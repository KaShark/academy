package com.kashark.crazykashark.mapper;

import com.kashark.crazykashark.entity.StudentInformation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StudentInformationMapperTest {
    @Autowired
    private StudentInformationMapper studentInformationMapper;
    @Test
    void newBriefStudentInformation() {
        StudentInformation studentInformation = new StudentInformation();
        studentInformation.setStudentId(1L);
        studentInformation.setRegistrationTime(new Timestamp(System.currentTimeMillis()));
        studentInformation.setStudentName("赵宇鹏");
        studentInformation.setSchool("大同二中");
        studentInformation.setMajor(true);
        studentInformation.setScore(554L);
        studentInformation.setCreateBy(11L);
        studentInformation.setUpdateBy(11L);
        studentInformation.setCreateTime(new Timestamp(System.currentTimeMillis()));
        studentInformation.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        studentInformation.setDeleted(0);
        studentInformationMapper.insert(studentInformation);
    }

    @Test
    void getBriefStudentInformation() {
    }

    @Test
    void getStudentInformationById() {
    }

    @Test
    void getBriefStudentInformationByStudentId() {
    }

    @Test
    void getBriefStudentInformationInAscScore() {
    }

    @Test
    void getBriefStudentInformationInDescScore() {
    }

    @Test
    void searchBriefStudentInformation() {
    }
}