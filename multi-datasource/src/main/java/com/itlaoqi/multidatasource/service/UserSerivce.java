package com.itlaoqi.multidatasource.service;

import com.itlaoqi.multidatasource.common.DataSourceContextHolder;
import com.itlaoqi.multidatasource.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserSerivce {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void insertDs1(User user){
        DataSourceContextHolder.setDataSource("ds1");
        String sql = "INSERT INTO user(username, password, nickname) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,  user.getUsername(), user.getPassword(), user.getNickname());
    }

    public void insertDs2(User user){
        DataSourceContextHolder.setDataSource("ds2");
        String sql = "INSERT INTO user(username, password, nickname) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,  user.getUsername(), user.getPassword(), user.getNickname());
    }
}
