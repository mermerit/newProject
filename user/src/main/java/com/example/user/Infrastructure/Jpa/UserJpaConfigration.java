package com.example.user.Infrastructure.Jpa;

import com.example.user.Domain.UserPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserJpaConfigration {

    @Bean
    public UserPort getUserPort (UserRepository userRepository){

    return  new UserJpaAdapter(userRepository);
}
}
