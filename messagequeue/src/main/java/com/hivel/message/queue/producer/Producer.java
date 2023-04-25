package com.hivel.message.queue.producer;

import com.hivel.message.queue.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private static final String BINDER_NAME = "produce-out-0";

    @Autowired
    private StreamBridge streamBridge;

    public void produce(Message message){
        streamBridge.send(BINDER_NAME,message);
    }
}
