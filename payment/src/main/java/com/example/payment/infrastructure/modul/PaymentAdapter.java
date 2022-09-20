package com.example.payment.infrastructure.modul;

import com.example.payment.domain.PaymentStatus;
import com.example.payment.domain.PaymentStatusPort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentAdapter implements PaymentStatusPort {
    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentAdapter(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }


    @Override
    public PaymentStatus add(PaymentStatus paymentStatus) {
        PaymentStatusEntity paymentStatusEntity = new PaymentStatusEntity();
        BeanUtils.copyProperties(paymentStatus, paymentStatusEntity);
        paymentRepository.save(paymentStatusEntity);
        return paymentStatus;
    }
}
