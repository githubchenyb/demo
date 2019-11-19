package com.service;

import com.dao.UserDao;
import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return this.userDao.findAll();
    }

    @Override
    public User addUser(User u) {
        return this.userDao.save( u );
    }

    @Override
    public void deleteUser(Integer id) {
        this.userDao.deleteById( id );
    }
}
