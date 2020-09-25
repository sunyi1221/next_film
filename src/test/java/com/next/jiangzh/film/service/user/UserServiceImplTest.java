package com.next.jiangzh.film.service.user;

import com.next.jiangzh.film.controller.user.vo.EnrollUserVO;
import com.next.jiangzh.film.controller.user.vo.UserInfoVO;
import com.next.jiangzh.film.service.common.exception.CommonServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceAPI userServiceAPI;

    @Test
    public void userEnroll() throws CommonServiceException {
        EnrollUserVO enrollUserVO = new EnrollUserVO();
        enrollUserVO.setUsername("1");
        enrollUserVO.setPassword("1");
        enrollUserVO.setEmail("1");
        enrollUserVO.setPhone("1");
        enrollUserVO.setAddress("1");
        userServiceAPI.userEnroll(enrollUserVO);
    }

    @Test
    public void checkUserName() {

    }

    @Test
    public void userAuth() {

    }

    @Test
    public void describeUserInfo() throws CommonServiceException {
        String userId = "8";
        System.out.println(userServiceAPI.describeUserInfo(userId));
    }

    @Test
    public void updateUserInfo() throws CommonServiceException {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUuid(4);
        userInfoVO.setLifeState("0");
        System.out.println(userServiceAPI.updateUserInfo(userInfoVO));
    }
}