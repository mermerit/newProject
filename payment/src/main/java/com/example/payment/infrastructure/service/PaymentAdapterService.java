package com.example.payment.infrastructure.service;

import com.example.payment.domain.PaymentStatus;
import com.example.payment.domain.PaymentStatusPort;
import com.example.payment.infrastructure.modul.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentAdapterService implements PaymentService{

    private PaymentStatusPort paymentStatusPort;

    @Autowired
    public PaymentAdapterService(PaymentStatusPort paymentStatusPort) {
        this.paymentStatusPort= paymentStatusPort;
    }





    @Override
    public PaymentStatus add(PaymentStatus paymentStatus) {
         paymentStatusPort.add(paymentStatus);
         return paymentStatus;

    }
}
