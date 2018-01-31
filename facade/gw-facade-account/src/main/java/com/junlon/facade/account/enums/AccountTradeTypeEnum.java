package com.junlon.facade.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交易码，账户服务专用
 * 
 * @author Administrator
 * 
 */
public enum AccountTradeTypeEnum {

	/**
	 * 
	 * type类型
	 * 	1:付款、收单(账务处理时要联合AccountFundDirectionEnum来区分是出款还是入账)
	 *  2:退款
	 *  3:转账
	 *  4:调账/资金调拨
	 *  5:退汇
	 *  6:风控冻结
	 *  7:结算
	 *  8:备付金调账
	 *  9:余额出款
	 *  99:其他
	 *
	 */
	
	/**
	 * 分账
	 */
	SPLIT("分账", 1001, 99),

	/**
	 * 会员转账（转账产品用到）
	 */
	ACCOUNT_TRANSFER("会员转账", 2001, 3),

	/**
	 * 转银行卡（代付产品用到）
	 */
	ACCOUNT_TO_BANK_TRANSFER("代付", 2002, 1),

	/**
	 * 跨境汇款
	 */
	CROSS_REMIT("跨境汇款", 2003),

	/**
	 * 充值
	 */
	ACCOUNT_DEPOSIT("充值", 3001, 1),

	/**
	 * B2C网银退款
	 */
	NET_B2C_REFUND("B2C网银退款", 4001, 2),

	/**
	 * B2B网银退款
	 */
	NET_B2B_REFUND("B2B网银退款", 4002, 2),

	/**
	 * 充值失败退款
	 */
	DEPOSIT_FAILD_REFUND("充值失败退款", 4003, 2),

	/**
	 * 快捷支付退款
	 */
	FAST_REFUND("快捷支付退款", 4004, 2),

	/**
	 * 会员余额支付退款
	 */
	ACCOUNT_BALANCE_REFUND("会员余额支付退款", 4005, 2),

	/**
	 * POS退货
	 */
	POS_REFUND("POS退货", 4008, 99),

	/**
	 * 分账退款
	 */
	SPLIT_REFUND("分账退款", 4009, 2),

	/**
	 * 现金支付退款
	 */
	CASH_REFUND("现金支付退款", 4010, 2),

	/**
	 * 代理商分润退回(退汇)
	 */
	AGENT_SPLITTING_REFUND("代理商分润退回", 4011, 5),

	/**
	 * 转银行卡退回，目前在退汇时使用，金额将会直接退回到可结算金额
	 */
	ACCOUNT_TO_BANK_TRANSFER_REFUND("代付退汇", 4012, 5),

	/**
	 * 微信支付退款
	 */
	WEIXIN_REFUND("微信支付退款", 4013, 2),

	/**
	 * 支付宝支付退款
	 */
	ALIPAY_REFUND("支付宝支付退款", 4014, 2),
	/**
	 * 京东支付退款
	 */
	JDPAY_REFUND("京东支付退款", 4015, 2),
	/**
	 * 无卡B2C支付退款
	 */
	NOCARD_B2C_REFUND("无卡B2C支付退款", 4016, 2),
	/**
	 * 无卡B2B支付退款
	 */
	NOCARD_B2B_REFUND("无卡B2B支付退款", 4017, 2),
	/**
	 * 银联支付退款
	 */
	UNIONPAY_REFUND("银联支付退款", 4018, 2),
	/**
	 * QQ支付退款
	 */
	QQPAY_REFUND("QQ支付退款", 4019, 2),
	/**
	 * 百度钱包支付退款
	 */
	BAIDU_REFUND("百度钱包支付退款", 4020, 2),
	/**
	 * 苏宁支付退款
	 */
	SUNING_REFUND("苏宁支付退款", 4021, 2),
	
	/**
	 * 银联无跳转支付退款
	 */
	DIRECTPAY_REFUND("快付支付退款", 4022, 2),

	/**
	 * 结算
	 */
	SETTLEMENT("结算", 5001, 7),
	
	/**
	 * 提现
	 */
	ATM("提现", 5002),

	/**
	 * 结算到账
	 */
	SETTLEMENT_INTO("结算到账", 5003),

	/**
	 * 提现到账
	 */
	ATM_INTO("提现到账", 5004),

	/**
	 * T0结算
	 */
	SETTLEMENT_T0("T0结算", 5005),

	/**
	 * 清算入账
	 */
	CLEAR_INTO("清算入账", 5006),

	/**
	 * 清算且不入账
	 */
	CLEAR_BUT_NOT_IN("清算且不入账", 5007),
	
	/**
	 * 日终汇总
	 */
	SUMMERY_DAILY("日终汇总", 5008),
	
	/**
	 * 自动结算
	 */
	SETTLEMENT_AUTO("自动结算", 5009, 7),
	
	/**
	 * 普通结算
	 */
	SETTLEMENT_T1("普通结算", 5010, 7),

	/**
	 * B2C银行卡支付
	 */
	NET_B2C_PAY("B2C银行卡支付", 6001, 1),

	/**
	 * B2B银行卡支付
	 */
	NET_B2B_PAY("B2B银行卡支付", 6002, 1),

	/**
	 * 非银行卡支付出款）
	 */
	NON_BANK_PAY("非银行卡支付", 6003, 1),

	/**
	 * 快捷支付
	 */
	FAST_PAY("快捷支付", 6004, 1),

	/**
	 * 余额支付
	 */
	ACCOUNT_BALANCE_PAY("余额支付", 6005, 1),

	/**
	 * POS消费
	 */
	POS_PAY("POS消费", 6006, 1),

	/**
	 * 现金支付
	 */
	CASH_PAY("现金支付", 6007, 1),

	/**
	 * 代理商分润
	 */
	AGENT_SPLITTING("代理商分润", 6008, 4),

	/**
	 * 微信支付
	 */
	WEIXIN_PAY("微信支付", 6009, 1),

	/**
	 * 支付宝支付
	 */
	ALIPAY_PAY("支付宝支付", 6010, 1),
	/**
	 * 京东支付
	 */
	JD_PAY("京东支付", 6011, 1),
	
	/**
	 * 无卡B2C支付
	 */
	NOCARD_B2C_PAY("无卡B2C支付", 6012, 1),
	
	/**
	 * 银联支付
	 */
	UNIONPAY_PAY("银联支付", 6013, 1),
	
	/**
	 * QQ支付
	 */
	QQPAY_PAY("QQ支付", 6014, 1),
	
	/**
	 * 钱包支付
	 */
	ACCOUNT_PURSE_PAY("钱包支付",6015, 1),
	
	/**
	 * 百度钱包支付
	 */
	BAIDU_PAY("百度钱包支付", 6016, 1),
	
	/**
	 * 苏宁支付
	 */
	SUNING_PAY("苏宁支付", 6017, 1),
	
	/**
	 * 银联无跳转支付
	 */
	DIRECT_PAY("快付支付", 6018, 1),
	
	/**
	 * 打款
	 */
	REMIT("打款", 7001, 1),

	/**
	 * 会计日终
	 */
	ACCOUNTING_DAILY_CUT("会计日终", 8001),

	/**
	 * 账户调账
	 */
	ACCOUNT_ADJUST("账户调账", 9001, 4),

	/**
	 * 商户认账
	 */
	MERCHANT_RECON("商户认账", 1101, 4),

	/**
	 * 银行长款平台认账
	 */
	BANK_MORE_PLAT_RECON("银行长款平台认账", 1102, 4),

	/**
	 * 银行短款平台认账
	 */
	BANK_LESS_PLAT_RECON("银行短款平台认账", 1103, 4),

	/**
	 * 银行长款金额不符银行认账
	 */
	BANK_MORE_NOT_MATCH_BANK_RECON("银行长款金额不符银行认账", 1104, 4),

	/**
	 * 现金支付入账
	 */
	CASH_PAY_RECON("现金支付入账", 1105, 4),

	/**
	 * 代扣
	 */
	ACCOUNT_AGENCYDEBIT("代扣", 1106),

	/**
	 * 待清算款入账
	 */
	WAIT_CLEAR_RECON("待清算款入账", 1107, 4),

	/**
	 * 商户调账_调增
	 */
	//MERCHANT_RECON_INCREATE("商户调账_调增",1111),

	/**
	 * 商户调账_调减
	 */
	//MERCHANT_RECON_REDUCE("商户调账_调减",1112),

	/**
	 * 银行卡认证
	 */
	BANK_AUTH("银行卡认证", 1201),

	/**
	 * 资金调拨（针对备付金而言的）
	 */
	FUNDS_ALLOCATION("资金调拨", 1301, 4),
	
	/**
	 * 风控资金冻结
	 */
	RCMS_ACCOUNT_FROZEN("风控处理", 1401, 6),

    /**
     * 反诈骗资金冻结
     */
    SAFE_ACCOUNT_FROZEN("反诈骗", 1501, 6),

	/**
	 * 调整可出款金额
	 */
	ADJUST_CAN_OUT_AMOUNT("调整可出款金额", 1601),
	
	/**
	 * 分期
	 */
	FENQIPAY("分期", 1701, 1),

	/**
	 * 鉴权（将使用余额出款）
	 */
	AUTHENTICATION("鉴权", 1801, 9);


	/** 枚举值 */
	private int value;

	/** 描述 */
	private String desc;
	
	/** 类型值 */
	private int type;

	private static Map<Integer, String> onlinePaymentMap = null;//在线支付的业务类型
	private static Map<Integer, String> adjustMap = null;//调账的业务类型
	private static Map<Integer, String> depositMap = null;//充值的业务类型

	private AccountTradeTypeEnum(String desc, int value) {
		this.value = value;
		this.desc = desc;
	}
	
	private AccountTradeTypeEnum(String desc, int value, int type) {
		this.value = value;
		this.desc = desc;
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public static AccountTradeTypeEnum getEnum(int value) {
		AccountTradeTypeEnum resultEnum = null;
		AccountTradeTypeEnum[] enumAry = AccountTradeTypeEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].getValue() == value) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}

	public static Map<String, Map<String, Object>> toMap() {
		AccountTradeTypeEnum[] ary = AccountTradeTypeEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (int num = 0; num < ary.length; num++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = String.valueOf(getEnum(ary[num].getValue()));
			map.put("value", String.valueOf(ary[num].getValue()));
			map.put("desc", ary[num].getDesc());
			enumMap.put(key, map);
		}
		return enumMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List toList() {
		AccountTradeTypeEnum[] ary = AccountTradeTypeEnum.values();
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("value", ary[i].getValue() + "");
			map.put("desc", ary[i].getDesc());
			list.add(map);
		}
		return list;
	}

	/**
	 * 调账业务类型
	 * @return
	 */
	public static Map<Integer, String> getAdjustMap(){
		if(adjustMap == null){
			Map<Integer, String> map = new HashMap<>();
			map.put(MERCHANT_RECON.getValue(), MERCHANT_RECON.getDesc());//商户认账
			map.put(BANK_MORE_PLAT_RECON.getValue(), BANK_MORE_PLAT_RECON.getDesc());//银行长款平台认账
//			map.put(BANK_LESS_PLAT_RECON.getValue(), BANK_LESS_PLAT_RECON.getDesc());//银行短款平台认账
			map.put(BANK_MORE_NOT_MATCH_BANK_RECON.getValue(), BANK_MORE_NOT_MATCH_BANK_RECON.getDesc());//银行长款金额不符银行认账
			map.put(CASH_PAY_RECON.getValue(), CASH_PAY_RECON.getDesc());//现金支付入账
			map.put(WAIT_CLEAR_RECON.getValue(), WAIT_CLEAR_RECON.getDesc());//待清算款入账
			adjustMap = map;
		}
		return adjustMap;
	}

	/**
	 * 返回收单的业务类型
	 * @return
	 */
	public static Map<Integer, String> getOnlinePaymentMap(){
		if(onlinePaymentMap == null){
			Map<Integer, String> map = new HashMap<>();
			//以下是在线支付的交易类型
			map.put(NET_B2C_PAY.getValue(), NET_B2C_PAY.getDesc());//B2C银行卡支付
			map.put(NET_B2B_PAY.getValue(), NET_B2B_PAY.getDesc());//B2B银行卡支付
			map.put(FAST_PAY.getValue(), FAST_PAY.getDesc());//快捷支付
			map.put(NOCARD_B2C_PAY.getValue(), NOCARD_B2C_PAY.getDesc());//无卡B2C支付
			map.put(WEIXIN_PAY.getValue(), WEIXIN_PAY.getDesc());//微信支付
			map.put(ALIPAY_PAY.getValue(), ALIPAY_PAY.getDesc());//支付宝支付
			map.put(UNIONPAY_PAY.getValue(), UNIONPAY_PAY.getDesc());//银联支付
			map.put(QQPAY_PAY.getValue(), QQPAY_PAY.getDesc());//QQ支付
			map.put(JD_PAY.getValue(), JD_PAY.getDesc());//京东支付
			map.put(BAIDU_PAY.getValue(), BAIDU_PAY.getDesc());//百度钱包支付
			map.put(ACCOUNT_AGENCYDEBIT.getValue(), ACCOUNT_AGENCYDEBIT.getDesc());//代扣
			map.put(ACCOUNT_BALANCE_PAY.getValue(), ACCOUNT_BALANCE_PAY.getDesc());//余额支付
			map.put(ACCOUNT_PURSE_PAY.getValue(), ACCOUNT_PURSE_PAY.getDesc());//钱包支付
			map.put(FENQIPAY.getValue(), FENQIPAY.getDesc());//分期

//			map.put(NON_BANK_PAY.getValue(), NON_BANK_PAY.getDesc());//非银行卡支付
//			map.put(POS_PAY.getValue(), POS_PAY.getDesc());//POS消费
			onlinePaymentMap = map;
		}
		return onlinePaymentMap;
	}

	/**
	 * 返回充值的交易类型
	 * @return
	 */
	public static Map<Integer, String> getDepositMap(){
		if(depositMap == null) {
			Map<Integer, String> map = new HashMap<>();
			map.put(ACCOUNT_DEPOSIT.getValue(), ACCOUNT_DEPOSIT.getDesc());//充值
			map.put(ACCOUNT_TRANSFER.getValue(), ACCOUNT_TRANSFER.getDesc());//会员转账

			depositMap = map;
		}
		return depositMap;
	}
}
