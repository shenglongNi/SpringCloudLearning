package com.nsl.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nsl.serviceribbon.command.MyCustCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 这里只是测试，没有定义接口了
 */
@Service
public class HelloService {


    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getHelloErr")
    public String getHello(String name) {

        return restTemplate.getForObject("http://HELLO-SERVICE/getHello?name=" + name, String.class);
    }

    /**
     *
     * @param name 名称
     *
     *             MyCustCommand 有四种调用方式：
     *              1.execute(): 同步调用
     *              2.queue() : 异步调用，返回Feature对象
     *              3. observe(): 返回Observable对象，立即调用
     *              4. toObservable(): 返回Observable对象，所有订阅者订阅后执行
     * @return
     */
    @HystrixCommand(fallbackMethod = "getHelloErr")
    public String getHello2(String name) {

        return new MyCustCommand(restTemplate, name).execute();
    }


    public String getHelloErr(String name, Throwable e) {
        e.printStackTrace();
        return "Service Error:" + e.getMessage();
    }


}
