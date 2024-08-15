package com.kashark.crazykashark.service;

import com.kashark.crazykashark.dto.StaffDTO;
import com.kashark.crazykashark.exception.ServiceException;

import java.util.List;

/**
 * 员工信息Service
 * @author 赵宇鹏
 * @version 1.0
 */
public interface StaffService {
    List<StaffDTO> getStaff(Integer current, Integer size);

    StaffDTO getStaffById(Integer id) throws ServiceException;

    StaffDTO getStaffByStaffId(Integer staffId) throws ServiceException;

    void newStaff(StaffDTO staffDTO) throws ServiceException;

    void editStaff(StaffDTO staffDTO) throws ServiceException;

    void deleteStaff(Integer id) throws ServiceException;

    List<StaffDTO> searchStaff(String[] keywords, Integer current, Integer size);
}
