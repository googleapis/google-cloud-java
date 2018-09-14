package com.google.cloud.videointelligence.v1p2beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service that implements Google Cloud Video Intelligence API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/videointelligence/v1p2beta1/video_intelligence.proto")
public final class VideoIntelligenceServiceGrpc {

  private VideoIntelligenceServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.videointelligence.v1p2beta1.VideoIntelligenceService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAnnotateVideoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest,
      com.google.longrunning.Operation> METHOD_ANNOTATE_VIDEO = getAnnotateVideoMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest,
      com.google.longrunning.Operation> getAnnotateVideoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest,
      com.google.longrunning.Operation> getAnnotateVideoMethod() {
    return getAnnotateVideoMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest,
      com.google.longrunning.Operation> getAnnotateVideoMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest, com.google.longrunning.Operation> getAnnotateVideoMethod;
    if ((getAnnotateVideoMethod = VideoIntelligenceServiceGrpc.getAnnotateVideoMethod) == null) {
      synchronized (VideoIntelligenceServiceGrpc.class) {
        if ((getAnnotateVideoMethod = VideoIntelligenceServiceGrpc.getAnnotateVideoMethod) == null) {
          VideoIntelligenceServiceGrpc.getAnnotateVideoMethod = getAnnotateVideoMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.videointelligence.v1p2beta1.VideoIntelligenceService", "AnnotateVideo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new VideoIntelligenceServiceMethodDescriptorSupplier("AnnotateVideo"))
                  .build();
          }
        }
     }
     return getAnnotateVideoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VideoIntelligenceServiceStub newStub(io.grpc.Channel channel) {
    return new VideoIntelligenceServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VideoIntelligenceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VideoIntelligenceServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VideoIntelligenceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VideoIntelligenceServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service that implements Google Cloud Video Intelligence API.
   * </pre>
   */
  public static abstract class VideoIntelligenceServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Performs asynchronous video annotation. Progress and results can be
     * retrieved through the `google.longrunning.Operations` interface.
     * `Operation.metadata` contains `AnnotateVideoProgress` (progress).
     * `Operation.response` contains `AnnotateVideoResponse` (results).
     * </pre>
     */
    public void annotateVideo(com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getAnnotateVideoMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAnnotateVideoMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_ANNOTATE_VIDEO)))
          .build();
    }
  }

  /**
   * <pre>
   * Service that implements Google Cloud Video Intelligence API.
   * </pre>
   */
  public static final class VideoIntelligenceServiceStub extends io.grpc.stub.AbstractStub<VideoIntelligenceServiceStub> {
    private VideoIntelligenceServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VideoIntelligenceServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VideoIntelligenceServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VideoIntelligenceServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Performs asynchronous video annotation. Progress and results can be
     * retrieved through the `google.longrunning.Operations` interface.
     * `Operation.metadata` contains `AnnotateVideoProgress` (progress).
     * `Operation.response` contains `AnnotateVideoResponse` (results).
     * </pre>
     */
    public void annotateVideo(com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnnotateVideoMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service that implements Google Cloud Video Intelligence API.
   * </pre>
   */
  public static final class VideoIntelligenceServiceBlockingStub extends io.grpc.stub.AbstractStub<VideoIntelligenceServiceBlockingStub> {
    private VideoIntelligenceServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VideoIntelligenceServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VideoIntelligenceServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VideoIntelligenceServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Performs asynchronous video annotation. Progress and results can be
     * retrieved through the `google.longrunning.Operations` interface.
     * `Operation.metadata` contains `AnnotateVideoProgress` (progress).
     * `Operation.response` contains `AnnotateVideoResponse` (results).
     * </pre>
     */
    public com.google.longrunning.Operation annotateVideo(com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnnotateVideoMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service that implements Google Cloud Video Intelligence API.
   * </pre>
   */
  public static final class VideoIntelligenceServiceFutureStub extends io.grpc.stub.AbstractStub<VideoIntelligenceServiceFutureStub> {
    private VideoIntelligenceServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VideoIntelligenceServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VideoIntelligenceServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VideoIntelligenceServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Performs asynchronous video annotation. Progress and results can be
     * retrieved through the `google.longrunning.Operations` interface.
     * `Operation.metadata` contains `AnnotateVideoProgress` (progress).
     * `Operation.response` contains `AnnotateVideoResponse` (results).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> annotateVideo(
        com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnnotateVideoMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANNOTATE_VIDEO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VideoIntelligenceServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VideoIntelligenceServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ANNOTATE_VIDEO:
          serviceImpl.annotateVideo((com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest) request,
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

  private static abstract class VideoIntelligenceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VideoIntelligenceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.videointelligence.v1p2beta1.VideoIntelligenceServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VideoIntelligenceService");
    }
  }

  private static final class VideoIntelligenceServiceFileDescriptorSupplier
      extends VideoIntelligenceServiceBaseDescriptorSupplier {
    VideoIntelligenceServiceFileDescriptorSupplier() {}
  }

  private static final class VideoIntelligenceServiceMethodDescriptorSupplier
      extends VideoIntelligenceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VideoIntelligenceServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (VideoIntelligenceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VideoIntelligenceServiceFileDescriptorSupplier())
              .addMethod(getAnnotateVideoMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
