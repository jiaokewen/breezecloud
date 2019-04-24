package com.qingfeng.breeze.api.exception;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/4/24 11:58
 */
public class BreezeException extends RuntimeException{

    public BreezeException(){}

    public BreezeException(String message) {
        super(message);
    }
}
