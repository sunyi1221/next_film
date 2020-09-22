package com.next.jiangzh.film.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.next.jiangzh.film.dao.entity.NextUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Sunyi
 * @since 2020-09-22
 */
public interface NextUserMapper extends BaseMapper<NextUser> {

    List<NextUser> getUsers(IPage<NextUser> iPage);
}
