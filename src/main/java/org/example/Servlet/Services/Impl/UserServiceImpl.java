package org.example.Servlet.Services.Impl;

import org.example.Servlet.Models.User;
import org.example.Servlet.Services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAllUsers() {
        return List.of();
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User findUser(int id) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }
}
