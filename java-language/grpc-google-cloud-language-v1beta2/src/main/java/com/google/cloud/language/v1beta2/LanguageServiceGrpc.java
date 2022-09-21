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
package com.google.cloud.language.v1beta2;

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
    comments = "Source: google/cloud/language/v1beta2/language_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LanguageServiceGrpc {

  private LanguageServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.language.v1beta2.LanguageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.language.v1beta2.AnalyzeSentimentRequest,
          com.google.cloud.language.v1beta2.AnalyzeSentimentResponse>
      getAnalyzeSentimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeSentiment",
      requestType = com.google.cloud.language.v1beta2.AnalyzeSentimentRequest.class,
      responseType = com.google.cloud.language.v1beta2.AnalyzeSentimentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.language.v1beta2.AnalyzeSentimentRequest,
          com.google.cloud.language.v1beta2.AnalyzeSentimentResponse>
      getAnalyzeSentimentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.language.v1beta2.AnalyzeSentimentRequest,
            com.google.cloud.language.v1beta2.AnalyzeSentimentResponse>
        getAnalyzeSentimentMethod;
    if ((getAnalyzeSentimentMethod = LanguageServiceGrpc.getAnalyzeSentimentMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAnalyzeSentimentMethod = LanguageServiceGrpc.getAnalyzeSentimentMethod) == null) {
          LanguageServiceGrpc.getAnalyzeSentimentMethod =
              getAnalyzeSentimentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.language.v1beta2.AnalyzeSentimentRequest,
                          com.google.cloud.language.v1beta2.AnalyzeSentimentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeSentiment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v1beta2.AnalyzeSentimentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v1beta2.AnalyzeSentimentResponse
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
          com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest,
          com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse>
      getAnalyzeEntitiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeEntities",
      requestType = com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest.class,
      responseType = com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest,
          com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse>
      getAnalyzeEntitiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest,
            com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse>
        getAnalyzeEntitiesMethod;
    if ((getAnalyzeEntitiesMethod = LanguageServiceGrpc.getAnalyzeEntitiesMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAnalyzeEntitiesMethod = LanguageServiceGrpc.getAnalyzeEntitiesMethod) == null) {
          LanguageServiceGrpc.getAnalyzeEntitiesMethod =
              getAnalyzeEntitiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest,
                          com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeEntities"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse
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
          com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest,
          com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse>
      getAnalyzeEntitySentimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeEntitySentiment",
      requestType = com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest.class,
      responseType = com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest,
          com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse>
      getAnalyzeEntitySentimentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest,
            com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse>
        getAnalyzeEntitySentimentMethod;
    if ((getAnalyzeEntitySentimentMethod = LanguageServiceGrpc.getAnalyzeEntitySentimentMethod)
        == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAnalyzeEntitySentimentMethod = LanguageServiceGrpc.getAnalyzeEntitySentimentMethod)
            == null) {
          LanguageServiceGrpc.getAnalyzeEntitySentimentMethod =
              getAnalyzeEntitySentimentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest,
                          com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AnalyzeEntitySentiment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LanguageServiceMethodDescriptorSupplier("AnalyzeEntitySentiment"))
                      .build();
        }
      }
    }
    return getAnalyzeEntitySentimentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest,
          com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse>
      getAnalyzeSyntaxMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeSyntax",
      requestType = com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest.class,
      responseType = com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest,
          com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse>
      getAnalyzeSyntaxMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest,
            com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse>
        getAnalyzeSyntaxMethod;
    if ((getAnalyzeSyntaxMethod = LanguageServiceGrpc.getAnalyzeSyntaxMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAnalyzeSyntaxMethod = LanguageServiceGrpc.getAnalyzeSyntaxMethod) == null) {
          LanguageServiceGrpc.getAnalyzeSyntaxMethod =
              getAnalyzeSyntaxMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest,
                          com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeSyntax"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LanguageServiceMethodDescriptorSupplier("AnalyzeSyntax"))
                      .build();
        }
      }
    }
    return getAnalyzeSyntaxMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.language.v1beta2.ClassifyTextRequest,
          com.google.cloud.language.v1beta2.ClassifyTextResponse>
      getClassifyTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClassifyText",
      requestType = com.google.cloud.language.v1beta2.ClassifyTextRequest.class,
      responseType = com.google.cloud.language.v1beta2.ClassifyTextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.language.v1beta2.ClassifyTextRequest,
          com.google.cloud.language.v1beta2.ClassifyTextResponse>
      getClassifyTextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.language.v1beta2.ClassifyTextRequest,
            com.google.cloud.language.v1beta2.ClassifyTextResponse>
        getClassifyTextMethod;
    if ((getClassifyTextMethod = LanguageServiceGrpc.getClassifyTextMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getClassifyTextMethod = LanguageServiceGrpc.getClassifyTextMethod) == null) {
          LanguageServiceGrpc.getClassifyTextMethod =
              getClassifyTextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.language.v1beta2.ClassifyTextRequest,
                          com.google.cloud.language.v1beta2.ClassifyTextResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClassifyText"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v1beta2.ClassifyTextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v1beta2.ClassifyTextResponse
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
          com.google.cloud.language.v1beta2.AnnotateTextRequest,
          com.google.cloud.language.v1beta2.AnnotateTextResponse>
      getAnnotateTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnnotateText",
      requestType = com.google.cloud.language.v1beta2.AnnotateTextRequest.class,
      responseType = com.google.cloud.language.v1beta2.AnnotateTextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.language.v1beta2.AnnotateTextRequest,
          com.google.cloud.language.v1beta2.AnnotateTextResponse>
      getAnnotateTextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.language.v1beta2.AnnotateTextRequest,
            com.google.cloud.language.v1beta2.AnnotateTextResponse>
        getAnnotateTextMethod;
    if ((getAnnotateTextMethod = LanguageServiceGrpc.getAnnotateTextMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAnnotateTextMethod = LanguageServiceGrpc.getAnnotateTextMethod) == null) {
          LanguageServiceGrpc.getAnnotateTextMethod =
              getAnnotateTextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.language.v1beta2.AnnotateTextRequest,
                          com.google.cloud.language.v1beta2.AnnotateTextResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnnotateText"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v1beta2.AnnotateTextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.language.v1beta2.AnnotateTextResponse
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
  public abstract static class LanguageServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Analyzes the sentiment of the provided text.
     * </pre>
     */
    public void analyzeSentiment(
        com.google.cloud.language.v1beta2.AnalyzeSentimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeSentimentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnalyzeSentimentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Finds named entities (currently proper names and common nouns) in the text
     * along with entity types, salience, mentions for each entity, and
     * other properties.
     * </pre>
     */
    public void analyzeEntities(
        com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnalyzeEntitiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Finds entities, similar to [AnalyzeEntities][google.cloud.language.v1beta2.LanguageService.AnalyzeEntities] in the text and analyzes
     * sentiment associated with each entity and its mentions.
     * </pre>
     */
    public void analyzeEntitySentiment(
        com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnalyzeEntitySentimentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyzes the syntax of the text and provides sentence boundaries and
     * tokenization along with part of speech tags, dependency trees, and other
     * properties.
     * </pre>
     */
    public void analyzeSyntax(
        com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnalyzeSyntaxMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Classifies a document into categories.
     * </pre>
     */
    public void classifyText(
        com.google.cloud.language.v1beta2.ClassifyTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.ClassifyTextResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getClassifyTextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * A convenience method that provides all syntax, sentiment, entity, and
     * classification features in one call.
     * </pre>
     */
    public void annotateText(
        com.google.cloud.language.v1beta2.AnnotateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnnotateTextResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnnotateTextMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getAnalyzeSentimentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.language.v1beta2.AnalyzeSentimentRequest,
                      com.google.cloud.language.v1beta2.AnalyzeSentimentResponse>(
                      this, METHODID_ANALYZE_SENTIMENT)))
          .addMethod(
              getAnalyzeEntitiesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest,
                      com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse>(
                      this, METHODID_ANALYZE_ENTITIES)))
          .addMethod(
              getAnalyzeEntitySentimentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest,
                      com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse>(
                      this, METHODID_ANALYZE_ENTITY_SENTIMENT)))
          .addMethod(
              getAnalyzeSyntaxMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest,
                      com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse>(
                      this, METHODID_ANALYZE_SYNTAX)))
          .addMethod(
              getClassifyTextMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.language.v1beta2.ClassifyTextRequest,
                      com.google.cloud.language.v1beta2.ClassifyTextResponse>(
                      this, METHODID_CLASSIFY_TEXT)))
          .addMethod(
              getAnnotateTextMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.language.v1beta2.AnnotateTextRequest,
                      com.google.cloud.language.v1beta2.AnnotateTextResponse>(
                      this, METHODID_ANNOTATE_TEXT)))
          .build();
    }
  }

  /**
   *
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
        com.google.cloud.language.v1beta2.AnalyzeSentimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeSentimentResponse>
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
     * along with entity types, salience, mentions for each entity, and
     * other properties.
     * </pre>
     */
    public void analyzeEntities(
        com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse>
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
     * Finds entities, similar to [AnalyzeEntities][google.cloud.language.v1beta2.LanguageService.AnalyzeEntities] in the text and analyzes
     * sentiment associated with each entity and its mentions.
     * </pre>
     */
    public void analyzeEntitySentiment(
        com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeEntitySentimentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyzes the syntax of the text and provides sentence boundaries and
     * tokenization along with part of speech tags, dependency trees, and other
     * properties.
     * </pre>
     */
    public void analyzeSyntax(
        com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeSyntaxMethod(), getCallOptions()),
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
        com.google.cloud.language.v1beta2.ClassifyTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.ClassifyTextResponse>
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
     * A convenience method that provides all syntax, sentiment, entity, and
     * classification features in one call.
     * </pre>
     */
    public void annotateText(
        com.google.cloud.language.v1beta2.AnnotateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnnotateTextResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnnotateTextMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
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
    public com.google.cloud.language.v1beta2.AnalyzeSentimentResponse analyzeSentiment(
        com.google.cloud.language.v1beta2.AnalyzeSentimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeSentimentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Finds named entities (currently proper names and common nouns) in the text
     * along with entity types, salience, mentions for each entity, and
     * other properties.
     * </pre>
     */
    public com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse analyzeEntities(
        com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeEntitiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Finds entities, similar to [AnalyzeEntities][google.cloud.language.v1beta2.LanguageService.AnalyzeEntities] in the text and analyzes
     * sentiment associated with each entity and its mentions.
     * </pre>
     */
    public com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse analyzeEntitySentiment(
        com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeEntitySentimentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Analyzes the syntax of the text and provides sentence boundaries and
     * tokenization along with part of speech tags, dependency trees, and other
     * properties.
     * </pre>
     */
    public com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse analyzeSyntax(
        com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeSyntaxMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Classifies a document into categories.
     * </pre>
     */
    public com.google.cloud.language.v1beta2.ClassifyTextResponse classifyText(
        com.google.cloud.language.v1beta2.ClassifyTextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getClassifyTextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * A convenience method that provides all syntax, sentiment, entity, and
     * classification features in one call.
     * </pre>
     */
    public com.google.cloud.language.v1beta2.AnnotateTextResponse annotateText(
        com.google.cloud.language.v1beta2.AnnotateTextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnnotateTextMethod(), getCallOptions(), request);
    }
  }

  /**
   *
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
            com.google.cloud.language.v1beta2.AnalyzeSentimentResponse>
        analyzeSentiment(com.google.cloud.language.v1beta2.AnalyzeSentimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeSentimentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Finds named entities (currently proper names and common nouns) in the text
     * along with entity types, salience, mentions for each entity, and
     * other properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse>
        analyzeEntities(com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeEntitiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Finds entities, similar to [AnalyzeEntities][google.cloud.language.v1beta2.LanguageService.AnalyzeEntities] in the text and analyzes
     * sentiment associated with each entity and its mentions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse>
        analyzeEntitySentiment(
            com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeEntitySentimentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Analyzes the syntax of the text and provides sentence boundaries and
     * tokenization along with part of speech tags, dependency trees, and other
     * properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse>
        analyzeSyntax(com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeSyntaxMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Classifies a document into categories.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.language.v1beta2.ClassifyTextResponse>
        classifyText(com.google.cloud.language.v1beta2.ClassifyTextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getClassifyTextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * A convenience method that provides all syntax, sentiment, entity, and
     * classification features in one call.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.language.v1beta2.AnnotateTextResponse>
        annotateText(com.google.cloud.language.v1beta2.AnnotateTextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnnotateTextMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANALYZE_SENTIMENT = 0;
  private static final int METHODID_ANALYZE_ENTITIES = 1;
  private static final int METHODID_ANALYZE_ENTITY_SENTIMENT = 2;
  private static final int METHODID_ANALYZE_SYNTAX = 3;
  private static final int METHODID_CLASSIFY_TEXT = 4;
  private static final int METHODID_ANNOTATE_TEXT = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LanguageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LanguageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ANALYZE_SENTIMENT:
          serviceImpl.analyzeSentiment(
              (com.google.cloud.language.v1beta2.AnalyzeSentimentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.language.v1beta2.AnalyzeSentimentResponse>)
                  responseObserver);
          break;
        case METHODID_ANALYZE_ENTITIES:
          serviceImpl.analyzeEntities(
              (com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse>)
                  responseObserver);
          break;
        case METHODID_ANALYZE_ENTITY_SENTIMENT:
          serviceImpl.analyzeEntitySentiment(
              (com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse>)
                  responseObserver);
          break;
        case METHODID_ANALYZE_SYNTAX:
          serviceImpl.analyzeSyntax(
              (com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse>)
                  responseObserver);
          break;
        case METHODID_CLASSIFY_TEXT:
          serviceImpl.classifyText(
              (com.google.cloud.language.v1beta2.ClassifyTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.ClassifyTextResponse>)
                  responseObserver);
          break;
        case METHODID_ANNOTATE_TEXT:
          serviceImpl.annotateText(
              (com.google.cloud.language.v1beta2.AnnotateTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnnotateTextResponse>)
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

  private abstract static class LanguageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LanguageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.language.v1beta2.LanguageServiceProto.getDescriptor();
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
    private final String methodName;

    LanguageServiceMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getAnalyzeEntitySentimentMethod())
                      .addMethod(getAnalyzeSyntaxMethod())
                      .addMethod(getClassifyTextMethod())
                      .addMethod(getAnnotateTextMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
