package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service for online predictions and explanations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/prediction_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PredictionServiceGrpc {

  private PredictionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.aiplatform.v1.PredictionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.PredictRequest,
      com.google.cloud.aiplatform.v1.PredictResponse> getPredictMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Predict",
      requestType = com.google.cloud.aiplatform.v1.PredictRequest.class,
      responseType = com.google.cloud.aiplatform.v1.PredictResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.PredictRequest,
      com.google.cloud.aiplatform.v1.PredictResponse> getPredictMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.PredictRequest, com.google.cloud.aiplatform.v1.PredictResponse> getPredictMethod;
    if ((getPredictMethod = PredictionServiceGrpc.getPredictMethod) == null) {
      synchronized (PredictionServiceGrpc.class) {
        if ((getPredictMethod = PredictionServiceGrpc.getPredictMethod) == null) {
          PredictionServiceGrpc.getPredictMethod = getPredictMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.PredictRequest, com.google.cloud.aiplatform.v1.PredictResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Predict"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.PredictRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.PredictResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PredictionServiceMethodDescriptorSupplier("Predict"))
              .build();
        }
      }
    }
    return getPredictMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.RawPredictRequest,
      com.google.api.HttpBody> getRawPredictMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RawPredict",
      requestType = com.google.cloud.aiplatform.v1.RawPredictRequest.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.RawPredictRequest,
      com.google.api.HttpBody> getRawPredictMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.RawPredictRequest, com.google.api.HttpBody> getRawPredictMethod;
    if ((getRawPredictMethod = PredictionServiceGrpc.getRawPredictMethod) == null) {
      synchronized (PredictionServiceGrpc.class) {
        if ((getRawPredictMethod = PredictionServiceGrpc.getRawPredictMethod) == null) {
          PredictionServiceGrpc.getRawPredictMethod = getRawPredictMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.RawPredictRequest, com.google.api.HttpBody>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RawPredict"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.RawPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.HttpBody.getDefaultInstance()))
              .setSchemaDescriptor(new PredictionServiceMethodDescriptorSupplier("RawPredict"))
              .build();
        }
      }
    }
    return getRawPredictMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DirectPredictRequest,
      com.google.cloud.aiplatform.v1.DirectPredictResponse> getDirectPredictMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DirectPredict",
      requestType = com.google.cloud.aiplatform.v1.DirectPredictRequest.class,
      responseType = com.google.cloud.aiplatform.v1.DirectPredictResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DirectPredictRequest,
      com.google.cloud.aiplatform.v1.DirectPredictResponse> getDirectPredictMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DirectPredictRequest, com.google.cloud.aiplatform.v1.DirectPredictResponse> getDirectPredictMethod;
    if ((getDirectPredictMethod = PredictionServiceGrpc.getDirectPredictMethod) == null) {
      synchronized (PredictionServiceGrpc.class) {
        if ((getDirectPredictMethod = PredictionServiceGrpc.getDirectPredictMethod) == null) {
          PredictionServiceGrpc.getDirectPredictMethod = getDirectPredictMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.DirectPredictRequest, com.google.cloud.aiplatform.v1.DirectPredictResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DirectPredict"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.DirectPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.DirectPredictResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PredictionServiceMethodDescriptorSupplier("DirectPredict"))
              .build();
        }
      }
    }
    return getDirectPredictMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DirectRawPredictRequest,
      com.google.cloud.aiplatform.v1.DirectRawPredictResponse> getDirectRawPredictMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DirectRawPredict",
      requestType = com.google.cloud.aiplatform.v1.DirectRawPredictRequest.class,
      responseType = com.google.cloud.aiplatform.v1.DirectRawPredictResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DirectRawPredictRequest,
      com.google.cloud.aiplatform.v1.DirectRawPredictResponse> getDirectRawPredictMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DirectRawPredictRequest, com.google.cloud.aiplatform.v1.DirectRawPredictResponse> getDirectRawPredictMethod;
    if ((getDirectRawPredictMethod = PredictionServiceGrpc.getDirectRawPredictMethod) == null) {
      synchronized (PredictionServiceGrpc.class) {
        if ((getDirectRawPredictMethod = PredictionServiceGrpc.getDirectRawPredictMethod) == null) {
          PredictionServiceGrpc.getDirectRawPredictMethod = getDirectRawPredictMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.DirectRawPredictRequest, com.google.cloud.aiplatform.v1.DirectRawPredictResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DirectRawPredict"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.DirectRawPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.DirectRawPredictResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PredictionServiceMethodDescriptorSupplier("DirectRawPredict"))
              .build();
        }
      }
    }
    return getDirectRawPredictMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.StreamingPredictRequest,
      com.google.cloud.aiplatform.v1.StreamingPredictResponse> getStreamingPredictMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingPredict",
      requestType = com.google.cloud.aiplatform.v1.StreamingPredictRequest.class,
      responseType = com.google.cloud.aiplatform.v1.StreamingPredictResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.StreamingPredictRequest,
      com.google.cloud.aiplatform.v1.StreamingPredictResponse> getStreamingPredictMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.StreamingPredictRequest, com.google.cloud.aiplatform.v1.StreamingPredictResponse> getStreamingPredictMethod;
    if ((getStreamingPredictMethod = PredictionServiceGrpc.getStreamingPredictMethod) == null) {
      synchronized (PredictionServiceGrpc.class) {
        if ((getStreamingPredictMethod = PredictionServiceGrpc.getStreamingPredictMethod) == null) {
          PredictionServiceGrpc.getStreamingPredictMethod = getStreamingPredictMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.StreamingPredictRequest, com.google.cloud.aiplatform.v1.StreamingPredictResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamingPredict"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.StreamingPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.StreamingPredictResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PredictionServiceMethodDescriptorSupplier("StreamingPredict"))
              .build();
        }
      }
    }
    return getStreamingPredictMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.StreamingPredictRequest,
      com.google.cloud.aiplatform.v1.StreamingPredictResponse> getServerStreamingPredictMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ServerStreamingPredict",
      requestType = com.google.cloud.aiplatform.v1.StreamingPredictRequest.class,
      responseType = com.google.cloud.aiplatform.v1.StreamingPredictResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.StreamingPredictRequest,
      com.google.cloud.aiplatform.v1.StreamingPredictResponse> getServerStreamingPredictMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.StreamingPredictRequest, com.google.cloud.aiplatform.v1.StreamingPredictResponse> getServerStreamingPredictMethod;
    if ((getServerStreamingPredictMethod = PredictionServiceGrpc.getServerStreamingPredictMethod) == null) {
      synchronized (PredictionServiceGrpc.class) {
        if ((getServerStreamingPredictMethod = PredictionServiceGrpc.getServerStreamingPredictMethod) == null) {
          PredictionServiceGrpc.getServerStreamingPredictMethod = getServerStreamingPredictMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.StreamingPredictRequest, com.google.cloud.aiplatform.v1.StreamingPredictResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ServerStreamingPredict"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.StreamingPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.StreamingPredictResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PredictionServiceMethodDescriptorSupplier("ServerStreamingPredict"))
              .build();
        }
      }
    }
    return getServerStreamingPredictMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.StreamingRawPredictRequest,
      com.google.cloud.aiplatform.v1.StreamingRawPredictResponse> getStreamingRawPredictMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingRawPredict",
      requestType = com.google.cloud.aiplatform.v1.StreamingRawPredictRequest.class,
      responseType = com.google.cloud.aiplatform.v1.StreamingRawPredictResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.StreamingRawPredictRequest,
      com.google.cloud.aiplatform.v1.StreamingRawPredictResponse> getStreamingRawPredictMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.StreamingRawPredictRequest, com.google.cloud.aiplatform.v1.StreamingRawPredictResponse> getStreamingRawPredictMethod;
    if ((getStreamingRawPredictMethod = PredictionServiceGrpc.getStreamingRawPredictMethod) == null) {
      synchronized (PredictionServiceGrpc.class) {
        if ((getStreamingRawPredictMethod = PredictionServiceGrpc.getStreamingRawPredictMethod) == null) {
          PredictionServiceGrpc.getStreamingRawPredictMethod = getStreamingRawPredictMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.StreamingRawPredictRequest, com.google.cloud.aiplatform.v1.StreamingRawPredictResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamingRawPredict"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.StreamingRawPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.StreamingRawPredictResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PredictionServiceMethodDescriptorSupplier("StreamingRawPredict"))
              .build();
        }
      }
    }
    return getStreamingRawPredictMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ExplainRequest,
      com.google.cloud.aiplatform.v1.ExplainResponse> getExplainMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Explain",
      requestType = com.google.cloud.aiplatform.v1.ExplainRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ExplainResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ExplainRequest,
      com.google.cloud.aiplatform.v1.ExplainResponse> getExplainMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ExplainRequest, com.google.cloud.aiplatform.v1.ExplainResponse> getExplainMethod;
    if ((getExplainMethod = PredictionServiceGrpc.getExplainMethod) == null) {
      synchronized (PredictionServiceGrpc.class) {
        if ((getExplainMethod = PredictionServiceGrpc.getExplainMethod) == null) {
          PredictionServiceGrpc.getExplainMethod = getExplainMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.ExplainRequest, com.google.cloud.aiplatform.v1.ExplainResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Explain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ExplainRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ExplainResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PredictionServiceMethodDescriptorSupplier("Explain"))
              .build();
        }
      }
    }
    return getExplainMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PredictionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PredictionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PredictionServiceStub>() {
        @java.lang.Override
        public PredictionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PredictionServiceStub(channel, callOptions);
        }
      };
    return PredictionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PredictionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PredictionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PredictionServiceBlockingStub>() {
        @java.lang.Override
        public PredictionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PredictionServiceBlockingStub(channel, callOptions);
        }
      };
    return PredictionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PredictionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PredictionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PredictionServiceFutureStub>() {
        @java.lang.Override
        public PredictionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PredictionServiceFutureStub(channel, callOptions);
        }
      };
    return PredictionServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service for online predictions and explanations.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Perform an online prediction.
     * </pre>
     */
    default void predict(com.google.cloud.aiplatform.v1.PredictRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.PredictResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPredictMethod(), responseObserver);
    }

    /**
     * <pre>
     * Perform an online prediction with an arbitrary HTTP payload.
     * The response includes the following HTTP headers:
     * * `X-Vertex-AI-Endpoint-Id`: ID of the
     * [Endpoint][google.cloud.aiplatform.v1.Endpoint] that served this
     * prediction.
     * * `X-Vertex-AI-Deployed-Model-Id`: ID of the Endpoint's
     * [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] that served this
     * prediction.
     * </pre>
     */
    default void rawPredict(com.google.cloud.aiplatform.v1.RawPredictRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRawPredictMethod(), responseObserver);
    }

    /**
     * <pre>
     * Perform an unary online prediction request for Vertex first-party products
     * and frameworks.
     * </pre>
     */
    default void directPredict(com.google.cloud.aiplatform.v1.DirectPredictRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.DirectPredictResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDirectPredictMethod(), responseObserver);
    }

    /**
     * <pre>
     * Perform an online prediction request through gRPC.
     * </pre>
     */
    default void directRawPredict(com.google.cloud.aiplatform.v1.DirectRawPredictRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.DirectRawPredictResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDirectRawPredictMethod(), responseObserver);
    }

    /**
     * <pre>
     * Perform a streaming online prediction request for Vertex first-party
     * products and frameworks.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.StreamingPredictRequest> streamingPredict(
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.StreamingPredictResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamingPredictMethod(), responseObserver);
    }

    /**
     * <pre>
     * Perform a server-side streaming online prediction request for Vertex
     * LLM streaming.
     * </pre>
     */
    default void serverStreamingPredict(com.google.cloud.aiplatform.v1.StreamingPredictRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.StreamingPredictResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getServerStreamingPredictMethod(), responseObserver);
    }

    /**
     * <pre>
     * Perform a streaming online prediction request through gRPC.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.StreamingRawPredictRequest> streamingRawPredict(
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.StreamingRawPredictResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamingRawPredictMethod(), responseObserver);
    }

    /**
     * <pre>
     * Perform an online explanation.
     * If
     * [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id]
     * is specified, the corresponding DeployModel must have
     * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec]
     * populated. If
     * [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id]
     * is not specified, all DeployedModels must have
     * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec]
     * populated.
     * </pre>
     */
    default void explain(com.google.cloud.aiplatform.v1.ExplainRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ExplainResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExplainMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PredictionService.
   * <pre>
   * A service for online predictions and explanations.
   * </pre>
   */
  public static abstract class PredictionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PredictionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PredictionService.
   * <pre>
   * A service for online predictions and explanations.
   * </pre>
   */
  public static final class PredictionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PredictionServiceStub> {
    private PredictionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PredictionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PredictionServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Perform an online prediction.
     * </pre>
     */
    public void predict(com.google.cloud.aiplatform.v1.PredictRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.PredictResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPredictMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Perform an online prediction with an arbitrary HTTP payload.
     * The response includes the following HTTP headers:
     * * `X-Vertex-AI-Endpoint-Id`: ID of the
     * [Endpoint][google.cloud.aiplatform.v1.Endpoint] that served this
     * prediction.
     * * `X-Vertex-AI-Deployed-Model-Id`: ID of the Endpoint's
     * [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] that served this
     * prediction.
     * </pre>
     */
    public void rawPredict(com.google.cloud.aiplatform.v1.RawPredictRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRawPredictMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Perform an unary online prediction request for Vertex first-party products
     * and frameworks.
     * </pre>
     */
    public void directPredict(com.google.cloud.aiplatform.v1.DirectPredictRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.DirectPredictResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDirectPredictMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Perform an online prediction request through gRPC.
     * </pre>
     */
    public void directRawPredict(com.google.cloud.aiplatform.v1.DirectRawPredictRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.DirectRawPredictResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDirectRawPredictMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Perform a streaming online prediction request for Vertex first-party
     * products and frameworks.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.StreamingPredictRequest> streamingPredict(
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.StreamingPredictResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingPredictMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Perform a server-side streaming online prediction request for Vertex
     * LLM streaming.
     * </pre>
     */
    public void serverStreamingPredict(com.google.cloud.aiplatform.v1.StreamingPredictRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.StreamingPredictResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getServerStreamingPredictMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Perform a streaming online prediction request through gRPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.StreamingRawPredictRequest> streamingRawPredict(
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.StreamingRawPredictResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingRawPredictMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Perform an online explanation.
     * If
     * [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id]
     * is specified, the corresponding DeployModel must have
     * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec]
     * populated. If
     * [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id]
     * is not specified, all DeployedModels must have
     * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec]
     * populated.
     * </pre>
     */
    public void explain(com.google.cloud.aiplatform.v1.ExplainRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ExplainResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExplainMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PredictionService.
   * <pre>
   * A service for online predictions and explanations.
   * </pre>
   */
  public static final class PredictionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PredictionServiceBlockingStub> {
    private PredictionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PredictionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PredictionServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Perform an online prediction.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.PredictResponse predict(com.google.cloud.aiplatform.v1.PredictRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPredictMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Perform an online prediction with an arbitrary HTTP payload.
     * The response includes the following HTTP headers:
     * * `X-Vertex-AI-Endpoint-Id`: ID of the
     * [Endpoint][google.cloud.aiplatform.v1.Endpoint] that served this
     * prediction.
     * * `X-Vertex-AI-Deployed-Model-Id`: ID of the Endpoint's
     * [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] that served this
     * prediction.
     * </pre>
     */
    public com.google.api.HttpBody rawPredict(com.google.cloud.aiplatform.v1.RawPredictRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRawPredictMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Perform an unary online prediction request for Vertex first-party products
     * and frameworks.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.DirectPredictResponse directPredict(com.google.cloud.aiplatform.v1.DirectPredictRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDirectPredictMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Perform an online prediction request through gRPC.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.DirectRawPredictResponse directRawPredict(com.google.cloud.aiplatform.v1.DirectRawPredictRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDirectRawPredictMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Perform a server-side streaming online prediction request for Vertex
     * LLM streaming.
     * </pre>
     */
    public java.util.Iterator<com.google.cloud.aiplatform.v1.StreamingPredictResponse> serverStreamingPredict(
        com.google.cloud.aiplatform.v1.StreamingPredictRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getServerStreamingPredictMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Perform an online explanation.
     * If
     * [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id]
     * is specified, the corresponding DeployModel must have
     * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec]
     * populated. If
     * [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id]
     * is not specified, all DeployedModels must have
     * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec]
     * populated.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ExplainResponse explain(com.google.cloud.aiplatform.v1.ExplainRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExplainMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PredictionService.
   * <pre>
   * A service for online predictions and explanations.
   * </pre>
   */
  public static final class PredictionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PredictionServiceFutureStub> {
    private PredictionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PredictionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PredictionServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Perform an online prediction.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.PredictResponse> predict(
        com.google.cloud.aiplatform.v1.PredictRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPredictMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Perform an online prediction with an arbitrary HTTP payload.
     * The response includes the following HTTP headers:
     * * `X-Vertex-AI-Endpoint-Id`: ID of the
     * [Endpoint][google.cloud.aiplatform.v1.Endpoint] that served this
     * prediction.
     * * `X-Vertex-AI-Deployed-Model-Id`: ID of the Endpoint's
     * [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] that served this
     * prediction.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody> rawPredict(
        com.google.cloud.aiplatform.v1.RawPredictRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRawPredictMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Perform an unary online prediction request for Vertex first-party products
     * and frameworks.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.DirectPredictResponse> directPredict(
        com.google.cloud.aiplatform.v1.DirectPredictRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDirectPredictMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Perform an online prediction request through gRPC.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.DirectRawPredictResponse> directRawPredict(
        com.google.cloud.aiplatform.v1.DirectRawPredictRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDirectRawPredictMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Perform an online explanation.
     * If
     * [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id]
     * is specified, the corresponding DeployModel must have
     * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec]
     * populated. If
     * [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id]
     * is not specified, all DeployedModels must have
     * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec]
     * populated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.ExplainResponse> explain(
        com.google.cloud.aiplatform.v1.ExplainRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExplainMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PREDICT = 0;
  private static final int METHODID_RAW_PREDICT = 1;
  private static final int METHODID_DIRECT_PREDICT = 2;
  private static final int METHODID_DIRECT_RAW_PREDICT = 3;
  private static final int METHODID_SERVER_STREAMING_PREDICT = 4;
  private static final int METHODID_EXPLAIN = 5;
  private static final int METHODID_STREAMING_PREDICT = 6;
  private static final int METHODID_STREAMING_RAW_PREDICT = 7;

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
        case METHODID_PREDICT:
          serviceImpl.predict((com.google.cloud.aiplatform.v1.PredictRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.PredictResponse>) responseObserver);
          break;
        case METHODID_RAW_PREDICT:
          serviceImpl.rawPredict((com.google.cloud.aiplatform.v1.RawPredictRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
          break;
        case METHODID_DIRECT_PREDICT:
          serviceImpl.directPredict((com.google.cloud.aiplatform.v1.DirectPredictRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.DirectPredictResponse>) responseObserver);
          break;
        case METHODID_DIRECT_RAW_PREDICT:
          serviceImpl.directRawPredict((com.google.cloud.aiplatform.v1.DirectRawPredictRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.DirectRawPredictResponse>) responseObserver);
          break;
        case METHODID_SERVER_STREAMING_PREDICT:
          serviceImpl.serverStreamingPredict((com.google.cloud.aiplatform.v1.StreamingPredictRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.StreamingPredictResponse>) responseObserver);
          break;
        case METHODID_EXPLAIN:
          serviceImpl.explain((com.google.cloud.aiplatform.v1.ExplainRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ExplainResponse>) responseObserver);
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
        case METHODID_STREAMING_PREDICT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamingPredict(
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.StreamingPredictResponse>) responseObserver);
        case METHODID_STREAMING_RAW_PREDICT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamingRawPredict(
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.StreamingRawPredictResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getPredictMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.PredictRequest,
              com.google.cloud.aiplatform.v1.PredictResponse>(
                service, METHODID_PREDICT)))
        .addMethod(
          getRawPredictMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.RawPredictRequest,
              com.google.api.HttpBody>(
                service, METHODID_RAW_PREDICT)))
        .addMethod(
          getDirectPredictMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.DirectPredictRequest,
              com.google.cloud.aiplatform.v1.DirectPredictResponse>(
                service, METHODID_DIRECT_PREDICT)))
        .addMethod(
          getDirectRawPredictMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.DirectRawPredictRequest,
              com.google.cloud.aiplatform.v1.DirectRawPredictResponse>(
                service, METHODID_DIRECT_RAW_PREDICT)))
        .addMethod(
          getStreamingPredictMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.StreamingPredictRequest,
              com.google.cloud.aiplatform.v1.StreamingPredictResponse>(
                service, METHODID_STREAMING_PREDICT)))
        .addMethod(
          getServerStreamingPredictMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.StreamingPredictRequest,
              com.google.cloud.aiplatform.v1.StreamingPredictResponse>(
                service, METHODID_SERVER_STREAMING_PREDICT)))
        .addMethod(
          getStreamingRawPredictMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.StreamingRawPredictRequest,
              com.google.cloud.aiplatform.v1.StreamingRawPredictResponse>(
                service, METHODID_STREAMING_RAW_PREDICT)))
        .addMethod(
          getExplainMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.ExplainRequest,
              com.google.cloud.aiplatform.v1.ExplainResponse>(
                service, METHODID_EXPLAIN)))
        .build();
  }

  private static abstract class PredictionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PredictionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.PredictionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PredictionService");
    }
  }

  private static final class PredictionServiceFileDescriptorSupplier
      extends PredictionServiceBaseDescriptorSupplier {
    PredictionServiceFileDescriptorSupplier() {}
  }

  private static final class PredictionServiceMethodDescriptorSupplier
      extends PredictionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PredictionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PredictionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PredictionServiceFileDescriptorSupplier())
              .addMethod(getPredictMethod())
              .addMethod(getRawPredictMethod())
              .addMethod(getDirectPredictMethod())
              .addMethod(getDirectRawPredictMethod())
              .addMethod(getStreamingPredictMethod())
              .addMethod(getServerStreamingPredictMethod())
              .addMethod(getStreamingRawPredictMethod())
              .addMethod(getExplainMethod())
              .build();
        }
      }
    }
    return result;
  }
}
