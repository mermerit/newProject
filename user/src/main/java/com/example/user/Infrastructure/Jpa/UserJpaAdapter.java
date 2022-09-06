package com.example.user.Infrastructure.Jpa;

import com.example.user.Domain.User;
import com.example.user.Domain.UserPort;
import com.example.user.Infrastructure.VO.Course;
import com.example.user.Infrastructure.VO.ResponceVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserJpaAdapter implements UserPort {

    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public UserJpaAdapter (UserRepository userRepository){
        this.userRepository=userRepository;

    }


    @Override
    public User addUser(User user) {
    UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List <User> userList = new ArrayList<>();
        List<UserEntity> userEntityList = userRepository.findAll();
        for ( UserEntity userEntity : userEntityList)
        {
            User user= new User();
            BeanUtils.copyProperties(userEntity,user);
            userList.add(user);
        }
        return userList;

    }

    @Override
    public void removeUser(Integer id) {

        UserEntity userEntity= new UserEntity();

        Optional<UserEntity> userEntityId= Optional.ofNullable(userRepository.findByUserId(id));

        UserEntity theUser =null;

        if (userEntityId.isPresent()) {

            theUser=userEntityId.get();

        }
        else
        {
            throw  new RuntimeException("Did not find student id "+id);
        }
        User user=  new User();
        BeanUtils.copyProperties(user,userEntity);
        userRepository.delete(theUser);

        }


    @Override
    public User getUserById(Integer id) {
        Optional<UserEntity> userEntity= Optional.ofNullable(userRepository.findByUserId(id));
        UserEntity theUser =null;
        if (userEntity.isPresent())
        {
            theUser=userEntity.get();
        }
        else
        {
            throw new RuntimeException("Did not find student id "+id);
        }
        User user= new User();
        BeanUtils.copyProperties(theUser,user);
        return user;


    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity= new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userRepository.save(userEntity);
        return user;
    }

    public ResponceVo getUserWithCourse(Integer id)
    {
        ResponceVo vo= new ResponceVo();
        UserEntity userEntity = userRepository.findByUserId(id);
        Course course
                =restTemplate.getForObject("http://localhost:8001/api/course/" + userEntity.getCourseId(),
                Course.class);

        vo.setUserEntity(userEntity);
        vo.setCourse(course);


        return vo;

    }
}
