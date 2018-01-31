package com.feicuiedu.atm.business;

import java.io.File;
import java.util.HashMap;

import com.feicuiedu.atm.bean.User;
/**
 * 更新键值对
 * @author wangxiaoyi
 *
 */
public class UpdateDate {
	public void date(User user) {
		//将信息以键值对方法存入文件夹
		CreateFile creat = new CreateFile();
		File file = creat.userFile();
		InputDate ipd = new InputDate();
		HashMap<String, Object> hashMap = ipd.updateQuery(file);
		//
		String account = user.getAccount();
		String userCard = user.getUserCard();
		String accountCard = account + userCard;
		hashMap.put(accountCard, user);
		
		OutputData opt = new OutputData();
		opt.updateInsert(hashMap, file);
	}

}
