package com.learn.springboot.elasticsearch.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "sample", name = "service")
public class NotificationConfiguration {
}
