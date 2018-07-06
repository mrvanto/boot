package com.example.springbootdemo.util;

import org.springframework.http.ResponseEntity;


public class ResponseBody {
    private Integer status;
    private String message;
    private Object data;

    public ResponseBody(Integer status, String message, Object data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseEntity ok(Integer status, String message, Object data) {
        return ResponseEntity.ok(new ResponseBody(status, message, data));
    }
}
