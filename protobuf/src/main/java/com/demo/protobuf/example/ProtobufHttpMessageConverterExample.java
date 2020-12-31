package com.demo.protobuf.example;

import com.demo.protobuf.builder.UserBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProtobufHttpMessageConverterExample {

    @GetMapping("/getProtobuf")
    public UserBuilder.User getUsers(){
        UserBuilder.User builder=UserBuilder.User.newBuilder()
                .setEmail("xiaolong.song@fih-foxconn.com")
                .setEnable(false)
                .setSex(4)
                .setUsername("xiaolong.song").build();

        log.info(builder.toString());

        return builder;
    }
}
