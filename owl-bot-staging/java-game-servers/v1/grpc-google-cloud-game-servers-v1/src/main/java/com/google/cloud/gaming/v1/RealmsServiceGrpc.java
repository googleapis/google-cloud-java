package com.google.cloud.gaming.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A realm is a grouping of game server clusters that are considered
 * interchangeable.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gaming/v1/realms_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RealmsServiceGrpc {

  private RealmsServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gaming.v1.RealmsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.ListRealmsRequest,
      com.google.cloud.gaming.v1.ListRealmsResponse> getListRealmsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRealms",
      requestType = com.google.cloud.gaming.v1.ListRealmsRequest.class,
      responseType = com.google.cloud.gaming.v1.ListRealmsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.ListRealmsRequest,
      com.google.cloud.gaming.v1.ListRealmsResponse> getListRealmsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.ListRealmsRequest, com.google.cloud.gaming.v1.ListRealmsResponse> getListRealmsMethod;
    if ((getListRealmsMethod = RealmsServiceGrpc.getListRealmsMethod) == null) {
      synchronized (RealmsServiceGrpc.class) {
        if ((getListRealmsMethod = RealmsServiceGrpc.getListRealmsMethod) == null) {
          RealmsServiceGrpc.getListRealmsMethod = getListRealmsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.ListRealmsRequest, com.google.cloud.gaming.v1.ListRealmsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRealms"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.ListRealmsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.ListRealmsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RealmsServiceMethodDescriptorSupplier("ListRealms"))
              .build();
        }
      }
    }
    return getListRealmsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.GetRealmRequest,
      com.google.cloud.gaming.v1.Realm> getGetRealmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealm",
      requestType = com.google.cloud.gaming.v1.GetRealmRequest.class,
      responseType = com.google.cloud.gaming.v1.Realm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.GetRealmRequest,
      com.google.cloud.gaming.v1.Realm> getGetRealmMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.GetRealmRequest, com.google.cloud.gaming.v1.Realm> getGetRealmMethod;
    if ((getGetRealmMethod = RealmsServiceGrpc.getGetRealmMethod) == null) {
      synchronized (RealmsServiceGrpc.class) {
        if ((getGetRealmMethod = RealmsServiceGrpc.getGetRealmMethod) == null) {
          RealmsServiceGrpc.getGetRealmMethod = getGetRealmMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.GetRealmRequest, com.google.cloud.gaming.v1.Realm>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRealm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.GetRealmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.Realm.getDefaultInstance()))
              .setSchemaDescriptor(new RealmsServiceMethodDescriptorSupplier("GetRealm"))
              .build();
        }
      }
    }
    return getGetRealmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.CreateRealmRequest,
      com.google.longrunning.Operation> getCreateRealmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRealm",
      requestType = com.google.cloud.gaming.v1.CreateRealmRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.CreateRealmRequest,
      com.google.longrunning.Operation> getCreateRealmMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.CreateRealmRequest, com.google.longrunning.Operation> getCreateRealmMethod;
    if ((getCreateRealmMethod = RealmsServiceGrpc.getCreateRealmMethod) == null) {
      synchronized (RealmsServiceGrpc.class) {
        if ((getCreateRealmMethod = RealmsServiceGrpc.getCreateRealmMethod) == null) {
          RealmsServiceGrpc.getCreateRealmMethod = getCreateRealmMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.CreateRealmRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRealm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.CreateRealmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new RealmsServiceMethodDescriptorSupplier("CreateRealm"))
              .build();
        }
      }
    }
    return getCreateRealmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.DeleteRealmRequest,
      com.google.longrunning.Operation> getDeleteRealmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRealm",
      requestType = com.google.cloud.gaming.v1.DeleteRealmRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.DeleteRealmRequest,
      com.google.longrunning.Operation> getDeleteRealmMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.DeleteRealmRequest, com.google.longrunning.Operation> getDeleteRealmMethod;
    if ((getDeleteRealmMethod = RealmsServiceGrpc.getDeleteRealmMethod) == null) {
      synchronized (RealmsServiceGrpc.class) {
        if ((getDeleteRealmMethod = RealmsServiceGrpc.getDeleteRealmMethod) == null) {
          RealmsServiceGrpc.getDeleteRealmMethod = getDeleteRealmMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.DeleteRealmRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRealm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.DeleteRealmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new RealmsServiceMethodDescriptorSupplier("DeleteRealm"))
              .build();
        }
      }
    }
    return getDeleteRealmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.UpdateRealmRequest,
      com.google.longrunning.Operation> getUpdateRealmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRealm",
      requestType = com.google.cloud.gaming.v1.UpdateRealmRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.UpdateRealmRequest,
      com.google.longrunning.Operation> getUpdateRealmMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.UpdateRealmRequest, com.google.longrunning.Operation> getUpdateRealmMethod;
    if ((getUpdateRealmMethod = RealmsServiceGrpc.getUpdateRealmMethod) == null) {
      synchronized (RealmsServiceGrpc.class) {
        if ((getUpdateRealmMethod = RealmsServiceGrpc.getUpdateRealmMethod) == null) {
          RealmsServiceGrpc.getUpdateRealmMethod = getUpdateRealmMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.UpdateRealmRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRealm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.UpdateRealmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new RealmsServiceMethodDescriptorSupplier("UpdateRealm"))
              .build();
        }
      }
    }
    return getUpdateRealmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.PreviewRealmUpdateRequest,
      com.google.cloud.gaming.v1.PreviewRealmUpdateResponse> getPreviewRealmUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PreviewRealmUpdate",
      requestType = com.google.cloud.gaming.v1.PreviewRealmUpdateRequest.class,
      responseType = com.google.cloud.gaming.v1.PreviewRealmUpdateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.PreviewRealmUpdateRequest,
      com.google.cloud.gaming.v1.PreviewRealmUpdateResponse> getPreviewRealmUpdateMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.PreviewRealmUpdateRequest, com.google.cloud.gaming.v1.PreviewRealmUpdateResponse> getPreviewRealmUpdateMethod;
    if ((getPreviewRealmUpdateMethod = RealmsServiceGrpc.getPreviewRealmUpdateMethod) == null) {
      synchronized (RealmsServiceGrpc.class) {
        if ((getPreviewRealmUpdateMethod = RealmsServiceGrpc.getPreviewRealmUpdateMethod) == null) {
          RealmsServiceGrpc.getPreviewRealmUpdateMethod = getPreviewRealmUpdateMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.PreviewRealmUpdateRequest, com.google.cloud.gaming.v1.PreviewRealmUpdateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PreviewRealmUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.PreviewRealmUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.PreviewRealmUpdateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RealmsServiceMethodDescriptorSupplier("PreviewRealmUpdate"))
              .build();
        }
      }
    }
    return getPreviewRealmUpdateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RealmsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RealmsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RealmsServiceStub>() {
        @java.lang.Override
        public RealmsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RealmsServiceStub(channel, callOptions);
        }
      };
    return RealmsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RealmsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RealmsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RealmsServiceBlockingStub>() {
        @java.lang.Override
        public RealmsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RealmsServiceBlockingStub(channel, callOptions);
        }
      };
    return RealmsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RealmsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RealmsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RealmsServiceFutureStub>() {
        @java.lang.Override
        public RealmsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RealmsServiceFutureStub(channel, callOptions);
        }
      };
    return RealmsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A realm is a grouping of game server clusters that are considered
   * interchangeable.
   * </pre>
   */
  public static abstract class RealmsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists realms in a given project and location.
     * </pre>
     */
    public void listRealms(com.google.cloud.gaming.v1.ListRealmsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.ListRealmsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRealmsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single realm.
     * </pre>
     */
    public void getRealm(com.google.cloud.gaming.v1.GetRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.Realm> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRealmMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new realm in a given project and location.
     * </pre>
     */
    public void createRealm(com.google.cloud.gaming.v1.CreateRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRealmMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single realm.
     * </pre>
     */
    public void deleteRealm(com.google.cloud.gaming.v1.DeleteRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRealmMethod(), responseObserver);
    }

    /**
     * <pre>
     * Patches a single realm.
     * </pre>
     */
    public void updateRealm(com.google.cloud.gaming.v1.UpdateRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateRealmMethod(), responseObserver);
    }

    /**
     * <pre>
     * Previews patches to a single realm.
     * </pre>
     */
    public void previewRealmUpdate(com.google.cloud.gaming.v1.PreviewRealmUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.PreviewRealmUpdateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPreviewRealmUpdateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListRealmsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.ListRealmsRequest,
                com.google.cloud.gaming.v1.ListRealmsResponse>(
                  this, METHODID_LIST_REALMS)))
          .addMethod(
            getGetRealmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.GetRealmRequest,
                com.google.cloud.gaming.v1.Realm>(
                  this, METHODID_GET_REALM)))
          .addMethod(
            getCreateRealmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.CreateRealmRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_REALM)))
          .addMethod(
            getDeleteRealmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.DeleteRealmRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_REALM)))
          .addMethod(
            getUpdateRealmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.UpdateRealmRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_REALM)))
          .addMethod(
            getPreviewRealmUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.PreviewRealmUpdateRequest,
                com.google.cloud.gaming.v1.PreviewRealmUpdateResponse>(
                  this, METHODID_PREVIEW_REALM_UPDATE)))
          .build();
    }
  }

  /**
   * <pre>
   * A realm is a grouping of game server clusters that are considered
   * interchangeable.
   * </pre>
   */
  public static final class RealmsServiceStub extends io.grpc.stub.AbstractAsyncStub<RealmsServiceStub> {
    private RealmsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RealmsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RealmsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists realms in a given project and location.
     * </pre>
     */
    public void listRealms(com.google.cloud.gaming.v1.ListRealmsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.ListRealmsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRealmsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single realm.
     * </pre>
     */
    public void getRealm(com.google.cloud.gaming.v1.GetRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.Realm> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRealmMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new realm in a given project and location.
     * </pre>
     */
    public void createRealm(com.google.cloud.gaming.v1.CreateRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRealmMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single realm.
     * </pre>
     */
    public void deleteRealm(com.google.cloud.gaming.v1.DeleteRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRealmMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Patches a single realm.
     * </pre>
     */
    public void updateRealm(com.google.cloud.gaming.v1.UpdateRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRealmMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Previews patches to a single realm.
     * </pre>
     */
    public void previewRealmUpdate(com.google.cloud.gaming.v1.PreviewRealmUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.PreviewRealmUpdateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPreviewRealmUpdateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * A realm is a grouping of game server clusters that are considered
   * interchangeable.
   * </pre>
   */
  public static final class RealmsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RealmsServiceBlockingStub> {
    private RealmsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RealmsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RealmsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists realms in a given project and location.
     * </pre>
     */
    public com.google.cloud.gaming.v1.ListRealmsResponse listRealms(com.google.cloud.gaming.v1.ListRealmsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRealmsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single realm.
     * </pre>
     */
    public com.google.cloud.gaming.v1.Realm getRealm(com.google.cloud.gaming.v1.GetRealmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRealmMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new realm in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createRealm(com.google.cloud.gaming.v1.CreateRealmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRealmMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single realm.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRealm(com.google.cloud.gaming.v1.DeleteRealmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRealmMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Patches a single realm.
     * </pre>
     */
    public com.google.longrunning.Operation updateRealm(com.google.cloud.gaming.v1.UpdateRealmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRealmMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Previews patches to a single realm.
     * </pre>
     */
    public com.google.cloud.gaming.v1.PreviewRealmUpdateResponse previewRealmUpdate(com.google.cloud.gaming.v1.PreviewRealmUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPreviewRealmUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A realm is a grouping of game server clusters that are considered
   * interchangeable.
   * </pre>
   */
  public static final class RealmsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RealmsServiceFutureStub> {
    private RealmsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RealmsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RealmsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists realms in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gaming.v1.ListRealmsResponse> listRealms(
        com.google.cloud.gaming.v1.ListRealmsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRealmsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single realm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gaming.v1.Realm> getRealm(
        com.google.cloud.gaming.v1.GetRealmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRealmMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new realm in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createRealm(
        com.google.cloud.gaming.v1.CreateRealmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRealmMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single realm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteRealm(
        com.google.cloud.gaming.v1.DeleteRealmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRealmMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Patches a single realm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateRealm(
        com.google.cloud.gaming.v1.UpdateRealmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRealmMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Previews patches to a single realm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gaming.v1.PreviewRealmUpdateResponse> previewRealmUpdate(
        com.google.cloud.gaming.v1.PreviewRealmUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPreviewRealmUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_REALMS = 0;
  private static final int METHODID_GET_REALM = 1;
  private static final int METHODID_CREATE_REALM = 2;
  private static final int METHODID_DELETE_REALM = 3;
  private static final int METHODID_UPDATE_REALM = 4;
  private static final int METHODID_PREVIEW_REALM_UPDATE = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.listRealms((com.google.cloud.gaming.v1.ListRealmsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.ListRealmsResponse>) responseObserver);
          break;
        case METHODID_GET_REALM:
          serviceImpl.getRealm((com.google.cloud.gaming.v1.GetRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.Realm>) responseObserver);
          break;
        case METHODID_CREATE_REALM:
          serviceImpl.createRealm((com.google.cloud.gaming.v1.CreateRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_REALM:
          serviceImpl.deleteRealm((com.google.cloud.gaming.v1.DeleteRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_REALM:
          serviceImpl.updateRealm((com.google.cloud.gaming.v1.UpdateRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PREVIEW_REALM_UPDATE:
          serviceImpl.previewRealmUpdate((com.google.cloud.gaming.v1.PreviewRealmUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.PreviewRealmUpdateResponse>) responseObserver);
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

  private static abstract class RealmsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RealmsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gaming.v1.RealmsServiceOuterClass.getDescriptor();
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
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RealmsServiceFileDescriptorSupplier())
              .addMethod(getListRealmsMethod())
              .addMethod(getGetRealmMethod())
              .addMethod(getCreateRealmMethod())
              .addMethod(getDeleteRealmMethod())
              .addMethod(getUpdateRealmMethod())
              .addMethod(getPreviewRealmUpdateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
