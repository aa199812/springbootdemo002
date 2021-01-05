package com.openlab.service;

import com.openlab.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> getUserAll();
    public User getUser(Long id);
    public String createUser(User user);
    public String updateUser(Long id,User user);
    public String deleteUser(Long id);
}
