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
package com.google.cloud.backupdr.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The BackupDR Service
 * </pre>
 */
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
          com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeRequest,
          com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeResponse>
      getFetchBackupsForResourceTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchBackupsForResourceType",
      requestType = com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeRequest.class,
      responseType = com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeRequest,
          com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeResponse>
      getFetchBackupsForResourceTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeRequest,
            com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeResponse>
        getFetchBackupsForResourceTypeMethod;
    if ((getFetchBackupsForResourceTypeMethod = BackupDRGrpc.getFetchBackupsForResourceTypeMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getFetchBackupsForResourceTypeMethod =
                BackupDRGrpc.getFetchBackupsForResourceTypeMethod)
            == null) {
          BackupDRGrpc.getFetchBackupsForResourceTypeMethod =
              getFetchBackupsForResourceTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeRequest,
                          com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchBackupsForResourceType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("FetchBackupsForResourceType"))
                      .build();
        }
      }
    }
    return getFetchBackupsForResourceTypeMethod;
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
          com.google.cloud.backupdr.v1.UpdateBackupPlanRequest, com.google.longrunning.Operation>
      getUpdateBackupPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackupPlan",
      requestType = com.google.cloud.backupdr.v1.UpdateBackupPlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.UpdateBackupPlanRequest, com.google.longrunning.Operation>
      getUpdateBackupPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.UpdateBackupPlanRequest, com.google.longrunning.Operation>
        getUpdateBackupPlanMethod;
    if ((getUpdateBackupPlanMethod = BackupDRGrpc.getUpdateBackupPlanMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getUpdateBackupPlanMethod = BackupDRGrpc.getUpdateBackupPlanMethod) == null) {
          BackupDRGrpc.getUpdateBackupPlanMethod =
              getUpdateBackupPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.UpdateBackupPlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackupPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.UpdateBackupPlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("UpdateBackupPlan"))
                      .build();
        }
      }
    }
    return getUpdateBackupPlanMethod;
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
          com.google.cloud.backupdr.v1.GetBackupPlanRevisionRequest,
          com.google.cloud.backupdr.v1.BackupPlanRevision>
      getGetBackupPlanRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupPlanRevision",
      requestType = com.google.cloud.backupdr.v1.GetBackupPlanRevisionRequest.class,
      responseType = com.google.cloud.backupdr.v1.BackupPlanRevision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetBackupPlanRevisionRequest,
          com.google.cloud.backupdr.v1.BackupPlanRevision>
      getGetBackupPlanRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetBackupPlanRevisionRequest,
            com.google.cloud.backupdr.v1.BackupPlanRevision>
        getGetBackupPlanRevisionMethod;
    if ((getGetBackupPlanRevisionMethod = BackupDRGrpc.getGetBackupPlanRevisionMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetBackupPlanRevisionMethod = BackupDRGrpc.getGetBackupPlanRevisionMethod)
            == null) {
          BackupDRGrpc.getGetBackupPlanRevisionMethod =
              getGetBackupPlanRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetBackupPlanRevisionRequest,
                          com.google.cloud.backupdr.v1.BackupPlanRevision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetBackupPlanRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetBackupPlanRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.BackupPlanRevision.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("GetBackupPlanRevision"))
                      .build();
        }
      }
    }
    return getGetBackupPlanRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListBackupPlanRevisionsRequest,
          com.google.cloud.backupdr.v1.ListBackupPlanRevisionsResponse>
      getListBackupPlanRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupPlanRevisions",
      requestType = com.google.cloud.backupdr.v1.ListBackupPlanRevisionsRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListBackupPlanRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListBackupPlanRevisionsRequest,
          com.google.cloud.backupdr.v1.ListBackupPlanRevisionsResponse>
      getListBackupPlanRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListBackupPlanRevisionsRequest,
            com.google.cloud.backupdr.v1.ListBackupPlanRevisionsResponse>
        getListBackupPlanRevisionsMethod;
    if ((getListBackupPlanRevisionsMethod = BackupDRGrpc.getListBackupPlanRevisionsMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListBackupPlanRevisionsMethod = BackupDRGrpc.getListBackupPlanRevisionsMethod)
            == null) {
          BackupDRGrpc.getListBackupPlanRevisionsMethod =
              getListBackupPlanRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListBackupPlanRevisionsRequest,
                          com.google.cloud.backupdr.v1.ListBackupPlanRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBackupPlanRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListBackupPlanRevisionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListBackupPlanRevisionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListBackupPlanRevisions"))
                      .build();
        }
      }
    }
    return getListBackupPlanRevisionsMethod;
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
          com.google.cloud.backupdr.v1.UpdateBackupPlanAssociationRequest,
          com.google.longrunning.Operation>
      getUpdateBackupPlanAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackupPlanAssociation",
      requestType = com.google.cloud.backupdr.v1.UpdateBackupPlanAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.UpdateBackupPlanAssociationRequest,
          com.google.longrunning.Operation>
      getUpdateBackupPlanAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.UpdateBackupPlanAssociationRequest,
            com.google.longrunning.Operation>
        getUpdateBackupPlanAssociationMethod;
    if ((getUpdateBackupPlanAssociationMethod = BackupDRGrpc.getUpdateBackupPlanAssociationMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getUpdateBackupPlanAssociationMethod =
                BackupDRGrpc.getUpdateBackupPlanAssociationMethod)
            == null) {
          BackupDRGrpc.getUpdateBackupPlanAssociationMethod =
              getUpdateBackupPlanAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.UpdateBackupPlanAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateBackupPlanAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.UpdateBackupPlanAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("UpdateBackupPlanAssociation"))
                      .build();
        }
      }
    }
    return getUpdateBackupPlanAssociationMethod;
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
          com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeRequest,
          com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeResponse>
      getFetchBackupPlanAssociationsForResourceTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchBackupPlanAssociationsForResourceType",
      requestType =
          com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeRequest.class,
      responseType =
          com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeRequest,
          com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeResponse>
      getFetchBackupPlanAssociationsForResourceTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeRequest,
            com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeResponse>
        getFetchBackupPlanAssociationsForResourceTypeMethod;
    if ((getFetchBackupPlanAssociationsForResourceTypeMethod =
            BackupDRGrpc.getFetchBackupPlanAssociationsForResourceTypeMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getFetchBackupPlanAssociationsForResourceTypeMethod =
                BackupDRGrpc.getFetchBackupPlanAssociationsForResourceTypeMethod)
            == null) {
          BackupDRGrpc.getFetchBackupPlanAssociationsForResourceTypeMethod =
              getFetchBackupPlanAssociationsForResourceTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1
                              .FetchBackupPlanAssociationsForResourceTypeRequest,
                          com.google.cloud.backupdr.v1
                              .FetchBackupPlanAssociationsForResourceTypeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "FetchBackupPlanAssociationsForResourceType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1
                                  .FetchBackupPlanAssociationsForResourceTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1
                                  .FetchBackupPlanAssociationsForResourceTypeResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier(
                              "FetchBackupPlanAssociationsForResourceType"))
                      .build();
        }
      }
    }
    return getFetchBackupPlanAssociationsForResourceTypeMethod;
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
          com.google.cloud.backupdr.v1.GetDataSourceReferenceRequest,
          com.google.cloud.backupdr.v1.DataSourceReference>
      getGetDataSourceReferenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataSourceReference",
      requestType = com.google.cloud.backupdr.v1.GetDataSourceReferenceRequest.class,
      responseType = com.google.cloud.backupdr.v1.DataSourceReference.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetDataSourceReferenceRequest,
          com.google.cloud.backupdr.v1.DataSourceReference>
      getGetDataSourceReferenceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetDataSourceReferenceRequest,
            com.google.cloud.backupdr.v1.DataSourceReference>
        getGetDataSourceReferenceMethod;
    if ((getGetDataSourceReferenceMethod = BackupDRGrpc.getGetDataSourceReferenceMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetDataSourceReferenceMethod = BackupDRGrpc.getGetDataSourceReferenceMethod)
            == null) {
          BackupDRGrpc.getGetDataSourceReferenceMethod =
              getGetDataSourceReferenceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetDataSourceReferenceRequest,
                          com.google.cloud.backupdr.v1.DataSourceReference>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDataSourceReference"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetDataSourceReferenceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.DataSourceReference
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("GetDataSourceReference"))
                      .build();
        }
      }
    }
    return getGetDataSourceReferenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListDataSourceReferencesRequest,
          com.google.cloud.backupdr.v1.ListDataSourceReferencesResponse>
      getListDataSourceReferencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataSourceReferences",
      requestType = com.google.cloud.backupdr.v1.ListDataSourceReferencesRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListDataSourceReferencesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListDataSourceReferencesRequest,
          com.google.cloud.backupdr.v1.ListDataSourceReferencesResponse>
      getListDataSourceReferencesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListDataSourceReferencesRequest,
            com.google.cloud.backupdr.v1.ListDataSourceReferencesResponse>
        getListDataSourceReferencesMethod;
    if ((getListDataSourceReferencesMethod = BackupDRGrpc.getListDataSourceReferencesMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListDataSourceReferencesMethod = BackupDRGrpc.getListDataSourceReferencesMethod)
            == null) {
          BackupDRGrpc.getListDataSourceReferencesMethod =
              getListDataSourceReferencesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListDataSourceReferencesRequest,
                          com.google.cloud.backupdr.v1.ListDataSourceReferencesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDataSourceReferences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListDataSourceReferencesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListDataSourceReferencesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListDataSourceReferences"))
                      .build();
        }
      }
    }
    return getListDataSourceReferencesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeRequest,
          com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeResponse>
      getFetchDataSourceReferencesForResourceTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchDataSourceReferencesForResourceType",
      requestType =
          com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeRequest.class,
      responseType =
          com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeRequest,
          com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeResponse>
      getFetchDataSourceReferencesForResourceTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeRequest,
            com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeResponse>
        getFetchDataSourceReferencesForResourceTypeMethod;
    if ((getFetchDataSourceReferencesForResourceTypeMethod =
            BackupDRGrpc.getFetchDataSourceReferencesForResourceTypeMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getFetchDataSourceReferencesForResourceTypeMethod =
                BackupDRGrpc.getFetchDataSourceReferencesForResourceTypeMethod)
            == null) {
          BackupDRGrpc.getFetchDataSourceReferencesForResourceTypeMethod =
              getFetchDataSourceReferencesForResourceTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1
                              .FetchDataSourceReferencesForResourceTypeRequest,
                          com.google.cloud.backupdr.v1
                              .FetchDataSourceReferencesForResourceTypeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "FetchDataSourceReferencesForResourceType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1
                                  .FetchDataSourceReferencesForResourceTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1
                                  .FetchDataSourceReferencesForResourceTypeResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier(
                              "FetchDataSourceReferencesForResourceType"))
                      .build();
        }
      }
    }
    return getFetchDataSourceReferencesForResourceTypeMethod;
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyRequest,
          com.google.longrunning.Operation>
      getCreateAutoProtectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAutoProtectionPolicy",
      requestType = com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyRequest,
          com.google.longrunning.Operation>
      getCreateAutoProtectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyRequest,
            com.google.longrunning.Operation>
        getCreateAutoProtectionPolicyMethod;
    if ((getCreateAutoProtectionPolicyMethod = BackupDRGrpc.getCreateAutoProtectionPolicyMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getCreateAutoProtectionPolicyMethod = BackupDRGrpc.getCreateAutoProtectionPolicyMethod)
            == null) {
          BackupDRGrpc.getCreateAutoProtectionPolicyMethod =
              getCreateAutoProtectionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAutoProtectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("CreateAutoProtectionPolicy"))
                      .build();
        }
      }
    }
    return getCreateAutoProtectionPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesRequest,
          com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesResponse>
      getListAutoProtectionPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAutoProtectionPolicies",
      requestType = com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesRequest,
          com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesResponse>
      getListAutoProtectionPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesRequest,
            com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesResponse>
        getListAutoProtectionPoliciesMethod;
    if ((getListAutoProtectionPoliciesMethod = BackupDRGrpc.getListAutoProtectionPoliciesMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListAutoProtectionPoliciesMethod = BackupDRGrpc.getListAutoProtectionPoliciesMethod)
            == null) {
          BackupDRGrpc.getListAutoProtectionPoliciesMethod =
              getListAutoProtectionPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesRequest,
                          com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAutoProtectionPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListAutoProtectionPolicies"))
                      .build();
        }
      }
    }
    return getListAutoProtectionPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetAutoProtectionPolicyRequest,
          com.google.cloud.backupdr.v1.AutoProtectionPolicy>
      getGetAutoProtectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAutoProtectionPolicy",
      requestType = com.google.cloud.backupdr.v1.GetAutoProtectionPolicyRequest.class,
      responseType = com.google.cloud.backupdr.v1.AutoProtectionPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetAutoProtectionPolicyRequest,
          com.google.cloud.backupdr.v1.AutoProtectionPolicy>
      getGetAutoProtectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetAutoProtectionPolicyRequest,
            com.google.cloud.backupdr.v1.AutoProtectionPolicy>
        getGetAutoProtectionPolicyMethod;
    if ((getGetAutoProtectionPolicyMethod = BackupDRGrpc.getGetAutoProtectionPolicyMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetAutoProtectionPolicyMethod = BackupDRGrpc.getGetAutoProtectionPolicyMethod)
            == null) {
          BackupDRGrpc.getGetAutoProtectionPolicyMethod =
              getGetAutoProtectionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetAutoProtectionPolicyRequest,
                          com.google.cloud.backupdr.v1.AutoProtectionPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAutoProtectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetAutoProtectionPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.AutoProtectionPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("GetAutoProtectionPolicy"))
                      .build();
        }
      }
    }
    return getGetAutoProtectionPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.UpdateAutoProtectionPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateAutoProtectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAutoProtectionPolicy",
      requestType = com.google.cloud.backupdr.v1.UpdateAutoProtectionPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.UpdateAutoProtectionPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateAutoProtectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.UpdateAutoProtectionPolicyRequest,
            com.google.longrunning.Operation>
        getUpdateAutoProtectionPolicyMethod;
    if ((getUpdateAutoProtectionPolicyMethod = BackupDRGrpc.getUpdateAutoProtectionPolicyMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getUpdateAutoProtectionPolicyMethod = BackupDRGrpc.getUpdateAutoProtectionPolicyMethod)
            == null) {
          BackupDRGrpc.getUpdateAutoProtectionPolicyMethod =
              getUpdateAutoProtectionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.UpdateAutoProtectionPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAutoProtectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.UpdateAutoProtectionPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("UpdateAutoProtectionPolicy"))
                      .build();
        }
      }
    }
    return getUpdateAutoProtectionPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteAutoProtectionPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteAutoProtectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAutoProtectionPolicy",
      requestType = com.google.cloud.backupdr.v1.DeleteAutoProtectionPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteAutoProtectionPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteAutoProtectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.DeleteAutoProtectionPolicyRequest,
            com.google.longrunning.Operation>
        getDeleteAutoProtectionPolicyMethod;
    if ((getDeleteAutoProtectionPolicyMethod = BackupDRGrpc.getDeleteAutoProtectionPolicyMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteAutoProtectionPolicyMethod = BackupDRGrpc.getDeleteAutoProtectionPolicyMethod)
            == null) {
          BackupDRGrpc.getDeleteAutoProtectionPolicyMethod =
              getDeleteAutoProtectionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.DeleteAutoProtectionPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAutoProtectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.DeleteAutoProtectionPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("DeleteAutoProtectionPolicy"))
                      .build();
        }
      }
    }
    return getDeleteAutoProtectionPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyBindingRequest,
          com.google.longrunning.Operation>
      getCreateAutoProtectionPolicyBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAutoProtectionPolicyBinding",
      requestType = com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyBindingRequest,
          com.google.longrunning.Operation>
      getCreateAutoProtectionPolicyBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyBindingRequest,
            com.google.longrunning.Operation>
        getCreateAutoProtectionPolicyBindingMethod;
    if ((getCreateAutoProtectionPolicyBindingMethod =
            BackupDRGrpc.getCreateAutoProtectionPolicyBindingMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getCreateAutoProtectionPolicyBindingMethod =
                BackupDRGrpc.getCreateAutoProtectionPolicyBindingMethod)
            == null) {
          BackupDRGrpc.getCreateAutoProtectionPolicyBindingMethod =
              getCreateAutoProtectionPolicyBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAutoProtectionPolicyBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("CreateAutoProtectionPolicyBinding"))
                      .build();
        }
      }
    }
    return getCreateAutoProtectionPolicyBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetAutoProtectionPolicyBindingRequest,
          com.google.cloud.backupdr.v1.AutoProtectionPolicyBinding>
      getGetAutoProtectionPolicyBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAutoProtectionPolicyBinding",
      requestType = com.google.cloud.backupdr.v1.GetAutoProtectionPolicyBindingRequest.class,
      responseType = com.google.cloud.backupdr.v1.AutoProtectionPolicyBinding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetAutoProtectionPolicyBindingRequest,
          com.google.cloud.backupdr.v1.AutoProtectionPolicyBinding>
      getGetAutoProtectionPolicyBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetAutoProtectionPolicyBindingRequest,
            com.google.cloud.backupdr.v1.AutoProtectionPolicyBinding>
        getGetAutoProtectionPolicyBindingMethod;
    if ((getGetAutoProtectionPolicyBindingMethod =
            BackupDRGrpc.getGetAutoProtectionPolicyBindingMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetAutoProtectionPolicyBindingMethod =
                BackupDRGrpc.getGetAutoProtectionPolicyBindingMethod)
            == null) {
          BackupDRGrpc.getGetAutoProtectionPolicyBindingMethod =
              getGetAutoProtectionPolicyBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetAutoProtectionPolicyBindingRequest,
                          com.google.cloud.backupdr.v1.AutoProtectionPolicyBinding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAutoProtectionPolicyBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetAutoProtectionPolicyBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.AutoProtectionPolicyBinding
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("GetAutoProtectionPolicyBinding"))
                      .build();
        }
      }
    }
    return getGetAutoProtectionPolicyBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsRequest,
          com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsResponse>
      getListAutoProtectionPolicyBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAutoProtectionPolicyBindings",
      requestType = com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsRequest,
          com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsResponse>
      getListAutoProtectionPolicyBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsRequest,
            com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsResponse>
        getListAutoProtectionPolicyBindingsMethod;
    if ((getListAutoProtectionPolicyBindingsMethod =
            BackupDRGrpc.getListAutoProtectionPolicyBindingsMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListAutoProtectionPolicyBindingsMethod =
                BackupDRGrpc.getListAutoProtectionPolicyBindingsMethod)
            == null) {
          BackupDRGrpc.getListAutoProtectionPolicyBindingsMethod =
              getListAutoProtectionPolicyBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsRequest,
                          com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAutoProtectionPolicyBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListAutoProtectionPolicyBindings"))
                      .build();
        }
      }
    }
    return getListAutoProtectionPolicyBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesRequest,
          com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesResponse>
      getListAppliedAutoProtectionPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAppliedAutoProtectionPolicies",
      requestType = com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesRequest,
          com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesResponse>
      getListAppliedAutoProtectionPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesRequest,
            com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesResponse>
        getListAppliedAutoProtectionPoliciesMethod;
    if ((getListAppliedAutoProtectionPoliciesMethod =
            BackupDRGrpc.getListAppliedAutoProtectionPoliciesMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListAppliedAutoProtectionPoliciesMethod =
                BackupDRGrpc.getListAppliedAutoProtectionPoliciesMethod)
            == null) {
          BackupDRGrpc.getListAppliedAutoProtectionPoliciesMethod =
              getListAppliedAutoProtectionPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesRequest,
                          com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAppliedAutoProtectionPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListAppliedAutoProtectionPolicies"))
                      .build();
        }
      }
    }
    return getListAppliedAutoProtectionPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.InitiateDeleteAutoProtectionPolicyBindingRequest,
          com.google.longrunning.Operation>
      getInitiateDeleteAutoProtectionPolicyBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InitiateDeleteAutoProtectionPolicyBinding",
      requestType =
          com.google.cloud.backupdr.v1.InitiateDeleteAutoProtectionPolicyBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.InitiateDeleteAutoProtectionPolicyBindingRequest,
          com.google.longrunning.Operation>
      getInitiateDeleteAutoProtectionPolicyBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.InitiateDeleteAutoProtectionPolicyBindingRequest,
            com.google.longrunning.Operation>
        getInitiateDeleteAutoProtectionPolicyBindingMethod;
    if ((getInitiateDeleteAutoProtectionPolicyBindingMethod =
            BackupDRGrpc.getInitiateDeleteAutoProtectionPolicyBindingMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getInitiateDeleteAutoProtectionPolicyBindingMethod =
                BackupDRGrpc.getInitiateDeleteAutoProtectionPolicyBindingMethod)
            == null) {
          BackupDRGrpc.getInitiateDeleteAutoProtectionPolicyBindingMethod =
              getInitiateDeleteAutoProtectionPolicyBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1
                              .InitiateDeleteAutoProtectionPolicyBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "InitiateDeleteAutoProtectionPolicyBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1
                                  .InitiateDeleteAutoProtectionPolicyBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier(
                              "InitiateDeleteAutoProtectionPolicyBinding"))
                      .build();
        }
      }
    }
    return getInitiateDeleteAutoProtectionPolicyBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListBindingMatchingResourcesRequest,
          com.google.cloud.backupdr.v1.ListBindingMatchingResourcesResponse>
      getListBindingMatchingResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBindingMatchingResources",
      requestType = com.google.cloud.backupdr.v1.ListBindingMatchingResourcesRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListBindingMatchingResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListBindingMatchingResourcesRequest,
          com.google.cloud.backupdr.v1.ListBindingMatchingResourcesResponse>
      getListBindingMatchingResourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListBindingMatchingResourcesRequest,
            com.google.cloud.backupdr.v1.ListBindingMatchingResourcesResponse>
        getListBindingMatchingResourcesMethod;
    if ((getListBindingMatchingResourcesMethod = BackupDRGrpc.getListBindingMatchingResourcesMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListBindingMatchingResourcesMethod =
                BackupDRGrpc.getListBindingMatchingResourcesMethod)
            == null) {
          BackupDRGrpc.getListBindingMatchingResourcesMethod =
              getListBindingMatchingResourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListBindingMatchingResourcesRequest,
                          com.google.cloud.backupdr.v1.ListBindingMatchingResourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBindingMatchingResources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListBindingMatchingResourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListBindingMatchingResourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListBindingMatchingResources"))
                      .build();
        }
      }
    }
    return getListBindingMatchingResourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateRestoreTemplateRequest,
          com.google.longrunning.Operation>
      getCreateRestoreTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRestoreTemplate",
      requestType = com.google.cloud.backupdr.v1.CreateRestoreTemplateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateRestoreTemplateRequest,
          com.google.longrunning.Operation>
      getCreateRestoreTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.CreateRestoreTemplateRequest,
            com.google.longrunning.Operation>
        getCreateRestoreTemplateMethod;
    if ((getCreateRestoreTemplateMethod = BackupDRGrpc.getCreateRestoreTemplateMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getCreateRestoreTemplateMethod = BackupDRGrpc.getCreateRestoreTemplateMethod)
            == null) {
          BackupDRGrpc.getCreateRestoreTemplateMethod =
              getCreateRestoreTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.CreateRestoreTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateRestoreTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.CreateRestoreTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("CreateRestoreTemplate"))
                      .build();
        }
      }
    }
    return getCreateRestoreTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetRestoreTemplateRequest,
          com.google.cloud.backupdr.v1.RestoreTemplate>
      getGetRestoreTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRestoreTemplate",
      requestType = com.google.cloud.backupdr.v1.GetRestoreTemplateRequest.class,
      responseType = com.google.cloud.backupdr.v1.RestoreTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetRestoreTemplateRequest,
          com.google.cloud.backupdr.v1.RestoreTemplate>
      getGetRestoreTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetRestoreTemplateRequest,
            com.google.cloud.backupdr.v1.RestoreTemplate>
        getGetRestoreTemplateMethod;
    if ((getGetRestoreTemplateMethod = BackupDRGrpc.getGetRestoreTemplateMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetRestoreTemplateMethod = BackupDRGrpc.getGetRestoreTemplateMethod) == null) {
          BackupDRGrpc.getGetRestoreTemplateMethod =
              getGetRestoreTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetRestoreTemplateRequest,
                          com.google.cloud.backupdr.v1.RestoreTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRestoreTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetRestoreTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.RestoreTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("GetRestoreTemplate"))
                      .build();
        }
      }
    }
    return getGetRestoreTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListRestoreTemplatesRequest,
          com.google.cloud.backupdr.v1.ListRestoreTemplatesResponse>
      getListRestoreTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRestoreTemplates",
      requestType = com.google.cloud.backupdr.v1.ListRestoreTemplatesRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListRestoreTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListRestoreTemplatesRequest,
          com.google.cloud.backupdr.v1.ListRestoreTemplatesResponse>
      getListRestoreTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListRestoreTemplatesRequest,
            com.google.cloud.backupdr.v1.ListRestoreTemplatesResponse>
        getListRestoreTemplatesMethod;
    if ((getListRestoreTemplatesMethod = BackupDRGrpc.getListRestoreTemplatesMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListRestoreTemplatesMethod = BackupDRGrpc.getListRestoreTemplatesMethod) == null) {
          BackupDRGrpc.getListRestoreTemplatesMethod =
              getListRestoreTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListRestoreTemplatesRequest,
                          com.google.cloud.backupdr.v1.ListRestoreTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListRestoreTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListRestoreTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListRestoreTemplatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListRestoreTemplates"))
                      .build();
        }
      }
    }
    return getListRestoreTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.UpdateRestoreTemplateRequest,
          com.google.longrunning.Operation>
      getUpdateRestoreTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRestoreTemplate",
      requestType = com.google.cloud.backupdr.v1.UpdateRestoreTemplateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.UpdateRestoreTemplateRequest,
          com.google.longrunning.Operation>
      getUpdateRestoreTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.UpdateRestoreTemplateRequest,
            com.google.longrunning.Operation>
        getUpdateRestoreTemplateMethod;
    if ((getUpdateRestoreTemplateMethod = BackupDRGrpc.getUpdateRestoreTemplateMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getUpdateRestoreTemplateMethod = BackupDRGrpc.getUpdateRestoreTemplateMethod)
            == null) {
          BackupDRGrpc.getUpdateRestoreTemplateMethod =
              getUpdateRestoreTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.UpdateRestoreTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateRestoreTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.UpdateRestoreTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("UpdateRestoreTemplate"))
                      .build();
        }
      }
    }
    return getUpdateRestoreTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteRestoreTemplateRequest,
          com.google.longrunning.Operation>
      getDeleteRestoreTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRestoreTemplate",
      requestType = com.google.cloud.backupdr.v1.DeleteRestoreTemplateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteRestoreTemplateRequest,
          com.google.longrunning.Operation>
      getDeleteRestoreTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.DeleteRestoreTemplateRequest,
            com.google.longrunning.Operation>
        getDeleteRestoreTemplateMethod;
    if ((getDeleteRestoreTemplateMethod = BackupDRGrpc.getDeleteRestoreTemplateMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteRestoreTemplateMethod = BackupDRGrpc.getDeleteRestoreTemplateMethod)
            == null) {
          BackupDRGrpc.getDeleteRestoreTemplateMethod =
              getDeleteRestoreTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.DeleteRestoreTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteRestoreTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.DeleteRestoreTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("DeleteRestoreTemplate"))
                      .build();
        }
      }
    }
    return getDeleteRestoreTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.RunRestoreTemplateRequest, com.google.longrunning.Operation>
      getRunRestoreTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunRestoreTemplate",
      requestType = com.google.cloud.backupdr.v1.RunRestoreTemplateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.RunRestoreTemplateRequest, com.google.longrunning.Operation>
      getRunRestoreTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.RunRestoreTemplateRequest,
            com.google.longrunning.Operation>
        getRunRestoreTemplateMethod;
    if ((getRunRestoreTemplateMethod = BackupDRGrpc.getRunRestoreTemplateMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getRunRestoreTemplateMethod = BackupDRGrpc.getRunRestoreTemplateMethod) == null) {
          BackupDRGrpc.getRunRestoreTemplateMethod =
              getRunRestoreTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.RunRestoreTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunRestoreTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.RunRestoreTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("RunRestoreTemplate"))
                      .build();
        }
      }
    }
    return getRunRestoreTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetRestoreTemplateExecutionRequest,
          com.google.cloud.backupdr.v1.RestoreTemplateExecution>
      getGetRestoreTemplateExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRestoreTemplateExecution",
      requestType = com.google.cloud.backupdr.v1.GetRestoreTemplateExecutionRequest.class,
      responseType = com.google.cloud.backupdr.v1.RestoreTemplateExecution.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetRestoreTemplateExecutionRequest,
          com.google.cloud.backupdr.v1.RestoreTemplateExecution>
      getGetRestoreTemplateExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetRestoreTemplateExecutionRequest,
            com.google.cloud.backupdr.v1.RestoreTemplateExecution>
        getGetRestoreTemplateExecutionMethod;
    if ((getGetRestoreTemplateExecutionMethod = BackupDRGrpc.getGetRestoreTemplateExecutionMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetRestoreTemplateExecutionMethod =
                BackupDRGrpc.getGetRestoreTemplateExecutionMethod)
            == null) {
          BackupDRGrpc.getGetRestoreTemplateExecutionMethod =
              getGetRestoreTemplateExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetRestoreTemplateExecutionRequest,
                          com.google.cloud.backupdr.v1.RestoreTemplateExecution>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetRestoreTemplateExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetRestoreTemplateExecutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.RestoreTemplateExecution
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("GetRestoreTemplateExecution"))
                      .build();
        }
      }
    }
    return getGetRestoreTemplateExecutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsRequest,
          com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsResponse>
      getListRestoreTemplateExecutionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRestoreTemplateExecutions",
      requestType = com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsRequest,
          com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsResponse>
      getListRestoreTemplateExecutionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsRequest,
            com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsResponse>
        getListRestoreTemplateExecutionsMethod;
    if ((getListRestoreTemplateExecutionsMethod =
            BackupDRGrpc.getListRestoreTemplateExecutionsMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListRestoreTemplateExecutionsMethod =
                BackupDRGrpc.getListRestoreTemplateExecutionsMethod)
            == null) {
          BackupDRGrpc.getListRestoreTemplateExecutionsMethod =
              getListRestoreTemplateExecutionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsRequest,
                          com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListRestoreTemplateExecutions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListRestoreTemplateExecutions"))
                      .build();
        }
      }
    }
    return getListRestoreTemplateExecutionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.TriggerRestoreCleanupRequest,
          com.google.longrunning.Operation>
      getTriggerRestoreCleanupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TriggerRestoreCleanup",
      requestType = com.google.cloud.backupdr.v1.TriggerRestoreCleanupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.TriggerRestoreCleanupRequest,
          com.google.longrunning.Operation>
      getTriggerRestoreCleanupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.TriggerRestoreCleanupRequest,
            com.google.longrunning.Operation>
        getTriggerRestoreCleanupMethod;
    if ((getTriggerRestoreCleanupMethod = BackupDRGrpc.getTriggerRestoreCleanupMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getTriggerRestoreCleanupMethod = BackupDRGrpc.getTriggerRestoreCleanupMethod)
            == null) {
          BackupDRGrpc.getTriggerRestoreCleanupMethod =
              getTriggerRestoreCleanupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.TriggerRestoreCleanupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "TriggerRestoreCleanup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.TriggerRestoreCleanupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("TriggerRestoreCleanup"))
                      .build();
        }
      }
    }
    return getTriggerRestoreCleanupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanRequest,
          com.google.longrunning.Operation>
      getCreateRestoreVerificationPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRestoreVerificationPlan",
      requestType = com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanRequest,
          com.google.longrunning.Operation>
      getCreateRestoreVerificationPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanRequest,
            com.google.longrunning.Operation>
        getCreateRestoreVerificationPlanMethod;
    if ((getCreateRestoreVerificationPlanMethod =
            BackupDRGrpc.getCreateRestoreVerificationPlanMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getCreateRestoreVerificationPlanMethod =
                BackupDRGrpc.getCreateRestoreVerificationPlanMethod)
            == null) {
          BackupDRGrpc.getCreateRestoreVerificationPlanMethod =
              getCreateRestoreVerificationPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateRestoreVerificationPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("CreateRestoreVerificationPlan"))
                      .build();
        }
      }
    }
    return getCreateRestoreVerificationPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanAssociationRequest,
          com.google.longrunning.Operation>
      getCreateRestoreVerificationPlanAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRestoreVerificationPlanAssociation",
      requestType =
          com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanAssociationRequest,
          com.google.longrunning.Operation>
      getCreateRestoreVerificationPlanAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanAssociationRequest,
            com.google.longrunning.Operation>
        getCreateRestoreVerificationPlanAssociationMethod;
    if ((getCreateRestoreVerificationPlanAssociationMethod =
            BackupDRGrpc.getCreateRestoreVerificationPlanAssociationMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getCreateRestoreVerificationPlanAssociationMethod =
                BackupDRGrpc.getCreateRestoreVerificationPlanAssociationMethod)
            == null) {
          BackupDRGrpc.getCreateRestoreVerificationPlanAssociationMethod =
              getCreateRestoreVerificationPlanAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1
                              .CreateRestoreVerificationPlanAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CreateRestoreVerificationPlanAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1
                                  .CreateRestoreVerificationPlanAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier(
                              "CreateRestoreVerificationPlanAssociation"))
                      .build();
        }
      }
    }
    return getCreateRestoreVerificationPlanAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetRestoreVerificationPlanAssociationRequest,
          com.google.cloud.backupdr.v1.RestoreVerificationPlanAssociation>
      getGetRestoreVerificationPlanAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRestoreVerificationPlanAssociation",
      requestType = com.google.cloud.backupdr.v1.GetRestoreVerificationPlanAssociationRequest.class,
      responseType = com.google.cloud.backupdr.v1.RestoreVerificationPlanAssociation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetRestoreVerificationPlanAssociationRequest,
          com.google.cloud.backupdr.v1.RestoreVerificationPlanAssociation>
      getGetRestoreVerificationPlanAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetRestoreVerificationPlanAssociationRequest,
            com.google.cloud.backupdr.v1.RestoreVerificationPlanAssociation>
        getGetRestoreVerificationPlanAssociationMethod;
    if ((getGetRestoreVerificationPlanAssociationMethod =
            BackupDRGrpc.getGetRestoreVerificationPlanAssociationMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetRestoreVerificationPlanAssociationMethod =
                BackupDRGrpc.getGetRestoreVerificationPlanAssociationMethod)
            == null) {
          BackupDRGrpc.getGetRestoreVerificationPlanAssociationMethod =
              getGetRestoreVerificationPlanAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetRestoreVerificationPlanAssociationRequest,
                          com.google.cloud.backupdr.v1.RestoreVerificationPlanAssociation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetRestoreVerificationPlanAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1
                                  .GetRestoreVerificationPlanAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.RestoreVerificationPlanAssociation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier(
                              "GetRestoreVerificationPlanAssociation"))
                      .build();
        }
      }
    }
    return getGetRestoreVerificationPlanAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsRequest,
          com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsResponse>
      getListRestoreVerificationPlanAssociationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRestoreVerificationPlanAssociations",
      requestType =
          com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsRequest.class,
      responseType =
          com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsRequest,
          com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsResponse>
      getListRestoreVerificationPlanAssociationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsRequest,
            com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsResponse>
        getListRestoreVerificationPlanAssociationsMethod;
    if ((getListRestoreVerificationPlanAssociationsMethod =
            BackupDRGrpc.getListRestoreVerificationPlanAssociationsMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListRestoreVerificationPlanAssociationsMethod =
                BackupDRGrpc.getListRestoreVerificationPlanAssociationsMethod)
            == null) {
          BackupDRGrpc.getListRestoreVerificationPlanAssociationsMethod =
              getListRestoreVerificationPlanAssociationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsRequest,
                          com.google.cloud.backupdr.v1
                              .ListRestoreVerificationPlanAssociationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListRestoreVerificationPlanAssociations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1
                                  .ListRestoreVerificationPlanAssociationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1
                                  .ListRestoreVerificationPlanAssociationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier(
                              "ListRestoreVerificationPlanAssociations"))
                      .build();
        }
      }
    }
    return getListRestoreVerificationPlanAssociationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanAssociationRequest,
          com.google.longrunning.Operation>
      getDeleteRestoreVerificationPlanAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRestoreVerificationPlanAssociation",
      requestType =
          com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanAssociationRequest,
          com.google.longrunning.Operation>
      getDeleteRestoreVerificationPlanAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanAssociationRequest,
            com.google.longrunning.Operation>
        getDeleteRestoreVerificationPlanAssociationMethod;
    if ((getDeleteRestoreVerificationPlanAssociationMethod =
            BackupDRGrpc.getDeleteRestoreVerificationPlanAssociationMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteRestoreVerificationPlanAssociationMethod =
                BackupDRGrpc.getDeleteRestoreVerificationPlanAssociationMethod)
            == null) {
          BackupDRGrpc.getDeleteRestoreVerificationPlanAssociationMethod =
              getDeleteRestoreVerificationPlanAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1
                              .DeleteRestoreVerificationPlanAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DeleteRestoreVerificationPlanAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1
                                  .DeleteRestoreVerificationPlanAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier(
                              "DeleteRestoreVerificationPlanAssociation"))
                      .build();
        }
      }
    }
    return getDeleteRestoreVerificationPlanAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.TriggerRestoreVerificationRequest,
          com.google.longrunning.Operation>
      getTriggerRestoreVerificationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TriggerRestoreVerification",
      requestType = com.google.cloud.backupdr.v1.TriggerRestoreVerificationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.TriggerRestoreVerificationRequest,
          com.google.longrunning.Operation>
      getTriggerRestoreVerificationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.TriggerRestoreVerificationRequest,
            com.google.longrunning.Operation>
        getTriggerRestoreVerificationMethod;
    if ((getTriggerRestoreVerificationMethod = BackupDRGrpc.getTriggerRestoreVerificationMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getTriggerRestoreVerificationMethod = BackupDRGrpc.getTriggerRestoreVerificationMethod)
            == null) {
          BackupDRGrpc.getTriggerRestoreVerificationMethod =
              getTriggerRestoreVerificationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.TriggerRestoreVerificationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "TriggerRestoreVerification"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.TriggerRestoreVerificationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("TriggerRestoreVerification"))
                      .build();
        }
      }
    }
    return getTriggerRestoreVerificationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetRestoreVerificationPlanRequest,
          com.google.cloud.backupdr.v1.RestoreVerificationPlan>
      getGetRestoreVerificationPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRestoreVerificationPlan",
      requestType = com.google.cloud.backupdr.v1.GetRestoreVerificationPlanRequest.class,
      responseType = com.google.cloud.backupdr.v1.RestoreVerificationPlan.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetRestoreVerificationPlanRequest,
          com.google.cloud.backupdr.v1.RestoreVerificationPlan>
      getGetRestoreVerificationPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetRestoreVerificationPlanRequest,
            com.google.cloud.backupdr.v1.RestoreVerificationPlan>
        getGetRestoreVerificationPlanMethod;
    if ((getGetRestoreVerificationPlanMethod = BackupDRGrpc.getGetRestoreVerificationPlanMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetRestoreVerificationPlanMethod = BackupDRGrpc.getGetRestoreVerificationPlanMethod)
            == null) {
          BackupDRGrpc.getGetRestoreVerificationPlanMethod =
              getGetRestoreVerificationPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetRestoreVerificationPlanRequest,
                          com.google.cloud.backupdr.v1.RestoreVerificationPlan>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetRestoreVerificationPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetRestoreVerificationPlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.RestoreVerificationPlan
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("GetRestoreVerificationPlan"))
                      .build();
        }
      }
    }
    return getGetRestoreVerificationPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListRestoreVerificationPlansRequest,
          com.google.cloud.backupdr.v1.ListRestoreVerificationPlansResponse>
      getListRestoreVerificationPlansMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRestoreVerificationPlans",
      requestType = com.google.cloud.backupdr.v1.ListRestoreVerificationPlansRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListRestoreVerificationPlansResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListRestoreVerificationPlansRequest,
          com.google.cloud.backupdr.v1.ListRestoreVerificationPlansResponse>
      getListRestoreVerificationPlansMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListRestoreVerificationPlansRequest,
            com.google.cloud.backupdr.v1.ListRestoreVerificationPlansResponse>
        getListRestoreVerificationPlansMethod;
    if ((getListRestoreVerificationPlansMethod = BackupDRGrpc.getListRestoreVerificationPlansMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListRestoreVerificationPlansMethod =
                BackupDRGrpc.getListRestoreVerificationPlansMethod)
            == null) {
          BackupDRGrpc.getListRestoreVerificationPlansMethod =
              getListRestoreVerificationPlansMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListRestoreVerificationPlansRequest,
                          com.google.cloud.backupdr.v1.ListRestoreVerificationPlansResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListRestoreVerificationPlans"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListRestoreVerificationPlansRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListRestoreVerificationPlansResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListRestoreVerificationPlans"))
                      .build();
        }
      }
    }
    return getListRestoreVerificationPlansMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanRequest,
          com.google.longrunning.Operation>
      getDeleteRestoreVerificationPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRestoreVerificationPlan",
      requestType = com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanRequest,
          com.google.longrunning.Operation>
      getDeleteRestoreVerificationPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanRequest,
            com.google.longrunning.Operation>
        getDeleteRestoreVerificationPlanMethod;
    if ((getDeleteRestoreVerificationPlanMethod =
            BackupDRGrpc.getDeleteRestoreVerificationPlanMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteRestoreVerificationPlanMethod =
                BackupDRGrpc.getDeleteRestoreVerificationPlanMethod)
            == null) {
          BackupDRGrpc.getDeleteRestoreVerificationPlanMethod =
              getDeleteRestoreVerificationPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteRestoreVerificationPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("DeleteRestoreVerificationPlan"))
                      .build();
        }
      }
    }
    return getDeleteRestoreVerificationPlanMethod;
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

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static BackupDRBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupDRBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupDRBlockingV2Stub>() {
          @java.lang.Override
          public BackupDRBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupDRBlockingV2Stub(channel, callOptions);
          }
        };
    return BackupDRBlockingV2Stub.newStub(factory, channel);
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
     * Fetch Backups for a given resource type.
     * </pre>
     */
    default void fetchBackupsForResourceType(
        com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchBackupsForResourceTypeMethod(), responseObserver);
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
     * Update a BackupPlan.
     * </pre>
     */
    default void updateBackupPlan(
        com.google.cloud.backupdr.v1.UpdateBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupPlanMethod(), responseObserver);
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
     * Gets details of a single BackupPlanRevision.
     * </pre>
     */
    default void getBackupPlanRevision(
        com.google.cloud.backupdr.v1.GetBackupPlanRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.BackupPlanRevision>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBackupPlanRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlanRevisions in a given project and location.
     * </pre>
     */
    default void listBackupPlanRevisions(
        com.google.cloud.backupdr.v1.ListBackupPlanRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListBackupPlanRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupPlanRevisionsMethod(), responseObserver);
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
     * Update a BackupPlanAssociation.
     * </pre>
     */
    default void updateBackupPlanAssociation(
        com.google.cloud.backupdr.v1.UpdateBackupPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupPlanAssociationMethod(), responseObserver);
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
     * List BackupPlanAssociations for a given resource type.
     * </pre>
     */
    default void fetchBackupPlanAssociationsForResourceType(
        com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchBackupPlanAssociationsForResourceTypeMethod(), responseObserver);
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
     * Gets details of a single DataSourceReference.
     * </pre>
     */
    default void getDataSourceReference(
        com.google.cloud.backupdr.v1.GetDataSourceReferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.DataSourceReference>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataSourceReferenceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataSourceReferences for a given project and location.
     * </pre>
     */
    default void listDataSourceReferences(
        com.google.cloud.backupdr.v1.ListDataSourceReferencesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListDataSourceReferencesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataSourceReferencesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetch DataSourceReferences for a given project, location and resource type.
     * </pre>
     */
    default void fetchDataSourceReferencesForResourceType(
        com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchDataSourceReferencesForResourceTypeMethod(), responseObserver);
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

    /**
     *
     *
     * <pre>
     * Creates a new AutoProtectionPolicy in a given project and location.
     * </pre>
     */
    default void createAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAutoProtectionPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AutoProtectionPolicies for a given project and location.
     * </pre>
     */
    default void listAutoProtectionPolicies(
        com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAutoProtectionPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AutoProtectionPolicy.
     * </pre>
     */
    default void getAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.GetAutoProtectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.AutoProtectionPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAutoProtectionPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AutoProtectionPolicy.
     * </pre>
     */
    default void updateAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.UpdateAutoProtectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAutoProtectionPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AutoProtectionPolicy.
     * </pre>
     */
    default void deleteAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.DeleteAutoProtectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAutoProtectionPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AutoProtectionPolicyBinding in a given project and
     * location.
     * </pre>
     */
    default void createAutoProtectionPolicyBinding(
        com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAutoProtectionPolicyBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the auto protection policy binding read from the CCFE tables.
     * </pre>
     */
    default void getAutoProtectionPolicyBinding(
        com.google.cloud.backupdr.v1.GetAutoProtectionPolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.AutoProtectionPolicyBinding>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAutoProtectionPolicyBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the auto protection policy bindings read from the CCFE tables.
     * </pre>
     */
    default void listAutoProtectionPolicyBindings(
        com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAutoProtectionPolicyBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AppliedAutoProtectionPolicies in a given project and location.
     * </pre>
     */
    default void listAppliedAutoProtectionPolicies(
        com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAppliedAutoProtectionPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * InitiateDeleteAutoProtectionPolicyBinding initiates delete for
     * AutoProtectionPolicy Binding
     * </pre>
     */
    default void initiateDeleteAutoProtectionPolicyBinding(
        com.google.cloud.backupdr.v1.InitiateDeleteAutoProtectionPolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInitiateDeleteAutoProtectionPolicyBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Binding Matching Resources for a given AutoProtectionPolicyBinding.
     * </pre>
     */
    default void listBindingMatchingResources(
        com.google.cloud.backupdr.v1.ListBindingMatchingResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.ListBindingMatchingResourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBindingMatchingResourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreTemplate in a given project and location.
     * </pre>
     */
    default void createRestoreTemplate(
        com.google.cloud.backupdr.v1.CreateRestoreTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRestoreTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a RestoreTemplate.
     * </pre>
     */
    default void getRestoreTemplate(
        com.google.cloud.backupdr.v1.GetRestoreTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.RestoreTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRestoreTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreTemplates in a given project and location.
     * </pre>
     */
    default void listRestoreTemplates(
        com.google.cloud.backupdr.v1.ListRestoreTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListRestoreTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRestoreTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a RestoreTemplate.
     * </pre>
     */
    default void updateRestoreTemplate(
        com.google.cloud.backupdr.v1.UpdateRestoreTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRestoreTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RestoreTemplate.
     * </pre>
     */
    default void deleteRestoreTemplate(
        com.google.cloud.backupdr.v1.DeleteRestoreTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRestoreTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs a RestoreTemplate.
     * </pre>
     */
    default void runRestoreTemplate(
        com.google.cloud.backupdr.v1.RunRestoreTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunRestoreTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a RestoreTemplateExecution.
     * </pre>
     */
    default void getRestoreTemplateExecution(
        com.google.cloud.backupdr.v1.GetRestoreTemplateExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.RestoreTemplateExecution>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRestoreTemplateExecutionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreTemplateExecutions in a given project, location and restore
     * template.
     * </pre>
     */
    default void listRestoreTemplateExecutions(
        com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRestoreTemplateExecutionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Triggers cleanup of restored resources created during execution.
     * </pre>
     */
    default void triggerRestoreCleanup(
        com.google.cloud.backupdr.v1.TriggerRestoreCleanupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTriggerRestoreCleanupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreVerificationPlan in a given project and location.
     * </pre>
     */
    default void createRestoreVerificationPlan(
        com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRestoreVerificationPlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    default void createRestoreVerificationPlanAssociation(
        com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRestoreVerificationPlanAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    default void getRestoreVerificationPlanAssociation(
        com.google.cloud.backupdr.v1.GetRestoreVerificationPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.RestoreVerificationPlanAssociation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRestoreVerificationPlanAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreVerificationPlanAssociations in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    default void listRestoreVerificationPlanAssociations(
        com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRestoreVerificationPlanAssociationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    default void deleteRestoreVerificationPlanAssociation(
        com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRestoreVerificationPlanAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Triggers a new Restore Verification for the association in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    default void triggerRestoreVerification(
        com.google.cloud.backupdr.v1.TriggerRestoreVerificationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTriggerRestoreVerificationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RestoreVerificationPlan. Returns the requested
     * RestoreVerificationPlan.
     * </pre>
     */
    default void getRestoreVerificationPlan(
        com.google.cloud.backupdr.v1.GetRestoreVerificationPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.RestoreVerificationPlan>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRestoreVerificationPlanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreVerificationPlans in a given project and location.
     * </pre>
     */
    default void listRestoreVerificationPlans(
        com.google.cloud.backupdr.v1.ListRestoreVerificationPlansRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.ListRestoreVerificationPlansResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRestoreVerificationPlansMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RestoreVerificationPlan. If the `force` flag is set to
     * `true`, any RestoreVerificationPlanAssociations linked to this
     * RestoreVerificationPlan will also be deleted.
     * </pre>
     */
    default void deleteRestoreVerificationPlan(
        com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRestoreVerificationPlanMethod(), responseObserver);
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
     * Fetch Backups for a given resource type.
     * </pre>
     */
    public void fetchBackupsForResourceType(
        com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchBackupsForResourceTypeMethod(), getCallOptions()),
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
     * Update a BackupPlan.
     * </pre>
     */
    public void updateBackupPlan(
        com.google.cloud.backupdr.v1.UpdateBackupPlanRequest request,
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
     * Gets details of a single BackupPlanRevision.
     * </pre>
     */
    public void getBackupPlanRevision(
        com.google.cloud.backupdr.v1.GetBackupPlanRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.BackupPlanRevision>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupPlanRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlanRevisions in a given project and location.
     * </pre>
     */
    public void listBackupPlanRevisions(
        com.google.cloud.backupdr.v1.ListBackupPlanRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListBackupPlanRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupPlanRevisionsMethod(), getCallOptions()),
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
     * Update a BackupPlanAssociation.
     * </pre>
     */
    public void updateBackupPlanAssociation(
        com.google.cloud.backupdr.v1.UpdateBackupPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBackupPlanAssociationMethod(), getCallOptions()),
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
     * List BackupPlanAssociations for a given resource type.
     * </pre>
     */
    public void fetchBackupPlanAssociationsForResourceType(
        com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getFetchBackupPlanAssociationsForResourceTypeMethod(), getCallOptions()),
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
     * Gets details of a single DataSourceReference.
     * </pre>
     */
    public void getDataSourceReference(
        com.google.cloud.backupdr.v1.GetDataSourceReferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.DataSourceReference>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataSourceReferenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataSourceReferences for a given project and location.
     * </pre>
     */
    public void listDataSourceReferences(
        com.google.cloud.backupdr.v1.ListDataSourceReferencesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListDataSourceReferencesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataSourceReferencesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetch DataSourceReferences for a given project, location and resource type.
     * </pre>
     */
    public void fetchDataSourceReferencesForResourceType(
        com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getFetchDataSourceReferencesForResourceTypeMethod(), getCallOptions()),
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

    /**
     *
     *
     * <pre>
     * Creates a new AutoProtectionPolicy in a given project and location.
     * </pre>
     */
    public void createAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAutoProtectionPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AutoProtectionPolicies for a given project and location.
     * </pre>
     */
    public void listAutoProtectionPolicies(
        com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAutoProtectionPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AutoProtectionPolicy.
     * </pre>
     */
    public void getAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.GetAutoProtectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.AutoProtectionPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAutoProtectionPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AutoProtectionPolicy.
     * </pre>
     */
    public void updateAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.UpdateAutoProtectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAutoProtectionPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AutoProtectionPolicy.
     * </pre>
     */
    public void deleteAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.DeleteAutoProtectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAutoProtectionPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AutoProtectionPolicyBinding in a given project and
     * location.
     * </pre>
     */
    public void createAutoProtectionPolicyBinding(
        com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAutoProtectionPolicyBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the auto protection policy binding read from the CCFE tables.
     * </pre>
     */
    public void getAutoProtectionPolicyBinding(
        com.google.cloud.backupdr.v1.GetAutoProtectionPolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.AutoProtectionPolicyBinding>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAutoProtectionPolicyBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the auto protection policy bindings read from the CCFE tables.
     * </pre>
     */
    public void listAutoProtectionPolicyBindings(
        com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAutoProtectionPolicyBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists AppliedAutoProtectionPolicies in a given project and location.
     * </pre>
     */
    public void listAppliedAutoProtectionPolicies(
        com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAppliedAutoProtectionPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * InitiateDeleteAutoProtectionPolicyBinding initiates delete for
     * AutoProtectionPolicy Binding
     * </pre>
     */
    public void initiateDeleteAutoProtectionPolicyBinding(
        com.google.cloud.backupdr.v1.InitiateDeleteAutoProtectionPolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getInitiateDeleteAutoProtectionPolicyBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Binding Matching Resources for a given AutoProtectionPolicyBinding.
     * </pre>
     */
    public void listBindingMatchingResources(
        com.google.cloud.backupdr.v1.ListBindingMatchingResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.ListBindingMatchingResourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBindingMatchingResourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreTemplate in a given project and location.
     * </pre>
     */
    public void createRestoreTemplate(
        com.google.cloud.backupdr.v1.CreateRestoreTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRestoreTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a RestoreTemplate.
     * </pre>
     */
    public void getRestoreTemplate(
        com.google.cloud.backupdr.v1.GetRestoreTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.RestoreTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRestoreTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreTemplates in a given project and location.
     * </pre>
     */
    public void listRestoreTemplates(
        com.google.cloud.backupdr.v1.ListRestoreTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListRestoreTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRestoreTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a RestoreTemplate.
     * </pre>
     */
    public void updateRestoreTemplate(
        com.google.cloud.backupdr.v1.UpdateRestoreTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRestoreTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RestoreTemplate.
     * </pre>
     */
    public void deleteRestoreTemplate(
        com.google.cloud.backupdr.v1.DeleteRestoreTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRestoreTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs a RestoreTemplate.
     * </pre>
     */
    public void runRestoreTemplate(
        com.google.cloud.backupdr.v1.RunRestoreTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunRestoreTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a RestoreTemplateExecution.
     * </pre>
     */
    public void getRestoreTemplateExecution(
        com.google.cloud.backupdr.v1.GetRestoreTemplateExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.RestoreTemplateExecution>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRestoreTemplateExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreTemplateExecutions in a given project, location and restore
     * template.
     * </pre>
     */
    public void listRestoreTemplateExecutions(
        com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRestoreTemplateExecutionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Triggers cleanup of restored resources created during execution.
     * </pre>
     */
    public void triggerRestoreCleanup(
        com.google.cloud.backupdr.v1.TriggerRestoreCleanupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTriggerRestoreCleanupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreVerificationPlan in a given project and location.
     * </pre>
     */
    public void createRestoreVerificationPlan(
        com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRestoreVerificationPlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public void createRestoreVerificationPlanAssociation(
        com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getCreateRestoreVerificationPlanAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public void getRestoreVerificationPlanAssociation(
        com.google.cloud.backupdr.v1.GetRestoreVerificationPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.RestoreVerificationPlanAssociation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRestoreVerificationPlanAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreVerificationPlanAssociations in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public void listRestoreVerificationPlanAssociations(
        com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getListRestoreVerificationPlanAssociationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public void deleteRestoreVerificationPlanAssociation(
        com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getDeleteRestoreVerificationPlanAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Triggers a new Restore Verification for the association in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public void triggerRestoreVerification(
        com.google.cloud.backupdr.v1.TriggerRestoreVerificationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTriggerRestoreVerificationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RestoreVerificationPlan. Returns the requested
     * RestoreVerificationPlan.
     * </pre>
     */
    public void getRestoreVerificationPlan(
        com.google.cloud.backupdr.v1.GetRestoreVerificationPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.RestoreVerificationPlan>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRestoreVerificationPlanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreVerificationPlans in a given project and location.
     * </pre>
     */
    public void listRestoreVerificationPlans(
        com.google.cloud.backupdr.v1.ListRestoreVerificationPlansRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1.ListRestoreVerificationPlansResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRestoreVerificationPlansMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RestoreVerificationPlan. If the `force` flag is set to
     * `true`, any RestoreVerificationPlanAssociations linked to this
     * RestoreVerificationPlan will also be deleted.
     * </pre>
     */
    public void deleteRestoreVerificationPlan(
        com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRestoreVerificationPlanMethod(), getCallOptions()),
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
  public static final class BackupDRBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<BackupDRBlockingV2Stub> {
    private BackupDRBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupDRBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupDRBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ManagementServers in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListManagementServersResponse listManagementServers(
        com.google.cloud.backupdr.v1.ListManagementServersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.GetManagementServerRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.CreateManagementServerRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.DeleteManagementServerRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.CreateBackupVaultRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.ListBackupVaultsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.FetchUsableBackupVaultsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.GetBackupVaultRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.UpdateBackupVaultRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.DeleteBackupVaultRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.ListDataSourcesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.GetDataSourceRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.UpdateDataSourceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.ListBackupsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetch Backups for a given resource type.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeResponse
        fetchBackupsForResourceType(
            com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFetchBackupsForResourceTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a Backup.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.Backup getBackup(
        com.google.cloud.backupdr.v1.GetBackupRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.UpdateBackupRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.DeleteBackupRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.RestoreBackupRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.CreateBackupPlanRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateBackupPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a BackupPlan.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackupPlan(
        com.google.cloud.backupdr.v1.UpdateBackupPlanRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateBackupPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackupPlan.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.BackupPlan getBackupPlan(
        com.google.cloud.backupdr.v1.GetBackupPlanRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.ListBackupPlansRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.DeleteBackupPlanRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteBackupPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackupPlanRevision.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.BackupPlanRevision getBackupPlanRevision(
        com.google.cloud.backupdr.v1.GetBackupPlanRevisionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBackupPlanRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlanRevisions in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListBackupPlanRevisionsResponse listBackupPlanRevisions(
        com.google.cloud.backupdr.v1.ListBackupPlanRevisionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBackupPlanRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a BackupPlanAssociation
     * </pre>
     */
    public com.google.longrunning.Operation createBackupPlanAssociation(
        com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateBackupPlanAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a BackupPlanAssociation.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackupPlanAssociation(
        com.google.cloud.backupdr.v1.UpdateBackupPlanAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateBackupPlanAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single BackupPlanAssociation.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.BackupPlanAssociation getBackupPlanAssociation(
        com.google.cloud.backupdr.v1.GetBackupPlanAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
            com.google.cloud.backupdr.v1.ListBackupPlanAssociationsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBackupPlanAssociationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List BackupPlanAssociations for a given resource type.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeResponse
        fetchBackupPlanAssociationsForResourceType(
            com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getFetchBackupPlanAssociationsForResourceTypeMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single BackupPlanAssociation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackupPlanAssociation(
        com.google.cloud.backupdr.v1.DeleteBackupPlanAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.backupdr.v1.TriggerBackupRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTriggerBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DataSourceReference.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.DataSourceReference getDataSourceReference(
        com.google.cloud.backupdr.v1.GetDataSourceReferenceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDataSourceReferenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataSourceReferences for a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListDataSourceReferencesResponse listDataSourceReferences(
        com.google.cloud.backupdr.v1.ListDataSourceReferencesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDataSourceReferencesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetch DataSourceReferences for a given project, location and resource type.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeResponse
        fetchDataSourceReferencesForResourceType(
            com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getFetchDataSourceReferencesForResourceTypeMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Initializes the service related config for a project.
     * </pre>
     */
    public com.google.longrunning.Operation initializeService(
        com.google.cloud.backupdr.v1.InitializeServiceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getInitializeServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AutoProtectionPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAutoProtectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AutoProtectionPolicies for a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesResponse
        listAutoProtectionPolicies(
            com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAutoProtectionPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AutoProtectionPolicy.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.AutoProtectionPolicy getAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.GetAutoProtectionPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAutoProtectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AutoProtectionPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.UpdateAutoProtectionPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateAutoProtectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AutoProtectionPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.DeleteAutoProtectionPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteAutoProtectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AutoProtectionPolicyBinding in a given project and
     * location.
     * </pre>
     */
    public com.google.longrunning.Operation createAutoProtectionPolicyBinding(
        com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAutoProtectionPolicyBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the auto protection policy binding read from the CCFE tables.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.AutoProtectionPolicyBinding getAutoProtectionPolicyBinding(
        com.google.cloud.backupdr.v1.GetAutoProtectionPolicyBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAutoProtectionPolicyBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the auto protection policy bindings read from the CCFE tables.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsResponse
        listAutoProtectionPolicyBindings(
            com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAutoProtectionPolicyBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AppliedAutoProtectionPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesResponse
        listAppliedAutoProtectionPolicies(
            com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAppliedAutoProtectionPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * InitiateDeleteAutoProtectionPolicyBinding initiates delete for
     * AutoProtectionPolicy Binding
     * </pre>
     */
    public com.google.longrunning.Operation initiateDeleteAutoProtectionPolicyBinding(
        com.google.cloud.backupdr.v1.InitiateDeleteAutoProtectionPolicyBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getInitiateDeleteAutoProtectionPolicyBindingMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists Binding Matching Resources for a given AutoProtectionPolicyBinding.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListBindingMatchingResourcesResponse
        listBindingMatchingResources(
            com.google.cloud.backupdr.v1.ListBindingMatchingResourcesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBindingMatchingResourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreTemplate in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createRestoreTemplate(
        com.google.cloud.backupdr.v1.CreateRestoreTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateRestoreTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a RestoreTemplate.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.RestoreTemplate getRestoreTemplate(
        com.google.cloud.backupdr.v1.GetRestoreTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetRestoreTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreTemplates in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListRestoreTemplatesResponse listRestoreTemplates(
        com.google.cloud.backupdr.v1.ListRestoreTemplatesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRestoreTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a RestoreTemplate.
     * </pre>
     */
    public com.google.longrunning.Operation updateRestoreTemplate(
        com.google.cloud.backupdr.v1.UpdateRestoreTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateRestoreTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RestoreTemplate.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRestoreTemplate(
        com.google.cloud.backupdr.v1.DeleteRestoreTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteRestoreTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs a RestoreTemplate.
     * </pre>
     */
    public com.google.longrunning.Operation runRestoreTemplate(
        com.google.cloud.backupdr.v1.RunRestoreTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRunRestoreTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a RestoreTemplateExecution.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.RestoreTemplateExecution getRestoreTemplateExecution(
        com.google.cloud.backupdr.v1.GetRestoreTemplateExecutionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetRestoreTemplateExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreTemplateExecutions in a given project, location and restore
     * template.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsResponse
        listRestoreTemplateExecutions(
            com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRestoreTemplateExecutionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Triggers cleanup of restored resources created during execution.
     * </pre>
     */
    public com.google.longrunning.Operation triggerRestoreCleanup(
        com.google.cloud.backupdr.v1.TriggerRestoreCleanupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTriggerRestoreCleanupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreVerificationPlan in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createRestoreVerificationPlan(
        com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateRestoreVerificationPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.longrunning.Operation createRestoreVerificationPlanAssociation(
        com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getCreateRestoreVerificationPlanAssociationMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.RestoreVerificationPlanAssociation
        getRestoreVerificationPlanAssociation(
            com.google.cloud.backupdr.v1.GetRestoreVerificationPlanAssociationRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getGetRestoreVerificationPlanAssociationMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreVerificationPlanAssociations in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsResponse
        listRestoreVerificationPlanAssociations(
            com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getListRestoreVerificationPlanAssociationsMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRestoreVerificationPlanAssociation(
        com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getDeleteRestoreVerificationPlanAssociationMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Triggers a new Restore Verification for the association in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.longrunning.Operation triggerRestoreVerification(
        com.google.cloud.backupdr.v1.TriggerRestoreVerificationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTriggerRestoreVerificationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RestoreVerificationPlan. Returns the requested
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.RestoreVerificationPlan getRestoreVerificationPlan(
        com.google.cloud.backupdr.v1.GetRestoreVerificationPlanRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetRestoreVerificationPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreVerificationPlans in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListRestoreVerificationPlansResponse
        listRestoreVerificationPlans(
            com.google.cloud.backupdr.v1.ListRestoreVerificationPlansRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRestoreVerificationPlansMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RestoreVerificationPlan. If the `force` flag is set to
     * `true`, any RestoreVerificationPlanAssociations linked to this
     * RestoreVerificationPlan will also be deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRestoreVerificationPlan(
        com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteRestoreVerificationPlanMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service BackupDR.
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
     * Fetch Backups for a given resource type.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeResponse
        fetchBackupsForResourceType(
            com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchBackupsForResourceTypeMethod(), getCallOptions(), request);
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
     * Update a BackupPlan.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackupPlan(
        com.google.cloud.backupdr.v1.UpdateBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupPlanMethod(), getCallOptions(), request);
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
     * Gets details of a single BackupPlanRevision.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.BackupPlanRevision getBackupPlanRevision(
        com.google.cloud.backupdr.v1.GetBackupPlanRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupPlanRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlanRevisions in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListBackupPlanRevisionsResponse listBackupPlanRevisions(
        com.google.cloud.backupdr.v1.ListBackupPlanRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupPlanRevisionsMethod(), getCallOptions(), request);
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
     * Update a BackupPlanAssociation.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackupPlanAssociation(
        com.google.cloud.backupdr.v1.UpdateBackupPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupPlanAssociationMethod(), getCallOptions(), request);
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
     * List BackupPlanAssociations for a given resource type.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeResponse
        fetchBackupPlanAssociationsForResourceType(
            com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getFetchBackupPlanAssociationsForResourceTypeMethod(),
          getCallOptions(),
          request);
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
     * Gets details of a single DataSourceReference.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.DataSourceReference getDataSourceReference(
        com.google.cloud.backupdr.v1.GetDataSourceReferenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataSourceReferenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataSourceReferences for a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListDataSourceReferencesResponse listDataSourceReferences(
        com.google.cloud.backupdr.v1.ListDataSourceReferencesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataSourceReferencesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetch DataSourceReferences for a given project, location and resource type.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeResponse
        fetchDataSourceReferencesForResourceType(
            com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getFetchDataSourceReferencesForResourceTypeMethod(),
          getCallOptions(),
          request);
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

    /**
     *
     *
     * <pre>
     * Creates a new AutoProtectionPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAutoProtectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AutoProtectionPolicies for a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesResponse
        listAutoProtectionPolicies(
            com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAutoProtectionPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AutoProtectionPolicy.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.AutoProtectionPolicy getAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.GetAutoProtectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAutoProtectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AutoProtectionPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.UpdateAutoProtectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAutoProtectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AutoProtectionPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAutoProtectionPolicy(
        com.google.cloud.backupdr.v1.DeleteAutoProtectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAutoProtectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AutoProtectionPolicyBinding in a given project and
     * location.
     * </pre>
     */
    public com.google.longrunning.Operation createAutoProtectionPolicyBinding(
        com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAutoProtectionPolicyBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the auto protection policy binding read from the CCFE tables.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.AutoProtectionPolicyBinding getAutoProtectionPolicyBinding(
        com.google.cloud.backupdr.v1.GetAutoProtectionPolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAutoProtectionPolicyBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the auto protection policy bindings read from the CCFE tables.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsResponse
        listAutoProtectionPolicyBindings(
            com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAutoProtectionPolicyBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AppliedAutoProtectionPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesResponse
        listAppliedAutoProtectionPolicies(
            com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAppliedAutoProtectionPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * InitiateDeleteAutoProtectionPolicyBinding initiates delete for
     * AutoProtectionPolicy Binding
     * </pre>
     */
    public com.google.longrunning.Operation initiateDeleteAutoProtectionPolicyBinding(
        com.google.cloud.backupdr.v1.InitiateDeleteAutoProtectionPolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getInitiateDeleteAutoProtectionPolicyBindingMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists Binding Matching Resources for a given AutoProtectionPolicyBinding.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListBindingMatchingResourcesResponse
        listBindingMatchingResources(
            com.google.cloud.backupdr.v1.ListBindingMatchingResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBindingMatchingResourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreTemplate in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createRestoreTemplate(
        com.google.cloud.backupdr.v1.CreateRestoreTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRestoreTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a RestoreTemplate.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.RestoreTemplate getRestoreTemplate(
        com.google.cloud.backupdr.v1.GetRestoreTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRestoreTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreTemplates in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListRestoreTemplatesResponse listRestoreTemplates(
        com.google.cloud.backupdr.v1.ListRestoreTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRestoreTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a RestoreTemplate.
     * </pre>
     */
    public com.google.longrunning.Operation updateRestoreTemplate(
        com.google.cloud.backupdr.v1.UpdateRestoreTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRestoreTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RestoreTemplate.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRestoreTemplate(
        com.google.cloud.backupdr.v1.DeleteRestoreTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRestoreTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs a RestoreTemplate.
     * </pre>
     */
    public com.google.longrunning.Operation runRestoreTemplate(
        com.google.cloud.backupdr.v1.RunRestoreTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunRestoreTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a RestoreTemplateExecution.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.RestoreTemplateExecution getRestoreTemplateExecution(
        com.google.cloud.backupdr.v1.GetRestoreTemplateExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRestoreTemplateExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreTemplateExecutions in a given project, location and restore
     * template.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsResponse
        listRestoreTemplateExecutions(
            com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRestoreTemplateExecutionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Triggers cleanup of restored resources created during execution.
     * </pre>
     */
    public com.google.longrunning.Operation triggerRestoreCleanup(
        com.google.cloud.backupdr.v1.TriggerRestoreCleanupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTriggerRestoreCleanupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreVerificationPlan in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createRestoreVerificationPlan(
        com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRestoreVerificationPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.longrunning.Operation createRestoreVerificationPlanAssociation(
        com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getCreateRestoreVerificationPlanAssociationMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.RestoreVerificationPlanAssociation
        getRestoreVerificationPlanAssociation(
            com.google.cloud.backupdr.v1.GetRestoreVerificationPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGetRestoreVerificationPlanAssociationMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreVerificationPlanAssociations in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsResponse
        listRestoreVerificationPlanAssociations(
            com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListRestoreVerificationPlanAssociationsMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRestoreVerificationPlanAssociation(
        com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getDeleteRestoreVerificationPlanAssociationMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Triggers a new Restore Verification for the association in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.longrunning.Operation triggerRestoreVerification(
        com.google.cloud.backupdr.v1.TriggerRestoreVerificationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTriggerRestoreVerificationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RestoreVerificationPlan. Returns the requested
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.RestoreVerificationPlan getRestoreVerificationPlan(
        com.google.cloud.backupdr.v1.GetRestoreVerificationPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRestoreVerificationPlanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreVerificationPlans in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListRestoreVerificationPlansResponse
        listRestoreVerificationPlans(
            com.google.cloud.backupdr.v1.ListRestoreVerificationPlansRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRestoreVerificationPlansMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RestoreVerificationPlan. If the `force` flag is set to
     * `true`, any RestoreVerificationPlanAssociations linked to this
     * RestoreVerificationPlan will also be deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRestoreVerificationPlan(
        com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRestoreVerificationPlanMethod(), getCallOptions(), request);
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
     * Fetch Backups for a given resource type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeResponse>
        fetchBackupsForResourceType(
            com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchBackupsForResourceTypeMethod(), getCallOptions()), request);
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
     * Update a BackupPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBackupPlan(com.google.cloud.backupdr.v1.UpdateBackupPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupPlanMethod(), getCallOptions()), request);
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
     * Gets details of a single BackupPlanRevision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.BackupPlanRevision>
        getBackupPlanRevision(com.google.cloud.backupdr.v1.GetBackupPlanRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupPlanRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists BackupPlanRevisions in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListBackupPlanRevisionsResponse>
        listBackupPlanRevisions(
            com.google.cloud.backupdr.v1.ListBackupPlanRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupPlanRevisionsMethod(), getCallOptions()), request);
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
     * Update a BackupPlanAssociation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBackupPlanAssociation(
            com.google.cloud.backupdr.v1.UpdateBackupPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupPlanAssociationMethod(), getCallOptions()), request);
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
     * List BackupPlanAssociations for a given resource type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeResponse>
        fetchBackupPlanAssociationsForResourceType(
            com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getFetchBackupPlanAssociationsForResourceTypeMethod(), getCallOptions()),
          request);
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
     * Gets details of a single DataSourceReference.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.DataSourceReference>
        getDataSourceReference(com.google.cloud.backupdr.v1.GetDataSourceReferenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataSourceReferenceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataSourceReferences for a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListDataSourceReferencesResponse>
        listDataSourceReferences(
            com.google.cloud.backupdr.v1.ListDataSourceReferencesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataSourceReferencesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetch DataSourceReferences for a given project, location and resource type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeResponse>
        fetchDataSourceReferencesForResourceType(
            com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getFetchDataSourceReferencesForResourceTypeMethod(), getCallOptions()),
          request);
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

    /**
     *
     *
     * <pre>
     * Creates a new AutoProtectionPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAutoProtectionPolicy(
            com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAutoProtectionPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists AutoProtectionPolicies for a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesResponse>
        listAutoProtectionPolicies(
            com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAutoProtectionPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single AutoProtectionPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.AutoProtectionPolicy>
        getAutoProtectionPolicy(
            com.google.cloud.backupdr.v1.GetAutoProtectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAutoProtectionPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single AutoProtectionPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateAutoProtectionPolicy(
            com.google.cloud.backupdr.v1.UpdateAutoProtectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAutoProtectionPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single AutoProtectionPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAutoProtectionPolicy(
            com.google.cloud.backupdr.v1.DeleteAutoProtectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAutoProtectionPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new AutoProtectionPolicyBinding in a given project and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAutoProtectionPolicyBinding(
            com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAutoProtectionPolicyBindingMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns the auto protection policy binding read from the CCFE tables.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.AutoProtectionPolicyBinding>
        getAutoProtectionPolicyBinding(
            com.google.cloud.backupdr.v1.GetAutoProtectionPolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAutoProtectionPolicyBindingMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns the auto protection policy bindings read from the CCFE tables.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsResponse>
        listAutoProtectionPolicyBindings(
            com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAutoProtectionPolicyBindingsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists AppliedAutoProtectionPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesResponse>
        listAppliedAutoProtectionPolicies(
            com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAppliedAutoProtectionPoliciesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * InitiateDeleteAutoProtectionPolicyBinding initiates delete for
     * AutoProtectionPolicy Binding
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        initiateDeleteAutoProtectionPolicyBinding(
            com.google.cloud.backupdr.v1.InitiateDeleteAutoProtectionPolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getInitiateDeleteAutoProtectionPolicyBindingMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists Binding Matching Resources for a given AutoProtectionPolicyBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListBindingMatchingResourcesResponse>
        listBindingMatchingResources(
            com.google.cloud.backupdr.v1.ListBindingMatchingResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBindingMatchingResourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreTemplate in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRestoreTemplate(com.google.cloud.backupdr.v1.CreateRestoreTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRestoreTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a RestoreTemplate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.RestoreTemplate>
        getRestoreTemplate(com.google.cloud.backupdr.v1.GetRestoreTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRestoreTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreTemplates in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListRestoreTemplatesResponse>
        listRestoreTemplates(com.google.cloud.backupdr.v1.ListRestoreTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRestoreTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a RestoreTemplate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateRestoreTemplate(com.google.cloud.backupdr.v1.UpdateRestoreTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRestoreTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a RestoreTemplate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRestoreTemplate(com.google.cloud.backupdr.v1.DeleteRestoreTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRestoreTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Runs a RestoreTemplate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        runRestoreTemplate(com.google.cloud.backupdr.v1.RunRestoreTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunRestoreTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a RestoreTemplateExecution.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.RestoreTemplateExecution>
        getRestoreTemplateExecution(
            com.google.cloud.backupdr.v1.GetRestoreTemplateExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRestoreTemplateExecutionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreTemplateExecutions in a given project, location and restore
     * template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsResponse>
        listRestoreTemplateExecutions(
            com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRestoreTemplateExecutionsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Triggers cleanup of restored resources created during execution.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        triggerRestoreCleanup(com.google.cloud.backupdr.v1.TriggerRestoreCleanupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTriggerRestoreCleanupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreVerificationPlan in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRestoreVerificationPlan(
            com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRestoreVerificationPlanMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRestoreVerificationPlanAssociation(
            com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getCreateRestoreVerificationPlanAssociationMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.RestoreVerificationPlanAssociation>
        getRestoreVerificationPlanAssociation(
            com.google.cloud.backupdr.v1.GetRestoreVerificationPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRestoreVerificationPlanAssociationMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreVerificationPlanAssociations in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsResponse>
        listRestoreVerificationPlanAssociations(
            com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getListRestoreVerificationPlanAssociationsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RestoreVerificationPlanAssociation in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRestoreVerificationPlanAssociation(
            com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanAssociationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getDeleteRestoreVerificationPlanAssociationMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Triggers a new Restore Verification for the association in a given
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        triggerRestoreVerification(
            com.google.cloud.backupdr.v1.TriggerRestoreVerificationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTriggerRestoreVerificationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single RestoreVerificationPlan. Returns the requested
     * RestoreVerificationPlan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.RestoreVerificationPlan>
        getRestoreVerificationPlan(
            com.google.cloud.backupdr.v1.GetRestoreVerificationPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRestoreVerificationPlanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RestoreVerificationPlans in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListRestoreVerificationPlansResponse>
        listRestoreVerificationPlans(
            com.google.cloud.backupdr.v1.ListRestoreVerificationPlansRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRestoreVerificationPlansMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single RestoreVerificationPlan. If the `force` flag is set to
     * `true`, any RestoreVerificationPlanAssociations linked to this
     * RestoreVerificationPlan will also be deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRestoreVerificationPlan(
            com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRestoreVerificationPlanMethod(), getCallOptions()),
          request);
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
  private static final int METHODID_FETCH_BACKUPS_FOR_RESOURCE_TYPE = 14;
  private static final int METHODID_GET_BACKUP = 15;
  private static final int METHODID_UPDATE_BACKUP = 16;
  private static final int METHODID_DELETE_BACKUP = 17;
  private static final int METHODID_RESTORE_BACKUP = 18;
  private static final int METHODID_CREATE_BACKUP_PLAN = 19;
  private static final int METHODID_UPDATE_BACKUP_PLAN = 20;
  private static final int METHODID_GET_BACKUP_PLAN = 21;
  private static final int METHODID_LIST_BACKUP_PLANS = 22;
  private static final int METHODID_DELETE_BACKUP_PLAN = 23;
  private static final int METHODID_GET_BACKUP_PLAN_REVISION = 24;
  private static final int METHODID_LIST_BACKUP_PLAN_REVISIONS = 25;
  private static final int METHODID_CREATE_BACKUP_PLAN_ASSOCIATION = 26;
  private static final int METHODID_UPDATE_BACKUP_PLAN_ASSOCIATION = 27;
  private static final int METHODID_GET_BACKUP_PLAN_ASSOCIATION = 28;
  private static final int METHODID_LIST_BACKUP_PLAN_ASSOCIATIONS = 29;
  private static final int METHODID_FETCH_BACKUP_PLAN_ASSOCIATIONS_FOR_RESOURCE_TYPE = 30;
  private static final int METHODID_DELETE_BACKUP_PLAN_ASSOCIATION = 31;
  private static final int METHODID_TRIGGER_BACKUP = 32;
  private static final int METHODID_GET_DATA_SOURCE_REFERENCE = 33;
  private static final int METHODID_LIST_DATA_SOURCE_REFERENCES = 34;
  private static final int METHODID_FETCH_DATA_SOURCE_REFERENCES_FOR_RESOURCE_TYPE = 35;
  private static final int METHODID_INITIALIZE_SERVICE = 36;
  private static final int METHODID_CREATE_AUTO_PROTECTION_POLICY = 37;
  private static final int METHODID_LIST_AUTO_PROTECTION_POLICIES = 38;
  private static final int METHODID_GET_AUTO_PROTECTION_POLICY = 39;
  private static final int METHODID_UPDATE_AUTO_PROTECTION_POLICY = 40;
  private static final int METHODID_DELETE_AUTO_PROTECTION_POLICY = 41;
  private static final int METHODID_CREATE_AUTO_PROTECTION_POLICY_BINDING = 42;
  private static final int METHODID_GET_AUTO_PROTECTION_POLICY_BINDING = 43;
  private static final int METHODID_LIST_AUTO_PROTECTION_POLICY_BINDINGS = 44;
  private static final int METHODID_LIST_APPLIED_AUTO_PROTECTION_POLICIES = 45;
  private static final int METHODID_INITIATE_DELETE_AUTO_PROTECTION_POLICY_BINDING = 46;
  private static final int METHODID_LIST_BINDING_MATCHING_RESOURCES = 47;
  private static final int METHODID_CREATE_RESTORE_TEMPLATE = 48;
  private static final int METHODID_GET_RESTORE_TEMPLATE = 49;
  private static final int METHODID_LIST_RESTORE_TEMPLATES = 50;
  private static final int METHODID_UPDATE_RESTORE_TEMPLATE = 51;
  private static final int METHODID_DELETE_RESTORE_TEMPLATE = 52;
  private static final int METHODID_RUN_RESTORE_TEMPLATE = 53;
  private static final int METHODID_GET_RESTORE_TEMPLATE_EXECUTION = 54;
  private static final int METHODID_LIST_RESTORE_TEMPLATE_EXECUTIONS = 55;
  private static final int METHODID_TRIGGER_RESTORE_CLEANUP = 56;
  private static final int METHODID_CREATE_RESTORE_VERIFICATION_PLAN = 57;
  private static final int METHODID_CREATE_RESTORE_VERIFICATION_PLAN_ASSOCIATION = 58;
  private static final int METHODID_GET_RESTORE_VERIFICATION_PLAN_ASSOCIATION = 59;
  private static final int METHODID_LIST_RESTORE_VERIFICATION_PLAN_ASSOCIATIONS = 60;
  private static final int METHODID_DELETE_RESTORE_VERIFICATION_PLAN_ASSOCIATION = 61;
  private static final int METHODID_TRIGGER_RESTORE_VERIFICATION = 62;
  private static final int METHODID_GET_RESTORE_VERIFICATION_PLAN = 63;
  private static final int METHODID_LIST_RESTORE_VERIFICATION_PLANS = 64;
  private static final int METHODID_DELETE_RESTORE_VERIFICATION_PLAN = 65;

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
        case METHODID_FETCH_BACKUPS_FOR_RESOURCE_TYPE:
          serviceImpl.fetchBackupsForResourceType(
              (com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeResponse>)
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
        case METHODID_UPDATE_BACKUP_PLAN:
          serviceImpl.updateBackupPlan(
              (com.google.cloud.backupdr.v1.UpdateBackupPlanRequest) request,
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
        case METHODID_GET_BACKUP_PLAN_REVISION:
          serviceImpl.getBackupPlanRevision(
              (com.google.cloud.backupdr.v1.GetBackupPlanRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.BackupPlanRevision>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUP_PLAN_REVISIONS:
          serviceImpl.listBackupPlanRevisions(
              (com.google.cloud.backupdr.v1.ListBackupPlanRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListBackupPlanRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_BACKUP_PLAN_ASSOCIATION:
          serviceImpl.createBackupPlanAssociation(
              (com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_BACKUP_PLAN_ASSOCIATION:
          serviceImpl.updateBackupPlanAssociation(
              (com.google.cloud.backupdr.v1.UpdateBackupPlanAssociationRequest) request,
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
        case METHODID_FETCH_BACKUP_PLAN_ASSOCIATIONS_FOR_RESOURCE_TYPE:
          serviceImpl.fetchBackupPlanAssociationsForResourceType(
              (com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1
                          .FetchBackupPlanAssociationsForResourceTypeResponse>)
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
        case METHODID_GET_DATA_SOURCE_REFERENCE:
          serviceImpl.getDataSourceReference(
              (com.google.cloud.backupdr.v1.GetDataSourceReferenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.DataSourceReference>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_SOURCE_REFERENCES:
          serviceImpl.listDataSourceReferences(
              (com.google.cloud.backupdr.v1.ListDataSourceReferencesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListDataSourceReferencesResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_DATA_SOURCE_REFERENCES_FOR_RESOURCE_TYPE:
          serviceImpl.fetchDataSourceReferencesForResourceType(
              (com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1
                          .FetchDataSourceReferencesForResourceTypeResponse>)
                  responseObserver);
          break;
        case METHODID_INITIALIZE_SERVICE:
          serviceImpl.initializeService(
              (com.google.cloud.backupdr.v1.InitializeServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_AUTO_PROTECTION_POLICY:
          serviceImpl.createAutoProtectionPolicy(
              (com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_AUTO_PROTECTION_POLICIES:
          serviceImpl.listAutoProtectionPolicies(
              (com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AUTO_PROTECTION_POLICY:
          serviceImpl.getAutoProtectionPolicy(
              (com.google.cloud.backupdr.v1.GetAutoProtectionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.AutoProtectionPolicy>)
                  responseObserver);
          break;
        case METHODID_UPDATE_AUTO_PROTECTION_POLICY:
          serviceImpl.updateAutoProtectionPolicy(
              (com.google.cloud.backupdr.v1.UpdateAutoProtectionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_AUTO_PROTECTION_POLICY:
          serviceImpl.deleteAutoProtectionPolicy(
              (com.google.cloud.backupdr.v1.DeleteAutoProtectionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_AUTO_PROTECTION_POLICY_BINDING:
          serviceImpl.createAutoProtectionPolicyBinding(
              (com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_AUTO_PROTECTION_POLICY_BINDING:
          serviceImpl.getAutoProtectionPolicyBinding(
              (com.google.cloud.backupdr.v1.GetAutoProtectionPolicyBindingRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.AutoProtectionPolicyBinding>)
                  responseObserver);
          break;
        case METHODID_LIST_AUTO_PROTECTION_POLICY_BINDINGS:
          serviceImpl.listAutoProtectionPolicyBindings(
              (com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_APPLIED_AUTO_PROTECTION_POLICIES:
          serviceImpl.listAppliedAutoProtectionPolicies(
              (com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_INITIATE_DELETE_AUTO_PROTECTION_POLICY_BINDING:
          serviceImpl.initiateDeleteAutoProtectionPolicyBinding(
              (com.google.cloud.backupdr.v1.InitiateDeleteAutoProtectionPolicyBindingRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BINDING_MATCHING_RESOURCES:
          serviceImpl.listBindingMatchingResources(
              (com.google.cloud.backupdr.v1.ListBindingMatchingResourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListBindingMatchingResourcesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_RESTORE_TEMPLATE:
          serviceImpl.createRestoreTemplate(
              (com.google.cloud.backupdr.v1.CreateRestoreTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_RESTORE_TEMPLATE:
          serviceImpl.getRestoreTemplate(
              (com.google.cloud.backupdr.v1.GetRestoreTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.RestoreTemplate>)
                  responseObserver);
          break;
        case METHODID_LIST_RESTORE_TEMPLATES:
          serviceImpl.listRestoreTemplates(
              (com.google.cloud.backupdr.v1.ListRestoreTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListRestoreTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_RESTORE_TEMPLATE:
          serviceImpl.updateRestoreTemplate(
              (com.google.cloud.backupdr.v1.UpdateRestoreTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_RESTORE_TEMPLATE:
          serviceImpl.deleteRestoreTemplate(
              (com.google.cloud.backupdr.v1.DeleteRestoreTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RUN_RESTORE_TEMPLATE:
          serviceImpl.runRestoreTemplate(
              (com.google.cloud.backupdr.v1.RunRestoreTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_RESTORE_TEMPLATE_EXECUTION:
          serviceImpl.getRestoreTemplateExecution(
              (com.google.cloud.backupdr.v1.GetRestoreTemplateExecutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.RestoreTemplateExecution>)
                  responseObserver);
          break;
        case METHODID_LIST_RESTORE_TEMPLATE_EXECUTIONS:
          serviceImpl.listRestoreTemplateExecutions(
              (com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsResponse>)
                  responseObserver);
          break;
        case METHODID_TRIGGER_RESTORE_CLEANUP:
          serviceImpl.triggerRestoreCleanup(
              (com.google.cloud.backupdr.v1.TriggerRestoreCleanupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_RESTORE_VERIFICATION_PLAN:
          serviceImpl.createRestoreVerificationPlan(
              (com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_RESTORE_VERIFICATION_PLAN_ASSOCIATION:
          serviceImpl.createRestoreVerificationPlanAssociation(
              (com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanAssociationRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_RESTORE_VERIFICATION_PLAN_ASSOCIATION:
          serviceImpl.getRestoreVerificationPlanAssociation(
              (com.google.cloud.backupdr.v1.GetRestoreVerificationPlanAssociationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.RestoreVerificationPlanAssociation>)
                  responseObserver);
          break;
        case METHODID_LIST_RESTORE_VERIFICATION_PLAN_ASSOCIATIONS:
          serviceImpl.listRestoreVerificationPlanAssociations(
              (com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_RESTORE_VERIFICATION_PLAN_ASSOCIATION:
          serviceImpl.deleteRestoreVerificationPlanAssociation(
              (com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanAssociationRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_TRIGGER_RESTORE_VERIFICATION:
          serviceImpl.triggerRestoreVerification(
              (com.google.cloud.backupdr.v1.TriggerRestoreVerificationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_RESTORE_VERIFICATION_PLAN:
          serviceImpl.getRestoreVerificationPlan(
              (com.google.cloud.backupdr.v1.GetRestoreVerificationPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.RestoreVerificationPlan>)
                  responseObserver);
          break;
        case METHODID_LIST_RESTORE_VERIFICATION_PLANS:
          serviceImpl.listRestoreVerificationPlans(
              (com.google.cloud.backupdr.v1.ListRestoreVerificationPlansRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListRestoreVerificationPlansResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_RESTORE_VERIFICATION_PLAN:
          serviceImpl.deleteRestoreVerificationPlan(
              (com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanRequest) request,
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
            getFetchBackupsForResourceTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeRequest,
                    com.google.cloud.backupdr.v1.FetchBackupsForResourceTypeResponse>(
                    service, METHODID_FETCH_BACKUPS_FOR_RESOURCE_TYPE)))
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
            getUpdateBackupPlanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.UpdateBackupPlanRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BACKUP_PLAN)))
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
            getGetBackupPlanRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetBackupPlanRevisionRequest,
                    com.google.cloud.backupdr.v1.BackupPlanRevision>(
                    service, METHODID_GET_BACKUP_PLAN_REVISION)))
        .addMethod(
            getListBackupPlanRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListBackupPlanRevisionsRequest,
                    com.google.cloud.backupdr.v1.ListBackupPlanRevisionsResponse>(
                    service, METHODID_LIST_BACKUP_PLAN_REVISIONS)))
        .addMethod(
            getCreateBackupPlanAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.CreateBackupPlanAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_BACKUP_PLAN_ASSOCIATION)))
        .addMethod(
            getUpdateBackupPlanAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.UpdateBackupPlanAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_BACKUP_PLAN_ASSOCIATION)))
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
            getFetchBackupPlanAssociationsForResourceTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.FetchBackupPlanAssociationsForResourceTypeRequest,
                    com.google.cloud.backupdr.v1
                        .FetchBackupPlanAssociationsForResourceTypeResponse>(
                    service, METHODID_FETCH_BACKUP_PLAN_ASSOCIATIONS_FOR_RESOURCE_TYPE)))
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
            getGetDataSourceReferenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetDataSourceReferenceRequest,
                    com.google.cloud.backupdr.v1.DataSourceReference>(
                    service, METHODID_GET_DATA_SOURCE_REFERENCE)))
        .addMethod(
            getListDataSourceReferencesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListDataSourceReferencesRequest,
                    com.google.cloud.backupdr.v1.ListDataSourceReferencesResponse>(
                    service, METHODID_LIST_DATA_SOURCE_REFERENCES)))
        .addMethod(
            getFetchDataSourceReferencesForResourceTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeRequest,
                    com.google.cloud.backupdr.v1.FetchDataSourceReferencesForResourceTypeResponse>(
                    service, METHODID_FETCH_DATA_SOURCE_REFERENCES_FOR_RESOURCE_TYPE)))
        .addMethod(
            getInitializeServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.InitializeServiceRequest,
                    com.google.longrunning.Operation>(service, METHODID_INITIALIZE_SERVICE)))
        .addMethod(
            getCreateAutoProtectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_AUTO_PROTECTION_POLICY)))
        .addMethod(
            getListAutoProtectionPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesRequest,
                    com.google.cloud.backupdr.v1.ListAutoProtectionPoliciesResponse>(
                    service, METHODID_LIST_AUTO_PROTECTION_POLICIES)))
        .addMethod(
            getGetAutoProtectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetAutoProtectionPolicyRequest,
                    com.google.cloud.backupdr.v1.AutoProtectionPolicy>(
                    service, METHODID_GET_AUTO_PROTECTION_POLICY)))
        .addMethod(
            getUpdateAutoProtectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.UpdateAutoProtectionPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_AUTO_PROTECTION_POLICY)))
        .addMethod(
            getDeleteAutoProtectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.DeleteAutoProtectionPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_AUTO_PROTECTION_POLICY)))
        .addMethod(
            getCreateAutoProtectionPolicyBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.CreateAutoProtectionPolicyBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_AUTO_PROTECTION_POLICY_BINDING)))
        .addMethod(
            getGetAutoProtectionPolicyBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetAutoProtectionPolicyBindingRequest,
                    com.google.cloud.backupdr.v1.AutoProtectionPolicyBinding>(
                    service, METHODID_GET_AUTO_PROTECTION_POLICY_BINDING)))
        .addMethod(
            getListAutoProtectionPolicyBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsRequest,
                    com.google.cloud.backupdr.v1.ListAutoProtectionPolicyBindingsResponse>(
                    service, METHODID_LIST_AUTO_PROTECTION_POLICY_BINDINGS)))
        .addMethod(
            getListAppliedAutoProtectionPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesRequest,
                    com.google.cloud.backupdr.v1.ListAppliedAutoProtectionPoliciesResponse>(
                    service, METHODID_LIST_APPLIED_AUTO_PROTECTION_POLICIES)))
        .addMethod(
            getInitiateDeleteAutoProtectionPolicyBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.InitiateDeleteAutoProtectionPolicyBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_INITIATE_DELETE_AUTO_PROTECTION_POLICY_BINDING)))
        .addMethod(
            getListBindingMatchingResourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListBindingMatchingResourcesRequest,
                    com.google.cloud.backupdr.v1.ListBindingMatchingResourcesResponse>(
                    service, METHODID_LIST_BINDING_MATCHING_RESOURCES)))
        .addMethod(
            getCreateRestoreTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.CreateRestoreTemplateRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_RESTORE_TEMPLATE)))
        .addMethod(
            getGetRestoreTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetRestoreTemplateRequest,
                    com.google.cloud.backupdr.v1.RestoreTemplate>(
                    service, METHODID_GET_RESTORE_TEMPLATE)))
        .addMethod(
            getListRestoreTemplatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListRestoreTemplatesRequest,
                    com.google.cloud.backupdr.v1.ListRestoreTemplatesResponse>(
                    service, METHODID_LIST_RESTORE_TEMPLATES)))
        .addMethod(
            getUpdateRestoreTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.UpdateRestoreTemplateRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_RESTORE_TEMPLATE)))
        .addMethod(
            getDeleteRestoreTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.DeleteRestoreTemplateRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_RESTORE_TEMPLATE)))
        .addMethod(
            getRunRestoreTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.RunRestoreTemplateRequest,
                    com.google.longrunning.Operation>(service, METHODID_RUN_RESTORE_TEMPLATE)))
        .addMethod(
            getGetRestoreTemplateExecutionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetRestoreTemplateExecutionRequest,
                    com.google.cloud.backupdr.v1.RestoreTemplateExecution>(
                    service, METHODID_GET_RESTORE_TEMPLATE_EXECUTION)))
        .addMethod(
            getListRestoreTemplateExecutionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsRequest,
                    com.google.cloud.backupdr.v1.ListRestoreTemplateExecutionsResponse>(
                    service, METHODID_LIST_RESTORE_TEMPLATE_EXECUTIONS)))
        .addMethod(
            getTriggerRestoreCleanupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.TriggerRestoreCleanupRequest,
                    com.google.longrunning.Operation>(service, METHODID_TRIGGER_RESTORE_CLEANUP)))
        .addMethod(
            getCreateRestoreVerificationPlanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_RESTORE_VERIFICATION_PLAN)))
        .addMethod(
            getCreateRestoreVerificationPlanAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.CreateRestoreVerificationPlanAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_RESTORE_VERIFICATION_PLAN_ASSOCIATION)))
        .addMethod(
            getGetRestoreVerificationPlanAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetRestoreVerificationPlanAssociationRequest,
                    com.google.cloud.backupdr.v1.RestoreVerificationPlanAssociation>(
                    service, METHODID_GET_RESTORE_VERIFICATION_PLAN_ASSOCIATION)))
        .addMethod(
            getListRestoreVerificationPlanAssociationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsRequest,
                    com.google.cloud.backupdr.v1.ListRestoreVerificationPlanAssociationsResponse>(
                    service, METHODID_LIST_RESTORE_VERIFICATION_PLAN_ASSOCIATIONS)))
        .addMethod(
            getDeleteRestoreVerificationPlanAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_RESTORE_VERIFICATION_PLAN_ASSOCIATION)))
        .addMethod(
            getTriggerRestoreVerificationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.TriggerRestoreVerificationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_TRIGGER_RESTORE_VERIFICATION)))
        .addMethod(
            getGetRestoreVerificationPlanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetRestoreVerificationPlanRequest,
                    com.google.cloud.backupdr.v1.RestoreVerificationPlan>(
                    service, METHODID_GET_RESTORE_VERIFICATION_PLAN)))
        .addMethod(
            getListRestoreVerificationPlansMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListRestoreVerificationPlansRequest,
                    com.google.cloud.backupdr.v1.ListRestoreVerificationPlansResponse>(
                    service, METHODID_LIST_RESTORE_VERIFICATION_PLANS)))
        .addMethod(
            getDeleteRestoreVerificationPlanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.DeleteRestoreVerificationPlanRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_RESTORE_VERIFICATION_PLAN)))
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
                      .addMethod(getFetchBackupsForResourceTypeMethod())
                      .addMethod(getGetBackupMethod())
                      .addMethod(getUpdateBackupMethod())
                      .addMethod(getDeleteBackupMethod())
                      .addMethod(getRestoreBackupMethod())
                      .addMethod(getCreateBackupPlanMethod())
                      .addMethod(getUpdateBackupPlanMethod())
                      .addMethod(getGetBackupPlanMethod())
                      .addMethod(getListBackupPlansMethod())
                      .addMethod(getDeleteBackupPlanMethod())
                      .addMethod(getGetBackupPlanRevisionMethod())
                      .addMethod(getListBackupPlanRevisionsMethod())
                      .addMethod(getCreateBackupPlanAssociationMethod())
                      .addMethod(getUpdateBackupPlanAssociationMethod())
                      .addMethod(getGetBackupPlanAssociationMethod())
                      .addMethod(getListBackupPlanAssociationsMethod())
                      .addMethod(getFetchBackupPlanAssociationsForResourceTypeMethod())
                      .addMethod(getDeleteBackupPlanAssociationMethod())
                      .addMethod(getTriggerBackupMethod())
                      .addMethod(getGetDataSourceReferenceMethod())
                      .addMethod(getListDataSourceReferencesMethod())
                      .addMethod(getFetchDataSourceReferencesForResourceTypeMethod())
                      .addMethod(getInitializeServiceMethod())
                      .addMethod(getCreateAutoProtectionPolicyMethod())
                      .addMethod(getListAutoProtectionPoliciesMethod())
                      .addMethod(getGetAutoProtectionPolicyMethod())
                      .addMethod(getUpdateAutoProtectionPolicyMethod())
                      .addMethod(getDeleteAutoProtectionPolicyMethod())
                      .addMethod(getCreateAutoProtectionPolicyBindingMethod())
                      .addMethod(getGetAutoProtectionPolicyBindingMethod())
                      .addMethod(getListAutoProtectionPolicyBindingsMethod())
                      .addMethod(getListAppliedAutoProtectionPoliciesMethod())
                      .addMethod(getInitiateDeleteAutoProtectionPolicyBindingMethod())
                      .addMethod(getListBindingMatchingResourcesMethod())
                      .addMethod(getCreateRestoreTemplateMethod())
                      .addMethod(getGetRestoreTemplateMethod())
                      .addMethod(getListRestoreTemplatesMethod())
                      .addMethod(getUpdateRestoreTemplateMethod())
                      .addMethod(getDeleteRestoreTemplateMethod())
                      .addMethod(getRunRestoreTemplateMethod())
                      .addMethod(getGetRestoreTemplateExecutionMethod())
                      .addMethod(getListRestoreTemplateExecutionsMethod())
                      .addMethod(getTriggerRestoreCleanupMethod())
                      .addMethod(getCreateRestoreVerificationPlanMethod())
                      .addMethod(getCreateRestoreVerificationPlanAssociationMethod())
                      .addMethod(getGetRestoreVerificationPlanAssociationMethod())
                      .addMethod(getListRestoreVerificationPlanAssociationsMethod())
                      .addMethod(getDeleteRestoreVerificationPlanAssociationMethod())
                      .addMethod(getTriggerRestoreVerificationMethod())
                      .addMethod(getGetRestoreVerificationPlanMethod())
                      .addMethod(getListRestoreVerificationPlansMethod())
                      .addMethod(getDeleteRestoreVerificationPlanMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
