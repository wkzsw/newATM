package com.feicuiedu.atm.bean;
/**
 * 创建管理员登录方法
 * @author wangxiaoyi
 *
 */
public class Admin {
	private String account = "370120180104";
	private String password = "123456";
	private String adminUser = "翡翠侠";
	public Admin() {

	}
    //设置用户名
	public Admin(String adminUser) {
		this.adminUser = adminUser;

	}
	//创造构造方法管理员账号登录使用
	public Admin(String account, String password, String adminUser) {
		super();
		this.account = account;
		this.password = password;
		this.adminUser = adminUser;

	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

}
