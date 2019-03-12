package com.w15104.dataengine.study.basic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.w15104.dataengine.study.basic.config.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 *
 * @Description 统一异常处理类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@ControllerAdvice
public class BaseExceptionHandler {

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return Object
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object handleError(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        Result<String> rs = new Result<>();
        if(ex instanceof  CommonException){
            //自定义异常
            /**        日志输出    **/
            rs.setResult(false);
            rs.setCode( ((CommonException) ex).getCode());
        } else {
            //未知异常
            /**        日志输出    **/
            rs.setResult(false);
            rs.setCode(ErrorCode.E_00000);
        }

        return new ResponseEntity<Result<String>>(rs, HttpStatus.OK);
    }
}
