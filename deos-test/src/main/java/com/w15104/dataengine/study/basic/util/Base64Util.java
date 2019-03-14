package com.w15104.dataengine.study.basic.util;

import org.apache.commons.codec.binary.Base64;


/*
 *
 * @Description Base64编码工具类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public class Base64Util {

  /**
   * Base64解码
   * @param str 要解析的字符串
   * @return String
   */
  public static String decode(String str) {
    return new String(Base64.decodeBase64(str));
  }


  /**
   * Base64编码
   * @param str 待编码的字符串
   * @return String
   */
  public static String encode(String str) {
    return new String(Base64.encodeBase64(str.getBytes()));
  }

}
