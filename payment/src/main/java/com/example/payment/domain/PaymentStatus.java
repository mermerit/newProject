package com.example.payment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentStatus {
    private Integer id;
    private String userId;
    private String courseId;
    private String coursePrice;
    private String paying;
}
