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
package com.google.cloud.backupdr.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The BackupDR Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/backupdr/v1/backupdr.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BackupDRGrpc {

  private BackupDRGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.backupdr.v1.BackupDR";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListManagementServersRequest,
          com.google.cloud.backupdr.v1.ListManagementServersResponse>
      getListManagementServersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListManagementServers",
      requestType = com.google.cloud.backupdr.v1.ListManagementServersRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListManagementServersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListManagementServersRequest,
          com.google.cloud.backupdr.v1.ListManagementServersResponse>
      getListManagementServersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListManagementServersRequest,
            com.google.cloud.backupdr.v1.ListManagementServersResponse>
        getListManagementServersMethod;
    if ((getListManagementServersMethod = BackupDRGrpc.getListManagementServersMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListManagementServersMethod = BackupDRGrpc.getListManagementServersMethod)
            == null) {
          BackupDRGrpc.getListManagementServersMethod =
              getListManagementServersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListManagementServersRequest,
                          com.google.cloud.backupdr.v1.ListManagementServersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListManagementServers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListManagementServersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListManagementServersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListManagementServers"))
                      .build();
        }
      }
    }
    return getListManagementServersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetManagementServerRequest,
          com.google.cloud.backupdr.v1.ManagementServer>
      getGetManagementServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetManagementServer",
      requestType = com.google.cloud.backupdr.v1.GetManagementServerRequest.class,
      responseType = com.google.cloud.backupdr.v1.ManagementServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetManagementServerRequest,
          com.google.cloud.backupdr.v1.ManagementServer>
      getGetManagementServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetManagementServerRequest,
            com.google.cloud.backupdr.v1.ManagementServer>
        getGetManagementServerMethod;
    if ((getGetManagementServerMethod = BackupDRGrpc.getGetManagementServerMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetManagementServerMethod = BackupDRGrpc.getGetManagementServerMethod) == null) {
          BackupDRGrpc.getGetManagementServerMethod =
              getGetManagementServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetManagementServerRequest,
                          com.google.cloud.backupdr.v1.ManagementServer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetManagementServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetManagementServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ManagementServer.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("GetManagementServer"))
                      .build();
        }
      }
    }
    return getGetManagementServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateManagementServerRequest,
          com.google.longrunning.Operation>
      getCreateManagementServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateManagementServer",
      requestType = com.google.cloud.backupdr.v1.CreateManagementServerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateManagementServerRequest,
          com.google.longrunning.Operation>
      getCreateManagementServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.CreateManagementServerRequest,
            com.google.longrunning.Operation>
        getCreateManagementServerMethod;
    if ((getCreateManagementServerMethod = BackupDRGrpc.getCreateManagementServerMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getCreateManagementServerMethod = BackupDRGrpc.getCreateManagementServerMethod)
            == null) {
          BackupDRGrpc.getCreateManagementServerMethod =
              getCreateManagementServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.CreateManagementServerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateManagementServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.CreateManagementServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("CreateManagementServer"))
                      .build();
        }
      }
    }
    return getCreateManagementServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteManagementServerRequest,
          com.google.longrunning.Operation>
      getDeleteManagementServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteManagementServer",
      requestType = com.google.cloud.backupdr.v1.DeleteManagementServerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteManagementServerRequest,
          com.google.longrunning.Operation>
      getDeleteManagementServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.DeleteManagementServerRequest,
            com.google.longrunning.Operation>
        getDeleteManagementServerMethod;
    if ((getDeleteManagementServerMethod = BackupDRGrpc.getDeleteManagementServerMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteManagementServerMethod = BackupDRGrpc.getDeleteManagementServerMethod)
            == null) {
          BackupDRGrpc.getDeleteManagementServerMethod =
              getDeleteManagementServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.DeleteManagementServerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteManagementServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.DeleteManagementServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("DeleteManagementServer"))
                      .build();
        }
      }
    }
    return getDeleteManagementServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateBackupVaultRequest, com.google.longrunning.Operation>
      getCreateBackupVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackupVault",
      requestType = com.google.cloud.backupdr.v1.CreateBackupVaultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateBackupVaultRequest, com.google.longrunning.Operation>
      getCreateBackupVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.CreateBackupVaultRequest, com.google.longrunning.Operation>
        getCreateBackupVaultMethod;
    if ((getCreateBackupVaultMethod = BackupDRGrpc.getCreateBackupVaultMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getCreateBackupVaultMethod = BackupDRGrpc.getCreateBackupVaultMethod) == null) {
          BackupDRGrpc.getCreateBackupVaultMethod =
              getCreateBackupVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.CreateBackupVaultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackupVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.CreateBackupVaultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("CreateBackupVault"))
                      .build();
        }
      }
    }
    return getCreateBackupVaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListBackupVaultsRequest,
          com.google.cloud.backupdr.v1.ListBackupVaultsResponse>
      getListBackupVaultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupVaults",
      requestType = com.google.cloud.backupdr.v1.ListBackupVaultsRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListBackupVaultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListBackupVaultsRequest,
          com.google.cloud.backupdr.v1.ListBackupVaultsResponse>
      getListBackupVaultsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListBackupVaultsRequest,
            com.google.cloud.backupdr.v1.ListBackupVaultsResponse>
        getListBackupVaultsMethod;
    if ((getListBackupVaultsMethod = BackupDRGrpc.getListBackupVaultsMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListBackupVaultsMethod = BackupDRGrpc.getListBackupVaultsMethod) == null) {
          BackupDRGrpc.getListBackupVaultsMethod =
              getListBackupVaultsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListBackupVaultsRequest,
                          com.google.cloud.backupdr.v1.ListBackupVaultsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackupVaults"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListBackupVaultsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListBackupVaultsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("ListBackupVaults"))
                      .build();
        }
      }
    }
    return getListBackupVaultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest,
          com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse>
      getFetchUsableBackupVaultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchUsableBackupVaults",
      requestType = com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest.class,
      responseType = com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest,
          com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse>
      getFetchUsableBackupVaultsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest,
            com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse>
        getFetchUsableBackupVaultsMethod;
    if ((getFetchUsableBackupVaultsMethod = BackupDRGrpc.getFetchUsableBackupVaultsMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getFetchUsableBackupVaultsMethod = BackupDRGrpc.getFetchUsableBackupVaultsMethod)
            == null) {
          BackupDRGrpc.getFetchUsableBackupVaultsMethod =
              getFetchUsableBackupVaultsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest,
                          com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchUsableBackupVaults"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("FetchUsableBackupVaults"))
                      .build();
        }
      }
    }
    return getFetchUsableBackupVaultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetBackupVaultRequest,
          com.google.cloud.backupdr.v1.BackupVault>
      getGetBackupVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupVault",
      requestType = com.google.cloud.backupdr.v1.GetBackupVaultRequest.class,
      responseType = com.google.cloud.backupdr.v1.BackupVault.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetBackupVaultRequest,
          com.google.cloud.backupdr.v1.BackupVault>
      getGetBackupVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetBackupVaultRequest,
            com.google.cloud.backupdr.v1.BackupVault>
        getGetBackupVaultMethod;
    if ((getGetBackupVaultMethod = BackupDRGrpc.getGetBackupVaultMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetBackupVaultMethod = BackupDRGrpc.getGetBackupVaultMethod) == null) {
          BackupDRGrpc.getGetBackupVaultMethod =
              getGetBackupVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetBackupVaultRequest,
                          com.google.cloud.backupdr.v1.BackupVault>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackupVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetBackupVaultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.BackupVault.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("GetBackupVault"))
                      .build();
        }
      }
    }
    return getGetBackupVaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.UpdateBackupVaultRequest, com.google.longrunning.Operation>
      getUpdateBackupVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackupVault",
      requestType = com.google.cloud.backupdr.v1.UpdateBackupVaultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.UpdateBackupVaultRequest, com.google.longrunning.Operation>
      getUpdateBackupVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.UpdateBackupVaultRequest, com.google.longrunning.Operation>
        getUpdateBackupVaultMethod;
    if ((getUpdateBackupVaultMethod = BackupDRGrpc.getUpdateBackupVaultMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getUpdateBackupVaultMethod = BackupDRGrpc.getUpdateBackupVaultMethod) == null) {
          BackupDRGrpc.getUpdateBackupVaultMethod =
              getUpdateBackupVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.UpdateBackupVaultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackupVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.UpdateBackupVaultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("UpdateBackupVault"))
                      .build();
        }
      }
    }
    return getUpdateBackupVaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteBackupVaultRequest, com.google.longrunning.Operation>
      getDeleteBackupVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackupVault",
      requestType = com.google.cloud.backupdr.v1.DeleteBackupVaultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteBackupVaultRequest, com.google.longrunning.Operation>
      getDeleteBackupVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.DeleteBackupVaultRequest, com.google.longrunning.Operation>
        getDeleteBackupVaultMethod;
    if ((getDeleteBackupVaultMethod = BackupDRGrpc.getDeleteBackupVaultMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteBackupVaultMethod = BackupDRGrpc.getDeleteBackupVaultMethod) == null) {
          BackupDRGrpc.getDeleteBackupVaultMethod =
              getDeleteBackupVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.DeleteBackupVaultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackupVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.DeleteBackupVaultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("DeleteBackupVault"))
                      .build();
        }
      }
    }
    return getDeleteBackupVaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListDataSourcesRequest,
          com.google.cloud.backupdr.v1.ListDataSourcesResponse>
      getListDataSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataSources",
      requestType = com.google.cloud.backupdr.v1.ListDataSourcesRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListDataSourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListDataSourcesRequest,
          com.google.cloud.backupdr.v1.ListDataSourcesResponse>
      getListDataSourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListDataSourcesRequest,
            com.google.cloud.backupdr.v1.ListDataSourcesResponse>
        getListDataSourcesMethod;
    if ((getListDataSourcesMethod = BackupDRGrpc.getListDataSourcesMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListDataSourcesMethod = BackupDRGrpc.getListDataSourcesMethod) == null) {
          BackupDRGrpc.getListDataSourcesMethod =
              getListDataSourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListDataSourcesRequest,
                          com.google.cloud.backupdr.v1.ListDataSourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataSources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListDataSourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListDataSourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("ListDataSources"))
                      .build();
        }
      }
    }
    return getListDataSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetDataSourceRequest,
          com.google.cloud.backupdr.v1.DataSource>
      getGetDataSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataSource",
      requestType = com.google.cloud.backupdr.v1.GetDataSourceRequest.class,
      responseType = com.google.cloud.backupdr.v1.DataSource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetDataSourceRequest,
          com.google.cloud.backupdr.v1.DataSource>
      getGetDataSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetDataSourceRequest,
            com.google.cloud.backupdr.v1.DataSource>
        getGetDataSourceMethod;
    if ((getGetDataSourceMethod = BackupDRGrpc.getGetDataSourceMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetDataSourceMethod = BackupDRGrpc.getGetDataSourceMethod) == null) {
          BackupDRGrpc.getGetDataSourceMethod =
              getGetDataSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetDataSourceRequest,
                          com.google.cloud.backupdr.v1.DataSource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetDataSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.DataSource.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("GetDataSource"))
                      .build();
        }
      }
    }
    return getGetDataSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.UpdateDataSourceRequest, com.google.longrunning.Operation>
      getUpdateDataSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataSource",
      requestType = com.google.cloud.backupdr.v1.UpdateDataSourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.UpdateDataSourceRequest, com.google.longrunning.Operation>
      getUpdateDataSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.UpdateDataSourceRequest, com.google.longrunning.Operation>
        getUpdateDataSourceMethod;
    if ((getUpdateDataSourceMethod = BackupDRGrpc.getUpdateDataSourceMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getUpdateDataSourceMethod = BackupDRGrpc.getUpdateDataSourceMethod) == null) {
          BackupDRGrpc.getUpdateDataSourceMethod =
              getUpdateDataSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.UpdateDataSourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.UpdateDataSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("UpdateDataSource"))
                      .build();
        }
      }
    }
    return getUpdateDataSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListBackupsRequest,
          com.google.cloud.backupdr.v1.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackups",
      requestType = com.google.cloud.backupdr.v1.ListBackupsRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListBackupsRequest,
          com.google.cloud.backupdr.v1.ListBackupsResponse>
      getListBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListBackupsRequest,
            com.google.cloud.backupdr.v1.ListBackupsResponse>
        getListBackupsMethod;
    if ((getListBackupsMethod = BackupDRGrpc.getListBackupsMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListBackupsMethod = BackupDRGrpc.getListBackupsMethod) == null) {
          BackupDRGrpc.getListBackupsMethod =
              getListBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListBackupsRequest,
                          com.google.cloud.backupdr.v1.ListBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListBackupsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListBackupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("ListBackups"))
                      .build();
        }
      }
    }
    return getListBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetBackupRequest, com.google.cloud.backupdr.v1.Backup>
      getGetBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackup",
      requestType = com.google.cloud.backupdr.v1.GetBackupRequest.class,
      responseType = com.google.cloud.backupdr.v1.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetBackupRequest, com.google.cloud.backupdr.v1.Backup>
      getGetBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetBackupRequest, com.google.cloud.backupdr.v1.Backup>
        getGetBackupMethod;
    if ((getGetBackupMethod = BackupDRGrpc.getGetBackupMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetBackupMethod = BackupDRGrpc.getGetBackupMethod) == null) {
          BackupDRGrpc.getGetBackupMethod =
              getGetBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetBackupRequest,
                          com.google.cloud.backupdr.v1.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetBackupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("GetBackup"))
                      .build();
        }
      }
    }
    return getGetBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackup",
      requestType = com.google.cloud.backupdr.v1.UpdateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.UpdateBackupRequest, com.google.longrunning.Operation>
        getUpdateBackupMethod;
    if ((getUpdateBackupMethod = BackupDRGrpc.getUpdateBackupMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getUpdateBackupMethod = BackupDRGrpc.getUpdateBackupMethod) == null) {
          BackupDRGrpc.getUpdateBackupMethod =
              getUpdateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.UpdateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.UpdateBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("UpdateBackup"))
                      .build();
        }
      }
    }
    return getUpdateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackup",
      requestType = com.google.cloud.backupdr.v1.DeleteBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.DeleteBackupRequest, com.google.longrunning.Operation>
        getDeleteBackupMethod;
    if ((getDeleteBackupMethod = BackupDRGrpc.getDeleteBackupMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteBackupMethod = BackupDRGrpc.getDeleteBackupMethod) == null) {
          BackupDRGrpc.getDeleteBackupMethod =
              getDeleteBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.DeleteBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.DeleteBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("DeleteBackup"))
                      .build();
        }
      }
    }
    return getDeleteBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.RestoreBackupRequest, com.google.longrunning.Operation>
      getRestoreBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreBackup",
      requestType = com.google.cloud.backupdr.v1.RestoreBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.RestoreBackupRequest, com.google.longrunning.Operation>
      getRestoreBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.RestoreBackupRequest, com.google.longrunning.Operation>
        getRestoreBackupMethod;
    if ((getRestoreBackupMethod = BackupDRGrpc.getRestoreBackupMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getRestoreBackupMethod = BackupDRGrpc.getRestoreBackupMethod) == null) {
          BackupDRGrpc.getRestoreBackupMethod =
              getRestoreBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.RestoreBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.RestoreBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("RestoreBackup"))
                      .build();
        }
      }
    }
    return getRestoreBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateBackupPlanRequest, com.google.longrunning.Operation>
      getCreateBackupPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackupPlan",
      requestType = com.google.cloud.backupdr.v1.CreateBackupPlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateBackupPlanRequest, com.google.longrunning.Operation>
      getCreateBackupPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.CreateBackupPlanRequest, com.google.longrunning.Operation>
        getCreateBackupPlanMethod;
    if ((getCreateBackupPlanMethod = BackupDRGrpc.getCreateBackupPlanMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getCreateBackupPlanMethod = BackupDRGrpc.getCreateBackupPlanMethod) == null) {
          BackupDRGrpc.getCreateBackupPlanMethod =
              getCreateBackupPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.CreateBackupPlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackupPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.CreateBackupPlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("CreateBackupPlan"))
                      .build();
        }
      }
    }
    return getCreateBackupPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetBackupPlanRequest,
          com.google.cloud.backupdr.v1.BackupPlan>
      getGetBackupPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupPlan",
      requestType = com.google.cloud.backupdr.v1.GetBackupPlanRequest.class,
      responseType = com.google.cloud.backupdr.v1.BackupPlan.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetBackupPlanRequest,
          com.google.cloud.backupdr.v1.BackupPlan>
      getGetBackupPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetBackupPlanRequest,
            com.google.cloud.backupdr.v1.BackupPlan>
        getGetBackupPlanMethod;
    if ((getGetBackupPlanMethod = BackupDRGrpc.getGetBackupPlanMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetBackupPlanMethod = BackupDRGrpc.getGetBackupPlanMethod) == null) {
          BackupDRGrpc.getGetBackupPlanMethod =
              getGetBackupPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetBackupPlanRequest,
                          com.google.cloud.backupdr.v1.BackupPlan>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackupPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetBackupPlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.BackupPlan.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("GetBackupPlan"))
                      .build();
        }
      }
    }
    return getGetBackupPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListBackupPlansRequest,
          com.google.cloud.backupdr.v1.ListBackupPlansResponse>
      getListBackupPlansMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupPlans",
      requestType = com.google.cloud.backupdr.v1.ListBackupPlansRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListBackupPlansResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListBackupPlansRequest,
          com.google.cloud.backupdr.v1.ListBackupPlansResponse>
      getListBackupPlansMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListBackupPlansRequest,
            com.google.cloud.backupdr.v1.ListBackupPlansResponse>
        getListBackupPlansMethod;
    if ((getListBackupPlansMethod = BackupDRGrpc.getListBackupPlansMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListBackupPlansMethod = BackupDRGrpc.getListBackupPlansMethod) == null) {
          BackupDRGrpc.getListBackupPlansMethod =
              getListBackupPlansMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListBackupPlansRequest,
                          com.google.cloud.backupdr.v1.ListBackupPlansResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackupPlans"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListBackupPlansRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListBackupPlansResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("ListBackupPlans"))
                      .build();
        }
      }
    }
    return getListBackupPlansMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteBackupPlanRequest, com.google.longrunning.Operation>
      getDeleteBackupPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackupPlan",
      requestType = com.google.cloud.backupdr.v1.DeleteBackupPlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteBackupPlanRequest, com.google.longrunning.Operation>
      getDeleteBackupPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.DeleteBackupPlanRequest, com.google.longrunning.Operation>
        getDeleteBackupPlanMethod;
    if ((getDeleteBackupPlanMethod = BackupDRGrpc.getDeleteBackupPlanMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteBackupPlanMethod = BackupDRGrpc.getDeleteBackupPlanMethod) == null) {
          BackupDRGrpc.getDeleteBackupPlanMethod =
              getDeleteBackupPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.DeleteBackupPlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackupPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.DeleteBackupPlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("DeleteBackupPlan"))
                      .build();
        }
      }
    }
    return getDeleteBackupPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest,
          com.google.longrunning.Operation>
      getCreateBackupPlanAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackupPlanAssociation",
      requestType = com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest,
          com.google.longrunning.Operation>
      getCreateBackupPlanAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest,
            com.google.longrunning.Operation>
        getCreateBackupPlanAssociationMethod;
    if ((getCreateBackupPlanAssociationMethod = BackupDRGrpc.getCreateBackupPlanAssociationMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getCreateBackupPlanAssociationMethod =
                BackupDRGrpc.getCreateBackupPlanAssociationMethod)
            == null) {
          BackupDRGrpc.getCreateBackupPlanAssociationMethod =
              getCreateBackupPlanAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateBackupPlanAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("CreateBackupPlanAssociation"))
                      .build();
        }
      }
    }
    return getCreateBackupPlanAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest,
          com.google.cloud.backupdr.v1.BackupPlanAssociation>
      getGetBackupPlanAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupPlanAssociation",
      requestType = com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest.class,
      responseType = com.google.cloud.backupdr.v1.BackupPlanAssociation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest,
          com.google.cloud.backupdr.v1.BackupPlanAssociation>
      getGetBackupPlanAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest,
            com.google.cloud.backupdr.v1.BackupPlanAssociation>
        getGetBackupPlanAssociationMethod;
    if ((getGetBackupPlanAssociationMethod = BackupDRGrpc.getGetBackupPlanAssociationMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetBackupPlanAssociationMethod = BackupDRGrpc.getGetBackupPlanAssociationMethod)
            == null) {
          BackupDRGrpc.getGetBackupPlanAssociationMethod =
              getGetBackupPlanAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest,
                          com.google.cloud.backupdr.v1.BackupPlanAssociation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetBackupPlanAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.BackupPlanAssociation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("GetBackupPlanAssociation"))
                      .build();
        }
      }
    }
    return getGetBackupPlanAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest,
          com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse>
      getListBackupPlanAssociationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupPlanAssociations",
      requestType = com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest,
          com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse>
      getListBackupPlanAssociationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest,
            com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse>
        getListBackupPlanAssociationsMethod;
    if ((getListBackupPlanAssociationsMethod = BackupDRGrpc.getListBackupPlanAssociationsMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListBackupPlanAssociationsMethod = BackupDRGrpc.getListBackupPlanAssociationsMethod)
            == null) {
          BackupDRGrpc.getListBackupPlanAssociationsMethod =
              getListBackupPlanAssociationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest,
                          com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBackupPlanAssociations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListBackupPlanAssociations"))
                      .build();
        }
      }
    }
    return getListBackupPlanAssociationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest,
          com.google.longrunning.Operation>
      getDeleteBackupPlanAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackupPlanAssociation",
      requestType = com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest,
          com.google.longrunning.Operation>
      getDeleteBackupPlanAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest,
            com.google.longrunning.Operation>
        getDeleteBackupPlanAssociationMethod;
    if ((getDeleteBackupPlanAssociationMethod = BackupDRGrpc.getDeleteBackupPlanAssociationMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteBackupPlanAssociationMethod =
                BackupDRGrpc.getDeleteBackupPlanAssociationMethod)
            == null) {
          BackupDRGrpc.getDeleteBackupPlanAssociationMethod =
              getDeleteBackupPlanAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteBackupPlanAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("DeleteBackupPlanAssociation"))
                      .build();
        }
      }
    }
    return getDeleteBackupPlanAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.TriggerBackupRequest, com.google.longrunning.Operation>
      getTriggerBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TriggerBackup",
      requestType = com.google.cloud.backupdr.v1.TriggerBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.TriggerBackupRequest, com.google.longrunning.Operation>
      getTriggerBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.TriggerBackupRequest, com.google.longrunning.Operation>
        getTriggerBackupMethod;
    if ((getTriggerBackupMethod = BackupDRGrpc.getTriggerBackupMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getTriggerBackupMethod = BackupDRGrpc.getTriggerBackupMethod) == null) {
          BackupDRGrpc.getTriggerBackupMethod =
              getTriggerBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.TriggerBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TriggerBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.TriggerBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("TriggerBackup"))
                      .build();
        }
      }
    }
    return getTriggerBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.InitializeServiceRequest, com.google.longrunning.Operation>
      getInitializeServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InitializeService",
      requestType = com.google.cloud.backupdr.v1.InitializeServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.InitializeServiceRequest, com.google.longrunning.Operation>
      getInitializeServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.InitializeServiceRequest, com.google.longrunning.Operation>
        getInitializeServiceMethod;
    if ((getInitializeServiceMethod = BackupDRGrpc.getInitializeServiceMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getInitializeServiceMethod = BackupDRGrpc.getInitializeServiceMethod) == null) {
          BackupDRGrpc.getInitializeServiceMethod =
              getInitializeServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.InitializeServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InitializeService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.InitializeServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("InitializeService"))
                      .build();
        }
      }
    }
    return getInitializeServiceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BackupDRStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupDRStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupDRStub>() {
          @java.lang.Override
          public BackupDRStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupDRStub(channel, callOptions);
          }
        };
    return BackupDRStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BackupDRBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupDRBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupDRBlockingStub>() {
          @java.lang.Override
          public BackupDRBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupDRBlockingStub(channel, callOptions);
          }
        };
    return BackupDRBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BackupDRFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupDRFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupDRFutureStub>() {
          @java.lang.Override
          public BackupDRFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupDRFutureStub(channel, callOptions);
          }
        };
    return BackupDRFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The BackupDR Service
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists ManagementServers in a given project and location.
     * </pre>
     */
    default void listManagementServers(
        com.google.cloud.backupdr.v1.ListManagementServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListManagementServersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListManagementServersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ManagementServer.
     * </pre>
     */
    default void getManagementServer(
        com.google.cloud.backupdr.v1.GetManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ManagementServer>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetManagementServerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ManagementServer in a given project and location.
     * </pre>
     */
    default void createManagementServer(
        com.google.cloud.backupdr.v1.CreateManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateManagementServerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ManagementServer.
     * </pre>
     */
    default void deleteManagementServer(
        com.google.cloud.backupdr.v1.DeleteManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteManagementServerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new BackupVault in a given project and location.
     * </pre>
     */
    default void createBackupVault(
        com.google.cloud.backupdr.v1.CreateBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupVaultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupVaults in a given project and location.
     * </pre>
     */
    default void listBackupVaults(
        com.google.cloud.backupdr.v1.ListBackupVaultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListBackupVaultsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupVaultsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * FetchUsableBackupVaults lists usable BackupVaults in a given project and
     * location. Usable BackupVault are the ones that user has
     * backupdr.backupVaults.get permission.
     * </pre>
     */
    default void fetchUsableBackupVaults(
        com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchUsableBackupVaultsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a BackupVault.
     * </pre>
     */
    default void getBackupVault(
        com.google.cloud.backupdr.v1.GetBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.BackupVault> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBackupVaultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a BackupVault.
     * </pre>
     */
    default void updateBackupVault(
        com.google.cloud.backupdr.v1.UpdateBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupVaultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a BackupVault.
     * </pre>
     */
    default void deleteBackupVault(
        com.google.cloud.backupdr.v1.DeleteBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupVaultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataSources in a given project and location.
     * </pre>
     */
    default void listDataSources(
        com.google.cloud.backupdr.v1.ListDataSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListDataSourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataSourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a DataSource.
     * </pre>
     */
    default void getDataSource(
        com.google.cloud.backupdr.v1.GetDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.DataSource> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a DataSource.
     * </pre>
     */
    default void updateDataSource(
        com.google.cloud.backupdr.v1.UpdateDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    default void listBackups(
        com.google.cloud.backupdr.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a Backup.
     * </pre>
     */
    default void getBackup(
        com.google.cloud.backupdr.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.Backup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a Backup.
     * </pre>
     */
    default void updateBackup(
        com.google.cloud.backupdr.v1.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Backup.
     * </pre>
     */
    default void deleteBackup(
        com.google.cloud.backupdr.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restore from a Backup
     * </pre>
     */
    default void restoreBackup(
        com.google.cloud.backupdr.v1.RestoreBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a BackupPlan
     * </pre>
     */
    default void createBackupPlan(
        com.google.cloud.backupdr.v1.CreateBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupPlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackupPlan.
     * </pre>
     */
    default void getBackupPlan(
        com.google.cloud.backupdr.v1.GetBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.BackupPlan> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBackupPlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlans in a given project and location.
     * </pre>
     */
    default void listBackupPlans(
        com.google.cloud.backupdr.v1.ListBackupPlansRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListBackupPlansResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupPlansMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single BackupPlan.
     * </pre>
     */
    default void deleteBackupPlan(
        com.google.cloud.backupdr.v1.DeleteBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupPlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a BackupPlanAssociation
     * </pre>
     */
    default void createBackupPlanAssociation(
        com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupPlanAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackupPlanAssociation.
     * </pre>
     */
    default void getBackupPlanAssociation(
        com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.BackupPlanAssociation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBackupPlanAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlanAssociations in a given project and location.
     * </pre>
     */
    default void listBackupPlanAssociations(
        com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupPlanAssociationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single BackupPlanAssociation.
     * </pre>
     */
    default void deleteBackupPlanAssociation(
        com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupPlanAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Triggers a new Backup.
     * </pre>
     */
    default void triggerBackup(
        com.google.cloud.backupdr.v1.TriggerBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTriggerBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initializes the service related config for a project.
     * </pre>
     */
    default void initializeService(
        com.google.cloud.backupdr.v1.InitializeServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInitializeServiceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BackupDR.
   *
   * <pre>
   * The BackupDR Service
   * </pre>
   */
  public abstract static class BackupDRImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BackupDRGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BackupDR.
   *
   * <pre>
   * The BackupDR Service
   * </pre>
   */
  public static final class BackupDRStub extends io.grpc.stub.AbstractAsyncStub<BackupDRStub> {
    private BackupDRStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupDRStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupDRStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ManagementServers in a given project and location.
     * </pre>
     */
    public void listManagementServers(
        com.google.cloud.backupdr.v1.ListManagementServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListManagementServersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListManagementServersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ManagementServer.
     * </pre>
     */
    public void getManagementServer(
        com.google.cloud.backupdr.v1.GetManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ManagementServer>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetManagementServerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ManagementServer in a given project and location.
     * </pre>
     */
    public void createManagementServer(
        com.google.cloud.backupdr.v1.CreateManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateManagementServerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ManagementServer.
     * </pre>
     */
    public void deleteManagementServer(
        com.google.cloud.backupdr.v1.DeleteManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteManagementServerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new BackupVault in a given project and location.
     * </pre>
     */
    public void createBackupVault(
        com.google.cloud.backupdr.v1.CreateBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackupVaultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupVaults in a given project and location.
     * </pre>
     */
    public void listBackupVaults(
        com.google.cloud.backupdr.v1.ListBackupVaultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListBackupVaultsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupVaultsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * FetchUsableBackupVaults lists usable BackupVaults in a given project and
     * location. Usable BackupVault are the ones that user has
     * backupdr.backupVaults.get permission.
     * </pre>
     */
    public void fetchUsableBackupVaults(
        com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchUsableBackupVaultsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a BackupVault.
     * </pre>
     */
    public void getBackupVault(
        com.google.cloud.backupdr.v1.GetBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.BackupVault> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupVaultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a BackupVault.
     * </pre>
     */
    public void updateBackupVault(
        com.google.cloud.backupdr.v1.UpdateBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBackupVaultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a BackupVault.
     * </pre>
     */
    public void deleteBackupVault(
        com.google.cloud.backupdr.v1.DeleteBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupVaultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataSources in a given project and location.
     * </pre>
     */
    public void listDataSources(
        com.google.cloud.backupdr.v1.ListDataSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListDataSourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataSourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a DataSource.
     * </pre>
     */
    public void getDataSource(
        com.google.cloud.backupdr.v1.GetDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.DataSource> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a DataSource.
     * </pre>
     */
    public void updateDataSource(
        com.google.cloud.backupdr.v1.UpdateDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    public void listBackups(
        com.google.cloud.backupdr.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListBackupsResponse>
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
     * Gets details of a Backup.
     * </pre>
     */
    public void getBackup(
        com.google.cloud.backupdr.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.Backup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a Backup.
     * </pre>
     */
    public void updateBackup(
        com.google.cloud.backupdr.v1.UpdateBackupRequest request,
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
     * Deletes a Backup.
     * </pre>
     */
    public void deleteBackup(
        com.google.cloud.backupdr.v1.DeleteBackupRequest request,
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
     * Restore from a Backup
     * </pre>
     */
    public void restoreBackup(
        com.google.cloud.backupdr.v1.RestoreBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a BackupPlan
     * </pre>
     */
    public void createBackupPlan(
        com.google.cloud.backupdr.v1.CreateBackupPlanRequest request,
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
     * Gets details of a single BackupPlan.
     * </pre>
     */
    public void getBackupPlan(
        com.google.cloud.backupdr.v1.GetBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.BackupPlan> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupPlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlans in a given project and location.
     * </pre>
     */
    public void listBackupPlans(
        com.google.cloud.backupdr.v1.ListBackupPlansRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListBackupPlansResponse>
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
     * Deletes a single BackupPlan.
     * </pre>
     */
    public void deleteBackupPlan(
        com.google.cloud.backupdr.v1.DeleteBackupPlanRequest request,
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
     * Create a BackupPlanAssociation
     * </pre>
     */
    public void createBackupPlanAssociation(
        com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackupPlanAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackupPlanAssociation.
     * </pre>
     */
    public void getBackupPlanAssociation(
        com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.BackupPlanAssociation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupPlanAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlanAssociations in a given project and location.
     * </pre>
     */
    public void listBackupPlanAssociations(
        com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupPlanAssociationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single BackupPlanAssociation.
     * </pre>
     */
    public void deleteBackupPlanAssociation(
        com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupPlanAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Triggers a new Backup.
     * </pre>
     */
    public void triggerBackup(
        com.google.cloud.backupdr.v1.TriggerBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTriggerBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initializes the service related config for a project.
     * </pre>
     */
    public void initializeService(
        com.google.cloud.backupdr.v1.InitializeServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitializeServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BackupDR.
   *
   * <pre>
   * The BackupDR Service
   * </pre>
   */
  public static final class BackupDRBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BackupDRBlockingStub> {
    private BackupDRBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupDRBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupDRBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ManagementServers in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListManagementServersResponse listManagementServers(
        com.google.cloud.backupdr.v1.ListManagementServersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListManagementServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ManagementServer.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ManagementServer getManagementServer(
        com.google.cloud.backupdr.v1.GetManagementServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetManagementServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ManagementServer in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createManagementServer(
        com.google.cloud.backupdr.v1.CreateManagementServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateManagementServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ManagementServer.
     * </pre>
     */
    public com.google.longrunning.Operation deleteManagementServer(
        com.google.cloud.backupdr.v1.DeleteManagementServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteManagementServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new BackupVault in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createBackupVault(
        com.google.cloud.backupdr.v1.CreateBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupVaults in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListBackupVaultsResponse listBackupVaults(
        com.google.cloud.backupdr.v1.ListBackupVaultsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupVaultsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * FetchUsableBackupVaults lists usable BackupVaults in a given project and
     * location. Usable BackupVault are the ones that user has
     * backupdr.backupVaults.get permission.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse fetchUsableBackupVaults(
        com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchUsableBackupVaultsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a BackupVault.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.BackupVault getBackupVault(
        com.google.cloud.backupdr.v1.GetBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a BackupVault.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackupVault(
        com.google.cloud.backupdr.v1.UpdateBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a BackupVault.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackupVault(
        com.google.cloud.backupdr.v1.DeleteBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataSources in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListDataSourcesResponse listDataSources(
        com.google.cloud.backupdr.v1.ListDataSourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataSourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a DataSource.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.DataSource getDataSource(
        com.google.cloud.backupdr.v1.GetDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a DataSource.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataSource(
        com.google.cloud.backupdr.v1.UpdateDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListBackupsResponse listBackups(
        com.google.cloud.backupdr.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a Backup.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.Backup getBackup(
        com.google.cloud.backupdr.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a Backup.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackup(
        com.google.cloud.backupdr.v1.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Backup.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackup(
        com.google.cloud.backupdr.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restore from a Backup
     * </pre>
     */
    public com.google.longrunning.Operation restoreBackup(
        com.google.cloud.backupdr.v1.RestoreBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a BackupPlan
     * </pre>
     */
    public com.google.longrunning.Operation createBackupPlan(
        com.google.cloud.backupdr.v1.CreateBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackupPlan.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.BackupPlan getBackupPlan(
        com.google.cloud.backupdr.v1.GetBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlans in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListBackupPlansResponse listBackupPlans(
        com.google.cloud.backupdr.v1.ListBackupPlansRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupPlansMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single BackupPlan.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackupPlan(
        com.google.cloud.backupdr.v1.DeleteBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a BackupPlanAssociation
     * </pre>
     */
    public com.google.longrunning.Operation createBackupPlanAssociation(
        com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupPlanAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackupPlanAssociation.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.BackupPlanAssociation getBackupPlanAssociation(
        com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupPlanAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlanAssociations in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse
        listBackupPlanAssociations(
            com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupPlanAssociationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single BackupPlanAssociation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackupPlanAssociation(
        com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupPlanAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Triggers a new Backup.
     * </pre>
     */
    public com.google.longrunning.Operation triggerBackup(
        com.google.cloud.backupdr.v1.TriggerBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTriggerBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initializes the service related config for a project.
     * </pre>
     */
    public com.google.longrunning.Operation initializeService(
        com.google.cloud.backupdr.v1.InitializeServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitializeServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BackupDR.
   *
   * <pre>
   * The BackupDR Service
   * </pre>
   */
  public static final class BackupDRFutureStub
      extends io.grpc.stub.AbstractFutureStub<BackupDRFutureStub> {
    private BackupDRFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupDRFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupDRFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ManagementServers in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListManagementServersResponse>
        listManagementServers(com.google.cloud.backupdr.v1.ListManagementServersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListManagementServersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ManagementServer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ManagementServer>
        getManagementServer(com.google.cloud.backupdr.v1.GetManagementServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetManagementServerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ManagementServer in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createManagementServer(com.google.cloud.backupdr.v1.CreateManagementServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateManagementServerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ManagementServer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteManagementServer(com.google.cloud.backupdr.v1.DeleteManagementServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteManagementServerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new BackupVault in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackupVault(com.google.cloud.backupdr.v1.CreateBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupVaultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupVaults in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListBackupVaultsResponse>
        listBackupVaults(com.google.cloud.backupdr.v1.ListBackupVaultsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupVaultsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * FetchUsableBackupVaults lists usable BackupVaults in a given project and
     * location. Usable BackupVault are the ones that user has
     * backupdr.backupVaults.get permission.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse>
        fetchUsableBackupVaults(
            com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchUsableBackupVaultsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a BackupVault.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.BackupVault>
        getBackupVault(com.google.cloud.backupdr.v1.GetBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupVaultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a BackupVault.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBackupVault(com.google.cloud.backupdr.v1.UpdateBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupVaultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a BackupVault.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackupVault(com.google.cloud.backupdr.v1.DeleteBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupVaultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataSources in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListDataSourcesResponse>
        listDataSources(com.google.cloud.backupdr.v1.ListDataSourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataSourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a DataSource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.DataSource>
        getDataSource(com.google.cloud.backupdr.v1.GetDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a DataSource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDataSource(com.google.cloud.backupdr.v1.UpdateDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListBackupsResponse>
        listBackups(com.google.cloud.backupdr.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.backupdr.v1.Backup>
        getBackup(com.google.cloud.backupdr.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBackup(com.google.cloud.backupdr.v1.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackup(com.google.cloud.backupdr.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restore from a Backup
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restoreBackup(com.google.cloud.backupdr.v1.RestoreBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a BackupPlan
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackupPlan(com.google.cloud.backupdr.v1.CreateBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupPlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackupPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.BackupPlan>
        getBackupPlan(com.google.cloud.backupdr.v1.GetBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupPlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlans in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListBackupPlansResponse>
        listBackupPlans(com.google.cloud.backupdr.v1.ListBackupPlansRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupPlansMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single BackupPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackupPlan(com.google.cloud.backupdr.v1.DeleteBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupPlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a BackupPlanAssociation
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackupPlanAssociation(
            com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupPlanAssociationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackupPlanAssociation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.BackupPlanAssociation>
        getBackupPlanAssociation(
            com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupPlanAssociationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlanAssociations in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse>
        listBackupPlanAssociations(
            com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupPlanAssociationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single BackupPlanAssociation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackupPlanAssociation(
            com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupPlanAssociationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Triggers a new Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        triggerBackup(com.google.cloud.backupdr.v1.TriggerBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTriggerBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initializes the service related config for a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        initializeService(com.google.cloud.backupdr.v1.InitializeServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInitializeServiceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_MANAGEMENT_SERVERS = 0;
  private static final int METHODID_GET_MANAGEMENT_SERVER = 1;
  private static final int METHODID_CREATE_MANAGEMENT_SERVER = 2;
  private static final int METHODID_DELETE_MANAGEMENT_SERVER = 3;
  private static final int METHODID_CREATE_BACKUP_VAULT = 4;
  private static final int METHODID_LIST_BACKUP_VAULTS = 5;
  private static final int METHODID_FETCH_USABLE_BACKUP_VAULTS = 6;
  private static final int METHODID_GET_BACKUP_VAULT = 7;
  private static final int METHODID_UPDATE_BACKUP_VAULT = 8;
  private static final int METHODID_DELETE_BACKUP_VAULT = 9;
  private static final int METHODID_LIST_DATA_SOURCES = 10;
  private static final int METHODID_GET_DATA_SOURCE = 11;
  private static final int METHODID_UPDATE_DATA_SOURCE = 12;
  private static final int METHODID_LIST_BACKUPS = 13;
  private static final int METHODID_GET_BACKUP = 14;
  private static final int METHODID_UPDATE_BACKUP = 15;
  private static final int METHODID_DELETE_BACKUP = 16;
  private static final int METHODID_RESTORE_BACKUP = 17;
  private static final int METHODID_CREATE_BACKUP_PLAN = 18;
  private static final int METHODID_GET_BACKUP_PLAN = 19;
  private static final int METHODID_LIST_BACKUP_PLANS = 20;
  private static final int METHODID_DELETE_BACKUP_PLAN = 21;
  private static final int METHODID_CREATE_BACKUP_PLAN_ASSOCIATION = 22;
  private static final int METHODID_GET_BACKUP_PLAN_ASSOCIATION = 23;
  private static final int METHODID_LIST_BACKUP_PLAN_ASSOCIATIONS = 24;
  private static final int METHODID_DELETE_BACKUP_PLAN_ASSOCIATION = 25;
  private static final int METHODID_TRIGGER_BACKUP = 26;
  private static final int METHODID_INITIALIZE_SERVICE = 27;

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
        case METHODID_LIST_MANAGEMENT_SERVERS:
          serviceImpl.listManagementServers(
              (com.google.cloud.backupdr.v1.ListManagementServersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListManagementServersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MANAGEMENT_SERVER:
          serviceImpl.getManagementServer(
              (com.google.cloud.backupdr.v1.GetManagementServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ManagementServer>)
                  responseObserver);
          break;
        case METHODID_CREATE_MANAGEMENT_SERVER:
          serviceImpl.createManagementServer(
              (com.google.cloud.backupdr.v1.CreateManagementServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MANAGEMENT_SERVER:
          serviceImpl.deleteManagementServer(
              (com.google.cloud.backupdr.v1.DeleteManagementServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BACKUP_VAULT:
          serviceImpl.createBackupVault(
              (com.google.cloud.backupdr.v1.CreateBackupVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BACKUP_VAULTS:
          serviceImpl.listBackupVaults(
              (com.google.cloud.backupdr.v1.ListBackupVaultsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListBackupVaultsResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_USABLE_BACKUP_VAULTS:
          serviceImpl.fetchUsableBackupVaults(
              (com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP_VAULT:
          serviceImpl.getBackupVault(
              (com.google.cloud.backupdr.v1.GetBackupVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.BackupVault>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BACKUP_VAULT:
          serviceImpl.updateBackupVault(
              (com.google.cloud.backupdr.v1.UpdateBackupVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKUP_VAULT:
          serviceImpl.deleteBackupVault(
              (com.google.cloud.backupdr.v1.DeleteBackupVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DATA_SOURCES:
          serviceImpl.listDataSources(
              (com.google.cloud.backupdr.v1.ListDataSourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListDataSourcesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_SOURCE:
          serviceImpl.getDataSource(
              (com.google.cloud.backupdr.v1.GetDataSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.DataSource>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_SOURCE:
          serviceImpl.updateDataSource(
              (com.google.cloud.backupdr.v1.UpdateDataSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BACKUPS:
          serviceImpl.listBackups(
              (com.google.cloud.backupdr.v1.ListBackupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP:
          serviceImpl.getBackup(
              (com.google.cloud.backupdr.v1.GetBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.Backup>) responseObserver);
          break;
        case METHODID_UPDATE_BACKUP:
          serviceImpl.updateBackup(
              (com.google.cloud.backupdr.v1.UpdateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKUP:
          serviceImpl.deleteBackup(
              (com.google.cloud.backupdr.v1.DeleteBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTORE_BACKUP:
          serviceImpl.restoreBackup(
              (com.google.cloud.backupdr.v1.RestoreBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BACKUP_PLAN:
          serviceImpl.createBackupPlan(
              (com.google.cloud.backupdr.v1.CreateBackupPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_BACKUP_PLAN:
          serviceImpl.getBackupPlan(
              (com.google.cloud.backupdr.v1.GetBackupPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.BackupPlan>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUP_PLANS:
          serviceImpl.listBackupPlans(
              (com.google.cloud.backupdr.v1.ListBackupPlansRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListBackupPlansResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_BACKUP_PLAN:
          serviceImpl.deleteBackupPlan(
              (com.google.cloud.backupdr.v1.DeleteBackupPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BACKUP_PLAN_ASSOCIATION:
          serviceImpl.createBackupPlanAssociation(
              (com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_BACKUP_PLAN_ASSOCIATION:
          serviceImpl.getBackupPlanAssociation(
              (com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.BackupPlanAssociation>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUP_PLAN_ASSOCIATIONS:
          serviceImpl.listBackupPlanAssociations(
              (com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_BACKUP_PLAN_ASSOCIATION:
          serviceImpl.deleteBackupPlanAssociation(
              (com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_TRIGGER_BACKUP:
          serviceImpl.triggerBackup(
              (com.google.cloud.backupdr.v1.TriggerBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_INITIALIZE_SERVICE:
          serviceImpl.initializeService(
              (com.google.cloud.backupdr.v1.InitializeServiceRequest) request,
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
            getListManagementServersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListManagementServersRequest,
                    com.google.cloud.backupdr.v1.ListManagementServersResponse>(
                    service, METHODID_LIST_MANAGEMENT_SERVERS)))
        .addMethod(
            getGetManagementServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetManagementServerRequest,
                    com.google.cloud.backupdr.v1.ManagementServer>(
                    service, METHODID_GET_MANAGEMENT_SERVER)))
        .addMethod(
            getCreateManagementServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.CreateManagementServerRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_MANAGEMENT_SERVER)))
        .addMethod(
            getDeleteManagementServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.DeleteManagementServerRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_MANAGEMENT_SERVER)))
        .addMethod(
            getCreateBackupVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.CreateBackupVaultRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BACKUP_VAULT)))
        .addMethod(
            getListBackupVaultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListBackupVaultsRequest,
                    com.google.cloud.backupdr.v1.ListBackupVaultsResponse>(
                    service, METHODID_LIST_BACKUP_VAULTS)))
        .addMethod(
            getFetchUsableBackupVaultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest,
                    com.google.cloud.backupdr.v1.FetchUsableBackupVaultsResponse>(
                    service, METHODID_FETCH_USABLE_BACKUP_VAULTS)))
        .addMethod(
            getGetBackupVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetBackupVaultRequest,
                    com.google.cloud.backupdr.v1.BackupVault>(service, METHODID_GET_BACKUP_VAULT)))
        .addMethod(
            getUpdateBackupVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.UpdateBackupVaultRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BACKUP_VAULT)))
        .addMethod(
            getDeleteBackupVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.DeleteBackupVaultRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP_VAULT)))
        .addMethod(
            getListDataSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListDataSourcesRequest,
                    com.google.cloud.backupdr.v1.ListDataSourcesResponse>(
                    service, METHODID_LIST_DATA_SOURCES)))
        .addMethod(
            getGetDataSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetDataSourceRequest,
                    com.google.cloud.backupdr.v1.DataSource>(service, METHODID_GET_DATA_SOURCE)))
        .addMethod(
            getUpdateDataSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.UpdateDataSourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATA_SOURCE)))
        .addMethod(
            getListBackupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListBackupsRequest,
                    com.google.cloud.backupdr.v1.ListBackupsResponse>(
                    service, METHODID_LIST_BACKUPS)))
        .addMethod(
            getGetBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetBackupRequest,
                    com.google.cloud.backupdr.v1.Backup>(service, METHODID_GET_BACKUP)))
        .addMethod(
            getUpdateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.UpdateBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BACKUP)))
        .addMethod(
            getDeleteBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.DeleteBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP)))
        .addMethod(
            getRestoreBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.RestoreBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESTORE_BACKUP)))
        .addMethod(
            getCreateBackupPlanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.CreateBackupPlanRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BACKUP_PLAN)))
        .addMethod(
            getGetBackupPlanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetBackupPlanRequest,
                    com.google.cloud.backupdr.v1.BackupPlan>(service, METHODID_GET_BACKUP_PLAN)))
        .addMethod(
            getListBackupPlansMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListBackupPlansRequest,
                    com.google.cloud.backupdr.v1.ListBackupPlansResponse>(
                    service, METHODID_LIST_BACKUP_PLANS)))
        .addMethod(
            getDeleteBackupPlanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.DeleteBackupPlanRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP_PLAN)))
        .addMethod(
            getCreateBackupPlanAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_BACKUP_PLAN_ASSOCIATION)))
        .addMethod(
            getGetBackupPlanAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest,
                    com.google.cloud.backupdr.v1.BackupPlanAssociation>(
                    service, METHODID_GET_BACKUP_PLAN_ASSOCIATION)))
        .addMethod(
            getListBackupPlanAssociationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest,
                    com.google.cloud.backupdr.v1.ListBackupPlanAssociationsResponse>(
                    service, METHODID_LIST_BACKUP_PLAN_ASSOCIATIONS)))
        .addMethod(
            getDeleteBackupPlanAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_BACKUP_PLAN_ASSOCIATION)))
        .addMethod(
            getTriggerBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.TriggerBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_TRIGGER_BACKUP)))
        .addMethod(
            getInitializeServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.InitializeServiceRequest,
                    com.google.longrunning.Operation>(service, METHODID_INITIALIZE_SERVICE)))
        .build();
  }

  private abstract static class BackupDRBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BackupDRBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.backupdr.v1.BackupDRProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BackupDR");
    }
  }

  private static final class BackupDRFileDescriptorSupplier extends BackupDRBaseDescriptorSupplier {
    BackupDRFileDescriptorSupplier() {}
  }

  private static final class BackupDRMethodDescriptorSupplier extends BackupDRBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BackupDRMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BackupDRGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BackupDRFileDescriptorSupplier())
                      .addMethod(getListManagementServersMethod())
                      .addMethod(getGetManagementServerMethod())
                      .addMethod(getCreateManagementServerMethod())
                      .addMethod(getDeleteManagementServerMethod())
                      .addMethod(getCreateBackupVaultMethod())
                      .addMethod(getListBackupVaultsMethod())
                      .addMethod(getFetchUsableBackupVaultsMethod())
                      .addMethod(getGetBackupVaultMethod())
                      .addMethod(getUpdateBackupVaultMethod())
                      .addMethod(getDeleteBackupVaultMethod())
                      .addMethod(getListDataSourcesMethod())
                      .addMethod(getGetDataSourceMethod())
                      .addMethod(getUpdateDataSourceMethod())
                      .addMethod(getListBackupsMethod())
                      .addMethod(getGetBackupMethod())
                      .addMethod(getUpdateBackupMethod())
                      .addMethod(getDeleteBackupMethod())
                      .addMethod(getRestoreBackupMethod())
                      .addMethod(getCreateBackupPlanMethod())
                      .addMethod(getGetBackupPlanMethod())
                      .addMethod(getListBackupPlansMethod())
                      .addMethod(getDeleteBackupPlanMethod())
                      .addMethod(getCreateBackupPlanAssociationMethod())
                      .addMethod(getGetBackupPlanAssociationMethod())
                      .addMethod(getListBackupPlanAssociationsMethod())
                      .addMethod(getDeleteBackupPlanAssociationMethod())
                      .addMethod(getTriggerBackupMethod())
                      .addMethod(getInitializeServiceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
