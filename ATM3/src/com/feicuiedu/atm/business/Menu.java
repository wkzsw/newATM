package com.feicuiedu.atm.business;

import java.util.Scanner;

import com.feicuiedu.atm.bean.Admin;
import com.feicuiedu.atm.bean.User;
/**
 * 普通用户功能菜单选择
 * @author wangxiaoyi
 *
 */
public class Menu {
	//声明Admin类型变量
	private Admin admin;
	Scanner scanner = new Scanner(System.in);
	//普通用户功能菜单选择方法
	public void naviga(User user){
		Login longin = new Login(admin);
	
		 LoginProp lop=new  LoginProp();
		 lop.putong();
		UserMenuMethod mmd = new UserMenuMethod();
		
		String number = scanner .nextLine();
		if (number.equals("1")) {
			mmd.queryBusiness(user);
		}else if (number.equals("2")) {
			mmd.updateTransfer(user);
		}
		else if (number.equals("3")) {
			mmd.updateDraw(user);
		}else if (number.equals("4")) {
			mmd.updateAdd(user);
		}else if (number.equals("5")) {
			mmd.runningTab(user);
		}else if (number.equals("6")) {
			longin.signs();
		}else{
			System.out.println("输入不合法。请重新输入！");
			naviga(user);
		}
	}

}
