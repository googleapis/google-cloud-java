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
package com.google.cloud.gkebackup.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * BackupForGKE allows Kubernetes administrators to configure, execute, and
 * manage backup and restore operations for their GKE clusters.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gkebackup/v1/gkebackup.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BackupForGKEGrpc {

  private BackupForGKEGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gkebackup.v1.BackupForGKE";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.CreateBackupPlanRequest, com.google.longrunning.Operation>
      getCreateBackupPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackupPlan",
      requestType = com.google.cloud.gkebackup.v1.CreateBackupPlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.CreateBackupPlanRequest, com.google.longrunning.Operation>
      getCreateBackupPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.CreateBackupPlanRequest, com.google.longrunning.Operation>
        getCreateBackupPlanMethod;
    if ((getCreateBackupPlanMethod = BackupForGKEGrpc.getCreateBackupPlanMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getCreateBackupPlanMethod = BackupForGKEGrpc.getCreateBackupPlanMethod) == null) {
          BackupForGKEGrpc.getCreateBackupPlanMethod =
              getCreateBackupPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.CreateBackupPlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackupPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.CreateBackupPlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("CreateBackupPlan"))
                      .build();
        }
      }
    }
    return getCreateBackupPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.ListBackupPlansRequest,
          com.google.cloud.gkebackup.v1.ListBackupPlansResponse>
      getListBackupPlansMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupPlans",
      requestType = com.google.cloud.gkebackup.v1.ListBackupPlansRequest.class,
      responseType = com.google.cloud.gkebackup.v1.ListBackupPlansResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.ListBackupPlansRequest,
          com.google.cloud.gkebackup.v1.ListBackupPlansResponse>
      getListBackupPlansMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.ListBackupPlansRequest,
            com.google.cloud.gkebackup.v1.ListBackupPlansResponse>
        getListBackupPlansMethod;
    if ((getListBackupPlansMethod = BackupForGKEGrpc.getListBackupPlansMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getListBackupPlansMethod = BackupForGKEGrpc.getListBackupPlansMethod) == null) {
          BackupForGKEGrpc.getListBackupPlansMethod =
              getListBackupPlansMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.ListBackupPlansRequest,
                          com.google.cloud.gkebackup.v1.ListBackupPlansResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackupPlans"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.ListBackupPlansRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.ListBackupPlansResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("ListBackupPlans"))
                      .build();
        }
      }
    }
    return getListBackupPlansMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.GetBackupPlanRequest,
          com.google.cloud.gkebackup.v1.BackupPlan>
      getGetBackupPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupPlan",
      requestType = com.google.cloud.gkebackup.v1.GetBackupPlanRequest.class,
      responseType = com.google.cloud.gkebackup.v1.BackupPlan.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.GetBackupPlanRequest,
          com.google.cloud.gkebackup.v1.BackupPlan>
      getGetBackupPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.GetBackupPlanRequest,
            com.google.cloud.gkebackup.v1.BackupPlan>
        getGetBackupPlanMethod;
    if ((getGetBackupPlanMethod = BackupForGKEGrpc.getGetBackupPlanMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getGetBackupPlanMethod = BackupForGKEGrpc.getGetBackupPlanMethod) == null) {
          BackupForGKEGrpc.getGetBackupPlanMethod =
              getGetBackupPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.GetBackupPlanRequest,
                          com.google.cloud.gkebackup.v1.BackupPlan>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackupPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.GetBackupPlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.BackupPlan.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("GetBackupPlan"))
                      .build();
        }
      }
    }
    return getGetBackupPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest, com.google.longrunning.Operation>
      getUpdateBackupPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackupPlan",
      requestType = com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest, com.google.longrunning.Operation>
      getUpdateBackupPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest, com.google.longrunning.Operation>
        getUpdateBackupPlanMethod;
    if ((getUpdateBackupPlanMethod = BackupForGKEGrpc.getUpdateBackupPlanMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getUpdateBackupPlanMethod = BackupForGKEGrpc.getUpdateBackupPlanMethod) == null) {
          BackupForGKEGrpc.getUpdateBackupPlanMethod =
              getUpdateBackupPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackupPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("UpdateBackupPlan"))
                      .build();
        }
      }
    }
    return getUpdateBackupPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest, com.google.longrunning.Operation>
      getDeleteBackupPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackupPlan",
      requestType = com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest, com.google.longrunning.Operation>
      getDeleteBackupPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest, com.google.longrunning.Operation>
        getDeleteBackupPlanMethod;
    if ((getDeleteBackupPlanMethod = BackupForGKEGrpc.getDeleteBackupPlanMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getDeleteBackupPlanMethod = BackupForGKEGrpc.getDeleteBackupPlanMethod) == null) {
          BackupForGKEGrpc.getDeleteBackupPlanMethod =
              getDeleteBackupPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackupPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("DeleteBackupPlan"))
                      .build();
        }
      }
    }
    return getDeleteBackupPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.CreateBackupRequest, com.google.longrunning.Operation>
      getCreateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackup",
      requestType = com.google.cloud.gkebackup.v1.CreateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.CreateBackupRequest, com.google.longrunning.Operation>
      getCreateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.CreateBackupRequest, com.google.longrunning.Operation>
        getCreateBackupMethod;
    if ((getCreateBackupMethod = BackupForGKEGrpc.getCreateBackupMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getCreateBackupMethod = BackupForGKEGrpc.getCreateBackupMethod) == null) {
          BackupForGKEGrpc.getCreateBackupMethod =
              getCreateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.CreateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.CreateBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupForGKEMethodDescriptorSupplier("CreateBackup"))
                      .build();
        }
      }
    }
    return getCreateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.ListBackupsRequest,
          com.google.cloud.gkebackup.v1.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackups",
      requestType = com.google.cloud.gkebackup.v1.ListBackupsRequest.class,
      responseType = com.google.cloud.gkebackup.v1.ListBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.ListBackupsRequest,
          com.google.cloud.gkebackup.v1.ListBackupsResponse>
      getListBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.ListBackupsRequest,
            com.google.cloud.gkebackup.v1.ListBackupsResponse>
        getListBackupsMethod;
    if ((getListBackupsMethod = BackupForGKEGrpc.getListBackupsMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getListBackupsMethod = BackupForGKEGrpc.getListBackupsMethod) == null) {
          BackupForGKEGrpc.getListBackupsMethod =
              getListBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.ListBackupsRequest,
                          com.google.cloud.gkebackup.v1.ListBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.ListBackupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.ListBackupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BackupForGKEMethodDescriptorSupplier("ListBackups"))
                      .build();
        }
      }
    }
    return getListBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.GetBackupRequest, com.google.cloud.gkebackup.v1.Backup>
      getGetBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackup",
      requestType = com.google.cloud.gkebackup.v1.GetBackupRequest.class,
      responseType = com.google.cloud.gkebackup.v1.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.GetBackupRequest, com.google.cloud.gkebackup.v1.Backup>
      getGetBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.GetBackupRequest, com.google.cloud.gkebackup.v1.Backup>
        getGetBackupMethod;
    if ((getGetBackupMethod = BackupForGKEGrpc.getGetBackupMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getGetBackupMethod = BackupForGKEGrpc.getGetBackupMethod) == null) {
          BackupForGKEGrpc.getGetBackupMethod =
              getGetBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.GetBackupRequest,
                          com.google.cloud.gkebackup.v1.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.GetBackupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupForGKEMethodDescriptorSupplier("GetBackup"))
                      .build();
        }
      }
    }
    return getGetBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackup",
      requestType = com.google.cloud.gkebackup.v1.UpdateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.UpdateBackupRequest, com.google.longrunning.Operation>
        getUpdateBackupMethod;
    if ((getUpdateBackupMethod = BackupForGKEGrpc.getUpdateBackupMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getUpdateBackupMethod = BackupForGKEGrpc.getUpdateBackupMethod) == null) {
          BackupForGKEGrpc.getUpdateBackupMethod =
              getUpdateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.UpdateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.UpdateBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupForGKEMethodDescriptorSupplier("UpdateBackup"))
                      .build();
        }
      }
    }
    return getUpdateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackup",
      requestType = com.google.cloud.gkebackup.v1.DeleteBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.DeleteBackupRequest, com.google.longrunning.Operation>
        getDeleteBackupMethod;
    if ((getDeleteBackupMethod = BackupForGKEGrpc.getDeleteBackupMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getDeleteBackupMethod = BackupForGKEGrpc.getDeleteBackupMethod) == null) {
          BackupForGKEGrpc.getDeleteBackupMethod =
              getDeleteBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.DeleteBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.DeleteBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupForGKEMethodDescriptorSupplier("DeleteBackup"))
                      .build();
        }
      }
    }
    return getDeleteBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest,
          com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse>
      getListVolumeBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVolumeBackups",
      requestType = com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest.class,
      responseType = com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest,
          com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse>
      getListVolumeBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest,
            com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse>
        getListVolumeBackupsMethod;
    if ((getListVolumeBackupsMethod = BackupForGKEGrpc.getListVolumeBackupsMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getListVolumeBackupsMethod = BackupForGKEGrpc.getListVolumeBackupsMethod) == null) {
          BackupForGKEGrpc.getListVolumeBackupsMethod =
              getListVolumeBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest,
                          com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVolumeBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("ListVolumeBackups"))
                      .build();
        }
      }
    }
    return getListVolumeBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.GetVolumeBackupRequest,
          com.google.cloud.gkebackup.v1.VolumeBackup>
      getGetVolumeBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVolumeBackup",
      requestType = com.google.cloud.gkebackup.v1.GetVolumeBackupRequest.class,
      responseType = com.google.cloud.gkebackup.v1.VolumeBackup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.GetVolumeBackupRequest,
          com.google.cloud.gkebackup.v1.VolumeBackup>
      getGetVolumeBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.GetVolumeBackupRequest,
            com.google.cloud.gkebackup.v1.VolumeBackup>
        getGetVolumeBackupMethod;
    if ((getGetVolumeBackupMethod = BackupForGKEGrpc.getGetVolumeBackupMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getGetVolumeBackupMethod = BackupForGKEGrpc.getGetVolumeBackupMethod) == null) {
          BackupForGKEGrpc.getGetVolumeBackupMethod =
              getGetVolumeBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.GetVolumeBackupRequest,
                          com.google.cloud.gkebackup.v1.VolumeBackup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVolumeBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.GetVolumeBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.VolumeBackup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("GetVolumeBackup"))
                      .build();
        }
      }
    }
    return getGetVolumeBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.CreateRestorePlanRequest, com.google.longrunning.Operation>
      getCreateRestorePlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRestorePlan",
      requestType = com.google.cloud.gkebackup.v1.CreateRestorePlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.CreateRestorePlanRequest, com.google.longrunning.Operation>
      getCreateRestorePlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.CreateRestorePlanRequest,
            com.google.longrunning.Operation>
        getCreateRestorePlanMethod;
    if ((getCreateRestorePlanMethod = BackupForGKEGrpc.getCreateRestorePlanMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getCreateRestorePlanMethod = BackupForGKEGrpc.getCreateRestorePlanMethod) == null) {
          BackupForGKEGrpc.getCreateRestorePlanMethod =
              getCreateRestorePlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.CreateRestorePlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRestorePlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.CreateRestorePlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("CreateRestorePlan"))
                      .build();
        }
      }
    }
    return getCreateRestorePlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.ListRestorePlansRequest,
          com.google.cloud.gkebackup.v1.ListRestorePlansResponse>
      getListRestorePlansMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRestorePlans",
      requestType = com.google.cloud.gkebackup.v1.ListRestorePlansRequest.class,
      responseType = com.google.cloud.gkebackup.v1.ListRestorePlansResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.ListRestorePlansRequest,
          com.google.cloud.gkebackup.v1.ListRestorePlansResponse>
      getListRestorePlansMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.ListRestorePlansRequest,
            com.google.cloud.gkebackup.v1.ListRestorePlansResponse>
        getListRestorePlansMethod;
    if ((getListRestorePlansMethod = BackupForGKEGrpc.getListRestorePlansMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getListRestorePlansMethod = BackupForGKEGrpc.getListRestorePlansMethod) == null) {
          BackupForGKEGrpc.getListRestorePlansMethod =
              getListRestorePlansMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.ListRestorePlansRequest,
                          com.google.cloud.gkebackup.v1.ListRestorePlansResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRestorePlans"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.ListRestorePlansRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.ListRestorePlansResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("ListRestorePlans"))
                      .build();
        }
      }
    }
    return getListRestorePlansMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.GetRestorePlanRequest,
          com.google.cloud.gkebackup.v1.RestorePlan>
      getGetRestorePlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRestorePlan",
      requestType = com.google.cloud.gkebackup.v1.GetRestorePlanRequest.class,
      responseType = com.google.cloud.gkebackup.v1.RestorePlan.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.GetRestorePlanRequest,
          com.google.cloud.gkebackup.v1.RestorePlan>
      getGetRestorePlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.GetRestorePlanRequest,
            com.google.cloud.gkebackup.v1.RestorePlan>
        getGetRestorePlanMethod;
    if ((getGetRestorePlanMethod = BackupForGKEGrpc.getGetRestorePlanMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getGetRestorePlanMethod = BackupForGKEGrpc.getGetRestorePlanMethod) == null) {
          BackupForGKEGrpc.getGetRestorePlanMethod =
              getGetRestorePlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.GetRestorePlanRequest,
                          com.google.cloud.gkebackup.v1.RestorePlan>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRestorePlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.GetRestorePlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.RestorePlan.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("GetRestorePlan"))
                      .build();
        }
      }
    }
    return getGetRestorePlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest, com.google.longrunning.Operation>
      getUpdateRestorePlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRestorePlan",
      requestType = com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest, com.google.longrunning.Operation>
      getUpdateRestorePlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest,
            com.google.longrunning.Operation>
        getUpdateRestorePlanMethod;
    if ((getUpdateRestorePlanMethod = BackupForGKEGrpc.getUpdateRestorePlanMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getUpdateRestorePlanMethod = BackupForGKEGrpc.getUpdateRestorePlanMethod) == null) {
          BackupForGKEGrpc.getUpdateRestorePlanMethod =
              getUpdateRestorePlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRestorePlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("UpdateRestorePlan"))
                      .build();
        }
      }
    }
    return getUpdateRestorePlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest, com.google.longrunning.Operation>
      getDeleteRestorePlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRestorePlan",
      requestType = com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest, com.google.longrunning.Operation>
      getDeleteRestorePlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest,
            com.google.longrunning.Operation>
        getDeleteRestorePlanMethod;
    if ((getDeleteRestorePlanMethod = BackupForGKEGrpc.getDeleteRestorePlanMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getDeleteRestorePlanMethod = BackupForGKEGrpc.getDeleteRestorePlanMethod) == null) {
          BackupForGKEGrpc.getDeleteRestorePlanMethod =
              getDeleteRestorePlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRestorePlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("DeleteRestorePlan"))
                      .build();
        }
      }
    }
    return getDeleteRestorePlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.CreateRestoreRequest, com.google.longrunning.Operation>
      getCreateRestoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRestore",
      requestType = com.google.cloud.gkebackup.v1.CreateRestoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.CreateRestoreRequest, com.google.longrunning.Operation>
      getCreateRestoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.CreateRestoreRequest, com.google.longrunning.Operation>
        getCreateRestoreMethod;
    if ((getCreateRestoreMethod = BackupForGKEGrpc.getCreateRestoreMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getCreateRestoreMethod = BackupForGKEGrpc.getCreateRestoreMethod) == null) {
          BackupForGKEGrpc.getCreateRestoreMethod =
              getCreateRestoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.CreateRestoreRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRestore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.CreateRestoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("CreateRestore"))
                      .build();
        }
      }
    }
    return getCreateRestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.ListRestoresRequest,
          com.google.cloud.gkebackup.v1.ListRestoresResponse>
      getListRestoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRestores",
      requestType = com.google.cloud.gkebackup.v1.ListRestoresRequest.class,
      responseType = com.google.cloud.gkebackup.v1.ListRestoresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.ListRestoresRequest,
          com.google.cloud.gkebackup.v1.ListRestoresResponse>
      getListRestoresMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.ListRestoresRequest,
            com.google.cloud.gkebackup.v1.ListRestoresResponse>
        getListRestoresMethod;
    if ((getListRestoresMethod = BackupForGKEGrpc.getListRestoresMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getListRestoresMethod = BackupForGKEGrpc.getListRestoresMethod) == null) {
          BackupForGKEGrpc.getListRestoresMethod =
              getListRestoresMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.ListRestoresRequest,
                          com.google.cloud.gkebackup.v1.ListRestoresResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRestores"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.ListRestoresRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.ListRestoresResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BackupForGKEMethodDescriptorSupplier("ListRestores"))
                      .build();
        }
      }
    }
    return getListRestoresMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.GetRestoreRequest, com.google.cloud.gkebackup.v1.Restore>
      getGetRestoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRestore",
      requestType = com.google.cloud.gkebackup.v1.GetRestoreRequest.class,
      responseType = com.google.cloud.gkebackup.v1.Restore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.GetRestoreRequest, com.google.cloud.gkebackup.v1.Restore>
      getGetRestoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.GetRestoreRequest, com.google.cloud.gkebackup.v1.Restore>
        getGetRestoreMethod;
    if ((getGetRestoreMethod = BackupForGKEGrpc.getGetRestoreMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getGetRestoreMethod = BackupForGKEGrpc.getGetRestoreMethod) == null) {
          BackupForGKEGrpc.getGetRestoreMethod =
              getGetRestoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.GetRestoreRequest,
                          com.google.cloud.gkebackup.v1.Restore>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRestore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.GetRestoreRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.Restore.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupForGKEMethodDescriptorSupplier("GetRestore"))
                      .build();
        }
      }
    }
    return getGetRestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.UpdateRestoreRequest, com.google.longrunning.Operation>
      getUpdateRestoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRestore",
      requestType = com.google.cloud.gkebackup.v1.UpdateRestoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.UpdateRestoreRequest, com.google.longrunning.Operation>
      getUpdateRestoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.UpdateRestoreRequest, com.google.longrunning.Operation>
        getUpdateRestoreMethod;
    if ((getUpdateRestoreMethod = BackupForGKEGrpc.getUpdateRestoreMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getUpdateRestoreMethod = BackupForGKEGrpc.getUpdateRestoreMethod) == null) {
          BackupForGKEGrpc.getUpdateRestoreMethod =
              getUpdateRestoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.UpdateRestoreRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRestore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.UpdateRestoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("UpdateRestore"))
                      .build();
        }
      }
    }
    return getUpdateRestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.DeleteRestoreRequest, com.google.longrunning.Operation>
      getDeleteRestoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRestore",
      requestType = com.google.cloud.gkebackup.v1.DeleteRestoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.DeleteRestoreRequest, com.google.longrunning.Operation>
      getDeleteRestoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.DeleteRestoreRequest, com.google.longrunning.Operation>
        getDeleteRestoreMethod;
    if ((getDeleteRestoreMethod = BackupForGKEGrpc.getDeleteRestoreMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getDeleteRestoreMethod = BackupForGKEGrpc.getDeleteRestoreMethod) == null) {
          BackupForGKEGrpc.getDeleteRestoreMethod =
              getDeleteRestoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.DeleteRestoreRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRestore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.DeleteRestoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("DeleteRestore"))
                      .build();
        }
      }
    }
    return getDeleteRestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest,
          com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse>
      getListVolumeRestoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVolumeRestores",
      requestType = com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest.class,
      responseType = com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest,
          com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse>
      getListVolumeRestoresMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest,
            com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse>
        getListVolumeRestoresMethod;
    if ((getListVolumeRestoresMethod = BackupForGKEGrpc.getListVolumeRestoresMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getListVolumeRestoresMethod = BackupForGKEGrpc.getListVolumeRestoresMethod) == null) {
          BackupForGKEGrpc.getListVolumeRestoresMethod =
              getListVolumeRestoresMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest,
                          com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVolumeRestores"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("ListVolumeRestores"))
                      .build();
        }
      }
    }
    return getListVolumeRestoresMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest,
          com.google.cloud.gkebackup.v1.VolumeRestore>
      getGetVolumeRestoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVolumeRestore",
      requestType = com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest.class,
      responseType = com.google.cloud.gkebackup.v1.VolumeRestore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest,
          com.google.cloud.gkebackup.v1.VolumeRestore>
      getGetVolumeRestoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest,
            com.google.cloud.gkebackup.v1.VolumeRestore>
        getGetVolumeRestoreMethod;
    if ((getGetVolumeRestoreMethod = BackupForGKEGrpc.getGetVolumeRestoreMethod) == null) {
      synchronized (BackupForGKEGrpc.class) {
        if ((getGetVolumeRestoreMethod = BackupForGKEGrpc.getGetVolumeRestoreMethod) == null) {
          BackupForGKEGrpc.getGetVolumeRestoreMethod =
              getGetVolumeRestoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest,
                          com.google.cloud.gkebackup.v1.VolumeRestore>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVolumeRestore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkebackup.v1.VolumeRestore.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupForGKEMethodDescriptorSupplier("GetVolumeRestore"))
                      .build();
        }
      }
    }
    return getGetVolumeRestoreMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BackupForGKEStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupForGKEStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupForGKEStub>() {
          @java.lang.Override
          public BackupForGKEStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupForGKEStub(channel, callOptions);
          }
        };
    return BackupForGKEStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BackupForGKEBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupForGKEBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupForGKEBlockingStub>() {
          @java.lang.Override
          public BackupForGKEBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupForGKEBlockingStub(channel, callOptions);
          }
        };
    return BackupForGKEBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BackupForGKEFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupForGKEFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupForGKEFutureStub>() {
          @java.lang.Override
          public BackupForGKEFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupForGKEFutureStub(channel, callOptions);
          }
        };
    return BackupForGKEFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * BackupForGKE allows Kubernetes administrators to configure, execute, and
   * manage backup and restore operations for their GKE clusters.
   * </pre>
   */
  public abstract static class BackupForGKEImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new BackupPlan in a given location.
     * </pre>
     */
    public void createBackupPlan(
        com.google.cloud.gkebackup.v1.CreateBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupPlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlans in a given location.
     * </pre>
     */
    public void listBackupPlans(
        com.google.cloud.gkebackup.v1.ListBackupPlansRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListBackupPlansResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupPlansMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single BackupPlan.
     * </pre>
     */
    public void getBackupPlan(
        com.google.cloud.gkebackup.v1.GetBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.BackupPlan> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBackupPlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a BackupPlan.
     * </pre>
     */
    public void updateBackupPlan(
        com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupPlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing BackupPlan.
     * </pre>
     */
    public void deleteBackupPlan(
        com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupPlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Backup for the given BackupPlan.
     * </pre>
     */
    public void createBackup(
        com.google.cloud.gkebackup.v1.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Backups for a given BackupPlan.
     * </pre>
     */
    public void listBackups(
        com.google.cloud.gkebackup.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single Backup.
     * </pre>
     */
    public void getBackup(
        com.google.cloud.gkebackup.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.Backup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a Backup.
     * </pre>
     */
    public void updateBackup(
        com.google.cloud.gkebackup.v1.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing Backup.
     * </pre>
     */
    public void deleteBackup(
        com.google.cloud.gkebackup.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the VolumeBackups for a given Backup.
     * </pre>
     */
    public void listVolumeBackups(
        com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVolumeBackupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single VolumeBackup.
     * </pre>
     */
    public void getVolumeBackup(
        com.google.cloud.gkebackup.v1.GetVolumeBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.VolumeBackup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetVolumeBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestorePlan in a given location.
     * </pre>
     */
    public void createRestorePlan(
        com.google.cloud.gkebackup.v1.CreateRestorePlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRestorePlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RestorePlans in a given location.
     * </pre>
     */
    public void listRestorePlans(
        com.google.cloud.gkebackup.v1.ListRestorePlansRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListRestorePlansResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRestorePlansMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single RestorePlan.
     * </pre>
     */
    public void getRestorePlan(
        com.google.cloud.gkebackup.v1.GetRestorePlanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.RestorePlan> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRestorePlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a RestorePlan.
     * </pre>
     */
    public void updateRestorePlan(
        com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRestorePlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing RestorePlan.
     * </pre>
     */
    public void deleteRestorePlan(
        com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRestorePlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Restore for the given RestorePlan.
     * </pre>
     */
    public void createRestore(
        com.google.cloud.gkebackup.v1.CreateRestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRestoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Restores for a given RestorePlan.
     * </pre>
     */
    public void listRestores(
        com.google.cloud.gkebackup.v1.ListRestoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListRestoresResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRestoresMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the details of a single Restore.
     * </pre>
     */
    public void getRestore(
        com.google.cloud.gkebackup.v1.GetRestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.Restore> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRestoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a Restore.
     * </pre>
     */
    public void updateRestore(
        com.google.cloud.gkebackup.v1.UpdateRestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRestoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing Restore.
     * </pre>
     */
    public void deleteRestore(
        com.google.cloud.gkebackup.v1.DeleteRestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRestoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the VolumeRestores for a given Restore.
     * </pre>
     */
    public void listVolumeRestores(
        com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVolumeRestoresMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single VolumeRestore.
     * </pre>
     */
    public void getVolumeRestore(
        com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.VolumeRestore> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetVolumeRestoreMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateBackupPlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.CreateBackupPlanRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_BACKUP_PLAN)))
          .addMethod(
              getListBackupPlansMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.ListBackupPlansRequest,
                      com.google.cloud.gkebackup.v1.ListBackupPlansResponse>(
                      this, METHODID_LIST_BACKUP_PLANS)))
          .addMethod(
              getGetBackupPlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.GetBackupPlanRequest,
                      com.google.cloud.gkebackup.v1.BackupPlan>(this, METHODID_GET_BACKUP_PLAN)))
          .addMethod(
              getUpdateBackupPlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_BACKUP_PLAN)))
          .addMethod(
              getDeleteBackupPlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_BACKUP_PLAN)))
          .addMethod(
              getCreateBackupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.CreateBackupRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_BACKUP)))
          .addMethod(
              getListBackupsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.ListBackupsRequest,
                      com.google.cloud.gkebackup.v1.ListBackupsResponse>(
                      this, METHODID_LIST_BACKUPS)))
          .addMethod(
              getGetBackupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.GetBackupRequest,
                      com.google.cloud.gkebackup.v1.Backup>(this, METHODID_GET_BACKUP)))
          .addMethod(
              getUpdateBackupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.UpdateBackupRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_BACKUP)))
          .addMethod(
              getDeleteBackupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.DeleteBackupRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_BACKUP)))
          .addMethod(
              getListVolumeBackupsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest,
                      com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse>(
                      this, METHODID_LIST_VOLUME_BACKUPS)))
          .addMethod(
              getGetVolumeBackupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.GetVolumeBackupRequest,
                      com.google.cloud.gkebackup.v1.VolumeBackup>(
                      this, METHODID_GET_VOLUME_BACKUP)))
          .addMethod(
              getCreateRestorePlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.CreateRestorePlanRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_RESTORE_PLAN)))
          .addMethod(
              getListRestorePlansMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.ListRestorePlansRequest,
                      com.google.cloud.gkebackup.v1.ListRestorePlansResponse>(
                      this, METHODID_LIST_RESTORE_PLANS)))
          .addMethod(
              getGetRestorePlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.GetRestorePlanRequest,
                      com.google.cloud.gkebackup.v1.RestorePlan>(this, METHODID_GET_RESTORE_PLAN)))
          .addMethod(
              getUpdateRestorePlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_RESTORE_PLAN)))
          .addMethod(
              getDeleteRestorePlanMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_RESTORE_PLAN)))
          .addMethod(
              getCreateRestoreMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.CreateRestoreRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_RESTORE)))
          .addMethod(
              getListRestoresMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.ListRestoresRequest,
                      com.google.cloud.gkebackup.v1.ListRestoresResponse>(
                      this, METHODID_LIST_RESTORES)))
          .addMethod(
              getGetRestoreMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.GetRestoreRequest,
                      com.google.cloud.gkebackup.v1.Restore>(this, METHODID_GET_RESTORE)))
          .addMethod(
              getUpdateRestoreMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.UpdateRestoreRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_RESTORE)))
          .addMethod(
              getDeleteRestoreMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.DeleteRestoreRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_RESTORE)))
          .addMethod(
              getListVolumeRestoresMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest,
                      com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse>(
                      this, METHODID_LIST_VOLUME_RESTORES)))
          .addMethod(
              getGetVolumeRestoreMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest,
                      com.google.cloud.gkebackup.v1.VolumeRestore>(
                      this, METHODID_GET_VOLUME_RESTORE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * BackupForGKE allows Kubernetes administrators to configure, execute, and
   * manage backup and restore operations for their GKE clusters.
   * </pre>
   */
  public static final class BackupForGKEStub
      extends io.grpc.stub.AbstractAsyncStub<BackupForGKEStub> {
    private BackupForGKEStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupForGKEStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupForGKEStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new BackupPlan in a given location.
     * </pre>
     */
    public void createBackupPlan(
        com.google.cloud.gkebackup.v1.CreateBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackupPlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlans in a given location.
     * </pre>
     */
    public void listBackupPlans(
        com.google.cloud.gkebackup.v1.ListBackupPlansRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListBackupPlansResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupPlansMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single BackupPlan.
     * </pre>
     */
    public void getBackupPlan(
        com.google.cloud.gkebackup.v1.GetBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.BackupPlan> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupPlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a BackupPlan.
     * </pre>
     */
    public void updateBackupPlan(
        com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBackupPlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing BackupPlan.
     * </pre>
     */
    public void deleteBackupPlan(
        com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupPlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Backup for the given BackupPlan.
     * </pre>
     */
    public void createBackup(
        com.google.cloud.gkebackup.v1.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Backups for a given BackupPlan.
     * </pre>
     */
    public void listBackups(
        com.google.cloud.gkebackup.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single Backup.
     * </pre>
     */
    public void getBackup(
        com.google.cloud.gkebackup.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.Backup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a Backup.
     * </pre>
     */
    public void updateBackup(
        com.google.cloud.gkebackup.v1.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing Backup.
     * </pre>
     */
    public void deleteBackup(
        com.google.cloud.gkebackup.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the VolumeBackups for a given Backup.
     * </pre>
     */
    public void listVolumeBackups(
        com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVolumeBackupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single VolumeBackup.
     * </pre>
     */
    public void getVolumeBackup(
        com.google.cloud.gkebackup.v1.GetVolumeBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.VolumeBackup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVolumeBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestorePlan in a given location.
     * </pre>
     */
    public void createRestorePlan(
        com.google.cloud.gkebackup.v1.CreateRestorePlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRestorePlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RestorePlans in a given location.
     * </pre>
     */
    public void listRestorePlans(
        com.google.cloud.gkebackup.v1.ListRestorePlansRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListRestorePlansResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRestorePlansMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single RestorePlan.
     * </pre>
     */
    public void getRestorePlan(
        com.google.cloud.gkebackup.v1.GetRestorePlanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.RestorePlan> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRestorePlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a RestorePlan.
     * </pre>
     */
    public void updateRestorePlan(
        com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRestorePlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing RestorePlan.
     * </pre>
     */
    public void deleteRestorePlan(
        com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRestorePlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Restore for the given RestorePlan.
     * </pre>
     */
    public void createRestore(
        com.google.cloud.gkebackup.v1.CreateRestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRestoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Restores for a given RestorePlan.
     * </pre>
     */
    public void listRestores(
        com.google.cloud.gkebackup.v1.ListRestoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListRestoresResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRestoresMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the details of a single Restore.
     * </pre>
     */
    public void getRestore(
        com.google.cloud.gkebackup.v1.GetRestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.Restore> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRestoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a Restore.
     * </pre>
     */
    public void updateRestore(
        com.google.cloud.gkebackup.v1.UpdateRestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRestoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing Restore.
     * </pre>
     */
    public void deleteRestore(
        com.google.cloud.gkebackup.v1.DeleteRestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRestoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the VolumeRestores for a given Restore.
     * </pre>
     */
    public void listVolumeRestores(
        com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVolumeRestoresMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single VolumeRestore.
     * </pre>
     */
    public void getVolumeRestore(
        com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.VolumeRestore> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVolumeRestoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * BackupForGKE allows Kubernetes administrators to configure, execute, and
   * manage backup and restore operations for their GKE clusters.
   * </pre>
   */
  public static final class BackupForGKEBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BackupForGKEBlockingStub> {
    private BackupForGKEBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupForGKEBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupForGKEBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new BackupPlan in a given location.
     * </pre>
     */
    public com.google.longrunning.Operation createBackupPlan(
        com.google.cloud.gkebackup.v1.CreateBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlans in a given location.
     * </pre>
     */
    public com.google.cloud.gkebackup.v1.ListBackupPlansResponse listBackupPlans(
        com.google.cloud.gkebackup.v1.ListBackupPlansRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupPlansMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single BackupPlan.
     * </pre>
     */
    public com.google.cloud.gkebackup.v1.BackupPlan getBackupPlan(
        com.google.cloud.gkebackup.v1.GetBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a BackupPlan.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackupPlan(
        com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing BackupPlan.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackupPlan(
        com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Backup for the given BackupPlan.
     * </pre>
     */
    public com.google.longrunning.Operation createBackup(
        com.google.cloud.gkebackup.v1.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Backups for a given BackupPlan.
     * </pre>
     */
    public com.google.cloud.gkebackup.v1.ListBackupsResponse listBackups(
        com.google.cloud.gkebackup.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single Backup.
     * </pre>
     */
    public com.google.cloud.gkebackup.v1.Backup getBackup(
        com.google.cloud.gkebackup.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a Backup.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackup(
        com.google.cloud.gkebackup.v1.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing Backup.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackup(
        com.google.cloud.gkebackup.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the VolumeBackups for a given Backup.
     * </pre>
     */
    public com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse listVolumeBackups(
        com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVolumeBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single VolumeBackup.
     * </pre>
     */
    public com.google.cloud.gkebackup.v1.VolumeBackup getVolumeBackup(
        com.google.cloud.gkebackup.v1.GetVolumeBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVolumeBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestorePlan in a given location.
     * </pre>
     */
    public com.google.longrunning.Operation createRestorePlan(
        com.google.cloud.gkebackup.v1.CreateRestorePlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRestorePlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestorePlans in a given location.
     * </pre>
     */
    public com.google.cloud.gkebackup.v1.ListRestorePlansResponse listRestorePlans(
        com.google.cloud.gkebackup.v1.ListRestorePlansRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRestorePlansMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single RestorePlan.
     * </pre>
     */
    public com.google.cloud.gkebackup.v1.RestorePlan getRestorePlan(
        com.google.cloud.gkebackup.v1.GetRestorePlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRestorePlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a RestorePlan.
     * </pre>
     */
    public com.google.longrunning.Operation updateRestorePlan(
        com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRestorePlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing RestorePlan.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRestorePlan(
        com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRestorePlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Restore for the given RestorePlan.
     * </pre>
     */
    public com.google.longrunning.Operation createRestore(
        com.google.cloud.gkebackup.v1.CreateRestoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRestoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Restores for a given RestorePlan.
     * </pre>
     */
    public com.google.cloud.gkebackup.v1.ListRestoresResponse listRestores(
        com.google.cloud.gkebackup.v1.ListRestoresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRestoresMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the details of a single Restore.
     * </pre>
     */
    public com.google.cloud.gkebackup.v1.Restore getRestore(
        com.google.cloud.gkebackup.v1.GetRestoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRestoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a Restore.
     * </pre>
     */
    public com.google.longrunning.Operation updateRestore(
        com.google.cloud.gkebackup.v1.UpdateRestoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRestoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing Restore.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRestore(
        com.google.cloud.gkebackup.v1.DeleteRestoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRestoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the VolumeRestores for a given Restore.
     * </pre>
     */
    public com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse listVolumeRestores(
        com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVolumeRestoresMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single VolumeRestore.
     * </pre>
     */
    public com.google.cloud.gkebackup.v1.VolumeRestore getVolumeRestore(
        com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVolumeRestoreMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * BackupForGKE allows Kubernetes administrators to configure, execute, and
   * manage backup and restore operations for their GKE clusters.
   * </pre>
   */
  public static final class BackupForGKEFutureStub
      extends io.grpc.stub.AbstractFutureStub<BackupForGKEFutureStub> {
    private BackupForGKEFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupForGKEFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupForGKEFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new BackupPlan in a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackupPlan(com.google.cloud.gkebackup.v1.CreateBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupPlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlans in a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkebackup.v1.ListBackupPlansResponse>
        listBackupPlans(com.google.cloud.gkebackup.v1.ListBackupPlansRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupPlansMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single BackupPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkebackup.v1.BackupPlan>
        getBackupPlan(com.google.cloud.gkebackup.v1.GetBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupPlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a BackupPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBackupPlan(com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupPlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing BackupPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackupPlan(com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupPlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Backup for the given BackupPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackup(com.google.cloud.gkebackup.v1.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Backups for a given BackupPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkebackup.v1.ListBackupsResponse>
        listBackups(com.google.cloud.gkebackup.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkebackup.v1.Backup>
        getBackup(com.google.cloud.gkebackup.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBackup(com.google.cloud.gkebackup.v1.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackup(com.google.cloud.gkebackup.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the VolumeBackups for a given Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse>
        listVolumeBackups(com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVolumeBackupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single VolumeBackup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkebackup.v1.VolumeBackup>
        getVolumeBackup(com.google.cloud.gkebackup.v1.GetVolumeBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVolumeBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestorePlan in a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRestorePlan(com.google.cloud.gkebackup.v1.CreateRestorePlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRestorePlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestorePlans in a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkebackup.v1.ListRestorePlansResponse>
        listRestorePlans(com.google.cloud.gkebackup.v1.ListRestorePlansRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRestorePlansMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single RestorePlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkebackup.v1.RestorePlan>
        getRestorePlan(com.google.cloud.gkebackup.v1.GetRestorePlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRestorePlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a RestorePlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateRestorePlan(com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRestorePlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing RestorePlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRestorePlan(com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRestorePlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Restore for the given RestorePlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRestore(com.google.cloud.gkebackup.v1.CreateRestoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRestoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Restores for a given RestorePlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkebackup.v1.ListRestoresResponse>
        listRestores(com.google.cloud.gkebackup.v1.ListRestoresRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRestoresMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the details of a single Restore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkebackup.v1.Restore>
        getRestore(com.google.cloud.gkebackup.v1.GetRestoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRestoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a Restore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateRestore(com.google.cloud.gkebackup.v1.UpdateRestoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRestoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing Restore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRestore(com.google.cloud.gkebackup.v1.DeleteRestoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRestoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the VolumeRestores for a given Restore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse>
        listVolumeRestores(com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVolumeRestoresMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the details of a single VolumeRestore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkebackup.v1.VolumeRestore>
        getVolumeRestore(com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVolumeRestoreMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BACKUP_PLAN = 0;
  private static final int METHODID_LIST_BACKUP_PLANS = 1;
  private static final int METHODID_GET_BACKUP_PLAN = 2;
  private static final int METHODID_UPDATE_BACKUP_PLAN = 3;
  private static final int METHODID_DELETE_BACKUP_PLAN = 4;
  private static final int METHODID_CREATE_BACKUP = 5;
  private static final int METHODID_LIST_BACKUPS = 6;
  private static final int METHODID_GET_BACKUP = 7;
  private static final int METHODID_UPDATE_BACKUP = 8;
  private static final int METHODID_DELETE_BACKUP = 9;
  private static final int METHODID_LIST_VOLUME_BACKUPS = 10;
  private static final int METHODID_GET_VOLUME_BACKUP = 11;
  private static final int METHODID_CREATE_RESTORE_PLAN = 12;
  private static final int METHODID_LIST_RESTORE_PLANS = 13;
  private static final int METHODID_GET_RESTORE_PLAN = 14;
  private static final int METHODID_UPDATE_RESTORE_PLAN = 15;
  private static final int METHODID_DELETE_RESTORE_PLAN = 16;
  private static final int METHODID_CREATE_RESTORE = 17;
  private static final int METHODID_LIST_RESTORES = 18;
  private static final int METHODID_GET_RESTORE = 19;
  private static final int METHODID_UPDATE_RESTORE = 20;
  private static final int METHODID_DELETE_RESTORE = 21;
  private static final int METHODID_LIST_VOLUME_RESTORES = 22;
  private static final int METHODID_GET_VOLUME_RESTORE = 23;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BackupForGKEImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BackupForGKEImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_BACKUP_PLAN:
          serviceImpl.createBackupPlan(
              (com.google.cloud.gkebackup.v1.CreateBackupPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BACKUP_PLANS:
          serviceImpl.listBackupPlans(
              (com.google.cloud.gkebackup.v1.ListBackupPlansRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListBackupPlansResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP_PLAN:
          serviceImpl.getBackupPlan(
              (com.google.cloud.gkebackup.v1.GetBackupPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.BackupPlan>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BACKUP_PLAN:
          serviceImpl.updateBackupPlan(
              (com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKUP_PLAN:
          serviceImpl.deleteBackupPlan(
              (com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BACKUP:
          serviceImpl.createBackup(
              (com.google.cloud.gkebackup.v1.CreateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BACKUPS:
          serviceImpl.listBackups(
              (com.google.cloud.gkebackup.v1.ListBackupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP:
          serviceImpl.getBackup(
              (com.google.cloud.gkebackup.v1.GetBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.Backup>) responseObserver);
          break;
        case METHODID_UPDATE_BACKUP:
          serviceImpl.updateBackup(
              (com.google.cloud.gkebackup.v1.UpdateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKUP:
          serviceImpl.deleteBackup(
              (com.google.cloud.gkebackup.v1.DeleteBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_VOLUME_BACKUPS:
          serviceImpl.listVolumeBackups(
              (com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VOLUME_BACKUP:
          serviceImpl.getVolumeBackup(
              (com.google.cloud.gkebackup.v1.GetVolumeBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.VolumeBackup>)
                  responseObserver);
          break;
        case METHODID_CREATE_RESTORE_PLAN:
          serviceImpl.createRestorePlan(
              (com.google.cloud.gkebackup.v1.CreateRestorePlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_RESTORE_PLANS:
          serviceImpl.listRestorePlans(
              (com.google.cloud.gkebackup.v1.ListRestorePlansRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListRestorePlansResponse>)
                  responseObserver);
          break;
        case METHODID_GET_RESTORE_PLAN:
          serviceImpl.getRestorePlan(
              (com.google.cloud.gkebackup.v1.GetRestorePlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.RestorePlan>)
                  responseObserver);
          break;
        case METHODID_UPDATE_RESTORE_PLAN:
          serviceImpl.updateRestorePlan(
              (com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_RESTORE_PLAN:
          serviceImpl.deleteRestorePlan(
              (com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_RESTORE:
          serviceImpl.createRestore(
              (com.google.cloud.gkebackup.v1.CreateRestoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_RESTORES:
          serviceImpl.listRestores(
              (com.google.cloud.gkebackup.v1.ListRestoresRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.ListRestoresResponse>)
                  responseObserver);
          break;
        case METHODID_GET_RESTORE:
          serviceImpl.getRestore(
              (com.google.cloud.gkebackup.v1.GetRestoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.Restore>)
                  responseObserver);
          break;
        case METHODID_UPDATE_RESTORE:
          serviceImpl.updateRestore(
              (com.google.cloud.gkebackup.v1.UpdateRestoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_RESTORE:
          serviceImpl.deleteRestore(
              (com.google.cloud.gkebackup.v1.DeleteRestoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_VOLUME_RESTORES:
          serviceImpl.listVolumeRestores(
              (com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VOLUME_RESTORE:
          serviceImpl.getVolumeRestore(
              (com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkebackup.v1.VolumeRestore>)
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

  private abstract static class BackupForGKEBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BackupForGKEBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gkebackup.v1.GKEBackupProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BackupForGKE");
    }
  }

  private static final class BackupForGKEFileDescriptorSupplier
      extends BackupForGKEBaseDescriptorSupplier {
    BackupForGKEFileDescriptorSupplier() {}
  }

  private static final class BackupForGKEMethodDescriptorSupplier
      extends BackupForGKEBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BackupForGKEMethodDescriptorSupplier(String methodName) {
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
      synchronized (BackupForGKEGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BackupForGKEFileDescriptorSupplier())
                      .addMethod(getCreateBackupPlanMethod())
                      .addMethod(getListBackupPlansMethod())
                      .addMethod(getGetBackupPlanMethod())
                      .addMethod(getUpdateBackupPlanMethod())
                      .addMethod(getDeleteBackupPlanMethod())
                      .addMethod(getCreateBackupMethod())
                      .addMethod(getListBackupsMethod())
                      .addMethod(getGetBackupMethod())
                      .addMethod(getUpdateBackupMethod())
                      .addMethod(getDeleteBackupMethod())
                      .addMethod(getListVolumeBackupsMethod())
                      .addMethod(getGetVolumeBackupMethod())
                      .addMethod(getCreateRestorePlanMethod())
                      .addMethod(getListRestorePlansMethod())
                      .addMethod(getGetRestorePlanMethod())
                      .addMethod(getUpdateRestorePlanMethod())
                      .addMethod(getDeleteRestorePlanMethod())
                      .addMethod(getCreateRestoreMethod())
                      .addMethod(getListRestoresMethod())
                      .addMethod(getGetRestoreMethod())
                      .addMethod(getUpdateRestoreMethod())
                      .addMethod(getDeleteRestoreMethod())
                      .addMethod(getListVolumeRestoresMethod())
                      .addMethod(getGetVolumeRestoreMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
