package com.mysql;

public enum ResultEnum {

    SUCCESS(1,"成功"),
    FAILURE(0,"失败"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效");

    private int code;

    private  String msg;

    ResultEnum(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
