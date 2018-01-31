package com.feicuiedu.atm.business;

/**
 * 登录界面选择
 * @author wangxiaoyi
 *
 */
public class LoginProp {
	    //登录界面
		public void select() {
			CommonUtils.printText("select_xuanze.txt");
			
		}
		//管理员用户注册菜单
		public void zhucexuanze() {
			CommonUtils.printText("zuce_xuanze.txt");
		}
		//普通用户功能选择
		public void putong() {
			CommonUtils.printText("putong_gongneng.txt");
		}


}
