package com.kashark.crazykashark.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
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

    private Long studentId;

    private Long planChartId;

    private Long coreTeacherId;

    private String batch;

    private String comment;

    private Timestamp createTime;

    private Long createBy;

    private Timestamp updateTime;

    private Long updateBy;

    @TableLogic
    private Integer deleted;
}
