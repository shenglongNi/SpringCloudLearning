package com.nsl.serviceribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/helloRibbon")
    public String hello() {
        return restTemplate.getForObject("http://HELLO-SERVICE/helloService?name", String.class);
    }

}
