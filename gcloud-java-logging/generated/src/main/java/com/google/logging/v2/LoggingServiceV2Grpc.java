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
public class LoggingServiceV2Grpc {

  private LoggingServiceV2Grpc() {}

  public static final String SERVICE_NAME = "google.logging.v2.LoggingServiceV2";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.DeleteLogRequest,
      com.google.protobuf.Empty> METHOD_DELETE_LOG =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.LoggingServiceV2", "DeleteLog"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.DeleteLogRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.WriteLogEntriesRequest,
      com.google.logging.v2.WriteLogEntriesResponse> METHOD_WRITE_LOG_ENTRIES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.LoggingServiceV2", "WriteLogEntries"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.WriteLogEntriesRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.WriteLogEntriesResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.ListLogEntriesRequest,
      com.google.logging.v2.ListLogEntriesResponse> METHOD_LIST_LOG_ENTRIES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.LoggingServiceV2", "ListLogEntries"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ListLogEntriesRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ListLogEntriesResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.ReadLogEntriesRequest,
      com.google.logging.v2.ReadLogEntriesResponse> METHOD_READ_LOG_ENTRIES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "google.logging.v2.LoggingServiceV2", "ReadLogEntries"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ReadLogEntriesRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ReadLogEntriesResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.ListMonitoredResourceDescriptorsRequest,
      com.google.logging.v2.ListMonitoredResourceDescriptorsResponse> METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.LoggingServiceV2", "ListMonitoredResourceDescriptors"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ListMonitoredResourceDescriptorsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ListMonitoredResourceDescriptorsResponse.getDefaultInstance()));

  public static LoggingServiceV2Stub newStub(io.grpc.Channel channel) {
    return new LoggingServiceV2Stub(channel);
  }

  public static LoggingServiceV2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LoggingServiceV2BlockingStub(channel);
  }

  public static LoggingServiceV2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LoggingServiceV2FutureStub(channel);
  }

  public static interface LoggingServiceV2 {

    public void deleteLog(com.google.logging.v2.DeleteLogRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver);

    public void writeLogEntries(com.google.logging.v2.WriteLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.WriteLogEntriesResponse> responseObserver);

    public void listLogEntries(com.google.logging.v2.ListLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogEntriesResponse> responseObserver);

    public void readLogEntries(com.google.logging.v2.ReadLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ReadLogEntriesResponse> responseObserver);

    public void listMonitoredResourceDescriptors(com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListMonitoredResourceDescriptorsResponse> responseObserver);
  }

  public static interface LoggingServiceV2BlockingClient {

    public com.google.protobuf.Empty deleteLog(com.google.logging.v2.DeleteLogRequest request);

    public com.google.logging.v2.WriteLogEntriesResponse writeLogEntries(com.google.logging.v2.WriteLogEntriesRequest request);

    public com.google.logging.v2.ListLogEntriesResponse listLogEntries(com.google.logging.v2.ListLogEntriesRequest request);

    public java.util.Iterator<com.google.logging.v2.ReadLogEntriesResponse> readLogEntries(
        com.google.logging.v2.ReadLogEntriesRequest request);

    public com.google.logging.v2.ListMonitoredResourceDescriptorsResponse listMonitoredResourceDescriptors(com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request);
  }

  public static interface LoggingServiceV2FutureClient {

    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLog(
        com.google.logging.v2.DeleteLogRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.WriteLogEntriesResponse> writeLogEntries(
        com.google.logging.v2.WriteLogEntriesRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.ListLogEntriesResponse> listLogEntries(
        com.google.logging.v2.ListLogEntriesRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.ListMonitoredResourceDescriptorsResponse> listMonitoredResourceDescriptors(
        com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request);
  }

  public static class LoggingServiceV2Stub extends io.grpc.stub.AbstractStub<LoggingServiceV2Stub>
      implements LoggingServiceV2 {
    private LoggingServiceV2Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoggingServiceV2Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoggingServiceV2Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoggingServiceV2Stub(channel, callOptions);
    }

    @java.lang.Override
    public void deleteLog(com.google.logging.v2.DeleteLogRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeLogEntries(com.google.logging.v2.WriteLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.WriteLogEntriesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_LOG_ENTRIES, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void listLogEntries(com.google.logging.v2.ListLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogEntriesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_ENTRIES, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void readLogEntries(com.google.logging.v2.ReadLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ReadLogEntriesResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_READ_LOG_ENTRIES, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void listMonitoredResourceDescriptors(com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListMonitoredResourceDescriptorsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS, getCallOptions()), request, responseObserver);
    }
  }

  public static class LoggingServiceV2BlockingStub extends io.grpc.stub.AbstractStub<LoggingServiceV2BlockingStub>
      implements LoggingServiceV2BlockingClient {
    private LoggingServiceV2BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoggingServiceV2BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoggingServiceV2BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoggingServiceV2BlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.protobuf.Empty deleteLog(com.google.logging.v2.DeleteLogRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v2.WriteLogEntriesResponse writeLogEntries(com.google.logging.v2.WriteLogEntriesRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_WRITE_LOG_ENTRIES, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v2.ListLogEntriesResponse listLogEntries(com.google.logging.v2.ListLogEntriesRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_ENTRIES, getCallOptions()), request);
    }

    @java.lang.Override
    public java.util.Iterator<com.google.logging.v2.ReadLogEntriesResponse> readLogEntries(
        com.google.logging.v2.ReadLogEntriesRequest request) {
      return blockingServerStreamingCall(
          getChannel().newCall(METHOD_READ_LOG_ENTRIES, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v2.ListMonitoredResourceDescriptorsResponse listMonitoredResourceDescriptors(com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS, getCallOptions()), request);
    }
  }

  public static class LoggingServiceV2FutureStub extends io.grpc.stub.AbstractStub<LoggingServiceV2FutureStub>
      implements LoggingServiceV2FutureClient {
    private LoggingServiceV2FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoggingServiceV2FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoggingServiceV2FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoggingServiceV2FutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLog(
        com.google.logging.v2.DeleteLogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.WriteLogEntriesResponse> writeLogEntries(
        com.google.logging.v2.WriteLogEntriesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_LOG_ENTRIES, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.ListLogEntriesResponse> listLogEntries(
        com.google.logging.v2.ListLogEntriesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_ENTRIES, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.ListMonitoredResourceDescriptorsResponse> listMonitoredResourceDescriptors(
        com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS, getCallOptions()), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final LoggingServiceV2 serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_DELETE_LOG,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.DeleteLogRequest,
              com.google.protobuf.Empty>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.DeleteLogRequest request,
                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
              serviceImpl.deleteLog(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_WRITE_LOG_ENTRIES,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.WriteLogEntriesRequest,
              com.google.logging.v2.WriteLogEntriesResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.WriteLogEntriesRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v2.WriteLogEntriesResponse> responseObserver) {
              serviceImpl.writeLogEntries(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_LIST_LOG_ENTRIES,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.ListLogEntriesRequest,
              com.google.logging.v2.ListLogEntriesResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.ListLogEntriesRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogEntriesResponse> responseObserver) {
              serviceImpl.listLogEntries(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_READ_LOG_ENTRIES,
        asyncServerStreamingCall(
          new io.grpc.stub.ServerCalls.ServerStreamingMethod<
              com.google.logging.v2.ReadLogEntriesRequest,
              com.google.logging.v2.ReadLogEntriesResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.ReadLogEntriesRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v2.ReadLogEntriesResponse> responseObserver) {
              serviceImpl.readLogEntries(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.ListMonitoredResourceDescriptorsRequest,
              com.google.logging.v2.ListMonitoredResourceDescriptorsResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v2.ListMonitoredResourceDescriptorsResponse> responseObserver) {
              serviceImpl.listMonitoredResourceDescriptors(request, responseObserver);
            }
          })).build();
  }
}
