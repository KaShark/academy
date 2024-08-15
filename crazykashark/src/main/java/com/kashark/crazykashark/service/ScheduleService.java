package com.kashark.crazykashark.service;

import com.kashark.crazykashark.dto.ScheduleDTO;
import com.kashark.crazykashark.exception.ServiceException;

import java.time.LocalDate;
import java.util.List;

/**
 * 筛选方案时间安排表Service
 * @author 赵宇鹏
 * @version 1.0
 */
public interface ScheduleService {
    List<ScheduleDTO> getSchedules(Integer current, Integer size);

    ScheduleDTO getScheduleById(Integer id) throws ServiceException;

    List<ScheduleDTO> getSchedulesByStudentId(Integer studentId, Integer current, Integer size);

    List<ScheduleDTO> getSchedulesByTime(LocalDate date, Integer current, Integer size);

    List<ScheduleDTO> getSchedulesByCoreTeacherId(Integer coreTeacherId, Integer current, Integer size);

    List<ScheduleDTO> getSchedulesByType(String type, Integer current, Integer size);

    List<ScheduleDTO> getSchedulesByCoreTeacherIdAndType(Integer coreTeacherId, String type, Integer current, Integer size);

    List<ScheduleDTO> getSchedulesByTimeAndCoreTeacherId(LocalDate date, Integer coreTeacherId, Integer current, Integer size);

    List<ScheduleDTO> getSchedulesByTimeAndType(LocalDate date, String type, Integer current, Integer size);

    List<ScheduleDTO> getSchedulesByTimeAndCoreTeacherIdAndType(LocalDate date, Integer coreTeacherId, String type, Integer current, Integer size);

    void newSchedule(Integer staffId, ScheduleDTO scheduleDTO) throws ServiceException;

    void editSchedule(Integer staffId, ScheduleDTO scheduleDTO) throws ServiceException;

    void deleteSchedule(Integer staffId, Integer id) throws ServiceException;

    List<ScheduleDTO> searchSchedule(String[] keywords, Integer current, Integer size);
}
