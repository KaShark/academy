package com.kashark.crazykashark.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.kashark.crazykashark.dto.ScheduleDTO;
import com.kashark.crazykashark.entity.Schedule;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.mapper.ScheduleMapper;
import com.kashark.crazykashark.mapper.StudentInformationMapper;
import com.kashark.crazykashark.service.ScheduleService;
import com.kashark.crazykashark.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

/**
 * 时间表Service
 * @author 赵宇鹏
 * @version 1.0
 */
@Service
@Slf4j
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleMapper scheduleMapper;

    private final StudentInformationMapper studentInformationMapper;

    public ScheduleServiceImpl(ScheduleMapper scheduleMapper, StudentInformationMapper studentInformationMapper) {
        this.scheduleMapper = scheduleMapper;
        this.studentInformationMapper = studentInformationMapper;
    }
    
    @Override
    public List<ScheduleDTO> getSchedules(Integer current, Integer size) {
        log.info("获取时间表：当前页面 {}，页面尺寸 {}", current, size);
        return scheduleMapper.getSchedules((current - 1) * size, size);
    }

    @Override
    public ScheduleDTO getScheduleById(Integer id) throws ServiceException {
        log.info("通过时间表ID获取时间表：时间表ID {}", id);
        ScheduleDTO scheduleDTO = scheduleMapper.getScheduleById(id);
        if (scheduleDTO == null) {
            throw new ServiceException(StatusCode.GET_SCHEDULE_FAIL, "无法获取指定的时间表");
        }
        return scheduleDTO;
    }

    @Override
    public List<ScheduleDTO> getSchedulesByStudentId(Integer studentId, Integer current, Integer size) {
        log.info("通过学生编号获取时间表：学生编号 {}", studentId);
        return scheduleMapper.getSchedulesByStudentId(studentId, (current - 1) * size, size);
    }

    @Override
    public List<ScheduleDTO> getSchedulesByTime(LocalDate date, Integer current, Integer size) {
        log.info("通过日期获取时间表：时间 {}", date);
        return scheduleMapper.getSchedulesByTime(Timestamp.valueOf(date.atStartOfDay()), Timestamp.valueOf(date.plusDays(1).atStartOfDay()), (current - 1) * size, size);
    }

    @Override
    public List<ScheduleDTO> getSchedulesByCoreTeacherId(Integer coreTeacherId, Integer current, Integer size) {
        log.info("通过核心老师编号获取时间表：核心老师编号 {}", coreTeacherId);
        return scheduleMapper.getSchedulesByCoreTeacherId(coreTeacherId, (current - 1) * size, size);
    }

    @Override
    public List<ScheduleDTO> getSchedulesByType(String type, Integer current, Integer size) {
        log.info("通过安排种类获取时间表：安排种类 {}", type);
        return scheduleMapper.getSchedulesByType(type, (current - 1) * size, size);
    }

    @Override
    public List<ScheduleDTO> getSchedulesByCoreTeacherIdAndType(Integer coreTeacherId, String type, Integer current, Integer size) {
        log.info("通过核心老师编号和安排种类获取时间表：核心老师编号 {}，安排种类 {}", coreTeacherId ,type);
        return scheduleMapper.getSchedulesByCoreTeacherIdAndType(coreTeacherId, type, (current - 1) * size, size);
    }

    @Override
    public List<ScheduleDTO> getSchedulesByTimeAndCoreTeacherId(LocalDate date, Integer coreTeacherId, Integer current, Integer size) {
        log.info("通过时间和核心老师编号获取时间表：时间 {}，核心老师编号 {}", date, coreTeacherId);
        return scheduleMapper.getSchedulesByTimeAndCoreTeacherId(Timestamp.valueOf(date.atStartOfDay()), Timestamp.valueOf(date.plusDays(1).atStartOfDay()), coreTeacherId, (current - 1) * size, size);
    }

    @Override
    public List<ScheduleDTO> getSchedulesByTimeAndType(LocalDate date, String type, Integer current, Integer size) {
        log.info("通过时间和安排种类获取时间表：时间 {}，安排种类 {}", date, type);
        return scheduleMapper.getSchedulesByTimeAndType(Timestamp.valueOf(date.atStartOfDay()), Timestamp.valueOf(date.plusDays(1).atStartOfDay()), type, (current - 1) * size, size);
    }

    @Override
    public List<ScheduleDTO> getSchedulesByTimeAndCoreTeacherIdAndType(LocalDate date, Integer coreTeacherId, String type, Integer current, Integer size) {
        log.info("通过时间、核心老师编号和安排种类获取时间表：时间 {}，核心老师编号 {}，安排种类 {}", date, coreTeacherId, type);
        return scheduleMapper.getSchedulesByTimeAndCoreTeacherIdAndType(Timestamp.valueOf(date.atStartOfDay()), Timestamp.valueOf(date.plusDays(1).atStartOfDay()), coreTeacherId, type, (current - 1) * size, size);
    }

    @Override
    public void newSchedule(Integer staffId, ScheduleDTO scheduleDTO) throws ServiceException {
        log.info("新建时间表：时间表 {}", scheduleDTO);
        if(studentInformationMapper.getBriefStudentInformationByStudentId(scheduleDTO.getStudentId()) == null) {
            throw new ServiceException(StatusCode.NEW_SCHEDULE_FAIL, "学生编号不存在");
        }
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule);
        schedule.setCreateTime(new Timestamp(System.currentTimeMillis()));
        schedule.setCreateBy(staffId);
        if (scheduleMapper.insert(schedule) <= 0) {
            throw new ServiceException(StatusCode.NEW_SCHEDULE_FAIL, "添加时间表失败");
        }
    }

    @Override
    public void editSchedule(Integer staffId, ScheduleDTO scheduleDTO) throws ServiceException {
        log.info("修改时间表：时间表 {}", scheduleDTO);
        if (scheduleDTO.getStudentId()!=null) {
            if(studentInformationMapper.getBriefStudentInformationByStudentId(scheduleDTO.getStudentId()) == null) {
                throw new ServiceException(StatusCode.EDIT_SCHEDULE_FAIL, "学生编号不存在");
            }
        }
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule);
        schedule.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        schedule.setUpdateBy(staffId);
        if (scheduleMapper.updateById(schedule) <= 0) {
            throw new ServiceException(StatusCode.EDIT_SCHEDULE_FAIL, "修改时间表失败");
        }
    }

    @Override
    public void deleteSchedule(Integer staffId, Integer id) throws ServiceException {
        log.info("删除时间表：时间表ID {}", id);
        LambdaUpdateWrapper<Schedule> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(Schedule::getId, id);
        lambdaUpdateWrapper.set(Schedule::getUpdateTime, new Timestamp(System.currentTimeMillis()));
        lambdaUpdateWrapper.set(Schedule::getUpdateBy, staffId);
        lambdaUpdateWrapper.set(Schedule::getDeleted, 1);
        if (scheduleMapper.update(null, lambdaUpdateWrapper) <= 0) {
            throw new ServiceException(StatusCode.DELETE_SCHEDULE_FAIL, "删除时间表失败");
        }
    }

    @Override
    public List<ScheduleDTO> searchSchedule(String[] keywords, Integer current, Integer size) {
        log.info("搜索时间表：关键字 {}，当前页面 {}，页面尺寸 {}", keywords, current, size);
        return scheduleMapper.searchSchedules(keywords, (current - 1) * size, size);
    }
}
