package com.w15104.dataengine.study.utils;

import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/*
 *
 * @Description Spring 上下文工具类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public final class ContextUtil{
	
  private static final ContextUtil instance = new ContextUtil();
  
  /**
   * Servlet 上下文
   */
  private ServletContext servletContext;

  /**
   * Spring 上下文
   */
  private ApplicationContext springContext;

  /**
 * 功能描述：单例模式句柄
 * @return
 * @author w14100 2017年11月12日
 */
public static final ContextUtil getInstance() {
    return instance;
  }

/**
* 功能描述：servletContext的getter方法
* @return
* @author w14100 2017年11月12日
*/
  public static ServletContext getServletContext() {
    return getInstance().servletContext;
  }

  /**
  * 功能描述：springContext的getter方法
  * @return
  * @author w14100 2017年11月12日
  */
  public static ApplicationContext getSpringContext() {
    return getInstance().springContext;
  }

  /**
   * 功能描述：设置springContext
   * @author w15104 2017年11月12日
   */
  public static void setSpringContext(ApplicationContext springContext){
    getInstance().springContext = springContext;
  }


  /**
  * 私有构造方法
  */
  private ContextUtil() {
    servletContext = null;
    springContext = null;
  }

  /**
  * 功能描述：容器或服务关闭时清除上细文
  * @author w14100 2017年11月12日
  */
  public void cleanup() {
    servletContext = null;
    springContext = null;
  }

  /**
  * 功能描述：容器启动时初始化方法
  * @param  servletContext
  * @author w14100 2017年11月12日
  */
  public void init(ServletContext servletContext) {
    this.servletContext = servletContext;
    springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
  }

  /**
  * 功能描述：从Spring容器中获取已加载的对象实例
  * 
  * @param  beanName 对象名（beanId）
  * @return Object 容器对象实例
  * @author w14100 2017年11月12日
  */
  public static Object getBean(String beanName) {
    return getBean(beanName, new Object[] { null });
  }

  /**
  * 功能描述：从Spring容器中获取已加载的对象实例（重载）
  * 
  * @param  beanName 对象名（beanId）
  * @return Object 容器对象实例
  * @author w14100 2017年11月12日
  */
  public static Object getBean(String beanName, Object...args) {
    return getInstance().springContext.getBean(beanName, args);
  }

  /**
  * 功能描述：从Spring容器中获取已加载的对象实例（重载）
  * 
  * @param  beanClass 对象名（beanId）
  * @return Object 容器对象实例
  * @author w14100 2017年11月12日
  */
  public static Object getBean(Class<?> beanClass) {
    return getBean(beanClass, new Object[] { null });
  }

  /**
  * 功能描述：从Spring容器中获取已加载的对象实例（重载）
  * 
  * @param  beanClass 对象名（beanId）
  * @return Object 容器对象实例
  * @author w14100 2017年11月12日
  */
  public static Object getBean(Class<?> beanClass, Object...args) {
    return getInstance().springContext.getBean(beanClass, args);
  }
}