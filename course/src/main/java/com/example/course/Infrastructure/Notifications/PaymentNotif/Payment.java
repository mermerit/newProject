package com.example.course.Infrastructure.Notifications.PaymentNotif;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Integer id;
    private Integer userId;
    private Integer courseId;
    private String coursePrice;
    private String paying;
}
