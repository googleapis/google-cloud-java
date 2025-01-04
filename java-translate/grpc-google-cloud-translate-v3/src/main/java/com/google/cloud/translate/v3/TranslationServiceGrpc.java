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
package com.google.cloud.translate.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Provides natural language translation operations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/translate/v3/translation_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TranslationServiceGrpc {

  private TranslationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.translation.v3.TranslationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.TranslateTextRequest,
          com.google.cloud.translate.v3.TranslateTextResponse>
      getTranslateTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TranslateText",
      requestType = com.google.cloud.translate.v3.TranslateTextRequest.class,
      responseType = com.google.cloud.translate.v3.TranslateTextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.TranslateTextRequest,
          com.google.cloud.translate.v3.TranslateTextResponse>
      getTranslateTextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.TranslateTextRequest,
            com.google.cloud.translate.v3.TranslateTextResponse>
        getTranslateTextMethod;
    if ((getTranslateTextMethod = TranslationServiceGrpc.getTranslateTextMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getTranslateTextMethod = TranslationServiceGrpc.getTranslateTextMethod) == null) {
          TranslationServiceGrpc.getTranslateTextMethod =
              getTranslateTextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.TranslateTextRequest,
                          com.google.cloud.translate.v3.TranslateTextResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TranslateText"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.TranslateTextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.TranslateTextResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("TranslateText"))
                      .build();
        }
      }
    }
    return getTranslateTextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.RomanizeTextRequest,
          com.google.cloud.translate.v3.RomanizeTextResponse>
      getRomanizeTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RomanizeText",
      requestType = com.google.cloud.translate.v3.RomanizeTextRequest.class,
      responseType = com.google.cloud.translate.v3.RomanizeTextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.RomanizeTextRequest,
          com.google.cloud.translate.v3.RomanizeTextResponse>
      getRomanizeTextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.RomanizeTextRequest,
            com.google.cloud.translate.v3.RomanizeTextResponse>
        getRomanizeTextMethod;
    if ((getRomanizeTextMethod = TranslationServiceGrpc.getRomanizeTextMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getRomanizeTextMethod = TranslationServiceGrpc.getRomanizeTextMethod) == null) {
          TranslationServiceGrpc.getRomanizeTextMethod =
              getRomanizeTextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.RomanizeTextRequest,
                          com.google.cloud.translate.v3.RomanizeTextResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RomanizeText"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.RomanizeTextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.RomanizeTextResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("RomanizeText"))
                      .build();
        }
      }
    }
    return getRomanizeTextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DetectLanguageRequest,
          com.google.cloud.translate.v3.DetectLanguageResponse>
      getDetectLanguageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DetectLanguage",
      requestType = com.google.cloud.translate.v3.DetectLanguageRequest.class,
      responseType = com.google.cloud.translate.v3.DetectLanguageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DetectLanguageRequest,
          com.google.cloud.translate.v3.DetectLanguageResponse>
      getDetectLanguageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.DetectLanguageRequest,
            com.google.cloud.translate.v3.DetectLanguageResponse>
        getDetectLanguageMethod;
    if ((getDetectLanguageMethod = TranslationServiceGrpc.getDetectLanguageMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getDetectLanguageMethod = TranslationServiceGrpc.getDetectLanguageMethod) == null) {
          TranslationServiceGrpc.getDetectLanguageMethod =
              getDetectLanguageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.DetectLanguageRequest,
                          com.google.cloud.translate.v3.DetectLanguageResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DetectLanguage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.DetectLanguageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.DetectLanguageResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("DetectLanguage"))
                      .build();
        }
      }
    }
    return getDetectLanguageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetSupportedLanguagesRequest,
          com.google.cloud.translate.v3.SupportedLanguages>
      getGetSupportedLanguagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSupportedLanguages",
      requestType = com.google.cloud.translate.v3.GetSupportedLanguagesRequest.class,
      responseType = com.google.cloud.translate.v3.SupportedLanguages.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetSupportedLanguagesRequest,
          com.google.cloud.translate.v3.SupportedLanguages>
      getGetSupportedLanguagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.GetSupportedLanguagesRequest,
            com.google.cloud.translate.v3.SupportedLanguages>
        getGetSupportedLanguagesMethod;
    if ((getGetSupportedLanguagesMethod = TranslationServiceGrpc.getGetSupportedLanguagesMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getGetSupportedLanguagesMethod = TranslationServiceGrpc.getGetSupportedLanguagesMethod)
            == null) {
          TranslationServiceGrpc.getGetSupportedLanguagesMethod =
              getGetSupportedLanguagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.GetSupportedLanguagesRequest,
                          com.google.cloud.translate.v3.SupportedLanguages>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetSupportedLanguages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.GetSupportedLanguagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.SupportedLanguages
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("GetSupportedLanguages"))
                      .build();
        }
      }
    }
    return getGetSupportedLanguagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.TranslateDocumentRequest,
          com.google.cloud.translate.v3.TranslateDocumentResponse>
      getTranslateDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TranslateDocument",
      requestType = com.google.cloud.translate.v3.TranslateDocumentRequest.class,
      responseType = com.google.cloud.translate.v3.TranslateDocumentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.TranslateDocumentRequest,
          com.google.cloud.translate.v3.TranslateDocumentResponse>
      getTranslateDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.TranslateDocumentRequest,
            com.google.cloud.translate.v3.TranslateDocumentResponse>
        getTranslateDocumentMethod;
    if ((getTranslateDocumentMethod = TranslationServiceGrpc.getTranslateDocumentMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getTranslateDocumentMethod = TranslationServiceGrpc.getTranslateDocumentMethod)
            == null) {
          TranslationServiceGrpc.getTranslateDocumentMethod =
              getTranslateDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.TranslateDocumentRequest,
                          com.google.cloud.translate.v3.TranslateDocumentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TranslateDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.TranslateDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.TranslateDocumentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("TranslateDocument"))
                      .build();
        }
      }
    }
    return getTranslateDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.BatchTranslateTextRequest, com.google.longrunning.Operation>
      getBatchTranslateTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchTranslateText",
      requestType = com.google.cloud.translate.v3.BatchTranslateTextRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.BatchTranslateTextRequest, com.google.longrunning.Operation>
      getBatchTranslateTextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.BatchTranslateTextRequest,
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
                      .<com.google.cloud.translate.v3.BatchTranslateTextRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchTranslateText"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.BatchTranslateTextRequest
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.BatchTranslateDocumentRequest,
          com.google.longrunning.Operation>
      getBatchTranslateDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchTranslateDocument",
      requestType = com.google.cloud.translate.v3.BatchTranslateDocumentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.BatchTranslateDocumentRequest,
          com.google.longrunning.Operation>
      getBatchTranslateDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.BatchTranslateDocumentRequest,
            com.google.longrunning.Operation>
        getBatchTranslateDocumentMethod;
    if ((getBatchTranslateDocumentMethod = TranslationServiceGrpc.getBatchTranslateDocumentMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getBatchTranslateDocumentMethod =
                TranslationServiceGrpc.getBatchTranslateDocumentMethod)
            == null) {
          TranslationServiceGrpc.getBatchTranslateDocumentMethod =
              getBatchTranslateDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.BatchTranslateDocumentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchTranslateDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.BatchTranslateDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("BatchTranslateDocument"))
                      .build();
        }
      }
    }
    return getBatchTranslateDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.CreateGlossaryRequest, com.google.longrunning.Operation>
      getCreateGlossaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGlossary",
      requestType = com.google.cloud.translate.v3.CreateGlossaryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.CreateGlossaryRequest, com.google.longrunning.Operation>
      getCreateGlossaryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.CreateGlossaryRequest, com.google.longrunning.Operation>
        getCreateGlossaryMethod;
    if ((getCreateGlossaryMethod = TranslationServiceGrpc.getCreateGlossaryMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getCreateGlossaryMethod = TranslationServiceGrpc.getCreateGlossaryMethod) == null) {
          TranslationServiceGrpc.getCreateGlossaryMethod =
              getCreateGlossaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.CreateGlossaryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGlossary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.CreateGlossaryRequest
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.UpdateGlossaryRequest, com.google.longrunning.Operation>
      getUpdateGlossaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGlossary",
      requestType = com.google.cloud.translate.v3.UpdateGlossaryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.UpdateGlossaryRequest, com.google.longrunning.Operation>
      getUpdateGlossaryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.UpdateGlossaryRequest, com.google.longrunning.Operation>
        getUpdateGlossaryMethod;
    if ((getUpdateGlossaryMethod = TranslationServiceGrpc.getUpdateGlossaryMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getUpdateGlossaryMethod = TranslationServiceGrpc.getUpdateGlossaryMethod) == null) {
          TranslationServiceGrpc.getUpdateGlossaryMethod =
              getUpdateGlossaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.UpdateGlossaryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGlossary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.UpdateGlossaryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("UpdateGlossary"))
                      .build();
        }
      }
    }
    return getUpdateGlossaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListGlossariesRequest,
          com.google.cloud.translate.v3.ListGlossariesResponse>
      getListGlossariesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGlossaries",
      requestType = com.google.cloud.translate.v3.ListGlossariesRequest.class,
      responseType = com.google.cloud.translate.v3.ListGlossariesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListGlossariesRequest,
          com.google.cloud.translate.v3.ListGlossariesResponse>
      getListGlossariesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.ListGlossariesRequest,
            com.google.cloud.translate.v3.ListGlossariesResponse>
        getListGlossariesMethod;
    if ((getListGlossariesMethod = TranslationServiceGrpc.getListGlossariesMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getListGlossariesMethod = TranslationServiceGrpc.getListGlossariesMethod) == null) {
          TranslationServiceGrpc.getListGlossariesMethod =
              getListGlossariesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.ListGlossariesRequest,
                          com.google.cloud.translate.v3.ListGlossariesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGlossaries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListGlossariesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListGlossariesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("ListGlossaries"))
                      .build();
        }
      }
    }
    return getListGlossariesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetGlossaryRequest, com.google.cloud.translate.v3.Glossary>
      getGetGlossaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGlossary",
      requestType = com.google.cloud.translate.v3.GetGlossaryRequest.class,
      responseType = com.google.cloud.translate.v3.Glossary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetGlossaryRequest, com.google.cloud.translate.v3.Glossary>
      getGetGlossaryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.GetGlossaryRequest,
            com.google.cloud.translate.v3.Glossary>
        getGetGlossaryMethod;
    if ((getGetGlossaryMethod = TranslationServiceGrpc.getGetGlossaryMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getGetGlossaryMethod = TranslationServiceGrpc.getGetGlossaryMethod) == null) {
          TranslationServiceGrpc.getGetGlossaryMethod =
              getGetGlossaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.GetGlossaryRequest,
                          com.google.cloud.translate.v3.Glossary>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGlossary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.GetGlossaryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.Glossary.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("GetGlossary"))
                      .build();
        }
      }
    }
    return getGetGlossaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DeleteGlossaryRequest, com.google.longrunning.Operation>
      getDeleteGlossaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGlossary",
      requestType = com.google.cloud.translate.v3.DeleteGlossaryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DeleteGlossaryRequest, com.google.longrunning.Operation>
      getDeleteGlossaryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.DeleteGlossaryRequest, com.google.longrunning.Operation>
        getDeleteGlossaryMethod;
    if ((getDeleteGlossaryMethod = TranslationServiceGrpc.getDeleteGlossaryMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getDeleteGlossaryMethod = TranslationServiceGrpc.getDeleteGlossaryMethod) == null) {
          TranslationServiceGrpc.getDeleteGlossaryMethod =
              getDeleteGlossaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.DeleteGlossaryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGlossary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.DeleteGlossaryRequest
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetGlossaryEntryRequest,
          com.google.cloud.translate.v3.GlossaryEntry>
      getGetGlossaryEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGlossaryEntry",
      requestType = com.google.cloud.translate.v3.GetGlossaryEntryRequest.class,
      responseType = com.google.cloud.translate.v3.GlossaryEntry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetGlossaryEntryRequest,
          com.google.cloud.translate.v3.GlossaryEntry>
      getGetGlossaryEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.GetGlossaryEntryRequest,
            com.google.cloud.translate.v3.GlossaryEntry>
        getGetGlossaryEntryMethod;
    if ((getGetGlossaryEntryMethod = TranslationServiceGrpc.getGetGlossaryEntryMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getGetGlossaryEntryMethod = TranslationServiceGrpc.getGetGlossaryEntryMethod)
            == null) {
          TranslationServiceGrpc.getGetGlossaryEntryMethod =
              getGetGlossaryEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.GetGlossaryEntryRequest,
                          com.google.cloud.translate.v3.GlossaryEntry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGlossaryEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.GetGlossaryEntryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.GlossaryEntry.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("GetGlossaryEntry"))
                      .build();
        }
      }
    }
    return getGetGlossaryEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListGlossaryEntriesRequest,
          com.google.cloud.translate.v3.ListGlossaryEntriesResponse>
      getListGlossaryEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGlossaryEntries",
      requestType = com.google.cloud.translate.v3.ListGlossaryEntriesRequest.class,
      responseType = com.google.cloud.translate.v3.ListGlossaryEntriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListGlossaryEntriesRequest,
          com.google.cloud.translate.v3.ListGlossaryEntriesResponse>
      getListGlossaryEntriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.ListGlossaryEntriesRequest,
            com.google.cloud.translate.v3.ListGlossaryEntriesResponse>
        getListGlossaryEntriesMethod;
    if ((getListGlossaryEntriesMethod = TranslationServiceGrpc.getListGlossaryEntriesMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getListGlossaryEntriesMethod = TranslationServiceGrpc.getListGlossaryEntriesMethod)
            == null) {
          TranslationServiceGrpc.getListGlossaryEntriesMethod =
              getListGlossaryEntriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.ListGlossaryEntriesRequest,
                          com.google.cloud.translate.v3.ListGlossaryEntriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListGlossaryEntries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListGlossaryEntriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListGlossaryEntriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("ListGlossaryEntries"))
                      .build();
        }
      }
    }
    return getListGlossaryEntriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.CreateGlossaryEntryRequest,
          com.google.cloud.translate.v3.GlossaryEntry>
      getCreateGlossaryEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGlossaryEntry",
      requestType = com.google.cloud.translate.v3.CreateGlossaryEntryRequest.class,
      responseType = com.google.cloud.translate.v3.GlossaryEntry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.CreateGlossaryEntryRequest,
          com.google.cloud.translate.v3.GlossaryEntry>
      getCreateGlossaryEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.CreateGlossaryEntryRequest,
            com.google.cloud.translate.v3.GlossaryEntry>
        getCreateGlossaryEntryMethod;
    if ((getCreateGlossaryEntryMethod = TranslationServiceGrpc.getCreateGlossaryEntryMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getCreateGlossaryEntryMethod = TranslationServiceGrpc.getCreateGlossaryEntryMethod)
            == null) {
          TranslationServiceGrpc.getCreateGlossaryEntryMethod =
              getCreateGlossaryEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.CreateGlossaryEntryRequest,
                          com.google.cloud.translate.v3.GlossaryEntry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateGlossaryEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.CreateGlossaryEntryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.GlossaryEntry.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("CreateGlossaryEntry"))
                      .build();
        }
      }
    }
    return getCreateGlossaryEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.UpdateGlossaryEntryRequest,
          com.google.cloud.translate.v3.GlossaryEntry>
      getUpdateGlossaryEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGlossaryEntry",
      requestType = com.google.cloud.translate.v3.UpdateGlossaryEntryRequest.class,
      responseType = com.google.cloud.translate.v3.GlossaryEntry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.UpdateGlossaryEntryRequest,
          com.google.cloud.translate.v3.GlossaryEntry>
      getUpdateGlossaryEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.UpdateGlossaryEntryRequest,
            com.google.cloud.translate.v3.GlossaryEntry>
        getUpdateGlossaryEntryMethod;
    if ((getUpdateGlossaryEntryMethod = TranslationServiceGrpc.getUpdateGlossaryEntryMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getUpdateGlossaryEntryMethod = TranslationServiceGrpc.getUpdateGlossaryEntryMethod)
            == null) {
          TranslationServiceGrpc.getUpdateGlossaryEntryMethod =
              getUpdateGlossaryEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.UpdateGlossaryEntryRequest,
                          com.google.cloud.translate.v3.GlossaryEntry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateGlossaryEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.UpdateGlossaryEntryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.GlossaryEntry.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("UpdateGlossaryEntry"))
                      .build();
        }
      }
    }
    return getUpdateGlossaryEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DeleteGlossaryEntryRequest, com.google.protobuf.Empty>
      getDeleteGlossaryEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGlossaryEntry",
      requestType = com.google.cloud.translate.v3.DeleteGlossaryEntryRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DeleteGlossaryEntryRequest, com.google.protobuf.Empty>
      getDeleteGlossaryEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.DeleteGlossaryEntryRequest, com.google.protobuf.Empty>
        getDeleteGlossaryEntryMethod;
    if ((getDeleteGlossaryEntryMethod = TranslationServiceGrpc.getDeleteGlossaryEntryMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getDeleteGlossaryEntryMethod = TranslationServiceGrpc.getDeleteGlossaryEntryMethod)
            == null) {
          TranslationServiceGrpc.getDeleteGlossaryEntryMethod =
              getDeleteGlossaryEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.DeleteGlossaryEntryRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteGlossaryEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.DeleteGlossaryEntryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("DeleteGlossaryEntry"))
                      .build();
        }
      }
    }
    return getDeleteGlossaryEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.CreateDatasetRequest, com.google.longrunning.Operation>
      getCreateDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataset",
      requestType = com.google.cloud.translate.v3.CreateDatasetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.CreateDatasetRequest, com.google.longrunning.Operation>
      getCreateDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.CreateDatasetRequest, com.google.longrunning.Operation>
        getCreateDatasetMethod;
    if ((getCreateDatasetMethod = TranslationServiceGrpc.getCreateDatasetMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getCreateDatasetMethod = TranslationServiceGrpc.getCreateDatasetMethod) == null) {
          TranslationServiceGrpc.getCreateDatasetMethod =
              getCreateDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.CreateDatasetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.CreateDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("CreateDataset"))
                      .build();
        }
      }
    }
    return getCreateDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetDatasetRequest, com.google.cloud.translate.v3.Dataset>
      getGetDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataset",
      requestType = com.google.cloud.translate.v3.GetDatasetRequest.class,
      responseType = com.google.cloud.translate.v3.Dataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetDatasetRequest, com.google.cloud.translate.v3.Dataset>
      getGetDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.GetDatasetRequest, com.google.cloud.translate.v3.Dataset>
        getGetDatasetMethod;
    if ((getGetDatasetMethod = TranslationServiceGrpc.getGetDatasetMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getGetDatasetMethod = TranslationServiceGrpc.getGetDatasetMethod) == null) {
          TranslationServiceGrpc.getGetDatasetMethod =
              getGetDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.GetDatasetRequest,
                          com.google.cloud.translate.v3.Dataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.GetDatasetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.Dataset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("GetDataset"))
                      .build();
        }
      }
    }
    return getGetDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListDatasetsRequest,
          com.google.cloud.translate.v3.ListDatasetsResponse>
      getListDatasetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatasets",
      requestType = com.google.cloud.translate.v3.ListDatasetsRequest.class,
      responseType = com.google.cloud.translate.v3.ListDatasetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListDatasetsRequest,
          com.google.cloud.translate.v3.ListDatasetsResponse>
      getListDatasetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.ListDatasetsRequest,
            com.google.cloud.translate.v3.ListDatasetsResponse>
        getListDatasetsMethod;
    if ((getListDatasetsMethod = TranslationServiceGrpc.getListDatasetsMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getListDatasetsMethod = TranslationServiceGrpc.getListDatasetsMethod) == null) {
          TranslationServiceGrpc.getListDatasetsMethod =
              getListDatasetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.ListDatasetsRequest,
                          com.google.cloud.translate.v3.ListDatasetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatasets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListDatasetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListDatasetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("ListDatasets"))
                      .build();
        }
      }
    }
    return getListDatasetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DeleteDatasetRequest, com.google.longrunning.Operation>
      getDeleteDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataset",
      requestType = com.google.cloud.translate.v3.DeleteDatasetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DeleteDatasetRequest, com.google.longrunning.Operation>
      getDeleteDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.DeleteDatasetRequest, com.google.longrunning.Operation>
        getDeleteDatasetMethod;
    if ((getDeleteDatasetMethod = TranslationServiceGrpc.getDeleteDatasetMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getDeleteDatasetMethod = TranslationServiceGrpc.getDeleteDatasetMethod) == null) {
          TranslationServiceGrpc.getDeleteDatasetMethod =
              getDeleteDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.DeleteDatasetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.DeleteDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("DeleteDataset"))
                      .build();
        }
      }
    }
    return getDeleteDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.CreateAdaptiveMtDatasetRequest,
          com.google.cloud.translate.v3.AdaptiveMtDataset>
      getCreateAdaptiveMtDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAdaptiveMtDataset",
      requestType = com.google.cloud.translate.v3.CreateAdaptiveMtDatasetRequest.class,
      responseType = com.google.cloud.translate.v3.AdaptiveMtDataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.CreateAdaptiveMtDatasetRequest,
          com.google.cloud.translate.v3.AdaptiveMtDataset>
      getCreateAdaptiveMtDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.CreateAdaptiveMtDatasetRequest,
            com.google.cloud.translate.v3.AdaptiveMtDataset>
        getCreateAdaptiveMtDatasetMethod;
    if ((getCreateAdaptiveMtDatasetMethod = TranslationServiceGrpc.getCreateAdaptiveMtDatasetMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getCreateAdaptiveMtDatasetMethod =
                TranslationServiceGrpc.getCreateAdaptiveMtDatasetMethod)
            == null) {
          TranslationServiceGrpc.getCreateAdaptiveMtDatasetMethod =
              getCreateAdaptiveMtDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.CreateAdaptiveMtDatasetRequest,
                          com.google.cloud.translate.v3.AdaptiveMtDataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAdaptiveMtDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.CreateAdaptiveMtDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.AdaptiveMtDataset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("CreateAdaptiveMtDataset"))
                      .build();
        }
      }
    }
    return getCreateAdaptiveMtDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest, com.google.protobuf.Empty>
      getDeleteAdaptiveMtDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAdaptiveMtDataset",
      requestType = com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest, com.google.protobuf.Empty>
      getDeleteAdaptiveMtDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest, com.google.protobuf.Empty>
        getDeleteAdaptiveMtDatasetMethod;
    if ((getDeleteAdaptiveMtDatasetMethod = TranslationServiceGrpc.getDeleteAdaptiveMtDatasetMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getDeleteAdaptiveMtDatasetMethod =
                TranslationServiceGrpc.getDeleteAdaptiveMtDatasetMethod)
            == null) {
          TranslationServiceGrpc.getDeleteAdaptiveMtDatasetMethod =
              getDeleteAdaptiveMtDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAdaptiveMtDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("DeleteAdaptiveMtDataset"))
                      .build();
        }
      }
    }
    return getDeleteAdaptiveMtDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest,
          com.google.cloud.translate.v3.AdaptiveMtDataset>
      getGetAdaptiveMtDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAdaptiveMtDataset",
      requestType = com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest.class,
      responseType = com.google.cloud.translate.v3.AdaptiveMtDataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest,
          com.google.cloud.translate.v3.AdaptiveMtDataset>
      getGetAdaptiveMtDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest,
            com.google.cloud.translate.v3.AdaptiveMtDataset>
        getGetAdaptiveMtDatasetMethod;
    if ((getGetAdaptiveMtDatasetMethod = TranslationServiceGrpc.getGetAdaptiveMtDatasetMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getGetAdaptiveMtDatasetMethod = TranslationServiceGrpc.getGetAdaptiveMtDatasetMethod)
            == null) {
          TranslationServiceGrpc.getGetAdaptiveMtDatasetMethod =
              getGetAdaptiveMtDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest,
                          com.google.cloud.translate.v3.AdaptiveMtDataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAdaptiveMtDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.AdaptiveMtDataset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("GetAdaptiveMtDataset"))
                      .build();
        }
      }
    }
    return getGetAdaptiveMtDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest,
          com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse>
      getListAdaptiveMtDatasetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAdaptiveMtDatasets",
      requestType = com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest.class,
      responseType = com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest,
          com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse>
      getListAdaptiveMtDatasetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest,
            com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse>
        getListAdaptiveMtDatasetsMethod;
    if ((getListAdaptiveMtDatasetsMethod = TranslationServiceGrpc.getListAdaptiveMtDatasetsMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getListAdaptiveMtDatasetsMethod =
                TranslationServiceGrpc.getListAdaptiveMtDatasetsMethod)
            == null) {
          TranslationServiceGrpc.getListAdaptiveMtDatasetsMethod =
              getListAdaptiveMtDatasetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest,
                          com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAdaptiveMtDatasets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("ListAdaptiveMtDatasets"))
                      .build();
        }
      }
    }
    return getListAdaptiveMtDatasetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.AdaptiveMtTranslateRequest,
          com.google.cloud.translate.v3.AdaptiveMtTranslateResponse>
      getAdaptiveMtTranslateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AdaptiveMtTranslate",
      requestType = com.google.cloud.translate.v3.AdaptiveMtTranslateRequest.class,
      responseType = com.google.cloud.translate.v3.AdaptiveMtTranslateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.AdaptiveMtTranslateRequest,
          com.google.cloud.translate.v3.AdaptiveMtTranslateResponse>
      getAdaptiveMtTranslateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.AdaptiveMtTranslateRequest,
            com.google.cloud.translate.v3.AdaptiveMtTranslateResponse>
        getAdaptiveMtTranslateMethod;
    if ((getAdaptiveMtTranslateMethod = TranslationServiceGrpc.getAdaptiveMtTranslateMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getAdaptiveMtTranslateMethod = TranslationServiceGrpc.getAdaptiveMtTranslateMethod)
            == null) {
          TranslationServiceGrpc.getAdaptiveMtTranslateMethod =
              getAdaptiveMtTranslateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.AdaptiveMtTranslateRequest,
                          com.google.cloud.translate.v3.AdaptiveMtTranslateResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AdaptiveMtTranslate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.AdaptiveMtTranslateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.AdaptiveMtTranslateResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("AdaptiveMtTranslate"))
                      .build();
        }
      }
    }
    return getAdaptiveMtTranslateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetAdaptiveMtFileRequest,
          com.google.cloud.translate.v3.AdaptiveMtFile>
      getGetAdaptiveMtFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAdaptiveMtFile",
      requestType = com.google.cloud.translate.v3.GetAdaptiveMtFileRequest.class,
      responseType = com.google.cloud.translate.v3.AdaptiveMtFile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetAdaptiveMtFileRequest,
          com.google.cloud.translate.v3.AdaptiveMtFile>
      getGetAdaptiveMtFileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.GetAdaptiveMtFileRequest,
            com.google.cloud.translate.v3.AdaptiveMtFile>
        getGetAdaptiveMtFileMethod;
    if ((getGetAdaptiveMtFileMethod = TranslationServiceGrpc.getGetAdaptiveMtFileMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getGetAdaptiveMtFileMethod = TranslationServiceGrpc.getGetAdaptiveMtFileMethod)
            == null) {
          TranslationServiceGrpc.getGetAdaptiveMtFileMethod =
              getGetAdaptiveMtFileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.GetAdaptiveMtFileRequest,
                          com.google.cloud.translate.v3.AdaptiveMtFile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAdaptiveMtFile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.GetAdaptiveMtFileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.AdaptiveMtFile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("GetAdaptiveMtFile"))
                      .build();
        }
      }
    }
    return getGetAdaptiveMtFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest, com.google.protobuf.Empty>
      getDeleteAdaptiveMtFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAdaptiveMtFile",
      requestType = com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest, com.google.protobuf.Empty>
      getDeleteAdaptiveMtFileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest, com.google.protobuf.Empty>
        getDeleteAdaptiveMtFileMethod;
    if ((getDeleteAdaptiveMtFileMethod = TranslationServiceGrpc.getDeleteAdaptiveMtFileMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getDeleteAdaptiveMtFileMethod = TranslationServiceGrpc.getDeleteAdaptiveMtFileMethod)
            == null) {
          TranslationServiceGrpc.getDeleteAdaptiveMtFileMethod =
              getDeleteAdaptiveMtFileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAdaptiveMtFile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("DeleteAdaptiveMtFile"))
                      .build();
        }
      }
    }
    return getDeleteAdaptiveMtFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest,
          com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse>
      getImportAdaptiveMtFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportAdaptiveMtFile",
      requestType = com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest.class,
      responseType = com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest,
          com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse>
      getImportAdaptiveMtFileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest,
            com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse>
        getImportAdaptiveMtFileMethod;
    if ((getImportAdaptiveMtFileMethod = TranslationServiceGrpc.getImportAdaptiveMtFileMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getImportAdaptiveMtFileMethod = TranslationServiceGrpc.getImportAdaptiveMtFileMethod)
            == null) {
          TranslationServiceGrpc.getImportAdaptiveMtFileMethod =
              getImportAdaptiveMtFileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest,
                          com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportAdaptiveMtFile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("ImportAdaptiveMtFile"))
                      .build();
        }
      }
    }
    return getImportAdaptiveMtFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest,
          com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse>
      getListAdaptiveMtFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAdaptiveMtFiles",
      requestType = com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest.class,
      responseType = com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest,
          com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse>
      getListAdaptiveMtFilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest,
            com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse>
        getListAdaptiveMtFilesMethod;
    if ((getListAdaptiveMtFilesMethod = TranslationServiceGrpc.getListAdaptiveMtFilesMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getListAdaptiveMtFilesMethod = TranslationServiceGrpc.getListAdaptiveMtFilesMethod)
            == null) {
          TranslationServiceGrpc.getListAdaptiveMtFilesMethod =
              getListAdaptiveMtFilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest,
                          com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAdaptiveMtFiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("ListAdaptiveMtFiles"))
                      .build();
        }
      }
    }
    return getListAdaptiveMtFilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest,
          com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse>
      getListAdaptiveMtSentencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAdaptiveMtSentences",
      requestType = com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest.class,
      responseType = com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest,
          com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse>
      getListAdaptiveMtSentencesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest,
            com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse>
        getListAdaptiveMtSentencesMethod;
    if ((getListAdaptiveMtSentencesMethod = TranslationServiceGrpc.getListAdaptiveMtSentencesMethod)
        == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getListAdaptiveMtSentencesMethod =
                TranslationServiceGrpc.getListAdaptiveMtSentencesMethod)
            == null) {
          TranslationServiceGrpc.getListAdaptiveMtSentencesMethod =
              getListAdaptiveMtSentencesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest,
                          com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAdaptiveMtSentences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("ListAdaptiveMtSentences"))
                      .build();
        }
      }
    }
    return getListAdaptiveMtSentencesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ImportDataRequest, com.google.longrunning.Operation>
      getImportDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportData",
      requestType = com.google.cloud.translate.v3.ImportDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ImportDataRequest, com.google.longrunning.Operation>
      getImportDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.ImportDataRequest, com.google.longrunning.Operation>
        getImportDataMethod;
    if ((getImportDataMethod = TranslationServiceGrpc.getImportDataMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getImportDataMethod = TranslationServiceGrpc.getImportDataMethod) == null) {
          TranslationServiceGrpc.getImportDataMethod =
              getImportDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.ImportDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ImportDataRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("ImportData"))
                      .build();
        }
      }
    }
    return getImportDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ExportDataRequest, com.google.longrunning.Operation>
      getExportDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportData",
      requestType = com.google.cloud.translate.v3.ExportDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ExportDataRequest, com.google.longrunning.Operation>
      getExportDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.ExportDataRequest, com.google.longrunning.Operation>
        getExportDataMethod;
    if ((getExportDataMethod = TranslationServiceGrpc.getExportDataMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getExportDataMethod = TranslationServiceGrpc.getExportDataMethod) == null) {
          TranslationServiceGrpc.getExportDataMethod =
              getExportDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.ExportDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ExportDataRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("ExportData"))
                      .build();
        }
      }
    }
    return getExportDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListExamplesRequest,
          com.google.cloud.translate.v3.ListExamplesResponse>
      getListExamplesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExamples",
      requestType = com.google.cloud.translate.v3.ListExamplesRequest.class,
      responseType = com.google.cloud.translate.v3.ListExamplesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListExamplesRequest,
          com.google.cloud.translate.v3.ListExamplesResponse>
      getListExamplesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.ListExamplesRequest,
            com.google.cloud.translate.v3.ListExamplesResponse>
        getListExamplesMethod;
    if ((getListExamplesMethod = TranslationServiceGrpc.getListExamplesMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getListExamplesMethod = TranslationServiceGrpc.getListExamplesMethod) == null) {
          TranslationServiceGrpc.getListExamplesMethod =
              getListExamplesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.ListExamplesRequest,
                          com.google.cloud.translate.v3.ListExamplesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExamples"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListExamplesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListExamplesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("ListExamples"))
                      .build();
        }
      }
    }
    return getListExamplesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.CreateModelRequest, com.google.longrunning.Operation>
      getCreateModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateModel",
      requestType = com.google.cloud.translate.v3.CreateModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.CreateModelRequest, com.google.longrunning.Operation>
      getCreateModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.CreateModelRequest, com.google.longrunning.Operation>
        getCreateModelMethod;
    if ((getCreateModelMethod = TranslationServiceGrpc.getCreateModelMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getCreateModelMethod = TranslationServiceGrpc.getCreateModelMethod) == null) {
          TranslationServiceGrpc.getCreateModelMethod =
              getCreateModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.CreateModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.CreateModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("CreateModel"))
                      .build();
        }
      }
    }
    return getCreateModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListModelsRequest,
          com.google.cloud.translate.v3.ListModelsResponse>
      getListModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListModels",
      requestType = com.google.cloud.translate.v3.ListModelsRequest.class,
      responseType = com.google.cloud.translate.v3.ListModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.ListModelsRequest,
          com.google.cloud.translate.v3.ListModelsResponse>
      getListModelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.ListModelsRequest,
            com.google.cloud.translate.v3.ListModelsResponse>
        getListModelsMethod;
    if ((getListModelsMethod = TranslationServiceGrpc.getListModelsMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getListModelsMethod = TranslationServiceGrpc.getListModelsMethod) == null) {
          TranslationServiceGrpc.getListModelsMethod =
              getListModelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.ListModelsRequest,
                          com.google.cloud.translate.v3.ListModelsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListModels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListModelsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.ListModelsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("ListModels"))
                      .build();
        }
      }
    }
    return getListModelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetModelRequest, com.google.cloud.translate.v3.Model>
      getGetModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetModel",
      requestType = com.google.cloud.translate.v3.GetModelRequest.class,
      responseType = com.google.cloud.translate.v3.Model.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.GetModelRequest, com.google.cloud.translate.v3.Model>
      getGetModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.GetModelRequest, com.google.cloud.translate.v3.Model>
        getGetModelMethod;
    if ((getGetModelMethod = TranslationServiceGrpc.getGetModelMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getGetModelMethod = TranslationServiceGrpc.getGetModelMethod) == null) {
          TranslationServiceGrpc.getGetModelMethod =
              getGetModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.GetModelRequest,
                          com.google.cloud.translate.v3.Model>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.GetModelRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.Model.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("GetModel"))
                      .build();
        }
      }
    }
    return getGetModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DeleteModelRequest, com.google.longrunning.Operation>
      getDeleteModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteModel",
      requestType = com.google.cloud.translate.v3.DeleteModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.translate.v3.DeleteModelRequest, com.google.longrunning.Operation>
      getDeleteModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.translate.v3.DeleteModelRequest, com.google.longrunning.Operation>
        getDeleteModelMethod;
    if ((getDeleteModelMethod = TranslationServiceGrpc.getDeleteModelMethod) == null) {
      synchronized (TranslationServiceGrpc.class) {
        if ((getDeleteModelMethod = TranslationServiceGrpc.getDeleteModelMethod) == null) {
          TranslationServiceGrpc.getDeleteModelMethod =
              getDeleteModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.translate.v3.DeleteModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.translate.v3.DeleteModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranslationServiceMethodDescriptorSupplier("DeleteModel"))
                      .build();
        }
      }
    }
    return getDeleteModelMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TranslationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TranslationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TranslationServiceStub>() {
          @java.lang.Override
          public TranslationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TranslationServiceStub(channel, callOptions);
          }
        };
    return TranslationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TranslationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TranslationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TranslationServiceBlockingStub>() {
          @java.lang.Override
          public TranslationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TranslationServiceBlockingStub(channel, callOptions);
          }
        };
    return TranslationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TranslationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TranslationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TranslationServiceFutureStub>() {
          @java.lang.Override
          public TranslationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TranslationServiceFutureStub(channel, callOptions);
          }
        };
    return TranslationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Provides natural language translation operations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Translates input text and returns translated text.
     * </pre>
     */
    default void translateText(
        com.google.cloud.translate.v3.TranslateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.TranslateTextResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTranslateTextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Romanize input text written in non-Latin scripts to Latin text.
     * </pre>
     */
    default void romanizeText(
        com.google.cloud.translate.v3.RomanizeTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.RomanizeTextResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRomanizeTextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Detects the language of text within a request.
     * </pre>
     */
    default void detectLanguage(
        com.google.cloud.translate.v3.DetectLanguageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.DetectLanguageResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDetectLanguageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of supported languages for translation.
     * </pre>
     */
    default void getSupportedLanguages(
        com.google.cloud.translate.v3.GetSupportedLanguagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.SupportedLanguages>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSupportedLanguagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Translates documents in synchronous mode.
     * </pre>
     */
    default void translateDocument(
        com.google.cloud.translate.v3.TranslateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.TranslateDocumentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTranslateDocumentMethod(), responseObserver);
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
    default void batchTranslateText(
        com.google.cloud.translate.v3.BatchTranslateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchTranslateTextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Translates a large volume of document in asynchronous batch mode.
     * This function provides real-time output as the inputs are being processed.
     * If caller cancels a request, the partial results (for an input file, it's
     * all or nothing) may still be available on the specified output location.
     * This call returns immediately and you can use
     * google.longrunning.Operation.name to poll the status of the call.
     * </pre>
     */
    default void batchTranslateDocument(
        com.google.cloud.translate.v3.BatchTranslateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchTranslateDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a glossary and returns the long-running operation. Returns
     * NOT_FOUND, if the project doesn't exist.
     * </pre>
     */
    default void createGlossary(
        com.google.cloud.translate.v3.CreateGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGlossaryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a glossary. A LRO is used since the update can be async if the
     * glossary's entry file is updated.
     * </pre>
     */
    default void updateGlossary(
        com.google.cloud.translate.v3.UpdateGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGlossaryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't
     * exist.
     * </pre>
     */
    default void listGlossaries(
        com.google.cloud.translate.v3.ListGlossariesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListGlossariesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGlossariesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't
     * exist.
     * </pre>
     */
    default void getGlossary(
        com.google.cloud.translate.v3.GetGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.Glossary> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGlossaryMethod(), responseObserver);
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
    default void deleteGlossary(
        com.google.cloud.translate.v3.DeleteGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGlossaryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a single glossary entry by the given id.
     * </pre>
     */
    default void getGlossaryEntry(
        com.google.cloud.translate.v3.GetGlossaryEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.GlossaryEntry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGlossaryEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List the entries for the glossary.
     * </pre>
     */
    default void listGlossaryEntries(
        com.google.cloud.translate.v3.ListGlossaryEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListGlossaryEntriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGlossaryEntriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a glossary entry.
     * </pre>
     */
    default void createGlossaryEntry(
        com.google.cloud.translate.v3.CreateGlossaryEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.GlossaryEntry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGlossaryEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a glossary entry.
     * </pre>
     */
    default void updateGlossaryEntry(
        com.google.cloud.translate.v3.UpdateGlossaryEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.GlossaryEntry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGlossaryEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single entry from the glossary
     * </pre>
     */
    default void deleteGlossaryEntry(
        com.google.cloud.translate.v3.DeleteGlossaryEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGlossaryEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Dataset.
     * </pre>
     */
    default void createDataset(
        com.google.cloud.translate.v3.CreateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Dataset.
     * </pre>
     */
    default void getDataset(
        com.google.cloud.translate.v3.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.Dataset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets.
     * </pre>
     */
    default void listDatasets(
        com.google.cloud.translate.v3.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatasetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset and all of its contents.
     * </pre>
     */
    default void deleteDataset(
        com.google.cloud.translate.v3.DeleteDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Adaptive MT dataset.
     * </pre>
     */
    default void createAdaptiveMtDataset(
        com.google.cloud.translate.v3.CreateAdaptiveMtDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.AdaptiveMtDataset>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAdaptiveMtDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Adaptive MT dataset, including all its entries and associated
     * metadata.
     * </pre>
     */
    default void deleteAdaptiveMtDataset(
        com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAdaptiveMtDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Adaptive MT dataset.
     * </pre>
     */
    default void getAdaptiveMtDataset(
        com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.AdaptiveMtDataset>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAdaptiveMtDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Adaptive MT datasets for which the caller has read permission.
     * </pre>
     */
    default void listAdaptiveMtDatasets(
        com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAdaptiveMtDatasetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Translate text using Adaptive MT.
     * </pre>
     */
    default void adaptiveMtTranslate(
        com.google.cloud.translate.v3.AdaptiveMtTranslateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.AdaptiveMtTranslateResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAdaptiveMtTranslateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets and AdaptiveMtFile
     * </pre>
     */
    default void getAdaptiveMtFile(
        com.google.cloud.translate.v3.GetAdaptiveMtFileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.AdaptiveMtFile>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAdaptiveMtFileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an AdaptiveMtFile along with its sentences.
     * </pre>
     */
    default void deleteAdaptiveMtFile(
        com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAdaptiveMtFileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports an AdaptiveMtFile and adds all of its sentences into the
     * AdaptiveMtDataset.
     * </pre>
     */
    default void importAdaptiveMtFile(
        com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportAdaptiveMtFileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all AdaptiveMtFiles associated to an AdaptiveMtDataset.
     * </pre>
     */
    default void listAdaptiveMtFiles(
        com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAdaptiveMtFilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all AdaptiveMtSentences under a given file/dataset.
     * </pre>
     */
    default void listAdaptiveMtSentences(
        com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAdaptiveMtSentencesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Import sentence pairs into translation Dataset.
     * </pre>
     */
    default void importData(
        com.google.cloud.translate.v3.ImportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportDataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports dataset's data to the provided output location.
     * </pre>
     */
    default void exportData(
        com.google.cloud.translate.v3.ExportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportDataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists sentence pairs in the dataset.
     * </pre>
     */
    default void listExamples(
        com.google.cloud.translate.v3.ListExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListExamplesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExamplesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Model.
     * </pre>
     */
    default void createModel(
        com.google.cloud.translate.v3.CreateModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists models.
     * </pre>
     */
    default void listModels(
        com.google.cloud.translate.v3.ListModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListModelsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListModelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a model.
     * </pre>
     */
    default void getModel(
        com.google.cloud.translate.v3.GetModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.Model> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a model.
     * </pre>
     */
    default void deleteModel(
        com.google.cloud.translate.v3.DeleteModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteModelMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TranslationService.
   *
   * <pre>
   * Provides natural language translation operations.
   * </pre>
   */
  public abstract static class TranslationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return TranslationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TranslationService.
   *
   * <pre>
   * Provides natural language translation operations.
   * </pre>
   */
  public static final class TranslationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TranslationServiceStub> {
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
        com.google.cloud.translate.v3.TranslateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.TranslateTextResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTranslateTextMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Romanize input text written in non-Latin scripts to Latin text.
     * </pre>
     */
    public void romanizeText(
        com.google.cloud.translate.v3.RomanizeTextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.RomanizeTextResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRomanizeTextMethod(), getCallOptions()),
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
        com.google.cloud.translate.v3.DetectLanguageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.DetectLanguageResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDetectLanguageMethod(), getCallOptions()),
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
        com.google.cloud.translate.v3.GetSupportedLanguagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.SupportedLanguages>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSupportedLanguagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Translates documents in synchronous mode.
     * </pre>
     */
    public void translateDocument(
        com.google.cloud.translate.v3.TranslateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.TranslateDocumentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTranslateDocumentMethod(), getCallOptions()),
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
        com.google.cloud.translate.v3.BatchTranslateTextRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchTranslateTextMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Translates a large volume of document in asynchronous batch mode.
     * This function provides real-time output as the inputs are being processed.
     * If caller cancels a request, the partial results (for an input file, it's
     * all or nothing) may still be available on the specified output location.
     * This call returns immediately and you can use
     * google.longrunning.Operation.name to poll the status of the call.
     * </pre>
     */
    public void batchTranslateDocument(
        com.google.cloud.translate.v3.BatchTranslateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchTranslateDocumentMethod(), getCallOptions()),
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
        com.google.cloud.translate.v3.CreateGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGlossaryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a glossary. A LRO is used since the update can be async if the
     * glossary's entry file is updated.
     * </pre>
     */
    public void updateGlossary(
        com.google.cloud.translate.v3.UpdateGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGlossaryMethod(), getCallOptions()),
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
        com.google.cloud.translate.v3.ListGlossariesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListGlossariesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGlossariesMethod(), getCallOptions()),
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
        com.google.cloud.translate.v3.GetGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.Glossary> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGlossaryMethod(), getCallOptions()),
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
        com.google.cloud.translate.v3.DeleteGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGlossaryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a single glossary entry by the given id.
     * </pre>
     */
    public void getGlossaryEntry(
        com.google.cloud.translate.v3.GetGlossaryEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.GlossaryEntry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGlossaryEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List the entries for the glossary.
     * </pre>
     */
    public void listGlossaryEntries(
        com.google.cloud.translate.v3.ListGlossaryEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListGlossaryEntriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGlossaryEntriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a glossary entry.
     * </pre>
     */
    public void createGlossaryEntry(
        com.google.cloud.translate.v3.CreateGlossaryEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.GlossaryEntry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGlossaryEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a glossary entry.
     * </pre>
     */
    public void updateGlossaryEntry(
        com.google.cloud.translate.v3.UpdateGlossaryEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.GlossaryEntry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGlossaryEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single entry from the glossary
     * </pre>
     */
    public void deleteGlossaryEntry(
        com.google.cloud.translate.v3.DeleteGlossaryEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGlossaryEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Dataset.
     * </pre>
     */
    public void createDataset(
        com.google.cloud.translate.v3.CreateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Dataset.
     * </pre>
     */
    public void getDataset(
        com.google.cloud.translate.v3.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.Dataset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets.
     * </pre>
     */
    public void listDatasets(
        com.google.cloud.translate.v3.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatasetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset and all of its contents.
     * </pre>
     */
    public void deleteDataset(
        com.google.cloud.translate.v3.DeleteDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Adaptive MT dataset.
     * </pre>
     */
    public void createAdaptiveMtDataset(
        com.google.cloud.translate.v3.CreateAdaptiveMtDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.AdaptiveMtDataset>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAdaptiveMtDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Adaptive MT dataset, including all its entries and associated
     * metadata.
     * </pre>
     */
    public void deleteAdaptiveMtDataset(
        com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAdaptiveMtDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Adaptive MT dataset.
     * </pre>
     */
    public void getAdaptiveMtDataset(
        com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.AdaptiveMtDataset>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAdaptiveMtDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Adaptive MT datasets for which the caller has read permission.
     * </pre>
     */
    public void listAdaptiveMtDatasets(
        com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAdaptiveMtDatasetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Translate text using Adaptive MT.
     * </pre>
     */
    public void adaptiveMtTranslate(
        com.google.cloud.translate.v3.AdaptiveMtTranslateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.AdaptiveMtTranslateResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAdaptiveMtTranslateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets and AdaptiveMtFile
     * </pre>
     */
    public void getAdaptiveMtFile(
        com.google.cloud.translate.v3.GetAdaptiveMtFileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.AdaptiveMtFile>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAdaptiveMtFileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an AdaptiveMtFile along with its sentences.
     * </pre>
     */
    public void deleteAdaptiveMtFile(
        com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAdaptiveMtFileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports an AdaptiveMtFile and adds all of its sentences into the
     * AdaptiveMtDataset.
     * </pre>
     */
    public void importAdaptiveMtFile(
        com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportAdaptiveMtFileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all AdaptiveMtFiles associated to an AdaptiveMtDataset.
     * </pre>
     */
    public void listAdaptiveMtFiles(
        com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAdaptiveMtFilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all AdaptiveMtSentences under a given file/dataset.
     * </pre>
     */
    public void listAdaptiveMtSentences(
        com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAdaptiveMtSentencesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Import sentence pairs into translation Dataset.
     * </pre>
     */
    public void importData(
        com.google.cloud.translate.v3.ImportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports dataset's data to the provided output location.
     * </pre>
     */
    public void exportData(
        com.google.cloud.translate.v3.ExportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists sentence pairs in the dataset.
     * </pre>
     */
    public void listExamples(
        com.google.cloud.translate.v3.ListExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListExamplesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExamplesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Model.
     * </pre>
     */
    public void createModel(
        com.google.cloud.translate.v3.CreateModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists models.
     * </pre>
     */
    public void listModels(
        com.google.cloud.translate.v3.ListModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListModelsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListModelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a model.
     * </pre>
     */
    public void getModel(
        com.google.cloud.translate.v3.GetModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.Model> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a model.
     * </pre>
     */
    public void deleteModel(
        com.google.cloud.translate.v3.DeleteModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TranslationService.
   *
   * <pre>
   * Provides natural language translation operations.
   * </pre>
   */
  public static final class TranslationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TranslationServiceBlockingStub> {
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
    public com.google.cloud.translate.v3.TranslateTextResponse translateText(
        com.google.cloud.translate.v3.TranslateTextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTranslateTextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Romanize input text written in non-Latin scripts to Latin text.
     * </pre>
     */
    public com.google.cloud.translate.v3.RomanizeTextResponse romanizeText(
        com.google.cloud.translate.v3.RomanizeTextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRomanizeTextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Detects the language of text within a request.
     * </pre>
     */
    public com.google.cloud.translate.v3.DetectLanguageResponse detectLanguage(
        com.google.cloud.translate.v3.DetectLanguageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDetectLanguageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of supported languages for translation.
     * </pre>
     */
    public com.google.cloud.translate.v3.SupportedLanguages getSupportedLanguages(
        com.google.cloud.translate.v3.GetSupportedLanguagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSupportedLanguagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Translates documents in synchronous mode.
     * </pre>
     */
    public com.google.cloud.translate.v3.TranslateDocumentResponse translateDocument(
        com.google.cloud.translate.v3.TranslateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTranslateDocumentMethod(), getCallOptions(), request);
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
        com.google.cloud.translate.v3.BatchTranslateTextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchTranslateTextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Translates a large volume of document in asynchronous batch mode.
     * This function provides real-time output as the inputs are being processed.
     * If caller cancels a request, the partial results (for an input file, it's
     * all or nothing) may still be available on the specified output location.
     * This call returns immediately and you can use
     * google.longrunning.Operation.name to poll the status of the call.
     * </pre>
     */
    public com.google.longrunning.Operation batchTranslateDocument(
        com.google.cloud.translate.v3.BatchTranslateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchTranslateDocumentMethod(), getCallOptions(), request);
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
        com.google.cloud.translate.v3.CreateGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGlossaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a glossary. A LRO is used since the update can be async if the
     * glossary's entry file is updated.
     * </pre>
     */
    public com.google.longrunning.Operation updateGlossary(
        com.google.cloud.translate.v3.UpdateGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGlossaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't
     * exist.
     * </pre>
     */
    public com.google.cloud.translate.v3.ListGlossariesResponse listGlossaries(
        com.google.cloud.translate.v3.ListGlossariesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGlossariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't
     * exist.
     * </pre>
     */
    public com.google.cloud.translate.v3.Glossary getGlossary(
        com.google.cloud.translate.v3.GetGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGlossaryMethod(), getCallOptions(), request);
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
        com.google.cloud.translate.v3.DeleteGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGlossaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single glossary entry by the given id.
     * </pre>
     */
    public com.google.cloud.translate.v3.GlossaryEntry getGlossaryEntry(
        com.google.cloud.translate.v3.GetGlossaryEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGlossaryEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List the entries for the glossary.
     * </pre>
     */
    public com.google.cloud.translate.v3.ListGlossaryEntriesResponse listGlossaryEntries(
        com.google.cloud.translate.v3.ListGlossaryEntriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGlossaryEntriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a glossary entry.
     * </pre>
     */
    public com.google.cloud.translate.v3.GlossaryEntry createGlossaryEntry(
        com.google.cloud.translate.v3.CreateGlossaryEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGlossaryEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a glossary entry.
     * </pre>
     */
    public com.google.cloud.translate.v3.GlossaryEntry updateGlossaryEntry(
        com.google.cloud.translate.v3.UpdateGlossaryEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGlossaryEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single entry from the glossary
     * </pre>
     */
    public com.google.protobuf.Empty deleteGlossaryEntry(
        com.google.cloud.translate.v3.DeleteGlossaryEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGlossaryEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Dataset.
     * </pre>
     */
    public com.google.longrunning.Operation createDataset(
        com.google.cloud.translate.v3.CreateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Dataset.
     * </pre>
     */
    public com.google.cloud.translate.v3.Dataset getDataset(
        com.google.cloud.translate.v3.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets.
     * </pre>
     */
    public com.google.cloud.translate.v3.ListDatasetsResponse listDatasets(
        com.google.cloud.translate.v3.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatasetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset and all of its contents.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataset(
        com.google.cloud.translate.v3.DeleteDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Adaptive MT dataset.
     * </pre>
     */
    public com.google.cloud.translate.v3.AdaptiveMtDataset createAdaptiveMtDataset(
        com.google.cloud.translate.v3.CreateAdaptiveMtDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAdaptiveMtDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Adaptive MT dataset, including all its entries and associated
     * metadata.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAdaptiveMtDataset(
        com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAdaptiveMtDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Adaptive MT dataset.
     * </pre>
     */
    public com.google.cloud.translate.v3.AdaptiveMtDataset getAdaptiveMtDataset(
        com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAdaptiveMtDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Adaptive MT datasets for which the caller has read permission.
     * </pre>
     */
    public com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse listAdaptiveMtDatasets(
        com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAdaptiveMtDatasetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Translate text using Adaptive MT.
     * </pre>
     */
    public com.google.cloud.translate.v3.AdaptiveMtTranslateResponse adaptiveMtTranslate(
        com.google.cloud.translate.v3.AdaptiveMtTranslateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAdaptiveMtTranslateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets and AdaptiveMtFile
     * </pre>
     */
    public com.google.cloud.translate.v3.AdaptiveMtFile getAdaptiveMtFile(
        com.google.cloud.translate.v3.GetAdaptiveMtFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAdaptiveMtFileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an AdaptiveMtFile along with its sentences.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAdaptiveMtFile(
        com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAdaptiveMtFileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports an AdaptiveMtFile and adds all of its sentences into the
     * AdaptiveMtDataset.
     * </pre>
     */
    public com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse importAdaptiveMtFile(
        com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportAdaptiveMtFileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all AdaptiveMtFiles associated to an AdaptiveMtDataset.
     * </pre>
     */
    public com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse listAdaptiveMtFiles(
        com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAdaptiveMtFilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all AdaptiveMtSentences under a given file/dataset.
     * </pre>
     */
    public com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse listAdaptiveMtSentences(
        com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAdaptiveMtSentencesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Import sentence pairs into translation Dataset.
     * </pre>
     */
    public com.google.longrunning.Operation importData(
        com.google.cloud.translate.v3.ImportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportDataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports dataset's data to the provided output location.
     * </pre>
     */
    public com.google.longrunning.Operation exportData(
        com.google.cloud.translate.v3.ExportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportDataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists sentence pairs in the dataset.
     * </pre>
     */
    public com.google.cloud.translate.v3.ListExamplesResponse listExamples(
        com.google.cloud.translate.v3.ListExamplesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExamplesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Model.
     * </pre>
     */
    public com.google.longrunning.Operation createModel(
        com.google.cloud.translate.v3.CreateModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists models.
     * </pre>
     */
    public com.google.cloud.translate.v3.ListModelsResponse listModels(
        com.google.cloud.translate.v3.ListModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListModelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a model.
     * </pre>
     */
    public com.google.cloud.translate.v3.Model getModel(
        com.google.cloud.translate.v3.GetModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a model.
     * </pre>
     */
    public com.google.longrunning.Operation deleteModel(
        com.google.cloud.translate.v3.DeleteModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteModelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TranslationService.
   *
   * <pre>
   * Provides natural language translation operations.
   * </pre>
   */
  public static final class TranslationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TranslationServiceFutureStub> {
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
            com.google.cloud.translate.v3.TranslateTextResponse>
        translateText(com.google.cloud.translate.v3.TranslateTextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTranslateTextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Romanize input text written in non-Latin scripts to Latin text.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.RomanizeTextResponse>
        romanizeText(com.google.cloud.translate.v3.RomanizeTextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRomanizeTextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Detects the language of text within a request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.DetectLanguageResponse>
        detectLanguage(com.google.cloud.translate.v3.DetectLanguageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDetectLanguageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of supported languages for translation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.SupportedLanguages>
        getSupportedLanguages(com.google.cloud.translate.v3.GetSupportedLanguagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSupportedLanguagesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Translates documents in synchronous mode.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.TranslateDocumentResponse>
        translateDocument(com.google.cloud.translate.v3.TranslateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTranslateDocumentMethod(), getCallOptions()), request);
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
        batchTranslateText(com.google.cloud.translate.v3.BatchTranslateTextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchTranslateTextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Translates a large volume of document in asynchronous batch mode.
     * This function provides real-time output as the inputs are being processed.
     * If caller cancels a request, the partial results (for an input file, it's
     * all or nothing) may still be available on the specified output location.
     * This call returns immediately and you can use
     * google.longrunning.Operation.name to poll the status of the call.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchTranslateDocument(
            com.google.cloud.translate.v3.BatchTranslateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchTranslateDocumentMethod(), getCallOptions()), request);
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
        createGlossary(com.google.cloud.translate.v3.CreateGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGlossaryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a glossary. A LRO is used since the update can be async if the
     * glossary's entry file is updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGlossary(com.google.cloud.translate.v3.UpdateGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGlossaryMethod(), getCallOptions()), request);
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
            com.google.cloud.translate.v3.ListGlossariesResponse>
        listGlossaries(com.google.cloud.translate.v3.ListGlossariesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGlossariesMethod(), getCallOptions()), request);
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
            com.google.cloud.translate.v3.Glossary>
        getGlossary(com.google.cloud.translate.v3.GetGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGlossaryMethod(), getCallOptions()), request);
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
        deleteGlossary(com.google.cloud.translate.v3.DeleteGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGlossaryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single glossary entry by the given id.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.GlossaryEntry>
        getGlossaryEntry(com.google.cloud.translate.v3.GetGlossaryEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGlossaryEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List the entries for the glossary.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.ListGlossaryEntriesResponse>
        listGlossaryEntries(com.google.cloud.translate.v3.ListGlossaryEntriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGlossaryEntriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a glossary entry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.GlossaryEntry>
        createGlossaryEntry(com.google.cloud.translate.v3.CreateGlossaryEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGlossaryEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a glossary entry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.GlossaryEntry>
        updateGlossaryEntry(com.google.cloud.translate.v3.UpdateGlossaryEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGlossaryEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single entry from the glossary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteGlossaryEntry(com.google.cloud.translate.v3.DeleteGlossaryEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGlossaryEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDataset(com.google.cloud.translate.v3.CreateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.translate.v3.Dataset>
        getDataset(com.google.cloud.translate.v3.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.ListDatasetsResponse>
        listDatasets(com.google.cloud.translate.v3.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatasetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset and all of its contents.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDataset(com.google.cloud.translate.v3.DeleteDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Adaptive MT dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.AdaptiveMtDataset>
        createAdaptiveMtDataset(
            com.google.cloud.translate.v3.CreateAdaptiveMtDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAdaptiveMtDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Adaptive MT dataset, including all its entries and associated
     * metadata.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAdaptiveMtDataset(
            com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAdaptiveMtDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Adaptive MT dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.AdaptiveMtDataset>
        getAdaptiveMtDataset(com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAdaptiveMtDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Adaptive MT datasets for which the caller has read permission.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse>
        listAdaptiveMtDatasets(
            com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAdaptiveMtDatasetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Translate text using Adaptive MT.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.AdaptiveMtTranslateResponse>
        adaptiveMtTranslate(com.google.cloud.translate.v3.AdaptiveMtTranslateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAdaptiveMtTranslateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets and AdaptiveMtFile
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.AdaptiveMtFile>
        getAdaptiveMtFile(com.google.cloud.translate.v3.GetAdaptiveMtFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAdaptiveMtFileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an AdaptiveMtFile along with its sentences.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAdaptiveMtFile(com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAdaptiveMtFileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports an AdaptiveMtFile and adds all of its sentences into the
     * AdaptiveMtDataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse>
        importAdaptiveMtFile(com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportAdaptiveMtFileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all AdaptiveMtFiles associated to an AdaptiveMtDataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse>
        listAdaptiveMtFiles(com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAdaptiveMtFilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all AdaptiveMtSentences under a given file/dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse>
        listAdaptiveMtSentences(
            com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAdaptiveMtSentencesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Import sentence pairs into translation Dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importData(com.google.cloud.translate.v3.ImportDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportDataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports dataset's data to the provided output location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportData(com.google.cloud.translate.v3.ExportDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportDataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists sentence pairs in the dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.ListExamplesResponse>
        listExamples(com.google.cloud.translate.v3.ListExamplesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExamplesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createModel(com.google.cloud.translate.v3.CreateModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists models.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.translate.v3.ListModelsResponse>
        listModels(com.google.cloud.translate.v3.ListModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListModelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.translate.v3.Model>
        getModel(com.google.cloud.translate.v3.GetModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteModel(com.google.cloud.translate.v3.DeleteModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteModelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRANSLATE_TEXT = 0;
  private static final int METHODID_ROMANIZE_TEXT = 1;
  private static final int METHODID_DETECT_LANGUAGE = 2;
  private static final int METHODID_GET_SUPPORTED_LANGUAGES = 3;
  private static final int METHODID_TRANSLATE_DOCUMENT = 4;
  private static final int METHODID_BATCH_TRANSLATE_TEXT = 5;
  private static final int METHODID_BATCH_TRANSLATE_DOCUMENT = 6;
  private static final int METHODID_CREATE_GLOSSARY = 7;
  private static final int METHODID_UPDATE_GLOSSARY = 8;
  private static final int METHODID_LIST_GLOSSARIES = 9;
  private static final int METHODID_GET_GLOSSARY = 10;
  private static final int METHODID_DELETE_GLOSSARY = 11;
  private static final int METHODID_GET_GLOSSARY_ENTRY = 12;
  private static final int METHODID_LIST_GLOSSARY_ENTRIES = 13;
  private static final int METHODID_CREATE_GLOSSARY_ENTRY = 14;
  private static final int METHODID_UPDATE_GLOSSARY_ENTRY = 15;
  private static final int METHODID_DELETE_GLOSSARY_ENTRY = 16;
  private static final int METHODID_CREATE_DATASET = 17;
  private static final int METHODID_GET_DATASET = 18;
  private static final int METHODID_LIST_DATASETS = 19;
  private static final int METHODID_DELETE_DATASET = 20;
  private static final int METHODID_CREATE_ADAPTIVE_MT_DATASET = 21;
  private static final int METHODID_DELETE_ADAPTIVE_MT_DATASET = 22;
  private static final int METHODID_GET_ADAPTIVE_MT_DATASET = 23;
  private static final int METHODID_LIST_ADAPTIVE_MT_DATASETS = 24;
  private static final int METHODID_ADAPTIVE_MT_TRANSLATE = 25;
  private static final int METHODID_GET_ADAPTIVE_MT_FILE = 26;
  private static final int METHODID_DELETE_ADAPTIVE_MT_FILE = 27;
  private static final int METHODID_IMPORT_ADAPTIVE_MT_FILE = 28;
  private static final int METHODID_LIST_ADAPTIVE_MT_FILES = 29;
  private static final int METHODID_LIST_ADAPTIVE_MT_SENTENCES = 30;
  private static final int METHODID_IMPORT_DATA = 31;
  private static final int METHODID_EXPORT_DATA = 32;
  private static final int METHODID_LIST_EXAMPLES = 33;
  private static final int METHODID_CREATE_MODEL = 34;
  private static final int METHODID_LIST_MODELS = 35;
  private static final int METHODID_GET_MODEL = 36;
  private static final int METHODID_DELETE_MODEL = 37;

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
        case METHODID_TRANSLATE_TEXT:
          serviceImpl.translateText(
              (com.google.cloud.translate.v3.TranslateTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.TranslateTextResponse>)
                  responseObserver);
          break;
        case METHODID_ROMANIZE_TEXT:
          serviceImpl.romanizeText(
              (com.google.cloud.translate.v3.RomanizeTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.RomanizeTextResponse>)
                  responseObserver);
          break;
        case METHODID_DETECT_LANGUAGE:
          serviceImpl.detectLanguage(
              (com.google.cloud.translate.v3.DetectLanguageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.DetectLanguageResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SUPPORTED_LANGUAGES:
          serviceImpl.getSupportedLanguages(
              (com.google.cloud.translate.v3.GetSupportedLanguagesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.SupportedLanguages>)
                  responseObserver);
          break;
        case METHODID_TRANSLATE_DOCUMENT:
          serviceImpl.translateDocument(
              (com.google.cloud.translate.v3.TranslateDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.TranslateDocumentResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_TRANSLATE_TEXT:
          serviceImpl.batchTranslateText(
              (com.google.cloud.translate.v3.BatchTranslateTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_TRANSLATE_DOCUMENT:
          serviceImpl.batchTranslateDocument(
              (com.google.cloud.translate.v3.BatchTranslateDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_GLOSSARY:
          serviceImpl.createGlossary(
              (com.google.cloud.translate.v3.CreateGlossaryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_GLOSSARY:
          serviceImpl.updateGlossary(
              (com.google.cloud.translate.v3.UpdateGlossaryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_GLOSSARIES:
          serviceImpl.listGlossaries(
              (com.google.cloud.translate.v3.ListGlossariesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListGlossariesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GLOSSARY:
          serviceImpl.getGlossary(
              (com.google.cloud.translate.v3.GetGlossaryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.Glossary>)
                  responseObserver);
          break;
        case METHODID_DELETE_GLOSSARY:
          serviceImpl.deleteGlossary(
              (com.google.cloud.translate.v3.DeleteGlossaryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_GLOSSARY_ENTRY:
          serviceImpl.getGlossaryEntry(
              (com.google.cloud.translate.v3.GetGlossaryEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.GlossaryEntry>)
                  responseObserver);
          break;
        case METHODID_LIST_GLOSSARY_ENTRIES:
          serviceImpl.listGlossaryEntries(
              (com.google.cloud.translate.v3.ListGlossaryEntriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.translate.v3.ListGlossaryEntriesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_GLOSSARY_ENTRY:
          serviceImpl.createGlossaryEntry(
              (com.google.cloud.translate.v3.CreateGlossaryEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.GlossaryEntry>)
                  responseObserver);
          break;
        case METHODID_UPDATE_GLOSSARY_ENTRY:
          serviceImpl.updateGlossaryEntry(
              (com.google.cloud.translate.v3.UpdateGlossaryEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.GlossaryEntry>)
                  responseObserver);
          break;
        case METHODID_DELETE_GLOSSARY_ENTRY:
          serviceImpl.deleteGlossaryEntry(
              (com.google.cloud.translate.v3.DeleteGlossaryEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_DATASET:
          serviceImpl.createDataset(
              (com.google.cloud.translate.v3.CreateDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DATASET:
          serviceImpl.getDataset(
              (com.google.cloud.translate.v3.GetDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.Dataset>)
                  responseObserver);
          break;
        case METHODID_LIST_DATASETS:
          serviceImpl.listDatasets(
              (com.google.cloud.translate.v3.ListDatasetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListDatasetsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATASET:
          serviceImpl.deleteDataset(
              (com.google.cloud.translate.v3.DeleteDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_ADAPTIVE_MT_DATASET:
          serviceImpl.createAdaptiveMtDataset(
              (com.google.cloud.translate.v3.CreateAdaptiveMtDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.AdaptiveMtDataset>)
                  responseObserver);
          break;
        case METHODID_DELETE_ADAPTIVE_MT_DATASET:
          serviceImpl.deleteAdaptiveMtDataset(
              (com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_ADAPTIVE_MT_DATASET:
          serviceImpl.getAdaptiveMtDataset(
              (com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.AdaptiveMtDataset>)
                  responseObserver);
          break;
        case METHODID_LIST_ADAPTIVE_MT_DATASETS:
          serviceImpl.listAdaptiveMtDatasets(
              (com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse>)
                  responseObserver);
          break;
        case METHODID_ADAPTIVE_MT_TRANSLATE:
          serviceImpl.adaptiveMtTranslate(
              (com.google.cloud.translate.v3.AdaptiveMtTranslateRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.translate.v3.AdaptiveMtTranslateResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ADAPTIVE_MT_FILE:
          serviceImpl.getAdaptiveMtFile(
              (com.google.cloud.translate.v3.GetAdaptiveMtFileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.AdaptiveMtFile>)
                  responseObserver);
          break;
        case METHODID_DELETE_ADAPTIVE_MT_FILE:
          serviceImpl.deleteAdaptiveMtFile(
              (com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_IMPORT_ADAPTIVE_MT_FILE:
          serviceImpl.importAdaptiveMtFile(
              (com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ADAPTIVE_MT_FILES:
          serviceImpl.listAdaptiveMtFiles(
              (com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ADAPTIVE_MT_SENTENCES:
          serviceImpl.listAdaptiveMtSentences(
              (com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse>)
                  responseObserver);
          break;
        case METHODID_IMPORT_DATA:
          serviceImpl.importData(
              (com.google.cloud.translate.v3.ImportDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_DATA:
          serviceImpl.exportData(
              (com.google.cloud.translate.v3.ExportDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_EXAMPLES:
          serviceImpl.listExamples(
              (com.google.cloud.translate.v3.ListExamplesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListExamplesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_MODEL:
          serviceImpl.createModel(
              (com.google.cloud.translate.v3.CreateModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_MODELS:
          serviceImpl.listModels(
              (com.google.cloud.translate.v3.ListModelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.ListModelsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MODEL:
          serviceImpl.getModel(
              (com.google.cloud.translate.v3.GetModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.translate.v3.Model>) responseObserver);
          break;
        case METHODID_DELETE_MODEL:
          serviceImpl.deleteModel(
              (com.google.cloud.translate.v3.DeleteModelRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getTranslateTextMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.TranslateTextRequest,
                    com.google.cloud.translate.v3.TranslateTextResponse>(
                    service, METHODID_TRANSLATE_TEXT)))
        .addMethod(
            getRomanizeTextMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.RomanizeTextRequest,
                    com.google.cloud.translate.v3.RomanizeTextResponse>(
                    service, METHODID_ROMANIZE_TEXT)))
        .addMethod(
            getDetectLanguageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.DetectLanguageRequest,
                    com.google.cloud.translate.v3.DetectLanguageResponse>(
                    service, METHODID_DETECT_LANGUAGE)))
        .addMethod(
            getGetSupportedLanguagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.GetSupportedLanguagesRequest,
                    com.google.cloud.translate.v3.SupportedLanguages>(
                    service, METHODID_GET_SUPPORTED_LANGUAGES)))
        .addMethod(
            getTranslateDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.TranslateDocumentRequest,
                    com.google.cloud.translate.v3.TranslateDocumentResponse>(
                    service, METHODID_TRANSLATE_DOCUMENT)))
        .addMethod(
            getBatchTranslateTextMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.BatchTranslateTextRequest,
                    com.google.longrunning.Operation>(service, METHODID_BATCH_TRANSLATE_TEXT)))
        .addMethod(
            getBatchTranslateDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.BatchTranslateDocumentRequest,
                    com.google.longrunning.Operation>(service, METHODID_BATCH_TRANSLATE_DOCUMENT)))
        .addMethod(
            getCreateGlossaryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.CreateGlossaryRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_GLOSSARY)))
        .addMethod(
            getUpdateGlossaryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.UpdateGlossaryRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_GLOSSARY)))
        .addMethod(
            getListGlossariesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.ListGlossariesRequest,
                    com.google.cloud.translate.v3.ListGlossariesResponse>(
                    service, METHODID_LIST_GLOSSARIES)))
        .addMethod(
            getGetGlossaryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.GetGlossaryRequest,
                    com.google.cloud.translate.v3.Glossary>(service, METHODID_GET_GLOSSARY)))
        .addMethod(
            getDeleteGlossaryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.DeleteGlossaryRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_GLOSSARY)))
        .addMethod(
            getGetGlossaryEntryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.GetGlossaryEntryRequest,
                    com.google.cloud.translate.v3.GlossaryEntry>(
                    service, METHODID_GET_GLOSSARY_ENTRY)))
        .addMethod(
            getListGlossaryEntriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.ListGlossaryEntriesRequest,
                    com.google.cloud.translate.v3.ListGlossaryEntriesResponse>(
                    service, METHODID_LIST_GLOSSARY_ENTRIES)))
        .addMethod(
            getCreateGlossaryEntryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.CreateGlossaryEntryRequest,
                    com.google.cloud.translate.v3.GlossaryEntry>(
                    service, METHODID_CREATE_GLOSSARY_ENTRY)))
        .addMethod(
            getUpdateGlossaryEntryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.UpdateGlossaryEntryRequest,
                    com.google.cloud.translate.v3.GlossaryEntry>(
                    service, METHODID_UPDATE_GLOSSARY_ENTRY)))
        .addMethod(
            getDeleteGlossaryEntryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.DeleteGlossaryEntryRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_GLOSSARY_ENTRY)))
        .addMethod(
            getCreateDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.CreateDatasetRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DATASET)))
        .addMethod(
            getGetDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.GetDatasetRequest,
                    com.google.cloud.translate.v3.Dataset>(service, METHODID_GET_DATASET)))
        .addMethod(
            getListDatasetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.ListDatasetsRequest,
                    com.google.cloud.translate.v3.ListDatasetsResponse>(
                    service, METHODID_LIST_DATASETS)))
        .addMethod(
            getDeleteDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.DeleteDatasetRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DATASET)))
        .addMethod(
            getCreateAdaptiveMtDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.CreateAdaptiveMtDatasetRequest,
                    com.google.cloud.translate.v3.AdaptiveMtDataset>(
                    service, METHODID_CREATE_ADAPTIVE_MT_DATASET)))
        .addMethod(
            getDeleteAdaptiveMtDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ADAPTIVE_MT_DATASET)))
        .addMethod(
            getGetAdaptiveMtDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest,
                    com.google.cloud.translate.v3.AdaptiveMtDataset>(
                    service, METHODID_GET_ADAPTIVE_MT_DATASET)))
        .addMethod(
            getListAdaptiveMtDatasetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest,
                    com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse>(
                    service, METHODID_LIST_ADAPTIVE_MT_DATASETS)))
        .addMethod(
            getAdaptiveMtTranslateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.AdaptiveMtTranslateRequest,
                    com.google.cloud.translate.v3.AdaptiveMtTranslateResponse>(
                    service, METHODID_ADAPTIVE_MT_TRANSLATE)))
        .addMethod(
            getGetAdaptiveMtFileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.GetAdaptiveMtFileRequest,
                    com.google.cloud.translate.v3.AdaptiveMtFile>(
                    service, METHODID_GET_ADAPTIVE_MT_FILE)))
        .addMethod(
            getDeleteAdaptiveMtFileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ADAPTIVE_MT_FILE)))
        .addMethod(
            getImportAdaptiveMtFileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest,
                    com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse>(
                    service, METHODID_IMPORT_ADAPTIVE_MT_FILE)))
        .addMethod(
            getListAdaptiveMtFilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest,
                    com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse>(
                    service, METHODID_LIST_ADAPTIVE_MT_FILES)))
        .addMethod(
            getListAdaptiveMtSentencesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest,
                    com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse>(
                    service, METHODID_LIST_ADAPTIVE_MT_SENTENCES)))
        .addMethod(
            getImportDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.ImportDataRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_DATA)))
        .addMethod(
            getExportDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.ExportDataRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_DATA)))
        .addMethod(
            getListExamplesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.ListExamplesRequest,
                    com.google.cloud.translate.v3.ListExamplesResponse>(
                    service, METHODID_LIST_EXAMPLES)))
        .addMethod(
            getCreateModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.CreateModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_MODEL)))
        .addMethod(
            getListModelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.ListModelsRequest,
                    com.google.cloud.translate.v3.ListModelsResponse>(
                    service, METHODID_LIST_MODELS)))
        .addMethod(
            getGetModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.GetModelRequest,
                    com.google.cloud.translate.v3.Model>(service, METHODID_GET_MODEL)))
        .addMethod(
            getDeleteModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.translate.v3.DeleteModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_MODEL)))
        .build();
  }

  private abstract static class TranslationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TranslationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.translate.v3.TranslationServiceProto.getDescriptor();
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
    private final java.lang.String methodName;

    TranslationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
                      .addMethod(getTranslateTextMethod())
                      .addMethod(getRomanizeTextMethod())
                      .addMethod(getDetectLanguageMethod())
                      .addMethod(getGetSupportedLanguagesMethod())
                      .addMethod(getTranslateDocumentMethod())
                      .addMethod(getBatchTranslateTextMethod())
                      .addMethod(getBatchTranslateDocumentMethod())
                      .addMethod(getCreateGlossaryMethod())
                      .addMethod(getUpdateGlossaryMethod())
                      .addMethod(getListGlossariesMethod())
                      .addMethod(getGetGlossaryMethod())
                      .addMethod(getDeleteGlossaryMethod())
                      .addMethod(getGetGlossaryEntryMethod())
                      .addMethod(getListGlossaryEntriesMethod())
                      .addMethod(getCreateGlossaryEntryMethod())
                      .addMethod(getUpdateGlossaryEntryMethod())
                      .addMethod(getDeleteGlossaryEntryMethod())
                      .addMethod(getCreateDatasetMethod())
                      .addMethod(getGetDatasetMethod())
                      .addMethod(getListDatasetsMethod())
                      .addMethod(getDeleteDatasetMethod())
                      .addMethod(getCreateAdaptiveMtDatasetMethod())
                      .addMethod(getDeleteAdaptiveMtDatasetMethod())
                      .addMethod(getGetAdaptiveMtDatasetMethod())
                      .addMethod(getListAdaptiveMtDatasetsMethod())
                      .addMethod(getAdaptiveMtTranslateMethod())
                      .addMethod(getGetAdaptiveMtFileMethod())
                      .addMethod(getDeleteAdaptiveMtFileMethod())
                      .addMethod(getImportAdaptiveMtFileMethod())
                      .addMethod(getListAdaptiveMtFilesMethod())
                      .addMethod(getListAdaptiveMtSentencesMethod())
                      .addMethod(getImportDataMethod())
                      .addMethod(getExportDataMethod())
                      .addMethod(getListExamplesMethod())
                      .addMethod(getCreateModelMethod())
                      .addMethod(getListModelsMethod())
                      .addMethod(getGetModelMethod())
                      .addMethod(getDeleteModelMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
