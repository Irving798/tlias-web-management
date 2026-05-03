package com.itheima.exception;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("服务器发生异常", e);
        return Result.error("服务器发生异常");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        String message = e.getMessage();

        if (message != null && message.contains("Duplicate entry")) {
            int start = message.indexOf("'") + 1;
            int end = message.indexOf("'", start);
            String value = message.substring(start, end);

            if (message.contains("phone")) {
                return Result.error("手机号" + value + "已存在");
            }
        }

        return Result.error("数据已存在");
    }
}