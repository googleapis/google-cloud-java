package com.google.cloud.contentwarehouse.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A Service that manage/custom customer specified SynonymSets.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/contentwarehouse/v1/synonymset_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SynonymSetServiceGrpc {

  private SynonymSetServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.contentwarehouse.v1.SynonymSetService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest,
      com.google.cloud.contentwarehouse.v1.SynonymSet> getCreateSynonymSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSynonymSet",
      requestType = com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.SynonymSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest,
      com.google.cloud.contentwarehouse.v1.SynonymSet> getCreateSynonymSetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest, com.google.cloud.contentwarehouse.v1.SynonymSet> getCreateSynonymSetMethod;
    if ((getCreateSynonymSetMethod = SynonymSetServiceGrpc.getCreateSynonymSetMethod) == null) {
      synchronized (SynonymSetServiceGrpc.class) {
        if ((getCreateSynonymSetMethod = SynonymSetServiceGrpc.getCreateSynonymSetMethod) == null) {
          SynonymSetServiceGrpc.getCreateSynonymSetMethod = getCreateSynonymSetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest, com.google.cloud.contentwarehouse.v1.SynonymSet>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSynonymSet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.contentwarehouse.v1.SynonymSet.getDefaultInstance()))
              .setSchemaDescriptor(new SynonymSetServiceMethodDescriptorSupplier("CreateSynonymSet"))
              .build();
        }
      }
    }
    return getCreateSynonymSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest,
      com.google.cloud.contentwarehouse.v1.SynonymSet> getGetSynonymSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSynonymSet",
      requestType = com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.SynonymSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest,
      com.google.cloud.contentwarehouse.v1.SynonymSet> getGetSynonymSetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest, com.google.cloud.contentwarehouse.v1.SynonymSet> getGetSynonymSetMethod;
    if ((getGetSynonymSetMethod = SynonymSetServiceGrpc.getGetSynonymSetMethod) == null) {
      synchronized (SynonymSetServiceGrpc.class) {
        if ((getGetSynonymSetMethod = SynonymSetServiceGrpc.getGetSynonymSetMethod) == null) {
          SynonymSetServiceGrpc.getGetSynonymSetMethod = getGetSynonymSetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest, com.google.cloud.contentwarehouse.v1.SynonymSet>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSynonymSet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.contentwarehouse.v1.SynonymSet.getDefaultInstance()))
              .setSchemaDescriptor(new SynonymSetServiceMethodDescriptorSupplier("GetSynonymSet"))
              .build();
        }
      }
    }
    return getGetSynonymSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest,
      com.google.cloud.contentwarehouse.v1.SynonymSet> getUpdateSynonymSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSynonymSet",
      requestType = com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.SynonymSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest,
      com.google.cloud.contentwarehouse.v1.SynonymSet> getUpdateSynonymSetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest, com.google.cloud.contentwarehouse.v1.SynonymSet> getUpdateSynonymSetMethod;
    if ((getUpdateSynonymSetMethod = SynonymSetServiceGrpc.getUpdateSynonymSetMethod) == null) {
      synchronized (SynonymSetServiceGrpc.class) {
        if ((getUpdateSynonymSetMethod = SynonymSetServiceGrpc.getUpdateSynonymSetMethod) == null) {
          SynonymSetServiceGrpc.getUpdateSynonymSetMethod = getUpdateSynonymSetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest, com.google.cloud.contentwarehouse.v1.SynonymSet>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSynonymSet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.contentwarehouse.v1.SynonymSet.getDefaultInstance()))
              .setSchemaDescriptor(new SynonymSetServiceMethodDescriptorSupplier("UpdateSynonymSet"))
              .build();
        }
      }
    }
    return getUpdateSynonymSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest,
      com.google.protobuf.Empty> getDeleteSynonymSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSynonymSet",
      requestType = com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest,
      com.google.protobuf.Empty> getDeleteSynonymSetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest, com.google.protobuf.Empty> getDeleteSynonymSetMethod;
    if ((getDeleteSynonymSetMethod = SynonymSetServiceGrpc.getDeleteSynonymSetMethod) == null) {
      synchronized (SynonymSetServiceGrpc.class) {
        if ((getDeleteSynonymSetMethod = SynonymSetServiceGrpc.getDeleteSynonymSetMethod) == null) {
          SynonymSetServiceGrpc.getDeleteSynonymSetMethod = getDeleteSynonymSetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSynonymSet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new SynonymSetServiceMethodDescriptorSupplier("DeleteSynonymSet"))
              .build();
        }
      }
    }
    return getDeleteSynonymSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest,
      com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse> getListSynonymSetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSynonymSets",
      requestType = com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest,
      com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse> getListSynonymSetsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest, com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse> getListSynonymSetsMethod;
    if ((getListSynonymSetsMethod = SynonymSetServiceGrpc.getListSynonymSetsMethod) == null) {
      synchronized (SynonymSetServiceGrpc.class) {
        if ((getListSynonymSetsMethod = SynonymSetServiceGrpc.getListSynonymSetsMethod) == null) {
          SynonymSetServiceGrpc.getListSynonymSetsMethod = getListSynonymSetsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest, com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSynonymSets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SynonymSetServiceMethodDescriptorSupplier("ListSynonymSets"))
              .build();
        }
      }
    }
    return getListSynonymSetsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SynonymSetServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SynonymSetServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SynonymSetServiceStub>() {
        @java.lang.Override
        public SynonymSetServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SynonymSetServiceStub(channel, callOptions);
        }
      };
    return SynonymSetServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SynonymSetServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SynonymSetServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SynonymSetServiceBlockingStub>() {
        @java.lang.Override
        public SynonymSetServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SynonymSetServiceBlockingStub(channel, callOptions);
        }
      };
    return SynonymSetServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SynonymSetServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SynonymSetServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SynonymSetServiceFutureStub>() {
        @java.lang.Override
        public SynonymSetServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SynonymSetServiceFutureStub(channel, callOptions);
        }
      };
    return SynonymSetServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A Service that manage/custom customer specified SynonymSets.
   * </pre>
   */
  public static abstract class SynonymSetServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a SynonymSet for a single context.
     * Throws an ALREADY_EXISTS exception if a synonymset already exists
     * for the context.
     * </pre>
     */
    public void createSynonymSet(com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SynonymSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSynonymSetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a SynonymSet for a particular context.
     * Throws a NOT_FOUND exception if the Synonymset
     * does not exist
     * </pre>
     */
    public void getSynonymSet(com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SynonymSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSynonymSetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Remove the existing SynonymSet for the context and replaces it
     * with a new one.
     * Throws a NOT_FOUND exception if the SynonymSet is not found.
     * </pre>
     */
    public void updateSynonymSet(com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SynonymSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateSynonymSetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a SynonymSet for a given context.
     * Throws a NOT_FOUND exception if the SynonymSet is not found.
     * </pre>
     */
    public void deleteSynonymSet(com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSynonymSetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns all SynonymSets (for all contexts) for the specified location.
     * </pre>
     */
    public void listSynonymSets(com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSynonymSetsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSynonymSetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest,
                com.google.cloud.contentwarehouse.v1.SynonymSet>(
                  this, METHODID_CREATE_SYNONYM_SET)))
          .addMethod(
            getGetSynonymSetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest,
                com.google.cloud.contentwarehouse.v1.SynonymSet>(
                  this, METHODID_GET_SYNONYM_SET)))
          .addMethod(
            getUpdateSynonymSetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest,
                com.google.cloud.contentwarehouse.v1.SynonymSet>(
                  this, METHODID_UPDATE_SYNONYM_SET)))
          .addMethod(
            getDeleteSynonymSetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_SYNONYM_SET)))
          .addMethod(
            getListSynonymSetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest,
                com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse>(
                  this, METHODID_LIST_SYNONYM_SETS)))
          .build();
    }
  }

  /**
   * <pre>
   * A Service that manage/custom customer specified SynonymSets.
   * </pre>
   */
  public static final class SynonymSetServiceStub extends io.grpc.stub.AbstractAsyncStub<SynonymSetServiceStub> {
    private SynonymSetServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SynonymSetServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SynonymSetServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a SynonymSet for a single context.
     * Throws an ALREADY_EXISTS exception if a synonymset already exists
     * for the context.
     * </pre>
     */
    public void createSynonymSet(com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SynonymSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSynonymSetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a SynonymSet for a particular context.
     * Throws a NOT_FOUND exception if the Synonymset
     * does not exist
     * </pre>
     */
    public void getSynonymSet(com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SynonymSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSynonymSetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Remove the existing SynonymSet for the context and replaces it
     * with a new one.
     * Throws a NOT_FOUND exception if the SynonymSet is not found.
     * </pre>
     */
    public void updateSynonymSet(com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SynonymSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSynonymSetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a SynonymSet for a given context.
     * Throws a NOT_FOUND exception if the SynonymSet is not found.
     * </pre>
     */
    public void deleteSynonymSet(com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSynonymSetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns all SynonymSets (for all contexts) for the specified location.
     * </pre>
     */
    public void listSynonymSets(com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSynonymSetsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * A Service that manage/custom customer specified SynonymSets.
   * </pre>
   */
  public static final class SynonymSetServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SynonymSetServiceBlockingStub> {
    private SynonymSetServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SynonymSetServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SynonymSetServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a SynonymSet for a single context.
     * Throws an ALREADY_EXISTS exception if a synonymset already exists
     * for the context.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.SynonymSet createSynonymSet(com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSynonymSetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a SynonymSet for a particular context.
     * Throws a NOT_FOUND exception if the Synonymset
     * does not exist
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.SynonymSet getSynonymSet(com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSynonymSetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Remove the existing SynonymSet for the context and replaces it
     * with a new one.
     * Throws a NOT_FOUND exception if the SynonymSet is not found.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.SynonymSet updateSynonymSet(com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSynonymSetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a SynonymSet for a given context.
     * Throws a NOT_FOUND exception if the SynonymSet is not found.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSynonymSet(com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSynonymSetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns all SynonymSets (for all contexts) for the specified location.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse listSynonymSets(com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSynonymSetsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A Service that manage/custom customer specified SynonymSets.
   * </pre>
   */
  public static final class SynonymSetServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SynonymSetServiceFutureStub> {
    private SynonymSetServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SynonymSetServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SynonymSetServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a SynonymSet for a single context.
     * Throws an ALREADY_EXISTS exception if a synonymset already exists
     * for the context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.contentwarehouse.v1.SynonymSet> createSynonymSet(
        com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSynonymSetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a SynonymSet for a particular context.
     * Throws a NOT_FOUND exception if the Synonymset
     * does not exist
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.contentwarehouse.v1.SynonymSet> getSynonymSet(
        com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSynonymSetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Remove the existing SynonymSet for the context and replaces it
     * with a new one.
     * Throws a NOT_FOUND exception if the SynonymSet is not found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.contentwarehouse.v1.SynonymSet> updateSynonymSet(
        com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSynonymSetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a SynonymSet for a given context.
     * Throws a NOT_FOUND exception if the SynonymSet is not found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteSynonymSet(
        com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSynonymSetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns all SynonymSets (for all contexts) for the specified location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse> listSynonymSets(
        com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSynonymSetsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SYNONYM_SET = 0;
  private static final int METHODID_GET_SYNONYM_SET = 1;
  private static final int METHODID_UPDATE_SYNONYM_SET = 2;
  private static final int METHODID_DELETE_SYNONYM_SET = 3;
  private static final int METHODID_LIST_SYNONYM_SETS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SynonymSetServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SynonymSetServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SYNONYM_SET:
          serviceImpl.createSynonymSet((com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SynonymSet>) responseObserver);
          break;
        case METHODID_GET_SYNONYM_SET:
          serviceImpl.getSynonymSet((com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SynonymSet>) responseObserver);
          break;
        case METHODID_UPDATE_SYNONYM_SET:
          serviceImpl.updateSynonymSet((com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.SynonymSet>) responseObserver);
          break;
        case METHODID_DELETE_SYNONYM_SET:
          serviceImpl.deleteSynonymSet((com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_SYNONYM_SETS:
          serviceImpl.listSynonymSets((com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse>) responseObserver);
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

  private static abstract class SynonymSetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SynonymSetServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.contentwarehouse.v1.SynonymSetServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SynonymSetService");
    }
  }

  private static final class SynonymSetServiceFileDescriptorSupplier
      extends SynonymSetServiceBaseDescriptorSupplier {
    SynonymSetServiceFileDescriptorSupplier() {}
  }

  private static final class SynonymSetServiceMethodDescriptorSupplier
      extends SynonymSetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SynonymSetServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SynonymSetServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SynonymSetServiceFileDescriptorSupplier())
              .addMethod(getCreateSynonymSetMethod())
              .addMethod(getGetSynonymSetMethod())
              .addMethod(getUpdateSynonymSetMethod())
              .addMethod(getDeleteSynonymSetMethod())
              .addMethod(getListSynonymSetsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
