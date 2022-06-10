package com.learn.springboot.conditonalbean;


import com.learn.springboot.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = Main.class)
@ActiveProfiles("dev")
class EmailNotificationTest {

    @Autowired
    EmailNotification emailNotification;

    @Test
    public void assertEmailNotification() {
        Assertions.assertNotNull(emailNotification);
    }



}