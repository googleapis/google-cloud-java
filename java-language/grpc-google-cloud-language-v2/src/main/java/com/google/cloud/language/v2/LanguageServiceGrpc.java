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
package com.google.cloud.language.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Provides text analysis operations such as sentiment analysis and entity
 * recognition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/language/v2/language_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LanguageServiceGrpc {

  private LanguageServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.language.v2.LanguageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.language.v2.AnalyzeSentimentRequest,
          com.google.cloud.language.v2.AnalyzeSentimentResponse>
      getAnalyzeSentimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeSentiment",
      requestType = com.google.cloud.language.v2.AnalyzeSentimentRequest.class,
      responseType = com.google.cloud.language.v2.AnalyzeSentimentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.language.v2.AnalyzeSentimentRequest,
          com.google.cloud.language.v2.AnalyzeSentimentResponse>
      getAnalyzeSentimentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.language.v2.AnalyzeSentimentRequest,
            com.google.cloud.language.v2.AnalyzeSentimentResponse>
        getAnalyzeSentimentMethod;
    if ((getAnalyzeSentimentMethod = LanguageServiceGrpc.getAnalyzeSentimentMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAnalyzeSentimentMethod = LanguageServiceGrpc.getAnalyzeSentimentMethod) == null) {
          LanguageServiceGrpc.getAnalyzeSentimentMethod =
              getAnalyzeSentimentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.language.v2.AnalyzeSentimentRequest,
                          com.google.cloud.language.v2.AnalyzeSentimentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeSentiment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v2.AnalyzeSentimentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v2.AnalyzeSentimentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LanguageServiceMethodDescriptorSupplier("AnalyzeSentiment"))
                      .build();
        }
      }
    }
    return getAnalyzeSentimentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.language.v2.AnalyzeEntitiesRequest,
          com.google.cloud.language.v2.AnalyzeEntitiesResponse>
      getAnalyzeEntitiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeEntities",
      requestType = com.google.cloud.language.v2.AnalyzeEntitiesRequest.class,
      responseType = com.google.cloud.language.v2.AnalyzeEntitiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.language.v2.AnalyzeEntitiesRequest,
          com.google.cloud.language.v2.AnalyzeEntitiesResponse>
      getAnalyzeEntitiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.language.v2.AnalyzeEntitiesRequest,
            com.google.cloud.language.v2.AnalyzeEntitiesResponse>
        getAnalyzeEntitiesMethod;
    if ((getAnalyzeEntitiesMethod = LanguageServiceGrpc.getAnalyzeEntitiesMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAnalyzeEntitiesMethod = LanguageServiceGrpc.getAnalyzeEntitiesMethod) == null) {
          LanguageServiceGrpc.getAnalyzeEntitiesMethod =
              getAnalyzeEntitiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.language.v2.AnalyzeEntitiesRequest,
                          com.google.cloud.language.v2.AnalyzeEntitiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeEntities"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v2.AnalyzeEntitiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v2.AnalyzeEntitiesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LanguageServiceMethodDescriptorSupplier("AnalyzeEntities"))
                      .build();
        }
      }
    }
    return getAnalyzeEntitiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.language.v2.ClassifyTextRequest,
          com.google.cloud.language.v2.ClassifyTextResponse>
      getClassifyTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClassifyText",
      requestType = com.google.cloud.language.v2.ClassifyTextRequest.class,
      responseType = com.google.cloud.language.v2.ClassifyTextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.language.v2.ClassifyTextRequest,
          com.google.cloud.language.v2.ClassifyTextResponse>
      getClassifyTextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.language.v2.ClassifyTextRequest,
            com.google.cloud.language.v2.ClassifyTextResponse>
        getClassifyTextMethod;
    if ((getClassifyTextMethod = LanguageServiceGrpc.getClassifyTextMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getClassifyTextMethod = LanguageServiceGrpc.getClassifyTextMethod) == null) {
          LanguageServiceGrpc.getClassifyTextMethod =
              getClassifyTextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.language.v2.ClassifyTextRequest,
                          com.google.cloud.language.v2.ClassifyTextResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClassifyText"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v2.ClassifyTextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v2.ClassifyTextResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LanguageServiceMethodDescriptorSupplier("ClassifyText"))
                      .build();
        }
      }
    }
    return getClassifyTextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.language.v2.ModerateTextRequest,
          com.google.cloud.language.v2.ModerateTextResponse>
      getModerateTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModerateText",
      requestType = com.google.cloud.language.v2.ModerateTextRequest.class,
      responseType = com.google.cloud.language.v2.ModerateTextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.language.v2.ModerateTextRequest,
          com.google.cloud.language.v2.ModerateTextResponse>
      getModerateTextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.language.v2.ModerateTextRequest,
            com.google.cloud.language.v2.ModerateTextResponse>
        getModerateTextMethod;
    if ((getModerateTextMethod = LanguageServiceGrpc.getModerateTextMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getModerateTextMethod = LanguageServiceGrpc.getModerateTextMethod) == null) {
          LanguageServiceGrpc.getModerateTextMethod =
              getModerateTextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.language.v2.ModerateTextRequest,
                          com.google.cloud.language.v2.ModerateTextResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModerateText"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v2.ModerateTextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v2.ModerateTextResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LanguageServiceMethodDescriptorSupplier("ModerateText"))
                      .build();
        }
      }
    }
    return getModerateTextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.language.v2.AnnotateTextRequest,
          com.google.cloud.language.v2.AnnotateTextResponse>
      getAnnotateTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnnotateText",
      requestType = com.google.cloud.language.v2.AnnotateTextRequest.class,
      responseType = com.google.cloud.language.v2.AnnotateTextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.language.v2.AnnotateTextRequest,
          com.google.cloud.language.v2.AnnotateTextResponse>
      getAnnotateTextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.language.v2.AnnotateTextRequest,
            com.google.cloud.language.v2.AnnotateTextResponse>
        getAnnotateTextMethod;
    if ((getAnnotateTextMethod = LanguageServiceGrpc.getAnnotateTextMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAnnotateTextMethod = LanguageServiceGrpc.getAnnotateTextMethod) == null) {
          LanguageServiceGrpc.getAnnotateTextMethod =
              getAnnotateTextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.language.v2.AnnotateTextRequest,
                          com.google.cloud.language.v2.AnnotateTextResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnnotateText"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v2.AnnotateTextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v2.AnnotateTextResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LanguageServiceMethodDescriptorSupplier("AnnotateText"))
                      .build();
        }
      }
    }
    return getAnnotateTextMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LanguageServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LanguageServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LanguageServiceStub>() {
          @java.lang.Override
          public LanguageServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LanguageServiceStub(channel, callOptions);
          }
        };
    return LanguageServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LanguageServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LanguageServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LanguageServiceBlockingStub>() {
          @java.lang.Override
          public LanguageServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LanguageServiceBlockingStub(channel, callOptions);
          }
        };
    return LanguageServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LanguageServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LanguageServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LanguageServiceFutureStub>() {
          @java.lang.Override
          public LanguageServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LanguageServiceFutureStub(channel, callOptions);
          }
        };
    return LanguageServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Provides text analysis operations such as sentiment analysis and entity
   * recognition.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Analyzes the sentiment of the provided text.
     * </pre>
     */
    default void analyzeSentiment(
        com.google.cloud.language.v2.AnalyzeSentimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v2.AnalyzeSentimentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnalyzeSentimentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Finds named entities (currently proper names and common nouns) in the text
     * along with entity types, probability, mentions for each entity, and
     * other properties.
     * </pre>
     */
    default void analyzeEntities(
        com.google.cloud.language.v2.AnalyzeEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v2.AnalyzeEntitiesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnalyzeEntitiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Classifies a document into categories.
     * </pre>
     */
    default void classifyText(
        com.google.cloud.language.v2.ClassifyTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v2.ClassifyTextResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getClassifyTextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Moderates a document for harmful and sensitive categories.
     * </pre>
     */
    default void moderateText(
        com.google.cloud.language.v2.ModerateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v2.ModerateTextResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getModerateTextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * A convenience method that provides all features in one call.
     * </pre>
     */
    default void annotateText(
        com.google.cloud.language.v2.AnnotateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v2.AnnotateTextResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnnotateTextMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LanguageService.
   *
   * <pre>
   * Provides text analysis operations such as sentiment analysis and entity
   * recognition.
   * </pre>
   */
  public abstract static class LanguageServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LanguageServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LanguageService.
   *
   * <pre>
   * Provides text analysis operations such as sentiment analysis and entity
   * recognition.
   * </pre>
   */
  public static final class LanguageServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LanguageServiceStub> {
    private LanguageServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LanguageServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LanguageServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Analyzes the sentiment of the provided text.
     * </pre>
     */
    public void analyzeSentiment(
        com.google.cloud.language.v2.AnalyzeSentimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v2.AnalyzeSentimentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeSentimentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Finds named entities (currently proper names and common nouns) in the text
     * along with entity types, probability, mentions for each entity, and
     * other properties.
     * </pre>
     */
    public void analyzeEntities(
        com.google.cloud.language.v2.AnalyzeEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v2.AnalyzeEntitiesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeEntitiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Classifies a document into categories.
     * </pre>
     */
    public void classifyText(
        com.google.cloud.language.v2.ClassifyTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v2.ClassifyTextResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getClassifyTextMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Moderates a document for harmful and sensitive categories.
     * </pre>
     */
    public void moderateText(
        com.google.cloud.language.v2.ModerateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v2.ModerateTextResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModerateTextMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * A convenience method that provides all features in one call.
     * </pre>
     */
    public void annotateText(
        com.google.cloud.language.v2.AnnotateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v2.AnnotateTextResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnnotateTextMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LanguageService.
   *
   * <pre>
   * Provides text analysis operations such as sentiment analysis and entity
   * recognition.
   * </pre>
   */
  public static final class LanguageServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LanguageServiceBlockingStub> {
    private LanguageServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LanguageServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LanguageServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Analyzes the sentiment of the provided text.
     * </pre>
     */
    public com.google.cloud.language.v2.AnalyzeSentimentResponse analyzeSentiment(
        com.google.cloud.language.v2.AnalyzeSentimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeSentimentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Finds named entities (currently proper names and common nouns) in the text
     * along with entity types, probability, mentions for each entity, and
     * other properties.
     * </pre>
     */
    public com.google.cloud.language.v2.AnalyzeEntitiesResponse analyzeEntities(
        com.google.cloud.language.v2.AnalyzeEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeEntitiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Classifies a document into categories.
     * </pre>
     */
    public com.google.cloud.language.v2.ClassifyTextResponse classifyText(
        com.google.cloud.language.v2.ClassifyTextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getClassifyTextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Moderates a document for harmful and sensitive categories.
     * </pre>
     */
    public com.google.cloud.language.v2.ModerateTextResponse moderateText(
        com.google.cloud.language.v2.ModerateTextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModerateTextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * A convenience method that provides all features in one call.
     * </pre>
     */
    public com.google.cloud.language.v2.AnnotateTextResponse annotateText(
        com.google.cloud.language.v2.AnnotateTextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnnotateTextMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LanguageService.
   *
   * <pre>
   * Provides text analysis operations such as sentiment analysis and entity
   * recognition.
   * </pre>
   */
  public static final class LanguageServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LanguageServiceFutureStub> {
    private LanguageServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LanguageServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LanguageServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Analyzes the sentiment of the provided text.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.language.v2.AnalyzeSentimentResponse>
        analyzeSentiment(com.google.cloud.language.v2.AnalyzeSentimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeSentimentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Finds named entities (currently proper names and common nouns) in the text
     * along with entity types, probability, mentions for each entity, and
     * other properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.language.v2.AnalyzeEntitiesResponse>
        analyzeEntities(com.google.cloud.language.v2.AnalyzeEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeEntitiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Classifies a document into categories.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.language.v2.ClassifyTextResponse>
        classifyText(com.google.cloud.language.v2.ClassifyTextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getClassifyTextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Moderates a document for harmful and sensitive categories.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.language.v2.ModerateTextResponse>
        moderateText(com.google.cloud.language.v2.ModerateTextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModerateTextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * A convenience method that provides all features in one call.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.language.v2.AnnotateTextResponse>
        annotateText(com.google.cloud.language.v2.AnnotateTextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnnotateTextMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANALYZE_SENTIMENT = 0;
  private static final int METHODID_ANALYZE_ENTITIES = 1;
  private static final int METHODID_CLASSIFY_TEXT = 2;
  private static final int METHODID_MODERATE_TEXT = 3;
  private static final int METHODID_ANNOTATE_TEXT = 4;

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
        case METHODID_ANALYZE_SENTIMENT:
          serviceImpl.analyzeSentiment(
              (com.google.cloud.language.v2.AnalyzeSentimentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v2.AnalyzeSentimentResponse>)
                  responseObserver);
          break;
        case METHODID_ANALYZE_ENTITIES:
          serviceImpl.analyzeEntities(
              (com.google.cloud.language.v2.AnalyzeEntitiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v2.AnalyzeEntitiesResponse>)
                  responseObserver);
          break;
        case METHODID_CLASSIFY_TEXT:
          serviceImpl.classifyText(
              (com.google.cloud.language.v2.ClassifyTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v2.ClassifyTextResponse>)
                  responseObserver);
          break;
        case METHODID_MODERATE_TEXT:
          serviceImpl.moderateText(
              (com.google.cloud.language.v2.ModerateTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v2.ModerateTextResponse>)
                  responseObserver);
          break;
        case METHODID_ANNOTATE_TEXT:
          serviceImpl.annotateText(
              (com.google.cloud.language.v2.AnnotateTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v2.AnnotateTextResponse>)
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getAnalyzeSentimentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.language.v2.AnalyzeSentimentRequest,
                    com.google.cloud.language.v2.AnalyzeSentimentResponse>(
                    service, METHODID_ANALYZE_SENTIMENT)))
        .addMethod(
            getAnalyzeEntitiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.language.v2.AnalyzeEntitiesRequest,
                    com.google.cloud.language.v2.AnalyzeEntitiesResponse>(
                    service, METHODID_ANALYZE_ENTITIES)))
        .addMethod(
            getClassifyTextMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.language.v2.ClassifyTextRequest,
                    com.google.cloud.language.v2.ClassifyTextResponse>(
                    service, METHODID_CLASSIFY_TEXT)))
        .addMethod(
            getModerateTextMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.language.v2.ModerateTextRequest,
                    com.google.cloud.language.v2.ModerateTextResponse>(
                    service, METHODID_MODERATE_TEXT)))
        .addMethod(
            getAnnotateTextMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.language.v2.AnnotateTextRequest,
                    com.google.cloud.language.v2.AnnotateTextResponse>(
                    service, METHODID_ANNOTATE_TEXT)))
        .build();
  }

  private abstract static class LanguageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LanguageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.language.v2.LanguageServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LanguageService");
    }
  }

  private static final class LanguageServiceFileDescriptorSupplier
      extends LanguageServiceBaseDescriptorSupplier {
    LanguageServiceFileDescriptorSupplier() {}
  }

  private static final class LanguageServiceMethodDescriptorSupplier
      extends LanguageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LanguageServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LanguageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LanguageServiceFileDescriptorSupplier())
                      .addMethod(getAnalyzeSentimentMethod())
                      .addMethod(getAnalyzeEntitiesMethod())
                      .addMethod(getClassifyTextMethod())
                      .addMethod(getModerateTextMethod())
                      .addMethod(getAnnotateTextMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
