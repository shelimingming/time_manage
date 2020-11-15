package com.mj.time.common;

import lombok.Data;

/**
 * 通用的Controller返回
 *
 * @author sheliming
 * @date 2020-05-22
 */
@Data
public class CommonResponse<T> {
    private String code;
    private String message;
    private T data;

    public CommonResponse() {
        this.code = ErrorCodeEnum.SUCCESS.getCode();
        this.message = ErrorCodeEnum.SUCCESS.getMsg();
    }

    public CommonResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResponse(ErrorCodeEnum errorCodeEnum) {
        this.code = errorCodeEnum.getCode();
        this.message = errorCodeEnum.getMsg();
    }

    public CommonResponse(T data) {
        this.code = ErrorCodeEnum.SUCCESS.getCode();
        this.message = ErrorCodeEnum.SUCCESS.getMsg();
        this.data = data;
    }
}
