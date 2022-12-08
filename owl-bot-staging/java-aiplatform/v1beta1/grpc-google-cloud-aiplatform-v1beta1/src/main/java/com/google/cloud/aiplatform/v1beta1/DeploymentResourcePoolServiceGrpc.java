package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service that manages the DeploymentResourcePool resource.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/deployment_resource_pool_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DeploymentResourcePoolServiceGrpc {

  private DeploymentResourcePoolServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1beta1.DeploymentResourcePoolService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest,
      com.google.longrunning.Operation> getCreateDeploymentResourcePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDeploymentResourcePool",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest,
      com.google.longrunning.Operation> getCreateDeploymentResourcePoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest, com.google.longrunning.Operation> getCreateDeploymentResourcePoolMethod;
    if ((getCreateDeploymentResourcePoolMethod = DeploymentResourcePoolServiceGrpc.getCreateDeploymentResourcePoolMethod) == null) {
      synchronized (DeploymentResourcePoolServiceGrpc.class) {
        if ((getCreateDeploymentResourcePoolMethod = DeploymentResourcePoolServiceGrpc.getCreateDeploymentResourcePoolMethod) == null) {
          DeploymentResourcePoolServiceGrpc.getCreateDeploymentResourcePoolMethod = getCreateDeploymentResourcePoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDeploymentResourcePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DeploymentResourcePoolServiceMethodDescriptorSupplier("CreateDeploymentResourcePool"))
              .build();
        }
      }
    }
    return getCreateDeploymentResourcePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest,
      com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool> getGetDeploymentResourcePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeploymentResourcePool",
      requestType = com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest,
      com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool> getGetDeploymentResourcePoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest, com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool> getGetDeploymentResourcePoolMethod;
    if ((getGetDeploymentResourcePoolMethod = DeploymentResourcePoolServiceGrpc.getGetDeploymentResourcePoolMethod) == null) {
      synchronized (DeploymentResourcePoolServiceGrpc.class) {
        if ((getGetDeploymentResourcePoolMethod = DeploymentResourcePoolServiceGrpc.getGetDeploymentResourcePoolMethod) == null) {
          DeploymentResourcePoolServiceGrpc.getGetDeploymentResourcePoolMethod = getGetDeploymentResourcePoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest, com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDeploymentResourcePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool.getDefaultInstance()))
              .setSchemaDescriptor(new DeploymentResourcePoolServiceMethodDescriptorSupplier("GetDeploymentResourcePool"))
              .build();
        }
      }
    }
    return getGetDeploymentResourcePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest,
      com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse> getListDeploymentResourcePoolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeploymentResourcePools",
      requestType = com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest,
      com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse> getListDeploymentResourcePoolsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest, com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse> getListDeploymentResourcePoolsMethod;
    if ((getListDeploymentResourcePoolsMethod = DeploymentResourcePoolServiceGrpc.getListDeploymentResourcePoolsMethod) == null) {
      synchronized (DeploymentResourcePoolServiceGrpc.class) {
        if ((getListDeploymentResourcePoolsMethod = DeploymentResourcePoolServiceGrpc.getListDeploymentResourcePoolsMethod) == null) {
          DeploymentResourcePoolServiceGrpc.getListDeploymentResourcePoolsMethod = getListDeploymentResourcePoolsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest, com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDeploymentResourcePools"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DeploymentResourcePoolServiceMethodDescriptorSupplier("ListDeploymentResourcePools"))
              .build();
        }
      }
    }
    return getListDeploymentResourcePoolsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest,
      com.google.longrunning.Operation> getDeleteDeploymentResourcePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDeploymentResourcePool",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest,
      com.google.longrunning.Operation> getDeleteDeploymentResourcePoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest, com.google.longrunning.Operation> getDeleteDeploymentResourcePoolMethod;
    if ((getDeleteDeploymentResourcePoolMethod = DeploymentResourcePoolServiceGrpc.getDeleteDeploymentResourcePoolMethod) == null) {
      synchronized (DeploymentResourcePoolServiceGrpc.class) {
        if ((getDeleteDeploymentResourcePoolMethod = DeploymentResourcePoolServiceGrpc.getDeleteDeploymentResourcePoolMethod) == null) {
          DeploymentResourcePoolServiceGrpc.getDeleteDeploymentResourcePoolMethod = getDeleteDeploymentResourcePoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDeploymentResourcePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DeploymentResourcePoolServiceMethodDescriptorSupplier("DeleteDeploymentResourcePool"))
              .build();
        }
      }
    }
    return getDeleteDeploymentResourcePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest,
      com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse> getQueryDeployedModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryDeployedModels",
      requestType = com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest,
      com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse> getQueryDeployedModelsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest, com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse> getQueryDeployedModelsMethod;
    if ((getQueryDeployedModelsMethod = DeploymentResourcePoolServiceGrpc.getQueryDeployedModelsMethod) == null) {
      synchronized (DeploymentResourcePoolServiceGrpc.class) {
        if ((getQueryDeployedModelsMethod = DeploymentResourcePoolServiceGrpc.getQueryDeployedModelsMethod) == null) {
          DeploymentResourcePoolServiceGrpc.getQueryDeployedModelsMethod = getQueryDeployedModelsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest, com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryDeployedModels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DeploymentResourcePoolServiceMethodDescriptorSupplier("QueryDeployedModels"))
              .build();
        }
      }
    }
    return getQueryDeployedModelsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeploymentResourcePoolServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeploymentResourcePoolServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeploymentResourcePoolServiceStub>() {
        @java.lang.Override
        public DeploymentResourcePoolServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeploymentResourcePoolServiceStub(channel, callOptions);
        }
      };
    return DeploymentResourcePoolServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeploymentResourcePoolServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeploymentResourcePoolServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeploymentResourcePoolServiceBlockingStub>() {
        @java.lang.Override
        public DeploymentResourcePoolServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeploymentResourcePoolServiceBlockingStub(channel, callOptions);
        }
      };
    return DeploymentResourcePoolServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeploymentResourcePoolServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeploymentResourcePoolServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeploymentResourcePoolServiceFutureStub>() {
        @java.lang.Override
        public DeploymentResourcePoolServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeploymentResourcePoolServiceFutureStub(channel, callOptions);
        }
      };
    return DeploymentResourcePoolServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service that manages the DeploymentResourcePool resource.
   * </pre>
   */
  public static abstract class DeploymentResourcePoolServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Create a DeploymentResourcePool.
     * </pre>
     */
    public void createDeploymentResourcePool(com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateDeploymentResourcePoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get a DeploymentResourcePool.
     * </pre>
     */
    public void getDeploymentResourcePool(com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDeploymentResourcePoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * List DeploymentResourcePools in a location.
     * </pre>
     */
    public void listDeploymentResourcePools(com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDeploymentResourcePoolsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Delete a DeploymentResourcePool.
     * </pre>
     */
    public void deleteDeploymentResourcePool(com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteDeploymentResourcePoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * List DeployedModels that have been deployed on this DeploymentResourcePool.
     * </pre>
     */
    public void queryDeployedModels(com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryDeployedModelsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateDeploymentResourcePoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_DEPLOYMENT_RESOURCE_POOL)))
          .addMethod(
            getGetDeploymentResourcePoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest,
                com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool>(
                  this, METHODID_GET_DEPLOYMENT_RESOURCE_POOL)))
          .addMethod(
            getListDeploymentResourcePoolsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest,
                com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse>(
                  this, METHODID_LIST_DEPLOYMENT_RESOURCE_POOLS)))
          .addMethod(
            getDeleteDeploymentResourcePoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_DEPLOYMENT_RESOURCE_POOL)))
          .addMethod(
            getQueryDeployedModelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest,
                com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse>(
                  this, METHODID_QUERY_DEPLOYED_MODELS)))
          .build();
    }
  }

  /**
   * <pre>
   * A service that manages the DeploymentResourcePool resource.
   * </pre>
   */
  public static final class DeploymentResourcePoolServiceStub extends io.grpc.stub.AbstractAsyncStub<DeploymentResourcePoolServiceStub> {
    private DeploymentResourcePoolServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeploymentResourcePoolServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeploymentResourcePoolServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a DeploymentResourcePool.
     * </pre>
     */
    public void createDeploymentResourcePool(com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDeploymentResourcePoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a DeploymentResourcePool.
     * </pre>
     */
    public void getDeploymentResourcePool(com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDeploymentResourcePoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List DeploymentResourcePools in a location.
     * </pre>
     */
    public void listDeploymentResourcePools(com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeploymentResourcePoolsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Delete a DeploymentResourcePool.
     * </pre>
     */
    public void deleteDeploymentResourcePool(com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDeploymentResourcePoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List DeployedModels that have been deployed on this DeploymentResourcePool.
     * </pre>
     */
    public void queryDeployedModels(com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryDeployedModelsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * A service that manages the DeploymentResourcePool resource.
   * </pre>
   */
  public static final class DeploymentResourcePoolServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DeploymentResourcePoolServiceBlockingStub> {
    private DeploymentResourcePoolServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeploymentResourcePoolServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeploymentResourcePoolServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a DeploymentResourcePool.
     * </pre>
     */
    public com.google.longrunning.Operation createDeploymentResourcePool(com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDeploymentResourcePoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a DeploymentResourcePool.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool getDeploymentResourcePool(com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeploymentResourcePoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List DeploymentResourcePools in a location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse listDeploymentResourcePools(com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeploymentResourcePoolsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Delete a DeploymentResourcePool.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDeploymentResourcePool(com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDeploymentResourcePoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List DeployedModels that have been deployed on this DeploymentResourcePool.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse queryDeployedModels(com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryDeployedModelsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A service that manages the DeploymentResourcePool resource.
   * </pre>
   */
  public static final class DeploymentResourcePoolServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DeploymentResourcePoolServiceFutureStub> {
    private DeploymentResourcePoolServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeploymentResourcePoolServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeploymentResourcePoolServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a DeploymentResourcePool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createDeploymentResourcePool(
        com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDeploymentResourcePoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get a DeploymentResourcePool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool> getDeploymentResourcePool(
        com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDeploymentResourcePoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List DeploymentResourcePools in a location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse> listDeploymentResourcePools(
        com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeploymentResourcePoolsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Delete a DeploymentResourcePool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteDeploymentResourcePool(
        com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDeploymentResourcePoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List DeployedModels that have been deployed on this DeploymentResourcePool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse> queryDeployedModels(
        com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryDeployedModelsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DEPLOYMENT_RESOURCE_POOL = 0;
  private static final int METHODID_GET_DEPLOYMENT_RESOURCE_POOL = 1;
  private static final int METHODID_LIST_DEPLOYMENT_RESOURCE_POOLS = 2;
  private static final int METHODID_DELETE_DEPLOYMENT_RESOURCE_POOL = 3;
  private static final int METHODID_QUERY_DEPLOYED_MODELS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DeploymentResourcePoolServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeploymentResourcePoolServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_DEPLOYMENT_RESOURCE_POOL:
          serviceImpl.createDeploymentResourcePool((com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DEPLOYMENT_RESOURCE_POOL:
          serviceImpl.getDeploymentResourcePool((com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool>) responseObserver);
          break;
        case METHODID_LIST_DEPLOYMENT_RESOURCE_POOLS:
          serviceImpl.listDeploymentResourcePools((com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse>) responseObserver);
          break;
        case METHODID_DELETE_DEPLOYMENT_RESOURCE_POOL:
          serviceImpl.deleteDeploymentResourcePool((com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_QUERY_DEPLOYED_MODELS:
          serviceImpl.queryDeployedModels((com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse>) responseObserver);
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

  private static abstract class DeploymentResourcePoolServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeploymentResourcePoolServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeploymentResourcePoolService");
    }
  }

  private static final class DeploymentResourcePoolServiceFileDescriptorSupplier
      extends DeploymentResourcePoolServiceBaseDescriptorSupplier {
    DeploymentResourcePoolServiceFileDescriptorSupplier() {}
  }

  private static final class DeploymentResourcePoolServiceMethodDescriptorSupplier
      extends DeploymentResourcePoolServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DeploymentResourcePoolServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DeploymentResourcePoolServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeploymentResourcePoolServiceFileDescriptorSupplier())
              .addMethod(getCreateDeploymentResourcePoolMethod())
              .addMethod(getGetDeploymentResourcePoolMethod())
              .addMethod(getListDeploymentResourcePoolsMethod())
              .addMethod(getDeleteDeploymentResourcePoolMethod())
              .addMethod(getQueryDeployedModelsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
