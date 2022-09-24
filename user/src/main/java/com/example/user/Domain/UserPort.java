package com.example.user.Domain;


import com.example.user.Infrastructure.VO.ResponceVo;

import java.util.List;
public interface UserPort {

    User addUser(User  user);
    List <User> getAllUser();
    void removeUser (Integer id);
    User getUserById (Integer id);
    User updateUser(User user);
    ResponceVo getUserWithCourse(Integer id);





}
