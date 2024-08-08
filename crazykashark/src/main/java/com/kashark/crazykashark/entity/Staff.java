package com.kashark.crazykashark.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 员工信息类
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class Staff {
    private Long id;

    private Long staffId;

    private String name;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Long createBy;

    private Long updateBy;

    private Integer deleted;
}
