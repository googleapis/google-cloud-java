package com.google.cloud.translate.v3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Provides natural language translation operations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/translate/v3beta1/translation_service.proto")
public final class TranslationServiceGrpc {

  private TranslationServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.translation.v3beta1.TranslationService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTranslateTextMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.TranslateTextRequest,
          com.google.cloud.translate.v3beta1.TranslateTextResponse>
      METHOD_TRANSLATE_TEXT = getTranslateTextMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.TranslateTextRequest,
          com.google.cloud.translate.v3beta1.TranslateTextResponse>
      getTranslateTextMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.TranslateTextRequest,
          com.google.cloud.translate.v3beta1.TranslateTextResponse>
      getTranslateTextMethod() {
    return getTranslateTextMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.TranslateTextRequest,
          com.google.cloud.translate.v3beta1.TranslateTextResponse>
      getTranslateTextMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3beta1.TranslateTextRequest,
            com.google.cloud.translate.v3beta1.TranslateTextResponse>
        getTranslateTextMethod;
    if ((getTranslateTextMethod = TranslationServiceGrpc.getTranslateTextMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getTranslateTextMethod = TranslationServiceGrpc.getTranslateTextMethod) == null) {
          TranslationServiceGrpc.getTranslateTextMethod =
              getTranslateTextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3beta1.TranslateTextRequest,
                          com.google.cloud.translate.v3beta1.TranslateTextResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.translation.v3beta1.TranslationService",
                              "TranslateText"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3beta1.TranslateTextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3beta1.TranslateTextResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("TranslateText"))
                      .build();
        }
      }
    }
    return getTranslateTextMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDetectLanguageMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.DetectLanguageRequest,
          com.google.cloud.translate.v3beta1.DetectLanguageResponse>
      METHOD_DETECT_LANGUAGE = getDetectLanguageMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.DetectLanguageRequest,
          com.google.cloud.translate.v3beta1.DetectLanguageResponse>
      getDetectLanguageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.DetectLanguageRequest,
          com.google.cloud.translate.v3beta1.DetectLanguageResponse>
      getDetectLanguageMethod() {
    return getDetectLanguageMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.DetectLanguageRequest,
          com.google.cloud.translate.v3beta1.DetectLanguageResponse>
      getDetectLanguageMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3beta1.DetectLanguageRequest,
            com.google.cloud.translate.v3beta1.DetectLanguageResponse>
        getDetectLanguageMethod;
    if ((getDetectLanguageMethod = TranslationServiceGrpc.getDetectLanguageMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getDetectLanguageMethod = TranslationServiceGrpc.getDetectLanguageMethod) == null) {
          TranslationServiceGrpc.getDetectLanguageMethod =
              getDetectLanguageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3beta1.DetectLanguageRequest,
                          com.google.cloud.translate.v3beta1.DetectLanguageResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.translation.v3beta1.TranslationService",
                              "DetectLanguage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3beta1.DetectLanguageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3beta1.DetectLanguageResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("DetectLanguage"))
                      .build();
        }
      }
    }
    return getDetectLanguageMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetSupportedLanguagesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest,
          com.google.cloud.translate.v3beta1.SupportedLanguages>
      METHOD_GET_SUPPORTED_LANGUAGES = getGetSupportedLanguagesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest,
          com.google.cloud.translate.v3beta1.SupportedLanguages>
      getGetSupportedLanguagesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest,
          com.google.cloud.translate.v3beta1.SupportedLanguages>
      getGetSupportedLanguagesMethod() {
    return getGetSupportedLanguagesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest,
          com.google.cloud.translate.v3beta1.SupportedLanguages>
      getGetSupportedLanguagesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest,
            com.google.cloud.translate.v3beta1.SupportedLanguages>
        getGetSupportedLanguagesMethod;
    if ((getGetSupportedLanguagesMethod = TranslationServiceGrpc.getGetSupportedLanguagesMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getGetSupportedLanguagesMethod = TranslationServiceGrpc.getGetSupportedLanguagesMethod)
            == null) {
          TranslationServiceGrpc.getGetSupportedLanguagesMethod =
              getGetSupportedLanguagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest,
                          com.google.cloud.translate.v3beta1.SupportedLanguages>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.translation.v3beta1.TranslationService",
                              "GetSupportedLanguages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3beta1.SupportedLanguages
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("GetSupportedLanguages"))
                      .build();
        }
      }
    }
    return getGetSupportedLanguagesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchTranslateTextMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.BatchTranslateTextRequest,
          com.google.longrunning.Operation>
      METHOD_BATCH_TRANSLATE_TEXT = getBatchTranslateTextMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.BatchTranslateTextRequest,
          com.google.longrunning.Operation>
      getBatchTranslateTextMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.BatchTranslateTextRequest,
          com.google.longrunning.Operation>
      getBatchTranslateTextMethod() {
    return getBatchTranslateTextMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.BatchTranslateTextRequest,
          com.google.longrunning.Operation>
      getBatchTranslateTextMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3beta1.BatchTranslateTextRequest,
            com.google.longrunning.Operation>
        getBatchTranslateTextMethod;
    if ((getBatchTranslateTextMethod = TranslationServiceGrpc.getBatchTranslateTextMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getBatchTranslateTextMethod = TranslationServiceGrpc.getBatchTranslateTextMethod)
            == null) {
          TranslationServiceGrpc.getBatchTranslateTextMethod =
              getBatchTranslateTextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3beta1.BatchTranslateTextRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.translation.v3beta1.TranslationService",
                              "BatchTranslateText"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3beta1.BatchTranslateTextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("BatchTranslateText"))
                      .build();
        }
      }
    }
    return getBatchTranslateTextMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateGlossaryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.CreateGlossaryRequest,
          com.google.longrunning.Operation>
      METHOD_CREATE_GLOSSARY = getCreateGlossaryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.CreateGlossaryRequest,
          com.google.longrunning.Operation>
      getCreateGlossaryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.CreateGlossaryRequest,
          com.google.longrunning.Operation>
      getCreateGlossaryMethod() {
    return getCreateGlossaryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.CreateGlossaryRequest,
          com.google.longrunning.Operation>
      getCreateGlossaryMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3beta1.CreateGlossaryRequest,
            com.google.longrunning.Operation>
        getCreateGlossaryMethod;
    if ((getCreateGlossaryMethod = TranslationServiceGrpc.getCreateGlossaryMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getCreateGlossaryMethod = TranslationServiceGrpc.getCreateGlossaryMethod) == null) {
          TranslationServiceGrpc.getCreateGlossaryMethod =
              getCreateGlossaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3beta1.CreateGlossaryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.translation.v3beta1.TranslationService",
                              "CreateGlossary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3beta1.CreateGlossaryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("CreateGlossary"))
                      .build();
        }
      }
    }
    return getCreateGlossaryMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListGlossariesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.ListGlossariesRequest,
          com.google.cloud.translate.v3beta1.ListGlossariesResponse>
      METHOD_LIST_GLOSSARIES = getListGlossariesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.ListGlossariesRequest,
          com.google.cloud.translate.v3beta1.ListGlossariesResponse>
      getListGlossariesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.ListGlossariesRequest,
          com.google.cloud.translate.v3beta1.ListGlossariesResponse>
      getListGlossariesMethod() {
    return getListGlossariesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.ListGlossariesRequest,
          com.google.cloud.translate.v3beta1.ListGlossariesResponse>
      getListGlossariesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3beta1.ListGlossariesRequest,
            com.google.cloud.translate.v3beta1.ListGlossariesResponse>
        getListGlossariesMethod;
    if ((getListGlossariesMethod = TranslationServiceGrpc.getListGlossariesMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getListGlossariesMethod = TranslationServiceGrpc.getListGlossariesMethod) == null) {
          TranslationServiceGrpc.getListGlossariesMethod =
              getListGlossariesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3beta1.ListGlossariesRequest,
                          com.google.cloud.translate.v3beta1.ListGlossariesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.translation.v3beta1.TranslationService",
                              "ListGlossaries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3beta1.ListGlossariesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3beta1.ListGlossariesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("ListGlossaries"))
                      .build();
        }
      }
    }
    return getListGlossariesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetGlossaryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.GetGlossaryRequest,
          com.google.cloud.translate.v3beta1.Glossary>
      METHOD_GET_GLOSSARY = getGetGlossaryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.GetGlossaryRequest,
          com.google.cloud.translate.v3beta1.Glossary>
      getGetGlossaryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.GetGlossaryRequest,
          com.google.cloud.translate.v3beta1.Glossary>
      getGetGlossaryMethod() {
    return getGetGlossaryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.GetGlossaryRequest,
          com.google.cloud.translate.v3beta1.Glossary>
      getGetGlossaryMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3beta1.GetGlossaryRequest,
            com.google.cloud.translate.v3beta1.Glossary>
        getGetGlossaryMethod;
    if ((getGetGlossaryMethod = TranslationServiceGrpc.getGetGlossaryMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getGetGlossaryMethod = TranslationServiceGrpc.getGetGlossaryMethod) == null) {
          TranslationServiceGrpc.getGetGlossaryMethod =
              getGetGlossaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3beta1.GetGlossaryRequest,
                          com.google.cloud.translate.v3beta1.Glossary>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.translation.v3beta1.TranslationService", "GetGlossary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3beta1.GetGlossaryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3beta1.Glossary.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("GetGlossary"))
                      .build();
        }
      }
    }
    return getGetGlossaryMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteGlossaryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.DeleteGlossaryRequest,
          com.google.longrunning.Operation>
      METHOD_DELETE_GLOSSARY = getDeleteGlossaryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.DeleteGlossaryRequest,
          com.google.longrunning.Operation>
      getDeleteGlossaryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.DeleteGlossaryRequest,
          com.google.longrunning.Operation>
      getDeleteGlossaryMethod() {
    return getDeleteGlossaryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3beta1.DeleteGlossaryRequest,
          com.google.longrunning.Operation>
      getDeleteGlossaryMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3beta1.DeleteGlossaryRequest,
            com.google.longrunning.Operation>
        getDeleteGlossaryMethod;
    if ((getDeleteGlossaryMethod = TranslationServiceGrpc.getDeleteGlossaryMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getDeleteGlossaryMethod = TranslationServiceGrpc.getDeleteGlossaryMethod) == null) {
          TranslationServiceGrpc.getDeleteGlossaryMethod =
              getDeleteGlossaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3beta1.DeleteGlossaryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.translation.v3beta1.TranslationService",
                              "DeleteGlossary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3beta1.DeleteGlossaryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("DeleteGlossary"))
                      .build();
        }
      }
    }
    return getDeleteGlossaryMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TranslationServiceStub newStub(io.grpc.Channel channel) {
    return new TranslationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TranslationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new TranslationServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TranslationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new TranslationServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Provides natural language translation operations.
   * </pre>
   */
  public abstract static class TranslationServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Translates input text and returns translated text.
     * </pre>
     */
    public void translateText(
        com.google.cloud.translate.v3beta1.TranslateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3beta1.TranslateTextResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getTranslateTextMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Detects the language of text within a request.
     * </pre>
     */
    public void detectLanguage(
        com.google.cloud.translate.v3beta1.DetectLanguageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3beta1.DetectLanguageResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getDetectLanguageMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of supported languages for translation.
     * </pre>
     */
    public void getSupportedLanguages(
        com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3beta1.SupportedLanguages>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetSupportedLanguagesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Translates a large volume of text in asynchronous batch mode.
     * This function provides real-time output as the inputs are being processed.
     * If caller cancels a request, the partial results (for an input file, it's
     * all or nothing) may still be available on the specified output location.
     * This call returns immediately and you can
     * use google.longrunning.Operation.name to poll the status of the call.
     * </pre>
     */
    public void batchTranslateText(
        com.google.cloud.translate.v3beta1.BatchTranslateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchTranslateTextMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a glossary and returns the long-running operation. Returns
     * NOT_FOUND, if the project doesn't exist.
     * </pre>
     */
    public void createGlossary(
        com.google.cloud.translate.v3beta1.CreateGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateGlossaryMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't
     * exist.
     * </pre>
     */
    public void listGlossaries(
        com.google.cloud.translate.v3beta1.ListGlossariesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3beta1.ListGlossariesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListGlossariesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't
     * exist.
     * </pre>
     */
    public void getGlossary(
        com.google.cloud.translate.v3beta1.GetGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3beta1.Glossary> responseObserver) {
      asyncUnimplementedUnaryCall(getGetGlossaryMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a glossary, or cancels glossary construction
     * if the glossary isn't created yet.
     * Returns NOT_FOUND, if the glossary doesn't exist.
     * </pre>
     */
    public void deleteGlossary(
        com.google.cloud.translate.v3beta1.DeleteGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGlossaryMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getTranslateTextMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.translate.v3beta1.TranslateTextRequest,
                      com.google.cloud.translate.v3beta1.TranslateTextResponse>(
                      this, METHODID_TRANSLATE_TEXT)))
          .addMethod(
              getDetectLanguageMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.translate.v3beta1.DetectLanguageRequest,
                      com.google.cloud.translate.v3beta1.DetectLanguageResponse>(
                      this, METHODID_DETECT_LANGUAGE)))
          .addMethod(
              getGetSupportedLanguagesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest,
                      com.google.cloud.translate.v3beta1.SupportedLanguages>(
                      this, METHODID_GET_SUPPORTED_LANGUAGES)))
          .addMethod(
              getBatchTranslateTextMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.translate.v3beta1.BatchTranslateTextRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_TRANSLATE_TEXT)))
          .addMethod(
              getCreateGlossaryMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.translate.v3beta1.CreateGlossaryRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_GLOSSARY)))
          .addMethod(
              getListGlossariesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.translate.v3beta1.ListGlossariesRequest,
                      com.google.cloud.translate.v3beta1.ListGlossariesResponse>(
                      this, METHODID_LIST_GLOSSARIES)))
          .addMethod(
              getGetGlossaryMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.translate.v3beta1.GetGlossaryRequest,
                      com.google.cloud.translate.v3beta1.Glossary>(this, METHODID_GET_GLOSSARY)))
          .addMethod(
              getDeleteGlossaryMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.translate.v3beta1.DeleteGlossaryRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_GLOSSARY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Provides natural language translation operations.
   * </pre>
   */
  public static final class TranslationServiceStub
      extends io.grpc.stub.AbstractStub<TranslationServiceStub> {
    private TranslationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TranslationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TranslationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TranslationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Translates input text and returns translated text.
     * </pre>
     */
    public void translateText(
        com.google.cloud.translate.v3beta1.TranslateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3beta1.TranslateTextResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTranslateTextMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Detects the language of text within a request.
     * </pre>
     */
    public void detectLanguage(
        com.google.cloud.translate.v3beta1.DetectLanguageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3beta1.DetectLanguageResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDetectLanguageMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of supported languages for translation.
     * </pre>
     */
    public void getSupportedLanguages(
        com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3beta1.SupportedLanguages>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSupportedLanguagesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Translates a large volume of text in asynchronous batch mode.
     * This function provides real-time output as the inputs are being processed.
     * If caller cancels a request, the partial results (for an input file, it's
     * all or nothing) may still be available on the specified output location.
     * This call returns immediately and you can
     * use google.longrunning.Operation.name to poll the status of the call.
     * </pre>
     */
    public void batchTranslateText(
        com.google.cloud.translate.v3beta1.BatchTranslateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchTranslateTextMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a glossary and returns the long-running operation. Returns
     * NOT_FOUND, if the project doesn't exist.
     * </pre>
     */
    public void createGlossary(
        com.google.cloud.translate.v3beta1.CreateGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateGlossaryMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't
     * exist.
     * </pre>
     */
    public void listGlossaries(
        com.google.cloud.translate.v3beta1.ListGlossariesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3beta1.ListGlossariesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListGlossariesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't
     * exist.
     * </pre>
     */
    public void getGlossary(
        com.google.cloud.translate.v3beta1.GetGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3beta1.Glossary> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetGlossaryMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a glossary, or cancels glossary construction
     * if the glossary isn't created yet.
     * Returns NOT_FOUND, if the glossary doesn't exist.
     * </pre>
     */
    public void deleteGlossary(
        com.google.cloud.translate.v3beta1.DeleteGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGlossaryMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Provides natural language translation operations.
   * </pre>
   */
  public static final class TranslationServiceBlockingStub
      extends io.grpc.stub.AbstractStub<TranslationServiceBlockingStub> {
    private TranslationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TranslationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TranslationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TranslationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Translates input text and returns translated text.
     * </pre>
     */
    public com.google.cloud.translate.v3beta1.TranslateTextResponse translateText(
        com.google.cloud.translate.v3beta1.TranslateTextRequest request) {
      return blockingUnaryCall(
          getChannel(), getTranslateTextMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Detects the language of text within a request.
     * </pre>
     */
    public com.google.cloud.translate.v3beta1.DetectLanguageResponse detectLanguage(
        com.google.cloud.translate.v3beta1.DetectLanguageRequest request) {
      return blockingUnaryCall(
          getChannel(), getDetectLanguageMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of supported languages for translation.
     * </pre>
     */
    public com.google.cloud.translate.v3beta1.SupportedLanguages getSupportedLanguages(
        com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSupportedLanguagesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Translates a large volume of text in asynchronous batch mode.
     * This function provides real-time output as the inputs are being processed.
     * If caller cancels a request, the partial results (for an input file, it's
     * all or nothing) may still be available on the specified output location.
     * This call returns immediately and you can
     * use google.longrunning.Operation.name to poll the status of the call.
     * </pre>
     */
    public com.google.longrunning.Operation batchTranslateText(
        com.google.cloud.translate.v3beta1.BatchTranslateTextRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchTranslateTextMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a glossary and returns the long-running operation. Returns
     * NOT_FOUND, if the project doesn't exist.
     * </pre>
     */
    public com.google.longrunning.Operation createGlossary(
        com.google.cloud.translate.v3beta1.CreateGlossaryRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateGlossaryMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't
     * exist.
     * </pre>
     */
    public com.google.cloud.translate.v3beta1.ListGlossariesResponse listGlossaries(
        com.google.cloud.translate.v3beta1.ListGlossariesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListGlossariesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't
     * exist.
     * </pre>
     */
    public com.google.cloud.translate.v3beta1.Glossary getGlossary(
        com.google.cloud.translate.v3beta1.GetGlossaryRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetGlossaryMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a glossary, or cancels glossary construction
     * if the glossary isn't created yet.
     * Returns NOT_FOUND, if the glossary doesn't exist.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGlossary(
        com.google.cloud.translate.v3beta1.DeleteGlossaryRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGlossaryMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Provides natural language translation operations.
   * </pre>
   */
  public static final class TranslationServiceFutureStub
      extends io.grpc.stub.AbstractStub<TranslationServiceFutureStub> {
    private TranslationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TranslationServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TranslationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TranslationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Translates input text and returns translated text.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3beta1.TranslateTextResponse>
        translateText(com.google.cloud.translate.v3beta1.TranslateTextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTranslateTextMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Detects the language of text within a request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3beta1.DetectLanguageResponse>
        detectLanguage(com.google.cloud.translate.v3beta1.DetectLanguageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDetectLanguageMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of supported languages for translation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3beta1.SupportedLanguages>
        getSupportedLanguages(
            com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSupportedLanguagesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Translates a large volume of text in asynchronous batch mode.
     * This function provides real-time output as the inputs are being processed.
     * If caller cancels a request, the partial results (for an input file, it's
     * all or nothing) may still be available on the specified output location.
     * This call returns immediately and you can
     * use google.longrunning.Operation.name to poll the status of the call.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchTranslateText(com.google.cloud.translate.v3beta1.BatchTranslateTextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchTranslateTextMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a glossary and returns the long-running operation. Returns
     * NOT_FOUND, if the project doesn't exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGlossary(com.google.cloud.translate.v3beta1.CreateGlossaryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateGlossaryMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't
     * exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3beta1.ListGlossariesResponse>
        listGlossaries(com.google.cloud.translate.v3beta1.ListGlossariesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListGlossariesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't
     * exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3beta1.Glossary>
        getGlossary(com.google.cloud.translate.v3beta1.GetGlossaryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetGlossaryMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a glossary, or cancels glossary construction
     * if the glossary isn't created yet.
     * Returns NOT_FOUND, if the glossary doesn't exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGlossary(com.google.cloud.translate.v3beta1.DeleteGlossaryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGlossaryMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRANSLATE_TEXT = 0;
  private static final int METHODID_DETECT_LANGUAGE = 1;
  private static final int METHODID_GET_SUPPORTED_LANGUAGES = 2;
  private static final int METHODID_BATCH_TRANSLATE_TEXT = 3;
  private static final int METHODID_CREATE_GLOSSARY = 4;
  private static final int METHODID_LIST_GLOSSARIES = 5;
  private static final int METHODID_GET_GLOSSARY = 6;
  private static final int METHODID_DELETE_GLOSSARY = 7;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TranslationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TranslationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TRANSLATE_TEXT:
          serviceImpl.translateText(
              (com.google.cloud.translate.v3beta1.TranslateTextRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.translate.v3beta1.TranslateTextResponse>)
                  responseObserver);
          break;
        case METHODID_DETECT_LANGUAGE:
          serviceImpl.detectLanguage(
              (com.google.cloud.translate.v3beta1.DetectLanguageRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.translate.v3beta1.DetectLanguageResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SUPPORTED_LANGUAGES:
          serviceImpl.getSupportedLanguages(
              (com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3beta1.SupportedLanguages>)
                  responseObserver);
          break;
        case METHODID_BATCH_TRANSLATE_TEXT:
          serviceImpl.batchTranslateText(
              (com.google.cloud.translate.v3beta1.BatchTranslateTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_GLOSSARY:
          serviceImpl.createGlossary(
              (com.google.cloud.translate.v3beta1.CreateGlossaryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_GLOSSARIES:
          serviceImpl.listGlossaries(
              (com.google.cloud.translate.v3beta1.ListGlossariesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.translate.v3beta1.ListGlossariesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GLOSSARY:
          serviceImpl.getGlossary(
              (com.google.cloud.translate.v3beta1.GetGlossaryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3beta1.Glossary>)
                  responseObserver);
          break;
        case METHODID_DELETE_GLOSSARY:
          serviceImpl.deleteGlossary(
              (com.google.cloud.translate.v3beta1.DeleteGlossaryRequest) request,
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
        default:
          throw new AssertionError();
      }
    }
  }

  private abstract static class TranslationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TranslationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.translate.v3beta1.TranslationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TranslationService");
    }
  }

  private static final class TranslationServiceFileDescriptorSupplier
      extends TranslationServiceBaseDescriptorSupplier {
    TranslationServiceFileDescriptorSupplier() {}
  }

  private static final class TranslationServiceMethodDescriptorSupplier
      extends TranslationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TranslationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TranslationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TranslationServiceFileDescriptorSupplier())
                      .addMethod(getTranslateTextMethodHelper())
                      .addMethod(getDetectLanguageMethodHelper())
                      .addMethod(getGetSupportedLanguagesMethodHelper())
                      .addMethod(getBatchTranslateTextMethodHelper())
                      .addMethod(getCreateGlossaryMethodHelper())
                      .addMethod(getListGlossariesMethodHelper())
                      .addMethod(getGetGlossaryMethodHelper())
                      .addMethod(getDeleteGlossaryMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
