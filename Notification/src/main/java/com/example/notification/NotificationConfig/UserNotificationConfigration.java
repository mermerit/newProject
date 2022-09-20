package com.example.notification.NotificationConfig;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class UserNotificationConfigration {

    public static final String QUEUE="user_notification_service_Queue";

    @Bean

    public Jackson2JsonMessageConverter converter()
    {
        return new Jackson2JsonMessageConverter();
    }
}