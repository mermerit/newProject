package com.example.user.Infrastructure.Jpa;


import com.example.user.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity,Integer> {

     UserEntity findByUserId(Integer id);
}
