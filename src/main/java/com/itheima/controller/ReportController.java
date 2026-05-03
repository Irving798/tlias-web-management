package com.itheima.controller;


import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/report")
@RestController
@Slf4j
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("统计员工岗位数据");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);

    }
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("统计员工性别数据");
        List<Map<String, Object>> resultList = reportService.getEmpGenderData();
        return Result.success(resultList);
    }
}
