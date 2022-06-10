package com.learn.springboot.conditonalbean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "notification", name = "service")
public class EmailNotification implements NotificationService {


    @Override
    public void send() {
        System.out.println("Email Sent Successfully");
    }
}
