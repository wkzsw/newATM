package com.feicuiedu.atm.business;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.feicuiedu.atm.bean.User;

/**
 * 账号注册类
 * 
 * @author wangxiaoyi
 *
 */
public class Method {
	Scanner scanner = new Scanner(System.in);

	// 账号注册方法
	public void openUser() {
		// 账号注册判断方法对象
		InputRule rul = new InputRule();
		boolean flag = true;
		while (flag) {
			System.out.println("开通用户页面：");
			System.out.println("请输入姓名：");
			String userName = scanner.nextLine();
			System.out.println("请输入身份证号：");
			System.out.println("身份证号格式：长度不大于18,不得重复  输入前显示提示信息,请务必确认正确,之后不可修改");
			String userCard = scanner.nextLine();
			//判断输入字符串是否符合条件
			if (!rul.identity(userCard)) {
				System.out.println("身份证号输入格式有误，请重新输入！");
				openUser();
				break;
			}
			System.out.println("请输入密码：");
			System.out.println("密码格式： 至少8位,数字和字母必须同时又,至少一个大写字母");
			String password = scanner.nextLine();
			//判断输入字符串是否符合条件
			if (!rul.password(password)) {
				System.out.println("身份证号输入格式有误，请重新输入！");
				openUser();
				break;
			}
			System.out.println("请输入性别：");
			System.out.println("1代表男");
			System.out.println("2代表女");
			String userSex = null;
			String index = null;
			String gender = scanner.nextLine();
			if (gender.equals("1")) {
				userSex = "男";
				index = "01";
			} else if (gender.equals("2")) {
				userSex = "女";
				index = "02";
			} else {
				System.out.println("输入有误，返回菜单首页!");
				openUser();
				break;
			}
			System.out.println("请输入学历：");
			System.out.println("1代表小学");
			System.out.println("2代表中学");
			System.out.println("3代表大学");
			System.out.println("4代表其他");
			String education = null;
			String number = scanner.nextLine();
			if (number.equals("1")) {
				education = "小学";
			} else if (number.equals("2")) {
				education = "中学";
			} else if (number.equals("3")) {
				education = "大学";
			} else if (number.equals("4")) {
				education = "其他";
			} else {
				System.out.println("输入有误，返回菜单首页!");
				openUser();
				break;
			}
			System.out.println("请输入家庭住址，长度不能大于50！");
			String userAddress = scanner.nextLine();
			if (userAddress.length() > 50) {
				System.out.println("长度大于50，请重新输入：");
				openUser();
				break;
			}
			double userBalance = 0.0;
            //生成当前时间
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String time = format.format(new Date());
			//初始化账号
			String account = "37" + index + time;
			StringBuffer flow = new StringBuffer(" ");
			
			User user = new User(userName, userCard, password, userSex, education, userBalance, userAddress, account,
					flow);
			//创建用户信息存储的文件对象
			CreateFile creat = new CreateFile();
			//创建文件夹
			File file = creat.userFile();
			//键值类
			InputDate input = new InputDate();
			// inpt.updateQuery(file);
			//账号和身份证登录
			String accountCard = account + userCard;
            //判断文件是否为空输入文件夹
			HashMap<String, Object> obj = input.updateQuery(file);
			//添加键值内容
			obj.put(accountCard, user);
            //文件输出流
			OutputData opt = new OutputData();
			//调用文件输出方法
			opt.updateInsert(obj, file);

			System.out.println("开户成功!");
			flag = false;
		}

	}

	// 查询已开户的所有用户信息
	public void queryUser() {
		//创建文件对象
		CreateFile creat = new CreateFile();
		File file = creat.userFile();
		InputDate ipt = new InputDate();
		//文件输入流方法
		ipt.updateQuery(file);
		
		System.out.println(ipt.updateQuery(file));

	}

	// 删除用户信息
	public void userDelete() {
		System.out.println("请输入要删除的账户：");
		String account = scanner.nextLine();
		System.out.println("请输入账户对应的身份证号：");
		String userCard = scanner.nextLine();
         
		String accountCard = account + userCard;

		CreateFile creat = new CreateFile();
		File file = creat.userFile();
		InputDate ipd = new InputDate();
		HashMap<String, Object> hashMap = ipd.updateQuery(file);
		//判断数据是否存在
		if (!hashMap.containsKey(accountCard)) {
			System.out.println("账号或身份证号有误，返回管理员菜单！");
			//创建管理员功能类调用选择方法
			Navigation navi = new Navigation();
			navi.nation();
		} else {
			//根据账号删除
			hashMap.remove(accountCard);
			System.out.println("删除成功！");
			//文件输出流
			OutputData opt = new OutputData();
			//更新输出方法
			opt.updateInsert(hashMap, file);
		}

	}
    //创建修改方法
	public void userUpdate() {

		System.out.println("请输入要修改的账号：");
		String account = scanner.nextLine();
		//创建
		AccountJudge judge = new AccountJudge();
		//遍历方法
		User user = judge.judgeUser(account);
		if (user == null) {
			System.out.println("没有该用户！请重新输入：");
			userUpdate();
		}
		// 密码,姓名,学历,联系地址
		System.out.println("请输入修改的密码：");
		String password = scanner.nextLine();
		user.setPassword(password);
		System.out.println("请输入修改的姓名：");
		String userName = scanner.nextLine();
		user.setUserName(userName);
		System.out.println("请输入修改的学历：");
		String education = scanner.nextLine();
		user.setEducation(education);
		System.out.println("请输入修改的联系地址：");
		String userAddress = scanner.nextLine();
		user.setUserAddress(userAddress);
          
		String userCard = user.getUserCard();
		String accountCard = account + userCard;
          //文件存储
		CreateFile creat = new CreateFile();
		File file = creat.userFile();
		InputDate ipd = new InputDate();
		HashMap<String, Object> hashMap = ipd.updateQuery(file);
		hashMap.put(accountCard, user);
		
		OutputData opt = new OutputData();
		opt.updateInsert(hashMap, file);
		
		System.out.println("修改成功!");

	}

}
