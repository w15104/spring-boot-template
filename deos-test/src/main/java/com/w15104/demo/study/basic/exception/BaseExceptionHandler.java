package com.w15104.demo.study.basic.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.w15104.demo.study.basic.config.Result;

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
     * 日志
     */
    private final Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    /**
     * 全局异常捕捉处理
     * @param ex 传入的异常信息
     * @return Object
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object handleError(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        Result<String> rs = new Result<>();
        if(ex instanceof  CommonException){
            //自定义异常
            rs.setStatus(false);
            rs.setCode( ((CommonException) ex).getCode());
        } else {
            //未知异常
            rs.setStatus(false);
            rs.setCode(ErrorCode.E_00000);
        }
        //自定义异常日志输出
        logger.error("REQUEST_URI: {}", request.getRequestURI());
        logger.error("REQUEST_METHOD: {}", request.getMethod());
        logger.error("REQUEST_ADDR: {}", request.getRemoteAddr());
        logger.error("ERROR_MESSAGESG: {}", ex.getMessage());
        logger.error("CLASS_METHOD: {}{}{} ",ex.getStackTrace()[0].getClassName(), "." , ex.getStackTrace()[0].getMethodName());

        return new ResponseEntity<Result<String>>(rs, HttpStatus.OK);
    }
}
