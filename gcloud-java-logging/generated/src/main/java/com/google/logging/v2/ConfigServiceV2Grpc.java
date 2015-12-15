package com.google.logging.v2;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class ConfigServiceV2Grpc {

  private ConfigServiceV2Grpc() {}

  public static final String SERVICE_NAME = "google.logging.v2.ConfigServiceV2";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.ListSinksRequest,
      com.google.logging.v2.ListSinksResponse> METHOD_LIST_SINKS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.ConfigServiceV2", "ListSinks"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ListSinksRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ListSinksResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.GetSinkRequest,
      com.google.logging.v2.LogSink> METHOD_GET_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.ConfigServiceV2", "GetSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.GetSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.LogSink.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.CreateSinkRequest,
      com.google.logging.v2.LogSink> METHOD_CREATE_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.ConfigServiceV2", "CreateSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.CreateSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.LogSink.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.UpdateSinkRequest,
      com.google.logging.v2.LogSink> METHOD_UPDATE_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.ConfigServiceV2", "UpdateSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.UpdateSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.LogSink.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.DeleteSinkRequest,
      com.google.protobuf.Empty> METHOD_DELETE_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.ConfigServiceV2", "DeleteSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.DeleteSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance()));

  public static ConfigServiceV2Stub newStub(io.grpc.Channel channel) {
    return new ConfigServiceV2Stub(channel);
  }

  public static ConfigServiceV2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ConfigServiceV2BlockingStub(channel);
  }

  public static ConfigServiceV2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ConfigServiceV2FutureStub(channel);
  }

  public static interface ConfigServiceV2 {

    public void listSinks(com.google.logging.v2.ListSinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListSinksResponse> responseObserver);

    public void getSink(com.google.logging.v2.GetSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver);

    public void createSink(com.google.logging.v2.CreateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver);

    public void updateSink(com.google.logging.v2.UpdateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver);

    public void deleteSink(com.google.logging.v2.DeleteSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver);
  }

  public static interface ConfigServiceV2BlockingClient {

    public com.google.logging.v2.ListSinksResponse listSinks(com.google.logging.v2.ListSinksRequest request);

    public com.google.logging.v2.LogSink getSink(com.google.logging.v2.GetSinkRequest request);

    public com.google.logging.v2.LogSink createSink(com.google.logging.v2.CreateSinkRequest request);

    public com.google.logging.v2.LogSink updateSink(com.google.logging.v2.UpdateSinkRequest request);

    public com.google.protobuf.Empty deleteSink(com.google.logging.v2.DeleteSinkRequest request);
  }

  public static interface ConfigServiceV2FutureClient {

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.ListSinksResponse> listSinks(
        com.google.logging.v2.ListSinksRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogSink> getSink(
        com.google.logging.v2.GetSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogSink> createSink(
        com.google.logging.v2.CreateSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogSink> updateSink(
        com.google.logging.v2.UpdateSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteSink(
        com.google.logging.v2.DeleteSinkRequest request);
  }

  public static class ConfigServiceV2Stub extends io.grpc.stub.AbstractStub<ConfigServiceV2Stub>
      implements ConfigServiceV2 {
    private ConfigServiceV2Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceV2Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceV2Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceV2Stub(channel, callOptions);
    }

    @java.lang.Override
    public void listSinks(com.google.logging.v2.ListSinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListSinksResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_SINKS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void getSink(com.google.logging.v2.GetSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void createSink(com.google.logging.v2.CreateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void updateSink(com.google.logging.v2.UpdateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void deleteSink(com.google.logging.v2.DeleteSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_SINK, getCallOptions()), request, responseObserver);
    }
  }

  public static class ConfigServiceV2BlockingStub extends io.grpc.stub.AbstractStub<ConfigServiceV2BlockingStub>
      implements ConfigServiceV2BlockingClient {
    private ConfigServiceV2BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceV2BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceV2BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceV2BlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.logging.v2.ListSinksResponse listSinks(com.google.logging.v2.ListSinksRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_LIST_SINKS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v2.LogSink getSink(com.google.logging.v2.GetSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_GET_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v2.LogSink createSink(com.google.logging.v2.CreateSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_CREATE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v2.LogSink updateSink(com.google.logging.v2.UpdateSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_UPDATE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.protobuf.Empty deleteSink(com.google.logging.v2.DeleteSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_DELETE_SINK, getCallOptions()), request);
    }
  }

  public static class ConfigServiceV2FutureStub extends io.grpc.stub.AbstractStub<ConfigServiceV2FutureStub>
      implements ConfigServiceV2FutureClient {
    private ConfigServiceV2FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceV2FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceV2FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceV2FutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.ListSinksResponse> listSinks(
        com.google.logging.v2.ListSinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_SINKS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogSink> getSink(
        com.google.logging.v2.GetSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogSink> createSink(
        com.google.logging.v2.CreateSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogSink> updateSink(
        com.google.logging.v2.UpdateSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteSink(
        com.google.logging.v2.DeleteSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_SINK, getCallOptions()), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final ConfigServiceV2 serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_LIST_SINKS,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.ListSinksRequest,
              com.google.logging.v2.ListSinksResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.ListSinksRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v2.ListSinksResponse> responseObserver) {
              serviceImpl.listSinks(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_GET_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.GetSinkRequest,
              com.google.logging.v2.LogSink>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.GetSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
              serviceImpl.getSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_CREATE_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.CreateSinkRequest,
              com.google.logging.v2.LogSink>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.CreateSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
              serviceImpl.createSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_UPDATE_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.UpdateSinkRequest,
              com.google.logging.v2.LogSink>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.UpdateSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v2.LogSink> responseObserver) {
              serviceImpl.updateSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_DELETE_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.DeleteSinkRequest,
              com.google.protobuf.Empty>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.DeleteSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
              serviceImpl.deleteSink(request, responseObserver);
            }
          })).build();
  }
}
