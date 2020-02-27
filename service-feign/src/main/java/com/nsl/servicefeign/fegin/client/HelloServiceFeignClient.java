package com.nsl.servicefeign.fegin.client;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hello-service")
public interface HelloServiceFeignClient {


    /**
     *
     * @param name 名称
     * @return
     * 此处 @RequestParam 中的参数不可省略。
     */
    @GetMapping("/getHello")
    public String getHello(@RequestParam("name") String name);


}
