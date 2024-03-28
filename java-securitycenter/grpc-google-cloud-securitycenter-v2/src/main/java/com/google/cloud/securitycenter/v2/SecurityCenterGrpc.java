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
package com.google.cloud.securitycenter.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * V2 APIs for Security Center service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/securitycenter/v2/securitycenter_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SecurityCenterGrpc {

  private SecurityCenterGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.securitycenter.v2.SecurityCenter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest,
          com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse>
      getBatchCreateResourceValueConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateResourceValueConfigs",
      requestType = com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest.class,
      responseType =
          com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest,
          com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse>
      getBatchCreateResourceValueConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest,
            com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse>
        getBatchCreateResourceValueConfigsMethod;
    if ((getBatchCreateResourceValueConfigsMethod =
            SecurityCenterGrpc.getBatchCreateResourceValueConfigsMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getBatchCreateResourceValueConfigsMethod =
                SecurityCenterGrpc.getBatchCreateResourceValueConfigsMethod)
            == null) {
          SecurityCenterGrpc.getBatchCreateResourceValueConfigsMethod =
              getBatchCreateResourceValueConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest,
                          com.google.cloud.securitycenter.v2
                              .BatchCreateResourceValueConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateResourceValueConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2
                                  .BatchCreateResourceValueConfigsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2
                                  .BatchCreateResourceValueConfigsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier(
                              "BatchCreateResourceValueConfigs"))
                      .build();
        }
      }
    }
    return getBatchCreateResourceValueConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest,
          com.google.longrunning.Operation>
      getBulkMuteFindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkMuteFindings",
      requestType = com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest,
          com.google.longrunning.Operation>
      getBulkMuteFindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest,
            com.google.longrunning.Operation>
        getBulkMuteFindingsMethod;
    if ((getBulkMuteFindingsMethod = SecurityCenterGrpc.getBulkMuteFindingsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getBulkMuteFindingsMethod = SecurityCenterGrpc.getBulkMuteFindingsMethod) == null) {
          SecurityCenterGrpc.getBulkMuteFindingsMethod =
              getBulkMuteFindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BulkMuteFindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("BulkMuteFindings"))
                      .build();
        }
      }
    }
    return getBulkMuteFindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest,
          com.google.cloud.securitycenter.v2.BigQueryExport>
      getCreateBigQueryExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBigQueryExport",
      requestType = com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest.class,
      responseType = com.google.cloud.securitycenter.v2.BigQueryExport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest,
          com.google.cloud.securitycenter.v2.BigQueryExport>
      getCreateBigQueryExportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest,
            com.google.cloud.securitycenter.v2.BigQueryExport>
        getCreateBigQueryExportMethod;
    if ((getCreateBigQueryExportMethod = SecurityCenterGrpc.getCreateBigQueryExportMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateBigQueryExportMethod = SecurityCenterGrpc.getCreateBigQueryExportMethod)
            == null) {
          SecurityCenterGrpc.getCreateBigQueryExportMethod =
              getCreateBigQueryExportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest,
                          com.google.cloud.securitycenter.v2.BigQueryExport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateBigQueryExport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.BigQueryExport
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("CreateBigQueryExport"))
                      .build();
        }
      }
    }
    return getCreateBigQueryExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.CreateFindingRequest,
          com.google.cloud.securitycenter.v2.Finding>
      getCreateFindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFinding",
      requestType = com.google.cloud.securitycenter.v2.CreateFindingRequest.class,
      responseType = com.google.cloud.securitycenter.v2.Finding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.CreateFindingRequest,
          com.google.cloud.securitycenter.v2.Finding>
      getCreateFindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.CreateFindingRequest,
            com.google.cloud.securitycenter.v2.Finding>
        getCreateFindingMethod;
    if ((getCreateFindingMethod = SecurityCenterGrpc.getCreateFindingMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateFindingMethod = SecurityCenterGrpc.getCreateFindingMethod) == null) {
          SecurityCenterGrpc.getCreateFindingMethod =
              getCreateFindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.CreateFindingRequest,
                          com.google.cloud.securitycenter.v2.Finding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.CreateFindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.Finding.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("CreateFinding"))
                      .build();
        }
      }
    }
    return getCreateFindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.CreateMuteConfigRequest,
          com.google.cloud.securitycenter.v2.MuteConfig>
      getCreateMuteConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMuteConfig",
      requestType = com.google.cloud.securitycenter.v2.CreateMuteConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v2.MuteConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.CreateMuteConfigRequest,
          com.google.cloud.securitycenter.v2.MuteConfig>
      getCreateMuteConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.CreateMuteConfigRequest,
            com.google.cloud.securitycenter.v2.MuteConfig>
        getCreateMuteConfigMethod;
    if ((getCreateMuteConfigMethod = SecurityCenterGrpc.getCreateMuteConfigMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateMuteConfigMethod = SecurityCenterGrpc.getCreateMuteConfigMethod) == null) {
          SecurityCenterGrpc.getCreateMuteConfigMethod =
              getCreateMuteConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.CreateMuteConfigRequest,
                          com.google.cloud.securitycenter.v2.MuteConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMuteConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.CreateMuteConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.MuteConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("CreateMuteConfig"))
                      .build();
        }
      }
    }
    return getCreateMuteConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest,
          com.google.cloud.securitycenter.v2.NotificationConfig>
      getCreateNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNotificationConfig",
      requestType = com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v2.NotificationConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest,
          com.google.cloud.securitycenter.v2.NotificationConfig>
      getCreateNotificationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest,
            com.google.cloud.securitycenter.v2.NotificationConfig>
        getCreateNotificationConfigMethod;
    if ((getCreateNotificationConfigMethod = SecurityCenterGrpc.getCreateNotificationConfigMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateNotificationConfigMethod =
                SecurityCenterGrpc.getCreateNotificationConfigMethod)
            == null) {
          SecurityCenterGrpc.getCreateNotificationConfigMethod =
              getCreateNotificationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest,
                          com.google.cloud.securitycenter.v2.NotificationConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateNotificationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.NotificationConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("CreateNotificationConfig"))
                      .build();
        }
      }
    }
    return getCreateNotificationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.CreateSourceRequest,
          com.google.cloud.securitycenter.v2.Source>
      getCreateSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSource",
      requestType = com.google.cloud.securitycenter.v2.CreateSourceRequest.class,
      responseType = com.google.cloud.securitycenter.v2.Source.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.CreateSourceRequest,
          com.google.cloud.securitycenter.v2.Source>
      getCreateSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.CreateSourceRequest,
            com.google.cloud.securitycenter.v2.Source>
        getCreateSourceMethod;
    if ((getCreateSourceMethod = SecurityCenterGrpc.getCreateSourceMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateSourceMethod = SecurityCenterGrpc.getCreateSourceMethod) == null) {
          SecurityCenterGrpc.getCreateSourceMethod =
              getCreateSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.CreateSourceRequest,
                          com.google.cloud.securitycenter.v2.Source>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.CreateSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.Source.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("CreateSource"))
                      .build();
        }
      }
    }
    return getCreateSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest, com.google.protobuf.Empty>
      getDeleteBigQueryExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBigQueryExport",
      requestType = com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest, com.google.protobuf.Empty>
      getDeleteBigQueryExportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest,
            com.google.protobuf.Empty>
        getDeleteBigQueryExportMethod;
    if ((getDeleteBigQueryExportMethod = SecurityCenterGrpc.getDeleteBigQueryExportMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getDeleteBigQueryExportMethod = SecurityCenterGrpc.getDeleteBigQueryExportMethod)
            == null) {
          SecurityCenterGrpc.getDeleteBigQueryExportMethod =
              getDeleteBigQueryExportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteBigQueryExport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("DeleteBigQueryExport"))
                      .build();
        }
      }
    }
    return getDeleteBigQueryExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest, com.google.protobuf.Empty>
      getDeleteMuteConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMuteConfig",
      requestType = com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest, com.google.protobuf.Empty>
      getDeleteMuteConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest, com.google.protobuf.Empty>
        getDeleteMuteConfigMethod;
    if ((getDeleteMuteConfigMethod = SecurityCenterGrpc.getDeleteMuteConfigMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getDeleteMuteConfigMethod = SecurityCenterGrpc.getDeleteMuteConfigMethod) == null) {
          SecurityCenterGrpc.getDeleteMuteConfigMethod =
              getDeleteMuteConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMuteConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("DeleteMuteConfig"))
                      .build();
        }
      }
    }
    return getDeleteMuteConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest,
          com.google.protobuf.Empty>
      getDeleteNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNotificationConfig",
      requestType = com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest,
          com.google.protobuf.Empty>
      getDeleteNotificationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest,
            com.google.protobuf.Empty>
        getDeleteNotificationConfigMethod;
    if ((getDeleteNotificationConfigMethod = SecurityCenterGrpc.getDeleteNotificationConfigMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getDeleteNotificationConfigMethod =
                SecurityCenterGrpc.getDeleteNotificationConfigMethod)
            == null) {
          SecurityCenterGrpc.getDeleteNotificationConfigMethod =
              getDeleteNotificationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteNotificationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("DeleteNotificationConfig"))
                      .build();
        }
      }
    }
    return getDeleteNotificationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest,
          com.google.protobuf.Empty>
      getDeleteResourceValueConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteResourceValueConfig",
      requestType = com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest,
          com.google.protobuf.Empty>
      getDeleteResourceValueConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest,
            com.google.protobuf.Empty>
        getDeleteResourceValueConfigMethod;
    if ((getDeleteResourceValueConfigMethod = SecurityCenterGrpc.getDeleteResourceValueConfigMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getDeleteResourceValueConfigMethod =
                SecurityCenterGrpc.getDeleteResourceValueConfigMethod)
            == null) {
          SecurityCenterGrpc.getDeleteResourceValueConfigMethod =
              getDeleteResourceValueConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteResourceValueConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("DeleteResourceValueConfig"))
                      .build();
        }
      }
    }
    return getDeleteResourceValueConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetBigQueryExportRequest,
          com.google.cloud.securitycenter.v2.BigQueryExport>
      getGetBigQueryExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBigQueryExport",
      requestType = com.google.cloud.securitycenter.v2.GetBigQueryExportRequest.class,
      responseType = com.google.cloud.securitycenter.v2.BigQueryExport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetBigQueryExportRequest,
          com.google.cloud.securitycenter.v2.BigQueryExport>
      getGetBigQueryExportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.GetBigQueryExportRequest,
            com.google.cloud.securitycenter.v2.BigQueryExport>
        getGetBigQueryExportMethod;
    if ((getGetBigQueryExportMethod = SecurityCenterGrpc.getGetBigQueryExportMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetBigQueryExportMethod = SecurityCenterGrpc.getGetBigQueryExportMethod) == null) {
          SecurityCenterGrpc.getGetBigQueryExportMethod =
              getGetBigQueryExportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.GetBigQueryExportRequest,
                          com.google.cloud.securitycenter.v2.BigQueryExport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBigQueryExport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.GetBigQueryExportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.BigQueryExport
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GetBigQueryExport"))
                      .build();
        }
      }
    }
    return getGetBigQueryExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetSimulationRequest,
          com.google.cloud.securitycenter.v2.Simulation>
      getGetSimulationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSimulation",
      requestType = com.google.cloud.securitycenter.v2.GetSimulationRequest.class,
      responseType = com.google.cloud.securitycenter.v2.Simulation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetSimulationRequest,
          com.google.cloud.securitycenter.v2.Simulation>
      getGetSimulationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.GetSimulationRequest,
            com.google.cloud.securitycenter.v2.Simulation>
        getGetSimulationMethod;
    if ((getGetSimulationMethod = SecurityCenterGrpc.getGetSimulationMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetSimulationMethod = SecurityCenterGrpc.getGetSimulationMethod) == null) {
          SecurityCenterGrpc.getGetSimulationMethod =
              getGetSimulationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.GetSimulationRequest,
                          com.google.cloud.securitycenter.v2.Simulation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSimulation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.GetSimulationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.Simulation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GetSimulation"))
                      .build();
        }
      }
    }
    return getGetSimulationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetValuedResourceRequest,
          com.google.cloud.securitycenter.v2.ValuedResource>
      getGetValuedResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetValuedResource",
      requestType = com.google.cloud.securitycenter.v2.GetValuedResourceRequest.class,
      responseType = com.google.cloud.securitycenter.v2.ValuedResource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetValuedResourceRequest,
          com.google.cloud.securitycenter.v2.ValuedResource>
      getGetValuedResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.GetValuedResourceRequest,
            com.google.cloud.securitycenter.v2.ValuedResource>
        getGetValuedResourceMethod;
    if ((getGetValuedResourceMethod = SecurityCenterGrpc.getGetValuedResourceMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetValuedResourceMethod = SecurityCenterGrpc.getGetValuedResourceMethod) == null) {
          SecurityCenterGrpc.getGetValuedResourceMethod =
              getGetValuedResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.GetValuedResourceRequest,
                          com.google.cloud.securitycenter.v2.ValuedResource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetValuedResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.GetValuedResourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ValuedResource
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GetValuedResource"))
                      .build();
        }
      }
    }
    return getGetValuedResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = SecurityCenterGrpc.getGetIamPolicyMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetIamPolicyMethod = SecurityCenterGrpc.getGetIamPolicyMethod) == null) {
          SecurityCenterGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetMuteConfigRequest,
          com.google.cloud.securitycenter.v2.MuteConfig>
      getGetMuteConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMuteConfig",
      requestType = com.google.cloud.securitycenter.v2.GetMuteConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v2.MuteConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetMuteConfigRequest,
          com.google.cloud.securitycenter.v2.MuteConfig>
      getGetMuteConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.GetMuteConfigRequest,
            com.google.cloud.securitycenter.v2.MuteConfig>
        getGetMuteConfigMethod;
    if ((getGetMuteConfigMethod = SecurityCenterGrpc.getGetMuteConfigMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetMuteConfigMethod = SecurityCenterGrpc.getGetMuteConfigMethod) == null) {
          SecurityCenterGrpc.getGetMuteConfigMethod =
              getGetMuteConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.GetMuteConfigRequest,
                          com.google.cloud.securitycenter.v2.MuteConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMuteConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.GetMuteConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.MuteConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GetMuteConfig"))
                      .build();
        }
      }
    }
    return getGetMuteConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetNotificationConfigRequest,
          com.google.cloud.securitycenter.v2.NotificationConfig>
      getGetNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNotificationConfig",
      requestType = com.google.cloud.securitycenter.v2.GetNotificationConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v2.NotificationConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetNotificationConfigRequest,
          com.google.cloud.securitycenter.v2.NotificationConfig>
      getGetNotificationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.GetNotificationConfigRequest,
            com.google.cloud.securitycenter.v2.NotificationConfig>
        getGetNotificationConfigMethod;
    if ((getGetNotificationConfigMethod = SecurityCenterGrpc.getGetNotificationConfigMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetNotificationConfigMethod = SecurityCenterGrpc.getGetNotificationConfigMethod)
            == null) {
          SecurityCenterGrpc.getGetNotificationConfigMethod =
              getGetNotificationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.GetNotificationConfigRequest,
                          com.google.cloud.securitycenter.v2.NotificationConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetNotificationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.GetNotificationConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.NotificationConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GetNotificationConfig"))
                      .build();
        }
      }
    }
    return getGetNotificationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest,
          com.google.cloud.securitycenter.v2.ResourceValueConfig>
      getGetResourceValueConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetResourceValueConfig",
      requestType = com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v2.ResourceValueConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest,
          com.google.cloud.securitycenter.v2.ResourceValueConfig>
      getGetResourceValueConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest,
            com.google.cloud.securitycenter.v2.ResourceValueConfig>
        getGetResourceValueConfigMethod;
    if ((getGetResourceValueConfigMethod = SecurityCenterGrpc.getGetResourceValueConfigMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetResourceValueConfigMethod = SecurityCenterGrpc.getGetResourceValueConfigMethod)
            == null) {
          SecurityCenterGrpc.getGetResourceValueConfigMethod =
              getGetResourceValueConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest,
                          com.google.cloud.securitycenter.v2.ResourceValueConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetResourceValueConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ResourceValueConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GetResourceValueConfig"))
                      .build();
        }
      }
    }
    return getGetResourceValueConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetSourceRequest,
          com.google.cloud.securitycenter.v2.Source>
      getGetSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSource",
      requestType = com.google.cloud.securitycenter.v2.GetSourceRequest.class,
      responseType = com.google.cloud.securitycenter.v2.Source.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GetSourceRequest,
          com.google.cloud.securitycenter.v2.Source>
      getGetSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.GetSourceRequest,
            com.google.cloud.securitycenter.v2.Source>
        getGetSourceMethod;
    if ((getGetSourceMethod = SecurityCenterGrpc.getGetSourceMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetSourceMethod = SecurityCenterGrpc.getGetSourceMethod) == null) {
          SecurityCenterGrpc.getGetSourceMethod =
              getGetSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.GetSourceRequest,
                          com.google.cloud.securitycenter.v2.Source>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.GetSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.Source.getDefaultInstance()))
                      .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("GetSource"))
                      .build();
        }
      }
    }
    return getGetSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GroupFindingsRequest,
          com.google.cloud.securitycenter.v2.GroupFindingsResponse>
      getGroupFindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GroupFindings",
      requestType = com.google.cloud.securitycenter.v2.GroupFindingsRequest.class,
      responseType = com.google.cloud.securitycenter.v2.GroupFindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.GroupFindingsRequest,
          com.google.cloud.securitycenter.v2.GroupFindingsResponse>
      getGroupFindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.GroupFindingsRequest,
            com.google.cloud.securitycenter.v2.GroupFindingsResponse>
        getGroupFindingsMethod;
    if ((getGroupFindingsMethod = SecurityCenterGrpc.getGroupFindingsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGroupFindingsMethod = SecurityCenterGrpc.getGroupFindingsMethod) == null) {
          SecurityCenterGrpc.getGroupFindingsMethod =
              getGroupFindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.GroupFindingsRequest,
                          com.google.cloud.securitycenter.v2.GroupFindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GroupFindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.GroupFindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.GroupFindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GroupFindings"))
                      .build();
        }
      }
    }
    return getGroupFindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListAttackPathsRequest,
          com.google.cloud.securitycenter.v2.ListAttackPathsResponse>
      getListAttackPathsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAttackPaths",
      requestType = com.google.cloud.securitycenter.v2.ListAttackPathsRequest.class,
      responseType = com.google.cloud.securitycenter.v2.ListAttackPathsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListAttackPathsRequest,
          com.google.cloud.securitycenter.v2.ListAttackPathsResponse>
      getListAttackPathsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.ListAttackPathsRequest,
            com.google.cloud.securitycenter.v2.ListAttackPathsResponse>
        getListAttackPathsMethod;
    if ((getListAttackPathsMethod = SecurityCenterGrpc.getListAttackPathsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListAttackPathsMethod = SecurityCenterGrpc.getListAttackPathsMethod) == null) {
          SecurityCenterGrpc.getListAttackPathsMethod =
              getListAttackPathsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.ListAttackPathsRequest,
                          com.google.cloud.securitycenter.v2.ListAttackPathsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAttackPaths"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListAttackPathsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListAttackPathsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("ListAttackPaths"))
                      .build();
        }
      }
    }
    return getListAttackPathsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest,
          com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse>
      getListBigQueryExportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBigQueryExports",
      requestType = com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest.class,
      responseType = com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest,
          com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse>
      getListBigQueryExportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest,
            com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse>
        getListBigQueryExportsMethod;
    if ((getListBigQueryExportsMethod = SecurityCenterGrpc.getListBigQueryExportsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListBigQueryExportsMethod = SecurityCenterGrpc.getListBigQueryExportsMethod)
            == null) {
          SecurityCenterGrpc.getListBigQueryExportsMethod =
              getListBigQueryExportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest,
                          com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBigQueryExports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("ListBigQueryExports"))
                      .build();
        }
      }
    }
    return getListBigQueryExportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListFindingsRequest,
          com.google.cloud.securitycenter.v2.ListFindingsResponse>
      getListFindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFindings",
      requestType = com.google.cloud.securitycenter.v2.ListFindingsRequest.class,
      responseType = com.google.cloud.securitycenter.v2.ListFindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListFindingsRequest,
          com.google.cloud.securitycenter.v2.ListFindingsResponse>
      getListFindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.ListFindingsRequest,
            com.google.cloud.securitycenter.v2.ListFindingsResponse>
        getListFindingsMethod;
    if ((getListFindingsMethod = SecurityCenterGrpc.getListFindingsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListFindingsMethod = SecurityCenterGrpc.getListFindingsMethod) == null) {
          SecurityCenterGrpc.getListFindingsMethod =
              getListFindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.ListFindingsRequest,
                          com.google.cloud.securitycenter.v2.ListFindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListFindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListFindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("ListFindings"))
                      .build();
        }
      }
    }
    return getListFindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListMuteConfigsRequest,
          com.google.cloud.securitycenter.v2.ListMuteConfigsResponse>
      getListMuteConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMuteConfigs",
      requestType = com.google.cloud.securitycenter.v2.ListMuteConfigsRequest.class,
      responseType = com.google.cloud.securitycenter.v2.ListMuteConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListMuteConfigsRequest,
          com.google.cloud.securitycenter.v2.ListMuteConfigsResponse>
      getListMuteConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.ListMuteConfigsRequest,
            com.google.cloud.securitycenter.v2.ListMuteConfigsResponse>
        getListMuteConfigsMethod;
    if ((getListMuteConfigsMethod = SecurityCenterGrpc.getListMuteConfigsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListMuteConfigsMethod = SecurityCenterGrpc.getListMuteConfigsMethod) == null) {
          SecurityCenterGrpc.getListMuteConfigsMethod =
              getListMuteConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.ListMuteConfigsRequest,
                          com.google.cloud.securitycenter.v2.ListMuteConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMuteConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListMuteConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListMuteConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("ListMuteConfigs"))
                      .build();
        }
      }
    }
    return getListMuteConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest,
          com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse>
      getListNotificationConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNotificationConfigs",
      requestType = com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest.class,
      responseType = com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest,
          com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse>
      getListNotificationConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest,
            com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse>
        getListNotificationConfigsMethod;
    if ((getListNotificationConfigsMethod = SecurityCenterGrpc.getListNotificationConfigsMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListNotificationConfigsMethod = SecurityCenterGrpc.getListNotificationConfigsMethod)
            == null) {
          SecurityCenterGrpc.getListNotificationConfigsMethod =
              getListNotificationConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest,
                          com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListNotificationConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("ListNotificationConfigs"))
                      .build();
        }
      }
    }
    return getListNotificationConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest,
          com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse>
      getListResourceValueConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListResourceValueConfigs",
      requestType = com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest.class,
      responseType = com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest,
          com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse>
      getListResourceValueConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest,
            com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse>
        getListResourceValueConfigsMethod;
    if ((getListResourceValueConfigsMethod = SecurityCenterGrpc.getListResourceValueConfigsMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListResourceValueConfigsMethod =
                SecurityCenterGrpc.getListResourceValueConfigsMethod)
            == null) {
          SecurityCenterGrpc.getListResourceValueConfigsMethod =
              getListResourceValueConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest,
                          com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListResourceValueConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("ListResourceValueConfigs"))
                      .build();
        }
      }
    }
    return getListResourceValueConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListSourcesRequest,
          com.google.cloud.securitycenter.v2.ListSourcesResponse>
      getListSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSources",
      requestType = com.google.cloud.securitycenter.v2.ListSourcesRequest.class,
      responseType = com.google.cloud.securitycenter.v2.ListSourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListSourcesRequest,
          com.google.cloud.securitycenter.v2.ListSourcesResponse>
      getListSourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.ListSourcesRequest,
            com.google.cloud.securitycenter.v2.ListSourcesResponse>
        getListSourcesMethod;
    if ((getListSourcesMethod = SecurityCenterGrpc.getListSourcesMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListSourcesMethod = SecurityCenterGrpc.getListSourcesMethod) == null) {
          SecurityCenterGrpc.getListSourcesMethod =
              getListSourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.ListSourcesRequest,
                          com.google.cloud.securitycenter.v2.ListSourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListSourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListSourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("ListSources"))
                      .build();
        }
      }
    }
    return getListSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListValuedResourcesRequest,
          com.google.cloud.securitycenter.v2.ListValuedResourcesResponse>
      getListValuedResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListValuedResources",
      requestType = com.google.cloud.securitycenter.v2.ListValuedResourcesRequest.class,
      responseType = com.google.cloud.securitycenter.v2.ListValuedResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.ListValuedResourcesRequest,
          com.google.cloud.securitycenter.v2.ListValuedResourcesResponse>
      getListValuedResourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.ListValuedResourcesRequest,
            com.google.cloud.securitycenter.v2.ListValuedResourcesResponse>
        getListValuedResourcesMethod;
    if ((getListValuedResourcesMethod = SecurityCenterGrpc.getListValuedResourcesMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListValuedResourcesMethod = SecurityCenterGrpc.getListValuedResourcesMethod)
            == null) {
          SecurityCenterGrpc.getListValuedResourcesMethod =
              getListValuedResourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.ListValuedResourcesRequest,
                          com.google.cloud.securitycenter.v2.ListValuedResourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListValuedResources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListValuedResourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ListValuedResourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("ListValuedResources"))
                      .build();
        }
      }
    }
    return getListValuedResourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.SetFindingStateRequest,
          com.google.cloud.securitycenter.v2.Finding>
      getSetFindingStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetFindingState",
      requestType = com.google.cloud.securitycenter.v2.SetFindingStateRequest.class,
      responseType = com.google.cloud.securitycenter.v2.Finding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.SetFindingStateRequest,
          com.google.cloud.securitycenter.v2.Finding>
      getSetFindingStateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.SetFindingStateRequest,
            com.google.cloud.securitycenter.v2.Finding>
        getSetFindingStateMethod;
    if ((getSetFindingStateMethod = SecurityCenterGrpc.getSetFindingStateMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getSetFindingStateMethod = SecurityCenterGrpc.getSetFindingStateMethod) == null) {
          SecurityCenterGrpc.getSetFindingStateMethod =
              getSetFindingStateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.SetFindingStateRequest,
                          com.google.cloud.securitycenter.v2.Finding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetFindingState"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.SetFindingStateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.Finding.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("SetFindingState"))
                      .build();
        }
      }
    }
    return getSetFindingStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = SecurityCenterGrpc.getSetIamPolicyMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getSetIamPolicyMethod = SecurityCenterGrpc.getSetIamPolicyMethod) == null) {
          SecurityCenterGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.SetMuteRequest,
          com.google.cloud.securitycenter.v2.Finding>
      getSetMuteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetMute",
      requestType = com.google.cloud.securitycenter.v2.SetMuteRequest.class,
      responseType = com.google.cloud.securitycenter.v2.Finding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.SetMuteRequest,
          com.google.cloud.securitycenter.v2.Finding>
      getSetMuteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.SetMuteRequest,
            com.google.cloud.securitycenter.v2.Finding>
        getSetMuteMethod;
    if ((getSetMuteMethod = SecurityCenterGrpc.getSetMuteMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getSetMuteMethod = SecurityCenterGrpc.getSetMuteMethod) == null) {
          SecurityCenterGrpc.getSetMuteMethod =
              getSetMuteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.SetMuteRequest,
                          com.google.cloud.securitycenter.v2.Finding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetMute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.SetMuteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.Finding.getDefaultInstance()))
                      .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("SetMute"))
                      .build();
        }
      }
    }
    return getSetMuteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = SecurityCenterGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getTestIamPermissionsMethod = SecurityCenterGrpc.getTestIamPermissionsMethod)
            == null) {
          SecurityCenterGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest,
          com.google.cloud.securitycenter.v2.BigQueryExport>
      getUpdateBigQueryExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBigQueryExport",
      requestType = com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest.class,
      responseType = com.google.cloud.securitycenter.v2.BigQueryExport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest,
          com.google.cloud.securitycenter.v2.BigQueryExport>
      getUpdateBigQueryExportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest,
            com.google.cloud.securitycenter.v2.BigQueryExport>
        getUpdateBigQueryExportMethod;
    if ((getUpdateBigQueryExportMethod = SecurityCenterGrpc.getUpdateBigQueryExportMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateBigQueryExportMethod = SecurityCenterGrpc.getUpdateBigQueryExportMethod)
            == null) {
          SecurityCenterGrpc.getUpdateBigQueryExportMethod =
              getUpdateBigQueryExportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest,
                          com.google.cloud.securitycenter.v2.BigQueryExport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateBigQueryExport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.BigQueryExport
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateBigQueryExport"))
                      .build();
        }
      }
    }
    return getUpdateBigQueryExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest,
          com.google.cloud.securitycenter.v2.ExternalSystem>
      getUpdateExternalSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExternalSystem",
      requestType = com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest.class,
      responseType = com.google.cloud.securitycenter.v2.ExternalSystem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest,
          com.google.cloud.securitycenter.v2.ExternalSystem>
      getUpdateExternalSystemMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest,
            com.google.cloud.securitycenter.v2.ExternalSystem>
        getUpdateExternalSystemMethod;
    if ((getUpdateExternalSystemMethod = SecurityCenterGrpc.getUpdateExternalSystemMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateExternalSystemMethod = SecurityCenterGrpc.getUpdateExternalSystemMethod)
            == null) {
          SecurityCenterGrpc.getUpdateExternalSystemMethod =
              getUpdateExternalSystemMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest,
                          com.google.cloud.securitycenter.v2.ExternalSystem>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateExternalSystem"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ExternalSystem
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateExternalSystem"))
                      .build();
        }
      }
    }
    return getUpdateExternalSystemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateFindingRequest,
          com.google.cloud.securitycenter.v2.Finding>
      getUpdateFindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFinding",
      requestType = com.google.cloud.securitycenter.v2.UpdateFindingRequest.class,
      responseType = com.google.cloud.securitycenter.v2.Finding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateFindingRequest,
          com.google.cloud.securitycenter.v2.Finding>
      getUpdateFindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.UpdateFindingRequest,
            com.google.cloud.securitycenter.v2.Finding>
        getUpdateFindingMethod;
    if ((getUpdateFindingMethod = SecurityCenterGrpc.getUpdateFindingMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateFindingMethod = SecurityCenterGrpc.getUpdateFindingMethod) == null) {
          SecurityCenterGrpc.getUpdateFindingMethod =
              getUpdateFindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.UpdateFindingRequest,
                          com.google.cloud.securitycenter.v2.Finding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.UpdateFindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.Finding.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateFinding"))
                      .build();
        }
      }
    }
    return getUpdateFindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest,
          com.google.cloud.securitycenter.v2.MuteConfig>
      getUpdateMuteConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMuteConfig",
      requestType = com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v2.MuteConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest,
          com.google.cloud.securitycenter.v2.MuteConfig>
      getUpdateMuteConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest,
            com.google.cloud.securitycenter.v2.MuteConfig>
        getUpdateMuteConfigMethod;
    if ((getUpdateMuteConfigMethod = SecurityCenterGrpc.getUpdateMuteConfigMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateMuteConfigMethod = SecurityCenterGrpc.getUpdateMuteConfigMethod) == null) {
          SecurityCenterGrpc.getUpdateMuteConfigMethod =
              getUpdateMuteConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest,
                          com.google.cloud.securitycenter.v2.MuteConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMuteConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.MuteConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateMuteConfig"))
                      .build();
        }
      }
    }
    return getUpdateMuteConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest,
          com.google.cloud.securitycenter.v2.NotificationConfig>
      getUpdateNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNotificationConfig",
      requestType = com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v2.NotificationConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest,
          com.google.cloud.securitycenter.v2.NotificationConfig>
      getUpdateNotificationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest,
            com.google.cloud.securitycenter.v2.NotificationConfig>
        getUpdateNotificationConfigMethod;
    if ((getUpdateNotificationConfigMethod = SecurityCenterGrpc.getUpdateNotificationConfigMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateNotificationConfigMethod =
                SecurityCenterGrpc.getUpdateNotificationConfigMethod)
            == null) {
          SecurityCenterGrpc.getUpdateNotificationConfigMethod =
              getUpdateNotificationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest,
                          com.google.cloud.securitycenter.v2.NotificationConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateNotificationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.NotificationConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateNotificationConfig"))
                      .build();
        }
      }
    }
    return getUpdateNotificationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest,
          com.google.cloud.securitycenter.v2.ResourceValueConfig>
      getUpdateResourceValueConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateResourceValueConfig",
      requestType = com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v2.ResourceValueConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest,
          com.google.cloud.securitycenter.v2.ResourceValueConfig>
      getUpdateResourceValueConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest,
            com.google.cloud.securitycenter.v2.ResourceValueConfig>
        getUpdateResourceValueConfigMethod;
    if ((getUpdateResourceValueConfigMethod = SecurityCenterGrpc.getUpdateResourceValueConfigMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateResourceValueConfigMethod =
                SecurityCenterGrpc.getUpdateResourceValueConfigMethod)
            == null) {
          SecurityCenterGrpc.getUpdateResourceValueConfigMethod =
              getUpdateResourceValueConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest,
                          com.google.cloud.securitycenter.v2.ResourceValueConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateResourceValueConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.ResourceValueConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateResourceValueConfig"))
                      .build();
        }
      }
    }
    return getUpdateResourceValueConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest,
          com.google.cloud.securitycenter.v2.SecurityMarks>
      getUpdateSecurityMarksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSecurityMarks",
      requestType = com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest.class,
      responseType = com.google.cloud.securitycenter.v2.SecurityMarks.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest,
          com.google.cloud.securitycenter.v2.SecurityMarks>
      getUpdateSecurityMarksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest,
            com.google.cloud.securitycenter.v2.SecurityMarks>
        getUpdateSecurityMarksMethod;
    if ((getUpdateSecurityMarksMethod = SecurityCenterGrpc.getUpdateSecurityMarksMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateSecurityMarksMethod = SecurityCenterGrpc.getUpdateSecurityMarksMethod)
            == null) {
          SecurityCenterGrpc.getUpdateSecurityMarksMethod =
              getUpdateSecurityMarksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest,
                          com.google.cloud.securitycenter.v2.SecurityMarks>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSecurityMarks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.SecurityMarks
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateSecurityMarks"))
                      .build();
        }
      }
    }
    return getUpdateSecurityMarksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateSourceRequest,
          com.google.cloud.securitycenter.v2.Source>
      getUpdateSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSource",
      requestType = com.google.cloud.securitycenter.v2.UpdateSourceRequest.class,
      responseType = com.google.cloud.securitycenter.v2.Source.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v2.UpdateSourceRequest,
          com.google.cloud.securitycenter.v2.Source>
      getUpdateSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v2.UpdateSourceRequest,
            com.google.cloud.securitycenter.v2.Source>
        getUpdateSourceMethod;
    if ((getUpdateSourceMethod = SecurityCenterGrpc.getUpdateSourceMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateSourceMethod = SecurityCenterGrpc.getUpdateSourceMethod) == null) {
          SecurityCenterGrpc.getUpdateSourceMethod =
              getUpdateSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v2.UpdateSourceRequest,
                          com.google.cloud.securitycenter.v2.Source>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.UpdateSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v2.Source.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateSource"))
                      .build();
        }
      }
    }
    return getUpdateSourceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SecurityCenterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterStub>() {
          @java.lang.Override
          public SecurityCenterStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityCenterStub(channel, callOptions);
          }
        };
    return SecurityCenterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecurityCenterBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterBlockingStub>() {
          @java.lang.Override
          public SecurityCenterBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityCenterBlockingStub(channel, callOptions);
          }
        };
    return SecurityCenterBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SecurityCenterFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterFutureStub>() {
          @java.lang.Override
          public SecurityCenterFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityCenterFutureStub(channel, callOptions);
          }
        };
    return SecurityCenterFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * V2 APIs for Security Center service.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a ResourceValueConfig for an organization. Maps user's tags to
     * difference resource values for use by the attack path simulation.
     * </pre>
     */
    default void batchCreateResourceValueConfigs(
        com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateResourceValueConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Kicks off an LRO to bulk mute findings for a parent based on a filter. If
     * no location is specified, findings are muted in global. The parent
     * can be either an organization, folder, or project. The findings matched by
     * the filter will be muted after the LRO is done.
     * </pre>
     */
    default void bulkMuteFindings(
        com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBulkMuteFindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a BigQuery export.
     * </pre>
     */
    default void createBigQueryExport(
        com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.BigQueryExport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBigQueryExportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a finding in a location. The corresponding source must exist for
     * finding creation to succeed.
     * </pre>
     */
    default void createFinding(
        com.google.cloud.securitycenter.v2.CreateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Finding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a mute config.
     * </pre>
     */
    default void createMuteConfig(
        com.google.cloud.securitycenter.v2.CreateMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.MuteConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMuteConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a notification config.
     * </pre>
     */
    default void createNotificationConfig(
        com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.NotificationConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateNotificationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a source.
     * </pre>
     */
    default void createSource(
        com.google.cloud.securitycenter.v2.CreateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Source> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing BigQuery export.
     * </pre>
     */
    default void deleteBigQueryExport(
        com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBigQueryExportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing mute config. If no location is specified, default is
     * global.
     * </pre>
     */
    default void deleteMuteConfig(
        com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMuteConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a notification config.
     * </pre>
     */
    default void deleteNotificationConfig(
        com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteNotificationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ResourceValueConfig.
     * </pre>
     */
    default void deleteResourceValueConfig(
        com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteResourceValueConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a BigQuery export.
     * </pre>
     */
    default void getBigQueryExport(
        com.google.cloud.securitycenter.v2.GetBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.BigQueryExport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBigQueryExportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the simulation by name or the latest simulation for the given
     * organization.
     * </pre>
     */
    default void getSimulation(
        com.google.cloud.securitycenter.v2.GetSimulationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Simulation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSimulationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the valued resource by name
     * </pre>
     */
    default void getValuedResource(
        com.google.cloud.securitycenter.v2.GetValuedResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ValuedResource>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetValuedResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy on the specified Source.
     * </pre>
     */
    default void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a mute config. If no location is specified, default is
     * global.
     * </pre>
     */
    default void getMuteConfig(
        com.google.cloud.securitycenter.v2.GetMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.MuteConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMuteConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a notification config.
     * </pre>
     */
    default void getNotificationConfig(
        com.google.cloud.securitycenter.v2.GetNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.NotificationConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNotificationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ResourceValueConfig.
     * </pre>
     */
    default void getResourceValueConfig(
        com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ResourceValueConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetResourceValueConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a source.
     * </pre>
     */
    default void getSource(
        com.google.cloud.securitycenter.v2.GetSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Source> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization or source's findings and groups them by their
     * specified properties in a location. If no location is specified, findings
     * are assumed to be in global
     * To group across all sources provide a `-` as the source id.
     * The following list shows some examples:
     * + `/v2/organizations/{organization_id}/sources/-/findings`
     * +
     * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`
     * + `/v2/folders/{folder_id}/sources/-/findings`
     * + `/v2/folders/{folder_id}/sources/-/locations/{location_id}/findings`
     * + `/v2/projects/{project_id}/sources/-/findings`
     * + `/v2/projects/{project_id}/sources/-/locations/{location_id}/findings`
     * </pre>
     */
    default void groupFindings(
        com.google.cloud.securitycenter.v2.GroupFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.GroupFindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGroupFindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the attack paths for a set of simulation results or valued resources
     * and filter.
     * </pre>
     */
    default void listAttackPaths(
        com.google.cloud.securitycenter.v2.ListAttackPathsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListAttackPathsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAttackPathsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BigQuery exports. Note that when requesting BigQuery exports at a
     * given level all exports under that level are also returned e.g. if
     * requesting BigQuery exports under a folder, then all BigQuery exports
     * immediately under the folder plus the ones created under the projects
     * within the folder are returned.
     * </pre>
     */
    default void listBigQueryExports(
        com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBigQueryExportsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources for a given location provide a `-` as the source
     * id. If no location is specified, finding are assumed to be in global.
     * The following list shows some examples:
     * + `/v2/organizations/{organization_id}/sources/-/findings`
     * +
     * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`
     * </pre>
     */
    default void listFindings(
        com.google.cloud.securitycenter.v2.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListFindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists mute configs. If no location is specified, default is
     * global.
     * </pre>
     */
    default void listMuteConfigs(
        com.google.cloud.securitycenter.v2.ListMuteConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListMuteConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMuteConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists notification configs.
     * </pre>
     */
    default void listNotificationConfigs(
        com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNotificationConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all ResourceValueConfigs.
     * </pre>
     */
    default void listResourceValueConfigs(
        com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListResourceValueConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    default void listSources(
        com.google.cloud.securitycenter.v2.ListSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListSourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the valued resources for a set of simulation results and filter.
     * </pre>
     */
    default void listValuedResources(
        com.google.cloud.securitycenter.v2.ListValuedResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListValuedResourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListValuedResourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the state of a finding. If no location is specified, finding is
     * assumed to be in global
     * </pre>
     */
    default void setFindingState(
        com.google.cloud.securitycenter.v2.SetFindingStateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Finding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetFindingStateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified Source.
     * </pre>
     */
    default void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the mute state of a finding. If no location is specified, finding
     * is assumed to be in global
     * </pre>
     */
    default void setMute(
        com.google.cloud.securitycenter.v2.SetMuteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Finding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetMuteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified source.
     * </pre>
     */
    default void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a BigQuery export.
     * </pre>
     */
    default void updateBigQueryExport(
        com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.BigQueryExport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBigQueryExportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates external system. This is for a given finding. If no location is
     * specified, finding is assumed to be in global
     * </pre>
     */
    default void updateExternalSystem(
        com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ExternalSystem>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateExternalSystemMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a finding. If no location is specified, finding is
     * assumed to be in global. The corresponding source must exist for a finding
     * creation to succeed.
     * </pre>
     */
    default void updateFinding(
        com.google.cloud.securitycenter.v2.UpdateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Finding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a mute config. If no location is specified, default is
     * global.
     * </pre>
     */
    default void updateMuteConfig(
        com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.MuteConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMuteConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a notification config. The following update
     * fields are allowed: description, pubsub_topic, streaming_config.filter
     * </pre>
     */
    default void updateNotificationConfig(
        com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.NotificationConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateNotificationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing ResourceValueConfigs with new rules.
     * </pre>
     */
    default void updateResourceValueConfig(
        com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ResourceValueConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateResourceValueConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates security marks. For Finding Security marks, if no location is
     * specified, finding is assumed to be in global. Assets Security Marks can
     * only be accessed through global endpoint.
     * </pre>
     */
    default void updateSecurityMarks(
        com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.SecurityMarks>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSecurityMarksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a source.
     * </pre>
     */
    default void updateSource(
        com.google.cloud.securitycenter.v2.UpdateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Source> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSourceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SecurityCenter.
   *
   * <pre>
   * V2 APIs for Security Center service.
   * </pre>
   */
  public abstract static class SecurityCenterImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SecurityCenterGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SecurityCenter.
   *
   * <pre>
   * V2 APIs for Security Center service.
   * </pre>
   */
  public static final class SecurityCenterStub
      extends io.grpc.stub.AbstractAsyncStub<SecurityCenterStub> {
    private SecurityCenterStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a ResourceValueConfig for an organization. Maps user's tags to
     * difference resource values for use by the attack path simulation.
     * </pre>
     */
    public void batchCreateResourceValueConfigs(
        com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateResourceValueConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Kicks off an LRO to bulk mute findings for a parent based on a filter. If
     * no location is specified, findings are muted in global. The parent
     * can be either an organization, folder, or project. The findings matched by
     * the filter will be muted after the LRO is done.
     * </pre>
     */
    public void bulkMuteFindings(
        com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBulkMuteFindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a BigQuery export.
     * </pre>
     */
    public void createBigQueryExport(
        com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.BigQueryExport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBigQueryExportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a finding in a location. The corresponding source must exist for
     * finding creation to succeed.
     * </pre>
     */
    public void createFinding(
        com.google.cloud.securitycenter.v2.CreateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Finding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a mute config.
     * </pre>
     */
    public void createMuteConfig(
        com.google.cloud.securitycenter.v2.CreateMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.MuteConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMuteConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a notification config.
     * </pre>
     */
    public void createNotificationConfig(
        com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.NotificationConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNotificationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a source.
     * </pre>
     */
    public void createSource(
        com.google.cloud.securitycenter.v2.CreateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Source> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing BigQuery export.
     * </pre>
     */
    public void deleteBigQueryExport(
        com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBigQueryExportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing mute config. If no location is specified, default is
     * global.
     * </pre>
     */
    public void deleteMuteConfig(
        com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMuteConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a notification config.
     * </pre>
     */
    public void deleteNotificationConfig(
        com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNotificationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ResourceValueConfig.
     * </pre>
     */
    public void deleteResourceValueConfig(
        com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteResourceValueConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a BigQuery export.
     * </pre>
     */
    public void getBigQueryExport(
        com.google.cloud.securitycenter.v2.GetBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.BigQueryExport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBigQueryExportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the simulation by name or the latest simulation for the given
     * organization.
     * </pre>
     */
    public void getSimulation(
        com.google.cloud.securitycenter.v2.GetSimulationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Simulation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSimulationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the valued resource by name
     * </pre>
     */
    public void getValuedResource(
        com.google.cloud.securitycenter.v2.GetValuedResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ValuedResource>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetValuedResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy on the specified Source.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a mute config. If no location is specified, default is
     * global.
     * </pre>
     */
    public void getMuteConfig(
        com.google.cloud.securitycenter.v2.GetMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.MuteConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMuteConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a notification config.
     * </pre>
     */
    public void getNotificationConfig(
        com.google.cloud.securitycenter.v2.GetNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.NotificationConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNotificationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ResourceValueConfig.
     * </pre>
     */
    public void getResourceValueConfig(
        com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ResourceValueConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetResourceValueConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a source.
     * </pre>
     */
    public void getSource(
        com.google.cloud.securitycenter.v2.GetSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Source> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization or source's findings and groups them by their
     * specified properties in a location. If no location is specified, findings
     * are assumed to be in global
     * To group across all sources provide a `-` as the source id.
     * The following list shows some examples:
     * + `/v2/organizations/{organization_id}/sources/-/findings`
     * +
     * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`
     * + `/v2/folders/{folder_id}/sources/-/findings`
     * + `/v2/folders/{folder_id}/sources/-/locations/{location_id}/findings`
     * + `/v2/projects/{project_id}/sources/-/findings`
     * + `/v2/projects/{project_id}/sources/-/locations/{location_id}/findings`
     * </pre>
     */
    public void groupFindings(
        com.google.cloud.securitycenter.v2.GroupFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.GroupFindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGroupFindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the attack paths for a set of simulation results or valued resources
     * and filter.
     * </pre>
     */
    public void listAttackPaths(
        com.google.cloud.securitycenter.v2.ListAttackPathsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListAttackPathsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAttackPathsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BigQuery exports. Note that when requesting BigQuery exports at a
     * given level all exports under that level are also returned e.g. if
     * requesting BigQuery exports under a folder, then all BigQuery exports
     * immediately under the folder plus the ones created under the projects
     * within the folder are returned.
     * </pre>
     */
    public void listBigQueryExports(
        com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBigQueryExportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources for a given location provide a `-` as the source
     * id. If no location is specified, finding are assumed to be in global.
     * The following list shows some examples:
     * + `/v2/organizations/{organization_id}/sources/-/findings`
     * +
     * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`
     * </pre>
     */
    public void listFindings(
        com.google.cloud.securitycenter.v2.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListFindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists mute configs. If no location is specified, default is
     * global.
     * </pre>
     */
    public void listMuteConfigs(
        com.google.cloud.securitycenter.v2.ListMuteConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListMuteConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMuteConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists notification configs.
     * </pre>
     */
    public void listNotificationConfigs(
        com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNotificationConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all ResourceValueConfigs.
     * </pre>
     */
    public void listResourceValueConfigs(
        com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListResourceValueConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public void listSources(
        com.google.cloud.securitycenter.v2.ListSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListSourcesResponse>
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
     * Lists the valued resources for a set of simulation results and filter.
     * </pre>
     */
    public void listValuedResources(
        com.google.cloud.securitycenter.v2.ListValuedResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListValuedResourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListValuedResourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the state of a finding. If no location is specified, finding is
     * assumed to be in global
     * </pre>
     */
    public void setFindingState(
        com.google.cloud.securitycenter.v2.SetFindingStateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Finding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetFindingStateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified Source.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the mute state of a finding. If no location is specified, finding
     * is assumed to be in global
     * </pre>
     */
    public void setMute(
        com.google.cloud.securitycenter.v2.SetMuteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Finding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetMuteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified source.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a BigQuery export.
     * </pre>
     */
    public void updateBigQueryExport(
        com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.BigQueryExport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBigQueryExportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates external system. This is for a given finding. If no location is
     * specified, finding is assumed to be in global
     * </pre>
     */
    public void updateExternalSystem(
        com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ExternalSystem>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExternalSystemMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a finding. If no location is specified, finding is
     * assumed to be in global. The corresponding source must exist for a finding
     * creation to succeed.
     * </pre>
     */
    public void updateFinding(
        com.google.cloud.securitycenter.v2.UpdateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Finding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a mute config. If no location is specified, default is
     * global.
     * </pre>
     */
    public void updateMuteConfig(
        com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.MuteConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMuteConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a notification config. The following update
     * fields are allowed: description, pubsub_topic, streaming_config.filter
     * </pre>
     */
    public void updateNotificationConfig(
        com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.NotificationConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNotificationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing ResourceValueConfigs with new rules.
     * </pre>
     */
    public void updateResourceValueConfig(
        com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ResourceValueConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateResourceValueConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates security marks. For Finding Security marks, if no location is
     * specified, finding is assumed to be in global. Assets Security Marks can
     * only be accessed through global endpoint.
     * </pre>
     */
    public void updateSecurityMarks(
        com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.SecurityMarks>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSecurityMarksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a source.
     * </pre>
     */
    public void updateSource(
        com.google.cloud.securitycenter.v2.UpdateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Source> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SecurityCenter.
   *
   * <pre>
   * V2 APIs for Security Center service.
   * </pre>
   */
  public static final class SecurityCenterBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SecurityCenterBlockingStub> {
    private SecurityCenterBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a ResourceValueConfig for an organization. Maps user's tags to
     * difference resource values for use by the attack path simulation.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse
        batchCreateResourceValueConfigs(
            com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateResourceValueConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Kicks off an LRO to bulk mute findings for a parent based on a filter. If
     * no location is specified, findings are muted in global. The parent
     * can be either an organization, folder, or project. The findings matched by
     * the filter will be muted after the LRO is done.
     * </pre>
     */
    public com.google.longrunning.Operation bulkMuteFindings(
        com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkMuteFindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a BigQuery export.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.BigQueryExport createBigQueryExport(
        com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBigQueryExportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a finding in a location. The corresponding source must exist for
     * finding creation to succeed.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.Finding createFinding(
        com.google.cloud.securitycenter.v2.CreateFindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a mute config.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.MuteConfig createMuteConfig(
        com.google.cloud.securitycenter.v2.CreateMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMuteConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a notification config.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.NotificationConfig createNotificationConfig(
        com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a source.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.Source createSource(
        com.google.cloud.securitycenter.v2.CreateSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing BigQuery export.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBigQueryExport(
        com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBigQueryExportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing mute config. If no location is specified, default is
     * global.
     * </pre>
     */
    public com.google.protobuf.Empty deleteMuteConfig(
        com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMuteConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a notification config.
     * </pre>
     */
    public com.google.protobuf.Empty deleteNotificationConfig(
        com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ResourceValueConfig.
     * </pre>
     */
    public com.google.protobuf.Empty deleteResourceValueConfig(
        com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteResourceValueConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a BigQuery export.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.BigQueryExport getBigQueryExport(
        com.google.cloud.securitycenter.v2.GetBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBigQueryExportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get the simulation by name or the latest simulation for the given
     * organization.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.Simulation getSimulation(
        com.google.cloud.securitycenter.v2.GetSimulationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSimulationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get the valued resource by name
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.ValuedResource getValuedResource(
        com.google.cloud.securitycenter.v2.GetValuedResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetValuedResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy on the specified Source.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a mute config. If no location is specified, default is
     * global.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.MuteConfig getMuteConfig(
        com.google.cloud.securitycenter.v2.GetMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMuteConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a notification config.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.NotificationConfig getNotificationConfig(
        com.google.cloud.securitycenter.v2.GetNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ResourceValueConfig.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.ResourceValueConfig getResourceValueConfig(
        com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetResourceValueConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a source.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.Source getSource(
        com.google.cloud.securitycenter.v2.GetSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization or source's findings and groups them by their
     * specified properties in a location. If no location is specified, findings
     * are assumed to be in global
     * To group across all sources provide a `-` as the source id.
     * The following list shows some examples:
     * + `/v2/organizations/{organization_id}/sources/-/findings`
     * +
     * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`
     * + `/v2/folders/{folder_id}/sources/-/findings`
     * + `/v2/folders/{folder_id}/sources/-/locations/{location_id}/findings`
     * + `/v2/projects/{project_id}/sources/-/findings`
     * + `/v2/projects/{project_id}/sources/-/locations/{location_id}/findings`
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.GroupFindingsResponse groupFindings(
        com.google.cloud.securitycenter.v2.GroupFindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGroupFindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the attack paths for a set of simulation results or valued resources
     * and filter.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.ListAttackPathsResponse listAttackPaths(
        com.google.cloud.securitycenter.v2.ListAttackPathsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAttackPathsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BigQuery exports. Note that when requesting BigQuery exports at a
     * given level all exports under that level are also returned e.g. if
     * requesting BigQuery exports under a folder, then all BigQuery exports
     * immediately under the folder plus the ones created under the projects
     * within the folder are returned.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse listBigQueryExports(
        com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBigQueryExportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources for a given location provide a `-` as the source
     * id. If no location is specified, finding are assumed to be in global.
     * The following list shows some examples:
     * + `/v2/organizations/{organization_id}/sources/-/findings`
     * +
     * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.ListFindingsResponse listFindings(
        com.google.cloud.securitycenter.v2.ListFindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists mute configs. If no location is specified, default is
     * global.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.ListMuteConfigsResponse listMuteConfigs(
        com.google.cloud.securitycenter.v2.ListMuteConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMuteConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists notification configs.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse
        listNotificationConfigs(
            com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNotificationConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all ResourceValueConfigs.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse
        listResourceValueConfigs(
            com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListResourceValueConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.ListSourcesResponse listSources(
        com.google.cloud.securitycenter.v2.ListSourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the valued resources for a set of simulation results and filter.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.ListValuedResourcesResponse listValuedResources(
        com.google.cloud.securitycenter.v2.ListValuedResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListValuedResourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the state of a finding. If no location is specified, finding is
     * assumed to be in global
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.Finding setFindingState(
        com.google.cloud.securitycenter.v2.SetFindingStateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetFindingStateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified Source.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the mute state of a finding. If no location is specified, finding
     * is assumed to be in global
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.Finding setMute(
        com.google.cloud.securitycenter.v2.SetMuteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetMuteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified source.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a BigQuery export.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.BigQueryExport updateBigQueryExport(
        com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBigQueryExportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates external system. This is for a given finding. If no location is
     * specified, finding is assumed to be in global
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.ExternalSystem updateExternalSystem(
        com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExternalSystemMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a finding. If no location is specified, finding is
     * assumed to be in global. The corresponding source must exist for a finding
     * creation to succeed.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.Finding updateFinding(
        com.google.cloud.securitycenter.v2.UpdateFindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a mute config. If no location is specified, default is
     * global.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.MuteConfig updateMuteConfig(
        com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMuteConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a notification config. The following update
     * fields are allowed: description, pubsub_topic, streaming_config.filter
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.NotificationConfig updateNotificationConfig(
        com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing ResourceValueConfigs with new rules.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.ResourceValueConfig updateResourceValueConfig(
        com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateResourceValueConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates security marks. For Finding Security marks, if no location is
     * specified, finding is assumed to be in global. Assets Security Marks can
     * only be accessed through global endpoint.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.SecurityMarks updateSecurityMarks(
        com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSecurityMarksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a source.
     * </pre>
     */
    public com.google.cloud.securitycenter.v2.Source updateSource(
        com.google.cloud.securitycenter.v2.UpdateSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSourceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SecurityCenter.
   *
   * <pre>
   * V2 APIs for Security Center service.
   * </pre>
   */
  public static final class SecurityCenterFutureStub
      extends io.grpc.stub.AbstractFutureStub<SecurityCenterFutureStub> {
    private SecurityCenterFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a ResourceValueConfig for an organization. Maps user's tags to
     * difference resource values for use by the attack path simulation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse>
        batchCreateResourceValueConfigs(
            com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateResourceValueConfigsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Kicks off an LRO to bulk mute findings for a parent based on a filter. If
     * no location is specified, findings are muted in global. The parent
     * can be either an organization, folder, or project. The findings matched by
     * the filter will be muted after the LRO is done.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        bulkMuteFindings(com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBulkMuteFindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a BigQuery export.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.BigQueryExport>
        createBigQueryExport(
            com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBigQueryExportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a finding in a location. The corresponding source must exist for
     * finding creation to succeed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.Finding>
        createFinding(com.google.cloud.securitycenter.v2.CreateFindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a mute config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.MuteConfig>
        createMuteConfig(com.google.cloud.securitycenter.v2.CreateMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMuteConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a notification config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.NotificationConfig>
        createNotificationConfig(
            com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.Source>
        createSource(com.google.cloud.securitycenter.v2.CreateSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing BigQuery export.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteBigQueryExport(
            com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBigQueryExportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing mute config. If no location is specified, default is
     * global.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteMuteConfig(com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMuteConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a notification config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteNotificationConfig(
            com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ResourceValueConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteResourceValueConfig(
            com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteResourceValueConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a BigQuery export.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.BigQueryExport>
        getBigQueryExport(com.google.cloud.securitycenter.v2.GetBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBigQueryExportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get the simulation by name or the latest simulation for the given
     * organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.Simulation>
        getSimulation(com.google.cloud.securitycenter.v2.GetSimulationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSimulationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get the valued resource by name
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.ValuedResource>
        getValuedResource(com.google.cloud.securitycenter.v2.GetValuedResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetValuedResourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy on the specified Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a mute config. If no location is specified, default is
     * global.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.MuteConfig>
        getMuteConfig(com.google.cloud.securitycenter.v2.GetMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMuteConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a notification config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.NotificationConfig>
        getNotificationConfig(
            com.google.cloud.securitycenter.v2.GetNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ResourceValueConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.ResourceValueConfig>
        getResourceValueConfig(
            com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetResourceValueConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.Source>
        getSource(com.google.cloud.securitycenter.v2.GetSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization or source's findings and groups them by their
     * specified properties in a location. If no location is specified, findings
     * are assumed to be in global
     * To group across all sources provide a `-` as the source id.
     * The following list shows some examples:
     * + `/v2/organizations/{organization_id}/sources/-/findings`
     * +
     * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`
     * + `/v2/folders/{folder_id}/sources/-/findings`
     * + `/v2/folders/{folder_id}/sources/-/locations/{location_id}/findings`
     * + `/v2/projects/{project_id}/sources/-/findings`
     * + `/v2/projects/{project_id}/sources/-/locations/{location_id}/findings`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.GroupFindingsResponse>
        groupFindings(com.google.cloud.securitycenter.v2.GroupFindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGroupFindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the attack paths for a set of simulation results or valued resources
     * and filter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.ListAttackPathsResponse>
        listAttackPaths(com.google.cloud.securitycenter.v2.ListAttackPathsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAttackPathsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BigQuery exports. Note that when requesting BigQuery exports at a
     * given level all exports under that level are also returned e.g. if
     * requesting BigQuery exports under a folder, then all BigQuery exports
     * immediately under the folder plus the ones created under the projects
     * within the folder are returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse>
        listBigQueryExports(com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBigQueryExportsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources for a given location provide a `-` as the source
     * id. If no location is specified, finding are assumed to be in global.
     * The following list shows some examples:
     * + `/v2/organizations/{organization_id}/sources/-/findings`
     * +
     * `/v2/organizations/{organization_id}/sources/-/locations/{location_id}/findings`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.ListFindingsResponse>
        listFindings(com.google.cloud.securitycenter.v2.ListFindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists mute configs. If no location is specified, default is
     * global.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.ListMuteConfigsResponse>
        listMuteConfigs(com.google.cloud.securitycenter.v2.ListMuteConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMuteConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists notification configs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse>
        listNotificationConfigs(
            com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNotificationConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all ResourceValueConfigs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse>
        listResourceValueConfigs(
            com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListResourceValueConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.ListSourcesResponse>
        listSources(com.google.cloud.securitycenter.v2.ListSourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the valued resources for a set of simulation results and filter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.ListValuedResourcesResponse>
        listValuedResources(com.google.cloud.securitycenter.v2.ListValuedResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListValuedResourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the state of a finding. If no location is specified, finding is
     * assumed to be in global
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.Finding>
        setFindingState(com.google.cloud.securitycenter.v2.SetFindingStateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetFindingStateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the mute state of a finding. If no location is specified, finding
     * is assumed to be in global
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.Finding>
        setMute(com.google.cloud.securitycenter.v2.SetMuteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetMuteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a BigQuery export.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.BigQueryExport>
        updateBigQueryExport(
            com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBigQueryExportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates external system. This is for a given finding. If no location is
     * specified, finding is assumed to be in global
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.ExternalSystem>
        updateExternalSystem(
            com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExternalSystemMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a finding. If no location is specified, finding is
     * assumed to be in global. The corresponding source must exist for a finding
     * creation to succeed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.Finding>
        updateFinding(com.google.cloud.securitycenter.v2.UpdateFindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a mute config. If no location is specified, default is
     * global.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.MuteConfig>
        updateMuteConfig(com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMuteConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a notification config. The following update
     * fields are allowed: description, pubsub_topic, streaming_config.filter
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.NotificationConfig>
        updateNotificationConfig(
            com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing ResourceValueConfigs with new rules.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.ResourceValueConfig>
        updateResourceValueConfig(
            com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateResourceValueConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates security marks. For Finding Security marks, if no location is
     * specified, finding is assumed to be in global. Assets Security Marks can
     * only be accessed through global endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.SecurityMarks>
        updateSecurityMarks(com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSecurityMarksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v2.Source>
        updateSource(com.google.cloud.securitycenter.v2.UpdateSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSourceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BATCH_CREATE_RESOURCE_VALUE_CONFIGS = 0;
  private static final int METHODID_BULK_MUTE_FINDINGS = 1;
  private static final int METHODID_CREATE_BIG_QUERY_EXPORT = 2;
  private static final int METHODID_CREATE_FINDING = 3;
  private static final int METHODID_CREATE_MUTE_CONFIG = 4;
  private static final int METHODID_CREATE_NOTIFICATION_CONFIG = 5;
  private static final int METHODID_CREATE_SOURCE = 6;
  private static final int METHODID_DELETE_BIG_QUERY_EXPORT = 7;
  private static final int METHODID_DELETE_MUTE_CONFIG = 8;
  private static final int METHODID_DELETE_NOTIFICATION_CONFIG = 9;
  private static final int METHODID_DELETE_RESOURCE_VALUE_CONFIG = 10;
  private static final int METHODID_GET_BIG_QUERY_EXPORT = 11;
  private static final int METHODID_GET_SIMULATION = 12;
  private static final int METHODID_GET_VALUED_RESOURCE = 13;
  private static final int METHODID_GET_IAM_POLICY = 14;
  private static final int METHODID_GET_MUTE_CONFIG = 15;
  private static final int METHODID_GET_NOTIFICATION_CONFIG = 16;
  private static final int METHODID_GET_RESOURCE_VALUE_CONFIG = 17;
  private static final int METHODID_GET_SOURCE = 18;
  private static final int METHODID_GROUP_FINDINGS = 19;
  private static final int METHODID_LIST_ATTACK_PATHS = 20;
  private static final int METHODID_LIST_BIG_QUERY_EXPORTS = 21;
  private static final int METHODID_LIST_FINDINGS = 22;
  private static final int METHODID_LIST_MUTE_CONFIGS = 23;
  private static final int METHODID_LIST_NOTIFICATION_CONFIGS = 24;
  private static final int METHODID_LIST_RESOURCE_VALUE_CONFIGS = 25;
  private static final int METHODID_LIST_SOURCES = 26;
  private static final int METHODID_LIST_VALUED_RESOURCES = 27;
  private static final int METHODID_SET_FINDING_STATE = 28;
  private static final int METHODID_SET_IAM_POLICY = 29;
  private static final int METHODID_SET_MUTE = 30;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 31;
  private static final int METHODID_UPDATE_BIG_QUERY_EXPORT = 32;
  private static final int METHODID_UPDATE_EXTERNAL_SYSTEM = 33;
  private static final int METHODID_UPDATE_FINDING = 34;
  private static final int METHODID_UPDATE_MUTE_CONFIG = 35;
  private static final int METHODID_UPDATE_NOTIFICATION_CONFIG = 36;
  private static final int METHODID_UPDATE_RESOURCE_VALUE_CONFIG = 37;
  private static final int METHODID_UPDATE_SECURITY_MARKS = 38;
  private static final int METHODID_UPDATE_SOURCE = 39;

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
        case METHODID_BATCH_CREATE_RESOURCE_VALUE_CONFIGS:
          serviceImpl.batchCreateResourceValueConfigs(
              (com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_BULK_MUTE_FINDINGS:
          serviceImpl.bulkMuteFindings(
              (com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BIG_QUERY_EXPORT:
          serviceImpl.createBigQueryExport(
              (com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.BigQueryExport>)
                  responseObserver);
          break;
        case METHODID_CREATE_FINDING:
          serviceImpl.createFinding(
              (com.google.cloud.securitycenter.v2.CreateFindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Finding>)
                  responseObserver);
          break;
        case METHODID_CREATE_MUTE_CONFIG:
          serviceImpl.createMuteConfig(
              (com.google.cloud.securitycenter.v2.CreateMuteConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.MuteConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_NOTIFICATION_CONFIG:
          serviceImpl.createNotificationConfig(
              (com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.NotificationConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_SOURCE:
          serviceImpl.createSource(
              (com.google.cloud.securitycenter.v2.CreateSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Source>)
                  responseObserver);
          break;
        case METHODID_DELETE_BIG_QUERY_EXPORT:
          serviceImpl.deleteBigQueryExport(
              (com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_MUTE_CONFIG:
          serviceImpl.deleteMuteConfig(
              (com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_NOTIFICATION_CONFIG:
          serviceImpl.deleteNotificationConfig(
              (com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_RESOURCE_VALUE_CONFIG:
          serviceImpl.deleteResourceValueConfig(
              (com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_BIG_QUERY_EXPORT:
          serviceImpl.getBigQueryExport(
              (com.google.cloud.securitycenter.v2.GetBigQueryExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.BigQueryExport>)
                  responseObserver);
          break;
        case METHODID_GET_SIMULATION:
          serviceImpl.getSimulation(
              (com.google.cloud.securitycenter.v2.GetSimulationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Simulation>)
                  responseObserver);
          break;
        case METHODID_GET_VALUED_RESOURCE:
          serviceImpl.getValuedResource(
              (com.google.cloud.securitycenter.v2.GetValuedResourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ValuedResource>)
                  responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_MUTE_CONFIG:
          serviceImpl.getMuteConfig(
              (com.google.cloud.securitycenter.v2.GetMuteConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.MuteConfig>)
                  responseObserver);
          break;
        case METHODID_GET_NOTIFICATION_CONFIG:
          serviceImpl.getNotificationConfig(
              (com.google.cloud.securitycenter.v2.GetNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.NotificationConfig>)
                  responseObserver);
          break;
        case METHODID_GET_RESOURCE_VALUE_CONFIG:
          serviceImpl.getResourceValueConfig(
              (com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ResourceValueConfig>)
                  responseObserver);
          break;
        case METHODID_GET_SOURCE:
          serviceImpl.getSource(
              (com.google.cloud.securitycenter.v2.GetSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Source>)
                  responseObserver);
          break;
        case METHODID_GROUP_FINDINGS:
          serviceImpl.groupFindings(
              (com.google.cloud.securitycenter.v2.GroupFindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v2.GroupFindingsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ATTACK_PATHS:
          serviceImpl.listAttackPaths(
              (com.google.cloud.securitycenter.v2.ListAttackPathsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v2.ListAttackPathsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_BIG_QUERY_EXPORTS:
          serviceImpl.listBigQueryExports(
              (com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_FINDINGS:
          serviceImpl.listFindings(
              (com.google.cloud.securitycenter.v2.ListFindingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListFindingsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_MUTE_CONFIGS:
          serviceImpl.listMuteConfigs(
              (com.google.cloud.securitycenter.v2.ListMuteConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v2.ListMuteConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_NOTIFICATION_CONFIGS:
          serviceImpl.listNotificationConfigs(
              (com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_RESOURCE_VALUE_CONFIGS:
          serviceImpl.listResourceValueConfigs(
              (com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SOURCES:
          serviceImpl.listSources(
              (com.google.cloud.securitycenter.v2.ListSourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ListSourcesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_VALUED_RESOURCES:
          serviceImpl.listValuedResources(
              (com.google.cloud.securitycenter.v2.ListValuedResourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v2.ListValuedResourcesResponse>)
                  responseObserver);
          break;
        case METHODID_SET_FINDING_STATE:
          serviceImpl.setFindingState(
              (com.google.cloud.securitycenter.v2.SetFindingStateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Finding>)
                  responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_MUTE:
          serviceImpl.setMute(
              (com.google.cloud.securitycenter.v2.SetMuteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Finding>)
                  responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BIG_QUERY_EXPORT:
          serviceImpl.updateBigQueryExport(
              (com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.BigQueryExport>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EXTERNAL_SYSTEM:
          serviceImpl.updateExternalSystem(
              (com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ExternalSystem>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FINDING:
          serviceImpl.updateFinding(
              (com.google.cloud.securitycenter.v2.UpdateFindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Finding>)
                  responseObserver);
          break;
        case METHODID_UPDATE_MUTE_CONFIG:
          serviceImpl.updateMuteConfig(
              (com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.MuteConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_NOTIFICATION_CONFIG:
          serviceImpl.updateNotificationConfig(
              (com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.NotificationConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_RESOURCE_VALUE_CONFIG:
          serviceImpl.updateResourceValueConfig(
              (com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.ResourceValueConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SECURITY_MARKS:
          serviceImpl.updateSecurityMarks(
              (com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.SecurityMarks>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SOURCE:
          serviceImpl.updateSource(
              (com.google.cloud.securitycenter.v2.UpdateSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v2.Source>)
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
            getBatchCreateResourceValueConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest,
                    com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse>(
                    service, METHODID_BATCH_CREATE_RESOURCE_VALUE_CONFIGS)))
        .addMethod(
            getBulkMuteFindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest,
                    com.google.longrunning.Operation>(service, METHODID_BULK_MUTE_FINDINGS)))
        .addMethod(
            getCreateBigQueryExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest,
                    com.google.cloud.securitycenter.v2.BigQueryExport>(
                    service, METHODID_CREATE_BIG_QUERY_EXPORT)))
        .addMethod(
            getCreateFindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.CreateFindingRequest,
                    com.google.cloud.securitycenter.v2.Finding>(service, METHODID_CREATE_FINDING)))
        .addMethod(
            getCreateMuteConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.CreateMuteConfigRequest,
                    com.google.cloud.securitycenter.v2.MuteConfig>(
                    service, METHODID_CREATE_MUTE_CONFIG)))
        .addMethod(
            getCreateNotificationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest,
                    com.google.cloud.securitycenter.v2.NotificationConfig>(
                    service, METHODID_CREATE_NOTIFICATION_CONFIG)))
        .addMethod(
            getCreateSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.CreateSourceRequest,
                    com.google.cloud.securitycenter.v2.Source>(service, METHODID_CREATE_SOURCE)))
        .addMethod(
            getDeleteBigQueryExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_BIG_QUERY_EXPORT)))
        .addMethod(
            getDeleteMuteConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_MUTE_CONFIG)))
        .addMethod(
            getDeleteNotificationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_NOTIFICATION_CONFIG)))
        .addMethod(
            getDeleteResourceValueConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_RESOURCE_VALUE_CONFIG)))
        .addMethod(
            getGetBigQueryExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.GetBigQueryExportRequest,
                    com.google.cloud.securitycenter.v2.BigQueryExport>(
                    service, METHODID_GET_BIG_QUERY_EXPORT)))
        .addMethod(
            getGetSimulationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.GetSimulationRequest,
                    com.google.cloud.securitycenter.v2.Simulation>(
                    service, METHODID_GET_SIMULATION)))
        .addMethod(
            getGetValuedResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.GetValuedResourceRequest,
                    com.google.cloud.securitycenter.v2.ValuedResource>(
                    service, METHODID_GET_VALUED_RESOURCE)))
        .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_GET_IAM_POLICY)))
        .addMethod(
            getGetMuteConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.GetMuteConfigRequest,
                    com.google.cloud.securitycenter.v2.MuteConfig>(
                    service, METHODID_GET_MUTE_CONFIG)))
        .addMethod(
            getGetNotificationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.GetNotificationConfigRequest,
                    com.google.cloud.securitycenter.v2.NotificationConfig>(
                    service, METHODID_GET_NOTIFICATION_CONFIG)))
        .addMethod(
            getGetResourceValueConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest,
                    com.google.cloud.securitycenter.v2.ResourceValueConfig>(
                    service, METHODID_GET_RESOURCE_VALUE_CONFIG)))
        .addMethod(
            getGetSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.GetSourceRequest,
                    com.google.cloud.securitycenter.v2.Source>(service, METHODID_GET_SOURCE)))
        .addMethod(
            getGroupFindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.GroupFindingsRequest,
                    com.google.cloud.securitycenter.v2.GroupFindingsResponse>(
                    service, METHODID_GROUP_FINDINGS)))
        .addMethod(
            getListAttackPathsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.ListAttackPathsRequest,
                    com.google.cloud.securitycenter.v2.ListAttackPathsResponse>(
                    service, METHODID_LIST_ATTACK_PATHS)))
        .addMethod(
            getListBigQueryExportsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest,
                    com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse>(
                    service, METHODID_LIST_BIG_QUERY_EXPORTS)))
        .addMethod(
            getListFindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.ListFindingsRequest,
                    com.google.cloud.securitycenter.v2.ListFindingsResponse>(
                    service, METHODID_LIST_FINDINGS)))
        .addMethod(
            getListMuteConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.ListMuteConfigsRequest,
                    com.google.cloud.securitycenter.v2.ListMuteConfigsResponse>(
                    service, METHODID_LIST_MUTE_CONFIGS)))
        .addMethod(
            getListNotificationConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest,
                    com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse>(
                    service, METHODID_LIST_NOTIFICATION_CONFIGS)))
        .addMethod(
            getListResourceValueConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest,
                    com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse>(
                    service, METHODID_LIST_RESOURCE_VALUE_CONFIGS)))
        .addMethod(
            getListSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.ListSourcesRequest,
                    com.google.cloud.securitycenter.v2.ListSourcesResponse>(
                    service, METHODID_LIST_SOURCES)))
        .addMethod(
            getListValuedResourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.ListValuedResourcesRequest,
                    com.google.cloud.securitycenter.v2.ListValuedResourcesResponse>(
                    service, METHODID_LIST_VALUED_RESOURCES)))
        .addMethod(
            getSetFindingStateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.SetFindingStateRequest,
                    com.google.cloud.securitycenter.v2.Finding>(
                    service, METHODID_SET_FINDING_STATE)))
        .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY)))
        .addMethod(
            getSetMuteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.SetMuteRequest,
                    com.google.cloud.securitycenter.v2.Finding>(service, METHODID_SET_MUTE)))
        .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v1.TestIamPermissionsRequest,
                    com.google.iam.v1.TestIamPermissionsResponse>(
                    service, METHODID_TEST_IAM_PERMISSIONS)))
        .addMethod(
            getUpdateBigQueryExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest,
                    com.google.cloud.securitycenter.v2.BigQueryExport>(
                    service, METHODID_UPDATE_BIG_QUERY_EXPORT)))
        .addMethod(
            getUpdateExternalSystemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest,
                    com.google.cloud.securitycenter.v2.ExternalSystem>(
                    service, METHODID_UPDATE_EXTERNAL_SYSTEM)))
        .addMethod(
            getUpdateFindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.UpdateFindingRequest,
                    com.google.cloud.securitycenter.v2.Finding>(service, METHODID_UPDATE_FINDING)))
        .addMethod(
            getUpdateMuteConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest,
                    com.google.cloud.securitycenter.v2.MuteConfig>(
                    service, METHODID_UPDATE_MUTE_CONFIG)))
        .addMethod(
            getUpdateNotificationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest,
                    com.google.cloud.securitycenter.v2.NotificationConfig>(
                    service, METHODID_UPDATE_NOTIFICATION_CONFIG)))
        .addMethod(
            getUpdateResourceValueConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest,
                    com.google.cloud.securitycenter.v2.ResourceValueConfig>(
                    service, METHODID_UPDATE_RESOURCE_VALUE_CONFIG)))
        .addMethod(
            getUpdateSecurityMarksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest,
                    com.google.cloud.securitycenter.v2.SecurityMarks>(
                    service, METHODID_UPDATE_SECURITY_MARKS)))
        .addMethod(
            getUpdateSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securitycenter.v2.UpdateSourceRequest,
                    com.google.cloud.securitycenter.v2.Source>(service, METHODID_UPDATE_SOURCE)))
        .build();
  }

  private abstract static class SecurityCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecurityCenterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.securitycenter.v2.SecuritycenterServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecurityCenter");
    }
  }

  private static final class SecurityCenterFileDescriptorSupplier
      extends SecurityCenterBaseDescriptorSupplier {
    SecurityCenterFileDescriptorSupplier() {}
  }

  private static final class SecurityCenterMethodDescriptorSupplier
      extends SecurityCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SecurityCenterMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SecurityCenterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SecurityCenterFileDescriptorSupplier())
                      .addMethod(getBatchCreateResourceValueConfigsMethod())
                      .addMethod(getBulkMuteFindingsMethod())
                      .addMethod(getCreateBigQueryExportMethod())
                      .addMethod(getCreateFindingMethod())
                      .addMethod(getCreateMuteConfigMethod())
                      .addMethod(getCreateNotificationConfigMethod())
                      .addMethod(getCreateSourceMethod())
                      .addMethod(getDeleteBigQueryExportMethod())
                      .addMethod(getDeleteMuteConfigMethod())
                      .addMethod(getDeleteNotificationConfigMethod())
                      .addMethod(getDeleteResourceValueConfigMethod())
                      .addMethod(getGetBigQueryExportMethod())
                      .addMethod(getGetSimulationMethod())
                      .addMethod(getGetValuedResourceMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getGetMuteConfigMethod())
                      .addMethod(getGetNotificationConfigMethod())
                      .addMethod(getGetResourceValueConfigMethod())
                      .addMethod(getGetSourceMethod())
                      .addMethod(getGroupFindingsMethod())
                      .addMethod(getListAttackPathsMethod())
                      .addMethod(getListBigQueryExportsMethod())
                      .addMethod(getListFindingsMethod())
                      .addMethod(getListMuteConfigsMethod())
                      .addMethod(getListNotificationConfigsMethod())
                      .addMethod(getListResourceValueConfigsMethod())
                      .addMethod(getListSourcesMethod())
                      .addMethod(getListValuedResourcesMethod())
                      .addMethod(getSetFindingStateMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getSetMuteMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .addMethod(getUpdateBigQueryExportMethod())
                      .addMethod(getUpdateExternalSystemMethod())
                      .addMethod(getUpdateFindingMethod())
                      .addMethod(getUpdateMuteConfigMethod())
                      .addMethod(getUpdateNotificationConfigMethod())
                      .addMethod(getUpdateResourceValueConfigMethod())
                      .addMethod(getUpdateSecurityMarksMethod())
                      .addMethod(getUpdateSourceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
