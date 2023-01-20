package com.google.maps.addressvalidation.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The service for validating addresses.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/maps/addressvalidation/v1/address_validation_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AddressValidationGrpc {

  private AddressValidationGrpc() {}

  public static final String SERVICE_NAME = "google.maps.addressvalidation.v1.AddressValidation";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.maps.addressvalidation.v1.ValidateAddressRequest,
      com.google.maps.addressvalidation.v1.ValidateAddressResponse> getValidateAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateAddress",
      requestType = com.google.maps.addressvalidation.v1.ValidateAddressRequest.class,
      responseType = com.google.maps.addressvalidation.v1.ValidateAddressResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.maps.addressvalidation.v1.ValidateAddressRequest,
      com.google.maps.addressvalidation.v1.ValidateAddressResponse> getValidateAddressMethod() {
    io.grpc.MethodDescriptor<com.google.maps.addressvalidation.v1.ValidateAddressRequest, com.google.maps.addressvalidation.v1.ValidateAddressResponse> getValidateAddressMethod;
    if ((getValidateAddressMethod = AddressValidationGrpc.getValidateAddressMethod) == null) {
      synchronized (AddressValidationGrpc.class) {
        if ((getValidateAddressMethod = AddressValidationGrpc.getValidateAddressMethod) == null) {
          AddressValidationGrpc.getValidateAddressMethod = getValidateAddressMethod =
              io.grpc.MethodDescriptor.<com.google.maps.addressvalidation.v1.ValidateAddressRequest, com.google.maps.addressvalidation.v1.ValidateAddressResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateAddress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.maps.addressvalidation.v1.ValidateAddressRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.maps.addressvalidation.v1.ValidateAddressResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AddressValidationMethodDescriptorSupplier("ValidateAddress"))
              .build();
        }
      }
    }
    return getValidateAddressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest,
      com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse> getProvideValidationFeedbackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProvideValidationFeedback",
      requestType = com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest.class,
      responseType = com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest,
      com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse> getProvideValidationFeedbackMethod() {
    io.grpc.MethodDescriptor<com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest, com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse> getProvideValidationFeedbackMethod;
    if ((getProvideValidationFeedbackMethod = AddressValidationGrpc.getProvideValidationFeedbackMethod) == null) {
      synchronized (AddressValidationGrpc.class) {
        if ((getProvideValidationFeedbackMethod = AddressValidationGrpc.getProvideValidationFeedbackMethod) == null) {
          AddressValidationGrpc.getProvideValidationFeedbackMethod = getProvideValidationFeedbackMethod =
              io.grpc.MethodDescriptor.<com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest, com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProvideValidationFeedback"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AddressValidationMethodDescriptorSupplier("ProvideValidationFeedback"))
              .build();
        }
      }
    }
    return getProvideValidationFeedbackMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AddressValidationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddressValidationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddressValidationStub>() {
        @java.lang.Override
        public AddressValidationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddressValidationStub(channel, callOptions);
        }
      };
    return AddressValidationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AddressValidationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddressValidationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddressValidationBlockingStub>() {
        @java.lang.Override
        public AddressValidationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddressValidationBlockingStub(channel, callOptions);
        }
      };
    return AddressValidationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AddressValidationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddressValidationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddressValidationFutureStub>() {
        @java.lang.Override
        public AddressValidationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddressValidationFutureStub(channel, callOptions);
        }
      };
    return AddressValidationFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The service for validating addresses.
   * </pre>
   */
  public static abstract class AddressValidationImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Validates an address.
     * </pre>
     */
    public void validateAddress(com.google.maps.addressvalidation.v1.ValidateAddressRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.addressvalidation.v1.ValidateAddressResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateAddressMethod(), responseObserver);
    }

    /**
     * <pre>
     * Feedback about the outcome of the sequence of validation attempts. This
     * should be the last call made after a sequence of validation calls for the
     * same address, and should be called once the transaction is concluded. This
     * should only be sent once for the sequence of `ValidateAddress` requests
     * needed to validate an address fully.
     * </pre>
     */
    public void provideValidationFeedback(com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProvideValidationFeedbackMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getValidateAddressMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.maps.addressvalidation.v1.ValidateAddressRequest,
                com.google.maps.addressvalidation.v1.ValidateAddressResponse>(
                  this, METHODID_VALIDATE_ADDRESS)))
          .addMethod(
            getProvideValidationFeedbackMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest,
                com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse>(
                  this, METHODID_PROVIDE_VALIDATION_FEEDBACK)))
          .build();
    }
  }

  /**
   * <pre>
   * The service for validating addresses.
   * </pre>
   */
  public static final class AddressValidationStub extends io.grpc.stub.AbstractAsyncStub<AddressValidationStub> {
    private AddressValidationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressValidationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddressValidationStub(channel, callOptions);
    }

    /**
     * <pre>
     * Validates an address.
     * </pre>
     */
    public void validateAddress(com.google.maps.addressvalidation.v1.ValidateAddressRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.addressvalidation.v1.ValidateAddressResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateAddressMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Feedback about the outcome of the sequence of validation attempts. This
     * should be the last call made after a sequence of validation calls for the
     * same address, and should be called once the transaction is concluded. This
     * should only be sent once for the sequence of `ValidateAddress` requests
     * needed to validate an address fully.
     * </pre>
     */
    public void provideValidationFeedback(com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProvideValidationFeedbackMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The service for validating addresses.
   * </pre>
   */
  public static final class AddressValidationBlockingStub extends io.grpc.stub.AbstractBlockingStub<AddressValidationBlockingStub> {
    private AddressValidationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressValidationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddressValidationBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Validates an address.
     * </pre>
     */
    public com.google.maps.addressvalidation.v1.ValidateAddressResponse validateAddress(com.google.maps.addressvalidation.v1.ValidateAddressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateAddressMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Feedback about the outcome of the sequence of validation attempts. This
     * should be the last call made after a sequence of validation calls for the
     * same address, and should be called once the transaction is concluded. This
     * should only be sent once for the sequence of `ValidateAddress` requests
     * needed to validate an address fully.
     * </pre>
     */
    public com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse provideValidationFeedback(com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProvideValidationFeedbackMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The service for validating addresses.
   * </pre>
   */
  public static final class AddressValidationFutureStub extends io.grpc.stub.AbstractFutureStub<AddressValidationFutureStub> {
    private AddressValidationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressValidationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddressValidationFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Validates an address.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.maps.addressvalidation.v1.ValidateAddressResponse> validateAddress(
        com.google.maps.addressvalidation.v1.ValidateAddressRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateAddressMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Feedback about the outcome of the sequence of validation attempts. This
     * should be the last call made after a sequence of validation calls for the
     * same address, and should be called once the transaction is concluded. This
     * should only be sent once for the sequence of `ValidateAddress` requests
     * needed to validate an address fully.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse> provideValidationFeedback(
        com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProvideValidationFeedbackMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VALIDATE_ADDRESS = 0;
  private static final int METHODID_PROVIDE_VALIDATION_FEEDBACK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AddressValidationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AddressValidationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VALIDATE_ADDRESS:
          serviceImpl.validateAddress((com.google.maps.addressvalidation.v1.ValidateAddressRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.addressvalidation.v1.ValidateAddressResponse>) responseObserver);
          break;
        case METHODID_PROVIDE_VALIDATION_FEEDBACK:
          serviceImpl.provideValidationFeedback((com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse>) responseObserver);
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

  private static abstract class AddressValidationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AddressValidationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.maps.addressvalidation.v1.AddressValidationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AddressValidation");
    }
  }

  private static final class AddressValidationFileDescriptorSupplier
      extends AddressValidationBaseDescriptorSupplier {
    AddressValidationFileDescriptorSupplier() {}
  }

  private static final class AddressValidationMethodDescriptorSupplier
      extends AddressValidationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AddressValidationMethodDescriptorSupplier(String methodName) {
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
      synchronized (AddressValidationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AddressValidationFileDescriptorSupplier())
              .addMethod(getValidateAddressMethod())
              .addMethod(getProvideValidationFeedbackMethod())
              .build();
        }
      }
    }
    return result;
  }
}
