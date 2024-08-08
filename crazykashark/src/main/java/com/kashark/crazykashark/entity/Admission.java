package com.kashark.crazykashark.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 学生录取情况类
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class Admission {
    private Long id;

    private Long studentId;

    private String schoolChoice;

    private String majorChoice;

    private String comment;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Long createBy;

    private Long updateBy;

    private Integer deleted;
}
