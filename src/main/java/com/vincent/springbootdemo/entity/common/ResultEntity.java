package com.vincent.springbootdemo.entity.common;

import java.io.Serializable;

public class ResultEntity<T> implements Serializable {
    private int code;
    private String message;
    private String url;
    private T t;

    public ResultEntity() {
    }

    public ResultEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public ResultEntity(int code, String message, String url) {
        this.code = code;
        this.message = message;
        this.url = url;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
