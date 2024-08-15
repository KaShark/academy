package com.kashark.crazykashark.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kashark.crazykashark.dto.ScheduleDTO;
import com.kashark.crazykashark.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

/**
 * 时间表Mapper
 * @author 赵宇鹏
 * @version 1.0
 */
@Mapper
public interface ScheduleMapper extends BaseMapper<Schedule> {
    List<ScheduleDTO> getSchedules(Integer start, Integer length);

    ScheduleDTO getScheduleById(Integer id);

    List<ScheduleDTO> getSchedulesByStudentId(Integer studentId, Integer start, Integer length);

    List<ScheduleDTO> getSchedulesByTime(Timestamp beginTime, Timestamp endTime, Integer start, Integer length);

    List<ScheduleDTO> getSchedulesByCoreTeacherId(Integer coreTeacherId, Integer start, Integer length);

    List<ScheduleDTO> getSchedulesByType(String type, Integer start, Integer length);

    List<ScheduleDTO> getSchedulesByCoreTeacherIdAndType(Integer coreTeacherId, String type, Integer start, Integer length);

    List<ScheduleDTO> getSchedulesByTimeAndCoreTeacherId(Timestamp beginTime, Timestamp endTime, Integer coreTeacherId, Integer start, Integer length);

    List<ScheduleDTO> getSchedulesByTimeAndType(Timestamp beginTime, Timestamp endTime, String type, Integer start, Integer length);

    List<ScheduleDTO> getSchedulesByTimeAndCoreTeacherIdAndType(Timestamp beginTime, Timestamp endTime, Integer coreTeacherId, String type, Integer start, Integer length);

    List<ScheduleDTO> searchSchedules(String[] keywords, Integer start, Integer length);
}
