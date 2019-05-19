package com.notalent.bookstore.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * api 结果集
 * @author noTalent
 * @version 1.0
 * 2019.05.09
 */
@Data
@AllArgsConstructor
public class Result {

    // 静态常量

    public static final int SUCCESS_CODE = 0;                 // 成功状态码

    public static final int ERROR_CODE = 1;                   // 失败状态码

    public static final String SUCCESS_MSG = "ok";            // 成功信息

    public static final String ERROR_MSG = "error";           // 失败信息

    public static final Object NULL_DATA = new JSONObject();  // 结果为空

    // 变量

    private int code;       // 状态码

    private String msg;     // 请求信息

    private Object data;    // 数据

    // 静态方法

    public static Result success() {
        return new Result(SUCCESS_CODE, SUCCESS_MSG, NULL_DATA);
    }

    public static Result success(Object obj) {
        return new Result(SUCCESS_CODE, SUCCESS_MSG, obj);
    }

    public static Result error() {
        return new Result(ERROR_CODE, ERROR_MSG, NULL_DATA);
    }

    public static Result error(Object obj) {
        return new Result(ERROR_CODE, ERROR_MSG, obj);
    }

    public static String errorJson() {
        return JSON.toJSONString(error());
    }

}
