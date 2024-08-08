package com.kashark.crazykashark.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kashark.crazykashark.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

/**
 * 签到表Mapper
 * @author 赵宇鹏
 * @version 1.0
 */
@Mapper
public interface ScheduleMapper extends BaseMapper<Schedule> {
    List<Schedule> getSchedule(Integer start, Integer length);

    Schedule getScheduleById(Long id);

    Schedule getScheduleByStudentId(Long studentId);

    Schedule getScheduleByCoreTeacherId(Long coreTeacherId);

    List<Schedule> getScheduleByTimeAndType(Timestamp beginTime, Timestamp endTime, Boolean type);

    List<Schedule> getScheduleWithStatusByTimeAndType(Timestamp beginTime, Timestamp endTime, Boolean type, Integer start, Integer length);

    List<Schedule> getScheduleByTimeAndCoreTeacherIdAndType(Timestamp beginTime, Timestamp endTime, Long coreTeacherId, Boolean type);

    List<Schedule> getScheduleInDescTime(Integer start, Integer length);

    List<Schedule> searchSchedule(String[] keywords, Integer start, Integer length);
}
