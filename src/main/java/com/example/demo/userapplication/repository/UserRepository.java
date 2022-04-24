package com.example.demo.userapplication.repository;

import com.example.demo.userapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query("SELECT u FROM USER u WHERE u.userName = :name")
//    public User getUserByName(@Param("name") String name);
}
