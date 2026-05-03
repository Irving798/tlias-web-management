package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工工作经历
 */
@Mapper
public interface EmpExprMapper {
    /**
     * 批量保存员工的工作经历信息
     */
    void insertBatch(List<EmpExpr> exprList);

    // 批量删除员工工作经历信息
    void deleteByEmpIds(List<Integer> empIds);
    // 根据员工id查询员工工作经历信息
    List<EmpExpr> selectByEmpId(Integer id);
}
