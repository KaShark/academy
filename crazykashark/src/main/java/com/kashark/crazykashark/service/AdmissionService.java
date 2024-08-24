package com.kashark.crazykashark.service;

import com.kashark.crazykashark.dto.AdmissionDTO;
import com.kashark.crazykashark.exception.ServiceException;

import java.util.List;

/**
 * 学生录取情况Service
 * @author 赵宇鹏
 * @version 1.0
 */
public interface AdmissionService {
    List<AdmissionDTO> getAdmission(Integer current, Integer size);

    List<AdmissionDTO> getAdmissionNotNull(Integer current, Integer size);

    AdmissionDTO getAdmissionById(Integer id) throws ServiceException;

    AdmissionDTO getAdmissionByStudentId(Integer studentId) throws ServiceException;

    List<AdmissionDTO> getAdmissionByCoreTeacherId(Integer coreTeacherId, Integer current, Integer size);

    List<AdmissionDTO> getAdmissionNotNullByCoreTeacherId(Integer coreTeacherId, Integer current, Integer size);

    void newAdmission(Integer staffId, AdmissionDTO admissionDTO) throws ServiceException;

    void editAdmission(Integer staffId, AdmissionDTO admissionDTO) throws ServiceException;

    void deleteAdmission(Integer staffId, Integer id) throws ServiceException;

    List<AdmissionDTO> searchAdmission(String[] keywords, Integer current, Integer size);
}
