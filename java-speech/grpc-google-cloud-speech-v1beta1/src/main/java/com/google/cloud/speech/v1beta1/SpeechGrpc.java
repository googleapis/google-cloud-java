/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.speech.v1beta1;

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
 * Service that implements Google Cloud Speech API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/speech/v1beta1/cloud_speech.proto")
public final class SpeechGrpc {

  private SpeechGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.speech.v1beta1.Speech";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSyncRecognizeMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1beta1.SyncRecognizeRequest,
          com.google.cloud.speech.v1beta1.SyncRecognizeResponse>
      METHOD_SYNC_RECOGNIZE = getSyncRecognizeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1beta1.SyncRecognizeRequest,
          com.google.cloud.speech.v1beta1.SyncRecognizeResponse>
      getSyncRecognizeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1beta1.SyncRecognizeRequest,
          com.google.cloud.speech.v1beta1.SyncRecognizeResponse>
      getSyncRecognizeMethod() {
    return getSyncRecognizeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1beta1.SyncRecognizeRequest,
          com.google.cloud.speech.v1beta1.SyncRecognizeResponse>
      getSyncRecognizeMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v1beta1.SyncRecognizeRequest,
            com.google.cloud.speech.v1beta1.SyncRecognizeResponse>
        getSyncRecognizeMethod;
    if ((getSyncRecognizeMethod = SpeechGrpc.getSyncRecognizeMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getSyncRecognizeMethod = SpeechGrpc.getSyncRecognizeMethod) == null) {
          SpeechGrpc.getSyncRecognizeMethod =
              getSyncRecognizeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v1beta1.SyncRecognizeRequest,
                          com.google.cloud.speech.v1beta1.SyncRecognizeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.speech.v1beta1.Speech", "SyncRecognize"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1beta1.SyncRecognizeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1beta1.SyncRecognizeResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("SyncRecognize"))
                      .build();
        }
      }
    }
    return getSyncRecognizeMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAsyncRecognizeMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1beta1.AsyncRecognizeRequest, com.google.longrunning.Operation>
      METHOD_ASYNC_RECOGNIZE = getAsyncRecognizeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1beta1.AsyncRecognizeRequest, com.google.longrunning.Operation>
      getAsyncRecognizeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1beta1.AsyncRecognizeRequest, com.google.longrunning.Operation>
      getAsyncRecognizeMethod() {
    return getAsyncRecognizeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1beta1.AsyncRecognizeRequest, com.google.longrunning.Operation>
      getAsyncRecognizeMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v1beta1.AsyncRecognizeRequest, com.google.longrunning.Operation>
        getAsyncRecognizeMethod;
    if ((getAsyncRecognizeMethod = SpeechGrpc.getAsyncRecognizeMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getAsyncRecognizeMethod = SpeechGrpc.getAsyncRecognizeMethod) == null) {
          SpeechGrpc.getAsyncRecognizeMethod =
              getAsyncRecognizeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v1beta1.AsyncRecognizeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.speech.v1beta1.Speech", "AsyncRecognize"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1beta1.AsyncRecognizeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("AsyncRecognize"))
                      .build();
        }
      }
    }
    return getAsyncRecognizeMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStreamingRecognizeMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1beta1.StreamingRecognizeRequest,
          com.google.cloud.speech.v1beta1.StreamingRecognizeResponse>
      METHOD_STREAMING_RECOGNIZE = getStreamingRecognizeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1beta1.StreamingRecognizeRequest,
          com.google.cloud.speech.v1beta1.StreamingRecognizeResponse>
      getStreamingRecognizeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1beta1.StreamingRecognizeRequest,
          com.google.cloud.speech.v1beta1.StreamingRecognizeResponse>
      getStreamingRecognizeMethod() {
    return getStreamingRecognizeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1beta1.StreamingRecognizeRequest,
          com.google.cloud.speech.v1beta1.StreamingRecognizeResponse>
      getStreamingRecognizeMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v1beta1.StreamingRecognizeRequest,
            com.google.cloud.speech.v1beta1.StreamingRecognizeResponse>
        getStreamingRecognizeMethod;
    if ((getStreamingRecognizeMethod = SpeechGrpc.getStreamingRecognizeMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getStreamingRecognizeMethod = SpeechGrpc.getStreamingRecognizeMethod) == null) {
          SpeechGrpc.getStreamingRecognizeMethod =
              getStreamingRecognizeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v1beta1.StreamingRecognizeRequest,
                          com.google.cloud.speech.v1beta1.StreamingRecognizeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.speech.v1beta1.Speech", "StreamingRecognize"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1beta1.StreamingRecognizeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1beta1.StreamingRecognizeResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("StreamingRecognize"))
                      .build();
        }
      }
    }
    return getStreamingRecognizeMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SpeechStub newStub(io.grpc.Channel channel) {
    return new SpeechStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SpeechBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new SpeechBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SpeechFutureStub newFutureStub(io.grpc.Channel channel) {
    return new SpeechFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Service that implements Google Cloud Speech API.
   * </pre>
   */
  public abstract static class SpeechImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Performs synchronous speech recognition: receive results after all audio
     * has been sent and processed.
     * </pre>
     */
    public void syncRecognize(
        com.google.cloud.speech.v1beta1.SyncRecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.SyncRecognizeResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSyncRecognizeMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs asynchronous speech recognition: receive results via the
     * [google.longrunning.Operations]
     * (/speech/reference/rest/v1beta1/operations#Operation)
     * interface. Returns either an
     * `Operation.error` or an `Operation.response` which contains
     * an `AsyncRecognizeResponse` message.
     * </pre>
     */
    public void asyncRecognize(
        com.google.cloud.speech.v1beta1.AsyncRecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getAsyncRecognizeMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs bidirectional streaming speech recognition: receive results while
     * sending audio. This method is only available via the gRPC API (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.StreamingRecognizeRequest>
        streamingRecognize(
            io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.StreamingRecognizeResponse>
                responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamingRecognizeMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getSyncRecognizeMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v1beta1.SyncRecognizeRequest,
                      com.google.cloud.speech.v1beta1.SyncRecognizeResponse>(
                      this, METHODID_SYNC_RECOGNIZE)))
          .addMethod(
              getAsyncRecognizeMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v1beta1.AsyncRecognizeRequest,
                      com.google.longrunning.Operation>(this, METHODID_ASYNC_RECOGNIZE)))
          .addMethod(
              getStreamingRecognizeMethodHelper(),
              asyncBidiStreamingCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v1beta1.StreamingRecognizeRequest,
                      com.google.cloud.speech.v1beta1.StreamingRecognizeResponse>(
                      this, METHODID_STREAMING_RECOGNIZE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service that implements Google Cloud Speech API.
   * </pre>
   */
  public static final class SpeechStub extends io.grpc.stub.AbstractStub<SpeechStub> {
    private SpeechStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpeechStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeechStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpeechStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs synchronous speech recognition: receive results after all audio
     * has been sent and processed.
     * </pre>
     */
    public void syncRecognize(
        com.google.cloud.speech.v1beta1.SyncRecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.SyncRecognizeResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSyncRecognizeMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs asynchronous speech recognition: receive results via the
     * [google.longrunning.Operations]
     * (/speech/reference/rest/v1beta1/operations#Operation)
     * interface. Returns either an
     * `Operation.error` or an `Operation.response` which contains
     * an `AsyncRecognizeResponse` message.
     * </pre>
     */
    public void asyncRecognize(
        com.google.cloud.speech.v1beta1.AsyncRecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAsyncRecognizeMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs bidirectional streaming speech recognition: receive results while
     * sending audio. This method is only available via the gRPC API (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.StreamingRecognizeRequest>
        streamingRecognize(
            io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.StreamingRecognizeResponse>
                responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStreamingRecognizeMethodHelper(), getCallOptions()),
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service that implements Google Cloud Speech API.
   * </pre>
   */
  public static final class SpeechBlockingStub
      extends io.grpc.stub.AbstractStub<SpeechBlockingStub> {
    private SpeechBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpeechBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeechBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpeechBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs synchronous speech recognition: receive results after all audio
     * has been sent and processed.
     * </pre>
     */
    public com.google.cloud.speech.v1beta1.SyncRecognizeResponse syncRecognize(
        com.google.cloud.speech.v1beta1.SyncRecognizeRequest request) {
      return blockingUnaryCall(
          getChannel(), getSyncRecognizeMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Performs asynchronous speech recognition: receive results via the
     * [google.longrunning.Operations]
     * (/speech/reference/rest/v1beta1/operations#Operation)
     * interface. Returns either an
     * `Operation.error` or an `Operation.response` which contains
     * an `AsyncRecognizeResponse` message.
     * </pre>
     */
    public com.google.longrunning.Operation asyncRecognize(
        com.google.cloud.speech.v1beta1.AsyncRecognizeRequest request) {
      return blockingUnaryCall(
          getChannel(), getAsyncRecognizeMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service that implements Google Cloud Speech API.
   * </pre>
   */
  public static final class SpeechFutureStub extends io.grpc.stub.AbstractStub<SpeechFutureStub> {
    private SpeechFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpeechFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeechFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpeechFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs synchronous speech recognition: receive results after all audio
     * has been sent and processed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v1beta1.SyncRecognizeResponse>
        syncRecognize(com.google.cloud.speech.v1beta1.SyncRecognizeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSyncRecognizeMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Performs asynchronous speech recognition: receive results via the
     * [google.longrunning.Operations]
     * (/speech/reference/rest/v1beta1/operations#Operation)
     * interface. Returns either an
     * `Operation.error` or an `Operation.response` which contains
     * an `AsyncRecognizeResponse` message.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        asyncRecognize(com.google.cloud.speech.v1beta1.AsyncRecognizeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAsyncRecognizeMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SYNC_RECOGNIZE = 0;
  private static final int METHODID_ASYNC_RECOGNIZE = 1;
  private static final int METHODID_STREAMING_RECOGNIZE = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SpeechImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SpeechImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SYNC_RECOGNIZE:
          serviceImpl.syncRecognize(
              (com.google.cloud.speech.v1beta1.SyncRecognizeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.SyncRecognizeResponse>)
                  responseObserver);
          break;
        case METHODID_ASYNC_RECOGNIZE:
          serviceImpl.asyncRecognize(
              (com.google.cloud.speech.v1beta1.AsyncRecognizeRequest) request,
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
        case METHODID_STREAMING_RECOGNIZE:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.streamingRecognize(
                  (io.grpc.stub.StreamObserver<
                          com.google.cloud.speech.v1beta1.StreamingRecognizeResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private abstract static class SpeechBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SpeechBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.speech.v1beta1.SpeechProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Speech");
    }
  }

  private static final class SpeechFileDescriptorSupplier extends SpeechBaseDescriptorSupplier {
    SpeechFileDescriptorSupplier() {}
  }

  private static final class SpeechMethodDescriptorSupplier extends SpeechBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SpeechMethodDescriptorSupplier(String methodName) {
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
      synchronized (SpeechGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SpeechFileDescriptorSupplier())
                      .addMethod(getSyncRecognizeMethodHelper())
                      .addMethod(getAsyncRecognizeMethodHelper())
                      .addMethod(getStreamingRecognizeMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
