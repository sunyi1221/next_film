package com.next.jiangzh.film.controller.auth.controller;

import com.next.jiangzh.film.controller.auth.controller.vo.AuthRequestVO;
import com.next.jiangzh.film.controller.auth.controller.vo.AuthResponseVO;
import com.next.jiangzh.film.controller.auth.util.JwtTokenUtil;
import com.next.jiangzh.film.controller.common.BaseResponseVO;
import com.next.jiangzh.film.controller.exception.ParamErrorException;
import com.next.jiangzh.film.service.common.exception.CommonServiceException;
import com.next.jiangzh.film.service.user.UserServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：jwt验证处理Controller
 * <p>
 * 创建人： Sunyi
 * 创建时间：2020/9/27 13:33
 *
 * @author Sunyi
 * @date 2020/9/27 13:33
 * @updateRemark 修改备注：jwt验证处理Controller
 */
@RestController
public class AuthController {

    @Autowired
    private UserServiceAPI userServiceAPI;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "auth", method = RequestMethod.POST)
    public BaseResponseVO auth(@RequestBody AuthRequestVO authRequestVO) throws ParamErrorException, CommonServiceException {
        // 参数校验
        authRequestVO.checkParam();
        // 用户名密码校验
        boolean isValid = userServiceAPI.userAuth(authRequestVO.getUsername(), authRequestVO.getPassword());

        if (isValid) {
            String randomKey = jwtTokenUtil.getRandomKey();
            String token = jwtTokenUtil.generateToken(authRequestVO.getUsername(), randomKey);

            AuthResponseVO authResponseVO = AuthResponseVO.builder()
                    .randomKey(randomKey)
                    .token(token).build();
            return BaseResponseVO.success(authResponseVO);
        } else {
            return BaseResponseVO.serviceFailed(1, "用户名或密码不正确！");
        }
    }

}
