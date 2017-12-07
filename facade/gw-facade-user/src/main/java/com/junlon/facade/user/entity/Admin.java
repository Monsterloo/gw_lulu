package com.junlon.facade.user.entity;

import java.io.Serializable;

/**
 * 管理员
 */
public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;

	//columns START
	/**
	 * aid
	 */
	private String aid;

	/**
	 * 账户名
	 */
	private String aaccount;

	/**
	 * 密码
	 */
	private String apwd;

	/**
	 * arole
	 */
	private String arole;

	/**
	 * 所属部门
	 */
	private String adept;

	/**
	 * 管理员名字
	 */
	private String aname;

	/**
	 * 联系方式
	 */
	private String acontact;

	/**
	 * state
	 */
	private String state;

	//columns END
	
	//WebModal
	//角色名称
	private String aRoleName;

	/**
	 * aid
	 */
	public void setAid(String aid) {
		this.aid = aid;
	}
	/**
	 * aid
	 */
	public String getAid() {
		return this.aid;
	}

	/**
	 * 账户名
	 */
	public void setAaccount(String aaccount) {
		this.aaccount = aaccount;
	}
	/**
	 * 账户名
	 */
	public String getAaccount() {
		return this.aaccount;
	}

	/**
	 * 密码
	 */
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	/**
	 * 密码
	 */
	public String getApwd() {
		return this.apwd;
	}

	/**
	 * arole
	 */
	public void setArole(String arole) {
		this.arole = arole;
	}
	/**
	 * arole
	 */
	public String getArole() {
		return this.arole;
	}

	/**
	 * 所属部门
	 */
	public void setAdept(String adept) {
		this.adept = adept;
	}
	/**
	 * 所属部门
	 */
	public String getAdept() {
		return this.adept;
	}

	/**
	 * 管理员名字
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}
	/**
	 * 管理员名字
	 */
	public String getAname() {
		return this.aname;
	}

	/**
	 * 联系方式
	 */
	public void setAcontact(String acontact) {
		this.acontact = acontact;
	}
	/**
	 * 联系方式
	 */
	public String getAcontact() {
		return this.acontact;
	}

	/**
	 * state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * state
	 */
	public String getState() {
		return this.state;
	}
	
	/*public String getaRoleName() {
		if(BlankUtil.isNotBlank(this.arole)){
			RoleEnum roleEnum = RoleEnum.getEnum(Integer.parseInt(this.arole));
			return roleEnum.getDesc();
		}else{
			return "";
		}
	}*/

	public void setaRoleName(String aRoleName) {
		this.aRoleName = aRoleName;
	}
	
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aaccount=" + aaccount + ", apwd=" + apwd + ", arole=" + arole + ", adept="
				+ adept + ", aname=" + aname + ", acontact=" + acontact + ", state=" + state + ", aRoleName="
				+ aRoleName + "]";
	}
	
}
