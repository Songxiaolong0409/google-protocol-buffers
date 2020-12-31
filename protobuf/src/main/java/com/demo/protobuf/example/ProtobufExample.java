package com.demo.protobuf.example;

import com.demo.protobuf.builder.UserBuilder;

/**
 * Protobuf byte[]格式例子
 */
public class ProtobufExample {

    public ProtobufExample(){
        UserBuilder.User builder=UserBuilder.User.newBuilder()
                .setEmail("xiaolong.song@fih-foxconn.com")
                .setEnable(false)
                .setSex(4)
                .setUsername("xiaolong.song").build();
        byte[] bytes=builder.toByteArray();

        for (byte b : bytes) {
           System.out.println(String.valueOf(b));
        }
    }
}
