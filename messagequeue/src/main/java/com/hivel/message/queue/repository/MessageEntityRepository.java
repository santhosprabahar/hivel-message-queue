package com.hivel.message.queue.repository;

import com.hivel.message.queue.dto.Message;
import com.hivel.message.queue.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageEntityRepository extends JpaRepository<MessageEntity,Long> {
    MessageEntity findByName(String name);

    void deleteByName(String name);
}
