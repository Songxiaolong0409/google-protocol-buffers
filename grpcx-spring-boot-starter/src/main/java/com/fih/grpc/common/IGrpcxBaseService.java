package com.fih.grpc.common;

import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;

@Component
public interface IGrpcxBaseService<T> {

    public abstract void getGrpcxSuccessResult(StreamObserver<T> responseObserver, T t);

    public abstract void getGrpcxFailResult(StreamObserver<T> responseObserver, String errorMsg);
}
