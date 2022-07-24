package com.swagger.swagger.controller;

import com.swagger.swagger.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloSwagger {

    @GetMapping(value="/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping(value="/user")
    public User user(){
        return new User();
    }

    @ApiOperation("Hello控制类")
    @GetMapping(value="/hello1")
    public String hello1(String username){
        return "hello1"+username;
    }
}
