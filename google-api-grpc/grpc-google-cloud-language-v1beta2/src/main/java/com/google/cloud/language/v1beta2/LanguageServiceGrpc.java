package com.google.cloud.language.v1beta2;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Provides text analysis operations such as sentiment analysis and entity
 * recognition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/language/v1beta2/language_service.proto")
public final class LanguageServiceGrpc {

  private LanguageServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.language.v1beta2.LanguageService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAnalyzeSentimentMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeSentimentRequest,
      com.google.cloud.language.v1beta2.AnalyzeSentimentResponse> METHOD_ANALYZE_SENTIMENT = getAnalyzeSentimentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeSentimentRequest,
      com.google.cloud.language.v1beta2.AnalyzeSentimentResponse> getAnalyzeSentimentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeSentimentRequest,
      com.google.cloud.language.v1beta2.AnalyzeSentimentResponse> getAnalyzeSentimentMethod() {
    return getAnalyzeSentimentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeSentimentRequest,
      com.google.cloud.language.v1beta2.AnalyzeSentimentResponse> getAnalyzeSentimentMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeSentimentRequest, com.google.cloud.language.v1beta2.AnalyzeSentimentResponse> getAnalyzeSentimentMethod;
    if ((getAnalyzeSentimentMethod = LanguageServiceGrpc.getAnalyzeSentimentMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAnalyzeSentimentMethod = LanguageServiceGrpc.getAnalyzeSentimentMethod) == null) {
          LanguageServiceGrpc.getAnalyzeSentimentMethod = getAnalyzeSentimentMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.language.v1beta2.AnalyzeSentimentRequest, com.google.cloud.language.v1beta2.AnalyzeSentimentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.language.v1beta2.LanguageService", "AnalyzeSentiment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.language.v1beta2.AnalyzeSentimentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.language.v1beta2.AnalyzeSentimentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LanguageServiceMethodDescriptorSupplier("AnalyzeSentiment"))
                  .build();
          }
        }
     }
     return getAnalyzeSentimentMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAnalyzeEntitiesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest,
      com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse> METHOD_ANALYZE_ENTITIES = getAnalyzeEntitiesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest,
      com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse> getAnalyzeEntitiesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest,
      com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse> getAnalyzeEntitiesMethod() {
    return getAnalyzeEntitiesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest,
      com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse> getAnalyzeEntitiesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest, com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse> getAnalyzeEntitiesMethod;
    if ((getAnalyzeEntitiesMethod = LanguageServiceGrpc.getAnalyzeEntitiesMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAnalyzeEntitiesMethod = LanguageServiceGrpc.getAnalyzeEntitiesMethod) == null) {
          LanguageServiceGrpc.getAnalyzeEntitiesMethod = getAnalyzeEntitiesMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest, com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.language.v1beta2.LanguageService", "AnalyzeEntities"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LanguageServiceMethodDescriptorSupplier("AnalyzeEntities"))
                  .build();
          }
        }
     }
     return getAnalyzeEntitiesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAnalyzeEntitySentimentMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest,
      com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse> METHOD_ANALYZE_ENTITY_SENTIMENT = getAnalyzeEntitySentimentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest,
      com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse> getAnalyzeEntitySentimentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest,
      com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse> getAnalyzeEntitySentimentMethod() {
    return getAnalyzeEntitySentimentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest,
      com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse> getAnalyzeEntitySentimentMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest, com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse> getAnalyzeEntitySentimentMethod;
    if ((getAnalyzeEntitySentimentMethod = LanguageServiceGrpc.getAnalyzeEntitySentimentMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAnalyzeEntitySentimentMethod = LanguageServiceGrpc.getAnalyzeEntitySentimentMethod) == null) {
          LanguageServiceGrpc.getAnalyzeEntitySentimentMethod = getAnalyzeEntitySentimentMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest, com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.language.v1beta2.LanguageService", "AnalyzeEntitySentiment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LanguageServiceMethodDescriptorSupplier("AnalyzeEntitySentiment"))
                  .build();
          }
        }
     }
     return getAnalyzeEntitySentimentMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAnalyzeSyntaxMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest,
      com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse> METHOD_ANALYZE_SYNTAX = getAnalyzeSyntaxMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest,
      com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse> getAnalyzeSyntaxMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest,
      com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse> getAnalyzeSyntaxMethod() {
    return getAnalyzeSyntaxMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest,
      com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse> getAnalyzeSyntaxMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest, com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse> getAnalyzeSyntaxMethod;
    if ((getAnalyzeSyntaxMethod = LanguageServiceGrpc.getAnalyzeSyntaxMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAnalyzeSyntaxMethod = LanguageServiceGrpc.getAnalyzeSyntaxMethod) == null) {
          LanguageServiceGrpc.getAnalyzeSyntaxMethod = getAnalyzeSyntaxMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest, com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.language.v1beta2.LanguageService", "AnalyzeSyntax"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LanguageServiceMethodDescriptorSupplier("AnalyzeSyntax"))
                  .build();
          }
        }
     }
     return getAnalyzeSyntaxMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getClassifyTextMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.ClassifyTextRequest,
      com.google.cloud.language.v1beta2.ClassifyTextResponse> METHOD_CLASSIFY_TEXT = getClassifyTextMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.ClassifyTextRequest,
      com.google.cloud.language.v1beta2.ClassifyTextResponse> getClassifyTextMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.ClassifyTextRequest,
      com.google.cloud.language.v1beta2.ClassifyTextResponse> getClassifyTextMethod() {
    return getClassifyTextMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.ClassifyTextRequest,
      com.google.cloud.language.v1beta2.ClassifyTextResponse> getClassifyTextMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.ClassifyTextRequest, com.google.cloud.language.v1beta2.ClassifyTextResponse> getClassifyTextMethod;
    if ((getClassifyTextMethod = LanguageServiceGrpc.getClassifyTextMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getClassifyTextMethod = LanguageServiceGrpc.getClassifyTextMethod) == null) {
          LanguageServiceGrpc.getClassifyTextMethod = getClassifyTextMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.language.v1beta2.ClassifyTextRequest, com.google.cloud.language.v1beta2.ClassifyTextResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.language.v1beta2.LanguageService", "ClassifyText"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.language.v1beta2.ClassifyTextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.language.v1beta2.ClassifyTextResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LanguageServiceMethodDescriptorSupplier("ClassifyText"))
                  .build();
          }
        }
     }
     return getClassifyTextMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAnnotateTextMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnnotateTextRequest,
      com.google.cloud.language.v1beta2.AnnotateTextResponse> METHOD_ANNOTATE_TEXT = getAnnotateTextMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnnotateTextRequest,
      com.google.cloud.language.v1beta2.AnnotateTextResponse> getAnnotateTextMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnnotateTextRequest,
      com.google.cloud.language.v1beta2.AnnotateTextResponse> getAnnotateTextMethod() {
    return getAnnotateTextMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnnotateTextRequest,
      com.google.cloud.language.v1beta2.AnnotateTextResponse> getAnnotateTextMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.language.v1beta2.AnnotateTextRequest, com.google.cloud.language.v1beta2.AnnotateTextResponse> getAnnotateTextMethod;
    if ((getAnnotateTextMethod = LanguageServiceGrpc.getAnnotateTextMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAnnotateTextMethod = LanguageServiceGrpc.getAnnotateTextMethod) == null) {
          LanguageServiceGrpc.getAnnotateTextMethod = getAnnotateTextMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.language.v1beta2.AnnotateTextRequest, com.google.cloud.language.v1beta2.AnnotateTextResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.language.v1beta2.LanguageService", "AnnotateText"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.language.v1beta2.AnnotateTextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.language.v1beta2.AnnotateTextResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LanguageServiceMethodDescriptorSupplier("AnnotateText"))
                  .build();
          }
        }
     }
     return getAnnotateTextMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LanguageServiceStub newStub(io.grpc.Channel channel) {
    return new LanguageServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LanguageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LanguageServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LanguageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LanguageServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Provides text analysis operations such as sentiment analysis and entity
   * recognition.
   * </pre>
   */
  public static abstract class LanguageServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Analyzes the sentiment of the provided text.
     * </pre>
     */
    public void analyzeSentiment(com.google.cloud.language.v1beta2.AnalyzeSentimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeSentimentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAnalyzeSentimentMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Finds named entities (currently proper names and common nouns) in the text
     * along with entity types, salience, mentions for each entity, and
     * other properties.
     * </pre>
     */
    public void analyzeEntities(com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAnalyzeEntitiesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Finds entities, similar to [AnalyzeEntities][google.cloud.language.v1beta2.LanguageService.AnalyzeEntities] in the text and analyzes
     * sentiment associated with each entity and its mentions.
     * </pre>
     */
    public void analyzeEntitySentiment(com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAnalyzeEntitySentimentMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Analyzes the syntax of the text and provides sentence boundaries and
     * tokenization along with part of speech tags, dependency trees, and other
     * properties.
     * </pre>
     */
    public void analyzeSyntax(com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAnalyzeSyntaxMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Classifies a document into categories.
     * </pre>
     */
    public void classifyText(com.google.cloud.language.v1beta2.ClassifyTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.ClassifyTextResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getClassifyTextMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * A convenience method that provides all syntax, sentiment, entity, and
     * classification features in one call.
     * </pre>
     */
    public void annotateText(com.google.cloud.language.v1beta2.AnnotateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnnotateTextResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAnnotateTextMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAnalyzeSentimentMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.language.v1beta2.AnalyzeSentimentRequest,
                com.google.cloud.language.v1beta2.AnalyzeSentimentResponse>(
                  this, METHODID_ANALYZE_SENTIMENT)))
          .addMethod(
            getAnalyzeEntitiesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest,
                com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse>(
                  this, METHODID_ANALYZE_ENTITIES)))
          .addMethod(
            getAnalyzeEntitySentimentMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest,
                com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse>(
                  this, METHODID_ANALYZE_ENTITY_SENTIMENT)))
          .addMethod(
            getAnalyzeSyntaxMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest,
                com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse>(
                  this, METHODID_ANALYZE_SYNTAX)))
          .addMethod(
            getClassifyTextMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.language.v1beta2.ClassifyTextRequest,
                com.google.cloud.language.v1beta2.ClassifyTextResponse>(
                  this, METHODID_CLASSIFY_TEXT)))
          .addMethod(
            getAnnotateTextMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.language.v1beta2.AnnotateTextRequest,
                com.google.cloud.language.v1beta2.AnnotateTextResponse>(
                  this, METHODID_ANNOTATE_TEXT)))
          .build();
    }
  }

  /**
   * <pre>
   * Provides text analysis operations such as sentiment analysis and entity
   * recognition.
   * </pre>
   */
  public static final class LanguageServiceStub extends io.grpc.stub.AbstractStub<LanguageServiceStub> {
    private LanguageServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LanguageServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LanguageServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LanguageServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Analyzes the sentiment of the provided text.
     * </pre>
     */
    public void analyzeSentiment(com.google.cloud.language.v1beta2.AnalyzeSentimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeSentimentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnalyzeSentimentMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Finds named entities (currently proper names and common nouns) in the text
     * along with entity types, salience, mentions for each entity, and
     * other properties.
     * </pre>
     */
    public void analyzeEntities(com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnalyzeEntitiesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Finds entities, similar to [AnalyzeEntities][google.cloud.language.v1beta2.LanguageService.AnalyzeEntities] in the text and analyzes
     * sentiment associated with each entity and its mentions.
     * </pre>
     */
    public void analyzeEntitySentiment(com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnalyzeEntitySentimentMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Analyzes the syntax of the text and provides sentence boundaries and
     * tokenization along with part of speech tags, dependency trees, and other
     * properties.
     * </pre>
     */
    public void analyzeSyntax(com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnalyzeSyntaxMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Classifies a document into categories.
     * </pre>
     */
    public void classifyText(com.google.cloud.language.v1beta2.ClassifyTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.ClassifyTextResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getClassifyTextMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * A convenience method that provides all syntax, sentiment, entity, and
     * classification features in one call.
     * </pre>
     */
    public void annotateText(com.google.cloud.language.v1beta2.AnnotateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnnotateTextResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnnotateTextMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Provides text analysis operations such as sentiment analysis and entity
   * recognition.
   * </pre>
   */
  public static final class LanguageServiceBlockingStub extends io.grpc.stub.AbstractStub<LanguageServiceBlockingStub> {
    private LanguageServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LanguageServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LanguageServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LanguageServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Analyzes the sentiment of the provided text.
     * </pre>
     */
    public com.google.cloud.language.v1beta2.AnalyzeSentimentResponse analyzeSentiment(com.google.cloud.language.v1beta2.AnalyzeSentimentRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnalyzeSentimentMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Finds named entities (currently proper names and common nouns) in the text
     * along with entity types, salience, mentions for each entity, and
     * other properties.
     * </pre>
     */
    public com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse analyzeEntities(com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnalyzeEntitiesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Finds entities, similar to [AnalyzeEntities][google.cloud.language.v1beta2.LanguageService.AnalyzeEntities] in the text and analyzes
     * sentiment associated with each entity and its mentions.
     * </pre>
     */
    public com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse analyzeEntitySentiment(com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnalyzeEntitySentimentMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Analyzes the syntax of the text and provides sentence boundaries and
     * tokenization along with part of speech tags, dependency trees, and other
     * properties.
     * </pre>
     */
    public com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse analyzeSyntax(com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnalyzeSyntaxMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Classifies a document into categories.
     * </pre>
     */
    public com.google.cloud.language.v1beta2.ClassifyTextResponse classifyText(com.google.cloud.language.v1beta2.ClassifyTextRequest request) {
      return blockingUnaryCall(
          getChannel(), getClassifyTextMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * A convenience method that provides all syntax, sentiment, entity, and
     * classification features in one call.
     * </pre>
     */
    public com.google.cloud.language.v1beta2.AnnotateTextResponse annotateText(com.google.cloud.language.v1beta2.AnnotateTextRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnnotateTextMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Provides text analysis operations such as sentiment analysis and entity
   * recognition.
   * </pre>
   */
  public static final class LanguageServiceFutureStub extends io.grpc.stub.AbstractStub<LanguageServiceFutureStub> {
    private LanguageServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LanguageServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LanguageServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LanguageServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Analyzes the sentiment of the provided text.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.language.v1beta2.AnalyzeSentimentResponse> analyzeSentiment(
        com.google.cloud.language.v1beta2.AnalyzeSentimentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnalyzeSentimentMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Finds named entities (currently proper names and common nouns) in the text
     * along with entity types, salience, mentions for each entity, and
     * other properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse> analyzeEntities(
        com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnalyzeEntitiesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Finds entities, similar to [AnalyzeEntities][google.cloud.language.v1beta2.LanguageService.AnalyzeEntities] in the text and analyzes
     * sentiment associated with each entity and its mentions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse> analyzeEntitySentiment(
        com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnalyzeEntitySentimentMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Analyzes the syntax of the text and provides sentence boundaries and
     * tokenization along with part of speech tags, dependency trees, and other
     * properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse> analyzeSyntax(
        com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnalyzeSyntaxMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Classifies a document into categories.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.language.v1beta2.ClassifyTextResponse> classifyText(
        com.google.cloud.language.v1beta2.ClassifyTextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getClassifyTextMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * A convenience method that provides all syntax, sentiment, entity, and
     * classification features in one call.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.language.v1beta2.AnnotateTextResponse> annotateText(
        com.google.cloud.language.v1beta2.AnnotateTextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnnotateTextMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANALYZE_SENTIMENT = 0;
  private static final int METHODID_ANALYZE_ENTITIES = 1;
  private static final int METHODID_ANALYZE_ENTITY_SENTIMENT = 2;
  private static final int METHODID_ANALYZE_SYNTAX = 3;
  private static final int METHODID_CLASSIFY_TEXT = 4;
  private static final int METHODID_ANNOTATE_TEXT = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.analyzeSentiment((com.google.cloud.language.v1beta2.AnalyzeSentimentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeSentimentResponse>) responseObserver);
          break;
        case METHODID_ANALYZE_ENTITIES:
          serviceImpl.analyzeEntities((com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse>) responseObserver);
          break;
        case METHODID_ANALYZE_ENTITY_SENTIMENT:
          serviceImpl.analyzeEntitySentiment((com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse>) responseObserver);
          break;
        case METHODID_ANALYZE_SYNTAX:
          serviceImpl.analyzeSyntax((com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse>) responseObserver);
          break;
        case METHODID_CLASSIFY_TEXT:
          serviceImpl.classifyText((com.google.cloud.language.v1beta2.ClassifyTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.ClassifyTextResponse>) responseObserver);
          break;
        case METHODID_ANNOTATE_TEXT:
          serviceImpl.annotateText((com.google.cloud.language.v1beta2.AnnotateTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.language.v1beta2.AnnotateTextResponse>) responseObserver);
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

  private static abstract class LanguageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
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
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LanguageServiceFileDescriptorSupplier())
              .addMethod(getAnalyzeSentimentMethodHelper())
              .addMethod(getAnalyzeEntitiesMethodHelper())
              .addMethod(getAnalyzeEntitySentimentMethodHelper())
              .addMethod(getAnalyzeSyntaxMethodHelper())
              .addMethod(getClassifyTextMethodHelper())
              .addMethod(getAnnotateTextMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
