package com.w15104.demo.study.basic.util;

import com.w15104.demo.study.basic.config.Result;
import com.w15104.demo.study.basic.exception.ErrorCode;
import org.springframework.stereotype.Component;

/*
 *
 * @Description 返回结果封装工具操作类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@Component
public class ResultUtil {

    /**
     * 构造成功报文
     * @param data 报文内容
     * @return T
     */
    public static <T> Result<T> ok(T data){
        return new Result<T>().setStatus(true).setData(data);
    }

    /**
     * 构造成功报文
     * @return T
     */
    public static <T> Result<T> ok(){
        return new Result<T>().setStatus(true);
    }

    /**
     * 构造失败报文
     * @param code 错误码
     * @param isClinese 抛出错误的信息是否设置为中文
     * @return T
     */
    public static <T> Result<T> error(ErrorCode code) {
        return new Result<T>().setStatus(false).setCode(code);
    }

}
