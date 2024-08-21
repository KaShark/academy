package com.kashark.crazykashark.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CoreTeacherMapperTest {
    @Autowired
    private CoreTeacherMapper coreTeacherMapper;

    @Test
    void getCoreTeachers() {
        log.info(coreTeacherMapper.getCoreTeachers(0,10).toString());
    }

    @Test
    void getCoreTeacherById() {
        log.info(coreTeacherMapper.getCoreTeacherById(1).toString());
    }

    @Test
    void getCoreTeacherByStaffId() {
        log.info(coreTeacherMapper.getCoreTeacherByStaffId(1001).toString());
    }

    @Test
    void getCoreTeacherByCoreTeacherId() {
        log.info(coreTeacherMapper.getCoreTeacherByCoreTeacherId(11001).toString());
    }

    @Test
    void searchCoreTeachers() {
        log.info(coreTeacherMapper.searchCoreTeachers(new String[]{"楚"}, 0, 10).toString());
    }
}