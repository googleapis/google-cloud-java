package com.google.cloud.ids.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The IDS Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/ids/v1/ids.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IDSGrpc {

  private IDSGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.ids.v1.IDS";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.ids.v1.ListEndpointsRequest,
      com.google.cloud.ids.v1.ListEndpointsResponse> getListEndpointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEndpoints",
      requestType = com.google.cloud.ids.v1.ListEndpointsRequest.class,
      responseType = com.google.cloud.ids.v1.ListEndpointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.ids.v1.ListEndpointsRequest,
      com.google.cloud.ids.v1.ListEndpointsResponse> getListEndpointsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.ids.v1.ListEndpointsRequest, com.google.cloud.ids.v1.ListEndpointsResponse> getListEndpointsMethod;
    if ((getListEndpointsMethod = IDSGrpc.getListEndpointsMethod) == null) {
      synchronized (IDSGrpc.class) {
        if ((getListEndpointsMethod = IDSGrpc.getListEndpointsMethod) == null) {
          IDSGrpc.getListEndpointsMethod = getListEndpointsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.ids.v1.ListEndpointsRequest, com.google.cloud.ids.v1.ListEndpointsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEndpoints"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.ids.v1.ListEndpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.ids.v1.ListEndpointsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IDSMethodDescriptorSupplier("ListEndpoints"))
              .build();
        }
      }
    }
    return getListEndpointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.ids.v1.GetEndpointRequest,
      com.google.cloud.ids.v1.Endpoint> getGetEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEndpoint",
      requestType = com.google.cloud.ids.v1.GetEndpointRequest.class,
      responseType = com.google.cloud.ids.v1.Endpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.ids.v1.GetEndpointRequest,
      com.google.cloud.ids.v1.Endpoint> getGetEndpointMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.ids.v1.GetEndpointRequest, com.google.cloud.ids.v1.Endpoint> getGetEndpointMethod;
    if ((getGetEndpointMethod = IDSGrpc.getGetEndpointMethod) == null) {
      synchronized (IDSGrpc.class) {
        if ((getGetEndpointMethod = IDSGrpc.getGetEndpointMethod) == null) {
          IDSGrpc.getGetEndpointMethod = getGetEndpointMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.ids.v1.GetEndpointRequest, com.google.cloud.ids.v1.Endpoint>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEndpoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.ids.v1.GetEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.ids.v1.Endpoint.getDefaultInstance()))
              .setSchemaDescriptor(new IDSMethodDescriptorSupplier("GetEndpoint"))
              .build();
        }
      }
    }
    return getGetEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.ids.v1.CreateEndpointRequest,
      com.google.longrunning.Operation> getCreateEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEndpoint",
      requestType = com.google.cloud.ids.v1.CreateEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.ids.v1.CreateEndpointRequest,
      com.google.longrunning.Operation> getCreateEndpointMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.ids.v1.CreateEndpointRequest, com.google.longrunning.Operation> getCreateEndpointMethod;
    if ((getCreateEndpointMethod = IDSGrpc.getCreateEndpointMethod) == null) {
      synchronized (IDSGrpc.class) {
        if ((getCreateEndpointMethod = IDSGrpc.getCreateEndpointMethod) == null) {
          IDSGrpc.getCreateEndpointMethod = getCreateEndpointMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.ids.v1.CreateEndpointRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEndpoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.ids.v1.CreateEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new IDSMethodDescriptorSupplier("CreateEndpoint"))
              .build();
        }
      }
    }
    return getCreateEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.ids.v1.DeleteEndpointRequest,
      com.google.longrunning.Operation> getDeleteEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEndpoint",
      requestType = com.google.cloud.ids.v1.DeleteEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.ids.v1.DeleteEndpointRequest,
      com.google.longrunning.Operation> getDeleteEndpointMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.ids.v1.DeleteEndpointRequest, com.google.longrunning.Operation> getDeleteEndpointMethod;
    if ((getDeleteEndpointMethod = IDSGrpc.getDeleteEndpointMethod) == null) {
      synchronized (IDSGrpc.class) {
        if ((getDeleteEndpointMethod = IDSGrpc.getDeleteEndpointMethod) == null) {
          IDSGrpc.getDeleteEndpointMethod = getDeleteEndpointMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.ids.v1.DeleteEndpointRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEndpoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.ids.v1.DeleteEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new IDSMethodDescriptorSupplier("DeleteEndpoint"))
              .build();
        }
      }
    }
    return getDeleteEndpointMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IDSStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IDSStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IDSStub>() {
        @java.lang.Override
        public IDSStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IDSStub(channel, callOptions);
        }
      };
    return IDSStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IDSBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IDSBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IDSBlockingStub>() {
        @java.lang.Override
        public IDSBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IDSBlockingStub(channel, callOptions);
        }
      };
    return IDSBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IDSFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IDSFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IDSFutureStub>() {
        @java.lang.Override
        public IDSFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IDSFutureStub(channel, callOptions);
        }
      };
    return IDSFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The IDS Service
   * </pre>
   */
  public static abstract class IDSImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists Endpoints in a given project and location.
     * </pre>
     */
    public void listEndpoints(com.google.cloud.ids.v1.ListEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ids.v1.ListEndpointsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEndpointsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Endpoint.
     * </pre>
     */
    public void getEndpoint(com.google.cloud.ids.v1.GetEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ids.v1.Endpoint> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEndpointMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Endpoint in a given project and location.
     * </pre>
     */
    public void createEndpoint(com.google.cloud.ids.v1.CreateEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateEndpointMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Endpoint.
     * </pre>
     */
    public void deleteEndpoint(com.google.cloud.ids.v1.DeleteEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteEndpointMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListEndpointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.ids.v1.ListEndpointsRequest,
                com.google.cloud.ids.v1.ListEndpointsResponse>(
                  this, METHODID_LIST_ENDPOINTS)))
          .addMethod(
            getGetEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.ids.v1.GetEndpointRequest,
                com.google.cloud.ids.v1.Endpoint>(
                  this, METHODID_GET_ENDPOINT)))
          .addMethod(
            getCreateEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.ids.v1.CreateEndpointRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_ENDPOINT)))
          .addMethod(
            getDeleteEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.ids.v1.DeleteEndpointRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_ENDPOINT)))
          .build();
    }
  }

  /**
   * <pre>
   * The IDS Service
   * </pre>
   */
  public static final class IDSStub extends io.grpc.stub.AbstractAsyncStub<IDSStub> {
    private IDSStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IDSStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IDSStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Endpoints in a given project and location.
     * </pre>
     */
    public void listEndpoints(com.google.cloud.ids.v1.ListEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ids.v1.ListEndpointsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEndpointsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Endpoint.
     * </pre>
     */
    public void getEndpoint(com.google.cloud.ids.v1.GetEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ids.v1.Endpoint> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEndpointMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Endpoint in a given project and location.
     * </pre>
     */
    public void createEndpoint(com.google.cloud.ids.v1.CreateEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEndpointMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Endpoint.
     * </pre>
     */
    public void deleteEndpoint(com.google.cloud.ids.v1.DeleteEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEndpointMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The IDS Service
   * </pre>
   */
  public static final class IDSBlockingStub extends io.grpc.stub.AbstractBlockingStub<IDSBlockingStub> {
    private IDSBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IDSBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IDSBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Endpoints in a given project and location.
     * </pre>
     */
    public com.google.cloud.ids.v1.ListEndpointsResponse listEndpoints(com.google.cloud.ids.v1.ListEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEndpointsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Endpoint.
     * </pre>
     */
    public com.google.cloud.ids.v1.Endpoint getEndpoint(com.google.cloud.ids.v1.GetEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEndpointMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Endpoint in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createEndpoint(com.google.cloud.ids.v1.CreateEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEndpointMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single Endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEndpoint(com.google.cloud.ids.v1.DeleteEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEndpointMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The IDS Service
   * </pre>
   */
  public static final class IDSFutureStub extends io.grpc.stub.AbstractFutureStub<IDSFutureStub> {
    private IDSFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IDSFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IDSFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Endpoints in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ids.v1.ListEndpointsResponse> listEndpoints(
        com.google.cloud.ids.v1.ListEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEndpointsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.ids.v1.Endpoint> getEndpoint(
        com.google.cloud.ids.v1.GetEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEndpointMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new Endpoint in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createEndpoint(
        com.google.cloud.ids.v1.CreateEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEndpointMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single Endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteEndpoint(
        com.google.cloud.ids.v1.DeleteEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEndpointMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ENDPOINTS = 0;
  private static final int METHODID_GET_ENDPOINT = 1;
  private static final int METHODID_CREATE_ENDPOINT = 2;
  private static final int METHODID_DELETE_ENDPOINT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IDSImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IDSImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ENDPOINTS:
          serviceImpl.listEndpoints((com.google.cloud.ids.v1.ListEndpointsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ids.v1.ListEndpointsResponse>) responseObserver);
          break;
        case METHODID_GET_ENDPOINT:
          serviceImpl.getEndpoint((com.google.cloud.ids.v1.GetEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ids.v1.Endpoint>) responseObserver);
          break;
        case METHODID_CREATE_ENDPOINT:
          serviceImpl.createEndpoint((com.google.cloud.ids.v1.CreateEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENDPOINT:
          serviceImpl.deleteEndpoint((com.google.cloud.ids.v1.DeleteEndpointRequest) request,
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

  private static abstract class IDSBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IDSBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.ids.v1.IdsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IDS");
    }
  }

  private static final class IDSFileDescriptorSupplier
      extends IDSBaseDescriptorSupplier {
    IDSFileDescriptorSupplier() {}
  }

  private static final class IDSMethodDescriptorSupplier
      extends IDSBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IDSMethodDescriptorSupplier(String methodName) {
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
      synchronized (IDSGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IDSFileDescriptorSupplier())
              .addMethod(getListEndpointsMethod())
              .addMethod(getGetEndpointMethod())
              .addMethod(getCreateEndpointMethod())
              .addMethod(getDeleteEndpointMethod())
              .build();
        }
      }
    }
    return result;
  }
}
