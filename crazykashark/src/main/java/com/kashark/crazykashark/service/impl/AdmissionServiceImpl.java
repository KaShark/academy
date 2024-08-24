package com.kashark.crazykashark.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.kashark.crazykashark.dto.AdmissionDTO;
import com.kashark.crazykashark.entity.Admission;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.mapper.AdmissionMapper;
import com.kashark.crazykashark.mapper.StudentInformationMapper;
import com.kashark.crazykashark.service.AdmissionService;
import com.kashark.crazykashark.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 学生录取情况Service
 * @author 赵宇鹏
 * @version 1.0
 */
@Service
@Slf4j
public class AdmissionServiceImpl implements AdmissionService {
    private final AdmissionMapper admissionMapper;

    private final StudentInformationMapper studentInformationMapper;

    public AdmissionServiceImpl(AdmissionMapper admissionMapper, StudentInformationMapper studentInformationMapper) {
        this.admissionMapper = admissionMapper;
        this.studentInformationMapper = studentInformationMapper;
    }

    @Override
    public List<AdmissionDTO> getAdmission(Integer current, Integer size) {
        log.info("获取学生录取情况：核心老师编号 所有，当前页面 {}，页面尺寸 {}", current, size);
        return admissionMapper.getAdmission((current - 1) * size, size);
    }

    @Override
    public List<AdmissionDTO> getAdmissionNotNull(Integer current, Integer size) {
        log.info("获取不为空的学生录取情况：核心老师编号 所有，当前页面 {}，页面尺寸 {}", current, size);
        return admissionMapper.getAdmissionNotNull((current - 1) * size, size);
    }

    @Override
    public AdmissionDTO getAdmissionById(Integer id) throws ServiceException {
        log.info("通过学生录取情况ID获取学生录取情况：学生录取情况ID {}", id);
        AdmissionDTO admissionDTO = admissionMapper.getAdmissionById(id);
        if (admissionDTO == null) {
            throw new ServiceException(StatusCode.GET_ADMISSION_FAIL, "无法获取指定的学生录取情况");
        }
        return admissionDTO;
    }

    @Override
    public AdmissionDTO getAdmissionByStudentId(Integer studentId) throws ServiceException {
        log.info("通过学生编号获取学生录取情况：学生编号 {}", studentId);
        AdmissionDTO admissionDTO = admissionMapper.getAdmissionByStudentId(studentId);
        if (admissionDTO == null) {
            throw new ServiceException(StatusCode.GET_ADMISSION_FAIL, "无法获取指定的学生录取情况");
        }
        return admissionDTO;
    }

    @Override
    public List<AdmissionDTO> getAdmissionByCoreTeacherId(Integer coreTeacherId, Integer current, Integer size) {
        log.info("通过核心老师编号获取学生录取情况：核心老师编号 {}，当前页面 {}，页面尺寸 {}", coreTeacherId, current, size);
        return admissionMapper.getAdmissionByCoreTeacherId(coreTeacherId, (current - 1) * size, size);
    }

    @Override
    public List<AdmissionDTO> getAdmissionNotNullByCoreTeacherId(Integer coreTeacherId, Integer current, Integer size) {
        log.info("通过核心老师编号获取不为空的学生录取情况：核心老师编号 {}，当前页面 {}，页面尺寸 {}", coreTeacherId, current, size);
        return admissionMapper.getAdmissionNotNullByCoreTeacherId(coreTeacherId, (current - 1) * size, size);
    }

    @Override
    public void newAdmission(Integer staffId, AdmissionDTO admissionDTO) throws ServiceException {
        log.info("新建学生录取情况：学生录取情况 {}", admissionDTO);
        if(studentInformationMapper.getBriefStudentInformationByStudentId(admissionDTO.getStudentId()) == null) {
            throw new ServiceException(StatusCode.NEW_ADMISSION_FAIL, "学生编号不存在");
        }
        Admission admission = new Admission();
        BeanUtils.copyProperties(admissionDTO, admission);
        admission.setCreateTime(new Timestamp(System.currentTimeMillis()));
        admission.setCreateBy(staffId);
        if (admissionMapper.insert(admission) <= 0) {
            throw new ServiceException(StatusCode.NEW_ADMISSION_FAIL, "添加学生录取情况失败");
        }
    }

    @Override
    public void editAdmission(Integer staffId, AdmissionDTO admissionDTO) throws ServiceException {
        log.info("修改学生录取情况：学生录取情况 {}", admissionDTO);
        if (admissionDTO.getStudentId()!=null) {
            if(studentInformationMapper.getBriefStudentInformationByStudentId(admissionDTO.getStudentId()) == null) {
                throw new ServiceException(StatusCode.EDIT_SCHEDULE_FAIL, "学生编号不存在");
            }
        }
        Admission admission = new Admission();
        BeanUtils.copyProperties(admissionDTO, admission);
        admission.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        admission.setUpdateBy(staffId);
        if (admissionMapper.updateById(admission) <= 0) {
            throw new ServiceException(StatusCode.EDIT_ADMISSION_FAIL, "修改学生录取情况失败");
        }
    }

    @Override
    public void deleteAdmission(Integer staffId, Integer id) throws ServiceException {
        log.info("删除学生录取情况：学生录取情况ID {}", id);
        LambdaUpdateWrapper<Admission> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(Admission::getId, id);
        lambdaUpdateWrapper.set(Admission::getUpdateTime, new Timestamp(System.currentTimeMillis()));
        lambdaUpdateWrapper.set(Admission::getUpdateBy, staffId);
        lambdaUpdateWrapper.set(Admission::getDeleted, 1);
        if (admissionMapper.update(null, lambdaUpdateWrapper) <= 0) {
            throw new ServiceException(StatusCode.DELETE_ADMISSION_FAIL, "删除学生录取情况失败");
        }
    }

    @Override
    public List<AdmissionDTO> searchAdmission(String[] keywords, Integer current, Integer size) {
        log.info("搜索学生录取情况：关键字 {}，当前页面 {}，页面尺寸 {}", keywords, current, size);
        return admissionMapper.searchAdmission(keywords, (current - 1) * size, size);
    }
}
