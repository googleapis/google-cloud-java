package com.google.cloud.kms.inventory.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Provides a cross-region view of all Cloud KMS keys in a given Cloud project.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/kms/inventory/v1/key_dashboard_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class KeyDashboardServiceGrpc {

  private KeyDashboardServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.kms.inventory.v1.KeyDashboardService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest,
      com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse> getListCryptoKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCryptoKeys",
      requestType = com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest.class,
      responseType = com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest,
      com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse> getListCryptoKeysMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest, com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse> getListCryptoKeysMethod;
    if ((getListCryptoKeysMethod = KeyDashboardServiceGrpc.getListCryptoKeysMethod) == null) {
      synchronized (KeyDashboardServiceGrpc.class) {
        if ((getListCryptoKeysMethod = KeyDashboardServiceGrpc.getListCryptoKeysMethod) == null) {
          KeyDashboardServiceGrpc.getListCryptoKeysMethod = getListCryptoKeysMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest, com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCryptoKeys"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyDashboardServiceMethodDescriptorSupplier("ListCryptoKeys"))
              .build();
        }
      }
    }
    return getListCryptoKeysMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static KeyDashboardServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KeyDashboardServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KeyDashboardServiceStub>() {
        @java.lang.Override
        public KeyDashboardServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KeyDashboardServiceStub(channel, callOptions);
        }
      };
    return KeyDashboardServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KeyDashboardServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KeyDashboardServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KeyDashboardServiceBlockingStub>() {
        @java.lang.Override
        public KeyDashboardServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KeyDashboardServiceBlockingStub(channel, callOptions);
        }
      };
    return KeyDashboardServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static KeyDashboardServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KeyDashboardServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KeyDashboardServiceFutureStub>() {
        @java.lang.Override
        public KeyDashboardServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KeyDashboardServiceFutureStub(channel, callOptions);
        }
      };
    return KeyDashboardServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Provides a cross-region view of all Cloud KMS keys in a given Cloud project.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Returns cryptographic keys managed by Cloud KMS in a given Cloud project.
     * Note that this data is sourced from snapshots, meaning it may not
     * completely reflect the actual state of key metadata at call time.
     * </pre>
     */
    default void listCryptoKeys(com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCryptoKeysMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service KeyDashboardService.
   * <pre>
   * Provides a cross-region view of all Cloud KMS keys in a given Cloud project.
   * </pre>
   */
  public static abstract class KeyDashboardServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return KeyDashboardServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service KeyDashboardService.
   * <pre>
   * Provides a cross-region view of all Cloud KMS keys in a given Cloud project.
   * </pre>
   */
  public static final class KeyDashboardServiceStub
      extends io.grpc.stub.AbstractAsyncStub<KeyDashboardServiceStub> {
    private KeyDashboardServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyDashboardServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KeyDashboardServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns cryptographic keys managed by Cloud KMS in a given Cloud project.
     * Note that this data is sourced from snapshots, meaning it may not
     * completely reflect the actual state of key metadata at call time.
     * </pre>
     */
    public void listCryptoKeys(com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCryptoKeysMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service KeyDashboardService.
   * <pre>
   * Provides a cross-region view of all Cloud KMS keys in a given Cloud project.
   * </pre>
   */
  public static final class KeyDashboardServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<KeyDashboardServiceBlockingStub> {
    private KeyDashboardServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyDashboardServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KeyDashboardServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns cryptographic keys managed by Cloud KMS in a given Cloud project.
     * Note that this data is sourced from snapshots, meaning it may not
     * completely reflect the actual state of key metadata at call time.
     * </pre>
     */
    public com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse listCryptoKeys(com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCryptoKeysMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service KeyDashboardService.
   * <pre>
   * Provides a cross-region view of all Cloud KMS keys in a given Cloud project.
   * </pre>
   */
  public static final class KeyDashboardServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<KeyDashboardServiceFutureStub> {
    private KeyDashboardServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyDashboardServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KeyDashboardServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns cryptographic keys managed by Cloud KMS in a given Cloud project.
     * Note that this data is sourced from snapshots, meaning it may not
     * completely reflect the actual state of key metadata at call time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse> listCryptoKeys(
        com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCryptoKeysMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CRYPTO_KEYS = 0;

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
        case METHODID_LIST_CRYPTO_KEYS:
          serviceImpl.listCryptoKeys((com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse>) responseObserver);
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
          getListCryptoKeysMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.kms.inventory.v1.ListCryptoKeysRequest,
              com.google.cloud.kms.inventory.v1.ListCryptoKeysResponse>(
                service, METHODID_LIST_CRYPTO_KEYS)))
        .build();
  }

  private static abstract class KeyDashboardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    KeyDashboardServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.kms.inventory.v1.KeyDashboardServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("KeyDashboardService");
    }
  }

  private static final class KeyDashboardServiceFileDescriptorSupplier
      extends KeyDashboardServiceBaseDescriptorSupplier {
    KeyDashboardServiceFileDescriptorSupplier() {}
  }

  private static final class KeyDashboardServiceMethodDescriptorSupplier
      extends KeyDashboardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    KeyDashboardServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (KeyDashboardServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new KeyDashboardServiceFileDescriptorSupplier())
              .addMethod(getListCryptoKeysMethod())
              .build();
        }
      }
    }
    return result;
  }
}
