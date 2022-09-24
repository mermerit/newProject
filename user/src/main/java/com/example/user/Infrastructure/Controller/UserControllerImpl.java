package com.example.user.Infrastructure.Controller;

import com.example.user.Domain.User;

import com.example.user.Infrastructure.Jpa.UserJpaAdapter;
import com.example.user.Infrastructure.Jpa.UserRepository;
import com.example.user.Infrastructure.Service.UserService;
import com.example.user.Infrastructure.VO.ResponceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserControllerImpl implements UserController {
    private UserService userService;
    @Autowired
    private UserJpaAdapter userJpaAdapter;
    @Autowired
    public UserControllerImpl (UserService userService){
        this.userService=userService;
    }
    @Override
    public List<User> getUsers() {
        return userService.getAllUser();
    }

    @Override
    public User addUser(User user) {
        userService.addUser(user);
        return user;
    }

    @Override
    public User findUserById(Integer userId) {
        return userService.getUserById(userId);
    }

    @Override
    public String deleteUser(Integer userId) {
        userService.remove(userId);

        return "the ID"+userId+"was deleted";
    }

    @Override
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @Override
    public ResponceVo getUserWithCourse(Integer userId) {
        return userService.getUserWithCourse(userId);
    }
}
