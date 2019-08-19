package service;

import com.proto.MyRPCGrpc;
import com.proto.MyThing;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Request1Impl extends MyRPCGrpc.MyRPCImplBase {

    private static final Logger logger = LoggerFactory.getLogger(Request1Impl.class);

    @Override
    public void sayHi(MyThing.Request request, StreamObserver<MyThing.Response> responseObserver) {
        logger.info("Request1 name:" + request.getName());
        //proto文件上定义的response返回信息
        MyThing.Response response = MyThing.Response.newBuilder().setName("Response Request1 name:" + request.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
