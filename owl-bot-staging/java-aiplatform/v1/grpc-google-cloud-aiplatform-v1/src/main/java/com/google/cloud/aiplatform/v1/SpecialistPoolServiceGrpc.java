package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service for creating and managing Customer SpecialistPools.
 * When customers start Data Labeling jobs, they can reuse/create Specialist
 * Pools to bring their own Specialists to label the data.
 * Customers can add/remove Managers for the Specialist Pool on Cloud console,
 * then Managers will get email notifications to manage Specialists and tasks on
 * CrowdCompute console.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/specialist_pool_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SpecialistPoolServiceGrpc {

  private SpecialistPoolServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1.SpecialistPoolService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreateSpecialistPoolRequest,
      com.google.longrunning.Operation> getCreateSpecialistPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSpecialistPool",
      requestType = com.google.cloud.aiplatform.v1.CreateSpecialistPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreateSpecialistPoolRequest,
      com.google.longrunning.Operation> getCreateSpecialistPoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreateSpecialistPoolRequest, com.google.longrunning.Operation> getCreateSpecialistPoolMethod;
    if ((getCreateSpecialistPoolMethod = SpecialistPoolServiceGrpc.getCreateSpecialistPoolMethod) == null) {
      synchronized (SpecialistPoolServiceGrpc.class) {
        if ((getCreateSpecialistPoolMethod = SpecialistPoolServiceGrpc.getCreateSpecialistPoolMethod) == null) {
          SpecialistPoolServiceGrpc.getCreateSpecialistPoolMethod = getCreateSpecialistPoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.CreateSpecialistPoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSpecialistPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.CreateSpecialistPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SpecialistPoolServiceMethodDescriptorSupplier("CreateSpecialistPool"))
              .build();
        }
      }
    }
    return getCreateSpecialistPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetSpecialistPoolRequest,
      com.google.cloud.aiplatform.v1.SpecialistPool> getGetSpecialistPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSpecialistPool",
      requestType = com.google.cloud.aiplatform.v1.GetSpecialistPoolRequest.class,
      responseType = com.google.cloud.aiplatform.v1.SpecialistPool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetSpecialistPoolRequest,
      com.google.cloud.aiplatform.v1.SpecialistPool> getGetSpecialistPoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetSpecialistPoolRequest, com.google.cloud.aiplatform.v1.SpecialistPool> getGetSpecialistPoolMethod;
    if ((getGetSpecialistPoolMethod = SpecialistPoolServiceGrpc.getGetSpecialistPoolMethod) == null) {
      synchronized (SpecialistPoolServiceGrpc.class) {
        if ((getGetSpecialistPoolMethod = SpecialistPoolServiceGrpc.getGetSpecialistPoolMethod) == null) {
          SpecialistPoolServiceGrpc.getGetSpecialistPoolMethod = getGetSpecialistPoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.GetSpecialistPoolRequest, com.google.cloud.aiplatform.v1.SpecialistPool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSpecialistPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.GetSpecialistPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.SpecialistPool.getDefaultInstance()))
              .setSchemaDescriptor(new SpecialistPoolServiceMethodDescriptorSupplier("GetSpecialistPool"))
              .build();
        }
      }
    }
    return getGetSpecialistPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListSpecialistPoolsRequest,
      com.google.cloud.aiplatform.v1.ListSpecialistPoolsResponse> getListSpecialistPoolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSpecialistPools",
      requestType = com.google.cloud.aiplatform.v1.ListSpecialistPoolsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListSpecialistPoolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListSpecialistPoolsRequest,
      com.google.cloud.aiplatform.v1.ListSpecialistPoolsResponse> getListSpecialistPoolsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListSpecialistPoolsRequest, com.google.cloud.aiplatform.v1.ListSpecialistPoolsResponse> getListSpecialistPoolsMethod;
    if ((getListSpecialistPoolsMethod = SpecialistPoolServiceGrpc.getListSpecialistPoolsMethod) == null) {
      synchronized (SpecialistPoolServiceGrpc.class) {
        if ((getListSpecialistPoolsMethod = SpecialistPoolServiceGrpc.getListSpecialistPoolsMethod) == null) {
          SpecialistPoolServiceGrpc.getListSpecialistPoolsMethod = getListSpecialistPoolsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.ListSpecialistPoolsRequest, com.google.cloud.aiplatform.v1.ListSpecialistPoolsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSpecialistPools"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ListSpecialistPoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ListSpecialistPoolsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SpecialistPoolServiceMethodDescriptorSupplier("ListSpecialistPools"))
              .build();
        }
      }
    }
    return getListSpecialistPoolsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeleteSpecialistPoolRequest,
      com.google.longrunning.Operation> getDeleteSpecialistPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSpecialistPool",
      requestType = com.google.cloud.aiplatform.v1.DeleteSpecialistPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeleteSpecialistPoolRequest,
      com.google.longrunning.Operation> getDeleteSpecialistPoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeleteSpecialistPoolRequest, com.google.longrunning.Operation> getDeleteSpecialistPoolMethod;
    if ((getDeleteSpecialistPoolMethod = SpecialistPoolServiceGrpc.getDeleteSpecialistPoolMethod) == null) {
      synchronized (SpecialistPoolServiceGrpc.class) {
        if ((getDeleteSpecialistPoolMethod = SpecialistPoolServiceGrpc.getDeleteSpecialistPoolMethod) == null) {
          SpecialistPoolServiceGrpc.getDeleteSpecialistPoolMethod = getDeleteSpecialistPoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.DeleteSpecialistPoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSpecialistPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.DeleteSpecialistPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SpecialistPoolServiceMethodDescriptorSupplier("DeleteSpecialistPool"))
              .build();
        }
      }
    }
    return getDeleteSpecialistPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.UpdateSpecialistPoolRequest,
      com.google.longrunning.Operation> getUpdateSpecialistPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSpecialistPool",
      requestType = com.google.cloud.aiplatform.v1.UpdateSpecialistPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.UpdateSpecialistPoolRequest,
      com.google.longrunning.Operation> getUpdateSpecialistPoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.UpdateSpecialistPoolRequest, com.google.longrunning.Operation> getUpdateSpecialistPoolMethod;
    if ((getUpdateSpecialistPoolMethod = SpecialistPoolServiceGrpc.getUpdateSpecialistPoolMethod) == null) {
      synchronized (SpecialistPoolServiceGrpc.class) {
        if ((getUpdateSpecialistPoolMethod = SpecialistPoolServiceGrpc.getUpdateSpecialistPoolMethod) == null) {
          SpecialistPoolServiceGrpc.getUpdateSpecialistPoolMethod = getUpdateSpecialistPoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.UpdateSpecialistPoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSpecialistPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.UpdateSpecialistPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SpecialistPoolServiceMethodDescriptorSupplier("UpdateSpecialistPool"))
              .build();
        }
      }
    }
    return getUpdateSpecialistPoolMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SpecialistPoolServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpecialistPoolServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SpecialistPoolServiceStub>() {
        @java.lang.Override
        public SpecialistPoolServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SpecialistPoolServiceStub(channel, callOptions);
        }
      };
    return SpecialistPoolServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SpecialistPoolServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpecialistPoolServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SpecialistPoolServiceBlockingStub>() {
        @java.lang.Override
        public SpecialistPoolServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SpecialistPoolServiceBlockingStub(channel, callOptions);
        }
      };
    return SpecialistPoolServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SpecialistPoolServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpecialistPoolServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SpecialistPoolServiceFutureStub>() {
        @java.lang.Override
        public SpecialistPoolServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SpecialistPoolServiceFutureStub(channel, callOptions);
        }
      };
    return SpecialistPoolServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service for creating and managing Customer SpecialistPools.
   * When customers start Data Labeling jobs, they can reuse/create Specialist
   * Pools to bring their own Specialists to label the data.
   * Customers can add/remove Managers for the Specialist Pool on Cloud console,
   * then Managers will get email notifications to manage Specialists and tasks on
   * CrowdCompute console.
   * </pre>
   */
  public static abstract class SpecialistPoolServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a SpecialistPool.
     * </pre>
     */
    public void createSpecialistPool(com.google.cloud.aiplatform.v1.CreateSpecialistPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSpecialistPoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a SpecialistPool.
     * </pre>
     */
    public void getSpecialistPool(com.google.cloud.aiplatform.v1.GetSpecialistPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.SpecialistPool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSpecialistPoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists SpecialistPools in a Location.
     * </pre>
     */
    public void listSpecialistPools(com.google.cloud.aiplatform.v1.ListSpecialistPoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListSpecialistPoolsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSpecialistPoolsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a SpecialistPool as well as all Specialists in the pool.
     * </pre>
     */
    public void deleteSpecialistPool(com.google.cloud.aiplatform.v1.DeleteSpecialistPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSpecialistPoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a SpecialistPool.
     * </pre>
     */
    public void updateSpecialistPool(com.google.cloud.aiplatform.v1.UpdateSpecialistPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateSpecialistPoolMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSpecialistPoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.CreateSpecialistPoolRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_SPECIALIST_POOL)))
          .addMethod(
            getGetSpecialistPoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.GetSpecialistPoolRequest,
                com.google.cloud.aiplatform.v1.SpecialistPool>(
                  this, METHODID_GET_SPECIALIST_POOL)))
          .addMethod(
            getListSpecialistPoolsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.ListSpecialistPoolsRequest,
                com.google.cloud.aiplatform.v1.ListSpecialistPoolsResponse>(
                  this, METHODID_LIST_SPECIALIST_POOLS)))
          .addMethod(
            getDeleteSpecialistPoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.DeleteSpecialistPoolRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_SPECIALIST_POOL)))
          .addMethod(
            getUpdateSpecialistPoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.UpdateSpecialistPoolRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_SPECIALIST_POOL)))
          .build();
    }
  }

  /**
   * <pre>
   * A service for creating and managing Customer SpecialistPools.
   * When customers start Data Labeling jobs, they can reuse/create Specialist
   * Pools to bring their own Specialists to label the data.
   * Customers can add/remove Managers for the Specialist Pool on Cloud console,
   * then Managers will get email notifications to manage Specialists and tasks on
   * CrowdCompute console.
   * </pre>
   */
  public static final class SpecialistPoolServiceStub extends io.grpc.stub.AbstractAsyncStub<SpecialistPoolServiceStub> {
    private SpecialistPoolServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpecialistPoolServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpecialistPoolServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a SpecialistPool.
     * </pre>
     */
    public void createSpecialistPool(com.google.cloud.aiplatform.v1.CreateSpecialistPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSpecialistPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a SpecialistPool.
     * </pre>
     */
    public void getSpecialistPool(com.google.cloud.aiplatform.v1.GetSpecialistPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.SpecialistPool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSpecialistPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists SpecialistPools in a Location.
     * </pre>
     */
    public void listSpecialistPools(com.google.cloud.aiplatform.v1.ListSpecialistPoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListSpecialistPoolsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSpecialistPoolsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a SpecialistPool as well as all Specialists in the pool.
     * </pre>
     */
    public void deleteSpecialistPool(com.google.cloud.aiplatform.v1.DeleteSpecialistPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSpecialistPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a SpecialistPool.
     * </pre>
     */
    public void updateSpecialistPool(com.google.cloud.aiplatform.v1.UpdateSpecialistPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSpecialistPoolMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * A service for creating and managing Customer SpecialistPools.
   * When customers start Data Labeling jobs, they can reuse/create Specialist
   * Pools to bring their own Specialists to label the data.
   * Customers can add/remove Managers for the Specialist Pool on Cloud console,
   * then Managers will get email notifications to manage Specialists and tasks on
   * CrowdCompute console.
   * </pre>
   */
  public static final class SpecialistPoolServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SpecialistPoolServiceBlockingStub> {
    private SpecialistPoolServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpecialistPoolServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpecialistPoolServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a SpecialistPool.
     * </pre>
     */
    public com.google.longrunning.Operation createSpecialistPool(com.google.cloud.aiplatform.v1.CreateSpecialistPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSpecialistPoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a SpecialistPool.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.SpecialistPool getSpecialistPool(com.google.cloud.aiplatform.v1.GetSpecialistPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSpecialistPoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists SpecialistPools in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListSpecialistPoolsResponse listSpecialistPools(com.google.cloud.aiplatform.v1.ListSpecialistPoolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSpecialistPoolsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a SpecialistPool as well as all Specialists in the pool.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSpecialistPool(com.google.cloud.aiplatform.v1.DeleteSpecialistPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSpecialistPoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a SpecialistPool.
     * </pre>
     */
    public com.google.longrunning.Operation updateSpecialistPool(com.google.cloud.aiplatform.v1.UpdateSpecialistPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSpecialistPoolMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A service for creating and managing Customer SpecialistPools.
   * When customers start Data Labeling jobs, they can reuse/create Specialist
   * Pools to bring their own Specialists to label the data.
   * Customers can add/remove Managers for the Specialist Pool on Cloud console,
   * then Managers will get email notifications to manage Specialists and tasks on
   * CrowdCompute console.
   * </pre>
   */
  public static final class SpecialistPoolServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SpecialistPoolServiceFutureStub> {
    private SpecialistPoolServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpecialistPoolServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpecialistPoolServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a SpecialistPool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createSpecialistPool(
        com.google.cloud.aiplatform.v1.CreateSpecialistPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSpecialistPoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a SpecialistPool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.SpecialistPool> getSpecialistPool(
        com.google.cloud.aiplatform.v1.GetSpecialistPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSpecialistPoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists SpecialistPools in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.ListSpecialistPoolsResponse> listSpecialistPools(
        com.google.cloud.aiplatform.v1.ListSpecialistPoolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSpecialistPoolsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a SpecialistPool as well as all Specialists in the pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteSpecialistPool(
        com.google.cloud.aiplatform.v1.DeleteSpecialistPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSpecialistPoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a SpecialistPool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateSpecialistPool(
        com.google.cloud.aiplatform.v1.UpdateSpecialistPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSpecialistPoolMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SPECIALIST_POOL = 0;
  private static final int METHODID_GET_SPECIALIST_POOL = 1;
  private static final int METHODID_LIST_SPECIALIST_POOLS = 2;
  private static final int METHODID_DELETE_SPECIALIST_POOL = 3;
  private static final int METHODID_UPDATE_SPECIALIST_POOL = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SpecialistPoolServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SpecialistPoolServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SPECIALIST_POOL:
          serviceImpl.createSpecialistPool((com.google.cloud.aiplatform.v1.CreateSpecialistPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SPECIALIST_POOL:
          serviceImpl.getSpecialistPool((com.google.cloud.aiplatform.v1.GetSpecialistPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.SpecialistPool>) responseObserver);
          break;
        case METHODID_LIST_SPECIALIST_POOLS:
          serviceImpl.listSpecialistPools((com.google.cloud.aiplatform.v1.ListSpecialistPoolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListSpecialistPoolsResponse>) responseObserver);
          break;
        case METHODID_DELETE_SPECIALIST_POOL:
          serviceImpl.deleteSpecialistPool((com.google.cloud.aiplatform.v1.DeleteSpecialistPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SPECIALIST_POOL:
          serviceImpl.updateSpecialistPool((com.google.cloud.aiplatform.v1.UpdateSpecialistPoolRequest) request,
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

  private static abstract class SpecialistPoolServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SpecialistPoolServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.SpecialistPoolServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SpecialistPoolService");
    }
  }

  private static final class SpecialistPoolServiceFileDescriptorSupplier
      extends SpecialistPoolServiceBaseDescriptorSupplier {
    SpecialistPoolServiceFileDescriptorSupplier() {}
  }

  private static final class SpecialistPoolServiceMethodDescriptorSupplier
      extends SpecialistPoolServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SpecialistPoolServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SpecialistPoolServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SpecialistPoolServiceFileDescriptorSupplier())
              .addMethod(getCreateSpecialistPoolMethod())
              .addMethod(getGetSpecialistPoolMethod())
              .addMethod(getListSpecialistPoolsMethod())
              .addMethod(getDeleteSpecialistPoolMethod())
              .addMethod(getUpdateSpecialistPoolMethod())
              .build();
        }
      }
    }
    return result;
  }
}
