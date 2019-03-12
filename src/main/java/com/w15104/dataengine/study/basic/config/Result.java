package com.w15104.dataengine.study.basic.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.w15104.dataengine.study.basic.exception.ErrorCode;

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
     * 中文错误信息
     */
    private String errMsgUS;

    /**
     * 英文错误信息
     */
    private String errMsgCN;


    public T getData() {
        return data;
    }

    public Result<T> setData(T data){
        this.data = data;
        return  this;
    }

    public String getErrMsgCN() {
        return errMsgCN;
    }

    public Result<T> setErrMsgCN(String errMsgCN) {
        this.errMsgCN = errMsgCN;
        return this;
    }

    public String getErrMsgUS() {
        return errMsgUS;
    }

    public Result<T> setErrMsgUS(String errMsgUS) {
        this.errMsgUS = errMsgUS;
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
        this.errMsgCN = code.getMessageCN();
        this.errMsgUS = code.getMessageUS();
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                ", code=" + code +
                ", data=" + data +
                ", errMsgUS='" + errMsgUS + '\'' +
                ", errMsgCN='" + errMsgCN + '\'' +
                '}';
    }
}
