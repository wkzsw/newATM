package com.feicuiedu.atm.business;

import java.util.Scanner;

import com.feicuiedu.atm.bean.Admin;
import com.feicuiedu.atm.bean.AdminMenu;
/**
 * 登录选择
 * @author wangxiaoyi
 *
 */
public class Login {
	//声明Admin类型变量
	private Admin admin;
	//声明AdminMenu类型变量
	private AdminMenu adminMenu;
	//声明Navigation类型变量
	private Navigation navg;
	//创建构造方法
	public Login() {
		// TODO Auto-generated constructor stub
	}
	//创建menu对象普通用户功能菜单选择类
	Menu menu = new Menu();
	//传Admin类型构造器
	public Login(Admin admin) {
		//调用
		this.admin = admin;
		//创建对象
		adminMenu = new AdminMenu(admin);
		//创建对象
		navg = new Navigation();
	}
    //创建登录选择界面
	public  void signs() {
		//创建普通用户对象
		LoginUser loginUser = new LoginUser();
		
		Scanner scanner =new Scanner(System.in);
		
		 LoginProp lp=new  LoginProp();
		 lp.select();
		String str = scanner.nextLine();
		//选择判断
		if (str.equals("1")) {
			//调用AdminMenu类的signAdmin登录选择方法
			adminMenu.signAdmin(admin);
			//调用Navigation类的nation管理员菜单选择及功能选择
			navg.nation();
		}else if (str.equals("2")) {
			//创建普通用户对象调用普通用户登录方法
			loginUser.login();
			//普通用户功能菜单选择方法
			menu.naviga(null);
		}else {
			System.out.println("您输入不合法,请你重新输入");
			signs();
		}
	}

}
