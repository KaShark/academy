package com.kashark.crazykashark.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
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

    private String university;

    private String subject;

    private String error;

    private String comment;

    private Timestamp createTime;

    private Long createBy;

    private Timestamp updateTime;

    private Long updateBy;

    @TableLogic
    private Integer deleted;
}
