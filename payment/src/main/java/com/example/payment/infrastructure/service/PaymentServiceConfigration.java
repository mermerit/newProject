package com.example.payment.infrastructure.service;

import com.example.payment.domain.PaymentStatusPort;
import org.springframework.context.annotation.Bean;

public class PaymentServiceConfigration {

    @Bean
    public PaymentService courseService (PaymentStatusPort paymentStatusPort){

        return  new PaymentAdapterService(paymentStatusPort);
    }
}
