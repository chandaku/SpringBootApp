package com.learn.springboot.resource;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;


@RestController
@RequestMapping("/rest/publish")
public class MessageProducer {

    private final JmsTemplate jmsTemplate;

    private final Queue queue;


    public MessageProducer(JmsTemplate jmsTemplate, Queue queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") final String message) {
        jmsTemplate.convertAndSend(queue, message);
        return "Published Successfully";
    }
}
