package com.example.course.Infrastructure.Jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
     CourseEntity findByCourseId(Integer id);
}
