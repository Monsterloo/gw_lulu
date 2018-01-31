package com.junlon.common.base.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by jo on 2017/7/6.
 */
public class AccountSubBizException extends BizException {

    private static final long serialVersionUID = 1L;

    private static final Log log = LogFactory.getLog(AccountBizException.class);

    public static final AccountSubBizException ACCOUNT_NOT_EXIT = new AccountSubBizException(2017070601, "账户不存在");
    public static final AccountSubBizException ACCOUNT_NOT_SAME = new AccountSubBizException(2017070602, "账户不统一");
    public static final AccountSubBizException UNSETTAMOUNT_NOT_ENOUGH = new AccountSubBizException(2017070603, "未结算金额不足");
    public static final AccountSubBizException SETTAMOUNT_NOT_ENOUGH = new AccountSubBizException(2017070604, "可结算金额不足");
    public static final AccountSubBizException BALANCE_NOT_ENOUGH = new AccountSubBizException(2017070605, "余额不足");
    public static final AccountSubBizException FROZEN_AMOUNT_NOT_ENOUGH = new AccountSubBizException(2017070606, "冻结金额不足");
    public static final AccountSubBizException FROZEN_RECORD_NOT_EXIST = new AccountSubBizException(2017070607, "冻结记录不存在");
    public static final AccountSubBizException UNEXPECT_ACCOUNT_TRADE_TYPE = new AccountSubBizException(2017070608, "未预期的账户交易类型");

    public AccountSubBizException() {
    }

    public AccountSubBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    public AccountSubBizException(int code, String msg) {
        super(code, msg);
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public AccountSubBizException newInstance(String msgFormat, Object... args) {
        return new AccountSubBizException(this.code, msgFormat, args);
    }

    public AccountSubBizException print() {
        log.error("==>BizException, code:" + this.code + ", msg:" + this.msg);
        return new AccountSubBizException(this.code, this.msg);
    }

    public AccountSubBizException print(String message) {
        log.error("==>BizException, code:" + this.code + ", msg:" + this.msg + ", otherMessage:" + message);
        return new AccountSubBizException(this.code, this.msg);
    }
}
