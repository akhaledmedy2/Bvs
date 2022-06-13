package com.example.bvs.service;

import com.example.bvs.dto.EventMessageDto;
import com.example.bvs.entity.Router;
import com.example.bvs.repository.RouterRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class RouterService {

    @Autowired
    private RouterRepository routerRepository;

    @Autowired
    private IntegrationService integrationService;

    @Autowired
    private Gson gson;

    @Async
    public void handleHttpClientRequest(Object requestBody, String consumer, HttpServletRequest request) {
        Router router = routerRepository.getRouterAccount(consumer);

        EventMessageDto messageDto = new EventMessageDto();
        messageDto.setBody(requestBody);
        messageDto.setSenderInfo(request.getAttribute("client_url").toString());
        messageDto.setMessage("Message from consumer " + router.getConsumerName());

        String jsonString = gson.toJson(messageDto);

        integrationService.composeAndPut(jsonString, router);
    }
}