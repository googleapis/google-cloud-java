package com.google.cloud.discoveryengine.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for managing billing estimations resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1alpha/estimate_billing_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EstimateBillingServiceGrpc {

  private EstimateBillingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.discoveryengine.v1alpha.EstimateBillingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest,
      com.google.longrunning.Operation> getEstimateDataSizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EstimateDataSize",
      requestType = com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest,
      com.google.longrunning.Operation> getEstimateDataSizeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest, com.google.longrunning.Operation> getEstimateDataSizeMethod;
    if ((getEstimateDataSizeMethod = EstimateBillingServiceGrpc.getEstimateDataSizeMethod) == null) {
      synchronized (EstimateBillingServiceGrpc.class) {
        if ((getEstimateDataSizeMethod = EstimateBillingServiceGrpc.getEstimateDataSizeMethod) == null) {
          EstimateBillingServiceGrpc.getEstimateDataSizeMethod = getEstimateDataSizeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EstimateDataSize"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EstimateBillingServiceMethodDescriptorSupplier("EstimateDataSize"))
              .build();
        }
      }
    }
    return getEstimateDataSizeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EstimateBillingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EstimateBillingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EstimateBillingServiceStub>() {
        @java.lang.Override
        public EstimateBillingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EstimateBillingServiceStub(channel, callOptions);
        }
      };
    return EstimateBillingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EstimateBillingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EstimateBillingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EstimateBillingServiceBlockingStub>() {
        @java.lang.Override
        public EstimateBillingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EstimateBillingServiceBlockingStub(channel, callOptions);
        }
      };
    return EstimateBillingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EstimateBillingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EstimateBillingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EstimateBillingServiceFutureStub>() {
        @java.lang.Override
        public EstimateBillingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EstimateBillingServiceFutureStub(channel, callOptions);
        }
      };
    return EstimateBillingServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for managing billing estimations resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Estimates the data size to be used by a customer.
     * </pre>
     */
    default void estimateDataSize(com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEstimateDataSizeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EstimateBillingService.
   * <pre>
   * Service for managing billing estimations resources.
   * </pre>
   */
  public static abstract class EstimateBillingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EstimateBillingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EstimateBillingService.
   * <pre>
   * Service for managing billing estimations resources.
   * </pre>
   */
  public static final class EstimateBillingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EstimateBillingServiceStub> {
    private EstimateBillingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EstimateBillingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EstimateBillingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Estimates the data size to be used by a customer.
     * </pre>
     */
    public void estimateDataSize(com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEstimateDataSizeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EstimateBillingService.
   * <pre>
   * Service for managing billing estimations resources.
   * </pre>
   */
  public static final class EstimateBillingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EstimateBillingServiceBlockingStub> {
    private EstimateBillingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EstimateBillingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EstimateBillingServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Estimates the data size to be used by a customer.
     * </pre>
     */
    public com.google.longrunning.Operation estimateDataSize(com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEstimateDataSizeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EstimateBillingService.
   * <pre>
   * Service for managing billing estimations resources.
   * </pre>
   */
  public static final class EstimateBillingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EstimateBillingServiceFutureStub> {
    private EstimateBillingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EstimateBillingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EstimateBillingServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Estimates the data size to be used by a customer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> estimateDataSize(
        com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEstimateDataSizeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ESTIMATE_DATA_SIZE = 0;

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
        case METHODID_ESTIMATE_DATA_SIZE:
          serviceImpl.estimateDataSize((com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getEstimateDataSizeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest,
              com.google.longrunning.Operation>(
                service, METHODID_ESTIMATE_DATA_SIZE)))
        .build();
  }

  private static abstract class EstimateBillingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EstimateBillingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1alpha.EstimateBillingServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EstimateBillingService");
    }
  }

  private static final class EstimateBillingServiceFileDescriptorSupplier
      extends EstimateBillingServiceBaseDescriptorSupplier {
    EstimateBillingServiceFileDescriptorSupplier() {}
  }

  private static final class EstimateBillingServiceMethodDescriptorSupplier
      extends EstimateBillingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EstimateBillingServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EstimateBillingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EstimateBillingServiceFileDescriptorSupplier())
              .addMethod(getEstimateDataSizeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
