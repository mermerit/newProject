package com.example.course.Domain;

import java.util.List;
public interface CoursePort {
    Course addCourse(Course course);
    List <Course> getAllCourse();
    void removeCourse (Integer id);
    Course getCourseById (Integer id);
    Course updateCourse(Course course);

}
