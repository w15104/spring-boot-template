package com.w15104.dataengine.study.utils;

import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestContext {
	/**
	 * 上下文
	 */
	private ServletContext context;
	/**
	 * 会话
	 */
	private HttpSession session;
	/**
	 * 请求
	 */
	private HttpServletRequest request;
	/**
	 * 相应
	 */
	private HttpServletResponse response;
	/**
	 * cookies
	 */
	private Map<String, Cookie> cookies;
	
	public RequestContext(){
	}


	public ServletContext getContext()
	{
		return this.context;
	}

	public HttpSession getSession() {
		return this.session;
	}

	public HttpServletRequest getRequest() {
		return this.request;
	}

	public HttpServletResponse getResponse() {
		return this.response;
	}

	public Map<String, Cookie> getCookies() {
		return this.cookies;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setCookies(Map<String, Cookie> cookies) {
		this.cookies = cookies;
	}
}