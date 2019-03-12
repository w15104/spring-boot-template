package com.w15104.dataengine.study.utils;

import java.util.UUID;

/**
* UUID 32位序列号生生工具类
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
   * 获取UUID,生成32位序列号
   * @return String uuid
   */
  public static String getUUID()
  {
    return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
  }

}