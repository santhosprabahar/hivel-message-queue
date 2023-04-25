package com.hivel.message.queue.mapper;

import com.hivel.message.queue.dto.Message;
import com.hivel.message.queue.entity.MessageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageEntity toMessageEntity(Message message);
    Message toMessage(MessageEntity messageEntity);
}
