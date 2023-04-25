package com.hivel.message.queue.controller;

import com.hivel.message.queue.dto.Message;
import com.hivel.message.queue.dto.MessageResponse;
import com.hivel.message.queue.entity.MessageEntity;
import com.hivel.message.queue.producer.Producer;
import com.hivel.message.queue.service.MessageProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    private Producer producer;

    @Autowired
    private MessageProcessorService messageProcessorService;

    @PostMapping("/message")
    public MessageResponse save(@RequestBody Message message){
        producer.produce(message);
        return MessageResponse.builder()
                .result(true)
                .build();
    }

    @GetMapping("/message")
    public MessageResponse get(@RequestParam(name = "name") String name){
        Message message = messageProcessorService.get(name);
        return MessageResponse.builder()
                .result(message!=null)
                .data(message)
                .build();
    }

    @PutMapping("/message")
    public MessageResponse put(@RequestBody Message message,@RequestParam(name = "name") String name){
        return messageProcessorService.put(message,name);
    }

    @DeleteMapping("/message")
    public MessageResponse delete(@RequestParam(name = "name") String name){
        return messageProcessorService.delete(name);
    }
}
