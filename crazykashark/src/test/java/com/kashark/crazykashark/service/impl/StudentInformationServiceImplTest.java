package com.kashark.crazykashark.service.impl;

import com.kashark.crazykashark.dto.BriefStudentInformationDTO;
import com.kashark.crazykashark.dto.StudentInformationDTO;
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
        StudentInformationDTO studentInformationDTO = new StudentInformationDTO();
        studentInformationDTO.setStudentId(5);
        studentInformationDTO.setConsultation(2022);
        studentInformationDTO.setRegistrationTime(new Timestamp(System.currentTimeMillis()));
        studentInformationDTO.setStudentName("李颖");
        studentInformationDTO.setHighSchool("大同二中");
        studentInformationDTO.setMajor("理工");
        studentInformationDTO.setScore(437);
        studentInformationService.newStudentInformation(11, studentInformationDTO);
        log.info("SUCCESS");
    }

    @Test
    void editStudentInformation() throws ServiceException {
        StudentInformationDTO studentInformationDTO = new StudentInformationDTO();
        studentInformationDTO.setId(5);
        studentInformationDTO.setStudentId(2023005);
        studentInformationDTO.setConsultation(2023);
        studentInformationDTO.setStudentName("王卓");
        studentInformationDTO.setHighSchool("大同二中");
        studentInformationDTO.setMajor("理工");
        studentInformationDTO.setScore(500);
        studentInformationService.editStudentInformation(11, studentInformationDTO);
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