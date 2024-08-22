package com.kashark.crazykashark.service;

import com.kashark.crazykashark.dto.FiltTeacherDTO;
import com.kashark.crazykashark.exception.ServiceException;

import java.util.List;

/**
 * 筛选老师Service
 * @author 赵宇鹏
 * @version 1.0
 */
public interface FiltTeacherService {
    List<FiltTeacherDTO> getFiltTeachers(Integer current, Integer size);

    FiltTeacherDTO getFiltTeacherById(Integer id) throws ServiceException;

    FiltTeacherDTO getFiltTeacherByStaffId(Integer staffId) throws ServiceException;

    FiltTeacherDTO getFiltTeacherByFiltTeacherId(Integer filtTeacherId) throws ServiceException;

    void newFiltTeacher(Integer staffId, FiltTeacherDTO filtTeacherDTO) throws ServiceException;

    void editFiltTeacher(Integer staffId, FiltTeacherDTO filtTeacherDTO) throws ServiceException;

    void deleteFiltTeacher(Integer staffId, Integer id) throws ServiceException;

    List<FiltTeacherDTO> searchFiltTeachers(String[] keywords, Integer current, Integer size);
}
