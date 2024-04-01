package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service for Extension execution.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/extension_execution_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExtensionExecutionServiceGrpc {

  private ExtensionExecutionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.aiplatform.v1beta1.ExtensionExecutionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ExecuteExtensionRequest,
      com.google.cloud.aiplatform.v1beta1.ExecuteExtensionResponse> getExecuteExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteExtension",
      requestType = com.google.cloud.aiplatform.v1beta1.ExecuteExtensionRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ExecuteExtensionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ExecuteExtensionRequest,
      com.google.cloud.aiplatform.v1beta1.ExecuteExtensionResponse> getExecuteExtensionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ExecuteExtensionRequest, com.google.cloud.aiplatform.v1beta1.ExecuteExtensionResponse> getExecuteExtensionMethod;
    if ((getExecuteExtensionMethod = ExtensionExecutionServiceGrpc.getExecuteExtensionMethod) == null) {
      synchronized (ExtensionExecutionServiceGrpc.class) {
        if ((getExecuteExtensionMethod = ExtensionExecutionServiceGrpc.getExecuteExtensionMethod) == null) {
          ExtensionExecutionServiceGrpc.getExecuteExtensionMethod = getExecuteExtensionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.ExecuteExtensionRequest, com.google.cloud.aiplatform.v1beta1.ExecuteExtensionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteExtension"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ExecuteExtensionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ExecuteExtensionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExtensionExecutionServiceMethodDescriptorSupplier("ExecuteExtension"))
              .build();
        }
      }
    }
    return getExecuteExtensionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.QueryExtensionRequest,
      com.google.cloud.aiplatform.v1beta1.QueryExtensionResponse> getQueryExtensionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryExtension",
      requestType = com.google.cloud.aiplatform.v1beta1.QueryExtensionRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.QueryExtensionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.QueryExtensionRequest,
      com.google.cloud.aiplatform.v1beta1.QueryExtensionResponse> getQueryExtensionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.QueryExtensionRequest, com.google.cloud.aiplatform.v1beta1.QueryExtensionResponse> getQueryExtensionMethod;
    if ((getQueryExtensionMethod = ExtensionExecutionServiceGrpc.getQueryExtensionMethod) == null) {
      synchronized (ExtensionExecutionServiceGrpc.class) {
        if ((getQueryExtensionMethod = ExtensionExecutionServiceGrpc.getQueryExtensionMethod) == null) {
          ExtensionExecutionServiceGrpc.getQueryExtensionMethod = getQueryExtensionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.QueryExtensionRequest, com.google.cloud.aiplatform.v1beta1.QueryExtensionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryExtension"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.QueryExtensionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.QueryExtensionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExtensionExecutionServiceMethodDescriptorSupplier("QueryExtension"))
              .build();
        }
      }
    }
    return getQueryExtensionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExtensionExecutionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExtensionExecutionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExtensionExecutionServiceStub>() {
        @java.lang.Override
        public ExtensionExecutionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExtensionExecutionServiceStub(channel, callOptions);
        }
      };
    return ExtensionExecutionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExtensionExecutionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExtensionExecutionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExtensionExecutionServiceBlockingStub>() {
        @java.lang.Override
        public ExtensionExecutionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExtensionExecutionServiceBlockingStub(channel, callOptions);
        }
      };
    return ExtensionExecutionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExtensionExecutionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExtensionExecutionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExtensionExecutionServiceFutureStub>() {
        @java.lang.Override
        public ExtensionExecutionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExtensionExecutionServiceFutureStub(channel, callOptions);
        }
      };
    return ExtensionExecutionServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service for Extension execution.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Executes the request against a given extension.
     * </pre>
     */
    default void executeExtension(com.google.cloud.aiplatform.v1beta1.ExecuteExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ExecuteExtensionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExecuteExtensionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Queries an extension with a default controller.
     * </pre>
     */
    default void queryExtension(com.google.cloud.aiplatform.v1beta1.QueryExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.QueryExtensionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryExtensionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ExtensionExecutionService.
   * <pre>
   * A service for Extension execution.
   * </pre>
   */
  public static abstract class ExtensionExecutionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ExtensionExecutionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ExtensionExecutionService.
   * <pre>
   * A service for Extension execution.
   * </pre>
   */
  public static final class ExtensionExecutionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ExtensionExecutionServiceStub> {
    private ExtensionExecutionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExtensionExecutionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExtensionExecutionServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Executes the request against a given extension.
     * </pre>
     */
    public void executeExtension(com.google.cloud.aiplatform.v1beta1.ExecuteExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ExecuteExtensionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteExtensionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Queries an extension with a default controller.
     * </pre>
     */
    public void queryExtension(com.google.cloud.aiplatform.v1beta1.QueryExtensionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.QueryExtensionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryExtensionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ExtensionExecutionService.
   * <pre>
   * A service for Extension execution.
   * </pre>
   */
  public static final class ExtensionExecutionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ExtensionExecutionServiceBlockingStub> {
    private ExtensionExecutionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExtensionExecutionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExtensionExecutionServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Executes the request against a given extension.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ExecuteExtensionResponse executeExtension(com.google.cloud.aiplatform.v1beta1.ExecuteExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteExtensionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Queries an extension with a default controller.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.QueryExtensionResponse queryExtension(com.google.cloud.aiplatform.v1beta1.QueryExtensionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryExtensionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ExtensionExecutionService.
   * <pre>
   * A service for Extension execution.
   * </pre>
   */
  public static final class ExtensionExecutionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ExtensionExecutionServiceFutureStub> {
    private ExtensionExecutionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExtensionExecutionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExtensionExecutionServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Executes the request against a given extension.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.ExecuteExtensionResponse> executeExtension(
        com.google.cloud.aiplatform.v1beta1.ExecuteExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteExtensionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Queries an extension with a default controller.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.QueryExtensionResponse> queryExtension(
        com.google.cloud.aiplatform.v1beta1.QueryExtensionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryExtensionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXECUTE_EXTENSION = 0;
  private static final int METHODID_QUERY_EXTENSION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXECUTE_EXTENSION:
          serviceImpl.executeExtension((com.google.cloud.aiplatform.v1beta1.ExecuteExtensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ExecuteExtensionResponse>) responseObserver);
          break;
        case METHODID_QUERY_EXTENSION:
          serviceImpl.queryExtension((com.google.cloud.aiplatform.v1beta1.QueryExtensionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.QueryExtensionResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getExecuteExtensionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1beta1.ExecuteExtensionRequest,
              com.google.cloud.aiplatform.v1beta1.ExecuteExtensionResponse>(
                service, METHODID_EXECUTE_EXTENSION)))
        .addMethod(
          getQueryExtensionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1beta1.QueryExtensionRequest,
              com.google.cloud.aiplatform.v1beta1.QueryExtensionResponse>(
                service, METHODID_QUERY_EXTENSION)))
        .build();
  }

  private static abstract class ExtensionExecutionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExtensionExecutionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.ExtensionExecutionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExtensionExecutionService");
    }
  }

  private static final class ExtensionExecutionServiceFileDescriptorSupplier
      extends ExtensionExecutionServiceBaseDescriptorSupplier {
    ExtensionExecutionServiceFileDescriptorSupplier() {}
  }

  private static final class ExtensionExecutionServiceMethodDescriptorSupplier
      extends ExtensionExecutionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ExtensionExecutionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ExtensionExecutionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExtensionExecutionServiceFileDescriptorSupplier())
              .addMethod(getExecuteExtensionMethod())
              .addMethod(getQueryExtensionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
