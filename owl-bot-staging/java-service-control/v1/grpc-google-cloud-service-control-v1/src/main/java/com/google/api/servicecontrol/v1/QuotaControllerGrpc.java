package com.google.api.servicecontrol.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * [Google Quota Control API](/service-control/overview)
 * Allows clients to allocate and release quota against a [managed
 * service](https://cloud.google.com/service-management/reference/rpc/google.api/servicemanagement.v1#google.api.servicemanagement.v1.ManagedService).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/api/servicecontrol/v1/quota_controller.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class QuotaControllerGrpc {

  private QuotaControllerGrpc() {}

  public static final String SERVICE_NAME = "google.api.servicecontrol.v1.QuotaController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.api.servicecontrol.v1.AllocateQuotaRequest,
      com.google.api.servicecontrol.v1.AllocateQuotaResponse> getAllocateQuotaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AllocateQuota",
      requestType = com.google.api.servicecontrol.v1.AllocateQuotaRequest.class,
      responseType = com.google.api.servicecontrol.v1.AllocateQuotaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicecontrol.v1.AllocateQuotaRequest,
      com.google.api.servicecontrol.v1.AllocateQuotaResponse> getAllocateQuotaMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicecontrol.v1.AllocateQuotaRequest, com.google.api.servicecontrol.v1.AllocateQuotaResponse> getAllocateQuotaMethod;
    if ((getAllocateQuotaMethod = QuotaControllerGrpc.getAllocateQuotaMethod) == null) {
      synchronized (QuotaControllerGrpc.class) {
        if ((getAllocateQuotaMethod = QuotaControllerGrpc.getAllocateQuotaMethod) == null) {
          QuotaControllerGrpc.getAllocateQuotaMethod = getAllocateQuotaMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicecontrol.v1.AllocateQuotaRequest, com.google.api.servicecontrol.v1.AllocateQuotaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AllocateQuota"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicecontrol.v1.AllocateQuotaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicecontrol.v1.AllocateQuotaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new QuotaControllerMethodDescriptorSupplier("AllocateQuota"))
              .build();
        }
      }
    }
    return getAllocateQuotaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static QuotaControllerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QuotaControllerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<QuotaControllerStub>() {
        @java.lang.Override
        public QuotaControllerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new QuotaControllerStub(channel, callOptions);
        }
      };
    return QuotaControllerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static QuotaControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QuotaControllerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<QuotaControllerBlockingStub>() {
        @java.lang.Override
        public QuotaControllerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new QuotaControllerBlockingStub(channel, callOptions);
        }
      };
    return QuotaControllerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static QuotaControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QuotaControllerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<QuotaControllerFutureStub>() {
        @java.lang.Override
        public QuotaControllerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new QuotaControllerFutureStub(channel, callOptions);
        }
      };
    return QuotaControllerFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * [Google Quota Control API](/service-control/overview)
   * Allows clients to allocate and release quota against a [managed
   * service](https://cloud.google.com/service-management/reference/rpc/google.api/servicemanagement.v1#google.api.servicemanagement.v1.ManagedService).
   * </pre>
   */
  public static abstract class QuotaControllerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Attempts to allocate quota for the specified consumer. It should be called
     * before the operation is executed.
     * This method requires the `servicemanagement.services.quota`
     * permission on the specified service. For more information, see
     * [Cloud IAM](https://cloud.google.com/iam).
     * **NOTE:** The client **must** fail-open on server errors `INTERNAL`,
     * `UNKNOWN`, `DEADLINE_EXCEEDED`, and `UNAVAILABLE`. To ensure system
     * reliability, the server may inject these errors to prohibit any hard
     * dependency on the quota functionality.
     * </pre>
     */
    public void allocateQuota(com.google.api.servicecontrol.v1.AllocateQuotaRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicecontrol.v1.AllocateQuotaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAllocateQuotaMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAllocateQuotaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicecontrol.v1.AllocateQuotaRequest,
                com.google.api.servicecontrol.v1.AllocateQuotaResponse>(
                  this, METHODID_ALLOCATE_QUOTA)))
          .build();
    }
  }

  /**
   * <pre>
   * [Google Quota Control API](/service-control/overview)
   * Allows clients to allocate and release quota against a [managed
   * service](https://cloud.google.com/service-management/reference/rpc/google.api/servicemanagement.v1#google.api.servicemanagement.v1.ManagedService).
   * </pre>
   */
  public static final class QuotaControllerStub extends io.grpc.stub.AbstractAsyncStub<QuotaControllerStub> {
    private QuotaControllerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QuotaControllerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QuotaControllerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Attempts to allocate quota for the specified consumer. It should be called
     * before the operation is executed.
     * This method requires the `servicemanagement.services.quota`
     * permission on the specified service. For more information, see
     * [Cloud IAM](https://cloud.google.com/iam).
     * **NOTE:** The client **must** fail-open on server errors `INTERNAL`,
     * `UNKNOWN`, `DEADLINE_EXCEEDED`, and `UNAVAILABLE`. To ensure system
     * reliability, the server may inject these errors to prohibit any hard
     * dependency on the quota functionality.
     * </pre>
     */
    public void allocateQuota(com.google.api.servicecontrol.v1.AllocateQuotaRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicecontrol.v1.AllocateQuotaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAllocateQuotaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * [Google Quota Control API](/service-control/overview)
   * Allows clients to allocate and release quota against a [managed
   * service](https://cloud.google.com/service-management/reference/rpc/google.api/servicemanagement.v1#google.api.servicemanagement.v1.ManagedService).
   * </pre>
   */
  public static final class QuotaControllerBlockingStub extends io.grpc.stub.AbstractBlockingStub<QuotaControllerBlockingStub> {
    private QuotaControllerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QuotaControllerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QuotaControllerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Attempts to allocate quota for the specified consumer. It should be called
     * before the operation is executed.
     * This method requires the `servicemanagement.services.quota`
     * permission on the specified service. For more information, see
     * [Cloud IAM](https://cloud.google.com/iam).
     * **NOTE:** The client **must** fail-open on server errors `INTERNAL`,
     * `UNKNOWN`, `DEADLINE_EXCEEDED`, and `UNAVAILABLE`. To ensure system
     * reliability, the server may inject these errors to prohibit any hard
     * dependency on the quota functionality.
     * </pre>
     */
    public com.google.api.servicecontrol.v1.AllocateQuotaResponse allocateQuota(com.google.api.servicecontrol.v1.AllocateQuotaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAllocateQuotaMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * [Google Quota Control API](/service-control/overview)
   * Allows clients to allocate and release quota against a [managed
   * service](https://cloud.google.com/service-management/reference/rpc/google.api/servicemanagement.v1#google.api.servicemanagement.v1.ManagedService).
   * </pre>
   */
  public static final class QuotaControllerFutureStub extends io.grpc.stub.AbstractFutureStub<QuotaControllerFutureStub> {
    private QuotaControllerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QuotaControllerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QuotaControllerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Attempts to allocate quota for the specified consumer. It should be called
     * before the operation is executed.
     * This method requires the `servicemanagement.services.quota`
     * permission on the specified service. For more information, see
     * [Cloud IAM](https://cloud.google.com/iam).
     * **NOTE:** The client **must** fail-open on server errors `INTERNAL`,
     * `UNKNOWN`, `DEADLINE_EXCEEDED`, and `UNAVAILABLE`. To ensure system
     * reliability, the server may inject these errors to prohibit any hard
     * dependency on the quota functionality.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.servicecontrol.v1.AllocateQuotaResponse> allocateQuota(
        com.google.api.servicecontrol.v1.AllocateQuotaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAllocateQuotaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ALLOCATE_QUOTA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final QuotaControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(QuotaControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ALLOCATE_QUOTA:
          serviceImpl.allocateQuota((com.google.api.servicecontrol.v1.AllocateQuotaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.servicecontrol.v1.AllocateQuotaResponse>) responseObserver);
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

  private static abstract class QuotaControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    QuotaControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.api.servicecontrol.v1.QuotaControllerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("QuotaController");
    }
  }

  private static final class QuotaControllerFileDescriptorSupplier
      extends QuotaControllerBaseDescriptorSupplier {
    QuotaControllerFileDescriptorSupplier() {}
  }

  private static final class QuotaControllerMethodDescriptorSupplier
      extends QuotaControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    QuotaControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (QuotaControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new QuotaControllerFileDescriptorSupplier())
              .addMethod(getAllocateQuotaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
