package com.kashark.crazykashark.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.kashark.crazykashark.dto.CoreTeacherDTO;
import com.kashark.crazykashark.entity.CoreTeacher;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.mapper.CoreTeacherMapper;
import com.kashark.crazykashark.mapper.StaffMapper;
import com.kashark.crazykashark.service.CoreTeacherService;
import com.kashark.crazykashark.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 核心老师Service
 * @author 赵宇鹏
 * @version 1.0
 */
@Service
@Slf4j
public class CoreTeacherServiceImpl implements CoreTeacherService {
    private final CoreTeacherMapper coreTeacherMapper;

    private final StaffMapper staffMapper;

    public CoreTeacherServiceImpl(CoreTeacherMapper coreTeacherMapper, StaffMapper staffMapper) {
        this.coreTeacherMapper = coreTeacherMapper;
        this.staffMapper = staffMapper;
    }

    @Override
    public List<CoreTeacherDTO> getCoreTeachers(Integer current, Integer size) {
        log.info("获取核心老师：当前页面 {}，页面尺寸 {}", current, size);
        return coreTeacherMapper.getCoreTeachers((current - 1) * size, size);
    }

    @Override
    public CoreTeacherDTO getCoreTeacherById(Integer id) throws ServiceException {
        log.info("通过核心老师ID获取核心老师：核心老师ID {}", id);
        CoreTeacherDTO coreTeacherDTO = coreTeacherMapper.getCoreTeacherById(id);
        if (coreTeacherDTO == null) {
            throw new ServiceException(StatusCode.GET_CORE_TEACHER_FAIL, "无法获取指定的核心老师");
        }
        return coreTeacherDTO;
    }

    @Override
    public CoreTeacherDTO getCoreTeacherByStaffId(Integer staffId) throws ServiceException {
        log.info("通过员工编号获取核心老师：员工编号 {}", staffId);
        CoreTeacherDTO coreTeacherDTO = coreTeacherMapper.getCoreTeacherByStaffId(staffId);
        if (coreTeacherDTO == null) {
            throw new ServiceException(StatusCode.GET_CORE_TEACHER_FAIL, "无法获取指定的核心老师");
        }
        return coreTeacherDTO;
    }

    @Override
    public CoreTeacherDTO getCoreTeacherByCoreTeacherId(Integer coreTeacherId) throws ServiceException {
        log.info("通过核心老师编号获取核心老师：核心老师编号 {}", coreTeacherId);
        CoreTeacherDTO coreTeacherDTO = coreTeacherMapper.getCoreTeacherByCoreTeacherId(coreTeacherId);
        if (coreTeacherDTO == null) {
            throw new ServiceException(StatusCode.GET_CORE_TEACHER_FAIL, "无法获取指定的核心老师");
        }
        return coreTeacherDTO;
    }

    @Override
    public void newCoreTeacher(Integer staffId, CoreTeacherDTO coreTeacherDTO) throws ServiceException {
        log.info("新建核心老师：核心老师 {}", coreTeacherDTO);
        if(staffMapper.getStaffByStaffId(coreTeacherDTO.getStaffId()) == null) {
            throw new ServiceException(StatusCode.NEW_CORE_TEACHER_FAIL, "员工不存在");
        }
        if(coreTeacherMapper.getCoreTeacherByStaffId(coreTeacherDTO.getStaffId()) != null) {
            throw new ServiceException(StatusCode.NEW_CORE_TEACHER_FAIL, "核心老师已存在");
        }
        if(coreTeacherMapper.getCoreTeacherByCoreTeacherId(coreTeacherDTO.getCoreTeacherId()) != null) {
            throw new ServiceException(StatusCode.NEW_CORE_TEACHER_FAIL, "核心老师编号已存在");
        }
        CoreTeacher coreTeacher = new CoreTeacher();
        BeanUtils.copyProperties(coreTeacherDTO, coreTeacher);
        coreTeacher.setCreateTime(new Timestamp(System.currentTimeMillis()));
        coreTeacher.setCreateBy(staffId);
        if (coreTeacherMapper.insert(coreTeacher) <= 0) {
            throw new ServiceException(StatusCode.NEW_CORE_TEACHER_FAIL, "添加核心老师失败");
        }
    }

    @Override
    public void editCoreTeacher(Integer staffId, CoreTeacherDTO coreTeacherDTO) throws ServiceException {
        log.info("修改核心老师：核心老师 {}", coreTeacherDTO);
        if (coreTeacherDTO.getCoreTeacherId()!=null) {
            if(coreTeacherMapper.getCoreTeacherByCoreTeacherId(coreTeacherDTO.getCoreTeacherId()) != null) {
                throw new ServiceException(StatusCode.EDIT_CORE_TEACHER_FAIL, "核心老师编号已存在");
            }
        }
        CoreTeacher coreTeacher = new CoreTeacher();
        BeanUtils.copyProperties(coreTeacherDTO, coreTeacher);
        coreTeacher.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        coreTeacher.setUpdateBy(staffId);
        if (coreTeacherMapper.updateById(coreTeacher) <= 0) {
            throw new ServiceException(StatusCode.EDIT_CORE_TEACHER_FAIL, "修改核心老师失败");
        }
    }

    @Override
    public void deleteCoreTeacher(Integer staffId, Integer id) throws ServiceException {
        log.info("删除核心老师：核心老师ID {}", id);
        LambdaUpdateWrapper<CoreTeacher> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(CoreTeacher::getId, id);
        lambdaUpdateWrapper.set(CoreTeacher::getUpdateTime, new Timestamp(System.currentTimeMillis()));
        lambdaUpdateWrapper.set(CoreTeacher::getUpdateBy, staffId);
        lambdaUpdateWrapper.set(CoreTeacher::getDeleted, 1);
        if (coreTeacherMapper.update(null, lambdaUpdateWrapper) <= 0) {
            throw new ServiceException(StatusCode.DELETE_CORE_TEACHER_FAIL, "删除核心老师失败");
        }
    }

    @Override
    public List<CoreTeacherDTO> searchCoreTeachers(String[] keywords, Integer current, Integer size) {
        log.info("搜索核心老师：关键字 {}，当前页面 {}，页面尺寸 {}", keywords, current, size);
        return coreTeacherMapper.searchCoreTeachers(keywords, (current - 1) * size, size);
    }
}
