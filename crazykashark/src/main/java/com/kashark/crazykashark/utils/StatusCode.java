package com.kashark.crazykashark.utils;


/**
 * 统一响应码
 * @author 赵宇鹏
 * @version 1.0
 */
public class StatusCode {
    public static final Integer SUCCESS = 200;

    public static final Integer INVALID_TOKEN = 300;

    public static final Integer TOKEN_NOT_FOUND = 301;

    public static final Integer UNAUTHORIZED = 302;

    public static final Integer AUTHENTICATION_FAIL = 303;

    public static final Integer USER_NOT_EXIST = 304;

    public static final Integer PARAMETER_EXCEPTION = 400;

    public static final Integer METHOD_NOT_SUPPORT = 401;

    public static final Integer REGISTER_FAIL = 402;

    public static final Integer UNREGISTER_FAIL = 403;

    public static final Integer GET_STUDENT_INFORMATION_FAIL = 404;

    public static final Integer NEW_STUDENT_INFORMATION_FAIL = 405;

    public static final Integer EDIT_STUDENT_INFORMATION_FAIL = 406;

    public static final Integer DELETE_STUDENT_INFORMATION_FAIL = 407;

    public static final Integer GET_SCHEDULE_FAIL = 408;

    public static final Integer NEW_SCHEDULE_FAIL = 409;

    public static final Integer EDIT_SCHEDULE_FAIL = 410;

    public static final Integer DELETE_SCHEDULE_FAIL = 411;

    public static final Integer GET_STAFF_FAIL = 412;

    public static final Integer NEW_STAFF_FAIL = 413;

    public static final Integer EDIT_STAFF_FAIL = 414;

    public static final Integer DELETE_STAFF_FAIL = 415;
}
