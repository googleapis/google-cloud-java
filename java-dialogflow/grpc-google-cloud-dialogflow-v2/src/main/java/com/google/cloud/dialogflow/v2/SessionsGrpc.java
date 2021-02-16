/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
 * A service used for session interactions.
 * For more information, see the [API interactions
 * guide](https://cloud.google.com/dialogflow/docs/api-overview).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/session.proto")
public final class SessionsGrpc {

  private SessionsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2.Sessions";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DetectIntentRequest,
          com.google.cloud.dialogflow.v2.DetectIntentResponse>
      getDetectIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DetectIntent",
      requestType = com.google.cloud.dialogflow.v2.DetectIntentRequest.class,
      responseType = com.google.cloud.dialogflow.v2.DetectIntentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DetectIntentRequest,
          com.google.cloud.dialogflow.v2.DetectIntentResponse>
      getDetectIntentMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DetectIntent"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest,
          com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>
      getStreamingDetectIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingDetectIntent",
      requestType = com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest.class,
      responseType = com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest,
          com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>
      getStreamingDetectIntentMethod() {
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
                          generateFullMethodName(SERVICE_NAME, "StreamingDetectIntent"))
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
  public static SessionsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionsBlockingStub>() {
          @java.lang.Override
          public SessionsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionsBlockingStub(channel, callOptions);
          }
        };
    return SessionsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SessionsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionsFutureStub>() {
          @java.lang.Override
          public SessionsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionsFutureStub(channel, callOptions);
          }
        };
    return SessionsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service used for session interactions.
   * For more information, see the [API interactions
   * guide](https://cloud.google.com/dialogflow/docs/api-overview).
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
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
     * </pre>
     */
    public void detectIntent(
        com.google.cloud.dialogflow.v2.DetectIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.DetectIntentResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getDetectIntentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Processes a natural language query in audio format in a streaming fashion
     * and returns structured, actionable data as a result. This method is only
     * available via the gRPC API (not REST).
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest>
        streamingDetectIntent(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>
                responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamingDetectIntentMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getDetectIntentMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.DetectIntentRequest,
                      com.google.cloud.dialogflow.v2.DetectIntentResponse>(
                      this, METHODID_DETECT_INTENT)))
          .addMethod(
              getStreamingDetectIntentMethod(),
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
   * A service used for session interactions.
   * For more information, see the [API interactions
   * guide](https://cloud.google.com/dialogflow/docs/api-overview).
   * </pre>
   */
  public static final class SessionsStub extends io.grpc.stub.AbstractAsyncStub<SessionsStub> {
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
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
     * </pre>
     */
    public void detectIntent(
        com.google.cloud.dialogflow.v2.DetectIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.DetectIntentResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDetectIntentMethod(), getCallOptions()),
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
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.StreamingDetectIntentRequest>
        streamingDetectIntent(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.dialogflow.v2.StreamingDetectIntentResponse>
                responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStreamingDetectIntentMethod(), getCallOptions()),
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service used for session interactions.
   * For more information, see the [API interactions
   * guide](https://cloud.google.com/dialogflow/docs/api-overview).
   * </pre>
   */
  public static final class SessionsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SessionsBlockingStub> {
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
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.DetectIntentResponse detectIntent(
        com.google.cloud.dialogflow.v2.DetectIntentRequest request) {
      return blockingUnaryCall(getChannel(), getDetectIntentMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service used for session interactions.
   * For more information, see the [API interactions
   * guide](https://cloud.google.com/dialogflow/docs/api-overview).
   * </pre>
   */
  public static final class SessionsFutureStub
      extends io.grpc.stub.AbstractFutureStub<SessionsFutureStub> {
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
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.DetectIntentResponse>
        detectIntent(com.google.cloud.dialogflow.v2.DetectIntentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDetectIntentMethod(), getCallOptions()), request);
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
                      .addMethod(getDetectIntentMethod())
                      .addMethod(getStreamingDetectIntentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
