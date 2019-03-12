package com.w15104.dataengine.study.basic.exception;

/*
 *
 * @description 自定义异常
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public class CommonException extends Exception{

    /**
     * 唯一识别号
     */
    private static final long  serialVersionUID  = 8918375828146090155L;

    /**
     * 错误码
     */
    protected ErrorCode code;

    /**
     * 构造函数
     */
    public CommonException() {
        super();
    }

    /**
     * 构造函数
     * @param code 错误码
     */
    public CommonException(ErrorCode code){
        super( code.getMessageCN());
        this.code = code;
    }

    /**
     * 构造函数
     * @param code 错误码
     * @param cause 异常
     */
    public CommonException(ErrorCode code, Throwable cause){
        super( code.getMessageUS(), cause);
        this.code = code;
    }

    /**
     * 构造函数
     * @param cause 异常
     */
    public CommonException(Throwable cause){
        super( cause);
    }

    /**
     * 获取错误码
     * @return ErrorCode
     */
    public ErrorCode getCode() {
        return code;
    }
}
