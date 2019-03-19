package com.w15104.demo.study.basic.util;

import java.util.Locale;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/*
 *
 * @Description RequestContextUtil工具类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public class RequestContextUtil {

	public RequestContextUtil() {
	}

	/**
	 * 从Reques中获取IP
	 * 
	 * @return IP
	 */
	public static String getIP() {
		HttpServletRequest request = getRequest();
		return IPUtils.getIpAddr(request);
	}

	/**
	 * 获取HttpServletRequest
	 * 
	 * @return HttpServletRequest
	 */
	public static HttpServletRequest getRequest() {
		if (RequestContextHolder.getRequestAttributes() == null) {
			return null;
		}
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取ServletContext
	 * 
	 * @return ServletContext
	 */
	public static ServletContext getServletContext() {
		HttpServletRequest request = getRequest();
		if (request != null) {
			return request.getSession().getServletContext();
		}
		return null;
	}

	/**
	 * 获取系统显示语言
	 * 
	 * @return Locale
	 */
	public static Locale getCurrentLocale() {
		HttpServletRequest request = getRequest();
		Locale locale = null;
		if (request != null) {
			locale = (Locale) request.getSession().getAttribute("locale");
		}
		return locale == null ? Locale.SIMPLIFIED_CHINESE : locale;
	}

}
