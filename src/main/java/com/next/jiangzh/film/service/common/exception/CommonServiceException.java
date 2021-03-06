package com.next.jiangzh.film.service.common.exception;

import lombok.Data;

/**
 * 类名称：业务处理异常类
 *
 * 创建人： Sunyi
 * 创建时间：2020/9/23 16:40
 *
 * @author Sunyi
 * @date 2020/9/23 16:40
 * @updateRemark 修改备注：数据处理异常类
 */
@Data
public class CommonServiceException extends Exception {

    /**
     * 异常代码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String errMsg;

    public CommonServiceException(int code, String errMsg) {
        super(errMsg);
        this.code = code;
        this.errMsg = errMsg;
    }
}
