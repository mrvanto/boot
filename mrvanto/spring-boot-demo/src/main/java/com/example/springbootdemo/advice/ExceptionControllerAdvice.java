package com.example.springbootdemo.advice;

import com.example.springbootdemo.util.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger LOGGER = LogManager.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception ex, HttpServletRequest request){
        LOGGER.info("", ex);
        Map data = new HashMap();
        data.put("aaa",111);
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("c");
        data.put("list",list);
        return ResponseBody.ok(HttpStatus.INTERNAL_SERVER_ERROR.value(), "内部错误", data);
    }
}
