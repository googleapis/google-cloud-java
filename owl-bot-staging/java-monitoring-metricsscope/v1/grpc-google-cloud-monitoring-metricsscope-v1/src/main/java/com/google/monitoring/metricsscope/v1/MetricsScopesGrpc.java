package com.google.monitoring.metricsscope.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Manages Cloud Monitoring Metrics Scopes, and the monitoring of Google Cloud
 * projects and AWS accounts.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/monitoring/metricsscope/v1/metrics_scopes.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MetricsScopesGrpc {

  private MetricsScopesGrpc() {}

  public static final String SERVICE_NAME = "google.monitoring.metricsscope.v1.MetricsScopes";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest,
      com.google.monitoring.metricsscope.v1.MetricsScope> getGetMetricsScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMetricsScope",
      requestType = com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest.class,
      responseType = com.google.monitoring.metricsscope.v1.MetricsScope.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest,
      com.google.monitoring.metricsscope.v1.MetricsScope> getGetMetricsScopeMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest, com.google.monitoring.metricsscope.v1.MetricsScope> getGetMetricsScopeMethod;
    if ((getGetMetricsScopeMethod = MetricsScopesGrpc.getGetMetricsScopeMethod) == null) {
      synchronized (MetricsScopesGrpc.class) {
        if ((getGetMetricsScopeMethod = MetricsScopesGrpc.getGetMetricsScopeMethod) == null) {
          MetricsScopesGrpc.getGetMetricsScopeMethod = getGetMetricsScopeMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest, com.google.monitoring.metricsscope.v1.MetricsScope>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMetricsScope"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.metricsscope.v1.MetricsScope.getDefaultInstance()))
              .setSchemaDescriptor(new MetricsScopesMethodDescriptorSupplier("GetMetricsScope"))
              .build();
        }
      }
    }
    return getGetMetricsScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest,
      com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse> getListMetricsScopesByMonitoredProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMetricsScopesByMonitoredProject",
      requestType = com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest.class,
      responseType = com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest,
      com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse> getListMetricsScopesByMonitoredProjectMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest, com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse> getListMetricsScopesByMonitoredProjectMethod;
    if ((getListMetricsScopesByMonitoredProjectMethod = MetricsScopesGrpc.getListMetricsScopesByMonitoredProjectMethod) == null) {
      synchronized (MetricsScopesGrpc.class) {
        if ((getListMetricsScopesByMonitoredProjectMethod = MetricsScopesGrpc.getListMetricsScopesByMonitoredProjectMethod) == null) {
          MetricsScopesGrpc.getListMetricsScopesByMonitoredProjectMethod = getListMetricsScopesByMonitoredProjectMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest, com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMetricsScopesByMonitoredProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MetricsScopesMethodDescriptorSupplier("ListMetricsScopesByMonitoredProject"))
              .build();
        }
      }
    }
    return getListMetricsScopesByMonitoredProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest,
      com.google.longrunning.Operation> getCreateMonitoredProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMonitoredProject",
      requestType = com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest,
      com.google.longrunning.Operation> getCreateMonitoredProjectMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest, com.google.longrunning.Operation> getCreateMonitoredProjectMethod;
    if ((getCreateMonitoredProjectMethod = MetricsScopesGrpc.getCreateMonitoredProjectMethod) == null) {
      synchronized (MetricsScopesGrpc.class) {
        if ((getCreateMonitoredProjectMethod = MetricsScopesGrpc.getCreateMonitoredProjectMethod) == null) {
          MetricsScopesGrpc.getCreateMonitoredProjectMethod = getCreateMonitoredProjectMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMonitoredProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new MetricsScopesMethodDescriptorSupplier("CreateMonitoredProject"))
              .build();
        }
      }
    }
    return getCreateMonitoredProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest,
      com.google.longrunning.Operation> getDeleteMonitoredProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMonitoredProject",
      requestType = com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest,
      com.google.longrunning.Operation> getDeleteMonitoredProjectMethod() {
    io.grpc.MethodDescriptor<com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest, com.google.longrunning.Operation> getDeleteMonitoredProjectMethod;
    if ((getDeleteMonitoredProjectMethod = MetricsScopesGrpc.getDeleteMonitoredProjectMethod) == null) {
      synchronized (MetricsScopesGrpc.class) {
        if ((getDeleteMonitoredProjectMethod = MetricsScopesGrpc.getDeleteMonitoredProjectMethod) == null) {
          MetricsScopesGrpc.getDeleteMonitoredProjectMethod = getDeleteMonitoredProjectMethod =
              io.grpc.MethodDescriptor.<com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMonitoredProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new MetricsScopesMethodDescriptorSupplier("DeleteMonitoredProject"))
              .build();
        }
      }
    }
    return getDeleteMonitoredProjectMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MetricsScopesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricsScopesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MetricsScopesStub>() {
        @java.lang.Override
        public MetricsScopesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MetricsScopesStub(channel, callOptions);
        }
      };
    return MetricsScopesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MetricsScopesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricsScopesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MetricsScopesBlockingStub>() {
        @java.lang.Override
        public MetricsScopesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MetricsScopesBlockingStub(channel, callOptions);
        }
      };
    return MetricsScopesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MetricsScopesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricsScopesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MetricsScopesFutureStub>() {
        @java.lang.Override
        public MetricsScopesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MetricsScopesFutureStub(channel, callOptions);
        }
      };
    return MetricsScopesFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Manages Cloud Monitoring Metrics Scopes, and the monitoring of Google Cloud
   * projects and AWS accounts.
   * </pre>
   */
  public static abstract class MetricsScopesImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns a specific `Metrics Scope`.
     * </pre>
     */
    public void getMetricsScope(com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.metricsscope.v1.MetricsScope> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMetricsScopeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a list of every `Metrics Scope` that a specific `MonitoredProject`
     * has been added to. The metrics scope representing the specified monitored
     * project will always be the first entry in the response.
     * </pre>
     */
    public void listMetricsScopesByMonitoredProject(com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMetricsScopesByMonitoredProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * Adds a `MonitoredProject` with the given project ID
     * to the specified `Metrics Scope`.
     * </pre>
     */
    public void createMonitoredProject(com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMonitoredProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a `MonitoredProject` from the specified `Metrics Scope`.
     * </pre>
     */
    public void deleteMonitoredProject(com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMonitoredProjectMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMetricsScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest,
                com.google.monitoring.metricsscope.v1.MetricsScope>(
                  this, METHODID_GET_METRICS_SCOPE)))
          .addMethod(
            getListMetricsScopesByMonitoredProjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest,
                com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse>(
                  this, METHODID_LIST_METRICS_SCOPES_BY_MONITORED_PROJECT)))
          .addMethod(
            getCreateMonitoredProjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_MONITORED_PROJECT)))
          .addMethod(
            getDeleteMonitoredProjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_MONITORED_PROJECT)))
          .build();
    }
  }

  /**
   * <pre>
   * Manages Cloud Monitoring Metrics Scopes, and the monitoring of Google Cloud
   * projects and AWS accounts.
   * </pre>
   */
  public static final class MetricsScopesStub extends io.grpc.stub.AbstractAsyncStub<MetricsScopesStub> {
    private MetricsScopesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsScopesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricsScopesStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a specific `Metrics Scope`.
     * </pre>
     */
    public void getMetricsScope(com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.metricsscope.v1.MetricsScope> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMetricsScopeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a list of every `Metrics Scope` that a specific `MonitoredProject`
     * has been added to. The metrics scope representing the specified monitored
     * project will always be the first entry in the response.
     * </pre>
     */
    public void listMetricsScopesByMonitoredProject(com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMetricsScopesByMonitoredProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Adds a `MonitoredProject` with the given project ID
     * to the specified `Metrics Scope`.
     * </pre>
     */
    public void createMonitoredProject(com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMonitoredProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a `MonitoredProject` from the specified `Metrics Scope`.
     * </pre>
     */
    public void deleteMonitoredProject(com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMonitoredProjectMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Manages Cloud Monitoring Metrics Scopes, and the monitoring of Google Cloud
   * projects and AWS accounts.
   * </pre>
   */
  public static final class MetricsScopesBlockingStub extends io.grpc.stub.AbstractBlockingStub<MetricsScopesBlockingStub> {
    private MetricsScopesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsScopesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricsScopesBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a specific `Metrics Scope`.
     * </pre>
     */
    public com.google.monitoring.metricsscope.v1.MetricsScope getMetricsScope(com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMetricsScopeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a list of every `Metrics Scope` that a specific `MonitoredProject`
     * has been added to. The metrics scope representing the specified monitored
     * project will always be the first entry in the response.
     * </pre>
     */
    public com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse listMetricsScopesByMonitoredProject(com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMetricsScopesByMonitoredProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Adds a `MonitoredProject` with the given project ID
     * to the specified `Metrics Scope`.
     * </pre>
     */
    public com.google.longrunning.Operation createMonitoredProject(com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMonitoredProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a `MonitoredProject` from the specified `Metrics Scope`.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMonitoredProject(com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMonitoredProjectMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Manages Cloud Monitoring Metrics Scopes, and the monitoring of Google Cloud
   * projects and AWS accounts.
   * </pre>
   */
  public static final class MetricsScopesFutureStub extends io.grpc.stub.AbstractFutureStub<MetricsScopesFutureStub> {
    private MetricsScopesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsScopesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricsScopesFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a specific `Metrics Scope`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.metricsscope.v1.MetricsScope> getMetricsScope(
        com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMetricsScopeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a list of every `Metrics Scope` that a specific `MonitoredProject`
     * has been added to. The metrics scope representing the specified monitored
     * project will always be the first entry in the response.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse> listMetricsScopesByMonitoredProject(
        com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMetricsScopesByMonitoredProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Adds a `MonitoredProject` with the given project ID
     * to the specified `Metrics Scope`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createMonitoredProject(
        com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMonitoredProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a `MonitoredProject` from the specified `Metrics Scope`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteMonitoredProject(
        com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMonitoredProjectMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_METRICS_SCOPE = 0;
  private static final int METHODID_LIST_METRICS_SCOPES_BY_MONITORED_PROJECT = 1;
  private static final int METHODID_CREATE_MONITORED_PROJECT = 2;
  private static final int METHODID_DELETE_MONITORED_PROJECT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MetricsScopesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MetricsScopesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_METRICS_SCOPE:
          serviceImpl.getMetricsScope((com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.metricsscope.v1.MetricsScope>) responseObserver);
          break;
        case METHODID_LIST_METRICS_SCOPES_BY_MONITORED_PROJECT:
          serviceImpl.listMetricsScopesByMonitoredProject((com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse>) responseObserver);
          break;
        case METHODID_CREATE_MONITORED_PROJECT:
          serviceImpl.createMonitoredProject((com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MONITORED_PROJECT:
          serviceImpl.deleteMonitoredProject((com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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

  private static abstract class MetricsScopesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MetricsScopesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.monitoring.metricsscope.v1.MetricsScopesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MetricsScopes");
    }
  }

  private static final class MetricsScopesFileDescriptorSupplier
      extends MetricsScopesBaseDescriptorSupplier {
    MetricsScopesFileDescriptorSupplier() {}
  }

  private static final class MetricsScopesMethodDescriptorSupplier
      extends MetricsScopesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MetricsScopesMethodDescriptorSupplier(String methodName) {
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
      synchronized (MetricsScopesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MetricsScopesFileDescriptorSupplier())
              .addMethod(getGetMetricsScopeMethod())
              .addMethod(getListMetricsScopesByMonitoredProjectMethod())
              .addMethod(getCreateMonitoredProjectMethod())
              .addMethod(getDeleteMonitoredProjectMethod())
              .build();
        }
      }
    }
    return result;
  }
}
