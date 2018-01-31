package com.feicuiedu.atm.business;
/**
 * 账号注册判断
 * @author wangxiaoyi
 *
 */
public class InputRule {
  //省份证验证方法
	public boolean identity(String str) {
		
		return str.matches("[a-z0-9A-Z]{6,18}");
	}
	//密码判断方法
	public boolean password(String str) {
		
		return str.matches("[a-z0-9A-Z]{8,18}") && !str.matches("[a-zA-Z]+") && // 不能只包含字母
				!str.matches("[0-9]+") && // 不能只包含数字
				!str.matches("[a-z]+");// 至少有一个大写
	}

}
