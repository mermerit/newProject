package com.example.notification.Modul;

import lombok.Data;


import java.util.List;

@Data
public class UserEntity {

    private Integer id;
    private String Name;


    private List<CourseList> courses;
}
