package com.example.course.Domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Course {

    private Integer courseId;
    private String name;
    private Float cost;


    public Course(){
        super();
    }

}
