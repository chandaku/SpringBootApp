package com.learn.springboot.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.springboot.model.Greetings;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class GreetingSerializer implements Serializer<Greetings> {

    @Override
    public byte[] serialize(String arg0, Greetings greetings) {
        byte[] serializedBytes = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            serializedBytes = objectMapper.writeValueAsString(greetings).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serializedBytes;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }

    @Override
    public void configure(Map<String, ?> arg0, boolean arg1) {
        // TODO Auto-generated method stub
    }

}
