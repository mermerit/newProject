package com.example.user.Infrastructure.Jpa;

import com.example.user.Domain.User;
import org.aspectj.lang.annotation.After;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserJpaAdapterTest {
    @Mock UserRepository userRepository;
    private AutoCloseable autoCloseable;
    private UserJpaAdapter undertest;

    @BeforeEach
    void setUp(){
        autoCloseable= MockitoAnnotations.openMocks(this);
        undertest= new UserJpaAdapter(userRepository);
    }
    @AfterEach
    void tearDown()throws Exception{
        autoCloseable.close();
    }


    @Test
    void addUser() {

        User user= new User(1,"meran","mermer","123",1);
        undertest.addUser(user);
        ArgumentCaptor<UserEntity>userEntityArgumentCaptor=
                ArgumentCaptor.forClass(UserEntity.class);
        verify(userRepository).save(userEntityArgumentCaptor.capture());

        UserEntity capture=userEntityArgumentCaptor.getValue();
        assertThat(capture.getUserId()).isEqualTo(user.getUserId());

    }

    @Test
    void getAllUser() {
    }

    @Test
    void removeUser() {







    }

    @Test
    void getUserById() {
        User user= new User(1,"meran","mermer","123",1);
        undertest.addUser(user);
        ArgumentCaptor<UserEntity>userEntityArgumentCaptor=
                ArgumentCaptor.forClass(UserEntity.class);
        verify(userRepository).save(userEntityArgumentCaptor.capture());

        UserEntity captureUser=userEntityArgumentCaptor.getValue();

        Mockito.when(userRepository.findByUserId(1)).thenReturn(captureUser);

        assertThat(undertest.getUserById(1).getUserId()).isEqualTo(captureUser.getUserId());

    }

    @Test
    void updateUser() {
        User user = new User(1,"meran","mermer","123",1);


        undertest.updateUser(user);

        ArgumentCaptor<UserEntity>userEntityArgumentCaptor=
                ArgumentCaptor.forClass(UserEntity.class);
        verify(userRepository).save(userEntityArgumentCaptor.capture());

        UserEntity capture= userEntityArgumentCaptor.getValue();

        Integer expected =user.getUserId();

        assertThat(capture.getUserId()).isEqualTo(expected);
    }


}