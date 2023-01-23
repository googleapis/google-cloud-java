package com.google.cloud.dialogflow.cx.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for managing [EntityTypes][google.cloud.dialogflow.cx.v3.EntityType].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3/entity_type.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EntityTypesGrpc {

  private EntityTypesGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3.EntityTypes";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest,
      com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse> getListEntityTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntityTypes",
      requestType = com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest,
      com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse> getListEntityTypesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest, com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse> getListEntityTypesMethod;
    if ((getListEntityTypesMethod = EntityTypesGrpc.getListEntityTypesMethod) == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getListEntityTypesMethod = EntityTypesGrpc.getListEntityTypesMethod) == null) {
          EntityTypesGrpc.getListEntityTypesMethod = getListEntityTypesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest, com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEntityTypes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EntityTypesMethodDescriptorSupplier("ListEntityTypes"))
              .build();
        }
      }
    }
    return getListEntityTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest,
      com.google.cloud.dialogflow.cx.v3.EntityType> getGetEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEntityType",
      requestType = com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.EntityType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest,
      com.google.cloud.dialogflow.cx.v3.EntityType> getGetEntityTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest, com.google.cloud.dialogflow.cx.v3.EntityType> getGetEntityTypeMethod;
    if ((getGetEntityTypeMethod = EntityTypesGrpc.getGetEntityTypeMethod) == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getGetEntityTypeMethod = EntityTypesGrpc.getGetEntityTypeMethod) == null) {
          EntityTypesGrpc.getGetEntityTypeMethod = getGetEntityTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest, com.google.cloud.dialogflow.cx.v3.EntityType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEntityType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.EntityType.getDefaultInstance()))
              .setSchemaDescriptor(new EntityTypesMethodDescriptorSupplier("GetEntityType"))
              .build();
        }
      }
    }
    return getGetEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest,
      com.google.cloud.dialogflow.cx.v3.EntityType> getCreateEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEntityType",
      requestType = com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.EntityType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest,
      com.google.cloud.dialogflow.cx.v3.EntityType> getCreateEntityTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest, com.google.cloud.dialogflow.cx.v3.EntityType> getCreateEntityTypeMethod;
    if ((getCreateEntityTypeMethod = EntityTypesGrpc.getCreateEntityTypeMethod) == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getCreateEntityTypeMethod = EntityTypesGrpc.getCreateEntityTypeMethod) == null) {
          EntityTypesGrpc.getCreateEntityTypeMethod = getCreateEntityTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest, com.google.cloud.dialogflow.cx.v3.EntityType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEntityType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.EntityType.getDefaultInstance()))
              .setSchemaDescriptor(new EntityTypesMethodDescriptorSupplier("CreateEntityType"))
              .build();
        }
      }
    }
    return getCreateEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest,
      com.google.cloud.dialogflow.cx.v3.EntityType> getUpdateEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEntityType",
      requestType = com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.EntityType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest,
      com.google.cloud.dialogflow.cx.v3.EntityType> getUpdateEntityTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest, com.google.cloud.dialogflow.cx.v3.EntityType> getUpdateEntityTypeMethod;
    if ((getUpdateEntityTypeMethod = EntityTypesGrpc.getUpdateEntityTypeMethod) == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getUpdateEntityTypeMethod = EntityTypesGrpc.getUpdateEntityTypeMethod) == null) {
          EntityTypesGrpc.getUpdateEntityTypeMethod = getUpdateEntityTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest, com.google.cloud.dialogflow.cx.v3.EntityType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEntityType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.EntityType.getDefaultInstance()))
              .setSchemaDescriptor(new EntityTypesMethodDescriptorSupplier("UpdateEntityType"))
              .build();
        }
      }
    }
    return getUpdateEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest,
      com.google.protobuf.Empty> getDeleteEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEntityType",
      requestType = com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest,
      com.google.protobuf.Empty> getDeleteEntityTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest, com.google.protobuf.Empty> getDeleteEntityTypeMethod;
    if ((getDeleteEntityTypeMethod = EntityTypesGrpc.getDeleteEntityTypeMethod) == null) {
      synchronized (EntityTypesGrpc.class) {
        if ((getDeleteEntityTypeMethod = EntityTypesGrpc.getDeleteEntityTypeMethod) == null) {
          EntityTypesGrpc.getDeleteEntityTypeMethod = getDeleteEntityTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEntityType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new EntityTypesMethodDescriptorSupplier("DeleteEntityType"))
              .build();
        }
      }
    }
    return getDeleteEntityTypeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EntityTypesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EntityTypesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EntityTypesStub>() {
        @java.lang.Override
        public EntityTypesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EntityTypesStub(channel, callOptions);
        }
      };
    return EntityTypesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EntityTypesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EntityTypesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EntityTypesBlockingStub>() {
        @java.lang.Override
        public EntityTypesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EntityTypesBlockingStub(channel, callOptions);
        }
      };
    return EntityTypesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EntityTypesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EntityTypesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EntityTypesFutureStub>() {
        @java.lang.Override
        public EntityTypesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EntityTypesFutureStub(channel, callOptions);
        }
      };
    return EntityTypesFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for managing [EntityTypes][google.cloud.dialogflow.cx.v3.EntityType].
   * </pre>
   */
  public static abstract class EntityTypesImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns the list of all entity types in the specified agent.
     * </pre>
     */
    public void listEntityTypes(com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEntityTypesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified entity type.
     * </pre>
     */
    public void getEntityType(com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.EntityType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEntityTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an entity type in the specified agent.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void createEntityType(com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.EntityType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateEntityTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified entity type.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void updateEntityType(com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.EntityType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateEntityTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified entity type.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void deleteEntityType(com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteEntityTypeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListEntityTypesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest,
                com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse>(
                  this, METHODID_LIST_ENTITY_TYPES)))
          .addMethod(
            getGetEntityTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest,
                com.google.cloud.dialogflow.cx.v3.EntityType>(
                  this, METHODID_GET_ENTITY_TYPE)))
          .addMethod(
            getCreateEntityTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest,
                com.google.cloud.dialogflow.cx.v3.EntityType>(
                  this, METHODID_CREATE_ENTITY_TYPE)))
          .addMethod(
            getUpdateEntityTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest,
                com.google.cloud.dialogflow.cx.v3.EntityType>(
                  this, METHODID_UPDATE_ENTITY_TYPE)))
          .addMethod(
            getDeleteEntityTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_ENTITY_TYPE)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for managing [EntityTypes][google.cloud.dialogflow.cx.v3.EntityType].
   * </pre>
   */
  public static final class EntityTypesStub extends io.grpc.stub.AbstractAsyncStub<EntityTypesStub> {
    private EntityTypesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityTypesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EntityTypesStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all entity types in the specified agent.
     * </pre>
     */
    public void listEntityTypes(com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEntityTypesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified entity type.
     * </pre>
     */
    public void getEntityType(com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.EntityType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEntityTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an entity type in the specified agent.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void createEntityType(com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.EntityType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEntityTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified entity type.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void updateEntityType(com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.EntityType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEntityTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified entity type.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public void deleteEntityType(com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEntityTypeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service for managing [EntityTypes][google.cloud.dialogflow.cx.v3.EntityType].
   * </pre>
   */
  public static final class EntityTypesBlockingStub extends io.grpc.stub.AbstractBlockingStub<EntityTypesBlockingStub> {
    private EntityTypesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityTypesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EntityTypesBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all entity types in the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse listEntityTypes(com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntityTypesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the specified entity type.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.EntityType getEntityType(com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an entity type in the specified agent.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.EntityType createEntityType(com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified entity type.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.EntityType updateEntityType(com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified entity type.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.protobuf.Empty deleteEntityType(com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEntityTypeMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service for managing [EntityTypes][google.cloud.dialogflow.cx.v3.EntityType].
   * </pre>
   */
  public static final class EntityTypesFutureStub extends io.grpc.stub.AbstractFutureStub<EntityTypesFutureStub> {
    private EntityTypesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityTypesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EntityTypesFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all entity types in the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse> listEntityTypes(
        com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEntityTypesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves the specified entity type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3.EntityType> getEntityType(
        com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an entity type in the specified agent.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3.EntityType> createEntityType(
        com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified entity type.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3.EntityType> updateEntityType(
        com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified entity type.
     * Note: You should always train a flow prior to sending it queries. See the
     * [training
     * documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteEntityType(
        com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEntityTypeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ENTITY_TYPES = 0;
  private static final int METHODID_GET_ENTITY_TYPE = 1;
  private static final int METHODID_CREATE_ENTITY_TYPE = 2;
  private static final int METHODID_UPDATE_ENTITY_TYPE = 3;
  private static final int METHODID_DELETE_ENTITY_TYPE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EntityTypesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EntityTypesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ENTITY_TYPES:
          serviceImpl.listEntityTypes((com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse>) responseObserver);
          break;
        case METHODID_GET_ENTITY_TYPE:
          serviceImpl.getEntityType((com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.EntityType>) responseObserver);
          break;
        case METHODID_CREATE_ENTITY_TYPE:
          serviceImpl.createEntityType((com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.EntityType>) responseObserver);
          break;
        case METHODID_UPDATE_ENTITY_TYPE:
          serviceImpl.updateEntityType((com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.EntityType>) responseObserver);
          break;
        case METHODID_DELETE_ENTITY_TYPE:
          serviceImpl.deleteEntityType((com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest) request,
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

  private static abstract class EntityTypesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EntityTypesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3.EntityTypeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EntityTypes");
    }
  }

  private static final class EntityTypesFileDescriptorSupplier
      extends EntityTypesBaseDescriptorSupplier {
    EntityTypesFileDescriptorSupplier() {}
  }

  private static final class EntityTypesMethodDescriptorSupplier
      extends EntityTypesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EntityTypesMethodDescriptorSupplier(String methodName) {
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
      synchronized (EntityTypesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EntityTypesFileDescriptorSupplier())
              .addMethod(getListEntityTypesMethod())
              .addMethod(getGetEntityTypeMethod())
              .addMethod(getCreateEntityTypeMethod())
              .addMethod(getUpdateEntityTypeMethod())
              .addMethod(getDeleteEntityTypeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
