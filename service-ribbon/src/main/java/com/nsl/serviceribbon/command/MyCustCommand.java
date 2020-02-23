package com.nsl.serviceribbon.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import org.springframework.web.client.RestTemplate;

public class MyCustCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;
    private String name;

    /**
     *
     * 配置Hystrix
     *               1. HystrixCommandGroupKey 先设置组名
     *               2. HystrixCommandKey 设置command Key 名称， 默认为实现类的类名称
     *               3. HystrixThreadPoolKey 设置command的 线程池名称，默认情况Hystrix会让在同一个组的command 使用相同的线程池
     *                  HystrixThreadPoolKey 可以让我们更细粒度的划分线程池。即同一个command 组下可以配置多个不同的线程池，对不同的业务
     *                  使用不同的线程池。
     * @param restTemplate
     * @param name
     */
    public MyCustCommand(RestTemplate restTemplate, String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("myCustGroup1"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("myCustCommandKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("myCustThreadPoolKey")));
        this.restTemplate = restTemplate;
        this.name = name;

    }

    @Override
    protected String run() throws Exception {
        return  restTemplate.getForObject("http://HELLO-SERVICE/getHello?name=" + name, String.class);
    }
}
