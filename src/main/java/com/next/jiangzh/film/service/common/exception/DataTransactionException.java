package com.next.jiangzh.film.service.common.exception;

/**
 * 类名称：数据处理异常类
 *
 * 创建人： Sunyi
 * 创建时间：2020/9/23 16:40
 *
 * @author Sunyi
 * @date 2020/9/23 16:40
 * @updateRemark 修改备注：数据处理异常类
 */
public class DataTransactionException extends Exception {

    /**
     * 异常代码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String errMsg;

    public DataTransactionException(int code, String errMsg) {
        super(errMsg);
        this.code = code;
        this.errMsg = errMsg;
    }
}
