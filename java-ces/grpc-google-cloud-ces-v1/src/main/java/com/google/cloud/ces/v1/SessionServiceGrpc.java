/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.ces.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Session service provides APIs for interacting with CES agents.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SessionServiceGrpc {

  private SessionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.ces.v1.SessionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.RunSessionRequest, com.google.cloud.ces.v1.RunSessionResponse>
      getRunSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunSession",
      requestType = com.google.cloud.ces.v1.RunSessionRequest.class,
      responseType = com.google.cloud.ces.v1.RunSessionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.RunSessionRequest, com.google.cloud.ces.v1.RunSessionResponse>
      getRunSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.RunSessionRequest, com.google.cloud.ces.v1.RunSessionResponse>
        getRunSessionMethod;
    if ((getRunSessionMethod = SessionServiceGrpc.getRunSessionMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getRunSessionMethod = SessionServiceGrpc.getRunSessionMethod) == null) {
          SessionServiceGrpc.getRunSessionMethod =
              getRunSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.RunSessionRequest,
                          com.google.cloud.ces.v1.RunSessionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.RunSessionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.RunSessionResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SessionServiceMethodDescriptorSupplier("RunSession"))
                      .build();
        }
      }
    }
    return getRunSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.BidiSessionClientMessage,
          com.google.cloud.ces.v1.BidiSessionServerMessage>
      getBidiRunSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BidiRunSession",
      requestType = com.google.cloud.ces.v1.BidiSessionClientMessage.class,
      responseType = com.google.cloud.ces.v1.BidiSessionServerMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.BidiSessionClientMessage,
          com.google.cloud.ces.v1.BidiSessionServerMessage>
      getBidiRunSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.BidiSessionClientMessage,
            com.google.cloud.ces.v1.BidiSessionServerMessage>
        getBidiRunSessionMethod;
    if ((getBidiRunSessionMethod = SessionServiceGrpc.getBidiRunSessionMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getBidiRunSessionMethod = SessionServiceGrpc.getBidiRunSessionMethod) == null) {
          SessionServiceGrpc.getBidiRunSessionMethod =
              getBidiRunSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.BidiSessionClientMessage,
                          com.google.cloud.ces.v1.BidiSessionServerMessage>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BidiRunSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.BidiSessionClientMessage
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.BidiSessionServerMessage
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SessionServiceMethodDescriptorSupplier("BidiRunSession"))
                      .build();
        }
      }
    }
    return getBidiRunSessionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SessionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionServiceStub>() {
          @java.lang.Override
          public SessionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionServiceStub(channel, callOptions);
          }
        };
    return SessionServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SessionServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionServiceBlockingV2Stub>() {
          @java.lang.Override
          public SessionServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SessionServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SessionServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionServiceBlockingStub>() {
          @java.lang.Override
          public SessionServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionServiceBlockingStub(channel, callOptions);
          }
        };
    return SessionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SessionServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SessionServiceFutureStub>() {
          @java.lang.Override
          public SessionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SessionServiceFutureStub(channel, callOptions);
          }
        };
    return SessionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Session service provides APIs for interacting with CES agents.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Initiates a single turn interaction with the CES agent within a
     * session.
     * </pre>
     */
    default void runSession(
        com.google.cloud.ces.v1.RunSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.RunSessionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Establishes a bidirectional streaming connection with the CES agent.
     * The agent processes continuous multimodal inputs (e.g., text, audio) and
     * generates real-time multimodal output streams.
     * --- Client Request Stream ---
     * The client streams requests in the following order:
     * 1.  Initialization:
     *     The first message must contain
     *     [SessionConfig][google.cloud.ces.v1.BidiSessionClientMessage.config].
     *     For audio sessions, this should also include
     *     [InputAudioConfig][google.cloud.ces.v1.SessionConfig.input_audio_config]
     *     and
     *     [OutputAudioConfig][google.cloud.ces.v1.SessionConfig.output_audio_config]
     *     to define audio processing and synthesis parameters.
     * 2.  Interaction:
     *     Subsequent messages stream
     *     [SessionInput][google.cloud.ces.v1.BidiSessionClientMessage.realtime_input]
     *     containing real-time user input data.
     * 3.  Termination:
     *     The client should half-close the stream when there is no more user
     *     input. It should also half-close upon receiving
     *     [EndSession][google.cloud.ces.v1.BidiSessionServerMessage.end_session]
     *     or [GoAway][google.cloud.ces.v1.BidiSessionServerMessage.go_away] from
     *     the agent.
     * --- Server Response Stream ---
     * For each interaction turn, the agent streams messages in the following
     * sequence:
     * 1.  Speech Recognition (First N messages):
     *     Contains
     *     [RecognitionResult][google.cloud.ces.v1.BidiSessionServerMessage.recognition_result]
     *     representing the concatenated user speech segments captured so far.
     *     This is only populated for audio sessions.
     * 2.  Response (Next M messages):
     *     Contains
     *     [SessionOutput][google.cloud.ces.v1.BidiSessionServerMessage.session_output]
     *     delivering the agent's response in various modalities (e.g., text,
     *     audio).
     * 3.  Turn Completion (Final message of the turn):
     *     Contains
     *     [SessionOutput][google.cloud.ces.v1.BidiSessionServerMessage.session_output]
     *     with [turn_completed][google.cloud.ces.v1.SessionOutput.turn_completed]
     *     set to true. This signals the end of the current turn and includes
     *     [DiagnosticInfo][google.cloud.ces.v1.SessionOutput.diagnostic_info]
     *     with execution details.
     * --- Audio Best Practices ---
     * 1.  Streaming:
     *     Stream [audio data][google.cloud.ces.v1.SessionInput.audio]
     *     **CONTINUOUSLY**, even during silence. Recommended chunk size: 40-120ms
     *     (balances latency vs. efficiency).
     * 2.  Playback &amp; Interruption:
     *     Play [audio responses][google.cloud.ces.v1.SessionOutput.audio] upon
     *     receipt. Stop playback immediately if an
     *     [InterruptionSignal][google.cloud.ces.v1.BidiSessionServerMessage.interruption_signal]
     *     is received (e.g., user barge-in or new agent response).
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.BidiSessionClientMessage>
        bidiRunSession(
            io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.BidiSessionServerMessage>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getBidiRunSessionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SessionService.
   *
   * <pre>
   * Session service provides APIs for interacting with CES agents.
   * </pre>
   */
  public abstract static class SessionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SessionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SessionService.
   *
   * <pre>
   * Session service provides APIs for interacting with CES agents.
   * </pre>
   */
  public static final class SessionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SessionServiceStub> {
    private SessionServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Initiates a single turn interaction with the CES agent within a
     * session.
     * </pre>
     */
    public void runSession(
        com.google.cloud.ces.v1.RunSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.RunSessionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunSessionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Establishes a bidirectional streaming connection with the CES agent.
     * The agent processes continuous multimodal inputs (e.g., text, audio) and
     * generates real-time multimodal output streams.
     * --- Client Request Stream ---
     * The client streams requests in the following order:
     * 1.  Initialization:
     *     The first message must contain
     *     [SessionConfig][google.cloud.ces.v1.BidiSessionClientMessage.config].
     *     For audio sessions, this should also include
     *     [InputAudioConfig][google.cloud.ces.v1.SessionConfig.input_audio_config]
     *     and
     *     [OutputAudioConfig][google.cloud.ces.v1.SessionConfig.output_audio_config]
     *     to define audio processing and synthesis parameters.
     * 2.  Interaction:
     *     Subsequent messages stream
     *     [SessionInput][google.cloud.ces.v1.BidiSessionClientMessage.realtime_input]
     *     containing real-time user input data.
     * 3.  Termination:
     *     The client should half-close the stream when there is no more user
     *     input. It should also half-close upon receiving
     *     [EndSession][google.cloud.ces.v1.BidiSessionServerMessage.end_session]
     *     or [GoAway][google.cloud.ces.v1.BidiSessionServerMessage.go_away] from
     *     the agent.
     * --- Server Response Stream ---
     * For each interaction turn, the agent streams messages in the following
     * sequence:
     * 1.  Speech Recognition (First N messages):
     *     Contains
     *     [RecognitionResult][google.cloud.ces.v1.BidiSessionServerMessage.recognition_result]
     *     representing the concatenated user speech segments captured so far.
     *     This is only populated for audio sessions.
     * 2.  Response (Next M messages):
     *     Contains
     *     [SessionOutput][google.cloud.ces.v1.BidiSessionServerMessage.session_output]
     *     delivering the agent's response in various modalities (e.g., text,
     *     audio).
     * 3.  Turn Completion (Final message of the turn):
     *     Contains
     *     [SessionOutput][google.cloud.ces.v1.BidiSessionServerMessage.session_output]
     *     with [turn_completed][google.cloud.ces.v1.SessionOutput.turn_completed]
     *     set to true. This signals the end of the current turn and includes
     *     [DiagnosticInfo][google.cloud.ces.v1.SessionOutput.diagnostic_info]
     *     with execution details.
     * --- Audio Best Practices ---
     * 1.  Streaming:
     *     Stream [audio data][google.cloud.ces.v1.SessionInput.audio]
     *     **CONTINUOUSLY**, even during silence. Recommended chunk size: 40-120ms
     *     (balances latency vs. efficiency).
     * 2.  Playback &amp; Interruption:
     *     Play [audio responses][google.cloud.ces.v1.SessionOutput.audio] upon
     *     receipt. Stop playback immediately if an
     *     [InterruptionSignal][google.cloud.ces.v1.BidiSessionServerMessage.interruption_signal]
     *     is received (e.g., user barge-in or new agent response).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.BidiSessionClientMessage>
        bidiRunSession(
            io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.BidiSessionServerMessage>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBidiRunSessionMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SessionService.
   *
   * <pre>
   * Session service provides APIs for interacting with CES agents.
   * </pre>
   */
  public static final class SessionServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SessionServiceBlockingV2Stub> {
    private SessionServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Initiates a single turn interaction with the CES agent within a
     * session.
     * </pre>
     */
    public com.google.cloud.ces.v1.RunSessionResponse runSession(
        com.google.cloud.ces.v1.RunSessionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRunSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Establishes a bidirectional streaming connection with the CES agent.
     * The agent processes continuous multimodal inputs (e.g., text, audio) and
     * generates real-time multimodal output streams.
     * --- Client Request Stream ---
     * The client streams requests in the following order:
     * 1.  Initialization:
     *     The first message must contain
     *     [SessionConfig][google.cloud.ces.v1.BidiSessionClientMessage.config].
     *     For audio sessions, this should also include
     *     [InputAudioConfig][google.cloud.ces.v1.SessionConfig.input_audio_config]
     *     and
     *     [OutputAudioConfig][google.cloud.ces.v1.SessionConfig.output_audio_config]
     *     to define audio processing and synthesis parameters.
     * 2.  Interaction:
     *     Subsequent messages stream
     *     [SessionInput][google.cloud.ces.v1.BidiSessionClientMessage.realtime_input]
     *     containing real-time user input data.
     * 3.  Termination:
     *     The client should half-close the stream when there is no more user
     *     input. It should also half-close upon receiving
     *     [EndSession][google.cloud.ces.v1.BidiSessionServerMessage.end_session]
     *     or [GoAway][google.cloud.ces.v1.BidiSessionServerMessage.go_away] from
     *     the agent.
     * --- Server Response Stream ---
     * For each interaction turn, the agent streams messages in the following
     * sequence:
     * 1.  Speech Recognition (First N messages):
     *     Contains
     *     [RecognitionResult][google.cloud.ces.v1.BidiSessionServerMessage.recognition_result]
     *     representing the concatenated user speech segments captured so far.
     *     This is only populated for audio sessions.
     * 2.  Response (Next M messages):
     *     Contains
     *     [SessionOutput][google.cloud.ces.v1.BidiSessionServerMessage.session_output]
     *     delivering the agent's response in various modalities (e.g., text,
     *     audio).
     * 3.  Turn Completion (Final message of the turn):
     *     Contains
     *     [SessionOutput][google.cloud.ces.v1.BidiSessionServerMessage.session_output]
     *     with [turn_completed][google.cloud.ces.v1.SessionOutput.turn_completed]
     *     set to true. This signals the end of the current turn and includes
     *     [DiagnosticInfo][google.cloud.ces.v1.SessionOutput.diagnostic_info]
     *     with execution details.
     * --- Audio Best Practices ---
     * 1.  Streaming:
     *     Stream [audio data][google.cloud.ces.v1.SessionInput.audio]
     *     **CONTINUOUSLY**, even during silence. Recommended chunk size: 40-120ms
     *     (balances latency vs. efficiency).
     * 2.  Playback &amp; Interruption:
     *     Play [audio responses][google.cloud.ces.v1.SessionOutput.audio] upon
     *     receipt. Stop playback immediately if an
     *     [InterruptionSignal][google.cloud.ces.v1.BidiSessionServerMessage.interruption_signal]
     *     is received (e.g., user barge-in or new agent response).
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            com.google.cloud.ces.v1.BidiSessionClientMessage,
            com.google.cloud.ces.v1.BidiSessionServerMessage>
        bidiRunSession() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getBidiRunSessionMethod(), getCallOptions());
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SessionService.
   *
   * <pre>
   * Session service provides APIs for interacting with CES agents.
   * </pre>
   */
  public static final class SessionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SessionServiceBlockingStub> {
    private SessionServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Initiates a single turn interaction with the CES agent within a
     * session.
     * </pre>
     */
    public com.google.cloud.ces.v1.RunSessionResponse runSession(
        com.google.cloud.ces.v1.RunSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunSessionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SessionService.
   *
   * <pre>
   * Session service provides APIs for interacting with CES agents.
   * </pre>
   */
  public static final class SessionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SessionServiceFutureStub> {
    private SessionServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Initiates a single turn interaction with the CES agent within a
     * session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.RunSessionResponse>
        runSession(com.google.cloud.ces.v1.RunSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunSessionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RUN_SESSION = 0;
  private static final int METHODID_BIDI_RUN_SESSION = 1;

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
        case METHODID_RUN_SESSION:
          serviceImpl.runSession(
              (com.google.cloud.ces.v1.RunSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.RunSessionResponse>)
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
        case METHODID_BIDI_RUN_SESSION:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.bidiRunSession(
                  (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.BidiSessionServerMessage>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getRunSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.RunSessionRequest,
                    com.google.cloud.ces.v1.RunSessionResponse>(service, METHODID_RUN_SESSION)))
        .addMethod(
            getBidiRunSessionMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.BidiSessionClientMessage,
                    com.google.cloud.ces.v1.BidiSessionServerMessage>(
                    service, METHODID_BIDI_RUN_SESSION)))
        .build();
  }

  private abstract static class SessionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SessionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.ces.v1.SessionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SessionService");
    }
  }

  private static final class SessionServiceFileDescriptorSupplier
      extends SessionServiceBaseDescriptorSupplier {
    SessionServiceFileDescriptorSupplier() {}
  }

  private static final class SessionServiceMethodDescriptorSupplier
      extends SessionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SessionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SessionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SessionServiceFileDescriptorSupplier())
                      .addMethod(getRunSessionMethod())
                      .addMethod(getBidiRunSessionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
