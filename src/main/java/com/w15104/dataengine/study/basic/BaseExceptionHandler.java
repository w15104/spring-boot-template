package com.w15104.dataengine.study.basic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@ControllerAdvice
public class BaseExceptionHandler {

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object handleError(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        Result<String> rs = new Result<>();
        if(ex instanceof  CommonException){
            //自定义异常
            /**        日志输出    **/
            rs.setResult(false);
            rs.setCode( ((CommonException) ex).getCode() );
        } else {
            //其他异常
            /**        日志输出    **/
            rs.setResult(true);
            rs.setCode(ErrorCode.E_00000);
        }

        //if (request.getHeader("Accept").contains("application/json")){
             return new ResponseEntity<Result<String>>(rs, HttpStatus.OK);
        //}
    }

}
