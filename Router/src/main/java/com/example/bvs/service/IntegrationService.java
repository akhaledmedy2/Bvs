package com.example.bvs.service;

import com.example.bvs.dto.EventMessageDto;
import com.example.bvs.entity.Router;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Service
public class IntegrationService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void composeAndPut(String jsonString,Router router) {
        rabbitTemplate.convertAndSend(router.getQueueName(), jsonString);
    }
}