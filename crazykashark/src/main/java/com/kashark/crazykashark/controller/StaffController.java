package com.kashark.crazykashark.controller;

import com.baomidou.mybatisplus.core.injector.methods.Insert;
import com.baomidou.mybatisplus.core.injector.methods.Update;
import com.kashark.crazykashark.dto.SearchDTO;
import com.kashark.crazykashark.dto.StaffDTO;
import com.kashark.crazykashark.entity.Result;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.service.StaffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 员工信息的Controller
 * @author 赵宇鹏
 * @version 1.0
 */
@RestController
@RequestMapping("/staff")
@Validated
@Tag(name = "员工信息接口")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }
    @GetMapping
    @Operation(summary = "获取员工信息")
    public Result getStaff(Integer current, Integer size) {
        return new Result(staffService.getStaff(current, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取指定ID的员工信息")
    public Result getStaffById(@PathVariable Integer id) throws ServiceException {
        return new Result(staffService.getStaffById(id));
    }

    @GetMapping("/staffId/{staffId}")
    @Operation(summary = "获取指定员工编号的员工信息")
    public Result getBriefStudentInformationByStudentId(@PathVariable Integer staffId) throws ServiceException {
        return new Result(staffService.getStaffByStaffId(staffId));
    }

    @PostMapping
    @Operation(summary = "添加新员工信息")
    public Result newBriefStudentInformation(@RequestBody @Validated(Insert.class) StaffDTO staffDTO) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        staffService.newStaff(staffDTO);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改员工信息")
    public Result editBriefStudentInformation(@RequestBody @Validated(Update.class) StaffDTO staffDTO) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        staffService.editStaff(staffDTO);
        return new Result();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除员工信息")
    public Result deleteBriefStudentInformation(@PathVariable Integer id) throws ServiceException {
        staffService.deleteStaff(id);
        return new Result();
    }

    @PostMapping("/search")
    @Operation(summary = "搜索员工信息")
    public Result searchStudentInformation(@RequestBody SearchDTO searchDTO) {
        String keyword = searchDTO.getKeyword();
        if (searchDTO.getKeyword() == null) {
            return new Result(staffService.getStaff(searchDTO.getCurrent(), searchDTO.getSize()));
        }
        String[] keywords = keyword.isBlank() ? null : keyword.split("\\s+");
        return new Result(staffService.searchStaff(keywords, searchDTO.getCurrent(), searchDTO.getSize()));
    }
}
