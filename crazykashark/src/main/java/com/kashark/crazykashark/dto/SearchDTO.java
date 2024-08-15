package com.kashark.crazykashark.dto;

import lombok.Data;

/**
 * 关键字搜索的DTO
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
public class SearchDTO {
    String keyword;

    Integer current;

    Integer size;
}
