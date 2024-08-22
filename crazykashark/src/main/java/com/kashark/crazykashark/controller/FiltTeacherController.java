package com.kashark.crazykashark.controller;

import com.baomidou.mybatisplus.core.injector.methods.Insert;
import com.baomidou.mybatisplus.core.injector.methods.Update;
import com.kashark.crazykashark.dto.FiltTeacherDTO;
import com.kashark.crazykashark.dto.SearchDTO;
import com.kashark.crazykashark.entity.Result;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.service.FiltTeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 筛选老师的Controller
 * @author 赵宇鹏
 * @version 1.0
 */
@RestController
@RequestMapping("/filtTeacher")
@Validated
@Tag(name = "筛选老师接口")
public class FiltTeacherController {
    private final FiltTeacherService filtTeacherService;

    public FiltTeacherController(FiltTeacherService filtTeacherService) {
        this.filtTeacherService = filtTeacherService;
    }

    @GetMapping
    @Operation(summary = "获取筛选老师")
    public Result getFiltTeachers(Integer current, Integer size) {
        return new Result(filtTeacherService.getFiltTeachers(current, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取指定ID的筛选老师")
    public Result getFiltTeacherById(@PathVariable Integer id) throws ServiceException {
        return new Result(filtTeacherService.getFiltTeacherById(id));
    }

    @GetMapping("/staffId/{staffId}")
    @Operation(summary = "获取指定员工编号的筛选老师")
    public Result getFiltTeacherByStudentId(@PathVariable Integer staffId) throws ServiceException {
        return new Result(filtTeacherService.getFiltTeacherByStaffId(staffId));
    }

    @GetMapping("/filtTeacherId/{filtTeacherId}")
    @Operation(summary = "获取指定筛选老师编号的筛选老师")
    public Result getFiltTeacherByFiltTeacherId(@PathVariable Integer filtTeacherId) throws ServiceException {
        return new Result(filtTeacherService.getFiltTeacherByFiltTeacherId(filtTeacherId));
    }

    @PostMapping
    @Operation(summary = "添加筛选老师")
    public Result newSchedule(Integer staffId, @RequestBody @Validated(Insert.class) FiltTeacherDTO filtTeacherDTO) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        filtTeacherService.newFiltTeacher(staffId, filtTeacherDTO);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改筛选老师")
    public Result editSchedule(Integer staffId, @RequestBody @Validated(Update.class) FiltTeacherDTO filtTeacherDTO) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        filtTeacherService.editFiltTeacher(staffId, filtTeacherDTO);
        return new Result();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除筛选老师")
    public Result deleteSchedule(Integer staffId, @PathVariable Integer id) throws ServiceException {
        filtTeacherService.deleteFiltTeacher(staffId, id);
        return new Result();
    }

    @PostMapping("/search")
    @Operation(summary = "搜索筛选老师")
    public Result searchStudentInformation(@RequestBody SearchDTO searchDTO) {
        String keyword = searchDTO.getKeyword();
        if (searchDTO.getKeyword() == null) {
            return new Result(filtTeacherService.getFiltTeachers(searchDTO.getCurrent(), searchDTO.getSize()));
        }
        String[] keywords = keyword.isBlank() ? null : keyword.split("\\s+");
        return new Result(filtTeacherService.searchFiltTeachers(keywords, searchDTO.getCurrent(), searchDTO.getSize()));
    }
}
