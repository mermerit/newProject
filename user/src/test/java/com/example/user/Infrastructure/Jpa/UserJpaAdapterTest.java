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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        UserEntity user = new UserEntity(1,"meran","mermer","123",1);
        List<UserEntity> userEntity = Collections.singletonList(user);
        Mockito.when(userRepository.findAll()).thenReturn(userEntity);
        List <User> users=undertest.getAllUser();
        assertThat(users.size()).isEqualTo(1);
    }

    @Test
    void removeUser() {
        UserEntity entity = new UserEntity(10,"meran","mermer","123",1);
        Mockito.when(userRepository.findByUserId(1)).thenReturn(entity);
        undertest.removeUser(1);
        verify(userRepository).delete(entity);
    }

    @Test
    void removeUserThrowsError() {
        Mockito.when(userRepository.findByUserId(10)).thenReturn(null);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            undertest.removeUser(10);
        });
        //UserEntity entity = new UserEntity(10,"meran","mermer","123",1);
        String expectedMessage = "Did not find student id 10";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void getUserByIdThrowsError () {
        Integer id=10;
        Mockito.when(userRepository.findByUserId(10)).thenReturn(null);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            undertest.getUserById(id);
        });
        String expectedMessage = "Did not find student id "+id;
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getUserById() {
        UserEntity userEntity = new UserEntity
                (1,"meran","mermer","123",1);

        Mockito.when(userRepository.findByUserId(1)).thenReturn(userEntity);

        assertThat(undertest.getUserById(1).getUserId()).isEqualTo(userEntity.getUserId());
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