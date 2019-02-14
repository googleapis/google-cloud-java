package com.google.cloud.dialogflow.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * A session represents an interaction with a user. You retrieve user input
 * and pass it to the [DetectIntent][google.cloud.dialogflow.v2.Sessions.DetectIntent] (or
 * [StreamingDetectIntent][google.cloud.dialogflow.v2.Sessions.StreamingDetectIntent]) method to determine
 * user intent and respond.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/dialogflow/v2/session.proto")
public final class SessionsGrpc {

  private SessionsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2.Sessions";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDetectIntentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DetectIntentRequest,
          com.google.cloud.dialogflow.v2.DetectIntentResponse>
      METHOD_DETECT_INTENT = getDetectIntentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DetectIntentRequest,
          com.google.cloud.dialogflow.v2.DetectIntentResponse>
      getDetectIntentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DetectIntentRequest,
          com.google.cloud.dialogflow.v2.DetectIntentResponse>
      getDetectIntentMethod() {
    return getDetectIntentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DetectIntentRequest,
          com.google.cloud.dialogflow.v2.DetectIntentResponse>
      getDetectIntentMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.DetectIntentRequest,
            com.google.cloud.dialogflow.v2.DetectIntentResponse>
        getDetectIntentMethod;
    if ((getDetectIntentMethod = SessionsGrpc.getDetectIntentMethod) == null) {
      synchronized (SessionsGrpc.class) {
        if ((getDetectIntentMethod = SessionsGrpc.getDetectIntentMethod) == null) {
          SessionsGrpc.getDetectIntentMethod =
              getDetectIntentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.DetectIntentRequest,
                          com.google.cloud.dialogflow.v2.DetectIntentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2.Sessions", "DetectIntent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.DetectIntentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.DetectIntentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SessionsMethodDescriptorSupplier("DetectIntent"))
                      .build();
        }
      }
    }
    return getDetectIntentMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStreamingDetectIntentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest,
          com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>
      METHOD_STREAMING_DETECT_INTENT = getStreamingDetectIntentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest,
          com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>
      getStreamingDetectIntentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest,
          com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>
      getStreamingDetectIntentMethod() {
    return getStreamingDetectIntentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest,
          com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>
      getStreamingDetectIntentMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest,
            com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>
        getStreamingDetectIntentMethod;
    if ((getStreamingDetectIntentMethod = SessionsGrpc.getStreamingDetectIntentMethod) == null) {
      synchronized (SessionsGrpc.class) {
        if ((getStreamingDetectIntentMethod = SessionsGrpc.getStreamingDetectIntentMethod)
            == null) {
          SessionsGrpc.getStreamingDetectIntentMethod =
              getStreamingDetectIntentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest,
                          com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2.Sessions", "StreamingDetectIntent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionsMethodDescriptorSupplier("StreamingDetectIntent"))
                      .build();
        }
      }
    }
    return getStreamingDetectIntentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SessionsStub newStub(io.grpc.Channel channel) {
    return new SessionsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SessionsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new SessionsBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SessionsFutureStub newFutureStub(io.grpc.Channel channel) {
    return new SessionsFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * A session represents an interaction with a user. You retrieve user input
   * and pass it to the [DetectIntent][google.cloud.dialogflow.v2.Sessions.DetectIntent] (or
   * [StreamingDetectIntent][google.cloud.dialogflow.v2.Sessions.StreamingDetectIntent]) method to determine
   * user intent and respond.
   * </pre>
   */
  public abstract static class SessionsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Processes a natural language query and returns structured, actionable data
     * as a result. This method is not idempotent, because it may cause contexts
     * and session entity types to be updated, which in turn might affect
     * results of future queries.
     * </pre>
     */
    public void detectIntent(
        com.google.cloud.dialogflow.v2.DetectIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.DetectIntentResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getDetectIntentMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Processes a natural language query in audio format in a streaming fashion
     * and returns structured, actionable data as a result. This method is only
     * available via the gRPC API (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest>
        streamingDetectIntent(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>
                responseObserver) {
      return asyncUnimplementedStreamingCall(
          getStreamingDetectIntentMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getDetectIntentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.DetectIntentRequest,
                      com.google.cloud.dialogflow.v2.DetectIntentResponse>(
                      this, METHODID_DETECT_INTENT)))
          .addMethod(
              getStreamingDetectIntentMethodHelper(),
              asyncBidiStreamingCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest,
                      com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>(
                      this, METHODID_STREAMING_DETECT_INTENT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A session represents an interaction with a user. You retrieve user input
   * and pass it to the [DetectIntent][google.cloud.dialogflow.v2.Sessions.DetectIntent] (or
   * [StreamingDetectIntent][google.cloud.dialogflow.v2.Sessions.StreamingDetectIntent]) method to determine
   * user intent and respond.
   * </pre>
   */
  public static final class SessionsStub extends io.grpc.stub.AbstractStub<SessionsStub> {
    private SessionsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SessionsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Processes a natural language query and returns structured, actionable data
     * as a result. This method is not idempotent, because it may cause contexts
     * and session entity types to be updated, which in turn might affect
     * results of future queries.
     * </pre>
     */
    public void detectIntent(
        com.google.cloud.dialogflow.v2.DetectIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.DetectIntentResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDetectIntentMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Processes a natural language query in audio format in a streaming fashion
     * and returns structured, actionable data as a result. This method is only
     * available via the gRPC API (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest>
        streamingDetectIntent(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>
                responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStreamingDetectIntentMethodHelper(), getCallOptions()),
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A session represents an interaction with a user. You retrieve user input
   * and pass it to the [DetectIntent][google.cloud.dialogflow.v2.Sessions.DetectIntent] (or
   * [StreamingDetectIntent][google.cloud.dialogflow.v2.Sessions.StreamingDetectIntent]) method to determine
   * user intent and respond.
   * </pre>
   */
  public static final class SessionsBlockingStub
      extends io.grpc.stub.AbstractStub<SessionsBlockingStub> {
    private SessionsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SessionsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionsBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Processes a natural language query and returns structured, actionable data
     * as a result. This method is not idempotent, because it may cause contexts
     * and session entity types to be updated, which in turn might affect
     * results of future queries.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.DetectIntentResponse detectIntent(
        com.google.cloud.dialogflow.v2.DetectIntentRequest request) {
      return blockingUnaryCall(
          getChannel(), getDetectIntentMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A session represents an interaction with a user. You retrieve user input
   * and pass it to the [DetectIntent][google.cloud.dialogflow.v2.Sessions.DetectIntent] (or
   * [StreamingDetectIntent][google.cloud.dialogflow.v2.Sessions.StreamingDetectIntent]) method to determine
   * user intent and respond.
   * </pre>
   */
  public static final class SessionsFutureStub
      extends io.grpc.stub.AbstractStub<SessionsFutureStub> {
    private SessionsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SessionsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Processes a natural language query and returns structured, actionable data
     * as a result. This method is not idempotent, because it may cause contexts
     * and session entity types to be updated, which in turn might affect
     * results of future queries.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.DetectIntentResponse>
        detectIntent(com.google.cloud.dialogflow.v2.DetectIntentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDetectIntentMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DETECT_INTENT = 0;
  private static final int METHODID_STREAMING_DETECT_INTENT = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.detectIntent(
              (com.google.cloud.dialogflow.v2.DetectIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.DetectIntentResponse>)
                  responseObserver);
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
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.streamingDetectIntent(
                  (io.grpc.stub.StreamObserver<
                          com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private abstract static class SessionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SessionsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.SessionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Sessions");
    }
  }

  private static final class SessionsFileDescriptorSupplier extends SessionsBaseDescriptorSupplier {
    SessionsFileDescriptorSupplier() {}
  }

  private static final class SessionsMethodDescriptorSupplier extends SessionsBaseDescriptorSupplier
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SessionsFileDescriptorSupplier())
                      .addMethod(getDetectIntentMethodHelper())
                      .addMethod(getStreamingDetectIntentMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
