package com.hivel.message.queue.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageResponse {
    private boolean result;
    private Object exception;
    private Object data;
}
