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
package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for managing Vertex AI's machine learning Models.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/model_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ModelServiceGrpc {

  private ModelServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1.ModelService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UploadModelRequest, com.google.longrunning.Operation>
      getUploadModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadModel",
      requestType = com.google.cloud.aiplatform.v1.UploadModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UploadModelRequest, com.google.longrunning.Operation>
      getUploadModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.UploadModelRequest, com.google.longrunning.Operation>
        getUploadModelMethod;
    if ((getUploadModelMethod = ModelServiceGrpc.getUploadModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getUploadModelMethod = ModelServiceGrpc.getUploadModelMethod) == null) {
          ModelServiceGrpc.getUploadModelMethod =
              getUploadModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.UploadModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UploadModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.UploadModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("UploadModel"))
                      .build();
        }
      }
    }
    return getUploadModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetModelRequest, com.google.cloud.aiplatform.v1.Model>
      getGetModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetModel",
      requestType = com.google.cloud.aiplatform.v1.GetModelRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Model.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetModelRequest, com.google.cloud.aiplatform.v1.Model>
      getGetModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetModelRequest, com.google.cloud.aiplatform.v1.Model>
        getGetModelMethod;
    if ((getGetModelMethod = ModelServiceGrpc.getGetModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getGetModelMethod = ModelServiceGrpc.getGetModelMethod) == null) {
          ModelServiceGrpc.getGetModelMethod =
              getGetModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetModelRequest,
                          com.google.cloud.aiplatform.v1.Model>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetModelRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Model.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("GetModel"))
                      .build();
        }
      }
    }
    return getGetModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListModelsRequest,
          com.google.cloud.aiplatform.v1.ListModelsResponse>
      getListModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListModels",
      requestType = com.google.cloud.aiplatform.v1.ListModelsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListModelsRequest,
          com.google.cloud.aiplatform.v1.ListModelsResponse>
      getListModelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListModelsRequest,
            com.google.cloud.aiplatform.v1.ListModelsResponse>
        getListModelsMethod;
    if ((getListModelsMethod = ModelServiceGrpc.getListModelsMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getListModelsMethod = ModelServiceGrpc.getListModelsMethod) == null) {
          ModelServiceGrpc.getListModelsMethod =
              getListModelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListModelsRequest,
                          com.google.cloud.aiplatform.v1.ListModelsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListModels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListModelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListModelsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("ListModels"))
                      .build();
        }
      }
    }
    return getListModelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListModelVersionsRequest,
          com.google.cloud.aiplatform.v1.ListModelVersionsResponse>
      getListModelVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListModelVersions",
      requestType = com.google.cloud.aiplatform.v1.ListModelVersionsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListModelVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListModelVersionsRequest,
          com.google.cloud.aiplatform.v1.ListModelVersionsResponse>
      getListModelVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListModelVersionsRequest,
            com.google.cloud.aiplatform.v1.ListModelVersionsResponse>
        getListModelVersionsMethod;
    if ((getListModelVersionsMethod = ModelServiceGrpc.getListModelVersionsMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getListModelVersionsMethod = ModelServiceGrpc.getListModelVersionsMethod) == null) {
          ModelServiceGrpc.getListModelVersionsMethod =
              getListModelVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListModelVersionsRequest,
                          com.google.cloud.aiplatform.v1.ListModelVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListModelVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListModelVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListModelVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelServiceMethodDescriptorSupplier("ListModelVersions"))
                      .build();
        }
      }
    }
    return getListModelVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateModelRequest, com.google.cloud.aiplatform.v1.Model>
      getUpdateModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateModel",
      requestType = com.google.cloud.aiplatform.v1.UpdateModelRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Model.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateModelRequest, com.google.cloud.aiplatform.v1.Model>
      getUpdateModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.UpdateModelRequest, com.google.cloud.aiplatform.v1.Model>
        getUpdateModelMethod;
    if ((getUpdateModelMethod = ModelServiceGrpc.getUpdateModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getUpdateModelMethod = ModelServiceGrpc.getUpdateModelMethod) == null) {
          ModelServiceGrpc.getUpdateModelMethod =
              getUpdateModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.UpdateModelRequest,
                          com.google.cloud.aiplatform.v1.Model>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.UpdateModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Model.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("UpdateModel"))
                      .build();
        }
      }
    }
    return getUpdateModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteModelRequest, com.google.longrunning.Operation>
      getDeleteModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteModel",
      requestType = com.google.cloud.aiplatform.v1.DeleteModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteModelRequest, com.google.longrunning.Operation>
      getDeleteModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.DeleteModelRequest, com.google.longrunning.Operation>
        getDeleteModelMethod;
    if ((getDeleteModelMethod = ModelServiceGrpc.getDeleteModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getDeleteModelMethod = ModelServiceGrpc.getDeleteModelMethod) == null) {
          ModelServiceGrpc.getDeleteModelMethod =
              getDeleteModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.DeleteModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.DeleteModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("DeleteModel"))
                      .build();
        }
      }
    }
    return getDeleteModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteModelVersionRequest,
          com.google.longrunning.Operation>
      getDeleteModelVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteModelVersion",
      requestType = com.google.cloud.aiplatform.v1.DeleteModelVersionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteModelVersionRequest,
          com.google.longrunning.Operation>
      getDeleteModelVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.DeleteModelVersionRequest,
            com.google.longrunning.Operation>
        getDeleteModelVersionMethod;
    if ((getDeleteModelVersionMethod = ModelServiceGrpc.getDeleteModelVersionMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getDeleteModelVersionMethod = ModelServiceGrpc.getDeleteModelVersionMethod) == null) {
          ModelServiceGrpc.getDeleteModelVersionMethod =
              getDeleteModelVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.DeleteModelVersionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteModelVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.DeleteModelVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelServiceMethodDescriptorSupplier("DeleteModelVersion"))
                      .build();
        }
      }
    }
    return getDeleteModelVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.MergeVersionAliasesRequest,
          com.google.cloud.aiplatform.v1.Model>
      getMergeVersionAliasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MergeVersionAliases",
      requestType = com.google.cloud.aiplatform.v1.MergeVersionAliasesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Model.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.MergeVersionAliasesRequest,
          com.google.cloud.aiplatform.v1.Model>
      getMergeVersionAliasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.MergeVersionAliasesRequest,
            com.google.cloud.aiplatform.v1.Model>
        getMergeVersionAliasesMethod;
    if ((getMergeVersionAliasesMethod = ModelServiceGrpc.getMergeVersionAliasesMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getMergeVersionAliasesMethod = ModelServiceGrpc.getMergeVersionAliasesMethod)
            == null) {
          ModelServiceGrpc.getMergeVersionAliasesMethod =
              getMergeVersionAliasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.MergeVersionAliasesRequest,
                          com.google.cloud.aiplatform.v1.Model>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "MergeVersionAliases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.MergeVersionAliasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Model.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelServiceMethodDescriptorSupplier("MergeVersionAliases"))
                      .build();
        }
      }
    }
    return getMergeVersionAliasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ExportModelRequest, com.google.longrunning.Operation>
      getExportModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportModel",
      requestType = com.google.cloud.aiplatform.v1.ExportModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ExportModelRequest, com.google.longrunning.Operation>
      getExportModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ExportModelRequest, com.google.longrunning.Operation>
        getExportModelMethod;
    if ((getExportModelMethod = ModelServiceGrpc.getExportModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getExportModelMethod = ModelServiceGrpc.getExportModelMethod) == null) {
          ModelServiceGrpc.getExportModelMethod =
              getExportModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ExportModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ExportModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("ExportModel"))
                      .build();
        }
      }
    }
    return getExportModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ImportModelEvaluationRequest,
          com.google.cloud.aiplatform.v1.ModelEvaluation>
      getImportModelEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportModelEvaluation",
      requestType = com.google.cloud.aiplatform.v1.ImportModelEvaluationRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ModelEvaluation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ImportModelEvaluationRequest,
          com.google.cloud.aiplatform.v1.ModelEvaluation>
      getImportModelEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ImportModelEvaluationRequest,
            com.google.cloud.aiplatform.v1.ModelEvaluation>
        getImportModelEvaluationMethod;
    if ((getImportModelEvaluationMethod = ModelServiceGrpc.getImportModelEvaluationMethod)
        == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getImportModelEvaluationMethod = ModelServiceGrpc.getImportModelEvaluationMethod)
            == null) {
          ModelServiceGrpc.getImportModelEvaluationMethod =
              getImportModelEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ImportModelEvaluationRequest,
                          com.google.cloud.aiplatform.v1.ModelEvaluation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportModelEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ImportModelEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ModelEvaluation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelServiceMethodDescriptorSupplier("ImportModelEvaluation"))
                      .build();
        }
      }
    }
    return getImportModelEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesRequest,
          com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesResponse>
      getBatchImportModelEvaluationSlicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchImportModelEvaluationSlices",
      requestType = com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesRequest,
          com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesResponse>
      getBatchImportModelEvaluationSlicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesRequest,
            com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesResponse>
        getBatchImportModelEvaluationSlicesMethod;
    if ((getBatchImportModelEvaluationSlicesMethod =
            ModelServiceGrpc.getBatchImportModelEvaluationSlicesMethod)
        == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getBatchImportModelEvaluationSlicesMethod =
                ModelServiceGrpc.getBatchImportModelEvaluationSlicesMethod)
            == null) {
          ModelServiceGrpc.getBatchImportModelEvaluationSlicesMethod =
              getBatchImportModelEvaluationSlicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesRequest,
                          com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchImportModelEvaluationSlices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1
                                  .BatchImportModelEvaluationSlicesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelServiceMethodDescriptorSupplier(
                              "BatchImportModelEvaluationSlices"))
                      .build();
        }
      }
    }
    return getBatchImportModelEvaluationSlicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetModelEvaluationRequest,
          com.google.cloud.aiplatform.v1.ModelEvaluation>
      getGetModelEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetModelEvaluation",
      requestType = com.google.cloud.aiplatform.v1.GetModelEvaluationRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ModelEvaluation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetModelEvaluationRequest,
          com.google.cloud.aiplatform.v1.ModelEvaluation>
      getGetModelEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetModelEvaluationRequest,
            com.google.cloud.aiplatform.v1.ModelEvaluation>
        getGetModelEvaluationMethod;
    if ((getGetModelEvaluationMethod = ModelServiceGrpc.getGetModelEvaluationMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getGetModelEvaluationMethod = ModelServiceGrpc.getGetModelEvaluationMethod) == null) {
          ModelServiceGrpc.getGetModelEvaluationMethod =
              getGetModelEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetModelEvaluationRequest,
                          com.google.cloud.aiplatform.v1.ModelEvaluation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetModelEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetModelEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ModelEvaluation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelServiceMethodDescriptorSupplier("GetModelEvaluation"))
                      .build();
        }
      }
    }
    return getGetModelEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListModelEvaluationsRequest,
          com.google.cloud.aiplatform.v1.ListModelEvaluationsResponse>
      getListModelEvaluationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListModelEvaluations",
      requestType = com.google.cloud.aiplatform.v1.ListModelEvaluationsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListModelEvaluationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListModelEvaluationsRequest,
          com.google.cloud.aiplatform.v1.ListModelEvaluationsResponse>
      getListModelEvaluationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListModelEvaluationsRequest,
            com.google.cloud.aiplatform.v1.ListModelEvaluationsResponse>
        getListModelEvaluationsMethod;
    if ((getListModelEvaluationsMethod = ModelServiceGrpc.getListModelEvaluationsMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getListModelEvaluationsMethod = ModelServiceGrpc.getListModelEvaluationsMethod)
            == null) {
          ModelServiceGrpc.getListModelEvaluationsMethod =
              getListModelEvaluationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListModelEvaluationsRequest,
                          com.google.cloud.aiplatform.v1.ListModelEvaluationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListModelEvaluations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListModelEvaluationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListModelEvaluationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelServiceMethodDescriptorSupplier("ListModelEvaluations"))
                      .build();
        }
      }
    }
    return getListModelEvaluationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetModelEvaluationSliceRequest,
          com.google.cloud.aiplatform.v1.ModelEvaluationSlice>
      getGetModelEvaluationSliceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetModelEvaluationSlice",
      requestType = com.google.cloud.aiplatform.v1.GetModelEvaluationSliceRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ModelEvaluationSlice.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetModelEvaluationSliceRequest,
          com.google.cloud.aiplatform.v1.ModelEvaluationSlice>
      getGetModelEvaluationSliceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetModelEvaluationSliceRequest,
            com.google.cloud.aiplatform.v1.ModelEvaluationSlice>
        getGetModelEvaluationSliceMethod;
    if ((getGetModelEvaluationSliceMethod = ModelServiceGrpc.getGetModelEvaluationSliceMethod)
        == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getGetModelEvaluationSliceMethod = ModelServiceGrpc.getGetModelEvaluationSliceMethod)
            == null) {
          ModelServiceGrpc.getGetModelEvaluationSliceMethod =
              getGetModelEvaluationSliceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetModelEvaluationSliceRequest,
                          com.google.cloud.aiplatform.v1.ModelEvaluationSlice>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetModelEvaluationSlice"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetModelEvaluationSliceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ModelEvaluationSlice
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelServiceMethodDescriptorSupplier("GetModelEvaluationSlice"))
                      .build();
        }
      }
    }
    return getGetModelEvaluationSliceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesRequest,
          com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesResponse>
      getListModelEvaluationSlicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListModelEvaluationSlices",
      requestType = com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesRequest,
          com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesResponse>
      getListModelEvaluationSlicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesRequest,
            com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesResponse>
        getListModelEvaluationSlicesMethod;
    if ((getListModelEvaluationSlicesMethod = ModelServiceGrpc.getListModelEvaluationSlicesMethod)
        == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getListModelEvaluationSlicesMethod =
                ModelServiceGrpc.getListModelEvaluationSlicesMethod)
            == null) {
          ModelServiceGrpc.getListModelEvaluationSlicesMethod =
              getListModelEvaluationSlicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesRequest,
                          com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListModelEvaluationSlices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelServiceMethodDescriptorSupplier("ListModelEvaluationSlices"))
                      .build();
        }
      }
    }
    return getListModelEvaluationSlicesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ModelServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelServiceStub>() {
          @java.lang.Override
          public ModelServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelServiceStub(channel, callOptions);
          }
        };
    return ModelServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ModelServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelServiceBlockingStub>() {
          @java.lang.Override
          public ModelServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelServiceBlockingStub(channel, callOptions);
          }
        };
    return ModelServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ModelServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelServiceFutureStub>() {
          @java.lang.Override
          public ModelServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelServiceFutureStub(channel, callOptions);
          }
        };
    return ModelServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for managing Vertex AI's machine learning Models.
   * </pre>
   */
  public abstract static class ModelServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Uploads a Model artifact into Vertex AI.
     * </pre>
     */
    public void uploadModel(
        com.google.cloud.aiplatform.v1.UploadModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUploadModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Model.
     * </pre>
     */
    public void getModel(
        com.google.cloud.aiplatform.v1.GetModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Model> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Models in a Location.
     * </pre>
     */
    public void listModels(
        com.google.cloud.aiplatform.v1.ListModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListModelsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListModelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists versions of the specified model.
     * </pre>
     */
    public void listModelVersions(
        com.google.cloud.aiplatform.v1.ListModelVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListModelVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListModelVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Model.
     * </pre>
     */
    public void updateModel(
        com.google.cloud.aiplatform.v1.UpdateModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Model> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Model.
     * A model cannot be deleted if any
     * [Endpoint][google.cloud.aiplatform.v1.Endpoint] resource has a
     * [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] based on the
     * model in its
     * [deployed_models][google.cloud.aiplatform.v1.Endpoint.deployed_models]
     * field.
     * </pre>
     */
    public void deleteModel(
        com.google.cloud.aiplatform.v1.DeleteModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Model version.
     * Model version can only be deleted if there are no [DeployedModels][]
     * created from it. Deleting the only version in the Model is not allowed. Use
     * [DeleteModel][google.cloud.aiplatform.v1.ModelService.DeleteModel] for
     * deleting the Model instead.
     * </pre>
     */
    public void deleteModelVersion(
        com.google.cloud.aiplatform.v1.DeleteModelVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteModelVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Merges a set of aliases for a Model version.
     * </pre>
     */
    public void mergeVersionAliases(
        com.google.cloud.aiplatform.v1.MergeVersionAliasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Model> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getMergeVersionAliasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports a trained, exportable Model to a location specified by the
     * user. A Model is considered to be exportable if it has at least one
     * [supported export
     * format][google.cloud.aiplatform.v1.Model.supported_export_formats].
     * </pre>
     */
    public void exportModel(
        com.google.cloud.aiplatform.v1.ExportModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports an externally generated ModelEvaluation.
     * </pre>
     */
    public void importModelEvaluation(
        com.google.cloud.aiplatform.v1.ImportModelEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ModelEvaluation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportModelEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports a list of externally generated ModelEvaluationSlice.
     * </pre>
     */
    public void batchImportModelEvaluationSlices(
        com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchImportModelEvaluationSlicesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelEvaluation.
     * </pre>
     */
    public void getModelEvaluation(
        com.google.cloud.aiplatform.v1.GetModelEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ModelEvaluation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetModelEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelEvaluations in a Model.
     * </pre>
     */
    public void listModelEvaluations(
        com.google.cloud.aiplatform.v1.ListModelEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListModelEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListModelEvaluationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelEvaluationSlice.
     * </pre>
     */
    public void getModelEvaluationSlice(
        com.google.cloud.aiplatform.v1.GetModelEvaluationSliceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ModelEvaluationSlice>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetModelEvaluationSliceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelEvaluationSlices in a ModelEvaluation.
     * </pre>
     */
    public void listModelEvaluationSlices(
        com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListModelEvaluationSlicesMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getUploadModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.UploadModelRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPLOAD_MODEL)))
          .addMethod(
              getGetModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.GetModelRequest,
                      com.google.cloud.aiplatform.v1.Model>(this, METHODID_GET_MODEL)))
          .addMethod(
              getListModelsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListModelsRequest,
                      com.google.cloud.aiplatform.v1.ListModelsResponse>(
                      this, METHODID_LIST_MODELS)))
          .addMethod(
              getListModelVersionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListModelVersionsRequest,
                      com.google.cloud.aiplatform.v1.ListModelVersionsResponse>(
                      this, METHODID_LIST_MODEL_VERSIONS)))
          .addMethod(
              getUpdateModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.UpdateModelRequest,
                      com.google.cloud.aiplatform.v1.Model>(this, METHODID_UPDATE_MODEL)))
          .addMethod(
              getDeleteModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.DeleteModelRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_MODEL)))
          .addMethod(
              getDeleteModelVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.DeleteModelVersionRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_MODEL_VERSION)))
          .addMethod(
              getMergeVersionAliasesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.MergeVersionAliasesRequest,
                      com.google.cloud.aiplatform.v1.Model>(this, METHODID_MERGE_VERSION_ALIASES)))
          .addMethod(
              getExportModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ExportModelRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_MODEL)))
          .addMethod(
              getImportModelEvaluationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ImportModelEvaluationRequest,
                      com.google.cloud.aiplatform.v1.ModelEvaluation>(
                      this, METHODID_IMPORT_MODEL_EVALUATION)))
          .addMethod(
              getBatchImportModelEvaluationSlicesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesRequest,
                      com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesResponse>(
                      this, METHODID_BATCH_IMPORT_MODEL_EVALUATION_SLICES)))
          .addMethod(
              getGetModelEvaluationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.GetModelEvaluationRequest,
                      com.google.cloud.aiplatform.v1.ModelEvaluation>(
                      this, METHODID_GET_MODEL_EVALUATION)))
          .addMethod(
              getListModelEvaluationsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListModelEvaluationsRequest,
                      com.google.cloud.aiplatform.v1.ListModelEvaluationsResponse>(
                      this, METHODID_LIST_MODEL_EVALUATIONS)))
          .addMethod(
              getGetModelEvaluationSliceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.GetModelEvaluationSliceRequest,
                      com.google.cloud.aiplatform.v1.ModelEvaluationSlice>(
                      this, METHODID_GET_MODEL_EVALUATION_SLICE)))
          .addMethod(
              getListModelEvaluationSlicesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesRequest,
                      com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesResponse>(
                      this, METHODID_LIST_MODEL_EVALUATION_SLICES)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A service for managing Vertex AI's machine learning Models.
   * </pre>
   */
  public static final class ModelServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ModelServiceStub> {
    private ModelServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a Model artifact into Vertex AI.
     * </pre>
     */
    public void uploadModel(
        com.google.cloud.aiplatform.v1.UploadModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUploadModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Model.
     * </pre>
     */
    public void getModel(
        com.google.cloud.aiplatform.v1.GetModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Model> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Models in a Location.
     * </pre>
     */
    public void listModels(
        com.google.cloud.aiplatform.v1.ListModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListModelsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListModelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists versions of the specified model.
     * </pre>
     */
    public void listModelVersions(
        com.google.cloud.aiplatform.v1.ListModelVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListModelVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListModelVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Model.
     * </pre>
     */
    public void updateModel(
        com.google.cloud.aiplatform.v1.UpdateModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Model> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Model.
     * A model cannot be deleted if any
     * [Endpoint][google.cloud.aiplatform.v1.Endpoint] resource has a
     * [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] based on the
     * model in its
     * [deployed_models][google.cloud.aiplatform.v1.Endpoint.deployed_models]
     * field.
     * </pre>
     */
    public void deleteModel(
        com.google.cloud.aiplatform.v1.DeleteModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Model version.
     * Model version can only be deleted if there are no [DeployedModels][]
     * created from it. Deleting the only version in the Model is not allowed. Use
     * [DeleteModel][google.cloud.aiplatform.v1.ModelService.DeleteModel] for
     * deleting the Model instead.
     * </pre>
     */
    public void deleteModelVersion(
        com.google.cloud.aiplatform.v1.DeleteModelVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteModelVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Merges a set of aliases for a Model version.
     * </pre>
     */
    public void mergeVersionAliases(
        com.google.cloud.aiplatform.v1.MergeVersionAliasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Model> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMergeVersionAliasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports a trained, exportable Model to a location specified by the
     * user. A Model is considered to be exportable if it has at least one
     * [supported export
     * format][google.cloud.aiplatform.v1.Model.supported_export_formats].
     * </pre>
     */
    public void exportModel(
        com.google.cloud.aiplatform.v1.ExportModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports an externally generated ModelEvaluation.
     * </pre>
     */
    public void importModelEvaluation(
        com.google.cloud.aiplatform.v1.ImportModelEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ModelEvaluation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportModelEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports a list of externally generated ModelEvaluationSlice.
     * </pre>
     */
    public void batchImportModelEvaluationSlices(
        com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchImportModelEvaluationSlicesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelEvaluation.
     * </pre>
     */
    public void getModelEvaluation(
        com.google.cloud.aiplatform.v1.GetModelEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ModelEvaluation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetModelEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelEvaluations in a Model.
     * </pre>
     */
    public void listModelEvaluations(
        com.google.cloud.aiplatform.v1.ListModelEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListModelEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListModelEvaluationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelEvaluationSlice.
     * </pre>
     */
    public void getModelEvaluationSlice(
        com.google.cloud.aiplatform.v1.GetModelEvaluationSliceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ModelEvaluationSlice>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetModelEvaluationSliceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelEvaluationSlices in a ModelEvaluation.
     * </pre>
     */
    public void listModelEvaluationSlices(
        com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListModelEvaluationSlicesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service for managing Vertex AI's machine learning Models.
   * </pre>
   */
  public static final class ModelServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ModelServiceBlockingStub> {
    private ModelServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a Model artifact into Vertex AI.
     * </pre>
     */
    public com.google.longrunning.Operation uploadModel(
        com.google.cloud.aiplatform.v1.UploadModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Model.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Model getModel(
        com.google.cloud.aiplatform.v1.GetModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Models in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListModelsResponse listModels(
        com.google.cloud.aiplatform.v1.ListModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListModelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists versions of the specified model.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListModelVersionsResponse listModelVersions(
        com.google.cloud.aiplatform.v1.ListModelVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListModelVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Model.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Model updateModel(
        com.google.cloud.aiplatform.v1.UpdateModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Model.
     * A model cannot be deleted if any
     * [Endpoint][google.cloud.aiplatform.v1.Endpoint] resource has a
     * [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] based on the
     * model in its
     * [deployed_models][google.cloud.aiplatform.v1.Endpoint.deployed_models]
     * field.
     * </pre>
     */
    public com.google.longrunning.Operation deleteModel(
        com.google.cloud.aiplatform.v1.DeleteModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Model version.
     * Model version can only be deleted if there are no [DeployedModels][]
     * created from it. Deleting the only version in the Model is not allowed. Use
     * [DeleteModel][google.cloud.aiplatform.v1.ModelService.DeleteModel] for
     * deleting the Model instead.
     * </pre>
     */
    public com.google.longrunning.Operation deleteModelVersion(
        com.google.cloud.aiplatform.v1.DeleteModelVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteModelVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Merges a set of aliases for a Model version.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Model mergeVersionAliases(
        com.google.cloud.aiplatform.v1.MergeVersionAliasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMergeVersionAliasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports a trained, exportable Model to a location specified by the
     * user. A Model is considered to be exportable if it has at least one
     * [supported export
     * format][google.cloud.aiplatform.v1.Model.supported_export_formats].
     * </pre>
     */
    public com.google.longrunning.Operation exportModel(
        com.google.cloud.aiplatform.v1.ExportModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports an externally generated ModelEvaluation.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ModelEvaluation importModelEvaluation(
        com.google.cloud.aiplatform.v1.ImportModelEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportModelEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports a list of externally generated ModelEvaluationSlice.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesResponse
        batchImportModelEvaluationSlices(
            com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchImportModelEvaluationSlicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelEvaluation.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ModelEvaluation getModelEvaluation(
        com.google.cloud.aiplatform.v1.GetModelEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetModelEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelEvaluations in a Model.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListModelEvaluationsResponse listModelEvaluations(
        com.google.cloud.aiplatform.v1.ListModelEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListModelEvaluationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelEvaluationSlice.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ModelEvaluationSlice getModelEvaluationSlice(
        com.google.cloud.aiplatform.v1.GetModelEvaluationSliceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetModelEvaluationSliceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelEvaluationSlices in a ModelEvaluation.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesResponse
        listModelEvaluationSlices(
            com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListModelEvaluationSlicesMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service for managing Vertex AI's machine learning Models.
   * </pre>
   */
  public static final class ModelServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ModelServiceFutureStub> {
    private ModelServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a Model artifact into Vertex AI.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        uploadModel(com.google.cloud.aiplatform.v1.UploadModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUploadModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.Model>
        getModel(com.google.cloud.aiplatform.v1.GetModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Models in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListModelsResponse>
        listModels(com.google.cloud.aiplatform.v1.ListModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListModelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists versions of the specified model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListModelVersionsResponse>
        listModelVersions(com.google.cloud.aiplatform.v1.ListModelVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListModelVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.Model>
        updateModel(com.google.cloud.aiplatform.v1.UpdateModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Model.
     * A model cannot be deleted if any
     * [Endpoint][google.cloud.aiplatform.v1.Endpoint] resource has a
     * [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] based on the
     * model in its
     * [deployed_models][google.cloud.aiplatform.v1.Endpoint.deployed_models]
     * field.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteModel(com.google.cloud.aiplatform.v1.DeleteModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Model version.
     * Model version can only be deleted if there are no [DeployedModels][]
     * created from it. Deleting the only version in the Model is not allowed. Use
     * [DeleteModel][google.cloud.aiplatform.v1.ModelService.DeleteModel] for
     * deleting the Model instead.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteModelVersion(com.google.cloud.aiplatform.v1.DeleteModelVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteModelVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Merges a set of aliases for a Model version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.Model>
        mergeVersionAliases(com.google.cloud.aiplatform.v1.MergeVersionAliasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMergeVersionAliasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports a trained, exportable Model to a location specified by the
     * user. A Model is considered to be exportable if it has at least one
     * [supported export
     * format][google.cloud.aiplatform.v1.Model.supported_export_formats].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportModel(com.google.cloud.aiplatform.v1.ExportModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports an externally generated ModelEvaluation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ModelEvaluation>
        importModelEvaluation(com.google.cloud.aiplatform.v1.ImportModelEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportModelEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports a list of externally generated ModelEvaluationSlice.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesResponse>
        batchImportModelEvaluationSlices(
            com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchImportModelEvaluationSlicesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelEvaluation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ModelEvaluation>
        getModelEvaluation(com.google.cloud.aiplatform.v1.GetModelEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetModelEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelEvaluations in a Model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListModelEvaluationsResponse>
        listModelEvaluations(com.google.cloud.aiplatform.v1.ListModelEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListModelEvaluationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ModelEvaluationSlice.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ModelEvaluationSlice>
        getModelEvaluationSlice(
            com.google.cloud.aiplatform.v1.GetModelEvaluationSliceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetModelEvaluationSliceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ModelEvaluationSlices in a ModelEvaluation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesResponse>
        listModelEvaluationSlices(
            com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListModelEvaluationSlicesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPLOAD_MODEL = 0;
  private static final int METHODID_GET_MODEL = 1;
  private static final int METHODID_LIST_MODELS = 2;
  private static final int METHODID_LIST_MODEL_VERSIONS = 3;
  private static final int METHODID_UPDATE_MODEL = 4;
  private static final int METHODID_DELETE_MODEL = 5;
  private static final int METHODID_DELETE_MODEL_VERSION = 6;
  private static final int METHODID_MERGE_VERSION_ALIASES = 7;
  private static final int METHODID_EXPORT_MODEL = 8;
  private static final int METHODID_IMPORT_MODEL_EVALUATION = 9;
  private static final int METHODID_BATCH_IMPORT_MODEL_EVALUATION_SLICES = 10;
  private static final int METHODID_GET_MODEL_EVALUATION = 11;
  private static final int METHODID_LIST_MODEL_EVALUATIONS = 12;
  private static final int METHODID_GET_MODEL_EVALUATION_SLICE = 13;
  private static final int METHODID_LIST_MODEL_EVALUATION_SLICES = 14;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ModelServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ModelServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD_MODEL:
          serviceImpl.uploadModel(
              (com.google.cloud.aiplatform.v1.UploadModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_MODEL:
          serviceImpl.getModel(
              (com.google.cloud.aiplatform.v1.GetModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Model>) responseObserver);
          break;
        case METHODID_LIST_MODELS:
          serviceImpl.listModels(
              (com.google.cloud.aiplatform.v1.ListModelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListModelsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_MODEL_VERSIONS:
          serviceImpl.listModelVersions(
              (com.google.cloud.aiplatform.v1.ListModelVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.ListModelVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_MODEL:
          serviceImpl.updateModel(
              (com.google.cloud.aiplatform.v1.UpdateModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Model>) responseObserver);
          break;
        case METHODID_DELETE_MODEL:
          serviceImpl.deleteModel(
              (com.google.cloud.aiplatform.v1.DeleteModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MODEL_VERSION:
          serviceImpl.deleteModelVersion(
              (com.google.cloud.aiplatform.v1.DeleteModelVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_MERGE_VERSION_ALIASES:
          serviceImpl.mergeVersionAliases(
              (com.google.cloud.aiplatform.v1.MergeVersionAliasesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Model>) responseObserver);
          break;
        case METHODID_EXPORT_MODEL:
          serviceImpl.exportModel(
              (com.google.cloud.aiplatform.v1.ExportModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_MODEL_EVALUATION:
          serviceImpl.importModelEvaluation(
              (com.google.cloud.aiplatform.v1.ImportModelEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ModelEvaluation>)
                  responseObserver);
          break;
        case METHODID_BATCH_IMPORT_MODEL_EVALUATION_SLICES:
          serviceImpl.batchImportModelEvaluationSlices(
              (com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.BatchImportModelEvaluationSlicesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MODEL_EVALUATION:
          serviceImpl.getModelEvaluation(
              (com.google.cloud.aiplatform.v1.GetModelEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ModelEvaluation>)
                  responseObserver);
          break;
        case METHODID_LIST_MODEL_EVALUATIONS:
          serviceImpl.listModelEvaluations(
              (com.google.cloud.aiplatform.v1.ListModelEvaluationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.ListModelEvaluationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MODEL_EVALUATION_SLICE:
          serviceImpl.getModelEvaluationSlice(
              (com.google.cloud.aiplatform.v1.GetModelEvaluationSliceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ModelEvaluationSlice>)
                  responseObserver);
          break;
        case METHODID_LIST_MODEL_EVALUATION_SLICES:
          serviceImpl.listModelEvaluationSlices(
              (com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesResponse>)
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

  private abstract static class ModelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ModelServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.ModelServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ModelService");
    }
  }

  private static final class ModelServiceFileDescriptorSupplier
      extends ModelServiceBaseDescriptorSupplier {
    ModelServiceFileDescriptorSupplier() {}
  }

  private static final class ModelServiceMethodDescriptorSupplier
      extends ModelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ModelServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ModelServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ModelServiceFileDescriptorSupplier())
                      .addMethod(getUploadModelMethod())
                      .addMethod(getGetModelMethod())
                      .addMethod(getListModelsMethod())
                      .addMethod(getListModelVersionsMethod())
                      .addMethod(getUpdateModelMethod())
                      .addMethod(getDeleteModelMethod())
                      .addMethod(getDeleteModelVersionMethod())
                      .addMethod(getMergeVersionAliasesMethod())
                      .addMethod(getExportModelMethod())
                      .addMethod(getImportModelEvaluationMethod())
                      .addMethod(getBatchImportModelEvaluationSlicesMethod())
                      .addMethod(getGetModelEvaluationMethod())
                      .addMethod(getListModelEvaluationsMethod())
                      .addMethod(getGetModelEvaluationSliceMethod())
                      .addMethod(getListModelEvaluationSlicesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
