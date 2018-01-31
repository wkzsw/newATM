package com.feicuiedu.atm.business;

import java.util.Scanner;

import com.feicuiedu.atm.bean.Admin;
import com.feicuiedu.atm.bean.AdminMenu;

/**
 * 创建管理员菜单类
 * 
 * @author wangxiaoyi
 *
 */
public class Navigation {
	private Admin admin;
	Scanner scanner = new Scanner(System.in);

	Method method = new Method();
	AdminMenu amnu = new AdminMenu();
	Login login = new Login();

	// 管理员菜单选择及功能选择
	public void nation() {
		LoginProp lp = new LoginProp();
		lp.zhucexuanze();
		String str = scanner.nextLine();
		if (str.equals("1")) {
			// 账号注册
			method.openUser();
			nation();
		} else if (str.equals("2")) {
			// 销户
			method.userDelete();
			nation();
		} else if (str.equals("3")) {
			// 查询
			method.queryUser();
			nation();
		} else if (str.equals("4")) {
			// 修改
			method.userUpdate();
			nation();
		} else if (str.equals("5")) {
			// 登录
			login.signs();
		} else {
			System.out.println("输入不合法，返回菜单!");
			nation();
		}
	}

}
