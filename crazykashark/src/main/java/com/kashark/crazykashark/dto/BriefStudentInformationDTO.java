package com.kashark.crazykashark.dto;

import lombok.Data;

/**
 * 学生部分信息的DTO
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class BriefStudentInformationDTO {
    private Integer id;

    private Integer consultation;

    private Integer studentId;

    private String studentName;

    private String highSchool;

    private String major;

    private Integer score;
}
