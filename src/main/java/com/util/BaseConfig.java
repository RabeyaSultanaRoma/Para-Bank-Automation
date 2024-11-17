package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseConfig {
	public String getConfig(String key) throws Exception{
		File file = new File("./Config.properties");
		FileInputStream fs = new FileInputStream(file);
		Properties pro = new Properties();
		pro.load(fs);
		String value = pro.get("URL").toString();
		System.out.println(value);
		return value;
	}
	public static void main(String[] args) throws Exception {
		BaseConfig bc = new BaseConfig();
		bc.getConfig("URL");
	}
}
