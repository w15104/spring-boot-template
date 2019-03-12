package com.w15104.dataengine.study.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestContextUtil {
	
	private RequestContextUtil () {
	}
	public static final String SYS_USER = "sysUser";

	
	/**
	 * 功能描述：构造请求上下文
	 * @return
	 * @author w14100 2017年11月12日
	 */
	public static RequestContext getContext() {
		
		if (RequestContextHolder.getRequestAttributes() == null) {
			return null;
		}
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		RequestContext requestContext = new RequestContext();
		requestContext.setRequest(req);
		requestContext.setSession(req.getSession());
		return requestContext;
	}


	public static HttpServletRequest getRequest() {
		if (RequestContextHolder.getRequestAttributes() == null) {
			return null;
		}
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}


	/**
	 * 功能描述：获取当前登录人ID
	 * @return
	 * @author w15104 2017年11月12日
	 */
/*	public static String getCurrentUserID()
		{
			User su = getCurrentUser();
			if (su != null) {
				return su.getId();
			}
			return null;
		}*/

	/**
	 * 功能描述：获取当前登录人信息
	 * @return
	 * @author w15104 2017年11月12日
	 */
/*	public static User getCurrentUser()
		{
			RequestContext context = getContext();
			if (context != null) {
				return (User)context.getRequest().getSession().getAttribute(SYS_USER);
			}
			return null;
		}*/
}