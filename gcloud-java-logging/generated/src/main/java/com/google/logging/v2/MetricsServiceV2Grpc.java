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
public class MetricsServiceV2Grpc {

  private MetricsServiceV2Grpc() {}

  public static final String SERVICE_NAME = "google.logging.v2.MetricsServiceV2";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.ListLogMetricsRequest,
      com.google.logging.v2.ListLogMetricsResponse> METHOD_LIST_LOG_METRICS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.MetricsServiceV2", "ListLogMetrics"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ListLogMetricsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ListLogMetricsResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.GetLogMetricRequest,
      com.google.logging.v2.LogMetric> METHOD_GET_LOG_METRIC =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.MetricsServiceV2", "GetLogMetric"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.GetLogMetricRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.LogMetric.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.CreateLogMetricRequest,
      com.google.logging.v2.LogMetric> METHOD_CREATE_LOG_METRIC =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.MetricsServiceV2", "CreateLogMetric"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.CreateLogMetricRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.LogMetric.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.UpdateLogMetricRequest,
      com.google.logging.v2.LogMetric> METHOD_UPDATE_LOG_METRIC =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.MetricsServiceV2", "UpdateLogMetric"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.UpdateLogMetricRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.LogMetric.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.DeleteLogMetricRequest,
      com.google.protobuf.Empty> METHOD_DELETE_LOG_METRIC =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.MetricsServiceV2", "DeleteLogMetric"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.DeleteLogMetricRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance()));

  public static MetricsServiceV2Stub newStub(io.grpc.Channel channel) {
    return new MetricsServiceV2Stub(channel);
  }

  public static MetricsServiceV2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MetricsServiceV2BlockingStub(channel);
  }

  public static MetricsServiceV2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MetricsServiceV2FutureStub(channel);
  }

  public static interface MetricsServiceV2 {

    public void listLogMetrics(com.google.logging.v2.ListLogMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogMetricsResponse> responseObserver);

    public void getLogMetric(com.google.logging.v2.GetLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver);

    public void createLogMetric(com.google.logging.v2.CreateLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver);

    public void updateLogMetric(com.google.logging.v2.UpdateLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver);

    public void deleteLogMetric(com.google.logging.v2.DeleteLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver);
  }

  public static interface MetricsServiceV2BlockingClient {

    public com.google.logging.v2.ListLogMetricsResponse listLogMetrics(com.google.logging.v2.ListLogMetricsRequest request);

    public com.google.logging.v2.LogMetric getLogMetric(com.google.logging.v2.GetLogMetricRequest request);

    public com.google.logging.v2.LogMetric createLogMetric(com.google.logging.v2.CreateLogMetricRequest request);

    public com.google.logging.v2.LogMetric updateLogMetric(com.google.logging.v2.UpdateLogMetricRequest request);

    public com.google.protobuf.Empty deleteLogMetric(com.google.logging.v2.DeleteLogMetricRequest request);
  }

  public static interface MetricsServiceV2FutureClient {

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.ListLogMetricsResponse> listLogMetrics(
        com.google.logging.v2.ListLogMetricsRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogMetric> getLogMetric(
        com.google.logging.v2.GetLogMetricRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogMetric> createLogMetric(
        com.google.logging.v2.CreateLogMetricRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogMetric> updateLogMetric(
        com.google.logging.v2.UpdateLogMetricRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLogMetric(
        com.google.logging.v2.DeleteLogMetricRequest request);
  }

  public static class MetricsServiceV2Stub extends io.grpc.stub.AbstractStub<MetricsServiceV2Stub>
      implements MetricsServiceV2 {
    private MetricsServiceV2Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private MetricsServiceV2Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsServiceV2Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MetricsServiceV2Stub(channel, callOptions);
    }

    @java.lang.Override
    public void listLogMetrics(com.google.logging.v2.ListLogMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogMetricsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_METRICS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void getLogMetric(com.google.logging.v2.GetLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_LOG_METRIC, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void createLogMetric(com.google.logging.v2.CreateLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_LOG_METRIC, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void updateLogMetric(com.google.logging.v2.UpdateLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_LOG_METRIC, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void deleteLogMetric(com.google.logging.v2.DeleteLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG_METRIC, getCallOptions()), request, responseObserver);
    }
  }

  public static class MetricsServiceV2BlockingStub extends io.grpc.stub.AbstractStub<MetricsServiceV2BlockingStub>
      implements MetricsServiceV2BlockingClient {
    private MetricsServiceV2BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MetricsServiceV2BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsServiceV2BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MetricsServiceV2BlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.logging.v2.ListLogMetricsResponse listLogMetrics(com.google.logging.v2.ListLogMetricsRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_METRICS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v2.LogMetric getLogMetric(com.google.logging.v2.GetLogMetricRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_GET_LOG_METRIC, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v2.LogMetric createLogMetric(com.google.logging.v2.CreateLogMetricRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_CREATE_LOG_METRIC, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.logging.v2.LogMetric updateLogMetric(com.google.logging.v2.UpdateLogMetricRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_UPDATE_LOG_METRIC, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.protobuf.Empty deleteLogMetric(com.google.logging.v2.DeleteLogMetricRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG_METRIC, getCallOptions()), request);
    }
  }

  public static class MetricsServiceV2FutureStub extends io.grpc.stub.AbstractStub<MetricsServiceV2FutureStub>
      implements MetricsServiceV2FutureClient {
    private MetricsServiceV2FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MetricsServiceV2FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsServiceV2FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MetricsServiceV2FutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.ListLogMetricsResponse> listLogMetrics(
        com.google.logging.v2.ListLogMetricsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_METRICS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogMetric> getLogMetric(
        com.google.logging.v2.GetLogMetricRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_LOG_METRIC, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogMetric> createLogMetric(
        com.google.logging.v2.CreateLogMetricRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_LOG_METRIC, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogMetric> updateLogMetric(
        com.google.logging.v2.UpdateLogMetricRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_LOG_METRIC, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLogMetric(
        com.google.logging.v2.DeleteLogMetricRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG_METRIC, getCallOptions()), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final MetricsServiceV2 serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_LIST_LOG_METRICS,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.ListLogMetricsRequest,
              com.google.logging.v2.ListLogMetricsResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.ListLogMetricsRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogMetricsResponse> responseObserver) {
              serviceImpl.listLogMetrics(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_GET_LOG_METRIC,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.GetLogMetricRequest,
              com.google.logging.v2.LogMetric>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.GetLogMetricRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver) {
              serviceImpl.getLogMetric(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_CREATE_LOG_METRIC,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.CreateLogMetricRequest,
              com.google.logging.v2.LogMetric>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.CreateLogMetricRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver) {
              serviceImpl.createLogMetric(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_UPDATE_LOG_METRIC,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.UpdateLogMetricRequest,
              com.google.logging.v2.LogMetric>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.UpdateLogMetricRequest request,
                io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver) {
              serviceImpl.updateLogMetric(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_DELETE_LOG_METRIC,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.logging.v2.DeleteLogMetricRequest,
              com.google.protobuf.Empty>() {
            @java.lang.Override
            public void invoke(
                com.google.logging.v2.DeleteLogMetricRequest request,
                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
              serviceImpl.deleteLogMetric(request, responseObserver);
            }
          })).build();
  }
}
