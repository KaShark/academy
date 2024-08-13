package com.kashark.crazykashark.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 方案小组类
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class PlanGroup {
    private Integer id;

    private Integer studentId;

    private String coreTeacherId;

    private Timestamp createTime;

    private Integer createBy;

    private Timestamp updateTime;

    private Integer updateBy;

    @TableLogic
    private Integer deleted;
}
