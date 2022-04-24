package com.example.demo.userapplication.service;

import com.example.demo.userapplication.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();
    User findUserByID(Integer id);
  //  User findByUserName(String name);
    boolean deleteUser(User user);
    User updateUser(User user);
}
