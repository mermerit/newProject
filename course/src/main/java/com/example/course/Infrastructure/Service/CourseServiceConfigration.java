package com.example.course.Infrastructure.Service;

import com.example.course.Domain.CoursePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseServiceConfigration {

    @Bean
    public CourseService courseService (CoursePort coursePort){

        return  new CourseServiceAdapter(coursePort);
    }
}
