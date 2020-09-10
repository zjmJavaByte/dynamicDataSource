package com.kh.jkdw.model.vo;


import com.kh.jkdw.enums.StatusCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 类名称：ResponseResult
 * ********************************
 * <p>
 * 类描述：通用返回结果模型
 *
 * @author
 * @date 下午12:59
 */
@Data
public class ResponseResult<T> implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7813356989387725160L;
    /**
     * 是否成功
     */
    private boolean success;
    private boolean isSuccess;
    /**
     * 编码
     */
    private String code;
    /**
     * 描述信息
     */
    private String msg;
    /**
     * 结果
     */
    private T info;
    /**
     * 成功
     * @param info
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> success(T info, String code, String msg) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setSuccess(Boolean.TRUE);
        responseResult.setCode(code);
        responseResult.setMsg(msg);
        responseResult.setInfo(info);
        return responseResult;
    }
    /**
     * 失败
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> failure(String code, String msg) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setSuccess(Boolean.FALSE);
        responseResult.setCode(code);
        responseResult.setMsg(msg);
        return responseResult;
    }
    /**
     * 失败
     * @param statusCodeEnum
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> failure(StatusCodeEnum statusCodeEnum) {
        return failure(statusCodeEnum.getCode(), statusCodeEnum.getMsg());
    }
    /**
     * 成功
     * @param info
     * @param statusCodeEnum
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> success(T info,StatusCodeEnum statusCodeEnum) {
        return success(info,statusCodeEnum.getCode(), statusCodeEnum.getMsg());
    }

    public static <T> ResponseResult<T> success(StatusCodeEnum statusCodeEnum) {
        return success(null,statusCodeEnum.getCode(), statusCodeEnum.getMsg());
    }



}
