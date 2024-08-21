package com.kashark.crazykashark.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kashark.crazykashark.dto.CoreTeacherDTO;
import com.kashark.crazykashark.entity.CoreTeacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 核心老师Mapper
 * @author 赵宇鹏
 * @version 1.0
 */
@Mapper
public interface CoreTeacherMapper extends BaseMapper<CoreTeacher> {
    List<CoreTeacherDTO> getCoreTeachers(Integer start, Integer length);

    CoreTeacherDTO getCoreTeacherById(Integer id);

    CoreTeacherDTO getCoreTeacherByStaffId(Integer staffId);

    CoreTeacherDTO getCoreTeacherByCoreTeacherId(Integer coreTeacherId);

    List<CoreTeacherDTO> searchCoreTeachers(String[] keywords, Integer start, Integer length);
}
