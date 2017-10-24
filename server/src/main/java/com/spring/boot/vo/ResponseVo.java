package com.spring.boot.vo;

import lombok.Data;

@Data
public class ResponseVo<T> {

    private Integer code;

    private String msg;

    private T t;

    public ResponseVo(Integer code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }

    public ResponseVo() {
    }
}
