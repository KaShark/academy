package com.kashark.crazykashark.service;

import com.kashark.crazykashark.entity.StudentInformation;
import com.kashark.crazykashark.exception.ServiceException;

import java.util.List;

/**
 * 学生信息Service
 * @author 赵宇鹏
 * @version 1.0
 */
public interface StudentInformationService {
    List<StudentInformation> getBriefStudentInformation(Integer current, Integer size);

    List<StudentInformation> getBriefStudentInformationByConsultation(Integer consultation, Integer current, Integer size);

    StudentInformation getStudentInformationById(Integer id) throws ServiceException;

    StudentInformation getBriefStudentInformationByStudentId(Integer studentId) throws ServiceException;

    void newStudentInformation(Integer staffId, StudentInformation studentInformation) throws ServiceException;

    void editStudentInformation(Integer staffId, StudentInformation studentInformation) throws ServiceException;

    void deleteStudentInformation(Integer staffId, Integer id) throws ServiceException;

    List<StudentInformation> searchBriefStudentInformation(String[] keywords, Integer current, Integer size);
}
