package com.kashark.crazykashark.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 学生方案表类
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class StudentPlan {
    private Long id;

    private Long planChartId;

    private Long studentId;

    private Long coreTeacherId;

    private String batch;

    private String comment;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Long createBy;

    private Long updateBy;

    private Integer deleted;
}
