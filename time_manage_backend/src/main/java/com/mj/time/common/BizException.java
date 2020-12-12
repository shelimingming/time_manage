package com.mj.time.common;

import lombok.Data;

/**
 * 系统统一异常
 *
 * @author sheliming
 * @date 2020-05-22
 */
@Data
public class BizException extends RuntimeException {
    private static final long serialVersionUID = -8229285237702935672L;

    private String errorCode;
    private String errorMsg;
    private String errorData;


    /**
     * 无参构造，默认系统异常错误
     */
    public BizException() {
        this.errorCode = ErrorCodeEnum.UNKNOW_ERROR.getCode();
        this.errorMsg = ErrorCodeEnum.UNKNOW_ERROR.getMsg();
    }

    public BizException(final ErrorCodeEnum errorCode) {
        this.errorCode = errorCode.getCode();
        this.errorMsg = errorCode.getMsg();
    }

    public BizException(final ErrorCodeEnum errorCode, String errorData) {
        this.errorCode = errorCode.getCode();
        this.errorMsg = errorCode.getMsg().replace("%s", errorData);

    }

    public BizException(final ErrorCodeEnum errorCode, final Throwable t) {
        super(errorCode.getMsg(), t);
        this.errorCode = errorCode.getCode();
        this.errorMsg = errorCode.getMsg();
    }

    public BizException(final Throwable t) {
        super(t);
        this.errorCode = ErrorCodeEnum.UNKNOW_ERROR.getCode();
        this.errorMsg = ErrorCodeEnum.UNKNOW_ERROR.getMsg();
    }

    @Override
    public String toString() {
        return "BizException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

}
