package com.openlab.controller;

import com.openlab.pojo.User;
import com.openlab.service.UserService;
import com.openlab.service.UserServiceMyBaits;
import com.openlab.service.impl.UserServiceImplMyBatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mybatisController")
public class MybatisController {

    @Autowired
    UserServiceMyBaits userServiceMyBaits;

    @GetMapping("/")
    public List<User> getAll(){

        return userServiceMyBaits.getUserAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userServiceMyBaits.getUser(id);
    }

    @PostMapping("/")
    public String save(User user){
        return userServiceMyBaits.createUser(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id,User user){
        return userServiceMyBaits.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
        public String deleteUser(@PathVariable("id") Long id){
        return userServiceMyBaits.deleteUser(id);
        }
}
