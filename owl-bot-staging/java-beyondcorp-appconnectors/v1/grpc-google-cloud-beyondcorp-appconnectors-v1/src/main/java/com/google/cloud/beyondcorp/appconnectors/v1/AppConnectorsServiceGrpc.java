package com.google.cloud.beyondcorp.appconnectors.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * ## API Overview
 * The `beyondcorp.googleapis.com` service implements the Google Cloud
 * BeyondCorp API.
 * ## Data Model
 * The AppConnectorsService exposes the following resource:
 * * AppConnectors, named as follows:
 *   `projects/{project_id}/locations/{location_id}/appConnectors/{app_connector_id}`.
 * The AppConnectorsService provides methods to manage
 * (create/read/update/delete) BeyondCorp AppConnectors.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/beyondcorp/appconnectors/v1/app_connectors_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AppConnectorsServiceGrpc {

  private AppConnectorsServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.beyondcorp.appconnectors.v1.AppConnectorsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest,
      com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse> getListAppConnectorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAppConnectors",
      requestType = com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest.class,
      responseType = com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest,
      com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse> getListAppConnectorsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest, com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse> getListAppConnectorsMethod;
    if ((getListAppConnectorsMethod = AppConnectorsServiceGrpc.getListAppConnectorsMethod) == null) {
      synchronized (AppConnectorsServiceGrpc.class) {
        if ((getListAppConnectorsMethod = AppConnectorsServiceGrpc.getListAppConnectorsMethod) == null) {
          AppConnectorsServiceGrpc.getListAppConnectorsMethod = getListAppConnectorsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest, com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAppConnectors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppConnectorsServiceMethodDescriptorSupplier("ListAppConnectors"))
              .build();
        }
      }
    }
    return getListAppConnectorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest,
      com.google.cloud.beyondcorp.appconnectors.v1.AppConnector> getGetAppConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAppConnector",
      requestType = com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest.class,
      responseType = com.google.cloud.beyondcorp.appconnectors.v1.AppConnector.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest,
      com.google.cloud.beyondcorp.appconnectors.v1.AppConnector> getGetAppConnectorMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest, com.google.cloud.beyondcorp.appconnectors.v1.AppConnector> getGetAppConnectorMethod;
    if ((getGetAppConnectorMethod = AppConnectorsServiceGrpc.getGetAppConnectorMethod) == null) {
      synchronized (AppConnectorsServiceGrpc.class) {
        if ((getGetAppConnectorMethod = AppConnectorsServiceGrpc.getGetAppConnectorMethod) == null) {
          AppConnectorsServiceGrpc.getGetAppConnectorMethod = getGetAppConnectorMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest, com.google.cloud.beyondcorp.appconnectors.v1.AppConnector>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAppConnector"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnectors.v1.AppConnector.getDefaultInstance()))
              .setSchemaDescriptor(new AppConnectorsServiceMethodDescriptorSupplier("GetAppConnector"))
              .build();
        }
      }
    }
    return getGetAppConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest,
      com.google.longrunning.Operation> getCreateAppConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAppConnector",
      requestType = com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest,
      com.google.longrunning.Operation> getCreateAppConnectorMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest, com.google.longrunning.Operation> getCreateAppConnectorMethod;
    if ((getCreateAppConnectorMethod = AppConnectorsServiceGrpc.getCreateAppConnectorMethod) == null) {
      synchronized (AppConnectorsServiceGrpc.class) {
        if ((getCreateAppConnectorMethod = AppConnectorsServiceGrpc.getCreateAppConnectorMethod) == null) {
          AppConnectorsServiceGrpc.getCreateAppConnectorMethod = getCreateAppConnectorMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAppConnector"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppConnectorsServiceMethodDescriptorSupplier("CreateAppConnector"))
              .build();
        }
      }
    }
    return getCreateAppConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest,
      com.google.longrunning.Operation> getUpdateAppConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAppConnector",
      requestType = com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest,
      com.google.longrunning.Operation> getUpdateAppConnectorMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest, com.google.longrunning.Operation> getUpdateAppConnectorMethod;
    if ((getUpdateAppConnectorMethod = AppConnectorsServiceGrpc.getUpdateAppConnectorMethod) == null) {
      synchronized (AppConnectorsServiceGrpc.class) {
        if ((getUpdateAppConnectorMethod = AppConnectorsServiceGrpc.getUpdateAppConnectorMethod) == null) {
          AppConnectorsServiceGrpc.getUpdateAppConnectorMethod = getUpdateAppConnectorMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAppConnector"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppConnectorsServiceMethodDescriptorSupplier("UpdateAppConnector"))
              .build();
        }
      }
    }
    return getUpdateAppConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest,
      com.google.longrunning.Operation> getDeleteAppConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAppConnector",
      requestType = com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest,
      com.google.longrunning.Operation> getDeleteAppConnectorMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest, com.google.longrunning.Operation> getDeleteAppConnectorMethod;
    if ((getDeleteAppConnectorMethod = AppConnectorsServiceGrpc.getDeleteAppConnectorMethod) == null) {
      synchronized (AppConnectorsServiceGrpc.class) {
        if ((getDeleteAppConnectorMethod = AppConnectorsServiceGrpc.getDeleteAppConnectorMethod) == null) {
          AppConnectorsServiceGrpc.getDeleteAppConnectorMethod = getDeleteAppConnectorMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAppConnector"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppConnectorsServiceMethodDescriptorSupplier("DeleteAppConnector"))
              .build();
        }
      }
    }
    return getDeleteAppConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest,
      com.google.longrunning.Operation> getReportStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportStatus",
      requestType = com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest,
      com.google.longrunning.Operation> getReportStatusMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest, com.google.longrunning.Operation> getReportStatusMethod;
    if ((getReportStatusMethod = AppConnectorsServiceGrpc.getReportStatusMethod) == null) {
      synchronized (AppConnectorsServiceGrpc.class) {
        if ((getReportStatusMethod = AppConnectorsServiceGrpc.getReportStatusMethod) == null) {
          AppConnectorsServiceGrpc.getReportStatusMethod = getReportStatusMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReportStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppConnectorsServiceMethodDescriptorSupplier("ReportStatus"))
              .build();
        }
      }
    }
    return getReportStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AppConnectorsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppConnectorsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppConnectorsServiceStub>() {
        @java.lang.Override
        public AppConnectorsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppConnectorsServiceStub(channel, callOptions);
        }
      };
    return AppConnectorsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AppConnectorsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppConnectorsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppConnectorsServiceBlockingStub>() {
        @java.lang.Override
        public AppConnectorsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppConnectorsServiceBlockingStub(channel, callOptions);
        }
      };
    return AppConnectorsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AppConnectorsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppConnectorsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppConnectorsServiceFutureStub>() {
        @java.lang.Override
        public AppConnectorsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppConnectorsServiceFutureStub(channel, callOptions);
        }
      };
    return AppConnectorsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The AppConnectorsService exposes the following resource:
   * * AppConnectors, named as follows:
   *   `projects/{project_id}/locations/{location_id}/appConnectors/{app_connector_id}`.
   * The AppConnectorsService provides methods to manage
   * (create/read/update/delete) BeyondCorp AppConnectors.
   * </pre>
   */
  public static abstract class AppConnectorsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists AppConnectors in a given project and location.
     * </pre>
     */
    public void listAppConnectors(com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAppConnectorsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single AppConnector.
     * </pre>
     */
    public void getAppConnector(com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnectors.v1.AppConnector> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAppConnectorMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new AppConnector in a given project and location.
     * </pre>
     */
    public void createAppConnector(com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAppConnectorMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single AppConnector.
     * </pre>
     */
    public void updateAppConnector(com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAppConnectorMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single AppConnector.
     * </pre>
     */
    public void deleteAppConnector(com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAppConnectorMethod(), responseObserver);
    }

    /**
     * <pre>
     * Report status for a given connector.
     * </pre>
     */
    public void reportStatus(com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReportStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListAppConnectorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest,
                com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse>(
                  this, METHODID_LIST_APP_CONNECTORS)))
          .addMethod(
            getGetAppConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest,
                com.google.cloud.beyondcorp.appconnectors.v1.AppConnector>(
                  this, METHODID_GET_APP_CONNECTOR)))
          .addMethod(
            getCreateAppConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_APP_CONNECTOR)))
          .addMethod(
            getUpdateAppConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_APP_CONNECTOR)))
          .addMethod(
            getDeleteAppConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_APP_CONNECTOR)))
          .addMethod(
            getReportStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_REPORT_STATUS)))
          .build();
    }
  }

  /**
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The AppConnectorsService exposes the following resource:
   * * AppConnectors, named as follows:
   *   `projects/{project_id}/locations/{location_id}/appConnectors/{app_connector_id}`.
   * The AppConnectorsService provides methods to manage
   * (create/read/update/delete) BeyondCorp AppConnectors.
   * </pre>
   */
  public static final class AppConnectorsServiceStub extends io.grpc.stub.AbstractAsyncStub<AppConnectorsServiceStub> {
    private AppConnectorsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppConnectorsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppConnectorsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists AppConnectors in a given project and location.
     * </pre>
     */
    public void listAppConnectors(com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAppConnectorsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single AppConnector.
     * </pre>
     */
    public void getAppConnector(com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnectors.v1.AppConnector> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAppConnectorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new AppConnector in a given project and location.
     * </pre>
     */
    public void createAppConnector(com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAppConnectorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single AppConnector.
     * </pre>
     */
    public void updateAppConnector(com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAppConnectorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single AppConnector.
     * </pre>
     */
    public void deleteAppConnector(com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAppConnectorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Report status for a given connector.
     * </pre>
     */
    public void reportStatus(com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The AppConnectorsService exposes the following resource:
   * * AppConnectors, named as follows:
   *   `projects/{project_id}/locations/{location_id}/appConnectors/{app_connector_id}`.
   * The AppConnectorsService provides methods to manage
   * (create/read/update/delete) BeyondCorp AppConnectors.
   * </pre>
   */
  public static final class AppConnectorsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AppConnectorsServiceBlockingStub> {
    private AppConnectorsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppConnectorsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppConnectorsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists AppConnectors in a given project and location.
     * </pre>
     */
    public com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse listAppConnectors(com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAppConnectorsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single AppConnector.
     * </pre>
     */
    public com.google.cloud.beyondcorp.appconnectors.v1.AppConnector getAppConnector(com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAppConnectorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new AppConnector in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAppConnector(com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAppConnectorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single AppConnector.
     * </pre>
     */
    public com.google.longrunning.Operation updateAppConnector(com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAppConnectorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single AppConnector.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAppConnector(com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAppConnectorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Report status for a given connector.
     * </pre>
     */
    public com.google.longrunning.Operation reportStatus(com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The AppConnectorsService exposes the following resource:
   * * AppConnectors, named as follows:
   *   `projects/{project_id}/locations/{location_id}/appConnectors/{app_connector_id}`.
   * The AppConnectorsService provides methods to manage
   * (create/read/update/delete) BeyondCorp AppConnectors.
   * </pre>
   */
  public static final class AppConnectorsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AppConnectorsServiceFutureStub> {
    private AppConnectorsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppConnectorsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppConnectorsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists AppConnectors in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse> listAppConnectors(
        com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAppConnectorsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single AppConnector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.beyondcorp.appconnectors.v1.AppConnector> getAppConnector(
        com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAppConnectorMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new AppConnector in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createAppConnector(
        com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAppConnectorMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single AppConnector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateAppConnector(
        com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAppConnectorMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single AppConnector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteAppConnector(
        com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAppConnectorMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Report status for a given connector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> reportStatus(
        com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_APP_CONNECTORS = 0;
  private static final int METHODID_GET_APP_CONNECTOR = 1;
  private static final int METHODID_CREATE_APP_CONNECTOR = 2;
  private static final int METHODID_UPDATE_APP_CONNECTOR = 3;
  private static final int METHODID_DELETE_APP_CONNECTOR = 4;
  private static final int METHODID_REPORT_STATUS = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AppConnectorsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AppConnectorsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_APP_CONNECTORS:
          serviceImpl.listAppConnectors((com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse>) responseObserver);
          break;
        case METHODID_GET_APP_CONNECTOR:
          serviceImpl.getAppConnector((com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.appconnectors.v1.AppConnector>) responseObserver);
          break;
        case METHODID_CREATE_APP_CONNECTOR:
          serviceImpl.createAppConnector((com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_APP_CONNECTOR:
          serviceImpl.updateAppConnector((com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_APP_CONNECTOR:
          serviceImpl.deleteAppConnector((com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REPORT_STATUS:
          serviceImpl.reportStatus((com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest) request,
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

  private static abstract class AppConnectorsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AppConnectorsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AppConnectorsService");
    }
  }

  private static final class AppConnectorsServiceFileDescriptorSupplier
      extends AppConnectorsServiceBaseDescriptorSupplier {
    AppConnectorsServiceFileDescriptorSupplier() {}
  }

  private static final class AppConnectorsServiceMethodDescriptorSupplier
      extends AppConnectorsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AppConnectorsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AppConnectorsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AppConnectorsServiceFileDescriptorSupplier())
              .addMethod(getListAppConnectorsMethod())
              .addMethod(getGetAppConnectorMethod())
              .addMethod(getCreateAppConnectorMethod())
              .addMethod(getUpdateAppConnectorMethod())
              .addMethod(getDeleteAppConnectorMethod())
              .addMethod(getReportStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
