package com.example.course.Infrastructure.Notifications.PaymentNotif;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class PaymentNotificationConfig {
    public static final String QUEUE="payment_notification_service_Queue";



}
