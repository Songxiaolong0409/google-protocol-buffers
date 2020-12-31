package com.demo.grpc.server.example;

import com.demo.grpc.server.GrpcResult;
import com.demo.grpc.server.User;
import com.demo.grpc.server.UserServiceGrpc;
import io.grpc.stub.StreamObserver;

public class GrpcServerExample extends UserServiceGrpc.UserServiceImplBase {

    public void sayHelloWord(User request,
                             StreamObserver<GrpcResult> responseObserver) {

        GrpcResult result=GrpcResult.newBuilder()
                .setCode(200)
                .setData(request)
                .setMessage(request.getUsername()+" say Hello Word !!!")
                .build();

        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }



}
