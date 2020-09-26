package com.next.jiangzh.film.controller.exception;

import lombok.Data;

/**
 * 类名称：参数校验异常类
 *
 * 创建人： Sunyi
 * 创建时间：2020/9/26 16:19
 *
 * @author Sunyi
 * @date 2020/9/26 16:19
 * @updateRemark 修改备注：参数校验异常类
 */
@Data
public class ParamErrorException extends Exception{
    /**
     * 异常代码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String errMsg;

    public ParamErrorException(int code, String errMsg) {
        super(errMsg);
        this.code = code;
        this.errMsg = errMsg;
    }
}
