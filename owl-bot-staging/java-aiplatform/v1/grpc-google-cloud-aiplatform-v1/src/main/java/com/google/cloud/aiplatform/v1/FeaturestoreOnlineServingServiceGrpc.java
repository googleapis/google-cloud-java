package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service for serving online feature values.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/featurestore_online_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FeaturestoreOnlineServingServiceGrpc {

  private FeaturestoreOnlineServingServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1.FeaturestoreOnlineServingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ReadFeatureValuesRequest,
      com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse> getReadFeatureValuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadFeatureValues",
      requestType = com.google.cloud.aiplatform.v1.ReadFeatureValuesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ReadFeatureValuesRequest,
      com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse> getReadFeatureValuesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ReadFeatureValuesRequest, com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse> getReadFeatureValuesMethod;
    if ((getReadFeatureValuesMethod = FeaturestoreOnlineServingServiceGrpc.getReadFeatureValuesMethod) == null) {
      synchronized (FeaturestoreOnlineServingServiceGrpc.class) {
        if ((getReadFeatureValuesMethod = FeaturestoreOnlineServingServiceGrpc.getReadFeatureValuesMethod) == null) {
          FeaturestoreOnlineServingServiceGrpc.getReadFeatureValuesMethod = getReadFeatureValuesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.ReadFeatureValuesRequest, com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadFeatureValues"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ReadFeatureValuesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FeaturestoreOnlineServingServiceMethodDescriptorSupplier("ReadFeatureValues"))
              .build();
        }
      }
    }
    return getReadFeatureValuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.StreamingReadFeatureValuesRequest,
      com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse> getStreamingReadFeatureValuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingReadFeatureValues",
      requestType = com.google.cloud.aiplatform.v1.StreamingReadFeatureValuesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.StreamingReadFeatureValuesRequest,
      com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse> getStreamingReadFeatureValuesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.StreamingReadFeatureValuesRequest, com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse> getStreamingReadFeatureValuesMethod;
    if ((getStreamingReadFeatureValuesMethod = FeaturestoreOnlineServingServiceGrpc.getStreamingReadFeatureValuesMethod) == null) {
      synchronized (FeaturestoreOnlineServingServiceGrpc.class) {
        if ((getStreamingReadFeatureValuesMethod = FeaturestoreOnlineServingServiceGrpc.getStreamingReadFeatureValuesMethod) == null) {
          FeaturestoreOnlineServingServiceGrpc.getStreamingReadFeatureValuesMethod = getStreamingReadFeatureValuesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.StreamingReadFeatureValuesRequest, com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamingReadFeatureValues"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.StreamingReadFeatureValuesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FeaturestoreOnlineServingServiceMethodDescriptorSupplier("StreamingReadFeatureValues"))
              .build();
        }
      }
    }
    return getStreamingReadFeatureValuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.WriteFeatureValuesRequest,
      com.google.cloud.aiplatform.v1.WriteFeatureValuesResponse> getWriteFeatureValuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteFeatureValues",
      requestType = com.google.cloud.aiplatform.v1.WriteFeatureValuesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.WriteFeatureValuesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.WriteFeatureValuesRequest,
      com.google.cloud.aiplatform.v1.WriteFeatureValuesResponse> getWriteFeatureValuesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.WriteFeatureValuesRequest, com.google.cloud.aiplatform.v1.WriteFeatureValuesResponse> getWriteFeatureValuesMethod;
    if ((getWriteFeatureValuesMethod = FeaturestoreOnlineServingServiceGrpc.getWriteFeatureValuesMethod) == null) {
      synchronized (FeaturestoreOnlineServingServiceGrpc.class) {
        if ((getWriteFeatureValuesMethod = FeaturestoreOnlineServingServiceGrpc.getWriteFeatureValuesMethod) == null) {
          FeaturestoreOnlineServingServiceGrpc.getWriteFeatureValuesMethod = getWriteFeatureValuesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.WriteFeatureValuesRequest, com.google.cloud.aiplatform.v1.WriteFeatureValuesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteFeatureValues"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.WriteFeatureValuesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.WriteFeatureValuesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FeaturestoreOnlineServingServiceMethodDescriptorSupplier("WriteFeatureValues"))
              .build();
        }
      }
    }
    return getWriteFeatureValuesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FeaturestoreOnlineServingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeaturestoreOnlineServingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FeaturestoreOnlineServingServiceStub>() {
        @java.lang.Override
        public FeaturestoreOnlineServingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FeaturestoreOnlineServingServiceStub(channel, callOptions);
        }
      };
    return FeaturestoreOnlineServingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FeaturestoreOnlineServingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeaturestoreOnlineServingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FeaturestoreOnlineServingServiceBlockingStub>() {
        @java.lang.Override
        public FeaturestoreOnlineServingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FeaturestoreOnlineServingServiceBlockingStub(channel, callOptions);
        }
      };
    return FeaturestoreOnlineServingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FeaturestoreOnlineServingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeaturestoreOnlineServingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FeaturestoreOnlineServingServiceFutureStub>() {
        @java.lang.Override
        public FeaturestoreOnlineServingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FeaturestoreOnlineServingServiceFutureStub(channel, callOptions);
        }
      };
    return FeaturestoreOnlineServingServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service for serving online feature values.
   * </pre>
   */
  public static abstract class FeaturestoreOnlineServingServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Reads Feature values of a specific entity of an EntityType. For reading
     * feature values of multiple entities of an EntityType, please use
     * StreamingReadFeatureValues.
     * </pre>
     */
    public void readFeatureValues(com.google.cloud.aiplatform.v1.ReadFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadFeatureValuesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Reads Feature values for multiple entities. Depending on their size, data
     * for different entities may be broken
     * up across multiple responses.
     * </pre>
     */
    public void streamingReadFeatureValues(com.google.cloud.aiplatform.v1.StreamingReadFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamingReadFeatureValuesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Writes Feature values of one or more entities of an EntityType.
     * The Feature values are merged into existing entities if any. The Feature
     * values to be written must have timestamp within the online storage
     * retention.
     * </pre>
     */
    public void writeFeatureValues(com.google.cloud.aiplatform.v1.WriteFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.WriteFeatureValuesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteFeatureValuesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReadFeatureValuesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.ReadFeatureValuesRequest,
                com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse>(
                  this, METHODID_READ_FEATURE_VALUES)))
          .addMethod(
            getStreamingReadFeatureValuesMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.StreamingReadFeatureValuesRequest,
                com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse>(
                  this, METHODID_STREAMING_READ_FEATURE_VALUES)))
          .addMethod(
            getWriteFeatureValuesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.WriteFeatureValuesRequest,
                com.google.cloud.aiplatform.v1.WriteFeatureValuesResponse>(
                  this, METHODID_WRITE_FEATURE_VALUES)))
          .build();
    }
  }

  /**
   * <pre>
   * A service for serving online feature values.
   * </pre>
   */
  public static final class FeaturestoreOnlineServingServiceStub extends io.grpc.stub.AbstractAsyncStub<FeaturestoreOnlineServingServiceStub> {
    private FeaturestoreOnlineServingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeaturestoreOnlineServingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeaturestoreOnlineServingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Reads Feature values of a specific entity of an EntityType. For reading
     * feature values of multiple entities of an EntityType, please use
     * StreamingReadFeatureValues.
     * </pre>
     */
    public void readFeatureValues(com.google.cloud.aiplatform.v1.ReadFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadFeatureValuesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Reads Feature values for multiple entities. Depending on their size, data
     * for different entities may be broken
     * up across multiple responses.
     * </pre>
     */
    public void streamingReadFeatureValues(com.google.cloud.aiplatform.v1.StreamingReadFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamingReadFeatureValuesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Writes Feature values of one or more entities of an EntityType.
     * The Feature values are merged into existing entities if any. The Feature
     * values to be written must have timestamp within the online storage
     * retention.
     * </pre>
     */
    public void writeFeatureValues(com.google.cloud.aiplatform.v1.WriteFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.WriteFeatureValuesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteFeatureValuesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * A service for serving online feature values.
   * </pre>
   */
  public static final class FeaturestoreOnlineServingServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FeaturestoreOnlineServingServiceBlockingStub> {
    private FeaturestoreOnlineServingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeaturestoreOnlineServingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeaturestoreOnlineServingServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Reads Feature values of a specific entity of an EntityType. For reading
     * feature values of multiple entities of an EntityType, please use
     * StreamingReadFeatureValues.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse readFeatureValues(com.google.cloud.aiplatform.v1.ReadFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadFeatureValuesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Reads Feature values for multiple entities. Depending on their size, data
     * for different entities may be broken
     * up across multiple responses.
     * </pre>
     */
    public java.util.Iterator<com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse> streamingReadFeatureValues(
        com.google.cloud.aiplatform.v1.StreamingReadFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamingReadFeatureValuesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Writes Feature values of one or more entities of an EntityType.
     * The Feature values are merged into existing entities if any. The Feature
     * values to be written must have timestamp within the online storage
     * retention.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.WriteFeatureValuesResponse writeFeatureValues(com.google.cloud.aiplatform.v1.WriteFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteFeatureValuesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A service for serving online feature values.
   * </pre>
   */
  public static final class FeaturestoreOnlineServingServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FeaturestoreOnlineServingServiceFutureStub> {
    private FeaturestoreOnlineServingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeaturestoreOnlineServingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeaturestoreOnlineServingServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Reads Feature values of a specific entity of an EntityType. For reading
     * feature values of multiple entities of an EntityType, please use
     * StreamingReadFeatureValues.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse> readFeatureValues(
        com.google.cloud.aiplatform.v1.ReadFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadFeatureValuesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Writes Feature values of one or more entities of an EntityType.
     * The Feature values are merged into existing entities if any. The Feature
     * values to be written must have timestamp within the online storage
     * retention.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.WriteFeatureValuesResponse> writeFeatureValues(
        com.google.cloud.aiplatform.v1.WriteFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteFeatureValuesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_READ_FEATURE_VALUES = 0;
  private static final int METHODID_STREAMING_READ_FEATURE_VALUES = 1;
  private static final int METHODID_WRITE_FEATURE_VALUES = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FeaturestoreOnlineServingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FeaturestoreOnlineServingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_READ_FEATURE_VALUES:
          serviceImpl.readFeatureValues((com.google.cloud.aiplatform.v1.ReadFeatureValuesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse>) responseObserver);
          break;
        case METHODID_STREAMING_READ_FEATURE_VALUES:
          serviceImpl.streamingReadFeatureValues((com.google.cloud.aiplatform.v1.StreamingReadFeatureValuesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ReadFeatureValuesResponse>) responseObserver);
          break;
        case METHODID_WRITE_FEATURE_VALUES:
          serviceImpl.writeFeatureValues((com.google.cloud.aiplatform.v1.WriteFeatureValuesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.WriteFeatureValuesResponse>) responseObserver);
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

  private static abstract class FeaturestoreOnlineServingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FeaturestoreOnlineServingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.FeaturestoreOnlineServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FeaturestoreOnlineServingService");
    }
  }

  private static final class FeaturestoreOnlineServingServiceFileDescriptorSupplier
      extends FeaturestoreOnlineServingServiceBaseDescriptorSupplier {
    FeaturestoreOnlineServingServiceFileDescriptorSupplier() {}
  }

  private static final class FeaturestoreOnlineServingServiceMethodDescriptorSupplier
      extends FeaturestoreOnlineServingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FeaturestoreOnlineServingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FeaturestoreOnlineServingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FeaturestoreOnlineServingServiceFileDescriptorSupplier())
              .addMethod(getReadFeatureValuesMethod())
              .addMethod(getStreamingReadFeatureValuesMethod())
              .addMethod(getWriteFeatureValuesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
