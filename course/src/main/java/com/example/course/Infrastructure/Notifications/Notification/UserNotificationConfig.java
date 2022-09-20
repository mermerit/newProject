package com.example.course.Infrastructure.Notifications.Notification;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserNotificationConfig
{
    public static final String EXCHANGE="user_notification_service_exchange";
    public static final String ROUTING_KEYS="user_notification_service_routingKey";
    public static final String QUEUE="user_notification_service_Queue";

    @Bean
    public Queue customerOrderQueue(){
        return new Queue(QUEUE);
    }
    @Bean

    public TopicExchange exchange()
    {
        return new TopicExchange(EXCHANGE);
    }
    @Bean

    public Jackson2JsonMessageConverter converter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean

    public Binding bindingCustomerServiceQueue(TopicExchange exchange) {
        return BindingBuilder.bind(customerOrderQueue()).to(exchange).with(ROUTING_KEYS);
    }

}
