package com.next.jiangzh.film.service.user;

import com.next.jiangzh.film.controller.user.vo.EnrollUserVO;
import com.next.jiangzh.film.controller.user.vo.UserInfoVO;
import com.next.jiangzh.film.dao.entity.NextUserT;
import com.next.jiangzh.film.service.common.exception.CommonServiceException;

import java.util.List;

public interface UserServiceAPI {

    /**
     * 方法描述:用户登记接口
     *
     * @param  enrollUserVO 用户登记对象
     */
    void userEnroll(EnrollUserVO enrollUserVO) throws CommonServiceException;

    /**
     * 方法描述:验证用户是否存在
     *
     * @param  userName 用户名
     */
    boolean checkUserName(String userName) throws CommonServiceException;

    /**
     * 方法描述:用户名密码校验
     *
     * @param  userName 用户名
     * @param  userPwd 密码
     */
    boolean userAuth(String userName, String userPwd) throws CommonServiceException;

    /**
     * 方法描述:获取用户信息
     *
     * @param  userId 用户ID
     */
    UserInfoVO describeUserInfo(String userId) throws CommonServiceException;

    /**
     * 方法描述:修改用户信息
     *
     * @param  userInfoVO 用户信息对象
     */
    UserInfoVO updateUserInfo(UserInfoVO userInfoVO) throws CommonServiceException;

    /**
     * 方法描述:查询用户信息
     *
     * @param  username 用户名
     */
    List<NextUserT> selectUser(String username);
}
