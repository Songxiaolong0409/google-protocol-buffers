package com.demo.grpc.client;

import com.demo.grpc.client.example.GrpcClientExample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GprcClientApplicationTests {

    @Autowired
    private GrpcClientExample grpcClientExample;

    @Test
    void contextLoads() {

        grpcClientExample.sayHello();
    }

}
