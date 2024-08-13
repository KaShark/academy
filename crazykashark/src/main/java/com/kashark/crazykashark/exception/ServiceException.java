package com.kashark.crazykashark.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 服务异常
 * @author 赵宇鹏
 * @version 1.0
 */
@Getter
@Setter
public class ServiceException extends Exception{
    private Integer statusCode;

    private Object data;

    public ServiceException(Integer statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public ServiceException(Integer statusCode, String message, Object data) {
        super(message);
        this.statusCode = statusCode;
        this.data = data;
    }
}
