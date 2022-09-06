package com.example.user.Domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@AllArgsConstructor
@Data
public class User {

    private Integer userId;
    private String name;
    private String userName;
    private String password;
    private Integer courseId;

    public User (){
        super();
    }

}
