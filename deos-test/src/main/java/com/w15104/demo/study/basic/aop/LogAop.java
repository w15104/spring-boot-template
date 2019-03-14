package com.w15104.demo.study.basic.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/*
*
* @Description 日志切面
*
* @author yqz
* @data: 2019-3-13
*
* @modified by:
* @modified date:
* @modified no:
*/
@Aspect
@Component
public class LogAop {

	private final  Logger logger = LoggerFactory.getLogger(LogAop.class);

	/**
     * 切入点，包含service层和controller层
     */
	@Pointcut("execution(public * com.w15104.demo.study.controller..*.*(..)) || "
			+ "execution(public * com.w15104.demo.study.service..*.*(..))")
	public void serviceLog() throws Throwable{
		logger.info("start operations");
	}
	
	/**
	 * 在进入切入点之前，执行此方法
	 * @param joinPoint 接入点，从中获得访问信息
	 * @throws Throwable
	 */
	@Before("serviceLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，获得参数
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest servletRequest = attributes.getRequest();
		
		logger.info(servletRequest.getRequestURI().toString());
		logger.info(servletRequest.getMethod());
		logger.info(servletRequest.getRemoteAddr());
		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		logger.info("ARGS" + Arrays.toString(joinPoint.getArgs()));
	}
	
	/**
	 * 在方法执行完后，处理返回结果
	 * @param ret
	 * @throws Throwable
	 */
	@AfterReturning(returning = "ret", pointcut = "serviceLog()")
	public void doAfterReturning(Object ret) throws Throwable{
		logger.info("RESPONSE: " + ret);
	}
}
