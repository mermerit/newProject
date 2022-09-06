package com.example.course.Infrastructure.UserCourseEntity.Service;

import com.example.course.Infrastructure.UserCourseEntity.UserEntity;
import com.example.course.Infrastructure.UserCourseEntity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService (UserRepository userRepository)
    {
        this.userRepository=userRepository;

    }

    public UserEntity addUser(UserEntity user)
    {
     return userRepository.save(user);
    }
    public List <UserEntity>getAll(){
        return userRepository.findAll();
    }

    public UserEntity findById (Integer id) {

        Optional<UserEntity> userEntity = userRepository.findById(id);
        UserEntity theUser =null;
        if (userEntity.isPresent())
        {
            theUser=userEntity.get();
        }
        else
        {
            throw new RuntimeException("Did not find course id "+id);

        }
        return theUser;

    }
    public UserEntity updateUser(UserEntity userEntity){

        return userRepository.save(userEntity);
    }
    public void remove(Integer id){

        Optional<UserEntity> userEntity = userRepository.findById(id);
        UserEntity theUser =null;
        if (userEntity.isPresent())
        {
            theUser=userEntity.get();
        }
        else
        {
            throw new RuntimeException("Did not find course id "+id);

        }
        userRepository.delete(theUser);


    }



}
