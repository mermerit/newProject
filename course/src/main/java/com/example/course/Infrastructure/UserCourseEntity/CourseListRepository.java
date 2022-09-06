package com.example.course.Infrastructure.UserCourseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CourseListRepository extends JpaRepository<CourseList,Integer> {
    CourseList findByPriceLessThan (Float price);
}
