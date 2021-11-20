package com.lchalela.pasajes.service;

import com.lchalela.pasajes.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(Long id);
    void saveUser(User user);
    void updateUser(Long id, User user);
    void deleteUserById(Long id);
}