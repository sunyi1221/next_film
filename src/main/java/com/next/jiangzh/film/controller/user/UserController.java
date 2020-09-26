package com.next.jiangzh.film.controller.user;

import com.next.jiangzh.film.common.utils.ToolUtils;
import com.next.jiangzh.film.controller.common.BaseResponseVO;
import com.next.jiangzh.film.controller.exception.NextFilmException;
import com.next.jiangzh.film.controller.exception.ParamErrorException;
import com.next.jiangzh.film.controller.user.vo.EnrollUserVO;
import com.next.jiangzh.film.service.common.exception.CommonServiceException;
import com.next.jiangzh.film.service.user.UserServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：用户表现层
 *
 * 创建人： Sunyi
 * 创建时间：2020/9/25 9:03
 *
 * @author Sunyi
 * @date 2020/9/25 9:03
 * @updateRemark 修改备注：用户表现层
 */
@RestController
@RequestMapping(value = "/nextfilm/user/")
public class UserController {

    @Autowired
    private UserServiceAPI userServiceAPI;

    @RequestMapping(value = "check", method = RequestMethod.POST)
    public BaseResponseVO checkUser(String username) throws CommonServiceException, NextFilmException {
        if (ToolUtils.isEmpty(username)) {
            throw new NextFilmException(1, "username不能为空！");
        }
        boolean hasUserName = userServiceAPI.checkUserName(username);
        if (hasUserName) {
            return BaseResponseVO.serviceFailed("用户名已存在！");
        } else {
            return BaseResponseVO.success();
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public BaseResponseVO register(@RequestBody EnrollUserVO enrollUserVO) throws CommonServiceException, ParamErrorException {
        // 参数校验 （贫血模型）
        enrollUserVO.checkParam();
        // 用户注册
        userServiceAPI.userEnroll(enrollUserVO);
        return BaseResponseVO.success();
    }

}
