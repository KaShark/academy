package com.kashark.crazykashark.entity;

import com.kashark.crazykashark.utils.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回值
 * @author 赵宇鹏
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class Result {
    //状态码
    private Integer statusCode;

    //信息
    private String message;

    //数据
    private Object data;

    public Result(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Result(Object data) {
        this.data = data;
        this.statusCode = StatusCode.SUCCESS;
    }

    public Result(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Result() {
        this.statusCode = StatusCode.SUCCESS;
    }
}
