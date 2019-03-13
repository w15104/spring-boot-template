package com.w15104.dataengine.study.basic.util;

import java.util.UUID;

/*
 *
 * @Description UUID 32位序列号生生工具类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public final class PKUtil
{
  /**
   * 获取UUID,生成32位序列号
   * @return String uuid
   */
  public static String getUUID() {
    return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
  }

}