package com.example.user.Infrastructure.Jpa;
import com.example.user.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
     UserEntity findByUserId(Integer id);
}
