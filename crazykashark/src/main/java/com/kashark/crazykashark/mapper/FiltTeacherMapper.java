package com.kashark.crazykashark.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kashark.crazykashark.dto.FiltTeacherDTO;
import com.kashark.crazykashark.entity.FiltTeacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 筛选老师Mapper
 * @author 赵宇鹏
 * @version 1.0
 */
@Mapper
public interface FiltTeacherMapper extends BaseMapper<FiltTeacher> {
    List<FiltTeacherDTO> getFiltTeachers(Integer start, Integer length);

    FiltTeacherDTO getFiltTeacherById(Integer id);

    FiltTeacherDTO getFiltTeacherByStaffId(Integer staffId);

    FiltTeacherDTO getFiltTeacherByFiltTeacherId(Integer filtTeacherId);

    List<FiltTeacherDTO> searchFiltTeachers(String[] keywords, Integer start, Integer length);
}
