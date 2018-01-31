package com.feicuiedu.atm.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 工具类
 * 
 * @author wangxiaoyi
 *
 */
public class CommonUtils {
	/**
	 * 项目根据目录下读取文件里的内容
	 */
	public static void printText(String fileName) {
		try {
			// 字节输入流
			InputStream is = CommonUtils.class.getClassLoader().getResourceAsStream(fileName);
			// 字符输入流
			InputStreamReader isr = new InputStreamReader(is);
			// 输入缓冲流
			BufferedReader br = new BufferedReader(isr);

			String strLine = null;

			while ((strLine = br.readLine()) != null) {
				System.out.println(strLine);

			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
