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
package com.google.cloud.backupdr.v1beta;

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

  public static final java.lang.String SERVICE_NAME = "google.cloud.backupdr.v1beta.BackupDR";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListManagementServersRequest,
          com.google.cloud.backupdr.v1beta.ListManagementServersResponse>
      getListManagementServersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListManagementServers",
      requestType = com.google.cloud.backupdr.v1beta.ListManagementServersRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.ListManagementServersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListManagementServersRequest,
          com.google.cloud.backupdr.v1beta.ListManagementServersResponse>
      getListManagementServersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.ListManagementServersRequest,
            com.google.cloud.backupdr.v1beta.ListManagementServersResponse>
        getListManagementServersMethod;
    if ((getListManagementServersMethod = BackupDRGrpc.getListManagementServersMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListManagementServersMethod = BackupDRGrpc.getListManagementServersMethod)
            == null) {
          BackupDRGrpc.getListManagementServersMethod =
              getListManagementServersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.ListManagementServersRequest,
                          com.google.cloud.backupdr.v1beta.ListManagementServersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListManagementServers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListManagementServersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListManagementServersResponse
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
          com.google.cloud.backupdr.v1beta.GetManagementServerRequest,
          com.google.cloud.backupdr.v1beta.ManagementServer>
      getGetManagementServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetManagementServer",
      requestType = com.google.cloud.backupdr.v1beta.GetManagementServerRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.ManagementServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.GetManagementServerRequest,
          com.google.cloud.backupdr.v1beta.ManagementServer>
      getGetManagementServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.GetManagementServerRequest,
            com.google.cloud.backupdr.v1beta.ManagementServer>
        getGetManagementServerMethod;
    if ((getGetManagementServerMethod = BackupDRGrpc.getGetManagementServerMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetManagementServerMethod = BackupDRGrpc.getGetManagementServerMethod) == null) {
          BackupDRGrpc.getGetManagementServerMethod =
              getGetManagementServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.GetManagementServerRequest,
                          com.google.cloud.backupdr.v1beta.ManagementServer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetManagementServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.GetManagementServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ManagementServer
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("GetManagementServer"))
                      .build();
        }
      }
    }
    return getGetManagementServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.CreateManagementServerRequest,
          com.google.longrunning.Operation>
      getCreateManagementServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateManagementServer",
      requestType = com.google.cloud.backupdr.v1beta.CreateManagementServerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.CreateManagementServerRequest,
          com.google.longrunning.Operation>
      getCreateManagementServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.CreateManagementServerRequest,
            com.google.longrunning.Operation>
        getCreateManagementServerMethod;
    if ((getCreateManagementServerMethod = BackupDRGrpc.getCreateManagementServerMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getCreateManagementServerMethod = BackupDRGrpc.getCreateManagementServerMethod)
            == null) {
          BackupDRGrpc.getCreateManagementServerMethod =
              getCreateManagementServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.CreateManagementServerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateManagementServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.CreateManagementServerRequest
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
          com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest,
          com.google.longrunning.Operation>
      getDeleteManagementServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteManagementServer",
      requestType = com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest,
          com.google.longrunning.Operation>
      getDeleteManagementServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest,
            com.google.longrunning.Operation>
        getDeleteManagementServerMethod;
    if ((getDeleteManagementServerMethod = BackupDRGrpc.getDeleteManagementServerMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteManagementServerMethod = BackupDRGrpc.getDeleteManagementServerMethod)
            == null) {
          BackupDRGrpc.getDeleteManagementServerMethod =
              getDeleteManagementServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteManagementServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest
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
          com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest,
          com.google.longrunning.Operation>
      getCreateBackupVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackupVault",
      requestType = com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest,
          com.google.longrunning.Operation>
      getCreateBackupVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest,
            com.google.longrunning.Operation>
        getCreateBackupVaultMethod;
    if ((getCreateBackupVaultMethod = BackupDRGrpc.getCreateBackupVaultMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getCreateBackupVaultMethod = BackupDRGrpc.getCreateBackupVaultMethod) == null) {
          BackupDRGrpc.getCreateBackupVaultMethod =
              getCreateBackupVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackupVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest
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
          com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest,
          com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse>
      getListBackupVaultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupVaults",
      requestType = com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest,
          com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse>
      getListBackupVaultsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest,
            com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse>
        getListBackupVaultsMethod;
    if ((getListBackupVaultsMethod = BackupDRGrpc.getListBackupVaultsMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListBackupVaultsMethod = BackupDRGrpc.getListBackupVaultsMethod) == null) {
          BackupDRGrpc.getListBackupVaultsMethod =
              getListBackupVaultsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest,
                          com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackupVaults"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("ListBackupVaults"))
                      .build();
        }
      }
    }
    return getListBackupVaultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest,
          com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse>
      getFetchUsableBackupVaultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchUsableBackupVaults",
      requestType = com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest,
          com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse>
      getFetchUsableBackupVaultsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest,
            com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse>
        getFetchUsableBackupVaultsMethod;
    if ((getFetchUsableBackupVaultsMethod = BackupDRGrpc.getFetchUsableBackupVaultsMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getFetchUsableBackupVaultsMethod = BackupDRGrpc.getFetchUsableBackupVaultsMethod)
            == null) {
          BackupDRGrpc.getFetchUsableBackupVaultsMethod =
              getFetchUsableBackupVaultsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest,
                          com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchUsableBackupVaults"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse
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
          com.google.cloud.backupdr.v1beta.GetBackupVaultRequest,
          com.google.cloud.backupdr.v1beta.BackupVault>
      getGetBackupVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupVault",
      requestType = com.google.cloud.backupdr.v1beta.GetBackupVaultRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.BackupVault.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.GetBackupVaultRequest,
          com.google.cloud.backupdr.v1beta.BackupVault>
      getGetBackupVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.GetBackupVaultRequest,
            com.google.cloud.backupdr.v1beta.BackupVault>
        getGetBackupVaultMethod;
    if ((getGetBackupVaultMethod = BackupDRGrpc.getGetBackupVaultMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetBackupVaultMethod = BackupDRGrpc.getGetBackupVaultMethod) == null) {
          BackupDRGrpc.getGetBackupVaultMethod =
              getGetBackupVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.GetBackupVaultRequest,
                          com.google.cloud.backupdr.v1beta.BackupVault>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackupVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.GetBackupVaultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.BackupVault.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("GetBackupVault"))
                      .build();
        }
      }
    }
    return getGetBackupVaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest,
          com.google.longrunning.Operation>
      getUpdateBackupVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackupVault",
      requestType = com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest,
          com.google.longrunning.Operation>
      getUpdateBackupVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest,
            com.google.longrunning.Operation>
        getUpdateBackupVaultMethod;
    if ((getUpdateBackupVaultMethod = BackupDRGrpc.getUpdateBackupVaultMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getUpdateBackupVaultMethod = BackupDRGrpc.getUpdateBackupVaultMethod) == null) {
          BackupDRGrpc.getUpdateBackupVaultMethod =
              getUpdateBackupVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackupVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest
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
          com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest,
          com.google.longrunning.Operation>
      getDeleteBackupVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackupVault",
      requestType = com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest,
          com.google.longrunning.Operation>
      getDeleteBackupVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest,
            com.google.longrunning.Operation>
        getDeleteBackupVaultMethod;
    if ((getDeleteBackupVaultMethod = BackupDRGrpc.getDeleteBackupVaultMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteBackupVaultMethod = BackupDRGrpc.getDeleteBackupVaultMethod) == null) {
          BackupDRGrpc.getDeleteBackupVaultMethod =
              getDeleteBackupVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackupVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest
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
          com.google.cloud.backupdr.v1beta.ListDataSourcesRequest,
          com.google.cloud.backupdr.v1beta.ListDataSourcesResponse>
      getListDataSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataSources",
      requestType = com.google.cloud.backupdr.v1beta.ListDataSourcesRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.ListDataSourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListDataSourcesRequest,
          com.google.cloud.backupdr.v1beta.ListDataSourcesResponse>
      getListDataSourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.ListDataSourcesRequest,
            com.google.cloud.backupdr.v1beta.ListDataSourcesResponse>
        getListDataSourcesMethod;
    if ((getListDataSourcesMethod = BackupDRGrpc.getListDataSourcesMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListDataSourcesMethod = BackupDRGrpc.getListDataSourcesMethod) == null) {
          BackupDRGrpc.getListDataSourcesMethod =
              getListDataSourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.ListDataSourcesRequest,
                          com.google.cloud.backupdr.v1beta.ListDataSourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataSources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListDataSourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListDataSourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("ListDataSources"))
                      .build();
        }
      }
    }
    return getListDataSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.GetDataSourceRequest,
          com.google.cloud.backupdr.v1beta.DataSource>
      getGetDataSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataSource",
      requestType = com.google.cloud.backupdr.v1beta.GetDataSourceRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.DataSource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.GetDataSourceRequest,
          com.google.cloud.backupdr.v1beta.DataSource>
      getGetDataSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.GetDataSourceRequest,
            com.google.cloud.backupdr.v1beta.DataSource>
        getGetDataSourceMethod;
    if ((getGetDataSourceMethod = BackupDRGrpc.getGetDataSourceMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetDataSourceMethod = BackupDRGrpc.getGetDataSourceMethod) == null) {
          BackupDRGrpc.getGetDataSourceMethod =
              getGetDataSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.GetDataSourceRequest,
                          com.google.cloud.backupdr.v1beta.DataSource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.GetDataSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.DataSource.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("GetDataSource"))
                      .build();
        }
      }
    }
    return getGetDataSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest,
          com.google.longrunning.Operation>
      getUpdateDataSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataSource",
      requestType = com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest,
          com.google.longrunning.Operation>
      getUpdateDataSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest,
            com.google.longrunning.Operation>
        getUpdateDataSourceMethod;
    if ((getUpdateDataSourceMethod = BackupDRGrpc.getUpdateDataSourceMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getUpdateDataSourceMethod = BackupDRGrpc.getUpdateDataSourceMethod) == null) {
          BackupDRGrpc.getUpdateDataSourceMethod =
              getUpdateDataSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest
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
          com.google.cloud.backupdr.v1beta.ListBackupsRequest,
          com.google.cloud.backupdr.v1beta.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackups",
      requestType = com.google.cloud.backupdr.v1beta.ListBackupsRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.ListBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListBackupsRequest,
          com.google.cloud.backupdr.v1beta.ListBackupsResponse>
      getListBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.ListBackupsRequest,
            com.google.cloud.backupdr.v1beta.ListBackupsResponse>
        getListBackupsMethod;
    if ((getListBackupsMethod = BackupDRGrpc.getListBackupsMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListBackupsMethod = BackupDRGrpc.getListBackupsMethod) == null) {
          BackupDRGrpc.getListBackupsMethod =
              getListBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.ListBackupsRequest,
                          com.google.cloud.backupdr.v1beta.ListBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListBackupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListBackupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("ListBackups"))
                      .build();
        }
      }
    }
    return getListBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest,
          com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse>
      getFetchBackupsForResourceTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchBackupsForResourceType",
      requestType = com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest,
          com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse>
      getFetchBackupsForResourceTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest,
            com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse>
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
                      .<com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest,
                          com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchBackupsForResourceType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse
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
          com.google.cloud.backupdr.v1beta.GetBackupRequest,
          com.google.cloud.backupdr.v1beta.Backup>
      getGetBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackup",
      requestType = com.google.cloud.backupdr.v1beta.GetBackupRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.GetBackupRequest,
          com.google.cloud.backupdr.v1beta.Backup>
      getGetBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.GetBackupRequest,
            com.google.cloud.backupdr.v1beta.Backup>
        getGetBackupMethod;
    if ((getGetBackupMethod = BackupDRGrpc.getGetBackupMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetBackupMethod = BackupDRGrpc.getGetBackupMethod) == null) {
          BackupDRGrpc.getGetBackupMethod =
              getGetBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.GetBackupRequest,
                          com.google.cloud.backupdr.v1beta.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.GetBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("GetBackup"))
                      .build();
        }
      }
    }
    return getGetBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackup",
      requestType = com.google.cloud.backupdr.v1beta.UpdateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.UpdateBackupRequest, com.google.longrunning.Operation>
        getUpdateBackupMethod;
    if ((getUpdateBackupMethod = BackupDRGrpc.getUpdateBackupMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getUpdateBackupMethod = BackupDRGrpc.getUpdateBackupMethod) == null) {
          BackupDRGrpc.getUpdateBackupMethod =
              getUpdateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.UpdateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.UpdateBackupRequest
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
          com.google.cloud.backupdr.v1beta.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackup",
      requestType = com.google.cloud.backupdr.v1beta.DeleteBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.DeleteBackupRequest, com.google.longrunning.Operation>
        getDeleteBackupMethod;
    if ((getDeleteBackupMethod = BackupDRGrpc.getDeleteBackupMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteBackupMethod = BackupDRGrpc.getDeleteBackupMethod) == null) {
          BackupDRGrpc.getDeleteBackupMethod =
              getDeleteBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.DeleteBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.DeleteBackupRequest
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
          com.google.cloud.backupdr.v1beta.RestoreBackupRequest, com.google.longrunning.Operation>
      getRestoreBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreBackup",
      requestType = com.google.cloud.backupdr.v1beta.RestoreBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.RestoreBackupRequest, com.google.longrunning.Operation>
      getRestoreBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.RestoreBackupRequest, com.google.longrunning.Operation>
        getRestoreBackupMethod;
    if ((getRestoreBackupMethod = BackupDRGrpc.getRestoreBackupMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getRestoreBackupMethod = BackupDRGrpc.getRestoreBackupMethod) == null) {
          BackupDRGrpc.getRestoreBackupMethod =
              getRestoreBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.RestoreBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.RestoreBackupRequest
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
          com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest,
          com.google.longrunning.Operation>
      getCreateBackupPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackupPlan",
      requestType = com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest,
          com.google.longrunning.Operation>
      getCreateBackupPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest,
            com.google.longrunning.Operation>
        getCreateBackupPlanMethod;
    if ((getCreateBackupPlanMethod = BackupDRGrpc.getCreateBackupPlanMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getCreateBackupPlanMethod = BackupDRGrpc.getCreateBackupPlanMethod) == null) {
          BackupDRGrpc.getCreateBackupPlanMethod =
              getCreateBackupPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackupPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest
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
          com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest,
          com.google.longrunning.Operation>
      getUpdateBackupPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackupPlan",
      requestType = com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest,
          com.google.longrunning.Operation>
      getUpdateBackupPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest,
            com.google.longrunning.Operation>
        getUpdateBackupPlanMethod;
    if ((getUpdateBackupPlanMethod = BackupDRGrpc.getUpdateBackupPlanMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getUpdateBackupPlanMethod = BackupDRGrpc.getUpdateBackupPlanMethod) == null) {
          BackupDRGrpc.getUpdateBackupPlanMethod =
              getUpdateBackupPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackupPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest
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
          com.google.cloud.backupdr.v1beta.GetBackupPlanRequest,
          com.google.cloud.backupdr.v1beta.BackupPlan>
      getGetBackupPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupPlan",
      requestType = com.google.cloud.backupdr.v1beta.GetBackupPlanRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.BackupPlan.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.GetBackupPlanRequest,
          com.google.cloud.backupdr.v1beta.BackupPlan>
      getGetBackupPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.GetBackupPlanRequest,
            com.google.cloud.backupdr.v1beta.BackupPlan>
        getGetBackupPlanMethod;
    if ((getGetBackupPlanMethod = BackupDRGrpc.getGetBackupPlanMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetBackupPlanMethod = BackupDRGrpc.getGetBackupPlanMethod) == null) {
          BackupDRGrpc.getGetBackupPlanMethod =
              getGetBackupPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.GetBackupPlanRequest,
                          com.google.cloud.backupdr.v1beta.BackupPlan>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackupPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.GetBackupPlanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.BackupPlan.getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("GetBackupPlan"))
                      .build();
        }
      }
    }
    return getGetBackupPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListBackupPlansRequest,
          com.google.cloud.backupdr.v1beta.ListBackupPlansResponse>
      getListBackupPlansMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupPlans",
      requestType = com.google.cloud.backupdr.v1beta.ListBackupPlansRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.ListBackupPlansResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListBackupPlansRequest,
          com.google.cloud.backupdr.v1beta.ListBackupPlansResponse>
      getListBackupPlansMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.ListBackupPlansRequest,
            com.google.cloud.backupdr.v1beta.ListBackupPlansResponse>
        getListBackupPlansMethod;
    if ((getListBackupPlansMethod = BackupDRGrpc.getListBackupPlansMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListBackupPlansMethod = BackupDRGrpc.getListBackupPlansMethod) == null) {
          BackupDRGrpc.getListBackupPlansMethod =
              getListBackupPlansMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.ListBackupPlansRequest,
                          com.google.cloud.backupdr.v1beta.ListBackupPlansResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackupPlans"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListBackupPlansRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListBackupPlansResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BackupDRMethodDescriptorSupplier("ListBackupPlans"))
                      .build();
        }
      }
    }
    return getListBackupPlansMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest,
          com.google.longrunning.Operation>
      getDeleteBackupPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackupPlan",
      requestType = com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest,
          com.google.longrunning.Operation>
      getDeleteBackupPlanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest,
            com.google.longrunning.Operation>
        getDeleteBackupPlanMethod;
    if ((getDeleteBackupPlanMethod = BackupDRGrpc.getDeleteBackupPlanMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteBackupPlanMethod = BackupDRGrpc.getDeleteBackupPlanMethod) == null) {
          BackupDRGrpc.getDeleteBackupPlanMethod =
              getDeleteBackupPlanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackupPlan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest
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
          com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest,
          com.google.cloud.backupdr.v1beta.BackupPlanRevision>
      getGetBackupPlanRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupPlanRevision",
      requestType = com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.BackupPlanRevision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest,
          com.google.cloud.backupdr.v1beta.BackupPlanRevision>
      getGetBackupPlanRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest,
            com.google.cloud.backupdr.v1beta.BackupPlanRevision>
        getGetBackupPlanRevisionMethod;
    if ((getGetBackupPlanRevisionMethod = BackupDRGrpc.getGetBackupPlanRevisionMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetBackupPlanRevisionMethod = BackupDRGrpc.getGetBackupPlanRevisionMethod)
            == null) {
          BackupDRGrpc.getGetBackupPlanRevisionMethod =
              getGetBackupPlanRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest,
                          com.google.cloud.backupdr.v1beta.BackupPlanRevision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetBackupPlanRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.BackupPlanRevision
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("GetBackupPlanRevision"))
                      .build();
        }
      }
    }
    return getGetBackupPlanRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest,
          com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse>
      getListBackupPlanRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupPlanRevisions",
      requestType = com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest,
          com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse>
      getListBackupPlanRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest,
            com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse>
        getListBackupPlanRevisionsMethod;
    if ((getListBackupPlanRevisionsMethod = BackupDRGrpc.getListBackupPlanRevisionsMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListBackupPlanRevisionsMethod = BackupDRGrpc.getListBackupPlanRevisionsMethod)
            == null) {
          BackupDRGrpc.getListBackupPlanRevisionsMethod =
              getListBackupPlanRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest,
                          com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBackupPlanRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse
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
          com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest,
          com.google.longrunning.Operation>
      getCreateBackupPlanAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackupPlanAssociation",
      requestType = com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest,
          com.google.longrunning.Operation>
      getCreateBackupPlanAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest,
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
                      .<com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateBackupPlanAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest
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
          com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest,
          com.google.longrunning.Operation>
      getUpdateBackupPlanAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackupPlanAssociation",
      requestType = com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest,
          com.google.longrunning.Operation>
      getUpdateBackupPlanAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest,
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
                      .<com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateBackupPlanAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest
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
          com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest,
          com.google.cloud.backupdr.v1beta.BackupPlanAssociation>
      getGetBackupPlanAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupPlanAssociation",
      requestType = com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.BackupPlanAssociation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest,
          com.google.cloud.backupdr.v1beta.BackupPlanAssociation>
      getGetBackupPlanAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest,
            com.google.cloud.backupdr.v1beta.BackupPlanAssociation>
        getGetBackupPlanAssociationMethod;
    if ((getGetBackupPlanAssociationMethod = BackupDRGrpc.getGetBackupPlanAssociationMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetBackupPlanAssociationMethod = BackupDRGrpc.getGetBackupPlanAssociationMethod)
            == null) {
          BackupDRGrpc.getGetBackupPlanAssociationMethod =
              getGetBackupPlanAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest,
                          com.google.cloud.backupdr.v1beta.BackupPlanAssociation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetBackupPlanAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.BackupPlanAssociation
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
          com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest,
          com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse>
      getListBackupPlanAssociationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupPlanAssociations",
      requestType = com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest,
          com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse>
      getListBackupPlanAssociationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest,
            com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse>
        getListBackupPlanAssociationsMethod;
    if ((getListBackupPlanAssociationsMethod = BackupDRGrpc.getListBackupPlanAssociationsMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListBackupPlanAssociationsMethod = BackupDRGrpc.getListBackupPlanAssociationsMethod)
            == null) {
          BackupDRGrpc.getListBackupPlanAssociationsMethod =
              getListBackupPlanAssociationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest,
                          com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBackupPlanAssociations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse
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
          com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeRequest,
          com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeResponse>
      getFetchBackupPlanAssociationsForResourceTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchBackupPlanAssociationsForResourceType",
      requestType =
          com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeRequest.class,
      responseType =
          com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeRequest,
          com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeResponse>
      getFetchBackupPlanAssociationsForResourceTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeRequest,
            com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeResponse>
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
                      .<com.google.cloud.backupdr.v1beta
                              .FetchBackupPlanAssociationsForResourceTypeRequest,
                          com.google.cloud.backupdr.v1beta
                              .FetchBackupPlanAssociationsForResourceTypeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "FetchBackupPlanAssociationsForResourceType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta
                                  .FetchBackupPlanAssociationsForResourceTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta
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
          com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest,
          com.google.longrunning.Operation>
      getDeleteBackupPlanAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackupPlanAssociation",
      requestType = com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest,
          com.google.longrunning.Operation>
      getDeleteBackupPlanAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest,
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
                      .<com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteBackupPlanAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest
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
          com.google.cloud.backupdr.v1beta.TriggerBackupRequest, com.google.longrunning.Operation>
      getTriggerBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TriggerBackup",
      requestType = com.google.cloud.backupdr.v1beta.TriggerBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.TriggerBackupRequest, com.google.longrunning.Operation>
      getTriggerBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.TriggerBackupRequest, com.google.longrunning.Operation>
        getTriggerBackupMethod;
    if ((getTriggerBackupMethod = BackupDRGrpc.getTriggerBackupMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getTriggerBackupMethod = BackupDRGrpc.getTriggerBackupMethod) == null) {
          BackupDRGrpc.getTriggerBackupMethod =
              getTriggerBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.TriggerBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TriggerBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.TriggerBackupRequest
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
          com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest,
          com.google.cloud.backupdr.v1beta.DataSourceReference>
      getGetDataSourceReferenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataSourceReference",
      requestType = com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.DataSourceReference.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest,
          com.google.cloud.backupdr.v1beta.DataSourceReference>
      getGetDataSourceReferenceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest,
            com.google.cloud.backupdr.v1beta.DataSourceReference>
        getGetDataSourceReferenceMethod;
    if ((getGetDataSourceReferenceMethod = BackupDRGrpc.getGetDataSourceReferenceMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetDataSourceReferenceMethod = BackupDRGrpc.getGetDataSourceReferenceMethod)
            == null) {
          BackupDRGrpc.getGetDataSourceReferenceMethod =
              getGetDataSourceReferenceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest,
                          com.google.cloud.backupdr.v1beta.DataSourceReference>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDataSourceReference"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.DataSourceReference
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
          com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest,
          com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse>
      getListDataSourceReferencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataSourceReferences",
      requestType = com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest,
          com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse>
      getListDataSourceReferencesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest,
            com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse>
        getListDataSourceReferencesMethod;
    if ((getListDataSourceReferencesMethod = BackupDRGrpc.getListDataSourceReferencesMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListDataSourceReferencesMethod = BackupDRGrpc.getListDataSourceReferencesMethod)
            == null) {
          BackupDRGrpc.getListDataSourceReferencesMethod =
              getListDataSourceReferencesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest,
                          com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDataSourceReferences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse
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
          com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeRequest,
          com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeResponse>
      getFetchDataSourceReferencesForResourceTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchDataSourceReferencesForResourceType",
      requestType =
          com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeRequest.class,
      responseType =
          com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeRequest,
          com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeResponse>
      getFetchDataSourceReferencesForResourceTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeRequest,
            com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeResponse>
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
                      .<com.google.cloud.backupdr.v1beta
                              .FetchDataSourceReferencesForResourceTypeRequest,
                          com.google.cloud.backupdr.v1beta
                              .FetchDataSourceReferencesForResourceTypeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "FetchDataSourceReferencesForResourceType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta
                                  .FetchDataSourceReferencesForResourceTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta
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
          com.google.cloud.backupdr.v1beta.InitializeServiceRequest,
          com.google.longrunning.Operation>
      getInitializeServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InitializeService",
      requestType = com.google.cloud.backupdr.v1beta.InitializeServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.InitializeServiceRequest,
          com.google.longrunning.Operation>
      getInitializeServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.InitializeServiceRequest,
            com.google.longrunning.Operation>
        getInitializeServiceMethod;
    if ((getInitializeServiceMethod = BackupDRGrpc.getInitializeServiceMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getInitializeServiceMethod = BackupDRGrpc.getInitializeServiceMethod) == null) {
          BackupDRGrpc.getInitializeServiceMethod =
              getInitializeServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.InitializeServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InitializeService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.InitializeServiceRequest
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
          com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest,
          com.google.longrunning.Operation>
      getCreateAutoProtectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAutoProtectionPolicy",
      requestType = com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest,
          com.google.longrunning.Operation>
      getCreateAutoProtectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest,
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
                      .<com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAutoProtectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest
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
          com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest,
          com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse>
      getListAutoProtectionPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAutoProtectionPolicies",
      requestType = com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest,
          com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse>
      getListAutoProtectionPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest,
            com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse>
        getListAutoProtectionPoliciesMethod;
    if ((getListAutoProtectionPoliciesMethod = BackupDRGrpc.getListAutoProtectionPoliciesMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListAutoProtectionPoliciesMethod = BackupDRGrpc.getListAutoProtectionPoliciesMethod)
            == null) {
          BackupDRGrpc.getListAutoProtectionPoliciesMethod =
              getListAutoProtectionPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest,
                          com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAutoProtectionPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse
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
          com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest,
          com.google.cloud.backupdr.v1beta.AutoProtectionPolicy>
      getGetAutoProtectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAutoProtectionPolicy",
      requestType = com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.AutoProtectionPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest,
          com.google.cloud.backupdr.v1beta.AutoProtectionPolicy>
      getGetAutoProtectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest,
            com.google.cloud.backupdr.v1beta.AutoProtectionPolicy>
        getGetAutoProtectionPolicyMethod;
    if ((getGetAutoProtectionPolicyMethod = BackupDRGrpc.getGetAutoProtectionPolicyMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetAutoProtectionPolicyMethod = BackupDRGrpc.getGetAutoProtectionPolicyMethod)
            == null) {
          BackupDRGrpc.getGetAutoProtectionPolicyMethod =
              getGetAutoProtectionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest,
                          com.google.cloud.backupdr.v1beta.AutoProtectionPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAutoProtectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.AutoProtectionPolicy
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
          com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateAutoProtectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAutoProtectionPolicy",
      requestType = com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateAutoProtectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest,
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
                      .<com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAutoProtectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest
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
          com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteAutoProtectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAutoProtectionPolicy",
      requestType = com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteAutoProtectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest,
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
                      .<com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAutoProtectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest
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
          com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyBindingRequest,
          com.google.longrunning.Operation>
      getCreateAutoProtectionPolicyBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAutoProtectionPolicyBinding",
      requestType = com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyBindingRequest,
          com.google.longrunning.Operation>
      getCreateAutoProtectionPolicyBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyBindingRequest,
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
                      .<com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAutoProtectionPolicyBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta
                                  .CreateAutoProtectionPolicyBindingRequest.getDefaultInstance()))
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
          com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest,
          com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding>
      getGetAutoProtectionPolicyBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAutoProtectionPolicyBinding",
      requestType = com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest,
          com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding>
      getGetAutoProtectionPolicyBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest,
            com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding>
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
                      .<com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest,
                          com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAutoProtectionPolicyBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding
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
          com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsRequest,
          com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsResponse>
      getListAutoProtectionPolicyBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAutoProtectionPolicyBindings",
      requestType = com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsRequest.class,
      responseType =
          com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsRequest,
          com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsResponse>
      getListAutoProtectionPolicyBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsRequest,
            com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsResponse>
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
                      .<com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsRequest,
                          com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAutoProtectionPolicyBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta
                                  .ListAutoProtectionPolicyBindingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta
                                  .ListAutoProtectionPolicyBindingsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListAutoProtectionPolicyBindings"))
                      .build();
        }
      }
    }
    return getListAutoProtectionPolicyBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesRequest,
          com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesResponse>
      getListAppliedAutoProtectionPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAppliedAutoProtectionPolicies",
      requestType = com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesRequest.class,
      responseType =
          com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesRequest,
          com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesResponse>
      getListAppliedAutoProtectionPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesRequest,
            com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesResponse>
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
                      .<com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesRequest,
                          com.google.cloud.backupdr.v1beta
                              .ListAppliedAutoProtectionPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAppliedAutoProtectionPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta
                                  .ListAppliedAutoProtectionPoliciesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta
                                  .ListAppliedAutoProtectionPoliciesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListAppliedAutoProtectionPolicies"))
                      .build();
        }
      }
    }
    return getListAppliedAutoProtectionPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.InitiateDeleteAutoProtectionPolicyBindingRequest,
          com.google.longrunning.Operation>
      getInitiateDeleteAutoProtectionPolicyBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InitiateDeleteAutoProtectionPolicyBinding",
      requestType =
          com.google.cloud.backupdr.v1beta.InitiateDeleteAutoProtectionPolicyBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.InitiateDeleteAutoProtectionPolicyBindingRequest,
          com.google.longrunning.Operation>
      getInitiateDeleteAutoProtectionPolicyBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.InitiateDeleteAutoProtectionPolicyBindingRequest,
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
                      .<com.google.cloud.backupdr.v1beta
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
                              com.google.cloud.backupdr.v1beta
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
          com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest,
          com.google.cloud.backupdr.v1beta.BindingMatchingResource>
      getGetBindingMatchingResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBindingMatchingResource",
      requestType = com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.BindingMatchingResource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest,
          com.google.cloud.backupdr.v1beta.BindingMatchingResource>
      getGetBindingMatchingResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest,
            com.google.cloud.backupdr.v1beta.BindingMatchingResource>
        getGetBindingMatchingResourceMethod;
    if ((getGetBindingMatchingResourceMethod = BackupDRGrpc.getGetBindingMatchingResourceMethod)
        == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetBindingMatchingResourceMethod = BackupDRGrpc.getGetBindingMatchingResourceMethod)
            == null) {
          BackupDRGrpc.getGetBindingMatchingResourceMethod =
              getGetBindingMatchingResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest,
                          com.google.cloud.backupdr.v1beta.BindingMatchingResource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetBindingMatchingResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.BindingMatchingResource
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("GetBindingMatchingResource"))
                      .build();
        }
      }
    }
    return getGetBindingMatchingResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest,
          com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse>
      getListBindingMatchingResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBindingMatchingResources",
      requestType = com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest.class,
      responseType = com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest,
          com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse>
      getListBindingMatchingResourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest,
            com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse>
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
                      .<com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest,
                          com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBindingMatchingResources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListBindingMatchingResources"))
                      .build();
        }
      }
    }
    return getListBindingMatchingResourcesMethod;
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
        com.google.cloud.backupdr.v1beta.ListManagementServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ListManagementServersResponse>
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
        com.google.cloud.backupdr.v1beta.GetManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ManagementServer>
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
        com.google.cloud.backupdr.v1beta.CreateManagementServerRequest request,
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
        com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest request,
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
        com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest request,
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
        com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse>
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
        com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse>
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
        com.google.cloud.backupdr.v1beta.GetBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BackupVault>
            responseObserver) {
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
        com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest request,
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
        com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest request,
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
        com.google.cloud.backupdr.v1beta.ListDataSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ListDataSourcesResponse>
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
        com.google.cloud.backupdr.v1beta.GetDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.DataSource> responseObserver) {
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
        com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest request,
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
        com.google.cloud.backupdr.v1beta.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ListBackupsResponse>
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
        com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse>
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
        com.google.cloud.backupdr.v1beta.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.Backup> responseObserver) {
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
        com.google.cloud.backupdr.v1beta.UpdateBackupRequest request,
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
        com.google.cloud.backupdr.v1beta.DeleteBackupRequest request,
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
        com.google.cloud.backupdr.v1beta.RestoreBackupRequest request,
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
        com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest request,
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
        com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest request,
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
        com.google.cloud.backupdr.v1beta.GetBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BackupPlan> responseObserver) {
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
        com.google.cloud.backupdr.v1beta.ListBackupPlansRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ListBackupPlansResponse>
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
        com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest request,
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
        com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BackupPlanRevision>
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
        com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse>
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
        com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest request,
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
        com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest request,
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
        com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BackupPlanAssociation>
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
        com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse>
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
        com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeResponse>
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
        com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest request,
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
        com.google.cloud.backupdr.v1beta.TriggerBackupRequest request,
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
        com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.DataSourceReference>
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
        com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse>
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
        com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeResponse>
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
        com.google.cloud.backupdr.v1beta.InitializeServiceRequest request,
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
        com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest request,
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
        com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse>
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
        com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.AutoProtectionPolicy>
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
        com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest request,
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
        com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest request,
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
        com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyBindingRequest request,
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
        com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding>
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
        com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsResponse>
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
        com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesResponse>
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
        com.google.cloud.backupdr.v1beta.InitiateDeleteAutoProtectionPolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInitiateDeleteAutoProtectionPolicyBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Binding Matching Resource.
     * </pre>
     */
    default void getBindingMatchingResource(
        com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BindingMatchingResource>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBindingMatchingResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Binding Matching Resources for a given AutoProtectionPolicyBinding.
     * </pre>
     */
    default void listBindingMatchingResources(
        com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBindingMatchingResourcesMethod(), responseObserver);
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
        com.google.cloud.backupdr.v1beta.ListManagementServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ListManagementServersResponse>
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
        com.google.cloud.backupdr.v1beta.GetManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ManagementServer>
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
        com.google.cloud.backupdr.v1beta.CreateManagementServerRequest request,
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
        com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest request,
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
        com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest request,
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
        com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse>
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
        com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse>
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
        com.google.cloud.backupdr.v1beta.GetBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BackupVault>
            responseObserver) {
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
        com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest request,
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
        com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest request,
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
        com.google.cloud.backupdr.v1beta.ListDataSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ListDataSourcesResponse>
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
        com.google.cloud.backupdr.v1beta.GetDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.DataSource> responseObserver) {
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
        com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest request,
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
        com.google.cloud.backupdr.v1beta.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ListBackupsResponse>
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
        com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse>
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
        com.google.cloud.backupdr.v1beta.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.Backup> responseObserver) {
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
        com.google.cloud.backupdr.v1beta.UpdateBackupRequest request,
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
        com.google.cloud.backupdr.v1beta.DeleteBackupRequest request,
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
        com.google.cloud.backupdr.v1beta.RestoreBackupRequest request,
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
        com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest request,
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
        com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest request,
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
        com.google.cloud.backupdr.v1beta.GetBackupPlanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BackupPlan> responseObserver) {
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
        com.google.cloud.backupdr.v1beta.ListBackupPlansRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ListBackupPlansResponse>
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
        com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest request,
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
        com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BackupPlanRevision>
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
        com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse>
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
        com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest request,
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
        com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest request,
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
        com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BackupPlanAssociation>
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
        com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse>
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
        com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeResponse>
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
        com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest request,
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
        com.google.cloud.backupdr.v1beta.TriggerBackupRequest request,
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
        com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.DataSourceReference>
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
        com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse>
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
        com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeResponse>
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
        com.google.cloud.backupdr.v1beta.InitializeServiceRequest request,
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
        com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest request,
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
        com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse>
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
        com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.AutoProtectionPolicy>
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
        com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest request,
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
        com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest request,
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
        com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyBindingRequest request,
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
        com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding>
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
        com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsResponse>
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
        com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesResponse>
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
        com.google.cloud.backupdr.v1beta.InitiateDeleteAutoProtectionPolicyBindingRequest request,
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
     * Gets details of a single Binding Matching Resource.
     * </pre>
     */
    public void getBindingMatchingResource(
        com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BindingMatchingResource>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBindingMatchingResourceMethod(), getCallOptions()),
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
        com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBindingMatchingResourcesMethod(), getCallOptions()),
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
    public com.google.cloud.backupdr.v1beta.ListManagementServersResponse listManagementServers(
        com.google.cloud.backupdr.v1beta.ListManagementServersRequest request)
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
    public com.google.cloud.backupdr.v1beta.ManagementServer getManagementServer(
        com.google.cloud.backupdr.v1beta.GetManagementServerRequest request)
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
        com.google.cloud.backupdr.v1beta.CreateManagementServerRequest request)
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
        com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest request)
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
        com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest request)
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
    public com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse listBackupVaults(
        com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest request)
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
    public com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse fetchUsableBackupVaults(
        com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest request)
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
    public com.google.cloud.backupdr.v1beta.BackupVault getBackupVault(
        com.google.cloud.backupdr.v1beta.GetBackupVaultRequest request)
        throws io.grpc.StatusException {
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
        com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest request)
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
        com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest request)
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
    public com.google.cloud.backupdr.v1beta.ListDataSourcesResponse listDataSources(
        com.google.cloud.backupdr.v1beta.ListDataSourcesRequest request)
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
    public com.google.cloud.backupdr.v1beta.DataSource getDataSource(
        com.google.cloud.backupdr.v1beta.GetDataSourceRequest request)
        throws io.grpc.StatusException {
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
        com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest request)
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
    public com.google.cloud.backupdr.v1beta.ListBackupsResponse listBackups(
        com.google.cloud.backupdr.v1beta.ListBackupsRequest request)
        throws io.grpc.StatusException {
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
    public com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse
        fetchBackupsForResourceType(
            com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest request)
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
    public com.google.cloud.backupdr.v1beta.Backup getBackup(
        com.google.cloud.backupdr.v1beta.GetBackupRequest request) throws io.grpc.StatusException {
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
        com.google.cloud.backupdr.v1beta.UpdateBackupRequest request)
        throws io.grpc.StatusException {
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
        com.google.cloud.backupdr.v1beta.DeleteBackupRequest request)
        throws io.grpc.StatusException {
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
        com.google.cloud.backupdr.v1beta.RestoreBackupRequest request)
        throws io.grpc.StatusException {
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
        com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest request)
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
        com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest request)
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
    public com.google.cloud.backupdr.v1beta.BackupPlan getBackupPlan(
        com.google.cloud.backupdr.v1beta.GetBackupPlanRequest request)
        throws io.grpc.StatusException {
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
    public com.google.cloud.backupdr.v1beta.ListBackupPlansResponse listBackupPlans(
        com.google.cloud.backupdr.v1beta.ListBackupPlansRequest request)
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
        com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest request)
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
    public com.google.cloud.backupdr.v1beta.BackupPlanRevision getBackupPlanRevision(
        com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest request)
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
    public com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse listBackupPlanRevisions(
        com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest request)
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
        com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest request)
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
        com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest request)
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
    public com.google.cloud.backupdr.v1beta.BackupPlanAssociation getBackupPlanAssociation(
        com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest request)
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
    public com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse
        listBackupPlanAssociations(
            com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest request)
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
    public com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeResponse
        fetchBackupPlanAssociationsForResourceType(
            com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeRequest
                request)
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
        com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest request)
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
        com.google.cloud.backupdr.v1beta.TriggerBackupRequest request)
        throws io.grpc.StatusException {
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
    public com.google.cloud.backupdr.v1beta.DataSourceReference getDataSourceReference(
        com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest request)
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
    public com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse
        listDataSourceReferences(
            com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest request)
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
    public com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeResponse
        fetchDataSourceReferencesForResourceType(
            com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeRequest
                request)
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
        com.google.cloud.backupdr.v1beta.InitializeServiceRequest request)
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
        com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest request)
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
    public com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse
        listAutoProtectionPolicies(
            com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest request)
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
    public com.google.cloud.backupdr.v1beta.AutoProtectionPolicy getAutoProtectionPolicy(
        com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest request)
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
        com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest request)
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
        com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest request)
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
        com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyBindingRequest request)
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
    public com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding
        getAutoProtectionPolicyBinding(
            com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest request)
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
    public com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsResponse
        listAutoProtectionPolicyBindings(
            com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsRequest request)
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
    public com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesResponse
        listAppliedAutoProtectionPolicies(
            com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesRequest request)
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
        com.google.cloud.backupdr.v1beta.InitiateDeleteAutoProtectionPolicyBindingRequest request)
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
     * Gets details of a single Binding Matching Resource.
     * </pre>
     */
    public com.google.cloud.backupdr.v1beta.BindingMatchingResource getBindingMatchingResource(
        com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBindingMatchingResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Binding Matching Resources for a given AutoProtectionPolicyBinding.
     * </pre>
     */
    public com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse
        listBindingMatchingResources(
            com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBindingMatchingResourcesMethod(), getCallOptions(), request);
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
    public com.google.cloud.backupdr.v1beta.ListManagementServersResponse listManagementServers(
        com.google.cloud.backupdr.v1beta.ListManagementServersRequest request) {
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
    public com.google.cloud.backupdr.v1beta.ManagementServer getManagementServer(
        com.google.cloud.backupdr.v1beta.GetManagementServerRequest request) {
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
        com.google.cloud.backupdr.v1beta.CreateManagementServerRequest request) {
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
        com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest request) {
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
        com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest request) {
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
    public com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse listBackupVaults(
        com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest request) {
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
    public com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse fetchUsableBackupVaults(
        com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest request) {
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
    public com.google.cloud.backupdr.v1beta.BackupVault getBackupVault(
        com.google.cloud.backupdr.v1beta.GetBackupVaultRequest request) {
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
        com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest request) {
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
        com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest request) {
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
    public com.google.cloud.backupdr.v1beta.ListDataSourcesResponse listDataSources(
        com.google.cloud.backupdr.v1beta.ListDataSourcesRequest request) {
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
    public com.google.cloud.backupdr.v1beta.DataSource getDataSource(
        com.google.cloud.backupdr.v1beta.GetDataSourceRequest request) {
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
        com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest request) {
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
    public com.google.cloud.backupdr.v1beta.ListBackupsResponse listBackups(
        com.google.cloud.backupdr.v1beta.ListBackupsRequest request) {
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
    public com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse
        fetchBackupsForResourceType(
            com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest request) {
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
    public com.google.cloud.backupdr.v1beta.Backup getBackup(
        com.google.cloud.backupdr.v1beta.GetBackupRequest request) {
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
        com.google.cloud.backupdr.v1beta.UpdateBackupRequest request) {
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
        com.google.cloud.backupdr.v1beta.DeleteBackupRequest request) {
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
        com.google.cloud.backupdr.v1beta.RestoreBackupRequest request) {
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
        com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest request) {
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
        com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest request) {
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
    public com.google.cloud.backupdr.v1beta.BackupPlan getBackupPlan(
        com.google.cloud.backupdr.v1beta.GetBackupPlanRequest request) {
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
    public com.google.cloud.backupdr.v1beta.ListBackupPlansResponse listBackupPlans(
        com.google.cloud.backupdr.v1beta.ListBackupPlansRequest request) {
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
        com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest request) {
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
    public com.google.cloud.backupdr.v1beta.BackupPlanRevision getBackupPlanRevision(
        com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest request) {
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
    public com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse listBackupPlanRevisions(
        com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest request) {
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
        com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest request) {
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
        com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest request) {
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
    public com.google.cloud.backupdr.v1beta.BackupPlanAssociation getBackupPlanAssociation(
        com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest request) {
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
    public com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse
        listBackupPlanAssociations(
            com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest request) {
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
    public com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeResponse
        fetchBackupPlanAssociationsForResourceType(
            com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeRequest
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
        com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest request) {
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
        com.google.cloud.backupdr.v1beta.TriggerBackupRequest request) {
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
    public com.google.cloud.backupdr.v1beta.DataSourceReference getDataSourceReference(
        com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest request) {
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
    public com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse
        listDataSourceReferences(
            com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest request) {
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
    public com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeResponse
        fetchDataSourceReferencesForResourceType(
            com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeRequest
                request) {
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
        com.google.cloud.backupdr.v1beta.InitializeServiceRequest request) {
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
        com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest request) {
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
    public com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse
        listAutoProtectionPolicies(
            com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest request) {
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
    public com.google.cloud.backupdr.v1beta.AutoProtectionPolicy getAutoProtectionPolicy(
        com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest request) {
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
        com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest request) {
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
        com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest request) {
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
        com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyBindingRequest request) {
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
    public com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding
        getAutoProtectionPolicyBinding(
            com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest request) {
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
    public com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsResponse
        listAutoProtectionPolicyBindings(
            com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsRequest request) {
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
    public com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesResponse
        listAppliedAutoProtectionPolicies(
            com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesRequest request) {
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
        com.google.cloud.backupdr.v1beta.InitiateDeleteAutoProtectionPolicyBindingRequest request) {
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
     * Gets details of a single Binding Matching Resource.
     * </pre>
     */
    public com.google.cloud.backupdr.v1beta.BindingMatchingResource getBindingMatchingResource(
        com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBindingMatchingResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Binding Matching Resources for a given AutoProtectionPolicyBinding.
     * </pre>
     */
    public com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse
        listBindingMatchingResources(
            com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBindingMatchingResourcesMethod(), getCallOptions(), request);
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
            com.google.cloud.backupdr.v1beta.ListManagementServersResponse>
        listManagementServers(
            com.google.cloud.backupdr.v1beta.ListManagementServersRequest request) {
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
            com.google.cloud.backupdr.v1beta.ManagementServer>
        getManagementServer(com.google.cloud.backupdr.v1beta.GetManagementServerRequest request) {
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
        createManagementServer(
            com.google.cloud.backupdr.v1beta.CreateManagementServerRequest request) {
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
        deleteManagementServer(
            com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest request) {
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
        createBackupVault(com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest request) {
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
            com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse>
        listBackupVaults(com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest request) {
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
            com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse>
        fetchUsableBackupVaults(
            com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest request) {
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
            com.google.cloud.backupdr.v1beta.BackupVault>
        getBackupVault(com.google.cloud.backupdr.v1beta.GetBackupVaultRequest request) {
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
        updateBackupVault(com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest request) {
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
        deleteBackupVault(com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest request) {
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
            com.google.cloud.backupdr.v1beta.ListDataSourcesResponse>
        listDataSources(com.google.cloud.backupdr.v1beta.ListDataSourcesRequest request) {
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
            com.google.cloud.backupdr.v1beta.DataSource>
        getDataSource(com.google.cloud.backupdr.v1beta.GetDataSourceRequest request) {
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
        updateDataSource(com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest request) {
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
            com.google.cloud.backupdr.v1beta.ListBackupsResponse>
        listBackups(com.google.cloud.backupdr.v1beta.ListBackupsRequest request) {
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
            com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse>
        fetchBackupsForResourceType(
            com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1beta.Backup>
        getBackup(com.google.cloud.backupdr.v1beta.GetBackupRequest request) {
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
        updateBackup(com.google.cloud.backupdr.v1beta.UpdateBackupRequest request) {
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
        deleteBackup(com.google.cloud.backupdr.v1beta.DeleteBackupRequest request) {
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
        restoreBackup(com.google.cloud.backupdr.v1beta.RestoreBackupRequest request) {
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
        createBackupPlan(com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest request) {
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
        updateBackupPlan(com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest request) {
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
            com.google.cloud.backupdr.v1beta.BackupPlan>
        getBackupPlan(com.google.cloud.backupdr.v1beta.GetBackupPlanRequest request) {
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
            com.google.cloud.backupdr.v1beta.ListBackupPlansResponse>
        listBackupPlans(com.google.cloud.backupdr.v1beta.ListBackupPlansRequest request) {
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
        deleteBackupPlan(com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest request) {
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
            com.google.cloud.backupdr.v1beta.BackupPlanRevision>
        getBackupPlanRevision(
            com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest request) {
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
            com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse>
        listBackupPlanRevisions(
            com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest request) {
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
            com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest request) {
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
            com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest request) {
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
            com.google.cloud.backupdr.v1beta.BackupPlanAssociation>
        getBackupPlanAssociation(
            com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest request) {
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
            com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse>
        listBackupPlanAssociations(
            com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest request) {
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
            com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeResponse>
        fetchBackupPlanAssociationsForResourceType(
            com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeRequest
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
            com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest request) {
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
        triggerBackup(com.google.cloud.backupdr.v1beta.TriggerBackupRequest request) {
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
            com.google.cloud.backupdr.v1beta.DataSourceReference>
        getDataSourceReference(
            com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest request) {
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
            com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse>
        listDataSourceReferences(
            com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest request) {
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
            com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeResponse>
        fetchDataSourceReferencesForResourceType(
            com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeRequest
                request) {
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
        initializeService(com.google.cloud.backupdr.v1beta.InitializeServiceRequest request) {
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
            com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest request) {
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
            com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse>
        listAutoProtectionPolicies(
            com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest request) {
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
            com.google.cloud.backupdr.v1beta.AutoProtectionPolicy>
        getAutoProtectionPolicy(
            com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest request) {
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
            com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest request) {
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
            com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest request) {
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
            com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyBindingRequest request) {
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
            com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding>
        getAutoProtectionPolicyBinding(
            com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest request) {
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
            com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsResponse>
        listAutoProtectionPolicyBindings(
            com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsRequest request) {
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
            com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesResponse>
        listAppliedAutoProtectionPolicies(
            com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesRequest request) {
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
            com.google.cloud.backupdr.v1beta.InitiateDeleteAutoProtectionPolicyBindingRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getInitiateDeleteAutoProtectionPolicyBindingMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Binding Matching Resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1beta.BindingMatchingResource>
        getBindingMatchingResource(
            com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBindingMatchingResourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Binding Matching Resources for a given AutoProtectionPolicyBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse>
        listBindingMatchingResources(
            com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBindingMatchingResourcesMethod(), getCallOptions()), request);
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
  private static final int METHODID_GET_BINDING_MATCHING_RESOURCE = 47;
  private static final int METHODID_LIST_BINDING_MATCHING_RESOURCES = 48;

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
              (com.google.cloud.backupdr.v1beta.ListManagementServersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.ListManagementServersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MANAGEMENT_SERVER:
          serviceImpl.getManagementServer(
              (com.google.cloud.backupdr.v1beta.GetManagementServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ManagementServer>)
                  responseObserver);
          break;
        case METHODID_CREATE_MANAGEMENT_SERVER:
          serviceImpl.createManagementServer(
              (com.google.cloud.backupdr.v1beta.CreateManagementServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MANAGEMENT_SERVER:
          serviceImpl.deleteManagementServer(
              (com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BACKUP_VAULT:
          serviceImpl.createBackupVault(
              (com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BACKUP_VAULTS:
          serviceImpl.listBackupVaults(
              (com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_USABLE_BACKUP_VAULTS:
          serviceImpl.fetchUsableBackupVaults(
              (com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP_VAULT:
          serviceImpl.getBackupVault(
              (com.google.cloud.backupdr.v1beta.GetBackupVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BackupVault>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BACKUP_VAULT:
          serviceImpl.updateBackupVault(
              (com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKUP_VAULT:
          serviceImpl.deleteBackupVault(
              (com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DATA_SOURCES:
          serviceImpl.listDataSources(
              (com.google.cloud.backupdr.v1beta.ListDataSourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.ListDataSourcesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_SOURCE:
          serviceImpl.getDataSource(
              (com.google.cloud.backupdr.v1beta.GetDataSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.DataSource>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_SOURCE:
          serviceImpl.updateDataSource(
              (com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BACKUPS:
          serviceImpl.listBackups(
              (com.google.cloud.backupdr.v1beta.ListBackupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.ListBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_BACKUPS_FOR_RESOURCE_TYPE:
          serviceImpl.fetchBackupsForResourceType(
              (com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP:
          serviceImpl.getBackup(
              (com.google.cloud.backupdr.v1beta.GetBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.Backup>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BACKUP:
          serviceImpl.updateBackup(
              (com.google.cloud.backupdr.v1beta.UpdateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKUP:
          serviceImpl.deleteBackup(
              (com.google.cloud.backupdr.v1beta.DeleteBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTORE_BACKUP:
          serviceImpl.restoreBackup(
              (com.google.cloud.backupdr.v1beta.RestoreBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BACKUP_PLAN:
          serviceImpl.createBackupPlan(
              (com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_BACKUP_PLAN:
          serviceImpl.updateBackupPlan(
              (com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_BACKUP_PLAN:
          serviceImpl.getBackupPlan(
              (com.google.cloud.backupdr.v1beta.GetBackupPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BackupPlan>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUP_PLANS:
          serviceImpl.listBackupPlans(
              (com.google.cloud.backupdr.v1beta.ListBackupPlansRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.ListBackupPlansResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_BACKUP_PLAN:
          serviceImpl.deleteBackupPlan(
              (com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_BACKUP_PLAN_REVISION:
          serviceImpl.getBackupPlanRevision(
              (com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BackupPlanRevision>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUP_PLAN_REVISIONS:
          serviceImpl.listBackupPlanRevisions(
              (com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_BACKUP_PLAN_ASSOCIATION:
          serviceImpl.createBackupPlanAssociation(
              (com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_BACKUP_PLAN_ASSOCIATION:
          serviceImpl.updateBackupPlanAssociation(
              (com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_BACKUP_PLAN_ASSOCIATION:
          serviceImpl.getBackupPlanAssociation(
              (com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.BackupPlanAssociation>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUP_PLAN_ASSOCIATIONS:
          serviceImpl.listBackupPlanAssociations(
              (com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_BACKUP_PLAN_ASSOCIATIONS_FOR_RESOURCE_TYPE:
          serviceImpl.fetchBackupPlanAssociationsForResourceType(
              (com.google.cloud.backupdr.v1beta.FetchBackupPlanAssociationsForResourceTypeRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta
                          .FetchBackupPlanAssociationsForResourceTypeResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_BACKUP_PLAN_ASSOCIATION:
          serviceImpl.deleteBackupPlanAssociation(
              (com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_TRIGGER_BACKUP:
          serviceImpl.triggerBackup(
              (com.google.cloud.backupdr.v1beta.TriggerBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DATA_SOURCE_REFERENCE:
          serviceImpl.getDataSourceReference(
              (com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.DataSourceReference>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_SOURCE_REFERENCES:
          serviceImpl.listDataSourceReferences(
              (com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_DATA_SOURCE_REFERENCES_FOR_RESOURCE_TYPE:
          serviceImpl.fetchDataSourceReferencesForResourceType(
              (com.google.cloud.backupdr.v1beta.FetchDataSourceReferencesForResourceTypeRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta
                          .FetchDataSourceReferencesForResourceTypeResponse>)
                  responseObserver);
          break;
        case METHODID_INITIALIZE_SERVICE:
          serviceImpl.initializeService(
              (com.google.cloud.backupdr.v1beta.InitializeServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_AUTO_PROTECTION_POLICY:
          serviceImpl.createAutoProtectionPolicy(
              (com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_AUTO_PROTECTION_POLICIES:
          serviceImpl.listAutoProtectionPolicies(
              (com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AUTO_PROTECTION_POLICY:
          serviceImpl.getAutoProtectionPolicy(
              (com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1beta.AutoProtectionPolicy>)
                  responseObserver);
          break;
        case METHODID_UPDATE_AUTO_PROTECTION_POLICY:
          serviceImpl.updateAutoProtectionPolicy(
              (com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_AUTO_PROTECTION_POLICY:
          serviceImpl.deleteAutoProtectionPolicy(
              (com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_AUTO_PROTECTION_POLICY_BINDING:
          serviceImpl.createAutoProtectionPolicyBinding(
              (com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_AUTO_PROTECTION_POLICY_BINDING:
          serviceImpl.getAutoProtectionPolicyBinding(
              (com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding>)
                  responseObserver);
          break;
        case METHODID_LIST_AUTO_PROTECTION_POLICY_BINDINGS:
          serviceImpl.listAutoProtectionPolicyBindings(
              (com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_APPLIED_AUTO_PROTECTION_POLICIES:
          serviceImpl.listAppliedAutoProtectionPolicies(
              (com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_INITIATE_DELETE_AUTO_PROTECTION_POLICY_BINDING:
          serviceImpl.initiateDeleteAutoProtectionPolicyBinding(
              (com.google.cloud.backupdr.v1beta.InitiateDeleteAutoProtectionPolicyBindingRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_BINDING_MATCHING_RESOURCE:
          serviceImpl.getBindingMatchingResource(
              (com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.BindingMatchingResource>)
                  responseObserver);
          break;
        case METHODID_LIST_BINDING_MATCHING_RESOURCES:
          serviceImpl.listBindingMatchingResources(
              (com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse>)
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
            getListManagementServersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.ListManagementServersRequest,
                    com.google.cloud.backupdr.v1beta.ListManagementServersResponse>(
                    service, METHODID_LIST_MANAGEMENT_SERVERS)))
        .addMethod(
            getGetManagementServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.GetManagementServerRequest,
                    com.google.cloud.backupdr.v1beta.ManagementServer>(
                    service, METHODID_GET_MANAGEMENT_SERVER)))
        .addMethod(
            getCreateManagementServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.CreateManagementServerRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_MANAGEMENT_SERVER)))
        .addMethod(
            getDeleteManagementServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.DeleteManagementServerRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_MANAGEMENT_SERVER)))
        .addMethod(
            getCreateBackupVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.CreateBackupVaultRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BACKUP_VAULT)))
        .addMethod(
            getListBackupVaultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.ListBackupVaultsRequest,
                    com.google.cloud.backupdr.v1beta.ListBackupVaultsResponse>(
                    service, METHODID_LIST_BACKUP_VAULTS)))
        .addMethod(
            getFetchUsableBackupVaultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsRequest,
                    com.google.cloud.backupdr.v1beta.FetchUsableBackupVaultsResponse>(
                    service, METHODID_FETCH_USABLE_BACKUP_VAULTS)))
        .addMethod(
            getGetBackupVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.GetBackupVaultRequest,
                    com.google.cloud.backupdr.v1beta.BackupVault>(
                    service, METHODID_GET_BACKUP_VAULT)))
        .addMethod(
            getUpdateBackupVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.UpdateBackupVaultRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BACKUP_VAULT)))
        .addMethod(
            getDeleteBackupVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.DeleteBackupVaultRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP_VAULT)))
        .addMethod(
            getListDataSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.ListDataSourcesRequest,
                    com.google.cloud.backupdr.v1beta.ListDataSourcesResponse>(
                    service, METHODID_LIST_DATA_SOURCES)))
        .addMethod(
            getGetDataSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.GetDataSourceRequest,
                    com.google.cloud.backupdr.v1beta.DataSource>(
                    service, METHODID_GET_DATA_SOURCE)))
        .addMethod(
            getUpdateDataSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.UpdateDataSourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATA_SOURCE)))
        .addMethod(
            getListBackupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.ListBackupsRequest,
                    com.google.cloud.backupdr.v1beta.ListBackupsResponse>(
                    service, METHODID_LIST_BACKUPS)))
        .addMethod(
            getFetchBackupsForResourceTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeRequest,
                    com.google.cloud.backupdr.v1beta.FetchBackupsForResourceTypeResponse>(
                    service, METHODID_FETCH_BACKUPS_FOR_RESOURCE_TYPE)))
        .addMethod(
            getGetBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.GetBackupRequest,
                    com.google.cloud.backupdr.v1beta.Backup>(service, METHODID_GET_BACKUP)))
        .addMethod(
            getUpdateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.UpdateBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BACKUP)))
        .addMethod(
            getDeleteBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.DeleteBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP)))
        .addMethod(
            getRestoreBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.RestoreBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESTORE_BACKUP)))
        .addMethod(
            getCreateBackupPlanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.CreateBackupPlanRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BACKUP_PLAN)))
        .addMethod(
            getUpdateBackupPlanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.UpdateBackupPlanRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BACKUP_PLAN)))
        .addMethod(
            getGetBackupPlanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.GetBackupPlanRequest,
                    com.google.cloud.backupdr.v1beta.BackupPlan>(
                    service, METHODID_GET_BACKUP_PLAN)))
        .addMethod(
            getListBackupPlansMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.ListBackupPlansRequest,
                    com.google.cloud.backupdr.v1beta.ListBackupPlansResponse>(
                    service, METHODID_LIST_BACKUP_PLANS)))
        .addMethod(
            getDeleteBackupPlanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.DeleteBackupPlanRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP_PLAN)))
        .addMethod(
            getGetBackupPlanRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.GetBackupPlanRevisionRequest,
                    com.google.cloud.backupdr.v1beta.BackupPlanRevision>(
                    service, METHODID_GET_BACKUP_PLAN_REVISION)))
        .addMethod(
            getListBackupPlanRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsRequest,
                    com.google.cloud.backupdr.v1beta.ListBackupPlanRevisionsResponse>(
                    service, METHODID_LIST_BACKUP_PLAN_REVISIONS)))
        .addMethod(
            getCreateBackupPlanAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.CreateBackupPlanAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_BACKUP_PLAN_ASSOCIATION)))
        .addMethod(
            getUpdateBackupPlanAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.UpdateBackupPlanAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_BACKUP_PLAN_ASSOCIATION)))
        .addMethod(
            getGetBackupPlanAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.GetBackupPlanAssociationRequest,
                    com.google.cloud.backupdr.v1beta.BackupPlanAssociation>(
                    service, METHODID_GET_BACKUP_PLAN_ASSOCIATION)))
        .addMethod(
            getListBackupPlanAssociationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsRequest,
                    com.google.cloud.backupdr.v1beta.ListBackupPlanAssociationsResponse>(
                    service, METHODID_LIST_BACKUP_PLAN_ASSOCIATIONS)))
        .addMethod(
            getFetchBackupPlanAssociationsForResourceTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta
                        .FetchBackupPlanAssociationsForResourceTypeRequest,
                    com.google.cloud.backupdr.v1beta
                        .FetchBackupPlanAssociationsForResourceTypeResponse>(
                    service, METHODID_FETCH_BACKUP_PLAN_ASSOCIATIONS_FOR_RESOURCE_TYPE)))
        .addMethod(
            getDeleteBackupPlanAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.DeleteBackupPlanAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_BACKUP_PLAN_ASSOCIATION)))
        .addMethod(
            getTriggerBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.TriggerBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_TRIGGER_BACKUP)))
        .addMethod(
            getGetDataSourceReferenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.GetDataSourceReferenceRequest,
                    com.google.cloud.backupdr.v1beta.DataSourceReference>(
                    service, METHODID_GET_DATA_SOURCE_REFERENCE)))
        .addMethod(
            getListDataSourceReferencesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.ListDataSourceReferencesRequest,
                    com.google.cloud.backupdr.v1beta.ListDataSourceReferencesResponse>(
                    service, METHODID_LIST_DATA_SOURCE_REFERENCES)))
        .addMethod(
            getFetchDataSourceReferencesForResourceTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta
                        .FetchDataSourceReferencesForResourceTypeRequest,
                    com.google.cloud.backupdr.v1beta
                        .FetchDataSourceReferencesForResourceTypeResponse>(
                    service, METHODID_FETCH_DATA_SOURCE_REFERENCES_FOR_RESOURCE_TYPE)))
        .addMethod(
            getInitializeServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.InitializeServiceRequest,
                    com.google.longrunning.Operation>(service, METHODID_INITIALIZE_SERVICE)))
        .addMethod(
            getCreateAutoProtectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_AUTO_PROTECTION_POLICY)))
        .addMethod(
            getListAutoProtectionPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesRequest,
                    com.google.cloud.backupdr.v1beta.ListAutoProtectionPoliciesResponse>(
                    service, METHODID_LIST_AUTO_PROTECTION_POLICIES)))
        .addMethod(
            getGetAutoProtectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyRequest,
                    com.google.cloud.backupdr.v1beta.AutoProtectionPolicy>(
                    service, METHODID_GET_AUTO_PROTECTION_POLICY)))
        .addMethod(
            getUpdateAutoProtectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.UpdateAutoProtectionPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_AUTO_PROTECTION_POLICY)))
        .addMethod(
            getDeleteAutoProtectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.DeleteAutoProtectionPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_AUTO_PROTECTION_POLICY)))
        .addMethod(
            getCreateAutoProtectionPolicyBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.CreateAutoProtectionPolicyBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_AUTO_PROTECTION_POLICY_BINDING)))
        .addMethod(
            getGetAutoProtectionPolicyBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.GetAutoProtectionPolicyBindingRequest,
                    com.google.cloud.backupdr.v1beta.AutoProtectionPolicyBinding>(
                    service, METHODID_GET_AUTO_PROTECTION_POLICY_BINDING)))
        .addMethod(
            getListAutoProtectionPolicyBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsRequest,
                    com.google.cloud.backupdr.v1beta.ListAutoProtectionPolicyBindingsResponse>(
                    service, METHODID_LIST_AUTO_PROTECTION_POLICY_BINDINGS)))
        .addMethod(
            getListAppliedAutoProtectionPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesRequest,
                    com.google.cloud.backupdr.v1beta.ListAppliedAutoProtectionPoliciesResponse>(
                    service, METHODID_LIST_APPLIED_AUTO_PROTECTION_POLICIES)))
        .addMethod(
            getInitiateDeleteAutoProtectionPolicyBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta
                        .InitiateDeleteAutoProtectionPolicyBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_INITIATE_DELETE_AUTO_PROTECTION_POLICY_BINDING)))
        .addMethod(
            getGetBindingMatchingResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.GetBindingMatchingResourceRequest,
                    com.google.cloud.backupdr.v1beta.BindingMatchingResource>(
                    service, METHODID_GET_BINDING_MATCHING_RESOURCE)))
        .addMethod(
            getListBindingMatchingResourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesRequest,
                    com.google.cloud.backupdr.v1beta.ListBindingMatchingResourcesResponse>(
                    service, METHODID_LIST_BINDING_MATCHING_RESOURCES)))
        .build();
  }

  private abstract static class BackupDRBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BackupDRBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.backupdr.v1beta.BackupDRProto.getDescriptor();
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
                      .addMethod(getGetBindingMatchingResourceMethod())
                      .addMethod(getListBindingMatchingResourcesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
