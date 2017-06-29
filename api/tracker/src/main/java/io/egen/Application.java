package io.egen;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Aastha Jain on 6/20/2017.
 */

@Configuration
@EnableWebMvc
@ComponentScan
public class Application extends WebMvcConfigurerAdapter {

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*//*")
                .allowedOrigins("http://mocker.egen.io","http://localhost:8080")
                .allowedMethods("GET","POST","PUT", "DELETE","HEAD","OPTIONS")
                .allowedHeaders("header1", "header2", "header3")
                .exposedHeaders("header1", "header2")
                .allowCredentials(false).maxAge(3600);
    }*/
}
