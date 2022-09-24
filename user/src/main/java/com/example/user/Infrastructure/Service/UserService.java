package com.example.user.Infrastructure.Service;
import com.example.user.Domain.User;
import com.example.user.Infrastructure.VO.ResponceVo;
import java.util.List;
public interface UserService {
    User addUser (User user);
    List <User> getAllUser();
    User getUserById(Integer id);
    void remove(Integer id);
    User updateUser(User user);
    ResponceVo getUserWithCourse(Integer id);


}
