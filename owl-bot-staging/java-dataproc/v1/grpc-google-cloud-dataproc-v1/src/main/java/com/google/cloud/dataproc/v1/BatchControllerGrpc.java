package com.google.cloud.dataproc.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The BatchController provides methods to manage batch workloads.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataproc/v1/batches.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BatchControllerGrpc {

  private BatchControllerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dataproc.v1.BatchController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateBatchRequest,
      com.google.longrunning.Operation> getCreateBatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBatch",
      requestType = com.google.cloud.dataproc.v1.CreateBatchRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateBatchRequest,
      com.google.longrunning.Operation> getCreateBatchMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateBatchRequest, com.google.longrunning.Operation> getCreateBatchMethod;
    if ((getCreateBatchMethod = BatchControllerGrpc.getCreateBatchMethod) == null) {
      synchronized (BatchControllerGrpc.class) {
        if ((getCreateBatchMethod = BatchControllerGrpc.getCreateBatchMethod) == null) {
          BatchControllerGrpc.getCreateBatchMethod = getCreateBatchMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.CreateBatchRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBatch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.CreateBatchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new BatchControllerMethodDescriptorSupplier("CreateBatch"))
              .build();
        }
      }
    }
    return getCreateBatchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetBatchRequest,
      com.google.cloud.dataproc.v1.Batch> getGetBatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBatch",
      requestType = com.google.cloud.dataproc.v1.GetBatchRequest.class,
      responseType = com.google.cloud.dataproc.v1.Batch.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetBatchRequest,
      com.google.cloud.dataproc.v1.Batch> getGetBatchMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetBatchRequest, com.google.cloud.dataproc.v1.Batch> getGetBatchMethod;
    if ((getGetBatchMethod = BatchControllerGrpc.getGetBatchMethod) == null) {
      synchronized (BatchControllerGrpc.class) {
        if ((getGetBatchMethod = BatchControllerGrpc.getGetBatchMethod) == null) {
          BatchControllerGrpc.getGetBatchMethod = getGetBatchMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.GetBatchRequest, com.google.cloud.dataproc.v1.Batch>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBatch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.GetBatchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.Batch.getDefaultInstance()))
              .setSchemaDescriptor(new BatchControllerMethodDescriptorSupplier("GetBatch"))
              .build();
        }
      }
    }
    return getGetBatchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListBatchesRequest,
      com.google.cloud.dataproc.v1.ListBatchesResponse> getListBatchesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBatches",
      requestType = com.google.cloud.dataproc.v1.ListBatchesRequest.class,
      responseType = com.google.cloud.dataproc.v1.ListBatchesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListBatchesRequest,
      com.google.cloud.dataproc.v1.ListBatchesResponse> getListBatchesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListBatchesRequest, com.google.cloud.dataproc.v1.ListBatchesResponse> getListBatchesMethod;
    if ((getListBatchesMethod = BatchControllerGrpc.getListBatchesMethod) == null) {
      synchronized (BatchControllerGrpc.class) {
        if ((getListBatchesMethod = BatchControllerGrpc.getListBatchesMethod) == null) {
          BatchControllerGrpc.getListBatchesMethod = getListBatchesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.ListBatchesRequest, com.google.cloud.dataproc.v1.ListBatchesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBatches"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.ListBatchesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.ListBatchesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BatchControllerMethodDescriptorSupplier("ListBatches"))
              .build();
        }
      }
    }
    return getListBatchesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteBatchRequest,
      com.google.protobuf.Empty> getDeleteBatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBatch",
      requestType = com.google.cloud.dataproc.v1.DeleteBatchRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteBatchRequest,
      com.google.protobuf.Empty> getDeleteBatchMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteBatchRequest, com.google.protobuf.Empty> getDeleteBatchMethod;
    if ((getDeleteBatchMethod = BatchControllerGrpc.getDeleteBatchMethod) == null) {
      synchronized (BatchControllerGrpc.class) {
        if ((getDeleteBatchMethod = BatchControllerGrpc.getDeleteBatchMethod) == null) {
          BatchControllerGrpc.getDeleteBatchMethod = getDeleteBatchMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.DeleteBatchRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBatch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.DeleteBatchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BatchControllerMethodDescriptorSupplier("DeleteBatch"))
              .build();
        }
      }
    }
    return getDeleteBatchMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BatchControllerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BatchControllerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BatchControllerStub>() {
        @java.lang.Override
        public BatchControllerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BatchControllerStub(channel, callOptions);
        }
      };
    return BatchControllerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BatchControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BatchControllerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BatchControllerBlockingStub>() {
        @java.lang.Override
        public BatchControllerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BatchControllerBlockingStub(channel, callOptions);
        }
      };
    return BatchControllerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BatchControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BatchControllerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BatchControllerFutureStub>() {
        @java.lang.Override
        public BatchControllerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BatchControllerFutureStub(channel, callOptions);
        }
      };
    return BatchControllerFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The BatchController provides methods to manage batch workloads.
   * </pre>
   */
  public static abstract class BatchControllerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a batch workload that executes asynchronously.
     * </pre>
     */
    public void createBatch(com.google.cloud.dataproc.v1.CreateBatchRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateBatchMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the batch workload resource representation.
     * </pre>
     */
    public void getBatch(com.google.cloud.dataproc.v1.GetBatchRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Batch> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBatchMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists batch workloads.
     * </pre>
     */
    public void listBatches(com.google.cloud.dataproc.v1.ListBatchesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListBatchesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListBatchesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the batch workload resource. If the batch is not in terminal state,
     * the delete fails and the response returns `FAILED_PRECONDITION`.
     * </pre>
     */
    public void deleteBatch(com.google.cloud.dataproc.v1.DeleteBatchRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteBatchMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateBatchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.CreateBatchRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_BATCH)))
          .addMethod(
            getGetBatchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.GetBatchRequest,
                com.google.cloud.dataproc.v1.Batch>(
                  this, METHODID_GET_BATCH)))
          .addMethod(
            getListBatchesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.ListBatchesRequest,
                com.google.cloud.dataproc.v1.ListBatchesResponse>(
                  this, METHODID_LIST_BATCHES)))
          .addMethod(
            getDeleteBatchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.DeleteBatchRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_BATCH)))
          .build();
    }
  }

  /**
   * <pre>
   * The BatchController provides methods to manage batch workloads.
   * </pre>
   */
  public static final class BatchControllerStub extends io.grpc.stub.AbstractAsyncStub<BatchControllerStub> {
    private BatchControllerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BatchControllerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BatchControllerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a batch workload that executes asynchronously.
     * </pre>
     */
    public void createBatch(com.google.cloud.dataproc.v1.CreateBatchRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBatchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the batch workload resource representation.
     * </pre>
     */
    public void getBatch(com.google.cloud.dataproc.v1.GetBatchRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Batch> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBatchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists batch workloads.
     * </pre>
     */
    public void listBatches(com.google.cloud.dataproc.v1.ListBatchesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListBatchesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBatchesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the batch workload resource. If the batch is not in terminal state,
     * the delete fails and the response returns `FAILED_PRECONDITION`.
     * </pre>
     */
    public void deleteBatch(com.google.cloud.dataproc.v1.DeleteBatchRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBatchMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The BatchController provides methods to manage batch workloads.
   * </pre>
   */
  public static final class BatchControllerBlockingStub extends io.grpc.stub.AbstractBlockingStub<BatchControllerBlockingStub> {
    private BatchControllerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BatchControllerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BatchControllerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a batch workload that executes asynchronously.
     * </pre>
     */
    public com.google.longrunning.Operation createBatch(com.google.cloud.dataproc.v1.CreateBatchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBatchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the batch workload resource representation.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.Batch getBatch(com.google.cloud.dataproc.v1.GetBatchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBatchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists batch workloads.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.ListBatchesResponse listBatches(com.google.cloud.dataproc.v1.ListBatchesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBatchesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the batch workload resource. If the batch is not in terminal state,
     * the delete fails and the response returns `FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBatch(com.google.cloud.dataproc.v1.DeleteBatchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBatchMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The BatchController provides methods to manage batch workloads.
   * </pre>
   */
  public static final class BatchControllerFutureStub extends io.grpc.stub.AbstractFutureStub<BatchControllerFutureStub> {
    private BatchControllerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BatchControllerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BatchControllerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a batch workload that executes asynchronously.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createBatch(
        com.google.cloud.dataproc.v1.CreateBatchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBatchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the batch workload resource representation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.Batch> getBatch(
        com.google.cloud.dataproc.v1.GetBatchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBatchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists batch workloads.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.ListBatchesResponse> listBatches(
        com.google.cloud.dataproc.v1.ListBatchesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBatchesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the batch workload resource. If the batch is not in terminal state,
     * the delete fails and the response returns `FAILED_PRECONDITION`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteBatch(
        com.google.cloud.dataproc.v1.DeleteBatchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBatchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BATCH = 0;
  private static final int METHODID_GET_BATCH = 1;
  private static final int METHODID_LIST_BATCHES = 2;
  private static final int METHODID_DELETE_BATCH = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BatchControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BatchControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_BATCH:
          serviceImpl.createBatch((com.google.cloud.dataproc.v1.CreateBatchRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_BATCH:
          serviceImpl.getBatch((com.google.cloud.dataproc.v1.GetBatchRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Batch>) responseObserver);
          break;
        case METHODID_LIST_BATCHES:
          serviceImpl.listBatches((com.google.cloud.dataproc.v1.ListBatchesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListBatchesResponse>) responseObserver);
          break;
        case METHODID_DELETE_BATCH:
          serviceImpl.deleteBatch((com.google.cloud.dataproc.v1.DeleteBatchRequest) request,
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

  private static abstract class BatchControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BatchControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataproc.v1.BatchesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BatchController");
    }
  }

  private static final class BatchControllerFileDescriptorSupplier
      extends BatchControllerBaseDescriptorSupplier {
    BatchControllerFileDescriptorSupplier() {}
  }

  private static final class BatchControllerMethodDescriptorSupplier
      extends BatchControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BatchControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (BatchControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BatchControllerFileDescriptorSupplier())
              .addMethod(getCreateBatchMethod())
              .addMethod(getGetBatchMethod())
              .addMethod(getListBatchesMethod())
              .addMethod(getDeleteBatchMethod())
              .build();
        }
      }
    }
    return result;
  }
}
