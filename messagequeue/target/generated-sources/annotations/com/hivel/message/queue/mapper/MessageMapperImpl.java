package com.hivel.message.queue.mapper;

import com.hivel.message.queue.dto.Message;
import com.hivel.message.queue.entity.MessageEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-24T18:17:49+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Homebrew)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public MessageEntity toMessageEntity(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageEntity.MessageEntityBuilder messageEntity = MessageEntity.builder();

        messageEntity.name( message.getName() );

        return messageEntity.build();
    }

    @Override
    public Message toMessage(MessageEntity messageEntity) {
        if ( messageEntity == null ) {
            return null;
        }

        Message.MessageBuilder message = Message.builder();

        message.name( messageEntity.getName() );

        return message.build();
    }
}
