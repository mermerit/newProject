package com.example.payment.infrastructure.api;

import com.example.payment.domain.PaymentStatus;
import com.example.payment.infrastructure.PaymentMessageToCourse.PaymentNotificationConfigration;
import com.example.payment.infrastructure.modul.PaymentStatusEntity;
import com.example.payment.infrastructure.service.PaymentAdapterService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class controllerImpl implements ControllerPayment {
    private PaymentAdapterService paymentAdapterService;
    @Autowired
    RabbitTemplate template;

    controllerImpl(PaymentAdapterService paymentAdapterService){
        this.paymentAdapterService = paymentAdapterService;

    }

    @Override
    public PaymentStatus add(PaymentStatus paymentStatus) {

        template.convertAndSend(PaymentNotificationConfigration
                .EXCHANGE,PaymentNotificationConfigration
                .ROUTING_KEYS, paymentStatus);

        return paymentAdapterService.add(paymentStatus);


    }
}
