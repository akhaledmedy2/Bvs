package com.consumer.consumer1.listener;

import com.consumer.consumer1.dto.EventMessageDto;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RabbitMqListener {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Gson gson;

    @RabbitListener(queues = "consumer1")
    public void listen(String object) {
        System.out.println("Message read " + object);

        EventMessageDto eventMessageDto = gson.fromJson(object, EventMessageDto.class);

        HttpEntity<Object> request = new HttpEntity(eventMessageDto.getBody(), null);
        restTemplate.exchange(eventMessageDto.getSenderInfo() + "/webhook", HttpMethod.POST, request,
                String.class);
    }
}