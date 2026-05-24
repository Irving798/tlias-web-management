package com.fly.service.impl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.fly.mapper.OperateLogMapper;
import com.fly.pojo.OperateLog;
import com.fly.pojo.PageResult;
import com.fly.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OperateLogServiceImpl implements OperateLogService {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Override
    public PageResult<OperateLog> page(Integer page, Integer pageSize) {
        //1. 设置分页参数(PageHelper)
        PageHelper.startPage(page, pageSize);

        //2. 执行查询
        List<OperateLog> operateLogList = operateLogMapper.list(page, pageSize);
        //3. 解析查询结果, 并封装
        Page<OperateLog> p = (Page<OperateLog>) operateLogList;
        return new PageResult<OperateLog>(p.getTotal(), p.getResult());
    }
}
