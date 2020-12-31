package com.demo.grpc.server;

import com.demo.grpc.server.example.GrpcServerExample;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcServerApplication {

    public static void main(String[] args) {
        try {
            Server server = ServerBuilder.
                    forPort(8080)
                    .addService( new GrpcServerExample() )
                    .build().start();
            System.out.println( "grpc服务端启动成功, 端口=" + 8080 );
            server.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SpringApplication.run(GrpcServerApplication.class, args);
    }

}
