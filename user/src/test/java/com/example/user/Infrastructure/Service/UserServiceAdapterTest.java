package com.example.user.Infrastructure.Service;

import com.example.user.Domain.User;
import com.example.user.Domain.UserPort;
import com.example.user.Infrastructure.Jpa.UserEntity;
import com.example.user.Infrastructure.Jpa.UserJpaAdapter;
import com.example.user.Infrastructure.Jpa.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class UserServiceAdapterTest {
    private AutoCloseable autoCloseable;
    private UserPort undertest;
    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        undertest= new UserJpaAdapter(userRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();

    }

    @Test
    void addUser() {
        User user = new User(1,"meran","mermer","123",1);
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
    void getUserById() {
    }

    @Test
    void remove() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void getUserWithCourse() {
    }
}