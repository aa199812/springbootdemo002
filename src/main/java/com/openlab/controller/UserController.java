package com.openlab.controller;

import com.openlab.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    List<User> list= Collections.synchronizedList(new ArrayList<User>());

    @GetMapping("/")
    public List<User> findUsersAll(){
        return list;
    }


    @ApiOperation(value = "根据用户的Id查找该用户的详细信息",notes = "查看用户备注信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",value = "用户Id",required = true,dataType = "Long")
    })
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        for(User user:list){
            if(user.getId()==id){
                return user;
            }
        }

        return null;
    }

    //新增用户

    @ApiOperation(value = "新增用户",notes = "保存用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user",value = "保存的用户对象",required = true,dataType = "User")
    })
    @PostMapping("/")
    public String createUser(User user){
        list.add(user);
        return "success";
    }

    //更新用户
    @PutMapping("/{id}")
    @ApiOperation(value = "根据用户的id更新用户",notes = "更新用户使用id")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "更新的用户Id",required = true,dataType = "Long"),
            @ApiImplicitParam(name="user",value = "更新的对象",required = true,dataType = "User")
    })
    public String updateUser(@PathVariable("id") Long id,User user){
        User user1=getUser(id);
        user1.setName(user.getName());
        user1.setAge(user.getAge());

        return "success";
    }

    //删除用户




    @ApiOperation(value = "删除用户对象根据id",notes = "根据用户id删除指定的用户对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "删除的用户Id",required = true,dataType = "Long")
    })
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        list.remove(getUser(id));
        return "success";
    }


}
