package com.kashark.crazykashark.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 学生筛选表类
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class StudentFiltration {
    private Integer id;

    private Integer studentId;

    private Integer filtChartId;

    private Integer filtTeacherId;

    private String batch;

    private Integer grade;

    private String comment;

    private Timestamp createTime;

    private Integer createBy;

    private Timestamp updateTime;

    private Integer updateBy;

    @TableLogic
    private Integer deleted;
}
