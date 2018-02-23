package com.feicuiedu.atm.business;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import com.feicuiedu.atm.bean.User;
/**
 * 普通用户功能菜单方法
 * @author wangxiaoyi
 *
 */
public class UserMenuMethod {
	Scanner scanner = new Scanner(System.in);
	Menu menu = new Menu();
     //查询
	public void queryBusiness(User user) {
         //创建文件路径
		CreateFile creat = new CreateFile();
		File file = creat.userFile();
		//创建键值对
		InputDate ipd = new InputDate();
		HashMap<String, Object> hashMap = ipd.updateQuery(file);
		//获取账号
		String account = user.getAccount();
		//获取身份证
		String userCard = user.getUserCard();
		String accountCard = account + userCard;
		//获取键值对
		User user1 = (User) hashMap.get(accountCard);
		System.out.println("查询业务");
		//打印获取姓名
		System.out.println("账户姓名：" + user1.getUserName());
	    //打印获取余额
		System.out.println("余额：" + user1.getUserBalance());
		System.out.println("1、返回上一级");
		String str = scanner.nextLine();
		//判断
		if (str.equals("1")) {
			menu.naviga(user);
		} else {
			System.out.println("输入错误。返回菜单!");
			menu.naviga(user);
		}
	}

	// 存款
	public void updateAdd(User user) {
		//创建
		UpdateDate ude = new UpdateDate();
		System.out.println("存款业务");
		System.out.println("请输入存款金额：");
		//来取得此对象的原始值
		double index = Double.valueOf(scanner.nextLine());
		System.out.println("1、确认  2.重新输入  3.返回菜单");
		
		String number = scanner.nextLine();
		//判断
		if (number.equals("1")) {
			//获取姓名打印
			System.out.println("账户姓名：" + user.getUserName());
			//存入金额
			double balances = index + user.getUserBalance();
			//获取存入后金额
			System.out.println("余额：" + balances);
			System.out.println("存款成功！");
			//存入后的金额存入内存
			user.setUserBalance(balances);
			//将新user存入文件
			ude.date(user);
			//创建时间格式
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
			//义字符串的形式显示
			String time = format.format(Calendar.getInstance().getTime());
			//列表
			StringBuffer flow = new StringBuffer("时间:" + time + "交易记录:" + "您存入了：" + index + "元钱。");
			//获取原有记录添加新信息重新设置Flow
			user.setFlow(user.getFlow().append(flow).append("\n"));
			//user.setFlow(flow);
			//存入内存
			ude.date(user);
			// ude.date(user);
			//操作完成调用列表
			menu.naviga(user);
           
		} else if (number.equals("2")) {
			
			System.out.println("请输入存款金额：");
			double index1 = Double.valueOf(scanner.nextLine());
			double balance1 = index1 + user.getUserBalance();
			
			System.out.println("账户姓名：" + user.getUserName());
			System.out.println("余额：" + balance1);
			System.out.println("存款成功！返回菜单！");
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
			String time = format.format(Calendar.getInstance().getTime());
			
			StringBuffer flow = new StringBuffer("时间:" + time + "交易记录:" + "您存入了：" + index1 + "元钱。");
			user.setFlow(user.getFlow().append(flow).append("\n"));
			ude.date(user);
			user.setUserBalance(balance1);
			ude.date(user);
			menu.naviga(user);
		} else if (number.equals("3")) {
			menu.naviga(user);
		} else {
			System.out.println("输入不合法，返回菜单业务！");
			menu.naviga(user);
		}
	}

	// 取款
	public void updateDraw(User user) {
		//创建对象
		UpdateDate ude = new UpdateDate();
		System.out.println("取款业务");
		System.out.println("请输入取款金额：");
		double index = Double.valueOf(scanner.nextLine());
		System.out.println("1、确认  2.重新输入  3.返回菜单");
		
		String number = scanner.nextLine();
		//请输入取款金额
		if (number.equals("1")) {
			
			if (index < user.getUserBalance()) {
				 System.out.println("请输入取款金额");
				System.out.println("账户姓名：" + user.getUserName());
				double balance1 = user.getUserBalance() - index;
				System.out.println("余额：" + balance1);
				System.out.println("取款成功");
				// 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
				String time = format.format(Calendar.getInstance().getTime());
				StringBuffer flow = new StringBuffer("时间:" + time + "交易记录:" + "您取出了：" + index + "元钱。");
				//
				user.setFlow(user.getFlow().append(flow).append("\n"));
				ude.date(user);
				user.setUserBalance(balance1);
				ude.date(user);
				menu.naviga(user);
			} else if (index > user.getUserBalance()) {
				System.out.println("输入金额大于卡中金额，无法取出！返回菜单！");
				menu.naviga(user);
				
			} else {
				System.out.println("输入金额大于卡中金额，无法取出！返回菜单！");
				menu.naviga(user);
				
			}
		} else if (number.equals("2")) {
			System.out.println("请重新输入取款金额：");
			//初始化余额变量
			double index1 = Double.valueOf(scanner.nextLine());
			//
			if (index1 < user.getUserBalance()) {
				// System.out.println("请输入取款金额");
				System.out.println("账户姓名：" + user.getUserName());
				double balance2 = user.getUserBalance() - index;
				System.out.println("余额：" + balance2);
				System.out.println("取款成功");
				// user.appendFlow("您取出了：" + index1 +"元钱");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
				String time = format.format(Calendar.getInstance().getTime());
				StringBuffer flow = new StringBuffer("时间:" + time + "交易记录:" + "您取出了：" + index1 + "元钱。");
				user.setFlow(user.getFlow().append(flow).append("\n"));
				ude.date(user);
				user.setUserBalance(balance2);
				ude.date(user);
				menu.naviga(user);
			} else if (index > user.getUserBalance()) {
				System.out.println("输入金额大于卡中金额，无法取出！返回菜单！");
				menu.naviga(user);
			} else {
				System.out.println("输入金额大于卡中金额，无法取出！返回菜单！");
				menu.naviga(user);
			}
		} else if (number.equals("3")) {
			menu.naviga(user);
		} else {
			System.out.println("输入不合法，返回菜单业务！");
			menu.naviga(user);
		}
	}

	// 转账
	public void updateTransfer(User user) {
		UpdateDate ude = new UpdateDate();
		System.out.println("转账业务：");
		System.out.println("请输入对方银行卡号：");
		String transfer = scanner.nextLine();
		System.out.println("请输入转账金额：");
		double money = Double.valueOf(scanner.nextLine());
		System.out.println("1、确认  2.重新输入  3.返回菜单");
		
		String number1 = scanner.nextLine();
		if (number1.equals("1")) {
			AccountJudge judge = new AccountJudge();
			User user1 = judge.judgeUser(transfer);
			if (user1 == null) {
				System.out.println("账号不存在，请重新输入:");
				updateTransfer(user);
			}
			if (user1 != null) {
				System.out.println("对方卡号：" + user1.getUserCard());
				System.out.println("对方姓名：" + user1.getUserName());
				System.out.println("转账金额：" + money);
				System.out.println("1、确认转账");
				System.out.println("2、返回上一级");

				String number2 = scanner.nextLine();
				if (number2.equals("1")) {
					if (user.getUserBalance() >= money) {
						double lmoney = (user1.getUserBalance()) + money;
						user1.setUserBalance(lmoney);
						ude.date(user1);
						double reallymoney = (user.getUserBalance()) - money;
						user.setUserBalance(reallymoney);
						ude.date(user);
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
						String time = format.format(Calendar.getInstance().getTime());
						StringBuffer flow = new StringBuffer(
								"时间:" + time + "交易记录:" + "您给：" + user1.getUserName() + "转了" + money + "元钱。");
						user.setFlow(user.getFlow().append(flow).append("\n"));
						ude.date(user);
						SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
						String time1 = format1.format(Calendar.getInstance().getTime());
						StringBuffer flow1 = new StringBuffer(
								"时间:" + time1 + "交易记录:" + user.getUserName() + "给您转了" + money + "元钱。");
						user1.setFlow(user.getFlow().append(flow1).append("\n"));
						ude.date(user1);
						// user.appendFlow("给：" + user1.getUserName() + "转了" + money +"元钱");
						// user1.appendFlow(user.getUserName() + "给您转了" + money + "元钱");
						System.out.println("转账成功！返回菜单！");
						menu.naviga(user);
					} else if (user.getUserBalance() < money) {
						System.out.println("余额不足，请重新输入！");
						updateTransfer(user);
					} else {
						System.out.println("输入有误，请重新输入！");
						updateTransfer(user);
					}

				} else if (number2.equals("2")) {
					updateTransfer(user);
				} else {
					System.out.println("输入错误，返回菜单！");
					menu.naviga(user);
				}
			} else {
				System.out.println("卡号输入错误，返回菜单！");
				menu.naviga(user);
			}

		} else if (number1.equals("2")) {
			updateTransfer(user);
		} else if (number1.equals("3")) {
			menu.naviga(user);
		} else {
			System.out.println("输入不合法，返回菜单业务！");
			menu.naviga(user);
		}
	}
	
	// 交易流水
	public void runningTab(User user) {
		
		CreateFile creat = new CreateFile();
		File file = creat.userFile();
		InputDate ipd = new InputDate();
		HashMap<String, Object> hashMap = ipd.updateQuery(file);
		String account = user.getAccount();
		String userCard = user.getUserCard();
		String accountCard = account + userCard;
		user = (User) hashMap.get(accountCard);
		System.out.println(user);
	}
}
