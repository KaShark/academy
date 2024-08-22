package com.kashark.crazykashark.controller;

import com.baomidou.mybatisplus.core.injector.methods.Insert;
import com.baomidou.mybatisplus.core.injector.methods.Update;
import com.kashark.crazykashark.dto.CoreTeacherDTO;
import com.kashark.crazykashark.dto.SearchDTO;
import com.kashark.crazykashark.entity.Result;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.service.CoreTeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 核心老师的Controller
 * @author 赵宇鹏
 * @version 1.0
 */
@RestController
@RequestMapping("/coreTeacher")
@Validated
@Tag(name = "核心老师接口")
public class CoreTeacherController {
    private final CoreTeacherService coreTeacherService;
    
    public CoreTeacherController(CoreTeacherService coreTeacherService) {
        this.coreTeacherService = coreTeacherService;
    }

    @GetMapping
    @Operation(summary = "获取核心老师")
    public Result getCoreTeachers(Integer current, Integer size) {
        return new Result(coreTeacherService.getCoreTeachers(current, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取指定ID的核心老师")
    public Result getCoreTeacherById(@PathVariable Integer id) throws ServiceException {
        return new Result(coreTeacherService.getCoreTeacherById(id));
    }

    @GetMapping("/staffId/{staffId}")
    @Operation(summary = "获取指定员工编号的核心老师")
    public Result getCoreTeacherByStudentId(@PathVariable Integer staffId) throws ServiceException {
        return new Result(coreTeacherService.getCoreTeacherByStaffId(staffId));
    }

    @GetMapping("/coreTeacherId/{coreTeacherId}")
    @Operation(summary = "获取指定核心老师编号的核心老师")
    public Result getCoreTeacherByCoreTeacherId(@PathVariable Integer coreTeacherId) throws ServiceException {
        return new Result(coreTeacherService.getCoreTeacherByCoreTeacherId(coreTeacherId));
    }

    @PostMapping
    @Operation(summary = "添加核心老师")
    public Result newSchedule(Integer staffId, @RequestBody @Validated(Insert.class) CoreTeacherDTO coreTeacherDTO) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        coreTeacherService.newCoreTeacher(staffId, coreTeacherDTO);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改核心老师")
    public Result editSchedule(Integer staffId, @RequestBody @Validated(Update.class) CoreTeacherDTO coreTeacherDTO) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        coreTeacherService.editCoreTeacher(staffId, coreTeacherDTO);
        return new Result();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除核心老师")
    public Result deleteSchedule(Integer staffId, @PathVariable Integer id) throws ServiceException {
        coreTeacherService.deleteCoreTeacher(staffId, id);
        return new Result();
    }

    @PostMapping("/search")
    @Operation(summary = "搜索核心老师")
    public Result searchStudentInformation(@RequestBody SearchDTO searchDTO) {
        String keyword = searchDTO.getKeyword();
        if (searchDTO.getKeyword() == null) {
            return new Result(coreTeacherService.getCoreTeachers(searchDTO.getCurrent(), searchDTO.getSize()));
        }
        String[] keywords = keyword.isBlank() ? null : keyword.split("\\s+");
        return new Result(coreTeacherService.searchCoreTeachers(keywords, searchDTO.getCurrent(), searchDTO.getSize()));
    }
}
