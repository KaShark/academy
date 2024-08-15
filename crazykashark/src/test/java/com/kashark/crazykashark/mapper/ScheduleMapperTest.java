package com.kashark.crazykashark.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDate;

@SpringBootTest
@Slf4j
class ScheduleMapperTest {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Test
    void getSchedule() {
        log.info(scheduleMapper.getSchedules(0, 10).toString());
    }

    @Test
    void getScheduleById() {
        log.info(scheduleMapper.getScheduleById(2).toString());
    }

    @Test
    void getScheduleByStudentId() {
        log.info(scheduleMapper.getSchedulesByStudentId(2024001, 1, 10).toString());
    }

    @Test
    void getScheduleByCoreTeacherId() {
        log.info(scheduleMapper.getSchedulesByCoreTeacherId(11001, 1, 10).toString());
    }

    @Test
    void getScheduleByType() {
        log.info(scheduleMapper.getSchedulesByType("筛选", 1, 10).toString());
    }
    @Test
    void getScheduleByCoreTeacherIdAndType() {
        log.info(scheduleMapper.getSchedulesByCoreTeacherIdAndType(11001, "筛选", 1, 10).toString());
    }

    @Test
    void getScheduleByTimeAndCoreTeacherId() {
        LocalDate date = LocalDate.of(2024, 8, 14);
        log.info(scheduleMapper.getSchedulesByTimeAndCoreTeacherId(Timestamp.valueOf(date.atStartOfDay()), Timestamp.valueOf(date.plusDays(1).atStartOfDay()), 11002, 1, 10).toString());
    }
    @Test
    void getScheduleByTimeAndType() {
        LocalDate date = LocalDate.of(2024, 8, 14);
        log.info(scheduleMapper.getSchedulesByTimeAndType(Timestamp.valueOf(date.atStartOfDay()), Timestamp.valueOf(date.plusDays(1).atStartOfDay()), "筛选", 1, 10).toString());
    }

    @Test
    void getScheduleByTimeAndCoreTeacherIdAndType() {
        LocalDate date = LocalDate.of(2024, 8, 14);
        log.info(scheduleMapper.getSchedulesByTimeAndCoreTeacherIdAndType(Timestamp.valueOf(date.atStartOfDay()), Timestamp.valueOf(date.plusDays(1).atStartOfDay()), 11001, "筛选", 1, 10).toString());
    }

    @Test
    void searchSchedule() {
        log.info(scheduleMapper.searchSchedules(new String[]{"文"}, 0, 5).toString());
    }
}