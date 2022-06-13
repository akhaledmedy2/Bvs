package com.example.bvs.interceptor;

import com.example.bvs.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class IntegrationInterceptor implements HandlerInterceptor {

    @Autowired
    private RouterService routerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute("client_url", request.getHeader("host"));
        return true;
    }
}