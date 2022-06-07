package com.example.bvs.service;

import com.example.bvs.dto.EventMessageDto;
import com.example.bvs.dto.RouterCreateDto;
import com.example.bvs.dto.RouterDto;
import com.example.bvs.entity.Router;
import com.example.bvs.mapper.RouterMapper;
import com.example.bvs.repository.RouterRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class RouterService {

    private RouterMapper routerMapper = Mappers.getMapper(RouterMapper.class);

    @Autowired
    private RouterRepository routerRepository;

    @Autowired
    private IntegrationService integrationService;

    public RouterDto createRouter(RouterCreateDto createDto) {
        Router router = routerRepository.createRouter(createDto.getAccountName());
        return routerMapper.mapToRouterDto(router);
    }

    @Async
    public void handleHttpClientRequest(String host , String message , long accountId) {
        Router router = routerRepository.getRouterAccount(accountId);
        EventMessageDto messageDto = new EventMessageDto();

        messageDto.setMessage(message);
        messageDto.setBody(routerMapper.mapToRouterDto(router));
        messageDto.setSender_info(host);

        integrationService.composeAndPut(messageDto);
    }
}