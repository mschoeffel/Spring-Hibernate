package spring.REST.AuthorisationREST.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("spring.REST.AuthorisationREST")
public class DemoAppConfig implements WebMvcConfigurer {

}









