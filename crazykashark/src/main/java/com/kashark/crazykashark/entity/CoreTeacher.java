package com.kashark.crazykashark.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 核心老师类
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class CoreTeacher {
    private Integer id;

    private Integer staffId;

    private Integer coreTeacherId;

    private Timestamp createTime;

    private Integer createBy;

    private Timestamp updateTime;

    private Integer updateBy;

    @TableLogic
    private Integer deleted;
}
