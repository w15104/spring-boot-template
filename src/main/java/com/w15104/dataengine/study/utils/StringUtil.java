package com.w15104.dataengine.study.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * MD5工具类
 * 
 * @author w11122
 * @date: 2017年11月13日
 * @see: StringUtil
 * @since:
 */
public class StringUtil {
	private static Logger logger = LoggerFactory.getLogger(StringUtil.class);

	/**
	 * Description：获取字符串的MD5值
	 * 
	 * @param str
	 *            待加密字符串
	 * @return string MD5加载字符串
	 */
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		}
		byte[] byteArray = null;
		if (messageDigest != null) {
			byteArray = messageDigest.digest();
		}
		StringBuffer md5StrBuff = new StringBuffer();
		if (byteArray != null) {
			for (int i = 0; i < byteArray.length; i++) {
				if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
					md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
				} else {
					md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
				}
			}
		}
		return md5StrBuff.toString();
	}

	/**
	 * Description：获取对象的MD5值
	 * 
	 * @param objects 用户对象
	 * @return string 密码密文
	 */
	public static String getMD5Str(Object... objects) {
		StringBuilder stringBuilder = new StringBuilder();
		Object[] arrayOfObject = objects;
		int j = objects.length;
		for (int i = 0; i < j; i++) {
			Object object = arrayOfObject[i];
			stringBuilder.append(object.toString());
		}
		return getMD5Str(stringBuilder.toString());
	}
}