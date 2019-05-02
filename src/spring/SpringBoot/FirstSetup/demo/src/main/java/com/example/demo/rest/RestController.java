package spring.SpringBoot.FirstSetup.demo.src.main.java.com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World! Time on the server is: " + LocalDateTime.now();
    }

}
