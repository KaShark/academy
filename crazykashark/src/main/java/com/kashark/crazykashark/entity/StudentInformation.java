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

    private Timestamp createTime;

    private Integer createBy;

    private Timestamp updateTime;

    private Integer updateBy;

    @TableLogic
    private Integer deleted;
}
