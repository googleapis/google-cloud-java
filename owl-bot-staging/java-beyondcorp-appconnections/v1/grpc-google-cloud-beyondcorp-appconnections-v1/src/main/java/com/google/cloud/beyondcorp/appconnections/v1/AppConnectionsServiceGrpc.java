package com.google.cloud.beyondcorp.appconnections.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * ## API Overview
 * The `beyondcorp.googleapis.com` service implements the Google Cloud
 * BeyondCorp API.
 * ## Data Model
 * The AppConnectionsService exposes the following resources:
 * * AppConnections, named as follows:
 *   `projects/{project_id}/locations/{location_id}/appConnections/{app_connection_id}`.
 * The AppConnectionsService service provides methods to manage
 * (create/read/update/delete) BeyondCorp AppConnections.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/beyondcorp/appconnections/v1/app_connections_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AppConnectionsServiceGrpc {

  private AppConnectionsServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.beyondcorp.appconnections.v1.AppConnectionsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest,
      com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse> getListAppConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAppConnections",
      requestType = com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest.class,
      responseType = com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest,
      com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse> getListAppConnectionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest, com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse> getListAppConnectionsMethod;
    if ((getListAppConnectionsMethod = AppConnectionsServiceGrpc.getListAppConnectionsMethod) == null) {
      synchronized (AppConnectionsServiceGrpc.class) {
        if ((getListAppConnectionsMethod = AppConnectionsServiceGrpc.getListAppConnectionsMethod) == null) {
          AppConnectionsServiceGrpc.getListAppConnectionsMethod = getListAppConnectionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest, com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAppConnections"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppConnectionsServiceMethodDescriptorSupplier("ListAppConnections"))
              .build();
        }
      }
    }
    return getListAppConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest,
      com.google.cloud.beyondcorp.appconnections.v1.AppConnection> getGetAppConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAppConnection",
      requestType = com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest.class,
      responseType = com.google.cloud.beyondcorp.appconnections.v1.AppConnection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest,
      com.google.cloud.beyondcorp.appconnections.v1.AppConnection> getGetAppConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest, com.google.cloud.beyondcorp.appconnections.v1.AppConnection> getGetAppConnectionMethod;
    if ((getGetAppConnectionMethod = AppConnectionsServiceGrpc.getGetAppConnectionMethod) == null) {
      synchronized (AppConnectionsServiceGrpc.class) {
        if ((getGetAppConnectionMethod = AppConnectionsServiceGrpc.getGetAppConnectionMethod) == null) {
          AppConnectionsServiceGrpc.getGetAppConnectionMethod = getGetAppConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest, com.google.cloud.beyondcorp.appconnections.v1.AppConnection>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAppConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnections.v1.AppConnection.getDefaultInstance()))
              .setSchemaDescriptor(new AppConnectionsServiceMethodDescriptorSupplier("GetAppConnection"))
              .build();
        }
      }
    }
    return getGetAppConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest,
      com.google.longrunning.Operation> getCreateAppConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAppConnection",
      requestType = com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest,
      com.google.longrunning.Operation> getCreateAppConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest, com.google.longrunning.Operation> getCreateAppConnectionMethod;
    if ((getCreateAppConnectionMethod = AppConnectionsServiceGrpc.getCreateAppConnectionMethod) == null) {
      synchronized (AppConnectionsServiceGrpc.class) {
        if ((getCreateAppConnectionMethod = AppConnectionsServiceGrpc.getCreateAppConnectionMethod) == null) {
          AppConnectionsServiceGrpc.getCreateAppConnectionMethod = getCreateAppConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAppConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppConnectionsServiceMethodDescriptorSupplier("CreateAppConnection"))
              .build();
        }
      }
    }
    return getCreateAppConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest,
      com.google.longrunning.Operation> getUpdateAppConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAppConnection",
      requestType = com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest,
      com.google.longrunning.Operation> getUpdateAppConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest, com.google.longrunning.Operation> getUpdateAppConnectionMethod;
    if ((getUpdateAppConnectionMethod = AppConnectionsServiceGrpc.getUpdateAppConnectionMethod) == null) {
      synchronized (AppConnectionsServiceGrpc.class) {
        if ((getUpdateAppConnectionMethod = AppConnectionsServiceGrpc.getUpdateAppConnectionMethod) == null) {
          AppConnectionsServiceGrpc.getUpdateAppConnectionMethod = getUpdateAppConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAppConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppConnectionsServiceMethodDescriptorSupplier("UpdateAppConnection"))
              .build();
        }
      }
    }
    return getUpdateAppConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest,
      com.google.longrunning.Operation> getDeleteAppConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAppConnection",
      requestType = com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest,
      com.google.longrunning.Operation> getDeleteAppConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest, com.google.longrunning.Operation> getDeleteAppConnectionMethod;
    if ((getDeleteAppConnectionMethod = AppConnectionsServiceGrpc.getDeleteAppConnectionMethod) == null) {
      synchronized (AppConnectionsServiceGrpc.class) {
        if ((getDeleteAppConnectionMethod = AppConnectionsServiceGrpc.getDeleteAppConnectionMethod) == null) {
          AppConnectionsServiceGrpc.getDeleteAppConnectionMethod = getDeleteAppConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAppConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppConnectionsServiceMethodDescriptorSupplier("DeleteAppConnection"))
              .build();
        }
      }
    }
    return getDeleteAppConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest,
      com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse> getResolveAppConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResolveAppConnections",
      requestType = com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest.class,
      responseType = com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest,
      com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse> getResolveAppConnectionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest, com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse> getResolveAppConnectionsMethod;
    if ((getResolveAppConnectionsMethod = AppConnectionsServiceGrpc.getResolveAppConnectionsMethod) == null) {
      synchronized (AppConnectionsServiceGrpc.class) {
        if ((getResolveAppConnectionsMethod = AppConnectionsServiceGrpc.getResolveAppConnectionsMethod) == null) {
          AppConnectionsServiceGrpc.getResolveAppConnectionsMethod = getResolveAppConnectionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest, com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResolveAppConnections"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppConnectionsServiceMethodDescriptorSupplier("ResolveAppConnections"))
              .build();
        }
      }
    }
    return getResolveAppConnectionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AppConnectionsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppConnectionsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppConnectionsServiceStub>() {
        @java.lang.Override
        public AppConnectionsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppConnectionsServiceStub(channel, callOptions);
        }
      };
    return AppConnectionsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AppConnectionsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppConnectionsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppConnectionsServiceBlockingStub>() {
        @java.lang.Override
        public AppConnectionsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppConnectionsServiceBlockingStub(channel, callOptions);
        }
      };
    return AppConnectionsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AppConnectionsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppConnectionsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppConnectionsServiceFutureStub>() {
        @java.lang.Override
        public AppConnectionsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppConnectionsServiceFutureStub(channel, callOptions);
        }
      };
    return AppConnectionsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The AppConnectionsService exposes the following resources:
   * * AppConnections, named as follows:
   *   `projects/{project_id}/locations/{location_id}/appConnections/{app_connection_id}`.
   * The AppConnectionsService service provides methods to manage
   * (create/read/update/delete) BeyondCorp AppConnections.
   * </pre>
   */
  public static abstract class AppConnectionsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists AppConnections in a given project and location.
     * </pre>
     */
    public void listAppConnections(com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAppConnectionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single AppConnection.
     * </pre>
     */
    public void getAppConnection(com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnections.v1.AppConnection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAppConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new AppConnection in a given project and location.
     * </pre>
     */
    public void createAppConnection(com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAppConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single AppConnection.
     * </pre>
     */
    public void updateAppConnection(com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAppConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single AppConnection.
     * </pre>
     */
    public void deleteAppConnection(com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAppConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Resolves AppConnections details for a given AppConnector.
     * An internal method called by a connector to find AppConnections to connect
     * to.
     * </pre>
     */
    public void resolveAppConnections(com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResolveAppConnectionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListAppConnectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest,
                com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse>(
                  this, METHODID_LIST_APP_CONNECTIONS)))
          .addMethod(
            getGetAppConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest,
                com.google.cloud.beyondcorp.appconnections.v1.AppConnection>(
                  this, METHODID_GET_APP_CONNECTION)))
          .addMethod(
            getCreateAppConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_APP_CONNECTION)))
          .addMethod(
            getUpdateAppConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_APP_CONNECTION)))
          .addMethod(
            getDeleteAppConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_APP_CONNECTION)))
          .addMethod(
            getResolveAppConnectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest,
                com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse>(
                  this, METHODID_RESOLVE_APP_CONNECTIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The AppConnectionsService exposes the following resources:
   * * AppConnections, named as follows:
   *   `projects/{project_id}/locations/{location_id}/appConnections/{app_connection_id}`.
   * The AppConnectionsService service provides methods to manage
   * (create/read/update/delete) BeyondCorp AppConnections.
   * </pre>
   */
  public static final class AppConnectionsServiceStub extends io.grpc.stub.AbstractAsyncStub<AppConnectionsServiceStub> {
    private AppConnectionsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppConnectionsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppConnectionsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists AppConnections in a given project and location.
     * </pre>
     */
    public void listAppConnections(com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAppConnectionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single AppConnection.
     * </pre>
     */
    public void getAppConnection(com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnections.v1.AppConnection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAppConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new AppConnection in a given project and location.
     * </pre>
     */
    public void createAppConnection(com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAppConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single AppConnection.
     * </pre>
     */
    public void updateAppConnection(com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAppConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single AppConnection.
     * </pre>
     */
    public void deleteAppConnection(com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAppConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Resolves AppConnections details for a given AppConnector.
     * An internal method called by a connector to find AppConnections to connect
     * to.
     * </pre>
     */
    public void resolveAppConnections(com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResolveAppConnectionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The AppConnectionsService exposes the following resources:
   * * AppConnections, named as follows:
   *   `projects/{project_id}/locations/{location_id}/appConnections/{app_connection_id}`.
   * The AppConnectionsService service provides methods to manage
   * (create/read/update/delete) BeyondCorp AppConnections.
   * </pre>
   */
  public static final class AppConnectionsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AppConnectionsServiceBlockingStub> {
    private AppConnectionsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppConnectionsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppConnectionsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists AppConnections in a given project and location.
     * </pre>
     */
    public com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse listAppConnections(com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAppConnectionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single AppConnection.
     * </pre>
     */
    public com.google.cloud.beyondcorp.appconnections.v1.AppConnection getAppConnection(com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAppConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new AppConnection in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAppConnection(com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAppConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single AppConnection.
     * </pre>
     */
    public com.google.longrunning.Operation updateAppConnection(com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAppConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single AppConnection.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAppConnection(com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAppConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Resolves AppConnections details for a given AppConnector.
     * An internal method called by a connector to find AppConnections to connect
     * to.
     * </pre>
     */
    public com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse resolveAppConnections(com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResolveAppConnectionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The AppConnectionsService exposes the following resources:
   * * AppConnections, named as follows:
   *   `projects/{project_id}/locations/{location_id}/appConnections/{app_connection_id}`.
   * The AppConnectionsService service provides methods to manage
   * (create/read/update/delete) BeyondCorp AppConnections.
   * </pre>
   */
  public static final class AppConnectionsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AppConnectionsServiceFutureStub> {
    private AppConnectionsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppConnectionsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppConnectionsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists AppConnections in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse> listAppConnections(
        com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAppConnectionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single AppConnection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.beyondcorp.appconnections.v1.AppConnection> getAppConnection(
        com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAppConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new AppConnection in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createAppConnection(
        com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAppConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single AppConnection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateAppConnection(
        com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAppConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single AppConnection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteAppConnection(
        com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAppConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Resolves AppConnections details for a given AppConnector.
     * An internal method called by a connector to find AppConnections to connect
     * to.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse> resolveAppConnections(
        com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResolveAppConnectionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_APP_CONNECTIONS = 0;
  private static final int METHODID_GET_APP_CONNECTION = 1;
  private static final int METHODID_CREATE_APP_CONNECTION = 2;
  private static final int METHODID_UPDATE_APP_CONNECTION = 3;
  private static final int METHODID_DELETE_APP_CONNECTION = 4;
  private static final int METHODID_RESOLVE_APP_CONNECTIONS = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AppConnectionsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AppConnectionsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_APP_CONNECTIONS:
          serviceImpl.listAppConnections((com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse>) responseObserver);
          break;
        case METHODID_GET_APP_CONNECTION:
          serviceImpl.getAppConnection((com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnections.v1.AppConnection>) responseObserver);
          break;
        case METHODID_CREATE_APP_CONNECTION:
          serviceImpl.createAppConnection((com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_APP_CONNECTION:
          serviceImpl.updateAppConnection((com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_APP_CONNECTION:
          serviceImpl.deleteAppConnection((com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESOLVE_APP_CONNECTIONS:
          serviceImpl.resolveAppConnections((com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse>) responseObserver);
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

  private static abstract class AppConnectionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AppConnectionsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AppConnectionsService");
    }
  }

  private static final class AppConnectionsServiceFileDescriptorSupplier
      extends AppConnectionsServiceBaseDescriptorSupplier {
    AppConnectionsServiceFileDescriptorSupplier() {}
  }

  private static final class AppConnectionsServiceMethodDescriptorSupplier
      extends AppConnectionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AppConnectionsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AppConnectionsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AppConnectionsServiceFileDescriptorSupplier())
              .addMethod(getListAppConnectionsMethod())
              .addMethod(getGetAppConnectionMethod())
              .addMethod(getCreateAppConnectionMethod())
              .addMethod(getUpdateAppConnectionMethod())
              .addMethod(getDeleteAppConnectionMethod())
              .addMethod(getResolveAppConnectionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
