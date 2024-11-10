package org.example.Servlet.Services;

import org.example.Servlet.Models.User;

import java.util.List;

public interface UserService {

    public List<User> findAllUsers();

    public void saveUser(User user);

    public User findUser(int id);

    public User updateUser(User user);
    public User deleteUser(User user);
}
