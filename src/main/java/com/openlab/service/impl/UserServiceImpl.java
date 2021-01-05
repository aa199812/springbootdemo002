package com.openlab.service.impl;

import com.openlab.pojo.User;
import com.openlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    

    public List<User> getUserAll() {
        List list = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper(User.class));
        return list;
    }

   
    public User getUser(Long id) {
        User user =(User) jdbcTemplate.query("select * from user where id=?", new BeanPropertyRowMapper(User.class), id);
        return user;
    }

   
    public String createUser(User user) {
        int i = jdbcTemplate.update("insert  into  user (name,age)values(?,?)", user.getName(), user.getAge());
        if(i>0){
            return "success";
        }else{
            return "fail";
        }

    }

   
    public String updateUser(Long id, User user) {
        int i = jdbcTemplate.update("update    user set name=?,age=? where id=?", user.getName(), user.getAge(),id);
        if(i>0){
            return "success";
        }else{
            return "fail";
        }

    }

   
    public String deleteUser(Long id) {
        int i = jdbcTemplate.update("delete  from  user   where id=?",id);
        if(i>0){
            return "success";
        }else{
            return "fail";
        }
    }
}
