package com.kashark.crazykashark.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class StudentInformationMapperTest {
    @Autowired
    private StudentInformationMapper studentInformationMapper;

    @Test
    void getBriefStudentInformation() {
        log.info(studentInformationMapper.getBriefStudentInformation(0,10).toString());
    }

    @Test
    void getBriefStudentInformationByConsultation() {
        log.info(studentInformationMapper.getBriefStudentInformationByConsultation(2022,0,10).toString());
    }

    @Test
    void getStudentInformationById() {
        log.info(studentInformationMapper.getStudentInformationById(10).toString());
    }

    @Test
    void getBriefStudentInformationByStudentId() {
        log.info(studentInformationMapper.getBriefStudentInformationByStudentId(10).toString());
    }

    @Test
    void searchBriefStudentInformation() {
        log.info(studentInformationMapper.searchBriefStudentInformation(new String[]{"丽"}, 0,10).toString());
    }
}