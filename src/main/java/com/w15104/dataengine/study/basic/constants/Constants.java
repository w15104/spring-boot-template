package com.w15104.dataengine.study.basic.constants;

import java.text.SimpleDateFormat;

/*
 *
 * @Description 常量类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public class Constants {

	private Constants() {}
	
    /**
     * FORMAT2格式
     */
    public static final String FORMAT2 = "%s%s";

    /**
     * FORMAT3格式
     */
    public static final String FORMAT3 = "%s%s%s";

    /**
     * FORMAT4格式
     */
    public static final String FORMAT4 = "%s%s%s%s";
    
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

}
