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
package com.google.cloud.speech.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Enables speech transcription and resource management.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/speech/v2/cloud_speech.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SpeechGrpc {

  private SpeechGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.speech.v2.Speech";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.CreateRecognizerRequest, com.google.longrunning.Operation>
      getCreateRecognizerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRecognizer",
      requestType = com.google.cloud.speech.v2.CreateRecognizerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.CreateRecognizerRequest, com.google.longrunning.Operation>
      getCreateRecognizerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.CreateRecognizerRequest, com.google.longrunning.Operation>
        getCreateRecognizerMethod;
    if ((getCreateRecognizerMethod = SpeechGrpc.getCreateRecognizerMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getCreateRecognizerMethod = SpeechGrpc.getCreateRecognizerMethod) == null) {
          SpeechGrpc.getCreateRecognizerMethod =
              getCreateRecognizerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.CreateRecognizerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRecognizer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.CreateRecognizerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("CreateRecognizer"))
                      .build();
        }
      }
    }
    return getCreateRecognizerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.ListRecognizersRequest,
          com.google.cloud.speech.v2.ListRecognizersResponse>
      getListRecognizersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRecognizers",
      requestType = com.google.cloud.speech.v2.ListRecognizersRequest.class,
      responseType = com.google.cloud.speech.v2.ListRecognizersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.ListRecognizersRequest,
          com.google.cloud.speech.v2.ListRecognizersResponse>
      getListRecognizersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.ListRecognizersRequest,
            com.google.cloud.speech.v2.ListRecognizersResponse>
        getListRecognizersMethod;
    if ((getListRecognizersMethod = SpeechGrpc.getListRecognizersMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getListRecognizersMethod = SpeechGrpc.getListRecognizersMethod) == null) {
          SpeechGrpc.getListRecognizersMethod =
              getListRecognizersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.ListRecognizersRequest,
                          com.google.cloud.speech.v2.ListRecognizersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRecognizers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.ListRecognizersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.ListRecognizersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("ListRecognizers"))
                      .build();
        }
      }
    }
    return getListRecognizersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.GetRecognizerRequest, com.google.cloud.speech.v2.Recognizer>
      getGetRecognizerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecognizer",
      requestType = com.google.cloud.speech.v2.GetRecognizerRequest.class,
      responseType = com.google.cloud.speech.v2.Recognizer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.GetRecognizerRequest, com.google.cloud.speech.v2.Recognizer>
      getGetRecognizerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.GetRecognizerRequest, com.google.cloud.speech.v2.Recognizer>
        getGetRecognizerMethod;
    if ((getGetRecognizerMethod = SpeechGrpc.getGetRecognizerMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getGetRecognizerMethod = SpeechGrpc.getGetRecognizerMethod) == null) {
          SpeechGrpc.getGetRecognizerMethod =
              getGetRecognizerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.GetRecognizerRequest,
                          com.google.cloud.speech.v2.Recognizer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRecognizer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.GetRecognizerRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.Recognizer.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("GetRecognizer"))
                      .build();
        }
      }
    }
    return getGetRecognizerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UpdateRecognizerRequest, com.google.longrunning.Operation>
      getUpdateRecognizerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRecognizer",
      requestType = com.google.cloud.speech.v2.UpdateRecognizerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UpdateRecognizerRequest, com.google.longrunning.Operation>
      getUpdateRecognizerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.UpdateRecognizerRequest, com.google.longrunning.Operation>
        getUpdateRecognizerMethod;
    if ((getUpdateRecognizerMethod = SpeechGrpc.getUpdateRecognizerMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getUpdateRecognizerMethod = SpeechGrpc.getUpdateRecognizerMethod) == null) {
          SpeechGrpc.getUpdateRecognizerMethod =
              getUpdateRecognizerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.UpdateRecognizerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRecognizer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.UpdateRecognizerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("UpdateRecognizer"))
                      .build();
        }
      }
    }
    return getUpdateRecognizerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.DeleteRecognizerRequest, com.google.longrunning.Operation>
      getDeleteRecognizerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRecognizer",
      requestType = com.google.cloud.speech.v2.DeleteRecognizerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.DeleteRecognizerRequest, com.google.longrunning.Operation>
      getDeleteRecognizerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.DeleteRecognizerRequest, com.google.longrunning.Operation>
        getDeleteRecognizerMethod;
    if ((getDeleteRecognizerMethod = SpeechGrpc.getDeleteRecognizerMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getDeleteRecognizerMethod = SpeechGrpc.getDeleteRecognizerMethod) == null) {
          SpeechGrpc.getDeleteRecognizerMethod =
              getDeleteRecognizerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.DeleteRecognizerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRecognizer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.DeleteRecognizerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("DeleteRecognizer"))
                      .build();
        }
      }
    }
    return getDeleteRecognizerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UndeleteRecognizerRequest, com.google.longrunning.Operation>
      getUndeleteRecognizerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteRecognizer",
      requestType = com.google.cloud.speech.v2.UndeleteRecognizerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UndeleteRecognizerRequest, com.google.longrunning.Operation>
      getUndeleteRecognizerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.UndeleteRecognizerRequest, com.google.longrunning.Operation>
        getUndeleteRecognizerMethod;
    if ((getUndeleteRecognizerMethod = SpeechGrpc.getUndeleteRecognizerMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getUndeleteRecognizerMethod = SpeechGrpc.getUndeleteRecognizerMethod) == null) {
          SpeechGrpc.getUndeleteRecognizerMethod =
              getUndeleteRecognizerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.UndeleteRecognizerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeleteRecognizer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.UndeleteRecognizerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("UndeleteRecognizer"))
                      .build();
        }
      }
    }
    return getUndeleteRecognizerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.RecognizeRequest, com.google.cloud.speech.v2.RecognizeResponse>
      getRecognizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Recognize",
      requestType = com.google.cloud.speech.v2.RecognizeRequest.class,
      responseType = com.google.cloud.speech.v2.RecognizeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.RecognizeRequest, com.google.cloud.speech.v2.RecognizeResponse>
      getRecognizeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.RecognizeRequest,
            com.google.cloud.speech.v2.RecognizeResponse>
        getRecognizeMethod;
    if ((getRecognizeMethod = SpeechGrpc.getRecognizeMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getRecognizeMethod = SpeechGrpc.getRecognizeMethod) == null) {
          SpeechGrpc.getRecognizeMethod =
              getRecognizeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.RecognizeRequest,
                          com.google.cloud.speech.v2.RecognizeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Recognize"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.RecognizeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.RecognizeResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("Recognize"))
                      .build();
        }
      }
    }
    return getRecognizeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.StreamingRecognizeRequest,
          com.google.cloud.speech.v2.StreamingRecognizeResponse>
      getStreamingRecognizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingRecognize",
      requestType = com.google.cloud.speech.v2.StreamingRecognizeRequest.class,
      responseType = com.google.cloud.speech.v2.StreamingRecognizeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.StreamingRecognizeRequest,
          com.google.cloud.speech.v2.StreamingRecognizeResponse>
      getStreamingRecognizeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.StreamingRecognizeRequest,
            com.google.cloud.speech.v2.StreamingRecognizeResponse>
        getStreamingRecognizeMethod;
    if ((getStreamingRecognizeMethod = SpeechGrpc.getStreamingRecognizeMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getStreamingRecognizeMethod = SpeechGrpc.getStreamingRecognizeMethod) == null) {
          SpeechGrpc.getStreamingRecognizeMethod =
              getStreamingRecognizeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.StreamingRecognizeRequest,
                          com.google.cloud.speech.v2.StreamingRecognizeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamingRecognize"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.StreamingRecognizeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.StreamingRecognizeResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("StreamingRecognize"))
                      .build();
        }
      }
    }
    return getStreamingRecognizeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.BatchRecognizeRequest, com.google.longrunning.Operation>
      getBatchRecognizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchRecognize",
      requestType = com.google.cloud.speech.v2.BatchRecognizeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.BatchRecognizeRequest, com.google.longrunning.Operation>
      getBatchRecognizeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.BatchRecognizeRequest, com.google.longrunning.Operation>
        getBatchRecognizeMethod;
    if ((getBatchRecognizeMethod = SpeechGrpc.getBatchRecognizeMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getBatchRecognizeMethod = SpeechGrpc.getBatchRecognizeMethod) == null) {
          SpeechGrpc.getBatchRecognizeMethod =
              getBatchRecognizeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.BatchRecognizeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchRecognize"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.BatchRecognizeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("BatchRecognize"))
                      .build();
        }
      }
    }
    return getBatchRecognizeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.GetConfigRequest, com.google.cloud.speech.v2.Config>
      getGetConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConfig",
      requestType = com.google.cloud.speech.v2.GetConfigRequest.class,
      responseType = com.google.cloud.speech.v2.Config.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.GetConfigRequest, com.google.cloud.speech.v2.Config>
      getGetConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.GetConfigRequest, com.google.cloud.speech.v2.Config>
        getGetConfigMethod;
    if ((getGetConfigMethod = SpeechGrpc.getGetConfigMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getGetConfigMethod = SpeechGrpc.getGetConfigMethod) == null) {
          SpeechGrpc.getGetConfigMethod =
              getGetConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.GetConfigRequest,
                          com.google.cloud.speech.v2.Config>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.GetConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.Config.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("GetConfig"))
                      .build();
        }
      }
    }
    return getGetConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UpdateConfigRequest, com.google.cloud.speech.v2.Config>
      getUpdateConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConfig",
      requestType = com.google.cloud.speech.v2.UpdateConfigRequest.class,
      responseType = com.google.cloud.speech.v2.Config.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UpdateConfigRequest, com.google.cloud.speech.v2.Config>
      getUpdateConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.UpdateConfigRequest, com.google.cloud.speech.v2.Config>
        getUpdateConfigMethod;
    if ((getUpdateConfigMethod = SpeechGrpc.getUpdateConfigMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getUpdateConfigMethod = SpeechGrpc.getUpdateConfigMethod) == null) {
          SpeechGrpc.getUpdateConfigMethod =
              getUpdateConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.UpdateConfigRequest,
                          com.google.cloud.speech.v2.Config>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.UpdateConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.Config.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("UpdateConfig"))
                      .build();
        }
      }
    }
    return getUpdateConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.CreateCustomClassRequest, com.google.longrunning.Operation>
      getCreateCustomClassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCustomClass",
      requestType = com.google.cloud.speech.v2.CreateCustomClassRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.CreateCustomClassRequest, com.google.longrunning.Operation>
      getCreateCustomClassMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.CreateCustomClassRequest, com.google.longrunning.Operation>
        getCreateCustomClassMethod;
    if ((getCreateCustomClassMethod = SpeechGrpc.getCreateCustomClassMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getCreateCustomClassMethod = SpeechGrpc.getCreateCustomClassMethod) == null) {
          SpeechGrpc.getCreateCustomClassMethod =
              getCreateCustomClassMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.CreateCustomClassRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCustomClass"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.CreateCustomClassRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("CreateCustomClass"))
                      .build();
        }
      }
    }
    return getCreateCustomClassMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.ListCustomClassesRequest,
          com.google.cloud.speech.v2.ListCustomClassesResponse>
      getListCustomClassesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCustomClasses",
      requestType = com.google.cloud.speech.v2.ListCustomClassesRequest.class,
      responseType = com.google.cloud.speech.v2.ListCustomClassesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.ListCustomClassesRequest,
          com.google.cloud.speech.v2.ListCustomClassesResponse>
      getListCustomClassesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.ListCustomClassesRequest,
            com.google.cloud.speech.v2.ListCustomClassesResponse>
        getListCustomClassesMethod;
    if ((getListCustomClassesMethod = SpeechGrpc.getListCustomClassesMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getListCustomClassesMethod = SpeechGrpc.getListCustomClassesMethod) == null) {
          SpeechGrpc.getListCustomClassesMethod =
              getListCustomClassesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.ListCustomClassesRequest,
                          com.google.cloud.speech.v2.ListCustomClassesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCustomClasses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.ListCustomClassesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.ListCustomClassesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("ListCustomClasses"))
                      .build();
        }
      }
    }
    return getListCustomClassesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.GetCustomClassRequest, com.google.cloud.speech.v2.CustomClass>
      getGetCustomClassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomClass",
      requestType = com.google.cloud.speech.v2.GetCustomClassRequest.class,
      responseType = com.google.cloud.speech.v2.CustomClass.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.GetCustomClassRequest, com.google.cloud.speech.v2.CustomClass>
      getGetCustomClassMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.GetCustomClassRequest,
            com.google.cloud.speech.v2.CustomClass>
        getGetCustomClassMethod;
    if ((getGetCustomClassMethod = SpeechGrpc.getGetCustomClassMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getGetCustomClassMethod = SpeechGrpc.getGetCustomClassMethod) == null) {
          SpeechGrpc.getGetCustomClassMethod =
              getGetCustomClassMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.GetCustomClassRequest,
                          com.google.cloud.speech.v2.CustomClass>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomClass"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.GetCustomClassRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.CustomClass.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("GetCustomClass"))
                      .build();
        }
      }
    }
    return getGetCustomClassMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UpdateCustomClassRequest, com.google.longrunning.Operation>
      getUpdateCustomClassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCustomClass",
      requestType = com.google.cloud.speech.v2.UpdateCustomClassRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UpdateCustomClassRequest, com.google.longrunning.Operation>
      getUpdateCustomClassMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.UpdateCustomClassRequest, com.google.longrunning.Operation>
        getUpdateCustomClassMethod;
    if ((getUpdateCustomClassMethod = SpeechGrpc.getUpdateCustomClassMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getUpdateCustomClassMethod = SpeechGrpc.getUpdateCustomClassMethod) == null) {
          SpeechGrpc.getUpdateCustomClassMethod =
              getUpdateCustomClassMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.UpdateCustomClassRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCustomClass"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.UpdateCustomClassRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("UpdateCustomClass"))
                      .build();
        }
      }
    }
    return getUpdateCustomClassMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.DeleteCustomClassRequest, com.google.longrunning.Operation>
      getDeleteCustomClassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCustomClass",
      requestType = com.google.cloud.speech.v2.DeleteCustomClassRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.DeleteCustomClassRequest, com.google.longrunning.Operation>
      getDeleteCustomClassMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.DeleteCustomClassRequest, com.google.longrunning.Operation>
        getDeleteCustomClassMethod;
    if ((getDeleteCustomClassMethod = SpeechGrpc.getDeleteCustomClassMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getDeleteCustomClassMethod = SpeechGrpc.getDeleteCustomClassMethod) == null) {
          SpeechGrpc.getDeleteCustomClassMethod =
              getDeleteCustomClassMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.DeleteCustomClassRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCustomClass"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.DeleteCustomClassRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("DeleteCustomClass"))
                      .build();
        }
      }
    }
    return getDeleteCustomClassMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UndeleteCustomClassRequest, com.google.longrunning.Operation>
      getUndeleteCustomClassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteCustomClass",
      requestType = com.google.cloud.speech.v2.UndeleteCustomClassRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UndeleteCustomClassRequest, com.google.longrunning.Operation>
      getUndeleteCustomClassMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.UndeleteCustomClassRequest, com.google.longrunning.Operation>
        getUndeleteCustomClassMethod;
    if ((getUndeleteCustomClassMethod = SpeechGrpc.getUndeleteCustomClassMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getUndeleteCustomClassMethod = SpeechGrpc.getUndeleteCustomClassMethod) == null) {
          SpeechGrpc.getUndeleteCustomClassMethod =
              getUndeleteCustomClassMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.UndeleteCustomClassRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UndeleteCustomClass"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.UndeleteCustomClassRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SpeechMethodDescriptorSupplier("UndeleteCustomClass"))
                      .build();
        }
      }
    }
    return getUndeleteCustomClassMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.CreatePhraseSetRequest, com.google.longrunning.Operation>
      getCreatePhraseSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePhraseSet",
      requestType = com.google.cloud.speech.v2.CreatePhraseSetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.CreatePhraseSetRequest, com.google.longrunning.Operation>
      getCreatePhraseSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.CreatePhraseSetRequest, com.google.longrunning.Operation>
        getCreatePhraseSetMethod;
    if ((getCreatePhraseSetMethod = SpeechGrpc.getCreatePhraseSetMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getCreatePhraseSetMethod = SpeechGrpc.getCreatePhraseSetMethod) == null) {
          SpeechGrpc.getCreatePhraseSetMethod =
              getCreatePhraseSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.CreatePhraseSetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePhraseSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.CreatePhraseSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("CreatePhraseSet"))
                      .build();
        }
      }
    }
    return getCreatePhraseSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.ListPhraseSetsRequest,
          com.google.cloud.speech.v2.ListPhraseSetsResponse>
      getListPhraseSetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPhraseSets",
      requestType = com.google.cloud.speech.v2.ListPhraseSetsRequest.class,
      responseType = com.google.cloud.speech.v2.ListPhraseSetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.ListPhraseSetsRequest,
          com.google.cloud.speech.v2.ListPhraseSetsResponse>
      getListPhraseSetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.ListPhraseSetsRequest,
            com.google.cloud.speech.v2.ListPhraseSetsResponse>
        getListPhraseSetsMethod;
    if ((getListPhraseSetsMethod = SpeechGrpc.getListPhraseSetsMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getListPhraseSetsMethod = SpeechGrpc.getListPhraseSetsMethod) == null) {
          SpeechGrpc.getListPhraseSetsMethod =
              getListPhraseSetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.ListPhraseSetsRequest,
                          com.google.cloud.speech.v2.ListPhraseSetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPhraseSets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.ListPhraseSetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.ListPhraseSetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("ListPhraseSets"))
                      .build();
        }
      }
    }
    return getListPhraseSetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.GetPhraseSetRequest, com.google.cloud.speech.v2.PhraseSet>
      getGetPhraseSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPhraseSet",
      requestType = com.google.cloud.speech.v2.GetPhraseSetRequest.class,
      responseType = com.google.cloud.speech.v2.PhraseSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.GetPhraseSetRequest, com.google.cloud.speech.v2.PhraseSet>
      getGetPhraseSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.GetPhraseSetRequest, com.google.cloud.speech.v2.PhraseSet>
        getGetPhraseSetMethod;
    if ((getGetPhraseSetMethod = SpeechGrpc.getGetPhraseSetMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getGetPhraseSetMethod = SpeechGrpc.getGetPhraseSetMethod) == null) {
          SpeechGrpc.getGetPhraseSetMethod =
              getGetPhraseSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.GetPhraseSetRequest,
                          com.google.cloud.speech.v2.PhraseSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPhraseSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.GetPhraseSetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.PhraseSet.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("GetPhraseSet"))
                      .build();
        }
      }
    }
    return getGetPhraseSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UpdatePhraseSetRequest, com.google.longrunning.Operation>
      getUpdatePhraseSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePhraseSet",
      requestType = com.google.cloud.speech.v2.UpdatePhraseSetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UpdatePhraseSetRequest, com.google.longrunning.Operation>
      getUpdatePhraseSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.UpdatePhraseSetRequest, com.google.longrunning.Operation>
        getUpdatePhraseSetMethod;
    if ((getUpdatePhraseSetMethod = SpeechGrpc.getUpdatePhraseSetMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getUpdatePhraseSetMethod = SpeechGrpc.getUpdatePhraseSetMethod) == null) {
          SpeechGrpc.getUpdatePhraseSetMethod =
              getUpdatePhraseSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.UpdatePhraseSetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePhraseSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.UpdatePhraseSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("UpdatePhraseSet"))
                      .build();
        }
      }
    }
    return getUpdatePhraseSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.DeletePhraseSetRequest, com.google.longrunning.Operation>
      getDeletePhraseSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePhraseSet",
      requestType = com.google.cloud.speech.v2.DeletePhraseSetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.DeletePhraseSetRequest, com.google.longrunning.Operation>
      getDeletePhraseSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.DeletePhraseSetRequest, com.google.longrunning.Operation>
        getDeletePhraseSetMethod;
    if ((getDeletePhraseSetMethod = SpeechGrpc.getDeletePhraseSetMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getDeletePhraseSetMethod = SpeechGrpc.getDeletePhraseSetMethod) == null) {
          SpeechGrpc.getDeletePhraseSetMethod =
              getDeletePhraseSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.DeletePhraseSetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePhraseSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.DeletePhraseSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("DeletePhraseSet"))
                      .build();
        }
      }
    }
    return getDeletePhraseSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UndeletePhraseSetRequest, com.google.longrunning.Operation>
      getUndeletePhraseSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeletePhraseSet",
      requestType = com.google.cloud.speech.v2.UndeletePhraseSetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v2.UndeletePhraseSetRequest, com.google.longrunning.Operation>
      getUndeletePhraseSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v2.UndeletePhraseSetRequest, com.google.longrunning.Operation>
        getUndeletePhraseSetMethod;
    if ((getUndeletePhraseSetMethod = SpeechGrpc.getUndeletePhraseSetMethod) == null) {
      synchronized (SpeechGrpc.class) {
        if ((getUndeletePhraseSetMethod = SpeechGrpc.getUndeletePhraseSetMethod) == null) {
          SpeechGrpc.getUndeletePhraseSetMethod =
              getUndeletePhraseSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v2.UndeletePhraseSetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeletePhraseSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v2.UndeletePhraseSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SpeechMethodDescriptorSupplier("UndeletePhraseSet"))
                      .build();
        }
      }
    }
    return getUndeletePhraseSetMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SpeechStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpeechStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpeechStub>() {
          @java.lang.Override
          public SpeechStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpeechStub(channel, callOptions);
          }
        };
    return SpeechStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SpeechBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpeechBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpeechBlockingStub>() {
          @java.lang.Override
          public SpeechBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpeechBlockingStub(channel, callOptions);
          }
        };
    return SpeechBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SpeechFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpeechFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpeechFutureStub>() {
          @java.lang.Override
          public SpeechFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpeechFutureStub(channel, callOptions);
          }
        };
    return SpeechFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Enables speech transcription and resource management.
   * </pre>
   */
  public abstract static class SpeechImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public void createRecognizer(
        com.google.cloud.speech.v2.CreateRecognizerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRecognizerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Recognizers.
     * </pre>
     */
    public void listRecognizers(
        com.google.cloud.speech.v2.ListRecognizersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.ListRecognizersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRecognizersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [Recognizer][google.cloud.speech.v2.Recognizer]. Fails with
     * [NOT_FOUND][google.rpc.Code.NOT_FOUND] if the requested recognizer doesn't
     * exist.
     * </pre>
     */
    public void getRecognizer(
        com.google.cloud.speech.v2.GetRecognizerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.Recognizer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRecognizerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public void updateRecognizer(
        com.google.cloud.speech.v2.UpdateRecognizerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRecognizerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public void deleteRecognizer(
        com.google.cloud.speech.v2.DeleteRecognizerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRecognizerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeletes the [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public void undeleteRecognizer(
        com.google.cloud.speech.v2.UndeleteRecognizerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeleteRecognizerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs synchronous Speech recognition: receive results after all audio
     * has been sent and processed.
     * </pre>
     */
    public void recognize(
        com.google.cloud.speech.v2.RecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.RecognizeResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRecognizeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs bidirectional streaming speech recognition: receive results while
     * sending audio. This method is only available via the gRPC API (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.StreamingRecognizeRequest>
        streamingRecognize(
            io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.StreamingRecognizeResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getStreamingRecognizeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs batch asynchronous speech recognition: send a request with N
     * audio files and receive a long running operation that can be polled to see
     * when the transcriptions are finished.
     * </pre>
     */
    public void batchRecognize(
        com.google.cloud.speech.v2.BatchRecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchRecognizeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested [Config][google.cloud.speech.v2.Config].
     * </pre>
     */
    public void getConfig(
        com.google.cloud.speech.v2.GetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.Config> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the [Config][google.cloud.speech.v2.Config].
     * </pre>
     */
    public void updateConfig(
        com.google.cloud.speech.v2.UpdateConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.Config> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public void createCustomClass(
        com.google.cloud.speech.v2.CreateCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCustomClassMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomClasses.
     * </pre>
     */
    public void listCustomClasses(
        com.google.cloud.speech.v2.ListCustomClassesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.ListCustomClassesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCustomClassesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public void getCustomClass(
        com.google.cloud.speech.v2.GetCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.CustomClass> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCustomClassMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public void updateCustomClass(
        com.google.cloud.speech.v2.UpdateCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCustomClassMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public void deleteCustomClass(
        com.google.cloud.speech.v2.DeleteCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCustomClassMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeletes the [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public void undeleteCustomClass(
        com.google.cloud.speech.v2.UndeleteCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeleteCustomClassMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public void createPhraseSet(
        com.google.cloud.speech.v2.CreatePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePhraseSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists PhraseSets.
     * </pre>
     */
    public void listPhraseSets(
        com.google.cloud.speech.v2.ListPhraseSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.ListPhraseSetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPhraseSetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public void getPhraseSet(
        com.google.cloud.speech.v2.GetPhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.PhraseSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPhraseSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public void updatePhraseSet(
        com.google.cloud.speech.v2.UpdatePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePhraseSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public void deletePhraseSet(
        com.google.cloud.speech.v2.DeletePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePhraseSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public void undeletePhraseSet(
        com.google.cloud.speech.v2.UndeletePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeletePhraseSetMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateRecognizerMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.CreateRecognizerRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_RECOGNIZER)))
          .addMethod(
              getListRecognizersMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.ListRecognizersRequest,
                      com.google.cloud.speech.v2.ListRecognizersResponse>(
                      this, METHODID_LIST_RECOGNIZERS)))
          .addMethod(
              getGetRecognizerMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.GetRecognizerRequest,
                      com.google.cloud.speech.v2.Recognizer>(this, METHODID_GET_RECOGNIZER)))
          .addMethod(
              getUpdateRecognizerMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.UpdateRecognizerRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_RECOGNIZER)))
          .addMethod(
              getDeleteRecognizerMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.DeleteRecognizerRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_RECOGNIZER)))
          .addMethod(
              getUndeleteRecognizerMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.UndeleteRecognizerRequest,
                      com.google.longrunning.Operation>(this, METHODID_UNDELETE_RECOGNIZER)))
          .addMethod(
              getRecognizeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.RecognizeRequest,
                      com.google.cloud.speech.v2.RecognizeResponse>(this, METHODID_RECOGNIZE)))
          .addMethod(
              getStreamingRecognizeMethod(),
              io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.StreamingRecognizeRequest,
                      com.google.cloud.speech.v2.StreamingRecognizeResponse>(
                      this, METHODID_STREAMING_RECOGNIZE)))
          .addMethod(
              getBatchRecognizeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.BatchRecognizeRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_RECOGNIZE)))
          .addMethod(
              getGetConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.GetConfigRequest,
                      com.google.cloud.speech.v2.Config>(this, METHODID_GET_CONFIG)))
          .addMethod(
              getUpdateConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.UpdateConfigRequest,
                      com.google.cloud.speech.v2.Config>(this, METHODID_UPDATE_CONFIG)))
          .addMethod(
              getCreateCustomClassMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.CreateCustomClassRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_CUSTOM_CLASS)))
          .addMethod(
              getListCustomClassesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.ListCustomClassesRequest,
                      com.google.cloud.speech.v2.ListCustomClassesResponse>(
                      this, METHODID_LIST_CUSTOM_CLASSES)))
          .addMethod(
              getGetCustomClassMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.GetCustomClassRequest,
                      com.google.cloud.speech.v2.CustomClass>(this, METHODID_GET_CUSTOM_CLASS)))
          .addMethod(
              getUpdateCustomClassMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.UpdateCustomClassRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_CUSTOM_CLASS)))
          .addMethod(
              getDeleteCustomClassMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.DeleteCustomClassRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_CUSTOM_CLASS)))
          .addMethod(
              getUndeleteCustomClassMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.UndeleteCustomClassRequest,
                      com.google.longrunning.Operation>(this, METHODID_UNDELETE_CUSTOM_CLASS)))
          .addMethod(
              getCreatePhraseSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.CreatePhraseSetRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_PHRASE_SET)))
          .addMethod(
              getListPhraseSetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.ListPhraseSetsRequest,
                      com.google.cloud.speech.v2.ListPhraseSetsResponse>(
                      this, METHODID_LIST_PHRASE_SETS)))
          .addMethod(
              getGetPhraseSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.GetPhraseSetRequest,
                      com.google.cloud.speech.v2.PhraseSet>(this, METHODID_GET_PHRASE_SET)))
          .addMethod(
              getUpdatePhraseSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.UpdatePhraseSetRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_PHRASE_SET)))
          .addMethod(
              getDeletePhraseSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.DeletePhraseSetRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_PHRASE_SET)))
          .addMethod(
              getUndeletePhraseSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v2.UndeletePhraseSetRequest,
                      com.google.longrunning.Operation>(this, METHODID_UNDELETE_PHRASE_SET)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Enables speech transcription and resource management.
   * </pre>
   */
  public static final class SpeechStub extends io.grpc.stub.AbstractAsyncStub<SpeechStub> {
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
     * Creates a [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public void createRecognizer(
        com.google.cloud.speech.v2.CreateRecognizerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRecognizerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Recognizers.
     * </pre>
     */
    public void listRecognizers(
        com.google.cloud.speech.v2.ListRecognizersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.ListRecognizersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRecognizersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [Recognizer][google.cloud.speech.v2.Recognizer]. Fails with
     * [NOT_FOUND][google.rpc.Code.NOT_FOUND] if the requested recognizer doesn't
     * exist.
     * </pre>
     */
    public void getRecognizer(
        com.google.cloud.speech.v2.GetRecognizerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.Recognizer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRecognizerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public void updateRecognizer(
        com.google.cloud.speech.v2.UpdateRecognizerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRecognizerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public void deleteRecognizer(
        com.google.cloud.speech.v2.DeleteRecognizerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRecognizerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeletes the [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public void undeleteRecognizer(
        com.google.cloud.speech.v2.UndeleteRecognizerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteRecognizerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs synchronous Speech recognition: receive results after all audio
     * has been sent and processed.
     * </pre>
     */
    public void recognize(
        com.google.cloud.speech.v2.RecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.RecognizeResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRecognizeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs bidirectional streaming speech recognition: receive results while
     * sending audio. This method is only available via the gRPC API (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.StreamingRecognizeRequest>
        streamingRecognize(
            io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.StreamingRecognizeResponse>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingRecognizeMethod(), getCallOptions()), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Performs batch asynchronous speech recognition: send a request with N
     * audio files and receive a long running operation that can be polled to see
     * when the transcriptions are finished.
     * </pre>
     */
    public void batchRecognize(
        com.google.cloud.speech.v2.BatchRecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchRecognizeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested [Config][google.cloud.speech.v2.Config].
     * </pre>
     */
    public void getConfig(
        com.google.cloud.speech.v2.GetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.Config> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the [Config][google.cloud.speech.v2.Config].
     * </pre>
     */
    public void updateConfig(
        com.google.cloud.speech.v2.UpdateConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.Config> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public void createCustomClass(
        com.google.cloud.speech.v2.CreateCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCustomClassMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomClasses.
     * </pre>
     */
    public void listCustomClasses(
        com.google.cloud.speech.v2.ListCustomClassesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.ListCustomClassesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCustomClassesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public void getCustomClass(
        com.google.cloud.speech.v2.GetCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.CustomClass> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCustomClassMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public void updateCustomClass(
        com.google.cloud.speech.v2.UpdateCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCustomClassMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public void deleteCustomClass(
        com.google.cloud.speech.v2.DeleteCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCustomClassMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeletes the [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public void undeleteCustomClass(
        com.google.cloud.speech.v2.UndeleteCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteCustomClassMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public void createPhraseSet(
        com.google.cloud.speech.v2.CreatePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePhraseSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists PhraseSets.
     * </pre>
     */
    public void listPhraseSets(
        com.google.cloud.speech.v2.ListPhraseSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.ListPhraseSetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPhraseSetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public void getPhraseSet(
        com.google.cloud.speech.v2.GetPhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.PhraseSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPhraseSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public void updatePhraseSet(
        com.google.cloud.speech.v2.UpdatePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePhraseSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public void deletePhraseSet(
        com.google.cloud.speech.v2.DeletePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePhraseSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public void undeletePhraseSet(
        com.google.cloud.speech.v2.UndeletePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeletePhraseSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Enables speech transcription and resource management.
   * </pre>
   */
  public static final class SpeechBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SpeechBlockingStub> {
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
     * Creates a [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public com.google.longrunning.Operation createRecognizer(
        com.google.cloud.speech.v2.CreateRecognizerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRecognizerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Recognizers.
     * </pre>
     */
    public com.google.cloud.speech.v2.ListRecognizersResponse listRecognizers(
        com.google.cloud.speech.v2.ListRecognizersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRecognizersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [Recognizer][google.cloud.speech.v2.Recognizer]. Fails with
     * [NOT_FOUND][google.rpc.Code.NOT_FOUND] if the requested recognizer doesn't
     * exist.
     * </pre>
     */
    public com.google.cloud.speech.v2.Recognizer getRecognizer(
        com.google.cloud.speech.v2.GetRecognizerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRecognizerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public com.google.longrunning.Operation updateRecognizer(
        com.google.cloud.speech.v2.UpdateRecognizerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRecognizerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public com.google.longrunning.Operation deleteRecognizer(
        com.google.cloud.speech.v2.DeleteRecognizerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRecognizerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes the [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public com.google.longrunning.Operation undeleteRecognizer(
        com.google.cloud.speech.v2.UndeleteRecognizerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteRecognizerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Performs synchronous Speech recognition: receive results after all audio
     * has been sent and processed.
     * </pre>
     */
    public com.google.cloud.speech.v2.RecognizeResponse recognize(
        com.google.cloud.speech.v2.RecognizeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRecognizeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Performs batch asynchronous speech recognition: send a request with N
     * audio files and receive a long running operation that can be polled to see
     * when the transcriptions are finished.
     * </pre>
     */
    public com.google.longrunning.Operation batchRecognize(
        com.google.cloud.speech.v2.BatchRecognizeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchRecognizeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested [Config][google.cloud.speech.v2.Config].
     * </pre>
     */
    public com.google.cloud.speech.v2.Config getConfig(
        com.google.cloud.speech.v2.GetConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the [Config][google.cloud.speech.v2.Config].
     * </pre>
     */
    public com.google.cloud.speech.v2.Config updateConfig(
        com.google.cloud.speech.v2.UpdateConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public com.google.longrunning.Operation createCustomClass(
        com.google.cloud.speech.v2.CreateCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCustomClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomClasses.
     * </pre>
     */
    public com.google.cloud.speech.v2.ListCustomClassesResponse listCustomClasses(
        com.google.cloud.speech.v2.ListCustomClassesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCustomClassesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public com.google.cloud.speech.v2.CustomClass getCustomClass(
        com.google.cloud.speech.v2.GetCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCustomClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public com.google.longrunning.Operation updateCustomClass(
        com.google.cloud.speech.v2.UpdateCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCustomClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public com.google.longrunning.Operation deleteCustomClass(
        com.google.cloud.speech.v2.DeleteCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCustomClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes the [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public com.google.longrunning.Operation undeleteCustomClass(
        com.google.cloud.speech.v2.UndeleteCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteCustomClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public com.google.longrunning.Operation createPhraseSet(
        com.google.cloud.speech.v2.CreatePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePhraseSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists PhraseSets.
     * </pre>
     */
    public com.google.cloud.speech.v2.ListPhraseSetsResponse listPhraseSets(
        com.google.cloud.speech.v2.ListPhraseSetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPhraseSetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public com.google.cloud.speech.v2.PhraseSet getPhraseSet(
        com.google.cloud.speech.v2.GetPhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPhraseSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public com.google.longrunning.Operation updatePhraseSet(
        com.google.cloud.speech.v2.UpdatePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePhraseSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public com.google.longrunning.Operation deletePhraseSet(
        com.google.cloud.speech.v2.DeletePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePhraseSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public com.google.longrunning.Operation undeletePhraseSet(
        com.google.cloud.speech.v2.UndeletePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeletePhraseSetMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Enables speech transcription and resource management.
   * </pre>
   */
  public static final class SpeechFutureStub
      extends io.grpc.stub.AbstractFutureStub<SpeechFutureStub> {
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
     * Creates a [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRecognizer(com.google.cloud.speech.v2.CreateRecognizerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRecognizerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Recognizers.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v2.ListRecognizersResponse>
        listRecognizers(com.google.cloud.speech.v2.ListRecognizersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRecognizersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [Recognizer][google.cloud.speech.v2.Recognizer]. Fails with
     * [NOT_FOUND][google.rpc.Code.NOT_FOUND] if the requested recognizer doesn't
     * exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.speech.v2.Recognizer>
        getRecognizer(com.google.cloud.speech.v2.GetRecognizerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRecognizerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateRecognizer(com.google.cloud.speech.v2.UpdateRecognizerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRecognizerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRecognizer(com.google.cloud.speech.v2.DeleteRecognizerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRecognizerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes the [Recognizer][google.cloud.speech.v2.Recognizer].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeleteRecognizer(com.google.cloud.speech.v2.UndeleteRecognizerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteRecognizerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Performs synchronous Speech recognition: receive results after all audio
     * has been sent and processed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v2.RecognizeResponse>
        recognize(com.google.cloud.speech.v2.RecognizeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRecognizeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Performs batch asynchronous speech recognition: send a request with N
     * audio files and receive a long running operation that can be polled to see
     * when the transcriptions are finished.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchRecognize(com.google.cloud.speech.v2.BatchRecognizeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchRecognizeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested [Config][google.cloud.speech.v2.Config].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.speech.v2.Config>
        getConfig(com.google.cloud.speech.v2.GetConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the [Config][google.cloud.speech.v2.Config].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.speech.v2.Config>
        updateConfig(com.google.cloud.speech.v2.UpdateConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCustomClass(com.google.cloud.speech.v2.CreateCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCustomClassMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CustomClasses.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v2.ListCustomClassesResponse>
        listCustomClasses(com.google.cloud.speech.v2.ListCustomClassesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCustomClassesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v2.CustomClass>
        getCustomClass(com.google.cloud.speech.v2.GetCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCustomClassMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCustomClass(com.google.cloud.speech.v2.UpdateCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCustomClassMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCustomClass(com.google.cloud.speech.v2.DeleteCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCustomClassMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes the [CustomClass][google.cloud.speech.v2.CustomClass].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeleteCustomClass(com.google.cloud.speech.v2.UndeleteCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteCustomClassMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPhraseSet(com.google.cloud.speech.v2.CreatePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePhraseSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists PhraseSets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v2.ListPhraseSetsResponse>
        listPhraseSets(com.google.cloud.speech.v2.ListPhraseSetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPhraseSetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.speech.v2.PhraseSet>
        getPhraseSet(com.google.cloud.speech.v2.GetPhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPhraseSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updatePhraseSet(com.google.cloud.speech.v2.UpdatePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePhraseSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePhraseSet(com.google.cloud.speech.v2.DeletePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePhraseSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes the [PhraseSet][google.cloud.speech.v2.PhraseSet].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeletePhraseSet(com.google.cloud.speech.v2.UndeletePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeletePhraseSetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RECOGNIZER = 0;
  private static final int METHODID_LIST_RECOGNIZERS = 1;
  private static final int METHODID_GET_RECOGNIZER = 2;
  private static final int METHODID_UPDATE_RECOGNIZER = 3;
  private static final int METHODID_DELETE_RECOGNIZER = 4;
  private static final int METHODID_UNDELETE_RECOGNIZER = 5;
  private static final int METHODID_RECOGNIZE = 6;
  private static final int METHODID_BATCH_RECOGNIZE = 7;
  private static final int METHODID_GET_CONFIG = 8;
  private static final int METHODID_UPDATE_CONFIG = 9;
  private static final int METHODID_CREATE_CUSTOM_CLASS = 10;
  private static final int METHODID_LIST_CUSTOM_CLASSES = 11;
  private static final int METHODID_GET_CUSTOM_CLASS = 12;
  private static final int METHODID_UPDATE_CUSTOM_CLASS = 13;
  private static final int METHODID_DELETE_CUSTOM_CLASS = 14;
  private static final int METHODID_UNDELETE_CUSTOM_CLASS = 15;
  private static final int METHODID_CREATE_PHRASE_SET = 16;
  private static final int METHODID_LIST_PHRASE_SETS = 17;
  private static final int METHODID_GET_PHRASE_SET = 18;
  private static final int METHODID_UPDATE_PHRASE_SET = 19;
  private static final int METHODID_DELETE_PHRASE_SET = 20;
  private static final int METHODID_UNDELETE_PHRASE_SET = 21;
  private static final int METHODID_STREAMING_RECOGNIZE = 22;

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
        case METHODID_CREATE_RECOGNIZER:
          serviceImpl.createRecognizer(
              (com.google.cloud.speech.v2.CreateRecognizerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_RECOGNIZERS:
          serviceImpl.listRecognizers(
              (com.google.cloud.speech.v2.ListRecognizersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.ListRecognizersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_RECOGNIZER:
          serviceImpl.getRecognizer(
              (com.google.cloud.speech.v2.GetRecognizerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.Recognizer>)
                  responseObserver);
          break;
        case METHODID_UPDATE_RECOGNIZER:
          serviceImpl.updateRecognizer(
              (com.google.cloud.speech.v2.UpdateRecognizerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_RECOGNIZER:
          serviceImpl.deleteRecognizer(
              (com.google.cloud.speech.v2.DeleteRecognizerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDELETE_RECOGNIZER:
          serviceImpl.undeleteRecognizer(
              (com.google.cloud.speech.v2.UndeleteRecognizerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RECOGNIZE:
          serviceImpl.recognize(
              (com.google.cloud.speech.v2.RecognizeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.RecognizeResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_RECOGNIZE:
          serviceImpl.batchRecognize(
              (com.google.cloud.speech.v2.BatchRecognizeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CONFIG:
          serviceImpl.getConfig(
              (com.google.cloud.speech.v2.GetConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.Config>) responseObserver);
          break;
        case METHODID_UPDATE_CONFIG:
          serviceImpl.updateConfig(
              (com.google.cloud.speech.v2.UpdateConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.Config>) responseObserver);
          break;
        case METHODID_CREATE_CUSTOM_CLASS:
          serviceImpl.createCustomClass(
              (com.google.cloud.speech.v2.CreateCustomClassRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CUSTOM_CLASSES:
          serviceImpl.listCustomClasses(
              (com.google.cloud.speech.v2.ListCustomClassesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.ListCustomClassesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CUSTOM_CLASS:
          serviceImpl.getCustomClass(
              (com.google.cloud.speech.v2.GetCustomClassRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.CustomClass>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CUSTOM_CLASS:
          serviceImpl.updateCustomClass(
              (com.google.cloud.speech.v2.UpdateCustomClassRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CUSTOM_CLASS:
          serviceImpl.deleteCustomClass(
              (com.google.cloud.speech.v2.DeleteCustomClassRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDELETE_CUSTOM_CLASS:
          serviceImpl.undeleteCustomClass(
              (com.google.cloud.speech.v2.UndeleteCustomClassRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_PHRASE_SET:
          serviceImpl.createPhraseSet(
              (com.google.cloud.speech.v2.CreatePhraseSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_PHRASE_SETS:
          serviceImpl.listPhraseSets(
              (com.google.cloud.speech.v2.ListPhraseSetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.ListPhraseSetsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PHRASE_SET:
          serviceImpl.getPhraseSet(
              (com.google.cloud.speech.v2.GetPhraseSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v2.PhraseSet>) responseObserver);
          break;
        case METHODID_UPDATE_PHRASE_SET:
          serviceImpl.updatePhraseSet(
              (com.google.cloud.speech.v2.UpdatePhraseSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_PHRASE_SET:
          serviceImpl.deletePhraseSet(
              (com.google.cloud.speech.v2.DeletePhraseSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDELETE_PHRASE_SET:
          serviceImpl.undeletePhraseSet(
              (com.google.cloud.speech.v2.UndeletePhraseSetRequest) request,
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
                          com.google.cloud.speech.v2.StreamingRecognizeResponse>)
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
      return com.google.cloud.speech.v2.CloudSpeechProto.getDescriptor();
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
                      .addMethod(getCreateRecognizerMethod())
                      .addMethod(getListRecognizersMethod())
                      .addMethod(getGetRecognizerMethod())
                      .addMethod(getUpdateRecognizerMethod())
                      .addMethod(getDeleteRecognizerMethod())
                      .addMethod(getUndeleteRecognizerMethod())
                      .addMethod(getRecognizeMethod())
                      .addMethod(getStreamingRecognizeMethod())
                      .addMethod(getBatchRecognizeMethod())
                      .addMethod(getGetConfigMethod())
                      .addMethod(getUpdateConfigMethod())
                      .addMethod(getCreateCustomClassMethod())
                      .addMethod(getListCustomClassesMethod())
                      .addMethod(getGetCustomClassMethod())
                      .addMethod(getUpdateCustomClassMethod())
                      .addMethod(getDeleteCustomClassMethod())
                      .addMethod(getUndeleteCustomClassMethod())
                      .addMethod(getCreatePhraseSetMethod())
                      .addMethod(getListPhraseSetsMethod())
                      .addMethod(getGetPhraseSetMethod())
                      .addMethod(getUpdatePhraseSetMethod())
                      .addMethod(getDeletePhraseSetMethod())
                      .addMethod(getUndeletePhraseSetMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
