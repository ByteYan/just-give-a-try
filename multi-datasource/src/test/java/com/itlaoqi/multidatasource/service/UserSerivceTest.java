package com.itlaoqi.multidatasource.service;

import com.itlaoqi.multidatasource.MultiDatasourceApplication;
import com.itlaoqi.multidatasource.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = MultiDatasourceApplication.class)
class UserSerivceTest {
    @Resource
    private UserSerivce userSerivce;
    @Test
    void insertDs1() {
        userSerivce.insertDs1(new User("zhangsan","pass","张三"));
    }

    @Test
    void insertDs2() {
        userSerivce.insertDs2(new User("lisi","pass","李四"));
    }
}