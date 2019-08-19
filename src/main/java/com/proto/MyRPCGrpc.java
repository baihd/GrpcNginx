package com.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.0)",
    comments = "Source: hello.proto")
public class MyRPCGrpc {

  private MyRPCGrpc() {}

  public static final String SERVICE_NAME = "MyRPC";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.MyThing.Request,
      com.proto.MyThing.Response> METHOD_SAY_HI =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "MyRPC", "sayHi"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.proto.MyThing.Request.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.proto.MyThing.Response.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MyRPCStub newStub(io.grpc.Channel channel) {
    return new MyRPCStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MyRPCBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MyRPCBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static MyRPCFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MyRPCFutureStub(channel);
  }

  /**
   */
  public static abstract class MyRPCImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHi(com.proto.MyThing.Request request,
        io.grpc.stub.StreamObserver<com.proto.MyThing.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAY_HI, responseObserver);
    }

    @Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SAY_HI,
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.MyThing.Request,
                com.proto.MyThing.Response>(
                  this, METHODID_SAY_HI)))
          .build();
    }
  }

  /**
   */
  public static final class MyRPCStub extends io.grpc.stub.AbstractStub<MyRPCStub> {
    private MyRPCStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MyRPCStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected MyRPCStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MyRPCStub(channel, callOptions);
    }

    /**
     */
    public void sayHi(com.proto.MyThing.Request request,
        io.grpc.stub.StreamObserver<com.proto.MyThing.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAY_HI, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MyRPCBlockingStub extends io.grpc.stub.AbstractStub<MyRPCBlockingStub> {
    private MyRPCBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MyRPCBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected MyRPCBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MyRPCBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.MyThing.Response sayHi(com.proto.MyThing.Request request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAY_HI, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MyRPCFutureStub extends io.grpc.stub.AbstractStub<MyRPCFutureStub> {
    private MyRPCFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MyRPCFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected MyRPCFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MyRPCFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.MyThing.Response> sayHi(
        com.proto.MyThing.Request request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAY_HI, getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HI = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MyRPCImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(MyRPCImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HI:
          serviceImpl.sayHi((com.proto.MyThing.Request) request,
              (io.grpc.stub.StreamObserver<com.proto.MyThing.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_SAY_HI);
  }

}
