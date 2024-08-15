package com.kashark.crazykashark.dto;

import lombok.Data;

/**
 * 员工信息的DTO
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class StaffDTO {
    private Integer id;

    private Integer staffId;

    private String staffName;

    private Integer authorization;

    private String account;

    private String password;

    private String avatar;

    private String telephone;
}
