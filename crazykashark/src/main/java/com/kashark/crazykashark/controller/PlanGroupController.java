package com.kashark.crazykashark.controller;

import com.baomidou.mybatisplus.core.injector.methods.Insert;
import com.baomidou.mybatisplus.core.injector.methods.Update;
import com.kashark.crazykashark.dto.PlanGroupDTO;
import com.kashark.crazykashark.dto.SearchDTO;
import com.kashark.crazykashark.entity.Result;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.service.PlanGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 方案小组的Controller
 * @author 赵宇鹏
 * @version 1.0
 */
@RestController
@RequestMapping("/planGroup")
@Validated
@Tag(name = "方案小组接口")
public class PlanGroupController {
    private final PlanGroupService planGroupService;

    public PlanGroupController(PlanGroupService planGroupService) {
        this.planGroupService = planGroupService;
    }

    @GetMapping
    @Operation(summary = "获取方案小组")
    public Result getPlanGroupsInRegistrationTimeAsc(Integer current, Integer size) {
        return new Result(planGroupService.getPlanGroupsInRegistrationTimeAsc(current, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取指定ID的方案小组")
    public Result getPlanGroupById(@PathVariable Integer id) throws ServiceException {
        return new Result(planGroupService.getPlanGroupById(id));
    }

    @GetMapping("/studentId/{studentId}")
    @Operation(summary = "获取指定学生编号的方案小组")
    public Result getPlanGroupsByStudentId(@PathVariable Integer studentId) throws ServiceException {
        return new Result(planGroupService.getPlanGroupByStudentId(studentId));
    }

    @GetMapping("/option")
    @Operation(summary = "获取指定条件的方案小组")
    public Result getPlanGroupsByConsultationAndCoreTeacherIdAndFilter(Integer consultation, Integer coreTeacherId, Integer filter, Integer current, Integer size) {
        if (filter == 1) {
            if (consultation == null)
            {
                if (coreTeacherId == null){
                    return new Result(planGroupService.getPlanGroupsInRegistrationTimeAsc(current, size));
                }
                else {
                    return new Result(planGroupService.getPlanGroupsByCoreTeacherIdInRegistrationTimeAsc(coreTeacherId, current, size));
                }
            }
            else if (coreTeacherId == null){
                return new Result(planGroupService.getPlanGroupsByConsultationInRegistrationTimeAsc(consultation, current, size));
            }
            else {
                return new Result(planGroupService.getPlanGroupsByConsultationAndCoreTeacherIdInRegistrationTimeAsc(consultation, coreTeacherId, current, size));
            }
        }
        else if (filter == 2) {
            if (consultation == null)
            {
                if (coreTeacherId == null){
                    return new Result(planGroupService.getPlanGroupsInScoreDesc(current, size));
                }
                else {
                    return new Result(planGroupService.getPlanGroupsByCoreTeacherIdInScoreDesc(coreTeacherId, current, size));
                }
            }
            else if (coreTeacherId == null){
                return new Result(planGroupService.getPlanGroupsByConsultationInScoreDesc(consultation, current, size));
            }
            else {
                return new Result(planGroupService.getPlanGroupsByConsultationAndCoreTeacherIdInScoreDesc(consultation, coreTeacherId, current, size));
            }
        }
        else {
            return new Result();
        }
    }

    @PostMapping
    @Operation(summary = "添加方案小组")
    public Result newPlanGroup(Integer staffId, @RequestBody @Validated(Insert.class) PlanGroupDTO planGroupDTO) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        planGroupService.newPlanGroup(staffId, planGroupDTO);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改方案小组")
    public Result editPlanGroup(Integer staffId, @RequestBody @Validated(Update.class) PlanGroupDTO planGroupDTO) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        planGroupService.editPlanGroup(staffId, planGroupDTO);
        return new Result();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除方案小组")
    public Result deletePlanGroup(Integer staffId, @PathVariable Integer id) throws ServiceException {
        planGroupService.deletePlanGroup(staffId, id);
        return new Result();
    }

    @PostMapping("/search")
    @Operation(summary = "搜索方案小组")
    public Result searchStudentInformation(@RequestBody SearchDTO searchDTO) {
        String keyword = searchDTO.getKeyword();
        if (searchDTO.getKeyword() == null) {
            return new Result(planGroupService.getPlanGroupsInRegistrationTimeAsc(searchDTO.getCurrent(), searchDTO.getSize()));
        }
        String[] keywords = keyword.isBlank() ? null : keyword.split("\\s+");
        return new Result(planGroupService.searchPlanGroups(keywords, searchDTO.getCurrent(), searchDTO.getSize()));
    }
}
