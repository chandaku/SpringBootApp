package com.learn.springboot.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {


    @KafkaListener(topicPartitions = @TopicPartition(topic = "hello-kafka", partitionOffsets= {@PartitionOffset(partition = "0", initialOffset = "2755")}))
   // @KafkaListener(topics = "hello-kafka", groupId = "groupt_id")
    public void consume(String key, String value,  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        // Print statement
        System.out.println("message = " + value + " Partition Id " + partition );
    }

}

