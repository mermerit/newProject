package com.example.user.Infrastructure.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseList {
    private Integer courseId;
    private String name;
    private Float price;
}
