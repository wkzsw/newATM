package com.feicuiedu.atm.business;

import java.io.File;
import java.io.IOException;
/**
 * 创建文件存储
 * @author wangxiaoyi
 *
 */
public class CreateFile {
	public File userFile() {
		// 创建用户信息存储的文件
		File file = new File(File.separator + "user.date");
		//判断是否为文件
		if (file.exists()) {
			return file;
		}else {
			
			try {
				//创建文件
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return file;
	}

}
