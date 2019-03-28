package com.w15104.demo.study.basic.util;

import java.util.Properties;

/*
*
* @Description 用于判断当前系统类型（Windows/Linux）
*
* @author w15104
* @data: 2019-3-5
*
* @modified by:
* @modified date:
* @modified no:
*/
public class OSUtil {
	
	private OSUtil() {
	}

	/**
	 * 判断当前系统是否为Linux ture为linux false为windows
	 * 
	 * @return boolean 是否为Linux系统
	 */
	public static boolean isOSLinux() {
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		return (os != null) && (os.toLowerCase().contains("linux"));
	}
}