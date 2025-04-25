/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.dialogflow.cx.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A session represents an interaction with a user. You retrieve user input
 * and pass it to the
 * [DetectIntent][google.cloud.dialogflow.cx.v3.Sessions.DetectIntent] method to
 * determine user intent and respond.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3/session.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SessionsGrpc {

  private SessionsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dialogflow.cx.v3.Sessions";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DetectIntentRequest,
          com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
      getDetectIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DetectIntent",
      requestType = com.google.cloud.dialogflow.cx.v3.DetectIntentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.DetectIntentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DetectIntentRequest,
          com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
      getDetectIntentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.DetectIntentRequest,
            com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
        getDetectIntentMethod;
    if ((getDetectIntentMethod = SessionsGrpc.getDetectIntentMethod) == null) {
      synchronized (SessionsGrpc.class) {
        if ((getDetectIntentMethod = SessionsGrpc.getDetectIntentMethod) == null) {
          SessionsGrpc.getDetectIntentMethod =
              getDetectIntentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.DetectIntentRequest,
                          com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DetectIntent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.DetectIntentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.DetectIntentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SessionsMethodDescriptorSupplier("DetectIntent"))
                      .build();
        }
      }
    }
    return getDetectIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DetectIntentRequest,
          com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
      getServerStreamingDetectIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ServerStreamingDetectIntent",
      requestType = com.google.cloud.dialogflow.cx.v3.DetectIntentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.DetectIntentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.DetectIntentRequest,
          com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
      getServerStreamingDetectIntentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.DetectIntentRequest,
            com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
        getServerStreamingDetectIntentMethod;
    if ((getServerStreamingDetectIntentMethod = SessionsGrpc.getServerStreamingDetectIntentMethod)
        == null) {
      synchronized (SessionsGrpc.class) {
        if ((getServerStreamingDetectIntentMethod =
                SessionsGrpc.getServerStreamingDetectIntentMethod)
            == null) {
          SessionsGrpc.getServerStreamingDetectIntentMethod =
              getServerStreamingDetectIntentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.DetectIntentRequest,
                          com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ServerStreamingDetectIntent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.DetectIntentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.DetectIntentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionsMethodDescriptorSupplier("ServerStreamingDetectIntent"))
                      .build();
        }
      }
    }
    return getServerStreamingDetectIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentRequest,
          com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentResponse>
      getStreamingDetectIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingDetectIntent",
      requestType = com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentRequest,
          com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentResponse>
      getStreamingDetectIntentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentRequest,
            com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentResponse>
        getStreamingDetectIntentMethod;
    if ((getStreamingDetectIntentMethod = SessionsGrpc.getStreamingDetectIntentMethod) == null) {
      synchronized (SessionsGrpc.class) {
        if ((getStreamingDetectIntentMethod = SessionsGrpc.getStreamingDetectIntentMethod)
            == null) {
          SessionsGrpc.getStreamingDetectIntentMethod =
              getStreamingDetectIntentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentRequest,
                          com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "StreamingDetectIntent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionsMethodDescriptorSupplier("StreamingDetectIntent"))
                      .build();
        }
      }
    }
    return getStreamingDetectIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.MatchIntentRequest,
          com.google.cloud.dialogflow.cx.v3.MatchIntentResponse>
      getMatchIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MatchIntent",
      requestType = com.google.cloud.dialogflow.cx.v3.MatchIntentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.MatchIntentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.MatchIntentRequest,
          com.google.cloud.dialogflow.cx.v3.MatchIntentResponse>
      getMatchIntentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.MatchIntentRequest,
            com.google.cloud.dialogflow.cx.v3.MatchIntentResponse>
        getMatchIntentMethod;
    if ((getMatchIntentMethod = SessionsGrpc.getMatchIntentMethod) == null) {
      synchronized (SessionsGrpc.class) {
        if ((getMatchIntentMethod = SessionsGrpc.getMatchIntentMethod) == null) {
          SessionsGrpc.getMatchIntentMethod =
              getMatchIntentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.MatchIntentRequest,
                          com.google.cloud.dialogflow.cx.v3.MatchIntentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MatchIntent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.MatchIntentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.MatchIntentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SessionsMethodDescriptorSupplier("MatchIntent"))
                      .build();
        }
      }
    }
    return getMatchIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.FulfillIntentRequest,
          com.google.cloud.dialogflow.cx.v3.FulfillIntentResponse>
      getFulfillIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FulfillIntent",
      requestType = com.google.cloud.dialogflow.cx.v3.FulfillIntentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.FulfillIntentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.FulfillIntentRequest,
          com.google.cloud.dialogflow.cx.v3.FulfillIntentResponse>
      getFulfillIntentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.FulfillIntentRequest,
            com.google.cloud.dialogflow.cx.v3.FulfillIntentResponse>
        getFulfillIntentMethod;
    if ((getFulfillIntentMethod = SessionsGrpc.getFulfillIntentMethod) == null) {
      synchronized (SessionsGrpc.class) {
        if ((getFulfillIntentMethod = SessionsGrpc.getFulfillIntentMethod) == null) {
          SessionsGrpc.getFulfillIntentMethod =
              getFulfillIntentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.FulfillIntentRequest,
                          com.google.cloud.dialogflow.cx.v3.FulfillIntentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FulfillIntent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.FulfillIntentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.FulfillIntentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SessionsMethodDescriptorSupplier("FulfillIntent"))
                      .build();
        }
      }
    }
    return getFulfillIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.SubmitAnswerFeedbackRequest,
          com.google.cloud.dialogflow.cx.v3.AnswerFeedback>
      getSubmitAnswerFeedbackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubmitAnswerFeedback",
      requestType = com.google.cloud.dialogflow.cx.v3.SubmitAnswerFeedbackRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.AnswerFeedback.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3.SubmitAnswerFeedbackRequest,
          com.google.cloud.dialogflow.cx.v3.AnswerFeedback>
      getSubmitAnswerFeedbackMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3.SubmitAnswerFeedbackRequest,
            com.google.cloud.dialogflow.cx.v3.AnswerFeedback>
        getSubmitAnswerFeedbackMethod;
    if ((getSubmitAnswerFeedbackMethod = SessionsGrpc.getSubmitAnswerFeedbackMethod) == null) {
      synchronized (SessionsGrpc.class) {
        if ((getSubmitAnswerFeedbackMethod = SessionsGrpc.getSubmitAnswerFeedbackMethod) == null) {
          SessionsGrpc.getSubmitAnswerFeedbackMethod =
              getSubmitAnswerFeedbackMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3.SubmitAnswerFeedbackRequest,
                          com.google.cloud.dialogflow.cx.v3.AnswerFeedback>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SubmitAnswerFeedback"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.SubmitAnswerFeedbackRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3.AnswerFeedback
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionsMethodDescriptorSupplier("SubmitAnswerFeedback"))
                      .build();
        }
      }
    }
    return getSubmitAnswerFeedbackMethod;
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
   * A session represents an interaction with a user. You retrieve user input
   * and pass it to the
   * [DetectIntent][google.cloud.dialogflow.cx.v3.Sessions.DetectIntent] method to
   * determine user intent and respond.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
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
    default void detectIntent(
        com.google.cloud.dialogflow.cx.v3.DetectIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDetectIntentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Processes a natural language query and returns structured, actionable data
     * as a result through server-side streaming. Server-side streaming allows
     * Dialogflow to send [partial
     * responses](https://cloud.google.com/dialogflow/cx/docs/concept/fulfillment#partial-response)
     * earlier in a single request.
     * </pre>
     */
    default void serverStreamingDetectIntent(
        com.google.cloud.dialogflow.cx.v3.DetectIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getServerStreamingDetectIntentMethod(), responseObserver);
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
     * environments](https://cloud.google.com/dialogflow/cx/docs/concept/version).
     * </pre>
     */
    default io.grpc.stub.StreamObserver<
            com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentRequest>
        streamingDetectIntent(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getStreamingDetectIntentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns preliminary intent match results, doesn't change the session
     * status.
     * </pre>
     */
    default void matchIntent(
        com.google.cloud.dialogflow.cx.v3.MatchIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.MatchIntentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getMatchIntentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fulfills a matched intent returned by
     * [MatchIntent][google.cloud.dialogflow.cx.v3.Sessions.MatchIntent]. Must be
     * called after
     * [MatchIntent][google.cloud.dialogflow.cx.v3.Sessions.MatchIntent], with
     * input from
     * [MatchIntentResponse][google.cloud.dialogflow.cx.v3.MatchIntentResponse].
     * Otherwise, the behavior is undefined.
     * </pre>
     */
    default void fulfillIntent(
        com.google.cloud.dialogflow.cx.v3.FulfillIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.FulfillIntentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFulfillIntentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the feedback received from the user for a single turn of the bot
     * response.
     * </pre>
     */
    default void submitAnswerFeedback(
        com.google.cloud.dialogflow.cx.v3.SubmitAnswerFeedbackRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.AnswerFeedback>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSubmitAnswerFeedbackMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Sessions.
   *
   * <pre>
   * A session represents an interaction with a user. You retrieve user input
   * and pass it to the
   * [DetectIntent][google.cloud.dialogflow.cx.v3.Sessions.DetectIntent] method to
   * determine user intent and respond.
   * </pre>
   */
  public abstract static class SessionsImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SessionsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Sessions.
   *
   * <pre>
   * A session represents an interaction with a user. You retrieve user input
   * and pass it to the
   * [DetectIntent][google.cloud.dialogflow.cx.v3.Sessions.DetectIntent] method to
   * determine user intent and respond.
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
     * as a result. This method is not idempotent, because it may cause session
     * entity types to be updated, which in turn might affect results of future
     * queries.
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/cx/docs/concept/version).
     * </pre>
     */
    public void detectIntent(
        com.google.cloud.dialogflow.cx.v3.DetectIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDetectIntentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Processes a natural language query and returns structured, actionable data
     * as a result through server-side streaming. Server-side streaming allows
     * Dialogflow to send [partial
     * responses](https://cloud.google.com/dialogflow/cx/docs/concept/fulfillment#partial-response)
     * earlier in a single request.
     * </pre>
     */
    public void serverStreamingDetectIntent(
        com.google.cloud.dialogflow.cx.v3.DetectIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getServerStreamingDetectIntentMethod(), getCallOptions()),
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
     * environments](https://cloud.google.com/dialogflow/cx/docs/concept/version).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<
            com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentRequest>
        streamingDetectIntent(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentResponse>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingDetectIntentMethod(), getCallOptions()),
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns preliminary intent match results, doesn't change the session
     * status.
     * </pre>
     */
    public void matchIntent(
        com.google.cloud.dialogflow.cx.v3.MatchIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.MatchIntentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMatchIntentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fulfills a matched intent returned by
     * [MatchIntent][google.cloud.dialogflow.cx.v3.Sessions.MatchIntent]. Must be
     * called after
     * [MatchIntent][google.cloud.dialogflow.cx.v3.Sessions.MatchIntent], with
     * input from
     * [MatchIntentResponse][google.cloud.dialogflow.cx.v3.MatchIntentResponse].
     * Otherwise, the behavior is undefined.
     * </pre>
     */
    public void fulfillIntent(
        com.google.cloud.dialogflow.cx.v3.FulfillIntentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.FulfillIntentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFulfillIntentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the feedback received from the user for a single turn of the bot
     * response.
     * </pre>
     */
    public void submitAnswerFeedback(
        com.google.cloud.dialogflow.cx.v3.SubmitAnswerFeedbackRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.AnswerFeedback>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubmitAnswerFeedbackMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Sessions.
   *
   * <pre>
   * A session represents an interaction with a user. You retrieve user input
   * and pass it to the
   * [DetectIntent][google.cloud.dialogflow.cx.v3.Sessions.DetectIntent] method to
   * determine user intent and respond.
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
     * as a result. This method is not idempotent, because it may cause session
     * entity types to be updated, which in turn might affect results of future
     * queries.
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/cx/docs/concept/version).
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.DetectIntentResponse detectIntent(
        com.google.cloud.dialogflow.cx.v3.DetectIntentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDetectIntentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Processes a natural language query and returns structured, actionable data
     * as a result through server-side streaming. Server-side streaming allows
     * Dialogflow to send [partial
     * responses](https://cloud.google.com/dialogflow/cx/docs/concept/fulfillment#partial-response)
     * earlier in a single request.
     * </pre>
     */
    public java.util.Iterator<com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
        serverStreamingDetectIntent(com.google.cloud.dialogflow.cx.v3.DetectIntentRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getServerStreamingDetectIntentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns preliminary intent match results, doesn't change the session
     * status.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.MatchIntentResponse matchIntent(
        com.google.cloud.dialogflow.cx.v3.MatchIntentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMatchIntentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fulfills a matched intent returned by
     * [MatchIntent][google.cloud.dialogflow.cx.v3.Sessions.MatchIntent]. Must be
     * called after
     * [MatchIntent][google.cloud.dialogflow.cx.v3.Sessions.MatchIntent], with
     * input from
     * [MatchIntentResponse][google.cloud.dialogflow.cx.v3.MatchIntentResponse].
     * Otherwise, the behavior is undefined.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.FulfillIntentResponse fulfillIntent(
        com.google.cloud.dialogflow.cx.v3.FulfillIntentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFulfillIntentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the feedback received from the user for a single turn of the bot
     * response.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.AnswerFeedback submitAnswerFeedback(
        com.google.cloud.dialogflow.cx.v3.SubmitAnswerFeedbackRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubmitAnswerFeedbackMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Sessions.
   *
   * <pre>
   * A session represents an interaction with a user. You retrieve user input
   * and pass it to the
   * [DetectIntent][google.cloud.dialogflow.cx.v3.Sessions.DetectIntent] method to
   * determine user intent and respond.
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
     * as a result. This method is not idempotent, because it may cause session
     * entity types to be updated, which in turn might affect results of future
     * queries.
     * Note: Always use agent versions for production traffic.
     * See [Versions and
     * environments](https://cloud.google.com/dialogflow/cx/docs/concept/version).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>
        detectIntent(com.google.cloud.dialogflow.cx.v3.DetectIntentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDetectIntentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns preliminary intent match results, doesn't change the session
     * status.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.MatchIntentResponse>
        matchIntent(com.google.cloud.dialogflow.cx.v3.MatchIntentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMatchIntentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fulfills a matched intent returned by
     * [MatchIntent][google.cloud.dialogflow.cx.v3.Sessions.MatchIntent]. Must be
     * called after
     * [MatchIntent][google.cloud.dialogflow.cx.v3.Sessions.MatchIntent], with
     * input from
     * [MatchIntentResponse][google.cloud.dialogflow.cx.v3.MatchIntentResponse].
     * Otherwise, the behavior is undefined.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.FulfillIntentResponse>
        fulfillIntent(com.google.cloud.dialogflow.cx.v3.FulfillIntentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFulfillIntentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the feedback received from the user for a single turn of the bot
     * response.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3.AnswerFeedback>
        submitAnswerFeedback(
            com.google.cloud.dialogflow.cx.v3.SubmitAnswerFeedbackRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubmitAnswerFeedbackMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DETECT_INTENT = 0;
  private static final int METHODID_SERVER_STREAMING_DETECT_INTENT = 1;
  private static final int METHODID_MATCH_INTENT = 2;
  private static final int METHODID_FULFILL_INTENT = 3;
  private static final int METHODID_SUBMIT_ANSWER_FEEDBACK = 4;
  private static final int METHODID_STREAMING_DETECT_INTENT = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_DETECT_INTENT:
          serviceImpl.detectIntent(
              (com.google.cloud.dialogflow.cx.v3.DetectIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>)
                  responseObserver);
          break;
        case METHODID_SERVER_STREAMING_DETECT_INTENT:
          serviceImpl.serverStreamingDetectIntent(
              (com.google.cloud.dialogflow.cx.v3.DetectIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>)
                  responseObserver);
          break;
        case METHODID_MATCH_INTENT:
          serviceImpl.matchIntent(
              (com.google.cloud.dialogflow.cx.v3.MatchIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.MatchIntentResponse>)
                  responseObserver);
          break;
        case METHODID_FULFILL_INTENT:
          serviceImpl.fulfillIntent(
              (com.google.cloud.dialogflow.cx.v3.FulfillIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.FulfillIntentResponse>)
                  responseObserver);
          break;
        case METHODID_SUBMIT_ANSWER_FEEDBACK:
          serviceImpl.submitAnswerFeedback(
              (com.google.cloud.dialogflow.cx.v3.SubmitAnswerFeedbackRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.AnswerFeedback>)
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
                          com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getDetectIntentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.DetectIntentRequest,
                    com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>(
                    service, METHODID_DETECT_INTENT)))
        .addMethod(
            getServerStreamingDetectIntentMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.DetectIntentRequest,
                    com.google.cloud.dialogflow.cx.v3.DetectIntentResponse>(
                    service, METHODID_SERVER_STREAMING_DETECT_INTENT)))
        .addMethod(
            getStreamingDetectIntentMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentRequest,
                    com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentResponse>(
                    service, METHODID_STREAMING_DETECT_INTENT)))
        .addMethod(
            getMatchIntentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.MatchIntentRequest,
                    com.google.cloud.dialogflow.cx.v3.MatchIntentResponse>(
                    service, METHODID_MATCH_INTENT)))
        .addMethod(
            getFulfillIntentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.FulfillIntentRequest,
                    com.google.cloud.dialogflow.cx.v3.FulfillIntentResponse>(
                    service, METHODID_FULFILL_INTENT)))
        .addMethod(
            getSubmitAnswerFeedbackMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3.SubmitAnswerFeedbackRequest,
                    com.google.cloud.dialogflow.cx.v3.AnswerFeedback>(
                    service, METHODID_SUBMIT_ANSWER_FEEDBACK)))
        .build();
  }

  private abstract static class SessionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SessionsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3.SessionProto.getDescriptor();
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
    private final java.lang.String methodName;

    SessionsMethodDescriptorSupplier(java.lang.String methodName) {
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
                      .addMethod(getServerStreamingDetectIntentMethod())
                      .addMethod(getStreamingDetectIntentMethod())
                      .addMethod(getMatchIntentMethod())
                      .addMethod(getFulfillIntentMethod())
                      .addMethod(getSubmitAnswerFeedbackMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
