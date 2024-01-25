/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.logging.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for configuring logs-based metrics.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/logging/v2/logging_metrics.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MetricsServiceV2Grpc {

  private MetricsServiceV2Grpc() {}

  public static final java.lang.String SERVICE_NAME = "google.logging.v2.MetricsServiceV2";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.ListLogMetricsRequest, com.google.logging.v2.ListLogMetricsResponse>
      getListLogMetricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLogMetrics",
      requestType = com.google.logging.v2.ListLogMetricsRequest.class,
      responseType = com.google.logging.v2.ListLogMetricsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.ListLogMetricsRequest, com.google.logging.v2.ListLogMetricsResponse>
      getListLogMetricsMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.ListLogMetricsRequest,
            com.google.logging.v2.ListLogMetricsResponse>
        getListLogMetricsMethod;
    if ((getListLogMetricsMethod = MetricsServiceV2Grpc.getListLogMetricsMethod) == null) {
      synchronized (MetricsServiceV2Grpc.class) {
        if ((getListLogMetricsMethod = MetricsServiceV2Grpc.getListLogMetricsMethod) == null) {
          MetricsServiceV2Grpc.getListLogMetricsMethod =
              getListLogMetricsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.ListLogMetricsRequest,
                          com.google.logging.v2.ListLogMetricsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLogMetrics"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListLogMetricsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.ListLogMetricsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetricsServiceV2MethodDescriptorSupplier("ListLogMetrics"))
                      .build();
        }
      }
    }
    return getListLogMetricsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.GetLogMetricRequest, com.google.logging.v2.LogMetric>
      getGetLogMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLogMetric",
      requestType = com.google.logging.v2.GetLogMetricRequest.class,
      responseType = com.google.logging.v2.LogMetric.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.GetLogMetricRequest, com.google.logging.v2.LogMetric>
      getGetLogMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.GetLogMetricRequest, com.google.logging.v2.LogMetric>
        getGetLogMetricMethod;
    if ((getGetLogMetricMethod = MetricsServiceV2Grpc.getGetLogMetricMethod) == null) {
      synchronized (MetricsServiceV2Grpc.class) {
        if ((getGetLogMetricMethod = MetricsServiceV2Grpc.getGetLogMetricMethod) == null) {
          MetricsServiceV2Grpc.getGetLogMetricMethod =
              getGetLogMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.GetLogMetricRequest, com.google.logging.v2.LogMetric>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLogMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.GetLogMetricRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogMetric.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetricsServiceV2MethodDescriptorSupplier("GetLogMetric"))
                      .build();
        }
      }
    }
    return getGetLogMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateLogMetricRequest, com.google.logging.v2.LogMetric>
      getCreateLogMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLogMetric",
      requestType = com.google.logging.v2.CreateLogMetricRequest.class,
      responseType = com.google.logging.v2.LogMetric.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.CreateLogMetricRequest, com.google.logging.v2.LogMetric>
      getCreateLogMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.CreateLogMetricRequest, com.google.logging.v2.LogMetric>
        getCreateLogMetricMethod;
    if ((getCreateLogMetricMethod = MetricsServiceV2Grpc.getCreateLogMetricMethod) == null) {
      synchronized (MetricsServiceV2Grpc.class) {
        if ((getCreateLogMetricMethod = MetricsServiceV2Grpc.getCreateLogMetricMethod) == null) {
          MetricsServiceV2Grpc.getCreateLogMetricMethod =
              getCreateLogMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.CreateLogMetricRequest,
                          com.google.logging.v2.LogMetric>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateLogMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.CreateLogMetricRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogMetric.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetricsServiceV2MethodDescriptorSupplier("CreateLogMetric"))
                      .build();
        }
      }
    }
    return getCreateLogMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateLogMetricRequest, com.google.logging.v2.LogMetric>
      getUpdateLogMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateLogMetric",
      requestType = com.google.logging.v2.UpdateLogMetricRequest.class,
      responseType = com.google.logging.v2.LogMetric.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.UpdateLogMetricRequest, com.google.logging.v2.LogMetric>
      getUpdateLogMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.UpdateLogMetricRequest, com.google.logging.v2.LogMetric>
        getUpdateLogMetricMethod;
    if ((getUpdateLogMetricMethod = MetricsServiceV2Grpc.getUpdateLogMetricMethod) == null) {
      synchronized (MetricsServiceV2Grpc.class) {
        if ((getUpdateLogMetricMethod = MetricsServiceV2Grpc.getUpdateLogMetricMethod) == null) {
          MetricsServiceV2Grpc.getUpdateLogMetricMethod =
              getUpdateLogMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.UpdateLogMetricRequest,
                          com.google.logging.v2.LogMetric>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateLogMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.UpdateLogMetricRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.LogMetric.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetricsServiceV2MethodDescriptorSupplier("UpdateLogMetric"))
                      .build();
        }
      }
    }
    return getUpdateLogMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteLogMetricRequest, com.google.protobuf.Empty>
      getDeleteLogMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLogMetric",
      requestType = com.google.logging.v2.DeleteLogMetricRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.logging.v2.DeleteLogMetricRequest, com.google.protobuf.Empty>
      getDeleteLogMetricMethod() {
    io.grpc.MethodDescriptor<
            com.google.logging.v2.DeleteLogMetricRequest, com.google.protobuf.Empty>
        getDeleteLogMetricMethod;
    if ((getDeleteLogMetricMethod = MetricsServiceV2Grpc.getDeleteLogMetricMethod) == null) {
      synchronized (MetricsServiceV2Grpc.class) {
        if ((getDeleteLogMetricMethod = MetricsServiceV2Grpc.getDeleteLogMetricMethod) == null) {
          MetricsServiceV2Grpc.getDeleteLogMetricMethod =
              getDeleteLogMetricMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.logging.v2.DeleteLogMetricRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteLogMetric"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.logging.v2.DeleteLogMetricRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetricsServiceV2MethodDescriptorSupplier("DeleteLogMetric"))
                      .build();
        }
      }
    }
    return getDeleteLogMetricMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MetricsServiceV2Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricsServiceV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetricsServiceV2Stub>() {
          @java.lang.Override
          public MetricsServiceV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetricsServiceV2Stub(channel, callOptions);
          }
        };
    return MetricsServiceV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MetricsServiceV2BlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricsServiceV2BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetricsServiceV2BlockingStub>() {
          @java.lang.Override
          public MetricsServiceV2BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetricsServiceV2BlockingStub(channel, callOptions);
          }
        };
    return MetricsServiceV2BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MetricsServiceV2FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricsServiceV2FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetricsServiceV2FutureStub>() {
          @java.lang.Override
          public MetricsServiceV2FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetricsServiceV2FutureStub(channel, callOptions);
          }
        };
    return MetricsServiceV2FutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for configuring logs-based metrics.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists logs-based metrics.
     * </pre>
     */
    default void listLogMetrics(
        com.google.logging.v2.ListLogMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogMetricsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLogMetricsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a logs-based metric.
     * </pre>
     */
    default void getLogMetric(
        com.google.logging.v2.GetLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLogMetricMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a logs-based metric.
     * </pre>
     */
    default void createLogMetric(
        com.google.logging.v2.CreateLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateLogMetricMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a logs-based metric.
     * </pre>
     */
    default void updateLogMetric(
        com.google.logging.v2.UpdateLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateLogMetricMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a logs-based metric.
     * </pre>
     */
    default void deleteLogMetric(
        com.google.logging.v2.DeleteLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteLogMetricMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MetricsServiceV2.
   *
   * <pre>
   * Service for configuring logs-based metrics.
   * </pre>
   */
  public abstract static class MetricsServiceV2ImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MetricsServiceV2Grpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MetricsServiceV2.
   *
   * <pre>
   * Service for configuring logs-based metrics.
   * </pre>
   */
  public static final class MetricsServiceV2Stub
      extends io.grpc.stub.AbstractAsyncStub<MetricsServiceV2Stub> {
    private MetricsServiceV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsServiceV2Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricsServiceV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists logs-based metrics.
     * </pre>
     */
    public void listLogMetrics(
        com.google.logging.v2.ListLogMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogMetricsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLogMetricsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a logs-based metric.
     * </pre>
     */
    public void getLogMetric(
        com.google.logging.v2.GetLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLogMetricMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a logs-based metric.
     * </pre>
     */
    public void createLogMetric(
        com.google.logging.v2.CreateLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLogMetricMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a logs-based metric.
     * </pre>
     */
    public void updateLogMetric(
        com.google.logging.v2.UpdateLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateLogMetricMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a logs-based metric.
     * </pre>
     */
    public void deleteLogMetric(
        com.google.logging.v2.DeleteLogMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteLogMetricMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MetricsServiceV2.
   *
   * <pre>
   * Service for configuring logs-based metrics.
   * </pre>
   */
  public static final class MetricsServiceV2BlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MetricsServiceV2BlockingStub> {
    private MetricsServiceV2BlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsServiceV2BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricsServiceV2BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists logs-based metrics.
     * </pre>
     */
    public com.google.logging.v2.ListLogMetricsResponse listLogMetrics(
        com.google.logging.v2.ListLogMetricsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLogMetricsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a logs-based metric.
     * </pre>
     */
    public com.google.logging.v2.LogMetric getLogMetric(
        com.google.logging.v2.GetLogMetricRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLogMetricMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a logs-based metric.
     * </pre>
     */
    public com.google.logging.v2.LogMetric createLogMetric(
        com.google.logging.v2.CreateLogMetricRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLogMetricMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a logs-based metric.
     * </pre>
     */
    public com.google.logging.v2.LogMetric updateLogMetric(
        com.google.logging.v2.UpdateLogMetricRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateLogMetricMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a logs-based metric.
     * </pre>
     */
    public com.google.protobuf.Empty deleteLogMetric(
        com.google.logging.v2.DeleteLogMetricRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteLogMetricMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MetricsServiceV2.
   *
   * <pre>
   * Service for configuring logs-based metrics.
   * </pre>
   */
  public static final class MetricsServiceV2FutureStub
      extends io.grpc.stub.AbstractFutureStub<MetricsServiceV2FutureStub> {
    private MetricsServiceV2FutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsServiceV2FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricsServiceV2FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists logs-based metrics.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.logging.v2.ListLogMetricsResponse>
        listLogMetrics(com.google.logging.v2.ListLogMetricsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLogMetricsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a logs-based metric.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogMetric>
        getLogMetric(com.google.logging.v2.GetLogMetricRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLogMetricMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a logs-based metric.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogMetric>
        createLogMetric(com.google.logging.v2.CreateLogMetricRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLogMetricMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a logs-based metric.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.LogMetric>
        updateLogMetric(com.google.logging.v2.UpdateLogMetricRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateLogMetricMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a logs-based metric.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteLogMetric(com.google.logging.v2.DeleteLogMetricRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteLogMetricMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_LOG_METRICS = 0;
  private static final int METHODID_GET_LOG_METRIC = 1;
  private static final int METHODID_CREATE_LOG_METRIC = 2;
  private static final int METHODID_UPDATE_LOG_METRIC = 3;
  private static final int METHODID_DELETE_LOG_METRIC = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_LOG_METRICS:
          serviceImpl.listLogMetrics(
              (com.google.logging.v2.ListLogMetricsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogMetricsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_LOG_METRIC:
          serviceImpl.getLogMetric(
              (com.google.logging.v2.GetLogMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric>) responseObserver);
          break;
        case METHODID_CREATE_LOG_METRIC:
          serviceImpl.createLogMetric(
              (com.google.logging.v2.CreateLogMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric>) responseObserver);
          break;
        case METHODID_UPDATE_LOG_METRIC:
          serviceImpl.updateLogMetric(
              (com.google.logging.v2.UpdateLogMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.LogMetric>) responseObserver);
          break;
        case METHODID_DELETE_LOG_METRIC:
          serviceImpl.deleteLogMetric(
              (com.google.logging.v2.DeleteLogMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListLogMetricsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.ListLogMetricsRequest,
                    com.google.logging.v2.ListLogMetricsResponse>(
                    service, METHODID_LIST_LOG_METRICS)))
        .addMethod(
            getGetLogMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.GetLogMetricRequest, com.google.logging.v2.LogMetric>(
                    service, METHODID_GET_LOG_METRIC)))
        .addMethod(
            getCreateLogMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.CreateLogMetricRequest, com.google.logging.v2.LogMetric>(
                    service, METHODID_CREATE_LOG_METRIC)))
        .addMethod(
            getUpdateLogMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.UpdateLogMetricRequest, com.google.logging.v2.LogMetric>(
                    service, METHODID_UPDATE_LOG_METRIC)))
        .addMethod(
            getDeleteLogMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.logging.v2.DeleteLogMetricRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_LOG_METRIC)))
        .build();
  }

  private abstract static class MetricsServiceV2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MetricsServiceV2BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.logging.v2.LoggingMetricsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MetricsServiceV2");
    }
  }

  private static final class MetricsServiceV2FileDescriptorSupplier
      extends MetricsServiceV2BaseDescriptorSupplier {
    MetricsServiceV2FileDescriptorSupplier() {}
  }

  private static final class MetricsServiceV2MethodDescriptorSupplier
      extends MetricsServiceV2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MetricsServiceV2MethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MetricsServiceV2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MetricsServiceV2FileDescriptorSupplier())
                      .addMethod(getListLogMetricsMethod())
                      .addMethod(getGetLogMetricMethod())
                      .addMethod(getCreateLogMetricMethod())
                      .addMethod(getUpdateLogMetricMethod())
                      .addMethod(getDeleteLogMetricMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
