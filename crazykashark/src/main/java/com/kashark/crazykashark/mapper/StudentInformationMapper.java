package com.kashark.crazykashark.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kashark.crazykashark.dto.BriefStudentInformationDTO;
import com.kashark.crazykashark.dto.StudentInformationDTO;
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
    List<BriefStudentInformationDTO> getBriefStudentInformation(Integer start, Integer length);

    List<BriefStudentInformationDTO> getBriefStudentInformationByConsultation(Integer consultation, Integer start, Integer length);

    StudentInformationDTO getStudentInformationById(Integer id);

    BriefStudentInformationDTO getBriefStudentInformationByStudentId(Integer studentId);

    List<BriefStudentInformationDTO> searchBriefStudentInformation(String[] keywords, Integer start, Integer length);
}
