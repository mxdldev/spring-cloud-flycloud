package com.fly.common.exception;

/**
 * Description: <通用错误码><br>
 * Author:    门心叼龙<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
public enum ErrorCode {

    OK(0, ""),
    FAIL(-1, "操作失败"),
    RPC_ERROR(-2,"远程调度失败"),
    USER_NOT_FOUND(1000,"用户不存在"),
    USER_PASSWORD_ERROR(1001,"密码错误"),
    GET_TOKEN_FAIL(1002,"获取token失败"),
    TOKEN_IS_NOT_MATCH_USER(1003,"请使用自己的token进行接口请求"),

    BLOG_IS_NOT_EXIST(2001,"该内容不存在");
    private int code;
    private String msg;


    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ErrorCode codeOf(int code) {
        for (ErrorCode state : values()) {
            if (state.getCode() == code) {
                return state;
            }
        }
        return null;
    }
}
