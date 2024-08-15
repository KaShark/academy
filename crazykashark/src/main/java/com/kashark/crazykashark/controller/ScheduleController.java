package com.kashark.crazykashark.controller;

import com.baomidou.mybatisplus.core.injector.methods.Insert;
import com.baomidou.mybatisplus.core.injector.methods.Update;
import com.kashark.crazykashark.dto.ScheduleDTO;
import com.kashark.crazykashark.dto.SearchDTO;
import com.kashark.crazykashark.entity.Result;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * 时间表的Controller
 * @author 赵宇鹏
 * @version 1.0
 */
@RestController
@RequestMapping("/schedule")
@Validated
@Tag(name = "时间表接口")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    @Operation(summary = "获取时间表")
    public Result getSchedules(Integer current, Integer size) {
        return new Result(scheduleService.getSchedules(current, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取指定ID的时间表")
    public Result getScheduleById(@PathVariable Integer id) throws ServiceException {
        return new Result(scheduleService.getScheduleById(id));
    }

    @GetMapping("/studentId/{studentId}")
    @Operation(summary = "获取指定学生编号的时间表")
    public Result getSchedulesByStudentId(@PathVariable Integer studentId, Integer current, Integer size) {
        return new Result(scheduleService.getSchedulesByStudentId(studentId, current, size));
    }

    @GetMapping("/option")
    @Operation(summary = "获取指定条件的时间表")
    public Result getSchedulesByTimeAndCoreTeacherIdAneType(LocalDate date, Integer coreTeacherId, String type, Integer current, Integer size) {
        if (date == null) {
            if (coreTeacherId == null) {
                if (type == null) {
                    return new Result(scheduleService.getSchedules(current, size));
                }
                else {
                    return new Result(scheduleService.getSchedulesByType(type, current, size));
                }
            }
            else if (type == null)
            {
                return new Result(scheduleService.getSchedulesByCoreTeacherId(coreTeacherId, current, size));
            }
            else {
                return new Result(scheduleService.getSchedulesByCoreTeacherIdAndType(coreTeacherId, type, current, size));
            }
        }
        else if (coreTeacherId == null) {
            if (type == null) {
                return new Result(scheduleService.getSchedulesByTime(date, current, size));
            }
            else {
                return new Result(scheduleService.getSchedulesByTimeAndType(date, type, current, size));
            }
        }
        else if (type == null) {
            return new Result(scheduleService.getSchedulesByTimeAndCoreTeacherId(date, coreTeacherId, current, size));
        }
        else {
            return new Result(scheduleService.getSchedulesByTimeAndCoreTeacherIdAndType(date, coreTeacherId, type, current, size));
        }
    }

    @PostMapping
    @Operation(summary = "添加时间表")
    public Result newSchedule(Integer staffId, @RequestBody @Validated(Insert.class) ScheduleDTO scheduleDTO) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        scheduleService.newSchedule(staffId, scheduleDTO);
        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改时间表")
    public Result editSchedule(Integer staffId, @RequestBody @Validated(Update.class) ScheduleDTO scheduleDTO) throws ServiceException {
//        if (bindingResult.hasErrors()) {
//            throw new DTOValidationException(bindingResult.getAllErrors());
//        }
        scheduleService.editSchedule(staffId, scheduleDTO);
        return new Result();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除时间表")
    public Result deleteSchedule(Integer staffId, @PathVariable Integer id) throws ServiceException {
        scheduleService.deleteSchedule(staffId, id);
        return new Result();
    }

    @PostMapping("/search")
    @Operation(summary = "搜索时间表")
    public Result searchStudentInformation(@RequestBody SearchDTO searchDTO) {
        String keyword = searchDTO.getKeyword();
        if (searchDTO.getKeyword() == null) {
            return new Result(scheduleService.getSchedulesByTime(LocalDate.now(), searchDTO.getCurrent(), searchDTO.getSize()));
        }
        String[] keywords = keyword.isBlank() ? null : keyword.split("\\s+");
        return new Result(scheduleService.searchSchedule(keywords, searchDTO.getCurrent(), searchDTO.getSize()));
    }
}
