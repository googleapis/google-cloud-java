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
package com.google.cloud.alloydb.v1alpha;

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
    comments = "Source: google/cloud/alloydb/v1alpha/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AlloyDBAdminGrpc {

  private AlloyDBAdminGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.alloydb.v1alpha.AlloyDBAdmin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.ListClustersRequest,
          com.google.cloud.alloydb.v1alpha.ListClustersResponse>
      getListClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClusters",
      requestType = com.google.cloud.alloydb.v1alpha.ListClustersRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.ListClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.ListClustersRequest,
          com.google.cloud.alloydb.v1alpha.ListClustersResponse>
      getListClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.ListClustersRequest,
            com.google.cloud.alloydb.v1alpha.ListClustersResponse>
        getListClustersMethod;
    if ((getListClustersMethod = AlloyDBAdminGrpc.getListClustersMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getListClustersMethod = AlloyDBAdminGrpc.getListClustersMethod) == null) {
          AlloyDBAdminGrpc.getListClustersMethod =
              getListClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.ListClustersRequest,
                          com.google.cloud.alloydb.v1alpha.ListClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ListClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ListClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("ListClusters"))
                      .build();
        }
      }
    }
    return getListClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.GetClusterRequest,
          com.google.cloud.alloydb.v1alpha.Cluster>
      getGetClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCluster",
      requestType = com.google.cloud.alloydb.v1alpha.GetClusterRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.Cluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.GetClusterRequest,
          com.google.cloud.alloydb.v1alpha.Cluster>
      getGetClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.GetClusterRequest,
            com.google.cloud.alloydb.v1alpha.Cluster>
        getGetClusterMethod;
    if ((getGetClusterMethod = AlloyDBAdminGrpc.getGetClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getGetClusterMethod = AlloyDBAdminGrpc.getGetClusterMethod) == null) {
          AlloyDBAdminGrpc.getGetClusterMethod =
              getGetClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.GetClusterRequest,
                          com.google.cloud.alloydb.v1alpha.Cluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.GetClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.Cluster.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("GetCluster"))
                      .build();
        }
      }
    }
    return getGetClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCluster",
      requestType = com.google.cloud.alloydb.v1alpha.CreateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.CreateClusterRequest, com.google.longrunning.Operation>
        getCreateClusterMethod;
    if ((getCreateClusterMethod = AlloyDBAdminGrpc.getCreateClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getCreateClusterMethod = AlloyDBAdminGrpc.getCreateClusterMethod) == null) {
          AlloyDBAdminGrpc.getCreateClusterMethod =
              getCreateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.CreateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.CreateClusterRequest
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
          com.google.cloud.alloydb.v1alpha.UpdateClusterRequest, com.google.longrunning.Operation>
      getUpdateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCluster",
      requestType = com.google.cloud.alloydb.v1alpha.UpdateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.UpdateClusterRequest, com.google.longrunning.Operation>
      getUpdateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.UpdateClusterRequest, com.google.longrunning.Operation>
        getUpdateClusterMethod;
    if ((getUpdateClusterMethod = AlloyDBAdminGrpc.getUpdateClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getUpdateClusterMethod = AlloyDBAdminGrpc.getUpdateClusterMethod) == null) {
          AlloyDBAdminGrpc.getUpdateClusterMethod =
              getUpdateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.UpdateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.UpdateClusterRequest
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
          com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest, com.google.longrunning.Operation>
      getUpgradeClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpgradeCluster",
      requestType = com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest, com.google.longrunning.Operation>
      getUpgradeClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest,
            com.google.longrunning.Operation>
        getUpgradeClusterMethod;
    if ((getUpgradeClusterMethod = AlloyDBAdminGrpc.getUpgradeClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getUpgradeClusterMethod = AlloyDBAdminGrpc.getUpgradeClusterMethod) == null) {
          AlloyDBAdminGrpc.getUpgradeClusterMethod =
              getUpgradeClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpgradeCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest
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
          com.google.cloud.alloydb.v1alpha.DeleteClusterRequest, com.google.longrunning.Operation>
      getDeleteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCluster",
      requestType = com.google.cloud.alloydb.v1alpha.DeleteClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.DeleteClusterRequest, com.google.longrunning.Operation>
      getDeleteClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.DeleteClusterRequest, com.google.longrunning.Operation>
        getDeleteClusterMethod;
    if ((getDeleteClusterMethod = AlloyDBAdminGrpc.getDeleteClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getDeleteClusterMethod = AlloyDBAdminGrpc.getDeleteClusterMethod) == null) {
          AlloyDBAdminGrpc.getDeleteClusterMethod =
              getDeleteClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.DeleteClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.DeleteClusterRequest
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
          com.google.cloud.alloydb.v1alpha.PromoteClusterRequest, com.google.longrunning.Operation>
      getPromoteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PromoteCluster",
      requestType = com.google.cloud.alloydb.v1alpha.PromoteClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.PromoteClusterRequest, com.google.longrunning.Operation>
      getPromoteClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.PromoteClusterRequest,
            com.google.longrunning.Operation>
        getPromoteClusterMethod;
    if ((getPromoteClusterMethod = AlloyDBAdminGrpc.getPromoteClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getPromoteClusterMethod = AlloyDBAdminGrpc.getPromoteClusterMethod) == null) {
          AlloyDBAdminGrpc.getPromoteClusterMethod =
              getPromoteClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.PromoteClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PromoteCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.PromoteClusterRequest
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
          com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest,
          com.google.longrunning.Operation>
      getSwitchoverClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SwitchoverCluster",
      requestType = com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest,
          com.google.longrunning.Operation>
      getSwitchoverClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest,
            com.google.longrunning.Operation>
        getSwitchoverClusterMethod;
    if ((getSwitchoverClusterMethod = AlloyDBAdminGrpc.getSwitchoverClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getSwitchoverClusterMethod = AlloyDBAdminGrpc.getSwitchoverClusterMethod) == null) {
          AlloyDBAdminGrpc.getSwitchoverClusterMethod =
              getSwitchoverClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SwitchoverCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest
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
          com.google.cloud.alloydb.v1alpha.RestoreClusterRequest, com.google.longrunning.Operation>
      getRestoreClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreCluster",
      requestType = com.google.cloud.alloydb.v1alpha.RestoreClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.RestoreClusterRequest, com.google.longrunning.Operation>
      getRestoreClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.RestoreClusterRequest,
            com.google.longrunning.Operation>
        getRestoreClusterMethod;
    if ((getRestoreClusterMethod = AlloyDBAdminGrpc.getRestoreClusterMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getRestoreClusterMethod = AlloyDBAdminGrpc.getRestoreClusterMethod) == null) {
          AlloyDBAdminGrpc.getRestoreClusterMethod =
              getRestoreClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.RestoreClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.RestoreClusterRequest
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
          com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest,
          com.google.longrunning.Operation>
      getCreateSecondaryClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSecondaryCluster",
      requestType = com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest,
          com.google.longrunning.Operation>
      getCreateSecondaryClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest,
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
                      .<com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSecondaryCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest
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
          com.google.cloud.alloydb.v1alpha.ListInstancesRequest,
          com.google.cloud.alloydb.v1alpha.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.alloydb.v1alpha.ListInstancesRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.ListInstancesRequest,
          com.google.cloud.alloydb.v1alpha.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.ListInstancesRequest,
            com.google.cloud.alloydb.v1alpha.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = AlloyDBAdminGrpc.getListInstancesMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getListInstancesMethod = AlloyDBAdminGrpc.getListInstancesMethod) == null) {
          AlloyDBAdminGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.ListInstancesRequest,
                          com.google.cloud.alloydb.v1alpha.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ListInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ListInstancesResponse
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
          com.google.cloud.alloydb.v1alpha.GetInstanceRequest,
          com.google.cloud.alloydb.v1alpha.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.alloydb.v1alpha.GetInstanceRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.GetInstanceRequest,
          com.google.cloud.alloydb.v1alpha.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.GetInstanceRequest,
            com.google.cloud.alloydb.v1alpha.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = AlloyDBAdminGrpc.getGetInstanceMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getGetInstanceMethod = AlloyDBAdminGrpc.getGetInstanceMethod) == null) {
          AlloyDBAdminGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.GetInstanceRequest,
                          com.google.cloud.alloydb.v1alpha.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.GetInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.alloydb.v1alpha.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.CreateInstanceRequest,
            com.google.longrunning.Operation>
        getCreateInstanceMethod;
    if ((getCreateInstanceMethod = AlloyDBAdminGrpc.getCreateInstanceMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getCreateInstanceMethod = AlloyDBAdminGrpc.getCreateInstanceMethod) == null) {
          AlloyDBAdminGrpc.getCreateInstanceMethod =
              getCreateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.CreateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.CreateInstanceRequest
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
          com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest,
          com.google.longrunning.Operation>
      getCreateSecondaryInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSecondaryInstance",
      requestType = com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest,
          com.google.longrunning.Operation>
      getCreateSecondaryInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest,
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
                      .<com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSecondaryInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest
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
          com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest,
          com.google.longrunning.Operation>
      getBatchCreateInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateInstances",
      requestType = com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest,
          com.google.longrunning.Operation>
      getBatchCreateInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest,
            com.google.longrunning.Operation>
        getBatchCreateInstancesMethod;
    if ((getBatchCreateInstancesMethod = AlloyDBAdminGrpc.getBatchCreateInstancesMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getBatchCreateInstancesMethod = AlloyDBAdminGrpc.getBatchCreateInstancesMethod)
            == null) {
          AlloyDBAdminGrpc.getBatchCreateInstancesMethod =
              getBatchCreateInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest
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
          com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest, com.google.longrunning.Operation>
      getUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstance",
      requestType = com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest, com.google.longrunning.Operation>
      getUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest,
            com.google.longrunning.Operation>
        getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = AlloyDBAdminGrpc.getUpdateInstanceMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getUpdateInstanceMethod = AlloyDBAdminGrpc.getUpdateInstanceMethod) == null) {
          AlloyDBAdminGrpc.getUpdateInstanceMethod =
              getUpdateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest
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
          com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest,
            com.google.longrunning.Operation>
        getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = AlloyDBAdminGrpc.getDeleteInstanceMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getDeleteInstanceMethod = AlloyDBAdminGrpc.getDeleteInstanceMethod) == null) {
          AlloyDBAdminGrpc.getDeleteInstanceMethod =
              getDeleteInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest
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
          com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest,
          com.google.longrunning.Operation>
      getFailoverInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FailoverInstance",
      requestType = com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest,
          com.google.longrunning.Operation>
      getFailoverInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest,
            com.google.longrunning.Operation>
        getFailoverInstanceMethod;
    if ((getFailoverInstanceMethod = AlloyDBAdminGrpc.getFailoverInstanceMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getFailoverInstanceMethod = AlloyDBAdminGrpc.getFailoverInstanceMethod) == null) {
          AlloyDBAdminGrpc.getFailoverInstanceMethod =
              getFailoverInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FailoverInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest
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
          com.google.cloud.alloydb.v1alpha.InjectFaultRequest, com.google.longrunning.Operation>
      getInjectFaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InjectFault",
      requestType = com.google.cloud.alloydb.v1alpha.InjectFaultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.InjectFaultRequest, com.google.longrunning.Operation>
      getInjectFaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.InjectFaultRequest, com.google.longrunning.Operation>
        getInjectFaultMethod;
    if ((getInjectFaultMethod = AlloyDBAdminGrpc.getInjectFaultMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getInjectFaultMethod = AlloyDBAdminGrpc.getInjectFaultMethod) == null) {
          AlloyDBAdminGrpc.getInjectFaultMethod =
              getInjectFaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.InjectFaultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InjectFault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.InjectFaultRequest
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
          com.google.cloud.alloydb.v1alpha.RestartInstanceRequest, com.google.longrunning.Operation>
      getRestartInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestartInstance",
      requestType = com.google.cloud.alloydb.v1alpha.RestartInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.RestartInstanceRequest, com.google.longrunning.Operation>
      getRestartInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.RestartInstanceRequest,
            com.google.longrunning.Operation>
        getRestartInstanceMethod;
    if ((getRestartInstanceMethod = AlloyDBAdminGrpc.getRestartInstanceMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getRestartInstanceMethod = AlloyDBAdminGrpc.getRestartInstanceMethod) == null) {
          AlloyDBAdminGrpc.getRestartInstanceMethod =
              getRestartInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.RestartInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestartInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.RestartInstanceRequest
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
          com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest,
          com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse>
      getExecuteSqlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteSql",
      requestType = com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest,
          com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse>
      getExecuteSqlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest,
            com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse>
        getExecuteSqlMethod;
    if ((getExecuteSqlMethod = AlloyDBAdminGrpc.getExecuteSqlMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getExecuteSqlMethod = AlloyDBAdminGrpc.getExecuteSqlMethod) == null) {
          AlloyDBAdminGrpc.getExecuteSqlMethod =
              getExecuteSqlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest,
                          com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteSql"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("ExecuteSql"))
                      .build();
        }
      }
    }
    return getExecuteSqlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.ListBackupsRequest,
          com.google.cloud.alloydb.v1alpha.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackups",
      requestType = com.google.cloud.alloydb.v1alpha.ListBackupsRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.ListBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.ListBackupsRequest,
          com.google.cloud.alloydb.v1alpha.ListBackupsResponse>
      getListBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.ListBackupsRequest,
            com.google.cloud.alloydb.v1alpha.ListBackupsResponse>
        getListBackupsMethod;
    if ((getListBackupsMethod = AlloyDBAdminGrpc.getListBackupsMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getListBackupsMethod = AlloyDBAdminGrpc.getListBackupsMethod) == null) {
          AlloyDBAdminGrpc.getListBackupsMethod =
              getListBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.ListBackupsRequest,
                          com.google.cloud.alloydb.v1alpha.ListBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ListBackupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ListBackupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("ListBackups"))
                      .build();
        }
      }
    }
    return getListBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.GetBackupRequest,
          com.google.cloud.alloydb.v1alpha.Backup>
      getGetBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackup",
      requestType = com.google.cloud.alloydb.v1alpha.GetBackupRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.GetBackupRequest,
          com.google.cloud.alloydb.v1alpha.Backup>
      getGetBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.GetBackupRequest,
            com.google.cloud.alloydb.v1alpha.Backup>
        getGetBackupMethod;
    if ((getGetBackupMethod = AlloyDBAdminGrpc.getGetBackupMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getGetBackupMethod = AlloyDBAdminGrpc.getGetBackupMethod) == null) {
          AlloyDBAdminGrpc.getGetBackupMethod =
              getGetBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.GetBackupRequest,
                          com.google.cloud.alloydb.v1alpha.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.GetBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("GetBackup"))
                      .build();
        }
      }
    }
    return getGetBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.CreateBackupRequest, com.google.longrunning.Operation>
      getCreateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackup",
      requestType = com.google.cloud.alloydb.v1alpha.CreateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.CreateBackupRequest, com.google.longrunning.Operation>
      getCreateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.CreateBackupRequest, com.google.longrunning.Operation>
        getCreateBackupMethod;
    if ((getCreateBackupMethod = AlloyDBAdminGrpc.getCreateBackupMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getCreateBackupMethod = AlloyDBAdminGrpc.getCreateBackupMethod) == null) {
          AlloyDBAdminGrpc.getCreateBackupMethod =
              getCreateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.CreateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.CreateBackupRequest
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
          com.google.cloud.alloydb.v1alpha.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackup",
      requestType = com.google.cloud.alloydb.v1alpha.UpdateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.UpdateBackupRequest, com.google.longrunning.Operation>
        getUpdateBackupMethod;
    if ((getUpdateBackupMethod = AlloyDBAdminGrpc.getUpdateBackupMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getUpdateBackupMethod = AlloyDBAdminGrpc.getUpdateBackupMethod) == null) {
          AlloyDBAdminGrpc.getUpdateBackupMethod =
              getUpdateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.UpdateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.UpdateBackupRequest
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
          com.google.cloud.alloydb.v1alpha.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackup",
      requestType = com.google.cloud.alloydb.v1alpha.DeleteBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.DeleteBackupRequest, com.google.longrunning.Operation>
        getDeleteBackupMethod;
    if ((getDeleteBackupMethod = AlloyDBAdminGrpc.getDeleteBackupMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getDeleteBackupMethod = AlloyDBAdminGrpc.getDeleteBackupMethod) == null) {
          AlloyDBAdminGrpc.getDeleteBackupMethod =
              getDeleteBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.DeleteBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.DeleteBackupRequest
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
          com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest,
          com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse>
      getListSupportedDatabaseFlagsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSupportedDatabaseFlags",
      requestType = com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest,
          com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse>
      getListSupportedDatabaseFlagsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest,
            com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse>
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
                      .<com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest,
                          com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSupportedDatabaseFlags"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse
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
          com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest,
          com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse>
      getGenerateClientCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateClientCertificate",
      requestType = com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest,
          com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse>
      getGenerateClientCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest,
            com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse>
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
                      .<com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest,
                          com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateClientCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse
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
          com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest,
          com.google.cloud.alloydb.v1alpha.ConnectionInfo>
      getGetConnectionInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnectionInfo",
      requestType = com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.ConnectionInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest,
          com.google.cloud.alloydb.v1alpha.ConnectionInfo>
      getGetConnectionInfoMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest,
            com.google.cloud.alloydb.v1alpha.ConnectionInfo>
        getGetConnectionInfoMethod;
    if ((getGetConnectionInfoMethod = AlloyDBAdminGrpc.getGetConnectionInfoMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getGetConnectionInfoMethod = AlloyDBAdminGrpc.getGetConnectionInfoMethod) == null) {
          AlloyDBAdminGrpc.getGetConnectionInfoMethod =
              getGetConnectionInfoMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest,
                          com.google.cloud.alloydb.v1alpha.ConnectionInfo>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConnectionInfo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ConnectionInfo.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("GetConnectionInfo"))
                      .build();
        }
      }
    }
    return getGetConnectionInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.ListUsersRequest,
          com.google.cloud.alloydb.v1alpha.ListUsersResponse>
      getListUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUsers",
      requestType = com.google.cloud.alloydb.v1alpha.ListUsersRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.ListUsersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.ListUsersRequest,
          com.google.cloud.alloydb.v1alpha.ListUsersResponse>
      getListUsersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.ListUsersRequest,
            com.google.cloud.alloydb.v1alpha.ListUsersResponse>
        getListUsersMethod;
    if ((getListUsersMethod = AlloyDBAdminGrpc.getListUsersMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getListUsersMethod = AlloyDBAdminGrpc.getListUsersMethod) == null) {
          AlloyDBAdminGrpc.getListUsersMethod =
              getListUsersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.ListUsersRequest,
                          com.google.cloud.alloydb.v1alpha.ListUsersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUsers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ListUsersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ListUsersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("ListUsers"))
                      .build();
        }
      }
    }
    return getListUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.GetUserRequest, com.google.cloud.alloydb.v1alpha.User>
      getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUser",
      requestType = com.google.cloud.alloydb.v1alpha.GetUserRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.GetUserRequest, com.google.cloud.alloydb.v1alpha.User>
      getGetUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.GetUserRequest, com.google.cloud.alloydb.v1alpha.User>
        getGetUserMethod;
    if ((getGetUserMethod = AlloyDBAdminGrpc.getGetUserMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getGetUserMethod = AlloyDBAdminGrpc.getGetUserMethod) == null) {
          AlloyDBAdminGrpc.getGetUserMethod =
              getGetUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.GetUserRequest,
                          com.google.cloud.alloydb.v1alpha.User>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.GetUserRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.User.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("GetUser"))
                      .build();
        }
      }
    }
    return getGetUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.CreateUserRequest, com.google.cloud.alloydb.v1alpha.User>
      getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = com.google.cloud.alloydb.v1alpha.CreateUserRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.CreateUserRequest, com.google.cloud.alloydb.v1alpha.User>
      getCreateUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.CreateUserRequest,
            com.google.cloud.alloydb.v1alpha.User>
        getCreateUserMethod;
    if ((getCreateUserMethod = AlloyDBAdminGrpc.getCreateUserMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getCreateUserMethod = AlloyDBAdminGrpc.getCreateUserMethod) == null) {
          AlloyDBAdminGrpc.getCreateUserMethod =
              getCreateUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.CreateUserRequest,
                          com.google.cloud.alloydb.v1alpha.User>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.CreateUserRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.User.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("CreateUser"))
                      .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.UpdateUserRequest, com.google.cloud.alloydb.v1alpha.User>
      getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = com.google.cloud.alloydb.v1alpha.UpdateUserRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.UpdateUserRequest, com.google.cloud.alloydb.v1alpha.User>
      getUpdateUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.UpdateUserRequest,
            com.google.cloud.alloydb.v1alpha.User>
        getUpdateUserMethod;
    if ((getUpdateUserMethod = AlloyDBAdminGrpc.getUpdateUserMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getUpdateUserMethod = AlloyDBAdminGrpc.getUpdateUserMethod) == null) {
          AlloyDBAdminGrpc.getUpdateUserMethod =
              getUpdateUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.UpdateUserRequest,
                          com.google.cloud.alloydb.v1alpha.User>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.UpdateUserRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.User.getDefaultInstance()))
                      .setSchemaDescriptor(new AlloyDBAdminMethodDescriptorSupplier("UpdateUser"))
                      .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.DeleteUserRequest, com.google.protobuf.Empty>
      getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUser",
      requestType = com.google.cloud.alloydb.v1alpha.DeleteUserRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.DeleteUserRequest, com.google.protobuf.Empty>
      getDeleteUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.DeleteUserRequest, com.google.protobuf.Empty>
        getDeleteUserMethod;
    if ((getDeleteUserMethod = AlloyDBAdminGrpc.getDeleteUserMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getDeleteUserMethod = AlloyDBAdminGrpc.getDeleteUserMethod) == null) {
          AlloyDBAdminGrpc.getDeleteUserMethod =
              getDeleteUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.DeleteUserRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.DeleteUserRequest
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
          com.google.cloud.alloydb.v1alpha.ListDatabasesRequest,
          com.google.cloud.alloydb.v1alpha.ListDatabasesResponse>
      getListDatabasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatabases",
      requestType = com.google.cloud.alloydb.v1alpha.ListDatabasesRequest.class,
      responseType = com.google.cloud.alloydb.v1alpha.ListDatabasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.alloydb.v1alpha.ListDatabasesRequest,
          com.google.cloud.alloydb.v1alpha.ListDatabasesResponse>
      getListDatabasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.alloydb.v1alpha.ListDatabasesRequest,
            com.google.cloud.alloydb.v1alpha.ListDatabasesResponse>
        getListDatabasesMethod;
    if ((getListDatabasesMethod = AlloyDBAdminGrpc.getListDatabasesMethod) == null) {
      synchronized (AlloyDBAdminGrpc.class) {
        if ((getListDatabasesMethod = AlloyDBAdminGrpc.getListDatabasesMethod) == null) {
          AlloyDBAdminGrpc.getListDatabasesMethod =
              getListDatabasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.alloydb.v1alpha.ListDatabasesRequest,
                          com.google.cloud.alloydb.v1alpha.ListDatabasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatabases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ListDatabasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.alloydb.v1alpha.ListDatabasesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlloyDBAdminMethodDescriptorSupplier("ListDatabases"))
                      .build();
        }
      }
    }
    return getListDatabasesMethod;
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
        com.google.cloud.alloydb.v1alpha.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListClustersResponse>
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
        com.google.cloud.alloydb.v1alpha.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.Cluster> responseObserver) {
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
        com.google.cloud.alloydb.v1alpha.CreateClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateClusterMethod(), responseObserver);
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
        com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.DeleteClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.PromoteClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.RestoreClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListInstancesResponse>
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
        com.google.cloud.alloydb.v1alpha.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.Instance> responseObserver) {
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
        com.google.cloud.alloydb.v1alpha.CreateInstanceRequest request,
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
        com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest request,
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
        com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest request,
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
        com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest request,
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
        com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest request,
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
        com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest request,
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
        com.google.cloud.alloydb.v1alpha.InjectFaultRequest request,
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
        com.google.cloud.alloydb.v1alpha.RestartInstanceRequest request,
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
        com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse>
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
        com.google.cloud.alloydb.v1alpha.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListBackupsResponse>
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
        com.google.cloud.alloydb.v1alpha.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.Backup> responseObserver) {
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
        com.google.cloud.alloydb.v1alpha.CreateBackupRequest request,
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
        com.google.cloud.alloydb.v1alpha.UpdateBackupRequest request,
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
        com.google.cloud.alloydb.v1alpha.DeleteBackupRequest request,
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
        com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse>
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
        com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse>
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
        com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ConnectionInfo>
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
        com.google.cloud.alloydb.v1alpha.ListUsersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListUsersResponse>
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
        com.google.cloud.alloydb.v1alpha.GetUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.User> responseObserver) {
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
        com.google.cloud.alloydb.v1alpha.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.User> responseObserver) {
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
        com.google.cloud.alloydb.v1alpha.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.User> responseObserver) {
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
        com.google.cloud.alloydb.v1alpha.DeleteUserRequest request,
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
        com.google.cloud.alloydb.v1alpha.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatabasesMethod(), responseObserver);
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
        com.google.cloud.alloydb.v1alpha.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListClustersResponse>
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
        com.google.cloud.alloydb.v1alpha.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.Cluster> responseObserver) {
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
        com.google.cloud.alloydb.v1alpha.CreateClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.UpdateClusterRequest request,
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
     * Upgrades a single Cluster.
     * Imperative only.
     * </pre>
     */
    public void upgradeCluster(
        com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.DeleteClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.PromoteClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.RestoreClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest request,
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
        com.google.cloud.alloydb.v1alpha.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListInstancesResponse>
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
        com.google.cloud.alloydb.v1alpha.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.Instance> responseObserver) {
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
        com.google.cloud.alloydb.v1alpha.CreateInstanceRequest request,
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
        com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest request,
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
        com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest request,
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
        com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest request,
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
        com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest request,
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
        com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest request,
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
        com.google.cloud.alloydb.v1alpha.InjectFaultRequest request,
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
        com.google.cloud.alloydb.v1alpha.RestartInstanceRequest request,
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
        com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse>
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
        com.google.cloud.alloydb.v1alpha.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListBackupsResponse>
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
        com.google.cloud.alloydb.v1alpha.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.Backup> responseObserver) {
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
        com.google.cloud.alloydb.v1alpha.CreateBackupRequest request,
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
        com.google.cloud.alloydb.v1alpha.UpdateBackupRequest request,
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
        com.google.cloud.alloydb.v1alpha.DeleteBackupRequest request,
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
        com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse>
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
        com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse>
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
        com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ConnectionInfo>
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
        com.google.cloud.alloydb.v1alpha.ListUsersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListUsersResponse>
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
        com.google.cloud.alloydb.v1alpha.GetUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.User> responseObserver) {
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
        com.google.cloud.alloydb.v1alpha.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.User> responseObserver) {
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
        com.google.cloud.alloydb.v1alpha.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.User> responseObserver) {
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
        com.google.cloud.alloydb.v1alpha.DeleteUserRequest request,
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
        com.google.cloud.alloydb.v1alpha.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatabasesMethod(), getCallOptions()),
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
    public com.google.cloud.alloydb.v1alpha.ListClustersResponse listClusters(
        com.google.cloud.alloydb.v1alpha.ListClustersRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.Cluster getCluster(
        com.google.cloud.alloydb.v1alpha.GetClusterRequest request) {
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
        com.google.cloud.alloydb.v1alpha.CreateClusterRequest request) {
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
        com.google.cloud.alloydb.v1alpha.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
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
        com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest request) {
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
        com.google.cloud.alloydb.v1alpha.DeleteClusterRequest request) {
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
        com.google.cloud.alloydb.v1alpha.PromoteClusterRequest request) {
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
        com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest request) {
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
        com.google.cloud.alloydb.v1alpha.RestoreClusterRequest request) {
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
        com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.ListInstancesResponse listInstances(
        com.google.cloud.alloydb.v1alpha.ListInstancesRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.Instance getInstance(
        com.google.cloud.alloydb.v1alpha.GetInstanceRequest request) {
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
        com.google.cloud.alloydb.v1alpha.CreateInstanceRequest request) {
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
        com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest request) {
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
        com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest request) {
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
        com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest request) {
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
        com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest request) {
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
        com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest request) {
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
        com.google.cloud.alloydb.v1alpha.InjectFaultRequest request) {
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
        com.google.cloud.alloydb.v1alpha.RestartInstanceRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse executeSql(
        com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.ListBackupsResponse listBackups(
        com.google.cloud.alloydb.v1alpha.ListBackupsRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.Backup getBackup(
        com.google.cloud.alloydb.v1alpha.GetBackupRequest request) {
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
        com.google.cloud.alloydb.v1alpha.CreateBackupRequest request) {
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
        com.google.cloud.alloydb.v1alpha.UpdateBackupRequest request) {
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
        com.google.cloud.alloydb.v1alpha.DeleteBackupRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse
        listSupportedDatabaseFlags(
            com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse
        generateClientCertificate(
            com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.ConnectionInfo getConnectionInfo(
        com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.ListUsersResponse listUsers(
        com.google.cloud.alloydb.v1alpha.ListUsersRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.User getUser(
        com.google.cloud.alloydb.v1alpha.GetUserRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.User createUser(
        com.google.cloud.alloydb.v1alpha.CreateUserRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.User updateUser(
        com.google.cloud.alloydb.v1alpha.UpdateUserRequest request) {
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
        com.google.cloud.alloydb.v1alpha.DeleteUserRequest request) {
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
    public com.google.cloud.alloydb.v1alpha.ListDatabasesResponse listDatabases(
        com.google.cloud.alloydb.v1alpha.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatabasesMethod(), getCallOptions(), request);
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
            com.google.cloud.alloydb.v1alpha.ListClustersResponse>
        listClusters(com.google.cloud.alloydb.v1alpha.ListClustersRequest request) {
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
            com.google.cloud.alloydb.v1alpha.Cluster>
        getCluster(com.google.cloud.alloydb.v1alpha.GetClusterRequest request) {
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
        createCluster(com.google.cloud.alloydb.v1alpha.CreateClusterRequest request) {
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
        updateCluster(com.google.cloud.alloydb.v1alpha.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request);
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
        upgradeCluster(com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest request) {
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
        deleteCluster(com.google.cloud.alloydb.v1alpha.DeleteClusterRequest request) {
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
        promoteCluster(com.google.cloud.alloydb.v1alpha.PromoteClusterRequest request) {
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
        switchoverCluster(com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest request) {
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
        restoreCluster(com.google.cloud.alloydb.v1alpha.RestoreClusterRequest request) {
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
            com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest request) {
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
            com.google.cloud.alloydb.v1alpha.ListInstancesResponse>
        listInstances(com.google.cloud.alloydb.v1alpha.ListInstancesRequest request) {
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
            com.google.cloud.alloydb.v1alpha.Instance>
        getInstance(com.google.cloud.alloydb.v1alpha.GetInstanceRequest request) {
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
        createInstance(com.google.cloud.alloydb.v1alpha.CreateInstanceRequest request) {
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
            com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest request) {
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
        batchCreateInstances(com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest request) {
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
        updateInstance(com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest request) {
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
        deleteInstance(com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest request) {
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
        failoverInstance(com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest request) {
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
        injectFault(com.google.cloud.alloydb.v1alpha.InjectFaultRequest request) {
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
        restartInstance(com.google.cloud.alloydb.v1alpha.RestartInstanceRequest request) {
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
            com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse>
        executeSql(com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest request) {
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
            com.google.cloud.alloydb.v1alpha.ListBackupsResponse>
        listBackups(com.google.cloud.alloydb.v1alpha.ListBackupsRequest request) {
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
            com.google.cloud.alloydb.v1alpha.Backup>
        getBackup(com.google.cloud.alloydb.v1alpha.GetBackupRequest request) {
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
        createBackup(com.google.cloud.alloydb.v1alpha.CreateBackupRequest request) {
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
        updateBackup(com.google.cloud.alloydb.v1alpha.UpdateBackupRequest request) {
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
        deleteBackup(com.google.cloud.alloydb.v1alpha.DeleteBackupRequest request) {
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
            com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse>
        listSupportedDatabaseFlags(
            com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest request) {
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
            com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse>
        generateClientCertificate(
            com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest request) {
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
            com.google.cloud.alloydb.v1alpha.ConnectionInfo>
        getConnectionInfo(com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest request) {
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
            com.google.cloud.alloydb.v1alpha.ListUsersResponse>
        listUsers(com.google.cloud.alloydb.v1alpha.ListUsersRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.alloydb.v1alpha.User>
        getUser(com.google.cloud.alloydb.v1alpha.GetUserRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.alloydb.v1alpha.User>
        createUser(com.google.cloud.alloydb.v1alpha.CreateUserRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.alloydb.v1alpha.User>
        updateUser(com.google.cloud.alloydb.v1alpha.UpdateUserRequest request) {
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
        com.google.cloud.alloydb.v1alpha.DeleteUserRequest request) {
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
            com.google.cloud.alloydb.v1alpha.ListDatabasesResponse>
        listDatabases(com.google.cloud.alloydb.v1alpha.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatabasesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CLUSTERS = 0;
  private static final int METHODID_GET_CLUSTER = 1;
  private static final int METHODID_CREATE_CLUSTER = 2;
  private static final int METHODID_UPDATE_CLUSTER = 3;
  private static final int METHODID_UPGRADE_CLUSTER = 4;
  private static final int METHODID_DELETE_CLUSTER = 5;
  private static final int METHODID_PROMOTE_CLUSTER = 6;
  private static final int METHODID_SWITCHOVER_CLUSTER = 7;
  private static final int METHODID_RESTORE_CLUSTER = 8;
  private static final int METHODID_CREATE_SECONDARY_CLUSTER = 9;
  private static final int METHODID_LIST_INSTANCES = 10;
  private static final int METHODID_GET_INSTANCE = 11;
  private static final int METHODID_CREATE_INSTANCE = 12;
  private static final int METHODID_CREATE_SECONDARY_INSTANCE = 13;
  private static final int METHODID_BATCH_CREATE_INSTANCES = 14;
  private static final int METHODID_UPDATE_INSTANCE = 15;
  private static final int METHODID_DELETE_INSTANCE = 16;
  private static final int METHODID_FAILOVER_INSTANCE = 17;
  private static final int METHODID_INJECT_FAULT = 18;
  private static final int METHODID_RESTART_INSTANCE = 19;
  private static final int METHODID_EXECUTE_SQL = 20;
  private static final int METHODID_LIST_BACKUPS = 21;
  private static final int METHODID_GET_BACKUP = 22;
  private static final int METHODID_CREATE_BACKUP = 23;
  private static final int METHODID_UPDATE_BACKUP = 24;
  private static final int METHODID_DELETE_BACKUP = 25;
  private static final int METHODID_LIST_SUPPORTED_DATABASE_FLAGS = 26;
  private static final int METHODID_GENERATE_CLIENT_CERTIFICATE = 27;
  private static final int METHODID_GET_CONNECTION_INFO = 28;
  private static final int METHODID_LIST_USERS = 29;
  private static final int METHODID_GET_USER = 30;
  private static final int METHODID_CREATE_USER = 31;
  private static final int METHODID_UPDATE_USER = 32;
  private static final int METHODID_DELETE_USER = 33;
  private static final int METHODID_LIST_DATABASES = 34;

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
              (com.google.cloud.alloydb.v1alpha.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListClustersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster(
              (com.google.cloud.alloydb.v1alpha.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.Cluster>)
                  responseObserver);
          break;
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster(
              (com.google.cloud.alloydb.v1alpha.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster(
              (com.google.cloud.alloydb.v1alpha.UpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPGRADE_CLUSTER:
          serviceImpl.upgradeCluster(
              (com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster(
              (com.google.cloud.alloydb.v1alpha.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PROMOTE_CLUSTER:
          serviceImpl.promoteCluster(
              (com.google.cloud.alloydb.v1alpha.PromoteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SWITCHOVER_CLUSTER:
          serviceImpl.switchoverCluster(
              (com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTORE_CLUSTER:
          serviceImpl.restoreCluster(
              (com.google.cloud.alloydb.v1alpha.RestoreClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_SECONDARY_CLUSTER:
          serviceImpl.createSecondaryCluster(
              (com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances(
              (com.google.cloud.alloydb.v1alpha.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.alloydb.v1alpha.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.Instance>)
                  responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance(
              (com.google.cloud.alloydb.v1alpha.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_SECONDARY_INSTANCE:
          serviceImpl.createSecondaryInstance(
              (com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_INSTANCES:
          serviceImpl.batchCreateInstances(
              (com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance(
              (com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance(
              (com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FAILOVER_INSTANCE:
          serviceImpl.failoverInstance(
              (com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_INJECT_FAULT:
          serviceImpl.injectFault(
              (com.google.cloud.alloydb.v1alpha.InjectFaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTART_INSTANCE:
          serviceImpl.restartInstance(
              (com.google.cloud.alloydb.v1alpha.RestartInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXECUTE_SQL:
          serviceImpl.executeSql(
              (com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUPS:
          serviceImpl.listBackups(
              (com.google.cloud.alloydb.v1alpha.ListBackupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP:
          serviceImpl.getBackup(
              (com.google.cloud.alloydb.v1alpha.GetBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.Backup>)
                  responseObserver);
          break;
        case METHODID_CREATE_BACKUP:
          serviceImpl.createBackup(
              (com.google.cloud.alloydb.v1alpha.CreateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_BACKUP:
          serviceImpl.updateBackup(
              (com.google.cloud.alloydb.v1alpha.UpdateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKUP:
          serviceImpl.deleteBackup(
              (com.google.cloud.alloydb.v1alpha.DeleteBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SUPPORTED_DATABASE_FLAGS:
          serviceImpl.listSupportedDatabaseFlags(
              (com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse>)
                  responseObserver);
          break;
        case METHODID_GENERATE_CLIENT_CERTIFICATE:
          serviceImpl.generateClientCertificate(
              (com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CONNECTION_INFO:
          serviceImpl.getConnectionInfo(
              (com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ConnectionInfo>)
                  responseObserver);
          break;
        case METHODID_LIST_USERS:
          serviceImpl.listUsers(
              (com.google.cloud.alloydb.v1alpha.ListUsersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListUsersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_USER:
          serviceImpl.getUser(
              (com.google.cloud.alloydb.v1alpha.GetUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.User>)
                  responseObserver);
          break;
        case METHODID_CREATE_USER:
          serviceImpl.createUser(
              (com.google.cloud.alloydb.v1alpha.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.User>)
                  responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser(
              (com.google.cloud.alloydb.v1alpha.UpdateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.User>)
                  responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser(
              (com.google.cloud.alloydb.v1alpha.DeleteUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_DATABASES:
          serviceImpl.listDatabases(
              (com.google.cloud.alloydb.v1alpha.ListDatabasesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.alloydb.v1alpha.ListDatabasesResponse>)
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
                    com.google.cloud.alloydb.v1alpha.ListClustersRequest,
                    com.google.cloud.alloydb.v1alpha.ListClustersResponse>(
                    service, METHODID_LIST_CLUSTERS)))
        .addMethod(
            getGetClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.GetClusterRequest,
                    com.google.cloud.alloydb.v1alpha.Cluster>(service, METHODID_GET_CLUSTER)))
        .addMethod(
            getCreateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.CreateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CLUSTER)))
        .addMethod(
            getUpdateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.UpdateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CLUSTER)))
        .addMethod(
            getUpgradeClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.UpgradeClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPGRADE_CLUSTER)))
        .addMethod(
            getDeleteClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.DeleteClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CLUSTER)))
        .addMethod(
            getPromoteClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.PromoteClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_PROMOTE_CLUSTER)))
        .addMethod(
            getSwitchoverClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.SwitchoverClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_SWITCHOVER_CLUSTER)))
        .addMethod(
            getRestoreClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.RestoreClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESTORE_CLUSTER)))
        .addMethod(
            getCreateSecondaryClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.CreateSecondaryClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SECONDARY_CLUSTER)))
        .addMethod(
            getListInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.ListInstancesRequest,
                    com.google.cloud.alloydb.v1alpha.ListInstancesResponse>(
                    service, METHODID_LIST_INSTANCES)))
        .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.GetInstanceRequest,
                    com.google.cloud.alloydb.v1alpha.Instance>(service, METHODID_GET_INSTANCE)))
        .addMethod(
            getCreateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.CreateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INSTANCE)))
        .addMethod(
            getCreateSecondaryInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.CreateSecondaryInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SECONDARY_INSTANCE)))
        .addMethod(
            getBatchCreateInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.BatchCreateInstancesRequest,
                    com.google.longrunning.Operation>(service, METHODID_BATCH_CREATE_INSTANCES)))
        .addMethod(
            getUpdateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.UpdateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_INSTANCE)))
        .addMethod(
            getDeleteInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.DeleteInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INSTANCE)))
        .addMethod(
            getFailoverInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.FailoverInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_FAILOVER_INSTANCE)))
        .addMethod(
            getInjectFaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.InjectFaultRequest,
                    com.google.longrunning.Operation>(service, METHODID_INJECT_FAULT)))
        .addMethod(
            getRestartInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.RestartInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESTART_INSTANCE)))
        .addMethod(
            getExecuteSqlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.ExecuteSqlRequest,
                    com.google.cloud.alloydb.v1alpha.ExecuteSqlResponse>(
                    service, METHODID_EXECUTE_SQL)))
        .addMethod(
            getListBackupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.ListBackupsRequest,
                    com.google.cloud.alloydb.v1alpha.ListBackupsResponse>(
                    service, METHODID_LIST_BACKUPS)))
        .addMethod(
            getGetBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.GetBackupRequest,
                    com.google.cloud.alloydb.v1alpha.Backup>(service, METHODID_GET_BACKUP)))
        .addMethod(
            getCreateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.CreateBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BACKUP)))
        .addMethod(
            getUpdateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.UpdateBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BACKUP)))
        .addMethod(
            getDeleteBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.DeleteBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP)))
        .addMethod(
            getListSupportedDatabaseFlagsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsRequest,
                    com.google.cloud.alloydb.v1alpha.ListSupportedDatabaseFlagsResponse>(
                    service, METHODID_LIST_SUPPORTED_DATABASE_FLAGS)))
        .addMethod(
            getGenerateClientCertificateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.GenerateClientCertificateRequest,
                    com.google.cloud.alloydb.v1alpha.GenerateClientCertificateResponse>(
                    service, METHODID_GENERATE_CLIENT_CERTIFICATE)))
        .addMethod(
            getGetConnectionInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.GetConnectionInfoRequest,
                    com.google.cloud.alloydb.v1alpha.ConnectionInfo>(
                    service, METHODID_GET_CONNECTION_INFO)))
        .addMethod(
            getListUsersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.ListUsersRequest,
                    com.google.cloud.alloydb.v1alpha.ListUsersResponse>(
                    service, METHODID_LIST_USERS)))
        .addMethod(
            getGetUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.GetUserRequest,
                    com.google.cloud.alloydb.v1alpha.User>(service, METHODID_GET_USER)))
        .addMethod(
            getCreateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.CreateUserRequest,
                    com.google.cloud.alloydb.v1alpha.User>(service, METHODID_CREATE_USER)))
        .addMethod(
            getUpdateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.UpdateUserRequest,
                    com.google.cloud.alloydb.v1alpha.User>(service, METHODID_UPDATE_USER)))
        .addMethod(
            getDeleteUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.DeleteUserRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_USER)))
        .addMethod(
            getListDatabasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.alloydb.v1alpha.ListDatabasesRequest,
                    com.google.cloud.alloydb.v1alpha.ListDatabasesResponse>(
                    service, METHODID_LIST_DATABASES)))
        .build();
  }

  private abstract static class AlloyDBAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlloyDBAdminBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.alloydb.v1alpha.ServiceProto.getDescriptor();
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
                      .build();
        }
      }
    }
    return result;
  }
}
