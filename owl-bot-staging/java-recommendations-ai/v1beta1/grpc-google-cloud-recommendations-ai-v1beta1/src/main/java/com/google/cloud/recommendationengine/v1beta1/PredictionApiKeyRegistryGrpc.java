package com.google.cloud.recommendationengine.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for registering API keys for use with the `predict` method. If you
 * use an API key to request predictions, you must first register the API key.
 * Otherwise, your prediction request is rejected. If you use OAuth to
 * authenticate your `predict` method call, you do not need to register an API
 * key. You can register up to 20 API keys per project.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/recommendationengine/v1beta1/prediction_apikey_registry_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PredictionApiKeyRegistryGrpc {

  private PredictionApiKeyRegistryGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest,
      com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration> getCreatePredictionApiKeyRegistrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePredictionApiKeyRegistration",
      requestType = com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest.class,
      responseType = com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest,
      com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration> getCreatePredictionApiKeyRegistrationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest, com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration> getCreatePredictionApiKeyRegistrationMethod;
    if ((getCreatePredictionApiKeyRegistrationMethod = PredictionApiKeyRegistryGrpc.getCreatePredictionApiKeyRegistrationMethod) == null) {
      synchronized (PredictionApiKeyRegistryGrpc.class) {
        if ((getCreatePredictionApiKeyRegistrationMethod = PredictionApiKeyRegistryGrpc.getCreatePredictionApiKeyRegistrationMethod) == null) {
          PredictionApiKeyRegistryGrpc.getCreatePredictionApiKeyRegistrationMethod = getCreatePredictionApiKeyRegistrationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest, com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePredictionApiKeyRegistration"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration.getDefaultInstance()))
              .setSchemaDescriptor(new PredictionApiKeyRegistryMethodDescriptorSupplier("CreatePredictionApiKeyRegistration"))
              .build();
        }
      }
    }
    return getCreatePredictionApiKeyRegistrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest,
      com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse> getListPredictionApiKeyRegistrationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPredictionApiKeyRegistrations",
      requestType = com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest.class,
      responseType = com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest,
      com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse> getListPredictionApiKeyRegistrationsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest, com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse> getListPredictionApiKeyRegistrationsMethod;
    if ((getListPredictionApiKeyRegistrationsMethod = PredictionApiKeyRegistryGrpc.getListPredictionApiKeyRegistrationsMethod) == null) {
      synchronized (PredictionApiKeyRegistryGrpc.class) {
        if ((getListPredictionApiKeyRegistrationsMethod = PredictionApiKeyRegistryGrpc.getListPredictionApiKeyRegistrationsMethod) == null) {
          PredictionApiKeyRegistryGrpc.getListPredictionApiKeyRegistrationsMethod = getListPredictionApiKeyRegistrationsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest, com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPredictionApiKeyRegistrations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PredictionApiKeyRegistryMethodDescriptorSupplier("ListPredictionApiKeyRegistrations"))
              .build();
        }
      }
    }
    return getListPredictionApiKeyRegistrationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest,
      com.google.protobuf.Empty> getDeletePredictionApiKeyRegistrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePredictionApiKeyRegistration",
      requestType = com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest,
      com.google.protobuf.Empty> getDeletePredictionApiKeyRegistrationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest, com.google.protobuf.Empty> getDeletePredictionApiKeyRegistrationMethod;
    if ((getDeletePredictionApiKeyRegistrationMethod = PredictionApiKeyRegistryGrpc.getDeletePredictionApiKeyRegistrationMethod) == null) {
      synchronized (PredictionApiKeyRegistryGrpc.class) {
        if ((getDeletePredictionApiKeyRegistrationMethod = PredictionApiKeyRegistryGrpc.getDeletePredictionApiKeyRegistrationMethod) == null) {
          PredictionApiKeyRegistryGrpc.getDeletePredictionApiKeyRegistrationMethod = getDeletePredictionApiKeyRegistrationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePredictionApiKeyRegistration"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PredictionApiKeyRegistryMethodDescriptorSupplier("DeletePredictionApiKeyRegistration"))
              .build();
        }
      }
    }
    return getDeletePredictionApiKeyRegistrationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PredictionApiKeyRegistryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PredictionApiKeyRegistryStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PredictionApiKeyRegistryStub>() {
        @java.lang.Override
        public PredictionApiKeyRegistryStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PredictionApiKeyRegistryStub(channel, callOptions);
        }
      };
    return PredictionApiKeyRegistryStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PredictionApiKeyRegistryBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PredictionApiKeyRegistryBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PredictionApiKeyRegistryBlockingStub>() {
        @java.lang.Override
        public PredictionApiKeyRegistryBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PredictionApiKeyRegistryBlockingStub(channel, callOptions);
        }
      };
    return PredictionApiKeyRegistryBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PredictionApiKeyRegistryFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PredictionApiKeyRegistryFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PredictionApiKeyRegistryFutureStub>() {
        @java.lang.Override
        public PredictionApiKeyRegistryFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PredictionApiKeyRegistryFutureStub(channel, callOptions);
        }
      };
    return PredictionApiKeyRegistryFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for registering API keys for use with the `predict` method. If you
   * use an API key to request predictions, you must first register the API key.
   * Otherwise, your prediction request is rejected. If you use OAuth to
   * authenticate your `predict` method call, you do not need to register an API
   * key. You can register up to 20 API keys per project.
   * </pre>
   */
  public static abstract class PredictionApiKeyRegistryImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Register an API key for use with predict method.
     * </pre>
     */
    public void createPredictionApiKeyRegistration(com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePredictionApiKeyRegistrationMethod(), responseObserver);
    }

    /**
     * <pre>
     * List the registered apiKeys for use with predict method.
     * </pre>
     */
    public void listPredictionApiKeyRegistrations(com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPredictionApiKeyRegistrationsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unregister an apiKey from using for predict method.
     * </pre>
     */
    public void deletePredictionApiKeyRegistration(com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePredictionApiKeyRegistrationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreatePredictionApiKeyRegistrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest,
                com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration>(
                  this, METHODID_CREATE_PREDICTION_API_KEY_REGISTRATION)))
          .addMethod(
            getListPredictionApiKeyRegistrationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest,
                com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse>(
                  this, METHODID_LIST_PREDICTION_API_KEY_REGISTRATIONS)))
          .addMethod(
            getDeletePredictionApiKeyRegistrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_PREDICTION_API_KEY_REGISTRATION)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for registering API keys for use with the `predict` method. If you
   * use an API key to request predictions, you must first register the API key.
   * Otherwise, your prediction request is rejected. If you use OAuth to
   * authenticate your `predict` method call, you do not need to register an API
   * key. You can register up to 20 API keys per project.
   * </pre>
   */
  public static final class PredictionApiKeyRegistryStub extends io.grpc.stub.AbstractAsyncStub<PredictionApiKeyRegistryStub> {
    private PredictionApiKeyRegistryStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PredictionApiKeyRegistryStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PredictionApiKeyRegistryStub(channel, callOptions);
    }

    /**
     * <pre>
     * Register an API key for use with predict method.
     * </pre>
     */
    public void createPredictionApiKeyRegistration(com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePredictionApiKeyRegistrationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List the registered apiKeys for use with predict method.
     * </pre>
     */
    public void listPredictionApiKeyRegistrations(com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPredictionApiKeyRegistrationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unregister an apiKey from using for predict method.
     * </pre>
     */
    public void deletePredictionApiKeyRegistration(com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePredictionApiKeyRegistrationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service for registering API keys for use with the `predict` method. If you
   * use an API key to request predictions, you must first register the API key.
   * Otherwise, your prediction request is rejected. If you use OAuth to
   * authenticate your `predict` method call, you do not need to register an API
   * key. You can register up to 20 API keys per project.
   * </pre>
   */
  public static final class PredictionApiKeyRegistryBlockingStub extends io.grpc.stub.AbstractBlockingStub<PredictionApiKeyRegistryBlockingStub> {
    private PredictionApiKeyRegistryBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PredictionApiKeyRegistryBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PredictionApiKeyRegistryBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Register an API key for use with predict method.
     * </pre>
     */
    public com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration createPredictionApiKeyRegistration(com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePredictionApiKeyRegistrationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List the registered apiKeys for use with predict method.
     * </pre>
     */
    public com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse listPredictionApiKeyRegistrations(com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPredictionApiKeyRegistrationsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unregister an apiKey from using for predict method.
     * </pre>
     */
    public com.google.protobuf.Empty deletePredictionApiKeyRegistration(com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePredictionApiKeyRegistrationMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service for registering API keys for use with the `predict` method. If you
   * use an API key to request predictions, you must first register the API key.
   * Otherwise, your prediction request is rejected. If you use OAuth to
   * authenticate your `predict` method call, you do not need to register an API
   * key. You can register up to 20 API keys per project.
   * </pre>
   */
  public static final class PredictionApiKeyRegistryFutureStub extends io.grpc.stub.AbstractFutureStub<PredictionApiKeyRegistryFutureStub> {
    private PredictionApiKeyRegistryFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PredictionApiKeyRegistryFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PredictionApiKeyRegistryFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Register an API key for use with predict method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration> createPredictionApiKeyRegistration(
        com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePredictionApiKeyRegistrationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List the registered apiKeys for use with predict method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse> listPredictionApiKeyRegistrations(
        com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPredictionApiKeyRegistrationsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Unregister an apiKey from using for predict method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deletePredictionApiKeyRegistration(
        com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePredictionApiKeyRegistrationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PREDICTION_API_KEY_REGISTRATION = 0;
  private static final int METHODID_LIST_PREDICTION_API_KEY_REGISTRATIONS = 1;
  private static final int METHODID_DELETE_PREDICTION_API_KEY_REGISTRATION = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PredictionApiKeyRegistryImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PredictionApiKeyRegistryImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_PREDICTION_API_KEY_REGISTRATION:
          serviceImpl.createPredictionApiKeyRegistration((com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration>) responseObserver);
          break;
        case METHODID_LIST_PREDICTION_API_KEY_REGISTRATIONS:
          serviceImpl.listPredictionApiKeyRegistrations((com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse>) responseObserver);
          break;
        case METHODID_DELETE_PREDICTION_API_KEY_REGISTRATION:
          serviceImpl.deletePredictionApiKeyRegistration((com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class PredictionApiKeyRegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PredictionApiKeyRegistryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.recommendationengine.v1beta1.PredictionApikeyRegistryService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PredictionApiKeyRegistry");
    }
  }

  private static final class PredictionApiKeyRegistryFileDescriptorSupplier
      extends PredictionApiKeyRegistryBaseDescriptorSupplier {
    PredictionApiKeyRegistryFileDescriptorSupplier() {}
  }

  private static final class PredictionApiKeyRegistryMethodDescriptorSupplier
      extends PredictionApiKeyRegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PredictionApiKeyRegistryMethodDescriptorSupplier(String methodName) {
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
      synchronized (PredictionApiKeyRegistryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PredictionApiKeyRegistryFileDescriptorSupplier())
              .addMethod(getCreatePredictionApiKeyRegistrationMethod())
              .addMethod(getListPredictionApiKeyRegistrationsMethod())
              .addMethod(getDeletePredictionApiKeyRegistrationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
