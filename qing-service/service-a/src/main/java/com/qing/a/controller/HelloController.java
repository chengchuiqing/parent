package com.qing.a.controller;


import com.qing.feign.clients.UserFeignClient;
import com.qing.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hi")
    public String hello() {
        User user = new User("张三", 23);
        System.out.println(user);
        return "hi!";
    }

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id) {
        User user = userFeignClient.queryById(id);
        return user;
    }

}
