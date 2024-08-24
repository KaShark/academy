package com.kashark.crazykashark.dto;

import lombok.Data;

/**
 * 学生录取情况的DTO
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class AdmissionDTO {
    private Integer id;

    private Integer studentId;

    private Integer consultation;

    private String studentName;

    private String highSchool;

    private String major;

    private Integer score;

    private Integer coreTeacherId;

    private String coreTeacherName;

    private String university;

    private String subject;

    private String error;

    private String comment;
}
