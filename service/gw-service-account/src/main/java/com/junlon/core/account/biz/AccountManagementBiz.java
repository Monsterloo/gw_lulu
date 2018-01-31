package com.junlon.core.account.biz;

import com.junlon.common.base.exceptions.AccountAdvanceBizException;
import com.junlon.common.base.exceptions.AccountBizException;
import com.junlon.common.base.utils.date.DateUtils;
import com.junlon.common.base.utils.string.StringUtil;
import com.junlon.core.account.dao.AccountAdvanceDao;
import com.junlon.core.account.dao.AccountAdvanceDetailDao;
import com.junlon.core.account.dao.AccountDao;
import com.junlon.facade.account.entity.Account;
import com.junlon.facade.account.entity.AccountAdvance;
import com.junlon.facade.account.enums.AccountStatusEnum;
import com.junlon.facade.account.enums.AccountTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * 账户管理biz
 * 
 * @author healy
 * 
 */
@Component("accountManagementBiz")
@Transactional(rollbackFor = Exception.class)
public class AccountManagementBiz {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private AccountAdvanceDao accountAdvanceDao;
	@Autowired
	private AccountAdvanceDetailDao accountAdvanceDetailDao;

	private final static double DEFAULT_ADVANCE_SCALE = 1.0;
	private final static double DEFAULT_MAX_ADVANCE_AMOUNT = 999999999.99;

	private static final Logger log = LoggerFactory.getLogger(AccountManagementBiz.class);

	/**
	 * 重新绑定商户编号
	 * 
	 * @param accountNo
	 * @param userNo
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public void reBindUserNo(String accountNo, String userNo) {

		Account account = accountDao.getByAccountNo(accountNo);
		if (account == null) {
			throw AccountBizException.ACCOUNT_NOT_EXIT.print();
		}

		AccountAdvance accountAdvance = accountAdvanceDao.getByAccountNo(accountNo);
		if(accountAdvance != null){
			accountAdvance.setUserNo(userNo);
			accountAdvanceDao.update(accountAdvance);
		}

		//注意：主账户更新需要在垫资账户更新之后，因为垫资账户没有加同步锁
		account.setUserNo(userNo);
		account.setLastTime(new Date());
		accountDao.update(account);

		log.info("==>changeUserNo, accountNo:" + accountNo + ", userNo:" + userNo);
	}

	/**
	 * 生成账户编号20位
	 * 
	 * @param accountType
	 *            用户类型
	 * @return @
	 */
	public String buildAccountNo(AccountTypeEnum accountType) {

		String accountNo = accountDao.buildAccountNo(StringUtil.leftPadWithBytes(String.valueOf(accountType.getValue()), 3, '0', "UTF-8"));

		log.info("==>buildAccountNo:" + accountNo);

		return accountNo;
	}

	/**
	 * 创建账户
	 * 
	 * @param userNo
	 * @param accountNo
	 * @param accountType
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public long createAccount(String userNo, String accountNo, int accountType) {

		log.info("==>createAccount");

		// 隶属叶子科目编号
		String titleNo = "";
		if (accountType == AccountTypeEnum.CUSTOMER.getValue()) {
			titleNo = "2001";
		} else if (accountType == AccountTypeEnum.MERCHANT.getValue() || accountType == AccountTypeEnum.POS.getValue()
				|| accountType == AccountTypeEnum.POSAGENT.getValue() || accountType == AccountTypeEnum.POS_OUT_SETT.getValue()) {
			titleNo = "2002";
		} else if (accountType == AccountTypeEnum.PRIVATE.getValue()) {
			titleNo = "1002";
		}

		Account account = new Account();
		account.setUserNo(userNo);
		account.setAccountType(accountType);
		account.setAccountNo(accountNo);
		account.setStatus(AccountStatusEnum.ACTIVE.getValue());
		account.setAccountTitleNo(titleNo);
		account.setCurrentCanOutAmount(0.00);//可出款金额默认设置为0.00
		account.setMaxPayForSubScale(DEFAULT_ADVANCE_SCALE);
		
		if(AccountTypeEnum.CUSTOMER.getValue() == accountType) {
			account.setIsNewAccountLogic(Integer.valueOf(101));  // 标识为旧账务处理
		} else {
			account.setIsNewAccountLogic(Integer.valueOf(100));  // 标识为新账务处理
		}

		AccountAdvance accountAdvance = new AccountAdvance();
		accountAdvance.setUserNo(userNo);
		accountAdvance.setAccountNo(accountNo);
		accountAdvance.setAccountType(account.getAccountType());
		accountAdvance.setLastClearDate(DateUtils.addDay(new Date(), -1));
		accountAdvance.setLastDailyCollectDate(DateUtils.addDay(new Date(), -1));
		accountAdvance.setAdvanceScale(BigDecimal.valueOf(DEFAULT_ADVANCE_SCALE));
		accountAdvance.setMaxAdvanceAmount(BigDecimal.valueOf(DEFAULT_MAX_ADVANCE_AMOUNT));
		accountAdvanceDao.insert(accountAdvance);

		return accountDao.insert(account);

	}

	/**
	 * 创建内部账户
	 * 
	 * @param userNo
	 * @param accountNo
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public long createPrivateAccount(String userNo, String accountNo) {
		log.info("==>createPrivateAccount");
		// 隶属叶子科目编号
		String titleNo = "1002";

		Account account = new Account();
		account.setUserNo(userNo);
		account.setAccountNo(accountNo);
		account.setAccountType(AccountTypeEnum.PRIVATE.getValue());
		account.setStatus(AccountStatusEnum.ACTIVE.getValue());
		account.setAccountTitleNo(titleNo);
		account.setCurrentCanOutAmount(0.00);//可出款金额默认设置为0.00
		account.setMaxPayForSubScale(DEFAULT_ADVANCE_SCALE);

		AccountAdvance accountAdvance = new AccountAdvance();
		accountAdvance.setUserNo(userNo);
		accountAdvance.setAccountNo(accountNo);
		accountAdvance.setAccountType(account.getAccountType());
		accountAdvance.setAdvanceScale(BigDecimal.valueOf(DEFAULT_ADVANCE_SCALE));
		accountAdvance.setMaxAdvanceAmount(BigDecimal.valueOf(DEFAULT_MAX_ADVANCE_AMOUNT));
		accountAdvanceDao.insert(accountAdvance);

		return accountDao.insert(account);
	}

	/**
	 * 创建内部银行虚拟账户
	 * 
	 * @param userNo
	 * @param accountNo
	 * @param balance
	 * @param securityMoney
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public long createPrivateAccount(String userNo, String accountNo, Double balance, Double securityMoney) {
		log.info("==>createPrivateAccount");

		// 隶属叶子科目编号
		String titleNo = "1002";

		Account account = new Account();
		account.setUserNo(userNo);
		account.setAccountNo(accountNo);
		account.setAccountType(AccountTypeEnum.PRIVATE.getValue());
		account.setStatus(AccountStatusEnum.ACTIVE.getValue());
		account.setAccountTitleNo(titleNo);
		account.setBalance(balance);
		account.setSecurityMoney(securityMoney);
		account.setCurrentCanOutAmount(0.00);//可出款金额默认设置为0.00
		account.setMaxPayForSubScale(DEFAULT_ADVANCE_SCALE);

		AccountAdvance accountAdvance = new AccountAdvance();
		accountAdvance.setUserNo(userNo);
		accountAdvance.setAccountNo(accountNo);
		accountAdvance.setAccountType(account.getAccountType());
		accountAdvance.setAdvanceScale(BigDecimal.valueOf(DEFAULT_ADVANCE_SCALE));
		accountAdvance.setMaxAdvanceAmount(BigDecimal.valueOf(DEFAULT_MAX_ADVANCE_AMOUNT));
		accountAdvanceDao.insert(accountAdvance);

		return accountDao.insert(account);
	}

	/**
	 * 账户状态变更操作.
	 * 
	 * @param userNo
	 *            用户编号.
	 * @param operationType
	 *            账户操作类型.
	 * @param initiator
	 *            账户操作,发起方.
	 * @param desc
	 *            变更操作说明.
	 */
/*	@Transactional(rollbackFor = Exception.class)
	public void changeAccountStatus(String userNo, AccountOperationTypeEnum operationType, AccountInitiatorEnum initiator, String desc) {

		log.info("==>changeAccountStatus");
		log.info(String.format("==>userNo:%s, operationType:%s, initiator:%s, desc:%s", userNo, operationType.name(), initiator.name(),
				desc));

		Account account = accountDao.getByUserNo_IsPessimist(userNo, false);
		if (account == null) {
			throw AccountBizException.ACCOUNT_NOT_EXIT.print();
		}

		if (operationType.equals(AccountOperationTypeEnum.FREEZE_DEBIT)) {
			account.setStatus(AccountStatusEnum.INACTIVE_FREEZE_DEBIT.getValue());
		} else if (operationType.equals(AccountOperationTypeEnum.UNFREEZE_DEBIT)) {
			account.setStatus(AccountStatusEnum.ACTIVE.getValue());
		} else if (operationType.equals(AccountOperationTypeEnum.FREEZE_CREDIT)) {
			account.setStatus(AccountStatusEnum.INACTIVE_FREEZE_CREDIT.getValue());
		} else if (operationType.equals(AccountOperationTypeEnum.UNFREEZE_CREDIT)) {
			account.setStatus(AccountStatusEnum.ACTIVE.getValue());
		} else if (operationType.equals(AccountOperationTypeEnum.FREEZE_ACCOUNT)) {
			account.setStatus(AccountStatusEnum.INACTIVE.getValue());
		} else if (operationType.equals(AccountOperationTypeEnum.UNFREEZE_ACCOUNT)) {
			account.setStatus(AccountStatusEnum.ACTIVE.getValue());
		} else if (operationType.equals(AccountOperationTypeEnum.CREATE_ACCOUNT)) {
			account.setStatus(AccountStatusEnum.ACTIVE.getValue());
		} else if (operationType.equals(AccountOperationTypeEnum.FREEZE_FUND)) {
			account.setStatus(AccountStatusEnum.INACTIVE.getValue());
		} else if (operationType.equals(AccountOperationTypeEnum.UNFREEZE_FUND)) {
			account.setStatus(AccountStatusEnum.ACTIVE.getValue());
		} else if (operationType.equals(AccountOperationTypeEnum.CANCEL_ACCOUNT)) {
			account.setStatus(AccountStatusEnum.CANCELLED.getValue());
		}
		account.setLastTime(new Date());
		accountDao.update(account);

		AccountFrozenRecord accountFrozenRecord = new AccountFrozenRecord();
		accountFrozenRecord.setLastTime(new Date());
		accountFrozenRecord.setAccountNo(account.getAccountNo());
		accountFrozenRecord.setRemark(desc);
		accountFrozenRecord.setInitiator(initiator.getValue());
		accountFrozenRecord.setOperationType(operationType.getValue());

		accountFrozenRecordDao.insert(accountFrozenRecord);
	}*/

	/**
	 * 更新不可结算金额最大垫资比例
	 * 
	 * @param userNo
	 * @param maxPayForSubScale
	 * @throws AccountBizException
	 */
	@Transactional
	public void updateMaxPayForSubScale(String userNo, Double maxPayForSubScale) {
		log.info("==>updateMaxPayForSubScale userNo={} maxPayForSubScale={}", userNo, maxPayForSubScale);

		Account account = accountDao.getByUserNo_IsPessimist(userNo, true);
		if (account == null) {
			throw AccountBizException.ACCOUNT_NOT_EXIT.newInstance("账户不存在,用户编号{%s}", userNo).print();
		}

		AccountAdvance accountAdvance = accountAdvanceDao.getByUserNo_IsPessimist(userNo, true);
		if(accountAdvance != null){
			accountAdvance.setAdvanceScale(BigDecimal.valueOf(maxPayForSubScale));
			this.updateMaxAdvanceAmountHis(accountAdvance);
		}else{
			account.setMaxPayForSubScale(maxPayForSubScale);
			accountDao.update(account);
		}
		log.info("==>updateMaxPayForSubScale<==");
	}
	
	/**
	 * 新增账户历史
	 * @param accountHistory
	 * @return
	 */
	/*public long createAccountHistory(AccountHistory accountHistory){
		return accountHistoryDao.insert(accountHistory);
	}*/

	/**
	 * 更新账户
	 * @param account
	 */
	public void updateAccount(Account account) {

		accountDao.update(account);
		
	}

	/**
	 * 修改新旧账务处理逻辑
	 * @param paramMap
	 */
	@Transactional(rollbackFor = Exception.class)
	public int updateAccountNewLogic(Map<String, Object> paramMap){
		return accountDao.updateAccountNewLogic(paramMap);
	}
	
	/**
	 * 
	 * @description:                      更新最大垫资金额或垫资比例
	 * @param modifyAccountAdvance  	  最大垫资明细记录
	 * @author:                           huang.jin
	 * @date:                             2017年10月30日 上午10:14:14
	 *
	 */
	@Transactional(rollbackFor = Exception.class)
	public void updateMaxAdvanceAmountHis(AccountAdvance modifyAccountAdvance) {
		
		String userNo = modifyAccountAdvance.getUserNo();
		Account account = accountDao.getByUserNo_IsPessimist(userNo,true);
		AccountAdvance accountAdvance = accountAdvanceDao.getByUserNo_IsPessimist(userNo, true);
		if(null == accountAdvance) { 
			throw AccountAdvanceBizException.ACCOUNT_ADVANCE_IS_NOT_EXIT.newInstance("垫资账户不存在,用户编号{%s}", userNo).print();
		}
		
		accountAdvance.setMaxAdvanceAmount(modifyAccountAdvance.getMaxAdvanceAmount());
		accountAdvance.setAdvanceScale(modifyAccountAdvance.getAdvanceScale());

		/**----------------TODO 增加修改最高垫资额度表的记录，因为业务不需要，所以注释掉了-------------------**/
		/*AccountMaxAdvanceAmountHis accountMaxAdvanceAmountHis = new AccountMaxAdvanceAmountHis();
		accountMaxAdvanceAmountHis.setUserNo(userNo);
		accountMaxAdvanceAmountHis.setMaxAdvanceAmount(modifyAccountAdvance.getMaxAdvanceAmount());
		accountMaxAdvanceAmountHis.setAdvanceScale(modifyAccountAdvance.getAdvanceScale());
		accountMaxAdvanceAmountHis.setCreator(modifyAccountAdvance.getUpdator());
		accountMaxAdvanceAmountHis.setCreateTime(new Date());
		accountMaxAdvanceAmountHis.setUpdator(modifyAccountAdvance.getUpdator());
		accountMaxAdvanceAmountHis.setUpdateTime(new Date());
		accountMaxAdvanceAmountHisDao.insert(accountMaxAdvanceAmountHis);*/
		
		accountAdvance.calCurrentAdvanceAmount();
		accountAdvance.calAvaliableAdvanceAmount();

		account.setMaxPayForSubScale(Double.valueOf(modifyAccountAdvance.getAdvanceScale().toString()));

		accountAdvanceDao.update(accountAdvance);
		//注意：主账户更新需要在垫资账户更新之后，因为垫资账户没有加同步锁
		accountDao.update(account);
	}
}
