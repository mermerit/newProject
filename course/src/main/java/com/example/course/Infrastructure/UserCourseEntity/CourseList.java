package com.example.course.Infrastructure.UserCourseEntity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "courseList")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class CourseList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer courseId;
    @Column
    private String name;
    @Column
    private Float price;




}
