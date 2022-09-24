package com.example.course.Infrastructure.Notifications.PaymentNotif;

import org.hibernate.boot.model.relational.QualifiedName;
import org.hibernate.boot.model.relational.SqlStringGenerationContext;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentListener {
    @RabbitListener(
            queues= PaymentNotificationConfig.QUEUE)
    public void UserNotificationService(Payment payment){
        System.out.println(payment.getUserId());
            System.out.println(payment.getCourseId());
            System.out.println(payment.getCoursePrice());
            System.out.println(payment.getPaying());
            System.out.println(new Date());
            try {
            TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }
    }
}
