package com.lzq.junit;

import com.lzq.mapper.UserMapper;
import com.lzq.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void testCreateUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = ac.getBean(UserMapper.class);
        User user = new User();
        user.setUserPassword("123");
        user.setTelephone("22121744963");
        user.setToken("qwqeqwwq1121231231");
        user.setIsAdmin(1);
        user.setIsRoot(1);
        user.setMemoryQuota(10);
        user.setProSize(5);
        user.setUserName("生变");
        mapper.createUser(user);
    }

    @Test
    public void testUpdateUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = ac.getBean(UserMapper.class);
        User user = mapper.getUserById(1);
        user.setUserPassword("123456");
        mapper.updateUser(user);
    }
    @Test
    public void testDeleteUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = ac.getBean(UserMapper.class);
        mapper.deleteUser(1);
    }

    @Test
    public void testGetUserByUserName() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = ac.getBean(UserMapper.class);
        mapper.getUserByUserName("生变");
    }

}
