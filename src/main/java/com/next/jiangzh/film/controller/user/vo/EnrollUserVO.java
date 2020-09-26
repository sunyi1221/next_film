package com.next.jiangzh.film.controller.user.vo;

import com.next.jiangzh.film.common.utils.ToolUtils;
import com.next.jiangzh.film.controller.common.BaseVO;
import com.next.jiangzh.film.controller.exception.ParamErrorException;
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
public class EnrollUserVO extends BaseVO {

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

    /**
     * 参数校验
     */
    @Override
    public void checkParam() throws ParamErrorException {
        if (ToolUtils.isEmpty(this.getUsername())) {
            throw new ParamErrorException(400, "用户名不能为空！");
        }
        if (ToolUtils.isEmpty(this.getPassword())) {
            throw new ParamErrorException(400, "密码不能为空！");
        }
    }

}
