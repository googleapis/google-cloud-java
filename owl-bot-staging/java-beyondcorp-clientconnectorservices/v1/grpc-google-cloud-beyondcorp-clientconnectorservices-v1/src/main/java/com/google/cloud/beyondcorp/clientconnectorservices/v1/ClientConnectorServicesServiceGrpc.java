package com.google.cloud.beyondcorp.clientconnectorservices.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * ## API Overview
 * The `beyondcorp.googleapis.com` service implements the Google Cloud
 * BeyondCorp API.
 * ## Data Model
 * The ClientConnectorServicesService exposes the following resources:
 * * Client Connector Services, named as follows:
 *   `projects/{project_id}/locations/{location_id}/client_connector_services/{client_connector_service_id}`.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/beyondcorp/clientconnectorservices/v1/client_connector_services_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ClientConnectorServicesServiceGrpc {

  private ClientConnectorServicesServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest,
      com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse> getListClientConnectorServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClientConnectorServices",
      requestType = com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest.class,
      responseType = com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest,
      com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse> getListClientConnectorServicesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest, com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse> getListClientConnectorServicesMethod;
    if ((getListClientConnectorServicesMethod = ClientConnectorServicesServiceGrpc.getListClientConnectorServicesMethod) == null) {
      synchronized (ClientConnectorServicesServiceGrpc.class) {
        if ((getListClientConnectorServicesMethod = ClientConnectorServicesServiceGrpc.getListClientConnectorServicesMethod) == null) {
          ClientConnectorServicesServiceGrpc.getListClientConnectorServicesMethod = getListClientConnectorServicesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest, com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClientConnectorServices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ClientConnectorServicesServiceMethodDescriptorSupplier("ListClientConnectorServices"))
              .build();
        }
      }
    }
    return getListClientConnectorServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest,
      com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService> getGetClientConnectorServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetClientConnectorService",
      requestType = com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest.class,
      responseType = com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest,
      com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService> getGetClientConnectorServiceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest, com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService> getGetClientConnectorServiceMethod;
    if ((getGetClientConnectorServiceMethod = ClientConnectorServicesServiceGrpc.getGetClientConnectorServiceMethod) == null) {
      synchronized (ClientConnectorServicesServiceGrpc.class) {
        if ((getGetClientConnectorServiceMethod = ClientConnectorServicesServiceGrpc.getGetClientConnectorServiceMethod) == null) {
          ClientConnectorServicesServiceGrpc.getGetClientConnectorServiceMethod = getGetClientConnectorServiceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest, com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetClientConnectorService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService.getDefaultInstance()))
              .setSchemaDescriptor(new ClientConnectorServicesServiceMethodDescriptorSupplier("GetClientConnectorService"))
              .build();
        }
      }
    }
    return getGetClientConnectorServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest,
      com.google.longrunning.Operation> getCreateClientConnectorServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateClientConnectorService",
      requestType = com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest,
      com.google.longrunning.Operation> getCreateClientConnectorServiceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest, com.google.longrunning.Operation> getCreateClientConnectorServiceMethod;
    if ((getCreateClientConnectorServiceMethod = ClientConnectorServicesServiceGrpc.getCreateClientConnectorServiceMethod) == null) {
      synchronized (ClientConnectorServicesServiceGrpc.class) {
        if ((getCreateClientConnectorServiceMethod = ClientConnectorServicesServiceGrpc.getCreateClientConnectorServiceMethod) == null) {
          ClientConnectorServicesServiceGrpc.getCreateClientConnectorServiceMethod = getCreateClientConnectorServiceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateClientConnectorService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ClientConnectorServicesServiceMethodDescriptorSupplier("CreateClientConnectorService"))
              .build();
        }
      }
    }
    return getCreateClientConnectorServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest,
      com.google.longrunning.Operation> getUpdateClientConnectorServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateClientConnectorService",
      requestType = com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest,
      com.google.longrunning.Operation> getUpdateClientConnectorServiceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest, com.google.longrunning.Operation> getUpdateClientConnectorServiceMethod;
    if ((getUpdateClientConnectorServiceMethod = ClientConnectorServicesServiceGrpc.getUpdateClientConnectorServiceMethod) == null) {
      synchronized (ClientConnectorServicesServiceGrpc.class) {
        if ((getUpdateClientConnectorServiceMethod = ClientConnectorServicesServiceGrpc.getUpdateClientConnectorServiceMethod) == null) {
          ClientConnectorServicesServiceGrpc.getUpdateClientConnectorServiceMethod = getUpdateClientConnectorServiceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateClientConnectorService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ClientConnectorServicesServiceMethodDescriptorSupplier("UpdateClientConnectorService"))
              .build();
        }
      }
    }
    return getUpdateClientConnectorServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest,
      com.google.longrunning.Operation> getDeleteClientConnectorServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteClientConnectorService",
      requestType = com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest,
      com.google.longrunning.Operation> getDeleteClientConnectorServiceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest, com.google.longrunning.Operation> getDeleteClientConnectorServiceMethod;
    if ((getDeleteClientConnectorServiceMethod = ClientConnectorServicesServiceGrpc.getDeleteClientConnectorServiceMethod) == null) {
      synchronized (ClientConnectorServicesServiceGrpc.class) {
        if ((getDeleteClientConnectorServiceMethod = ClientConnectorServicesServiceGrpc.getDeleteClientConnectorServiceMethod) == null) {
          ClientConnectorServicesServiceGrpc.getDeleteClientConnectorServiceMethod = getDeleteClientConnectorServiceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteClientConnectorService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ClientConnectorServicesServiceMethodDescriptorSupplier("DeleteClientConnectorService"))
              .build();
        }
      }
    }
    return getDeleteClientConnectorServiceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientConnectorServicesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientConnectorServicesServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientConnectorServicesServiceStub>() {
        @java.lang.Override
        public ClientConnectorServicesServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientConnectorServicesServiceStub(channel, callOptions);
        }
      };
    return ClientConnectorServicesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientConnectorServicesServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientConnectorServicesServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientConnectorServicesServiceBlockingStub>() {
        @java.lang.Override
        public ClientConnectorServicesServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientConnectorServicesServiceBlockingStub(channel, callOptions);
        }
      };
    return ClientConnectorServicesServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientConnectorServicesServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientConnectorServicesServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientConnectorServicesServiceFutureStub>() {
        @java.lang.Override
        public ClientConnectorServicesServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientConnectorServicesServiceFutureStub(channel, callOptions);
        }
      };
    return ClientConnectorServicesServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The ClientConnectorServicesService exposes the following resources:
   * * Client Connector Services, named as follows:
   *   `projects/{project_id}/locations/{location_id}/client_connector_services/{client_connector_service_id}`.
   * </pre>
   */
  public static abstract class ClientConnectorServicesServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists ClientConnectorServices in a given project and location.
     * </pre>
     */
    public void listClientConnectorServices(com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListClientConnectorServicesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single ClientConnectorService.
     * </pre>
     */
    public void getClientConnectorService(com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClientConnectorServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new ClientConnectorService in a given project and location.
     * </pre>
     */
    public void createClientConnectorService(com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateClientConnectorServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single ClientConnectorService.
     * </pre>
     */
    public void updateClientConnectorService(com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateClientConnectorServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single ClientConnectorService.
     * </pre>
     */
    public void deleteClientConnectorService(com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteClientConnectorServiceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListClientConnectorServicesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest,
                com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse>(
                  this, METHODID_LIST_CLIENT_CONNECTOR_SERVICES)))
          .addMethod(
            getGetClientConnectorServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest,
                com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService>(
                  this, METHODID_GET_CLIENT_CONNECTOR_SERVICE)))
          .addMethod(
            getCreateClientConnectorServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CLIENT_CONNECTOR_SERVICE)))
          .addMethod(
            getUpdateClientConnectorServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_CLIENT_CONNECTOR_SERVICE)))
          .addMethod(
            getDeleteClientConnectorServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_CLIENT_CONNECTOR_SERVICE)))
          .build();
    }
  }

  /**
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The ClientConnectorServicesService exposes the following resources:
   * * Client Connector Services, named as follows:
   *   `projects/{project_id}/locations/{location_id}/client_connector_services/{client_connector_service_id}`.
   * </pre>
   */
  public static final class ClientConnectorServicesServiceStub extends io.grpc.stub.AbstractAsyncStub<ClientConnectorServicesServiceStub> {
    private ClientConnectorServicesServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientConnectorServicesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientConnectorServicesServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists ClientConnectorServices in a given project and location.
     * </pre>
     */
    public void listClientConnectorServices(com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListClientConnectorServicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single ClientConnectorService.
     * </pre>
     */
    public void getClientConnectorService(com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClientConnectorServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new ClientConnectorService in a given project and location.
     * </pre>
     */
    public void createClientConnectorService(com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClientConnectorServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single ClientConnectorService.
     * </pre>
     */
    public void updateClientConnectorService(com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateClientConnectorServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single ClientConnectorService.
     * </pre>
     */
    public void deleteClientConnectorService(com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteClientConnectorServiceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The ClientConnectorServicesService exposes the following resources:
   * * Client Connector Services, named as follows:
   *   `projects/{project_id}/locations/{location_id}/client_connector_services/{client_connector_service_id}`.
   * </pre>
   */
  public static final class ClientConnectorServicesServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ClientConnectorServicesServiceBlockingStub> {
    private ClientConnectorServicesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientConnectorServicesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientConnectorServicesServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists ClientConnectorServices in a given project and location.
     * </pre>
     */
    public com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse listClientConnectorServices(com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClientConnectorServicesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single ClientConnectorService.
     * </pre>
     */
    public com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService getClientConnectorService(com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClientConnectorServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new ClientConnectorService in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createClientConnectorService(com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClientConnectorServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single ClientConnectorService.
     * </pre>
     */
    public com.google.longrunning.Operation updateClientConnectorService(com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClientConnectorServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single ClientConnectorService.
     * </pre>
     */
    public com.google.longrunning.Operation deleteClientConnectorService(com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClientConnectorServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * ## API Overview
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * ## Data Model
   * The ClientConnectorServicesService exposes the following resources:
   * * Client Connector Services, named as follows:
   *   `projects/{project_id}/locations/{location_id}/client_connector_services/{client_connector_service_id}`.
   * </pre>
   */
  public static final class ClientConnectorServicesServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ClientConnectorServicesServiceFutureStub> {
    private ClientConnectorServicesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientConnectorServicesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientConnectorServicesServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists ClientConnectorServices in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse> listClientConnectorServices(
        com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClientConnectorServicesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single ClientConnectorService.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService> getClientConnectorService(
        com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClientConnectorServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new ClientConnectorService in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createClientConnectorService(
        com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClientConnectorServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single ClientConnectorService.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateClientConnectorService(
        com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClientConnectorServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single ClientConnectorService.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteClientConnectorService(
        com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClientConnectorServiceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CLIENT_CONNECTOR_SERVICES = 0;
  private static final int METHODID_GET_CLIENT_CONNECTOR_SERVICE = 1;
  private static final int METHODID_CREATE_CLIENT_CONNECTOR_SERVICE = 2;
  private static final int METHODID_UPDATE_CLIENT_CONNECTOR_SERVICE = 3;
  private static final int METHODID_DELETE_CLIENT_CONNECTOR_SERVICE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientConnectorServicesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientConnectorServicesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CLIENT_CONNECTOR_SERVICES:
          serviceImpl.listClientConnectorServices((com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse>) responseObserver);
          break;
        case METHODID_GET_CLIENT_CONNECTOR_SERVICE:
          serviceImpl.getClientConnectorService((com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService>) responseObserver);
          break;
        case METHODID_CREATE_CLIENT_CONNECTOR_SERVICE:
          serviceImpl.createClientConnectorService((com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLIENT_CONNECTOR_SERVICE:
          serviceImpl.updateClientConnectorService((com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLIENT_CONNECTOR_SERVICE:
          serviceImpl.deleteClientConnectorService((com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest) request,
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

  private static abstract class ClientConnectorServicesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientConnectorServicesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientConnectorServicesService");
    }
  }

  private static final class ClientConnectorServicesServiceFileDescriptorSupplier
      extends ClientConnectorServicesServiceBaseDescriptorSupplier {
    ClientConnectorServicesServiceFileDescriptorSupplier() {}
  }

  private static final class ClientConnectorServicesServiceMethodDescriptorSupplier
      extends ClientConnectorServicesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientConnectorServicesServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClientConnectorServicesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientConnectorServicesServiceFileDescriptorSupplier())
              .addMethod(getListClientConnectorServicesMethod())
              .addMethod(getGetClientConnectorServiceMethod())
              .addMethod(getCreateClientConnectorServiceMethod())
              .addMethod(getUpdateClientConnectorServiceMethod())
              .addMethod(getDeleteClientConnectorServiceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
