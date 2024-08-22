package com.kashark.crazykashark.dto;

import lombok.Data;

/**
 * 筛选老师的DTO
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class FiltTeacherDTO {
    private Integer id;

    private Integer staffId;

    private String staffName;

    private Integer filtTeacherId;
}
