package service;

import com.proto.MyRPCGrpc;
import com.proto.MyThing;
import io.grpc.stub.StreamObserver;

public class Request2Impl extends MyRPCGrpc.MyRPCImplBase {

    @Override
    public void sayHi(MyThing.Request request, StreamObserver<MyThing.Response> responseObserver) {
        System.out.println("Request2 name:" + request.getName());
        //proto文件上定义的response返回信息
        MyThing.Response response = MyThing.Response.newBuilder().setName("Response Request2 name:" + request.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
