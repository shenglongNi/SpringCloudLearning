package com.nsl.servicefeign.web;

import com.netflix.discovery.converters.Auto;
import com.nsl.servicefeign.fegin.client.HelloServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClientController {


    @Autowired
    private HelloServiceFeignClient helloServiceFeignClient;


    @GetMapping("/getHello")
    public String getHello(String name) {

        return helloServiceFeignClient.getHello(name);

    }


}
