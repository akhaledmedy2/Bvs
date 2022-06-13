package com.consumer.consumer1.dto;

import lombok.Data;

@Data
public class EventMessageDto {
    private Object body;
    private String message;
    private String senderInfo;
}