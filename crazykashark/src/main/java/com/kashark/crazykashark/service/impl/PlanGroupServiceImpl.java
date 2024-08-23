package com.kashark.crazykashark.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.kashark.crazykashark.dto.PlanGroupDTO;
import com.kashark.crazykashark.entity.PlanGroup;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.mapper.CoreTeacherMapper;
import com.kashark.crazykashark.mapper.PlanGroupMapper;
import com.kashark.crazykashark.mapper.StudentInformationMapper;
import com.kashark.crazykashark.service.PlanGroupService;
import com.kashark.crazykashark.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 方案小组Service
 * @author 赵宇鹏
 * @version 1.0
 */
@Service
@Slf4j
public class PlanGroupServiceImpl implements PlanGroupService {
    private final PlanGroupMapper planGroupMapper;

    private final StudentInformationMapper studentInformationMapper;

    private final CoreTeacherMapper coreTeacherMapper;

    public PlanGroupServiceImpl(PlanGroupMapper planGroupMapper, StudentInformationMapper studentInformationMapper, CoreTeacherMapper coreTeacherMapper) {
        this.planGroupMapper = planGroupMapper;
        this.studentInformationMapper = studentInformationMapper;
        this.coreTeacherMapper = coreTeacherMapper;
    }

    @Override
    public List<PlanGroupDTO> getPlanGroupsInRegistrationTimeAsc(Integer current, Integer size) {
        log.info("获取方案小组：咨询年份 所有，核心老师编号 所有，注册时间升序 默认，当前页面 {}，页面尺寸 {}", current, size);
        return planGroupMapper.getPlanGroupsInRegistrationTimeAsc((current - 1) * size, size);
    }

    @Override
    public List<PlanGroupDTO> getPlanGroupsInScoreDesc(Integer current, Integer size) {
        log.info("获取方案小组：咨询年份 所有，核心老师编号 所有，分数降序 默认，当前页面 {}，页面尺寸 {}", current, size);
        return planGroupMapper.getPlanGroupsInScoreDesc((current - 1) * size, size);
    }

    @Override
    public PlanGroupDTO getPlanGroupById(Integer id) throws ServiceException {
        log.info("通过方案小组ID获取方案小组：方案小组ID {}", id);
        PlanGroupDTO planGroupDTO = planGroupMapper.getPlanGroupById(id);
        if (planGroupDTO == null) {
            throw new ServiceException(StatusCode.GET_PLAN_GROUP_FAIL, "无法获取指定的方案小组");
        }
        return planGroupDTO;
    }

    @Override
    public PlanGroupDTO getPlanGroupByStudentId(Integer studentId) throws ServiceException {
        log.info("通过学生编号获取方案小组：学生编号 {}", studentId);
        PlanGroupDTO planGroupDTO = planGroupMapper.getPlanGroupByStudentId(studentId);
        if (planGroupDTO == null) {
            throw new ServiceException(StatusCode.GET_PLAN_GROUP_FAIL, "无法获取指定的方案小组");
        }
        return planGroupDTO;
    }

    @Override
    public List<PlanGroupDTO> getPlanGroupsByConsultationInRegistrationTimeAsc(Integer consultation, Integer current, Integer size) {
        log.info("通过日期获取方案小组：咨询年份 {}，核心老师编号 所有，排序方式 注册时间升序，当前页面 {}，页面尺寸 {}", consultation, current, size);
        return planGroupMapper.getPlanGroupsByConsultationInRegistrationTimeAsc(consultation, (current - 1) * size, size);
    }

    @Override
    public List<PlanGroupDTO> getPlanGroupsByConsultationInScoreDesc(Integer consultation, Integer current, Integer size) {
        log.info("通过日期获取方案小组：咨询年份 {}，核心老师编号 所有，排序方式 分数降序，当前页面 {}，页面尺寸 {}", consultation, current, size);
        return planGroupMapper.getPlanGroupsByConsultationInScoreDesc(consultation, (current - 1) * size, size);
    }

    @Override
    public List<PlanGroupDTO> getPlanGroupsByCoreTeacherIdInRegistrationTimeAsc(Integer coreTeacherId, Integer current, Integer size) {
        log.info("通过日期获取方案小组：咨询年份 所有，核心老师编号 {}，排序方式 注册时间升序，当前页面 {}，页面尺寸 {}", coreTeacherId, current, size);
        return planGroupMapper.getPlanGroupsByCoreTeacherIdInRegistrationTimeAsc(coreTeacherId, (current - 1) * size, size);
    }

    @Override
    public List<PlanGroupDTO> getPlanGroupsByCoreTeacherIdInScoreDesc(Integer coreTeacherId, Integer current, Integer size) {
        log.info("通过日期获取方案小组：咨询年份 所有，核心老师编号 {}，排序方式 分数降序，当前页面 {}，页面尺寸 {}", coreTeacherId, current, size);
        return planGroupMapper.getPlanGroupsByCoreTeacherIdInScoreDesc(coreTeacherId, (current - 1) * size, size);
    }

    @Override
    public List<PlanGroupDTO> getPlanGroupsByConsultationAndCoreTeacherIdInRegistrationTimeAsc(Integer consultation, Integer coreTeacherId, Integer current, Integer size) {
        log.info("通过日期获取方案小组：咨询年份 {}，核心老师编号 {}，排序方式 注册时间升序，当前页面 {}，页面尺寸 {}", consultation, coreTeacherId, current, size);
        return planGroupMapper.getPlanGroupsByConsultationAndCoreTeacherIdInRegistrationTimeAsc(consultation, coreTeacherId, (current - 1) * size, size);
    }

    @Override
    public List<PlanGroupDTO> getPlanGroupsByConsultationAndCoreTeacherIdInScoreDesc(Integer consultation, Integer coreTeacherId, Integer current, Integer size) {
        log.info("通过日期获取方案小组：咨询年份 {}，核心老师编号 {}，排序方式 分数降序，当前页面 {}，页面尺寸 {}", consultation, coreTeacherId, current, size);
        return planGroupMapper.getPlanGroupsByConsultationAndCoreTeacherIdInScoreDesc(consultation, coreTeacherId, (current - 1) * size, size);
    }

    @Override
    public void newPlanGroup(Integer staffId, PlanGroupDTO planGroupDTO) throws ServiceException {
        log.info("新建方案小组：方案小组 {}", planGroupDTO);
        if(studentInformationMapper.getBriefStudentInformationByStudentId(planGroupDTO.getStudentId()) == null) {
            throw new ServiceException(StatusCode.NEW_PLAN_GROUP_FAIL, "学生编号不存在");
        }
        if(coreTeacherMapper.getCoreTeacherByCoreTeacherId(planGroupDTO.getCoreTeacherId()) == null) {
            throw new ServiceException(StatusCode.NEW_PLAN_GROUP_FAIL, "核心老师编号不存在");
        }
        PlanGroup planGroup = new PlanGroup();
        BeanUtils.copyProperties(planGroupDTO, planGroup);
        planGroup.setCreateTime(new Timestamp(System.currentTimeMillis()));
        planGroup.setCreateBy(staffId);
        if (planGroupMapper.insert(planGroup) <= 0) {
            throw new ServiceException(StatusCode.NEW_PLAN_GROUP_FAIL, "添加方案小组失败");
        }
    }

    @Override
    public void editPlanGroup(Integer staffId, PlanGroupDTO planGroupDTO) throws ServiceException {
        log.info("修改方案小组：方案小组 {}", planGroupDTO);
        if (planGroupDTO.getStudentId() != null) {
            if (studentInformationMapper.getBriefStudentInformationByStudentId(planGroupDTO.getStudentId()) == null) {
                throw new ServiceException(StatusCode.EDIT_PLAN_GROUP_FAIL, "学生编号不存在");
            }
        }
        if (planGroupDTO.getCoreTeacherId() != null) {
            if (coreTeacherMapper.getCoreTeacherByCoreTeacherId(planGroupDTO.getCoreTeacherId()) == null) {
                throw new ServiceException(StatusCode.EDIT_PLAN_GROUP_FAIL, "核心老师编号不存在");
            }
            PlanGroup planGroup = new PlanGroup();
            BeanUtils.copyProperties(planGroupDTO, planGroup);
            planGroup.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            planGroup.setUpdateBy(staffId);
            if (planGroupMapper.updateById(planGroup) <= 0) {
                throw new ServiceException(StatusCode.EDIT_PLAN_GROUP_FAIL, "修改方案小组失败");
            }
        }
    }

    @Override
    public void deletePlanGroup(Integer staffId, Integer id) throws ServiceException {
            log.info("删除方案小组：方案小组ID {}", id);
            LambdaUpdateWrapper<PlanGroup> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
            lambdaUpdateWrapper.eq(PlanGroup::getId, id);
            lambdaUpdateWrapper.set(PlanGroup::getUpdateTime, new Timestamp(System.currentTimeMillis()));
            lambdaUpdateWrapper.set(PlanGroup::getUpdateBy, staffId);
            lambdaUpdateWrapper.set(PlanGroup::getDeleted, 1);
            if (planGroupMapper.update(null, lambdaUpdateWrapper) <= 0) {
                throw new ServiceException(StatusCode.DELETE_PLAN_GROUP_FAIL, "删除方案小组失败");
            }
    }

    @Override
    public List<PlanGroupDTO> searchPlanGroups(String[] keywords, Integer current, Integer size) {
        log.info("搜索方案小组：关键字 {}，当前页面 {}，页面尺寸 {}", keywords, current, size);
        return planGroupMapper.searchPlanGroups(keywords, (current - 1) * size, size);
    }
}
