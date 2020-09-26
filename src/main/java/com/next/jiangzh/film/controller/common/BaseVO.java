package com.next.jiangzh.film.controller.common;

import com.next.jiangzh.film.controller.exception.ParamErrorException;

/**
 * 类名称：通用视图实体类
 *
 * 创建人： Sunyi
 * 创建时间：2020/9/26 16:26
 *
 * @author Sunyi
 * @date 2020/9/26 16:26
 * @updateRemark 修改备注：通用视图实体类
 */
public abstract class BaseVO {

    public abstract void checkParam() throws ParamErrorException;

}
