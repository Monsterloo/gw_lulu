package com.junlon.facade.account.entity;

import com.junlon.common.base.entity.BaseEntity;

public class CommonUnique extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String uniqueKey;

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

}
