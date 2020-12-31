package com.demo.grpc.client.example;

import com.demo.grpc.server.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.demo.grpc.server.UserServiceGrpc.newBlockingStub;

@Component
@Slf4j
public class GrpcClientExample {

    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    public void sayHello(){
        ManagedChannel managedChannel= ManagedChannelBuilder
                .forAddress("localhost",8080).usePlaintext().build();
        userServiceBlockingStub=newBlockingStub(managedChannel);

        User user=User.newBuilder()
                .setUsername("宋小龙")
                .build();

        GrpcResult result=userServiceBlockingStub.sayHelloWord(user);

        log.info("============================");
        log.info("Code:{},Message:{}",
                result.getCode(),result.getMessage());

        managedChannel.shutdownNow();
    }


    /*private static final String host = "localhost";
    private static final int serverPort = 6565;

    public static void main( String[] args ) throws Exception {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress( host, serverPort ).usePlaintext().build();
        try {
            RPCDateServiceGrpc.RPCDateServiceBlockingStub rpcDateService = newBlockingStub( managedChannel );
            RPCDateRequest rpcDateRequest = RPCDateRequest
                    .newBuilder()
                    .setUserName("hansonwang99")
                    .build();
            RPCDateResponse rpcDateResponse = rpcDateService.getDate( rpcDateRequest );
            System.out.println( rpcDateResponse.getServerDate() );
        } finally {
            managedChannel.shutdown();
        }
    }*/
}
