package com.kashark.crazykashark.controller;

import com.baomidou.mybatisplus.core.injector.methods.Insert;
import com.baomidou.mybatisplus.core.injector.methods.Update;
import com.kashark.crazykashark.entity.Result;
import com.kashark.crazykashark.entity.StudentInformation;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.service.StudentInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 学生信息的Controller
 * @author 赵宇鹏
 * @version 1.0
 */
@RestController
@RequestMapping("/studentInformation")
@Validated
@Tag(name = "学生信息接口")
public class StudentInformationController {
    private final StudentInformationService studentInformationService;

    public StudentInformationController(StudentInformationService studentInformationService) {
        this.studentInformationService = studentInformationService;
    }

    @GetMapping
    @Operation(summary = "获取学生信息")
    public Result getBriefStudentInformation(Integer current, Integer size) {
        return new Result(studentInformationService.getBriefStudentInformation(current, size));
    }

    @GetMapping("/consultation/{consultation}")
    @Operation(summary = "获取指定ID的学生信息")
    public Result getBriefStudentInformationByConsultation(@PathVariable Integer consultation, Integer current, Integer size) {
        return new Result(studentInformationService.getBriefStudentInformationByConsultation(consultation, current, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取指定ID的学生信息")
    public Result getBriefStudentInformationById(@PathVariable Integer id) throws ServiceException {
        return new Result(studentInformationService.getStudentInformationById(id));
    }

    @GetMapping("/studentId/{studentId}")
    @Operation(summary = "获取指定学生编号的学生信息")
    public Result getBriefStudentInformationByBriefStudentInformationId(@PathVariable Integer studentId) throws ServiceException {
        return new Result(studentInformationService.getBriefStudentInformationByStudentId(studentId));
    }

    @PostMapping
    @Operation(summary = "添加新学生信息")
    public Result newBriefStudentInformation(Integer staffId, @RequestBody @Validated(Insert.class) StudentInformation studentInformation) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        studentInformationService.newStudentInformation(staffId, studentInformation);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改学生信息")
    public Result editBriefStudentInformation(Integer staffId, @RequestBody @Validated(Update.class) StudentInformation studentInformation) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        studentInformationService.editStudentInformation(staffId, studentInformation);
        return new Result();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除学生信息")
    public Result deleteBriefStudentInformation(Integer staffId, @PathVariable Integer id) throws ServiceException {
        studentInformationService.deleteStudentInformation(staffId, id);
        return new Result();
    }
}
