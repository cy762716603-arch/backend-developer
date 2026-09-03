package me.scpark;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController

public class TestController {
    @GetMapping("/test")
    public String test(){
           return ("안녕?'http://localhost:8080/test' 에 대한 응답입니다.");
     }
    @GetMapping("/hi")
    public String hi(){
        return ("안녕?'http://localhost:8080/hi' 에 대한 응답입니다.");
    }
    @PostMapping ("/test")
    public String deleteTest(){
        return ("안녕?'http://localhost:8080/test' 에 대한 응답입니다.");
    }
    @PatchMapping ("/test")
    public String patch(){
        return ("안녕?'http://localhost:8080/test' 에 대한 응답입니다.");
    }
    @PutMapping ("/test")
    public String Put(){
        return ("안녕?'http://localhost:8080/test' 에 대한 응답입니다.");
    }
    @DeleteMapping ("/test")
    public String Delete(){
        return ("안녕?'http://localhost:8080/test' 에 대한 응답입니다.");
    }


}
