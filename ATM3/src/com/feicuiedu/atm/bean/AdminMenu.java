package com.feicuiedu.atm.bean;

import java.util.Scanner;
/**管理员登录
 * @author wangxiaoyi
 *
 */
public class AdminMenu {
	//声明Admin类型变量
	private Admin admin;
	//创建构造方法传参
	public AdminMenu(Admin admin) {
		this.admin = admin;
	}
	
	public AdminMenu() {
		// TODO Auto-generated constructor stub
	}
	//创建登录选择方法串参为Admin类型
	public void signAdmin(Admin admin) {
		
		Scanner scanner = new Scanner(System.in);
		//判断
		while(true){
			System.out.println("欢迎来到管理员用户登录窗口");
			System.out.println("请输入账户：");
			String account = scanner.nextLine();
			//判断账号长度
			if (account.length() != 12) {
				System.out.println("账号长度不符合，请重新输入：");
				signAdmin(admin);
				break;
				//获取Admin类的获取账号长度
			}else if (!account.equals(admin.getAccount())) {
				System.out.println("账号有误，请重新输入：");
				signAdmin(admin);
				break;
			}
			
			System.out.println("请输入密码：");
			String password = scanner.nextLine();
			//判断输入密码是否等于获取Admin类的获取密码长度
			if (password.equals(admin.getPassword())) {
				System.out.println("登录成功！");
				break;
			}else{
				System.out.println("密码错误，请重新输入！");
				
				signAdmin(admin);
				break;
			}
		}
	}

}
