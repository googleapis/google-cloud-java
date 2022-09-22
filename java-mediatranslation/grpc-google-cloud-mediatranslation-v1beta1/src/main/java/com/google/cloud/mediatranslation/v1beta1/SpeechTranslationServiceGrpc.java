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
package com.google.cloud.mediatranslation.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Provides translation from/to media types.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/mediatranslation/v1beta1/media_translation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SpeechTranslationServiceGrpc {

  private SpeechTranslationServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.mediatranslation.v1beta1.SpeechTranslationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechRequest,
          com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechResponse>
      getStreamingTranslateSpeechMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingTranslateSpeech",
      requestType = com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechRequest.class,
      responseType =
          com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechRequest,
          com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechResponse>
      getStreamingTranslateSpeechMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechRequest,
            com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechResponse>
        getStreamingTranslateSpeechMethod;
    if ((getStreamingTranslateSpeechMethod =
            SpeechTranslationServiceGrpc.getStreamingTranslateSpeechMethod)
        == null) {
      synchronized (SpeechTranslationServiceGrpc.class) {
        if ((getStreamingTranslateSpeechMethod =
                SpeechTranslationServiceGrpc.getStreamingTranslateSpeechMethod)
            == null) {
          SpeechTranslationServiceGrpc.getStreamingTranslateSpeechMethod =
              getStreamingTranslateSpeechMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechRequest,
                          com.google.cloud.mediatranslation.v1beta1
                              .StreamingTranslateSpeechResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "StreamingTranslateSpeech"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.mediatranslation.v1beta1
                                  .StreamingTranslateSpeechRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.mediatranslation.v1beta1
                                  .StreamingTranslateSpeechResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SpeechTranslationServiceMethodDescriptorSupplier(
                              "StreamingTranslateSpeech"))
                      .build();
        }
      }
    }
    return getStreamingTranslateSpeechMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SpeechTranslationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpeechTranslationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpeechTranslationServiceStub>() {
          @java.lang.Override
          public SpeechTranslationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpeechTranslationServiceStub(channel, callOptions);
          }
        };
    return SpeechTranslationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SpeechTranslationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpeechTranslationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpeechTranslationServiceBlockingStub>() {
          @java.lang.Override
          public SpeechTranslationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpeechTranslationServiceBlockingStub(channel, callOptions);
          }
        };
    return SpeechTranslationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SpeechTranslationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpeechTranslationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpeechTranslationServiceFutureStub>() {
          @java.lang.Override
          public SpeechTranslationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpeechTranslationServiceFutureStub(channel, callOptions);
          }
        };
    return SpeechTranslationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Provides translation from/to media types.
   * </pre>
   */
  public abstract static class SpeechTranslationServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Performs bidirectional streaming speech translation: receive results while
     * sending audio. This method is only available via the gRPC API (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<
            com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechRequest>
        streamingTranslateSpeech(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getStreamingTranslateSpeechMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getStreamingTranslateSpeechMethod(),
              io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                  new MethodHandlers<
                      com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechRequest,
                      com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechResponse>(
                      this, METHODID_STREAMING_TRANSLATE_SPEECH)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Provides translation from/to media types.
   * </pre>
   */
  public static final class SpeechTranslationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SpeechTranslationServiceStub> {
    private SpeechTranslationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeechTranslationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpeechTranslationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs bidirectional streaming speech translation: receive results while
     * sending audio. This method is only available via the gRPC API (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<
            com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechRequest>
        streamingTranslateSpeech(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.mediatranslation.v1beta1.StreamingTranslateSpeechResponse>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingTranslateSpeechMethod(), getCallOptions()),
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Provides translation from/to media types.
   * </pre>
   */
  public static final class SpeechTranslationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SpeechTranslationServiceBlockingStub> {
    private SpeechTranslationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeechTranslationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpeechTranslationServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   *
   *
   * <pre>
   * Provides translation from/to media types.
   * </pre>
   */
  public static final class SpeechTranslationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SpeechTranslationServiceFutureStub> {
    private SpeechTranslationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeechTranslationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpeechTranslationServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAMING_TRANSLATE_SPEECH = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SpeechTranslationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SpeechTranslationServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_STREAMING_TRANSLATE_SPEECH:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.streamingTranslateSpeech(
                  (io.grpc.stub.StreamObserver<
                          com.google.cloud.mediatranslation.v1beta1
                              .StreamingTranslateSpeechResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private abstract static class SpeechTranslationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SpeechTranslationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.mediatranslation.v1beta1.MediaTranslationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SpeechTranslationService");
    }
  }

  private static final class SpeechTranslationServiceFileDescriptorSupplier
      extends SpeechTranslationServiceBaseDescriptorSupplier {
    SpeechTranslationServiceFileDescriptorSupplier() {}
  }

  private static final class SpeechTranslationServiceMethodDescriptorSupplier
      extends SpeechTranslationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SpeechTranslationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SpeechTranslationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SpeechTranslationServiceFileDescriptorSupplier())
                      .addMethod(getStreamingTranslateSpeechMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
