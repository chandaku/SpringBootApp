package com.learn.springboot.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.springboot.model.Greetings;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class GreetingDeSerializer implements Deserializer<Greetings> {

    @Override
    public Greetings deserialize(String arg0, byte[] devBytes) {
        ObjectMapper mapper = new ObjectMapper();
        Greetings developer = null;
        try {
            developer = mapper.readValue(devBytes, Greetings.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return developer;
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
