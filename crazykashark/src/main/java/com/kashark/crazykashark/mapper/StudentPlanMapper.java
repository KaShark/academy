package com.kashark.crazykashark.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kashark.crazykashark.entity.StudentPlan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学生方案表Mapper
 * @author 赵宇鹏
 * @version 1.0
 */
@Mapper
public interface StudentPlanMapper extends BaseMapper<StudentPlan> {
    List<StudentPlan> getStudentPlan(Integer start, Integer length);

    StudentPlan getStudentPlanById(Long id);

    StudentPlan getStudentPlanByPlanChartId(Long planChartId);

    StudentPlan getStudentPlanByStudentId(Long studentId);

    StudentPlan getStudentPlanByCoreTeacherId(Long coreTeacherId);

    StudentPlan getStudentPlanByBatch(String batch);

    List<StudentPlan> getStudentPlanInAscCreateTime(Integer start, Integer length);

    List<StudentPlan> getStudentPlanInDescCreateTime(Integer start, Integer length);

    List<StudentPlan> searchStudentPlan(String[] keywords, Integer start, Integer length);

}
