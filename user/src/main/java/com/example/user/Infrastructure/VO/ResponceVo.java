package com.example.user.Infrastructure.VO;

import com.example.user.Infrastructure.Jpa.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponceVo {

    private UserEntity userEntity;
    private UserWithCourses userWithCourses;




}
