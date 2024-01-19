/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.workstations.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for interacting with Cloud Workstations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/workstations/v1/workstations.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WorkstationsGrpc {

  private WorkstationsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.workstations.v1.Workstations";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.GetWorkstationClusterRequest,
          com.google.cloud.workstations.v1.WorkstationCluster>
      getGetWorkstationClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkstationCluster",
      requestType = com.google.cloud.workstations.v1.GetWorkstationClusterRequest.class,
      responseType = com.google.cloud.workstations.v1.WorkstationCluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.GetWorkstationClusterRequest,
          com.google.cloud.workstations.v1.WorkstationCluster>
      getGetWorkstationClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.GetWorkstationClusterRequest,
            com.google.cloud.workstations.v1.WorkstationCluster>
        getGetWorkstationClusterMethod;
    if ((getGetWorkstationClusterMethod = WorkstationsGrpc.getGetWorkstationClusterMethod)
        == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getGetWorkstationClusterMethod = WorkstationsGrpc.getGetWorkstationClusterMethod)
            == null) {
          WorkstationsGrpc.getGetWorkstationClusterMethod =
              getGetWorkstationClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.GetWorkstationClusterRequest,
                          com.google.cloud.workstations.v1.WorkstationCluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetWorkstationCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.GetWorkstationClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.WorkstationCluster
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("GetWorkstationCluster"))
                      .build();
        }
      }
    }
    return getGetWorkstationClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.ListWorkstationClustersRequest,
          com.google.cloud.workstations.v1.ListWorkstationClustersResponse>
      getListWorkstationClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkstationClusters",
      requestType = com.google.cloud.workstations.v1.ListWorkstationClustersRequest.class,
      responseType = com.google.cloud.workstations.v1.ListWorkstationClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.ListWorkstationClustersRequest,
          com.google.cloud.workstations.v1.ListWorkstationClustersResponse>
      getListWorkstationClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.ListWorkstationClustersRequest,
            com.google.cloud.workstations.v1.ListWorkstationClustersResponse>
        getListWorkstationClustersMethod;
    if ((getListWorkstationClustersMethod = WorkstationsGrpc.getListWorkstationClustersMethod)
        == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getListWorkstationClustersMethod = WorkstationsGrpc.getListWorkstationClustersMethod)
            == null) {
          WorkstationsGrpc.getListWorkstationClustersMethod =
              getListWorkstationClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.ListWorkstationClustersRequest,
                          com.google.cloud.workstations.v1.ListWorkstationClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListWorkstationClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.ListWorkstationClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.ListWorkstationClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("ListWorkstationClusters"))
                      .build();
        }
      }
    }
    return getListWorkstationClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.CreateWorkstationClusterRequest,
          com.google.longrunning.Operation>
      getCreateWorkstationClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWorkstationCluster",
      requestType = com.google.cloud.workstations.v1.CreateWorkstationClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.CreateWorkstationClusterRequest,
          com.google.longrunning.Operation>
      getCreateWorkstationClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.CreateWorkstationClusterRequest,
            com.google.longrunning.Operation>
        getCreateWorkstationClusterMethod;
    if ((getCreateWorkstationClusterMethod = WorkstationsGrpc.getCreateWorkstationClusterMethod)
        == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getCreateWorkstationClusterMethod = WorkstationsGrpc.getCreateWorkstationClusterMethod)
            == null) {
          WorkstationsGrpc.getCreateWorkstationClusterMethod =
              getCreateWorkstationClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.CreateWorkstationClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateWorkstationCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.CreateWorkstationClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("CreateWorkstationCluster"))
                      .build();
        }
      }
    }
    return getCreateWorkstationClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.UpdateWorkstationClusterRequest,
          com.google.longrunning.Operation>
      getUpdateWorkstationClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWorkstationCluster",
      requestType = com.google.cloud.workstations.v1.UpdateWorkstationClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.UpdateWorkstationClusterRequest,
          com.google.longrunning.Operation>
      getUpdateWorkstationClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.UpdateWorkstationClusterRequest,
            com.google.longrunning.Operation>
        getUpdateWorkstationClusterMethod;
    if ((getUpdateWorkstationClusterMethod = WorkstationsGrpc.getUpdateWorkstationClusterMethod)
        == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getUpdateWorkstationClusterMethod = WorkstationsGrpc.getUpdateWorkstationClusterMethod)
            == null) {
          WorkstationsGrpc.getUpdateWorkstationClusterMethod =
              getUpdateWorkstationClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.UpdateWorkstationClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateWorkstationCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.UpdateWorkstationClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("UpdateWorkstationCluster"))
                      .build();
        }
      }
    }
    return getUpdateWorkstationClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.DeleteWorkstationClusterRequest,
          com.google.longrunning.Operation>
      getDeleteWorkstationClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWorkstationCluster",
      requestType = com.google.cloud.workstations.v1.DeleteWorkstationClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.DeleteWorkstationClusterRequest,
          com.google.longrunning.Operation>
      getDeleteWorkstationClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.DeleteWorkstationClusterRequest,
            com.google.longrunning.Operation>
        getDeleteWorkstationClusterMethod;
    if ((getDeleteWorkstationClusterMethod = WorkstationsGrpc.getDeleteWorkstationClusterMethod)
        == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getDeleteWorkstationClusterMethod = WorkstationsGrpc.getDeleteWorkstationClusterMethod)
            == null) {
          WorkstationsGrpc.getDeleteWorkstationClusterMethod =
              getDeleteWorkstationClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.DeleteWorkstationClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteWorkstationCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.DeleteWorkstationClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("DeleteWorkstationCluster"))
                      .build();
        }
      }
    }
    return getDeleteWorkstationClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.GetWorkstationConfigRequest,
          com.google.cloud.workstations.v1.WorkstationConfig>
      getGetWorkstationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkstationConfig",
      requestType = com.google.cloud.workstations.v1.GetWorkstationConfigRequest.class,
      responseType = com.google.cloud.workstations.v1.WorkstationConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.GetWorkstationConfigRequest,
          com.google.cloud.workstations.v1.WorkstationConfig>
      getGetWorkstationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.GetWorkstationConfigRequest,
            com.google.cloud.workstations.v1.WorkstationConfig>
        getGetWorkstationConfigMethod;
    if ((getGetWorkstationConfigMethod = WorkstationsGrpc.getGetWorkstationConfigMethod) == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getGetWorkstationConfigMethod = WorkstationsGrpc.getGetWorkstationConfigMethod)
            == null) {
          WorkstationsGrpc.getGetWorkstationConfigMethod =
              getGetWorkstationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.GetWorkstationConfigRequest,
                          com.google.cloud.workstations.v1.WorkstationConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetWorkstationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.GetWorkstationConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.WorkstationConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("GetWorkstationConfig"))
                      .build();
        }
      }
    }
    return getGetWorkstationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.ListWorkstationConfigsRequest,
          com.google.cloud.workstations.v1.ListWorkstationConfigsResponse>
      getListWorkstationConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkstationConfigs",
      requestType = com.google.cloud.workstations.v1.ListWorkstationConfigsRequest.class,
      responseType = com.google.cloud.workstations.v1.ListWorkstationConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.ListWorkstationConfigsRequest,
          com.google.cloud.workstations.v1.ListWorkstationConfigsResponse>
      getListWorkstationConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.ListWorkstationConfigsRequest,
            com.google.cloud.workstations.v1.ListWorkstationConfigsResponse>
        getListWorkstationConfigsMethod;
    if ((getListWorkstationConfigsMethod = WorkstationsGrpc.getListWorkstationConfigsMethod)
        == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getListWorkstationConfigsMethod = WorkstationsGrpc.getListWorkstationConfigsMethod)
            == null) {
          WorkstationsGrpc.getListWorkstationConfigsMethod =
              getListWorkstationConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.ListWorkstationConfigsRequest,
                          com.google.cloud.workstations.v1.ListWorkstationConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListWorkstationConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.ListWorkstationConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.ListWorkstationConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("ListWorkstationConfigs"))
                      .build();
        }
      }
    }
    return getListWorkstationConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.ListUsableWorkstationConfigsRequest,
          com.google.cloud.workstations.v1.ListUsableWorkstationConfigsResponse>
      getListUsableWorkstationConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUsableWorkstationConfigs",
      requestType = com.google.cloud.workstations.v1.ListUsableWorkstationConfigsRequest.class,
      responseType = com.google.cloud.workstations.v1.ListUsableWorkstationConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.ListUsableWorkstationConfigsRequest,
          com.google.cloud.workstations.v1.ListUsableWorkstationConfigsResponse>
      getListUsableWorkstationConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.ListUsableWorkstationConfigsRequest,
            com.google.cloud.workstations.v1.ListUsableWorkstationConfigsResponse>
        getListUsableWorkstationConfigsMethod;
    if ((getListUsableWorkstationConfigsMethod =
            WorkstationsGrpc.getListUsableWorkstationConfigsMethod)
        == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getListUsableWorkstationConfigsMethod =
                WorkstationsGrpc.getListUsableWorkstationConfigsMethod)
            == null) {
          WorkstationsGrpc.getListUsableWorkstationConfigsMethod =
              getListUsableWorkstationConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.ListUsableWorkstationConfigsRequest,
                          com.google.cloud.workstations.v1.ListUsableWorkstationConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListUsableWorkstationConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.ListUsableWorkstationConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.ListUsableWorkstationConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("ListUsableWorkstationConfigs"))
                      .build();
        }
      }
    }
    return getListUsableWorkstationConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.CreateWorkstationConfigRequest,
          com.google.longrunning.Operation>
      getCreateWorkstationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWorkstationConfig",
      requestType = com.google.cloud.workstations.v1.CreateWorkstationConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.CreateWorkstationConfigRequest,
          com.google.longrunning.Operation>
      getCreateWorkstationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.CreateWorkstationConfigRequest,
            com.google.longrunning.Operation>
        getCreateWorkstationConfigMethod;
    if ((getCreateWorkstationConfigMethod = WorkstationsGrpc.getCreateWorkstationConfigMethod)
        == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getCreateWorkstationConfigMethod = WorkstationsGrpc.getCreateWorkstationConfigMethod)
            == null) {
          WorkstationsGrpc.getCreateWorkstationConfigMethod =
              getCreateWorkstationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.CreateWorkstationConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateWorkstationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.CreateWorkstationConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("CreateWorkstationConfig"))
                      .build();
        }
      }
    }
    return getCreateWorkstationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.UpdateWorkstationConfigRequest,
          com.google.longrunning.Operation>
      getUpdateWorkstationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWorkstationConfig",
      requestType = com.google.cloud.workstations.v1.UpdateWorkstationConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.UpdateWorkstationConfigRequest,
          com.google.longrunning.Operation>
      getUpdateWorkstationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.UpdateWorkstationConfigRequest,
            com.google.longrunning.Operation>
        getUpdateWorkstationConfigMethod;
    if ((getUpdateWorkstationConfigMethod = WorkstationsGrpc.getUpdateWorkstationConfigMethod)
        == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getUpdateWorkstationConfigMethod = WorkstationsGrpc.getUpdateWorkstationConfigMethod)
            == null) {
          WorkstationsGrpc.getUpdateWorkstationConfigMethod =
              getUpdateWorkstationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.UpdateWorkstationConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateWorkstationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.UpdateWorkstationConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("UpdateWorkstationConfig"))
                      .build();
        }
      }
    }
    return getUpdateWorkstationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.DeleteWorkstationConfigRequest,
          com.google.longrunning.Operation>
      getDeleteWorkstationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWorkstationConfig",
      requestType = com.google.cloud.workstations.v1.DeleteWorkstationConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.DeleteWorkstationConfigRequest,
          com.google.longrunning.Operation>
      getDeleteWorkstationConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.DeleteWorkstationConfigRequest,
            com.google.longrunning.Operation>
        getDeleteWorkstationConfigMethod;
    if ((getDeleteWorkstationConfigMethod = WorkstationsGrpc.getDeleteWorkstationConfigMethod)
        == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getDeleteWorkstationConfigMethod = WorkstationsGrpc.getDeleteWorkstationConfigMethod)
            == null) {
          WorkstationsGrpc.getDeleteWorkstationConfigMethod =
              getDeleteWorkstationConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.DeleteWorkstationConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteWorkstationConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.DeleteWorkstationConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("DeleteWorkstationConfig"))
                      .build();
        }
      }
    }
    return getDeleteWorkstationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.GetWorkstationRequest,
          com.google.cloud.workstations.v1.Workstation>
      getGetWorkstationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkstation",
      requestType = com.google.cloud.workstations.v1.GetWorkstationRequest.class,
      responseType = com.google.cloud.workstations.v1.Workstation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.GetWorkstationRequest,
          com.google.cloud.workstations.v1.Workstation>
      getGetWorkstationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.GetWorkstationRequest,
            com.google.cloud.workstations.v1.Workstation>
        getGetWorkstationMethod;
    if ((getGetWorkstationMethod = WorkstationsGrpc.getGetWorkstationMethod) == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getGetWorkstationMethod = WorkstationsGrpc.getGetWorkstationMethod) == null) {
          WorkstationsGrpc.getGetWorkstationMethod =
              getGetWorkstationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.GetWorkstationRequest,
                          com.google.cloud.workstations.v1.Workstation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWorkstation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.GetWorkstationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.Workstation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("GetWorkstation"))
                      .build();
        }
      }
    }
    return getGetWorkstationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.ListWorkstationsRequest,
          com.google.cloud.workstations.v1.ListWorkstationsResponse>
      getListWorkstationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkstations",
      requestType = com.google.cloud.workstations.v1.ListWorkstationsRequest.class,
      responseType = com.google.cloud.workstations.v1.ListWorkstationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.ListWorkstationsRequest,
          com.google.cloud.workstations.v1.ListWorkstationsResponse>
      getListWorkstationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.ListWorkstationsRequest,
            com.google.cloud.workstations.v1.ListWorkstationsResponse>
        getListWorkstationsMethod;
    if ((getListWorkstationsMethod = WorkstationsGrpc.getListWorkstationsMethod) == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getListWorkstationsMethod = WorkstationsGrpc.getListWorkstationsMethod) == null) {
          WorkstationsGrpc.getListWorkstationsMethod =
              getListWorkstationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.ListWorkstationsRequest,
                          com.google.cloud.workstations.v1.ListWorkstationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWorkstations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.ListWorkstationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.ListWorkstationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("ListWorkstations"))
                      .build();
        }
      }
    }
    return getListWorkstationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.ListUsableWorkstationsRequest,
          com.google.cloud.workstations.v1.ListUsableWorkstationsResponse>
      getListUsableWorkstationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUsableWorkstations",
      requestType = com.google.cloud.workstations.v1.ListUsableWorkstationsRequest.class,
      responseType = com.google.cloud.workstations.v1.ListUsableWorkstationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.ListUsableWorkstationsRequest,
          com.google.cloud.workstations.v1.ListUsableWorkstationsResponse>
      getListUsableWorkstationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.ListUsableWorkstationsRequest,
            com.google.cloud.workstations.v1.ListUsableWorkstationsResponse>
        getListUsableWorkstationsMethod;
    if ((getListUsableWorkstationsMethod = WorkstationsGrpc.getListUsableWorkstationsMethod)
        == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getListUsableWorkstationsMethod = WorkstationsGrpc.getListUsableWorkstationsMethod)
            == null) {
          WorkstationsGrpc.getListUsableWorkstationsMethod =
              getListUsableWorkstationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.ListUsableWorkstationsRequest,
                          com.google.cloud.workstations.v1.ListUsableWorkstationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListUsableWorkstations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.ListUsableWorkstationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.ListUsableWorkstationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("ListUsableWorkstations"))
                      .build();
        }
      }
    }
    return getListUsableWorkstationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.CreateWorkstationRequest,
          com.google.longrunning.Operation>
      getCreateWorkstationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWorkstation",
      requestType = com.google.cloud.workstations.v1.CreateWorkstationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.CreateWorkstationRequest,
          com.google.longrunning.Operation>
      getCreateWorkstationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.CreateWorkstationRequest,
            com.google.longrunning.Operation>
        getCreateWorkstationMethod;
    if ((getCreateWorkstationMethod = WorkstationsGrpc.getCreateWorkstationMethod) == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getCreateWorkstationMethod = WorkstationsGrpc.getCreateWorkstationMethod) == null) {
          WorkstationsGrpc.getCreateWorkstationMethod =
              getCreateWorkstationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.CreateWorkstationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateWorkstation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.CreateWorkstationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("CreateWorkstation"))
                      .build();
        }
      }
    }
    return getCreateWorkstationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.UpdateWorkstationRequest,
          com.google.longrunning.Operation>
      getUpdateWorkstationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWorkstation",
      requestType = com.google.cloud.workstations.v1.UpdateWorkstationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.UpdateWorkstationRequest,
          com.google.longrunning.Operation>
      getUpdateWorkstationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.UpdateWorkstationRequest,
            com.google.longrunning.Operation>
        getUpdateWorkstationMethod;
    if ((getUpdateWorkstationMethod = WorkstationsGrpc.getUpdateWorkstationMethod) == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getUpdateWorkstationMethod = WorkstationsGrpc.getUpdateWorkstationMethod) == null) {
          WorkstationsGrpc.getUpdateWorkstationMethod =
              getUpdateWorkstationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.UpdateWorkstationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateWorkstation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.UpdateWorkstationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("UpdateWorkstation"))
                      .build();
        }
      }
    }
    return getUpdateWorkstationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.DeleteWorkstationRequest,
          com.google.longrunning.Operation>
      getDeleteWorkstationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWorkstation",
      requestType = com.google.cloud.workstations.v1.DeleteWorkstationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.DeleteWorkstationRequest,
          com.google.longrunning.Operation>
      getDeleteWorkstationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.DeleteWorkstationRequest,
            com.google.longrunning.Operation>
        getDeleteWorkstationMethod;
    if ((getDeleteWorkstationMethod = WorkstationsGrpc.getDeleteWorkstationMethod) == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getDeleteWorkstationMethod = WorkstationsGrpc.getDeleteWorkstationMethod) == null) {
          WorkstationsGrpc.getDeleteWorkstationMethod =
              getDeleteWorkstationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.DeleteWorkstationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteWorkstation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.DeleteWorkstationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("DeleteWorkstation"))
                      .build();
        }
      }
    }
    return getDeleteWorkstationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.StartWorkstationRequest,
          com.google.longrunning.Operation>
      getStartWorkstationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartWorkstation",
      requestType = com.google.cloud.workstations.v1.StartWorkstationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.StartWorkstationRequest,
          com.google.longrunning.Operation>
      getStartWorkstationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.StartWorkstationRequest,
            com.google.longrunning.Operation>
        getStartWorkstationMethod;
    if ((getStartWorkstationMethod = WorkstationsGrpc.getStartWorkstationMethod) == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getStartWorkstationMethod = WorkstationsGrpc.getStartWorkstationMethod) == null) {
          WorkstationsGrpc.getStartWorkstationMethod =
              getStartWorkstationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.StartWorkstationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartWorkstation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.StartWorkstationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("StartWorkstation"))
                      .build();
        }
      }
    }
    return getStartWorkstationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.StopWorkstationRequest, com.google.longrunning.Operation>
      getStopWorkstationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopWorkstation",
      requestType = com.google.cloud.workstations.v1.StopWorkstationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.StopWorkstationRequest, com.google.longrunning.Operation>
      getStopWorkstationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.StopWorkstationRequest,
            com.google.longrunning.Operation>
        getStopWorkstationMethod;
    if ((getStopWorkstationMethod = WorkstationsGrpc.getStopWorkstationMethod) == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getStopWorkstationMethod = WorkstationsGrpc.getStopWorkstationMethod) == null) {
          WorkstationsGrpc.getStopWorkstationMethod =
              getStopWorkstationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.StopWorkstationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopWorkstation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.StopWorkstationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("StopWorkstation"))
                      .build();
        }
      }
    }
    return getStopWorkstationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.GenerateAccessTokenRequest,
          com.google.cloud.workstations.v1.GenerateAccessTokenResponse>
      getGenerateAccessTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAccessToken",
      requestType = com.google.cloud.workstations.v1.GenerateAccessTokenRequest.class,
      responseType = com.google.cloud.workstations.v1.GenerateAccessTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workstations.v1.GenerateAccessTokenRequest,
          com.google.cloud.workstations.v1.GenerateAccessTokenResponse>
      getGenerateAccessTokenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workstations.v1.GenerateAccessTokenRequest,
            com.google.cloud.workstations.v1.GenerateAccessTokenResponse>
        getGenerateAccessTokenMethod;
    if ((getGenerateAccessTokenMethod = WorkstationsGrpc.getGenerateAccessTokenMethod) == null) {
      synchronized (WorkstationsGrpc.class) {
        if ((getGenerateAccessTokenMethod = WorkstationsGrpc.getGenerateAccessTokenMethod)
            == null) {
          WorkstationsGrpc.getGenerateAccessTokenMethod =
              getGenerateAccessTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workstations.v1.GenerateAccessTokenRequest,
                          com.google.cloud.workstations.v1.GenerateAccessTokenResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateAccessToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.GenerateAccessTokenRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workstations.v1.GenerateAccessTokenResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkstationsMethodDescriptorSupplier("GenerateAccessToken"))
                      .build();
        }
      }
    }
    return getGenerateAccessTokenMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static WorkstationsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkstationsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkstationsStub>() {
          @java.lang.Override
          public WorkstationsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkstationsStub(channel, callOptions);
          }
        };
    return WorkstationsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkstationsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkstationsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkstationsBlockingStub>() {
          @java.lang.Override
          public WorkstationsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkstationsBlockingStub(channel, callOptions);
          }
        };
    return WorkstationsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WorkstationsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkstationsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkstationsFutureStub>() {
          @java.lang.Override
          public WorkstationsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkstationsFutureStub(channel, callOptions);
          }
        };
    return WorkstationsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for interacting with Cloud Workstations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns the requested workstation cluster.
     * </pre>
     */
    default void getWorkstationCluster(
        com.google.cloud.workstations.v1.GetWorkstationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.WorkstationCluster>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetWorkstationClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstation clusters in the specified location.
     * </pre>
     */
    default void listWorkstationClusters(
        com.google.cloud.workstations.v1.ListWorkstationClustersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.workstations.v1.ListWorkstationClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListWorkstationClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workstation cluster.
     * </pre>
     */
    default void createWorkstationCluster(
        com.google.cloud.workstations.v1.CreateWorkstationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateWorkstationClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workstation cluster.
     * </pre>
     */
    default void updateWorkstationCluster(
        com.google.cloud.workstations.v1.UpdateWorkstationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateWorkstationClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified workstation cluster.
     * </pre>
     */
    default void deleteWorkstationCluster(
        com.google.cloud.workstations.v1.DeleteWorkstationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteWorkstationClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested workstation configuration.
     * </pre>
     */
    default void getWorkstationConfig(
        com.google.cloud.workstations.v1.GetWorkstationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.WorkstationConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetWorkstationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstation configurations in the specified cluster.
     * </pre>
     */
    default void listWorkstationConfigs(
        com.google.cloud.workstations.v1.ListWorkstationConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.ListWorkstationConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListWorkstationConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstation configurations in the specified cluster on which
     * the caller has the "workstations.workstation.create" permission.
     * </pre>
     */
    default void listUsableWorkstationConfigs(
        com.google.cloud.workstations.v1.ListUsableWorkstationConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.workstations.v1.ListUsableWorkstationConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUsableWorkstationConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workstation configuration.
     * </pre>
     */
    default void createWorkstationConfig(
        com.google.cloud.workstations.v1.CreateWorkstationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateWorkstationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workstation configuration.
     * </pre>
     */
    default void updateWorkstationConfig(
        com.google.cloud.workstations.v1.UpdateWorkstationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateWorkstationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified workstation configuration.
     * </pre>
     */
    default void deleteWorkstationConfig(
        com.google.cloud.workstations.v1.DeleteWorkstationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteWorkstationConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested workstation.
     * </pre>
     */
    default void getWorkstation(
        com.google.cloud.workstations.v1.GetWorkstationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.Workstation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetWorkstationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all Workstations using the specified workstation configuration.
     * </pre>
     */
    default void listWorkstations(
        com.google.cloud.workstations.v1.ListWorkstationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.ListWorkstationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListWorkstationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstations using the specified workstation configuration
     * on which the caller has the "workstations.workstations.use" permission.
     * </pre>
     */
    default void listUsableWorkstations(
        com.google.cloud.workstations.v1.ListUsableWorkstationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.ListUsableWorkstationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUsableWorkstationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workstation.
     * </pre>
     */
    default void createWorkstation(
        com.google.cloud.workstations.v1.CreateWorkstationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateWorkstationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workstation.
     * </pre>
     */
    default void updateWorkstation(
        com.google.cloud.workstations.v1.UpdateWorkstationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateWorkstationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified workstation.
     * </pre>
     */
    default void deleteWorkstation(
        com.google.cloud.workstations.v1.DeleteWorkstationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteWorkstationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts running a workstation so that users can connect to it.
     * </pre>
     */
    default void startWorkstation(
        com.google.cloud.workstations.v1.StartWorkstationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartWorkstationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops running a workstation, reducing costs.
     * </pre>
     */
    default void stopWorkstation(
        com.google.cloud.workstations.v1.StopWorkstationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStopWorkstationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a short-lived credential that can be used to send authenticated and
     * authorized traffic to a workstation.
     * </pre>
     */
    default void generateAccessToken(
        com.google.cloud.workstations.v1.GenerateAccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.GenerateAccessTokenResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateAccessTokenMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Workstations.
   *
   * <pre>
   * Service for interacting with Cloud Workstations.
   * </pre>
   */
  public abstract static class WorkstationsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return WorkstationsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Workstations.
   *
   * <pre>
   * Service for interacting with Cloud Workstations.
   * </pre>
   */
  public static final class WorkstationsStub
      extends io.grpc.stub.AbstractAsyncStub<WorkstationsStub> {
    private WorkstationsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkstationsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkstationsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested workstation cluster.
     * </pre>
     */
    public void getWorkstationCluster(
        com.google.cloud.workstations.v1.GetWorkstationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.WorkstationCluster>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkstationClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstation clusters in the specified location.
     * </pre>
     */
    public void listWorkstationClusters(
        com.google.cloud.workstations.v1.ListWorkstationClustersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.workstations.v1.ListWorkstationClustersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkstationClustersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workstation cluster.
     * </pre>
     */
    public void createWorkstationCluster(
        com.google.cloud.workstations.v1.CreateWorkstationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkstationClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workstation cluster.
     * </pre>
     */
    public void updateWorkstationCluster(
        com.google.cloud.workstations.v1.UpdateWorkstationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWorkstationClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified workstation cluster.
     * </pre>
     */
    public void deleteWorkstationCluster(
        com.google.cloud.workstations.v1.DeleteWorkstationClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWorkstationClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested workstation configuration.
     * </pre>
     */
    public void getWorkstationConfig(
        com.google.cloud.workstations.v1.GetWorkstationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.WorkstationConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkstationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstation configurations in the specified cluster.
     * </pre>
     */
    public void listWorkstationConfigs(
        com.google.cloud.workstations.v1.ListWorkstationConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.ListWorkstationConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkstationConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstation configurations in the specified cluster on which
     * the caller has the "workstations.workstation.create" permission.
     * </pre>
     */
    public void listUsableWorkstationConfigs(
        com.google.cloud.workstations.v1.ListUsableWorkstationConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.workstations.v1.ListUsableWorkstationConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUsableWorkstationConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workstation configuration.
     * </pre>
     */
    public void createWorkstationConfig(
        com.google.cloud.workstations.v1.CreateWorkstationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkstationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workstation configuration.
     * </pre>
     */
    public void updateWorkstationConfig(
        com.google.cloud.workstations.v1.UpdateWorkstationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWorkstationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified workstation configuration.
     * </pre>
     */
    public void deleteWorkstationConfig(
        com.google.cloud.workstations.v1.DeleteWorkstationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWorkstationConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested workstation.
     * </pre>
     */
    public void getWorkstation(
        com.google.cloud.workstations.v1.GetWorkstationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.Workstation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkstationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all Workstations using the specified workstation configuration.
     * </pre>
     */
    public void listWorkstations(
        com.google.cloud.workstations.v1.ListWorkstationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.ListWorkstationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkstationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstations using the specified workstation configuration
     * on which the caller has the "workstations.workstations.use" permission.
     * </pre>
     */
    public void listUsableWorkstations(
        com.google.cloud.workstations.v1.ListUsableWorkstationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.ListUsableWorkstationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUsableWorkstationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workstation.
     * </pre>
     */
    public void createWorkstation(
        com.google.cloud.workstations.v1.CreateWorkstationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkstationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workstation.
     * </pre>
     */
    public void updateWorkstation(
        com.google.cloud.workstations.v1.UpdateWorkstationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWorkstationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified workstation.
     * </pre>
     */
    public void deleteWorkstation(
        com.google.cloud.workstations.v1.DeleteWorkstationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWorkstationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts running a workstation so that users can connect to it.
     * </pre>
     */
    public void startWorkstation(
        com.google.cloud.workstations.v1.StartWorkstationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartWorkstationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops running a workstation, reducing costs.
     * </pre>
     */
    public void stopWorkstation(
        com.google.cloud.workstations.v1.StopWorkstationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopWorkstationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a short-lived credential that can be used to send authenticated and
     * authorized traffic to a workstation.
     * </pre>
     */
    public void generateAccessToken(
        com.google.cloud.workstations.v1.GenerateAccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.GenerateAccessTokenResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateAccessTokenMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Workstations.
   *
   * <pre>
   * Service for interacting with Cloud Workstations.
   * </pre>
   */
  public static final class WorkstationsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WorkstationsBlockingStub> {
    private WorkstationsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkstationsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkstationsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested workstation cluster.
     * </pre>
     */
    public com.google.cloud.workstations.v1.WorkstationCluster getWorkstationCluster(
        com.google.cloud.workstations.v1.GetWorkstationClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkstationClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstation clusters in the specified location.
     * </pre>
     */
    public com.google.cloud.workstations.v1.ListWorkstationClustersResponse listWorkstationClusters(
        com.google.cloud.workstations.v1.ListWorkstationClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkstationClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workstation cluster.
     * </pre>
     */
    public com.google.longrunning.Operation createWorkstationCluster(
        com.google.cloud.workstations.v1.CreateWorkstationClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkstationClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workstation cluster.
     * </pre>
     */
    public com.google.longrunning.Operation updateWorkstationCluster(
        com.google.cloud.workstations.v1.UpdateWorkstationClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWorkstationClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified workstation cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteWorkstationCluster(
        com.google.cloud.workstations.v1.DeleteWorkstationClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWorkstationClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested workstation configuration.
     * </pre>
     */
    public com.google.cloud.workstations.v1.WorkstationConfig getWorkstationConfig(
        com.google.cloud.workstations.v1.GetWorkstationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkstationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstation configurations in the specified cluster.
     * </pre>
     */
    public com.google.cloud.workstations.v1.ListWorkstationConfigsResponse listWorkstationConfigs(
        com.google.cloud.workstations.v1.ListWorkstationConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkstationConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstation configurations in the specified cluster on which
     * the caller has the "workstations.workstation.create" permission.
     * </pre>
     */
    public com.google.cloud.workstations.v1.ListUsableWorkstationConfigsResponse
        listUsableWorkstationConfigs(
            com.google.cloud.workstations.v1.ListUsableWorkstationConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUsableWorkstationConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workstation configuration.
     * </pre>
     */
    public com.google.longrunning.Operation createWorkstationConfig(
        com.google.cloud.workstations.v1.CreateWorkstationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkstationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workstation configuration.
     * </pre>
     */
    public com.google.longrunning.Operation updateWorkstationConfig(
        com.google.cloud.workstations.v1.UpdateWorkstationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWorkstationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified workstation configuration.
     * </pre>
     */
    public com.google.longrunning.Operation deleteWorkstationConfig(
        com.google.cloud.workstations.v1.DeleteWorkstationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWorkstationConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested workstation.
     * </pre>
     */
    public com.google.cloud.workstations.v1.Workstation getWorkstation(
        com.google.cloud.workstations.v1.GetWorkstationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkstationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all Workstations using the specified workstation configuration.
     * </pre>
     */
    public com.google.cloud.workstations.v1.ListWorkstationsResponse listWorkstations(
        com.google.cloud.workstations.v1.ListWorkstationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkstationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstations using the specified workstation configuration
     * on which the caller has the "workstations.workstations.use" permission.
     * </pre>
     */
    public com.google.cloud.workstations.v1.ListUsableWorkstationsResponse listUsableWorkstations(
        com.google.cloud.workstations.v1.ListUsableWorkstationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUsableWorkstationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workstation.
     * </pre>
     */
    public com.google.longrunning.Operation createWorkstation(
        com.google.cloud.workstations.v1.CreateWorkstationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkstationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workstation.
     * </pre>
     */
    public com.google.longrunning.Operation updateWorkstation(
        com.google.cloud.workstations.v1.UpdateWorkstationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWorkstationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified workstation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteWorkstation(
        com.google.cloud.workstations.v1.DeleteWorkstationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWorkstationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts running a workstation so that users can connect to it.
     * </pre>
     */
    public com.google.longrunning.Operation startWorkstation(
        com.google.cloud.workstations.v1.StartWorkstationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartWorkstationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops running a workstation, reducing costs.
     * </pre>
     */
    public com.google.longrunning.Operation stopWorkstation(
        com.google.cloud.workstations.v1.StopWorkstationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopWorkstationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a short-lived credential that can be used to send authenticated and
     * authorized traffic to a workstation.
     * </pre>
     */
    public com.google.cloud.workstations.v1.GenerateAccessTokenResponse generateAccessToken(
        com.google.cloud.workstations.v1.GenerateAccessTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateAccessTokenMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Workstations.
   *
   * <pre>
   * Service for interacting with Cloud Workstations.
   * </pre>
   */
  public static final class WorkstationsFutureStub
      extends io.grpc.stub.AbstractFutureStub<WorkstationsFutureStub> {
    private WorkstationsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkstationsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkstationsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested workstation cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workstations.v1.WorkstationCluster>
        getWorkstationCluster(
            com.google.cloud.workstations.v1.GetWorkstationClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkstationClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstation clusters in the specified location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workstations.v1.ListWorkstationClustersResponse>
        listWorkstationClusters(
            com.google.cloud.workstations.v1.ListWorkstationClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkstationClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workstation cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createWorkstationCluster(
            com.google.cloud.workstations.v1.CreateWorkstationClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkstationClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workstation cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateWorkstationCluster(
            com.google.cloud.workstations.v1.UpdateWorkstationClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWorkstationClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified workstation cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteWorkstationCluster(
            com.google.cloud.workstations.v1.DeleteWorkstationClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWorkstationClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested workstation configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workstations.v1.WorkstationConfig>
        getWorkstationConfig(com.google.cloud.workstations.v1.GetWorkstationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkstationConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstation configurations in the specified cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workstations.v1.ListWorkstationConfigsResponse>
        listWorkstationConfigs(
            com.google.cloud.workstations.v1.ListWorkstationConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkstationConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstation configurations in the specified cluster on which
     * the caller has the "workstations.workstation.create" permission.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workstations.v1.ListUsableWorkstationConfigsResponse>
        listUsableWorkstationConfigs(
            com.google.cloud.workstations.v1.ListUsableWorkstationConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUsableWorkstationConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workstation configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createWorkstationConfig(
            com.google.cloud.workstations.v1.CreateWorkstationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkstationConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workstation configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateWorkstationConfig(
            com.google.cloud.workstations.v1.UpdateWorkstationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWorkstationConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified workstation configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteWorkstationConfig(
            com.google.cloud.workstations.v1.DeleteWorkstationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWorkstationConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested workstation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workstations.v1.Workstation>
        getWorkstation(com.google.cloud.workstations.v1.GetWorkstationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkstationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all Workstations using the specified workstation configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workstations.v1.ListWorkstationsResponse>
        listWorkstations(com.google.cloud.workstations.v1.ListWorkstationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkstationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all workstations using the specified workstation configuration
     * on which the caller has the "workstations.workstations.use" permission.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workstations.v1.ListUsableWorkstationsResponse>
        listUsableWorkstations(
            com.google.cloud.workstations.v1.ListUsableWorkstationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUsableWorkstationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workstation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createWorkstation(com.google.cloud.workstations.v1.CreateWorkstationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkstationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workstation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateWorkstation(com.google.cloud.workstations.v1.UpdateWorkstationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWorkstationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified workstation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteWorkstation(com.google.cloud.workstations.v1.DeleteWorkstationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWorkstationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts running a workstation so that users can connect to it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        startWorkstation(com.google.cloud.workstations.v1.StartWorkstationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartWorkstationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stops running a workstation, reducing costs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        stopWorkstation(com.google.cloud.workstations.v1.StopWorkstationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopWorkstationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a short-lived credential that can be used to send authenticated and
     * authorized traffic to a workstation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workstations.v1.GenerateAccessTokenResponse>
        generateAccessToken(com.google.cloud.workstations.v1.GenerateAccessTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateAccessTokenMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_WORKSTATION_CLUSTER = 0;
  private static final int METHODID_LIST_WORKSTATION_CLUSTERS = 1;
  private static final int METHODID_CREATE_WORKSTATION_CLUSTER = 2;
  private static final int METHODID_UPDATE_WORKSTATION_CLUSTER = 3;
  private static final int METHODID_DELETE_WORKSTATION_CLUSTER = 4;
  private static final int METHODID_GET_WORKSTATION_CONFIG = 5;
  private static final int METHODID_LIST_WORKSTATION_CONFIGS = 6;
  private static final int METHODID_LIST_USABLE_WORKSTATION_CONFIGS = 7;
  private static final int METHODID_CREATE_WORKSTATION_CONFIG = 8;
  private static final int METHODID_UPDATE_WORKSTATION_CONFIG = 9;
  private static final int METHODID_DELETE_WORKSTATION_CONFIG = 10;
  private static final int METHODID_GET_WORKSTATION = 11;
  private static final int METHODID_LIST_WORKSTATIONS = 12;
  private static final int METHODID_LIST_USABLE_WORKSTATIONS = 13;
  private static final int METHODID_CREATE_WORKSTATION = 14;
  private static final int METHODID_UPDATE_WORKSTATION = 15;
  private static final int METHODID_DELETE_WORKSTATION = 16;
  private static final int METHODID_START_WORKSTATION = 17;
  private static final int METHODID_STOP_WORKSTATION = 18;
  private static final int METHODID_GENERATE_ACCESS_TOKEN = 19;

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
        case METHODID_GET_WORKSTATION_CLUSTER:
          serviceImpl.getWorkstationCluster(
              (com.google.cloud.workstations.v1.GetWorkstationClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.WorkstationCluster>)
                  responseObserver);
          break;
        case METHODID_LIST_WORKSTATION_CLUSTERS:
          serviceImpl.listWorkstationClusters(
              (com.google.cloud.workstations.v1.ListWorkstationClustersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.workstations.v1.ListWorkstationClustersResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_WORKSTATION_CLUSTER:
          serviceImpl.createWorkstationCluster(
              (com.google.cloud.workstations.v1.CreateWorkstationClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_WORKSTATION_CLUSTER:
          serviceImpl.updateWorkstationCluster(
              (com.google.cloud.workstations.v1.UpdateWorkstationClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_WORKSTATION_CLUSTER:
          serviceImpl.deleteWorkstationCluster(
              (com.google.cloud.workstations.v1.DeleteWorkstationClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_WORKSTATION_CONFIG:
          serviceImpl.getWorkstationConfig(
              (com.google.cloud.workstations.v1.GetWorkstationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.WorkstationConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_WORKSTATION_CONFIGS:
          serviceImpl.listWorkstationConfigs(
              (com.google.cloud.workstations.v1.ListWorkstationConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.workstations.v1.ListWorkstationConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_USABLE_WORKSTATION_CONFIGS:
          serviceImpl.listUsableWorkstationConfigs(
              (com.google.cloud.workstations.v1.ListUsableWorkstationConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.workstations.v1.ListUsableWorkstationConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_WORKSTATION_CONFIG:
          serviceImpl.createWorkstationConfig(
              (com.google.cloud.workstations.v1.CreateWorkstationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_WORKSTATION_CONFIG:
          serviceImpl.updateWorkstationConfig(
              (com.google.cloud.workstations.v1.UpdateWorkstationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_WORKSTATION_CONFIG:
          serviceImpl.deleteWorkstationConfig(
              (com.google.cloud.workstations.v1.DeleteWorkstationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_WORKSTATION:
          serviceImpl.getWorkstation(
              (com.google.cloud.workstations.v1.GetWorkstationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.workstations.v1.Workstation>)
                  responseObserver);
          break;
        case METHODID_LIST_WORKSTATIONS:
          serviceImpl.listWorkstations(
              (com.google.cloud.workstations.v1.ListWorkstationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.workstations.v1.ListWorkstationsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_USABLE_WORKSTATIONS:
          serviceImpl.listUsableWorkstations(
              (com.google.cloud.workstations.v1.ListUsableWorkstationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.workstations.v1.ListUsableWorkstationsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_WORKSTATION:
          serviceImpl.createWorkstation(
              (com.google.cloud.workstations.v1.CreateWorkstationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_WORKSTATION:
          serviceImpl.updateWorkstation(
              (com.google.cloud.workstations.v1.UpdateWorkstationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_WORKSTATION:
          serviceImpl.deleteWorkstation(
              (com.google.cloud.workstations.v1.DeleteWorkstationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_WORKSTATION:
          serviceImpl.startWorkstation(
              (com.google.cloud.workstations.v1.StartWorkstationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_STOP_WORKSTATION:
          serviceImpl.stopWorkstation(
              (com.google.cloud.workstations.v1.StopWorkstationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_ACCESS_TOKEN:
          serviceImpl.generateAccessToken(
              (com.google.cloud.workstations.v1.GenerateAccessTokenRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.workstations.v1.GenerateAccessTokenResponse>)
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
            getGetWorkstationClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.GetWorkstationClusterRequest,
                    com.google.cloud.workstations.v1.WorkstationCluster>(
                    service, METHODID_GET_WORKSTATION_CLUSTER)))
        .addMethod(
            getListWorkstationClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.ListWorkstationClustersRequest,
                    com.google.cloud.workstations.v1.ListWorkstationClustersResponse>(
                    service, METHODID_LIST_WORKSTATION_CLUSTERS)))
        .addMethod(
            getCreateWorkstationClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.CreateWorkstationClusterRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_WORKSTATION_CLUSTER)))
        .addMethod(
            getUpdateWorkstationClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.UpdateWorkstationClusterRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_WORKSTATION_CLUSTER)))
        .addMethod(
            getDeleteWorkstationClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.DeleteWorkstationClusterRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_WORKSTATION_CLUSTER)))
        .addMethod(
            getGetWorkstationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.GetWorkstationConfigRequest,
                    com.google.cloud.workstations.v1.WorkstationConfig>(
                    service, METHODID_GET_WORKSTATION_CONFIG)))
        .addMethod(
            getListWorkstationConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.ListWorkstationConfigsRequest,
                    com.google.cloud.workstations.v1.ListWorkstationConfigsResponse>(
                    service, METHODID_LIST_WORKSTATION_CONFIGS)))
        .addMethod(
            getListUsableWorkstationConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.ListUsableWorkstationConfigsRequest,
                    com.google.cloud.workstations.v1.ListUsableWorkstationConfigsResponse>(
                    service, METHODID_LIST_USABLE_WORKSTATION_CONFIGS)))
        .addMethod(
            getCreateWorkstationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.CreateWorkstationConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_WORKSTATION_CONFIG)))
        .addMethod(
            getUpdateWorkstationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.UpdateWorkstationConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_WORKSTATION_CONFIG)))
        .addMethod(
            getDeleteWorkstationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.DeleteWorkstationConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_WORKSTATION_CONFIG)))
        .addMethod(
            getGetWorkstationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.GetWorkstationRequest,
                    com.google.cloud.workstations.v1.Workstation>(
                    service, METHODID_GET_WORKSTATION)))
        .addMethod(
            getListWorkstationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.ListWorkstationsRequest,
                    com.google.cloud.workstations.v1.ListWorkstationsResponse>(
                    service, METHODID_LIST_WORKSTATIONS)))
        .addMethod(
            getListUsableWorkstationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.ListUsableWorkstationsRequest,
                    com.google.cloud.workstations.v1.ListUsableWorkstationsResponse>(
                    service, METHODID_LIST_USABLE_WORKSTATIONS)))
        .addMethod(
            getCreateWorkstationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.CreateWorkstationRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_WORKSTATION)))
        .addMethod(
            getUpdateWorkstationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.UpdateWorkstationRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_WORKSTATION)))
        .addMethod(
            getDeleteWorkstationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.DeleteWorkstationRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_WORKSTATION)))
        .addMethod(
            getStartWorkstationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.StartWorkstationRequest,
                    com.google.longrunning.Operation>(service, METHODID_START_WORKSTATION)))
        .addMethod(
            getStopWorkstationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.StopWorkstationRequest,
                    com.google.longrunning.Operation>(service, METHODID_STOP_WORKSTATION)))
        .addMethod(
            getGenerateAccessTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.workstations.v1.GenerateAccessTokenRequest,
                    com.google.cloud.workstations.v1.GenerateAccessTokenResponse>(
                    service, METHODID_GENERATE_ACCESS_TOKEN)))
        .build();
  }

  private abstract static class WorkstationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkstationsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.workstations.v1.WorkstationsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Workstations");
    }
  }

  private static final class WorkstationsFileDescriptorSupplier
      extends WorkstationsBaseDescriptorSupplier {
    WorkstationsFileDescriptorSupplier() {}
  }

  private static final class WorkstationsMethodDescriptorSupplier
      extends WorkstationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WorkstationsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WorkstationsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new WorkstationsFileDescriptorSupplier())
                      .addMethod(getGetWorkstationClusterMethod())
                      .addMethod(getListWorkstationClustersMethod())
                      .addMethod(getCreateWorkstationClusterMethod())
                      .addMethod(getUpdateWorkstationClusterMethod())
                      .addMethod(getDeleteWorkstationClusterMethod())
                      .addMethod(getGetWorkstationConfigMethod())
                      .addMethod(getListWorkstationConfigsMethod())
                      .addMethod(getListUsableWorkstationConfigsMethod())
                      .addMethod(getCreateWorkstationConfigMethod())
                      .addMethod(getUpdateWorkstationConfigMethod())
                      .addMethod(getDeleteWorkstationConfigMethod())
                      .addMethod(getGetWorkstationMethod())
                      .addMethod(getListWorkstationsMethod())
                      .addMethod(getListUsableWorkstationsMethod())
                      .addMethod(getCreateWorkstationMethod())
                      .addMethod(getUpdateWorkstationMethod())
                      .addMethod(getDeleteWorkstationMethod())
                      .addMethod(getStartWorkstationMethod())
                      .addMethod(getStopWorkstationMethod())
                      .addMethod(getGenerateAccessTokenMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
