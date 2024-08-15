package com.kashark.crazykashark.service;

import com.kashark.crazykashark.dto.BriefStudentInformationDTO;
import com.kashark.crazykashark.dto.StudentInformationDTO;
import com.kashark.crazykashark.exception.ServiceException;

import java.util.List;

/**
 * 学生信息Service
 * @author 赵宇鹏
 * @version 1.0
 */
public interface StudentInformationService {
    List<BriefStudentInformationDTO> getBriefStudentInformation(Integer current, Integer size);

    List<BriefStudentInformationDTO> getBriefStudentInformationByConsultation(Integer consultation, Integer current, Integer size);

    StudentInformationDTO getStudentInformationById(Integer id) throws ServiceException;

    BriefStudentInformationDTO getBriefStudentInformationByStudentId(Integer studentId) throws ServiceException;

    void newStudentInformation(Integer staffId, StudentInformationDTO studentInformationDTO) throws ServiceException;

    void editStudentInformation(Integer staffId, StudentInformationDTO studentInformationDTO) throws ServiceException;

    void deleteStudentInformation(Integer staffId, Integer id) throws ServiceException;

    List<BriefStudentInformationDTO> searchBriefStudentInformation(String[] keywords, Integer current, Integer size);
}
