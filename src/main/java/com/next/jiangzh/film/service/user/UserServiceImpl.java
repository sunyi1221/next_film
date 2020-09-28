package com.next.jiangzh.film.service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.next.jiangzh.film.common.utils.MD5Util;
import com.next.jiangzh.film.common.utils.ToolUtils;
import com.next.jiangzh.film.controller.user.vo.EnrollUserVO;
import com.next.jiangzh.film.controller.user.vo.UserInfoVO;
import com.next.jiangzh.film.dao.entity.NextUserT;
import com.next.jiangzh.film.dao.mapper.NextUserTMapper;
import com.next.jiangzh.film.service.common.exception.CommonServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

/**
 * 类名称：用户Service接口实现类
 * <p>
 * 创建人： Sunyi
 * 创建时间：2020/9/23 17:56
 *
 * @author Sunyi
 * @date 2020/9/23 17:56
 * @updateRemark 修改备注：用户Service接口实现类
 */
@Service("userService")
public class UserServiceImpl implements UserServiceAPI {

    @Autowired
    private NextUserTMapper userTMapper;

    @Override
    public void userEnroll(EnrollUserVO enrollUserVO) throws CommonServiceException {
        NextUserT nextUserT = new NextUserT();
        // Spring提供的对象拷贝工具，将enrollUserVO中和nextUserT对象相同属性的属性值拷贝至nextUserT
        BeanUtils.copyProperties(enrollUserVO, nextUserT);
        nextUserT.setUserName(enrollUserVO.getUsername());
        nextUserT.setUserPwd(MD5Util.encrypt(enrollUserVO.getPassword()));

        int isSuccess = userTMapper.insert(nextUserT);
        // 判断是否插入成功，成功时isSuccess为1
        if (isSuccess != 1) {
            throw new CommonServiceException(500, "用户注册失败！");
        }
    }

    @Override
    public boolean checkUserName(String userName) throws CommonServiceException {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name", userName);
        // 判断当前用户名是否存在，如果hasUserName=0则不存在，否则已存在
        int hasUserName = userTMapper.selectCount(queryWrapper);
        return hasUserName == 0 ? false : true;
    }

    @Override
    public boolean userAuth(String userName, String userPwd) throws CommonServiceException {
        if (ToolUtils.isEmpty(userName) || ToolUtils.isEmpty(userPwd)) {
            throw new CommonServiceException(400, "用户名和密码不能为空！");
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name", userName);
        // 1、根据用户名获取用户信息，判断用户名是否存在
        List<NextUserT> list = userTMapper.selectList(queryWrapper);
        if (list.size() == 0) {
            return false;
        } else {
            // 2、如果存在则判断密码是否正确
            // 3、先对用户输入的密码进行MD5加密，然后再判断两个密码是否相等
            if (MD5Util.encrypt(userPwd).equals(list.get(0).getUserPwd())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserInfoVO describeUserInfo(String userId) throws CommonServiceException {
        NextUserT nextUserT = userTMapper.selectById(userId);
        if (nextUserT != null && nextUserT.getUuid() != null) {
            UserInfoVO userInfoVO = user2InfoVO(nextUserT);
            return userInfoVO;
        } else {
            throw new CommonServiceException(404, "用户编号为[" + userId + "]的用户不存在！");
        }
    }

    @Override
    public UserInfoVO updateUserInfo(UserInfoVO userInfoVO) throws CommonServiceException {
        NextUserT nextUserT = info2user(userInfoVO);
        if (userInfoVO != null && userInfoVO.getUuid() != null) {
            int isSuccess = userTMapper.updateById(nextUserT);
            if (isSuccess == 1) {
                UserInfoVO result = describeUserInfo(nextUserT.getUuid() + "");
                return result;
            } else {
                throw new CommonServiceException(500, "用户信息修改失败！");
            }
        } else {
            throw new CommonServiceException(404, "用户名编号为[" + userInfoVO.getUuid() + "]的用户不存在！");
        }
    }

    @Override
    public List<NextUserT> selectUser(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name", username);
        return userTMapper.selectList(queryWrapper);
    }


    /** -------------------------------- 以下都是自定义方法 -------------------------------- */

    /**
     * 方法描述:将用户BO对象转换成用户VO对象
     *
     * @param
     */
    private UserInfoVO user2InfoVO(NextUserT nextUserT) {
        UserInfoVO userInfoVO = new UserInfoVO();
        // 1、将属性名不一致的属性进行手动赋值
        userInfoVO.setUsername(nextUserT.getUserName());
        userInfoVO.setNickname(nextUserT.getNickName());

        if (ToolUtils.isNotEmpty(nextUserT.getLifeState())) {
            userInfoVO.setLifeState(nextUserT.getLifeState() + "");
        }

        // 将LocalDateTime时间转换成long类型的时间  +8表示东八区
        userInfoVO.setBeginTime(nextUserT.getBeginTime().toEpochSecond(ZoneOffset.of("+8")));
        userInfoVO.setUpdateTime(nextUserT.getUpdateTime().toEpochSecond(ZoneOffset.of("+8")));

        // 2、将属性名一致的属性通过Spring提供的工具类进行拷贝
        BeanUtils.copyProperties(nextUserT, userInfoVO);

        return userInfoVO;
    }

    /**
     * 方法描述:将用户VO对象转换成用户BO对象
     *
     * @param
     */
    private NextUserT info2user(UserInfoVO userInfoVO) {
        NextUserT nextUserT = new NextUserT();
        // 1、将属性名不一致的属性进行手动赋值
        nextUserT.setUserName(userInfoVO.getUsername());
        nextUserT.setNickName(userInfoVO.getNickname());

        // 用正则表达式判断是否为数字，再进行转换
        if (ToolUtils.isNumbers(userInfoVO.getLifeState())) {
            nextUserT.setLifeState(Integer.parseInt(userInfoVO.getLifeState()));
        }

        // 更新时间设置为数据库更新的时间
        nextUserT.setUpdateTime(LocalDateTime.now());

        // 2、将属性名一致的属性通过Spring提供的工具类进行拷贝
        BeanUtils.copyProperties(userInfoVO, nextUserT);

        return nextUserT;
    }

}
