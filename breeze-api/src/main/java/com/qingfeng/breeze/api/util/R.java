package com.qingfeng.breeze.api.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;

    private String code;

    private T data;

    private  String message;

    private Integer total;

    public R() {

    }

    public R (boolean success,String code,String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public  R (boolean success,String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public  R (boolean success,String code, String message, T data, Integer total) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public static <T>R success (String code, String message) {
        return new R(true,code,message);
    }

    public static <T>R fail (String code, String message) {
        return new R(false,code,message);
    }

    public static <T>R success (String code, String message, T data) {
        return new R(false,code,message,data);
    }

    public static <T>R success (String code, String message, T data, Integer total) {
        return new R(false,code,message,data,total);
    }
}
