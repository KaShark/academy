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
    private Integer id;

    private Integer studentId;

    private Integer planChartId;

    private Integer coreTeacherId;

    private String batch;

    private Timestamp planTime;

    private String comment;

    private Timestamp createTime;

    private Integer createBy;

    private Timestamp updateTime;

    private Integer updateBy;

    @TableLogic
    private Integer deleted;
}
