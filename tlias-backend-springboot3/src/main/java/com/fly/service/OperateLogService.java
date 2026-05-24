package com.fly.service;

import com.fly.pojo.OperateLog;
import com.fly.pojo.PageResult;

public interface OperateLogService {
    PageResult<OperateLog> page(Integer page, Integer pageSize);
}
