package com.cf.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "sayHiError")
    public String sayHi(String name) {
        return restTemplate.getForObject("http://SERVICE-PROVIDER/hi?name="+name,String.class);
    }

    public String sayHiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
