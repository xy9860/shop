package com.xy9860.shop.util;

import java.io.File;
import java.io.FilenameFilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bankUtil")
public class BankUtilImpl implements BankUtil {
	@Value("#{prop.bankPath}")
	private String bankPath;
	
	public String[] getBankImage() {
		return new File(bankPath).list(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {//路径 和文件名
				// TODO Auto-generated method stub
				return name.endsWith(".gif");//过滤后缀名gif 的文件
			}
		});
	}
	
/*	public static void main(String[] args) {
		String[] list=new File("H:\\shop\\shop\\src\\main\\webapp\\bank\\").list(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".gif");
			}
		});
		
		for (String string : list) {
			System.out.println(list);
		}
	}
	*/
}
