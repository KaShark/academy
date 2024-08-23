package com.kashark.crazykashark.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 方案小组的DTO
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class PlanGroupDTO {

    private Integer id;

    private Integer studentId;

    private Integer consultation;

    private Timestamp registrationTime;

    private String studentName;

    private String highSchool;

    private String major;

    private Integer score;

    private Integer coreTeacherId;

    private String coreTeacherName;
}
