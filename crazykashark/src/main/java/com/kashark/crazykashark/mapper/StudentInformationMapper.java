package com.kashark.crazykashark.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kashark.crazykashark.entity.StudentInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学生信息Mapper
 * @author 赵宇鹏
 * @version 1.0
 */
@Mapper
public interface StudentInformationMapper extends BaseMapper<StudentInformation> {
    List<StudentInformation> getBriefStudentInformation(Integer start, Integer length);

    List<StudentInformation> getBriefStudentInformationByConsultation(Integer consultation, Integer start, Integer length);

    StudentInformation getStudentInformationById(Integer id);

    StudentInformation getBriefStudentInformationByStudentId(Integer studentId);

    List<StudentInformation> searchBriefStudentInformation(String[] keywords, Integer start, Integer length);
}
