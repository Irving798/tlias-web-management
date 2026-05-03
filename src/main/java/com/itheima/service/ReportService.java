package com.itheima.service;

import com.itheima.pojo.JobOption;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

public interface ReportService {

    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

}
