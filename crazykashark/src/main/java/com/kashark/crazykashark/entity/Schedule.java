package com.kashark.crazykashark.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 时间表类
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class Schedule {

    private Integer id;

    private Integer studentId;

    private Timestamp time;

    private String type;

    private String status;

    private String comment;

    private Timestamp createTime;

    private Integer createBy;

    private Timestamp updateTime;

    private Integer updateBy;

    @TableLogic
    private Integer deleted;
}
