package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service that migrates resources from automl.googleapis.com,
 * datalabeling.googleapis.com and ml.googleapis.com to Vertex AI.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/migration_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MigrationServiceGrpc {

  private MigrationServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1.MigrationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest,
      com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse> getSearchMigratableResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchMigratableResources",
      requestType = com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest,
      com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse> getSearchMigratableResourcesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest, com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse> getSearchMigratableResourcesMethod;
    if ((getSearchMigratableResourcesMethod = MigrationServiceGrpc.getSearchMigratableResourcesMethod) == null) {
      synchronized (MigrationServiceGrpc.class) {
        if ((getSearchMigratableResourcesMethod = MigrationServiceGrpc.getSearchMigratableResourcesMethod) == null) {
          MigrationServiceGrpc.getSearchMigratableResourcesMethod = getSearchMigratableResourcesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest, com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchMigratableResources"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MigrationServiceMethodDescriptorSupplier("SearchMigratableResources"))
              .build();
        }
      }
    }
    return getSearchMigratableResourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest,
      com.google.longrunning.Operation> getBatchMigrateResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchMigrateResources",
      requestType = com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest,
      com.google.longrunning.Operation> getBatchMigrateResourcesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest, com.google.longrunning.Operation> getBatchMigrateResourcesMethod;
    if ((getBatchMigrateResourcesMethod = MigrationServiceGrpc.getBatchMigrateResourcesMethod) == null) {
      synchronized (MigrationServiceGrpc.class) {
        if ((getBatchMigrateResourcesMethod = MigrationServiceGrpc.getBatchMigrateResourcesMethod) == null) {
          MigrationServiceGrpc.getBatchMigrateResourcesMethod = getBatchMigrateResourcesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchMigrateResources"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new MigrationServiceMethodDescriptorSupplier("BatchMigrateResources"))
              .build();
        }
      }
    }
    return getBatchMigrateResourcesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MigrationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MigrationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MigrationServiceStub>() {
        @java.lang.Override
        public MigrationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MigrationServiceStub(channel, callOptions);
        }
      };
    return MigrationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MigrationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MigrationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MigrationServiceBlockingStub>() {
        @java.lang.Override
        public MigrationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MigrationServiceBlockingStub(channel, callOptions);
        }
      };
    return MigrationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MigrationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MigrationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MigrationServiceFutureStub>() {
        @java.lang.Override
        public MigrationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MigrationServiceFutureStub(channel, callOptions);
        }
      };
    return MigrationServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service that migrates resources from automl.googleapis.com,
   * datalabeling.googleapis.com and ml.googleapis.com to Vertex AI.
   * </pre>
   */
  public static abstract class MigrationServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Searches all of the resources in automl.googleapis.com,
     * datalabeling.googleapis.com and ml.googleapis.com that can be migrated to
     * Vertex AI's given location.
     * </pre>
     */
    public void searchMigratableResources(com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchMigratableResourcesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Batch migrates resources from ml.googleapis.com, automl.googleapis.com,
     * and datalabeling.googleapis.com to Vertex AI.
     * </pre>
     */
    public void batchMigrateResources(com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchMigrateResourcesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSearchMigratableResourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest,
                com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse>(
                  this, METHODID_SEARCH_MIGRATABLE_RESOURCES)))
          .addMethod(
            getBatchMigrateResourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_BATCH_MIGRATE_RESOURCES)))
          .build();
    }
  }

  /**
   * <pre>
   * A service that migrates resources from automl.googleapis.com,
   * datalabeling.googleapis.com and ml.googleapis.com to Vertex AI.
   * </pre>
   */
  public static final class MigrationServiceStub extends io.grpc.stub.AbstractAsyncStub<MigrationServiceStub> {
    private MigrationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MigrationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MigrationServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Searches all of the resources in automl.googleapis.com,
     * datalabeling.googleapis.com and ml.googleapis.com that can be migrated to
     * Vertex AI's given location.
     * </pre>
     */
    public void searchMigratableResources(com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchMigratableResourcesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Batch migrates resources from ml.googleapis.com, automl.googleapis.com,
     * and datalabeling.googleapis.com to Vertex AI.
     * </pre>
     */
    public void batchMigrateResources(com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchMigrateResourcesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * A service that migrates resources from automl.googleapis.com,
   * datalabeling.googleapis.com and ml.googleapis.com to Vertex AI.
   * </pre>
   */
  public static final class MigrationServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MigrationServiceBlockingStub> {
    private MigrationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MigrationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MigrationServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Searches all of the resources in automl.googleapis.com,
     * datalabeling.googleapis.com and ml.googleapis.com that can be migrated to
     * Vertex AI's given location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse searchMigratableResources(com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchMigratableResourcesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Batch migrates resources from ml.googleapis.com, automl.googleapis.com,
     * and datalabeling.googleapis.com to Vertex AI.
     * </pre>
     */
    public com.google.longrunning.Operation batchMigrateResources(com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchMigrateResourcesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A service that migrates resources from automl.googleapis.com,
   * datalabeling.googleapis.com and ml.googleapis.com to Vertex AI.
   * </pre>
   */
  public static final class MigrationServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MigrationServiceFutureStub> {
    private MigrationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MigrationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MigrationServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Searches all of the resources in automl.googleapis.com,
     * datalabeling.googleapis.com and ml.googleapis.com that can be migrated to
     * Vertex AI's given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse> searchMigratableResources(
        com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchMigratableResourcesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Batch migrates resources from ml.googleapis.com, automl.googleapis.com,
     * and datalabeling.googleapis.com to Vertex AI.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> batchMigrateResources(
        com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchMigrateResourcesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_MIGRATABLE_RESOURCES = 0;
  private static final int METHODID_BATCH_MIGRATE_RESOURCES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MigrationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MigrationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH_MIGRATABLE_RESOURCES:
          serviceImpl.searchMigratableResources((com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse>) responseObserver);
          break;
        case METHODID_BATCH_MIGRATE_RESOURCES:
          serviceImpl.batchMigrateResources((com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest) request,
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

  private static abstract class MigrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MigrationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.MigrationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MigrationService");
    }
  }

  private static final class MigrationServiceFileDescriptorSupplier
      extends MigrationServiceBaseDescriptorSupplier {
    MigrationServiceFileDescriptorSupplier() {}
  }

  private static final class MigrationServiceMethodDescriptorSupplier
      extends MigrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MigrationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MigrationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MigrationServiceFileDescriptorSupplier())
              .addMethod(getSearchMigratableResourcesMethod())
              .addMethod(getBatchMigrateResourcesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
