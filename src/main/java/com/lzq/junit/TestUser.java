package com.lzq.junit;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.lzq.mapper.UserMapper;
import com.lzq.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.collections.Lists;
import org.testng.collections.Maps;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Test
    public void TestLambda(){
        List<Integer> list = Lists.newArrayList(1,21,32,3,6,4);
        String str = "dsdwjehwqjhhjweh";
        char[] a = str.toCharArray();
        List<Integer> strList = Lists.newArrayList();
        Map<Integer,Integer> strMap = Maps.newHashMap();
        for(int i=0;i<a.length;i++){
            strMap.put((int)a[i],0);
            strList.add((int)a[i]);
        }
        System.out.println(strList);
        strList.forEach(x->{
            strMap.put(x,strMap.get(x)+1);
        });
        strList.forEach(it->{
            strMap.forEach((x,y)->{
                if(x==it && y==1){
                    System.out.print((char)x.intValue());
                }
            });
        });
//        List filterList = list.stream().filter(it->it%2==0).collect(Collectors.toList());
//
//        List mapList = list.stream().filter(it->it%2==1).map(it->it*it).collect(Collectors.toList());
//        System.out.println(a[0]);

    }

}
