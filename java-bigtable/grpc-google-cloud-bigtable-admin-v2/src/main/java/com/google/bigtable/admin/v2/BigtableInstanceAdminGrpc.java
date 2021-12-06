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
package com.google.bigtable.admin.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for creating, configuring, and deleting Cloud Bigtable Instances and
 * Clusters. Provides access to the Instance and Cluster schemas only, not the
 * tables' metadata or data stored in those tables.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/bigtable/admin/v2/bigtable_instance_admin.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BigtableInstanceAdminGrpc {

  private BigtableInstanceAdminGrpc() {}

  public static final String SERVICE_NAME = "google.bigtable.admin.v2.BigtableInstanceAdmin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.bigtable.admin.v2.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.CreateInstanceRequest, com.google.longrunning.Operation>
        getCreateInstanceMethod;
    if ((getCreateInstanceMethod = BigtableInstanceAdminGrpc.getCreateInstanceMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getCreateInstanceMethod = BigtableInstanceAdminGrpc.getCreateInstanceMethod) == null) {
          BigtableInstanceAdminGrpc.getCreateInstanceMethod =
              getCreateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.CreateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.CreateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("CreateInstance"))
                      .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.GetInstanceRequest, com.google.bigtable.admin.v2.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.bigtable.admin.v2.GetInstanceRequest.class,
      responseType = com.google.bigtable.admin.v2.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.GetInstanceRequest, com.google.bigtable.admin.v2.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.GetInstanceRequest, com.google.bigtable.admin.v2.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = BigtableInstanceAdminGrpc.getGetInstanceMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getGetInstanceMethod = BigtableInstanceAdminGrpc.getGetInstanceMethod) == null) {
          BigtableInstanceAdminGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.GetInstanceRequest,
                          com.google.bigtable.admin.v2.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.GetInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.ListInstancesRequest,
          com.google.bigtable.admin.v2.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.bigtable.admin.v2.ListInstancesRequest.class,
      responseType = com.google.bigtable.admin.v2.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.ListInstancesRequest,
          com.google.bigtable.admin.v2.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.ListInstancesRequest,
            com.google.bigtable.admin.v2.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = BigtableInstanceAdminGrpc.getListInstancesMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getListInstancesMethod = BigtableInstanceAdminGrpc.getListInstancesMethod) == null) {
          BigtableInstanceAdminGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.ListInstancesRequest,
                          com.google.bigtable.admin.v2.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.ListInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.ListInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.Instance, com.google.bigtable.admin.v2.Instance>
      getUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstance",
      requestType = com.google.bigtable.admin.v2.Instance.class,
      responseType = com.google.bigtable.admin.v2.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.Instance, com.google.bigtable.admin.v2.Instance>
      getUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.Instance, com.google.bigtable.admin.v2.Instance>
        getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = BigtableInstanceAdminGrpc.getUpdateInstanceMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getUpdateInstanceMethod = BigtableInstanceAdminGrpc.getUpdateInstanceMethod) == null) {
          BigtableInstanceAdminGrpc.getUpdateInstanceMethod =
              getUpdateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.Instance,
                          com.google.bigtable.admin.v2.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.Instance.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("UpdateInstance"))
                      .build();
        }
      }
    }
    return getUpdateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.PartialUpdateInstanceRequest,
          com.google.longrunning.Operation>
      getPartialUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PartialUpdateInstance",
      requestType = com.google.bigtable.admin.v2.PartialUpdateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.PartialUpdateInstanceRequest,
          com.google.longrunning.Operation>
      getPartialUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.PartialUpdateInstanceRequest,
            com.google.longrunning.Operation>
        getPartialUpdateInstanceMethod;
    if ((getPartialUpdateInstanceMethod = BigtableInstanceAdminGrpc.getPartialUpdateInstanceMethod)
        == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getPartialUpdateInstanceMethod =
                BigtableInstanceAdminGrpc.getPartialUpdateInstanceMethod)
            == null) {
          BigtableInstanceAdminGrpc.getPartialUpdateInstanceMethod =
              getPartialUpdateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.PartialUpdateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "PartialUpdateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.PartialUpdateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier(
                              "PartialUpdateInstance"))
                      .build();
        }
      }
    }
    return getPartialUpdateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.DeleteInstanceRequest, com.google.protobuf.Empty>
      getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.bigtable.admin.v2.DeleteInstanceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.DeleteInstanceRequest, com.google.protobuf.Empty>
      getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.DeleteInstanceRequest, com.google.protobuf.Empty>
        getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = BigtableInstanceAdminGrpc.getDeleteInstanceMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getDeleteInstanceMethod = BigtableInstanceAdminGrpc.getDeleteInstanceMethod) == null) {
          BigtableInstanceAdminGrpc.getDeleteInstanceMethod =
              getDeleteInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.DeleteInstanceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.DeleteInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("DeleteInstance"))
                      .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCluster",
      requestType = com.google.bigtable.admin.v2.CreateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.CreateClusterRequest, com.google.longrunning.Operation>
        getCreateClusterMethod;
    if ((getCreateClusterMethod = BigtableInstanceAdminGrpc.getCreateClusterMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getCreateClusterMethod = BigtableInstanceAdminGrpc.getCreateClusterMethod) == null) {
          BigtableInstanceAdminGrpc.getCreateClusterMethod =
              getCreateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.CreateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.CreateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("CreateCluster"))
                      .build();
        }
      }
    }
    return getCreateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.GetClusterRequest, com.google.bigtable.admin.v2.Cluster>
      getGetClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCluster",
      requestType = com.google.bigtable.admin.v2.GetClusterRequest.class,
      responseType = com.google.bigtable.admin.v2.Cluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.GetClusterRequest, com.google.bigtable.admin.v2.Cluster>
      getGetClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.GetClusterRequest, com.google.bigtable.admin.v2.Cluster>
        getGetClusterMethod;
    if ((getGetClusterMethod = BigtableInstanceAdminGrpc.getGetClusterMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getGetClusterMethod = BigtableInstanceAdminGrpc.getGetClusterMethod) == null) {
          BigtableInstanceAdminGrpc.getGetClusterMethod =
              getGetClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.GetClusterRequest,
                          com.google.bigtable.admin.v2.Cluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.GetClusterRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.Cluster.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("GetCluster"))
                      .build();
        }
      }
    }
    return getGetClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.ListClustersRequest,
          com.google.bigtable.admin.v2.ListClustersResponse>
      getListClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClusters",
      requestType = com.google.bigtable.admin.v2.ListClustersRequest.class,
      responseType = com.google.bigtable.admin.v2.ListClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.ListClustersRequest,
          com.google.bigtable.admin.v2.ListClustersResponse>
      getListClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.ListClustersRequest,
            com.google.bigtable.admin.v2.ListClustersResponse>
        getListClustersMethod;
    if ((getListClustersMethod = BigtableInstanceAdminGrpc.getListClustersMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getListClustersMethod = BigtableInstanceAdminGrpc.getListClustersMethod) == null) {
          BigtableInstanceAdminGrpc.getListClustersMethod =
              getListClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.ListClustersRequest,
                          com.google.bigtable.admin.v2.ListClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.ListClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.ListClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("ListClusters"))
                      .build();
        }
      }
    }
    return getListClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.Cluster, com.google.longrunning.Operation>
      getUpdateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCluster",
      requestType = com.google.bigtable.admin.v2.Cluster.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.Cluster, com.google.longrunning.Operation>
      getUpdateClusterMethod() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.Cluster, com.google.longrunning.Operation>
        getUpdateClusterMethod;
    if ((getUpdateClusterMethod = BigtableInstanceAdminGrpc.getUpdateClusterMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getUpdateClusterMethod = BigtableInstanceAdminGrpc.getUpdateClusterMethod) == null) {
          BigtableInstanceAdminGrpc.getUpdateClusterMethod =
              getUpdateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.Cluster, com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.Cluster.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("UpdateCluster"))
                      .build();
        }
      }
    }
    return getUpdateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.PartialUpdateClusterRequest,
          com.google.longrunning.Operation>
      getPartialUpdateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PartialUpdateCluster",
      requestType = com.google.bigtable.admin.v2.PartialUpdateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.PartialUpdateClusterRequest,
          com.google.longrunning.Operation>
      getPartialUpdateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.PartialUpdateClusterRequest,
            com.google.longrunning.Operation>
        getPartialUpdateClusterMethod;
    if ((getPartialUpdateClusterMethod = BigtableInstanceAdminGrpc.getPartialUpdateClusterMethod)
        == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getPartialUpdateClusterMethod =
                BigtableInstanceAdminGrpc.getPartialUpdateClusterMethod)
            == null) {
          BigtableInstanceAdminGrpc.getPartialUpdateClusterMethod =
              getPartialUpdateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.PartialUpdateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "PartialUpdateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.PartialUpdateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("PartialUpdateCluster"))
                      .build();
        }
      }
    }
    return getPartialUpdateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.DeleteClusterRequest, com.google.protobuf.Empty>
      getDeleteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCluster",
      requestType = com.google.bigtable.admin.v2.DeleteClusterRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.DeleteClusterRequest, com.google.protobuf.Empty>
      getDeleteClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.DeleteClusterRequest, com.google.protobuf.Empty>
        getDeleteClusterMethod;
    if ((getDeleteClusterMethod = BigtableInstanceAdminGrpc.getDeleteClusterMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getDeleteClusterMethod = BigtableInstanceAdminGrpc.getDeleteClusterMethod) == null) {
          BigtableInstanceAdminGrpc.getDeleteClusterMethod =
              getDeleteClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.DeleteClusterRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.DeleteClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("DeleteCluster"))
                      .build();
        }
      }
    }
    return getDeleteClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.CreateAppProfileRequest,
          com.google.bigtable.admin.v2.AppProfile>
      getCreateAppProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAppProfile",
      requestType = com.google.bigtable.admin.v2.CreateAppProfileRequest.class,
      responseType = com.google.bigtable.admin.v2.AppProfile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.CreateAppProfileRequest,
          com.google.bigtable.admin.v2.AppProfile>
      getCreateAppProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.CreateAppProfileRequest,
            com.google.bigtable.admin.v2.AppProfile>
        getCreateAppProfileMethod;
    if ((getCreateAppProfileMethod = BigtableInstanceAdminGrpc.getCreateAppProfileMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getCreateAppProfileMethod = BigtableInstanceAdminGrpc.getCreateAppProfileMethod)
            == null) {
          BigtableInstanceAdminGrpc.getCreateAppProfileMethod =
              getCreateAppProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.CreateAppProfileRequest,
                          com.google.bigtable.admin.v2.AppProfile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAppProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.CreateAppProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.AppProfile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("CreateAppProfile"))
                      .build();
        }
      }
    }
    return getCreateAppProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.GetAppProfileRequest,
          com.google.bigtable.admin.v2.AppProfile>
      getGetAppProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAppProfile",
      requestType = com.google.bigtable.admin.v2.GetAppProfileRequest.class,
      responseType = com.google.bigtable.admin.v2.AppProfile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.GetAppProfileRequest,
          com.google.bigtable.admin.v2.AppProfile>
      getGetAppProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.GetAppProfileRequest,
            com.google.bigtable.admin.v2.AppProfile>
        getGetAppProfileMethod;
    if ((getGetAppProfileMethod = BigtableInstanceAdminGrpc.getGetAppProfileMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getGetAppProfileMethod = BigtableInstanceAdminGrpc.getGetAppProfileMethod) == null) {
          BigtableInstanceAdminGrpc.getGetAppProfileMethod =
              getGetAppProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.GetAppProfileRequest,
                          com.google.bigtable.admin.v2.AppProfile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAppProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.GetAppProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.AppProfile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("GetAppProfile"))
                      .build();
        }
      }
    }
    return getGetAppProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.ListAppProfilesRequest,
          com.google.bigtable.admin.v2.ListAppProfilesResponse>
      getListAppProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAppProfiles",
      requestType = com.google.bigtable.admin.v2.ListAppProfilesRequest.class,
      responseType = com.google.bigtable.admin.v2.ListAppProfilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.ListAppProfilesRequest,
          com.google.bigtable.admin.v2.ListAppProfilesResponse>
      getListAppProfilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.ListAppProfilesRequest,
            com.google.bigtable.admin.v2.ListAppProfilesResponse>
        getListAppProfilesMethod;
    if ((getListAppProfilesMethod = BigtableInstanceAdminGrpc.getListAppProfilesMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getListAppProfilesMethod = BigtableInstanceAdminGrpc.getListAppProfilesMethod)
            == null) {
          BigtableInstanceAdminGrpc.getListAppProfilesMethod =
              getListAppProfilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.ListAppProfilesRequest,
                          com.google.bigtable.admin.v2.ListAppProfilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAppProfiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.ListAppProfilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.ListAppProfilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("ListAppProfiles"))
                      .build();
        }
      }
    }
    return getListAppProfilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.UpdateAppProfileRequest, com.google.longrunning.Operation>
      getUpdateAppProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAppProfile",
      requestType = com.google.bigtable.admin.v2.UpdateAppProfileRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.UpdateAppProfileRequest, com.google.longrunning.Operation>
      getUpdateAppProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.UpdateAppProfileRequest, com.google.longrunning.Operation>
        getUpdateAppProfileMethod;
    if ((getUpdateAppProfileMethod = BigtableInstanceAdminGrpc.getUpdateAppProfileMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getUpdateAppProfileMethod = BigtableInstanceAdminGrpc.getUpdateAppProfileMethod)
            == null) {
          BigtableInstanceAdminGrpc.getUpdateAppProfileMethod =
              getUpdateAppProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.UpdateAppProfileRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAppProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.UpdateAppProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("UpdateAppProfile"))
                      .build();
        }
      }
    }
    return getUpdateAppProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.DeleteAppProfileRequest, com.google.protobuf.Empty>
      getDeleteAppProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAppProfile",
      requestType = com.google.bigtable.admin.v2.DeleteAppProfileRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.bigtable.admin.v2.DeleteAppProfileRequest, com.google.protobuf.Empty>
      getDeleteAppProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.bigtable.admin.v2.DeleteAppProfileRequest, com.google.protobuf.Empty>
        getDeleteAppProfileMethod;
    if ((getDeleteAppProfileMethod = BigtableInstanceAdminGrpc.getDeleteAppProfileMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getDeleteAppProfileMethod = BigtableInstanceAdminGrpc.getDeleteAppProfileMethod)
            == null) {
          BigtableInstanceAdminGrpc.getDeleteAppProfileMethod =
              getDeleteAppProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.bigtable.admin.v2.DeleteAppProfileRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAppProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.bigtable.admin.v2.DeleteAppProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BigtableInstanceAdminMethodDescriptorSupplier("DeleteAppProfile"))
                      .build();
        }
      }
    }
    return getDeleteAppProfileMethod;
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
    if ((getGetIamPolicyMethod = BigtableInstanceAdminGrpc.getGetIamPolicyMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getGetIamPolicyMethod = BigtableInstanceAdminGrpc.getGetIamPolicyMethod) == null) {
          BigtableInstanceAdminGrpc.getGetIamPolicyMethod =
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
                          new BigtableInstanceAdminMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
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
    if ((getSetIamPolicyMethod = BigtableInstanceAdminGrpc.getSetIamPolicyMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getSetIamPolicyMethod = BigtableInstanceAdminGrpc.getSetIamPolicyMethod) == null) {
          BigtableInstanceAdminGrpc.getSetIamPolicyMethod =
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
                          new BigtableInstanceAdminMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
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
    if ((getTestIamPermissionsMethod = BigtableInstanceAdminGrpc.getTestIamPermissionsMethod)
        == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getTestIamPermissionsMethod = BigtableInstanceAdminGrpc.getTestIamPermissionsMethod)
            == null) {
          BigtableInstanceAdminGrpc.getTestIamPermissionsMethod =
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
                          new BigtableInstanceAdminMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BigtableInstanceAdminStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigtableInstanceAdminStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigtableInstanceAdminStub>() {
          @java.lang.Override
          public BigtableInstanceAdminStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigtableInstanceAdminStub(channel, callOptions);
          }
        };
    return BigtableInstanceAdminStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BigtableInstanceAdminBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigtableInstanceAdminBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigtableInstanceAdminBlockingStub>() {
          @java.lang.Override
          public BigtableInstanceAdminBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigtableInstanceAdminBlockingStub(channel, callOptions);
          }
        };
    return BigtableInstanceAdminBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BigtableInstanceAdminFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BigtableInstanceAdminFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BigtableInstanceAdminFutureStub>() {
          @java.lang.Override
          public BigtableInstanceAdminFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BigtableInstanceAdminFutureStub(channel, callOptions);
          }
        };
    return BigtableInstanceAdminFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for creating, configuring, and deleting Cloud Bigtable Instances and
   * Clusters. Provides access to the Instance and Cluster schemas only, not the
   * tables' metadata or data stored in those tables.
   * </pre>
   */
  public abstract static class BigtableInstanceAdminImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Create an instance within a project.
     * Note that exactly one of Cluster.serve_nodes and
     * Cluster.cluster_config.cluster_autoscaling_config can be set. If
     * serve_nodes is set to non-zero, then the cluster is manually scaled. If
     * cluster_config.cluster_autoscaling_config is non-empty, then autoscaling is
     * enabled.
     * </pre>
     */
    public void createInstance(
        com.google.bigtable.admin.v2.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an instance.
     * </pre>
     */
    public void getInstance(
        com.google.bigtable.admin.v2.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists information about instances in a project.
     * </pre>
     */
    public void listInstances(
        com.google.bigtable.admin.v2.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an instance within a project. This method updates only the display
     * name and type for an Instance. To update other Instance properties, such as
     * labels, use PartialUpdateInstance.
     * </pre>
     */
    public void updateInstance(
        com.google.bigtable.admin.v2.Instance request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Partially updates an instance within a project. This method can modify all
     * fields of an Instance and is the preferred way to update an Instance.
     * </pre>
     */
    public void partialUpdateInstance(
        com.google.bigtable.admin.v2.PartialUpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPartialUpdateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an instance from a project.
     * </pre>
     */
    public void deleteInstance(
        com.google.bigtable.admin.v2.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster within an instance.
     * Note that exactly one of Cluster.serve_nodes and
     * Cluster.cluster_config.cluster_autoscaling_config can be set. If
     * serve_nodes is set to non-zero, then the cluster is manually scaled. If
     * cluster_config.cluster_autoscaling_config is non-empty, then autoscaling is
     * enabled.
     * </pre>
     */
    public void createCluster(
        com.google.bigtable.admin.v2.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a cluster.
     * </pre>
     */
    public void getCluster(
        com.google.bigtable.admin.v2.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Cluster> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists information about clusters in an instance.
     * </pre>
     */
    public void listClusters(
        com.google.bigtable.admin.v2.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a cluster within an instance.
     * Note that UpdateCluster does not support updating
     * cluster_config.cluster_autoscaling_config. In order to update it, you
     * must use PartialUpdateCluster.
     * </pre>
     */
    public void updateCluster(
        com.google.bigtable.admin.v2.Cluster request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Partially updates a cluster within a project. This method is the preferred
     * way to update a Cluster.
     * To enable and update autoscaling, set
     * cluster_config.cluster_autoscaling_config. When autoscaling is enabled,
     * serve_nodes is treated as an OUTPUT_ONLY field, meaning that updates to it
     * are ignored. Note that an update cannot simultaneously set serve_nodes to
     * non-zero and cluster_config.cluster_autoscaling_config to non-empty, and
     * also specify both in the update_mask.
     * To disable autoscaling, clear cluster_config.cluster_autoscaling_config,
     * and explicitly set a serve_node count via the update_mask.
     * </pre>
     */
    public void partialUpdateCluster(
        com.google.bigtable.admin.v2.PartialUpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPartialUpdateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a cluster from an instance.
     * </pre>
     */
    public void deleteCluster(
        com.google.bigtable.admin.v2.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an app profile within an instance.
     * </pre>
     */
    public void createAppProfile(
        com.google.bigtable.admin.v2.CreateAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.AppProfile> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAppProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an app profile.
     * </pre>
     */
    public void getAppProfile(
        com.google.bigtable.admin.v2.GetAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.AppProfile> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAppProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists information about app profiles in an instance.
     * </pre>
     */
    public void listAppProfiles(
        com.google.bigtable.admin.v2.ListAppProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListAppProfilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAppProfilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an app profile within an instance.
     * </pre>
     */
    public void updateAppProfile(
        com.google.bigtable.admin.v2.UpdateAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAppProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an app profile from an instance.
     * </pre>
     */
    public void deleteAppProfile(
        com.google.bigtable.admin.v2.DeleteAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAppProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for an instance resource. Returns an empty
     * policy if an instance exists but does not have a policy set.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on an instance resource. Replaces any
     * existing policy.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that the caller has on the specified instance resource.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.CreateInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_INSTANCE)))
          .addMethod(
              getGetInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.GetInstanceRequest,
                      com.google.bigtable.admin.v2.Instance>(this, METHODID_GET_INSTANCE)))
          .addMethod(
              getListInstancesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.ListInstancesRequest,
                      com.google.bigtable.admin.v2.ListInstancesResponse>(
                      this, METHODID_LIST_INSTANCES)))
          .addMethod(
              getUpdateInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.Instance, com.google.bigtable.admin.v2.Instance>(
                      this, METHODID_UPDATE_INSTANCE)))
          .addMethod(
              getPartialUpdateInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.PartialUpdateInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_PARTIAL_UPDATE_INSTANCE)))
          .addMethod(
              getDeleteInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.DeleteInstanceRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_INSTANCE)))
          .addMethod(
              getCreateClusterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.CreateClusterRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_CLUSTER)))
          .addMethod(
              getGetClusterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.GetClusterRequest,
                      com.google.bigtable.admin.v2.Cluster>(this, METHODID_GET_CLUSTER)))
          .addMethod(
              getListClustersMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.ListClustersRequest,
                      com.google.bigtable.admin.v2.ListClustersResponse>(
                      this, METHODID_LIST_CLUSTERS)))
          .addMethod(
              getUpdateClusterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.Cluster, com.google.longrunning.Operation>(
                      this, METHODID_UPDATE_CLUSTER)))
          .addMethod(
              getPartialUpdateClusterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.PartialUpdateClusterRequest,
                      com.google.longrunning.Operation>(this, METHODID_PARTIAL_UPDATE_CLUSTER)))
          .addMethod(
              getDeleteClusterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.DeleteClusterRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_CLUSTER)))
          .addMethod(
              getCreateAppProfileMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.CreateAppProfileRequest,
                      com.google.bigtable.admin.v2.AppProfile>(this, METHODID_CREATE_APP_PROFILE)))
          .addMethod(
              getGetAppProfileMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.GetAppProfileRequest,
                      com.google.bigtable.admin.v2.AppProfile>(this, METHODID_GET_APP_PROFILE)))
          .addMethod(
              getListAppProfilesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.ListAppProfilesRequest,
                      com.google.bigtable.admin.v2.ListAppProfilesResponse>(
                      this, METHODID_LIST_APP_PROFILES)))
          .addMethod(
              getUpdateAppProfileMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.UpdateAppProfileRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_APP_PROFILE)))
          .addMethod(
              getDeleteAppProfileMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.bigtable.admin.v2.DeleteAppProfileRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_APP_PROFILE)))
          .addMethod(
              getGetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getSetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getTestIamPermissionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.TestIamPermissionsRequest,
                      com.google.iam.v1.TestIamPermissionsResponse>(
                      this, METHODID_TEST_IAM_PERMISSIONS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for creating, configuring, and deleting Cloud Bigtable Instances and
   * Clusters. Provides access to the Instance and Cluster schemas only, not the
   * tables' metadata or data stored in those tables.
   * </pre>
   */
  public static final class BigtableInstanceAdminStub
      extends io.grpc.stub.AbstractAsyncStub<BigtableInstanceAdminStub> {
    private BigtableInstanceAdminStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigtableInstanceAdminStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigtableInstanceAdminStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an instance within a project.
     * Note that exactly one of Cluster.serve_nodes and
     * Cluster.cluster_config.cluster_autoscaling_config can be set. If
     * serve_nodes is set to non-zero, then the cluster is manually scaled. If
     * cluster_config.cluster_autoscaling_config is non-empty, then autoscaling is
     * enabled.
     * </pre>
     */
    public void createInstance(
        com.google.bigtable.admin.v2.CreateInstanceRequest request,
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
     * Gets information about an instance.
     * </pre>
     */
    public void getInstance(
        com.google.bigtable.admin.v2.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists information about instances in a project.
     * </pre>
     */
    public void listInstances(
        com.google.bigtable.admin.v2.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListInstancesResponse>
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
     * Updates an instance within a project. This method updates only the display
     * name and type for an Instance. To update other Instance properties, such as
     * labels, use PartialUpdateInstance.
     * </pre>
     */
    public void updateInstance(
        com.google.bigtable.admin.v2.Instance request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Partially updates an instance within a project. This method can modify all
     * fields of an Instance and is the preferred way to update an Instance.
     * </pre>
     */
    public void partialUpdateInstance(
        com.google.bigtable.admin.v2.PartialUpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPartialUpdateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an instance from a project.
     * </pre>
     */
    public void deleteInstance(
        com.google.bigtable.admin.v2.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster within an instance.
     * Note that exactly one of Cluster.serve_nodes and
     * Cluster.cluster_config.cluster_autoscaling_config can be set. If
     * serve_nodes is set to non-zero, then the cluster is manually scaled. If
     * cluster_config.cluster_autoscaling_config is non-empty, then autoscaling is
     * enabled.
     * </pre>
     */
    public void createCluster(
        com.google.bigtable.admin.v2.CreateClusterRequest request,
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
     * Gets information about a cluster.
     * </pre>
     */
    public void getCluster(
        com.google.bigtable.admin.v2.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Cluster> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists information about clusters in an instance.
     * </pre>
     */
    public void listClusters(
        com.google.bigtable.admin.v2.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListClustersResponse>
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
     * Updates a cluster within an instance.
     * Note that UpdateCluster does not support updating
     * cluster_config.cluster_autoscaling_config. In order to update it, you
     * must use PartialUpdateCluster.
     * </pre>
     */
    public void updateCluster(
        com.google.bigtable.admin.v2.Cluster request,
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
     * Partially updates a cluster within a project. This method is the preferred
     * way to update a Cluster.
     * To enable and update autoscaling, set
     * cluster_config.cluster_autoscaling_config. When autoscaling is enabled,
     * serve_nodes is treated as an OUTPUT_ONLY field, meaning that updates to it
     * are ignored. Note that an update cannot simultaneously set serve_nodes to
     * non-zero and cluster_config.cluster_autoscaling_config to non-empty, and
     * also specify both in the update_mask.
     * To disable autoscaling, clear cluster_config.cluster_autoscaling_config,
     * and explicitly set a serve_node count via the update_mask.
     * </pre>
     */
    public void partialUpdateCluster(
        com.google.bigtable.admin.v2.PartialUpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPartialUpdateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a cluster from an instance.
     * </pre>
     */
    public void deleteCluster(
        com.google.bigtable.admin.v2.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an app profile within an instance.
     * </pre>
     */
    public void createAppProfile(
        com.google.bigtable.admin.v2.CreateAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.AppProfile> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAppProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an app profile.
     * </pre>
     */
    public void getAppProfile(
        com.google.bigtable.admin.v2.GetAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.AppProfile> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAppProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists information about app profiles in an instance.
     * </pre>
     */
    public void listAppProfiles(
        com.google.bigtable.admin.v2.ListAppProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListAppProfilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAppProfilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an app profile within an instance.
     * </pre>
     */
    public void updateAppProfile(
        com.google.bigtable.admin.v2.UpdateAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAppProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an app profile from an instance.
     * </pre>
     */
    public void deleteAppProfile(
        com.google.bigtable.admin.v2.DeleteAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAppProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for an instance resource. Returns an empty
     * policy if an instance exists but does not have a policy set.
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
     * Sets the access control policy on an instance resource. Replaces any
     * existing policy.
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
     * Returns permissions that the caller has on the specified instance resource.
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
  }

  /**
   *
   *
   * <pre>
   * Service for creating, configuring, and deleting Cloud Bigtable Instances and
   * Clusters. Provides access to the Instance and Cluster schemas only, not the
   * tables' metadata or data stored in those tables.
   * </pre>
   */
  public static final class BigtableInstanceAdminBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BigtableInstanceAdminBlockingStub> {
    private BigtableInstanceAdminBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigtableInstanceAdminBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigtableInstanceAdminBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an instance within a project.
     * Note that exactly one of Cluster.serve_nodes and
     * Cluster.cluster_config.cluster_autoscaling_config can be set. If
     * serve_nodes is set to non-zero, then the cluster is manually scaled. If
     * cluster_config.cluster_autoscaling_config is non-empty, then autoscaling is
     * enabled.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.bigtable.admin.v2.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an instance.
     * </pre>
     */
    public com.google.bigtable.admin.v2.Instance getInstance(
        com.google.bigtable.admin.v2.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists information about instances in a project.
     * </pre>
     */
    public com.google.bigtable.admin.v2.ListInstancesResponse listInstances(
        com.google.bigtable.admin.v2.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an instance within a project. This method updates only the display
     * name and type for an Instance. To update other Instance properties, such as
     * labels, use PartialUpdateInstance.
     * </pre>
     */
    public com.google.bigtable.admin.v2.Instance updateInstance(
        com.google.bigtable.admin.v2.Instance request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Partially updates an instance within a project. This method can modify all
     * fields of an Instance and is the preferred way to update an Instance.
     * </pre>
     */
    public com.google.longrunning.Operation partialUpdateInstance(
        com.google.bigtable.admin.v2.PartialUpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPartialUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an instance from a project.
     * </pre>
     */
    public com.google.protobuf.Empty deleteInstance(
        com.google.bigtable.admin.v2.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster within an instance.
     * Note that exactly one of Cluster.serve_nodes and
     * Cluster.cluster_config.cluster_autoscaling_config can be set. If
     * serve_nodes is set to non-zero, then the cluster is manually scaled. If
     * cluster_config.cluster_autoscaling_config is non-empty, then autoscaling is
     * enabled.
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(
        com.google.bigtable.admin.v2.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a cluster.
     * </pre>
     */
    public com.google.bigtable.admin.v2.Cluster getCluster(
        com.google.bigtable.admin.v2.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists information about clusters in an instance.
     * </pre>
     */
    public com.google.bigtable.admin.v2.ListClustersResponse listClusters(
        com.google.bigtable.admin.v2.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a cluster within an instance.
     * Note that UpdateCluster does not support updating
     * cluster_config.cluster_autoscaling_config. In order to update it, you
     * must use PartialUpdateCluster.
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(
        com.google.bigtable.admin.v2.Cluster request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Partially updates a cluster within a project. This method is the preferred
     * way to update a Cluster.
     * To enable and update autoscaling, set
     * cluster_config.cluster_autoscaling_config. When autoscaling is enabled,
     * serve_nodes is treated as an OUTPUT_ONLY field, meaning that updates to it
     * are ignored. Note that an update cannot simultaneously set serve_nodes to
     * non-zero and cluster_config.cluster_autoscaling_config to non-empty, and
     * also specify both in the update_mask.
     * To disable autoscaling, clear cluster_config.cluster_autoscaling_config,
     * and explicitly set a serve_node count via the update_mask.
     * </pre>
     */
    public com.google.longrunning.Operation partialUpdateCluster(
        com.google.bigtable.admin.v2.PartialUpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPartialUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a cluster from an instance.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCluster(
        com.google.bigtable.admin.v2.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an app profile within an instance.
     * </pre>
     */
    public com.google.bigtable.admin.v2.AppProfile createAppProfile(
        com.google.bigtable.admin.v2.CreateAppProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAppProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an app profile.
     * </pre>
     */
    public com.google.bigtable.admin.v2.AppProfile getAppProfile(
        com.google.bigtable.admin.v2.GetAppProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAppProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists information about app profiles in an instance.
     * </pre>
     */
    public com.google.bigtable.admin.v2.ListAppProfilesResponse listAppProfiles(
        com.google.bigtable.admin.v2.ListAppProfilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAppProfilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an app profile within an instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateAppProfile(
        com.google.bigtable.admin.v2.UpdateAppProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAppProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an app profile from an instance.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAppProfile(
        com.google.bigtable.admin.v2.DeleteAppProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAppProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for an instance resource. Returns an empty
     * policy if an instance exists but does not have a policy set.
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
     * Sets the access control policy on an instance resource. Replaces any
     * existing policy.
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
     * Returns permissions that the caller has on the specified instance resource.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for creating, configuring, and deleting Cloud Bigtable Instances and
   * Clusters. Provides access to the Instance and Cluster schemas only, not the
   * tables' metadata or data stored in those tables.
   * </pre>
   */
  public static final class BigtableInstanceAdminFutureStub
      extends io.grpc.stub.AbstractFutureStub<BigtableInstanceAdminFutureStub> {
    private BigtableInstanceAdminFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigtableInstanceAdminFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BigtableInstanceAdminFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an instance within a project.
     * Note that exactly one of Cluster.serve_nodes and
     * Cluster.cluster_config.cluster_autoscaling_config can be set. If
     * serve_nodes is set to non-zero, then the cluster is manually scaled. If
     * cluster_config.cluster_autoscaling_config is non-empty, then autoscaling is
     * enabled.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInstance(com.google.bigtable.admin.v2.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.bigtable.admin.v2.Instance>
        getInstance(com.google.bigtable.admin.v2.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists information about instances in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.bigtable.admin.v2.ListInstancesResponse>
        listInstances(com.google.bigtable.admin.v2.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an instance within a project. This method updates only the display
     * name and type for an Instance. To update other Instance properties, such as
     * labels, use PartialUpdateInstance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.bigtable.admin.v2.Instance>
        updateInstance(com.google.bigtable.admin.v2.Instance request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Partially updates an instance within a project. This method can modify all
     * fields of an Instance and is the preferred way to update an Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        partialUpdateInstance(com.google.bigtable.admin.v2.PartialUpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPartialUpdateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an instance from a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteInstance(com.google.bigtable.admin.v2.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster within an instance.
     * Note that exactly one of Cluster.serve_nodes and
     * Cluster.cluster_config.cluster_autoscaling_config can be set. If
     * serve_nodes is set to non-zero, then the cluster is manually scaled. If
     * cluster_config.cluster_autoscaling_config is non-empty, then autoscaling is
     * enabled.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCluster(com.google.bigtable.admin.v2.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.bigtable.admin.v2.Cluster>
        getCluster(com.google.bigtable.admin.v2.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists information about clusters in an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.bigtable.admin.v2.ListClustersResponse>
        listClusters(com.google.bigtable.admin.v2.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a cluster within an instance.
     * Note that UpdateCluster does not support updating
     * cluster_config.cluster_autoscaling_config. In order to update it, you
     * must use PartialUpdateCluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCluster(com.google.bigtable.admin.v2.Cluster request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Partially updates a cluster within a project. This method is the preferred
     * way to update a Cluster.
     * To enable and update autoscaling, set
     * cluster_config.cluster_autoscaling_config. When autoscaling is enabled,
     * serve_nodes is treated as an OUTPUT_ONLY field, meaning that updates to it
     * are ignored. Note that an update cannot simultaneously set serve_nodes to
     * non-zero and cluster_config.cluster_autoscaling_config to non-empty, and
     * also specify both in the update_mask.
     * To disable autoscaling, clear cluster_config.cluster_autoscaling_config,
     * and explicitly set a serve_node count via the update_mask.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        partialUpdateCluster(com.google.bigtable.admin.v2.PartialUpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPartialUpdateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a cluster from an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCluster(com.google.bigtable.admin.v2.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an app profile within an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.bigtable.admin.v2.AppProfile>
        createAppProfile(com.google.bigtable.admin.v2.CreateAppProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAppProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about an app profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.bigtable.admin.v2.AppProfile>
        getAppProfile(com.google.bigtable.admin.v2.GetAppProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAppProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists information about app profiles in an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.bigtable.admin.v2.ListAppProfilesResponse>
        listAppProfiles(com.google.bigtable.admin.v2.ListAppProfilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAppProfilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an app profile within an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateAppProfile(com.google.bigtable.admin.v2.UpdateAppProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAppProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an app profile from an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAppProfile(com.google.bigtable.admin.v2.DeleteAppProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAppProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for an instance resource. Returns an empty
     * policy if an instance exists but does not have a policy set.
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
     * Sets the access control policy on an instance resource. Replaces any
     * existing policy.
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
     * Returns permissions that the caller has on the specified instance resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_INSTANCE = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_LIST_INSTANCES = 2;
  private static final int METHODID_UPDATE_INSTANCE = 3;
  private static final int METHODID_PARTIAL_UPDATE_INSTANCE = 4;
  private static final int METHODID_DELETE_INSTANCE = 5;
  private static final int METHODID_CREATE_CLUSTER = 6;
  private static final int METHODID_GET_CLUSTER = 7;
  private static final int METHODID_LIST_CLUSTERS = 8;
  private static final int METHODID_UPDATE_CLUSTER = 9;
  private static final int METHODID_PARTIAL_UPDATE_CLUSTER = 10;
  private static final int METHODID_DELETE_CLUSTER = 11;
  private static final int METHODID_CREATE_APP_PROFILE = 12;
  private static final int METHODID_GET_APP_PROFILE = 13;
  private static final int METHODID_LIST_APP_PROFILES = 14;
  private static final int METHODID_UPDATE_APP_PROFILE = 15;
  private static final int METHODID_DELETE_APP_PROFILE = 16;
  private static final int METHODID_GET_IAM_POLICY = 17;
  private static final int METHODID_SET_IAM_POLICY = 18;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 19;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BigtableInstanceAdminImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BigtableInstanceAdminImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance(
              (com.google.bigtable.admin.v2.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.bigtable.admin.v2.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Instance>)
                  responseObserver);
          break;
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances(
              (com.google.bigtable.admin.v2.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance(
              (com.google.bigtable.admin.v2.Instance) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Instance>)
                  responseObserver);
          break;
        case METHODID_PARTIAL_UPDATE_INSTANCE:
          serviceImpl.partialUpdateInstance(
              (com.google.bigtable.admin.v2.PartialUpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance(
              (com.google.bigtable.admin.v2.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster(
              (com.google.bigtable.admin.v2.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster(
              (com.google.bigtable.admin.v2.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Cluster>) responseObserver);
          break;
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters(
              (com.google.bigtable.admin.v2.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListClustersResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster(
              (com.google.bigtable.admin.v2.Cluster) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PARTIAL_UPDATE_CLUSTER:
          serviceImpl.partialUpdateCluster(
              (com.google.bigtable.admin.v2.PartialUpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster(
              (com.google.bigtable.admin.v2.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_APP_PROFILE:
          serviceImpl.createAppProfile(
              (com.google.bigtable.admin.v2.CreateAppProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.AppProfile>)
                  responseObserver);
          break;
        case METHODID_GET_APP_PROFILE:
          serviceImpl.getAppProfile(
              (com.google.bigtable.admin.v2.GetAppProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.AppProfile>)
                  responseObserver);
          break;
        case METHODID_LIST_APP_PROFILES:
          serviceImpl.listAppProfiles(
              (com.google.bigtable.admin.v2.ListAppProfilesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListAppProfilesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_APP_PROFILE:
          serviceImpl.updateAppProfile(
              (com.google.bigtable.admin.v2.UpdateAppProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_APP_PROFILE:
          serviceImpl.deleteAppProfile(
              (com.google.bigtable.admin.v2.DeleteAppProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
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

  private abstract static class BigtableInstanceAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BigtableInstanceAdminBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.bigtable.admin.v2.BigtableInstanceAdminProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BigtableInstanceAdmin");
    }
  }

  private static final class BigtableInstanceAdminFileDescriptorSupplier
      extends BigtableInstanceAdminBaseDescriptorSupplier {
    BigtableInstanceAdminFileDescriptorSupplier() {}
  }

  private static final class BigtableInstanceAdminMethodDescriptorSupplier
      extends BigtableInstanceAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BigtableInstanceAdminMethodDescriptorSupplier(String methodName) {
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
      synchronized (BigtableInstanceAdminGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BigtableInstanceAdminFileDescriptorSupplier())
                      .addMethod(getCreateInstanceMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getUpdateInstanceMethod())
                      .addMethod(getPartialUpdateInstanceMethod())
                      .addMethod(getDeleteInstanceMethod())
                      .addMethod(getCreateClusterMethod())
                      .addMethod(getGetClusterMethod())
                      .addMethod(getListClustersMethod())
                      .addMethod(getUpdateClusterMethod())
                      .addMethod(getPartialUpdateClusterMethod())
                      .addMethod(getDeleteClusterMethod())
                      .addMethod(getCreateAppProfileMethod())
                      .addMethod(getGetAppProfileMethod())
                      .addMethod(getListAppProfilesMethod())
                      .addMethod(getUpdateAppProfileMethod())
                      .addMethod(getDeleteAppProfileMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
