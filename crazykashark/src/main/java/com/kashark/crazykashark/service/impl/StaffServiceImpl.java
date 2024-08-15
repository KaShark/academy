package com.kashark.crazykashark.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.kashark.crazykashark.dto.StaffDTO;
import com.kashark.crazykashark.entity.Staff;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.mapper.StaffMapper;
import com.kashark.crazykashark.service.StaffService;
import com.kashark.crazykashark.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
/**
 * 员工信息Service
 * @author 赵宇鹏
 * @version 1.0
 */
@Service
@Slf4j
public class StaffServiceImpl implements StaffService {
    private final StaffMapper staffMapper;

    public StaffServiceImpl(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    @Override
    public List<StaffDTO> getStaff(Integer current, Integer size) {
        log.info("获取员工信息：咨询年份 所有，当前页面 {}，页面尺寸 {}", current, size);
        return staffMapper.getStaff((current - 1) * size, size);

    }

    @Override
    public StaffDTO getStaffById(Integer id) throws ServiceException {
        log.info("通过员工信息ID获取员工信息：员工信息ID {}", id);
        StaffDTO staffDTO = staffMapper.getStaffById(id);
        if (staffDTO == null) {
            throw new ServiceException(StatusCode.GET_STAFF_FAIL, "无法获取指定的员工信息");
        }
        return staffDTO;
    }

    @Override
    public StaffDTO getStaffByStaffId(Integer staffId) throws ServiceException {
        log.info("通过员工编号获取员工信息：员工编号 {}", staffId);
        StaffDTO staffDTO = staffMapper.getStaffByStaffId(staffId);
        if (staffDTO == null) {
            throw new ServiceException(StatusCode.GET_STAFF_FAIL, "无法获取指定的员工信息");
        }
        return staffDTO;
    }

    @Override
    public void newStaff(StaffDTO staffDTO) throws ServiceException {
        log.info("新建员工信息：员工信息 {}", staffDTO);
        if(staffMapper.getStaffByStaffId(staffDTO.getStaffId()) != null) {
            throw new ServiceException(StatusCode.NEW_STAFF_FAIL, "员工编号已存在");
        }
        Staff staff = new Staff();
        BeanUtils.copyProperties(staffDTO, staff);
        staff.setCreateTime(new Timestamp(System.currentTimeMillis()));
        if (staffMapper.insert(staff) <= 0) {
            throw new ServiceException(StatusCode.NEW_STAFF_FAIL, "添加员工信息失败");
        }
    }

    @Override
    public void editStaff(StaffDTO staffDTO) throws ServiceException {
        log.info("修改员工信息：员工信息 {}", staffDTO);
        if(staffMapper.getStaffByStaffId(staffDTO.getStaffId()) != null) {
            throw new ServiceException(StatusCode.EDIT_STAFF_FAIL, "员工编号已存在");
        }
        Staff staff = new Staff();
        BeanUtils.copyProperties(staffDTO, staff);
        staff.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        if (staffMapper.updateById(staff) <= 0) {
            throw new ServiceException(StatusCode.EDIT_STAFF_FAIL, "修改员工信息失败");
        }
    }

    @Override
    public void deleteStaff(Integer id) throws ServiceException {
        log.info("删除员工信息：员工信息ID {}", id);
        LambdaUpdateWrapper<Staff> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(Staff::getId, id);
        lambdaUpdateWrapper.set(Staff::getUpdateTime, new Timestamp(System.currentTimeMillis()));
        lambdaUpdateWrapper.set(Staff::getDeleted, 1);
        if (staffMapper.update(null, lambdaUpdateWrapper) <= 0) {
            throw new ServiceException(StatusCode.DELETE_STUDENT_INFORMATION_FAIL, "删除员工信息失败");
        }
    }

    @Override
    public List<StaffDTO> searchStaff(String[] keywords, Integer current, Integer size) {
        log.info("搜索员工信息：关键字 {}，当前页面 {}，页面尺寸 {}", keywords, current, size);
        return staffMapper.searchStaff(keywords, (current - 1) * size, size);
    }
}
