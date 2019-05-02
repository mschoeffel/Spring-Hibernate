package spring.SpringBoot.FirstSetup.demo.src.main.java.com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MyRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World! Time on the server is: " + LocalDateTime.now();
    }

}
