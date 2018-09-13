package com.lzq.junit;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.lzq.mapper.UserMapper;
import com.lzq.pojo.User;
import lombok.Data;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.collections.Lists;
import org.testng.collections.Maps;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Comparator;
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
//        List<Integer> list = Lists.newArrayList(1,21,32,3,6,4);
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
//        System.out.println(filterList);
//
//        List mapList = list.stream().filter(it->it%2==1).map(it->it*it).collect(Collectors.toList());
//        System.out.println(mapList);

    }

    public static void main(String[] args) {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 17), new Human("Jack", 12),
                new Human("kevin", 20),new Human("wangkai", 28));
        // 方法一
//        humans.sort((Human h1, Human h2) -> h2.getAge() - h1.getAge());
//        humans.sort((h1, h2) -> h2.getAge() - h1.getAge());
//        //[ContentPageService.Human(name=wangkai, age=28), ContentPageService.Human(name=kevin, age=20), ContentPageService.Human(name=Sarah, age=17), ContentPageService.Human(name=Jack, age=12)]
//        // 方法二
//        Collections.sort(humans, new Comparator<Human>() {
//
//            @Override
//            public int compare(Human o1, Human o2) {
//                return o2.getAge() - o1.getAge();
//            }
//        });
//
//        // 方法三  默认升序 再反转操作 降序
//        Collections.sort(humans, Comparator.comparing(Human::getAge).reversed());
        // 方式四  多条件组合排序
        humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
        System.out.println(humans);

    }


    @Data // lombok 自动生成getter setter
    static class Human {
        private String name;
        private int age;

        public Human() {
            super();
        }

        public Human(final String name, final int age) {
            super();

            this.name = name;
            this.age = age;
        }


    }

}
