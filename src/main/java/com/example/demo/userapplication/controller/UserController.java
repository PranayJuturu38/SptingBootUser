package com.example.demo.userapplication.controller;

import com.example.demo.userapplication.exception.CustomException;
import com.example.demo.userapplication.model.User;
import com.example.demo.userapplication.repository.UserRepository;
import com.example.demo.userapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) throws CustomException {
        User user = new User();
        try{
            user = userService.findUserByID(id);

        return new ResponseEntity<User>(user,HttpStatus.FOUND);
    }catch (Exception e){

            return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/users/userName/{name}")
//    public ResponseEntity<User> getUserByName(@PathVariable String name) throws CustomException{
//        User user = new User();
//        try{
//
//            user = userService.findByUserName(name);
//            return new ResponseEntity<User>(user,HttpStatus.FOUND);
//
//        }catch (Exception e){
//            return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
//        }
//    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception{
        try {
            userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(user);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception{
      try{
          userService.createUser(user);
          return ResponseEntity.status(HttpStatus.CREATED).body(user);
      }catch (Exception e){
          return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(user);
      }
    }
}
