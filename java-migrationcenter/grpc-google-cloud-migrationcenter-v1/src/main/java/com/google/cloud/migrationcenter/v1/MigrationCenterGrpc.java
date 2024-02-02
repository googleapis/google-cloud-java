/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.migrationcenter.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/migrationcenter/v1/migrationcenter.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MigrationCenterGrpc {

  private MigrationCenterGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.migrationcenter.v1.MigrationCenter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListAssetsRequest,
          com.google.cloud.migrationcenter.v1.ListAssetsResponse>
      getListAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAssets",
      requestType = com.google.cloud.migrationcenter.v1.ListAssetsRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ListAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListAssetsRequest,
          com.google.cloud.migrationcenter.v1.ListAssetsResponse>
      getListAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.ListAssetsRequest,
            com.google.cloud.migrationcenter.v1.ListAssetsResponse>
        getListAssetsMethod;
    if ((getListAssetsMethod = MigrationCenterGrpc.getListAssetsMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getListAssetsMethod = MigrationCenterGrpc.getListAssetsMethod) == null) {
          MigrationCenterGrpc.getListAssetsMethod =
              getListAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.ListAssetsRequest,
                          com.google.cloud.migrationcenter.v1.ListAssetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListAssetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListAssetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("ListAssets"))
                      .build();
        }
      }
    }
    return getListAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetAssetRequest,
          com.google.cloud.migrationcenter.v1.Asset>
      getGetAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAsset",
      requestType = com.google.cloud.migrationcenter.v1.GetAssetRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.Asset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetAssetRequest,
          com.google.cloud.migrationcenter.v1.Asset>
      getGetAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.GetAssetRequest,
            com.google.cloud.migrationcenter.v1.Asset>
        getGetAssetMethod;
    if ((getGetAssetMethod = MigrationCenterGrpc.getGetAssetMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getGetAssetMethod = MigrationCenterGrpc.getGetAssetMethod) == null) {
          MigrationCenterGrpc.getGetAssetMethod =
              getGetAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.GetAssetRequest,
                          com.google.cloud.migrationcenter.v1.Asset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.GetAssetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.Asset.getDefaultInstance()))
                      .setSchemaDescriptor(new MigrationCenterMethodDescriptorSupplier("GetAsset"))
                      .build();
        }
      }
    }
    return getGetAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.UpdateAssetRequest,
          com.google.cloud.migrationcenter.v1.Asset>
      getUpdateAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAsset",
      requestType = com.google.cloud.migrationcenter.v1.UpdateAssetRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.Asset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.UpdateAssetRequest,
          com.google.cloud.migrationcenter.v1.Asset>
      getUpdateAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.UpdateAssetRequest,
            com.google.cloud.migrationcenter.v1.Asset>
        getUpdateAssetMethod;
    if ((getUpdateAssetMethod = MigrationCenterGrpc.getUpdateAssetMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getUpdateAssetMethod = MigrationCenterGrpc.getUpdateAssetMethod) == null) {
          MigrationCenterGrpc.getUpdateAssetMethod =
              getUpdateAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.UpdateAssetRequest,
                          com.google.cloud.migrationcenter.v1.Asset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.UpdateAssetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.Asset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("UpdateAsset"))
                      .build();
        }
      }
    }
    return getUpdateAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest,
          com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse>
      getBatchUpdateAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateAssets",
      requestType = com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest,
          com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse>
      getBatchUpdateAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest,
            com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse>
        getBatchUpdateAssetsMethod;
    if ((getBatchUpdateAssetsMethod = MigrationCenterGrpc.getBatchUpdateAssetsMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getBatchUpdateAssetsMethod = MigrationCenterGrpc.getBatchUpdateAssetsMethod) == null) {
          MigrationCenterGrpc.getBatchUpdateAssetsMethod =
              getBatchUpdateAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest,
                          com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchUpdateAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("BatchUpdateAssets"))
                      .build();
        }
      }
    }
    return getBatchUpdateAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteAssetRequest, com.google.protobuf.Empty>
      getDeleteAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAsset",
      requestType = com.google.cloud.migrationcenter.v1.DeleteAssetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteAssetRequest, com.google.protobuf.Empty>
      getDeleteAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.DeleteAssetRequest, com.google.protobuf.Empty>
        getDeleteAssetMethod;
    if ((getDeleteAssetMethod = MigrationCenterGrpc.getDeleteAssetMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getDeleteAssetMethod = MigrationCenterGrpc.getDeleteAssetMethod) == null) {
          MigrationCenterGrpc.getDeleteAssetMethod =
              getDeleteAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.DeleteAssetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.DeleteAssetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("DeleteAsset"))
                      .build();
        }
      }
    }
    return getDeleteAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest, com.google.protobuf.Empty>
      getBatchDeleteAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteAssets",
      requestType = com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest, com.google.protobuf.Empty>
      getBatchDeleteAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest, com.google.protobuf.Empty>
        getBatchDeleteAssetsMethod;
    if ((getBatchDeleteAssetsMethod = MigrationCenterGrpc.getBatchDeleteAssetsMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getBatchDeleteAssetsMethod = MigrationCenterGrpc.getBatchDeleteAssetsMethod) == null) {
          MigrationCenterGrpc.getBatchDeleteAssetsMethod =
              getBatchDeleteAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchDeleteAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("BatchDeleteAssets"))
                      .build();
        }
      }
    }
    return getBatchDeleteAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest,
          com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse>
      getReportAssetFramesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportAssetFrames",
      requestType = com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest,
          com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse>
      getReportAssetFramesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest,
            com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse>
        getReportAssetFramesMethod;
    if ((getReportAssetFramesMethod = MigrationCenterGrpc.getReportAssetFramesMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getReportAssetFramesMethod = MigrationCenterGrpc.getReportAssetFramesMethod) == null) {
          MigrationCenterGrpc.getReportAssetFramesMethod =
              getReportAssetFramesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest,
                          com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReportAssetFrames"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("ReportAssetFrames"))
                      .build();
        }
      }
    }
    return getReportAssetFramesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest,
          com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse>
      getAggregateAssetsValuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AggregateAssetsValues",
      requestType = com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest,
          com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse>
      getAggregateAssetsValuesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest,
            com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse>
        getAggregateAssetsValuesMethod;
    if ((getAggregateAssetsValuesMethod = MigrationCenterGrpc.getAggregateAssetsValuesMethod)
        == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getAggregateAssetsValuesMethod = MigrationCenterGrpc.getAggregateAssetsValuesMethod)
            == null) {
          MigrationCenterGrpc.getAggregateAssetsValuesMethod =
              getAggregateAssetsValuesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest,
                          com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AggregateAssetsValues"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("AggregateAssetsValues"))
                      .build();
        }
      }
    }
    return getAggregateAssetsValuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreateImportJobRequest,
          com.google.longrunning.Operation>
      getCreateImportJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateImportJob",
      requestType = com.google.cloud.migrationcenter.v1.CreateImportJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreateImportJobRequest,
          com.google.longrunning.Operation>
      getCreateImportJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.CreateImportJobRequest,
            com.google.longrunning.Operation>
        getCreateImportJobMethod;
    if ((getCreateImportJobMethod = MigrationCenterGrpc.getCreateImportJobMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getCreateImportJobMethod = MigrationCenterGrpc.getCreateImportJobMethod) == null) {
          MigrationCenterGrpc.getCreateImportJobMethod =
              getCreateImportJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.CreateImportJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateImportJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.CreateImportJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("CreateImportJob"))
                      .build();
        }
      }
    }
    return getCreateImportJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListImportJobsRequest,
          com.google.cloud.migrationcenter.v1.ListImportJobsResponse>
      getListImportJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListImportJobs",
      requestType = com.google.cloud.migrationcenter.v1.ListImportJobsRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ListImportJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListImportJobsRequest,
          com.google.cloud.migrationcenter.v1.ListImportJobsResponse>
      getListImportJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.ListImportJobsRequest,
            com.google.cloud.migrationcenter.v1.ListImportJobsResponse>
        getListImportJobsMethod;
    if ((getListImportJobsMethod = MigrationCenterGrpc.getListImportJobsMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getListImportJobsMethod = MigrationCenterGrpc.getListImportJobsMethod) == null) {
          MigrationCenterGrpc.getListImportJobsMethod =
              getListImportJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.ListImportJobsRequest,
                          com.google.cloud.migrationcenter.v1.ListImportJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListImportJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListImportJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListImportJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("ListImportJobs"))
                      .build();
        }
      }
    }
    return getListImportJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetImportJobRequest,
          com.google.cloud.migrationcenter.v1.ImportJob>
      getGetImportJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetImportJob",
      requestType = com.google.cloud.migrationcenter.v1.GetImportJobRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ImportJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetImportJobRequest,
          com.google.cloud.migrationcenter.v1.ImportJob>
      getGetImportJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.GetImportJobRequest,
            com.google.cloud.migrationcenter.v1.ImportJob>
        getGetImportJobMethod;
    if ((getGetImportJobMethod = MigrationCenterGrpc.getGetImportJobMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getGetImportJobMethod = MigrationCenterGrpc.getGetImportJobMethod) == null) {
          MigrationCenterGrpc.getGetImportJobMethod =
              getGetImportJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.GetImportJobRequest,
                          com.google.cloud.migrationcenter.v1.ImportJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetImportJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.GetImportJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ImportJob.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("GetImportJob"))
                      .build();
        }
      }
    }
    return getGetImportJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteImportJobRequest,
          com.google.longrunning.Operation>
      getDeleteImportJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteImportJob",
      requestType = com.google.cloud.migrationcenter.v1.DeleteImportJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteImportJobRequest,
          com.google.longrunning.Operation>
      getDeleteImportJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.DeleteImportJobRequest,
            com.google.longrunning.Operation>
        getDeleteImportJobMethod;
    if ((getDeleteImportJobMethod = MigrationCenterGrpc.getDeleteImportJobMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getDeleteImportJobMethod = MigrationCenterGrpc.getDeleteImportJobMethod) == null) {
          MigrationCenterGrpc.getDeleteImportJobMethod =
              getDeleteImportJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.DeleteImportJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteImportJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.DeleteImportJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("DeleteImportJob"))
                      .build();
        }
      }
    }
    return getDeleteImportJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.UpdateImportJobRequest,
          com.google.longrunning.Operation>
      getUpdateImportJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateImportJob",
      requestType = com.google.cloud.migrationcenter.v1.UpdateImportJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.UpdateImportJobRequest,
          com.google.longrunning.Operation>
      getUpdateImportJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.UpdateImportJobRequest,
            com.google.longrunning.Operation>
        getUpdateImportJobMethod;
    if ((getUpdateImportJobMethod = MigrationCenterGrpc.getUpdateImportJobMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getUpdateImportJobMethod = MigrationCenterGrpc.getUpdateImportJobMethod) == null) {
          MigrationCenterGrpc.getUpdateImportJobMethod =
              getUpdateImportJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.UpdateImportJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateImportJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.UpdateImportJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("UpdateImportJob"))
                      .build();
        }
      }
    }
    return getUpdateImportJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ValidateImportJobRequest,
          com.google.longrunning.Operation>
      getValidateImportJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateImportJob",
      requestType = com.google.cloud.migrationcenter.v1.ValidateImportJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ValidateImportJobRequest,
          com.google.longrunning.Operation>
      getValidateImportJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.ValidateImportJobRequest,
            com.google.longrunning.Operation>
        getValidateImportJobMethod;
    if ((getValidateImportJobMethod = MigrationCenterGrpc.getValidateImportJobMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getValidateImportJobMethod = MigrationCenterGrpc.getValidateImportJobMethod) == null) {
          MigrationCenterGrpc.getValidateImportJobMethod =
              getValidateImportJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.ValidateImportJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateImportJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ValidateImportJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("ValidateImportJob"))
                      .build();
        }
      }
    }
    return getValidateImportJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.RunImportJobRequest, com.google.longrunning.Operation>
      getRunImportJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunImportJob",
      requestType = com.google.cloud.migrationcenter.v1.RunImportJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.RunImportJobRequest, com.google.longrunning.Operation>
      getRunImportJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.RunImportJobRequest,
            com.google.longrunning.Operation>
        getRunImportJobMethod;
    if ((getRunImportJobMethod = MigrationCenterGrpc.getRunImportJobMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getRunImportJobMethod = MigrationCenterGrpc.getRunImportJobMethod) == null) {
          MigrationCenterGrpc.getRunImportJobMethod =
              getRunImportJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.RunImportJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunImportJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.RunImportJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("RunImportJob"))
                      .build();
        }
      }
    }
    return getRunImportJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetImportDataFileRequest,
          com.google.cloud.migrationcenter.v1.ImportDataFile>
      getGetImportDataFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetImportDataFile",
      requestType = com.google.cloud.migrationcenter.v1.GetImportDataFileRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ImportDataFile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetImportDataFileRequest,
          com.google.cloud.migrationcenter.v1.ImportDataFile>
      getGetImportDataFileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.GetImportDataFileRequest,
            com.google.cloud.migrationcenter.v1.ImportDataFile>
        getGetImportDataFileMethod;
    if ((getGetImportDataFileMethod = MigrationCenterGrpc.getGetImportDataFileMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getGetImportDataFileMethod = MigrationCenterGrpc.getGetImportDataFileMethod) == null) {
          MigrationCenterGrpc.getGetImportDataFileMethod =
              getGetImportDataFileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.GetImportDataFileRequest,
                          com.google.cloud.migrationcenter.v1.ImportDataFile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetImportDataFile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.GetImportDataFileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ImportDataFile
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("GetImportDataFile"))
                      .build();
        }
      }
    }
    return getGetImportDataFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest,
          com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse>
      getListImportDataFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListImportDataFiles",
      requestType = com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest,
          com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse>
      getListImportDataFilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest,
            com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse>
        getListImportDataFilesMethod;
    if ((getListImportDataFilesMethod = MigrationCenterGrpc.getListImportDataFilesMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getListImportDataFilesMethod = MigrationCenterGrpc.getListImportDataFilesMethod)
            == null) {
          MigrationCenterGrpc.getListImportDataFilesMethod =
              getListImportDataFilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest,
                          com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListImportDataFiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("ListImportDataFiles"))
                      .build();
        }
      }
    }
    return getListImportDataFilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest,
          com.google.longrunning.Operation>
      getCreateImportDataFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateImportDataFile",
      requestType = com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest,
          com.google.longrunning.Operation>
      getCreateImportDataFileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest,
            com.google.longrunning.Operation>
        getCreateImportDataFileMethod;
    if ((getCreateImportDataFileMethod = MigrationCenterGrpc.getCreateImportDataFileMethod)
        == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getCreateImportDataFileMethod = MigrationCenterGrpc.getCreateImportDataFileMethod)
            == null) {
          MigrationCenterGrpc.getCreateImportDataFileMethod =
              getCreateImportDataFileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateImportDataFile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("CreateImportDataFile"))
                      .build();
        }
      }
    }
    return getCreateImportDataFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest,
          com.google.longrunning.Operation>
      getDeleteImportDataFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteImportDataFile",
      requestType = com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest,
          com.google.longrunning.Operation>
      getDeleteImportDataFileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest,
            com.google.longrunning.Operation>
        getDeleteImportDataFileMethod;
    if ((getDeleteImportDataFileMethod = MigrationCenterGrpc.getDeleteImportDataFileMethod)
        == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getDeleteImportDataFileMethod = MigrationCenterGrpc.getDeleteImportDataFileMethod)
            == null) {
          MigrationCenterGrpc.getDeleteImportDataFileMethod =
              getDeleteImportDataFileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteImportDataFile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("DeleteImportDataFile"))
                      .build();
        }
      }
    }
    return getDeleteImportDataFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListGroupsRequest,
          com.google.cloud.migrationcenter.v1.ListGroupsResponse>
      getListGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGroups",
      requestType = com.google.cloud.migrationcenter.v1.ListGroupsRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ListGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListGroupsRequest,
          com.google.cloud.migrationcenter.v1.ListGroupsResponse>
      getListGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.ListGroupsRequest,
            com.google.cloud.migrationcenter.v1.ListGroupsResponse>
        getListGroupsMethod;
    if ((getListGroupsMethod = MigrationCenterGrpc.getListGroupsMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getListGroupsMethod = MigrationCenterGrpc.getListGroupsMethod) == null) {
          MigrationCenterGrpc.getListGroupsMethod =
              getListGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.ListGroupsRequest,
                          com.google.cloud.migrationcenter.v1.ListGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("ListGroups"))
                      .build();
        }
      }
    }
    return getListGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetGroupRequest,
          com.google.cloud.migrationcenter.v1.Group>
      getGetGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGroup",
      requestType = com.google.cloud.migrationcenter.v1.GetGroupRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.Group.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetGroupRequest,
          com.google.cloud.migrationcenter.v1.Group>
      getGetGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.GetGroupRequest,
            com.google.cloud.migrationcenter.v1.Group>
        getGetGroupMethod;
    if ((getGetGroupMethod = MigrationCenterGrpc.getGetGroupMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getGetGroupMethod = MigrationCenterGrpc.getGetGroupMethod) == null) {
          MigrationCenterGrpc.getGetGroupMethod =
              getGetGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.GetGroupRequest,
                          com.google.cloud.migrationcenter.v1.Group>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.GetGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.Group.getDefaultInstance()))
                      .setSchemaDescriptor(new MigrationCenterMethodDescriptorSupplier("GetGroup"))
                      .build();
        }
      }
    }
    return getGetGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreateGroupRequest, com.google.longrunning.Operation>
      getCreateGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGroup",
      requestType = com.google.cloud.migrationcenter.v1.CreateGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreateGroupRequest, com.google.longrunning.Operation>
      getCreateGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.CreateGroupRequest,
            com.google.longrunning.Operation>
        getCreateGroupMethod;
    if ((getCreateGroupMethod = MigrationCenterGrpc.getCreateGroupMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getCreateGroupMethod = MigrationCenterGrpc.getCreateGroupMethod) == null) {
          MigrationCenterGrpc.getCreateGroupMethod =
              getCreateGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.CreateGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.CreateGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("CreateGroup"))
                      .build();
        }
      }
    }
    return getCreateGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.UpdateGroupRequest, com.google.longrunning.Operation>
      getUpdateGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGroup",
      requestType = com.google.cloud.migrationcenter.v1.UpdateGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.UpdateGroupRequest, com.google.longrunning.Operation>
      getUpdateGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.UpdateGroupRequest,
            com.google.longrunning.Operation>
        getUpdateGroupMethod;
    if ((getUpdateGroupMethod = MigrationCenterGrpc.getUpdateGroupMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getUpdateGroupMethod = MigrationCenterGrpc.getUpdateGroupMethod) == null) {
          MigrationCenterGrpc.getUpdateGroupMethod =
              getUpdateGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.UpdateGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.UpdateGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("UpdateGroup"))
                      .build();
        }
      }
    }
    return getUpdateGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteGroupRequest, com.google.longrunning.Operation>
      getDeleteGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGroup",
      requestType = com.google.cloud.migrationcenter.v1.DeleteGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteGroupRequest, com.google.longrunning.Operation>
      getDeleteGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.DeleteGroupRequest,
            com.google.longrunning.Operation>
        getDeleteGroupMethod;
    if ((getDeleteGroupMethod = MigrationCenterGrpc.getDeleteGroupMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getDeleteGroupMethod = MigrationCenterGrpc.getDeleteGroupMethod) == null) {
          MigrationCenterGrpc.getDeleteGroupMethod =
              getDeleteGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.DeleteGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.DeleteGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("DeleteGroup"))
                      .build();
        }
      }
    }
    return getDeleteGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest,
          com.google.longrunning.Operation>
      getAddAssetsToGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddAssetsToGroup",
      requestType = com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest,
          com.google.longrunning.Operation>
      getAddAssetsToGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest,
            com.google.longrunning.Operation>
        getAddAssetsToGroupMethod;
    if ((getAddAssetsToGroupMethod = MigrationCenterGrpc.getAddAssetsToGroupMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getAddAssetsToGroupMethod = MigrationCenterGrpc.getAddAssetsToGroupMethod) == null) {
          MigrationCenterGrpc.getAddAssetsToGroupMethod =
              getAddAssetsToGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddAssetsToGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("AddAssetsToGroup"))
                      .build();
        }
      }
    }
    return getAddAssetsToGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest,
          com.google.longrunning.Operation>
      getRemoveAssetsFromGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveAssetsFromGroup",
      requestType = com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest,
          com.google.longrunning.Operation>
      getRemoveAssetsFromGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest,
            com.google.longrunning.Operation>
        getRemoveAssetsFromGroupMethod;
    if ((getRemoveAssetsFromGroupMethod = MigrationCenterGrpc.getRemoveAssetsFromGroupMethod)
        == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getRemoveAssetsFromGroupMethod = MigrationCenterGrpc.getRemoveAssetsFromGroupMethod)
            == null) {
          MigrationCenterGrpc.getRemoveAssetsFromGroupMethod =
              getRemoveAssetsFromGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RemoveAssetsFromGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("RemoveAssetsFromGroup"))
                      .build();
        }
      }
    }
    return getRemoveAssetsFromGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListErrorFramesRequest,
          com.google.cloud.migrationcenter.v1.ListErrorFramesResponse>
      getListErrorFramesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListErrorFrames",
      requestType = com.google.cloud.migrationcenter.v1.ListErrorFramesRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ListErrorFramesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListErrorFramesRequest,
          com.google.cloud.migrationcenter.v1.ListErrorFramesResponse>
      getListErrorFramesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.ListErrorFramesRequest,
            com.google.cloud.migrationcenter.v1.ListErrorFramesResponse>
        getListErrorFramesMethod;
    if ((getListErrorFramesMethod = MigrationCenterGrpc.getListErrorFramesMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getListErrorFramesMethod = MigrationCenterGrpc.getListErrorFramesMethod) == null) {
          MigrationCenterGrpc.getListErrorFramesMethod =
              getListErrorFramesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.ListErrorFramesRequest,
                          com.google.cloud.migrationcenter.v1.ListErrorFramesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListErrorFrames"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListErrorFramesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListErrorFramesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("ListErrorFrames"))
                      .build();
        }
      }
    }
    return getListErrorFramesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetErrorFrameRequest,
          com.google.cloud.migrationcenter.v1.ErrorFrame>
      getGetErrorFrameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetErrorFrame",
      requestType = com.google.cloud.migrationcenter.v1.GetErrorFrameRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ErrorFrame.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetErrorFrameRequest,
          com.google.cloud.migrationcenter.v1.ErrorFrame>
      getGetErrorFrameMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.GetErrorFrameRequest,
            com.google.cloud.migrationcenter.v1.ErrorFrame>
        getGetErrorFrameMethod;
    if ((getGetErrorFrameMethod = MigrationCenterGrpc.getGetErrorFrameMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getGetErrorFrameMethod = MigrationCenterGrpc.getGetErrorFrameMethod) == null) {
          MigrationCenterGrpc.getGetErrorFrameMethod =
              getGetErrorFrameMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.GetErrorFrameRequest,
                          com.google.cloud.migrationcenter.v1.ErrorFrame>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetErrorFrame"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.GetErrorFrameRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ErrorFrame.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("GetErrorFrame"))
                      .build();
        }
      }
    }
    return getGetErrorFrameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListSourcesRequest,
          com.google.cloud.migrationcenter.v1.ListSourcesResponse>
      getListSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSources",
      requestType = com.google.cloud.migrationcenter.v1.ListSourcesRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ListSourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListSourcesRequest,
          com.google.cloud.migrationcenter.v1.ListSourcesResponse>
      getListSourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.ListSourcesRequest,
            com.google.cloud.migrationcenter.v1.ListSourcesResponse>
        getListSourcesMethod;
    if ((getListSourcesMethod = MigrationCenterGrpc.getListSourcesMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getListSourcesMethod = MigrationCenterGrpc.getListSourcesMethod) == null) {
          MigrationCenterGrpc.getListSourcesMethod =
              getListSourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.ListSourcesRequest,
                          com.google.cloud.migrationcenter.v1.ListSourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListSourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListSourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("ListSources"))
                      .build();
        }
      }
    }
    return getListSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetSourceRequest,
          com.google.cloud.migrationcenter.v1.Source>
      getGetSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSource",
      requestType = com.google.cloud.migrationcenter.v1.GetSourceRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.Source.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetSourceRequest,
          com.google.cloud.migrationcenter.v1.Source>
      getGetSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.GetSourceRequest,
            com.google.cloud.migrationcenter.v1.Source>
        getGetSourceMethod;
    if ((getGetSourceMethod = MigrationCenterGrpc.getGetSourceMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getGetSourceMethod = MigrationCenterGrpc.getGetSourceMethod) == null) {
          MigrationCenterGrpc.getGetSourceMethod =
              getGetSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.GetSourceRequest,
                          com.google.cloud.migrationcenter.v1.Source>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.GetSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.Source.getDefaultInstance()))
                      .setSchemaDescriptor(new MigrationCenterMethodDescriptorSupplier("GetSource"))
                      .build();
        }
      }
    }
    return getGetSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreateSourceRequest, com.google.longrunning.Operation>
      getCreateSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSource",
      requestType = com.google.cloud.migrationcenter.v1.CreateSourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreateSourceRequest, com.google.longrunning.Operation>
      getCreateSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.CreateSourceRequest,
            com.google.longrunning.Operation>
        getCreateSourceMethod;
    if ((getCreateSourceMethod = MigrationCenterGrpc.getCreateSourceMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getCreateSourceMethod = MigrationCenterGrpc.getCreateSourceMethod) == null) {
          MigrationCenterGrpc.getCreateSourceMethod =
              getCreateSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.CreateSourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.CreateSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("CreateSource"))
                      .build();
        }
      }
    }
    return getCreateSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.UpdateSourceRequest, com.google.longrunning.Operation>
      getUpdateSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSource",
      requestType = com.google.cloud.migrationcenter.v1.UpdateSourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.UpdateSourceRequest, com.google.longrunning.Operation>
      getUpdateSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.UpdateSourceRequest,
            com.google.longrunning.Operation>
        getUpdateSourceMethod;
    if ((getUpdateSourceMethod = MigrationCenterGrpc.getUpdateSourceMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getUpdateSourceMethod = MigrationCenterGrpc.getUpdateSourceMethod) == null) {
          MigrationCenterGrpc.getUpdateSourceMethod =
              getUpdateSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.UpdateSourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.UpdateSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("UpdateSource"))
                      .build();
        }
      }
    }
    return getUpdateSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteSourceRequest, com.google.longrunning.Operation>
      getDeleteSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSource",
      requestType = com.google.cloud.migrationcenter.v1.DeleteSourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteSourceRequest, com.google.longrunning.Operation>
      getDeleteSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.DeleteSourceRequest,
            com.google.longrunning.Operation>
        getDeleteSourceMethod;
    if ((getDeleteSourceMethod = MigrationCenterGrpc.getDeleteSourceMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getDeleteSourceMethod = MigrationCenterGrpc.getDeleteSourceMethod) == null) {
          MigrationCenterGrpc.getDeleteSourceMethod =
              getDeleteSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.DeleteSourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.DeleteSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("DeleteSource"))
                      .build();
        }
      }
    }
    return getDeleteSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest,
          com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse>
      getListPreferenceSetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPreferenceSets",
      requestType = com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest,
          com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse>
      getListPreferenceSetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest,
            com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse>
        getListPreferenceSetsMethod;
    if ((getListPreferenceSetsMethod = MigrationCenterGrpc.getListPreferenceSetsMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getListPreferenceSetsMethod = MigrationCenterGrpc.getListPreferenceSetsMethod)
            == null) {
          MigrationCenterGrpc.getListPreferenceSetsMethod =
              getListPreferenceSetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest,
                          com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPreferenceSets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("ListPreferenceSets"))
                      .build();
        }
      }
    }
    return getListPreferenceSetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest,
          com.google.cloud.migrationcenter.v1.PreferenceSet>
      getGetPreferenceSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPreferenceSet",
      requestType = com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.PreferenceSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest,
          com.google.cloud.migrationcenter.v1.PreferenceSet>
      getGetPreferenceSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest,
            com.google.cloud.migrationcenter.v1.PreferenceSet>
        getGetPreferenceSetMethod;
    if ((getGetPreferenceSetMethod = MigrationCenterGrpc.getGetPreferenceSetMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getGetPreferenceSetMethod = MigrationCenterGrpc.getGetPreferenceSetMethod) == null) {
          MigrationCenterGrpc.getGetPreferenceSetMethod =
              getGetPreferenceSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest,
                          com.google.cloud.migrationcenter.v1.PreferenceSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPreferenceSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.PreferenceSet
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("GetPreferenceSet"))
                      .build();
        }
      }
    }
    return getGetPreferenceSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest,
          com.google.longrunning.Operation>
      getCreatePreferenceSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePreferenceSet",
      requestType = com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest,
          com.google.longrunning.Operation>
      getCreatePreferenceSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest,
            com.google.longrunning.Operation>
        getCreatePreferenceSetMethod;
    if ((getCreatePreferenceSetMethod = MigrationCenterGrpc.getCreatePreferenceSetMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getCreatePreferenceSetMethod = MigrationCenterGrpc.getCreatePreferenceSetMethod)
            == null) {
          MigrationCenterGrpc.getCreatePreferenceSetMethod =
              getCreatePreferenceSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreatePreferenceSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("CreatePreferenceSet"))
                      .build();
        }
      }
    }
    return getCreatePreferenceSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest,
          com.google.longrunning.Operation>
      getUpdatePreferenceSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePreferenceSet",
      requestType = com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest,
          com.google.longrunning.Operation>
      getUpdatePreferenceSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest,
            com.google.longrunning.Operation>
        getUpdatePreferenceSetMethod;
    if ((getUpdatePreferenceSetMethod = MigrationCenterGrpc.getUpdatePreferenceSetMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getUpdatePreferenceSetMethod = MigrationCenterGrpc.getUpdatePreferenceSetMethod)
            == null) {
          MigrationCenterGrpc.getUpdatePreferenceSetMethod =
              getUpdatePreferenceSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdatePreferenceSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("UpdatePreferenceSet"))
                      .build();
        }
      }
    }
    return getUpdatePreferenceSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest,
          com.google.longrunning.Operation>
      getDeletePreferenceSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePreferenceSet",
      requestType = com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest,
          com.google.longrunning.Operation>
      getDeletePreferenceSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest,
            com.google.longrunning.Operation>
        getDeletePreferenceSetMethod;
    if ((getDeletePreferenceSetMethod = MigrationCenterGrpc.getDeletePreferenceSetMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getDeletePreferenceSetMethod = MigrationCenterGrpc.getDeletePreferenceSetMethod)
            == null) {
          MigrationCenterGrpc.getDeletePreferenceSetMethod =
              getDeletePreferenceSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeletePreferenceSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("DeletePreferenceSet"))
                      .build();
        }
      }
    }
    return getDeletePreferenceSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetSettingsRequest,
          com.google.cloud.migrationcenter.v1.Settings>
      getGetSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSettings",
      requestType = com.google.cloud.migrationcenter.v1.GetSettingsRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.Settings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetSettingsRequest,
          com.google.cloud.migrationcenter.v1.Settings>
      getGetSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.GetSettingsRequest,
            com.google.cloud.migrationcenter.v1.Settings>
        getGetSettingsMethod;
    if ((getGetSettingsMethod = MigrationCenterGrpc.getGetSettingsMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getGetSettingsMethod = MigrationCenterGrpc.getGetSettingsMethod) == null) {
          MigrationCenterGrpc.getGetSettingsMethod =
              getGetSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.GetSettingsRequest,
                          com.google.cloud.migrationcenter.v1.Settings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.GetSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.Settings.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("GetSettings"))
                      .build();
        }
      }
    }
    return getGetSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.UpdateSettingsRequest,
          com.google.longrunning.Operation>
      getUpdateSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSettings",
      requestType = com.google.cloud.migrationcenter.v1.UpdateSettingsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.UpdateSettingsRequest,
          com.google.longrunning.Operation>
      getUpdateSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.UpdateSettingsRequest,
            com.google.longrunning.Operation>
        getUpdateSettingsMethod;
    if ((getUpdateSettingsMethod = MigrationCenterGrpc.getUpdateSettingsMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getUpdateSettingsMethod = MigrationCenterGrpc.getUpdateSettingsMethod) == null) {
          MigrationCenterGrpc.getUpdateSettingsMethod =
              getUpdateSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.UpdateSettingsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.UpdateSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("UpdateSettings"))
                      .build();
        }
      }
    }
    return getUpdateSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreateReportConfigRequest,
          com.google.longrunning.Operation>
      getCreateReportConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReportConfig",
      requestType = com.google.cloud.migrationcenter.v1.CreateReportConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreateReportConfigRequest,
          com.google.longrunning.Operation>
      getCreateReportConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.CreateReportConfigRequest,
            com.google.longrunning.Operation>
        getCreateReportConfigMethod;
    if ((getCreateReportConfigMethod = MigrationCenterGrpc.getCreateReportConfigMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getCreateReportConfigMethod = MigrationCenterGrpc.getCreateReportConfigMethod)
            == null) {
          MigrationCenterGrpc.getCreateReportConfigMethod =
              getCreateReportConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.CreateReportConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReportConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.CreateReportConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("CreateReportConfig"))
                      .build();
        }
      }
    }
    return getCreateReportConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetReportConfigRequest,
          com.google.cloud.migrationcenter.v1.ReportConfig>
      getGetReportConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReportConfig",
      requestType = com.google.cloud.migrationcenter.v1.GetReportConfigRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ReportConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetReportConfigRequest,
          com.google.cloud.migrationcenter.v1.ReportConfig>
      getGetReportConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.GetReportConfigRequest,
            com.google.cloud.migrationcenter.v1.ReportConfig>
        getGetReportConfigMethod;
    if ((getGetReportConfigMethod = MigrationCenterGrpc.getGetReportConfigMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getGetReportConfigMethod = MigrationCenterGrpc.getGetReportConfigMethod) == null) {
          MigrationCenterGrpc.getGetReportConfigMethod =
              getGetReportConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.GetReportConfigRequest,
                          com.google.cloud.migrationcenter.v1.ReportConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReportConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.GetReportConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ReportConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("GetReportConfig"))
                      .build();
        }
      }
    }
    return getGetReportConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListReportConfigsRequest,
          com.google.cloud.migrationcenter.v1.ListReportConfigsResponse>
      getListReportConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReportConfigs",
      requestType = com.google.cloud.migrationcenter.v1.ListReportConfigsRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ListReportConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListReportConfigsRequest,
          com.google.cloud.migrationcenter.v1.ListReportConfigsResponse>
      getListReportConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.ListReportConfigsRequest,
            com.google.cloud.migrationcenter.v1.ListReportConfigsResponse>
        getListReportConfigsMethod;
    if ((getListReportConfigsMethod = MigrationCenterGrpc.getListReportConfigsMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getListReportConfigsMethod = MigrationCenterGrpc.getListReportConfigsMethod) == null) {
          MigrationCenterGrpc.getListReportConfigsMethod =
              getListReportConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.ListReportConfigsRequest,
                          com.google.cloud.migrationcenter.v1.ListReportConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReportConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListReportConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListReportConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("ListReportConfigs"))
                      .build();
        }
      }
    }
    return getListReportConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest,
          com.google.longrunning.Operation>
      getDeleteReportConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReportConfig",
      requestType = com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest,
          com.google.longrunning.Operation>
      getDeleteReportConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest,
            com.google.longrunning.Operation>
        getDeleteReportConfigMethod;
    if ((getDeleteReportConfigMethod = MigrationCenterGrpc.getDeleteReportConfigMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getDeleteReportConfigMethod = MigrationCenterGrpc.getDeleteReportConfigMethod)
            == null) {
          MigrationCenterGrpc.getDeleteReportConfigMethod =
              getDeleteReportConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteReportConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("DeleteReportConfig"))
                      .build();
        }
      }
    }
    return getDeleteReportConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreateReportRequest, com.google.longrunning.Operation>
      getCreateReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReport",
      requestType = com.google.cloud.migrationcenter.v1.CreateReportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.CreateReportRequest, com.google.longrunning.Operation>
      getCreateReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.CreateReportRequest,
            com.google.longrunning.Operation>
        getCreateReportMethod;
    if ((getCreateReportMethod = MigrationCenterGrpc.getCreateReportMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getCreateReportMethod = MigrationCenterGrpc.getCreateReportMethod) == null) {
          MigrationCenterGrpc.getCreateReportMethod =
              getCreateReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.CreateReportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.CreateReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("CreateReport"))
                      .build();
        }
      }
    }
    return getCreateReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetReportRequest,
          com.google.cloud.migrationcenter.v1.Report>
      getGetReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReport",
      requestType = com.google.cloud.migrationcenter.v1.GetReportRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.Report.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.GetReportRequest,
          com.google.cloud.migrationcenter.v1.Report>
      getGetReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.GetReportRequest,
            com.google.cloud.migrationcenter.v1.Report>
        getGetReportMethod;
    if ((getGetReportMethod = MigrationCenterGrpc.getGetReportMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getGetReportMethod = MigrationCenterGrpc.getGetReportMethod) == null) {
          MigrationCenterGrpc.getGetReportMethod =
              getGetReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.GetReportRequest,
                          com.google.cloud.migrationcenter.v1.Report>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.GetReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.Report.getDefaultInstance()))
                      .setSchemaDescriptor(new MigrationCenterMethodDescriptorSupplier("GetReport"))
                      .build();
        }
      }
    }
    return getGetReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListReportsRequest,
          com.google.cloud.migrationcenter.v1.ListReportsResponse>
      getListReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReports",
      requestType = com.google.cloud.migrationcenter.v1.ListReportsRequest.class,
      responseType = com.google.cloud.migrationcenter.v1.ListReportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.ListReportsRequest,
          com.google.cloud.migrationcenter.v1.ListReportsResponse>
      getListReportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.ListReportsRequest,
            com.google.cloud.migrationcenter.v1.ListReportsResponse>
        getListReportsMethod;
    if ((getListReportsMethod = MigrationCenterGrpc.getListReportsMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getListReportsMethod = MigrationCenterGrpc.getListReportsMethod) == null) {
          MigrationCenterGrpc.getListReportsMethod =
              getListReportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.ListReportsRequest,
                          com.google.cloud.migrationcenter.v1.ListReportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListReportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.ListReportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("ListReports"))
                      .build();
        }
      }
    }
    return getListReportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteReportRequest, com.google.longrunning.Operation>
      getDeleteReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReport",
      requestType = com.google.cloud.migrationcenter.v1.DeleteReportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.migrationcenter.v1.DeleteReportRequest, com.google.longrunning.Operation>
      getDeleteReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.migrationcenter.v1.DeleteReportRequest,
            com.google.longrunning.Operation>
        getDeleteReportMethod;
    if ((getDeleteReportMethod = MigrationCenterGrpc.getDeleteReportMethod) == null) {
      synchronized (MigrationCenterGrpc.class) {
        if ((getDeleteReportMethod = MigrationCenterGrpc.getDeleteReportMethod) == null) {
          MigrationCenterGrpc.getDeleteReportMethod =
              getDeleteReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.migrationcenter.v1.DeleteReportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.migrationcenter.v1.DeleteReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationCenterMethodDescriptorSupplier("DeleteReport"))
                      .build();
        }
      }
    }
    return getDeleteReportMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MigrationCenterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MigrationCenterStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MigrationCenterStub>() {
          @java.lang.Override
          public MigrationCenterStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MigrationCenterStub(channel, callOptions);
          }
        };
    return MigrationCenterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MigrationCenterBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MigrationCenterBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MigrationCenterBlockingStub>() {
          @java.lang.Override
          public MigrationCenterBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MigrationCenterBlockingStub(channel, callOptions);
          }
        };
    return MigrationCenterBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MigrationCenterFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MigrationCenterFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MigrationCenterFutureStub>() {
          @java.lang.Override
          public MigrationCenterFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MigrationCenterFutureStub(channel, callOptions);
          }
        };
    return MigrationCenterFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists all the assets in a given project and location.
     * </pre>
     */
    default void listAssets(
        com.google.cloud.migrationcenter.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListAssetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAssetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of an asset.
     * </pre>
     */
    default void getAsset(
        com.google.cloud.migrationcenter.v1.GetAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Asset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of an asset.
     * </pre>
     */
    default void updateAsset(
        com.google.cloud.migrationcenter.v1.UpdateAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Asset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a list of assets.
     * </pre>
     */
    default void batchUpdateAssets(
        com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchUpdateAssetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an asset.
     * </pre>
     */
    default void deleteAsset(
        com.google.cloud.migrationcenter.v1.DeleteAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes list of Assets.
     * </pre>
     */
    default void batchDeleteAssets(
        com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteAssetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reports a set of frames.
     * </pre>
     */
    default void reportAssetFrames(
        com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReportAssetFramesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Aggregates the requested fields based on provided function.
     * </pre>
     */
    default void aggregateAssetsValues(
        com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAggregateAssetsValuesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an import job.
     * </pre>
     */
    default void createImportJob(
        com.google.cloud.migrationcenter.v1.CreateImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateImportJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all import jobs.
     * </pre>
     */
    default void listImportJobs(
        com.google.cloud.migrationcenter.v1.ListImportJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListImportJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListImportJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of an import job.
     * </pre>
     */
    default void getImportJob(
        com.google.cloud.migrationcenter.v1.GetImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ImportJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetImportJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an import job.
     * </pre>
     */
    default void deleteImportJob(
        com.google.cloud.migrationcenter.v1.DeleteImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteImportJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an import job.
     * </pre>
     */
    default void updateImportJob(
        com.google.cloud.migrationcenter.v1.UpdateImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateImportJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Validates an import job.
     * </pre>
     */
    default void validateImportJob(
        com.google.cloud.migrationcenter.v1.ValidateImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getValidateImportJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs an import job.
     * </pre>
     */
    default void runImportJob(
        com.google.cloud.migrationcenter.v1.RunImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunImportJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an import data file.
     * </pre>
     */
    default void getImportDataFile(
        com.google.cloud.migrationcenter.v1.GetImportDataFileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ImportDataFile>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetImportDataFileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List import data files.
     * </pre>
     */
    default void listImportDataFiles(
        com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListImportDataFilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an import data file.
     * </pre>
     */
    default void createImportDataFile(
        com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateImportDataFileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an import data file.
     * </pre>
     */
    default void deleteImportDataFile(
        com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteImportDataFileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all groups in a given project and location.
     * </pre>
     */
    default void listGroups(
        com.google.cloud.migrationcenter.v1.ListGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a group.
     * </pre>
     */
    default void getGroup(
        com.google.cloud.migrationcenter.v1.GetGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Group> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new group in a given project and location.
     * </pre>
     */
    default void createGroup(
        com.google.cloud.migrationcenter.v1.CreateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a group.
     * </pre>
     */
    default void updateGroup(
        com.google.cloud.migrationcenter.v1.UpdateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a group.
     * </pre>
     */
    default void deleteGroup(
        com.google.cloud.migrationcenter.v1.DeleteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds assets to a group.
     * </pre>
     */
    default void addAssetsToGroup(
        com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddAssetsToGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes assets from a group.
     * </pre>
     */
    default void removeAssetsFromGroup(
        com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveAssetsFromGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all error frames in a given source and location.
     * </pre>
     */
    default void listErrorFrames(
        com.google.cloud.migrationcenter.v1.ListErrorFramesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListErrorFramesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListErrorFramesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of an error frame.
     * </pre>
     */
    default void getErrorFrame(
        com.google.cloud.migrationcenter.v1.GetErrorFrameRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ErrorFrame>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetErrorFrameMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the sources in a given project and location.
     * </pre>
     */
    default void listSources(
        com.google.cloud.migrationcenter.v1.ListSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListSourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a source.
     * </pre>
     */
    default void getSource(
        com.google.cloud.migrationcenter.v1.GetSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Source> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new source in a given project and location.
     * </pre>
     */
    default void createSource(
        com.google.cloud.migrationcenter.v1.CreateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a source.
     * </pre>
     */
    default void updateSource(
        com.google.cloud.migrationcenter.v1.UpdateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a source.
     * </pre>
     */
    default void deleteSource(
        com.google.cloud.migrationcenter.v1.DeleteSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the preference sets in a given project and location.
     * </pre>
     */
    default void listPreferenceSets(
        com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPreferenceSetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a preference set.
     * </pre>
     */
    default void getPreferenceSet(
        com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.PreferenceSet>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPreferenceSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new preference set in a given project and location.
     * </pre>
     */
    default void createPreferenceSet(
        com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePreferenceSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a preference set.
     * </pre>
     */
    default void updatePreferenceSet(
        com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePreferenceSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a preference set.
     * </pre>
     */
    default void deletePreferenceSet(
        com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePreferenceSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of regional settings.
     * </pre>
     */
    default void getSettings(
        com.google.cloud.migrationcenter.v1.GetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Settings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the regional-level project settings.
     * </pre>
     */
    default void updateSettings(
        com.google.cloud.migrationcenter.v1.UpdateSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a report configuration.
     * </pre>
     */
    default void createReportConfig(
        com.google.cloud.migrationcenter.v1.CreateReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReportConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReportConfig.
     * </pre>
     */
    default void getReportConfig(
        com.google.cloud.migrationcenter.v1.GetReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ReportConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetReportConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ReportConfigs in a given project and location.
     * </pre>
     */
    default void listReportConfigs(
        com.google.cloud.migrationcenter.v1.ListReportConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListReportConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReportConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ReportConfig.
     * </pre>
     */
    default void deleteReportConfig(
        com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteReportConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a report.
     * </pre>
     */
    default void createReport(
        com.google.cloud.migrationcenter.v1.CreateReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Report.
     * </pre>
     */
    default void getReport(
        com.google.cloud.migrationcenter.v1.GetReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Report> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Reports in a given ReportConfig.
     * </pre>
     */
    default void listReports(
        com.google.cloud.migrationcenter.v1.ListReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListReportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReportsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Report.
     * </pre>
     */
    default void deleteReport(
        com.google.cloud.migrationcenter.v1.DeleteReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteReportMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MigrationCenter.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public abstract static class MigrationCenterImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MigrationCenterGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MigrationCenter.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class MigrationCenterStub
      extends io.grpc.stub.AbstractAsyncStub<MigrationCenterStub> {
    private MigrationCenterStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MigrationCenterStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MigrationCenterStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the assets in a given project and location.
     * </pre>
     */
    public void listAssets(
        com.google.cloud.migrationcenter.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListAssetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of an asset.
     * </pre>
     */
    public void getAsset(
        com.google.cloud.migrationcenter.v1.GetAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Asset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAssetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of an asset.
     * </pre>
     */
    public void updateAsset(
        com.google.cloud.migrationcenter.v1.UpdateAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Asset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAssetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a list of assets.
     * </pre>
     */
    public void batchUpdateAssets(
        com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateAssetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an asset.
     * </pre>
     */
    public void deleteAsset(
        com.google.cloud.migrationcenter.v1.DeleteAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAssetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes list of Assets.
     * </pre>
     */
    public void batchDeleteAssets(
        com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteAssetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reports a set of frames.
     * </pre>
     */
    public void reportAssetFrames(
        com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportAssetFramesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Aggregates the requested fields based on provided function.
     * </pre>
     */
    public void aggregateAssetsValues(
        com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAggregateAssetsValuesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an import job.
     * </pre>
     */
    public void createImportJob(
        com.google.cloud.migrationcenter.v1.CreateImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateImportJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all import jobs.
     * </pre>
     */
    public void listImportJobs(
        com.google.cloud.migrationcenter.v1.ListImportJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListImportJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListImportJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of an import job.
     * </pre>
     */
    public void getImportJob(
        com.google.cloud.migrationcenter.v1.GetImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ImportJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetImportJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an import job.
     * </pre>
     */
    public void deleteImportJob(
        com.google.cloud.migrationcenter.v1.DeleteImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteImportJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an import job.
     * </pre>
     */
    public void updateImportJob(
        com.google.cloud.migrationcenter.v1.UpdateImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateImportJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Validates an import job.
     * </pre>
     */
    public void validateImportJob(
        com.google.cloud.migrationcenter.v1.ValidateImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateImportJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs an import job.
     * </pre>
     */
    public void runImportJob(
        com.google.cloud.migrationcenter.v1.RunImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunImportJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an import data file.
     * </pre>
     */
    public void getImportDataFile(
        com.google.cloud.migrationcenter.v1.GetImportDataFileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ImportDataFile>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetImportDataFileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List import data files.
     * </pre>
     */
    public void listImportDataFiles(
        com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListImportDataFilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an import data file.
     * </pre>
     */
    public void createImportDataFile(
        com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateImportDataFileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an import data file.
     * </pre>
     */
    public void deleteImportDataFile(
        com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteImportDataFileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all groups in a given project and location.
     * </pre>
     */
    public void listGroups(
        com.google.cloud.migrationcenter.v1.ListGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGroupsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a group.
     * </pre>
     */
    public void getGroup(
        com.google.cloud.migrationcenter.v1.GetGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Group> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new group in a given project and location.
     * </pre>
     */
    public void createGroup(
        com.google.cloud.migrationcenter.v1.CreateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a group.
     * </pre>
     */
    public void updateGroup(
        com.google.cloud.migrationcenter.v1.UpdateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a group.
     * </pre>
     */
    public void deleteGroup(
        com.google.cloud.migrationcenter.v1.DeleteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds assets to a group.
     * </pre>
     */
    public void addAssetsToGroup(
        com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddAssetsToGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes assets from a group.
     * </pre>
     */
    public void removeAssetsFromGroup(
        com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveAssetsFromGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all error frames in a given source and location.
     * </pre>
     */
    public void listErrorFrames(
        com.google.cloud.migrationcenter.v1.ListErrorFramesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListErrorFramesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListErrorFramesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of an error frame.
     * </pre>
     */
    public void getErrorFrame(
        com.google.cloud.migrationcenter.v1.GetErrorFrameRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ErrorFrame>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetErrorFrameMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the sources in a given project and location.
     * </pre>
     */
    public void listSources(
        com.google.cloud.migrationcenter.v1.ListSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListSourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a source.
     * </pre>
     */
    public void getSource(
        com.google.cloud.migrationcenter.v1.GetSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Source> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new source in a given project and location.
     * </pre>
     */
    public void createSource(
        com.google.cloud.migrationcenter.v1.CreateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a source.
     * </pre>
     */
    public void updateSource(
        com.google.cloud.migrationcenter.v1.UpdateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a source.
     * </pre>
     */
    public void deleteSource(
        com.google.cloud.migrationcenter.v1.DeleteSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the preference sets in a given project and location.
     * </pre>
     */
    public void listPreferenceSets(
        com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPreferenceSetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a preference set.
     * </pre>
     */
    public void getPreferenceSet(
        com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.PreferenceSet>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPreferenceSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new preference set in a given project and location.
     * </pre>
     */
    public void createPreferenceSet(
        com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePreferenceSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a preference set.
     * </pre>
     */
    public void updatePreferenceSet(
        com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePreferenceSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a preference set.
     * </pre>
     */
    public void deletePreferenceSet(
        com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePreferenceSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of regional settings.
     * </pre>
     */
    public void getSettings(
        com.google.cloud.migrationcenter.v1.GetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Settings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the regional-level project settings.
     * </pre>
     */
    public void updateSettings(
        com.google.cloud.migrationcenter.v1.UpdateSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a report configuration.
     * </pre>
     */
    public void createReportConfig(
        com.google.cloud.migrationcenter.v1.CreateReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReportConfigMethod(), getCallOptions()),
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
        com.google.cloud.migrationcenter.v1.GetReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ReportConfig>
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
     * Lists ReportConfigs in a given project and location.
     * </pre>
     */
    public void listReportConfigs(
        com.google.cloud.migrationcenter.v1.ListReportConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListReportConfigsResponse>
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
     * Deletes a ReportConfig.
     * </pre>
     */
    public void deleteReportConfig(
        com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteReportConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a report.
     * </pre>
     */
    public void createReport(
        com.google.cloud.migrationcenter.v1.CreateReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Report.
     * </pre>
     */
    public void getReport(
        com.google.cloud.migrationcenter.v1.GetReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Report> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Reports in a given ReportConfig.
     * </pre>
     */
    public void listReports(
        com.google.cloud.migrationcenter.v1.ListReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListReportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Report.
     * </pre>
     */
    public void deleteReport(
        com.google.cloud.migrationcenter.v1.DeleteReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MigrationCenter.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class MigrationCenterBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MigrationCenterBlockingStub> {
    private MigrationCenterBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MigrationCenterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MigrationCenterBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the assets in a given project and location.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ListAssetsResponse listAssets(
        com.google.cloud.migrationcenter.v1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAssetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of an asset.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.Asset getAsset(
        com.google.cloud.migrationcenter.v1.GetAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of an asset.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.Asset updateAsset(
        com.google.cloud.migrationcenter.v1.UpdateAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a list of assets.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse batchUpdateAssets(
        com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateAssetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an asset.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAsset(
        com.google.cloud.migrationcenter.v1.DeleteAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes list of Assets.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeleteAssets(
        com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteAssetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reports a set of frames.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse reportAssetFrames(
        com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportAssetFramesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Aggregates the requested fields based on provided function.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse aggregateAssetsValues(
        com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAggregateAssetsValuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an import job.
     * </pre>
     */
    public com.google.longrunning.Operation createImportJob(
        com.google.cloud.migrationcenter.v1.CreateImportJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateImportJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all import jobs.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ListImportJobsResponse listImportJobs(
        com.google.cloud.migrationcenter.v1.ListImportJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListImportJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of an import job.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ImportJob getImportJob(
        com.google.cloud.migrationcenter.v1.GetImportJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetImportJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an import job.
     * </pre>
     */
    public com.google.longrunning.Operation deleteImportJob(
        com.google.cloud.migrationcenter.v1.DeleteImportJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteImportJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an import job.
     * </pre>
     */
    public com.google.longrunning.Operation updateImportJob(
        com.google.cloud.migrationcenter.v1.UpdateImportJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateImportJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Validates an import job.
     * </pre>
     */
    public com.google.longrunning.Operation validateImportJob(
        com.google.cloud.migrationcenter.v1.ValidateImportJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateImportJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs an import job.
     * </pre>
     */
    public com.google.longrunning.Operation runImportJob(
        com.google.cloud.migrationcenter.v1.RunImportJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunImportJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an import data file.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ImportDataFile getImportDataFile(
        com.google.cloud.migrationcenter.v1.GetImportDataFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetImportDataFileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List import data files.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse listImportDataFiles(
        com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListImportDataFilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an import data file.
     * </pre>
     */
    public com.google.longrunning.Operation createImportDataFile(
        com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateImportDataFileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an import data file.
     * </pre>
     */
    public com.google.longrunning.Operation deleteImportDataFile(
        com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteImportDataFileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all groups in a given project and location.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ListGroupsResponse listGroups(
        com.google.cloud.migrationcenter.v1.ListGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a group.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.Group getGroup(
        com.google.cloud.migrationcenter.v1.GetGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new group in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGroup(
        com.google.cloud.migrationcenter.v1.CreateGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a group.
     * </pre>
     */
    public com.google.longrunning.Operation updateGroup(
        com.google.cloud.migrationcenter.v1.UpdateGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a group.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGroup(
        com.google.cloud.migrationcenter.v1.DeleteGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds assets to a group.
     * </pre>
     */
    public com.google.longrunning.Operation addAssetsToGroup(
        com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddAssetsToGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes assets from a group.
     * </pre>
     */
    public com.google.longrunning.Operation removeAssetsFromGroup(
        com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveAssetsFromGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all error frames in a given source and location.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ListErrorFramesResponse listErrorFrames(
        com.google.cloud.migrationcenter.v1.ListErrorFramesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListErrorFramesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of an error frame.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ErrorFrame getErrorFrame(
        com.google.cloud.migrationcenter.v1.GetErrorFrameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetErrorFrameMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the sources in a given project and location.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ListSourcesResponse listSources(
        com.google.cloud.migrationcenter.v1.ListSourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a source.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.Source getSource(
        com.google.cloud.migrationcenter.v1.GetSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new source in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSource(
        com.google.cloud.migrationcenter.v1.CreateSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a source.
     * </pre>
     */
    public com.google.longrunning.Operation updateSource(
        com.google.cloud.migrationcenter.v1.UpdateSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a source.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSource(
        com.google.cloud.migrationcenter.v1.DeleteSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the preference sets in a given project and location.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse listPreferenceSets(
        com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPreferenceSetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a preference set.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.PreferenceSet getPreferenceSet(
        com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPreferenceSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new preference set in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createPreferenceSet(
        com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePreferenceSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a preference set.
     * </pre>
     */
    public com.google.longrunning.Operation updatePreferenceSet(
        com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePreferenceSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a preference set.
     * </pre>
     */
    public com.google.longrunning.Operation deletePreferenceSet(
        com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePreferenceSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of regional settings.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.Settings getSettings(
        com.google.cloud.migrationcenter.v1.GetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the regional-level project settings.
     * </pre>
     */
    public com.google.longrunning.Operation updateSettings(
        com.google.cloud.migrationcenter.v1.UpdateSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a report configuration.
     * </pre>
     */
    public com.google.longrunning.Operation createReportConfig(
        com.google.cloud.migrationcenter.v1.CreateReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReportConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReportConfig.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ReportConfig getReportConfig(
        com.google.cloud.migrationcenter.v1.GetReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReportConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ReportConfigs in a given project and location.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ListReportConfigsResponse listReportConfigs(
        com.google.cloud.migrationcenter.v1.ListReportConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReportConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ReportConfig.
     * </pre>
     */
    public com.google.longrunning.Operation deleteReportConfig(
        com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReportConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a report.
     * </pre>
     */
    public com.google.longrunning.Operation createReport(
        com.google.cloud.migrationcenter.v1.CreateReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Report.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.Report getReport(
        com.google.cloud.migrationcenter.v1.GetReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Reports in a given ReportConfig.
     * </pre>
     */
    public com.google.cloud.migrationcenter.v1.ListReportsResponse listReports(
        com.google.cloud.migrationcenter.v1.ListReportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Report.
     * </pre>
     */
    public com.google.longrunning.Operation deleteReport(
        com.google.cloud.migrationcenter.v1.DeleteReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReportMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MigrationCenter.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class MigrationCenterFutureStub
      extends io.grpc.stub.AbstractFutureStub<MigrationCenterFutureStub> {
    private MigrationCenterFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MigrationCenterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MigrationCenterFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the assets in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ListAssetsResponse>
        listAssets(com.google.cloud.migrationcenter.v1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of an asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.Asset>
        getAsset(com.google.cloud.migrationcenter.v1.GetAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of an asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.Asset>
        updateAsset(com.google.cloud.migrationcenter.v1.UpdateAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a list of assets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse>
        batchUpdateAssets(com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateAssetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAsset(com.google.cloud.migrationcenter.v1.DeleteAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes list of Assets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        batchDeleteAssets(com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteAssetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reports a set of frames.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse>
        reportAssetFrames(com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportAssetFramesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Aggregates the requested fields based on provided function.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse>
        aggregateAssetsValues(
            com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAggregateAssetsValuesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an import job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createImportJob(com.google.cloud.migrationcenter.v1.CreateImportJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateImportJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all import jobs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ListImportJobsResponse>
        listImportJobs(com.google.cloud.migrationcenter.v1.ListImportJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListImportJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of an import job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ImportJob>
        getImportJob(com.google.cloud.migrationcenter.v1.GetImportJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetImportJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an import job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteImportJob(com.google.cloud.migrationcenter.v1.DeleteImportJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteImportJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an import job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateImportJob(com.google.cloud.migrationcenter.v1.UpdateImportJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateImportJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Validates an import job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        validateImportJob(com.google.cloud.migrationcenter.v1.ValidateImportJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateImportJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Runs an import job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        runImportJob(com.google.cloud.migrationcenter.v1.RunImportJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunImportJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an import data file.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ImportDataFile>
        getImportDataFile(com.google.cloud.migrationcenter.v1.GetImportDataFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetImportDataFileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List import data files.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse>
        listImportDataFiles(
            com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListImportDataFilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an import data file.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createImportDataFile(
            com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateImportDataFileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an import data file.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteImportDataFile(
            com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteImportDataFileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all groups in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ListGroupsResponse>
        listGroups(com.google.cloud.migrationcenter.v1.ListGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.Group>
        getGroup(com.google.cloud.migrationcenter.v1.GetGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new group in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGroup(com.google.cloud.migrationcenter.v1.CreateGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGroup(com.google.cloud.migrationcenter.v1.UpdateGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGroup(com.google.cloud.migrationcenter.v1.DeleteGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds assets to a group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        addAssetsToGroup(com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddAssetsToGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes assets from a group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        removeAssetsFromGroup(
            com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveAssetsFromGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all error frames in a given source and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ListErrorFramesResponse>
        listErrorFrames(com.google.cloud.migrationcenter.v1.ListErrorFramesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListErrorFramesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of an error frame.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ErrorFrame>
        getErrorFrame(com.google.cloud.migrationcenter.v1.GetErrorFrameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetErrorFrameMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the sources in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ListSourcesResponse>
        listSources(com.google.cloud.migrationcenter.v1.ListSourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.Source>
        getSource(com.google.cloud.migrationcenter.v1.GetSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new source in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSource(com.google.cloud.migrationcenter.v1.CreateSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSource(com.google.cloud.migrationcenter.v1.UpdateSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSource(com.google.cloud.migrationcenter.v1.DeleteSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the preference sets in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse>
        listPreferenceSets(com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPreferenceSetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a preference set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.PreferenceSet>
        getPreferenceSet(com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPreferenceSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new preference set in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPreferenceSet(
            com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePreferenceSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a preference set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updatePreferenceSet(
            com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePreferenceSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a preference set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePreferenceSet(
            com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePreferenceSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of regional settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.Settings>
        getSettings(com.google.cloud.migrationcenter.v1.GetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the regional-level project settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSettings(com.google.cloud.migrationcenter.v1.UpdateSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a report configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createReportConfig(com.google.cloud.migrationcenter.v1.CreateReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReportConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReportConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ReportConfig>
        getReportConfig(com.google.cloud.migrationcenter.v1.GetReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReportConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ReportConfigs in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ListReportConfigsResponse>
        listReportConfigs(com.google.cloud.migrationcenter.v1.ListReportConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReportConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ReportConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteReportConfig(com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteReportConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a report.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createReport(com.google.cloud.migrationcenter.v1.CreateReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Report.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.Report>
        getReport(com.google.cloud.migrationcenter.v1.GetReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Reports in a given ReportConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.migrationcenter.v1.ListReportsResponse>
        listReports(com.google.cloud.migrationcenter.v1.ListReportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReportsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Report.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteReport(com.google.cloud.migrationcenter.v1.DeleteReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteReportMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ASSETS = 0;
  private static final int METHODID_GET_ASSET = 1;
  private static final int METHODID_UPDATE_ASSET = 2;
  private static final int METHODID_BATCH_UPDATE_ASSETS = 3;
  private static final int METHODID_DELETE_ASSET = 4;
  private static final int METHODID_BATCH_DELETE_ASSETS = 5;
  private static final int METHODID_REPORT_ASSET_FRAMES = 6;
  private static final int METHODID_AGGREGATE_ASSETS_VALUES = 7;
  private static final int METHODID_CREATE_IMPORT_JOB = 8;
  private static final int METHODID_LIST_IMPORT_JOBS = 9;
  private static final int METHODID_GET_IMPORT_JOB = 10;
  private static final int METHODID_DELETE_IMPORT_JOB = 11;
  private static final int METHODID_UPDATE_IMPORT_JOB = 12;
  private static final int METHODID_VALIDATE_IMPORT_JOB = 13;
  private static final int METHODID_RUN_IMPORT_JOB = 14;
  private static final int METHODID_GET_IMPORT_DATA_FILE = 15;
  private static final int METHODID_LIST_IMPORT_DATA_FILES = 16;
  private static final int METHODID_CREATE_IMPORT_DATA_FILE = 17;
  private static final int METHODID_DELETE_IMPORT_DATA_FILE = 18;
  private static final int METHODID_LIST_GROUPS = 19;
  private static final int METHODID_GET_GROUP = 20;
  private static final int METHODID_CREATE_GROUP = 21;
  private static final int METHODID_UPDATE_GROUP = 22;
  private static final int METHODID_DELETE_GROUP = 23;
  private static final int METHODID_ADD_ASSETS_TO_GROUP = 24;
  private static final int METHODID_REMOVE_ASSETS_FROM_GROUP = 25;
  private static final int METHODID_LIST_ERROR_FRAMES = 26;
  private static final int METHODID_GET_ERROR_FRAME = 27;
  private static final int METHODID_LIST_SOURCES = 28;
  private static final int METHODID_GET_SOURCE = 29;
  private static final int METHODID_CREATE_SOURCE = 30;
  private static final int METHODID_UPDATE_SOURCE = 31;
  private static final int METHODID_DELETE_SOURCE = 32;
  private static final int METHODID_LIST_PREFERENCE_SETS = 33;
  private static final int METHODID_GET_PREFERENCE_SET = 34;
  private static final int METHODID_CREATE_PREFERENCE_SET = 35;
  private static final int METHODID_UPDATE_PREFERENCE_SET = 36;
  private static final int METHODID_DELETE_PREFERENCE_SET = 37;
  private static final int METHODID_GET_SETTINGS = 38;
  private static final int METHODID_UPDATE_SETTINGS = 39;
  private static final int METHODID_CREATE_REPORT_CONFIG = 40;
  private static final int METHODID_GET_REPORT_CONFIG = 41;
  private static final int METHODID_LIST_REPORT_CONFIGS = 42;
  private static final int METHODID_DELETE_REPORT_CONFIG = 43;
  private static final int METHODID_CREATE_REPORT = 44;
  private static final int METHODID_GET_REPORT = 45;
  private static final int METHODID_LIST_REPORTS = 46;
  private static final int METHODID_DELETE_REPORT = 47;

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
        case METHODID_LIST_ASSETS:
          serviceImpl.listAssets(
              (com.google.cloud.migrationcenter.v1.ListAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListAssetsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ASSET:
          serviceImpl.getAsset(
              (com.google.cloud.migrationcenter.v1.GetAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Asset>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ASSET:
          serviceImpl.updateAsset(
              (com.google.cloud.migrationcenter.v1.UpdateAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Asset>)
                  responseObserver);
          break;
        case METHODID_BATCH_UPDATE_ASSETS:
          serviceImpl.batchUpdateAssets(
              (com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ASSET:
          serviceImpl.deleteAsset(
              (com.google.cloud.migrationcenter.v1.DeleteAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_ASSETS:
          serviceImpl.batchDeleteAssets(
              (com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_REPORT_ASSET_FRAMES:
          serviceImpl.reportAssetFrames(
              (com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse>)
                  responseObserver);
          break;
        case METHODID_AGGREGATE_ASSETS_VALUES:
          serviceImpl.aggregateAssetsValues(
              (com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_IMPORT_JOB:
          serviceImpl.createImportJob(
              (com.google.cloud.migrationcenter.v1.CreateImportJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_IMPORT_JOBS:
          serviceImpl.listImportJobs(
              (com.google.cloud.migrationcenter.v1.ListImportJobsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.migrationcenter.v1.ListImportJobsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_IMPORT_JOB:
          serviceImpl.getImportJob(
              (com.google.cloud.migrationcenter.v1.GetImportJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ImportJob>)
                  responseObserver);
          break;
        case METHODID_DELETE_IMPORT_JOB:
          serviceImpl.deleteImportJob(
              (com.google.cloud.migrationcenter.v1.DeleteImportJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_IMPORT_JOB:
          serviceImpl.updateImportJob(
              (com.google.cloud.migrationcenter.v1.UpdateImportJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_VALIDATE_IMPORT_JOB:
          serviceImpl.validateImportJob(
              (com.google.cloud.migrationcenter.v1.ValidateImportJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RUN_IMPORT_JOB:
          serviceImpl.runImportJob(
              (com.google.cloud.migrationcenter.v1.RunImportJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_IMPORT_DATA_FILE:
          serviceImpl.getImportDataFile(
              (com.google.cloud.migrationcenter.v1.GetImportDataFileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ImportDataFile>)
                  responseObserver);
          break;
        case METHODID_LIST_IMPORT_DATA_FILES:
          serviceImpl.listImportDataFiles(
              (com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_IMPORT_DATA_FILE:
          serviceImpl.createImportDataFile(
              (com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_IMPORT_DATA_FILE:
          serviceImpl.deleteImportDataFile(
              (com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_GROUPS:
          serviceImpl.listGroups(
              (com.google.cloud.migrationcenter.v1.ListGroupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GROUP:
          serviceImpl.getGroup(
              (com.google.cloud.migrationcenter.v1.GetGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Group>)
                  responseObserver);
          break;
        case METHODID_CREATE_GROUP:
          serviceImpl.createGroup(
              (com.google.cloud.migrationcenter.v1.CreateGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP:
          serviceImpl.updateGroup(
              (com.google.cloud.migrationcenter.v1.UpdateGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GROUP:
          serviceImpl.deleteGroup(
              (com.google.cloud.migrationcenter.v1.DeleteGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ADD_ASSETS_TO_GROUP:
          serviceImpl.addAssetsToGroup(
              (com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REMOVE_ASSETS_FROM_GROUP:
          serviceImpl.removeAssetsFromGroup(
              (com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ERROR_FRAMES:
          serviceImpl.listErrorFrames(
              (com.google.cloud.migrationcenter.v1.ListErrorFramesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.migrationcenter.v1.ListErrorFramesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ERROR_FRAME:
          serviceImpl.getErrorFrame(
              (com.google.cloud.migrationcenter.v1.GetErrorFrameRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ErrorFrame>)
                  responseObserver);
          break;
        case METHODID_LIST_SOURCES:
          serviceImpl.listSources(
              (com.google.cloud.migrationcenter.v1.ListSourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListSourcesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SOURCE:
          serviceImpl.getSource(
              (com.google.cloud.migrationcenter.v1.GetSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Source>)
                  responseObserver);
          break;
        case METHODID_CREATE_SOURCE:
          serviceImpl.createSource(
              (com.google.cloud.migrationcenter.v1.CreateSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SOURCE:
          serviceImpl.updateSource(
              (com.google.cloud.migrationcenter.v1.UpdateSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SOURCE:
          serviceImpl.deleteSource(
              (com.google.cloud.migrationcenter.v1.DeleteSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_PREFERENCE_SETS:
          serviceImpl.listPreferenceSets(
              (com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PREFERENCE_SET:
          serviceImpl.getPreferenceSet(
              (com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.PreferenceSet>)
                  responseObserver);
          break;
        case METHODID_CREATE_PREFERENCE_SET:
          serviceImpl.createPreferenceSet(
              (com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_PREFERENCE_SET:
          serviceImpl.updatePreferenceSet(
              (com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_PREFERENCE_SET:
          serviceImpl.deletePreferenceSet(
              (com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SETTINGS:
          serviceImpl.getSettings(
              (com.google.cloud.migrationcenter.v1.GetSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Settings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SETTINGS:
          serviceImpl.updateSettings(
              (com.google.cloud.migrationcenter.v1.UpdateSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_REPORT_CONFIG:
          serviceImpl.createReportConfig(
              (com.google.cloud.migrationcenter.v1.CreateReportConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_REPORT_CONFIG:
          serviceImpl.getReportConfig(
              (com.google.cloud.migrationcenter.v1.GetReportConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ReportConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_REPORT_CONFIGS:
          serviceImpl.listReportConfigs(
              (com.google.cloud.migrationcenter.v1.ListReportConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.migrationcenter.v1.ListReportConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_REPORT_CONFIG:
          serviceImpl.deleteReportConfig(
              (com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_REPORT:
          serviceImpl.createReport(
              (com.google.cloud.migrationcenter.v1.CreateReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_REPORT:
          serviceImpl.getReport(
              (com.google.cloud.migrationcenter.v1.GetReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.Report>)
                  responseObserver);
          break;
        case METHODID_LIST_REPORTS:
          serviceImpl.listReports(
              (com.google.cloud.migrationcenter.v1.ListReportsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.migrationcenter.v1.ListReportsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_REPORT:
          serviceImpl.deleteReport(
              (com.google.cloud.migrationcenter.v1.DeleteReportRequest) request,
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
            getListAssetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.ListAssetsRequest,
                    com.google.cloud.migrationcenter.v1.ListAssetsResponse>(
                    service, METHODID_LIST_ASSETS)))
        .addMethod(
            getGetAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.GetAssetRequest,
                    com.google.cloud.migrationcenter.v1.Asset>(service, METHODID_GET_ASSET)))
        .addMethod(
            getUpdateAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.UpdateAssetRequest,
                    com.google.cloud.migrationcenter.v1.Asset>(service, METHODID_UPDATE_ASSET)))
        .addMethod(
            getBatchUpdateAssetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest,
                    com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse>(
                    service, METHODID_BATCH_UPDATE_ASSETS)))
        .addMethod(
            getDeleteAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.DeleteAssetRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ASSET)))
        .addMethod(
            getBatchDeleteAssetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest,
                    com.google.protobuf.Empty>(service, METHODID_BATCH_DELETE_ASSETS)))
        .addMethod(
            getReportAssetFramesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest,
                    com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse>(
                    service, METHODID_REPORT_ASSET_FRAMES)))
        .addMethod(
            getAggregateAssetsValuesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest,
                    com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse>(
                    service, METHODID_AGGREGATE_ASSETS_VALUES)))
        .addMethod(
            getCreateImportJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.CreateImportJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_IMPORT_JOB)))
        .addMethod(
            getListImportJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.ListImportJobsRequest,
                    com.google.cloud.migrationcenter.v1.ListImportJobsResponse>(
                    service, METHODID_LIST_IMPORT_JOBS)))
        .addMethod(
            getGetImportJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.GetImportJobRequest,
                    com.google.cloud.migrationcenter.v1.ImportJob>(
                    service, METHODID_GET_IMPORT_JOB)))
        .addMethod(
            getDeleteImportJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.DeleteImportJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_IMPORT_JOB)))
        .addMethod(
            getUpdateImportJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.UpdateImportJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_IMPORT_JOB)))
        .addMethod(
            getValidateImportJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.ValidateImportJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_VALIDATE_IMPORT_JOB)))
        .addMethod(
            getRunImportJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.RunImportJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_RUN_IMPORT_JOB)))
        .addMethod(
            getGetImportDataFileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.GetImportDataFileRequest,
                    com.google.cloud.migrationcenter.v1.ImportDataFile>(
                    service, METHODID_GET_IMPORT_DATA_FILE)))
        .addMethod(
            getListImportDataFilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest,
                    com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse>(
                    service, METHODID_LIST_IMPORT_DATA_FILES)))
        .addMethod(
            getCreateImportDataFileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_IMPORT_DATA_FILE)))
        .addMethod(
            getDeleteImportDataFileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_IMPORT_DATA_FILE)))
        .addMethod(
            getListGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.ListGroupsRequest,
                    com.google.cloud.migrationcenter.v1.ListGroupsResponse>(
                    service, METHODID_LIST_GROUPS)))
        .addMethod(
            getGetGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.GetGroupRequest,
                    com.google.cloud.migrationcenter.v1.Group>(service, METHODID_GET_GROUP)))
        .addMethod(
            getCreateGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.CreateGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_GROUP)))
        .addMethod(
            getUpdateGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.UpdateGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_GROUP)))
        .addMethod(
            getDeleteGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.DeleteGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_GROUP)))
        .addMethod(
            getAddAssetsToGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_ADD_ASSETS_TO_GROUP)))
        .addMethod(
            getRemoveAssetsFromGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_REMOVE_ASSETS_FROM_GROUP)))
        .addMethod(
            getListErrorFramesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.ListErrorFramesRequest,
                    com.google.cloud.migrationcenter.v1.ListErrorFramesResponse>(
                    service, METHODID_LIST_ERROR_FRAMES)))
        .addMethod(
            getGetErrorFrameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.GetErrorFrameRequest,
                    com.google.cloud.migrationcenter.v1.ErrorFrame>(
                    service, METHODID_GET_ERROR_FRAME)))
        .addMethod(
            getListSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.ListSourcesRequest,
                    com.google.cloud.migrationcenter.v1.ListSourcesResponse>(
                    service, METHODID_LIST_SOURCES)))
        .addMethod(
            getGetSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.GetSourceRequest,
                    com.google.cloud.migrationcenter.v1.Source>(service, METHODID_GET_SOURCE)))
        .addMethod(
            getCreateSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.CreateSourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SOURCE)))
        .addMethod(
            getUpdateSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.UpdateSourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SOURCE)))
        .addMethod(
            getDeleteSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.DeleteSourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SOURCE)))
        .addMethod(
            getListPreferenceSetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest,
                    com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse>(
                    service, METHODID_LIST_PREFERENCE_SETS)))
        .addMethod(
            getGetPreferenceSetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest,
                    com.google.cloud.migrationcenter.v1.PreferenceSet>(
                    service, METHODID_GET_PREFERENCE_SET)))
        .addMethod(
            getCreatePreferenceSetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_PREFERENCE_SET)))
        .addMethod(
            getUpdatePreferenceSetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_PREFERENCE_SET)))
        .addMethod(
            getDeletePreferenceSetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_PREFERENCE_SET)))
        .addMethod(
            getGetSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.GetSettingsRequest,
                    com.google.cloud.migrationcenter.v1.Settings>(service, METHODID_GET_SETTINGS)))
        .addMethod(
            getUpdateSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.UpdateSettingsRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SETTINGS)))
        .addMethod(
            getCreateReportConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.CreateReportConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_REPORT_CONFIG)))
        .addMethod(
            getGetReportConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.GetReportConfigRequest,
                    com.google.cloud.migrationcenter.v1.ReportConfig>(
                    service, METHODID_GET_REPORT_CONFIG)))
        .addMethod(
            getListReportConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.ListReportConfigsRequest,
                    com.google.cloud.migrationcenter.v1.ListReportConfigsResponse>(
                    service, METHODID_LIST_REPORT_CONFIGS)))
        .addMethod(
            getDeleteReportConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_REPORT_CONFIG)))
        .addMethod(
            getCreateReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.CreateReportRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_REPORT)))
        .addMethod(
            getGetReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.GetReportRequest,
                    com.google.cloud.migrationcenter.v1.Report>(service, METHODID_GET_REPORT)))
        .addMethod(
            getListReportsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.ListReportsRequest,
                    com.google.cloud.migrationcenter.v1.ListReportsResponse>(
                    service, METHODID_LIST_REPORTS)))
        .addMethod(
            getDeleteReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.migrationcenter.v1.DeleteReportRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_REPORT)))
        .build();
  }

  private abstract static class MigrationCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MigrationCenterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.migrationcenter.v1.MigrationCenterProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MigrationCenter");
    }
  }

  private static final class MigrationCenterFileDescriptorSupplier
      extends MigrationCenterBaseDescriptorSupplier {
    MigrationCenterFileDescriptorSupplier() {}
  }

  private static final class MigrationCenterMethodDescriptorSupplier
      extends MigrationCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MigrationCenterMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MigrationCenterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MigrationCenterFileDescriptorSupplier())
                      .addMethod(getListAssetsMethod())
                      .addMethod(getGetAssetMethod())
                      .addMethod(getUpdateAssetMethod())
                      .addMethod(getBatchUpdateAssetsMethod())
                      .addMethod(getDeleteAssetMethod())
                      .addMethod(getBatchDeleteAssetsMethod())
                      .addMethod(getReportAssetFramesMethod())
                      .addMethod(getAggregateAssetsValuesMethod())
                      .addMethod(getCreateImportJobMethod())
                      .addMethod(getListImportJobsMethod())
                      .addMethod(getGetImportJobMethod())
                      .addMethod(getDeleteImportJobMethod())
                      .addMethod(getUpdateImportJobMethod())
                      .addMethod(getValidateImportJobMethod())
                      .addMethod(getRunImportJobMethod())
                      .addMethod(getGetImportDataFileMethod())
                      .addMethod(getListImportDataFilesMethod())
                      .addMethod(getCreateImportDataFileMethod())
                      .addMethod(getDeleteImportDataFileMethod())
                      .addMethod(getListGroupsMethod())
                      .addMethod(getGetGroupMethod())
                      .addMethod(getCreateGroupMethod())
                      .addMethod(getUpdateGroupMethod())
                      .addMethod(getDeleteGroupMethod())
                      .addMethod(getAddAssetsToGroupMethod())
                      .addMethod(getRemoveAssetsFromGroupMethod())
                      .addMethod(getListErrorFramesMethod())
                      .addMethod(getGetErrorFrameMethod())
                      .addMethod(getListSourcesMethod())
                      .addMethod(getGetSourceMethod())
                      .addMethod(getCreateSourceMethod())
                      .addMethod(getUpdateSourceMethod())
                      .addMethod(getDeleteSourceMethod())
                      .addMethod(getListPreferenceSetsMethod())
                      .addMethod(getGetPreferenceSetMethod())
                      .addMethod(getCreatePreferenceSetMethod())
                      .addMethod(getUpdatePreferenceSetMethod())
                      .addMethod(getDeletePreferenceSetMethod())
                      .addMethod(getGetSettingsMethod())
                      .addMethod(getUpdateSettingsMethod())
                      .addMethod(getCreateReportConfigMethod())
                      .addMethod(getGetReportConfigMethod())
                      .addMethod(getListReportConfigsMethod())
                      .addMethod(getDeleteReportConfigMethod())
                      .addMethod(getCreateReportMethod())
                      .addMethod(getGetReportMethod())
                      .addMethod(getListReportsMethod())
                      .addMethod(getDeleteReportMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
