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
package com.google.cloud.texttospeech.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service that implements Google Cloud Text-to-Speech API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/texttospeech/v1beta1/cloud_tts.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TextToSpeechGrpc {

  private TextToSpeechGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.texttospeech.v1beta1.TextToSpeech";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.texttospeech.v1beta1.ListVoicesRequest,
          com.google.cloud.texttospeech.v1beta1.ListVoicesResponse>
      getListVoicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVoices",
      requestType = com.google.cloud.texttospeech.v1beta1.ListVoicesRequest.class,
      responseType = com.google.cloud.texttospeech.v1beta1.ListVoicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.texttospeech.v1beta1.ListVoicesRequest,
          com.google.cloud.texttospeech.v1beta1.ListVoicesResponse>
      getListVoicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.texttospeech.v1beta1.ListVoicesRequest,
            com.google.cloud.texttospeech.v1beta1.ListVoicesResponse>
        getListVoicesMethod;
    if ((getListVoicesMethod = TextToSpeechGrpc.getListVoicesMethod) == null) {
      synchronized (TextToSpeechGrpc.class) {
        if ((getListVoicesMethod = TextToSpeechGrpc.getListVoicesMethod) == null) {
          TextToSpeechGrpc.getListVoicesMethod =
              getListVoicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.texttospeech.v1beta1.ListVoicesRequest,
                          com.google.cloud.texttospeech.v1beta1.ListVoicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVoices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.texttospeech.v1beta1.ListVoicesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.texttospeech.v1beta1.ListVoicesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TextToSpeechMethodDescriptorSupplier("ListVoices"))
                      .build();
        }
      }
    }
    return getListVoicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest,
          com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse>
      getSynthesizeSpeechMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SynthesizeSpeech",
      requestType = com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest.class,
      responseType = com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest,
          com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse>
      getSynthesizeSpeechMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest,
            com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse>
        getSynthesizeSpeechMethod;
    if ((getSynthesizeSpeechMethod = TextToSpeechGrpc.getSynthesizeSpeechMethod) == null) {
      synchronized (TextToSpeechGrpc.class) {
        if ((getSynthesizeSpeechMethod = TextToSpeechGrpc.getSynthesizeSpeechMethod) == null) {
          TextToSpeechGrpc.getSynthesizeSpeechMethod =
              getSynthesizeSpeechMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest,
                          com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SynthesizeSpeech"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TextToSpeechMethodDescriptorSupplier("SynthesizeSpeech"))
                      .build();
        }
      }
    }
    return getSynthesizeSpeechMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeRequest,
          com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeResponse>
      getStreamingSynthesizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingSynthesize",
      requestType = com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeRequest.class,
      responseType = com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeRequest,
          com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeResponse>
      getStreamingSynthesizeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeRequest,
            com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeResponse>
        getStreamingSynthesizeMethod;
    if ((getStreamingSynthesizeMethod = TextToSpeechGrpc.getStreamingSynthesizeMethod) == null) {
      synchronized (TextToSpeechGrpc.class) {
        if ((getStreamingSynthesizeMethod = TextToSpeechGrpc.getStreamingSynthesizeMethod)
            == null) {
          TextToSpeechGrpc.getStreamingSynthesizeMethod =
              getStreamingSynthesizeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeRequest,
                          com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "StreamingSynthesize"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TextToSpeechMethodDescriptorSupplier("StreamingSynthesize"))
                      .build();
        }
      }
    }
    return getStreamingSynthesizeMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TextToSpeechStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TextToSpeechStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TextToSpeechStub>() {
          @java.lang.Override
          public TextToSpeechStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TextToSpeechStub(channel, callOptions);
          }
        };
    return TextToSpeechStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static TextToSpeechBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TextToSpeechBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TextToSpeechBlockingV2Stub>() {
          @java.lang.Override
          public TextToSpeechBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TextToSpeechBlockingV2Stub(channel, callOptions);
          }
        };
    return TextToSpeechBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TextToSpeechBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TextToSpeechBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TextToSpeechBlockingStub>() {
          @java.lang.Override
          public TextToSpeechBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TextToSpeechBlockingStub(channel, callOptions);
          }
        };
    return TextToSpeechBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TextToSpeechFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TextToSpeechFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TextToSpeechFutureStub>() {
          @java.lang.Override
          public TextToSpeechFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TextToSpeechFutureStub(channel, callOptions);
          }
        };
    return TextToSpeechFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service that implements Google Cloud Text-to-Speech API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns a list of Voice supported for synthesis.
     * </pre>
     */
    default void listVoices(
        com.google.cloud.texttospeech.v1beta1.ListVoicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.texttospeech.v1beta1.ListVoicesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListVoicesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Synthesizes speech synchronously: receive results after all text input
     * has been processed.
     * </pre>
     */
    default void synthesizeSpeech(
        com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSynthesizeSpeechMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs bidirectional streaming speech synthesis: receive audio while
     * sending text.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<
            com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeRequest>
        streamingSynthesize(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getStreamingSynthesizeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TextToSpeech.
   *
   * <pre>
   * Service that implements Google Cloud Text-to-Speech API.
   * </pre>
   */
  public abstract static class TextToSpeechImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return TextToSpeechGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TextToSpeech.
   *
   * <pre>
   * Service that implements Google Cloud Text-to-Speech API.
   * </pre>
   */
  public static final class TextToSpeechStub
      extends io.grpc.stub.AbstractAsyncStub<TextToSpeechStub> {
    private TextToSpeechStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextToSpeechStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TextToSpeechStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of Voice supported for synthesis.
     * </pre>
     */
    public void listVoices(
        com.google.cloud.texttospeech.v1beta1.ListVoicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.texttospeech.v1beta1.ListVoicesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVoicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Synthesizes speech synchronously: receive results after all text input
     * has been processed.
     * </pre>
     */
    public void synthesizeSpeech(
        com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSynthesizeSpeechMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs bidirectional streaming speech synthesis: receive audio while
     * sending text.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<
            com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeRequest>
        streamingSynthesize(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeResponse>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingSynthesizeMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TextToSpeech.
   *
   * <pre>
   * Service that implements Google Cloud Text-to-Speech API.
   * </pre>
   */
  public static final class TextToSpeechBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<TextToSpeechBlockingV2Stub> {
    private TextToSpeechBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextToSpeechBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TextToSpeechBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of Voice supported for synthesis.
     * </pre>
     */
    public com.google.cloud.texttospeech.v1beta1.ListVoicesResponse listVoices(
        com.google.cloud.texttospeech.v1beta1.ListVoicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVoicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Synthesizes speech synchronously: receive results after all text input
     * has been processed.
     * </pre>
     */
    public com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse synthesizeSpeech(
        com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSynthesizeSpeechMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Performs bidirectional streaming speech synthesis: receive audio while
     * sending text.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeRequest,
            com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeResponse>
        streamingSynthesize() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getStreamingSynthesizeMethod(), getCallOptions());
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service TextToSpeech.
   *
   * <pre>
   * Service that implements Google Cloud Text-to-Speech API.
   * </pre>
   */
  public static final class TextToSpeechBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TextToSpeechBlockingStub> {
    private TextToSpeechBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextToSpeechBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TextToSpeechBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of Voice supported for synthesis.
     * </pre>
     */
    public com.google.cloud.texttospeech.v1beta1.ListVoicesResponse listVoices(
        com.google.cloud.texttospeech.v1beta1.ListVoicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVoicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Synthesizes speech synchronously: receive results after all text input
     * has been processed.
     * </pre>
     */
    public com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse synthesizeSpeech(
        com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSynthesizeSpeechMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TextToSpeech.
   *
   * <pre>
   * Service that implements Google Cloud Text-to-Speech API.
   * </pre>
   */
  public static final class TextToSpeechFutureStub
      extends io.grpc.stub.AbstractFutureStub<TextToSpeechFutureStub> {
    private TextToSpeechFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextToSpeechFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TextToSpeechFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of Voice supported for synthesis.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.texttospeech.v1beta1.ListVoicesResponse>
        listVoices(com.google.cloud.texttospeech.v1beta1.ListVoicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVoicesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Synthesizes speech synchronously: receive results after all text input
     * has been processed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse>
        synthesizeSpeech(com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSynthesizeSpeechMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_VOICES = 0;
  private static final int METHODID_SYNTHESIZE_SPEECH = 1;
  private static final int METHODID_STREAMING_SYNTHESIZE = 2;

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
        case METHODID_LIST_VOICES:
          serviceImpl.listVoices(
              (com.google.cloud.texttospeech.v1beta1.ListVoicesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.texttospeech.v1beta1.ListVoicesResponse>)
                  responseObserver);
          break;
        case METHODID_SYNTHESIZE_SPEECH:
          serviceImpl.synthesizeSpeech(
              (com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse>)
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
        case METHODID_STREAMING_SYNTHESIZE:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.streamingSynthesize(
                  (io.grpc.stub.StreamObserver<
                          com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListVoicesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.texttospeech.v1beta1.ListVoicesRequest,
                    com.google.cloud.texttospeech.v1beta1.ListVoicesResponse>(
                    service, METHODID_LIST_VOICES)))
        .addMethod(
            getSynthesizeSpeechMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest,
                    com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse>(
                    service, METHODID_SYNTHESIZE_SPEECH)))
        .addMethod(
            getStreamingSynthesizeMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeRequest,
                    com.google.cloud.texttospeech.v1beta1.StreamingSynthesizeResponse>(
                    service, METHODID_STREAMING_SYNTHESIZE)))
        .build();
  }

  private abstract static class TextToSpeechBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TextToSpeechBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.texttospeech.v1beta1.TextToSpeechProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TextToSpeech");
    }
  }

  private static final class TextToSpeechFileDescriptorSupplier
      extends TextToSpeechBaseDescriptorSupplier {
    TextToSpeechFileDescriptorSupplier() {}
  }

  private static final class TextToSpeechMethodDescriptorSupplier
      extends TextToSpeechBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TextToSpeechMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TextToSpeechGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TextToSpeechFileDescriptorSupplier())
                      .addMethod(getListVoicesMethod())
                      .addMethod(getSynthesizeSpeechMethod())
                      .addMethod(getStreamingSynthesizeMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
