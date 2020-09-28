package com.next.jiangzh.film.controller.user.vo;

import com.next.jiangzh.film.controller.common.BaseVO;
import com.next.jiangzh.film.controller.exception.ParamErrorException;
import lombok.Data;

/**
 * 类名称：用户信息类
 * <p>
 * 创建人： Sunyi
 * 创建时间：2020/9/23 17:27
 *
 * @author Sunyi
 * @date 2020/9/23 17:27
 * @updateRemark 修改备注：用户信息类
 */
@Data
public class UserInfoVO extends BaseVO {

    private Integer id;
    /**
     * 主键ID
     */
    private Integer uuid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 生活状态
     */
    private String lifeState;
    /**
     * 个人简介
     */
    private String biography;
    /**
     * 地址
     */
    private String address;
    /**
     * 头像链接地址
     */
    private String headAddress;
    /**
     * 创建时间
     */
    private Long beginTime;
    /**
     * 更新时间
     */
    private Long updateTime;


    public Integer getUuid() {
        return this.getId();
    }

    /**
     * 参数校验
     */
    @Override
    public void checkParam() throws ParamErrorException {

    }

}
