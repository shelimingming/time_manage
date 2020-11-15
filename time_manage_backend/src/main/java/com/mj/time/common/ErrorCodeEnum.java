package com.mj.time.common;

public enum ErrorCodeEnum {

    SUCCESS("00000", "成功"),

    UNKNOW_ERROR("99999", "系统异常"),
    ;

    private String code;
    private String msg;


    private ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }

    /**
     * 根据编码查询枚举。
     *
     * @param code 编码。
     * @return 枚举。
     */
    public static ErrorCodeEnum getByCode(String code) {
        for (ErrorCodeEnum value : ErrorCodeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

    /**
     * 枚举是否包含此code
     *
     * @param code 枚举code
     * @return 结果
     */
    public static Boolean contains(String code) {
        for (ErrorCodeEnum value : ErrorCodeEnum.values()) {
            if (value.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
}
