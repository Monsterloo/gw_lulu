package com.junlon.core.account.dao.impl;

import com.junlon.common.base.dao.BaseDaoImpl;
import com.junlon.common.base.utils.rsa.MD5;
import com.junlon.core.account.dao.AccountAdvanceDetailDao;
import com.junlon.core.account.dao.CommonUniqueDao;
import com.junlon.facade.account.entity.AccountAdvanceDetail;
import com.junlon.facade.account.entity.CommonUnique;
import com.junlon.facade.account.vo.AccountMigrationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @description:  垫资账户明细Dao实现类
 *
 */
@Repository("accountAdvanceDetailDao")
public class AccountAdvanceDetailDaoImpl extends BaseDaoImpl<AccountAdvanceDetail> implements AccountAdvanceDetailDao {
 
	@Autowired
	private CommonUniqueDao commonUniqueDao;

	@Override
	public List<String> calNeedMigrationDates(String migrateDate) {
		return super.getSessionTemplate().selectList(super.getStatement("calNeedMigrationDates"), migrateDate);
	}

	@Override
	public AccountMigrationVo getDetailMigrationVoByDate(String migrationDate) {
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

	@Transactional(rollbackFor = Exception.class)
	@Override
	public long insert(AccountAdvanceDetail accountAdvanceDetail) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("aad_").append(accountAdvanceDetail.getAccountNo()).append(accountAdvanceDetail.getFundDirection())
			.append(accountAdvanceDetail.getAlterType()).append(accountAdvanceDetail.getRequestNo()).append(accountAdvanceDetail.getRemark())
			.append(accountAdvanceDetail.getAccountType()).append(accountAdvanceDetail.getAccountTrxType())
			.append(accountAdvanceDetail.getAlterAmount()).append(accountAdvanceDetail.getClearStage())
			.append(accountAdvanceDetail.getClearNo());
		
		CommonUnique unique = new CommonUnique();
		unique.setUniqueKey(MD5.getMD5Str(sb.toString()));
		unique.setCreateTime(new Date());
		commonUniqueDao.insert(unique);
		
		return super.insert(accountAdvanceDetail);
	}

}
