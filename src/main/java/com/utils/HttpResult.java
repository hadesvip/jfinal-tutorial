package com.utils;

/**
 * web 响应
 * Created by wangyong on 2016/12/5.
 */
public class HttpResult {

    /**
     * 响应码
     */
    private int code;

    /**
     * 响应结果
     */
    public Object result;

    public HttpResult() {
    }

    public HttpResult(int code) {
        this.code = code;
    }


    public HttpResult(int code, Object result) {
        this.code = code;
        this.result = result;
    }

    /**
     * 操作成功
     */
    public static HttpResult success() {
        return new HttpResult(HttpCode.HTTP_SUCCESS);
    }

    /**
     * 操作失败
     */
    public static HttpResult fail() {
        return new HttpResult(HttpCode.HTTP_FAIL);
    }
}
