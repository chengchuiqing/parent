package com.qing.feign.clients;


import com.qing.feign.config.FeignClientConfiguration;
import com.qing.model.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-b", url = "http://localhost:8080", configuration = FeignClientConfiguration.class)
public interface UserFeignClient {

    @GetMapping("/feign/user/{id}")
    User queryById(@PathVariable("id") Long id);

}
