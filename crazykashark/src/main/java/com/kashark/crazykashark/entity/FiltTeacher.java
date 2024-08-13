package com.kashark.crazykashark.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 筛选老师类
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class FiltTeacher {
    private Long id;

    private Long staffId;

    private String filtTeacherId;

    private Timestamp createTime;

    private Long createBy;

    private Timestamp updateTime;

    private Long updateBy;

    @TableLogic
    private Integer deleted;
}
