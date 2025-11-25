package com.example.Application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = {"http://localhost/"})
public class Controller {
    private String[] db;

    public Controller(){
        db = new String[] {"item-1", "item-2", "item-3", "item-4", "item-5"};
    }
    
    @GetMapping
    public String[] getData() {
        return db;
    }
    
}
