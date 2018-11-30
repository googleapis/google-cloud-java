package com.google.cloud.dialogflow.v2beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Entities are extracted from user input and represent parameters that are
 * meaningful to your application. For example, a date range, a proper name
 * such as a geographic location or landmark, and so on. Entities represent
 * actionable data for your application.
 * Session entity types are referred to as **User** entity types and are
 * entities that are built for an individual user such as
 * favorites, preferences, playlists, and so on. You can redefine a session
 * entity type at the session level.
 * For more information about entity types, see the
 * [Dialogflow documentation](https://dialogflow.com/docs/entities).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/dialogflow/v2beta1/session_entity_type.proto")
public final class SessionEntityTypesGrpc {

  private SessionEntityTypesGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2beta1.SessionEntityTypes";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListSessionEntityTypesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest,
          com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse>
      METHOD_LIST_SESSION_ENTITY_TYPES = getListSessionEntityTypesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest,
          com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse>
      getListSessionEntityTypesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest,
          com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse>
      getListSessionEntityTypesMethod() {
    return getListSessionEntityTypesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest,
          com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse>
      getListSessionEntityTypesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest,
            com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse>
        getListSessionEntityTypesMethod;
    if ((getListSessionEntityTypesMethod = SessionEntityTypesGrpc.getListSessionEntityTypesMethod)
        == null) {
      synchronized (SessionEntityTypesGrpc.class) {
        if ((getListSessionEntityTypesMethod =
                SessionEntityTypesGrpc.getListSessionEntityTypesMethod)
            == null) {
          SessionEntityTypesGrpc.getListSessionEntityTypesMethod =
              getListSessionEntityTypesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest,
                          com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.SessionEntityTypes",
                              "ListSessionEntityTypes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionEntityTypesMethodDescriptorSupplier("ListSessionEntityTypes"))
                      .build();
        }
      }
    }
    return getListSessionEntityTypesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetSessionEntityTypeMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest,
          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
      METHOD_GET_SESSION_ENTITY_TYPE = getGetSessionEntityTypeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest,
          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
      getGetSessionEntityTypeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest,
          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
      getGetSessionEntityTypeMethod() {
    return getGetSessionEntityTypeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest,
          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
      getGetSessionEntityTypeMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest,
            com.google.cloud.dialogflow.v2beta1.SessionEntityType>
        getGetSessionEntityTypeMethod;
    if ((getGetSessionEntityTypeMethod = SessionEntityTypesGrpc.getGetSessionEntityTypeMethod)
        == null) {
      synchronized (SessionEntityTypesGrpc.class) {
        if ((getGetSessionEntityTypeMethod = SessionEntityTypesGrpc.getGetSessionEntityTypeMethod)
            == null) {
          SessionEntityTypesGrpc.getGetSessionEntityTypeMethod =
              getGetSessionEntityTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest,
                          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.SessionEntityTypes",
                              "GetSessionEntityType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.SessionEntityType
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionEntityTypesMethodDescriptorSupplier("GetSessionEntityType"))
                      .build();
        }
      }
    }
    return getGetSessionEntityTypeMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateSessionEntityTypeMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest,
          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
      METHOD_CREATE_SESSION_ENTITY_TYPE = getCreateSessionEntityTypeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest,
          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
      getCreateSessionEntityTypeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest,
          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
      getCreateSessionEntityTypeMethod() {
    return getCreateSessionEntityTypeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest,
          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
      getCreateSessionEntityTypeMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest,
            com.google.cloud.dialogflow.v2beta1.SessionEntityType>
        getCreateSessionEntityTypeMethod;
    if ((getCreateSessionEntityTypeMethod = SessionEntityTypesGrpc.getCreateSessionEntityTypeMethod)
        == null) {
      synchronized (SessionEntityTypesGrpc.class) {
        if ((getCreateSessionEntityTypeMethod =
                SessionEntityTypesGrpc.getCreateSessionEntityTypeMethod)
            == null) {
          SessionEntityTypesGrpc.getCreateSessionEntityTypeMethod =
              getCreateSessionEntityTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest,
                          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.SessionEntityTypes",
                              "CreateSessionEntityType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.SessionEntityType
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionEntityTypesMethodDescriptorSupplier("CreateSessionEntityType"))
                      .build();
        }
      }
    }
    return getCreateSessionEntityTypeMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateSessionEntityTypeMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest,
          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
      METHOD_UPDATE_SESSION_ENTITY_TYPE = getUpdateSessionEntityTypeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest,
          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
      getUpdateSessionEntityTypeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest,
          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
      getUpdateSessionEntityTypeMethod() {
    return getUpdateSessionEntityTypeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest,
          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
      getUpdateSessionEntityTypeMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest,
            com.google.cloud.dialogflow.v2beta1.SessionEntityType>
        getUpdateSessionEntityTypeMethod;
    if ((getUpdateSessionEntityTypeMethod = SessionEntityTypesGrpc.getUpdateSessionEntityTypeMethod)
        == null) {
      synchronized (SessionEntityTypesGrpc.class) {
        if ((getUpdateSessionEntityTypeMethod =
                SessionEntityTypesGrpc.getUpdateSessionEntityTypeMethod)
            == null) {
          SessionEntityTypesGrpc.getUpdateSessionEntityTypeMethod =
              getUpdateSessionEntityTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest,
                          com.google.cloud.dialogflow.v2beta1.SessionEntityType>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.SessionEntityTypes",
                              "UpdateSessionEntityType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.SessionEntityType
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionEntityTypesMethodDescriptorSupplier("UpdateSessionEntityType"))
                      .build();
        }
      }
    }
    return getUpdateSessionEntityTypeMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteSessionEntityTypeMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest,
          com.google.protobuf.Empty>
      METHOD_DELETE_SESSION_ENTITY_TYPE = getDeleteSessionEntityTypeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest,
          com.google.protobuf.Empty>
      getDeleteSessionEntityTypeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest,
          com.google.protobuf.Empty>
      getDeleteSessionEntityTypeMethod() {
    return getDeleteSessionEntityTypeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest,
          com.google.protobuf.Empty>
      getDeleteSessionEntityTypeMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest,
            com.google.protobuf.Empty>
        getDeleteSessionEntityTypeMethod;
    if ((getDeleteSessionEntityTypeMethod = SessionEntityTypesGrpc.getDeleteSessionEntityTypeMethod)
        == null) {
      synchronized (SessionEntityTypesGrpc.class) {
        if ((getDeleteSessionEntityTypeMethod =
                SessionEntityTypesGrpc.getDeleteSessionEntityTypeMethod)
            == null) {
          SessionEntityTypesGrpc.getDeleteSessionEntityTypeMethod =
              getDeleteSessionEntityTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.SessionEntityTypes",
                              "DeleteSessionEntityType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionEntityTypesMethodDescriptorSupplier("DeleteSessionEntityType"))
                      .build();
        }
      }
    }
    return getDeleteSessionEntityTypeMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SessionEntityTypesStub newStub(io.grpc.Channel channel) {
    return new SessionEntityTypesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SessionEntityTypesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new SessionEntityTypesBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SessionEntityTypesFutureStub newFutureStub(io.grpc.Channel channel) {
    return new SessionEntityTypesFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Entities are extracted from user input and represent parameters that are
   * meaningful to your application. For example, a date range, a proper name
   * such as a geographic location or landmark, and so on. Entities represent
   * actionable data for your application.
   * Session entity types are referred to as **User** entity types and are
   * entities that are built for an individual user such as
   * favorites, preferences, playlists, and so on. You can redefine a session
   * entity type at the session level.
   * For more information about entity types, see the
   * [Dialogflow documentation](https://dialogflow.com/docs/entities).
   * </pre>
   */
  public abstract static class SessionEntityTypesImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all session entity types in the specified session.
     * </pre>
     */
    public void listSessionEntityTypes(
        com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListSessionEntityTypesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified session entity type.
     * </pre>
     */
    public void getSessionEntityType(
        com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SessionEntityType>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetSessionEntityTypeMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a session entity type.
     * </pre>
     */
    public void createSessionEntityType(
        com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SessionEntityType>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSessionEntityTypeMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified session entity type.
     * </pre>
     */
    public void updateSessionEntityType(
        com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SessionEntityType>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateSessionEntityTypeMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified session entity type.
     * </pre>
     */
    public void deleteSessionEntityType(
        com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteSessionEntityTypeMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListSessionEntityTypesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest,
                      com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse>(
                      this, METHODID_LIST_SESSION_ENTITY_TYPES)))
          .addMethod(
              getGetSessionEntityTypeMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest,
                      com.google.cloud.dialogflow.v2beta1.SessionEntityType>(
                      this, METHODID_GET_SESSION_ENTITY_TYPE)))
          .addMethod(
              getCreateSessionEntityTypeMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest,
                      com.google.cloud.dialogflow.v2beta1.SessionEntityType>(
                      this, METHODID_CREATE_SESSION_ENTITY_TYPE)))
          .addMethod(
              getUpdateSessionEntityTypeMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest,
                      com.google.cloud.dialogflow.v2beta1.SessionEntityType>(
                      this, METHODID_UPDATE_SESSION_ENTITY_TYPE)))
          .addMethod(
              getDeleteSessionEntityTypeMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_SESSION_ENTITY_TYPE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Entities are extracted from user input and represent parameters that are
   * meaningful to your application. For example, a date range, a proper name
   * such as a geographic location or landmark, and so on. Entities represent
   * actionable data for your application.
   * Session entity types are referred to as **User** entity types and are
   * entities that are built for an individual user such as
   * favorites, preferences, playlists, and so on. You can redefine a session
   * entity type at the session level.
   * For more information about entity types, see the
   * [Dialogflow documentation](https://dialogflow.com/docs/entities).
   * </pre>
   */
  public static final class SessionEntityTypesStub
      extends io.grpc.stub.AbstractStub<SessionEntityTypesStub> {
    private SessionEntityTypesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SessionEntityTypesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionEntityTypesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionEntityTypesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all session entity types in the specified session.
     * </pre>
     */
    public void listSessionEntityTypes(
        com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListSessionEntityTypesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified session entity type.
     * </pre>
     */
    public void getSessionEntityType(
        com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SessionEntityType>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSessionEntityTypeMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a session entity type.
     * </pre>
     */
    public void createSessionEntityType(
        com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SessionEntityType>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSessionEntityTypeMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified session entity type.
     * </pre>
     */
    public void updateSessionEntityType(
        com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SessionEntityType>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateSessionEntityTypeMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified session entity type.
     * </pre>
     */
    public void deleteSessionEntityType(
        com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteSessionEntityTypeMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Entities are extracted from user input and represent parameters that are
   * meaningful to your application. For example, a date range, a proper name
   * such as a geographic location or landmark, and so on. Entities represent
   * actionable data for your application.
   * Session entity types are referred to as **User** entity types and are
   * entities that are built for an individual user such as
   * favorites, preferences, playlists, and so on. You can redefine a session
   * entity type at the session level.
   * For more information about entity types, see the
   * [Dialogflow documentation](https://dialogflow.com/docs/entities).
   * </pre>
   */
  public static final class SessionEntityTypesBlockingStub
      extends io.grpc.stub.AbstractStub<SessionEntityTypesBlockingStub> {
    private SessionEntityTypesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     *
     *
     * <pre>
     * Returns the list of all session entity types in the specified session.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse
        listSessionEntityTypes(
            com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListSessionEntityTypesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified session entity type.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.SessionEntityType getSessionEntityType(
        com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSessionEntityTypeMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a session entity type.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.SessionEntityType createSessionEntityType(
        com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateSessionEntityTypeMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified session entity type.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.SessionEntityType updateSessionEntityType(
        com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateSessionEntityTypeMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified session entity type.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSessionEntityType(
        com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteSessionEntityTypeMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Entities are extracted from user input and represent parameters that are
   * meaningful to your application. For example, a date range, a proper name
   * such as a geographic location or landmark, and so on. Entities represent
   * actionable data for your application.
   * Session entity types are referred to as **User** entity types and are
   * entities that are built for an individual user such as
   * favorites, preferences, playlists, and so on. You can redefine a session
   * entity type at the session level.
   * For more information about entity types, see the
   * [Dialogflow documentation](https://dialogflow.com/docs/entities).
   * </pre>
   */
  public static final class SessionEntityTypesFutureStub
      extends io.grpc.stub.AbstractStub<SessionEntityTypesFutureStub> {
    private SessionEntityTypesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SessionEntityTypesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionEntityTypesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionEntityTypesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all session entity types in the specified session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse>
        listSessionEntityTypes(
            com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListSessionEntityTypesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified session entity type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.SessionEntityType>
        getSessionEntityType(
            com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSessionEntityTypeMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a session entity type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.SessionEntityType>
        createSessionEntityType(
            com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSessionEntityTypeMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified session entity type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.SessionEntityType>
        updateSessionEntityType(
            com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateSessionEntityTypeMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified session entity type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSessionEntityType(
            com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteSessionEntityTypeMethodHelper(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_LIST_SESSION_ENTITY_TYPES = 0;
  private static final int METHODID_GET_SESSION_ENTITY_TYPE = 1;
  private static final int METHODID_CREATE_SESSION_ENTITY_TYPE = 2;
  private static final int METHODID_UPDATE_SESSION_ENTITY_TYPE = 3;
  private static final int METHODID_DELETE_SESSION_ENTITY_TYPE = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.listSessionEntityTypes(
              (com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2beta1.ListSessionEntityTypesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SESSION_ENTITY_TYPE:
          serviceImpl.getSessionEntityType(
              (com.google.cloud.dialogflow.v2beta1.GetSessionEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SessionEntityType>)
                  responseObserver);
          break;
        case METHODID_CREATE_SESSION_ENTITY_TYPE:
          serviceImpl.createSessionEntityType(
              (com.google.cloud.dialogflow.v2beta1.CreateSessionEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SessionEntityType>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SESSION_ENTITY_TYPE:
          serviceImpl.updateSessionEntityType(
              (com.google.cloud.dialogflow.v2beta1.UpdateSessionEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SessionEntityType>)
                  responseObserver);
          break;
        case METHODID_DELETE_SESSION_ENTITY_TYPE:
          serviceImpl.deleteSessionEntityType(
              (com.google.cloud.dialogflow.v2beta1.DeleteSessionEntityTypeRequest) request,
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

  private abstract static class SessionEntityTypesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SessionEntityTypesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2beta1.SessionEntityTypeProto.getDescriptor();
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SessionEntityTypesFileDescriptorSupplier())
                      .addMethod(getListSessionEntityTypesMethodHelper())
                      .addMethod(getGetSessionEntityTypeMethodHelper())
                      .addMethod(getCreateSessionEntityTypeMethodHelper())
                      .addMethod(getUpdateSessionEntityTypeMethodHelper())
                      .addMethod(getDeleteSessionEntityTypeMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
