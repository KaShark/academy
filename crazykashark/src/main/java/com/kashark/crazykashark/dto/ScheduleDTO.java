package com.kashark.crazykashark.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 时间表的DTO
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class ScheduleDTO {

    private Integer id;

    private Integer coreTeacherId;

    private String coreTeacherName;

    private Integer studentId;

    private String studentName;

    private String highSchool;

    private Timestamp time;

    private String type;

    private String status;

    private String comment;
}
