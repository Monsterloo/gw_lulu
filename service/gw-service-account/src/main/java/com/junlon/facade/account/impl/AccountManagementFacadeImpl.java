package com.junlon.facade.account.impl;

import com.junlon.common.base.exceptions.AccountBizException;
import com.junlon.core.account.biz.AccountManagementBiz;
import com.junlon.facade.account.entity.Account;
import com.junlon.facade.account.entity.AccountAdvance;
import com.junlon.facade.account.enums.AccountTypeEnum;
import com.junlon.facade.account.service.AccountManagementFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 账户管理
 * 
 * @author healy
 * 
 */
@Component("accountManagementFacade")
public class AccountManagementFacadeImpl implements AccountManagementFacade {

	@Autowired
	private AccountManagementBiz accountManagementBiz;
	/*@Autowired
	private SwitchBiz switchBiz;*/

	/**
	 * 重新绑定商户编号
	 */
	public void reBindUserNo(String accountNo, String userNo) {
		accountManagementBiz.reBindUserNo(accountNo, userNo);
	}

	/**
	 * 生成账户编号
	 * 
	 * @entity accountType 账户类型.
	 * @return accountNo 账户编号.
	 * @throws AccountBizException
	 */
	public String buildAccountNo(AccountTypeEnum accountType) {
		return accountManagementBiz.buildAccountNo(accountType);
	}

	/**
	 * 创建账户
	 * 
	 * @param userNo
	 * @param accountType
	 * @return
	 * @throws AccountBizException
	 */
	public long createAccount(String userNo, String accountNo, int accountType) {
		return accountManagementBiz.createAccount(userNo, accountNo, accountType);
	}

	/**
	 * 创建内部账户
	 * 
	 * @param userNo
	 * @param accountNo
	 * @return
	 */
	public long createPrivateAccount(String userNo, String accountNo) {

		return accountManagementBiz.createPrivateAccount(userNo, accountNo);
	}

	@Override
	public long createPrivateAccount(String userNo, String accountNo, Double balance, Double securityMoney) throws AccountBizException {
		return accountManagementBiz.createPrivateAccount(userNo, accountNo, balance, securityMoney);
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
	/*@Override
	public void changeAccountStatus(String userNo, AccountOperationTypeEnum operationType, AccountInitiatorEnum initiator, String desc) throws AccountBizException, RpcException {
		accountManagementBiz.changeAccountStatus(userNo, operationType, initiator, desc);
	}*/

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
	/*public void changeAccountStatus(String userNo, AccountOperationTypeEnum operationType, AccountInitiatorEnum initiator, String desc) {
		accountManagementBiz.changeAccountStatus(userNo, operationType, initiator, desc);
	}*/

	/**
	 * 更新不可结算金额最大垫资比例
	 * 
	 * @param userNo
	 * @param maxPayForSubScale
	 * @throws AccountBizException
	 */
	public void updateMaxPayForSubScale(String userNo, Double maxPayForSubScale) {
		accountManagementBiz.updateMaxPayForSubScale(userNo, maxPayForSubScale);
	}
	/**
	 * 更新账户历史
	 */
	@Override
	public void updateAccount(Account account) {
		accountManagementBiz.updateAccount(account);
	}

	/**
	 * 修改新旧账务处理逻辑
	 * @param paramMap
	 */
	@Override
	public int updateAccountNewLogic(Map<String, Object> paramMap){
		return accountManagementBiz.updateAccountNewLogic(paramMap);
	}

	@Override
	public void updateMaxAdvanceAmountHis(AccountAdvance modifyAccountAdvance) {
		accountManagementBiz.updateMaxAdvanceAmountHis(modifyAccountAdvance);
	}

	/**----------------TODO 新账务和清结算版本切换时使用，待上线完毕之后需要下线-------------------**/
	/*@Override
	public void reCalcAvailableSettAmount(String userNo){
		switchBiz.reCalcAvailableSettAmount(userNo);
	}
	@Override
	public void updateOldAccountHistoryToSettled(String userNo){
		switchBiz.updateOldAccountHistoryToSettled(userNo);
	}
	@Override
	public void revertOldAccountHistoryToUnSettled(String userNo){
		switchBiz.revertOldAccountHistoryToUnSettled(userNo);
	}*/
	/**----------------TODO 新账务和清结算版本切换时使用，待上线完毕之后需要下线-------------------**/
}
