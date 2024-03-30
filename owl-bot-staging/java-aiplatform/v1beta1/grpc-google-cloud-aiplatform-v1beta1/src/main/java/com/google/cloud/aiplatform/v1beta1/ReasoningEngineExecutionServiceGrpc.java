package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service for executing queries on Reasoning Engine.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/reasoning_engine_execution_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReasoningEngineExecutionServiceGrpc {

  private ReasoningEngineExecutionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.aiplatform.v1beta1.ReasoningEngineExecutionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineRequest,
      com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineResponse> getQueryReasoningEngineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryReasoningEngine",
      requestType = com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineRequest,
      com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineResponse> getQueryReasoningEngineMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineRequest, com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineResponse> getQueryReasoningEngineMethod;
    if ((getQueryReasoningEngineMethod = ReasoningEngineExecutionServiceGrpc.getQueryReasoningEngineMethod) == null) {
      synchronized (ReasoningEngineExecutionServiceGrpc.class) {
        if ((getQueryReasoningEngineMethod = ReasoningEngineExecutionServiceGrpc.getQueryReasoningEngineMethod) == null) {
          ReasoningEngineExecutionServiceGrpc.getQueryReasoningEngineMethod = getQueryReasoningEngineMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineRequest, com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryReasoningEngine"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReasoningEngineExecutionServiceMethodDescriptorSupplier("QueryReasoningEngine"))
              .build();
        }
      }
    }
    return getQueryReasoningEngineMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReasoningEngineExecutionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineExecutionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineExecutionServiceStub>() {
        @java.lang.Override
        public ReasoningEngineExecutionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReasoningEngineExecutionServiceStub(channel, callOptions);
        }
      };
    return ReasoningEngineExecutionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReasoningEngineExecutionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineExecutionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineExecutionServiceBlockingStub>() {
        @java.lang.Override
        public ReasoningEngineExecutionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReasoningEngineExecutionServiceBlockingStub(channel, callOptions);
        }
      };
    return ReasoningEngineExecutionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReasoningEngineExecutionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineExecutionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineExecutionServiceFutureStub>() {
        @java.lang.Override
        public ReasoningEngineExecutionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReasoningEngineExecutionServiceFutureStub(channel, callOptions);
        }
      };
    return ReasoningEngineExecutionServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service for executing queries on Reasoning Engine.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Queries using a reasoning engine.
     * </pre>
     */
    default void queryReasoningEngine(com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryReasoningEngineMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ReasoningEngineExecutionService.
   * <pre>
   * A service for executing queries on Reasoning Engine.
   * </pre>
   */
  public static abstract class ReasoningEngineExecutionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ReasoningEngineExecutionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ReasoningEngineExecutionService.
   * <pre>
   * A service for executing queries on Reasoning Engine.
   * </pre>
   */
  public static final class ReasoningEngineExecutionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReasoningEngineExecutionServiceStub> {
    private ReasoningEngineExecutionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReasoningEngineExecutionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReasoningEngineExecutionServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Queries using a reasoning engine.
     * </pre>
     */
    public void queryReasoningEngine(com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryReasoningEngineMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ReasoningEngineExecutionService.
   * <pre>
   * A service for executing queries on Reasoning Engine.
   * </pre>
   */
  public static final class ReasoningEngineExecutionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReasoningEngineExecutionServiceBlockingStub> {
    private ReasoningEngineExecutionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReasoningEngineExecutionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReasoningEngineExecutionServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Queries using a reasoning engine.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineResponse queryReasoningEngine(com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryReasoningEngineMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ReasoningEngineExecutionService.
   * <pre>
   * A service for executing queries on Reasoning Engine.
   * </pre>
   */
  public static final class ReasoningEngineExecutionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReasoningEngineExecutionServiceFutureStub> {
    private ReasoningEngineExecutionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReasoningEngineExecutionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReasoningEngineExecutionServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Queries using a reasoning engine.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineResponse> queryReasoningEngine(
        com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryReasoningEngineMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY_REASONING_ENGINE = 0;

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
        case METHODID_QUERY_REASONING_ENGINE:
          serviceImpl.queryReasoningEngine((com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineResponse>) responseObserver);
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
          getQueryReasoningEngineMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineRequest,
              com.google.cloud.aiplatform.v1beta1.QueryReasoningEngineResponse>(
                service, METHODID_QUERY_REASONING_ENGINE)))
        .build();
  }

  private static abstract class ReasoningEngineExecutionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReasoningEngineExecutionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.ReasoningEngineExecutionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReasoningEngineExecutionService");
    }
  }

  private static final class ReasoningEngineExecutionServiceFileDescriptorSupplier
      extends ReasoningEngineExecutionServiceBaseDescriptorSupplier {
    ReasoningEngineExecutionServiceFileDescriptorSupplier() {}
  }

  private static final class ReasoningEngineExecutionServiceMethodDescriptorSupplier
      extends ReasoningEngineExecutionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ReasoningEngineExecutionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ReasoningEngineExecutionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReasoningEngineExecutionServiceFileDescriptorSupplier())
              .addMethod(getQueryReasoningEngineMethod())
              .build();
        }
      }
    }
    return result;
  }
}
