package com.example.bvs.service;

import com.example.bvs.dto.EventMessageDto;
import com.example.bvs.entity.Router;
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
    private RestTemplate restTemplate;

    public void composeAndPut(EventMessageDto messageDto) {
        // suppose that here will handle router http request then send it to message queuing service to register and event
        // suppose that here will be the entry point of the callback
        HttpEntity<EventMessageDto> request = new HttpEntity(messageDto, null);
        restTemplate.exchange("http://127.0.0.1:8080/webhook", HttpMethod.POST, request, String.class);

    }
}