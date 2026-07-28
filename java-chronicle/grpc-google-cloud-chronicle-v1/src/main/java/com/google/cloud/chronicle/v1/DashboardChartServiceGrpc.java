/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service providing functionality for managing dashboards' charts.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DashboardChartServiceGrpc {

  private DashboardChartServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.chronicle.v1.DashboardChartService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetDashboardChartRequest,
          com.google.cloud.chronicle.v1.DashboardChart>
      getGetDashboardChartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDashboardChart",
      requestType = com.google.cloud.chronicle.v1.GetDashboardChartRequest.class,
      responseType = com.google.cloud.chronicle.v1.DashboardChart.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetDashboardChartRequest,
          com.google.cloud.chronicle.v1.DashboardChart>
      getGetDashboardChartMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GetDashboardChartRequest,
            com.google.cloud.chronicle.v1.DashboardChart>
        getGetDashboardChartMethod;
    if ((getGetDashboardChartMethod = DashboardChartServiceGrpc.getGetDashboardChartMethod)
        == null) {
      synchronized (DashboardChartServiceGrpc.class) {
        if ((getGetDashboardChartMethod = DashboardChartServiceGrpc.getGetDashboardChartMethod)
            == null) {
          DashboardChartServiceGrpc.getGetDashboardChartMethod =
              getGetDashboardChartMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GetDashboardChartRequest,
                          com.google.cloud.chronicle.v1.DashboardChart>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDashboardChart"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GetDashboardChartRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DashboardChart.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DashboardChartServiceMethodDescriptorSupplier("GetDashboardChart"))
                      .build();
        }
      }
    }
    return getGetDashboardChartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest,
          com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse>
      getBatchGetDashboardChartsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchGetDashboardCharts",
      requestType = com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest.class,
      responseType = com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest,
          com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse>
      getBatchGetDashboardChartsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest,
            com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse>
        getBatchGetDashboardChartsMethod;
    if ((getBatchGetDashboardChartsMethod =
            DashboardChartServiceGrpc.getBatchGetDashboardChartsMethod)
        == null) {
      synchronized (DashboardChartServiceGrpc.class) {
        if ((getBatchGetDashboardChartsMethod =
                DashboardChartServiceGrpc.getBatchGetDashboardChartsMethod)
            == null) {
          DashboardChartServiceGrpc.getBatchGetDashboardChartsMethod =
              getBatchGetDashboardChartsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest,
                          com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchGetDashboardCharts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DashboardChartServiceMethodDescriptorSupplier(
                              "BatchGetDashboardCharts"))
                      .build();
        }
      }
    }
    return getBatchGetDashboardChartsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DashboardChartServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DashboardChartServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DashboardChartServiceStub>() {
          @java.lang.Override
          public DashboardChartServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DashboardChartServiceStub(channel, callOptions);
          }
        };
    return DashboardChartServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DashboardChartServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DashboardChartServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DashboardChartServiceBlockingV2Stub>() {
          @java.lang.Override
          public DashboardChartServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DashboardChartServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DashboardChartServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DashboardChartServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DashboardChartServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DashboardChartServiceBlockingStub>() {
          @java.lang.Override
          public DashboardChartServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DashboardChartServiceBlockingStub(channel, callOptions);
          }
        };
    return DashboardChartServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DashboardChartServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DashboardChartServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DashboardChartServiceFutureStub>() {
          @java.lang.Override
          public DashboardChartServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DashboardChartServiceFutureStub(channel, callOptions);
          }
        };
    return DashboardChartServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service providing functionality for managing dashboards' charts.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Get a dashboard chart.
     * </pre>
     */
    default void getDashboardChart(
        com.google.cloud.chronicle.v1.GetDashboardChartRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DashboardChart>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDashboardChartMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get dashboard charts in batches.
     * </pre>
     */
    default void batchGetDashboardCharts(
        com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchGetDashboardChartsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DashboardChartService.
   *
   * <pre>
   * A service providing functionality for managing dashboards' charts.
   * </pre>
   */
  public abstract static class DashboardChartServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DashboardChartServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DashboardChartService.
   *
   * <pre>
   * A service providing functionality for managing dashboards' charts.
   * </pre>
   */
  public static final class DashboardChartServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DashboardChartServiceStub> {
    private DashboardChartServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DashboardChartServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DashboardChartServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a dashboard chart.
     * </pre>
     */
    public void getDashboardChart(
        com.google.cloud.chronicle.v1.GetDashboardChartRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DashboardChart>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDashboardChartMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get dashboard charts in batches.
     * </pre>
     */
    public void batchGetDashboardCharts(
        com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchGetDashboardChartsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DashboardChartService.
   *
   * <pre>
   * A service providing functionality for managing dashboards' charts.
   * </pre>
   */
  public static final class DashboardChartServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DashboardChartServiceBlockingV2Stub> {
    private DashboardChartServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DashboardChartServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DashboardChartServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a dashboard chart.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DashboardChart getDashboardChart(
        com.google.cloud.chronicle.v1.GetDashboardChartRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDashboardChartMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get dashboard charts in batches.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse batchGetDashboardCharts(
        com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchGetDashboardChartsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DashboardChartService.
   *
   * <pre>
   * A service providing functionality for managing dashboards' charts.
   * </pre>
   */
  public static final class DashboardChartServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DashboardChartServiceBlockingStub> {
    private DashboardChartServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DashboardChartServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DashboardChartServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a dashboard chart.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DashboardChart getDashboardChart(
        com.google.cloud.chronicle.v1.GetDashboardChartRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDashboardChartMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get dashboard charts in batches.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse batchGetDashboardCharts(
        com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchGetDashboardChartsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * DashboardChartService.
   *
   * <pre>
   * A service providing functionality for managing dashboards' charts.
   * </pre>
   */
  public static final class DashboardChartServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DashboardChartServiceFutureStub> {
    private DashboardChartServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DashboardChartServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DashboardChartServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a dashboard chart.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.DashboardChart>
        getDashboardChart(com.google.cloud.chronicle.v1.GetDashboardChartRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDashboardChartMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get dashboard charts in batches.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse>
        batchGetDashboardCharts(
            com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchGetDashboardChartsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DASHBOARD_CHART = 0;
  private static final int METHODID_BATCH_GET_DASHBOARD_CHARTS = 1;

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
        case METHODID_GET_DASHBOARD_CHART:
          serviceImpl.getDashboardChart(
              (com.google.cloud.chronicle.v1.GetDashboardChartRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DashboardChart>)
                  responseObserver);
          break;
        case METHODID_BATCH_GET_DASHBOARD_CHARTS:
          serviceImpl.batchGetDashboardCharts(
              (com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse>)
                  responseObserver);
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
            getGetDashboardChartMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GetDashboardChartRequest,
                    com.google.cloud.chronicle.v1.DashboardChart>(
                    service, METHODID_GET_DASHBOARD_CHART)))
        .addMethod(
            getBatchGetDashboardChartsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest,
                    com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse>(
                    service, METHODID_BATCH_GET_DASHBOARD_CHARTS)))
        .build();
  }

  private abstract static class DashboardChartServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DashboardChartServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.chronicle.v1.DashboardChartProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DashboardChartService");
    }
  }

  private static final class DashboardChartServiceFileDescriptorSupplier
      extends DashboardChartServiceBaseDescriptorSupplier {
    DashboardChartServiceFileDescriptorSupplier() {}
  }

  private static final class DashboardChartServiceMethodDescriptorSupplier
      extends DashboardChartServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DashboardChartServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DashboardChartServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DashboardChartServiceFileDescriptorSupplier())
                      .addMethod(getGetDashboardChartMethod())
                      .addMethod(getBatchGetDashboardChartsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
