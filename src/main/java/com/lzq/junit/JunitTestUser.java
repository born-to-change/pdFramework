package com.lzq.junit;

import com.lzq.mapper.UserMapper;
import com.lzq.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTestUser {

    @Test
    public void testGetUser() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = ac.getBean(UserMapper.class);
        mapper.getUserById(7);
    }

    @Test
    public void testGetUserByUserLabel() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = ac.getBean(UserMapper.class);
        mapper.getUserByUserName("生变");
    }

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
        user.setUserName("罗卓群");
        mapper.createUser(user);
    }

    @Test
    public void testDeleteUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = ac.getBean(UserMapper.class);
        mapper.deleteUser(7);
    }

    @Test
    public void testUpdateUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = ac.getBean(UserMapper.class);
        User user = mapper.getUserById(6);
        user.setUserName("浩克杨帆");
        user.setUserPassword("123456qq");
        user.setTelephone("22121744963");
        mapper.updateUser(user);
    }

    @Test
    public void TestSplit() {
        String[] item = "C:\\fakepath\\s4393610.jpg".split("\\\\");

        System.out.print(item[item.length - 1]);


    }

}
