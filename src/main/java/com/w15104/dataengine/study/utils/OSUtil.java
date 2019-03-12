package com.w15104.dataengine.study.utils;

import java.util.Properties;

/**
 * 
 * 用于判断当前系统类型（Windows/Linux）
 * 
 * @author h14338
 * @date: 2017年7月22日
 * @see: OSUtil
 * @since:
 */
public class OSUtil
{
  /**
   * Description：判断当前系统是否为Linux ture为linux  false为windows
   * 
   * @return boolean
   */
public static boolean isOSLinux()
  {
    Properties prop = System.getProperties();

    String os = prop.getProperty("os.name");
    if ((os != null) && (os.toLowerCase().indexOf("linux") > -1)) {
        return true;
    }else{
    	return false;
    }
  }
}