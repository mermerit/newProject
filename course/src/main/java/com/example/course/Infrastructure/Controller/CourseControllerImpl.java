package com.example.course.Infrastructure.Controller;

import com.example.course.Domain.Course;

import com.example.course.Infrastructure.Notifications.Notification.UserNotificationConfig;
import com.example.course.Infrastructure.Service.CourseService;
import com.example.course.Infrastructure.UserCourseEntity.Service.UserService;
import com.example.course.Infrastructure.UserCourseEntity.UserEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping("/api")
public class CourseControllerImpl implements CourseController {
    private CourseService courseService;
    @Autowired
    private UserService userService;
    @Autowired
    RabbitTemplate template;

    @Autowired
    public CourseControllerImpl(CourseService courseService){
        this.courseService = courseService;
    }

    @Override
    public List<Course> getCourse() {
        return courseService.getAllCourse();
    }

    @Override
    public Course addCourse(Course course) {
        return courseService.addCourse(course);
    }

    @Override
    public Course findCourseById(Integer courseId) {
        return courseService.getCourseById(courseId);
    }

    @Override
    public String deleteCourse(Integer courseId) {
        courseService.remove(courseId);
        return "the ID "+courseId+" was deleted";
    }

    @Override
    public Course updateCourse(Course course)
    {
        return courseService.updateCourse(course);
    }

    @Override
    public UserEntity add(UserEntity userEntity) {
        template.convertAndSend(UserNotificationConfig.EXCHANGE,UserNotificationConfig.ROUTING_KEYS,userEntity);
        userEntity.setId(userEntity.getId());
        return userService.addUser(userEntity);
    }

    @Override

    public List<UserEntity> getAll() {

        return userService.getAll();
    }

    @Override
    public UserEntity findByid(Integer id) {
        return userService.findById(id);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return userService.updateUser(user);
    }

    @Override
    public String delete(Integer id) {

        userService.remove(id);

        return "the id "+ id +" was deleted ";
    }


}
