package com.openlab.service.impl;

import com.openlab.dao.UserDao;
import com.openlab.pojo.User;
import com.openlab.service.UserService;
import com.openlab.service.UserServiceMyBaits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplMyBatis implements UserServiceMyBaits {
    @Autowired
    UserDao   userDao;

    
    public List<User> getUserAll() {
        return userDao.getAll();
    }

    
    public User getUser(Long id) {
        return userDao.findOne(id);
    }

    
    public String createUser(User user) {
        try {
            userDao.save(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }

    
    public String updateUser(Long id, User user) {
        try {
            user.setId(id);
            userDao.update(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }

    
    public String deleteUser(Long id) {
        try {
            userDao.delete(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }
}
