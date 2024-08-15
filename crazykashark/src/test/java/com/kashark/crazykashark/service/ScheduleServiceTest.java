package com.kashark.crazykashark.service;

import com.kashark.crazykashark.dto.ScheduleDTO;
import com.kashark.crazykashark.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDate;

@SpringBootTest
@Slf4j
class ScheduleServiceTest {
    @Autowired
    private ScheduleService scheduleService;

    @Test
    void getSchedules() {
        log.info(scheduleService.getSchedules(1,5).toString());
    }

    @Test
    void getScheduleById() throws ServiceException {
        log.info(scheduleService.getScheduleById(3).toString());
    }

    @Test
    void getSchedulesByStudentId() {
        log.info(scheduleService.getSchedulesByStudentId(2024002, 1, 5).toString());
    }

    @Test
    void getSchedulesByCoreTeacherId() {
        log.info(scheduleService.getSchedulesByCoreTeacherId(11001, 1, 5).toString());
    }

    @Test
    void getSchedulesByType() {
        log.info(scheduleService.getSchedulesByType("筛选", 1, 5).toString());
    }

    @Test
    void getSchedulesByCoreTeacherIdAndType() {
        log.info(scheduleService.getSchedulesByCoreTeacherIdAndType(11002, "筛选", 1, 5).toString());
    }

    @Test
    void getSchedulesByTimeAndCoreTeacherId() {
        LocalDate date = LocalDate.of(2024, 8, 14);
        log.info(scheduleService.getSchedulesByTimeAndCoreTeacherId(date,11001, 1, 5).toString());
    }

    @Test
    void getSchedulesByTimeAndType() {
        LocalDate date = LocalDate.of(2024, 8, 14);
        log.info(scheduleService.getSchedulesByTimeAndType(date,"筛选", 1, 5).toString());
    }

    @Test
    void getSchedulesByTimeAndCoreTeacherIdAndType() {
        LocalDate date = LocalDate.of(2024, 8, 14);
        log.info(scheduleService.getSchedulesByTimeAndCoreTeacherIdAndType(date, 11002, "筛选", 1, 5).toString());
    }

    @Test
    void newSchedule() throws ServiceException {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setStudentId(2024002);
        scheduleDTO.setStudentName("沈天丽");
        scheduleDTO.setTime(new Timestamp(System.currentTimeMillis()));
        scheduleDTO.setType("方案");
        scheduleService.newSchedule(11, scheduleDTO);
        log.info("SUCCESS");
    }

    @Test
    void editSchedule() {
    }

    @Test
    void deleteSchedule() {
    }

    @Test
    void searchSchedule() {
    }
}