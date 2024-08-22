package com.kashark.crazykashark.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.kashark.crazykashark.dto.FiltTeacherDTO;
import com.kashark.crazykashark.entity.FiltTeacher;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.mapper.FiltTeacherMapper;
import com.kashark.crazykashark.mapper.StaffMapper;
import com.kashark.crazykashark.service.FiltTeacherService;
import com.kashark.crazykashark.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 筛选老师Service
 * @author 赵宇鹏
 * @version 1.0
 */
@Service
@Slf4j
public class FiltTeacherServiceImpl implements FiltTeacherService {
    private final FiltTeacherMapper filtTeacherMapper;

    private final StaffMapper staffMapper;

    public FiltTeacherServiceImpl(FiltTeacherMapper filtTeacherMapper, StaffMapper staffMapper) {
        this.filtTeacherMapper = filtTeacherMapper;
        this.staffMapper = staffMapper;
    }

    @Override
    public List<FiltTeacherDTO> getFiltTeachers(Integer current, Integer size) {
        log.info("获取筛选老师：当前页面 {}，页面尺寸 {}", current, size);
        return filtTeacherMapper.getFiltTeachers((current - 1) * size, size);
    }

    @Override
    public FiltTeacherDTO getFiltTeacherById(Integer id) throws ServiceException {
        log.info("通过筛选老师ID获取筛选老师：筛选老师ID {}", id);
        FiltTeacherDTO filtTeacherDTO = filtTeacherMapper.getFiltTeacherById(id);
        if (filtTeacherDTO == null) {
            throw new ServiceException(StatusCode.GET_FILT_TEACHER_FAIL, "无法获取指定的筛选老师");
        }
        return filtTeacherDTO;
    }

    @Override
    public FiltTeacherDTO getFiltTeacherByStaffId(Integer staffId) throws ServiceException {
        log.info("通过员工编号获取筛选老师：员工编号 {}", staffId);
        FiltTeacherDTO filtTeacherDTO = filtTeacherMapper.getFiltTeacherByStaffId(staffId);
        if (filtTeacherDTO == null) {
            throw new ServiceException(StatusCode.GET_FILT_TEACHER_FAIL, "无法获取指定的筛选老师");
        }
        return filtTeacherDTO;
    }

    @Override
    public FiltTeacherDTO getFiltTeacherByFiltTeacherId(Integer filtTeacherId) throws ServiceException {
        log.info("通过筛选老师编号获取筛选老师：筛选老师编号 {}", filtTeacherId);
        FiltTeacherDTO filtTeacherDTO = filtTeacherMapper.getFiltTeacherByFiltTeacherId(filtTeacherId);
        if (filtTeacherDTO == null) {
            throw new ServiceException(StatusCode.GET_FILT_TEACHER_FAIL, "无法获取指定的筛选老师");
        }
        return filtTeacherDTO;
    }

    @Override
    public void newFiltTeacher(Integer staffId, FiltTeacherDTO filtTeacherDTO) throws ServiceException {
        log.info("新建筛选老师：筛选老师 {}", filtTeacherDTO);
        if(staffMapper.getStaffByStaffId(filtTeacherDTO.getStaffId()) == null) {
            throw new ServiceException(StatusCode.NEW_FILT_TEACHER_FAIL, "员工不存在");
        }
        if(filtTeacherMapper.getFiltTeacherByStaffId(filtTeacherDTO.getStaffId()) != null) {
            throw new ServiceException(StatusCode.NEW_FILT_TEACHER_FAIL, "筛选老师已存在");
        }
        if(filtTeacherMapper.getFiltTeacherByFiltTeacherId(filtTeacherDTO.getFiltTeacherId()) != null) {
            throw new ServiceException(StatusCode.NEW_FILT_TEACHER_FAIL, "筛选老师编号已存在");
        }
        FiltTeacher filtTeacher = new FiltTeacher();
        BeanUtils.copyProperties(filtTeacherDTO, filtTeacher);
        filtTeacher.setCreateTime(new Timestamp(System.currentTimeMillis()));
        filtTeacher.setCreateBy(staffId);
        if (filtTeacherMapper.insert(filtTeacher) <= 0) {
            throw new ServiceException(StatusCode.NEW_FILT_TEACHER_FAIL, "添加筛选老师失败");
        }
    }

    @Override
    public void editFiltTeacher(Integer staffId, FiltTeacherDTO filtTeacherDTO) throws ServiceException {
        log.info("修改筛选老师：筛选老师 {}", filtTeacherDTO);
        if (filtTeacherDTO.getFiltTeacherId()!=null) {
            if(filtTeacherMapper.getFiltTeacherByFiltTeacherId(filtTeacherDTO.getFiltTeacherId()) != null) {
                throw new ServiceException(StatusCode.EDIT_FILT_TEACHER_FAIL, "筛选老师编号已存在");
            }
        }
        FiltTeacher filtTeacher = new FiltTeacher();
        BeanUtils.copyProperties(filtTeacherDTO, filtTeacher);
        filtTeacher.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        filtTeacher.setUpdateBy(staffId);
        if (filtTeacherMapper.updateById(filtTeacher) <= 0) {
            throw new ServiceException(StatusCode.EDIT_FILT_TEACHER_FAIL, "修改筛选老师失败");
        }
    }

    @Override
    public void deleteFiltTeacher(Integer staffId, Integer id) throws ServiceException {
        log.info("删除筛选老师：筛选老师ID {}", id);
        LambdaUpdateWrapper<FiltTeacher> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(FiltTeacher::getId, id);
        lambdaUpdateWrapper.set(FiltTeacher::getUpdateTime, new Timestamp(System.currentTimeMillis()));
        lambdaUpdateWrapper.set(FiltTeacher::getUpdateBy, staffId);
        lambdaUpdateWrapper.set(FiltTeacher::getDeleted, 1);
        if (filtTeacherMapper.update(null, lambdaUpdateWrapper) <= 0) {
            throw new ServiceException(StatusCode.DELETE_FILT_TEACHER_FAIL, "删除筛选老师失败");
        }
    }

    @Override
    public List<FiltTeacherDTO> searchFiltTeachers(String[] keywords, Integer current, Integer size) {
        log.info("搜索筛选老师：关键字 {}，当前页面 {}，页面尺寸 {}", keywords, current, size);
        return filtTeacherMapper.searchFiltTeachers(keywords, (current - 1) * size, size);
    }
}
