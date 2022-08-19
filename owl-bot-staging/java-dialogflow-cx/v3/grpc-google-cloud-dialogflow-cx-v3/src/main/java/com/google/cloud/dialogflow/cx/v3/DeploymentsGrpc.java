package com.google.cloud.dialogflow.cx.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for managing [Deployments][google.cloud.dialogflow.cx.v3.Deployment].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3/deployment.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DeploymentsGrpc {

  private DeploymentsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3.Deployments";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListDeploymentsRequest,
      com.google.cloud.dialogflow.cx.v3.ListDeploymentsResponse> getListDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeployments",
      requestType = com.google.cloud.dialogflow.cx.v3.ListDeploymentsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.ListDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListDeploymentsRequest,
      com.google.cloud.dialogflow.cx.v3.ListDeploymentsResponse> getListDeploymentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListDeploymentsRequest, com.google.cloud.dialogflow.cx.v3.ListDeploymentsResponse> getListDeploymentsMethod;
    if ((getListDeploymentsMethod = DeploymentsGrpc.getListDeploymentsMethod) == null) {
      synchronized (DeploymentsGrpc.class) {
        if ((getListDeploymentsMethod = DeploymentsGrpc.getListDeploymentsMethod) == null) {
          DeploymentsGrpc.getListDeploymentsMethod = getListDeploymentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.ListDeploymentsRequest, com.google.cloud.dialogflow.cx.v3.ListDeploymentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDeployments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.ListDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.ListDeploymentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DeploymentsMethodDescriptorSupplier("ListDeployments"))
              .build();
        }
      }
    }
    return getListDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.GetDeploymentRequest,
      com.google.cloud.dialogflow.cx.v3.Deployment> getGetDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeployment",
      requestType = com.google.cloud.dialogflow.cx.v3.GetDeploymentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.GetDeploymentRequest,
      com.google.cloud.dialogflow.cx.v3.Deployment> getGetDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.GetDeploymentRequest, com.google.cloud.dialogflow.cx.v3.Deployment> getGetDeploymentMethod;
    if ((getGetDeploymentMethod = DeploymentsGrpc.getGetDeploymentMethod) == null) {
      synchronized (DeploymentsGrpc.class) {
        if ((getGetDeploymentMethod = DeploymentsGrpc.getGetDeploymentMethod) == null) {
          DeploymentsGrpc.getGetDeploymentMethod = getGetDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.GetDeploymentRequest, com.google.cloud.dialogflow.cx.v3.Deployment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.GetDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.Deployment.getDefaultInstance()))
              .setSchemaDescriptor(new DeploymentsMethodDescriptorSupplier("GetDeployment"))
              .build();
        }
      }
    }
    return getGetDeploymentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeploymentsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeploymentsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeploymentsStub>() {
        @java.lang.Override
        public DeploymentsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeploymentsStub(channel, callOptions);
        }
      };
    return DeploymentsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeploymentsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeploymentsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeploymentsBlockingStub>() {
        @java.lang.Override
        public DeploymentsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeploymentsBlockingStub(channel, callOptions);
        }
      };
    return DeploymentsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeploymentsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeploymentsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeploymentsFutureStub>() {
        @java.lang.Override
        public DeploymentsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeploymentsFutureStub(channel, callOptions);
        }
      };
    return DeploymentsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for managing [Deployments][google.cloud.dialogflow.cx.v3.Deployment].
   * </pre>
   */
  public static abstract class DeploymentsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns the list of all deployments in the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public void listDeployments(com.google.cloud.dialogflow.cx.v3.ListDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListDeploymentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDeploymentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified [Deployment][google.cloud.dialogflow.cx.v3.Deployment].
     * </pre>
     */
    public void getDeployment(com.google.cloud.dialogflow.cx.v3.GetDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Deployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDeploymentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListDeploymentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.ListDeploymentsRequest,
                com.google.cloud.dialogflow.cx.v3.ListDeploymentsResponse>(
                  this, METHODID_LIST_DEPLOYMENTS)))
          .addMethod(
            getGetDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.GetDeploymentRequest,
                com.google.cloud.dialogflow.cx.v3.Deployment>(
                  this, METHODID_GET_DEPLOYMENT)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for managing [Deployments][google.cloud.dialogflow.cx.v3.Deployment].
   * </pre>
   */
  public static final class DeploymentsStub extends io.grpc.stub.AbstractAsyncStub<DeploymentsStub> {
    private DeploymentsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeploymentsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeploymentsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all deployments in the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public void listDeployments(com.google.cloud.dialogflow.cx.v3.ListDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListDeploymentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeploymentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified [Deployment][google.cloud.dialogflow.cx.v3.Deployment].
     * </pre>
     */
    public void getDeployment(com.google.cloud.dialogflow.cx.v3.GetDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Deployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDeploymentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service for managing [Deployments][google.cloud.dialogflow.cx.v3.Deployment].
   * </pre>
   */
  public static final class DeploymentsBlockingStub extends io.grpc.stub.AbstractBlockingStub<DeploymentsBlockingStub> {
    private DeploymentsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeploymentsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeploymentsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all deployments in the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.ListDeploymentsResponse listDeployments(com.google.cloud.dialogflow.cx.v3.ListDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the specified [Deployment][google.cloud.dialogflow.cx.v3.Deployment].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Deployment getDeployment(com.google.cloud.dialogflow.cx.v3.GetDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeploymentMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service for managing [Deployments][google.cloud.dialogflow.cx.v3.Deployment].
   * </pre>
   */
  public static final class DeploymentsFutureStub extends io.grpc.stub.AbstractFutureStub<DeploymentsFutureStub> {
    private DeploymentsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeploymentsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeploymentsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all deployments in the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3.ListDeploymentsResponse> listDeployments(
        com.google.cloud.dialogflow.cx.v3.ListDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeploymentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves the specified [Deployment][google.cloud.dialogflow.cx.v3.Deployment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3.Deployment> getDeployment(
        com.google.cloud.dialogflow.cx.v3.GetDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDeploymentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DEPLOYMENTS = 0;
  private static final int METHODID_GET_DEPLOYMENT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DeploymentsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeploymentsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_DEPLOYMENTS:
          serviceImpl.listDeployments((com.google.cloud.dialogflow.cx.v3.ListDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListDeploymentsResponse>) responseObserver);
          break;
        case METHODID_GET_DEPLOYMENT:
          serviceImpl.getDeployment((com.google.cloud.dialogflow.cx.v3.GetDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Deployment>) responseObserver);
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

  private static abstract class DeploymentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeploymentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3.DeploymentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Deployments");
    }
  }

  private static final class DeploymentsFileDescriptorSupplier
      extends DeploymentsBaseDescriptorSupplier {
    DeploymentsFileDescriptorSupplier() {}
  }

  private static final class DeploymentsMethodDescriptorSupplier
      extends DeploymentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DeploymentsMethodDescriptorSupplier(String methodName) {
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
      synchronized (DeploymentsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeploymentsFileDescriptorSupplier())
              .addMethod(getListDeploymentsMethod())
              .addMethod(getGetDeploymentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
