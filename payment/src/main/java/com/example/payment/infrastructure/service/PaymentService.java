package com.example.payment.infrastructure.service;

import com.example.payment.domain.PaymentStatus;

public interface PaymentService {
    public PaymentStatus add(PaymentStatus paymentStatus);
}
