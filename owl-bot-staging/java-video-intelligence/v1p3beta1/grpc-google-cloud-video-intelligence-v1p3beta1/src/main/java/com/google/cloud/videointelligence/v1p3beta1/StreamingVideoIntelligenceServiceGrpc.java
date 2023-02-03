package com.google.cloud.videointelligence.v1p3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service that implements streaming Video Intelligence API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/videointelligence/v1p3beta1/video_intelligence.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StreamingVideoIntelligenceServiceGrpc {

  private StreamingVideoIntelligenceServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.videointelligence.v1p3beta1.StreamingVideoIntelligenceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoRequest,
      com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse> getStreamingAnnotateVideoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingAnnotateVideo",
      requestType = com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoRequest.class,
      responseType = com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoRequest,
      com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse> getStreamingAnnotateVideoMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoRequest, com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse> getStreamingAnnotateVideoMethod;
    if ((getStreamingAnnotateVideoMethod = StreamingVideoIntelligenceServiceGrpc.getStreamingAnnotateVideoMethod) == null) {
      synchronized (StreamingVideoIntelligenceServiceGrpc.class) {
        if ((getStreamingAnnotateVideoMethod = StreamingVideoIntelligenceServiceGrpc.getStreamingAnnotateVideoMethod) == null) {
          StreamingVideoIntelligenceServiceGrpc.getStreamingAnnotateVideoMethod = getStreamingAnnotateVideoMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoRequest, com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamingAnnotateVideo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StreamingVideoIntelligenceServiceMethodDescriptorSupplier("StreamingAnnotateVideo"))
              .build();
        }
      }
    }
    return getStreamingAnnotateVideoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StreamingVideoIntelligenceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingVideoIntelligenceServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamingVideoIntelligenceServiceStub>() {
        @java.lang.Override
        public StreamingVideoIntelligenceServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamingVideoIntelligenceServiceStub(channel, callOptions);
        }
      };
    return StreamingVideoIntelligenceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StreamingVideoIntelligenceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingVideoIntelligenceServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamingVideoIntelligenceServiceBlockingStub>() {
        @java.lang.Override
        public StreamingVideoIntelligenceServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamingVideoIntelligenceServiceBlockingStub(channel, callOptions);
        }
      };
    return StreamingVideoIntelligenceServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StreamingVideoIntelligenceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingVideoIntelligenceServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamingVideoIntelligenceServiceFutureStub>() {
        @java.lang.Override
        public StreamingVideoIntelligenceServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamingVideoIntelligenceServiceFutureStub(channel, callOptions);
        }
      };
    return StreamingVideoIntelligenceServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service that implements streaming Video Intelligence API.
   * </pre>
   */
  public static abstract class StreamingVideoIntelligenceServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Performs video annotation with bidirectional streaming: emitting results
     * while sending video/audio bytes.
     * This method is only available via the gRPC API (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoRequest> streamingAnnotateVideo(
        io.grpc.stub.StreamObserver<com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamingAnnotateVideoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamingAnnotateVideoMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoRequest,
                com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse>(
                  this, METHODID_STREAMING_ANNOTATE_VIDEO)))
          .build();
    }
  }

  /**
   * <pre>
   * Service that implements streaming Video Intelligence API.
   * </pre>
   */
  public static final class StreamingVideoIntelligenceServiceStub extends io.grpc.stub.AbstractAsyncStub<StreamingVideoIntelligenceServiceStub> {
    private StreamingVideoIntelligenceServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingVideoIntelligenceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingVideoIntelligenceServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Performs video annotation with bidirectional streaming: emitting results
     * while sending video/audio bytes.
     * This method is only available via the gRPC API (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoRequest> streamingAnnotateVideo(
        io.grpc.stub.StreamObserver<com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingAnnotateVideoMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service that implements streaming Video Intelligence API.
   * </pre>
   */
  public static final class StreamingVideoIntelligenceServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<StreamingVideoIntelligenceServiceBlockingStub> {
    private StreamingVideoIntelligenceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingVideoIntelligenceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingVideoIntelligenceServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Service that implements streaming Video Intelligence API.
   * </pre>
   */
  public static final class StreamingVideoIntelligenceServiceFutureStub extends io.grpc.stub.AbstractFutureStub<StreamingVideoIntelligenceServiceFutureStub> {
    private StreamingVideoIntelligenceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingVideoIntelligenceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingVideoIntelligenceServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAMING_ANNOTATE_VIDEO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StreamingVideoIntelligenceServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StreamingVideoIntelligenceServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAMING_ANNOTATE_VIDEO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamingAnnotateVideo(
              (io.grpc.stub.StreamObserver<com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StreamingVideoIntelligenceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StreamingVideoIntelligenceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.videointelligence.v1p3beta1.VideoIntelligenceServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StreamingVideoIntelligenceService");
    }
  }

  private static final class StreamingVideoIntelligenceServiceFileDescriptorSupplier
      extends StreamingVideoIntelligenceServiceBaseDescriptorSupplier {
    StreamingVideoIntelligenceServiceFileDescriptorSupplier() {}
  }

  private static final class StreamingVideoIntelligenceServiceMethodDescriptorSupplier
      extends StreamingVideoIntelligenceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StreamingVideoIntelligenceServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StreamingVideoIntelligenceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StreamingVideoIntelligenceServiceFileDescriptorSupplier())
              .addMethod(getStreamingAnnotateVideoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
