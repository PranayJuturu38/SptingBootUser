package com.example.demo.userapplication.serviceImpl;

import com.example.demo.userapplication.exception.CustomException;
import com.example.demo.userapplication.model.User;
import com.example.demo.userapplication.repository.UserRepository;
import com.example.demo.userapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
       // User userName = userRepository.getUserByName(user.getUserName());
        if (!existingUser.isPresent() ) {
            User newUser = new User();
            newUser.setId(user.getId());
            newUser.setUserName(user.getUserName());
            newUser.setPassword(user.getPassword());
            newUser.setEmail(user.getEmail());
            newUser.setContactNo(user.getContactNo());

            userRepository.save(newUser);
            return newUser;
        }else{
            throw new CustomException("User already exists!");
        }
    }
    @Override
    public List<User> getAllUsers() {
        if(userRepository.findAll()!=null){
            return userRepository.findAll();
        }
        else{
             throw new CustomException("No records found");
        }
    }

    @Override
    public User findUserByID(Integer id) {
        Optional<User> user =  userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        else
        {
            throw  new CustomException("No user found with id"+id);
        }
    }

//    @Override
//    public User findByUserName(String name) {
//        User user =  userRepository.getUserByName(name);
//        if(user!=null){
//            return user;
//        }
//        else
//        {
//            throw  new CustomException("No user found with name"+name);
//        }
//    }

    @Override
    public boolean deleteUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (existingUser.isPresent()) {

            userRepository.deleteById(user.getId());
            return true;
        } else {
            throw new CustomException("No department found with id: " + user.getId());
        }
    }

    @Override
    public User updateUser(User user) {

        Optional<User> existingUser = userRepository.findById(user.getId());
        if(existingUser.isPresent()){
            existingUser.get().setUserName(user.getUserName());
            existingUser.get().setPassword(user.getPassword());
            existingUser.get().setEmail(user.getEmail());
            existingUser.get().setContactNo(user.getContactNo());
            return userRepository.save(existingUser.get());
        }else{
            throw new CustomException("User does not exist");
        }
    }
}
