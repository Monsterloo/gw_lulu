package com.junlon.facade.account.service;

import com.alibaba.dubbo.rpc.RpcException;
import com.junlon.common.base.exceptions.AccountBizException;
import com.junlon.facade.account.entity.Account;
import com.junlon.facade.account.entity.AccountAdvance;
import com.junlon.facade.account.enums.AccountInitiatorEnum;
import com.junlon.facade.account.enums.AccountOperationTypeEnum;
import com.junlon.facade.account.enums.AccountTypeEnum;

import java.util.Map;

/**
 * 账户管理
 * 
 * @author healy
 * 
 */
public interface AccountManagementFacade {

	/**
	 * 重新绑定商户编号
	 * 
	 * @param accountNo
	 * @param userNo
	 * @return
	 * @throws AccountBizException   
	 */
	public void reBindUserNo(String accountNo, String userNo) throws AccountBizException, RpcException;

	/**
	 * 生成账户编号
	 * 
	 * @param accountType
	 * @return
	 * @throws AccountBizException
	 */
	String buildAccountNo(AccountTypeEnum accountType) throws AccountBizException, RpcException;

	/**
	 * 创建账户
	 * 
	 * @param userNo
	 *            用户编号.
	 * @param accountNo
	 *            账户编号.
	 * @param accountType
	 *            账户类型.
	 * @return ID 账户ID.
	 * @throws AccountBizException
	 */
	long createAccount(String userNo, String accountNo, int accountType) throws AccountBizException, RpcException;

	/**
	 * 创建内部账户
	 * 
	 * @param userNo
	 *            用户编号.
	 * @param accountNo
	 *            账户编号.
	 * @throws AccountBizException
	 */
	long createPrivateAccount(String userNo, String accountNo) throws AccountBizException, RpcException;

	/**
	 * 创建内部银行虚拟账户
	 * 
	 * @param userNo
	 *            用户编号.
	 * @param accountNo
	 *            账户编号.
	 * @param balance
	 *            账户余额
	 * @param securityMoney
	 *            保证金
	 * @throws AccountBizException
	 */
	long createPrivateAccount(String userNo, String accountNo, Double balance, Double securityMoney) throws AccountBizException,
            RpcException;

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
/*	void changeAccountStatus(String userNo, AccountOperationTypeEnum operationType, AccountInitiatorEnum initiator, String desc)
			throws AccountBizException, RpcException;*/

	/**
	 * 更新不可结算金额最大垫资比例
	 * 
	 * @param userNo
	 * @param maxPayForSubScale
	 * @throws AccountBizException
	 */
	void updateMaxPayForSubScale(String userNo, Double maxPayForSubScale) throws AccountBizException;
	
	/**
	 * 更新账户
	 * @param account
	 */
	void updateAccount(Account account);

	/**
	 * @Author: LuJunLang
	 * @Description: 修改新旧账务处理逻辑
	 * @Date: 2017-11-27
	 * @param paramMap
	 */
	public int updateAccountNewLogic(Map<String, Object> paramMap);
	
	/**
	 * 
	 * @description:                      更新最大垫资金额或垫资比例
	 * @param modifyAccountAdvance  最大垫资明细记录
	 * @author:                           huang.jin
	 * @date:                             2017年10月30日 上午10:14:14
	 *
	 */
	public void updateMaxAdvanceAmountHis(AccountAdvance modifyAccountAdvance);

}
