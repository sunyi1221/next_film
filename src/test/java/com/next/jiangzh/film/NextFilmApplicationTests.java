package com.next.jiangzh.film;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.next.jiangzh.film.dao.entity.NextUser;
import com.next.jiangzh.film.dao.mapper.NextUserMapper;
import com.next.jiangzh.film.example.dao.UserMapper;
import com.next.jiangzh.film.example.dao.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
public class NextFilmApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NextUserMapper nextUserMapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void mybatisHelloWorld() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void mybatisGeneratorTest() {
        List<NextUser> nextUsers = nextUserMapper.selectList(null);
        nextUsers.forEach(System.out::println);
    }

    @Test
    public void defineSqlTest() {
        IPage<NextUser> iPage = new Page<>();
        iPage.setCurrent(1);
        iPage.setSize(2);
        List<NextUser> nextUsers = nextUserMapper.getUsers(iPage);
        nextUsers.forEach(System.out::println);
    }
}
