package com.next.jiangzh.film.controller.auth.controller.vo;

import com.next.jiangzh.film.controller.common.BaseVO;
import com.next.jiangzh.film.controller.exception.ParamErrorException;
import lombok.Data;

/**
 * 类名称：jwt验证请求VO
 * <p>
 * 创建人： Sunyi
 * 创建时间：2020/9/27 13:38
 *
 * @author Sunyi
 * @date 2020/9/27 13:38
 * @updateRemark 修改备注：jwt验证请求VO
 */
@Data
public class AuthRequestVO extends BaseVO {

    /**
     *  用户名
     */
    private String username;
    /**
     *  密码
     */
    private String password;


    /**
     *  参数校验
     */
    @Override
    public void checkParam() throws ParamErrorException {

    }
}
