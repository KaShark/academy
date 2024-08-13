package com.kashark.crazykashark.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 筛选方案时间安排表类
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class Schedule {

    private Integer id;

    private Integer studentId;

    private Integer coreTeacherId;

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
