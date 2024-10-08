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
    private Integer id;

    private Integer staffId;

    private String staffName;

    private Integer authorization;

    private String account;

    private String password;

    private String avatar;

    private String telephone;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Integer deleted;
}
