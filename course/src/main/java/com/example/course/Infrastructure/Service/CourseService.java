package com.example.course.Infrastructure.Service;

import com.example.course.Domain.Course;

import java.util.List;
public interface CourseService {

    Course addCourse (Course course);

    List <Course> getAllCourse();

    Course getCourseById(Integer id);

    void remove(Integer id);

    Course updateCourse(Course course);

}
