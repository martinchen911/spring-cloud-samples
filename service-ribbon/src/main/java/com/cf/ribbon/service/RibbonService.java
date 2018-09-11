package com.cf.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    public String sayHi(String name) {
        return restTemplate.getForObject("http://SERVICE-PROVIDER/hi?name="+name,String.class);
    }
}
