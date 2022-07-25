package com.google.cloud.dialogflow.cx.v3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for managing [SessionEntityTypes][google.cloud.dialogflow.cx.v3beta1.SessionEntityType].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3beta1/session_entity_type.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SessionEntityTypesGrpc {

  private SessionEntityTypesGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3beta1.SessionEntityTypes";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesRequest,
      com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesResponse> getListSessionEntityTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSessionEntityTypes",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesRequest,
      com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesResponse> getListSessionEntityTypesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesRequest, com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesResponse> getListSessionEntityTypesMethod;
    if ((getListSessionEntityTypesMethod = SessionEntityTypesGrpc.getListSessionEntityTypesMethod) == null) {
      synchronized (SessionEntityTypesGrpc.class) {
        if ((getListSessionEntityTypesMethod = SessionEntityTypesGrpc.getListSessionEntityTypesMethod) == null) {
          SessionEntityTypesGrpc.getListSessionEntityTypesMethod = getListSessionEntityTypesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesRequest, com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSessionEntityTypes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SessionEntityTypesMethodDescriptorSupplier("ListSessionEntityTypes"))
              .build();
        }
      }
    }
    return getListSessionEntityTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.GetSessionEntityTypeRequest,
      com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> getGetSessionEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSessionEntityType",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetSessionEntityTypeRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.GetSessionEntityTypeRequest,
      com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> getGetSessionEntityTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.GetSessionEntityTypeRequest, com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> getGetSessionEntityTypeMethod;
    if ((getGetSessionEntityTypeMethod = SessionEntityTypesGrpc.getGetSessionEntityTypeMethod) == null) {
      synchronized (SessionEntityTypesGrpc.class) {
        if ((getGetSessionEntityTypeMethod = SessionEntityTypesGrpc.getGetSessionEntityTypeMethod) == null) {
          SessionEntityTypesGrpc.getGetSessionEntityTypeMethod = getGetSessionEntityTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.GetSessionEntityTypeRequest, com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSessionEntityType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.GetSessionEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType.getDefaultInstance()))
              .setSchemaDescriptor(new SessionEntityTypesMethodDescriptorSupplier("GetSessionEntityType"))
              .build();
        }
      }
    }
    return getGetSessionEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.CreateSessionEntityTypeRequest,
      com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> getCreateSessionEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSessionEntityType",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.CreateSessionEntityTypeRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.CreateSessionEntityTypeRequest,
      com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> getCreateSessionEntityTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.CreateSessionEntityTypeRequest, com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> getCreateSessionEntityTypeMethod;
    if ((getCreateSessionEntityTypeMethod = SessionEntityTypesGrpc.getCreateSessionEntityTypeMethod) == null) {
      synchronized (SessionEntityTypesGrpc.class) {
        if ((getCreateSessionEntityTypeMethod = SessionEntityTypesGrpc.getCreateSessionEntityTypeMethod) == null) {
          SessionEntityTypesGrpc.getCreateSessionEntityTypeMethod = getCreateSessionEntityTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.CreateSessionEntityTypeRequest, com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSessionEntityType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.CreateSessionEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType.getDefaultInstance()))
              .setSchemaDescriptor(new SessionEntityTypesMethodDescriptorSupplier("CreateSessionEntityType"))
              .build();
        }
      }
    }
    return getCreateSessionEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.UpdateSessionEntityTypeRequest,
      com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> getUpdateSessionEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSessionEntityType",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.UpdateSessionEntityTypeRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.UpdateSessionEntityTypeRequest,
      com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> getUpdateSessionEntityTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.UpdateSessionEntityTypeRequest, com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> getUpdateSessionEntityTypeMethod;
    if ((getUpdateSessionEntityTypeMethod = SessionEntityTypesGrpc.getUpdateSessionEntityTypeMethod) == null) {
      synchronized (SessionEntityTypesGrpc.class) {
        if ((getUpdateSessionEntityTypeMethod = SessionEntityTypesGrpc.getUpdateSessionEntityTypeMethod) == null) {
          SessionEntityTypesGrpc.getUpdateSessionEntityTypeMethod = getUpdateSessionEntityTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.UpdateSessionEntityTypeRequest, com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSessionEntityType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.UpdateSessionEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType.getDefaultInstance()))
              .setSchemaDescriptor(new SessionEntityTypesMethodDescriptorSupplier("UpdateSessionEntityType"))
              .build();
        }
      }
    }
    return getUpdateSessionEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.DeleteSessionEntityTypeRequest,
      com.google.protobuf.Empty> getDeleteSessionEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSessionEntityType",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.DeleteSessionEntityTypeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.DeleteSessionEntityTypeRequest,
      com.google.protobuf.Empty> getDeleteSessionEntityTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.DeleteSessionEntityTypeRequest, com.google.protobuf.Empty> getDeleteSessionEntityTypeMethod;
    if ((getDeleteSessionEntityTypeMethod = SessionEntityTypesGrpc.getDeleteSessionEntityTypeMethod) == null) {
      synchronized (SessionEntityTypesGrpc.class) {
        if ((getDeleteSessionEntityTypeMethod = SessionEntityTypesGrpc.getDeleteSessionEntityTypeMethod) == null) {
          SessionEntityTypesGrpc.getDeleteSessionEntityTypeMethod = getDeleteSessionEntityTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.DeleteSessionEntityTypeRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSessionEntityType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.DeleteSessionEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new SessionEntityTypesMethodDescriptorSupplier("DeleteSessionEntityType"))
              .build();
        }
      }
    }
    return getDeleteSessionEntityTypeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SessionEntityTypesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionEntityTypesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SessionEntityTypesStub>() {
        @java.lang.Override
        public SessionEntityTypesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SessionEntityTypesStub(channel, callOptions);
        }
      };
    return SessionEntityTypesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SessionEntityTypesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionEntityTypesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SessionEntityTypesBlockingStub>() {
        @java.lang.Override
        public SessionEntityTypesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SessionEntityTypesBlockingStub(channel, callOptions);
        }
      };
    return SessionEntityTypesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SessionEntityTypesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionEntityTypesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SessionEntityTypesFutureStub>() {
        @java.lang.Override
        public SessionEntityTypesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SessionEntityTypesFutureStub(channel, callOptions);
        }
      };
    return SessionEntityTypesFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for managing [SessionEntityTypes][google.cloud.dialogflow.cx.v3beta1.SessionEntityType].
   * </pre>
   */
  public static abstract class SessionEntityTypesImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns the list of all session entity types in the specified session.
     * </pre>
     */
    public void listSessionEntityTypes(com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSessionEntityTypesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified session entity type.
     * </pre>
     */
    public void getSessionEntityType(com.google.cloud.dialogflow.cx.v3beta1.GetSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSessionEntityTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a session entity type.
     * </pre>
     */
    public void createSessionEntityType(com.google.cloud.dialogflow.cx.v3beta1.CreateSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSessionEntityTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified session entity type.
     * </pre>
     */
    public void updateSessionEntityType(com.google.cloud.dialogflow.cx.v3beta1.UpdateSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateSessionEntityTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified session entity type.
     * </pre>
     */
    public void deleteSessionEntityType(com.google.cloud.dialogflow.cx.v3beta1.DeleteSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSessionEntityTypeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListSessionEntityTypesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesRequest,
                com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesResponse>(
                  this, METHODID_LIST_SESSION_ENTITY_TYPES)))
          .addMethod(
            getGetSessionEntityTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.GetSessionEntityTypeRequest,
                com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType>(
                  this, METHODID_GET_SESSION_ENTITY_TYPE)))
          .addMethod(
            getCreateSessionEntityTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.CreateSessionEntityTypeRequest,
                com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType>(
                  this, METHODID_CREATE_SESSION_ENTITY_TYPE)))
          .addMethod(
            getUpdateSessionEntityTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.UpdateSessionEntityTypeRequest,
                com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType>(
                  this, METHODID_UPDATE_SESSION_ENTITY_TYPE)))
          .addMethod(
            getDeleteSessionEntityTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.DeleteSessionEntityTypeRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_SESSION_ENTITY_TYPE)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for managing [SessionEntityTypes][google.cloud.dialogflow.cx.v3beta1.SessionEntityType].
   * </pre>
   */
  public static final class SessionEntityTypesStub extends io.grpc.stub.AbstractAsyncStub<SessionEntityTypesStub> {
    private SessionEntityTypesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionEntityTypesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionEntityTypesStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all session entity types in the specified session.
     * </pre>
     */
    public void listSessionEntityTypes(com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSessionEntityTypesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified session entity type.
     * </pre>
     */
    public void getSessionEntityType(com.google.cloud.dialogflow.cx.v3beta1.GetSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSessionEntityTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a session entity type.
     * </pre>
     */
    public void createSessionEntityType(com.google.cloud.dialogflow.cx.v3beta1.CreateSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSessionEntityTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified session entity type.
     * </pre>
     */
    public void updateSessionEntityType(com.google.cloud.dialogflow.cx.v3beta1.UpdateSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSessionEntityTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified session entity type.
     * </pre>
     */
    public void deleteSessionEntityType(com.google.cloud.dialogflow.cx.v3beta1.DeleteSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSessionEntityTypeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service for managing [SessionEntityTypes][google.cloud.dialogflow.cx.v3beta1.SessionEntityType].
   * </pre>
   */
  public static final class SessionEntityTypesBlockingStub extends io.grpc.stub.AbstractBlockingStub<SessionEntityTypesBlockingStub> {
    private SessionEntityTypesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionEntityTypesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionEntityTypesBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all session entity types in the specified session.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesResponse listSessionEntityTypes(com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSessionEntityTypesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the specified session entity type.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType getSessionEntityType(com.google.cloud.dialogflow.cx.v3beta1.GetSessionEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSessionEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a session entity type.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType createSessionEntityType(com.google.cloud.dialogflow.cx.v3beta1.CreateSessionEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSessionEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified session entity type.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType updateSessionEntityType(com.google.cloud.dialogflow.cx.v3beta1.UpdateSessionEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSessionEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified session entity type.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSessionEntityType(com.google.cloud.dialogflow.cx.v3beta1.DeleteSessionEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSessionEntityTypeMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service for managing [SessionEntityTypes][google.cloud.dialogflow.cx.v3beta1.SessionEntityType].
   * </pre>
   */
  public static final class SessionEntityTypesFutureStub extends io.grpc.stub.AbstractFutureStub<SessionEntityTypesFutureStub> {
    private SessionEntityTypesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionEntityTypesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionEntityTypesFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all session entity types in the specified session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesResponse> listSessionEntityTypes(
        com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSessionEntityTypesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves the specified session entity type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> getSessionEntityType(
        com.google.cloud.dialogflow.cx.v3beta1.GetSessionEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSessionEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a session entity type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> createSessionEntityType(
        com.google.cloud.dialogflow.cx.v3beta1.CreateSessionEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSessionEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified session entity type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType> updateSessionEntityType(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateSessionEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSessionEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified session entity type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteSessionEntityType(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteSessionEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSessionEntityTypeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SESSION_ENTITY_TYPES = 0;
  private static final int METHODID_GET_SESSION_ENTITY_TYPE = 1;
  private static final int METHODID_CREATE_SESSION_ENTITY_TYPE = 2;
  private static final int METHODID_UPDATE_SESSION_ENTITY_TYPE = 3;
  private static final int METHODID_DELETE_SESSION_ENTITY_TYPE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SessionEntityTypesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SessionEntityTypesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_SESSION_ENTITY_TYPES:
          serviceImpl.listSessionEntityTypes((com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListSessionEntityTypesResponse>) responseObserver);
          break;
        case METHODID_GET_SESSION_ENTITY_TYPE:
          serviceImpl.getSessionEntityType((com.google.cloud.dialogflow.cx.v3beta1.GetSessionEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType>) responseObserver);
          break;
        case METHODID_CREATE_SESSION_ENTITY_TYPE:
          serviceImpl.createSessionEntityType((com.google.cloud.dialogflow.cx.v3beta1.CreateSessionEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType>) responseObserver);
          break;
        case METHODID_UPDATE_SESSION_ENTITY_TYPE:
          serviceImpl.updateSessionEntityType((com.google.cloud.dialogflow.cx.v3beta1.UpdateSessionEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SessionEntityType>) responseObserver);
          break;
        case METHODID_DELETE_SESSION_ENTITY_TYPE:
          serviceImpl.deleteSessionEntityType((com.google.cloud.dialogflow.cx.v3beta1.DeleteSessionEntityTypeRequest) request,
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

  private static abstract class SessionEntityTypesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SessionEntityTypesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3beta1.SessionEntityTypeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SessionEntityTypes");
    }
  }

  private static final class SessionEntityTypesFileDescriptorSupplier
      extends SessionEntityTypesBaseDescriptorSupplier {
    SessionEntityTypesFileDescriptorSupplier() {}
  }

  private static final class SessionEntityTypesMethodDescriptorSupplier
      extends SessionEntityTypesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SessionEntityTypesMethodDescriptorSupplier(String methodName) {
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
      synchronized (SessionEntityTypesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SessionEntityTypesFileDescriptorSupplier())
              .addMethod(getListSessionEntityTypesMethod())
              .addMethod(getGetSessionEntityTypeMethod())
              .addMethod(getCreateSessionEntityTypeMethod())
              .addMethod(getUpdateSessionEntityTypeMethod())
              .addMethod(getDeleteSessionEntityTypeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
