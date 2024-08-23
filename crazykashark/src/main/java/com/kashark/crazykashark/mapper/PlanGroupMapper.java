package com.kashark.crazykashark.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kashark.crazykashark.dto.PlanGroupDTO;
import com.kashark.crazykashark.entity.PlanGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 方案小组Mapper
 * @author 赵宇鹏
 * @version 1.0
 */
@Mapper
public interface PlanGroupMapper extends BaseMapper<PlanGroup> {
    List<PlanGroupDTO> getPlanGroupsInRegistrationTimeAsc(Integer start, Integer length);

    List<PlanGroupDTO> getPlanGroupsInScoreDesc(Integer start, Integer length);

    PlanGroupDTO getPlanGroupById(Integer id);

    PlanGroupDTO getPlanGroupByStudentId(Integer studentId);

    List<PlanGroupDTO> getPlanGroupsByConsultationInRegistrationTimeAsc(Integer consultation, Integer start, Integer length);

    List<PlanGroupDTO> getPlanGroupsByConsultationInScoreDesc(Integer consultation, Integer start, Integer length);

    List<PlanGroupDTO> getPlanGroupsByCoreTeacherIdInRegistrationTimeAsc(Integer coreTeacherId, Integer start, Integer length);

    List<PlanGroupDTO> getPlanGroupsByCoreTeacherIdInScoreDesc(Integer coreTeacherId, Integer start, Integer length);

    List<PlanGroupDTO> getPlanGroupsByConsultationAndCoreTeacherIdInRegistrationTimeAsc(Integer consultation, Integer coreTeacherId, Integer start, Integer length);

    List<PlanGroupDTO> getPlanGroupsByConsultationAndCoreTeacherIdInScoreDesc(Integer consultation, Integer coreTeacherId, Integer start, Integer length);

    List<PlanGroupDTO> searchPlanGroups(String[] keywords, Integer start, Integer length);
}
