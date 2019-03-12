package com.w15104.dataengine.study.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* IPUtils.java
*
* @version 1.0.0
*
* 新建时间：2017年11月10日
* 新建人：w14100
* 修改时间：
* 修改人：
* 修改原因：
*/
public class IPUtils {
	
	private IPUtils(){}
	
	protected static final Logger logger = LoggerFactory.getLogger(IPUtils.class);
	
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
	public static String getIpAddr(HttpServletRequest request)
	{
		String ipAddress = request.getHeader("x-forwarded-for");
		if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getRemoteAddr();
			if ((ipAddress.equals(LOCALHOST)) || (ipAddress.equals(LHOST))) {
				//根据网卡获取本机IP配置信息
				try {
					InetAddress inet = InetAddress.getLocalHost();
					ipAddress = inet.getHostAddress();
				} catch (UnknownHostException e) {
					logger.error("获取主机IP失败", e);
				}
			}
		}
		//对于通过多个代理的情况，第一个IP为客户端真实IP，多个IP按照‘,’分隔
		if (ipAddress != null && ipAddress.length() > 15 && ipAddress.indexOf(",") > 0) {
			ipAddress = ipAddress.substring(0, ipAddress.indexOf(SEPERATOR));
		}
		return ipAddress;
	}
}