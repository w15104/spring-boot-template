package com.w15104.dataengine.study.utils;

import java.util.UUID;

/**
* PKUtil.java
*
* @version 1.0.0
*
* 新建时间：2017年11月10日
* 新建人：w14100
* 修改时间：
* 修改人：
* 修改原因：
*/
public final class PKUtil
{
  /**
 * 功能描述：生成32位序列号
 * @return
 */
public static String getUUID()
  {
    return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
  }
}