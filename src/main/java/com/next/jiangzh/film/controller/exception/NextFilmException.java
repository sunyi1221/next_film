package com.next.jiangzh.film.controller.exception;

import lombok.Data;

/**
 * 类名称：全局异常类
 *
 * 创建人： Sunyi
 * 创建时间：2020/9/25 17:14
 *
 * @author Sunyi
 * @date 2020/9/25 17:14
 * @updateRemark 修改备注：全局异常类
 */
@Data
public class NextFilmException extends Exception{

    /**
     * 异常代码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String errMsg;

    public NextFilmException(int code, String errMsg) {
        super(errMsg);
        this.code = code;
        this.errMsg = errMsg;
    }

}
