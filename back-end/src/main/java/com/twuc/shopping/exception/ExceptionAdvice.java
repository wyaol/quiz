package com.twuc.shopping.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler({
            Exception.class
    })
    public ResponseEntity handleException(Exception e) {
        e.printStackTrace();
        String res = "";
        if (e instanceof CommonException) {
            res = e.getMessage();
        } else {
            res = "服务器异常，请稍后再试";
        }
        return ResponseEntity.badRequest().body(new ErrorDto(res));
    }
}
