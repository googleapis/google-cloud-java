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
package com.google.cloud.ces.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * EvaluationService exposes methods to perform evaluation for the CES app.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class EvaluationServiceGrpc {

  private EvaluationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.ces.v1beta.EvaluationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.RunEvaluationRequest, com.google.longrunning.Operation>
      getRunEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunEvaluation",
      requestType = com.google.cloud.ces.v1beta.RunEvaluationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.RunEvaluationRequest, com.google.longrunning.Operation>
      getRunEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.RunEvaluationRequest, com.google.longrunning.Operation>
        getRunEvaluationMethod;
    if ((getRunEvaluationMethod = EvaluationServiceGrpc.getRunEvaluationMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getRunEvaluationMethod = EvaluationServiceGrpc.getRunEvaluationMethod) == null) {
          EvaluationServiceGrpc.getRunEvaluationMethod =
              getRunEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.RunEvaluationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.RunEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("RunEvaluation"))
                      .build();
        }
      }
    }
    return getRunEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest,
          com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse>
      getUploadEvaluationAudioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadEvaluationAudio",
      requestType = com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest.class,
      responseType = com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest,
          com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse>
      getUploadEvaluationAudioMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest,
            com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse>
        getUploadEvaluationAudioMethod;
    if ((getUploadEvaluationAudioMethod = EvaluationServiceGrpc.getUploadEvaluationAudioMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getUploadEvaluationAudioMethod = EvaluationServiceGrpc.getUploadEvaluationAudioMethod)
            == null) {
          EvaluationServiceGrpc.getUploadEvaluationAudioMethod =
              getUploadEvaluationAudioMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest,
                          com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UploadEvaluationAudio"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("UploadEvaluationAudio"))
                      .build();
        }
      }
    }
    return getUploadEvaluationAudioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.CreateEvaluationRequest,
          com.google.cloud.ces.v1beta.Evaluation>
      getCreateEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEvaluation",
      requestType = com.google.cloud.ces.v1beta.CreateEvaluationRequest.class,
      responseType = com.google.cloud.ces.v1beta.Evaluation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.CreateEvaluationRequest,
          com.google.cloud.ces.v1beta.Evaluation>
      getCreateEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.CreateEvaluationRequest,
            com.google.cloud.ces.v1beta.Evaluation>
        getCreateEvaluationMethod;
    if ((getCreateEvaluationMethod = EvaluationServiceGrpc.getCreateEvaluationMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getCreateEvaluationMethod = EvaluationServiceGrpc.getCreateEvaluationMethod) == null) {
          EvaluationServiceGrpc.getCreateEvaluationMethod =
              getCreateEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.CreateEvaluationRequest,
                          com.google.cloud.ces.v1beta.Evaluation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.CreateEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.Evaluation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("CreateEvaluation"))
                      .build();
        }
      }
    }
    return getCreateEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GenerateEvaluationRequest, com.google.longrunning.Operation>
      getGenerateEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateEvaluation",
      requestType = com.google.cloud.ces.v1beta.GenerateEvaluationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GenerateEvaluationRequest, com.google.longrunning.Operation>
      getGenerateEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.GenerateEvaluationRequest, com.google.longrunning.Operation>
        getGenerateEvaluationMethod;
    if ((getGenerateEvaluationMethod = EvaluationServiceGrpc.getGenerateEvaluationMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getGenerateEvaluationMethod = EvaluationServiceGrpc.getGenerateEvaluationMethod)
            == null) {
          EvaluationServiceGrpc.getGenerateEvaluationMethod =
              getGenerateEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.GenerateEvaluationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.GenerateEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("GenerateEvaluation"))
                      .build();
        }
      }
    }
    return getGenerateEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ImportEvaluationsRequest, com.google.longrunning.Operation>
      getImportEvaluationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportEvaluations",
      requestType = com.google.cloud.ces.v1beta.ImportEvaluationsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ImportEvaluationsRequest, com.google.longrunning.Operation>
      getImportEvaluationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.ImportEvaluationsRequest, com.google.longrunning.Operation>
        getImportEvaluationsMethod;
    if ((getImportEvaluationsMethod = EvaluationServiceGrpc.getImportEvaluationsMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getImportEvaluationsMethod = EvaluationServiceGrpc.getImportEvaluationsMethod)
            == null) {
          EvaluationServiceGrpc.getImportEvaluationsMethod =
              getImportEvaluationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.ImportEvaluationsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportEvaluations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ImportEvaluationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("ImportEvaluations"))
                      .build();
        }
      }
    }
    return getImportEvaluationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest,
          com.google.cloud.ces.v1beta.EvaluationDataset>
      getCreateEvaluationDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEvaluationDataset",
      requestType = com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest.class,
      responseType = com.google.cloud.ces.v1beta.EvaluationDataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest,
          com.google.cloud.ces.v1beta.EvaluationDataset>
      getCreateEvaluationDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest,
            com.google.cloud.ces.v1beta.EvaluationDataset>
        getCreateEvaluationDatasetMethod;
    if ((getCreateEvaluationDatasetMethod = EvaluationServiceGrpc.getCreateEvaluationDatasetMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getCreateEvaluationDatasetMethod =
                EvaluationServiceGrpc.getCreateEvaluationDatasetMethod)
            == null) {
          EvaluationServiceGrpc.getCreateEvaluationDatasetMethod =
              getCreateEvaluationDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest,
                          com.google.cloud.ces.v1beta.EvaluationDataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateEvaluationDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.EvaluationDataset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("CreateEvaluationDataset"))
                      .build();
        }
      }
    }
    return getCreateEvaluationDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.UpdateEvaluationRequest,
          com.google.cloud.ces.v1beta.Evaluation>
      getUpdateEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEvaluation",
      requestType = com.google.cloud.ces.v1beta.UpdateEvaluationRequest.class,
      responseType = com.google.cloud.ces.v1beta.Evaluation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.UpdateEvaluationRequest,
          com.google.cloud.ces.v1beta.Evaluation>
      getUpdateEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.UpdateEvaluationRequest,
            com.google.cloud.ces.v1beta.Evaluation>
        getUpdateEvaluationMethod;
    if ((getUpdateEvaluationMethod = EvaluationServiceGrpc.getUpdateEvaluationMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getUpdateEvaluationMethod = EvaluationServiceGrpc.getUpdateEvaluationMethod) == null) {
          EvaluationServiceGrpc.getUpdateEvaluationMethod =
              getUpdateEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.UpdateEvaluationRequest,
                          com.google.cloud.ces.v1beta.Evaluation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.UpdateEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.Evaluation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("UpdateEvaluation"))
                      .build();
        }
      }
    }
    return getUpdateEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest,
          com.google.cloud.ces.v1beta.EvaluationDataset>
      getUpdateEvaluationDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEvaluationDataset",
      requestType = com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest.class,
      responseType = com.google.cloud.ces.v1beta.EvaluationDataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest,
          com.google.cloud.ces.v1beta.EvaluationDataset>
      getUpdateEvaluationDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest,
            com.google.cloud.ces.v1beta.EvaluationDataset>
        getUpdateEvaluationDatasetMethod;
    if ((getUpdateEvaluationDatasetMethod = EvaluationServiceGrpc.getUpdateEvaluationDatasetMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getUpdateEvaluationDatasetMethod =
                EvaluationServiceGrpc.getUpdateEvaluationDatasetMethod)
            == null) {
          EvaluationServiceGrpc.getUpdateEvaluationDatasetMethod =
              getUpdateEvaluationDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest,
                          com.google.cloud.ces.v1beta.EvaluationDataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateEvaluationDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.EvaluationDataset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("UpdateEvaluationDataset"))
                      .build();
        }
      }
    }
    return getUpdateEvaluationDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteEvaluationRequest, com.google.protobuf.Empty>
      getDeleteEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEvaluation",
      requestType = com.google.cloud.ces.v1beta.DeleteEvaluationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteEvaluationRequest, com.google.protobuf.Empty>
      getDeleteEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.DeleteEvaluationRequest, com.google.protobuf.Empty>
        getDeleteEvaluationMethod;
    if ((getDeleteEvaluationMethod = EvaluationServiceGrpc.getDeleteEvaluationMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getDeleteEvaluationMethod = EvaluationServiceGrpc.getDeleteEvaluationMethod) == null) {
          EvaluationServiceGrpc.getDeleteEvaluationMethod =
              getDeleteEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.DeleteEvaluationRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.DeleteEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("DeleteEvaluation"))
                      .build();
        }
      }
    }
    return getDeleteEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest, com.google.protobuf.Empty>
      getDeleteEvaluationResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEvaluationResult",
      requestType = com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest, com.google.protobuf.Empty>
      getDeleteEvaluationResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest, com.google.protobuf.Empty>
        getDeleteEvaluationResultMethod;
    if ((getDeleteEvaluationResultMethod = EvaluationServiceGrpc.getDeleteEvaluationResultMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getDeleteEvaluationResultMethod =
                EvaluationServiceGrpc.getDeleteEvaluationResultMethod)
            == null) {
          EvaluationServiceGrpc.getDeleteEvaluationResultMethod =
              getDeleteEvaluationResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteEvaluationResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("DeleteEvaluationResult"))
                      .build();
        }
      }
    }
    return getDeleteEvaluationResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest, com.google.protobuf.Empty>
      getDeleteEvaluationDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEvaluationDataset",
      requestType = com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest, com.google.protobuf.Empty>
      getDeleteEvaluationDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest, com.google.protobuf.Empty>
        getDeleteEvaluationDatasetMethod;
    if ((getDeleteEvaluationDatasetMethod = EvaluationServiceGrpc.getDeleteEvaluationDatasetMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getDeleteEvaluationDatasetMethod =
                EvaluationServiceGrpc.getDeleteEvaluationDatasetMethod)
            == null) {
          EvaluationServiceGrpc.getDeleteEvaluationDatasetMethod =
              getDeleteEvaluationDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteEvaluationDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("DeleteEvaluationDataset"))
                      .build();
        }
      }
    }
    return getDeleteEvaluationDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest, com.google.longrunning.Operation>
      getDeleteEvaluationRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEvaluationRun",
      requestType = com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest, com.google.longrunning.Operation>
      getDeleteEvaluationRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest,
            com.google.longrunning.Operation>
        getDeleteEvaluationRunMethod;
    if ((getDeleteEvaluationRunMethod = EvaluationServiceGrpc.getDeleteEvaluationRunMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getDeleteEvaluationRunMethod = EvaluationServiceGrpc.getDeleteEvaluationRunMethod)
            == null) {
          EvaluationServiceGrpc.getDeleteEvaluationRunMethod =
              getDeleteEvaluationRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteEvaluationRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("DeleteEvaluationRun"))
                      .build();
        }
      }
    }
    return getDeleteEvaluationRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetEvaluationRequest, com.google.cloud.ces.v1beta.Evaluation>
      getGetEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEvaluation",
      requestType = com.google.cloud.ces.v1beta.GetEvaluationRequest.class,
      responseType = com.google.cloud.ces.v1beta.Evaluation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetEvaluationRequest, com.google.cloud.ces.v1beta.Evaluation>
      getGetEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.GetEvaluationRequest,
            com.google.cloud.ces.v1beta.Evaluation>
        getGetEvaluationMethod;
    if ((getGetEvaluationMethod = EvaluationServiceGrpc.getGetEvaluationMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getGetEvaluationMethod = EvaluationServiceGrpc.getGetEvaluationMethod) == null) {
          EvaluationServiceGrpc.getGetEvaluationMethod =
              getGetEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.GetEvaluationRequest,
                          com.google.cloud.ces.v1beta.Evaluation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.GetEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.Evaluation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("GetEvaluation"))
                      .build();
        }
      }
    }
    return getGetEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetEvaluationResultRequest,
          com.google.cloud.ces.v1beta.EvaluationResult>
      getGetEvaluationResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEvaluationResult",
      requestType = com.google.cloud.ces.v1beta.GetEvaluationResultRequest.class,
      responseType = com.google.cloud.ces.v1beta.EvaluationResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetEvaluationResultRequest,
          com.google.cloud.ces.v1beta.EvaluationResult>
      getGetEvaluationResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.GetEvaluationResultRequest,
            com.google.cloud.ces.v1beta.EvaluationResult>
        getGetEvaluationResultMethod;
    if ((getGetEvaluationResultMethod = EvaluationServiceGrpc.getGetEvaluationResultMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getGetEvaluationResultMethod = EvaluationServiceGrpc.getGetEvaluationResultMethod)
            == null) {
          EvaluationServiceGrpc.getGetEvaluationResultMethod =
              getGetEvaluationResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.GetEvaluationResultRequest,
                          com.google.cloud.ces.v1beta.EvaluationResult>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetEvaluationResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.GetEvaluationResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.EvaluationResult.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("GetEvaluationResult"))
                      .build();
        }
      }
    }
    return getGetEvaluationResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest,
          com.google.cloud.ces.v1beta.EvaluationDataset>
      getGetEvaluationDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEvaluationDataset",
      requestType = com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest.class,
      responseType = com.google.cloud.ces.v1beta.EvaluationDataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest,
          com.google.cloud.ces.v1beta.EvaluationDataset>
      getGetEvaluationDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest,
            com.google.cloud.ces.v1beta.EvaluationDataset>
        getGetEvaluationDatasetMethod;
    if ((getGetEvaluationDatasetMethod = EvaluationServiceGrpc.getGetEvaluationDatasetMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getGetEvaluationDatasetMethod = EvaluationServiceGrpc.getGetEvaluationDatasetMethod)
            == null) {
          EvaluationServiceGrpc.getGetEvaluationDatasetMethod =
              getGetEvaluationDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest,
                          com.google.cloud.ces.v1beta.EvaluationDataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetEvaluationDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.EvaluationDataset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("GetEvaluationDataset"))
                      .build();
        }
      }
    }
    return getGetEvaluationDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetEvaluationRunRequest,
          com.google.cloud.ces.v1beta.EvaluationRun>
      getGetEvaluationRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEvaluationRun",
      requestType = com.google.cloud.ces.v1beta.GetEvaluationRunRequest.class,
      responseType = com.google.cloud.ces.v1beta.EvaluationRun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetEvaluationRunRequest,
          com.google.cloud.ces.v1beta.EvaluationRun>
      getGetEvaluationRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.GetEvaluationRunRequest,
            com.google.cloud.ces.v1beta.EvaluationRun>
        getGetEvaluationRunMethod;
    if ((getGetEvaluationRunMethod = EvaluationServiceGrpc.getGetEvaluationRunMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getGetEvaluationRunMethod = EvaluationServiceGrpc.getGetEvaluationRunMethod) == null) {
          EvaluationServiceGrpc.getGetEvaluationRunMethod =
              getGetEvaluationRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.GetEvaluationRunRequest,
                          com.google.cloud.ces.v1beta.EvaluationRun>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEvaluationRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.GetEvaluationRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.EvaluationRun.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("GetEvaluationRun"))
                      .build();
        }
      }
    }
    return getGetEvaluationRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListEvaluationsRequest,
          com.google.cloud.ces.v1beta.ListEvaluationsResponse>
      getListEvaluationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvaluations",
      requestType = com.google.cloud.ces.v1beta.ListEvaluationsRequest.class,
      responseType = com.google.cloud.ces.v1beta.ListEvaluationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListEvaluationsRequest,
          com.google.cloud.ces.v1beta.ListEvaluationsResponse>
      getListEvaluationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.ListEvaluationsRequest,
            com.google.cloud.ces.v1beta.ListEvaluationsResponse>
        getListEvaluationsMethod;
    if ((getListEvaluationsMethod = EvaluationServiceGrpc.getListEvaluationsMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getListEvaluationsMethod = EvaluationServiceGrpc.getListEvaluationsMethod) == null) {
          EvaluationServiceGrpc.getListEvaluationsMethod =
              getListEvaluationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.ListEvaluationsRequest,
                          com.google.cloud.ces.v1beta.ListEvaluationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEvaluations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListEvaluationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListEvaluationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("ListEvaluations"))
                      .build();
        }
      }
    }
    return getListEvaluationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListEvaluationResultsRequest,
          com.google.cloud.ces.v1beta.ListEvaluationResultsResponse>
      getListEvaluationResultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvaluationResults",
      requestType = com.google.cloud.ces.v1beta.ListEvaluationResultsRequest.class,
      responseType = com.google.cloud.ces.v1beta.ListEvaluationResultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListEvaluationResultsRequest,
          com.google.cloud.ces.v1beta.ListEvaluationResultsResponse>
      getListEvaluationResultsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.ListEvaluationResultsRequest,
            com.google.cloud.ces.v1beta.ListEvaluationResultsResponse>
        getListEvaluationResultsMethod;
    if ((getListEvaluationResultsMethod = EvaluationServiceGrpc.getListEvaluationResultsMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getListEvaluationResultsMethod = EvaluationServiceGrpc.getListEvaluationResultsMethod)
            == null) {
          EvaluationServiceGrpc.getListEvaluationResultsMethod =
              getListEvaluationResultsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.ListEvaluationResultsRequest,
                          com.google.cloud.ces.v1beta.ListEvaluationResultsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListEvaluationResults"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListEvaluationResultsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListEvaluationResultsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("ListEvaluationResults"))
                      .build();
        }
      }
    }
    return getListEvaluationResultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest,
          com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse>
      getListEvaluationDatasetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvaluationDatasets",
      requestType = com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest.class,
      responseType = com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest,
          com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse>
      getListEvaluationDatasetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest,
            com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse>
        getListEvaluationDatasetsMethod;
    if ((getListEvaluationDatasetsMethod = EvaluationServiceGrpc.getListEvaluationDatasetsMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getListEvaluationDatasetsMethod =
                EvaluationServiceGrpc.getListEvaluationDatasetsMethod)
            == null) {
          EvaluationServiceGrpc.getListEvaluationDatasetsMethod =
              getListEvaluationDatasetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest,
                          com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListEvaluationDatasets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("ListEvaluationDatasets"))
                      .build();
        }
      }
    }
    return getListEvaluationDatasetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListEvaluationRunsRequest,
          com.google.cloud.ces.v1beta.ListEvaluationRunsResponse>
      getListEvaluationRunsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvaluationRuns",
      requestType = com.google.cloud.ces.v1beta.ListEvaluationRunsRequest.class,
      responseType = com.google.cloud.ces.v1beta.ListEvaluationRunsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListEvaluationRunsRequest,
          com.google.cloud.ces.v1beta.ListEvaluationRunsResponse>
      getListEvaluationRunsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.ListEvaluationRunsRequest,
            com.google.cloud.ces.v1beta.ListEvaluationRunsResponse>
        getListEvaluationRunsMethod;
    if ((getListEvaluationRunsMethod = EvaluationServiceGrpc.getListEvaluationRunsMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getListEvaluationRunsMethod = EvaluationServiceGrpc.getListEvaluationRunsMethod)
            == null) {
          EvaluationServiceGrpc.getListEvaluationRunsMethod =
              getListEvaluationRunsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.ListEvaluationRunsRequest,
                          com.google.cloud.ces.v1beta.ListEvaluationRunsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEvaluationRuns"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListEvaluationRunsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListEvaluationRunsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("ListEvaluationRuns"))
                      .build();
        }
      }
    }
    return getListEvaluationRunsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest,
          com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse>
      getListEvaluationExpectationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvaluationExpectations",
      requestType = com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest.class,
      responseType = com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest,
          com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse>
      getListEvaluationExpectationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest,
            com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse>
        getListEvaluationExpectationsMethod;
    if ((getListEvaluationExpectationsMethod =
            EvaluationServiceGrpc.getListEvaluationExpectationsMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getListEvaluationExpectationsMethod =
                EvaluationServiceGrpc.getListEvaluationExpectationsMethod)
            == null) {
          EvaluationServiceGrpc.getListEvaluationExpectationsMethod =
              getListEvaluationExpectationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest,
                          com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListEvaluationExpectations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier(
                              "ListEvaluationExpectations"))
                      .build();
        }
      }
    }
    return getListEvaluationExpectationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest,
          com.google.cloud.ces.v1beta.EvaluationExpectation>
      getGetEvaluationExpectationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEvaluationExpectation",
      requestType = com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest.class,
      responseType = com.google.cloud.ces.v1beta.EvaluationExpectation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest,
          com.google.cloud.ces.v1beta.EvaluationExpectation>
      getGetEvaluationExpectationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest,
            com.google.cloud.ces.v1beta.EvaluationExpectation>
        getGetEvaluationExpectationMethod;
    if ((getGetEvaluationExpectationMethod =
            EvaluationServiceGrpc.getGetEvaluationExpectationMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getGetEvaluationExpectationMethod =
                EvaluationServiceGrpc.getGetEvaluationExpectationMethod)
            == null) {
          EvaluationServiceGrpc.getGetEvaluationExpectationMethod =
              getGetEvaluationExpectationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest,
                          com.google.cloud.ces.v1beta.EvaluationExpectation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetEvaluationExpectation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.EvaluationExpectation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("GetEvaluationExpectation"))
                      .build();
        }
      }
    }
    return getGetEvaluationExpectationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest,
          com.google.cloud.ces.v1beta.EvaluationExpectation>
      getCreateEvaluationExpectationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEvaluationExpectation",
      requestType = com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest.class,
      responseType = com.google.cloud.ces.v1beta.EvaluationExpectation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest,
          com.google.cloud.ces.v1beta.EvaluationExpectation>
      getCreateEvaluationExpectationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest,
            com.google.cloud.ces.v1beta.EvaluationExpectation>
        getCreateEvaluationExpectationMethod;
    if ((getCreateEvaluationExpectationMethod =
            EvaluationServiceGrpc.getCreateEvaluationExpectationMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getCreateEvaluationExpectationMethod =
                EvaluationServiceGrpc.getCreateEvaluationExpectationMethod)
            == null) {
          EvaluationServiceGrpc.getCreateEvaluationExpectationMethod =
              getCreateEvaluationExpectationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest,
                          com.google.cloud.ces.v1beta.EvaluationExpectation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateEvaluationExpectation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.EvaluationExpectation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier(
                              "CreateEvaluationExpectation"))
                      .build();
        }
      }
    }
    return getCreateEvaluationExpectationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest,
          com.google.cloud.ces.v1beta.EvaluationExpectation>
      getUpdateEvaluationExpectationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEvaluationExpectation",
      requestType = com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest.class,
      responseType = com.google.cloud.ces.v1beta.EvaluationExpectation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest,
          com.google.cloud.ces.v1beta.EvaluationExpectation>
      getUpdateEvaluationExpectationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest,
            com.google.cloud.ces.v1beta.EvaluationExpectation>
        getUpdateEvaluationExpectationMethod;
    if ((getUpdateEvaluationExpectationMethod =
            EvaluationServiceGrpc.getUpdateEvaluationExpectationMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getUpdateEvaluationExpectationMethod =
                EvaluationServiceGrpc.getUpdateEvaluationExpectationMethod)
            == null) {
          EvaluationServiceGrpc.getUpdateEvaluationExpectationMethod =
              getUpdateEvaluationExpectationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest,
                          com.google.cloud.ces.v1beta.EvaluationExpectation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateEvaluationExpectation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.EvaluationExpectation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier(
                              "UpdateEvaluationExpectation"))
                      .build();
        }
      }
    }
    return getUpdateEvaluationExpectationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest, com.google.protobuf.Empty>
      getDeleteEvaluationExpectationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEvaluationExpectation",
      requestType = com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest, com.google.protobuf.Empty>
      getDeleteEvaluationExpectationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest,
            com.google.protobuf.Empty>
        getDeleteEvaluationExpectationMethod;
    if ((getDeleteEvaluationExpectationMethod =
            EvaluationServiceGrpc.getDeleteEvaluationExpectationMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getDeleteEvaluationExpectationMethod =
                EvaluationServiceGrpc.getDeleteEvaluationExpectationMethod)
            == null) {
          EvaluationServiceGrpc.getDeleteEvaluationExpectationMethod =
              getDeleteEvaluationExpectationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteEvaluationExpectation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier(
                              "DeleteEvaluationExpectation"))
                      .build();
        }
      }
    }
    return getDeleteEvaluationExpectationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest,
          com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
      getCreateScheduledEvaluationRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateScheduledEvaluationRun",
      requestType = com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest.class,
      responseType = com.google.cloud.ces.v1beta.ScheduledEvaluationRun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest,
          com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
      getCreateScheduledEvaluationRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest,
            com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
        getCreateScheduledEvaluationRunMethod;
    if ((getCreateScheduledEvaluationRunMethod =
            EvaluationServiceGrpc.getCreateScheduledEvaluationRunMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getCreateScheduledEvaluationRunMethod =
                EvaluationServiceGrpc.getCreateScheduledEvaluationRunMethod)
            == null) {
          EvaluationServiceGrpc.getCreateScheduledEvaluationRunMethod =
              getCreateScheduledEvaluationRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest,
                          com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateScheduledEvaluationRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ScheduledEvaluationRun
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier(
                              "CreateScheduledEvaluationRun"))
                      .build();
        }
      }
    }
    return getCreateScheduledEvaluationRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest,
          com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
      getGetScheduledEvaluationRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScheduledEvaluationRun",
      requestType = com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest.class,
      responseType = com.google.cloud.ces.v1beta.ScheduledEvaluationRun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest,
          com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
      getGetScheduledEvaluationRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest,
            com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
        getGetScheduledEvaluationRunMethod;
    if ((getGetScheduledEvaluationRunMethod =
            EvaluationServiceGrpc.getGetScheduledEvaluationRunMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getGetScheduledEvaluationRunMethod =
                EvaluationServiceGrpc.getGetScheduledEvaluationRunMethod)
            == null) {
          EvaluationServiceGrpc.getGetScheduledEvaluationRunMethod =
              getGetScheduledEvaluationRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest,
                          com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetScheduledEvaluationRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ScheduledEvaluationRun
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier(
                              "GetScheduledEvaluationRun"))
                      .build();
        }
      }
    }
    return getGetScheduledEvaluationRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest,
          com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse>
      getListScheduledEvaluationRunsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListScheduledEvaluationRuns",
      requestType = com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest.class,
      responseType = com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest,
          com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse>
      getListScheduledEvaluationRunsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest,
            com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse>
        getListScheduledEvaluationRunsMethod;
    if ((getListScheduledEvaluationRunsMethod =
            EvaluationServiceGrpc.getListScheduledEvaluationRunsMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getListScheduledEvaluationRunsMethod =
                EvaluationServiceGrpc.getListScheduledEvaluationRunsMethod)
            == null) {
          EvaluationServiceGrpc.getListScheduledEvaluationRunsMethod =
              getListScheduledEvaluationRunsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest,
                          com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListScheduledEvaluationRuns"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier(
                              "ListScheduledEvaluationRuns"))
                      .build();
        }
      }
    }
    return getListScheduledEvaluationRunsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest,
          com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
      getUpdateScheduledEvaluationRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateScheduledEvaluationRun",
      requestType = com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest.class,
      responseType = com.google.cloud.ces.v1beta.ScheduledEvaluationRun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest,
          com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
      getUpdateScheduledEvaluationRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest,
            com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
        getUpdateScheduledEvaluationRunMethod;
    if ((getUpdateScheduledEvaluationRunMethod =
            EvaluationServiceGrpc.getUpdateScheduledEvaluationRunMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getUpdateScheduledEvaluationRunMethod =
                EvaluationServiceGrpc.getUpdateScheduledEvaluationRunMethod)
            == null) {
          EvaluationServiceGrpc.getUpdateScheduledEvaluationRunMethod =
              getUpdateScheduledEvaluationRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest,
                          com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateScheduledEvaluationRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ScheduledEvaluationRun
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier(
                              "UpdateScheduledEvaluationRun"))
                      .build();
        }
      }
    }
    return getUpdateScheduledEvaluationRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest,
          com.google.protobuf.Empty>
      getDeleteScheduledEvaluationRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteScheduledEvaluationRun",
      requestType = com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest,
          com.google.protobuf.Empty>
      getDeleteScheduledEvaluationRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest,
            com.google.protobuf.Empty>
        getDeleteScheduledEvaluationRunMethod;
    if ((getDeleteScheduledEvaluationRunMethod =
            EvaluationServiceGrpc.getDeleteScheduledEvaluationRunMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getDeleteScheduledEvaluationRunMethod =
                EvaluationServiceGrpc.getDeleteScheduledEvaluationRunMethod)
            == null) {
          EvaluationServiceGrpc.getDeleteScheduledEvaluationRunMethod =
              getDeleteScheduledEvaluationRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteScheduledEvaluationRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier(
                              "DeleteScheduledEvaluationRun"))
                      .build();
        }
      }
    }
    return getDeleteScheduledEvaluationRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.TestPersonaVoiceRequest,
          com.google.cloud.ces.v1beta.TestPersonaVoiceResponse>
      getTestPersonaVoiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestPersonaVoice",
      requestType = com.google.cloud.ces.v1beta.TestPersonaVoiceRequest.class,
      responseType = com.google.cloud.ces.v1beta.TestPersonaVoiceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.TestPersonaVoiceRequest,
          com.google.cloud.ces.v1beta.TestPersonaVoiceResponse>
      getTestPersonaVoiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.TestPersonaVoiceRequest,
            com.google.cloud.ces.v1beta.TestPersonaVoiceResponse>
        getTestPersonaVoiceMethod;
    if ((getTestPersonaVoiceMethod = EvaluationServiceGrpc.getTestPersonaVoiceMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getTestPersonaVoiceMethod = EvaluationServiceGrpc.getTestPersonaVoiceMethod) == null) {
          EvaluationServiceGrpc.getTestPersonaVoiceMethod =
              getTestPersonaVoiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.TestPersonaVoiceRequest,
                          com.google.cloud.ces.v1beta.TestPersonaVoiceResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestPersonaVoice"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.TestPersonaVoiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.TestPersonaVoiceResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("TestPersonaVoice"))
                      .build();
        }
      }
    }
    return getTestPersonaVoiceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EvaluationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceStub>() {
          @java.lang.Override
          public EvaluationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EvaluationServiceStub(channel, callOptions);
          }
        };
    return EvaluationServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static EvaluationServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceBlockingV2Stub>() {
          @java.lang.Override
          public EvaluationServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EvaluationServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return EvaluationServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EvaluationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceBlockingStub>() {
          @java.lang.Override
          public EvaluationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EvaluationServiceBlockingStub(channel, callOptions);
          }
        };
    return EvaluationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EvaluationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceFutureStub>() {
          @java.lang.Override
          public EvaluationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EvaluationServiceFutureStub(channel, callOptions);
          }
        };
    return EvaluationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * EvaluationService exposes methods to perform evaluation for the CES app.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Runs an evaluation of the app.
     * </pre>
     */
    default void runEvaluation(
        com.google.cloud.ces.v1beta.RunEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Uploads audio for use in Golden Evaluations. Stores the audio in the Cloud
     * Storage bucket defined in
     * 'App.logging_settings.evaluation_audio_recording_config.gcs_bucket' and
     * returns a transcript.
     * </pre>
     */
    default void uploadEvaluationAudio(
        com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUploadEvaluationAudioMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation.
     * </pre>
     */
    default void createEvaluation(
        com.google.cloud.ces.v1beta.CreateEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.Evaluation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a golden evaluation from a conversation.
     * </pre>
     */
    default void generateEvaluation(
        com.google.cloud.ces.v1beta.GenerateEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports evaluations into the app.
     * </pre>
     */
    default void importEvaluations(
        com.google.cloud.ces.v1beta.ImportEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportEvaluationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation dataset.
     * </pre>
     */
    default void createEvaluationDataset(
        com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationDataset>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEvaluationDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation.
     * </pre>
     */
    default void updateEvaluation(
        com.google.cloud.ces.v1beta.UpdateEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.Evaluation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation dataset.
     * </pre>
     */
    default void updateEvaluationDataset(
        com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationDataset>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEvaluationDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation.
     * </pre>
     */
    default void deleteEvaluation(
        com.google.cloud.ces.v1beta.DeleteEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation result.
     * </pre>
     */
    default void deleteEvaluationResult(
        com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEvaluationResultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation dataset.
     * </pre>
     */
    default void deleteEvaluationDataset(
        com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEvaluationDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation run.
     * </pre>
     */
    default void deleteEvaluationRun(
        com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEvaluationRunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation.
     * </pre>
     */
    default void getEvaluation(
        com.google.cloud.ces.v1beta.GetEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.Evaluation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation result.
     * </pre>
     */
    default void getEvaluationResult(
        com.google.cloud.ces.v1beta.GetEvaluationResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationResult>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEvaluationResultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation dataset.
     * </pre>
     */
    default void getEvaluationDataset(
        com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationDataset>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEvaluationDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation run.
     * </pre>
     */
    default void getEvaluationRun(
        com.google.cloud.ces.v1beta.GetEvaluationRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationRun> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEvaluationRunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluations in the given app.
     * </pre>
     */
    default void listEvaluations(
        com.google.cloud.ces.v1beta.ListEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEvaluationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation results for a given evaluation.
     * </pre>
     */
    default void listEvaluationResults(
        com.google.cloud.ces.v1beta.ListEvaluationResultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListEvaluationResultsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEvaluationResultsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation datasets in the given app.
     * </pre>
     */
    default void listEvaluationDatasets(
        com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEvaluationDatasetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation runs in the given app.
     * </pre>
     */
    default void listEvaluationRuns(
        com.google.cloud.ces.v1beta.ListEvaluationRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListEvaluationRunsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEvaluationRunsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation expectations in the given app.
     * </pre>
     */
    default void listEvaluationExpectations(
        com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEvaluationExpectationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation expectation.
     * </pre>
     */
    default void getEvaluationExpectation(
        com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationExpectation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEvaluationExpectationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation expectation.
     * </pre>
     */
    default void createEvaluationExpectation(
        com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationExpectation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEvaluationExpectationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation expectation.
     * </pre>
     */
    default void updateEvaluationExpectation(
        com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationExpectation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEvaluationExpectationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation expectation.
     * </pre>
     */
    default void deleteEvaluationExpectation(
        com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEvaluationExpectationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a scheduled evaluation run.
     * </pre>
     */
    default void createScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateScheduledEvaluationRunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified scheduled evaluation run.
     * </pre>
     */
    default void getScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetScheduledEvaluationRunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all scheduled evaluation runs in the given app.
     * </pre>
     */
    default void listScheduledEvaluationRuns(
        com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListScheduledEvaluationRunsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a scheduled evaluation run.
     * </pre>
     */
    default void updateScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateScheduledEvaluationRunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a scheduled evaluation run.
     * </pre>
     */
    default void deleteScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteScheduledEvaluationRunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Tests the voice of a persona. Also accepts a default persona.
     * </pre>
     */
    default void testPersonaVoice(
        com.google.cloud.ces.v1beta.TestPersonaVoiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.TestPersonaVoiceResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestPersonaVoiceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EvaluationService.
   *
   * <pre>
   * EvaluationService exposes methods to perform evaluation for the CES app.
   * </pre>
   */
  public abstract static class EvaluationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return EvaluationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EvaluationService.
   *
   * <pre>
   * EvaluationService exposes methods to perform evaluation for the CES app.
   * </pre>
   */
  public static final class EvaluationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EvaluationServiceStub> {
    private EvaluationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EvaluationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EvaluationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Runs an evaluation of the app.
     * </pre>
     */
    public void runEvaluation(
        com.google.cloud.ces.v1beta.RunEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Uploads audio for use in Golden Evaluations. Stores the audio in the Cloud
     * Storage bucket defined in
     * 'App.logging_settings.evaluation_audio_recording_config.gcs_bucket' and
     * returns a transcript.
     * </pre>
     */
    public void uploadEvaluationAudio(
        com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUploadEvaluationAudioMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation.
     * </pre>
     */
    public void createEvaluation(
        com.google.cloud.ces.v1beta.CreateEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.Evaluation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a golden evaluation from a conversation.
     * </pre>
     */
    public void generateEvaluation(
        com.google.cloud.ces.v1beta.GenerateEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports evaluations into the app.
     * </pre>
     */
    public void importEvaluations(
        com.google.cloud.ces.v1beta.ImportEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportEvaluationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation dataset.
     * </pre>
     */
    public void createEvaluationDataset(
        com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationDataset>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEvaluationDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation.
     * </pre>
     */
    public void updateEvaluation(
        com.google.cloud.ces.v1beta.UpdateEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.Evaluation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation dataset.
     * </pre>
     */
    public void updateEvaluationDataset(
        com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationDataset>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEvaluationDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation.
     * </pre>
     */
    public void deleteEvaluation(
        com.google.cloud.ces.v1beta.DeleteEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation result.
     * </pre>
     */
    public void deleteEvaluationResult(
        com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEvaluationResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation dataset.
     * </pre>
     */
    public void deleteEvaluationDataset(
        com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEvaluationDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation run.
     * </pre>
     */
    public void deleteEvaluationRun(
        com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEvaluationRunMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation.
     * </pre>
     */
    public void getEvaluation(
        com.google.cloud.ces.v1beta.GetEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.Evaluation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation result.
     * </pre>
     */
    public void getEvaluationResult(
        com.google.cloud.ces.v1beta.GetEvaluationResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationResult>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEvaluationResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation dataset.
     * </pre>
     */
    public void getEvaluationDataset(
        com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationDataset>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEvaluationDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation run.
     * </pre>
     */
    public void getEvaluationRun(
        com.google.cloud.ces.v1beta.GetEvaluationRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationRun> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEvaluationRunMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluations in the given app.
     * </pre>
     */
    public void listEvaluations(
        com.google.cloud.ces.v1beta.ListEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEvaluationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation results for a given evaluation.
     * </pre>
     */
    public void listEvaluationResults(
        com.google.cloud.ces.v1beta.ListEvaluationResultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListEvaluationResultsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEvaluationResultsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation datasets in the given app.
     * </pre>
     */
    public void listEvaluationDatasets(
        com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEvaluationDatasetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation runs in the given app.
     * </pre>
     */
    public void listEvaluationRuns(
        com.google.cloud.ces.v1beta.ListEvaluationRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListEvaluationRunsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEvaluationRunsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation expectations in the given app.
     * </pre>
     */
    public void listEvaluationExpectations(
        com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEvaluationExpectationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation expectation.
     * </pre>
     */
    public void getEvaluationExpectation(
        com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationExpectation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEvaluationExpectationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation expectation.
     * </pre>
     */
    public void createEvaluationExpectation(
        com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationExpectation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEvaluationExpectationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation expectation.
     * </pre>
     */
    public void updateEvaluationExpectation(
        com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationExpectation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEvaluationExpectationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation expectation.
     * </pre>
     */
    public void deleteEvaluationExpectation(
        com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEvaluationExpectationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a scheduled evaluation run.
     * </pre>
     */
    public void createScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateScheduledEvaluationRunMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified scheduled evaluation run.
     * </pre>
     */
    public void getScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScheduledEvaluationRunMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all scheduled evaluation runs in the given app.
     * </pre>
     */
    public void listScheduledEvaluationRuns(
        com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListScheduledEvaluationRunsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a scheduled evaluation run.
     * </pre>
     */
    public void updateScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateScheduledEvaluationRunMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a scheduled evaluation run.
     * </pre>
     */
    public void deleteScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteScheduledEvaluationRunMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Tests the voice of a persona. Also accepts a default persona.
     * </pre>
     */
    public void testPersonaVoice(
        com.google.cloud.ces.v1beta.TestPersonaVoiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.TestPersonaVoiceResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestPersonaVoiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EvaluationService.
   *
   * <pre>
   * EvaluationService exposes methods to perform evaluation for the CES app.
   * </pre>
   */
  public static final class EvaluationServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<EvaluationServiceBlockingV2Stub> {
    private EvaluationServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EvaluationServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EvaluationServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Runs an evaluation of the app.
     * </pre>
     */
    public com.google.longrunning.Operation runEvaluation(
        com.google.cloud.ces.v1beta.RunEvaluationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRunEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Uploads audio for use in Golden Evaluations. Stores the audio in the Cloud
     * Storage bucket defined in
     * 'App.logging_settings.evaluation_audio_recording_config.gcs_bucket' and
     * returns a transcript.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse uploadEvaluationAudio(
        com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUploadEvaluationAudioMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.Evaluation createEvaluation(
        com.google.cloud.ces.v1beta.CreateEvaluationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a golden evaluation from a conversation.
     * </pre>
     */
    public com.google.longrunning.Operation generateEvaluation(
        com.google.cloud.ces.v1beta.GenerateEvaluationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports evaluations into the app.
     * </pre>
     */
    public com.google.longrunning.Operation importEvaluations(
        com.google.cloud.ces.v1beta.ImportEvaluationsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getImportEvaluationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation dataset.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationDataset createEvaluationDataset(
        com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateEvaluationDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.Evaluation updateEvaluation(
        com.google.cloud.ces.v1beta.UpdateEvaluationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation dataset.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationDataset updateEvaluationDataset(
        com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateEvaluationDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEvaluation(
        com.google.cloud.ces.v1beta.DeleteEvaluationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation result.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEvaluationResult(
        com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteEvaluationResultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation dataset.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEvaluationDataset(
        com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteEvaluationDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation run.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEvaluationRun(
        com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteEvaluationRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.Evaluation getEvaluation(
        com.google.cloud.ces.v1beta.GetEvaluationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation result.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationResult getEvaluationResult(
        com.google.cloud.ces.v1beta.GetEvaluationResultRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetEvaluationResultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation dataset.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationDataset getEvaluationDataset(
        com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetEvaluationDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation run.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationRun getEvaluationRun(
        com.google.cloud.ces.v1beta.GetEvaluationRunRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetEvaluationRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluations in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListEvaluationsResponse listEvaluations(
        com.google.cloud.ces.v1beta.ListEvaluationsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListEvaluationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation results for a given evaluation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListEvaluationResultsResponse listEvaluationResults(
        com.google.cloud.ces.v1beta.ListEvaluationResultsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListEvaluationResultsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation datasets in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse listEvaluationDatasets(
        com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListEvaluationDatasetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation runs in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListEvaluationRunsResponse listEvaluationRuns(
        com.google.cloud.ces.v1beta.ListEvaluationRunsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListEvaluationRunsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation expectations in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse
        listEvaluationExpectations(
            com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListEvaluationExpectationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation expectation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationExpectation getEvaluationExpectation(
        com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetEvaluationExpectationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation expectation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationExpectation createEvaluationExpectation(
        com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateEvaluationExpectationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation expectation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationExpectation updateEvaluationExpectation(
        com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateEvaluationExpectationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation expectation.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEvaluationExpectation(
        com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteEvaluationExpectationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a scheduled evaluation run.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ScheduledEvaluationRun createScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateScheduledEvaluationRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified scheduled evaluation run.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ScheduledEvaluationRun getScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetScheduledEvaluationRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all scheduled evaluation runs in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse
        listScheduledEvaluationRuns(
            com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListScheduledEvaluationRunsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a scheduled evaluation run.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ScheduledEvaluationRun updateScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateScheduledEvaluationRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a scheduled evaluation run.
     * </pre>
     */
    public com.google.protobuf.Empty deleteScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteScheduledEvaluationRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Tests the voice of a persona. Also accepts a default persona.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.TestPersonaVoiceResponse testPersonaVoice(
        com.google.cloud.ces.v1beta.TestPersonaVoiceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTestPersonaVoiceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service EvaluationService.
   *
   * <pre>
   * EvaluationService exposes methods to perform evaluation for the CES app.
   * </pre>
   */
  public static final class EvaluationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EvaluationServiceBlockingStub> {
    private EvaluationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EvaluationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EvaluationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Runs an evaluation of the app.
     * </pre>
     */
    public com.google.longrunning.Operation runEvaluation(
        com.google.cloud.ces.v1beta.RunEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Uploads audio for use in Golden Evaluations. Stores the audio in the Cloud
     * Storage bucket defined in
     * 'App.logging_settings.evaluation_audio_recording_config.gcs_bucket' and
     * returns a transcript.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse uploadEvaluationAudio(
        com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadEvaluationAudioMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.Evaluation createEvaluation(
        com.google.cloud.ces.v1beta.CreateEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a golden evaluation from a conversation.
     * </pre>
     */
    public com.google.longrunning.Operation generateEvaluation(
        com.google.cloud.ces.v1beta.GenerateEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports evaluations into the app.
     * </pre>
     */
    public com.google.longrunning.Operation importEvaluations(
        com.google.cloud.ces.v1beta.ImportEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportEvaluationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation dataset.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationDataset createEvaluationDataset(
        com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEvaluationDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.Evaluation updateEvaluation(
        com.google.cloud.ces.v1beta.UpdateEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation dataset.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationDataset updateEvaluationDataset(
        com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEvaluationDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEvaluation(
        com.google.cloud.ces.v1beta.DeleteEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation result.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEvaluationResult(
        com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEvaluationResultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation dataset.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEvaluationDataset(
        com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEvaluationDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation run.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEvaluationRun(
        com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEvaluationRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.Evaluation getEvaluation(
        com.google.cloud.ces.v1beta.GetEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation result.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationResult getEvaluationResult(
        com.google.cloud.ces.v1beta.GetEvaluationResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEvaluationResultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation dataset.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationDataset getEvaluationDataset(
        com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEvaluationDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation run.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationRun getEvaluationRun(
        com.google.cloud.ces.v1beta.GetEvaluationRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEvaluationRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluations in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListEvaluationsResponse listEvaluations(
        com.google.cloud.ces.v1beta.ListEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEvaluationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation results for a given evaluation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListEvaluationResultsResponse listEvaluationResults(
        com.google.cloud.ces.v1beta.ListEvaluationResultsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEvaluationResultsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation datasets in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse listEvaluationDatasets(
        com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEvaluationDatasetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation runs in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListEvaluationRunsResponse listEvaluationRuns(
        com.google.cloud.ces.v1beta.ListEvaluationRunsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEvaluationRunsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation expectations in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse
        listEvaluationExpectations(
            com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEvaluationExpectationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation expectation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationExpectation getEvaluationExpectation(
        com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEvaluationExpectationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation expectation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationExpectation createEvaluationExpectation(
        com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEvaluationExpectationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation expectation.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.EvaluationExpectation updateEvaluationExpectation(
        com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEvaluationExpectationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation expectation.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEvaluationExpectation(
        com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEvaluationExpectationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a scheduled evaluation run.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ScheduledEvaluationRun createScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateScheduledEvaluationRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified scheduled evaluation run.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ScheduledEvaluationRun getScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScheduledEvaluationRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all scheduled evaluation runs in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse
        listScheduledEvaluationRuns(
            com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListScheduledEvaluationRunsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a scheduled evaluation run.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ScheduledEvaluationRun updateScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateScheduledEvaluationRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a scheduled evaluation run.
     * </pre>
     */
    public com.google.protobuf.Empty deleteScheduledEvaluationRun(
        com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteScheduledEvaluationRunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Tests the voice of a persona. Also accepts a default persona.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.TestPersonaVoiceResponse testPersonaVoice(
        com.google.cloud.ces.v1beta.TestPersonaVoiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestPersonaVoiceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EvaluationService.
   *
   * <pre>
   * EvaluationService exposes methods to perform evaluation for the CES app.
   * </pre>
   */
  public static final class EvaluationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EvaluationServiceFutureStub> {
    private EvaluationServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EvaluationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EvaluationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Runs an evaluation of the app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        runEvaluation(com.google.cloud.ces.v1beta.RunEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Uploads audio for use in Golden Evaluations. Stores the audio in the Cloud
     * Storage bucket defined in
     * 'App.logging_settings.evaluation_audio_recording_config.gcs_bucket' and
     * returns a transcript.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse>
        uploadEvaluationAudio(com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUploadEvaluationAudioMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.Evaluation>
        createEvaluation(com.google.cloud.ces.v1beta.CreateEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a golden evaluation from a conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        generateEvaluation(com.google.cloud.ces.v1beta.GenerateEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports evaluations into the app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importEvaluations(com.google.cloud.ces.v1beta.ImportEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportEvaluationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.EvaluationDataset>
        createEvaluationDataset(
            com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEvaluationDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.Evaluation>
        updateEvaluation(com.google.cloud.ces.v1beta.UpdateEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.EvaluationDataset>
        updateEvaluationDataset(
            com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEvaluationDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEvaluation(com.google.cloud.ces.v1beta.DeleteEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation result.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEvaluationResult(com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEvaluationResultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEvaluationDataset(
            com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEvaluationDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEvaluationRun(com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEvaluationRunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.Evaluation>
        getEvaluation(com.google.cloud.ces.v1beta.GetEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation result.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.EvaluationResult>
        getEvaluationResult(com.google.cloud.ces.v1beta.GetEvaluationResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEvaluationResultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.EvaluationDataset>
        getEvaluationDataset(com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEvaluationDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.EvaluationRun>
        getEvaluationRun(com.google.cloud.ces.v1beta.GetEvaluationRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEvaluationRunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluations in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.ListEvaluationsResponse>
        listEvaluations(com.google.cloud.ces.v1beta.ListEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEvaluationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation results for a given evaluation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.ListEvaluationResultsResponse>
        listEvaluationResults(com.google.cloud.ces.v1beta.ListEvaluationResultsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEvaluationResultsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation datasets in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse>
        listEvaluationDatasets(com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEvaluationDatasetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation runs in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.ListEvaluationRunsResponse>
        listEvaluationRuns(com.google.cloud.ces.v1beta.ListEvaluationRunsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEvaluationRunsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation expectations in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse>
        listEvaluationExpectations(
            com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEvaluationExpectationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified evaluation expectation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.EvaluationExpectation>
        getEvaluationExpectation(
            com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEvaluationExpectationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation expectation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.EvaluationExpectation>
        createEvaluationExpectation(
            com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEvaluationExpectationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation expectation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.EvaluationExpectation>
        updateEvaluationExpectation(
            com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEvaluationExpectationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation expectation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEvaluationExpectation(
            com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEvaluationExpectationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a scheduled evaluation run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
        createScheduledEvaluationRun(
            com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateScheduledEvaluationRunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified scheduled evaluation run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
        getScheduledEvaluationRun(
            com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScheduledEvaluationRunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all scheduled evaluation runs in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse>
        listScheduledEvaluationRuns(
            com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListScheduledEvaluationRunsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a scheduled evaluation run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.ScheduledEvaluationRun>
        updateScheduledEvaluationRun(
            com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateScheduledEvaluationRunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a scheduled evaluation run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteScheduledEvaluationRun(
            com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteScheduledEvaluationRunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Tests the voice of a persona. Also accepts a default persona.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.TestPersonaVoiceResponse>
        testPersonaVoice(com.google.cloud.ces.v1beta.TestPersonaVoiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestPersonaVoiceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RUN_EVALUATION = 0;
  private static final int METHODID_UPLOAD_EVALUATION_AUDIO = 1;
  private static final int METHODID_CREATE_EVALUATION = 2;
  private static final int METHODID_GENERATE_EVALUATION = 3;
  private static final int METHODID_IMPORT_EVALUATIONS = 4;
  private static final int METHODID_CREATE_EVALUATION_DATASET = 5;
  private static final int METHODID_UPDATE_EVALUATION = 6;
  private static final int METHODID_UPDATE_EVALUATION_DATASET = 7;
  private static final int METHODID_DELETE_EVALUATION = 8;
  private static final int METHODID_DELETE_EVALUATION_RESULT = 9;
  private static final int METHODID_DELETE_EVALUATION_DATASET = 10;
  private static final int METHODID_DELETE_EVALUATION_RUN = 11;
  private static final int METHODID_GET_EVALUATION = 12;
  private static final int METHODID_GET_EVALUATION_RESULT = 13;
  private static final int METHODID_GET_EVALUATION_DATASET = 14;
  private static final int METHODID_GET_EVALUATION_RUN = 15;
  private static final int METHODID_LIST_EVALUATIONS = 16;
  private static final int METHODID_LIST_EVALUATION_RESULTS = 17;
  private static final int METHODID_LIST_EVALUATION_DATASETS = 18;
  private static final int METHODID_LIST_EVALUATION_RUNS = 19;
  private static final int METHODID_LIST_EVALUATION_EXPECTATIONS = 20;
  private static final int METHODID_GET_EVALUATION_EXPECTATION = 21;
  private static final int METHODID_CREATE_EVALUATION_EXPECTATION = 22;
  private static final int METHODID_UPDATE_EVALUATION_EXPECTATION = 23;
  private static final int METHODID_DELETE_EVALUATION_EXPECTATION = 24;
  private static final int METHODID_CREATE_SCHEDULED_EVALUATION_RUN = 25;
  private static final int METHODID_GET_SCHEDULED_EVALUATION_RUN = 26;
  private static final int METHODID_LIST_SCHEDULED_EVALUATION_RUNS = 27;
  private static final int METHODID_UPDATE_SCHEDULED_EVALUATION_RUN = 28;
  private static final int METHODID_DELETE_SCHEDULED_EVALUATION_RUN = 29;
  private static final int METHODID_TEST_PERSONA_VOICE = 30;

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
        case METHODID_RUN_EVALUATION:
          serviceImpl.runEvaluation(
              (com.google.cloud.ces.v1beta.RunEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPLOAD_EVALUATION_AUDIO:
          serviceImpl.uploadEvaluationAudio(
              (com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_EVALUATION:
          serviceImpl.createEvaluation(
              (com.google.cloud.ces.v1beta.CreateEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.Evaluation>)
                  responseObserver);
          break;
        case METHODID_GENERATE_EVALUATION:
          serviceImpl.generateEvaluation(
              (com.google.cloud.ces.v1beta.GenerateEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_EVALUATIONS:
          serviceImpl.importEvaluations(
              (com.google.cloud.ces.v1beta.ImportEvaluationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_EVALUATION_DATASET:
          serviceImpl.createEvaluationDataset(
              (com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationDataset>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EVALUATION:
          serviceImpl.updateEvaluation(
              (com.google.cloud.ces.v1beta.UpdateEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.Evaluation>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EVALUATION_DATASET:
          serviceImpl.updateEvaluationDataset(
              (com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationDataset>)
                  responseObserver);
          break;
        case METHODID_DELETE_EVALUATION:
          serviceImpl.deleteEvaluation(
              (com.google.cloud.ces.v1beta.DeleteEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_EVALUATION_RESULT:
          serviceImpl.deleteEvaluationResult(
              (com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_EVALUATION_DATASET:
          serviceImpl.deleteEvaluationDataset(
              (com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_EVALUATION_RUN:
          serviceImpl.deleteEvaluationRun(
              (com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_EVALUATION:
          serviceImpl.getEvaluation(
              (com.google.cloud.ces.v1beta.GetEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.Evaluation>)
                  responseObserver);
          break;
        case METHODID_GET_EVALUATION_RESULT:
          serviceImpl.getEvaluationResult(
              (com.google.cloud.ces.v1beta.GetEvaluationResultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationResult>)
                  responseObserver);
          break;
        case METHODID_GET_EVALUATION_DATASET:
          serviceImpl.getEvaluationDataset(
              (com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationDataset>)
                  responseObserver);
          break;
        case METHODID_GET_EVALUATION_RUN:
          serviceImpl.getEvaluationRun(
              (com.google.cloud.ces.v1beta.GetEvaluationRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationRun>)
                  responseObserver);
          break;
        case METHODID_LIST_EVALUATIONS:
          serviceImpl.listEvaluations(
              (com.google.cloud.ces.v1beta.ListEvaluationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListEvaluationsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_EVALUATION_RESULTS:
          serviceImpl.listEvaluationResults(
              (com.google.cloud.ces.v1beta.ListEvaluationResultsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.ces.v1beta.ListEvaluationResultsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_EVALUATION_DATASETS:
          serviceImpl.listEvaluationDatasets(
              (com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_EVALUATION_RUNS:
          serviceImpl.listEvaluationRuns(
              (com.google.cloud.ces.v1beta.ListEvaluationRunsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListEvaluationRunsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_EVALUATION_EXPECTATIONS:
          serviceImpl.listEvaluationExpectations(
              (com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EVALUATION_EXPECTATION:
          serviceImpl.getEvaluationExpectation(
              (com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationExpectation>)
                  responseObserver);
          break;
        case METHODID_CREATE_EVALUATION_EXPECTATION:
          serviceImpl.createEvaluationExpectation(
              (com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationExpectation>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EVALUATION_EXPECTATION:
          serviceImpl.updateEvaluationExpectation(
              (com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.EvaluationExpectation>)
                  responseObserver);
          break;
        case METHODID_DELETE_EVALUATION_EXPECTATION:
          serviceImpl.deleteEvaluationExpectation(
              (com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_SCHEDULED_EVALUATION_RUN:
          serviceImpl.createScheduledEvaluationRun(
              (com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ScheduledEvaluationRun>)
                  responseObserver);
          break;
        case METHODID_GET_SCHEDULED_EVALUATION_RUN:
          serviceImpl.getScheduledEvaluationRun(
              (com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ScheduledEvaluationRun>)
                  responseObserver);
          break;
        case METHODID_LIST_SCHEDULED_EVALUATION_RUNS:
          serviceImpl.listScheduledEvaluationRuns(
              (com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SCHEDULED_EVALUATION_RUN:
          serviceImpl.updateScheduledEvaluationRun(
              (com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ScheduledEvaluationRun>)
                  responseObserver);
          break;
        case METHODID_DELETE_SCHEDULED_EVALUATION_RUN:
          serviceImpl.deleteScheduledEvaluationRun(
              (com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_TEST_PERSONA_VOICE:
          serviceImpl.testPersonaVoice(
              (com.google.cloud.ces.v1beta.TestPersonaVoiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.TestPersonaVoiceResponse>)
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
            getRunEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.RunEvaluationRequest,
                    com.google.longrunning.Operation>(service, METHODID_RUN_EVALUATION)))
        .addMethod(
            getUploadEvaluationAudioMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest,
                    com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse>(
                    service, METHODID_UPLOAD_EVALUATION_AUDIO)))
        .addMethod(
            getCreateEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.CreateEvaluationRequest,
                    com.google.cloud.ces.v1beta.Evaluation>(service, METHODID_CREATE_EVALUATION)))
        .addMethod(
            getGenerateEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.GenerateEvaluationRequest,
                    com.google.longrunning.Operation>(service, METHODID_GENERATE_EVALUATION)))
        .addMethod(
            getImportEvaluationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.ImportEvaluationsRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_EVALUATIONS)))
        .addMethod(
            getCreateEvaluationDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest,
                    com.google.cloud.ces.v1beta.EvaluationDataset>(
                    service, METHODID_CREATE_EVALUATION_DATASET)))
        .addMethod(
            getUpdateEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.UpdateEvaluationRequest,
                    com.google.cloud.ces.v1beta.Evaluation>(service, METHODID_UPDATE_EVALUATION)))
        .addMethod(
            getUpdateEvaluationDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest,
                    com.google.cloud.ces.v1beta.EvaluationDataset>(
                    service, METHODID_UPDATE_EVALUATION_DATASET)))
        .addMethod(
            getDeleteEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.DeleteEvaluationRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_EVALUATION)))
        .addMethod(
            getDeleteEvaluationResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_EVALUATION_RESULT)))
        .addMethod(
            getDeleteEvaluationDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_EVALUATION_DATASET)))
        .addMethod(
            getDeleteEvaluationRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_EVALUATION_RUN)))
        .addMethod(
            getGetEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.GetEvaluationRequest,
                    com.google.cloud.ces.v1beta.Evaluation>(service, METHODID_GET_EVALUATION)))
        .addMethod(
            getGetEvaluationResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.GetEvaluationResultRequest,
                    com.google.cloud.ces.v1beta.EvaluationResult>(
                    service, METHODID_GET_EVALUATION_RESULT)))
        .addMethod(
            getGetEvaluationDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest,
                    com.google.cloud.ces.v1beta.EvaluationDataset>(
                    service, METHODID_GET_EVALUATION_DATASET)))
        .addMethod(
            getGetEvaluationRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.GetEvaluationRunRequest,
                    com.google.cloud.ces.v1beta.EvaluationRun>(
                    service, METHODID_GET_EVALUATION_RUN)))
        .addMethod(
            getListEvaluationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.ListEvaluationsRequest,
                    com.google.cloud.ces.v1beta.ListEvaluationsResponse>(
                    service, METHODID_LIST_EVALUATIONS)))
        .addMethod(
            getListEvaluationResultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.ListEvaluationResultsRequest,
                    com.google.cloud.ces.v1beta.ListEvaluationResultsResponse>(
                    service, METHODID_LIST_EVALUATION_RESULTS)))
        .addMethod(
            getListEvaluationDatasetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest,
                    com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse>(
                    service, METHODID_LIST_EVALUATION_DATASETS)))
        .addMethod(
            getListEvaluationRunsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.ListEvaluationRunsRequest,
                    com.google.cloud.ces.v1beta.ListEvaluationRunsResponse>(
                    service, METHODID_LIST_EVALUATION_RUNS)))
        .addMethod(
            getListEvaluationExpectationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest,
                    com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse>(
                    service, METHODID_LIST_EVALUATION_EXPECTATIONS)))
        .addMethod(
            getGetEvaluationExpectationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest,
                    com.google.cloud.ces.v1beta.EvaluationExpectation>(
                    service, METHODID_GET_EVALUATION_EXPECTATION)))
        .addMethod(
            getCreateEvaluationExpectationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest,
                    com.google.cloud.ces.v1beta.EvaluationExpectation>(
                    service, METHODID_CREATE_EVALUATION_EXPECTATION)))
        .addMethod(
            getUpdateEvaluationExpectationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest,
                    com.google.cloud.ces.v1beta.EvaluationExpectation>(
                    service, METHODID_UPDATE_EVALUATION_EXPECTATION)))
        .addMethod(
            getDeleteEvaluationExpectationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_EVALUATION_EXPECTATION)))
        .addMethod(
            getCreateScheduledEvaluationRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest,
                    com.google.cloud.ces.v1beta.ScheduledEvaluationRun>(
                    service, METHODID_CREATE_SCHEDULED_EVALUATION_RUN)))
        .addMethod(
            getGetScheduledEvaluationRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest,
                    com.google.cloud.ces.v1beta.ScheduledEvaluationRun>(
                    service, METHODID_GET_SCHEDULED_EVALUATION_RUN)))
        .addMethod(
            getListScheduledEvaluationRunsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest,
                    com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse>(
                    service, METHODID_LIST_SCHEDULED_EVALUATION_RUNS)))
        .addMethod(
            getUpdateScheduledEvaluationRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest,
                    com.google.cloud.ces.v1beta.ScheduledEvaluationRun>(
                    service, METHODID_UPDATE_SCHEDULED_EVALUATION_RUN)))
        .addMethod(
            getDeleteScheduledEvaluationRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SCHEDULED_EVALUATION_RUN)))
        .addMethod(
            getTestPersonaVoiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.TestPersonaVoiceRequest,
                    com.google.cloud.ces.v1beta.TestPersonaVoiceResponse>(
                    service, METHODID_TEST_PERSONA_VOICE)))
        .build();
  }

  private abstract static class EvaluationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EvaluationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.ces.v1beta.EvaluationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EvaluationService");
    }
  }

  private static final class EvaluationServiceFileDescriptorSupplier
      extends EvaluationServiceBaseDescriptorSupplier {
    EvaluationServiceFileDescriptorSupplier() {}
  }

  private static final class EvaluationServiceMethodDescriptorSupplier
      extends EvaluationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EvaluationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EvaluationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EvaluationServiceFileDescriptorSupplier())
                      .addMethod(getRunEvaluationMethod())
                      .addMethod(getUploadEvaluationAudioMethod())
                      .addMethod(getCreateEvaluationMethod())
                      .addMethod(getGenerateEvaluationMethod())
                      .addMethod(getImportEvaluationsMethod())
                      .addMethod(getCreateEvaluationDatasetMethod())
                      .addMethod(getUpdateEvaluationMethod())
                      .addMethod(getUpdateEvaluationDatasetMethod())
                      .addMethod(getDeleteEvaluationMethod())
                      .addMethod(getDeleteEvaluationResultMethod())
                      .addMethod(getDeleteEvaluationDatasetMethod())
                      .addMethod(getDeleteEvaluationRunMethod())
                      .addMethod(getGetEvaluationMethod())
                      .addMethod(getGetEvaluationResultMethod())
                      .addMethod(getGetEvaluationDatasetMethod())
                      .addMethod(getGetEvaluationRunMethod())
                      .addMethod(getListEvaluationsMethod())
                      .addMethod(getListEvaluationResultsMethod())
                      .addMethod(getListEvaluationDatasetsMethod())
                      .addMethod(getListEvaluationRunsMethod())
                      .addMethod(getListEvaluationExpectationsMethod())
                      .addMethod(getGetEvaluationExpectationMethod())
                      .addMethod(getCreateEvaluationExpectationMethod())
                      .addMethod(getUpdateEvaluationExpectationMethod())
                      .addMethod(getDeleteEvaluationExpectationMethod())
                      .addMethod(getCreateScheduledEvaluationRunMethod())
                      .addMethod(getGetScheduledEvaluationRunMethod())
                      .addMethod(getListScheduledEvaluationRunsMethod())
                      .addMethod(getUpdateScheduledEvaluationRunMethod())
                      .addMethod(getDeleteScheduledEvaluationRunMethod())
                      .addMethod(getTestPersonaVoiceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
