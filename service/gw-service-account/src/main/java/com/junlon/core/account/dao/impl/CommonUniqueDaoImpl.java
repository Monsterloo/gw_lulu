package com.junlon.core.account.dao.impl;

import com.junlon.common.base.dao.BaseDaoImpl;
import com.junlon.core.account.dao.CommonUniqueDao;
import com.junlon.facade.account.entity.CommonUnique;
import org.springframework.stereotype.Repository;

@Repository("commonUniqueDao")
public class CommonUniqueDaoImpl extends BaseDaoImpl<CommonUnique> implements CommonUniqueDao {

}
