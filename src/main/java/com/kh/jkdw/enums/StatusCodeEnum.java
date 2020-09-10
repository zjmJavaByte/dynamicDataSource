package com.kh.jkdw.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 类名称：StatusCodeEnum
 * ********************************
 * <p>
 * 类描述：状态编码枚举
 *
 * @author
 * @date 2020/3/1 下午9:54
 */
@AllArgsConstructor
@Getter
public enum StatusCodeEnum {

    // 2*** 成功
    SUCCESS("200", "操作成功"),

    // 3*** 参数异常
    PARAM_ERROR("201", "参数异常"),
    PARAM_NULL("202", "参数为空"),
    PARAM_FORMAT_ERROR("203", "参数格式不正确"),
    PARAM_VALUE_ERROR("204", "参数值不正确"),

    // 4*** 系统异常
    SYSTEM_ERROR("401", "服务异常"),
    UNKNOWN_ERROR("402", "未知异常"),

    // 5*** 业务异常
    XXX("501", "业务异常"),
    INSERT_FAILURE("502", "新增失败"),
    UPDATE_FAILURE("503", "更新失败"),
    DELETE_FAILURE("504", "删除失败"),
    RATE_LIMIT_ERROR("505", "限流异常"),
    FILE_UPLOAD_FAILURE("506", "文件上传失败"),

    NUMBER_FORMAT("601","数字转换异常"),


    ILLEG_STATUS("701","非法状态异常"),

    NO_POWER("801","此账号无登录权限");

    ;


    /**
     * 错误编码
     */
    private String code;

    /**
     * 错误描述
     */
    private String msg;


}
