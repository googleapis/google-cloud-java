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
package com.google.cloud.alloydb.v1beta;

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
    comments = "Source: google/cloud/alloydb/v1beta/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AlloyDBAdminGrpc {

  private AlloyDBAdminGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.alloydb.v1beta.AlloyDBAdmin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ListClustersRequest,
          com.google.cloud.alloydb.v1beta.ListClustersResponse>
      getListClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClusters",
      requestType = com.google.cloud.alloydb.v1beta.ListClustersRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.ListClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ListClustersRequest,
          com.google.cloud.alloydb.v1beta.ListClustersResponse>
      getListClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.ListClustersRequest,
            com.google.cloud.alloydb.v1beta.ListClustersResponse>
        getListClustersMethod;
    if ((getListClustersMethod = AlloyDBAdminGrpc.getListClustersMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getListClustersMethod = AlloyDBAdminGrpc.getListClustersMethod) == null) {
          AlloyDBAdminGrpc.getListClustersMethod =
              getListClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.ListClustersRequest,
                          com.google.cloud.alloydb.v1beta.ListClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ListClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ListClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("ListClusters"))
                      .build();
        }
      }
    }
    return getListClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.GetClusterRequest,
          com.google.cloud.alloydb.v1beta.Cluster>
      getGetClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCluster",
      requestType = com.google.cloud.alloydb.v1beta.GetClusterRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.Cluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.GetClusterRequest,
          com.google.cloud.alloydb.v1beta.Cluster>
      getGetClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.GetClusterRequest,
            com.google.cloud.alloydb.v1beta.Cluster>
        getGetClusterMethod;
    if ((getGetClusterMethod = AlloyDBAdminGrpc.getGetClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getGetClusterMethod = AlloyDBAdminGrpc.getGetClusterMethod) == null) {
          AlloyDBAdminGrpc.getGetClusterMethod =
              getGetClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.GetClusterRequest,
                          com.google.cloud.alloydb.v1beta.Cluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.GetClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.Cluster.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("GetCluster"))
                      .build();
        }
      }
    }
    return getGetClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCluster",
      requestType = com.google.cloud.alloydb.v1beta.CreateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.CreateClusterRequest, com.google.longrunning.Operation>
        getCreateClusterMethod;
    if ((getCreateClusterMethod = AlloyDBAdminGrpc.getCreateClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getCreateClusterMethod = AlloyDBAdminGrpc.getCreateClusterMethod) == null) {
          AlloyDBAdminGrpc.getCreateClusterMethod =
              getCreateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.CreateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.CreateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("CreateCluster"))
                      .build();
        }
      }
    }
    return getCreateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.UpdateClusterRequest, com.google.longrunning.Operation>
      getUpdateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCluster",
      requestType = com.google.cloud.alloydb.v1beta.UpdateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.UpdateClusterRequest, com.google.longrunning.Operation>
      getUpdateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.UpdateClusterRequest, com.google.longrunning.Operation>
        getUpdateClusterMethod;
    if ((getUpdateClusterMethod = AlloyDBAdminGrpc.getUpdateClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getUpdateClusterMethod = AlloyDBAdminGrpc.getUpdateClusterMethod) == null) {
          AlloyDBAdminGrpc.getUpdateClusterMethod =
              getUpdateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.UpdateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.UpdateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("UpdateCluster"))
                      .build();
        }
      }
    }
    return getUpdateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ExportClusterRequest, com.google.longrunning.Operation>
      getExportClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportCluster",
      requestType = com.google.cloud.alloydb.v1beta.ExportClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ExportClusterRequest, com.google.longrunning.Operation>
      getExportClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.ExportClusterRequest, com.google.longrunning.Operation>
        getExportClusterMethod;
    if ((getExportClusterMethod = AlloyDBAdminGrpc.getExportClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getExportClusterMethod = AlloyDBAdminGrpc.getExportClusterMethod) == null) {
          AlloyDBAdminGrpc.getExportClusterMethod =
              getExportClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.ExportClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ExportClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("ExportCluster"))
                      .build();
        }
      }
    }
    return getExportClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ImportClusterRequest, com.google.longrunning.Operation>
      getImportClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportCluster",
      requestType = com.google.cloud.alloydb.v1beta.ImportClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ImportClusterRequest, com.google.longrunning.Operation>
      getImportClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.ImportClusterRequest, com.google.longrunning.Operation>
        getImportClusterMethod;
    if ((getImportClusterMethod = AlloyDBAdminGrpc.getImportClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getImportClusterMethod = AlloyDBAdminGrpc.getImportClusterMethod) == null) {
          AlloyDBAdminGrpc.getImportClusterMethod =
              getImportClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.ImportClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ImportClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("ImportCluster"))
                      .build();
        }
      }
    }
    return getImportClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.UpgradeClusterRequest, com.google.longrunning.Operation>
      getUpgradeClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpgradeCluster",
      requestType = com.google.cloud.alloydb.v1beta.UpgradeClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.UpgradeClusterRequest, com.google.longrunning.Operation>
      getUpgradeClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.UpgradeClusterRequest, com.google.longrunning.Operation>
        getUpgradeClusterMethod;
    if ((getUpgradeClusterMethod = AlloyDBAdminGrpc.getUpgradeClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getUpgradeClusterMethod = AlloyDBAdminGrpc.getUpgradeClusterMethod) == null) {
          AlloyDBAdminGrpc.getUpgradeClusterMethod =
              getUpgradeClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.UpgradeClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpgradeCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.UpgradeClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("UpgradeCluster"))
                      .build();
        }
      }
    }
    return getUpgradeClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.DeleteClusterRequest, com.google.longrunning.Operation>
      getDeleteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCluster",
      requestType = com.google.cloud.alloydb.v1beta.DeleteClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.DeleteClusterRequest, com.google.longrunning.Operation>
      getDeleteClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.DeleteClusterRequest, com.google.longrunning.Operation>
        getDeleteClusterMethod;
    if ((getDeleteClusterMethod = AlloyDBAdminGrpc.getDeleteClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getDeleteClusterMethod = AlloyDBAdminGrpc.getDeleteClusterMethod) == null) {
          AlloyDBAdminGrpc.getDeleteClusterMethod =
              getDeleteClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.DeleteClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.DeleteClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("DeleteCluster"))
                      .build();
        }
      }
    }
    return getDeleteClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.PromoteClusterRequest, com.google.longrunning.Operation>
      getPromoteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PromoteCluster",
      requestType = com.google.cloud.alloydb.v1beta.PromoteClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.PromoteClusterRequest, com.google.longrunning.Operation>
      getPromoteClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.PromoteClusterRequest, com.google.longrunning.Operation>
        getPromoteClusterMethod;
    if ((getPromoteClusterMethod = AlloyDBAdminGrpc.getPromoteClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getPromoteClusterMethod = AlloyDBAdminGrpc.getPromoteClusterMethod) == null) {
          AlloyDBAdminGrpc.getPromoteClusterMethod =
              getPromoteClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.PromoteClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PromoteCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.PromoteClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("PromoteCluster"))
                      .build();
        }
      }
    }
    return getPromoteClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.SwitchoverClusterRequest,
          com.google.longrunning.Operation>
      getSwitchoverClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SwitchoverCluster",
      requestType = com.google.cloud.alloydb.v1beta.SwitchoverClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.SwitchoverClusterRequest,
          com.google.longrunning.Operation>
      getSwitchoverClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.SwitchoverClusterRequest,
            com.google.longrunning.Operation>
        getSwitchoverClusterMethod;
    if ((getSwitchoverClusterMethod = AlloyDBAdminGrpc.getSwitchoverClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getSwitchoverClusterMethod = AlloyDBAdminGrpc.getSwitchoverClusterMethod) == null) {
          AlloyDBAdminGrpc.getSwitchoverClusterMethod =
              getSwitchoverClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.SwitchoverClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SwitchoverCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.SwitchoverClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("SwitchoverCluster"))
                      .build();
        }
      }
    }
    return getSwitchoverClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.RestoreClusterRequest, com.google.longrunning.Operation>
      getRestoreClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreCluster",
      requestType = com.google.cloud.alloydb.v1beta.RestoreClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.RestoreClusterRequest, com.google.longrunning.Operation>
      getRestoreClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.RestoreClusterRequest, com.google.longrunning.Operation>
        getRestoreClusterMethod;
    if ((getRestoreClusterMethod = AlloyDBAdminGrpc.getRestoreClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getRestoreClusterMethod = AlloyDBAdminGrpc.getRestoreClusterMethod) == null) {
          AlloyDBAdminGrpc.getRestoreClusterMethod =
              getRestoreClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.RestoreClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.RestoreClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("RestoreCluster"))
                      .build();
        }
      }
    }
    return getRestoreClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateSecondaryClusterRequest,
          com.google.longrunning.Operation>
      getCreateSecondaryClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSecondaryCluster",
      requestType = com.google.cloud.alloydb.v1beta.CreateSecondaryClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateSecondaryClusterRequest,
          com.google.longrunning.Operation>
      getCreateSecondaryClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.CreateSecondaryClusterRequest,
            com.google.longrunning.Operation>
        getCreateSecondaryClusterMethod;
    if ((getCreateSecondaryClusterMethod = AlloyDBAdminGrpc.getCreateSecondaryClusterMethod)
        == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getCreateSecondaryClusterMethod = AlloyDBAdminGrpc.getCreateSecondaryClusterMethod)
            == null) {
          AlloyDBAdminGrpc.getCreateSecondaryClusterMethod =
              getCreateSecondaryClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.CreateSecondaryClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSecondaryCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.CreateSecondaryClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("CreateSecondaryCluster"))
                      .build();
        }
      }
    }
    return getCreateSecondaryClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ListInstancesRequest,
          com.google.cloud.alloydb.v1beta.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.alloydb.v1beta.ListInstancesRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ListInstancesRequest,
          com.google.cloud.alloydb.v1beta.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.ListInstancesRequest,
            com.google.cloud.alloydb.v1beta.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = AlloyDBAdminGrpc.getListInstancesMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getListInstancesMethod = AlloyDBAdminGrpc.getListInstancesMethod) == null) {
          AlloyDBAdminGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.ListInstancesRequest,
                          com.google.cloud.alloydb.v1beta.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ListInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ListInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.GetInstanceRequest,
          com.google.cloud.alloydb.v1beta.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.alloydb.v1beta.GetInstanceRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.GetInstanceRequest,
          com.google.cloud.alloydb.v1beta.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.GetInstanceRequest,
            com.google.cloud.alloydb.v1beta.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = AlloyDBAdminGrpc.getGetInstanceMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getGetInstanceMethod = AlloyDBAdminGrpc.getGetInstanceMethod) == null) {
          AlloyDBAdminGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.GetInstanceRequest,
                          com.google.cloud.alloydb.v1beta.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.GetInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.alloydb.v1beta.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.CreateInstanceRequest, com.google.longrunning.Operation>
        getCreateInstanceMethod;
    if ((getCreateInstanceMethod = AlloyDBAdminGrpc.getCreateInstanceMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getCreateInstanceMethod = AlloyDBAdminGrpc.getCreateInstanceMethod) == null) {
          AlloyDBAdminGrpc.getCreateInstanceMethod =
              getCreateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.CreateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.CreateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("CreateInstance"))
                      .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateSecondaryInstanceRequest,
          com.google.longrunning.Operation>
      getCreateSecondaryInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSecondaryInstance",
      requestType = com.google.cloud.alloydb.v1beta.CreateSecondaryInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateSecondaryInstanceRequest,
          com.google.longrunning.Operation>
      getCreateSecondaryInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.CreateSecondaryInstanceRequest,
            com.google.longrunning.Operation>
        getCreateSecondaryInstanceMethod;
    if ((getCreateSecondaryInstanceMethod = AlloyDBAdminGrpc.getCreateSecondaryInstanceMethod)
        == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getCreateSecondaryInstanceMethod = AlloyDBAdminGrpc.getCreateSecondaryInstanceMethod)
            == null) {
          AlloyDBAdminGrpc.getCreateSecondaryInstanceMethod =
              getCreateSecondaryInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.CreateSecondaryInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSecondaryInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.CreateSecondaryInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("CreateSecondaryInstance"))
                      .build();
        }
      }
    }
    return getCreateSecondaryInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.BatchCreateInstancesRequest,
          com.google.longrunning.Operation>
      getBatchCreateInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateInstances",
      requestType = com.google.cloud.alloydb.v1beta.BatchCreateInstancesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.BatchCreateInstancesRequest,
          com.google.longrunning.Operation>
      getBatchCreateInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.BatchCreateInstancesRequest,
            com.google.longrunning.Operation>
        getBatchCreateInstancesMethod;
    if ((getBatchCreateInstancesMethod = AlloyDBAdminGrpc.getBatchCreateInstancesMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getBatchCreateInstancesMethod = AlloyDBAdminGrpc.getBatchCreateInstancesMethod)
            == null) {
          AlloyDBAdminGrpc.getBatchCreateInstancesMethod =
              getBatchCreateInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.BatchCreateInstancesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.BatchCreateInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("BatchCreateInstances"))
                      .build();
        }
      }
    }
    return getBatchCreateInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.UpdateInstanceRequest, com.google.longrunning.Operation>
      getUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstance",
      requestType = com.google.cloud.alloydb.v1beta.UpdateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.UpdateInstanceRequest, com.google.longrunning.Operation>
      getUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.UpdateInstanceRequest, com.google.longrunning.Operation>
        getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = AlloyDBAdminGrpc.getUpdateInstanceMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getUpdateInstanceMethod = AlloyDBAdminGrpc.getUpdateInstanceMethod) == null) {
          AlloyDBAdminGrpc.getUpdateInstanceMethod =
              getUpdateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.UpdateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.UpdateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("UpdateInstance"))
                      .build();
        }
      }
    }
    return getUpdateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.alloydb.v1beta.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.DeleteInstanceRequest, com.google.longrunning.Operation>
        getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = AlloyDBAdminGrpc.getDeleteInstanceMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getDeleteInstanceMethod = AlloyDBAdminGrpc.getDeleteInstanceMethod) == null) {
          AlloyDBAdminGrpc.getDeleteInstanceMethod =
              getDeleteInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.DeleteInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.DeleteInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("DeleteInstance"))
                      .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.FailoverInstanceRequest, com.google.longrunning.Operation>
      getFailoverInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FailoverInstance",
      requestType = com.google.cloud.alloydb.v1beta.FailoverInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.FailoverInstanceRequest, com.google.longrunning.Operation>
      getFailoverInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.FailoverInstanceRequest,
            com.google.longrunning.Operation>
        getFailoverInstanceMethod;
    if ((getFailoverInstanceMethod = AlloyDBAdminGrpc.getFailoverInstanceMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getFailoverInstanceMethod = AlloyDBAdminGrpc.getFailoverInstanceMethod) == null) {
          AlloyDBAdminGrpc.getFailoverInstanceMethod =
              getFailoverInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.FailoverInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FailoverInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.FailoverInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("FailoverInstance"))
                      .build();
        }
      }
    }
    return getFailoverInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.InjectFaultRequest, com.google.longrunning.Operation>
      getInjectFaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InjectFault",
      requestType = com.google.cloud.alloydb.v1beta.InjectFaultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.InjectFaultRequest, com.google.longrunning.Operation>
      getInjectFaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.InjectFaultRequest, com.google.longrunning.Operation>
        getInjectFaultMethod;
    if ((getInjectFaultMethod = AlloyDBAdminGrpc.getInjectFaultMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getInjectFaultMethod = AlloyDBAdminGrpc.getInjectFaultMethod) == null) {
          AlloyDBAdminGrpc.getInjectFaultMethod =
              getInjectFaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.InjectFaultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InjectFault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.InjectFaultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("InjectFault"))
                      .build();
        }
      }
    }
    return getInjectFaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.RestartInstanceRequest, com.google.longrunning.Operation>
      getRestartInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestartInstance",
      requestType = com.google.cloud.alloydb.v1beta.RestartInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.RestartInstanceRequest, com.google.longrunning.Operation>
      getRestartInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.RestartInstanceRequest,
            com.google.longrunning.Operation>
        getRestartInstanceMethod;
    if ((getRestartInstanceMethod = AlloyDBAdminGrpc.getRestartInstanceMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getRestartInstanceMethod = AlloyDBAdminGrpc.getRestartInstanceMethod) == null) {
          AlloyDBAdminGrpc.getRestartInstanceMethod =
              getRestartInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.RestartInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestartInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.RestartInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("RestartInstance"))
                      .build();
        }
      }
    }
    return getRestartInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ExecuteSqlRequest,
          com.google.cloud.alloydb.v1beta.ExecuteSqlResponse>
      getExecuteSqlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteSql",
      requestType = com.google.cloud.alloydb.v1beta.ExecuteSqlRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.ExecuteSqlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ExecuteSqlRequest,
          com.google.cloud.alloydb.v1beta.ExecuteSqlResponse>
      getExecuteSqlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.ExecuteSqlRequest,
            com.google.cloud.alloydb.v1beta.ExecuteSqlResponse>
        getExecuteSqlMethod;
    if ((getExecuteSqlMethod = AlloyDBAdminGrpc.getExecuteSqlMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getExecuteSqlMethod = AlloyDBAdminGrpc.getExecuteSqlMethod) == null) {
          AlloyDBAdminGrpc.getExecuteSqlMethod =
              getExecuteSqlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.ExecuteSqlRequest,
                          com.google.cloud.alloydb.v1beta.ExecuteSqlResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteSql"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ExecuteSqlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ExecuteSqlResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("ExecuteSql"))
                      .build();
        }
      }
    }
    return getExecuteSqlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ListBackupsRequest,
          com.google.cloud.alloydb.v1beta.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackups",
      requestType = com.google.cloud.alloydb.v1beta.ListBackupsRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.ListBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ListBackupsRequest,
          com.google.cloud.alloydb.v1beta.ListBackupsResponse>
      getListBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.ListBackupsRequest,
            com.google.cloud.alloydb.v1beta.ListBackupsResponse>
        getListBackupsMethod;
    if ((getListBackupsMethod = AlloyDBAdminGrpc.getListBackupsMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getListBackupsMethod = AlloyDBAdminGrpc.getListBackupsMethod) == null) {
          AlloyDBAdminGrpc.getListBackupsMethod =
              getListBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.ListBackupsRequest,
                          com.google.cloud.alloydb.v1beta.ListBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ListBackupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ListBackupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("ListBackups"))
                      .build();
        }
      }
    }
    return getListBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.GetBackupRequest, com.google.cloud.alloydb.v1beta.Backup>
      getGetBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackup",
      requestType = com.google.cloud.alloydb.v1beta.GetBackupRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.GetBackupRequest, com.google.cloud.alloydb.v1beta.Backup>
      getGetBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.GetBackupRequest,
            com.google.cloud.alloydb.v1beta.Backup>
        getGetBackupMethod;
    if ((getGetBackupMethod = AlloyDBAdminGrpc.getGetBackupMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getGetBackupMethod = AlloyDBAdminGrpc.getGetBackupMethod) == null) {
          AlloyDBAdminGrpc.getGetBackupMethod =
              getGetBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.GetBackupRequest,
                          com.google.cloud.alloydb.v1beta.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.GetBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("GetBackup"))
                      .build();
        }
      }
    }
    return getGetBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateBackupRequest, com.google.longrunning.Operation>
      getCreateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackup",
      requestType = com.google.cloud.alloydb.v1beta.CreateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateBackupRequest, com.google.longrunning.Operation>
      getCreateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.CreateBackupRequest, com.google.longrunning.Operation>
        getCreateBackupMethod;
    if ((getCreateBackupMethod = AlloyDBAdminGrpc.getCreateBackupMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getCreateBackupMethod = AlloyDBAdminGrpc.getCreateBackupMethod) == null) {
          AlloyDBAdminGrpc.getCreateBackupMethod =
              getCreateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.CreateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.CreateBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("CreateBackup"))
                      .build();
        }
      }
    }
    return getCreateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackup",
      requestType = com.google.cloud.alloydb.v1beta.UpdateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.UpdateBackupRequest, com.google.longrunning.Operation>
        getUpdateBackupMethod;
    if ((getUpdateBackupMethod = AlloyDBAdminGrpc.getUpdateBackupMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getUpdateBackupMethod = AlloyDBAdminGrpc.getUpdateBackupMethod) == null) {
          AlloyDBAdminGrpc.getUpdateBackupMethod =
              getUpdateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.UpdateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.UpdateBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("UpdateBackup"))
                      .build();
        }
      }
    }
    return getUpdateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackup",
      requestType = com.google.cloud.alloydb.v1beta.DeleteBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.DeleteBackupRequest, com.google.longrunning.Operation>
        getDeleteBackupMethod;
    if ((getDeleteBackupMethod = AlloyDBAdminGrpc.getDeleteBackupMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getDeleteBackupMethod = AlloyDBAdminGrpc.getDeleteBackupMethod) == null) {
          AlloyDBAdminGrpc.getDeleteBackupMethod =
              getDeleteBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.DeleteBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.DeleteBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("DeleteBackup"))
                      .build();
        }
      }
    }
    return getDeleteBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsRequest,
          com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsResponse>
      getListSupportedDatabaseFlagsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSupportedDatabaseFlags",
      requestType = com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsRequest,
          com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsResponse>
      getListSupportedDatabaseFlagsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsRequest,
            com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsResponse>
        getListSupportedDatabaseFlagsMethod;
    if ((getListSupportedDatabaseFlagsMethod = AlloyDBAdminGrpc.getListSupportedDatabaseFlagsMethod)
        == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getListSupportedDatabaseFlagsMethod =
                AlloyDBAdminGrpc.getListSupportedDatabaseFlagsMethod)
            == null) {
          AlloyDBAdminGrpc.getListSupportedDatabaseFlagsMethod =
              getListSupportedDatabaseFlagsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsRequest,
                          com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSupportedDatabaseFlags"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("ListSupportedDatabaseFlags"))
                      .build();
        }
      }
    }
    return getListSupportedDatabaseFlagsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.GenerateClientCertificateRequest,
          com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse>
      getGenerateClientCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateClientCertificate",
      requestType = com.google.cloud.alloydb.v1beta.GenerateClientCertificateRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.GenerateClientCertificateRequest,
          com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse>
      getGenerateClientCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.GenerateClientCertificateRequest,
            com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse>
        getGenerateClientCertificateMethod;
    if ((getGenerateClientCertificateMethod = AlloyDBAdminGrpc.getGenerateClientCertificateMethod)
        == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getGenerateClientCertificateMethod =
                AlloyDBAdminGrpc.getGenerateClientCertificateMethod)
            == null) {
          AlloyDBAdminGrpc.getGenerateClientCertificateMethod =
              getGenerateClientCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.GenerateClientCertificateRequest,
                          com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateClientCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.GenerateClientCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("GenerateClientCertificate"))
                      .build();
        }
      }
    }
    return getGenerateClientCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.GetConnectionInfoRequest,
          com.google.cloud.alloydb.v1beta.ConnectionInfo>
      getGetConnectionInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnectionInfo",
      requestType = com.google.cloud.alloydb.v1beta.GetConnectionInfoRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.ConnectionInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.GetConnectionInfoRequest,
          com.google.cloud.alloydb.v1beta.ConnectionInfo>
      getGetConnectionInfoMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.GetConnectionInfoRequest,
            com.google.cloud.alloydb.v1beta.ConnectionInfo>
        getGetConnectionInfoMethod;
    if ((getGetConnectionInfoMethod = AlloyDBAdminGrpc.getGetConnectionInfoMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getGetConnectionInfoMethod = AlloyDBAdminGrpc.getGetConnectionInfoMethod) == null) {
          AlloyDBAdminGrpc.getGetConnectionInfoMethod =
              getGetConnectionInfoMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.GetConnectionInfoRequest,
                          com.google.cloud.alloydb.v1beta.ConnectionInfo>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConnectionInfo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.GetConnectionInfoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ConnectionInfo.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("GetConnectionInfo"))
                      .build();
        }
      }
    }
    return getGetConnectionInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ListUsersRequest,
          com.google.cloud.alloydb.v1beta.ListUsersResponse>
      getListUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUsers",
      requestType = com.google.cloud.alloydb.v1beta.ListUsersRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.ListUsersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ListUsersRequest,
          com.google.cloud.alloydb.v1beta.ListUsersResponse>
      getListUsersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.ListUsersRequest,
            com.google.cloud.alloydb.v1beta.ListUsersResponse>
        getListUsersMethod;
    if ((getListUsersMethod = AlloyDBAdminGrpc.getListUsersMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getListUsersMethod = AlloyDBAdminGrpc.getListUsersMethod) == null) {
          AlloyDBAdminGrpc.getListUsersMethod =
              getListUsersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.ListUsersRequest,
                          com.google.cloud.alloydb.v1beta.ListUsersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUsers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ListUsersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ListUsersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("ListUsers"))
                      .build();
        }
      }
    }
    return getListUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.GetUserRequest, com.google.cloud.alloydb.v1beta.User>
      getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUser",
      requestType = com.google.cloud.alloydb.v1beta.GetUserRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.GetUserRequest, com.google.cloud.alloydb.v1beta.User>
      getGetUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.GetUserRequest, com.google.cloud.alloydb.v1beta.User>
        getGetUserMethod;
    if ((getGetUserMethod = AlloyDBAdminGrpc.getGetUserMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getGetUserMethod = AlloyDBAdminGrpc.getGetUserMethod) == null) {
          AlloyDBAdminGrpc.getGetUserMethod =
              getGetUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.GetUserRequest,
                          com.google.cloud.alloydb.v1beta.User>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.GetUserRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.User.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("GetUser"))
                      .build();
        }
      }
    }
    return getGetUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateUserRequest, com.google.cloud.alloydb.v1beta.User>
      getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = com.google.cloud.alloydb.v1beta.CreateUserRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateUserRequest, com.google.cloud.alloydb.v1beta.User>
      getCreateUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.CreateUserRequest, com.google.cloud.alloydb.v1beta.User>
        getCreateUserMethod;
    if ((getCreateUserMethod = AlloyDBAdminGrpc.getCreateUserMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getCreateUserMethod = AlloyDBAdminGrpc.getCreateUserMethod) == null) {
          AlloyDBAdminGrpc.getCreateUserMethod =
              getCreateUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.CreateUserRequest,
                          com.google.cloud.alloydb.v1beta.User>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.CreateUserRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.User.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("CreateUser"))
                      .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.UpdateUserRequest, com.google.cloud.alloydb.v1beta.User>
      getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = com.google.cloud.alloydb.v1beta.UpdateUserRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.UpdateUserRequest, com.google.cloud.alloydb.v1beta.User>
      getUpdateUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.UpdateUserRequest, com.google.cloud.alloydb.v1beta.User>
        getUpdateUserMethod;
    if ((getUpdateUserMethod = AlloyDBAdminGrpc.getUpdateUserMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getUpdateUserMethod = AlloyDBAdminGrpc.getUpdateUserMethod) == null) {
          AlloyDBAdminGrpc.getUpdateUserMethod =
              getUpdateUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.UpdateUserRequest,
                          com.google.cloud.alloydb.v1beta.User>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.UpdateUserRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.User.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("UpdateUser"))
                      .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.DeleteUserRequest, com.google.protobuf.Empty>
      getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUser",
      requestType = com.google.cloud.alloydb.v1beta.DeleteUserRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.DeleteUserRequest, com.google.protobuf.Empty>
      getDeleteUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.DeleteUserRequest, com.google.protobuf.Empty>
        getDeleteUserMethod;
    if ((getDeleteUserMethod = AlloyDBAdminGrpc.getDeleteUserMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getDeleteUserMethod = AlloyDBAdminGrpc.getDeleteUserMethod) == null) {
          AlloyDBAdminGrpc.getDeleteUserMethod =
              getDeleteUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.DeleteUserRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.DeleteUserRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("DeleteUser"))
                      .build();
        }
      }
    }
    return getDeleteUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ListDatabasesRequest,
          com.google.cloud.alloydb.v1beta.ListDatabasesResponse>
      getListDatabasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatabases",
      requestType = com.google.cloud.alloydb.v1beta.ListDatabasesRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.ListDatabasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.ListDatabasesRequest,
          com.google.cloud.alloydb.v1beta.ListDatabasesResponse>
      getListDatabasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.ListDatabasesRequest,
            com.google.cloud.alloydb.v1beta.ListDatabasesResponse>
        getListDatabasesMethod;
    if ((getListDatabasesMethod = AlloyDBAdminGrpc.getListDatabasesMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getListDatabasesMethod = AlloyDBAdminGrpc.getListDatabasesMethod) == null) {
          AlloyDBAdminGrpc.getListDatabasesMethod =
              getListDatabasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.ListDatabasesRequest,
                          com.google.cloud.alloydb.v1beta.ListDatabasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatabases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ListDatabasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.ListDatabasesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("ListDatabases"))
                      .build();
        }
      }
    }
    return getListDatabasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateDatabaseRequest,
          com.google.cloud.alloydb.v1beta.Database>
      getCreateDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDatabase",
      requestType = com.google.cloud.alloydb.v1beta.CreateDatabaseRequest.class,
      responseType = com.google.cloud.alloydb.v1beta.Database.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1beta.CreateDatabaseRequest,
          com.google.cloud.alloydb.v1beta.Database>
      getCreateDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1beta.CreateDatabaseRequest,
            com.google.cloud.alloydb.v1beta.Database>
        getCreateDatabaseMethod;
    if ((getCreateDatabaseMethod = AlloyDBAdminGrpc.getCreateDatabaseMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getCreateDatabaseMethod = AlloyDBAdminGrpc.getCreateDatabaseMethod) == null) {
          AlloyDBAdminGrpc.getCreateDatabaseMethod =
              getCreateDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1beta.CreateDatabaseRequest,
                          com.google.cloud.alloydb.v1beta.Database>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.CreateDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1beta.Database.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("CreateDatabase"))
                      .build();
        }
      }
    }
    return getCreateDatabaseMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AlloyDBAdminStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlloyDBAdminStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlloyDBAdminStub>() {
          @java.lang.Override
          public AlloyDBAdminStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlloyDBAdminStub(channel, callOptions);
          }
        };
    return AlloyDBAdminStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AlloyDBAdminBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlloyDBAdminBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlloyDBAdminBlockingV2Stub>() {
          @java.lang.Override
          public AlloyDBAdminBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlloyDBAdminBlockingV2Stub(channel, callOptions);
          }
        };
    return AlloyDBAdminBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlloyDBAdminBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlloyDBAdminBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlloyDBAdminBlockingStub>() {
          @java.lang.Override
          public AlloyDBAdminBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlloyDBAdminBlockingStub(channel, callOptions);
          }
        };
    return AlloyDBAdminBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AlloyDBAdminFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlloyDBAdminFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlloyDBAdminFutureStub>() {
          @java.lang.Override
          public AlloyDBAdminFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlloyDBAdminFutureStub(channel, callOptions);
          }
        };
    return AlloyDBAdminFutureStub.newStub(factory, channel);
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
     * Lists Clusters in a given project and location.
     * </pre>
     */
    default void listClusters(
        com.google.cloud.alloydb.v1beta.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    default void getCluster(
        com.google.cloud.alloydb.v1beta.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.Cluster> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    default void createCluster(
        com.google.cloud.alloydb.v1beta.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    default void updateCluster(
        com.google.cloud.alloydb.v1beta.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports data from the cluster.
     * Imperative only.
     * </pre>
     */
    default void exportCluster(
        com.google.cloud.alloydb.v1beta.ExportClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports data to the cluster.
     * Imperative only.
     * </pre>
     */
    default void importCluster(
        com.google.cloud.alloydb.v1beta.ImportClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upgrades a single Cluster.
     * Imperative only.
     * </pre>
     */
    default void upgradeCluster(
        com.google.cloud.alloydb.v1beta.UpgradeClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpgradeClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    default void deleteCluster(
        com.google.cloud.alloydb.v1beta.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Promotes a SECONDARY cluster. This turns down replication
     * from the PRIMARY cluster and promotes a secondary cluster
     * into its own standalone cluster.
     * Imperative only.
     * </pre>
     */
    default void promoteCluster(
        com.google.cloud.alloydb.v1beta.PromoteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPromoteClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Switches the roles of PRIMARY and SECONDARY clusters without any data loss.
     * This promotes the SECONDARY cluster to PRIMARY and sets up the original
     * PRIMARY cluster to replicate from this newly promoted cluster.
     * </pre>
     */
    default void switchoverCluster(
        com.google.cloud.alloydb.v1beta.SwitchoverClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSwitchoverClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location, with a volume
     * restored from the provided source, either a backup ID or a point-in-time
     * and a source cluster.
     * </pre>
     */
    default void restoreCluster(
        com.google.cloud.alloydb.v1beta.RestoreClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster of type SECONDARY in the given location using
     * the primary cluster as the source.
     * </pre>
     */
    default void createSecondaryCluster(
        com.google.cloud.alloydb.v1beta.CreateSecondaryClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSecondaryClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    default void listInstances(
        com.google.cloud.alloydb.v1beta.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    default void getInstance(
        com.google.cloud.alloydb.v1beta.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    default void createInstance(
        com.google.cloud.alloydb.v1beta.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SECONDARY Instance in a given project and location.
     * </pre>
     */
    default void createSecondaryInstance(
        com.google.cloud.alloydb.v1beta.CreateSecondaryInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSecondaryInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new instances under the given project, location and cluster.
     * There can be only one primary instance in a cluster. If the primary
     * instance exists in the cluster as well as this request, then API will
     * throw an error.
     * The primary instance should exist before any read pool instance is
     * created. If the primary instance is a part of the request payload, then
     * the API will take care of creating instances in the correct order.
     * This method is here to support Google-internal use cases, and is not meant
     * for external customers to consume. Please do not start relying on it; its
     * behavior is subject to change without notice.
     * </pre>
     */
    default void batchCreateInstances(
        com.google.cloud.alloydb.v1beta.BatchCreateInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    default void updateInstance(
        com.google.cloud.alloydb.v1beta.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    default void deleteInstance(
        com.google.cloud.alloydb.v1beta.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Forces a Failover for a highly available instance.
     * Failover promotes the HA standby instance as the new primary.
     * Imperative only.
     * </pre>
     */
    default void failoverInstance(
        com.google.cloud.alloydb.v1beta.FailoverInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFailoverInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Injects fault in an instance.
     * Imperative only.
     * </pre>
     */
    default void injectFault(
        com.google.cloud.alloydb.v1beta.InjectFaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInjectFaultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restart an Instance in a cluster.
     * Imperative only.
     * </pre>
     */
    default void restartInstance(
        com.google.cloud.alloydb.v1beta.RestartInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestartInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Executes a SQL statement in a database inside an AlloyDB instance.
     * </pre>
     */
    default void executeSql(
        com.google.cloud.alloydb.v1beta.ExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ExecuteSqlResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExecuteSqlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    default void listBackups(
        com.google.cloud.alloydb.v1beta.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Backup.
     * </pre>
     */
    default void getBackup(
        com.google.cloud.alloydb.v1beta.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.Backup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Backup in a given project and location.
     * </pre>
     */
    default void createBackup(
        com.google.cloud.alloydb.v1beta.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Backup.
     * </pre>
     */
    default void updateBackup(
        com.google.cloud.alloydb.v1beta.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Backup.
     * </pre>
     */
    default void deleteBackup(
        com.google.cloud.alloydb.v1beta.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SupportedDatabaseFlags for a given project and location.
     * </pre>
     */
    default void listSupportedDatabaseFlags(
        com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSupportedDatabaseFlagsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate a client certificate signed by a Cluster CA.
     * The sole purpose of this endpoint is to support AlloyDB connectors and the
     * Auth Proxy client. The endpoint's behavior is subject to change without
     * notice, so do not rely on its behavior remaining constant. Future changes
     * will not break AlloyDB connectors or the Auth Proxy client.
     * </pre>
     */
    default void generateClientCertificate(
        com.google.cloud.alloydb.v1beta.GenerateClientCertificateRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateClientCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get instance metadata used for a connection.
     * </pre>
     */
    default void getConnectionInfo(
        com.google.cloud.alloydb.v1beta.GetConnectionInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ConnectionInfo>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConnectionInfoMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Users in a given project and location.
     * </pre>
     */
    default void listUsers(
        com.google.cloud.alloydb.v1beta.ListUsersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListUsersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUsersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single User.
     * </pre>
     */
    default void getUser(
        com.google.cloud.alloydb.v1beta.GetUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.User> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new User in a given project, location, and cluster.
     * </pre>
     */
    default void createUser(
        com.google.cloud.alloydb.v1beta.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.User> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single User.
     * </pre>
     */
    default void updateUser(
        com.google.cloud.alloydb.v1beta.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.User> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single User.
     * </pre>
     */
    default void deleteUser(
        com.google.cloud.alloydb.v1beta.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Databases in a given project and location.
     * </pre>
     */
    default void listDatabases(
        com.google.cloud.alloydb.v1beta.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatabasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Database in a given project, location, and cluster.
     * </pre>
     */
    default void createDatabase(
        com.google.cloud.alloydb.v1beta.CreateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.Database> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDatabaseMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AlloyDBAdmin.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class AlloyDBAdminImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AlloyDBAdminGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AlloyDBAdmin.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AlloyDBAdminStub
      extends io.grpc.stub.AbstractAsyncStub<AlloyDBAdminStub> {
    private AlloyDBAdminStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlloyDBAdminStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlloyDBAdminStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public void listClusters(
        com.google.cloud.alloydb.v1beta.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListClustersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public void getCluster(
        com.google.cloud.alloydb.v1beta.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.Cluster> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public void createCluster(
        com.google.cloud.alloydb.v1beta.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public void updateCluster(
        com.google.cloud.alloydb.v1beta.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports data from the cluster.
     * Imperative only.
     * </pre>
     */
    public void exportCluster(
        com.google.cloud.alloydb.v1beta.ExportClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports data to the cluster.
     * Imperative only.
     * </pre>
     */
    public void importCluster(
        com.google.cloud.alloydb.v1beta.ImportClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upgrades a single Cluster.
     * Imperative only.
     * </pre>
     */
    public void upgradeCluster(
        com.google.cloud.alloydb.v1beta.UpgradeClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpgradeClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public void deleteCluster(
        com.google.cloud.alloydb.v1beta.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Promotes a SECONDARY cluster. This turns down replication
     * from the PRIMARY cluster and promotes a secondary cluster
     * into its own standalone cluster.
     * Imperative only.
     * </pre>
     */
    public void promoteCluster(
        com.google.cloud.alloydb.v1beta.PromoteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPromoteClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Switches the roles of PRIMARY and SECONDARY clusters without any data loss.
     * This promotes the SECONDARY cluster to PRIMARY and sets up the original
     * PRIMARY cluster to replicate from this newly promoted cluster.
     * </pre>
     */
    public void switchoverCluster(
        com.google.cloud.alloydb.v1beta.SwitchoverClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSwitchoverClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location, with a volume
     * restored from the provided source, either a backup ID or a point-in-time
     * and a source cluster.
     * </pre>
     */
    public void restoreCluster(
        com.google.cloud.alloydb.v1beta.RestoreClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster of type SECONDARY in the given location using
     * the primary cluster as the source.
     * </pre>
     */
    public void createSecondaryCluster(
        com.google.cloud.alloydb.v1beta.CreateSecondaryClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSecondaryClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.alloydb.v1beta.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.alloydb.v1beta.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public void createInstance(
        com.google.cloud.alloydb.v1beta.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SECONDARY Instance in a given project and location.
     * </pre>
     */
    public void createSecondaryInstance(
        com.google.cloud.alloydb.v1beta.CreateSecondaryInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSecondaryInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new instances under the given project, location and cluster.
     * There can be only one primary instance in a cluster. If the primary
     * instance exists in the cluster as well as this request, then API will
     * throw an error.
     * The primary instance should exist before any read pool instance is
     * created. If the primary instance is a part of the request payload, then
     * the API will take care of creating instances in the correct order.
     * This method is here to support Google-internal use cases, and is not meant
     * for external customers to consume. Please do not start relying on it; its
     * behavior is subject to change without notice.
     * </pre>
     */
    public void batchCreateInstances(
        com.google.cloud.alloydb.v1beta.BatchCreateInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public void updateInstance(
        com.google.cloud.alloydb.v1beta.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public void deleteInstance(
        com.google.cloud.alloydb.v1beta.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Forces a Failover for a highly available instance.
     * Failover promotes the HA standby instance as the new primary.
     * Imperative only.
     * </pre>
     */
    public void failoverInstance(
        com.google.cloud.alloydb.v1beta.FailoverInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFailoverInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Injects fault in an instance.
     * Imperative only.
     * </pre>
     */
    public void injectFault(
        com.google.cloud.alloydb.v1beta.InjectFaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInjectFaultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restart an Instance in a cluster.
     * Imperative only.
     * </pre>
     */
    public void restartInstance(
        com.google.cloud.alloydb.v1beta.RestartInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestartInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Executes a SQL statement in a database inside an AlloyDB instance.
     * </pre>
     */
    public void executeSql(
        com.google.cloud.alloydb.v1beta.ExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ExecuteSqlResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteSqlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    public void listBackups(
        com.google.cloud.alloydb.v1beta.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListBackupsResponse>
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
     * Gets details of a single Backup.
     * </pre>
     */
    public void getBackup(
        com.google.cloud.alloydb.v1beta.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.Backup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Backup in a given project and location.
     * </pre>
     */
    public void createBackup(
        com.google.cloud.alloydb.v1beta.CreateBackupRequest request,
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
     * Updates the parameters of a single Backup.
     * </pre>
     */
    public void updateBackup(
        com.google.cloud.alloydb.v1beta.UpdateBackupRequest request,
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
     * Deletes a single Backup.
     * </pre>
     */
    public void deleteBackup(
        com.google.cloud.alloydb.v1beta.DeleteBackupRequest request,
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
     * Lists SupportedDatabaseFlags for a given project and location.
     * </pre>
     */
    public void listSupportedDatabaseFlags(
        com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSupportedDatabaseFlagsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate a client certificate signed by a Cluster CA.
     * The sole purpose of this endpoint is to support AlloyDB connectors and the
     * Auth Proxy client. The endpoint's behavior is subject to change without
     * notice, so do not rely on its behavior remaining constant. Future changes
     * will not break AlloyDB connectors or the Auth Proxy client.
     * </pre>
     */
    public void generateClientCertificate(
        com.google.cloud.alloydb.v1beta.GenerateClientCertificateRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateClientCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get instance metadata used for a connection.
     * </pre>
     */
    public void getConnectionInfo(
        com.google.cloud.alloydb.v1beta.GetConnectionInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ConnectionInfo>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConnectionInfoMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Users in a given project and location.
     * </pre>
     */
    public void listUsers(
        com.google.cloud.alloydb.v1beta.ListUsersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListUsersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single User.
     * </pre>
     */
    public void getUser(
        com.google.cloud.alloydb.v1beta.GetUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.User> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new User in a given project, location, and cluster.
     * </pre>
     */
    public void createUser(
        com.google.cloud.alloydb.v1beta.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.User> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single User.
     * </pre>
     */
    public void updateUser(
        com.google.cloud.alloydb.v1beta.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.User> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single User.
     * </pre>
     */
    public void deleteUser(
        com.google.cloud.alloydb.v1beta.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Databases in a given project and location.
     * </pre>
     */
    public void listDatabases(
        com.google.cloud.alloydb.v1beta.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatabasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Database in a given project, location, and cluster.
     * </pre>
     */
    public void createDatabase(
        com.google.cloud.alloydb.v1beta.CreateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.Database> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AlloyDBAdmin.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AlloyDBAdminBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AlloyDBAdminBlockingV2Stub> {
    private AlloyDBAdminBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlloyDBAdminBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlloyDBAdminBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ListClustersResponse listClusters(
        com.google.cloud.alloydb.v1beta.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.Cluster getCluster(
        com.google.cloud.alloydb.v1beta.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(
        com.google.cloud.alloydb.v1beta.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(
        com.google.cloud.alloydb.v1beta.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports data from the cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation exportCluster(
        com.google.cloud.alloydb.v1beta.ExportClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data to the cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation importCluster(
        com.google.cloud.alloydb.v1beta.ImportClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Upgrades a single Cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation upgradeCluster(
        com.google.cloud.alloydb.v1beta.UpgradeClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpgradeClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCluster(
        com.google.cloud.alloydb.v1beta.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Promotes a SECONDARY cluster. This turns down replication
     * from the PRIMARY cluster and promotes a secondary cluster
     * into its own standalone cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation promoteCluster(
        com.google.cloud.alloydb.v1beta.PromoteClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPromoteClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Switches the roles of PRIMARY and SECONDARY clusters without any data loss.
     * This promotes the SECONDARY cluster to PRIMARY and sets up the original
     * PRIMARY cluster to replicate from this newly promoted cluster.
     * </pre>
     */
    public com.google.longrunning.Operation switchoverCluster(
        com.google.cloud.alloydb.v1beta.SwitchoverClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSwitchoverClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location, with a volume
     * restored from the provided source, either a backup ID or a point-in-time
     * and a source cluster.
     * </pre>
     */
    public com.google.longrunning.Operation restoreCluster(
        com.google.cloud.alloydb.v1beta.RestoreClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster of type SECONDARY in the given location using
     * the primary cluster as the source.
     * </pre>
     */
    public com.google.longrunning.Operation createSecondaryCluster(
        com.google.cloud.alloydb.v1beta.CreateSecondaryClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSecondaryClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ListInstancesResponse listInstances(
        com.google.cloud.alloydb.v1beta.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.Instance getInstance(
        com.google.cloud.alloydb.v1beta.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.alloydb.v1beta.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SECONDARY Instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSecondaryInstance(
        com.google.cloud.alloydb.v1beta.CreateSecondaryInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSecondaryInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new instances under the given project, location and cluster.
     * There can be only one primary instance in a cluster. If the primary
     * instance exists in the cluster as well as this request, then API will
     * throw an error.
     * The primary instance should exist before any read pool instance is
     * created. If the primary instance is a part of the request payload, then
     * the API will take care of creating instances in the correct order.
     * This method is here to support Google-internal use cases, and is not meant
     * for external customers to consume. Please do not start relying on it; its
     * behavior is subject to change without notice.
     * </pre>
     */
    public com.google.longrunning.Operation batchCreateInstances(
        com.google.cloud.alloydb.v1beta.BatchCreateInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(
        com.google.cloud.alloydb.v1beta.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.alloydb.v1beta.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Forces a Failover for a highly available instance.
     * Failover promotes the HA standby instance as the new primary.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation failoverInstance(
        com.google.cloud.alloydb.v1beta.FailoverInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFailoverInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Injects fault in an instance.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation injectFault(
        com.google.cloud.alloydb.v1beta.InjectFaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInjectFaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restart an Instance in a cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation restartInstance(
        com.google.cloud.alloydb.v1beta.RestartInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestartInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Executes a SQL statement in a database inside an AlloyDB instance.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ExecuteSqlResponse executeSql(
        com.google.cloud.alloydb.v1beta.ExecuteSqlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteSqlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ListBackupsResponse listBackups(
        com.google.cloud.alloydb.v1beta.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Backup.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.Backup getBackup(
        com.google.cloud.alloydb.v1beta.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Backup in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createBackup(
        com.google.cloud.alloydb.v1beta.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Backup.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackup(
        com.google.cloud.alloydb.v1beta.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Backup.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackup(
        com.google.cloud.alloydb.v1beta.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SupportedDatabaseFlags for a given project and location.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsResponse
        listSupportedDatabaseFlags(
            com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSupportedDatabaseFlagsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generate a client certificate signed by a Cluster CA.
     * The sole purpose of this endpoint is to support AlloyDB connectors and the
     * Auth Proxy client. The endpoint's behavior is subject to change without
     * notice, so do not rely on its behavior remaining constant. Future changes
     * will not break AlloyDB connectors or the Auth Proxy client.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse
        generateClientCertificate(
            com.google.cloud.alloydb.v1beta.GenerateClientCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateClientCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get instance metadata used for a connection.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ConnectionInfo getConnectionInfo(
        com.google.cloud.alloydb.v1beta.GetConnectionInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectionInfoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Users in a given project and location.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ListUsersResponse listUsers(
        com.google.cloud.alloydb.v1beta.ListUsersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUsersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single User.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.User getUser(
        com.google.cloud.alloydb.v1beta.GetUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new User in a given project, location, and cluster.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.User createUser(
        com.google.cloud.alloydb.v1beta.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single User.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.User updateUser(
        com.google.cloud.alloydb.v1beta.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single User.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUser(
        com.google.cloud.alloydb.v1beta.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Databases in a given project and location.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ListDatabasesResponse listDatabases(
        com.google.cloud.alloydb.v1beta.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Database in a given project, location, and cluster.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.Database createDatabase(
        com.google.cloud.alloydb.v1beta.CreateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatabaseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AlloyDBAdmin.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AlloyDBAdminBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AlloyDBAdminBlockingStub> {
    private AlloyDBAdminBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlloyDBAdminBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlloyDBAdminBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ListClustersResponse listClusters(
        com.google.cloud.alloydb.v1beta.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.Cluster getCluster(
        com.google.cloud.alloydb.v1beta.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(
        com.google.cloud.alloydb.v1beta.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(
        com.google.cloud.alloydb.v1beta.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports data from the cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation exportCluster(
        com.google.cloud.alloydb.v1beta.ExportClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data to the cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation importCluster(
        com.google.cloud.alloydb.v1beta.ImportClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Upgrades a single Cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation upgradeCluster(
        com.google.cloud.alloydb.v1beta.UpgradeClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpgradeClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCluster(
        com.google.cloud.alloydb.v1beta.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Promotes a SECONDARY cluster. This turns down replication
     * from the PRIMARY cluster and promotes a secondary cluster
     * into its own standalone cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation promoteCluster(
        com.google.cloud.alloydb.v1beta.PromoteClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPromoteClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Switches the roles of PRIMARY and SECONDARY clusters without any data loss.
     * This promotes the SECONDARY cluster to PRIMARY and sets up the original
     * PRIMARY cluster to replicate from this newly promoted cluster.
     * </pre>
     */
    public com.google.longrunning.Operation switchoverCluster(
        com.google.cloud.alloydb.v1beta.SwitchoverClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSwitchoverClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location, with a volume
     * restored from the provided source, either a backup ID or a point-in-time
     * and a source cluster.
     * </pre>
     */
    public com.google.longrunning.Operation restoreCluster(
        com.google.cloud.alloydb.v1beta.RestoreClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster of type SECONDARY in the given location using
     * the primary cluster as the source.
     * </pre>
     */
    public com.google.longrunning.Operation createSecondaryCluster(
        com.google.cloud.alloydb.v1beta.CreateSecondaryClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSecondaryClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ListInstancesResponse listInstances(
        com.google.cloud.alloydb.v1beta.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.Instance getInstance(
        com.google.cloud.alloydb.v1beta.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.alloydb.v1beta.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SECONDARY Instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSecondaryInstance(
        com.google.cloud.alloydb.v1beta.CreateSecondaryInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSecondaryInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new instances under the given project, location and cluster.
     * There can be only one primary instance in a cluster. If the primary
     * instance exists in the cluster as well as this request, then API will
     * throw an error.
     * The primary instance should exist before any read pool instance is
     * created. If the primary instance is a part of the request payload, then
     * the API will take care of creating instances in the correct order.
     * This method is here to support Google-internal use cases, and is not meant
     * for external customers to consume. Please do not start relying on it; its
     * behavior is subject to change without notice.
     * </pre>
     */
    public com.google.longrunning.Operation batchCreateInstances(
        com.google.cloud.alloydb.v1beta.BatchCreateInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(
        com.google.cloud.alloydb.v1beta.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.alloydb.v1beta.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Forces a Failover for a highly available instance.
     * Failover promotes the HA standby instance as the new primary.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation failoverInstance(
        com.google.cloud.alloydb.v1beta.FailoverInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFailoverInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Injects fault in an instance.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation injectFault(
        com.google.cloud.alloydb.v1beta.InjectFaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInjectFaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restart an Instance in a cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.longrunning.Operation restartInstance(
        com.google.cloud.alloydb.v1beta.RestartInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestartInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Executes a SQL statement in a database inside an AlloyDB instance.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ExecuteSqlResponse executeSql(
        com.google.cloud.alloydb.v1beta.ExecuteSqlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteSqlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ListBackupsResponse listBackups(
        com.google.cloud.alloydb.v1beta.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Backup.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.Backup getBackup(
        com.google.cloud.alloydb.v1beta.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Backup in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createBackup(
        com.google.cloud.alloydb.v1beta.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Backup.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackup(
        com.google.cloud.alloydb.v1beta.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Backup.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackup(
        com.google.cloud.alloydb.v1beta.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SupportedDatabaseFlags for a given project and location.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsResponse
        listSupportedDatabaseFlags(
            com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSupportedDatabaseFlagsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generate a client certificate signed by a Cluster CA.
     * The sole purpose of this endpoint is to support AlloyDB connectors and the
     * Auth Proxy client. The endpoint's behavior is subject to change without
     * notice, so do not rely on its behavior remaining constant. Future changes
     * will not break AlloyDB connectors or the Auth Proxy client.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse
        generateClientCertificate(
            com.google.cloud.alloydb.v1beta.GenerateClientCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateClientCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get instance metadata used for a connection.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ConnectionInfo getConnectionInfo(
        com.google.cloud.alloydb.v1beta.GetConnectionInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectionInfoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Users in a given project and location.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ListUsersResponse listUsers(
        com.google.cloud.alloydb.v1beta.ListUsersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUsersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single User.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.User getUser(
        com.google.cloud.alloydb.v1beta.GetUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new User in a given project, location, and cluster.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.User createUser(
        com.google.cloud.alloydb.v1beta.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single User.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.User updateUser(
        com.google.cloud.alloydb.v1beta.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single User.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUser(
        com.google.cloud.alloydb.v1beta.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Databases in a given project and location.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.ListDatabasesResponse listDatabases(
        com.google.cloud.alloydb.v1beta.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Database in a given project, location, and cluster.
     * </pre>
     */
    public com.google.cloud.alloydb.v1beta.Database createDatabase(
        com.google.cloud.alloydb.v1beta.CreateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatabaseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AlloyDBAdmin.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AlloyDBAdminFutureStub
      extends io.grpc.stub.AbstractFutureStub<AlloyDBAdminFutureStub> {
    private AlloyDBAdminFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlloyDBAdminFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlloyDBAdminFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.alloydb.v1beta.ListClustersResponse>
        listClusters(com.google.cloud.alloydb.v1beta.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.alloydb.v1beta.Cluster>
        getCluster(com.google.cloud.alloydb.v1beta.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCluster(com.google.cloud.alloydb.v1beta.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCluster(com.google.cloud.alloydb.v1beta.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports data from the cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportCluster(com.google.cloud.alloydb.v1beta.ExportClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data to the cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importCluster(com.google.cloud.alloydb.v1beta.ImportClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Upgrades a single Cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        upgradeCluster(com.google.cloud.alloydb.v1beta.UpgradeClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpgradeClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCluster(com.google.cloud.alloydb.v1beta.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Promotes a SECONDARY cluster. This turns down replication
     * from the PRIMARY cluster and promotes a secondary cluster
     * into its own standalone cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        promoteCluster(com.google.cloud.alloydb.v1beta.PromoteClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPromoteClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Switches the roles of PRIMARY and SECONDARY clusters without any data loss.
     * This promotes the SECONDARY cluster to PRIMARY and sets up the original
     * PRIMARY cluster to replicate from this newly promoted cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        switchoverCluster(com.google.cloud.alloydb.v1beta.SwitchoverClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSwitchoverClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location, with a volume
     * restored from the provided source, either a backup ID or a point-in-time
     * and a source cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restoreCluster(com.google.cloud.alloydb.v1beta.RestoreClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster of type SECONDARY in the given location using
     * the primary cluster as the source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSecondaryCluster(
            com.google.cloud.alloydb.v1beta.CreateSecondaryClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSecondaryClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.alloydb.v1beta.ListInstancesResponse>
        listInstances(com.google.cloud.alloydb.v1beta.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.alloydb.v1beta.Instance>
        getInstance(com.google.cloud.alloydb.v1beta.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInstance(com.google.cloud.alloydb.v1beta.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SECONDARY Instance in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSecondaryInstance(
            com.google.cloud.alloydb.v1beta.CreateSecondaryInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSecondaryInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new instances under the given project, location and cluster.
     * There can be only one primary instance in a cluster. If the primary
     * instance exists in the cluster as well as this request, then API will
     * throw an error.
     * The primary instance should exist before any read pool instance is
     * created. If the primary instance is a part of the request payload, then
     * the API will take care of creating instances in the correct order.
     * This method is here to support Google-internal use cases, and is not meant
     * for external customers to consume. Please do not start relying on it; its
     * behavior is subject to change without notice.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchCreateInstances(com.google.cloud.alloydb.v1beta.BatchCreateInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateInstance(com.google.cloud.alloydb.v1beta.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteInstance(com.google.cloud.alloydb.v1beta.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Forces a Failover for a highly available instance.
     * Failover promotes the HA standby instance as the new primary.
     * Imperative only.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        failoverInstance(com.google.cloud.alloydb.v1beta.FailoverInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFailoverInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Injects fault in an instance.
     * Imperative only.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        injectFault(com.google.cloud.alloydb.v1beta.InjectFaultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInjectFaultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restart an Instance in a cluster.
     * Imperative only.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restartInstance(com.google.cloud.alloydb.v1beta.RestartInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestartInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Executes a SQL statement in a database inside an AlloyDB instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.alloydb.v1beta.ExecuteSqlResponse>
        executeSql(com.google.cloud.alloydb.v1beta.ExecuteSqlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteSqlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.alloydb.v1beta.ListBackupsResponse>
        listBackups(com.google.cloud.alloydb.v1beta.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.alloydb.v1beta.Backup>
        getBackup(com.google.cloud.alloydb.v1beta.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Backup in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackup(com.google.cloud.alloydb.v1beta.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBackup(com.google.cloud.alloydb.v1beta.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackup(com.google.cloud.alloydb.v1beta.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SupportedDatabaseFlags for a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsResponse>
        listSupportedDatabaseFlags(
            com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSupportedDatabaseFlagsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generate a client certificate signed by a Cluster CA.
     * The sole purpose of this endpoint is to support AlloyDB connectors and the
     * Auth Proxy client. The endpoint's behavior is subject to change without
     * notice, so do not rely on its behavior remaining constant. Future changes
     * will not break AlloyDB connectors or the Auth Proxy client.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse>
        generateClientCertificate(
            com.google.cloud.alloydb.v1beta.GenerateClientCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateClientCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get instance metadata used for a connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.alloydb.v1beta.ConnectionInfo>
        getConnectionInfo(com.google.cloud.alloydb.v1beta.GetConnectionInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConnectionInfoMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Users in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.alloydb.v1beta.ListUsersResponse>
        listUsers(com.google.cloud.alloydb.v1beta.ListUsersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUsersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single User.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.alloydb.v1beta.User>
        getUser(com.google.cloud.alloydb.v1beta.GetUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new User in a given project, location, and cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.alloydb.v1beta.User>
        createUser(com.google.cloud.alloydb.v1beta.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single User.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.alloydb.v1beta.User>
        updateUser(com.google.cloud.alloydb.v1beta.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single User.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteUser(
        com.google.cloud.alloydb.v1beta.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Databases in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.alloydb.v1beta.ListDatabasesResponse>
        listDatabases(com.google.cloud.alloydb.v1beta.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatabasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Database in a given project, location, and cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.alloydb.v1beta.Database>
        createDatabase(com.google.cloud.alloydb.v1beta.CreateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDatabaseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CLUSTERS = 0;
  private static final int METHODID_GET_CLUSTER = 1;
  private static final int METHODID_CREATE_CLUSTER = 2;
  private static final int METHODID_UPDATE_CLUSTER = 3;
  private static final int METHODID_EXPORT_CLUSTER = 4;
  private static final int METHODID_IMPORT_CLUSTER = 5;
  private static final int METHODID_UPGRADE_CLUSTER = 6;
  private static final int METHODID_DELETE_CLUSTER = 7;
  private static final int METHODID_PROMOTE_CLUSTER = 8;
  private static final int METHODID_SWITCHOVER_CLUSTER = 9;
  private static final int METHODID_RESTORE_CLUSTER = 10;
  private static final int METHODID_CREATE_SECONDARY_CLUSTER = 11;
  private static final int METHODID_LIST_INSTANCES = 12;
  private static final int METHODID_GET_INSTANCE = 13;
  private static final int METHODID_CREATE_INSTANCE = 14;
  private static final int METHODID_CREATE_SECONDARY_INSTANCE = 15;
  private static final int METHODID_BATCH_CREATE_INSTANCES = 16;
  private static final int METHODID_UPDATE_INSTANCE = 17;
  private static final int METHODID_DELETE_INSTANCE = 18;
  private static final int METHODID_FAILOVER_INSTANCE = 19;
  private static final int METHODID_INJECT_FAULT = 20;
  private static final int METHODID_RESTART_INSTANCE = 21;
  private static final int METHODID_EXECUTE_SQL = 22;
  private static final int METHODID_LIST_BACKUPS = 23;
  private static final int METHODID_GET_BACKUP = 24;
  private static final int METHODID_CREATE_BACKUP = 25;
  private static final int METHODID_UPDATE_BACKUP = 26;
  private static final int METHODID_DELETE_BACKUP = 27;
  private static final int METHODID_LIST_SUPPORTED_DATABASE_FLAGS = 28;
  private static final int METHODID_GENERATE_CLIENT_CERTIFICATE = 29;
  private static final int METHODID_GET_CONNECTION_INFO = 30;
  private static final int METHODID_LIST_USERS = 31;
  private static final int METHODID_GET_USER = 32;
  private static final int METHODID_CREATE_USER = 33;
  private static final int METHODID_UPDATE_USER = 34;
  private static final int METHODID_DELETE_USER = 35;
  private static final int METHODID_LIST_DATABASES = 36;
  private static final int METHODID_CREATE_DATABASE = 37;

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
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters(
              (com.google.cloud.alloydb.v1beta.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListClustersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster(
              (com.google.cloud.alloydb.v1beta.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.Cluster>)
                  responseObserver);
          break;
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster(
              (com.google.cloud.alloydb.v1beta.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster(
              (com.google.cloud.alloydb.v1beta.UpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_CLUSTER:
          serviceImpl.exportCluster(
              (com.google.cloud.alloydb.v1beta.ExportClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_CLUSTER:
          serviceImpl.importCluster(
              (com.google.cloud.alloydb.v1beta.ImportClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPGRADE_CLUSTER:
          serviceImpl.upgradeCluster(
              (com.google.cloud.alloydb.v1beta.UpgradeClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster(
              (com.google.cloud.alloydb.v1beta.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PROMOTE_CLUSTER:
          serviceImpl.promoteCluster(
              (com.google.cloud.alloydb.v1beta.PromoteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SWITCHOVER_CLUSTER:
          serviceImpl.switchoverCluster(
              (com.google.cloud.alloydb.v1beta.SwitchoverClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTORE_CLUSTER:
          serviceImpl.restoreCluster(
              (com.google.cloud.alloydb.v1beta.RestoreClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_SECONDARY_CLUSTER:
          serviceImpl.createSecondaryCluster(
              (com.google.cloud.alloydb.v1beta.CreateSecondaryClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances(
              (com.google.cloud.alloydb.v1beta.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.alloydb.v1beta.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.Instance>)
                  responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance(
              (com.google.cloud.alloydb.v1beta.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_SECONDARY_INSTANCE:
          serviceImpl.createSecondaryInstance(
              (com.google.cloud.alloydb.v1beta.CreateSecondaryInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_INSTANCES:
          serviceImpl.batchCreateInstances(
              (com.google.cloud.alloydb.v1beta.BatchCreateInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance(
              (com.google.cloud.alloydb.v1beta.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance(
              (com.google.cloud.alloydb.v1beta.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FAILOVER_INSTANCE:
          serviceImpl.failoverInstance(
              (com.google.cloud.alloydb.v1beta.FailoverInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_INJECT_FAULT:
          serviceImpl.injectFault(
              (com.google.cloud.alloydb.v1beta.InjectFaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTART_INSTANCE:
          serviceImpl.restartInstance(
              (com.google.cloud.alloydb.v1beta.RestartInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXECUTE_SQL:
          serviceImpl.executeSql(
              (com.google.cloud.alloydb.v1beta.ExecuteSqlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ExecuteSqlResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUPS:
          serviceImpl.listBackups(
              (com.google.cloud.alloydb.v1beta.ListBackupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP:
          serviceImpl.getBackup(
              (com.google.cloud.alloydb.v1beta.GetBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.Backup>)
                  responseObserver);
          break;
        case METHODID_CREATE_BACKUP:
          serviceImpl.createBackup(
              (com.google.cloud.alloydb.v1beta.CreateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_BACKUP:
          serviceImpl.updateBackup(
              (com.google.cloud.alloydb.v1beta.UpdateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKUP:
          serviceImpl.deleteBackup(
              (com.google.cloud.alloydb.v1beta.DeleteBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SUPPORTED_DATABASE_FLAGS:
          serviceImpl.listSupportedDatabaseFlags(
              (com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsResponse>)
                  responseObserver);
          break;
        case METHODID_GENERATE_CLIENT_CERTIFICATE:
          serviceImpl.generateClientCertificate(
              (com.google.cloud.alloydb.v1beta.GenerateClientCertificateRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CONNECTION_INFO:
          serviceImpl.getConnectionInfo(
              (com.google.cloud.alloydb.v1beta.GetConnectionInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ConnectionInfo>)
                  responseObserver);
          break;
        case METHODID_LIST_USERS:
          serviceImpl.listUsers(
              (com.google.cloud.alloydb.v1beta.ListUsersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListUsersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_USER:
          serviceImpl.getUser(
              (com.google.cloud.alloydb.v1beta.GetUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.User>) responseObserver);
          break;
        case METHODID_CREATE_USER:
          serviceImpl.createUser(
              (com.google.cloud.alloydb.v1beta.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.User>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser(
              (com.google.cloud.alloydb.v1beta.UpdateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.User>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser(
              (com.google.cloud.alloydb.v1beta.DeleteUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_DATABASES:
          serviceImpl.listDatabases(
              (com.google.cloud.alloydb.v1beta.ListDatabasesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.ListDatabasesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATABASE:
          serviceImpl.createDatabase(
              (com.google.cloud.alloydb.v1beta.CreateDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1beta.Database>)
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
            getListClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.ListClustersRequest,
                    com.google.cloud.alloydb.v1beta.ListClustersResponse>(
                    service, METHODID_LIST_CLUSTERS)))
        .addMethod(
            getGetClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.GetClusterRequest,
                    com.google.cloud.alloydb.v1beta.Cluster>(service, METHODID_GET_CLUSTER)))
        .addMethod(
            getCreateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.CreateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CLUSTER)))
        .addMethod(
            getUpdateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.UpdateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CLUSTER)))
        .addMethod(
            getExportClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.ExportClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_CLUSTER)))
        .addMethod(
            getImportClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.ImportClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_CLUSTER)))
        .addMethod(
            getUpgradeClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.UpgradeClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPGRADE_CLUSTER)))
        .addMethod(
            getDeleteClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.DeleteClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CLUSTER)))
        .addMethod(
            getPromoteClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.PromoteClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_PROMOTE_CLUSTER)))
        .addMethod(
            getSwitchoverClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.SwitchoverClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_SWITCHOVER_CLUSTER)))
        .addMethod(
            getRestoreClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.RestoreClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESTORE_CLUSTER)))
        .addMethod(
            getCreateSecondaryClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.CreateSecondaryClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SECONDARY_CLUSTER)))
        .addMethod(
            getListInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.ListInstancesRequest,
                    com.google.cloud.alloydb.v1beta.ListInstancesResponse>(
                    service, METHODID_LIST_INSTANCES)))
        .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.GetInstanceRequest,
                    com.google.cloud.alloydb.v1beta.Instance>(service, METHODID_GET_INSTANCE)))
        .addMethod(
            getCreateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.CreateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INSTANCE)))
        .addMethod(
            getCreateSecondaryInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.CreateSecondaryInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SECONDARY_INSTANCE)))
        .addMethod(
            getBatchCreateInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.BatchCreateInstancesRequest,
                    com.google.longrunning.Operation>(service, METHODID_BATCH_CREATE_INSTANCES)))
        .addMethod(
            getUpdateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.UpdateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_INSTANCE)))
        .addMethod(
            getDeleteInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.DeleteInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INSTANCE)))
        .addMethod(
            getFailoverInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.FailoverInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_FAILOVER_INSTANCE)))
        .addMethod(
            getInjectFaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.InjectFaultRequest,
                    com.google.longrunning.Operation>(service, METHODID_INJECT_FAULT)))
        .addMethod(
            getRestartInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.RestartInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESTART_INSTANCE)))
        .addMethod(
            getExecuteSqlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.ExecuteSqlRequest,
                    com.google.cloud.alloydb.v1beta.ExecuteSqlResponse>(
                    service, METHODID_EXECUTE_SQL)))
        .addMethod(
            getListBackupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.ListBackupsRequest,
                    com.google.cloud.alloydb.v1beta.ListBackupsResponse>(
                    service, METHODID_LIST_BACKUPS)))
        .addMethod(
            getGetBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.GetBackupRequest,
                    com.google.cloud.alloydb.v1beta.Backup>(service, METHODID_GET_BACKUP)))
        .addMethod(
            getCreateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.CreateBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BACKUP)))
        .addMethod(
            getUpdateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.UpdateBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BACKUP)))
        .addMethod(
            getDeleteBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.DeleteBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP)))
        .addMethod(
            getListSupportedDatabaseFlagsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsRequest,
                    com.google.cloud.alloydb.v1beta.ListSupportedDatabaseFlagsResponse>(
                    service, METHODID_LIST_SUPPORTED_DATABASE_FLAGS)))
        .addMethod(
            getGenerateClientCertificateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.GenerateClientCertificateRequest,
                    com.google.cloud.alloydb.v1beta.GenerateClientCertificateResponse>(
                    service, METHODID_GENERATE_CLIENT_CERTIFICATE)))
        .addMethod(
            getGetConnectionInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.GetConnectionInfoRequest,
                    com.google.cloud.alloydb.v1beta.ConnectionInfo>(
                    service, METHODID_GET_CONNECTION_INFO)))
        .addMethod(
            getListUsersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.ListUsersRequest,
                    com.google.cloud.alloydb.v1beta.ListUsersResponse>(
                    service, METHODID_LIST_USERS)))
        .addMethod(
            getGetUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.GetUserRequest,
                    com.google.cloud.alloydb.v1beta.User>(service, METHODID_GET_USER)))
        .addMethod(
            getCreateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.CreateUserRequest,
                    com.google.cloud.alloydb.v1beta.User>(service, METHODID_CREATE_USER)))
        .addMethod(
            getUpdateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.UpdateUserRequest,
                    com.google.cloud.alloydb.v1beta.User>(service, METHODID_UPDATE_USER)))
        .addMethod(
            getDeleteUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.DeleteUserRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_USER)))
        .addMethod(
            getListDatabasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.ListDatabasesRequest,
                    com.google.cloud.alloydb.v1beta.ListDatabasesResponse>(
                    service, METHODID_LIST_DATABASES)))
        .addMethod(
            getCreateDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1beta.CreateDatabaseRequest,
                    com.google.cloud.alloydb.v1beta.Database>(service, METHODID_CREATE_DATABASE)))
        .build();
  }

  private abstract static class AlloyDBAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlloyDBAdminBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.alloydb.v1beta.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AlloyDBAdmin");
    }
  }

  private static final class AlloyDBAdminFileDescriptorSupplier
      extends AlloyDBAdminBaseDescriptorSupplier {
    AlloyDBAdminFileDescriptorSupplier() {}
  }

  private static final class AlloyDBAdminMethodDescriptorSupplier
      extends AlloyDBAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AlloyDBAdminMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AlloyDBAdminGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AlloyDBAdminFileDescriptorSupplier())
                      .addMethod(getListClustersMethod())
                      .addMethod(getGetClusterMethod())
                      .addMethod(getCreateClusterMethod())
                      .addMethod(getUpdateClusterMethod())
                      .addMethod(getExportClusterMethod())
                      .addMethod(getImportClusterMethod())
                      .addMethod(getUpgradeClusterMethod())
                      .addMethod(getDeleteClusterMethod())
                      .addMethod(getPromoteClusterMethod())
                      .addMethod(getSwitchoverClusterMethod())
                      .addMethod(getRestoreClusterMethod())
                      .addMethod(getCreateSecondaryClusterMethod())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getCreateInstanceMethod())
                      .addMethod(getCreateSecondaryInstanceMethod())
                      .addMethod(getBatchCreateInstancesMethod())
                      .addMethod(getUpdateInstanceMethod())
                      .addMethod(getDeleteInstanceMethod())
                      .addMethod(getFailoverInstanceMethod())
                      .addMethod(getInjectFaultMethod())
                      .addMethod(getRestartInstanceMethod())
                      .addMethod(getExecuteSqlMethod())
                      .addMethod(getListBackupsMethod())
                      .addMethod(getGetBackupMethod())
                      .addMethod(getCreateBackupMethod())
                      .addMethod(getUpdateBackupMethod())
                      .addMethod(getDeleteBackupMethod())
                      .addMethod(getListSupportedDatabaseFlagsMethod())
                      .addMethod(getGenerateClientCertificateMethod())
                      .addMethod(getGetConnectionInfoMethod())
                      .addMethod(getListUsersMethod())
                      .addMethod(getGetUserMethod())
                      .addMethod(getCreateUserMethod())
                      .addMethod(getUpdateUserMethod())
                      .addMethod(getDeleteUserMethod())
                      .addMethod(getListDatabasesMethod())
                      .addMethod(getCreateDatabaseMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
