package com.w15104.dataengine.study.basic;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/*
 * @description 统一返回
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@JsonInclude
public class Result<T> implements Serializable {

    /**
     * 成功标志
     */
    private boolean result;

    /**
     * 错误码
     */
    private ErrorCode code;

    /**
     * 成功时的数据集
     */
    private T data;

    /**
     * 错误信息
     */
    private String errMsg;


    public T getData() {
        return data;
    }

    public Result<T> setData(T data){
        this.data = data;
        return  this;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public Result<T> setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public boolean getResult(){
        return result;
    }

    public Result<T> setResult(boolean result) {
        this.result = result;
        return this;
    }

    public ErrorCode getCode(){
        return code;
    }


    public Result<T> setCode(ErrorCode code) {
        this.code = code;
        this.errMsg = code.getMessage();
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                ", code=" + code +
                ", data=" + data +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
