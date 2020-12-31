package com.demo.protobuf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProtobufApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProtobufApplication.class, args);
    }

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    @Bean
    RestTemplate restTemplate() {
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new ProtobufHttpMessageConverter());
        return rt;
    }


}
