package com.kashark.crazykashark.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.kashark.crazykashark.entity.StudentInformation;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.mapper.StudentInformationMapper;
import com.kashark.crazykashark.service.StudentInformationService;
import com.kashark.crazykashark.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 学生信息Service
 * @author 赵宇鹏
 * @version 1.0
 */
@Service
@Slf4j
public class StudentInformationServiceImpl implements StudentInformationService {
    private final StudentInformationMapper studentInformationMapper;

    public StudentInformationServiceImpl(StudentInformationMapper studentInformationMapper) {
        this.studentInformationMapper = studentInformationMapper;
    }

    @Override
    public List<StudentInformation> getBriefStudentInformation(Integer current, Integer size) {
        log.info("获取学生信息：咨询年份 所有，当前页面 {}，页面尺寸 {}", current, size);
        return studentInformationMapper.getBriefStudentInformation((current - 1) * size, size);
    }

    @Override
    public List<StudentInformation> getBriefStudentInformationByConsultation(Integer consultation, Integer current, Integer size) {
        log.info("获取学生信息：咨询年份 {}，当前页面 {}，页面尺寸 {}", consultation, current, size);
        return studentInformationMapper.getBriefStudentInformationByConsultation(consultation, (current - 1) * size, size);
    }

    @Override
    public StudentInformation getStudentInformationById(Integer id) throws ServiceException {
        log.info("通过学生信息ID获取学生信息：学生信息ID {}", id);
        StudentInformation studentInformation = studentInformationMapper.getStudentInformationById(id);
        if (studentInformation == null) {
            throw new ServiceException(StatusCode.GET_STUDENT_INFORMATION_FAIL, "无法获取指定的学生信息");
        }
        return studentInformation;
    }

    @Override
    public StudentInformation getBriefStudentInformationByStudentId(Integer studentId) throws ServiceException {
        log.info("通过学生编号获取学生信息：学生编号 {}", studentId);
        StudentInformation studentInformation = studentInformationMapper.getBriefStudentInformationByStudentId(studentId);
        if (studentInformation == null) {
            throw new ServiceException(StatusCode.GET_STUDENT_INFORMATION_FAIL, "无法获取指定的学生信息");
        }
        return studentInformation;
    }

    @Override
    public void newStudentInformation(Integer staffId, StudentInformation studentInformation) throws ServiceException {
        log.info("新建学生信息：学生信息 {}", studentInformation);
        if(studentInformationMapper.getBriefStudentInformationByStudentId(studentInformation.getStudentId()) != null) {
            throw new ServiceException(StatusCode.NEW_STUDENT_INFORMATION_FAIL, "学生编号已存在");
        }
        studentInformation.setCreateTime(new Timestamp(System.currentTimeMillis()));
        studentInformation.setCreateBy(staffId);
        if (studentInformationMapper.insert(studentInformation) <= 0) {
            throw new ServiceException(StatusCode.NEW_STUDENT_INFORMATION_FAIL, "添加学生信息失败");
        }
    }

    @Override
    public void editStudentInformation(Integer staffId, StudentInformation studentInformation) throws ServiceException {
        log.info("修改学生信息：学生信息 {}", studentInformation);
        if(studentInformationMapper.getBriefStudentInformationByStudentId(studentInformation.getStudentId()) != null) {
            throw new ServiceException(StatusCode.NEW_STUDENT_INFORMATION_FAIL, "学生编号已存在");
        }
        studentInformation.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        studentInformation.setUpdateBy(staffId);
        if (studentInformationMapper.updateById(studentInformation) <= 0) {
            throw new ServiceException(StatusCode.EDIT_STUDENT_INFORMATION_FAIL, "修改学生信息失败");
        }
    }

    @Override
    public void deleteStudentInformation(Integer staffId, Integer id) throws ServiceException {
        log.info("删除学生信息：学生信息ID {}", id);
        LambdaUpdateWrapper<StudentInformation> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(StudentInformation::getId, id);
        lambdaUpdateWrapper.set(StudentInformation::getUpdateTime, new Timestamp(System.currentTimeMillis()));
        lambdaUpdateWrapper.set(StudentInformation::getUpdateBy, staffId);
        lambdaUpdateWrapper.set(StudentInformation::getDeleted, 1);
        if (studentInformationMapper.update(null, lambdaUpdateWrapper) <= 0) {
            throw new ServiceException(StatusCode.DELETE_STUDENT_INFORMATION_FAIL, "删除学生信息失败");
        }
    }

    @Override
    public List<StudentInformation> searchBriefStudentInformation(String[] keywords, Integer current, Integer size) {
        log.info("搜索学生信息：关键字 {}，当前页面 {}，页面尺寸 {}", keywords, current, size);
        return studentInformationMapper.searchBriefStudentInformation(keywords, (current - 1) * size, size);
    }
}
