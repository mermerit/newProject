package com.example.user.Infrastructure.VO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithCourses {
    private Integer id;
    private String name;
    private List<CourseList>courses;

}
