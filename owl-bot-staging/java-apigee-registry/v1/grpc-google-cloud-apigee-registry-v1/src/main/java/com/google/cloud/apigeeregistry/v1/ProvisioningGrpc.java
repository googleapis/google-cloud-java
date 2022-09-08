package com.google.cloud.apigeeregistry.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The service that is used for managing the data plane provisioning of the
 * Registry.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/apigeeregistry/v1/provisioning_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProvisioningGrpc {

  private ProvisioningGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.apigeeregistry.v1.Provisioning";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigeeregistry.v1.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.apigeeregistry.v1.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigeeregistry.v1.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigeeregistry.v1.CreateInstanceRequest, com.google.longrunning.Operation> getCreateInstanceMethod;
    if ((getCreateInstanceMethod = ProvisioningGrpc.getCreateInstanceMethod) == null) {
      synchronized (ProvisioningGrpc.class) {
        if ((getCreateInstanceMethod = ProvisioningGrpc.getCreateInstanceMethod) == null) {
          ProvisioningGrpc.getCreateInstanceMethod = getCreateInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigeeregistry.v1.CreateInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigeeregistry.v1.CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ProvisioningMethodDescriptorSupplier("CreateInstance"))
              .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigeeregistry.v1.DeleteInstanceRequest,
      com.google.longrunning.Operation> getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.apigeeregistry.v1.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigeeregistry.v1.DeleteInstanceRequest,
      com.google.longrunning.Operation> getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigeeregistry.v1.DeleteInstanceRequest, com.google.longrunning.Operation> getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = ProvisioningGrpc.getDeleteInstanceMethod) == null) {
      synchronized (ProvisioningGrpc.class) {
        if ((getDeleteInstanceMethod = ProvisioningGrpc.getDeleteInstanceMethod) == null) {
          ProvisioningGrpc.getDeleteInstanceMethod = getDeleteInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigeeregistry.v1.DeleteInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigeeregistry.v1.DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ProvisioningMethodDescriptorSupplier("DeleteInstance"))
              .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigeeregistry.v1.GetInstanceRequest,
      com.google.cloud.apigeeregistry.v1.Instance> getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.apigeeregistry.v1.GetInstanceRequest.class,
      responseType = com.google.cloud.apigeeregistry.v1.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigeeregistry.v1.GetInstanceRequest,
      com.google.cloud.apigeeregistry.v1.Instance> getGetInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigeeregistry.v1.GetInstanceRequest, com.google.cloud.apigeeregistry.v1.Instance> getGetInstanceMethod;
    if ((getGetInstanceMethod = ProvisioningGrpc.getGetInstanceMethod) == null) {
      synchronized (ProvisioningGrpc.class) {
        if ((getGetInstanceMethod = ProvisioningGrpc.getGetInstanceMethod) == null) {
          ProvisioningGrpc.getGetInstanceMethod = getGetInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigeeregistry.v1.GetInstanceRequest, com.google.cloud.apigeeregistry.v1.Instance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigeeregistry.v1.GetInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigeeregistry.v1.Instance.getDefaultInstance()))
              .setSchemaDescriptor(new ProvisioningMethodDescriptorSupplier("GetInstance"))
              .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProvisioningStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProvisioningStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProvisioningStub>() {
        @java.lang.Override
        public ProvisioningStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProvisioningStub(channel, callOptions);
        }
      };
    return ProvisioningStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProvisioningBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProvisioningBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProvisioningBlockingStub>() {
        @java.lang.Override
        public ProvisioningBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProvisioningBlockingStub(channel, callOptions);
        }
      };
    return ProvisioningBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProvisioningFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProvisioningFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProvisioningFutureStub>() {
        @java.lang.Override
        public ProvisioningFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProvisioningFutureStub(channel, callOptions);
        }
      };
    return ProvisioningFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The service that is used for managing the data plane provisioning of the
   * Registry.
   * </pre>
   */
  public static abstract class ProvisioningImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Provisions instance resources for the Registry.
     * </pre>
     */
    public void createInstance(com.google.cloud.apigeeregistry.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the Registry instance.
     * </pre>
     */
    public void deleteInstance(com.google.cloud.apigeeregistry.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public void getInstance(com.google.cloud.apigeeregistry.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInstanceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigeeregistry.v1.CreateInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_INSTANCE)))
          .addMethod(
            getDeleteInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigeeregistry.v1.DeleteInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_INSTANCE)))
          .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigeeregistry.v1.GetInstanceRequest,
                com.google.cloud.apigeeregistry.v1.Instance>(
                  this, METHODID_GET_INSTANCE)))
          .build();
    }
  }

  /**
   * <pre>
   * The service that is used for managing the data plane provisioning of the
   * Registry.
   * </pre>
   */
  public static final class ProvisioningStub extends io.grpc.stub.AbstractAsyncStub<ProvisioningStub> {
    private ProvisioningStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProvisioningStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProvisioningStub(channel, callOptions);
    }

    /**
     * <pre>
     * Provisions instance resources for the Registry.
     * </pre>
     */
    public void createInstance(com.google.cloud.apigeeregistry.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the Registry instance.
     * </pre>
     */
    public void deleteInstance(com.google.cloud.apigeeregistry.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public void getInstance(com.google.cloud.apigeeregistry.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The service that is used for managing the data plane provisioning of the
   * Registry.
   * </pre>
   */
  public static final class ProvisioningBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProvisioningBlockingStub> {
    private ProvisioningBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProvisioningBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProvisioningBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Provisions instance resources for the Registry.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(com.google.cloud.apigeeregistry.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the Registry instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(com.google.cloud.apigeeregistry.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.cloud.apigeeregistry.v1.Instance getInstance(com.google.cloud.apigeeregistry.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The service that is used for managing the data plane provisioning of the
   * Registry.
   * </pre>
   */
  public static final class ProvisioningFutureStub extends io.grpc.stub.AbstractFutureStub<ProvisioningFutureStub> {
    private ProvisioningFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProvisioningFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProvisioningFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Provisions instance resources for the Registry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createInstance(
        com.google.cloud.apigeeregistry.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the Registry instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteInstance(
        com.google.cloud.apigeeregistry.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apigeeregistry.v1.Instance> getInstance(
        com.google.cloud.apigeeregistry.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_INSTANCE = 0;
  private static final int METHODID_DELETE_INSTANCE = 1;
  private static final int METHODID_GET_INSTANCE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProvisioningImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProvisioningImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance((com.google.cloud.apigeeregistry.v1.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance((com.google.cloud.apigeeregistry.v1.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance((com.google.cloud.apigeeregistry.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigeeregistry.v1.Instance>) responseObserver);
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

  private static abstract class ProvisioningBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProvisioningBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apigeeregistry.v1.ProvisioningServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Provisioning");
    }
  }

  private static final class ProvisioningFileDescriptorSupplier
      extends ProvisioningBaseDescriptorSupplier {
    ProvisioningFileDescriptorSupplier() {}
  }

  private static final class ProvisioningMethodDescriptorSupplier
      extends ProvisioningBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProvisioningMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProvisioningGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProvisioningFileDescriptorSupplier())
              .addMethod(getCreateInstanceMethod())
              .addMethod(getDeleteInstanceMethod())
              .addMethod(getGetInstanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
