package com.google.cloud.beyondcorp.clientgateways.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * API Overview:
 * The `beyondcorp.googleapis.com` service implements the Google Cloud
 * BeyondCorp API.
 * Data Model:
 * The ClientGatewaysService exposes the following resources:
 * * Client Gateways, named as follows:
 *   `projects/{project_id}/locations/{location_id}/clientGateways/{client_gateway_id}`.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/beyondcorp/clientgateways/v1/client_gateways_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ClientGatewaysServiceGrpc {

  private ClientGatewaysServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.beyondcorp.clientgateways.v1.ClientGatewaysService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysRequest,
      com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysResponse> getListClientGatewaysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClientGateways",
      requestType = com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysRequest.class,
      responseType = com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysRequest,
      com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysResponse> getListClientGatewaysMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysRequest, com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysResponse> getListClientGatewaysMethod;
    if ((getListClientGatewaysMethod = ClientGatewaysServiceGrpc.getListClientGatewaysMethod) == null) {
      synchronized (ClientGatewaysServiceGrpc.class) {
        if ((getListClientGatewaysMethod = ClientGatewaysServiceGrpc.getListClientGatewaysMethod) == null) {
          ClientGatewaysServiceGrpc.getListClientGatewaysMethod = getListClientGatewaysMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysRequest, com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClientGateways"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ClientGatewaysServiceMethodDescriptorSupplier("ListClientGateways"))
              .build();
        }
      }
    }
    return getListClientGatewaysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientgateways.v1.GetClientGatewayRequest,
      com.google.cloud.beyondcorp.clientgateways.v1.ClientGateway> getGetClientGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetClientGateway",
      requestType = com.google.cloud.beyondcorp.clientgateways.v1.GetClientGatewayRequest.class,
      responseType = com.google.cloud.beyondcorp.clientgateways.v1.ClientGateway.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientgateways.v1.GetClientGatewayRequest,
      com.google.cloud.beyondcorp.clientgateways.v1.ClientGateway> getGetClientGatewayMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientgateways.v1.GetClientGatewayRequest, com.google.cloud.beyondcorp.clientgateways.v1.ClientGateway> getGetClientGatewayMethod;
    if ((getGetClientGatewayMethod = ClientGatewaysServiceGrpc.getGetClientGatewayMethod) == null) {
      synchronized (ClientGatewaysServiceGrpc.class) {
        if ((getGetClientGatewayMethod = ClientGatewaysServiceGrpc.getGetClientGatewayMethod) == null) {
          ClientGatewaysServiceGrpc.getGetClientGatewayMethod = getGetClientGatewayMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.clientgateways.v1.GetClientGatewayRequest, com.google.cloud.beyondcorp.clientgateways.v1.ClientGateway>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetClientGateway"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.clientgateways.v1.GetClientGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.clientgateways.v1.ClientGateway.getDefaultInstance()))
              .setSchemaDescriptor(new ClientGatewaysServiceMethodDescriptorSupplier("GetClientGateway"))
              .build();
        }
      }
    }
    return getGetClientGatewayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientgateways.v1.CreateClientGatewayRequest,
      com.google.longrunning.Operation> getCreateClientGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateClientGateway",
      requestType = com.google.cloud.beyondcorp.clientgateways.v1.CreateClientGatewayRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientgateways.v1.CreateClientGatewayRequest,
      com.google.longrunning.Operation> getCreateClientGatewayMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientgateways.v1.CreateClientGatewayRequest, com.google.longrunning.Operation> getCreateClientGatewayMethod;
    if ((getCreateClientGatewayMethod = ClientGatewaysServiceGrpc.getCreateClientGatewayMethod) == null) {
      synchronized (ClientGatewaysServiceGrpc.class) {
        if ((getCreateClientGatewayMethod = ClientGatewaysServiceGrpc.getCreateClientGatewayMethod) == null) {
          ClientGatewaysServiceGrpc.getCreateClientGatewayMethod = getCreateClientGatewayMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.clientgateways.v1.CreateClientGatewayRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateClientGateway"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.clientgateways.v1.CreateClientGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ClientGatewaysServiceMethodDescriptorSupplier("CreateClientGateway"))
              .build();
        }
      }
    }
    return getCreateClientGatewayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest,
      com.google.longrunning.Operation> getDeleteClientGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteClientGateway",
      requestType = com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest,
      com.google.longrunning.Operation> getDeleteClientGatewayMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest, com.google.longrunning.Operation> getDeleteClientGatewayMethod;
    if ((getDeleteClientGatewayMethod = ClientGatewaysServiceGrpc.getDeleteClientGatewayMethod) == null) {
      synchronized (ClientGatewaysServiceGrpc.class) {
        if ((getDeleteClientGatewayMethod = ClientGatewaysServiceGrpc.getDeleteClientGatewayMethod) == null) {
          ClientGatewaysServiceGrpc.getDeleteClientGatewayMethod = getDeleteClientGatewayMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteClientGateway"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ClientGatewaysServiceMethodDescriptorSupplier("DeleteClientGateway"))
              .build();
        }
      }
    }
    return getDeleteClientGatewayMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientGatewaysServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientGatewaysServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientGatewaysServiceStub>() {
        @java.lang.Override
        public ClientGatewaysServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientGatewaysServiceStub(channel, callOptions);
        }
      };
    return ClientGatewaysServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientGatewaysServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientGatewaysServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientGatewaysServiceBlockingStub>() {
        @java.lang.Override
        public ClientGatewaysServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientGatewaysServiceBlockingStub(channel, callOptions);
        }
      };
    return ClientGatewaysServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientGatewaysServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientGatewaysServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientGatewaysServiceFutureStub>() {
        @java.lang.Override
        public ClientGatewaysServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientGatewaysServiceFutureStub(channel, callOptions);
        }
      };
    return ClientGatewaysServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * API Overview:
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * Data Model:
   * The ClientGatewaysService exposes the following resources:
   * * Client Gateways, named as follows:
   *   `projects/{project_id}/locations/{location_id}/clientGateways/{client_gateway_id}`.
   * </pre>
   */
  public static abstract class ClientGatewaysServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists ClientGateways in a given project and location.
     * </pre>
     */
    public void listClientGateways(com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListClientGatewaysMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single ClientGateway.
     * </pre>
     */
    public void getClientGateway(com.google.cloud.beyondcorp.clientgateways.v1.GetClientGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.clientgateways.v1.ClientGateway> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClientGatewayMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new ClientGateway in a given project and location.
     * </pre>
     */
    public void createClientGateway(com.google.cloud.beyondcorp.clientgateways.v1.CreateClientGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateClientGatewayMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single ClientGateway.
     * </pre>
     */
    public void deleteClientGateway(com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteClientGatewayMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListClientGatewaysMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysRequest,
                com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysResponse>(
                  this, METHODID_LIST_CLIENT_GATEWAYS)))
          .addMethod(
            getGetClientGatewayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.clientgateways.v1.GetClientGatewayRequest,
                com.google.cloud.beyondcorp.clientgateways.v1.ClientGateway>(
                  this, METHODID_GET_CLIENT_GATEWAY)))
          .addMethod(
            getCreateClientGatewayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.clientgateways.v1.CreateClientGatewayRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CLIENT_GATEWAY)))
          .addMethod(
            getDeleteClientGatewayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_CLIENT_GATEWAY)))
          .build();
    }
  }

  /**
   * <pre>
   * API Overview:
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * Data Model:
   * The ClientGatewaysService exposes the following resources:
   * * Client Gateways, named as follows:
   *   `projects/{project_id}/locations/{location_id}/clientGateways/{client_gateway_id}`.
   * </pre>
   */
  public static final class ClientGatewaysServiceStub extends io.grpc.stub.AbstractAsyncStub<ClientGatewaysServiceStub> {
    private ClientGatewaysServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientGatewaysServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientGatewaysServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists ClientGateways in a given project and location.
     * </pre>
     */
    public void listClientGateways(com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListClientGatewaysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single ClientGateway.
     * </pre>
     */
    public void getClientGateway(com.google.cloud.beyondcorp.clientgateways.v1.GetClientGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.clientgateways.v1.ClientGateway> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClientGatewayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new ClientGateway in a given project and location.
     * </pre>
     */
    public void createClientGateway(com.google.cloud.beyondcorp.clientgateways.v1.CreateClientGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClientGatewayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single ClientGateway.
     * </pre>
     */
    public void deleteClientGateway(com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteClientGatewayMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * API Overview:
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * Data Model:
   * The ClientGatewaysService exposes the following resources:
   * * Client Gateways, named as follows:
   *   `projects/{project_id}/locations/{location_id}/clientGateways/{client_gateway_id}`.
   * </pre>
   */
  public static final class ClientGatewaysServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ClientGatewaysServiceBlockingStub> {
    private ClientGatewaysServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientGatewaysServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientGatewaysServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists ClientGateways in a given project and location.
     * </pre>
     */
    public com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysResponse listClientGateways(com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClientGatewaysMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single ClientGateway.
     * </pre>
     */
    public com.google.cloud.beyondcorp.clientgateways.v1.ClientGateway getClientGateway(com.google.cloud.beyondcorp.clientgateways.v1.GetClientGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClientGatewayMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new ClientGateway in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createClientGateway(com.google.cloud.beyondcorp.clientgateways.v1.CreateClientGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClientGatewayMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single ClientGateway.
     * </pre>
     */
    public com.google.longrunning.Operation deleteClientGateway(com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClientGatewayMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * API Overview:
   * The `beyondcorp.googleapis.com` service implements the Google Cloud
   * BeyondCorp API.
   * Data Model:
   * The ClientGatewaysService exposes the following resources:
   * * Client Gateways, named as follows:
   *   `projects/{project_id}/locations/{location_id}/clientGateways/{client_gateway_id}`.
   * </pre>
   */
  public static final class ClientGatewaysServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ClientGatewaysServiceFutureStub> {
    private ClientGatewaysServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientGatewaysServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientGatewaysServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists ClientGateways in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysResponse> listClientGateways(
        com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClientGatewaysMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single ClientGateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.beyondcorp.clientgateways.v1.ClientGateway> getClientGateway(
        com.google.cloud.beyondcorp.clientgateways.v1.GetClientGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClientGatewayMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new ClientGateway in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createClientGateway(
        com.google.cloud.beyondcorp.clientgateways.v1.CreateClientGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClientGatewayMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single ClientGateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteClientGateway(
        com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClientGatewayMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CLIENT_GATEWAYS = 0;
  private static final int METHODID_GET_CLIENT_GATEWAY = 1;
  private static final int METHODID_CREATE_CLIENT_GATEWAY = 2;
  private static final int METHODID_DELETE_CLIENT_GATEWAY = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientGatewaysServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientGatewaysServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CLIENT_GATEWAYS:
          serviceImpl.listClientGateways((com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.clientgateways.v1.ListClientGatewaysResponse>) responseObserver);
          break;
        case METHODID_GET_CLIENT_GATEWAY:
          serviceImpl.getClientGateway((com.google.cloud.beyondcorp.clientgateways.v1.GetClientGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.beyondcorp.clientgateways.v1.ClientGateway>) responseObserver);
          break;
        case METHODID_CREATE_CLIENT_GATEWAY:
          serviceImpl.createClientGateway((com.google.cloud.beyondcorp.clientgateways.v1.CreateClientGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLIENT_GATEWAY:
          serviceImpl.deleteClientGateway((com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest) request,
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

  private static abstract class ClientGatewaysServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientGatewaysServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.beyondcorp.clientgateways.v1.ClientGatewaysServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientGatewaysService");
    }
  }

  private static final class ClientGatewaysServiceFileDescriptorSupplier
      extends ClientGatewaysServiceBaseDescriptorSupplier {
    ClientGatewaysServiceFileDescriptorSupplier() {}
  }

  private static final class ClientGatewaysServiceMethodDescriptorSupplier
      extends ClientGatewaysServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientGatewaysServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClientGatewaysServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientGatewaysServiceFileDescriptorSupplier())
              .addMethod(getListClientGatewaysMethod())
              .addMethod(getGetClientGatewayMethod())
              .addMethod(getCreateClientGatewayMethod())
              .addMethod(getDeleteClientGatewayMethod())
              .build();
        }
      }
    }
    return result;
  }
}
