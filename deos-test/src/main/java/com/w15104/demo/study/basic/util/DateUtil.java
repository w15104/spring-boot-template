package com.w15104.demo.study.basic.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	/**
	 * 时间格式14位
	 */
    public static final SimpleDateFormat FORMAT14 = new SimpleDateFormat("yyyyMMddHHmmss");
	/**
	 * 时间格式17位
	 */
    public static final SimpleDateFormat FORMAT17 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	/**
	 * 时间格式19位
	 */
    public static final SimpleDateFormat FORMAT19 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 时间格式10位
	 */
    public static final SimpleDateFormat FORMAT10 = new SimpleDateFormat("yyyy-MM-dd");

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
		return DateUtil.getInstance().parse(util.FORMAT19, date).getTime();
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
