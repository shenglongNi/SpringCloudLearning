package com.nsl.serviceribbon.web;

import com.nsl.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {


    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private HelloService service;

    @GetMapping("/helloRibbon")
    public String hello() {
        return restTemplate.getForObject("http://HELLO-SERVICE/helloService?name", String.class);
    }

    @GetMapping("/getHello")
    public String getHello(String name) {

        return service.getHello(name);

    }
    @GetMapping("/getHello2")
    public String getHello2(String name) {

        return service.getHello2(name);

    }
}
