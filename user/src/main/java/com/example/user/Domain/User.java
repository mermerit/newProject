package com.example.user.Domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Integer userId;
    private String name;
    private String userName;
    private String password;
    private Integer getUserWithCourse;



}
