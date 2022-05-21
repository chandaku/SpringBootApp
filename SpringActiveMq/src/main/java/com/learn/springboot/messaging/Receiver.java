package com.learn.springboot.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * https:///v=zaCXYkzLgJc
 */
@Component
public class Receiver {

    @JmsListener(destination = "standalone.queue")
    public void consume(String message) {
        System.out.println("Received " + message);
    }

    @JmsListener(destination = "standalone.queue")
    public void consume1(String message) {
        System.out.println("Received-1 " + message);
    }

}
