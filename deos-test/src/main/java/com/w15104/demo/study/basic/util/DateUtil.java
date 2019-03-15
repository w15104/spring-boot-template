package com.w15104.demo.study.basic.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.w15104.demo.study.basic.constants.Constants;

/*
*
* @Description 时间工具类
*
* @author y15649
* @data: 2019-3-5
*
* @modified by:
* @modified date:
* @modified no:
*/
public class DateUtil {

	private static final DateUtil util = new DateUtil();
	
	private DateUtil() {}
	
	public static DateUtil getInstance() {
		return util;
	}
	
	/**
	 * 将日期字符串转换成时间对想
	 * @param date 日期
	 * @param format 格式
	 * @return 日期对想
	 * @throws ParseException
	 */
	public static Date parseDate(String date, String format) throws ParseException {
		SimpleDateFormat parse = new SimpleDateFormat(format);
		return DateUtil.getInstance().parse(parse, date);
	}
	
	/**
	 * 获得当前时间字符串
	 * @param format 格式化字符串
	 * @return
	 */
	public static String getCurDateStr(String format) {
		return getDate(new Date(), format);
	}
	
	/**
	 * 根据时间字符串获得时间戳
	 * @param date 时间字符串（yyyy-MM-dd HH:mm:ss）
	 * @return 毫秒
	 * @throws ParseException
	 */
	public static long getTime(String date) throws ParseException {
		return DateUtil.getInstance().parse(Constants.FORMAT19, date).getTime();
	}
	
	/**
	 * 获得时间字符串
	 * @param date 日期
	 * @param format 格式
	 * @return
	 */
	public static String getDate(Date date, String format) {
		SimpleDateFormat parse = new SimpleDateFormat(format);
		return parse.format(date);
	}
	
	/**
	 * 日期格式化
	 * @param simple 日期格式化工具
	 * @param date 日期字符串
	 * @return 日期类型
	 * @throws ParseException
	 */
	private Date parse(SimpleDateFormat simple, String date) throws ParseException {
		return simple.parse(date);
	}
}
