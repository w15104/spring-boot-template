package com.w15104.dataengine.study.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description 时间工具类
 * @author c13691
 */
public class DateUtil
{
	/**
	 * @description 获取日期时间字符串
	 */
	public static String getSystemDateForString()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(BasicConstant.DOWNLAOD_DATE_FORMAT);
		String nowdate = dateFormat.format(new Date());
		return nowdate;
	}

	public static String getSystemDateFormat(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(BasicConstant.STANDARD_DATE_FORMAT);
		String nowdate = dateFormat.format(date);
		return nowdate;
	}
}