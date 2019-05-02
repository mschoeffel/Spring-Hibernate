package spring.SpringBoot.FirstSetup.demo.src.main.java.com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MyRestController {

    @Value("${my.testMsg}")
    private String msg;

    @GetMapping("/")
    public String sayHello(){
        return msg + " Time on the server is: " + LocalDateTime.now();
    }

}
