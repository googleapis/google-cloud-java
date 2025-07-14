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
package com.google.cloud.storageinsights.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/storageinsights/v1/storageinsights.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StorageInsightsGrpc {

  private StorageInsightsGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.storageinsights.v1.StorageInsights";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.ListReportConfigsRequest,
          com.google.cloud.storageinsights.v1.ListReportConfigsResponse>
      getListReportConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReportConfigs",
      requestType = com.google.cloud.storageinsights.v1.ListReportConfigsRequest.class,
      responseType = com.google.cloud.storageinsights.v1.ListReportConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.ListReportConfigsRequest,
          com.google.cloud.storageinsights.v1.ListReportConfigsResponse>
      getListReportConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.ListReportConfigsRequest,
            com.google.cloud.storageinsights.v1.ListReportConfigsResponse>
        getListReportConfigsMethod;
    if ((getListReportConfigsMethod = StorageInsightsGrpc.getListReportConfigsMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getListReportConfigsMethod = StorageInsightsGrpc.getListReportConfigsMethod) == null) {
          StorageInsightsGrpc.getListReportConfigsMethod =
              getListReportConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.ListReportConfigsRequest,
                          com.google.cloud.storageinsights.v1.ListReportConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReportConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.ListReportConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.ListReportConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("ListReportConfigs"))
                      .build();
        }
      }
    }
    return getListReportConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.GetReportConfigRequest,
          com.google.cloud.storageinsights.v1.ReportConfig>
      getGetReportConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReportConfig",
      requestType = com.google.cloud.storageinsights.v1.GetReportConfigRequest.class,
      responseType = com.google.cloud.storageinsights.v1.ReportConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.GetReportConfigRequest,
          com.google.cloud.storageinsights.v1.ReportConfig>
      getGetReportConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.GetReportConfigRequest,
            com.google.cloud.storageinsights.v1.ReportConfig>
        getGetReportConfigMethod;
    if ((getGetReportConfigMethod = StorageInsightsGrpc.getGetReportConfigMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getGetReportConfigMethod = StorageInsightsGrpc.getGetReportConfigMethod) == null) {
          StorageInsightsGrpc.getGetReportConfigMethod =
              getGetReportConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.GetReportConfigRequest,
                          com.google.cloud.storageinsights.v1.ReportConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReportConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.GetReportConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.ReportConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("GetReportConfig"))
                      .build();
        }
      }
    }
    return getGetReportConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.CreateReportConfigRequest,
          com.google.cloud.storageinsights.v1.ReportConfig>
      getCreateReportConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReportConfig",
      requestType = com.google.cloud.storageinsights.v1.CreateReportConfigRequest.class,
      responseType = com.google.cloud.storageinsights.v1.ReportConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.CreateReportConfigRequest,
          com.google.cloud.storageinsights.v1.ReportConfig>
      getCreateReportConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.CreateReportConfigRequest,
            com.google.cloud.storageinsights.v1.ReportConfig>
        getCreateReportConfigMethod;
    if ((getCreateReportConfigMethod = StorageInsightsGrpc.getCreateReportConfigMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getCreateReportConfigMethod = StorageInsightsGrpc.getCreateReportConfigMethod)
            == null) {
          StorageInsightsGrpc.getCreateReportConfigMethod =
              getCreateReportConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.CreateReportConfigRequest,
                          com.google.cloud.storageinsights.v1.ReportConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReportConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.CreateReportConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.ReportConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("CreateReportConfig"))
                      .build();
        }
      }
    }
    return getCreateReportConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.UpdateReportConfigRequest,
          com.google.cloud.storageinsights.v1.ReportConfig>
      getUpdateReportConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateReportConfig",
      requestType = com.google.cloud.storageinsights.v1.UpdateReportConfigRequest.class,
      responseType = com.google.cloud.storageinsights.v1.ReportConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.UpdateReportConfigRequest,
          com.google.cloud.storageinsights.v1.ReportConfig>
      getUpdateReportConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.UpdateReportConfigRequest,
            com.google.cloud.storageinsights.v1.ReportConfig>
        getUpdateReportConfigMethod;
    if ((getUpdateReportConfigMethod = StorageInsightsGrpc.getUpdateReportConfigMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getUpdateReportConfigMethod = StorageInsightsGrpc.getUpdateReportConfigMethod)
            == null) {
          StorageInsightsGrpc.getUpdateReportConfigMethod =
              getUpdateReportConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.UpdateReportConfigRequest,
                          com.google.cloud.storageinsights.v1.ReportConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateReportConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.UpdateReportConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.ReportConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("UpdateReportConfig"))
                      .build();
        }
      }
    }
    return getUpdateReportConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.DeleteReportConfigRequest, com.google.protobuf.Empty>
      getDeleteReportConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReportConfig",
      requestType = com.google.cloud.storageinsights.v1.DeleteReportConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.DeleteReportConfigRequest, com.google.protobuf.Empty>
      getDeleteReportConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.DeleteReportConfigRequest,
            com.google.protobuf.Empty>
        getDeleteReportConfigMethod;
    if ((getDeleteReportConfigMethod = StorageInsightsGrpc.getDeleteReportConfigMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getDeleteReportConfigMethod = StorageInsightsGrpc.getDeleteReportConfigMethod)
            == null) {
          StorageInsightsGrpc.getDeleteReportConfigMethod =
              getDeleteReportConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.DeleteReportConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteReportConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.DeleteReportConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("DeleteReportConfig"))
                      .build();
        }
      }
    }
    return getDeleteReportConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.ListReportDetailsRequest,
          com.google.cloud.storageinsights.v1.ListReportDetailsResponse>
      getListReportDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReportDetails",
      requestType = com.google.cloud.storageinsights.v1.ListReportDetailsRequest.class,
      responseType = com.google.cloud.storageinsights.v1.ListReportDetailsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.ListReportDetailsRequest,
          com.google.cloud.storageinsights.v1.ListReportDetailsResponse>
      getListReportDetailsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.ListReportDetailsRequest,
            com.google.cloud.storageinsights.v1.ListReportDetailsResponse>
        getListReportDetailsMethod;
    if ((getListReportDetailsMethod = StorageInsightsGrpc.getListReportDetailsMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getListReportDetailsMethod = StorageInsightsGrpc.getListReportDetailsMethod) == null) {
          StorageInsightsGrpc.getListReportDetailsMethod =
              getListReportDetailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.ListReportDetailsRequest,
                          com.google.cloud.storageinsights.v1.ListReportDetailsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReportDetails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.ListReportDetailsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.ListReportDetailsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("ListReportDetails"))
                      .build();
        }
      }
    }
    return getListReportDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.GetReportDetailRequest,
          com.google.cloud.storageinsights.v1.ReportDetail>
      getGetReportDetailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReportDetail",
      requestType = com.google.cloud.storageinsights.v1.GetReportDetailRequest.class,
      responseType = com.google.cloud.storageinsights.v1.ReportDetail.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.GetReportDetailRequest,
          com.google.cloud.storageinsights.v1.ReportDetail>
      getGetReportDetailMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.GetReportDetailRequest,
            com.google.cloud.storageinsights.v1.ReportDetail>
        getGetReportDetailMethod;
    if ((getGetReportDetailMethod = StorageInsightsGrpc.getGetReportDetailMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getGetReportDetailMethod = StorageInsightsGrpc.getGetReportDetailMethod) == null) {
          StorageInsightsGrpc.getGetReportDetailMethod =
              getGetReportDetailMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.GetReportDetailRequest,
                          com.google.cloud.storageinsights.v1.ReportDetail>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReportDetail"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.GetReportDetailRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.ReportDetail
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("GetReportDetail"))
                      .build();
        }
      }
    }
    return getGetReportDetailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest,
          com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse>
      getListDatasetConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatasetConfigs",
      requestType = com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest.class,
      responseType = com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest,
          com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse>
      getListDatasetConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest,
            com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse>
        getListDatasetConfigsMethod;
    if ((getListDatasetConfigsMethod = StorageInsightsGrpc.getListDatasetConfigsMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getListDatasetConfigsMethod = StorageInsightsGrpc.getListDatasetConfigsMethod)
            == null) {
          StorageInsightsGrpc.getListDatasetConfigsMethod =
              getListDatasetConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest,
                          com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatasetConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("ListDatasetConfigs"))
                      .build();
        }
      }
    }
    return getListDatasetConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.GetDatasetConfigRequest,
          com.google.cloud.storageinsights.v1.DatasetConfig>
      getGetDatasetConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDatasetConfig",
      requestType = com.google.cloud.storageinsights.v1.GetDatasetConfigRequest.class,
      responseType = com.google.cloud.storageinsights.v1.DatasetConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.GetDatasetConfigRequest,
          com.google.cloud.storageinsights.v1.DatasetConfig>
      getGetDatasetConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.GetDatasetConfigRequest,
            com.google.cloud.storageinsights.v1.DatasetConfig>
        getGetDatasetConfigMethod;
    if ((getGetDatasetConfigMethod = StorageInsightsGrpc.getGetDatasetConfigMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getGetDatasetConfigMethod = StorageInsightsGrpc.getGetDatasetConfigMethod) == null) {
          StorageInsightsGrpc.getGetDatasetConfigMethod =
              getGetDatasetConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.GetDatasetConfigRequest,
                          com.google.cloud.storageinsights.v1.DatasetConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDatasetConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.GetDatasetConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.DatasetConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("GetDatasetConfig"))
                      .build();
        }
      }
    }
    return getGetDatasetConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest,
          com.google.longrunning.Operation>
      getCreateDatasetConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDatasetConfig",
      requestType = com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest,
          com.google.longrunning.Operation>
      getCreateDatasetConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest,
            com.google.longrunning.Operation>
        getCreateDatasetConfigMethod;
    if ((getCreateDatasetConfigMethod = StorageInsightsGrpc.getCreateDatasetConfigMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getCreateDatasetConfigMethod = StorageInsightsGrpc.getCreateDatasetConfigMethod)
            == null) {
          StorageInsightsGrpc.getCreateDatasetConfigMethod =
              getCreateDatasetConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDatasetConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("CreateDatasetConfig"))
                      .build();
        }
      }
    }
    return getCreateDatasetConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest,
          com.google.longrunning.Operation>
      getUpdateDatasetConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDatasetConfig",
      requestType = com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest,
          com.google.longrunning.Operation>
      getUpdateDatasetConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest,
            com.google.longrunning.Operation>
        getUpdateDatasetConfigMethod;
    if ((getUpdateDatasetConfigMethod = StorageInsightsGrpc.getUpdateDatasetConfigMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getUpdateDatasetConfigMethod = StorageInsightsGrpc.getUpdateDatasetConfigMethod)
            == null) {
          StorageInsightsGrpc.getUpdateDatasetConfigMethod =
              getUpdateDatasetConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDatasetConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("UpdateDatasetConfig"))
                      .build();
        }
      }
    }
    return getUpdateDatasetConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest,
          com.google.longrunning.Operation>
      getDeleteDatasetConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDatasetConfig",
      requestType = com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest,
          com.google.longrunning.Operation>
      getDeleteDatasetConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest,
            com.google.longrunning.Operation>
        getDeleteDatasetConfigMethod;
    if ((getDeleteDatasetConfigMethod = StorageInsightsGrpc.getDeleteDatasetConfigMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getDeleteDatasetConfigMethod = StorageInsightsGrpc.getDeleteDatasetConfigMethod)
            == null) {
          StorageInsightsGrpc.getDeleteDatasetConfigMethod =
              getDeleteDatasetConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDatasetConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("DeleteDatasetConfig"))
                      .build();
        }
      }
    }
    return getDeleteDatasetConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.LinkDatasetRequest, com.google.longrunning.Operation>
      getLinkDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LinkDataset",
      requestType = com.google.cloud.storageinsights.v1.LinkDatasetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.LinkDatasetRequest, com.google.longrunning.Operation>
      getLinkDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.LinkDatasetRequest,
            com.google.longrunning.Operation>
        getLinkDatasetMethod;
    if ((getLinkDatasetMethod = StorageInsightsGrpc.getLinkDatasetMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getLinkDatasetMethod = StorageInsightsGrpc.getLinkDatasetMethod) == null) {
          StorageInsightsGrpc.getLinkDatasetMethod =
              getLinkDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.LinkDatasetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LinkDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.LinkDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("LinkDataset"))
                      .build();
        }
      }
    }
    return getLinkDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.UnlinkDatasetRequest,
          com.google.longrunning.Operation>
      getUnlinkDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnlinkDataset",
      requestType = com.google.cloud.storageinsights.v1.UnlinkDatasetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storageinsights.v1.UnlinkDatasetRequest,
          com.google.longrunning.Operation>
      getUnlinkDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storageinsights.v1.UnlinkDatasetRequest,
            com.google.longrunning.Operation>
        getUnlinkDatasetMethod;
    if ((getUnlinkDatasetMethod = StorageInsightsGrpc.getUnlinkDatasetMethod) == null) {
      synchronized (StorageInsightsGrpc.class) {
        if ((getUnlinkDatasetMethod = StorageInsightsGrpc.getUnlinkDatasetMethod) == null) {
          StorageInsightsGrpc.getUnlinkDatasetMethod =
              getUnlinkDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storageinsights.v1.UnlinkDatasetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnlinkDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storageinsights.v1.UnlinkDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageInsightsMethodDescriptorSupplier("UnlinkDataset"))
                      .build();
        }
      }
    }
    return getUnlinkDatasetMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static StorageInsightsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageInsightsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageInsightsStub>() {
          @java.lang.Override
          public StorageInsightsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageInsightsStub(channel, callOptions);
          }
        };
    return StorageInsightsStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static StorageInsightsBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageInsightsBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageInsightsBlockingV2Stub>() {
          @java.lang.Override
          public StorageInsightsBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageInsightsBlockingV2Stub(channel, callOptions);
          }
        };
    return StorageInsightsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StorageInsightsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageInsightsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageInsightsBlockingStub>() {
          @java.lang.Override
          public StorageInsightsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageInsightsBlockingStub(channel, callOptions);
          }
        };
    return StorageInsightsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static StorageInsightsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageInsightsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageInsightsFutureStub>() {
          @java.lang.Override
          public StorageInsightsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageInsightsFutureStub(channel, callOptions);
          }
        };
    return StorageInsightsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists ReportConfigs in a given project and location.
     * </pre>
     */
    default void listReportConfigs(
        com.google.cloud.storageinsights.v1.ListReportConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ListReportConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReportConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReportConfig.
     * </pre>
     */
    default void getReportConfig(
        com.google.cloud.storageinsights.v1.GetReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ReportConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetReportConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ReportConfig in a given project and location.
     * </pre>
     */
    default void createReportConfig(
        com.google.cloud.storageinsights.v1.CreateReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ReportConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReportConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ReportConfig.
     * </pre>
     */
    default void updateReportConfig(
        com.google.cloud.storageinsights.v1.UpdateReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ReportConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateReportConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ReportConfig.
     * </pre>
     */
    default void deleteReportConfig(
        com.google.cloud.storageinsights.v1.DeleteReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteReportConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ReportDetails in a given project and location.
     * </pre>
     */
    default void listReportDetails(
        com.google.cloud.storageinsights.v1.ListReportDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ListReportDetailsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReportDetailsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReportDetail.
     * </pre>
     */
    default void getReportDetail(
        com.google.cloud.storageinsights.v1.GetReportDetailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ReportDetail>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetReportDetailMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the dataset configurations in a given project for a given location.
     * </pre>
     */
    default void listDatasetConfigs(
        com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatasetConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the dataset configuration in a given project for a given location.
     * </pre>
     */
    default void getDatasetConfig(
        com.google.cloud.storageinsights.v1.GetDatasetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.DatasetConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDatasetConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataset configuration in a given project for a given location.
     * </pre>
     */
    default void createDatasetConfig(
        com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDatasetConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a dataset configuration in a given project for a given location.
     * </pre>
     */
    default void updateDatasetConfig(
        com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDatasetConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset configuration in a given project for a given location.
     * </pre>
     */
    default void deleteDatasetConfig(
        com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDatasetConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Links a dataset to BigQuery in a given project for a given location.
     * </pre>
     */
    default void linkDataset(
        com.google.cloud.storageinsights.v1.LinkDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLinkDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Unlinks a dataset from BigQuery in a given project
     * for a given location.
     * </pre>
     */
    default void unlinkDataset(
        com.google.cloud.storageinsights.v1.UnlinkDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUnlinkDatasetMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StorageInsights.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class StorageInsightsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return StorageInsightsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StorageInsights.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class StorageInsightsStub
      extends io.grpc.stub.AbstractAsyncStub<StorageInsightsStub> {
    private StorageInsightsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageInsightsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageInsightsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ReportConfigs in a given project and location.
     * </pre>
     */
    public void listReportConfigs(
        com.google.cloud.storageinsights.v1.ListReportConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ListReportConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReportConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReportConfig.
     * </pre>
     */
    public void getReportConfig(
        com.google.cloud.storageinsights.v1.GetReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ReportConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReportConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ReportConfig in a given project and location.
     * </pre>
     */
    public void createReportConfig(
        com.google.cloud.storageinsights.v1.CreateReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ReportConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReportConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ReportConfig.
     * </pre>
     */
    public void updateReportConfig(
        com.google.cloud.storageinsights.v1.UpdateReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ReportConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateReportConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ReportConfig.
     * </pre>
     */
    public void deleteReportConfig(
        com.google.cloud.storageinsights.v1.DeleteReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteReportConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ReportDetails in a given project and location.
     * </pre>
     */
    public void listReportDetails(
        com.google.cloud.storageinsights.v1.ListReportDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ListReportDetailsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReportDetailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReportDetail.
     * </pre>
     */
    public void getReportDetail(
        com.google.cloud.storageinsights.v1.GetReportDetailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ReportDetail>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReportDetailMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the dataset configurations in a given project for a given location.
     * </pre>
     */
    public void listDatasetConfigs(
        com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatasetConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the dataset configuration in a given project for a given location.
     * </pre>
     */
    public void getDatasetConfig(
        com.google.cloud.storageinsights.v1.GetDatasetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.DatasetConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatasetConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataset configuration in a given project for a given location.
     * </pre>
     */
    public void createDatasetConfig(
        com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDatasetConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a dataset configuration in a given project for a given location.
     * </pre>
     */
    public void updateDatasetConfig(
        com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDatasetConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset configuration in a given project for a given location.
     * </pre>
     */
    public void deleteDatasetConfig(
        com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDatasetConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Links a dataset to BigQuery in a given project for a given location.
     * </pre>
     */
    public void linkDataset(
        com.google.cloud.storageinsights.v1.LinkDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLinkDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Unlinks a dataset from BigQuery in a given project
     * for a given location.
     * </pre>
     */
    public void unlinkDataset(
        com.google.cloud.storageinsights.v1.UnlinkDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnlinkDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StorageInsights.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class StorageInsightsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<StorageInsightsBlockingV2Stub> {
    private StorageInsightsBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageInsightsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageInsightsBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ReportConfigs in a given project and location.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ListReportConfigsResponse listReportConfigs(
        com.google.cloud.storageinsights.v1.ListReportConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReportConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReportConfig.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ReportConfig getReportConfig(
        com.google.cloud.storageinsights.v1.GetReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReportConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ReportConfig in a given project and location.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ReportConfig createReportConfig(
        com.google.cloud.storageinsights.v1.CreateReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReportConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ReportConfig.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ReportConfig updateReportConfig(
        com.google.cloud.storageinsights.v1.UpdateReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateReportConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ReportConfig.
     * </pre>
     */
    public com.google.protobuf.Empty deleteReportConfig(
        com.google.cloud.storageinsights.v1.DeleteReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReportConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ReportDetails in a given project and location.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ListReportDetailsResponse listReportDetails(
        com.google.cloud.storageinsights.v1.ListReportDetailsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReportDetailsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReportDetail.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ReportDetail getReportDetail(
        com.google.cloud.storageinsights.v1.GetReportDetailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReportDetailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the dataset configurations in a given project for a given location.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse listDatasetConfigs(
        com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatasetConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the dataset configuration in a given project for a given location.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.DatasetConfig getDatasetConfig(
        com.google.cloud.storageinsights.v1.GetDatasetConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatasetConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataset configuration in a given project for a given location.
     * </pre>
     */
    public com.google.longrunning.Operation createDatasetConfig(
        com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatasetConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a dataset configuration in a given project for a given location.
     * </pre>
     */
    public com.google.longrunning.Operation updateDatasetConfig(
        com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDatasetConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset configuration in a given project for a given location.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDatasetConfig(
        com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDatasetConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Links a dataset to BigQuery in a given project for a given location.
     * </pre>
     */
    public com.google.longrunning.Operation linkDataset(
        com.google.cloud.storageinsights.v1.LinkDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLinkDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Unlinks a dataset from BigQuery in a given project
     * for a given location.
     * </pre>
     */
    public com.google.longrunning.Operation unlinkDataset(
        com.google.cloud.storageinsights.v1.UnlinkDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnlinkDatasetMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service StorageInsights.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class StorageInsightsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StorageInsightsBlockingStub> {
    private StorageInsightsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageInsightsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageInsightsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ReportConfigs in a given project and location.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ListReportConfigsResponse listReportConfigs(
        com.google.cloud.storageinsights.v1.ListReportConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReportConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReportConfig.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ReportConfig getReportConfig(
        com.google.cloud.storageinsights.v1.GetReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReportConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ReportConfig in a given project and location.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ReportConfig createReportConfig(
        com.google.cloud.storageinsights.v1.CreateReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReportConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ReportConfig.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ReportConfig updateReportConfig(
        com.google.cloud.storageinsights.v1.UpdateReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateReportConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ReportConfig.
     * </pre>
     */
    public com.google.protobuf.Empty deleteReportConfig(
        com.google.cloud.storageinsights.v1.DeleteReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReportConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ReportDetails in a given project and location.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ListReportDetailsResponse listReportDetails(
        com.google.cloud.storageinsights.v1.ListReportDetailsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReportDetailsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReportDetail.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ReportDetail getReportDetail(
        com.google.cloud.storageinsights.v1.GetReportDetailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReportDetailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the dataset configurations in a given project for a given location.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse listDatasetConfigs(
        com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatasetConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the dataset configuration in a given project for a given location.
     * </pre>
     */
    public com.google.cloud.storageinsights.v1.DatasetConfig getDatasetConfig(
        com.google.cloud.storageinsights.v1.GetDatasetConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatasetConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataset configuration in a given project for a given location.
     * </pre>
     */
    public com.google.longrunning.Operation createDatasetConfig(
        com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatasetConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a dataset configuration in a given project for a given location.
     * </pre>
     */
    public com.google.longrunning.Operation updateDatasetConfig(
        com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDatasetConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset configuration in a given project for a given location.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDatasetConfig(
        com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDatasetConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Links a dataset to BigQuery in a given project for a given location.
     * </pre>
     */
    public com.google.longrunning.Operation linkDataset(
        com.google.cloud.storageinsights.v1.LinkDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLinkDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Unlinks a dataset from BigQuery in a given project
     * for a given location.
     * </pre>
     */
    public com.google.longrunning.Operation unlinkDataset(
        com.google.cloud.storageinsights.v1.UnlinkDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnlinkDatasetMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StorageInsights.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class StorageInsightsFutureStub
      extends io.grpc.stub.AbstractFutureStub<StorageInsightsFutureStub> {
    private StorageInsightsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageInsightsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageInsightsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ReportConfigs in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.storageinsights.v1.ListReportConfigsResponse>
        listReportConfigs(com.google.cloud.storageinsights.v1.ListReportConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReportConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReportConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.storageinsights.v1.ReportConfig>
        getReportConfig(com.google.cloud.storageinsights.v1.GetReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReportConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ReportConfig in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.storageinsights.v1.ReportConfig>
        createReportConfig(com.google.cloud.storageinsights.v1.CreateReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReportConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ReportConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.storageinsights.v1.ReportConfig>
        updateReportConfig(com.google.cloud.storageinsights.v1.UpdateReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateReportConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ReportConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteReportConfig(com.google.cloud.storageinsights.v1.DeleteReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteReportConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ReportDetails in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.storageinsights.v1.ListReportDetailsResponse>
        listReportDetails(com.google.cloud.storageinsights.v1.ListReportDetailsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReportDetailsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReportDetail.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.storageinsights.v1.ReportDetail>
        getReportDetail(com.google.cloud.storageinsights.v1.GetReportDetailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReportDetailMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the dataset configurations in a given project for a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse>
        listDatasetConfigs(com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatasetConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the dataset configuration in a given project for a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.storageinsights.v1.DatasetConfig>
        getDatasetConfig(com.google.cloud.storageinsights.v1.GetDatasetConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatasetConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataset configuration in a given project for a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDatasetConfig(
            com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDatasetConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a dataset configuration in a given project for a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDatasetConfig(
            com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDatasetConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset configuration in a given project for a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDatasetConfig(
            com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDatasetConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Links a dataset to BigQuery in a given project for a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        linkDataset(com.google.cloud.storageinsights.v1.LinkDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLinkDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Unlinks a dataset from BigQuery in a given project
     * for a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        unlinkDataset(com.google.cloud.storageinsights.v1.UnlinkDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnlinkDatasetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_REPORT_CONFIGS = 0;
  private static final int METHODID_GET_REPORT_CONFIG = 1;
  private static final int METHODID_CREATE_REPORT_CONFIG = 2;
  private static final int METHODID_UPDATE_REPORT_CONFIG = 3;
  private static final int METHODID_DELETE_REPORT_CONFIG = 4;
  private static final int METHODID_LIST_REPORT_DETAILS = 5;
  private static final int METHODID_GET_REPORT_DETAIL = 6;
  private static final int METHODID_LIST_DATASET_CONFIGS = 7;
  private static final int METHODID_GET_DATASET_CONFIG = 8;
  private static final int METHODID_CREATE_DATASET_CONFIG = 9;
  private static final int METHODID_UPDATE_DATASET_CONFIG = 10;
  private static final int METHODID_DELETE_DATASET_CONFIG = 11;
  private static final int METHODID_LINK_DATASET = 12;
  private static final int METHODID_UNLINK_DATASET = 13;

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
        case METHODID_LIST_REPORT_CONFIGS:
          serviceImpl.listReportConfigs(
              (com.google.cloud.storageinsights.v1.ListReportConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.storageinsights.v1.ListReportConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REPORT_CONFIG:
          serviceImpl.getReportConfig(
              (com.google.cloud.storageinsights.v1.GetReportConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ReportConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_REPORT_CONFIG:
          serviceImpl.createReportConfig(
              (com.google.cloud.storageinsights.v1.CreateReportConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ReportConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_REPORT_CONFIG:
          serviceImpl.updateReportConfig(
              (com.google.cloud.storageinsights.v1.UpdateReportConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ReportConfig>)
                  responseObserver);
          break;
        case METHODID_DELETE_REPORT_CONFIG:
          serviceImpl.deleteReportConfig(
              (com.google.cloud.storageinsights.v1.DeleteReportConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_REPORT_DETAILS:
          serviceImpl.listReportDetails(
              (com.google.cloud.storageinsights.v1.ListReportDetailsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.storageinsights.v1.ListReportDetailsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REPORT_DETAIL:
          serviceImpl.getReportDetail(
              (com.google.cloud.storageinsights.v1.GetReportDetailRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.ReportDetail>)
                  responseObserver);
          break;
        case METHODID_LIST_DATASET_CONFIGS:
          serviceImpl.listDatasetConfigs(
              (com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATASET_CONFIG:
          serviceImpl.getDatasetConfig(
              (com.google.cloud.storageinsights.v1.GetDatasetConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.storageinsights.v1.DatasetConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATASET_CONFIG:
          serviceImpl.createDatasetConfig(
              (com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DATASET_CONFIG:
          serviceImpl.updateDatasetConfig(
              (com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DATASET_CONFIG:
          serviceImpl.deleteDatasetConfig(
              (com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LINK_DATASET:
          serviceImpl.linkDataset(
              (com.google.cloud.storageinsights.v1.LinkDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNLINK_DATASET:
          serviceImpl.unlinkDataset(
              (com.google.cloud.storageinsights.v1.UnlinkDatasetRequest) request,
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
            getListReportConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.ListReportConfigsRequest,
                    com.google.cloud.storageinsights.v1.ListReportConfigsResponse>(
                    service, METHODID_LIST_REPORT_CONFIGS)))
        .addMethod(
            getGetReportConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.GetReportConfigRequest,
                    com.google.cloud.storageinsights.v1.ReportConfig>(
                    service, METHODID_GET_REPORT_CONFIG)))
        .addMethod(
            getCreateReportConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.CreateReportConfigRequest,
                    com.google.cloud.storageinsights.v1.ReportConfig>(
                    service, METHODID_CREATE_REPORT_CONFIG)))
        .addMethod(
            getUpdateReportConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.UpdateReportConfigRequest,
                    com.google.cloud.storageinsights.v1.ReportConfig>(
                    service, METHODID_UPDATE_REPORT_CONFIG)))
        .addMethod(
            getDeleteReportConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.DeleteReportConfigRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_REPORT_CONFIG)))
        .addMethod(
            getListReportDetailsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.ListReportDetailsRequest,
                    com.google.cloud.storageinsights.v1.ListReportDetailsResponse>(
                    service, METHODID_LIST_REPORT_DETAILS)))
        .addMethod(
            getGetReportDetailMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.GetReportDetailRequest,
                    com.google.cloud.storageinsights.v1.ReportDetail>(
                    service, METHODID_GET_REPORT_DETAIL)))
        .addMethod(
            getListDatasetConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest,
                    com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse>(
                    service, METHODID_LIST_DATASET_CONFIGS)))
        .addMethod(
            getGetDatasetConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.GetDatasetConfigRequest,
                    com.google.cloud.storageinsights.v1.DatasetConfig>(
                    service, METHODID_GET_DATASET_CONFIG)))
        .addMethod(
            getCreateDatasetConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DATASET_CONFIG)))
        .addMethod(
            getUpdateDatasetConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATASET_CONFIG)))
        .addMethod(
            getDeleteDatasetConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DATASET_CONFIG)))
        .addMethod(
            getLinkDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.LinkDatasetRequest,
                    com.google.longrunning.Operation>(service, METHODID_LINK_DATASET)))
        .addMethod(
            getUnlinkDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storageinsights.v1.UnlinkDatasetRequest,
                    com.google.longrunning.Operation>(service, METHODID_UNLINK_DATASET)))
        .build();
  }

  private abstract static class StorageInsightsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StorageInsightsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.storageinsights.v1.V1Proto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StorageInsights");
    }
  }

  private static final class StorageInsightsFileDescriptorSupplier
      extends StorageInsightsBaseDescriptorSupplier {
    StorageInsightsFileDescriptorSupplier() {}
  }

  private static final class StorageInsightsMethodDescriptorSupplier
      extends StorageInsightsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StorageInsightsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (StorageInsightsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new StorageInsightsFileDescriptorSupplier())
                      .addMethod(getListReportConfigsMethod())
                      .addMethod(getGetReportConfigMethod())
                      .addMethod(getCreateReportConfigMethod())
                      .addMethod(getUpdateReportConfigMethod())
                      .addMethod(getDeleteReportConfigMethod())
                      .addMethod(getListReportDetailsMethod())
                      .addMethod(getGetReportDetailMethod())
                      .addMethod(getListDatasetConfigsMethod())
                      .addMethod(getGetDatasetConfigMethod())
                      .addMethod(getCreateDatasetConfigMethod())
                      .addMethod(getUpdateDatasetConfigMethod())
                      .addMethod(getDeleteDatasetConfigMethod())
                      .addMethod(getLinkDatasetMethod())
                      .addMethod(getUnlinkDatasetMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
