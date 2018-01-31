package com.junlon.core.account.dao.impl;

import com.junlon.common.base.dao.BaseDaoImpl;
import com.junlon.common.base.utils.rsa.MD5;
import com.junlon.core.account.dao.AccountDetailDao;
import com.junlon.core.account.dao.CommonUniqueDao;
import com.junlon.facade.account.entity.AccountDetail;
import com.junlon.facade.account.entity.CommonUnique;
import com.junlon.facade.account.vo.AccountMigrationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:  账户明细Dao实现类
 */
@Repository("accountDetailDao")
public class AccountDetailDaoImpl extends BaseDaoImpl<AccountDetail> implements AccountDetailDao {

	@Autowired
	private CommonUniqueDao commonUniqueDao;

	@Override
	public List<String> calNeedMigrationDates(String calNeedMigrationDates) {
		return super.getSessionTemplate().selectList(super.getStatement("calNeedMigrationDates"), calNeedMigrationDates);
	}

	public AccountMigrationVo getDetailMigrationVoByDate(String migrationDate){
		return super.getSessionTemplate().selectOne(super.getStatement("getDetailMigrationVoByDate"), migrationDate);
	}

	@Override
	public List<Long> queryNeedMigrationIdsList(AccountMigrationVo migrationVo) {
		return super.getSessionTemplate().selectList(super.getStatement("queryNeedMigrationIdsList"), migrationVo);
	}

	@Override
	public int deleteDetailByIdsList(List<Long> idsList) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idsList", idsList);
		return super.getSessionTemplate().delete(super.getStatement("deleteDetailByIdsList"), param);
	}

	@Override
	public long insert(AccountDetail accountDetail) {
		StringBuilder sb = new StringBuilder();
		sb.append("ad_")
				.append(accountDetail.getAccountNo())
				.append(accountDetail.getAccountType())
				.append(accountDetail.getAccountTrxType())
				.append(accountDetail.getRequestNo())
				.append(accountDetail.getFundDirection())
				.append(accountDetail.getAlterType())
				.append(accountDetail.getRemark());
		
		CommonUnique unique = new CommonUnique();
		unique.setUniqueKey(MD5.getMD5Str(sb.toString()));
		unique.setCreateTime(new Date());
		try {
			commonUniqueDao.insert(unique);
		} catch (Exception ex) {
			StackTraceElement stackTraceElement = new StackTraceElement("DuplicateKeyException","insert", "commonUniqueDao", 0);
			StackTraceElement[] stackTraceElements = new StackTraceElement[]{ stackTraceElement };
			ex.setStackTrace(stackTraceElements);
			throw ex;
		}

		return super.insert(accountDetail);
	}
}
