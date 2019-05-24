package com.qingfeng.breeze.api.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;

    private int code;

    private T data;

    private  String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long total;

    public R() {

    }

    public R (boolean success,int code,String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public  R (boolean success,int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public  R (boolean success,int code, String message, T data, Long total) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public static <T>R success (int code, String message) {
        return new R(true,code,message);
    }

    public static <T>R fail (int code, String message) {
        return new R(false,code,message);
    }

    public static <T>R success (int code, String message, T data) {
        return new R(true,code,message,data);
    }

    public static <T>R success (int code, String message, T data, Long total) {
        return new R(true,code,message,data,total);
    }
}
