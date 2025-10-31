package com.example.Application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
public class Controller {
    
    @GetMapping
    public String greet(@RequestParam(defaultValue = "User") String param) {
        return String.format("Hello %s!", param);
    }
    
}
