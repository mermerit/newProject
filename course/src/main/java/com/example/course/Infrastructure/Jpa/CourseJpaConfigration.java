package com.example.course.Infrastructure.Jpa;

import com.example.course.Domain.CoursePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseJpaConfigration {

    @Bean
    public CoursePort getCoursePort (CourseRepository courseRepository){

    return  new CourseJpaAdapter(courseRepository);
}
}
