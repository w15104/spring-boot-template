package com.w15104.demo.study.basic.util;

import java.lang.reflect.InvocationTargetException;

import com.w15104.demo.study.basic.exception.CommonException;
import com.w15104.demo.study.basic.exception.ErrorCode;
import org.apache.commons.beanutils.BeanUtils;

/*
 *
 * @Description 对象操作工具类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public class BeanUtil {


  /**
   * 对象属性拷贝方法
   * @param origin 源对象
   * @param clasz 目标对象类型
   * @return 目标对象
   * @throws CommonException 异常
   */
  public static <T> T copyBean(Object origin, Class<T> clasz) {
    try {
      T t = clasz.newInstance();
      BeanUtils.copyProperties(t, origin);
      return t;
    } catch (IllegalAccessException|InstantiationException|InvocationTargetException e) {
      throw new CommonException(ErrorCode.E_00010, e);
    }
  }
}
