package com.fly.controller;

import com.fly.pojo.*;
import com.fly.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/log")
@RestController

public class LogController {
    @Autowired
    private OperateLogService operateLogService;
    @GetMapping("/page")
    public Result page(Integer page, Integer pageSize) {
        log.info("分页查询: {}", page, pageSize);
        PageResult<OperateLog> pageResult = operateLogService.page(page, pageSize);
        return Result.success(pageResult);
    }
}
