package com.nsl.spring.cloud.helloservice.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceHelloController {


    @Value("${server.port}")
    private int port;

    @GetMapping("/helloService")
    public String helloService(@RequestParam String name) {

        return "hi:" + name + "; i am port:" + port;

    }

}
