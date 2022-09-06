package com.example.course.Infrastructure.Jpa;

import com.example.course.Domain.Course;
import com.example.course.Domain.CoursePort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseJpaAdapter implements CoursePort {

    private CourseRepository courseRepository;

    @Autowired
    public CourseJpaAdapter(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }


    @Override
    public Course addCourse(Course course) {
    CourseEntity courseEntity = new CourseEntity();
        BeanUtils.copyProperties(course, courseEntity);
        courseRepository.save(courseEntity);
        return course;
    }

    @Override
    public List<Course> getAllCourse() {
        List <Course> courseList = new ArrayList<>();
        List<CourseEntity> courseEntityList = courseRepository.findAll();
        for ( CourseEntity courseEntity : courseEntityList)
        {
            Course course= new Course();
            BeanUtils.copyProperties(courseEntity,course);
            courseList.add(course);
        }
        return courseList;

    }

    @Override
    public void removeCourse(Integer id) {

        CourseEntity courseEntity = new CourseEntity();

        Optional<CourseEntity> courseEntityId= Optional.ofNullable(courseRepository.findByCourseId(id));

        CourseEntity theCourse  =null;

        if (courseEntityId.isPresent()) {

            theCourse=courseEntityId.get();

        }
        else
        {
            throw  new RuntimeException("Did not find Course id "+id);
        }
        Course course=  new Course();
        BeanUtils.copyProperties(course, courseEntity);
        courseRepository.delete(theCourse);

        }


    @Override
    public Course getCourseById(Integer id) {
        Optional<CourseEntity> courseEntity= Optional.ofNullable(courseRepository.findByCourseId(id));
        CourseEntity theCourse =null;
        if (courseEntity.isPresent())
        {
            theCourse=courseEntity.get();
        }
        else
        {
            throw new RuntimeException("Did not find course id "+id);
        }
        Course course= new Course();
        BeanUtils.copyProperties(theCourse,course);
        return course;


    }

    @Override
    public Course updateCourse(Course course) {
        CourseEntity courseEntity = new CourseEntity();
        BeanUtils.copyProperties(course, courseEntity);
        courseRepository.save(courseEntity);
        return course;
    }
}
