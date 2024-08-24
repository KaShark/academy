package com.kashark.crazykashark.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kashark.crazykashark.dto.AdmissionDTO;
import com.kashark.crazykashark.entity.Admission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学生录取情况Mapper
 * @author 赵宇鹏
 * @version 1.0
 */
@Mapper
public interface AdmissionMapper extends BaseMapper<Admission> {
    List<AdmissionDTO> getAdmission(Integer start, Integer length);

    List<AdmissionDTO> getAdmissionNotNull(Integer start, Integer length);

    AdmissionDTO getAdmissionById(Integer id);

    AdmissionDTO getAdmissionByStudentId(Integer studentId);

    List<AdmissionDTO> getAdmissionByCoreTeacherId(Integer coreTeacherId, Integer start, Integer length);

    List<AdmissionDTO> getAdmissionNotNullByCoreTeacherId(Integer coreTeacherId, Integer start, Integer length);

    List<AdmissionDTO> searchAdmission(String[] keywords, Integer start, Integer length);
}
