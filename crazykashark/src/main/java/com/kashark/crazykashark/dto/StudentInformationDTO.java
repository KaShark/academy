package com.kashark.crazykashark.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 学生信息的DTO
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class StudentInformationDTO {
    private Integer id;

    private Integer consultation;

    private Integer studentId;

    private Timestamp registrationTime;

    private String studentName;

    private String highSchool;

    private String major;

    private Integer score;

    private Integer enrollment;

    private String telephone;

    private String parentName;

    private String wechatName;

    private String comment;
}
