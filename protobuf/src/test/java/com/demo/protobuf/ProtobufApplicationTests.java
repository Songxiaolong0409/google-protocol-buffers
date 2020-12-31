package com.demo.protobuf;

import com.demo.protobuf.example.ProtobufExample;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProtobufApplicationTests {

    @Test
    void contextLoads() {
        //Protobuf byte[]格式例子
        ProtobufExample protobufExample=new ProtobufExample();
    }

    /**
     * pom 中 ${os.detected.classifier} 参数
     */
    public void printPom(){
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.arch"));
    }
}
