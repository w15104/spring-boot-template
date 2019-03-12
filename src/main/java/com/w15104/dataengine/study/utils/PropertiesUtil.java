package com.w15104.dataengine.study.utils;

import java.util.ResourceBundle;

/**
* PropertiesUtil.java
*
* @version 1.0.0
*
* 新建时间：2017年11月10日
* 新建人：w14100
* 修改时间：
* 修改人：
* 修改原因：
*/
public class PropertiesUtil
{
  public static String getProperty(String path, String key)
  {
    ResourceBundle bundle = ResourceBundle.getBundle(path);
    return bundle.getString(key);
  }
}