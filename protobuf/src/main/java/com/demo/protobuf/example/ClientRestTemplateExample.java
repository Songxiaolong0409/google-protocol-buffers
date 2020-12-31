package com.demo.protobuf.example;

import com.demo.protobuf.builder.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientRestTemplateExample {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/client1")
    public String client1() {
        String url="http://127.0.0.1:8081/getProtobuf/";

        UserBuilder.User obj = this.restTemplate.getForObject(url,
                UserBuilder.User.class);
        return obj.toString();
    }


}
