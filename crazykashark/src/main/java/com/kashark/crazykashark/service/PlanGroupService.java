package com.kashark.crazykashark.service;

import com.kashark.crazykashark.dto.PlanGroupDTO;
import com.kashark.crazykashark.exception.ServiceException;

import java.util.List;

/**
 * 方案小组Service
 * @author 赵宇鹏
 * @version 1.0
 */
public interface PlanGroupService {
    List<PlanGroupDTO> getPlanGroupsInRegistrationTimeAsc(Integer current, Integer size);

    List<PlanGroupDTO> getPlanGroupsInScoreDesc(Integer current, Integer size);

    PlanGroupDTO getPlanGroupById(Integer id) throws ServiceException;

    PlanGroupDTO getPlanGroupByStudentId(Integer studentId) throws ServiceException;

    List<PlanGroupDTO> getPlanGroupsByConsultationInRegistrationTimeAsc(Integer consultation, Integer current, Integer size);

    List<PlanGroupDTO> getPlanGroupsByConsultationInScoreDesc(Integer consultation, Integer current, Integer size);

    List<PlanGroupDTO> getPlanGroupsByCoreTeacherIdInRegistrationTimeAsc(Integer coreTeacherId, Integer current, Integer size);

    List<PlanGroupDTO> getPlanGroupsByCoreTeacherIdInScoreDesc(Integer coreTeacherId, Integer current, Integer size);

    List<PlanGroupDTO> getPlanGroupsByConsultationAndCoreTeacherIdInRegistrationTimeAsc(Integer consultation, Integer coreTeacherId, Integer current, Integer size);

    List<PlanGroupDTO> getPlanGroupsByConsultationAndCoreTeacherIdInScoreDesc(Integer consultation, Integer coreTeacherId, Integer current, Integer size);

    void newPlanGroup(Integer staffId, PlanGroupDTO planGroupDTO) throws ServiceException;

    void editPlanGroup(Integer staffId, PlanGroupDTO planGroupDTO) throws ServiceException;

    void deletePlanGroup(Integer staffId, Integer id) throws ServiceException;

    List<PlanGroupDTO> searchPlanGroups(String[] keywords, Integer current, Integer size);
}
