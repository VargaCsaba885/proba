package com.csaba.demo.controller;


import com.csaba.demo.model.User;
import com.csaba.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("api/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("users")
    public List<User> getUsers(){
    return this.userRepository.findAll();
    }

//    @GetMapping("user/{id}")
//    public User getUser(@PathVariable int id) {
//        return userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
//    }
    @GetMapping("user/{id}")
public ResponseEntity<User> getUser(@PathVariable("id") int id) {
    try {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(null); // Hibás kérés esetén
    }
}
}
