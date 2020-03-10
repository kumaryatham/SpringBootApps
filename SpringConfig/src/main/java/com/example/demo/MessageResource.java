package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@RefreshScope
@RestController
@RequestMapping("/demo")
public class MessageResource {

    @Value("${welcome : default Alti}")
    @JsonProperty
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String welcome;

    @GetMapping("/welcome")
  
    public String welcome() {
        return  welcome;
    }
}
