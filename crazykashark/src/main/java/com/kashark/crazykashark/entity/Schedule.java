package com.kashark.crazykashark.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 筛选方案时间安排表类
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class Schedule {

    private Long id;

    private Long studentId;

    private Long coreTeacherId;

    private Timestamp time;

    private Boolean type;

    private String comment;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Long createBy;

    private Long updateBy;

    private Integer deleted;
}
