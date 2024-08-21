package com.kashark.crazykashark.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CoreTeacherServiceImplTest {
    @Autowired
    private CoreTeacherServiceImpl coreTeacherService;

    @Test
    void getCoreTeachers() {
        log.info(coreTeacherService.getCoreTeachers(1, 10).toString());
    }

    @Test
    void getCoreTeacherById() {
    }

    @Test
    void getCoreTeacherByStaffId() {
    }

    @Test
    void getCoreTeacherByCoreTeacherId() {
    }

    @Test
    void newCoreTeacher() {
    }

    @Test
    void editCoreTeacher() {
    }

    @Test
    void deleteCoreTeacher() {
    }

    @Test
    void searchCoreTeachers() {
    }
}