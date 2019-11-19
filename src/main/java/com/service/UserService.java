package com.service;

import com.domain.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User addUser(User u);

    void deleteUser(Integer id);
}
