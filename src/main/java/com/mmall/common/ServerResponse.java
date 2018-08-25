package com.mmall.common;

import java.io.Serializable;

/**
 * @author LiuZX liuzhixiang
 * DATE   2018/8/25
 */

public class ServerResponse<T> implements Serializable {
    /**
     * 状态码
     */
    private int status;
    /**
     * 信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    /**
     * 私有构造器
     * @param status
     */
    private ServerResponse(int status) {
        this.status = status;
    }

    /**
     * 私有构造器
     * @param status
     * @param data
     */
    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    /**
     * 私有构造器
     * @param status
     * @param msg
     * @param data
     */
    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 私有构造器
     * @param status
     * @param msg
     */
    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg);
    }
}
