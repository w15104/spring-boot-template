package com.w15104.dataengine.study.utils;

import java.util.Locale;
import org.springframework.context.MessageSource;

/**
* MessageUtil.java
*
* @version 1.0.0
*
* 新建时间：2017年11月10日
* 新建人：w14100
* 修改时间：
* 修改人：
* 修改原因：
*/
public final class MessageUtil
{
  /**
 * 功能描述：返回消息信息
 * @param code 消息编码
 * @param params 消息参数
 * @return
 * @author w14100 2017年11月12日
 */
public static String getMessage(String code, String...params)
  {
    MessageSource ms = (MessageSource)ContextUtil.getBean("messageSource");
    return ms.getMessage(code, params, Locale.SIMPLIFIED_CHINESE);
  }
}