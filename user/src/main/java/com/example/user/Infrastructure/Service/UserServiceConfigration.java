package com.example.user.Infrastructure.Service;

import com.example.user.Domain.UserPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;

@Configuration
public class UserServiceConfigration {

    @Bean
    public UserService userService (UserPort userPort){

        return  new UserServiceAdapter(userPort);
    }
}
