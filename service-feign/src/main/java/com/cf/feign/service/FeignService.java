package com.cf.feign.service;

import com.cf.feign.config.FeignServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-provider",fallback = FeignServiceHystric.class)
public interface FeignService {

    @GetMapping("/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
