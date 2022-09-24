package com.example.user.Infrastructure.Controller;

import com.example.user.Domain.User;

import com.example.user.Infrastructure.VO.ResponceVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {
    @GetMapping("/user")
    List<User> getUsers();
    @PostMapping("/user")
    User addUser(@RequestBody User user);
    @GetMapping("/user/{userId}")
    User findUserById(@PathVariable Integer userId);
    @DeleteMapping("/user/{userId}")
    String deleteUser(@PathVariable Integer userId);
    @PutMapping("/user")
    User updateUser(@RequestBody User user);
    @GetMapping("/{userId}")
    ResponceVo getUserWithCourse(@PathVariable Integer userId );




}
