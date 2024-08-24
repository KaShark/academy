package com.kashark.crazykashark.controller;

import com.baomidou.mybatisplus.core.injector.methods.Insert;
import com.baomidou.mybatisplus.core.injector.methods.Update;
import com.kashark.crazykashark.dto.AdmissionDTO;
import com.kashark.crazykashark.dto.SearchDTO;
import com.kashark.crazykashark.entity.Result;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.service.AdmissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 学生录取情况的Controller
 * @author 赵宇鹏
 * @version 1.0
 */
@RestController
@RequestMapping("/admission")
@Validated
@Tag(name = "学生录取情况接口")
public class AdmissionController {
    private final AdmissionService admissionService;

    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @GetMapping
    @Operation(summary = "获取学生录取情况")
    public Result getAdmission(Integer current, Integer size) {
        return new Result(admissionService.getAdmission(current, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取指定ID的学生录取情况")
    public Result getAdmissionById(@PathVariable Integer id) throws ServiceException {
        return new Result(admissionService.getAdmissionById(id));
    }

    @GetMapping("/studentId/{studentId}")
    @Operation(summary = "获取指定学生编号的学生录取情况")
    public Result getAdmissionByStudentId(@PathVariable Integer studentId) throws ServiceException {
        return new Result(admissionService.getAdmissionByStudentId(studentId));
    }

    @GetMapping("/option")
    @Operation(summary = "获取指定条件的学生录取情况")
    public Result getAdmissionNotNullByCoreTeacherId(Integer coreTeacherId, Integer type, Integer current, Integer size) {
        if (type == 1) {
            if (coreTeacherId == null) {
                return new Result(admissionService.getAdmissionNotNull(current, size));
            }
            else {
                return new Result(admissionService.getAdmissionNotNullByCoreTeacherId(coreTeacherId, current, size));
            }
        }
        else {
            if (coreTeacherId == null) {
                return new Result(admissionService.getAdmission(current, size));
            }
            else {
                return new Result(admissionService.getAdmissionByCoreTeacherId(coreTeacherId, current, size));
            }
        }
    }

    @PostMapping
    @Operation(summary = "添加学生录取情况")
    public Result newSchedule(Integer staffId, @RequestBody @Validated(Insert.class) AdmissionDTO admissionDTO) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        admissionService.newAdmission(staffId, admissionDTO);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改学生录取情况")
    public Result editSchedule(Integer staffId, @RequestBody @Validated(Update.class) AdmissionDTO admissionDTO) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        admissionService.editAdmission(staffId, admissionDTO);
        return new Result();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除学生录取情况")
    public Result deleteSchedule(Integer staffId, @PathVariable Integer id) throws ServiceException {
        admissionService.deleteAdmission(staffId, id);
        return new Result();
    }

    @PostMapping("/search")
    @Operation(summary = "搜索学生录取情况")
    public Result searchStudentInformation(@RequestBody SearchDTO searchDTO) {
        String keyword = searchDTO.getKeyword();
        if (searchDTO.getKeyword() == null) {
            return new Result(admissionService.getAdmission(searchDTO.getCurrent(), searchDTO.getSize()));
        }
        String[] keywords = keyword.isBlank() ? null : keyword.split("\\s+");
        return new Result(admissionService.searchAdmission(keywords, searchDTO.getCurrent(), searchDTO.getSize()));
    }
}
