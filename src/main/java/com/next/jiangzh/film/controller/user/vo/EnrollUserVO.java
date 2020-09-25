package com.next.jiangzh.film.controller.user.vo;

import lombok.Data;

/**
 * 类名称：用户登记类
 *
 * 创建人： Sunyi
 * 创建时间：2020/9/23 16:36
 *
 * @author Sunyi
 * @date 2020/9/23 16:36
 * @updateRemark 修改备注：用户登记类
 */
@Data
public class EnrollUserVO {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 地址
     */
    private String address;

}
