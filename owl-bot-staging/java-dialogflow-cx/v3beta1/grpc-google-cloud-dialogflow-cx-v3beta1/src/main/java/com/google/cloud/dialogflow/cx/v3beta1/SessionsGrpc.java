package com.google.cloud.dialogflow.cx.v3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A session represents an interaction with a user. You retrieve user input
 * and pass it to the [DetectIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.DetectIntent] method to determine
 * user intent and respond.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3beta1/session.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SessionsGrpc {

  private SessionsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3beta1.Sessions";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest,
      com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse> getDetectIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DetectIntent",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest,
      com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse> getDetectIntentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest, com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse> getDetectIntentMethod;
    if ((getDetectIntentMethod = SessionsGrpc.getDetectIntentMethod) == null) {
      synchronized (SessionsGrpc.class) {
        if ((getDetectIntentMethod = SessionsGrpc.getDetectIntentMethod) == null) {
          SessionsGrpc.getDetectIntentMethod = getDetectIntentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest, com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DetectIntent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SessionsMethodDescriptorSupplier("DetectIntent"))
              .build();
        }
      }
    }
    return getDetectIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentRequest,
      com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentResponse> getStreamingDetectIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingDetectIntent",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentRequest,
      com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentResponse> getStreamingDetectIntentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentRequest, com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentResponse> getStreamingDetectIntentMethod;
    if ((getStreamingDetectIntentMethod = SessionsGrpc.getStreamingDetectIntentMethod) == null) {
      synchronized (SessionsGrpc.class) {
        if ((getStreamingDetectIntentMethod = SessionsGrpc.getStreamingDetectIntentMethod) == null) {
          SessionsGrpc.getStreamingDetectIntentMethod = getStreamingDetectIntentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentRequest, com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamingDetectIntent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SessionsMethodDescriptorSupplier("StreamingDetectIntent"))
              .build();
        }
      }
    }
    return getStreamingDetectIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest,
      com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse> getMatchIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MatchIntent",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest,
      com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse> getMatchIntentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest, com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse> getMatchIntentMethod;
    if ((getMatchIntentMethod = SessionsGrpc.getMatchIntentMethod) == null) {
      synchronized (SessionsGrpc.class) {
        if ((getMatchIntentMethod = SessionsGrpc.getMatchIntentMethod) == null) {
          SessionsGrpc.getMatchIntentMethod = getMatchIntentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest, com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MatchIntent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SessionsMethodDescriptorSupplier("MatchIntent"))
              .build();
        }
      }
    }
    return getMatchIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest,
      com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse> getFulfillIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FulfillIntent",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest,
      com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse> getFulfillIntentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest, com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse> getFulfillIntentMethod;
    if ((getFulfillIntentMethod = SessionsGrpc.getFulfillIntentMethod) == null) {
      synchronized (SessionsGrpc.class) {
        if ((getFulfillIntentMethod = SessionsGrpc.getFulfillIntentMethod) == null) {
          SessionsGrpc.getFulfillIntentMethod = getFulfillIntentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest, com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FulfillIntent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SessionsMethodDescriptorSupplier("FulfillIntent"))
              .build();
        }
      }
    }
    return getFulfillIntentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SessionsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SessionsStub>() {
        @java.lang.Override
        public SessionsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SessionsStub(channel, callOptions);
        }
      };
    return SessionsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SessionsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SessionsBlockingStub>() {
        @java.lang.Override
        public SessionsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SessionsBlockingStub(channel, callOptions);
        }
      };
    return SessionsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SessionsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SessionsFutureStub>() {
        @java.lang.Override
        public SessionsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SessionsFutureStub(channel, callOptions);
        }
      };
    return SessionsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A session represents an interaction with a user. You retrieve user input
   * and pass it to the [DetectIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.DetectIntent] method to determine
   * user intent and respond.
   * </pre>
   */
  public static abstract class SessionsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Processes a natural language query and returns structured, actionable data
     * as a result. This method is not idempotent, because it may cause session
     * entity types to be updated, which in turn might affect results of future
     * queries.
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/cx/docs/concept/version).
     * </pre>
     */
    public void detectIntent(com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDetectIntentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Processes a natural language query in audio format in a streaming fashion
     * and returns structured, actionable data as a result. This method is only
     * available via the gRPC API (not REST).
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/cx/docs/concept/version).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentRequest> streamingDetectIntent(
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamingDetectIntentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns preliminary intent match results, doesn't change the session
     * status.
     * </pre>
     */
    public void matchIntent(com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMatchIntentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Fulfills a matched intent returned by [MatchIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.MatchIntent].
     * Must be called after [MatchIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.MatchIntent], with input from
     * [MatchIntentResponse][google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse]. Otherwise, the behavior is undefined.
     * </pre>
     */
    public void fulfillIntent(com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFulfillIntentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDetectIntentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest,
                com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse>(
                  this, METHODID_DETECT_INTENT)))
          .addMethod(
            getStreamingDetectIntentMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentRequest,
                com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentResponse>(
                  this, METHODID_STREAMING_DETECT_INTENT)))
          .addMethod(
            getMatchIntentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest,
                com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse>(
                  this, METHODID_MATCH_INTENT)))
          .addMethod(
            getFulfillIntentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest,
                com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse>(
                  this, METHODID_FULFILL_INTENT)))
          .build();
    }
  }

  /**
   * <pre>
   * A session represents an interaction with a user. You retrieve user input
   * and pass it to the [DetectIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.DetectIntent] method to determine
   * user intent and respond.
   * </pre>
   */
  public static final class SessionsStub extends io.grpc.stub.AbstractAsyncStub<SessionsStub> {
    private SessionsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Processes a natural language query and returns structured, actionable data
     * as a result. This method is not idempotent, because it may cause session
     * entity types to be updated, which in turn might affect results of future
     * queries.
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/cx/docs/concept/version).
     * </pre>
     */
    public void detectIntent(com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDetectIntentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Processes a natural language query in audio format in a streaming fashion
     * and returns structured, actionable data as a result. This method is only
     * available via the gRPC API (not REST).
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/cx/docs/concept/version).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentRequest> streamingDetectIntent(
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingDetectIntentMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Returns preliminary intent match results, doesn't change the session
     * status.
     * </pre>
     */
    public void matchIntent(com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMatchIntentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Fulfills a matched intent returned by [MatchIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.MatchIntent].
     * Must be called after [MatchIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.MatchIntent], with input from
     * [MatchIntentResponse][google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse]. Otherwise, the behavior is undefined.
     * </pre>
     */
    public void fulfillIntent(com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFulfillIntentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * A session represents an interaction with a user. You retrieve user input
   * and pass it to the [DetectIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.DetectIntent] method to determine
   * user intent and respond.
   * </pre>
   */
  public static final class SessionsBlockingStub extends io.grpc.stub.AbstractBlockingStub<SessionsBlockingStub> {
    private SessionsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Processes a natural language query and returns structured, actionable data
     * as a result. This method is not idempotent, because it may cause session
     * entity types to be updated, which in turn might affect results of future
     * queries.
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/cx/docs/concept/version).
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse detectIntent(com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDetectIntentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns preliminary intent match results, doesn't change the session
     * status.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse matchIntent(com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMatchIntentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Fulfills a matched intent returned by [MatchIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.MatchIntent].
     * Must be called after [MatchIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.MatchIntent], with input from
     * [MatchIntentResponse][google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse]. Otherwise, the behavior is undefined.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse fulfillIntent(com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFulfillIntentMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A session represents an interaction with a user. You retrieve user input
   * and pass it to the [DetectIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.DetectIntent] method to determine
   * user intent and respond.
   * </pre>
   */
  public static final class SessionsFutureStub extends io.grpc.stub.AbstractFutureStub<SessionsFutureStub> {
    private SessionsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Processes a natural language query and returns structured, actionable data
     * as a result. This method is not idempotent, because it may cause session
     * entity types to be updated, which in turn might affect results of future
     * queries.
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/cx/docs/concept/version).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse> detectIntent(
        com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDetectIntentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns preliminary intent match results, doesn't change the session
     * status.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse> matchIntent(
        com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMatchIntentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Fulfills a matched intent returned by [MatchIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.MatchIntent].
     * Must be called after [MatchIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.MatchIntent], with input from
     * [MatchIntentResponse][google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse]. Otherwise, the behavior is undefined.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse> fulfillIntent(
        com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFulfillIntentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DETECT_INTENT = 0;
  private static final int METHODID_MATCH_INTENT = 1;
  private static final int METHODID_FULFILL_INTENT = 2;
  private static final int METHODID_STREAMING_DETECT_INTENT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SessionsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SessionsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DETECT_INTENT:
          serviceImpl.detectIntent((com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse>) responseObserver);
          break;
        case METHODID_MATCH_INTENT:
          serviceImpl.matchIntent((com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse>) responseObserver);
          break;
        case METHODID_FULFILL_INTENT:
          serviceImpl.fulfillIntent((com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse>) responseObserver);
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
        case METHODID_STREAMING_DETECT_INTENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamingDetectIntent(
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SessionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SessionsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3beta1.SessionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Sessions");
    }
  }

  private static final class SessionsFileDescriptorSupplier
      extends SessionsBaseDescriptorSupplier {
    SessionsFileDescriptorSupplier() {}
  }

  private static final class SessionsMethodDescriptorSupplier
      extends SessionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SessionsMethodDescriptorSupplier(String methodName) {
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
      synchronized (SessionsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SessionsFileDescriptorSupplier())
              .addMethod(getDetectIntentMethod())
              .addMethod(getStreamingDetectIntentMethod())
              .addMethod(getMatchIntentMethod())
              .addMethod(getFulfillIntentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
