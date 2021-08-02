package com.example.helloworld.controller;

import com.example.helloworld.dao.Employee;
import com.example.helloworld.dao.EmployeeMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")

public class HelloWorldController {
    @GetMapping("Hello")
    public String sayHello(){
        return "Hello World";
    }
    }
