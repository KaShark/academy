package com.kashark.crazykashark.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 学生筛选表类
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class StudentFiltration {
    private Long id;

    private Long filtChartId;

    private Long studentId;

    private Long filtTeacherId;

    private String batch;

    private String type;

    private Long grade;

    private String comment;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Long createBy;

    private Long updateBy;

    private Integer deleted;
}
