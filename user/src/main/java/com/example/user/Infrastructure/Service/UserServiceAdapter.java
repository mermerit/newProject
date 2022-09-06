package com.example.user.Infrastructure.Service;

import com.example.user.Domain.User;
import com.example.user.Domain.UserPort;
import com.example.user.Infrastructure.VO.ResponceVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceAdapter implements UserService{
    private UserPort userPort;

    @Autowired
  public   UserServiceAdapter (UserPort userPort){
       this.userPort=userPort;
  }

    @Override
    public User addUser(User user) {
        userPort.addUser(user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userPort.getAllUser();
    }

    @Override
    public User getUserById(Integer id) {
        return userPort.getUserById(id);
    }

    @Override
    public void remove(Integer id) {

        userPort.removeUser(id);
    }

    @Override
    public User updateUser(User user) {
        return userPort.updateUser(user);
    }

    @Override
    public ResponceVo getUserWithCourse(Integer id) {
        return userPort.getUserWithCourse(id);
    }
}
