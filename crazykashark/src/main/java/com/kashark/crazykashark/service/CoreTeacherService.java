package com.kashark.crazykashark.service;

import com.kashark.crazykashark.dto.CoreTeacherDTO;
import com.kashark.crazykashark.exception.ServiceException;

import java.util.List;

/**
 * 核心老师Service
 * @author 赵宇鹏
 * @version 1.0
 */
public interface CoreTeacherService {
    List<CoreTeacherDTO> getCoreTeachers(Integer current, Integer size);

    CoreTeacherDTO getCoreTeacherById(Integer id) throws ServiceException;

    CoreTeacherDTO getCoreTeacherByStaffId(Integer staffId) throws ServiceException;

    CoreTeacherDTO getCoreTeacherByCoreTeacherId(Integer coreTeacherId) throws ServiceException;

    void newCoreTeacher(Integer staffId, CoreTeacherDTO coreTeacherDTO) throws ServiceException;

    void editCoreTeacher(Integer staffId, CoreTeacherDTO coreTeacherDTO) throws ServiceException;

    void deleteCoreTeacher(Integer staffId, Integer id) throws ServiceException;

    List<CoreTeacherDTO> searchCoreTeachers(String[] keywords, Integer current, Integer size);
}
