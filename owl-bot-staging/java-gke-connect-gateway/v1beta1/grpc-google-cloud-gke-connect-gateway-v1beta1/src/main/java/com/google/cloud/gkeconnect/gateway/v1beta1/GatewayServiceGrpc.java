package com.google.cloud.gkeconnect.gateway.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Gateway service is a public API which works as a Kubernetes resource model
 * proxy between end users and registered Kubernetes clusters. Each RPC in this
 * service matches with an HTTP verb. End user will initiate kubectl commands
 * against the Gateway service, and Gateway service will forward user requests
 * to clusters.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gkeconnect/gateway/v1beta1/gateway.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GatewayServiceGrpc {

  private GatewayServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gkeconnect.gateway.v1beta1.GatewayService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.api.HttpBody,
      com.google.api.HttpBody> getGetResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetResource",
      requestType = com.google.api.HttpBody.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.HttpBody,
      com.google.api.HttpBody> getGetResourceMethod() {
    io.grpc.MethodDescriptor<com.google.api.HttpBody, com.google.api.HttpBody> getGetResourceMethod;
    if ((getGetResourceMethod = GatewayServiceGrpc.getGetResourceMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getGetResourceMethod = GatewayServiceGrpc.getGetResourceMethod) == null) {
          GatewayServiceGrpc.getGetResourceMethod = getGetResourceMethod =
              io.grpc.MethodDescriptor.<com.google.api.HttpBody, com.google.api.HttpBody>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetResource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.HttpBody.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.HttpBody.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("GetResource"))
              .build();
        }
      }
    }
    return getGetResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.HttpBody,
      com.google.api.HttpBody> getPostResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PostResource",
      requestType = com.google.api.HttpBody.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.HttpBody,
      com.google.api.HttpBody> getPostResourceMethod() {
    io.grpc.MethodDescriptor<com.google.api.HttpBody, com.google.api.HttpBody> getPostResourceMethod;
    if ((getPostResourceMethod = GatewayServiceGrpc.getPostResourceMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getPostResourceMethod = GatewayServiceGrpc.getPostResourceMethod) == null) {
          GatewayServiceGrpc.getPostResourceMethod = getPostResourceMethod =
              io.grpc.MethodDescriptor.<com.google.api.HttpBody, com.google.api.HttpBody>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PostResource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.HttpBody.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.HttpBody.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("PostResource"))
              .build();
        }
      }
    }
    return getPostResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.HttpBody,
      com.google.api.HttpBody> getDeleteResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteResource",
      requestType = com.google.api.HttpBody.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.HttpBody,
      com.google.api.HttpBody> getDeleteResourceMethod() {
    io.grpc.MethodDescriptor<com.google.api.HttpBody, com.google.api.HttpBody> getDeleteResourceMethod;
    if ((getDeleteResourceMethod = GatewayServiceGrpc.getDeleteResourceMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getDeleteResourceMethod = GatewayServiceGrpc.getDeleteResourceMethod) == null) {
          GatewayServiceGrpc.getDeleteResourceMethod = getDeleteResourceMethod =
              io.grpc.MethodDescriptor.<com.google.api.HttpBody, com.google.api.HttpBody>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteResource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.HttpBody.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.HttpBody.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("DeleteResource"))
              .build();
        }
      }
    }
    return getDeleteResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.HttpBody,
      com.google.api.HttpBody> getPutResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PutResource",
      requestType = com.google.api.HttpBody.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.HttpBody,
      com.google.api.HttpBody> getPutResourceMethod() {
    io.grpc.MethodDescriptor<com.google.api.HttpBody, com.google.api.HttpBody> getPutResourceMethod;
    if ((getPutResourceMethod = GatewayServiceGrpc.getPutResourceMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getPutResourceMethod = GatewayServiceGrpc.getPutResourceMethod) == null) {
          GatewayServiceGrpc.getPutResourceMethod = getPutResourceMethod =
              io.grpc.MethodDescriptor.<com.google.api.HttpBody, com.google.api.HttpBody>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PutResource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.HttpBody.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.HttpBody.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("PutResource"))
              .build();
        }
      }
    }
    return getPutResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.HttpBody,
      com.google.api.HttpBody> getPatchResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PatchResource",
      requestType = com.google.api.HttpBody.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.HttpBody,
      com.google.api.HttpBody> getPatchResourceMethod() {
    io.grpc.MethodDescriptor<com.google.api.HttpBody, com.google.api.HttpBody> getPatchResourceMethod;
    if ((getPatchResourceMethod = GatewayServiceGrpc.getPatchResourceMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getPatchResourceMethod = GatewayServiceGrpc.getPatchResourceMethod) == null) {
          GatewayServiceGrpc.getPatchResourceMethod = getPatchResourceMethod =
              io.grpc.MethodDescriptor.<com.google.api.HttpBody, com.google.api.HttpBody>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PatchResource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.HttpBody.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.HttpBody.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("PatchResource"))
              .build();
        }
      }
    }
    return getPatchResourceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GatewayServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GatewayServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GatewayServiceStub>() {
        @java.lang.Override
        public GatewayServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GatewayServiceStub(channel, callOptions);
        }
      };
    return GatewayServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GatewayServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GatewayServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GatewayServiceBlockingStub>() {
        @java.lang.Override
        public GatewayServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GatewayServiceBlockingStub(channel, callOptions);
        }
      };
    return GatewayServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GatewayServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GatewayServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GatewayServiceFutureStub>() {
        @java.lang.Override
        public GatewayServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GatewayServiceFutureStub(channel, callOptions);
        }
      };
    return GatewayServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Gateway service is a public API which works as a Kubernetes resource model
   * proxy between end users and registered Kubernetes clusters. Each RPC in this
   * service matches with an HTTP verb. End user will initiate kubectl commands
   * against the Gateway service, and Gateway service will forward user requests
   * to clusters.
   * </pre>
   */
  public static abstract class GatewayServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * GetResource performs an HTTP GET request on the Kubernetes API Server.
     * </pre>
     */
    public void getResource(com.google.api.HttpBody request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetResourceMethod(), responseObserver);
    }

    /**
     * <pre>
     * PostResource performs an HTTP POST on the Kubernetes API Server.
     * </pre>
     */
    public void postResource(com.google.api.HttpBody request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPostResourceMethod(), responseObserver);
    }

    /**
     * <pre>
     * DeleteResource performs an HTTP DELETE on the Kubernetes API Server.
     * </pre>
     */
    public void deleteResource(com.google.api.HttpBody request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteResourceMethod(), responseObserver);
    }

    /**
     * <pre>
     * PutResource performs an HTTP PUT on the Kubernetes API Server.
     * </pre>
     */
    public void putResource(com.google.api.HttpBody request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPutResourceMethod(), responseObserver);
    }

    /**
     * <pre>
     * PatchResource performs an HTTP PATCH on the Kubernetes API Server.
     * </pre>
     */
    public void patchResource(com.google.api.HttpBody request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPatchResourceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.HttpBody,
                com.google.api.HttpBody>(
                  this, METHODID_GET_RESOURCE)))
          .addMethod(
            getPostResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.HttpBody,
                com.google.api.HttpBody>(
                  this, METHODID_POST_RESOURCE)))
          .addMethod(
            getDeleteResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.HttpBody,
                com.google.api.HttpBody>(
                  this, METHODID_DELETE_RESOURCE)))
          .addMethod(
            getPutResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.HttpBody,
                com.google.api.HttpBody>(
                  this, METHODID_PUT_RESOURCE)))
          .addMethod(
            getPatchResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.HttpBody,
                com.google.api.HttpBody>(
                  this, METHODID_PATCH_RESOURCE)))
          .build();
    }
  }

  /**
   * <pre>
   * Gateway service is a public API which works as a Kubernetes resource model
   * proxy between end users and registered Kubernetes clusters. Each RPC in this
   * service matches with an HTTP verb. End user will initiate kubectl commands
   * against the Gateway service, and Gateway service will forward user requests
   * to clusters.
   * </pre>
   */
  public static final class GatewayServiceStub extends io.grpc.stub.AbstractAsyncStub<GatewayServiceStub> {
    private GatewayServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GatewayServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GatewayServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * GetResource performs an HTTP GET request on the Kubernetes API Server.
     * </pre>
     */
    public void getResource(com.google.api.HttpBody request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetResourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * PostResource performs an HTTP POST on the Kubernetes API Server.
     * </pre>
     */
    public void postResource(com.google.api.HttpBody request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPostResourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * DeleteResource performs an HTTP DELETE on the Kubernetes API Server.
     * </pre>
     */
    public void deleteResource(com.google.api.HttpBody request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteResourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * PutResource performs an HTTP PUT on the Kubernetes API Server.
     * </pre>
     */
    public void putResource(com.google.api.HttpBody request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPutResourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * PatchResource performs an HTTP PATCH on the Kubernetes API Server.
     * </pre>
     */
    public void patchResource(com.google.api.HttpBody request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPatchResourceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Gateway service is a public API which works as a Kubernetes resource model
   * proxy between end users and registered Kubernetes clusters. Each RPC in this
   * service matches with an HTTP verb. End user will initiate kubectl commands
   * against the Gateway service, and Gateway service will forward user requests
   * to clusters.
   * </pre>
   */
  public static final class GatewayServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GatewayServiceBlockingStub> {
    private GatewayServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GatewayServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GatewayServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * GetResource performs an HTTP GET request on the Kubernetes API Server.
     * </pre>
     */
    public com.google.api.HttpBody getResource(com.google.api.HttpBody request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetResourceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * PostResource performs an HTTP POST on the Kubernetes API Server.
     * </pre>
     */
    public com.google.api.HttpBody postResource(com.google.api.HttpBody request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPostResourceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * DeleteResource performs an HTTP DELETE on the Kubernetes API Server.
     * </pre>
     */
    public com.google.api.HttpBody deleteResource(com.google.api.HttpBody request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteResourceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * PutResource performs an HTTP PUT on the Kubernetes API Server.
     * </pre>
     */
    public com.google.api.HttpBody putResource(com.google.api.HttpBody request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPutResourceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * PatchResource performs an HTTP PATCH on the Kubernetes API Server.
     * </pre>
     */
    public com.google.api.HttpBody patchResource(com.google.api.HttpBody request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPatchResourceMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Gateway service is a public API which works as a Kubernetes resource model
   * proxy between end users and registered Kubernetes clusters. Each RPC in this
   * service matches with an HTTP verb. End user will initiate kubectl commands
   * against the Gateway service, and Gateway service will forward user requests
   * to clusters.
   * </pre>
   */
  public static final class GatewayServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GatewayServiceFutureStub> {
    private GatewayServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GatewayServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GatewayServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * GetResource performs an HTTP GET request on the Kubernetes API Server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody> getResource(
        com.google.api.HttpBody request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetResourceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * PostResource performs an HTTP POST on the Kubernetes API Server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody> postResource(
        com.google.api.HttpBody request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPostResourceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * DeleteResource performs an HTTP DELETE on the Kubernetes API Server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody> deleteResource(
        com.google.api.HttpBody request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteResourceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * PutResource performs an HTTP PUT on the Kubernetes API Server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody> putResource(
        com.google.api.HttpBody request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPutResourceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * PatchResource performs an HTTP PATCH on the Kubernetes API Server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody> patchResource(
        com.google.api.HttpBody request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPatchResourceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_RESOURCE = 0;
  private static final int METHODID_POST_RESOURCE = 1;
  private static final int METHODID_DELETE_RESOURCE = 2;
  private static final int METHODID_PUT_RESOURCE = 3;
  private static final int METHODID_PATCH_RESOURCE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GatewayServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GatewayServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_RESOURCE:
          serviceImpl.getResource((com.google.api.HttpBody) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
          break;
        case METHODID_POST_RESOURCE:
          serviceImpl.postResource((com.google.api.HttpBody) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
          break;
        case METHODID_DELETE_RESOURCE:
          serviceImpl.deleteResource((com.google.api.HttpBody) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
          break;
        case METHODID_PUT_RESOURCE:
          serviceImpl.putResource((com.google.api.HttpBody) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
          break;
        case METHODID_PATCH_RESOURCE:
          serviceImpl.patchResource((com.google.api.HttpBody) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
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

  private static abstract class GatewayServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GatewayServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gkeconnect.gateway.v1beta1.GatewayProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GatewayService");
    }
  }

  private static final class GatewayServiceFileDescriptorSupplier
      extends GatewayServiceBaseDescriptorSupplier {
    GatewayServiceFileDescriptorSupplier() {}
  }

  private static final class GatewayServiceMethodDescriptorSupplier
      extends GatewayServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GatewayServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GatewayServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GatewayServiceFileDescriptorSupplier())
              .addMethod(getGetResourceMethod())
              .addMethod(getPostResourceMethod())
              .addMethod(getDeleteResourceMethod())
              .addMethod(getPutResourceMethod())
              .addMethod(getPatchResourceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
