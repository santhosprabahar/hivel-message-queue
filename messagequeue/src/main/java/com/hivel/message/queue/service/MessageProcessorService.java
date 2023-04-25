package com.hivel.message.queue.service;

import com.hivel.message.queue.dto.Message;
import com.hivel.message.queue.dto.MessageResponse;
import com.hivel.message.queue.entity.MessageEntity;
import com.hivel.message.queue.mapper.MessageMapper;
import com.hivel.message.queue.repository.MessageEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageProcessorService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private MessageEntityRepository messageEntityRepository;

    public void save(Message message){
        if(messageEntityRepository.findByName(message.getName()) != null){
            log.info("Name already found");
            return;
        }
        messageEntityRepository.save(messageMapper.toMessageEntity(message));
    }

    public Message get(String name){
        return messageMapper.toMessage(messageEntityRepository.findByName(name));
    }

    public MessageResponse delete(String name){
        MessageEntity messageEntity = messageEntityRepository.findByName(name);
        if(messageEntity == null)
            return MessageResponse.builder()
                    .result(false)
                    .exception("Name not found")
                    .build();
        messageEntityRepository.delete(messageEntity);
        return MessageResponse.builder()
                .result(true)
                .build();
    }

    public MessageResponse put(Message message,String name){
        MessageEntity messageEntity = messageEntityRepository.findByName(name);
        if(messageEntity == null)
            return MessageResponse.builder()
                    .result(false)
                    .exception("Name not found")
                    .build();
        MessageEntity messageEntity1 = MessageEntity.builder()
                        .id(messageEntity.getId())
                                .name(message.getName())
                                        .build();

        messageEntityRepository.save(messageEntity1);
        return MessageResponse.builder()
                .result(true)
                .build();

    }
}
