package com.fih.grpc.common;

import com.google.protobuf.Any;
import io.grpc.stub.StreamObserver;

public class GrpcxBaseService<T> implements IGrpcxBaseService<T> {

    @Override
    public void getGrpcxSuccessResult(StreamObserver responseObserver, Object o) {

        /*GrpcResult result=GrpcResult.newBuilder()
                .setCode(200)
                .setData(Any.pack(request))
                .setMessage(request.getUsername()+" say Hello Word !!!")
                .build();*/

        //返回数据
        responseObserver.onNext(o);
        //完成响应
        responseObserver.onCompleted();
    }

    @Override
    public void getGrpcxFailResult(StreamObserver responseObserver, String errorMsg) {
        //返回数据
        responseObserver.onError(new Throwable(errorMsg));
        //完成响应
        responseObserver.onCompleted();
    }
}
