package com.example.payment.infrastructure.api;

import com.example.payment.domain.PaymentStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ControllerPayment {
    @PostMapping("/payment")
    PaymentStatus add(@RequestBody PaymentStatus paymentStatus);
}
