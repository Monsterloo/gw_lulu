package com.junlon.common.base.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @description: 垫资账户服务业务异常类,异常代码8位数字组成,前4位固定2017打头,后4位自定义
 * @author: huang.jin
 * @date: 2017年9月21日 下午12:09:40
 * @version: 1.0
 *
 */
public class AccountAdvanceBizException extends BizException {

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(AccountAdvanceBizException.class);

	public static final AccountAdvanceBizException ACCOUNT_ADVANCE_IS_NOT_EXIT = new AccountAdvanceBizException(20170001, "垫资账户不存在");
	
	public static final AccountAdvanceBizException ACCOUNT_ADVANCE_MAX_AMOUNT_LESS_ZERO = new AccountAdvanceBizException(20170002, "最高垫资额度不能小于0");
	
	public static final AccountAdvanceBizException ACCOUNT_ADVANCE_AMOUNT_NOT_ENOUGH = new AccountAdvanceBizException(20170003, "可用垫资金额不足");

	public static final AccountAdvanceBizException ACCOUNT_ADVANCE_DAILY_CLEAR_NOT_FINISH = new AccountAdvanceBizException(20170004, "未完成日清零");

	public static final AccountAdvanceBizException ACCOUNT_ADVANCE_DAILY_COLLECT_NOT_FINISH = new AccountAdvanceBizException(20170005, "未完成日汇总");

	public static final AccountAdvanceBizException ACCOUNT_ADVANCE_UPDATE_FAIL = new AccountAdvanceBizException(20170006, "垫资账户更新失败");

	public AccountAdvanceBizException() {
	}

	public AccountAdvanceBizException(int code, String msgFormat, Object... args) {
		super(code, msgFormat, args);
	}

	public AccountAdvanceBizException(int code, String msg) {
		super(code, msg);
	}

	/**
	 * 实例化异常
	 * 
	 * @param msgFormat
	 * @param args
	 * @return
	 */
	public AccountAdvanceBizException newInstance(String msgFormat, Object... args) {
		return new AccountAdvanceBizException(this.code, msgFormat, args);
	}

	public AccountAdvanceBizException print() {
		log.error("==>BizException, code:" + this.code + ", msg:" + this.msg);
		return new AccountAdvanceBizException(this.code, this.msg);
	}

	public AccountAdvanceBizException print(String message) {
		log.error("==>BizException, code:" + this.code + ", msg:" + this.msg + ", otherMessage:" + message);
		return new AccountAdvanceBizException(this.code, this.msg);
	}
}
