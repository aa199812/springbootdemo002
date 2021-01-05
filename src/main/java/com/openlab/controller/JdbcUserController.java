package com.openlab.controller;

import com.openlab.pojo.User;
import com.openlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jdbcController")
public class JdbcUserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> getAll(){
        return userService.getUserAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @PostMapping("/")
    public String save(User user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public String updateUser(Long id,User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
        public String deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
        }
}
