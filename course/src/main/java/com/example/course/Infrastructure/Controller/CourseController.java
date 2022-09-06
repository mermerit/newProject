package com.example.course.Infrastructure.Controller;

import com.example.course.Domain.Course;

import com.example.course.Infrastructure.Jpa.CourseEntity;
import com.example.course.Infrastructure.UserCourseEntity.CourseList;
import com.example.course.Infrastructure.UserCourseEntity.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface CourseController {
    @GetMapping("/course")
    List<Course> getCourse();

    @PostMapping("/course")
    Course addCourse(@RequestBody Course course);

    @GetMapping("/course/{courseId}")
    Course findCourseById(@PathVariable Integer courseId);
    @DeleteMapping("/course/{courseId}")
    String deleteCourse(@PathVariable Integer courseId);

    @PutMapping("/course")
    Course updateCourse(@RequestBody Course course);

    @PostMapping("/user")
    UserEntity add(@RequestBody UserEntity userEntity);

    @GetMapping("/user")
   List<UserEntity>  getAll();

    @GetMapping("/user/{id}")
    UserEntity findByid(@PathVariable Integer id);

    @PutMapping("/user")
    UserEntity updateUser( @RequestBody UserEntity user);

    @DeleteMapping("/user/{id}")
    String delete( @PathVariable Integer id);





}
