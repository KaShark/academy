package com.kashark.crazykashark.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kashark.crazykashark.entity.StudentFiltration;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学生筛选表Mapper
 * @author 赵宇鹏
 * @version 1.0
 */
@Mapper
public interface StudentFiltrationMapper extends BaseMapper<StudentFiltration> {
    List<StudentFiltration> getStudentFiltration(Integer start, Integer length);

    StudentFiltration getStudentFiltrationById(Long id);

    StudentFiltration getStudentFiltrationByFiltChartId(Long filtChartId);

    StudentFiltration getStudentFiltrationByStudentId(Long studentId);

    StudentFiltration getStudentFiltrationByFiltTeacherId(Long filtTeacherId);

    StudentFiltration getStudentFiltrationByBatch(String batch);

    List<StudentFiltration> getStudentFiltrationInAscCreateTime(Integer start, Integer length);

    List<StudentFiltration> getStudentFiltrationInDescCreateTime(Integer start, Integer length);

    List<StudentFiltration> searchStudentFiltration(String[] keywords, Integer start, Integer length);
}
