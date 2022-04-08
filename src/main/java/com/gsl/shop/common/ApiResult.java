package com.gsl.shop.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * Api接口返回值的统一封装
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ApiResult<T> implements Serializable {

    public static String CODE_SUCCESS = "00000";


    public static final ApiResult<?> SUCCESS_EMPTY = new ApiResult<>(CODE_SUCCESS);

    /**
     * 错误码，00000表示成功，其他是失败
     */
    String code;

    /**
     * 返回给前端的错误信息
     */
    String msg;

    //返回结果时间戳
    Long resultTime;

    /**
     * 接口返回数据
     */
    T data;

    private ApiResult() {
        this.resultTime = System.currentTimeMillis();
    }

    private ApiResult(String code) {
        this.code = code;
        this.resultTime = System.currentTimeMillis();
    }

    private ApiResult(String code, T data) {
        this.code = code;
        this.data = data;
        this.resultTime = System.currentTimeMillis();
    }

    private ApiResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.resultTime = System.currentTimeMillis();
    }

    private ApiResult(ApiResultFail apiResultFail) {
        this.code = apiResultFail.getCode();
        this.msg = apiResultFail.getMsg();
        this.resultTime = System.currentTimeMillis();
    }

    private ApiResult(ApiResultFail apiResultFail, String msg) {
        this.code = apiResultFail.getCode();
        this.msg = msg;
        this.resultTime = System.currentTimeMillis();
    }

    private ApiResult(ApiResultFail apiResultFail, T data) {
        this.code = apiResultFail.getCode();
        this.msg = apiResultFail.getMsg();
        this.data = data;
        this.resultTime = System.currentTimeMillis();
    }

    /**
     * 无返回值的成功结果
     */
    public static ApiResult<?> success() {
        return SUCCESS_EMPTY;
    }

    /**
     * 有返回值的成功结果
     *
     * @param data 返回值对象
     * @param <T>  返回值范型
     */
    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(CODE_SUCCESS, data);
    }


    /**
     * 默认的错误结果
     */
    public static ApiResult failServer() {
        return new ApiResult<>(ApiResultFailEnum.DEFAULT_SERVER_ERROR);
    }

    /**
     * 有提示信息的错误结果
     *
     * @param msg 提示信息
     */
    public static ApiResult failServer(String msg) {
        return new ApiResult<>(ApiResultFailEnum.DEFAULT_SERVER_ERROR, msg);
    }

    /**
     * 有指定错误码和提示信息的错误结果
     *
     * @param apiResultFail 错误枚举
     * @param msg           提示信息
     */
    public static ApiResult fail(ApiResultFail apiResultFail, String msg) {
        return new ApiResult<>(apiResultFail, msg);
    }

    /**
     * 有指定错误码和提示信息的错误结果
     *
     * @param apiResultFail 错误枚举
     * @param data          数据
     */
    public static <T> ApiResult failData(ApiResultFail apiResultFail, T data) {
        return new ApiResult<>(apiResultFail, data);
    }
}