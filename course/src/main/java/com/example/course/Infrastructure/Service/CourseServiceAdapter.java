package com.example.course.Infrastructure.Service;

import com.example.course.Domain.Course;
import com.example.course.Domain.CoursePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public class CourseServiceAdapter implements CourseService {
    private CoursePort coursePort;
    @Autowired
  public CourseServiceAdapter(CoursePort coursePort){
       this.coursePort=coursePort;
  }
    @Override
    public Course addCourse(Course course) {
        coursePort.addCourse(course);
        return course;
    }
    @Override
    public List<Course> getAllCourse() {
        return coursePort.getAllCourse();
    }
    @Override
    public Course getCourseById(Integer id) {
        return coursePort.getCourseById(id);
    }
    @Override
    public void remove(Integer id) {
        coursePort.removeCourse(id);
    }

    @Override
    public Course updateCourse(Course course) {
        return coursePort.updateCourse(course);
    }
}
