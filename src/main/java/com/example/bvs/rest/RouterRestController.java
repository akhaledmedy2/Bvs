package com.example.bvs.rest;

import com.example.bvs.dto.EventMessageDto;
import com.example.bvs.dto.RouterCreateDto;
import com.example.bvs.dto.RouterDto;
import com.example.bvs.service.RouterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Router", tags = "Router", description = "Router Endpoints")
@RestController
@RequestMapping(path = "/")
public class RouterRestController {

    @Autowired
    private RouterService routerService;

    @PostMapping(path = "/webhook", produces = MediaType.APPLICATION_JSON_VALUE)
    public void webhook(@RequestBody EventMessageDto eventMessageDto) {
        System.out.println("Callback Success with response " + eventMessageDto.toString());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> consume() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RouterDto> createRouter(@RequestBody RouterCreateDto createDto) {
        return new ResponseEntity<>(routerService.createRouter(createDto), HttpStatus.OK);
    }
}