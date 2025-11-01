package com.example.Application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/")
public class Controller {
    private String[] db;

    public Controller(){
        db = new String[] {"item-1", "item-2", "item-3", "item-4"};
    }
    
    @GetMapping
    public String[] getData() {
        return db;
    }
    
}
