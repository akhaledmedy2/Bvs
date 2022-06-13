package com.example.bvs.dto;

import lombok.Data;

@Data
public class EventMessageDto{
    private Object body;
    private String message;
    private String senderInfo;
}