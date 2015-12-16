package com.google.logging.v1;

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
public class ConfigServiceGrpc {

  private ConfigServiceGrpc() {}

  public static final String SERVICE_NAME = "google.logging.v1.ConfigService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.ListLogSinksRequest,
      com.google.logging.v1.ListLogSinksResponse> METHOD_LIST_LOG_SINKS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "ListLogSinks"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.ListLogSinksRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.ListLogSinksResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.GetLogSinkRequest,
      com.google.logging.v1.LogSink> METHOD_GET_LOG_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "GetLogSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.GetLogSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.LogSink.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.CreateLogSinkRequest,
      com.google.logging.v1.LogSink> METHOD_CREATE_LOG_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "CreateLogSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.CreateLogSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.LogSink.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.UpdateLogSinkRequest,
      com.google.logging.v1.LogSink> METHOD_UPDATE_LOG_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "UpdateLogSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.UpdateLogSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.LogSink.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.DeleteLogSinkRequest,
      com.google.protobuf.Empty> METHOD_DELETE_LOG_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "DeleteLogSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.DeleteLogSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.ListLogServiceSinksRequest,
      com.google.logging.v1.ListLogServiceSinksResponse> METHOD_LIST_LOG_SERVICE_SINKS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "ListLogServiceSinks"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.ListLogServiceSinksRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.ListLogServiceSinksResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.GetLogServiceSinkRequest,
      com.google.logging.v1.LogSink> METHOD_GET_LOG_SERVICE_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "GetLogServiceSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.GetLogServiceSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.LogSink.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.CreateLogServiceSinkRequest,
      com.google.logging.v1.LogSink> METHOD_CREATE_LOG_SERVICE_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "CreateLogServiceSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.CreateLogServiceSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.LogSink.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.UpdateLogServiceSinkRequest,
      com.google.logging.v1.LogSink> METHOD_UPDATE_LOG_SERVICE_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "UpdateLogServiceSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.UpdateLogServiceSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.LogSink.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.DeleteLogServiceSinkRequest,
      com.google.protobuf.Empty> METHOD_DELETE_LOG_SERVICE_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "DeleteLogServiceSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.DeleteLogServiceSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.ListSinksRequest,
      com.google.logging.v1.ListSinksResponse> METHOD_LIST_SINKS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "ListSinks"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.ListSinksRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.ListSinksResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.GetSinkRequest,
      com.google.logging.v1.LogSink> METHOD_GET_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "GetSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.GetSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.LogSink.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.CreateSinkRequest,
      com.google.logging.v1.LogSink> METHOD_CREATE_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "CreateSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.CreateSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.LogSink.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.UpdateSinkRequest,
      com.google.logging.v1.LogSink> METHOD_UPDATE_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "UpdateSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.UpdateSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.LogSink.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v1.DeleteSinkRequest,
      com.google.protobuf.Empty> METHOD_DELETE_SINK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v1.ConfigService", "DeleteSink"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v1.DeleteSinkRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance()));

  public static ConfigServiceStub newStub(io.grpc.Channel channel) {
    return new ConfigServiceStub(channel);
  }

  public static ConfigServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ConfigServiceBlockingStub(channel);
  }

  public static ConfigServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ConfigServiceFutureStub(channel);
  }

  public static interface ConfigService {

    public void listLogSinks(com.google.logging.v1.ListLogSinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.ListLogSinksResponse> responseObserver);

    public void getLogSink(com.google.logging.v1.GetLogSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver);

    public void createLogSink(com.google.logging.v1.CreateLogSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver);

    public void updateLogSink(com.google.logging.v1.UpdateLogSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver);

    public void deleteLogSink(com.google.logging.v1.DeleteLogSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver);

    public void listLogServiceSinks(com.google.logging.v1.ListLogServiceSinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.ListLogServiceSinksResponse> responseObserver);

    public void getLogServiceSink(com.google.logging.v1.GetLogServiceSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver);

    public void createLogServiceSink(com.google.logging.v1.CreateLogServiceSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver);

    public void updateLogServiceSink(com.google.logging.v1.UpdateLogServiceSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver);

    public void deleteLogServiceSink(com.google.logging.v1.DeleteLogServiceSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver);

    public void listSinks(com.google.logging.v1.ListSinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.ListSinksResponse> responseObserver);

    public void getSink(com.google.logging.v1.GetSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver);

    public void createSink(com.google.logging.v1.CreateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver);

    public void updateSink(com.google.logging.v1.UpdateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver);

    public void deleteSink(com.google.logging.v1.DeleteSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver);
  }

  public static interface ConfigServiceBlockingClient {

    public com.google.logging.v1.ListLogSinksResponse listLogSinks(com.google.logging.v1.ListLogSinksRequest request);

    public com.google.logging.v1.LogSink getLogSink(com.google.logging.v1.GetLogSinkRequest request);

    public com.google.logging.v1.LogSink createLogSink(com.google.logging.v1.CreateLogSinkRequest request);

    public com.google.logging.v1.LogSink updateLogSink(com.google.logging.v1.UpdateLogSinkRequest request);

    public com.google.protobuf.Empty deleteLogSink(com.google.logging.v1.DeleteLogSinkRequest request);

    public com.google.logging.v1.ListLogServiceSinksResponse listLogServiceSinks(com.google.logging.v1.ListLogServiceSinksRequest request);

    public com.google.logging.v1.LogSink getLogServiceSink(com.google.logging.v1.GetLogServiceSinkRequest request);

    public com.google.logging.v1.LogSink createLogServiceSink(com.google.logging.v1.CreateLogServiceSinkRequest request);

    public com.google.logging.v1.LogSink updateLogServiceSink(com.google.logging.v1.UpdateLogServiceSinkRequest request);

    public com.google.protobuf.Empty deleteLogServiceSink(com.google.logging.v1.DeleteLogServiceSinkRequest request);

    public com.google.logging.v1.ListSinksResponse listSinks(com.google.logging.v1.ListSinksRequest request);

    public com.google.logging.v1.LogSink getSink(com.google.logging.v1.GetSinkRequest request);

    public com.google.logging.v1.LogSink createSink(com.google.logging.v1.CreateSinkRequest request);

    public com.google.logging.v1.LogSink updateSink(com.google.logging.v1.UpdateSinkRequest request);

    public com.google.protobuf.Empty deleteSink(com.google.logging.v1.DeleteSinkRequest request);
  }

  public static interface ConfigServiceFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.ListLogSinksResponse> listLogSinks(
        com.google.logging.v1.ListLogSinksRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> getLogSink(
        com.google.logging.v1.GetLogSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> createLogSink(
        com.google.logging.v1.CreateLogSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> updateLogSink(
        com.google.logging.v1.UpdateLogSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLogSink(
        com.google.logging.v1.DeleteLogSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.ListLogServiceSinksResponse> listLogServiceSinks(
        com.google.logging.v1.ListLogServiceSinksRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> getLogServiceSink(
        com.google.logging.v1.GetLogServiceSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> createLogServiceSink(
        com.google.logging.v1.CreateLogServiceSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> updateLogServiceSink(
        com.google.logging.v1.UpdateLogServiceSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLogServiceSink(
        com.google.logging.v1.DeleteLogServiceSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.ListSinksResponse> listSinks(
        com.google.logging.v1.ListSinksRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> getSink(
        com.google.logging.v1.GetSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> createSink(
        com.google.logging.v1.CreateSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> updateSink(
        com.google.logging.v1.UpdateSinkRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteSink(
        com.google.logging.v1.DeleteSinkRequest request);
  }

  public static class ConfigServiceStub extends io.grpc.stub.AbstractStub<ConfigServiceStub>
      implements ConfigService {
    private ConfigServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void listLogSinks(com.google.logging.v1.ListLogSinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.ListLogSinksResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_SINKS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void getLogSink(com.google.logging.v1.GetLogSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_LOG_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void createLogSink(com.google.logging.v1.CreateLogSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_LOG_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void updateLogSink(com.google.logging.v1.UpdateLogSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_LOG_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void deleteLogSink(com.google.logging.v1.DeleteLogSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void listLogServiceSinks(com.google.logging.v1.ListLogServiceSinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.ListLogServiceSinksResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_SERVICE_SINKS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void getLogServiceSink(com.google.logging.v1.GetLogServiceSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_LOG_SERVICE_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void createLogServiceSink(com.google.logging.v1.CreateLogServiceSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_LOG_SERVICE_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void updateLogServiceSink(com.google.logging.v1.UpdateLogServiceSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_LOG_SERVICE_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void deleteLogServiceSink(com.google.logging.v1.DeleteLogServiceSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG_SERVICE_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void listSinks(com.google.logging.v1.ListSinksRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.ListSinksResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_SINKS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void getSink(com.google.logging.v1.GetSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void createSink(com.google.logging.v1.CreateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void updateSink(com.google.logging.v1.UpdateSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_SINK, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void deleteSink(com.google.logging.v1.DeleteSinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_SINK, getCallOptions()), request, responseObserver);
    }
  }

  public static class ConfigServiceBlockingStub extends io.grpc.stub.AbstractStub<ConfigServiceBlockingStub>
      implements ConfigServiceBlockingClient {
    private ConfigServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.logging.v1.ListLogSinksResponse listLogSinks(com.google.logging.v1.ListLogSinksRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_SINKS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v1.LogSink getLogSink(com.google.logging.v1.GetLogSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_GET_LOG_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v1.LogSink createLogSink(com.google.logging.v1.CreateLogSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_CREATE_LOG_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v1.LogSink updateLogSink(com.google.logging.v1.UpdateLogSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_UPDATE_LOG_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.protobuf.Empty deleteLogSink(com.google.logging.v1.DeleteLogSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v1.ListLogServiceSinksResponse listLogServiceSinks(com.google.logging.v1.ListLogServiceSinksRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_SERVICE_SINKS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v1.LogSink getLogServiceSink(com.google.logging.v1.GetLogServiceSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_GET_LOG_SERVICE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v1.LogSink createLogServiceSink(com.google.logging.v1.CreateLogServiceSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_CREATE_LOG_SERVICE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v1.LogSink updateLogServiceSink(com.google.logging.v1.UpdateLogServiceSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_UPDATE_LOG_SERVICE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.protobuf.Empty deleteLogServiceSink(com.google.logging.v1.DeleteLogServiceSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG_SERVICE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v1.ListSinksResponse listSinks(com.google.logging.v1.ListSinksRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_LIST_SINKS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v1.LogSink getSink(com.google.logging.v1.GetSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_GET_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v1.LogSink createSink(com.google.logging.v1.CreateSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_CREATE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v1.LogSink updateSink(com.google.logging.v1.UpdateSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_UPDATE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.protobuf.Empty deleteSink(com.google.logging.v1.DeleteSinkRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_DELETE_SINK, getCallOptions()), request);
    }
  }

  public static class ConfigServiceFutureStub extends io.grpc.stub.AbstractStub<ConfigServiceFutureStub>
      implements ConfigServiceFutureClient {
    private ConfigServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.ListLogSinksResponse> listLogSinks(
        com.google.logging.v1.ListLogSinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_SINKS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> getLogSink(
        com.google.logging.v1.GetLogSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_LOG_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> createLogSink(
        com.google.logging.v1.CreateLogSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_LOG_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> updateLogSink(
        com.google.logging.v1.UpdateLogSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_LOG_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLogSink(
        com.google.logging.v1.DeleteLogSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.ListLogServiceSinksResponse> listLogServiceSinks(
        com.google.logging.v1.ListLogServiceSinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_SERVICE_SINKS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> getLogServiceSink(
        com.google.logging.v1.GetLogServiceSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_LOG_SERVICE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> createLogServiceSink(
        com.google.logging.v1.CreateLogServiceSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_LOG_SERVICE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> updateLogServiceSink(
        com.google.logging.v1.UpdateLogServiceSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_LOG_SERVICE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLogServiceSink(
        com.google.logging.v1.DeleteLogServiceSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG_SERVICE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.ListSinksResponse> listSinks(
        com.google.logging.v1.ListSinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_SINKS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> getSink(
        com.google.logging.v1.GetSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> createSink(
        com.google.logging.v1.CreateSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v1.LogSink> updateSink(
        com.google.logging.v1.UpdateSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_SINK, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteSink(
        com.google.logging.v1.DeleteSinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_SINK, getCallOptions()), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final ConfigService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_LIST_LOG_SINKS,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.ListLogSinksRequest,
              com.google.logging.v1.ListLogSinksResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.ListLogSinksRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v1.ListLogSinksResponse> responseObserver) {
              serviceImpl.listLogSinks(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_GET_LOG_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.GetLogSinkRequest,
              com.google.logging.v1.LogSink>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.GetLogSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
              serviceImpl.getLogSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_CREATE_LOG_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.CreateLogSinkRequest,
              com.google.logging.v1.LogSink>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.CreateLogSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
              serviceImpl.createLogSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_UPDATE_LOG_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.UpdateLogSinkRequest,
              com.google.logging.v1.LogSink>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.UpdateLogSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
              serviceImpl.updateLogSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_DELETE_LOG_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.DeleteLogSinkRequest,
              com.google.protobuf.Empty>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.DeleteLogSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
              serviceImpl.deleteLogSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_LIST_LOG_SERVICE_SINKS,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.ListLogServiceSinksRequest,
              com.google.logging.v1.ListLogServiceSinksResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.ListLogServiceSinksRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v1.ListLogServiceSinksResponse> responseObserver) {
              serviceImpl.listLogServiceSinks(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_GET_LOG_SERVICE_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.GetLogServiceSinkRequest,
              com.google.logging.v1.LogSink>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.GetLogServiceSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
              serviceImpl.getLogServiceSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_CREATE_LOG_SERVICE_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.CreateLogServiceSinkRequest,
              com.google.logging.v1.LogSink>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.CreateLogServiceSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
              serviceImpl.createLogServiceSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_UPDATE_LOG_SERVICE_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.UpdateLogServiceSinkRequest,
              com.google.logging.v1.LogSink>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.UpdateLogServiceSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
              serviceImpl.updateLogServiceSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_DELETE_LOG_SERVICE_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.DeleteLogServiceSinkRequest,
              com.google.protobuf.Empty>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.DeleteLogServiceSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
              serviceImpl.deleteLogServiceSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_LIST_SINKS,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.ListSinksRequest,
              com.google.logging.v1.ListSinksResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.ListSinksRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v1.ListSinksResponse> responseObserver) {
              serviceImpl.listSinks(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_GET_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.GetSinkRequest,
              com.google.logging.v1.LogSink>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.GetSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
              serviceImpl.getSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_CREATE_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.CreateSinkRequest,
              com.google.logging.v1.LogSink>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.CreateSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
              serviceImpl.createSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_UPDATE_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.UpdateSinkRequest,
              com.google.logging.v1.LogSink>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.UpdateSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v1.LogSink> responseObserver) {
              serviceImpl.updateSink(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_DELETE_SINK,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v1.DeleteSinkRequest,
              com.google.protobuf.Empty>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v1.DeleteSinkRequest request,
                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
              serviceImpl.deleteSink(request, responseObserver);
            }
          })).build();
  }
}
