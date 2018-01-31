package com.feicuiedu.atm.business;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

import com.feicuiedu.atm.bean.User;

/**
 * 遍历集合
 * @author wangxiaoyi
 *
 */
public class AccountJudge {
	//集合遍历方法
	public User judgeUser(String str) {
         //创建文件对象
		CreateFile creat = new CreateFile();
		//文件文件名称
		File file = creat.userFile();
		//创建键值类
		InputDate ipd = new InputDate();
		//创建键值对
		HashMap<String, Object> hashMap = ipd.updateQuery(file);
        //设置键值对集合获取键值对
		Set<String> set = hashMap.keySet();
		//判断
		for (String temp : set) {
			//确定此字符串实例的开头和结尾是否与指定的字符串匹配。
			if (temp.startsWith(str) || temp.endsWith(str)) {
				//创建user对象获取键值对遍历
				User user = (User) hashMap.get(temp);
				return user;
			}
		}
		return null;
	}

}
