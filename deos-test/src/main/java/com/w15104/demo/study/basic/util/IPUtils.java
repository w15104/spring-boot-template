package com.w15104.demo.study.basic.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 *
 * @Description IP工具类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public class IPUtils {
	
	private IPUtils(){}
	
	private static final Logger logger = LoggerFactory.getLogger(IPUtils.class);
	
	/**
	 * 本地IP常量
	 */
	public static final String LOCALHOST = "127.0.0.1";
	
	/**
	 * 本地IP常量
	 */
	public static final String LHOST = "0:0:0:0:0:0:0:1";

	/**
	 * 分隔符
	 */
	public static final String SEPERATOR = ",";

	/**
	 * 功能描述：获取访问者IP
	 * @param request
	 * @return
	 * @author w15104 2017年11月12日
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ipAddress = null;
		if (request != null) {
			ipAddress = request.getHeader("x-forwarded-for");
			if (checkVariable(ipAddress)) {
				ipAddress = request.getHeader("Proxy-Client-IP");
			}
			if (checkVariable(ipAddress)) {
				ipAddress = request.getHeader("WL-Proxy-Client-IP");
			}
			if (checkVariable(ipAddress)) {
				ipAddress = request.getRemoteAddr();
			}

			//对于多个代理的情况，第一个IP为客户端真实IP，多个IP按照','分割
			if ((ipAddress != null) && (ipAddress.length() > 15) && (ipAddress.indexOf(SEPERATOR) > 0)) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(SEPERATOR));
			}
		}
		if ((checkVariable(ipAddress)) || (ipAddress.equals(LOCALHOST)) || (ipAddress.equals(LHOST))) {
			//根据网卡获取本机配置IP
			try {
				InetAddress inet = InetAddress.getLocalHost();
				ipAddress = inet.getHostAddress();
			} catch (UnknownHostException e) {
				logger.error("get host IP error");
			}
		}
		return ipAddress;
	}

	private static boolean checkVariable(String ipAddress) {
		return (ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress));
	}
}