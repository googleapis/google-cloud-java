package com.google.cloud.vpcaccess.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Serverless VPC Access API allows users to create and manage connectors for
 * App Engine, Cloud Functions and Cloud Run to have internal connections to
 * Virtual Private Cloud networks.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/vpcaccess/v1/vpc_access.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VpcAccessServiceGrpc {

  private VpcAccessServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.vpcaccess.v1.VpcAccessService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vpcaccess.v1.CreateConnectorRequest,
      com.google.longrunning.Operation> getCreateConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConnector",
      requestType = com.google.cloud.vpcaccess.v1.CreateConnectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vpcaccess.v1.CreateConnectorRequest,
      com.google.longrunning.Operation> getCreateConnectorMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vpcaccess.v1.CreateConnectorRequest, com.google.longrunning.Operation> getCreateConnectorMethod;
    if ((getCreateConnectorMethod = VpcAccessServiceGrpc.getCreateConnectorMethod) == null) {
      synchronized (VpcAccessServiceGrpc.class) {
        if ((getCreateConnectorMethod = VpcAccessServiceGrpc.getCreateConnectorMethod) == null) {
          VpcAccessServiceGrpc.getCreateConnectorMethod = getCreateConnectorMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vpcaccess.v1.CreateConnectorRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConnector"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vpcaccess.v1.CreateConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VpcAccessServiceMethodDescriptorSupplier("CreateConnector"))
              .build();
        }
      }
    }
    return getCreateConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vpcaccess.v1.GetConnectorRequest,
      com.google.cloud.vpcaccess.v1.Connector> getGetConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnector",
      requestType = com.google.cloud.vpcaccess.v1.GetConnectorRequest.class,
      responseType = com.google.cloud.vpcaccess.v1.Connector.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vpcaccess.v1.GetConnectorRequest,
      com.google.cloud.vpcaccess.v1.Connector> getGetConnectorMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vpcaccess.v1.GetConnectorRequest, com.google.cloud.vpcaccess.v1.Connector> getGetConnectorMethod;
    if ((getGetConnectorMethod = VpcAccessServiceGrpc.getGetConnectorMethod) == null) {
      synchronized (VpcAccessServiceGrpc.class) {
        if ((getGetConnectorMethod = VpcAccessServiceGrpc.getGetConnectorMethod) == null) {
          VpcAccessServiceGrpc.getGetConnectorMethod = getGetConnectorMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vpcaccess.v1.GetConnectorRequest, com.google.cloud.vpcaccess.v1.Connector>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConnector"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vpcaccess.v1.GetConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vpcaccess.v1.Connector.getDefaultInstance()))
              .setSchemaDescriptor(new VpcAccessServiceMethodDescriptorSupplier("GetConnector"))
              .build();
        }
      }
    }
    return getGetConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vpcaccess.v1.ListConnectorsRequest,
      com.google.cloud.vpcaccess.v1.ListConnectorsResponse> getListConnectorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConnectors",
      requestType = com.google.cloud.vpcaccess.v1.ListConnectorsRequest.class,
      responseType = com.google.cloud.vpcaccess.v1.ListConnectorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vpcaccess.v1.ListConnectorsRequest,
      com.google.cloud.vpcaccess.v1.ListConnectorsResponse> getListConnectorsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vpcaccess.v1.ListConnectorsRequest, com.google.cloud.vpcaccess.v1.ListConnectorsResponse> getListConnectorsMethod;
    if ((getListConnectorsMethod = VpcAccessServiceGrpc.getListConnectorsMethod) == null) {
      synchronized (VpcAccessServiceGrpc.class) {
        if ((getListConnectorsMethod = VpcAccessServiceGrpc.getListConnectorsMethod) == null) {
          VpcAccessServiceGrpc.getListConnectorsMethod = getListConnectorsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vpcaccess.v1.ListConnectorsRequest, com.google.cloud.vpcaccess.v1.ListConnectorsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConnectors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vpcaccess.v1.ListConnectorsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vpcaccess.v1.ListConnectorsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VpcAccessServiceMethodDescriptorSupplier("ListConnectors"))
              .build();
        }
      }
    }
    return getListConnectorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vpcaccess.v1.DeleteConnectorRequest,
      com.google.longrunning.Operation> getDeleteConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConnector",
      requestType = com.google.cloud.vpcaccess.v1.DeleteConnectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vpcaccess.v1.DeleteConnectorRequest,
      com.google.longrunning.Operation> getDeleteConnectorMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vpcaccess.v1.DeleteConnectorRequest, com.google.longrunning.Operation> getDeleteConnectorMethod;
    if ((getDeleteConnectorMethod = VpcAccessServiceGrpc.getDeleteConnectorMethod) == null) {
      synchronized (VpcAccessServiceGrpc.class) {
        if ((getDeleteConnectorMethod = VpcAccessServiceGrpc.getDeleteConnectorMethod) == null) {
          VpcAccessServiceGrpc.getDeleteConnectorMethod = getDeleteConnectorMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vpcaccess.v1.DeleteConnectorRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConnector"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vpcaccess.v1.DeleteConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VpcAccessServiceMethodDescriptorSupplier("DeleteConnector"))
              .build();
        }
      }
    }
    return getDeleteConnectorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VpcAccessServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VpcAccessServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VpcAccessServiceStub>() {
        @java.lang.Override
        public VpcAccessServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VpcAccessServiceStub(channel, callOptions);
        }
      };
    return VpcAccessServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VpcAccessServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VpcAccessServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VpcAccessServiceBlockingStub>() {
        @java.lang.Override
        public VpcAccessServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VpcAccessServiceBlockingStub(channel, callOptions);
        }
      };
    return VpcAccessServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VpcAccessServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VpcAccessServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VpcAccessServiceFutureStub>() {
        @java.lang.Override
        public VpcAccessServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VpcAccessServiceFutureStub(channel, callOptions);
        }
      };
    return VpcAccessServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Serverless VPC Access API allows users to create and manage connectors for
   * App Engine, Cloud Functions and Cloud Run to have internal connections to
   * Virtual Private Cloud networks.
   * </pre>
   */
  public static abstract class VpcAccessServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a Serverless VPC Access connector, returns an operation.
     * </pre>
     */
    public void createConnector(com.google.cloud.vpcaccess.v1.CreateConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateConnectorMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a Serverless VPC Access connector. Returns NOT_FOUND if the resource
     * does not exist.
     * </pre>
     */
    public void getConnector(com.google.cloud.vpcaccess.v1.GetConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vpcaccess.v1.Connector> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetConnectorMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Serverless VPC Access connectors.
     * </pre>
     */
    public void listConnectors(com.google.cloud.vpcaccess.v1.ListConnectorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vpcaccess.v1.ListConnectorsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListConnectorsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a Serverless VPC Access connector. Returns NOT_FOUND if the
     * resource does not exist.
     * </pre>
     */
    public void deleteConnector(com.google.cloud.vpcaccess.v1.DeleteConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteConnectorMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vpcaccess.v1.CreateConnectorRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CONNECTOR)))
          .addMethod(
            getGetConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vpcaccess.v1.GetConnectorRequest,
                com.google.cloud.vpcaccess.v1.Connector>(
                  this, METHODID_GET_CONNECTOR)))
          .addMethod(
            getListConnectorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vpcaccess.v1.ListConnectorsRequest,
                com.google.cloud.vpcaccess.v1.ListConnectorsResponse>(
                  this, METHODID_LIST_CONNECTORS)))
          .addMethod(
            getDeleteConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vpcaccess.v1.DeleteConnectorRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_CONNECTOR)))
          .build();
    }
  }

  /**
   * <pre>
   * Serverless VPC Access API allows users to create and manage connectors for
   * App Engine, Cloud Functions and Cloud Run to have internal connections to
   * Virtual Private Cloud networks.
   * </pre>
   */
  public static final class VpcAccessServiceStub extends io.grpc.stub.AbstractAsyncStub<VpcAccessServiceStub> {
    private VpcAccessServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VpcAccessServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VpcAccessServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Serverless VPC Access connector, returns an operation.
     * </pre>
     */
    public void createConnector(com.google.cloud.vpcaccess.v1.CreateConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConnectorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a Serverless VPC Access connector. Returns NOT_FOUND if the resource
     * does not exist.
     * </pre>
     */
    public void getConnector(com.google.cloud.vpcaccess.v1.GetConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vpcaccess.v1.Connector> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConnectorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Serverless VPC Access connectors.
     * </pre>
     */
    public void listConnectors(com.google.cloud.vpcaccess.v1.ListConnectorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vpcaccess.v1.ListConnectorsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConnectorsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a Serverless VPC Access connector. Returns NOT_FOUND if the
     * resource does not exist.
     * </pre>
     */
    public void deleteConnector(com.google.cloud.vpcaccess.v1.DeleteConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConnectorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Serverless VPC Access API allows users to create and manage connectors for
   * App Engine, Cloud Functions and Cloud Run to have internal connections to
   * Virtual Private Cloud networks.
   * </pre>
   */
  public static final class VpcAccessServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<VpcAccessServiceBlockingStub> {
    private VpcAccessServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VpcAccessServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VpcAccessServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Serverless VPC Access connector, returns an operation.
     * </pre>
     */
    public com.google.longrunning.Operation createConnector(com.google.cloud.vpcaccess.v1.CreateConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConnectorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a Serverless VPC Access connector. Returns NOT_FOUND if the resource
     * does not exist.
     * </pre>
     */
    public com.google.cloud.vpcaccess.v1.Connector getConnector(com.google.cloud.vpcaccess.v1.GetConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Serverless VPC Access connectors.
     * </pre>
     */
    public com.google.cloud.vpcaccess.v1.ListConnectorsResponse listConnectors(com.google.cloud.vpcaccess.v1.ListConnectorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectorsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a Serverless VPC Access connector. Returns NOT_FOUND if the
     * resource does not exist.
     * </pre>
     */
    public com.google.longrunning.Operation deleteConnector(com.google.cloud.vpcaccess.v1.DeleteConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConnectorMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Serverless VPC Access API allows users to create and manage connectors for
   * App Engine, Cloud Functions and Cloud Run to have internal connections to
   * Virtual Private Cloud networks.
   * </pre>
   */
  public static final class VpcAccessServiceFutureStub extends io.grpc.stub.AbstractFutureStub<VpcAccessServiceFutureStub> {
    private VpcAccessServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VpcAccessServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VpcAccessServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Serverless VPC Access connector, returns an operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createConnector(
        com.google.cloud.vpcaccess.v1.CreateConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConnectorMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a Serverless VPC Access connector. Returns NOT_FOUND if the resource
     * does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vpcaccess.v1.Connector> getConnector(
        com.google.cloud.vpcaccess.v1.GetConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConnectorMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Serverless VPC Access connectors.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vpcaccess.v1.ListConnectorsResponse> listConnectors(
        com.google.cloud.vpcaccess.v1.ListConnectorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConnectorsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a Serverless VPC Access connector. Returns NOT_FOUND if the
     * resource does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteConnector(
        com.google.cloud.vpcaccess.v1.DeleteConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConnectorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CONNECTOR = 0;
  private static final int METHODID_GET_CONNECTOR = 1;
  private static final int METHODID_LIST_CONNECTORS = 2;
  private static final int METHODID_DELETE_CONNECTOR = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VpcAccessServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VpcAccessServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CONNECTOR:
          serviceImpl.createConnector((com.google.cloud.vpcaccess.v1.CreateConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CONNECTOR:
          serviceImpl.getConnector((com.google.cloud.vpcaccess.v1.GetConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vpcaccess.v1.Connector>) responseObserver);
          break;
        case METHODID_LIST_CONNECTORS:
          serviceImpl.listConnectors((com.google.cloud.vpcaccess.v1.ListConnectorsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vpcaccess.v1.ListConnectorsResponse>) responseObserver);
          break;
        case METHODID_DELETE_CONNECTOR:
          serviceImpl.deleteConnector((com.google.cloud.vpcaccess.v1.DeleteConnectorRequest) request,
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

  private static abstract class VpcAccessServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VpcAccessServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.vpcaccess.v1.VpcAccessProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VpcAccessService");
    }
  }

  private static final class VpcAccessServiceFileDescriptorSupplier
      extends VpcAccessServiceBaseDescriptorSupplier {
    VpcAccessServiceFileDescriptorSupplier() {}
  }

  private static final class VpcAccessServiceMethodDescriptorSupplier
      extends VpcAccessServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VpcAccessServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (VpcAccessServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VpcAccessServiceFileDescriptorSupplier())
              .addMethod(getCreateConnectorMethod())
              .addMethod(getGetConnectorMethod())
              .addMethod(getListConnectorsMethod())
              .addMethod(getDeleteConnectorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
