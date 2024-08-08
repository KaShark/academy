package com.kashark.crazykashark.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 学生信息类
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class StudentInformation {
    private Long studentId;

    private Boolean isFresh;

    private Timestamp registrationTime;

    private String studentName;

    private String school;

    private Boolean major;

    private String parentName;

    private Long telephone;

    private String wechatName;

    private Long score;

    private Integer status;

    private String comment;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Long createBy;

    private Long updateBy;

    @TableLogic
    private Integer deleted;
}
