package com.example.notification.Service;

import com.example.notification.Modul.UserEntity;
import com.example.notification.NotificationConfig.UserNotificationConfigration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service

public class UserNotificationService {

    @RabbitListener(
            queues= UserNotificationConfigration.QUEUE)


    public void UserNotificationService(UserEntity userEntity){

       // System.out.println(userEntity.getId());
        System.out.println(userEntity.getName());
        System.out.println(userEntity.getCourses());

    }
}
