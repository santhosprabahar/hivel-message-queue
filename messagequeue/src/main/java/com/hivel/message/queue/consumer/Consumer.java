package com.hivel.message.queue.consumer;

import com.hivel.message.queue.dto.Message;
import com.hivel.message.queue.service.MessageProcessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @Autowired
    private MessageProcessorService messageProcessorService;

    @Bean
    public java.util.function.Consumer<Message> consume() {
        return message -> {
            log.info("Received queue message -> {}", message);
            messageProcessorService.save(message);
        };
    }
}
