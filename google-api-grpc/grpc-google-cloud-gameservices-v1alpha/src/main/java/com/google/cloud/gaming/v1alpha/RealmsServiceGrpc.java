package com.google.cloud.gaming.v1alpha;

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
 * Realm provides grouping of game server clusters that are serving particular
 * gamer population.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/gaming/v1alpha/realms.proto")
public final class RealmsServiceGrpc {

  private RealmsServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gaming.v1alpha.RealmsService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListRealmsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListRealmsRequest,
          com.google.cloud.gaming.v1alpha.ListRealmsResponse>
      METHOD_LIST_REALMS = getListRealmsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListRealmsRequest,
          com.google.cloud.gaming.v1alpha.ListRealmsResponse>
      getListRealmsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListRealmsRequest,
          com.google.cloud.gaming.v1alpha.ListRealmsResponse>
      getListRealmsMethod() {
    return getListRealmsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListRealmsRequest,
          com.google.cloud.gaming.v1alpha.ListRealmsResponse>
      getListRealmsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.ListRealmsRequest,
            com.google.cloud.gaming.v1alpha.ListRealmsResponse>
        getListRealmsMethod;
    if ((getListRealmsMethod = RealmsServiceGrpc.getListRealmsMethod) == null) {
      synchronized (RealmsServiceGrpc.class) {
        if ((getListRealmsMethod = RealmsServiceGrpc.getListRealmsMethod) == null) {
          RealmsServiceGrpc.getListRealmsMethod =
              getListRealmsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.ListRealmsRequest,
                          com.google.cloud.gaming.v1alpha.ListRealmsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.RealmsService", "ListRealms"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.ListRealmsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.ListRealmsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new RealmsServiceMethodDescriptorSupplier("ListRealms"))
                      .build();
        }
      }
    }
    return getListRealmsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetRealmMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetRealmRequest, com.google.cloud.gaming.v1alpha.Realm>
      METHOD_GET_REALM = getGetRealmMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetRealmRequest, com.google.cloud.gaming.v1alpha.Realm>
      getGetRealmMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetRealmRequest, com.google.cloud.gaming.v1alpha.Realm>
      getGetRealmMethod() {
    return getGetRealmMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetRealmRequest, com.google.cloud.gaming.v1alpha.Realm>
      getGetRealmMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.GetRealmRequest, com.google.cloud.gaming.v1alpha.Realm>
        getGetRealmMethod;
    if ((getGetRealmMethod = RealmsServiceGrpc.getGetRealmMethod) == null) {
      synchronized (RealmsServiceGrpc.class) {
        if ((getGetRealmMethod = RealmsServiceGrpc.getGetRealmMethod) == null) {
          RealmsServiceGrpc.getGetRealmMethod =
              getGetRealmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.GetRealmRequest,
                          com.google.cloud.gaming.v1alpha.Realm>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.RealmsService", "GetRealm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.GetRealmRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.Realm.getDefaultInstance()))
                      .setSchemaDescriptor(new RealmsServiceMethodDescriptorSupplier("GetRealm"))
                      .build();
        }
      }
    }
    return getGetRealmMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateRealmMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateRealmRequest, com.google.longrunning.Operation>
      METHOD_CREATE_REALM = getCreateRealmMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateRealmRequest, com.google.longrunning.Operation>
      getCreateRealmMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateRealmRequest, com.google.longrunning.Operation>
      getCreateRealmMethod() {
    return getCreateRealmMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateRealmRequest, com.google.longrunning.Operation>
      getCreateRealmMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.CreateRealmRequest, com.google.longrunning.Operation>
        getCreateRealmMethod;
    if ((getCreateRealmMethod = RealmsServiceGrpc.getCreateRealmMethod) == null) {
      synchronized (RealmsServiceGrpc.class) {
        if ((getCreateRealmMethod = RealmsServiceGrpc.getCreateRealmMethod) == null) {
          RealmsServiceGrpc.getCreateRealmMethod =
              getCreateRealmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.CreateRealmRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.RealmsService", "CreateRealm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.CreateRealmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new RealmsServiceMethodDescriptorSupplier("CreateRealm"))
                      .build();
        }
      }
    }
    return getCreateRealmMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteRealmMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteRealmRequest, com.google.longrunning.Operation>
      METHOD_DELETE_REALM = getDeleteRealmMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteRealmRequest, com.google.longrunning.Operation>
      getDeleteRealmMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteRealmRequest, com.google.longrunning.Operation>
      getDeleteRealmMethod() {
    return getDeleteRealmMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteRealmRequest, com.google.longrunning.Operation>
      getDeleteRealmMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.DeleteRealmRequest, com.google.longrunning.Operation>
        getDeleteRealmMethod;
    if ((getDeleteRealmMethod = RealmsServiceGrpc.getDeleteRealmMethod) == null) {
      synchronized (RealmsServiceGrpc.class) {
        if ((getDeleteRealmMethod = RealmsServiceGrpc.getDeleteRealmMethod) == null) {
          RealmsServiceGrpc.getDeleteRealmMethod =
              getDeleteRealmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.DeleteRealmRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.RealmsService", "DeleteRealm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.DeleteRealmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new RealmsServiceMethodDescriptorSupplier("DeleteRealm"))
                      .build();
        }
      }
    }
    return getDeleteRealmMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateRealmMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateRealmRequest, com.google.longrunning.Operation>
      METHOD_UPDATE_REALM = getUpdateRealmMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateRealmRequest, com.google.longrunning.Operation>
      getUpdateRealmMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateRealmRequest, com.google.longrunning.Operation>
      getUpdateRealmMethod() {
    return getUpdateRealmMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateRealmRequest, com.google.longrunning.Operation>
      getUpdateRealmMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.UpdateRealmRequest, com.google.longrunning.Operation>
        getUpdateRealmMethod;
    if ((getUpdateRealmMethod = RealmsServiceGrpc.getUpdateRealmMethod) == null) {
      synchronized (RealmsServiceGrpc.class) {
        if ((getUpdateRealmMethod = RealmsServiceGrpc.getUpdateRealmMethod) == null) {
          RealmsServiceGrpc.getUpdateRealmMethod =
              getUpdateRealmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.UpdateRealmRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.RealmsService", "UpdateRealm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.UpdateRealmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new RealmsServiceMethodDescriptorSupplier("UpdateRealm"))
                      .build();
        }
      }
    }
    return getUpdateRealmMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RealmsServiceStub newStub(io.grpc.Channel channel) {
    return new RealmsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RealmsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new RealmsServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RealmsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new RealmsServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Realm provides grouping of game server clusters that are serving particular
   * gamer population.
   * </pre>
   */
  public abstract static class RealmsServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists realms in a given project and location.
     * </pre>
     */
    public void listRealms(
        com.google.cloud.gaming.v1alpha.ListRealmsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ListRealmsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListRealmsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single realm.
     * </pre>
     */
    public void getRealm(
        com.google.cloud.gaming.v1alpha.GetRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.Realm> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealmMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Realm in a given project and location.
     * </pre>
     */
    public void createRealm(
        com.google.cloud.gaming.v1alpha.CreateRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateRealmMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single realm.
     * </pre>
     */
    public void deleteRealm(
        com.google.cloud.gaming.v1alpha.DeleteRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteRealmMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Patches a single Realm.
     * </pre>
     */
    public void updateRealm(
        com.google.cloud.gaming.v1alpha.UpdateRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateRealmMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListRealmsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.ListRealmsRequest,
                      com.google.cloud.gaming.v1alpha.ListRealmsResponse>(
                      this, METHODID_LIST_REALMS)))
          .addMethod(
              getGetRealmMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.GetRealmRequest,
                      com.google.cloud.gaming.v1alpha.Realm>(this, METHODID_GET_REALM)))
          .addMethod(
              getCreateRealmMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.CreateRealmRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_REALM)))
          .addMethod(
              getDeleteRealmMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.DeleteRealmRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_REALM)))
          .addMethod(
              getUpdateRealmMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.UpdateRealmRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_REALM)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Realm provides grouping of game server clusters that are serving particular
   * gamer population.
   * </pre>
   */
  public static final class RealmsServiceStub extends io.grpc.stub.AbstractStub<RealmsServiceStub> {
    private RealmsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RealmsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RealmsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RealmsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists realms in a given project and location.
     * </pre>
     */
    public void listRealms(
        com.google.cloud.gaming.v1alpha.ListRealmsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ListRealmsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListRealmsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single realm.
     * </pre>
     */
    public void getRealm(
        com.google.cloud.gaming.v1alpha.GetRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.Realm> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealmMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Realm in a given project and location.
     * </pre>
     */
    public void createRealm(
        com.google.cloud.gaming.v1alpha.CreateRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateRealmMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single realm.
     * </pre>
     */
    public void deleteRealm(
        com.google.cloud.gaming.v1alpha.DeleteRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteRealmMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Patches a single Realm.
     * </pre>
     */
    public void updateRealm(
        com.google.cloud.gaming.v1alpha.UpdateRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateRealmMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Realm provides grouping of game server clusters that are serving particular
   * gamer population.
   * </pre>
   */
  public static final class RealmsServiceBlockingStub
      extends io.grpc.stub.AbstractStub<RealmsServiceBlockingStub> {
    private RealmsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RealmsServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RealmsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RealmsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists realms in a given project and location.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.ListRealmsResponse listRealms(
        com.google.cloud.gaming.v1alpha.ListRealmsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListRealmsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single realm.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.Realm getRealm(
        com.google.cloud.gaming.v1alpha.GetRealmRequest request) {
      return blockingUnaryCall(getChannel(), getGetRealmMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Realm in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createRealm(
        com.google.cloud.gaming.v1alpha.CreateRealmRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateRealmMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single realm.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRealm(
        com.google.cloud.gaming.v1alpha.DeleteRealmRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteRealmMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Patches a single Realm.
     * </pre>
     */
    public com.google.longrunning.Operation updateRealm(
        com.google.cloud.gaming.v1alpha.UpdateRealmRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateRealmMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Realm provides grouping of game server clusters that are serving particular
   * gamer population.
   * </pre>
   */
  public static final class RealmsServiceFutureStub
      extends io.grpc.stub.AbstractStub<RealmsServiceFutureStub> {
    private RealmsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RealmsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RealmsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RealmsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists realms in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.ListRealmsResponse>
        listRealms(com.google.cloud.gaming.v1alpha.ListRealmsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListRealmsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single realm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gaming.v1alpha.Realm>
        getRealm(com.google.cloud.gaming.v1alpha.GetRealmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealmMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Realm in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRealm(com.google.cloud.gaming.v1alpha.CreateRealmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateRealmMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single realm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRealm(com.google.cloud.gaming.v1alpha.DeleteRealmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteRealmMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Patches a single Realm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateRealm(com.google.cloud.gaming.v1alpha.UpdateRealmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateRealmMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_REALMS = 0;
  private static final int METHODID_GET_REALM = 1;
  private static final int METHODID_CREATE_REALM = 2;
  private static final int METHODID_DELETE_REALM = 3;
  private static final int METHODID_UPDATE_REALM = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RealmsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RealmsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_REALMS:
          serviceImpl.listRealms(
              (com.google.cloud.gaming.v1alpha.ListRealmsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ListRealmsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REALM:
          serviceImpl.getRealm(
              (com.google.cloud.gaming.v1alpha.GetRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.Realm>)
                  responseObserver);
          break;
        case METHODID_CREATE_REALM:
          serviceImpl.createRealm(
              (com.google.cloud.gaming.v1alpha.CreateRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_REALM:
          serviceImpl.deleteRealm(
              (com.google.cloud.gaming.v1alpha.DeleteRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_REALM:
          serviceImpl.updateRealm(
              (com.google.cloud.gaming.v1alpha.UpdateRealmRequest) request,
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

  private abstract static class RealmsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RealmsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gaming.v1alpha.Realms.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RealmsService");
    }
  }

  private static final class RealmsServiceFileDescriptorSupplier
      extends RealmsServiceBaseDescriptorSupplier {
    RealmsServiceFileDescriptorSupplier() {}
  }

  private static final class RealmsServiceMethodDescriptorSupplier
      extends RealmsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RealmsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RealmsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RealmsServiceFileDescriptorSupplier())
                      .addMethod(getListRealmsMethodHelper())
                      .addMethod(getGetRealmMethodHelper())
                      .addMethod(getCreateRealmMethodHelper())
                      .addMethod(getDeleteRealmMethodHelper())
                      .addMethod(getUpdateRealmMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
