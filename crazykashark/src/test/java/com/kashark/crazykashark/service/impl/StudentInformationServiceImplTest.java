package com.kashark.crazykashark.service.impl;

import com.kashark.crazykashark.entity.StudentInformation;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.service.StudentInformationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
@Slf4j
class StudentInformationServiceImplTest {
    @Autowired
    private StudentInformationService studentInformationService;

    @Test
    void getBriefStudentInformation() {
        log.info(studentInformationService.getBriefStudentInformation(2,5).toString());
    }

    @Test
    void getBriefStudentInformationByConsultation() {
        log.info(studentInformationService.getBriefStudentInformationByConsultation(2022,1,10).toString());
    }

    @Test
    void getStudentInformationById() throws ServiceException {
        log.info(studentInformationService.getStudentInformationById(10).toString());
    }

    @Test
    void getBriefStudentInformationByStudentId() throws ServiceException {
        log.info(studentInformationService.getBriefStudentInformationByStudentId(2023005).toString());
    }

    @Test
    void newStudentInformation() throws ServiceException {
        StudentInformation studentInformation = new StudentInformation();
        studentInformation.setStudentId(5);
        studentInformation.setConsultation(2022);
        studentInformation.setRegistrationTime(new Timestamp(System.currentTimeMillis()));
        studentInformation.setStudentName("李颖");
        studentInformation.setHighSchool("大同二中");
        studentInformation.setMajor("理工");
        studentInformation.setScore(437);
        studentInformationService.newStudentInformation(11, studentInformation);
        log.info("SUCCESS");
    }

    @Test
    void editStudentInformation() throws ServiceException {
        StudentInformation studentInformation = new StudentInformation();
        studentInformation.setId(5);
        studentInformation.setStudentId(2023005);
        studentInformation.setConsultation(2023);
        studentInformation.setStudentName("王卓");
        studentInformation.setHighSchool("大同二中");
        studentInformation.setMajor("理工");
        studentInformation.setScore(500);
        studentInformationService.editStudentInformation(11, studentInformation);
        log.info("SUCCESS");
    }

    @Test
    void deleteStudentInformation() throws ServiceException {
        studentInformationService.deleteStudentInformation(11, 1741639682);
        log.info("SUCCESS");
    }

    @Test
    void searchBriefStudentInformation() {
        log.info(studentInformationService.searchBriefStudentInformation(new String[]{"202300"},1,10).toString());
    }
}