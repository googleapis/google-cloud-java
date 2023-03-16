package com.google.cloud.discoveryengine.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for making recommendations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1beta/recommendation_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RecommendationServiceGrpc {

  private RecommendationServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.discoveryengine.v1beta.RecommendationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1beta.RecommendRequest,
      com.google.cloud.discoveryengine.v1beta.RecommendResponse> getRecommendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Recommend",
      requestType = com.google.cloud.discoveryengine.v1beta.RecommendRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.RecommendResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1beta.RecommendRequest,
      com.google.cloud.discoveryengine.v1beta.RecommendResponse> getRecommendMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1beta.RecommendRequest, com.google.cloud.discoveryengine.v1beta.RecommendResponse> getRecommendMethod;
    if ((getRecommendMethod = RecommendationServiceGrpc.getRecommendMethod) == null) {
      synchronized (RecommendationServiceGrpc.class) {
        if ((getRecommendMethod = RecommendationServiceGrpc.getRecommendMethod) == null) {
          RecommendationServiceGrpc.getRecommendMethod = getRecommendMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1beta.RecommendRequest, com.google.cloud.discoveryengine.v1beta.RecommendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Recommend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1beta.RecommendRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1beta.RecommendResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecommendationServiceMethodDescriptorSupplier("Recommend"))
              .build();
        }
      }
    }
    return getRecommendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecommendationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceStub>() {
        @java.lang.Override
        public RecommendationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecommendationServiceStub(channel, callOptions);
        }
      };
    return RecommendationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecommendationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceBlockingStub>() {
        @java.lang.Override
        public RecommendationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecommendationServiceBlockingStub(channel, callOptions);
        }
      };
    return RecommendationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecommendationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceFutureStub>() {
        @java.lang.Override
        public RecommendationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecommendationServiceFutureStub(channel, callOptions);
        }
      };
    return RecommendationServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for making recommendations.
   * </pre>
   */
  public static abstract class RecommendationServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Makes a recommendation, which requires a contextual user event.
     * </pre>
     */
    public void recommend(com.google.cloud.discoveryengine.v1beta.RecommendRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.RecommendResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRecommendMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRecommendMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.discoveryengine.v1beta.RecommendRequest,
                com.google.cloud.discoveryengine.v1beta.RecommendResponse>(
                  this, METHODID_RECOMMEND)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for making recommendations.
   * </pre>
   */
  public static final class RecommendationServiceStub extends io.grpc.stub.AbstractAsyncStub<RecommendationServiceStub> {
    private RecommendationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommendationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommendationServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Makes a recommendation, which requires a contextual user event.
     * </pre>
     */
    public void recommend(com.google.cloud.discoveryengine.v1beta.RecommendRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.RecommendResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRecommendMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service for making recommendations.
   * </pre>
   */
  public static final class RecommendationServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RecommendationServiceBlockingStub> {
    private RecommendationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommendationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommendationServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Makes a recommendation, which requires a contextual user event.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.RecommendResponse recommend(com.google.cloud.discoveryengine.v1beta.RecommendRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRecommendMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service for making recommendations.
   * </pre>
   */
  public static final class RecommendationServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RecommendationServiceFutureStub> {
    private RecommendationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommendationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommendationServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Makes a recommendation, which requires a contextual user event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.discoveryengine.v1beta.RecommendResponse> recommend(
        com.google.cloud.discoveryengine.v1beta.RecommendRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRecommendMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RECOMMEND = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecommendationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecommendationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECOMMEND:
          serviceImpl.recommend((com.google.cloud.discoveryengine.v1beta.RecommendRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.RecommendResponse>) responseObserver);
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

  private static abstract class RecommendationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecommendationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1beta.RecommendationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecommendationService");
    }
  }

  private static final class RecommendationServiceFileDescriptorSupplier
      extends RecommendationServiceBaseDescriptorSupplier {
    RecommendationServiceFileDescriptorSupplier() {}
  }

  private static final class RecommendationServiceMethodDescriptorSupplier
      extends RecommendationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecommendationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RecommendationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecommendationServiceFileDescriptorSupplier())
              .addMethod(getRecommendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
