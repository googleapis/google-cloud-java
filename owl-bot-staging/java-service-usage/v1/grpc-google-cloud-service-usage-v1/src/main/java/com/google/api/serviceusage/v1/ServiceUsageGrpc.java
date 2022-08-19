package com.google.api.serviceusage.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Enables services that service consumers want to use on Google Cloud Platform,
 * lists the available or enabled services, or disables services that service
 * consumers no longer use.
 * See [Service Usage API](https://cloud.google.com/service-usage/docs/overview)
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/api/serviceusage/v1/serviceusage.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServiceUsageGrpc {

  private ServiceUsageGrpc() {}

  public static final String SERVICE_NAME = "google.api.serviceusage.v1.ServiceUsage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.EnableServiceRequest,
      com.google.longrunning.Operation> getEnableServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableService",
      requestType = com.google.api.serviceusage.v1.EnableServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.EnableServiceRequest,
      com.google.longrunning.Operation> getEnableServiceMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.EnableServiceRequest, com.google.longrunning.Operation> getEnableServiceMethod;
    if ((getEnableServiceMethod = ServiceUsageGrpc.getEnableServiceMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getEnableServiceMethod = ServiceUsageGrpc.getEnableServiceMethod) == null) {
          ServiceUsageGrpc.getEnableServiceMethod = getEnableServiceMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1.EnableServiceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnableService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1.EnableServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("EnableService"))
              .build();
        }
      }
    }
    return getEnableServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.DisableServiceRequest,
      com.google.longrunning.Operation> getDisableServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableService",
      requestType = com.google.api.serviceusage.v1.DisableServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.DisableServiceRequest,
      com.google.longrunning.Operation> getDisableServiceMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.DisableServiceRequest, com.google.longrunning.Operation> getDisableServiceMethod;
    if ((getDisableServiceMethod = ServiceUsageGrpc.getDisableServiceMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getDisableServiceMethod = ServiceUsageGrpc.getDisableServiceMethod) == null) {
          ServiceUsageGrpc.getDisableServiceMethod = getDisableServiceMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1.DisableServiceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisableService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1.DisableServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("DisableService"))
              .build();
        }
      }
    }
    return getDisableServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.GetServiceRequest,
      com.google.api.serviceusage.v1.Service> getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetService",
      requestType = com.google.api.serviceusage.v1.GetServiceRequest.class,
      responseType = com.google.api.serviceusage.v1.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.GetServiceRequest,
      com.google.api.serviceusage.v1.Service> getGetServiceMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.GetServiceRequest, com.google.api.serviceusage.v1.Service> getGetServiceMethod;
    if ((getGetServiceMethod = ServiceUsageGrpc.getGetServiceMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getGetServiceMethod = ServiceUsageGrpc.getGetServiceMethod) == null) {
          ServiceUsageGrpc.getGetServiceMethod = getGetServiceMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1.GetServiceRequest, com.google.api.serviceusage.v1.Service>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1.GetServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1.Service.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("GetService"))
              .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.ListServicesRequest,
      com.google.api.serviceusage.v1.ListServicesResponse> getListServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServices",
      requestType = com.google.api.serviceusage.v1.ListServicesRequest.class,
      responseType = com.google.api.serviceusage.v1.ListServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.ListServicesRequest,
      com.google.api.serviceusage.v1.ListServicesResponse> getListServicesMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.ListServicesRequest, com.google.api.serviceusage.v1.ListServicesResponse> getListServicesMethod;
    if ((getListServicesMethod = ServiceUsageGrpc.getListServicesMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getListServicesMethod = ServiceUsageGrpc.getListServicesMethod) == null) {
          ServiceUsageGrpc.getListServicesMethod = getListServicesMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1.ListServicesRequest, com.google.api.serviceusage.v1.ListServicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1.ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1.ListServicesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("ListServices"))
              .build();
        }
      }
    }
    return getListServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.BatchEnableServicesRequest,
      com.google.longrunning.Operation> getBatchEnableServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchEnableServices",
      requestType = com.google.api.serviceusage.v1.BatchEnableServicesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.BatchEnableServicesRequest,
      com.google.longrunning.Operation> getBatchEnableServicesMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.BatchEnableServicesRequest, com.google.longrunning.Operation> getBatchEnableServicesMethod;
    if ((getBatchEnableServicesMethod = ServiceUsageGrpc.getBatchEnableServicesMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getBatchEnableServicesMethod = ServiceUsageGrpc.getBatchEnableServicesMethod) == null) {
          ServiceUsageGrpc.getBatchEnableServicesMethod = getBatchEnableServicesMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1.BatchEnableServicesRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchEnableServices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1.BatchEnableServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("BatchEnableServices"))
              .build();
        }
      }
    }
    return getBatchEnableServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.BatchGetServicesRequest,
      com.google.api.serviceusage.v1.BatchGetServicesResponse> getBatchGetServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchGetServices",
      requestType = com.google.api.serviceusage.v1.BatchGetServicesRequest.class,
      responseType = com.google.api.serviceusage.v1.BatchGetServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.BatchGetServicesRequest,
      com.google.api.serviceusage.v1.BatchGetServicesResponse> getBatchGetServicesMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1.BatchGetServicesRequest, com.google.api.serviceusage.v1.BatchGetServicesResponse> getBatchGetServicesMethod;
    if ((getBatchGetServicesMethod = ServiceUsageGrpc.getBatchGetServicesMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getBatchGetServicesMethod = ServiceUsageGrpc.getBatchGetServicesMethod) == null) {
          ServiceUsageGrpc.getBatchGetServicesMethod = getBatchGetServicesMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1.BatchGetServicesRequest, com.google.api.serviceusage.v1.BatchGetServicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchGetServices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1.BatchGetServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1.BatchGetServicesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("BatchGetServices"))
              .build();
        }
      }
    }
    return getBatchGetServicesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceUsageStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceUsageStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceUsageStub>() {
        @java.lang.Override
        public ServiceUsageStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceUsageStub(channel, callOptions);
        }
      };
    return ServiceUsageStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceUsageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceUsageBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceUsageBlockingStub>() {
        @java.lang.Override
        public ServiceUsageBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceUsageBlockingStub(channel, callOptions);
        }
      };
    return ServiceUsageBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceUsageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceUsageFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceUsageFutureStub>() {
        @java.lang.Override
        public ServiceUsageFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceUsageFutureStub(channel, callOptions);
        }
      };
    return ServiceUsageFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Enables services that service consumers want to use on Google Cloud Platform,
   * lists the available or enabled services, or disables services that service
   * consumers no longer use.
   * See [Service Usage API](https://cloud.google.com/service-usage/docs/overview)
   * </pre>
   */
  public static abstract class ServiceUsageImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Enable a service so that it can be used with a project.
     * </pre>
     */
    public void enableService(com.google.api.serviceusage.v1.EnableServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEnableServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Disable a service so that it can no longer be used with a project.
     * This prevents unintended usage that may cause unexpected billing
     * charges or security leaks.
     * It is not valid to call the disable method on a service that is not
     * currently enabled. Callers will receive a `FAILED_PRECONDITION` status if
     * the target service is not currently enabled.
     * </pre>
     */
    public void disableService(com.google.api.serviceusage.v1.DisableServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDisableServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the service configuration and enabled state for a given service.
     * </pre>
     */
    public void getService(com.google.api.serviceusage.v1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1.Service> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * List all services available to the specified project, and the current
     * state of those services with respect to the project. The list includes
     * all public services, all services for which the calling user has the
     * `servicemanagement.services.bind` permission, and all services that have
     * already been enabled on the project. The list can be filtered to
     * only include services in a specific state, for example to only include
     * services enabled on the project.
     * WARNING: If you need to query enabled services frequently or across
     * an organization, you should use
     * [Cloud Asset Inventory
     * API](https://cloud.google.com/asset-inventory/docs/apis), which provides
     * higher throughput and richer filtering capability.
     * </pre>
     */
    public void listServices(com.google.api.serviceusage.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1.ListServicesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListServicesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Enable multiple services on a project. The operation is atomic: if enabling
     * any service fails, then the entire batch fails, and no state changes occur.
     * To enable a single service, use the `EnableService` method instead.
     * </pre>
     */
    public void batchEnableServices(com.google.api.serviceusage.v1.BatchEnableServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchEnableServicesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the service configurations and enabled states for a given list of
     * services.
     * </pre>
     */
    public void batchGetServices(com.google.api.serviceusage.v1.BatchGetServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1.BatchGetServicesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchGetServicesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEnableServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1.EnableServiceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_ENABLE_SERVICE)))
          .addMethod(
            getDisableServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1.DisableServiceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DISABLE_SERVICE)))
          .addMethod(
            getGetServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1.GetServiceRequest,
                com.google.api.serviceusage.v1.Service>(
                  this, METHODID_GET_SERVICE)))
          .addMethod(
            getListServicesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1.ListServicesRequest,
                com.google.api.serviceusage.v1.ListServicesResponse>(
                  this, METHODID_LIST_SERVICES)))
          .addMethod(
            getBatchEnableServicesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1.BatchEnableServicesRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_BATCH_ENABLE_SERVICES)))
          .addMethod(
            getBatchGetServicesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1.BatchGetServicesRequest,
                com.google.api.serviceusage.v1.BatchGetServicesResponse>(
                  this, METHODID_BATCH_GET_SERVICES)))
          .build();
    }
  }

  /**
   * <pre>
   * Enables services that service consumers want to use on Google Cloud Platform,
   * lists the available or enabled services, or disables services that service
   * consumers no longer use.
   * See [Service Usage API](https://cloud.google.com/service-usage/docs/overview)
   * </pre>
   */
  public static final class ServiceUsageStub extends io.grpc.stub.AbstractAsyncStub<ServiceUsageStub> {
    private ServiceUsageStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceUsageStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceUsageStub(channel, callOptions);
    }

    /**
     * <pre>
     * Enable a service so that it can be used with a project.
     * </pre>
     */
    public void enableService(com.google.api.serviceusage.v1.EnableServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Disable a service so that it can no longer be used with a project.
     * This prevents unintended usage that may cause unexpected billing
     * charges or security leaks.
     * It is not valid to call the disable method on a service that is not
     * currently enabled. Callers will receive a `FAILED_PRECONDITION` status if
     * the target service is not currently enabled.
     * </pre>
     */
    public void disableService(com.google.api.serviceusage.v1.DisableServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the service configuration and enabled state for a given service.
     * </pre>
     */
    public void getService(com.google.api.serviceusage.v1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1.Service> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List all services available to the specified project, and the current
     * state of those services with respect to the project. The list includes
     * all public services, all services for which the calling user has the
     * `servicemanagement.services.bind` permission, and all services that have
     * already been enabled on the project. The list can be filtered to
     * only include services in a specific state, for example to only include
     * services enabled on the project.
     * WARNING: If you need to query enabled services frequently or across
     * an organization, you should use
     * [Cloud Asset Inventory
     * API](https://cloud.google.com/asset-inventory/docs/apis), which provides
     * higher throughput and richer filtering capability.
     * </pre>
     */
    public void listServices(com.google.api.serviceusage.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1.ListServicesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Enable multiple services on a project. The operation is atomic: if enabling
     * any service fails, then the entire batch fails, and no state changes occur.
     * To enable a single service, use the `EnableService` method instead.
     * </pre>
     */
    public void batchEnableServices(com.google.api.serviceusage.v1.BatchEnableServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchEnableServicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the service configurations and enabled states for a given list of
     * services.
     * </pre>
     */
    public void batchGetServices(com.google.api.serviceusage.v1.BatchGetServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1.BatchGetServicesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchGetServicesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Enables services that service consumers want to use on Google Cloud Platform,
   * lists the available or enabled services, or disables services that service
   * consumers no longer use.
   * See [Service Usage API](https://cloud.google.com/service-usage/docs/overview)
   * </pre>
   */
  public static final class ServiceUsageBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServiceUsageBlockingStub> {
    private ServiceUsageBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceUsageBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceUsageBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Enable a service so that it can be used with a project.
     * </pre>
     */
    public com.google.longrunning.Operation enableService(com.google.api.serviceusage.v1.EnableServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Disable a service so that it can no longer be used with a project.
     * This prevents unintended usage that may cause unexpected billing
     * charges or security leaks.
     * It is not valid to call the disable method on a service that is not
     * currently enabled. Callers will receive a `FAILED_PRECONDITION` status if
     * the target service is not currently enabled.
     * </pre>
     */
    public com.google.longrunning.Operation disableService(com.google.api.serviceusage.v1.DisableServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the service configuration and enabled state for a given service.
     * </pre>
     */
    public com.google.api.serviceusage.v1.Service getService(com.google.api.serviceusage.v1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List all services available to the specified project, and the current
     * state of those services with respect to the project. The list includes
     * all public services, all services for which the calling user has the
     * `servicemanagement.services.bind` permission, and all services that have
     * already been enabled on the project. The list can be filtered to
     * only include services in a specific state, for example to only include
     * services enabled on the project.
     * WARNING: If you need to query enabled services frequently or across
     * an organization, you should use
     * [Cloud Asset Inventory
     * API](https://cloud.google.com/asset-inventory/docs/apis), which provides
     * higher throughput and richer filtering capability.
     * </pre>
     */
    public com.google.api.serviceusage.v1.ListServicesResponse listServices(com.google.api.serviceusage.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Enable multiple services on a project. The operation is atomic: if enabling
     * any service fails, then the entire batch fails, and no state changes occur.
     * To enable a single service, use the `EnableService` method instead.
     * </pre>
     */
    public com.google.longrunning.Operation batchEnableServices(com.google.api.serviceusage.v1.BatchEnableServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchEnableServicesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the service configurations and enabled states for a given list of
     * services.
     * </pre>
     */
    public com.google.api.serviceusage.v1.BatchGetServicesResponse batchGetServices(com.google.api.serviceusage.v1.BatchGetServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchGetServicesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Enables services that service consumers want to use on Google Cloud Platform,
   * lists the available or enabled services, or disables services that service
   * consumers no longer use.
   * See [Service Usage API](https://cloud.google.com/service-usage/docs/overview)
   * </pre>
   */
  public static final class ServiceUsageFutureStub extends io.grpc.stub.AbstractFutureStub<ServiceUsageFutureStub> {
    private ServiceUsageFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceUsageFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceUsageFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Enable a service so that it can be used with a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> enableService(
        com.google.api.serviceusage.v1.EnableServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Disable a service so that it can no longer be used with a project.
     * This prevents unintended usage that may cause unexpected billing
     * charges or security leaks.
     * It is not valid to call the disable method on a service that is not
     * currently enabled. Callers will receive a `FAILED_PRECONDITION` status if
     * the target service is not currently enabled.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> disableService(
        com.google.api.serviceusage.v1.DisableServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the service configuration and enabled state for a given service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.serviceusage.v1.Service> getService(
        com.google.api.serviceusage.v1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List all services available to the specified project, and the current
     * state of those services with respect to the project. The list includes
     * all public services, all services for which the calling user has the
     * `servicemanagement.services.bind` permission, and all services that have
     * already been enabled on the project. The list can be filtered to
     * only include services in a specific state, for example to only include
     * services enabled on the project.
     * WARNING: If you need to query enabled services frequently or across
     * an organization, you should use
     * [Cloud Asset Inventory
     * API](https://cloud.google.com/asset-inventory/docs/apis), which provides
     * higher throughput and richer filtering capability.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.serviceusage.v1.ListServicesResponse> listServices(
        com.google.api.serviceusage.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Enable multiple services on a project. The operation is atomic: if enabling
     * any service fails, then the entire batch fails, and no state changes occur.
     * To enable a single service, use the `EnableService` method instead.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> batchEnableServices(
        com.google.api.serviceusage.v1.BatchEnableServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchEnableServicesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the service configurations and enabled states for a given list of
     * services.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.serviceusage.v1.BatchGetServicesResponse> batchGetServices(
        com.google.api.serviceusage.v1.BatchGetServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchGetServicesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENABLE_SERVICE = 0;
  private static final int METHODID_DISABLE_SERVICE = 1;
  private static final int METHODID_GET_SERVICE = 2;
  private static final int METHODID_LIST_SERVICES = 3;
  private static final int METHODID_BATCH_ENABLE_SERVICES = 4;
  private static final int METHODID_BATCH_GET_SERVICES = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceUsageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceUsageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENABLE_SERVICE:
          serviceImpl.enableService((com.google.api.serviceusage.v1.EnableServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DISABLE_SERVICE:
          serviceImpl.disableService((com.google.api.serviceusage.v1.DisableServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService((com.google.api.serviceusage.v1.GetServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1.Service>) responseObserver);
          break;
        case METHODID_LIST_SERVICES:
          serviceImpl.listServices((com.google.api.serviceusage.v1.ListServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1.ListServicesResponse>) responseObserver);
          break;
        case METHODID_BATCH_ENABLE_SERVICES:
          serviceImpl.batchEnableServices((com.google.api.serviceusage.v1.BatchEnableServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_GET_SERVICES:
          serviceImpl.batchGetServices((com.google.api.serviceusage.v1.BatchGetServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1.BatchGetServicesResponse>) responseObserver);
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

  private static abstract class ServiceUsageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceUsageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.api.serviceusage.v1.ServiceUsageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServiceUsage");
    }
  }

  private static final class ServiceUsageFileDescriptorSupplier
      extends ServiceUsageBaseDescriptorSupplier {
    ServiceUsageFileDescriptorSupplier() {}
  }

  private static final class ServiceUsageMethodDescriptorSupplier
      extends ServiceUsageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceUsageMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServiceUsageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceUsageFileDescriptorSupplier())
              .addMethod(getEnableServiceMethod())
              .addMethod(getDisableServiceMethod())
              .addMethod(getGetServiceMethod())
              .addMethod(getListServicesMethod())
              .addMethod(getBatchEnableServicesMethod())
              .addMethod(getBatchGetServicesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
