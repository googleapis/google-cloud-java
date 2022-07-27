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
package com.google.container.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Google Kubernetes Engine Cluster Manager v1
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/container/v1/cluster_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ClusterManagerGrpc {

  private ClusterManagerGrpc() {}

  public static final String SERVICE_NAME = "google.container.v1.ClusterManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.ListClustersRequest, com.google.container.v1.ListClustersResponse>
      getListClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClusters",
      requestType = com.google.container.v1.ListClustersRequest.class,
      responseType = com.google.container.v1.ListClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.ListClustersRequest, com.google.container.v1.ListClustersResponse>
      getListClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.ListClustersRequest,
            com.google.container.v1.ListClustersResponse>
        getListClustersMethod;
    if ((getListClustersMethod = ClusterManagerGrpc.getListClustersMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getListClustersMethod = ClusterManagerGrpc.getListClustersMethod) == null) {
          ClusterManagerGrpc.getListClustersMethod =
              getListClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.ListClustersRequest,
                          com.google.container.v1.ListClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.ListClustersRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.ListClustersResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("ListClusters"))
                      .build();
        }
      }
    }
    return getListClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.GetClusterRequest, com.google.container.v1.Cluster>
      getGetClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCluster",
      requestType = com.google.container.v1.GetClusterRequest.class,
      responseType = com.google.container.v1.Cluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.GetClusterRequest, com.google.container.v1.Cluster>
      getGetClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.GetClusterRequest, com.google.container.v1.Cluster>
        getGetClusterMethod;
    if ((getGetClusterMethod = ClusterManagerGrpc.getGetClusterMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getGetClusterMethod = ClusterManagerGrpc.getGetClusterMethod) == null) {
          ClusterManagerGrpc.getGetClusterMethod =
              getGetClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.GetClusterRequest, com.google.container.v1.Cluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.GetClusterRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Cluster.getDefaultInstance()))
                      .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("GetCluster"))
                      .build();
        }
      }
    }
    return getGetClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.CreateClusterRequest, com.google.container.v1.Operation>
      getCreateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCluster",
      requestType = com.google.container.v1.CreateClusterRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.CreateClusterRequest, com.google.container.v1.Operation>
      getCreateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.CreateClusterRequest, com.google.container.v1.Operation>
        getCreateClusterMethod;
    if ((getCreateClusterMethod = ClusterManagerGrpc.getCreateClusterMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getCreateClusterMethod = ClusterManagerGrpc.getCreateClusterMethod) == null) {
          ClusterManagerGrpc.getCreateClusterMethod =
              getCreateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.CreateClusterRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.CreateClusterRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("CreateCluster"))
                      .build();
        }
      }
    }
    return getCreateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.UpdateClusterRequest, com.google.container.v1.Operation>
      getUpdateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCluster",
      requestType = com.google.container.v1.UpdateClusterRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.UpdateClusterRequest, com.google.container.v1.Operation>
      getUpdateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.UpdateClusterRequest, com.google.container.v1.Operation>
        getUpdateClusterMethod;
    if ((getUpdateClusterMethod = ClusterManagerGrpc.getUpdateClusterMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getUpdateClusterMethod = ClusterManagerGrpc.getUpdateClusterMethod) == null) {
          ClusterManagerGrpc.getUpdateClusterMethod =
              getUpdateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.UpdateClusterRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.UpdateClusterRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("UpdateCluster"))
                      .build();
        }
      }
    }
    return getUpdateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.UpdateNodePoolRequest, com.google.container.v1.Operation>
      getUpdateNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNodePool",
      requestType = com.google.container.v1.UpdateNodePoolRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.UpdateNodePoolRequest, com.google.container.v1.Operation>
      getUpdateNodePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.UpdateNodePoolRequest, com.google.container.v1.Operation>
        getUpdateNodePoolMethod;
    if ((getUpdateNodePoolMethod = ClusterManagerGrpc.getUpdateNodePoolMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getUpdateNodePoolMethod = ClusterManagerGrpc.getUpdateNodePoolMethod) == null) {
          ClusterManagerGrpc.getUpdateNodePoolMethod =
              getUpdateNodePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.UpdateNodePoolRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateNodePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.UpdateNodePoolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("UpdateNodePool"))
                      .build();
        }
      }
    }
    return getUpdateNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.SetNodePoolAutoscalingRequest, com.google.container.v1.Operation>
      getSetNodePoolAutoscalingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetNodePoolAutoscaling",
      requestType = com.google.container.v1.SetNodePoolAutoscalingRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.SetNodePoolAutoscalingRequest, com.google.container.v1.Operation>
      getSetNodePoolAutoscalingMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.SetNodePoolAutoscalingRequest,
            com.google.container.v1.Operation>
        getSetNodePoolAutoscalingMethod;
    if ((getSetNodePoolAutoscalingMethod = ClusterManagerGrpc.getSetNodePoolAutoscalingMethod)
        == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetNodePoolAutoscalingMethod = ClusterManagerGrpc.getSetNodePoolAutoscalingMethod)
            == null) {
          ClusterManagerGrpc.getSetNodePoolAutoscalingMethod =
              getSetNodePoolAutoscalingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.SetNodePoolAutoscalingRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SetNodePoolAutoscaling"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.SetNodePoolAutoscalingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("SetNodePoolAutoscaling"))
                      .build();
        }
      }
    }
    return getSetNodePoolAutoscalingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.SetLoggingServiceRequest, com.google.container.v1.Operation>
      getSetLoggingServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetLoggingService",
      requestType = com.google.container.v1.SetLoggingServiceRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.SetLoggingServiceRequest, com.google.container.v1.Operation>
      getSetLoggingServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.SetLoggingServiceRequest, com.google.container.v1.Operation>
        getSetLoggingServiceMethod;
    if ((getSetLoggingServiceMethod = ClusterManagerGrpc.getSetLoggingServiceMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetLoggingServiceMethod = ClusterManagerGrpc.getSetLoggingServiceMethod) == null) {
          ClusterManagerGrpc.getSetLoggingServiceMethod =
              getSetLoggingServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.SetLoggingServiceRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetLoggingService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.SetLoggingServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("SetLoggingService"))
                      .build();
        }
      }
    }
    return getSetLoggingServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.SetMonitoringServiceRequest, com.google.container.v1.Operation>
      getSetMonitoringServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetMonitoringService",
      requestType = com.google.container.v1.SetMonitoringServiceRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.SetMonitoringServiceRequest, com.google.container.v1.Operation>
      getSetMonitoringServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.SetMonitoringServiceRequest, com.google.container.v1.Operation>
        getSetMonitoringServiceMethod;
    if ((getSetMonitoringServiceMethod = ClusterManagerGrpc.getSetMonitoringServiceMethod)
        == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetMonitoringServiceMethod = ClusterManagerGrpc.getSetMonitoringServiceMethod)
            == null) {
          ClusterManagerGrpc.getSetMonitoringServiceMethod =
              getSetMonitoringServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.SetMonitoringServiceRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SetMonitoringService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.SetMonitoringServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("SetMonitoringService"))
                      .build();
        }
      }
    }
    return getSetMonitoringServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.SetAddonsConfigRequest, com.google.container.v1.Operation>
      getSetAddonsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetAddonsConfig",
      requestType = com.google.container.v1.SetAddonsConfigRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.SetAddonsConfigRequest, com.google.container.v1.Operation>
      getSetAddonsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.SetAddonsConfigRequest, com.google.container.v1.Operation>
        getSetAddonsConfigMethod;
    if ((getSetAddonsConfigMethod = ClusterManagerGrpc.getSetAddonsConfigMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetAddonsConfigMethod = ClusterManagerGrpc.getSetAddonsConfigMethod) == null) {
          ClusterManagerGrpc.getSetAddonsConfigMethod =
              getSetAddonsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.SetAddonsConfigRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetAddonsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.SetAddonsConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("SetAddonsConfig"))
                      .build();
        }
      }
    }
    return getSetAddonsConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.SetLocationsRequest, com.google.container.v1.Operation>
      getSetLocationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetLocations",
      requestType = com.google.container.v1.SetLocationsRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.SetLocationsRequest, com.google.container.v1.Operation>
      getSetLocationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.SetLocationsRequest, com.google.container.v1.Operation>
        getSetLocationsMethod;
    if ((getSetLocationsMethod = ClusterManagerGrpc.getSetLocationsMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetLocationsMethod = ClusterManagerGrpc.getSetLocationsMethod) == null) {
          ClusterManagerGrpc.getSetLocationsMethod =
              getSetLocationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.SetLocationsRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetLocations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.SetLocationsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("SetLocations"))
                      .build();
        }
      }
    }
    return getSetLocationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.UpdateMasterRequest, com.google.container.v1.Operation>
      getUpdateMasterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMaster",
      requestType = com.google.container.v1.UpdateMasterRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.UpdateMasterRequest, com.google.container.v1.Operation>
      getUpdateMasterMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.UpdateMasterRequest, com.google.container.v1.Operation>
        getUpdateMasterMethod;
    if ((getUpdateMasterMethod = ClusterManagerGrpc.getUpdateMasterMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getUpdateMasterMethod = ClusterManagerGrpc.getUpdateMasterMethod) == null) {
          ClusterManagerGrpc.getUpdateMasterMethod =
              getUpdateMasterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.UpdateMasterRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMaster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.UpdateMasterRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("UpdateMaster"))
                      .build();
        }
      }
    }
    return getUpdateMasterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.SetMasterAuthRequest, com.google.container.v1.Operation>
      getSetMasterAuthMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetMasterAuth",
      requestType = com.google.container.v1.SetMasterAuthRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.SetMasterAuthRequest, com.google.container.v1.Operation>
      getSetMasterAuthMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.SetMasterAuthRequest, com.google.container.v1.Operation>
        getSetMasterAuthMethod;
    if ((getSetMasterAuthMethod = ClusterManagerGrpc.getSetMasterAuthMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetMasterAuthMethod = ClusterManagerGrpc.getSetMasterAuthMethod) == null) {
          ClusterManagerGrpc.getSetMasterAuthMethod =
              getSetMasterAuthMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.SetMasterAuthRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetMasterAuth"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.SetMasterAuthRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("SetMasterAuth"))
                      .build();
        }
      }
    }
    return getSetMasterAuthMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.DeleteClusterRequest, com.google.container.v1.Operation>
      getDeleteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCluster",
      requestType = com.google.container.v1.DeleteClusterRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.DeleteClusterRequest, com.google.container.v1.Operation>
      getDeleteClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.DeleteClusterRequest, com.google.container.v1.Operation>
        getDeleteClusterMethod;
    if ((getDeleteClusterMethod = ClusterManagerGrpc.getDeleteClusterMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getDeleteClusterMethod = ClusterManagerGrpc.getDeleteClusterMethod) == null) {
          ClusterManagerGrpc.getDeleteClusterMethod =
              getDeleteClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.DeleteClusterRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.DeleteClusterRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("DeleteCluster"))
                      .build();
        }
      }
    }
    return getDeleteClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.ListOperationsRequest,
          com.google.container.v1.ListOperationsResponse>
      getListOperationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOperations",
      requestType = com.google.container.v1.ListOperationsRequest.class,
      responseType = com.google.container.v1.ListOperationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.ListOperationsRequest,
          com.google.container.v1.ListOperationsResponse>
      getListOperationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.ListOperationsRequest,
            com.google.container.v1.ListOperationsResponse>
        getListOperationsMethod;
    if ((getListOperationsMethod = ClusterManagerGrpc.getListOperationsMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getListOperationsMethod = ClusterManagerGrpc.getListOperationsMethod) == null) {
          ClusterManagerGrpc.getListOperationsMethod =
              getListOperationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.ListOperationsRequest,
                          com.google.container.v1.ListOperationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOperations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.ListOperationsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.ListOperationsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("ListOperations"))
                      .build();
        }
      }
    }
    return getListOperationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.GetOperationRequest, com.google.container.v1.Operation>
      getGetOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOperation",
      requestType = com.google.container.v1.GetOperationRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.GetOperationRequest, com.google.container.v1.Operation>
      getGetOperationMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.GetOperationRequest, com.google.container.v1.Operation>
        getGetOperationMethod;
    if ((getGetOperationMethod = ClusterManagerGrpc.getGetOperationMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getGetOperationMethod = ClusterManagerGrpc.getGetOperationMethod) == null) {
          ClusterManagerGrpc.getGetOperationMethod =
              getGetOperationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.GetOperationRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOperation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.GetOperationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("GetOperation"))
                      .build();
        }
      }
    }
    return getGetOperationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.CancelOperationRequest, com.google.protobuf.Empty>
      getCancelOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelOperation",
      requestType = com.google.container.v1.CancelOperationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.CancelOperationRequest, com.google.protobuf.Empty>
      getCancelOperationMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.CancelOperationRequest, com.google.protobuf.Empty>
        getCancelOperationMethod;
    if ((getCancelOperationMethod = ClusterManagerGrpc.getCancelOperationMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getCancelOperationMethod = ClusterManagerGrpc.getCancelOperationMethod) == null) {
          ClusterManagerGrpc.getCancelOperationMethod =
              getCancelOperationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.CancelOperationRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelOperation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.CancelOperationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("CancelOperation"))
                      .build();
        }
      }
    }
    return getCancelOperationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.GetServerConfigRequest, com.google.container.v1.ServerConfig>
      getGetServerConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServerConfig",
      requestType = com.google.container.v1.GetServerConfigRequest.class,
      responseType = com.google.container.v1.ServerConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.GetServerConfigRequest, com.google.container.v1.ServerConfig>
      getGetServerConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.GetServerConfigRequest, com.google.container.v1.ServerConfig>
        getGetServerConfigMethod;
    if ((getGetServerConfigMethod = ClusterManagerGrpc.getGetServerConfigMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getGetServerConfigMethod = ClusterManagerGrpc.getGetServerConfigMethod) == null) {
          ClusterManagerGrpc.getGetServerConfigMethod =
              getGetServerConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.GetServerConfigRequest,
                          com.google.container.v1.ServerConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServerConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.GetServerConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.ServerConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("GetServerConfig"))
                      .build();
        }
      }
    }
    return getGetServerConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.GetJSONWebKeysRequest,
          com.google.container.v1.GetJSONWebKeysResponse>
      getGetJSONWebKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJSONWebKeys",
      requestType = com.google.container.v1.GetJSONWebKeysRequest.class,
      responseType = com.google.container.v1.GetJSONWebKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.GetJSONWebKeysRequest,
          com.google.container.v1.GetJSONWebKeysResponse>
      getGetJSONWebKeysMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.GetJSONWebKeysRequest,
            com.google.container.v1.GetJSONWebKeysResponse>
        getGetJSONWebKeysMethod;
    if ((getGetJSONWebKeysMethod = ClusterManagerGrpc.getGetJSONWebKeysMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getGetJSONWebKeysMethod = ClusterManagerGrpc.getGetJSONWebKeysMethod) == null) {
          ClusterManagerGrpc.getGetJSONWebKeysMethod =
              getGetJSONWebKeysMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.GetJSONWebKeysRequest,
                          com.google.container.v1.GetJSONWebKeysResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJSONWebKeys"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.GetJSONWebKeysRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.GetJSONWebKeysResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("GetJSONWebKeys"))
                      .build();
        }
      }
    }
    return getGetJSONWebKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.ListNodePoolsRequest,
          com.google.container.v1.ListNodePoolsResponse>
      getListNodePoolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNodePools",
      requestType = com.google.container.v1.ListNodePoolsRequest.class,
      responseType = com.google.container.v1.ListNodePoolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.ListNodePoolsRequest,
          com.google.container.v1.ListNodePoolsResponse>
      getListNodePoolsMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.ListNodePoolsRequest,
            com.google.container.v1.ListNodePoolsResponse>
        getListNodePoolsMethod;
    if ((getListNodePoolsMethod = ClusterManagerGrpc.getListNodePoolsMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getListNodePoolsMethod = ClusterManagerGrpc.getListNodePoolsMethod) == null) {
          ClusterManagerGrpc.getListNodePoolsMethod =
              getListNodePoolsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.ListNodePoolsRequest,
                          com.google.container.v1.ListNodePoolsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNodePools"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.ListNodePoolsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.ListNodePoolsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("ListNodePools"))
                      .build();
        }
      }
    }
    return getListNodePoolsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.GetNodePoolRequest, com.google.container.v1.NodePool>
      getGetNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNodePool",
      requestType = com.google.container.v1.GetNodePoolRequest.class,
      responseType = com.google.container.v1.NodePool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.GetNodePoolRequest, com.google.container.v1.NodePool>
      getGetNodePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.GetNodePoolRequest, com.google.container.v1.NodePool>
        getGetNodePoolMethod;
    if ((getGetNodePoolMethod = ClusterManagerGrpc.getGetNodePoolMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getGetNodePoolMethod = ClusterManagerGrpc.getGetNodePoolMethod) == null) {
          ClusterManagerGrpc.getGetNodePoolMethod =
              getGetNodePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.GetNodePoolRequest,
                          com.google.container.v1.NodePool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNodePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.GetNodePoolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.NodePool.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("GetNodePool"))
                      .build();
        }
      }
    }
    return getGetNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.CreateNodePoolRequest, com.google.container.v1.Operation>
      getCreateNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNodePool",
      requestType = com.google.container.v1.CreateNodePoolRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.CreateNodePoolRequest, com.google.container.v1.Operation>
      getCreateNodePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.CreateNodePoolRequest, com.google.container.v1.Operation>
        getCreateNodePoolMethod;
    if ((getCreateNodePoolMethod = ClusterManagerGrpc.getCreateNodePoolMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getCreateNodePoolMethod = ClusterManagerGrpc.getCreateNodePoolMethod) == null) {
          ClusterManagerGrpc.getCreateNodePoolMethod =
              getCreateNodePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.CreateNodePoolRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNodePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.CreateNodePoolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("CreateNodePool"))
                      .build();
        }
      }
    }
    return getCreateNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.DeleteNodePoolRequest, com.google.container.v1.Operation>
      getDeleteNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNodePool",
      requestType = com.google.container.v1.DeleteNodePoolRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.DeleteNodePoolRequest, com.google.container.v1.Operation>
      getDeleteNodePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.DeleteNodePoolRequest, com.google.container.v1.Operation>
        getDeleteNodePoolMethod;
    if ((getDeleteNodePoolMethod = ClusterManagerGrpc.getDeleteNodePoolMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getDeleteNodePoolMethod = ClusterManagerGrpc.getDeleteNodePoolMethod) == null) {
          ClusterManagerGrpc.getDeleteNodePoolMethod =
              getDeleteNodePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.DeleteNodePoolRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteNodePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.DeleteNodePoolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("DeleteNodePool"))
                      .build();
        }
      }
    }
    return getDeleteNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.CompleteNodePoolUpgradeRequest, com.google.protobuf.Empty>
      getCompleteNodePoolUpgradeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompleteNodePoolUpgrade",
      requestType = com.google.container.v1.CompleteNodePoolUpgradeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.CompleteNodePoolUpgradeRequest, com.google.protobuf.Empty>
      getCompleteNodePoolUpgradeMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.CompleteNodePoolUpgradeRequest, com.google.protobuf.Empty>
        getCompleteNodePoolUpgradeMethod;
    if ((getCompleteNodePoolUpgradeMethod = ClusterManagerGrpc.getCompleteNodePoolUpgradeMethod)
        == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getCompleteNodePoolUpgradeMethod = ClusterManagerGrpc.getCompleteNodePoolUpgradeMethod)
            == null) {
          ClusterManagerGrpc.getCompleteNodePoolUpgradeMethod =
              getCompleteNodePoolUpgradeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.CompleteNodePoolUpgradeRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CompleteNodePoolUpgrade"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.CompleteNodePoolUpgradeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("CompleteNodePoolUpgrade"))
                      .build();
        }
      }
    }
    return getCompleteNodePoolUpgradeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.RollbackNodePoolUpgradeRequest, com.google.container.v1.Operation>
      getRollbackNodePoolUpgradeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollbackNodePoolUpgrade",
      requestType = com.google.container.v1.RollbackNodePoolUpgradeRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.RollbackNodePoolUpgradeRequest, com.google.container.v1.Operation>
      getRollbackNodePoolUpgradeMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.RollbackNodePoolUpgradeRequest,
            com.google.container.v1.Operation>
        getRollbackNodePoolUpgradeMethod;
    if ((getRollbackNodePoolUpgradeMethod = ClusterManagerGrpc.getRollbackNodePoolUpgradeMethod)
        == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getRollbackNodePoolUpgradeMethod = ClusterManagerGrpc.getRollbackNodePoolUpgradeMethod)
            == null) {
          ClusterManagerGrpc.getRollbackNodePoolUpgradeMethod =
              getRollbackNodePoolUpgradeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.RollbackNodePoolUpgradeRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RollbackNodePoolUpgrade"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.RollbackNodePoolUpgradeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("RollbackNodePoolUpgrade"))
                      .build();
        }
      }
    }
    return getRollbackNodePoolUpgradeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.SetNodePoolManagementRequest, com.google.container.v1.Operation>
      getSetNodePoolManagementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetNodePoolManagement",
      requestType = com.google.container.v1.SetNodePoolManagementRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.SetNodePoolManagementRequest, com.google.container.v1.Operation>
      getSetNodePoolManagementMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.SetNodePoolManagementRequest, com.google.container.v1.Operation>
        getSetNodePoolManagementMethod;
    if ((getSetNodePoolManagementMethod = ClusterManagerGrpc.getSetNodePoolManagementMethod)
        == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetNodePoolManagementMethod = ClusterManagerGrpc.getSetNodePoolManagementMethod)
            == null) {
          ClusterManagerGrpc.getSetNodePoolManagementMethod =
              getSetNodePoolManagementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.SetNodePoolManagementRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SetNodePoolManagement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.SetNodePoolManagementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("SetNodePoolManagement"))
                      .build();
        }
      }
    }
    return getSetNodePoolManagementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.SetLabelsRequest, com.google.container.v1.Operation>
      getSetLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetLabels",
      requestType = com.google.container.v1.SetLabelsRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.SetLabelsRequest, com.google.container.v1.Operation>
      getSetLabelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.SetLabelsRequest, com.google.container.v1.Operation>
        getSetLabelsMethod;
    if ((getSetLabelsMethod = ClusterManagerGrpc.getSetLabelsMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetLabelsMethod = ClusterManagerGrpc.getSetLabelsMethod) == null) {
          ClusterManagerGrpc.getSetLabelsMethod =
              getSetLabelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.SetLabelsRequest, com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetLabels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.SetLabelsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("SetLabels"))
                      .build();
        }
      }
    }
    return getSetLabelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.SetLegacyAbacRequest, com.google.container.v1.Operation>
      getSetLegacyAbacMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetLegacyAbac",
      requestType = com.google.container.v1.SetLegacyAbacRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.SetLegacyAbacRequest, com.google.container.v1.Operation>
      getSetLegacyAbacMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.SetLegacyAbacRequest, com.google.container.v1.Operation>
        getSetLegacyAbacMethod;
    if ((getSetLegacyAbacMethod = ClusterManagerGrpc.getSetLegacyAbacMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetLegacyAbacMethod = ClusterManagerGrpc.getSetLegacyAbacMethod) == null) {
          ClusterManagerGrpc.getSetLegacyAbacMethod =
              getSetLegacyAbacMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.SetLegacyAbacRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetLegacyAbac"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.SetLegacyAbacRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("SetLegacyAbac"))
                      .build();
        }
      }
    }
    return getSetLegacyAbacMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.StartIPRotationRequest, com.google.container.v1.Operation>
      getStartIPRotationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartIPRotation",
      requestType = com.google.container.v1.StartIPRotationRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.StartIPRotationRequest, com.google.container.v1.Operation>
      getStartIPRotationMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.StartIPRotationRequest, com.google.container.v1.Operation>
        getStartIPRotationMethod;
    if ((getStartIPRotationMethod = ClusterManagerGrpc.getStartIPRotationMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getStartIPRotationMethod = ClusterManagerGrpc.getStartIPRotationMethod) == null) {
          ClusterManagerGrpc.getStartIPRotationMethod =
              getStartIPRotationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.StartIPRotationRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartIPRotation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.StartIPRotationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("StartIPRotation"))
                      .build();
        }
      }
    }
    return getStartIPRotationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.CompleteIPRotationRequest, com.google.container.v1.Operation>
      getCompleteIPRotationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompleteIPRotation",
      requestType = com.google.container.v1.CompleteIPRotationRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.CompleteIPRotationRequest, com.google.container.v1.Operation>
      getCompleteIPRotationMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.CompleteIPRotationRequest, com.google.container.v1.Operation>
        getCompleteIPRotationMethod;
    if ((getCompleteIPRotationMethod = ClusterManagerGrpc.getCompleteIPRotationMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getCompleteIPRotationMethod = ClusterManagerGrpc.getCompleteIPRotationMethod)
            == null) {
          ClusterManagerGrpc.getCompleteIPRotationMethod =
              getCompleteIPRotationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.CompleteIPRotationRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompleteIPRotation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.CompleteIPRotationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("CompleteIPRotation"))
                      .build();
        }
      }
    }
    return getCompleteIPRotationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.SetNodePoolSizeRequest, com.google.container.v1.Operation>
      getSetNodePoolSizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetNodePoolSize",
      requestType = com.google.container.v1.SetNodePoolSizeRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.SetNodePoolSizeRequest, com.google.container.v1.Operation>
      getSetNodePoolSizeMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.SetNodePoolSizeRequest, com.google.container.v1.Operation>
        getSetNodePoolSizeMethod;
    if ((getSetNodePoolSizeMethod = ClusterManagerGrpc.getSetNodePoolSizeMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetNodePoolSizeMethod = ClusterManagerGrpc.getSetNodePoolSizeMethod) == null) {
          ClusterManagerGrpc.getSetNodePoolSizeMethod =
              getSetNodePoolSizeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.SetNodePoolSizeRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetNodePoolSize"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.SetNodePoolSizeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("SetNodePoolSize"))
                      .build();
        }
      }
    }
    return getSetNodePoolSizeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.SetNetworkPolicyRequest, com.google.container.v1.Operation>
      getSetNetworkPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetNetworkPolicy",
      requestType = com.google.container.v1.SetNetworkPolicyRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.SetNetworkPolicyRequest, com.google.container.v1.Operation>
      getSetNetworkPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.SetNetworkPolicyRequest, com.google.container.v1.Operation>
        getSetNetworkPolicyMethod;
    if ((getSetNetworkPolicyMethod = ClusterManagerGrpc.getSetNetworkPolicyMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetNetworkPolicyMethod = ClusterManagerGrpc.getSetNetworkPolicyMethod) == null) {
          ClusterManagerGrpc.getSetNetworkPolicyMethod =
              getSetNetworkPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.SetNetworkPolicyRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetNetworkPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.SetNetworkPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("SetNetworkPolicy"))
                      .build();
        }
      }
    }
    return getSetNetworkPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.SetMaintenancePolicyRequest, com.google.container.v1.Operation>
      getSetMaintenancePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetMaintenancePolicy",
      requestType = com.google.container.v1.SetMaintenancePolicyRequest.class,
      responseType = com.google.container.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.SetMaintenancePolicyRequest, com.google.container.v1.Operation>
      getSetMaintenancePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.SetMaintenancePolicyRequest, com.google.container.v1.Operation>
        getSetMaintenancePolicyMethod;
    if ((getSetMaintenancePolicyMethod = ClusterManagerGrpc.getSetMaintenancePolicyMethod)
        == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetMaintenancePolicyMethod = ClusterManagerGrpc.getSetMaintenancePolicyMethod)
            == null) {
          ClusterManagerGrpc.getSetMaintenancePolicyMethod =
              getSetMaintenancePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.SetMaintenancePolicyRequest,
                          com.google.container.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SetMaintenancePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.SetMaintenancePolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("SetMaintenancePolicy"))
                      .build();
        }
      }
    }
    return getSetMaintenancePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.container.v1.ListUsableSubnetworksRequest,
          com.google.container.v1.ListUsableSubnetworksResponse>
      getListUsableSubnetworksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUsableSubnetworks",
      requestType = com.google.container.v1.ListUsableSubnetworksRequest.class,
      responseType = com.google.container.v1.ListUsableSubnetworksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.container.v1.ListUsableSubnetworksRequest,
          com.google.container.v1.ListUsableSubnetworksResponse>
      getListUsableSubnetworksMethod() {
    io.grpc.MethodDescriptor<
            com.google.container.v1.ListUsableSubnetworksRequest,
            com.google.container.v1.ListUsableSubnetworksResponse>
        getListUsableSubnetworksMethod;
    if ((getListUsableSubnetworksMethod = ClusterManagerGrpc.getListUsableSubnetworksMethod)
        == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getListUsableSubnetworksMethod = ClusterManagerGrpc.getListUsableSubnetworksMethod)
            == null) {
          ClusterManagerGrpc.getListUsableSubnetworksMethod =
              getListUsableSubnetworksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.container.v1.ListUsableSubnetworksRequest,
                          com.google.container.v1.ListUsableSubnetworksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListUsableSubnetworks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.ListUsableSubnetworksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.container.v1.ListUsableSubnetworksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterManagerMethodDescriptorSupplier("ListUsableSubnetworks"))
                      .build();
        }
      }
    }
    return getListUsableSubnetworksMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ClusterManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClusterManagerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ClusterManagerStub>() {
          @java.lang.Override
          public ClusterManagerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ClusterManagerStub(channel, callOptions);
          }
        };
    return ClusterManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClusterManagerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClusterManagerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ClusterManagerBlockingStub>() {
          @java.lang.Override
          public ClusterManagerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ClusterManagerBlockingStub(channel, callOptions);
          }
        };
    return ClusterManagerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ClusterManagerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClusterManagerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ClusterManagerFutureStub>() {
          @java.lang.Override
          public ClusterManagerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ClusterManagerFutureStub(channel, callOptions);
          }
        };
    return ClusterManagerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Google Kubernetes Engine Cluster Manager v1
   * </pre>
   */
  public abstract static class ClusterManagerImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists all clusters owned by a project in either the specified zone or all
     * zones.
     * </pre>
     */
    public void listClusters(
        com.google.container.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific cluster.
     * </pre>
     */
    public void getCluster(
        com.google.container.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Cluster> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster, consisting of the specified number and type of Google
     * Compute Engine instances.
     * By default, the cluster is created in the project's
     * [default
     * network](https://cloud.google.com/compute/docs/networks-and-firewalls#networks).
     * One firewall is added for the cluster. After cluster creation,
     * the Kubelet creates routes for each node to allow the containers
     * on that node to communicate with all other instances in the
     * cluster.
     * Finally, an entry is added to the project's global metadata indicating
     * which CIDR range the cluster is using.
     * </pre>
     */
    public void createCluster(
        com.google.container.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific cluster.
     * </pre>
     */
    public void updateCluster(
        com.google.container.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the version and/or image type for the specified node pool.
     * </pre>
     */
    public void updateNodePool(
        com.google.container.v1.UpdateNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateNodePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the autoscaling settings for the specified node pool.
     * </pre>
     */
    public void setNodePoolAutoscaling(
        com.google.container.v1.SetNodePoolAutoscalingRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetNodePoolAutoscalingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the logging service for a specific cluster.
     * </pre>
     */
    public void setLoggingService(
        com.google.container.v1.SetLoggingServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetLoggingServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the monitoring service for a specific cluster.
     * </pre>
     */
    public void setMonitoringService(
        com.google.container.v1.SetMonitoringServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetMonitoringServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the addons for a specific cluster.
     * </pre>
     */
    public void setAddonsConfig(
        com.google.container.v1.SetAddonsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetAddonsConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the locations for a specific cluster.
     * Deprecated. Use
     * [projects.locations.clusters.update](https://cloud.google.com/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters/update)
     * instead.
     * </pre>
     */
    @java.lang.Deprecated
    public void setLocations(
        com.google.container.v1.SetLocationsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetLocationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the master for a specific cluster.
     * </pre>
     */
    public void updateMaster(
        com.google.container.v1.UpdateMasterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMasterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets master auth materials. Currently supports changing the admin password
     * or a specific cluster, either via password generation or explicitly setting
     * the password.
     * </pre>
     */
    public void setMasterAuth(
        com.google.container.v1.SetMasterAuthRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetMasterAuthMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the cluster, including the Kubernetes endpoint and all worker
     * nodes.
     * Firewalls and routes that were configured during cluster creation
     * are also deleted.
     * Other Google Compute Engine resources that might be in use by the cluster,
     * such as load balancer resources, are not deleted if they weren't present
     * when the cluster was initially created.
     * </pre>
     */
    public void deleteCluster(
        com.google.container.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all operations in a project in a specific zone or all zones.
     * </pre>
     */
    public void listOperations(
        com.google.container.v1.ListOperationsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListOperationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOperationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified operation.
     * </pre>
     */
    public void getOperation(
        com.google.container.v1.GetOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOperationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels the specified operation.
     * </pre>
     */
    public void cancelOperation(
        com.google.container.v1.CancelOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelOperationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns configuration info about the Google Kubernetes Engine service.
     * </pre>
     */
    public void getServerConfig(
        com.google.container.v1.GetServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ServerConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetServerConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the public component of the cluster signing keys in
     * JSON Web Key format.
     * This API is not yet intended for general use, and is not available for all
     * clusters.
     * </pre>
     */
    public void getJSONWebKeys(
        com.google.container.v1.GetJSONWebKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.GetJSONWebKeysResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetJSONWebKeysMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the node pools for a cluster.
     * </pre>
     */
    public void listNodePools(
        com.google.container.v1.ListNodePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListNodePoolsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNodePoolsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the requested node pool.
     * </pre>
     */
    public void getNodePool(
        com.google.container.v1.GetNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.NodePool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNodePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a node pool for a cluster.
     * </pre>
     */
    public void createNodePool(
        com.google.container.v1.CreateNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateNodePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a node pool from a cluster.
     * </pre>
     */
    public void deleteNodePool(
        com.google.container.v1.DeleteNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteNodePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * CompleteNodePoolUpgrade will signal an on-going node pool upgrade to
     * complete.
     * </pre>
     */
    public void completeNodePoolUpgrade(
        com.google.container.v1.CompleteNodePoolUpgradeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCompleteNodePoolUpgradeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a previously Aborted or Failed NodePool upgrade.
     * This makes no changes if the last upgrade successfully completed.
     * </pre>
     */
    public void rollbackNodePoolUpgrade(
        com.google.container.v1.RollbackNodePoolUpgradeRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRollbackNodePoolUpgradeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the NodeManagement options for a node pool.
     * </pre>
     */
    public void setNodePoolManagement(
        com.google.container.v1.SetNodePoolManagementRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetNodePoolManagementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets labels on a cluster.
     * </pre>
     */
    public void setLabels(
        com.google.container.v1.SetLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetLabelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables or disables the ABAC authorization mechanism on a cluster.
     * </pre>
     */
    public void setLegacyAbac(
        com.google.container.v1.SetLegacyAbacRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetLegacyAbacMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts master IP rotation.
     * </pre>
     */
    public void startIPRotation(
        com.google.container.v1.StartIPRotationRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartIPRotationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Completes master IP rotation.
     * </pre>
     */
    public void completeIPRotation(
        com.google.container.v1.CompleteIPRotationRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCompleteIPRotationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the size for a specific node pool. The new size will be used for all
     * replicas, including future replicas created by modifying
     * [NodePool.locations][google.container.v1.NodePool.locations].
     * </pre>
     */
    public void setNodePoolSize(
        com.google.container.v1.SetNodePoolSizeRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetNodePoolSizeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables or disables Network Policy for a cluster.
     * </pre>
     */
    public void setNetworkPolicy(
        com.google.container.v1.SetNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetNetworkPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the maintenance policy for a cluster.
     * </pre>
     */
    public void setMaintenancePolicy(
        com.google.container.v1.SetMaintenancePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetMaintenancePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists subnetworks that are usable for creating clusters in a project.
     * </pre>
     */
    public void listUsableSubnetworks(
        com.google.container.v1.ListUsableSubnetworksRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListUsableSubnetworksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUsableSubnetworksMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListClustersMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.ListClustersRequest,
                      com.google.container.v1.ListClustersResponse>(this, METHODID_LIST_CLUSTERS)))
          .addMethod(
              getGetClusterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.GetClusterRequest, com.google.container.v1.Cluster>(
                      this, METHODID_GET_CLUSTER)))
          .addMethod(
              getCreateClusterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.CreateClusterRequest,
                      com.google.container.v1.Operation>(this, METHODID_CREATE_CLUSTER)))
          .addMethod(
              getUpdateClusterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.UpdateClusterRequest,
                      com.google.container.v1.Operation>(this, METHODID_UPDATE_CLUSTER)))
          .addMethod(
              getUpdateNodePoolMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.UpdateNodePoolRequest,
                      com.google.container.v1.Operation>(this, METHODID_UPDATE_NODE_POOL)))
          .addMethod(
              getSetNodePoolAutoscalingMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.SetNodePoolAutoscalingRequest,
                      com.google.container.v1.Operation>(this, METHODID_SET_NODE_POOL_AUTOSCALING)))
          .addMethod(
              getSetLoggingServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.SetLoggingServiceRequest,
                      com.google.container.v1.Operation>(this, METHODID_SET_LOGGING_SERVICE)))
          .addMethod(
              getSetMonitoringServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.SetMonitoringServiceRequest,
                      com.google.container.v1.Operation>(this, METHODID_SET_MONITORING_SERVICE)))
          .addMethod(
              getSetAddonsConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.SetAddonsConfigRequest,
                      com.google.container.v1.Operation>(this, METHODID_SET_ADDONS_CONFIG)))
          .addMethod(
              getSetLocationsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.SetLocationsRequest,
                      com.google.container.v1.Operation>(this, METHODID_SET_LOCATIONS)))
          .addMethod(
              getUpdateMasterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.UpdateMasterRequest,
                      com.google.container.v1.Operation>(this, METHODID_UPDATE_MASTER)))
          .addMethod(
              getSetMasterAuthMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.SetMasterAuthRequest,
                      com.google.container.v1.Operation>(this, METHODID_SET_MASTER_AUTH)))
          .addMethod(
              getDeleteClusterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.DeleteClusterRequest,
                      com.google.container.v1.Operation>(this, METHODID_DELETE_CLUSTER)))
          .addMethod(
              getListOperationsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.ListOperationsRequest,
                      com.google.container.v1.ListOperationsResponse>(
                      this, METHODID_LIST_OPERATIONS)))
          .addMethod(
              getGetOperationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.GetOperationRequest,
                      com.google.container.v1.Operation>(this, METHODID_GET_OPERATION)))
          .addMethod(
              getCancelOperationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.CancelOperationRequest, com.google.protobuf.Empty>(
                      this, METHODID_CANCEL_OPERATION)))
          .addMethod(
              getGetServerConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.GetServerConfigRequest,
                      com.google.container.v1.ServerConfig>(this, METHODID_GET_SERVER_CONFIG)))
          .addMethod(
              getGetJSONWebKeysMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.GetJSONWebKeysRequest,
                      com.google.container.v1.GetJSONWebKeysResponse>(
                      this, METHODID_GET_JSONWEB_KEYS)))
          .addMethod(
              getListNodePoolsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.ListNodePoolsRequest,
                      com.google.container.v1.ListNodePoolsResponse>(
                      this, METHODID_LIST_NODE_POOLS)))
          .addMethod(
              getGetNodePoolMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.GetNodePoolRequest, com.google.container.v1.NodePool>(
                      this, METHODID_GET_NODE_POOL)))
          .addMethod(
              getCreateNodePoolMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.CreateNodePoolRequest,
                      com.google.container.v1.Operation>(this, METHODID_CREATE_NODE_POOL)))
          .addMethod(
              getDeleteNodePoolMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.DeleteNodePoolRequest,
                      com.google.container.v1.Operation>(this, METHODID_DELETE_NODE_POOL)))
          .addMethod(
              getCompleteNodePoolUpgradeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.CompleteNodePoolUpgradeRequest,
                      com.google.protobuf.Empty>(this, METHODID_COMPLETE_NODE_POOL_UPGRADE)))
          .addMethod(
              getRollbackNodePoolUpgradeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.RollbackNodePoolUpgradeRequest,
                      com.google.container.v1.Operation>(
                      this, METHODID_ROLLBACK_NODE_POOL_UPGRADE)))
          .addMethod(
              getSetNodePoolManagementMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.SetNodePoolManagementRequest,
                      com.google.container.v1.Operation>(this, METHODID_SET_NODE_POOL_MANAGEMENT)))
          .addMethod(
              getSetLabelsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.SetLabelsRequest, com.google.container.v1.Operation>(
                      this, METHODID_SET_LABELS)))
          .addMethod(
              getSetLegacyAbacMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.SetLegacyAbacRequest,
                      com.google.container.v1.Operation>(this, METHODID_SET_LEGACY_ABAC)))
          .addMethod(
              getStartIPRotationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.StartIPRotationRequest,
                      com.google.container.v1.Operation>(this, METHODID_START_IPROTATION)))
          .addMethod(
              getCompleteIPRotationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.CompleteIPRotationRequest,
                      com.google.container.v1.Operation>(this, METHODID_COMPLETE_IPROTATION)))
          .addMethod(
              getSetNodePoolSizeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.SetNodePoolSizeRequest,
                      com.google.container.v1.Operation>(this, METHODID_SET_NODE_POOL_SIZE)))
          .addMethod(
              getSetNetworkPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.SetNetworkPolicyRequest,
                      com.google.container.v1.Operation>(this, METHODID_SET_NETWORK_POLICY)))
          .addMethod(
              getSetMaintenancePolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.SetMaintenancePolicyRequest,
                      com.google.container.v1.Operation>(this, METHODID_SET_MAINTENANCE_POLICY)))
          .addMethod(
              getListUsableSubnetworksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.container.v1.ListUsableSubnetworksRequest,
                      com.google.container.v1.ListUsableSubnetworksResponse>(
                      this, METHODID_LIST_USABLE_SUBNETWORKS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Google Kubernetes Engine Cluster Manager v1
   * </pre>
   */
  public static final class ClusterManagerStub
      extends io.grpc.stub.AbstractAsyncStub<ClusterManagerStub> {
    private ClusterManagerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterManagerStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClusterManagerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all clusters owned by a project in either the specified zone or all
     * zones.
     * </pre>
     */
    public void listClusters(
        com.google.container.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListClustersResponse>
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
     * Gets the details of a specific cluster.
     * </pre>
     */
    public void getCluster(
        com.google.container.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Cluster> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster, consisting of the specified number and type of Google
     * Compute Engine instances.
     * By default, the cluster is created in the project's
     * [default
     * network](https://cloud.google.com/compute/docs/networks-and-firewalls#networks).
     * One firewall is added for the cluster. After cluster creation,
     * the Kubelet creates routes for each node to allow the containers
     * on that node to communicate with all other instances in the
     * cluster.
     * Finally, an entry is added to the project's global metadata indicating
     * which CIDR range the cluster is using.
     * </pre>
     */
    public void createCluster(
        com.google.container.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific cluster.
     * </pre>
     */
    public void updateCluster(
        com.google.container.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the version and/or image type for the specified node pool.
     * </pre>
     */
    public void updateNodePool(
        com.google.container.v1.UpdateNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNodePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the autoscaling settings for the specified node pool.
     * </pre>
     */
    public void setNodePoolAutoscaling(
        com.google.container.v1.SetNodePoolAutoscalingRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetNodePoolAutoscalingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the logging service for a specific cluster.
     * </pre>
     */
    public void setLoggingService(
        com.google.container.v1.SetLoggingServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetLoggingServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the monitoring service for a specific cluster.
     * </pre>
     */
    public void setMonitoringService(
        com.google.container.v1.SetMonitoringServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetMonitoringServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the addons for a specific cluster.
     * </pre>
     */
    public void setAddonsConfig(
        com.google.container.v1.SetAddonsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetAddonsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the locations for a specific cluster.
     * Deprecated. Use
     * [projects.locations.clusters.update](https://cloud.google.com/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters/update)
     * instead.
     * </pre>
     */
    @java.lang.Deprecated
    public void setLocations(
        com.google.container.v1.SetLocationsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetLocationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the master for a specific cluster.
     * </pre>
     */
    public void updateMaster(
        com.google.container.v1.UpdateMasterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMasterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets master auth materials. Currently supports changing the admin password
     * or a specific cluster, either via password generation or explicitly setting
     * the password.
     * </pre>
     */
    public void setMasterAuth(
        com.google.container.v1.SetMasterAuthRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetMasterAuthMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the cluster, including the Kubernetes endpoint and all worker
     * nodes.
     * Firewalls and routes that were configured during cluster creation
     * are also deleted.
     * Other Google Compute Engine resources that might be in use by the cluster,
     * such as load balancer resources, are not deleted if they weren't present
     * when the cluster was initially created.
     * </pre>
     */
    public void deleteCluster(
        com.google.container.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all operations in a project in a specific zone or all zones.
     * </pre>
     */
    public void listOperations(
        com.google.container.v1.ListOperationsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListOperationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOperationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified operation.
     * </pre>
     */
    public void getOperation(
        com.google.container.v1.GetOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOperationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels the specified operation.
     * </pre>
     */
    public void cancelOperation(
        com.google.container.v1.CancelOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelOperationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns configuration info about the Google Kubernetes Engine service.
     * </pre>
     */
    public void getServerConfig(
        com.google.container.v1.GetServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ServerConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServerConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the public component of the cluster signing keys in
     * JSON Web Key format.
     * This API is not yet intended for general use, and is not available for all
     * clusters.
     * </pre>
     */
    public void getJSONWebKeys(
        com.google.container.v1.GetJSONWebKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.GetJSONWebKeysResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJSONWebKeysMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the node pools for a cluster.
     * </pre>
     */
    public void listNodePools(
        com.google.container.v1.ListNodePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListNodePoolsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNodePoolsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the requested node pool.
     * </pre>
     */
    public void getNodePool(
        com.google.container.v1.GetNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.NodePool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNodePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a node pool for a cluster.
     * </pre>
     */
    public void createNodePool(
        com.google.container.v1.CreateNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNodePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a node pool from a cluster.
     * </pre>
     */
    public void deleteNodePool(
        com.google.container.v1.DeleteNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNodePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * CompleteNodePoolUpgrade will signal an on-going node pool upgrade to
     * complete.
     * </pre>
     */
    public void completeNodePoolUpgrade(
        com.google.container.v1.CompleteNodePoolUpgradeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompleteNodePoolUpgradeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a previously Aborted or Failed NodePool upgrade.
     * This makes no changes if the last upgrade successfully completed.
     * </pre>
     */
    public void rollbackNodePoolUpgrade(
        com.google.container.v1.RollbackNodePoolUpgradeRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollbackNodePoolUpgradeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the NodeManagement options for a node pool.
     * </pre>
     */
    public void setNodePoolManagement(
        com.google.container.v1.SetNodePoolManagementRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetNodePoolManagementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets labels on a cluster.
     * </pre>
     */
    public void setLabels(
        com.google.container.v1.SetLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetLabelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables or disables the ABAC authorization mechanism on a cluster.
     * </pre>
     */
    public void setLegacyAbac(
        com.google.container.v1.SetLegacyAbacRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetLegacyAbacMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts master IP rotation.
     * </pre>
     */
    public void startIPRotation(
        com.google.container.v1.StartIPRotationRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartIPRotationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Completes master IP rotation.
     * </pre>
     */
    public void completeIPRotation(
        com.google.container.v1.CompleteIPRotationRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompleteIPRotationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the size for a specific node pool. The new size will be used for all
     * replicas, including future replicas created by modifying
     * [NodePool.locations][google.container.v1.NodePool.locations].
     * </pre>
     */
    public void setNodePoolSize(
        com.google.container.v1.SetNodePoolSizeRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetNodePoolSizeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables or disables Network Policy for a cluster.
     * </pre>
     */
    public void setNetworkPolicy(
        com.google.container.v1.SetNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetNetworkPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the maintenance policy for a cluster.
     * </pre>
     */
    public void setMaintenancePolicy(
        com.google.container.v1.SetMaintenancePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetMaintenancePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists subnetworks that are usable for creating clusters in a project.
     * </pre>
     */
    public void listUsableSubnetworks(
        com.google.container.v1.ListUsableSubnetworksRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListUsableSubnetworksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUsableSubnetworksMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Google Kubernetes Engine Cluster Manager v1
   * </pre>
   */
  public static final class ClusterManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ClusterManagerBlockingStub> {
    private ClusterManagerBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClusterManagerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all clusters owned by a project in either the specified zone or all
     * zones.
     * </pre>
     */
    public com.google.container.v1.ListClustersResponse listClusters(
        com.google.container.v1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific cluster.
     * </pre>
     */
    public com.google.container.v1.Cluster getCluster(
        com.google.container.v1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster, consisting of the specified number and type of Google
     * Compute Engine instances.
     * By default, the cluster is created in the project's
     * [default
     * network](https://cloud.google.com/compute/docs/networks-and-firewalls#networks).
     * One firewall is added for the cluster. After cluster creation,
     * the Kubelet creates routes for each node to allow the containers
     * on that node to communicate with all other instances in the
     * cluster.
     * Finally, an entry is added to the project's global metadata indicating
     * which CIDR range the cluster is using.
     * </pre>
     */
    public com.google.container.v1.Operation createCluster(
        com.google.container.v1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific cluster.
     * </pre>
     */
    public com.google.container.v1.Operation updateCluster(
        com.google.container.v1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the version and/or image type for the specified node pool.
     * </pre>
     */
    public com.google.container.v1.Operation updateNodePool(
        com.google.container.v1.UpdateNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNodePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the autoscaling settings for the specified node pool.
     * </pre>
     */
    public com.google.container.v1.Operation setNodePoolAutoscaling(
        com.google.container.v1.SetNodePoolAutoscalingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetNodePoolAutoscalingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the logging service for a specific cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setLoggingService(
        com.google.container.v1.SetLoggingServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetLoggingServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the monitoring service for a specific cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setMonitoringService(
        com.google.container.v1.SetMonitoringServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetMonitoringServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the addons for a specific cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setAddonsConfig(
        com.google.container.v1.SetAddonsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetAddonsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the locations for a specific cluster.
     * Deprecated. Use
     * [projects.locations.clusters.update](https://cloud.google.com/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters/update)
     * instead.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.container.v1.Operation setLocations(
        com.google.container.v1.SetLocationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetLocationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the master for a specific cluster.
     * </pre>
     */
    public com.google.container.v1.Operation updateMaster(
        com.google.container.v1.UpdateMasterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMasterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets master auth materials. Currently supports changing the admin password
     * or a specific cluster, either via password generation or explicitly setting
     * the password.
     * </pre>
     */
    public com.google.container.v1.Operation setMasterAuth(
        com.google.container.v1.SetMasterAuthRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetMasterAuthMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the cluster, including the Kubernetes endpoint and all worker
     * nodes.
     * Firewalls and routes that were configured during cluster creation
     * are also deleted.
     * Other Google Compute Engine resources that might be in use by the cluster,
     * such as load balancer resources, are not deleted if they weren't present
     * when the cluster was initially created.
     * </pre>
     */
    public com.google.container.v1.Operation deleteCluster(
        com.google.container.v1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all operations in a project in a specific zone or all zones.
     * </pre>
     */
    public com.google.container.v1.ListOperationsResponse listOperations(
        com.google.container.v1.ListOperationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOperationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified operation.
     * </pre>
     */
    public com.google.container.v1.Operation getOperation(
        com.google.container.v1.GetOperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOperationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels the specified operation.
     * </pre>
     */
    public com.google.protobuf.Empty cancelOperation(
        com.google.container.v1.CancelOperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelOperationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns configuration info about the Google Kubernetes Engine service.
     * </pre>
     */
    public com.google.container.v1.ServerConfig getServerConfig(
        com.google.container.v1.GetServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServerConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the public component of the cluster signing keys in
     * JSON Web Key format.
     * This API is not yet intended for general use, and is not available for all
     * clusters.
     * </pre>
     */
    public com.google.container.v1.GetJSONWebKeysResponse getJSONWebKeys(
        com.google.container.v1.GetJSONWebKeysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJSONWebKeysMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the node pools for a cluster.
     * </pre>
     */
    public com.google.container.v1.ListNodePoolsResponse listNodePools(
        com.google.container.v1.ListNodePoolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNodePoolsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the requested node pool.
     * </pre>
     */
    public com.google.container.v1.NodePool getNodePool(
        com.google.container.v1.GetNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNodePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a node pool for a cluster.
     * </pre>
     */
    public com.google.container.v1.Operation createNodePool(
        com.google.container.v1.CreateNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNodePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a node pool from a cluster.
     * </pre>
     */
    public com.google.container.v1.Operation deleteNodePool(
        com.google.container.v1.DeleteNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNodePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * CompleteNodePoolUpgrade will signal an on-going node pool upgrade to
     * complete.
     * </pre>
     */
    public com.google.protobuf.Empty completeNodePoolUpgrade(
        com.google.container.v1.CompleteNodePoolUpgradeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompleteNodePoolUpgradeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a previously Aborted or Failed NodePool upgrade.
     * This makes no changes if the last upgrade successfully completed.
     * </pre>
     */
    public com.google.container.v1.Operation rollbackNodePoolUpgrade(
        com.google.container.v1.RollbackNodePoolUpgradeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackNodePoolUpgradeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the NodeManagement options for a node pool.
     * </pre>
     */
    public com.google.container.v1.Operation setNodePoolManagement(
        com.google.container.v1.SetNodePoolManagementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetNodePoolManagementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets labels on a cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setLabels(
        com.google.container.v1.SetLabelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetLabelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enables or disables the ABAC authorization mechanism on a cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setLegacyAbac(
        com.google.container.v1.SetLegacyAbacRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetLegacyAbacMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts master IP rotation.
     * </pre>
     */
    public com.google.container.v1.Operation startIPRotation(
        com.google.container.v1.StartIPRotationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartIPRotationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Completes master IP rotation.
     * </pre>
     */
    public com.google.container.v1.Operation completeIPRotation(
        com.google.container.v1.CompleteIPRotationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompleteIPRotationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the size for a specific node pool. The new size will be used for all
     * replicas, including future replicas created by modifying
     * [NodePool.locations][google.container.v1.NodePool.locations].
     * </pre>
     */
    public com.google.container.v1.Operation setNodePoolSize(
        com.google.container.v1.SetNodePoolSizeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetNodePoolSizeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enables or disables Network Policy for a cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setNetworkPolicy(
        com.google.container.v1.SetNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetNetworkPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the maintenance policy for a cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setMaintenancePolicy(
        com.google.container.v1.SetMaintenancePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetMaintenancePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists subnetworks that are usable for creating clusters in a project.
     * </pre>
     */
    public com.google.container.v1.ListUsableSubnetworksResponse listUsableSubnetworks(
        com.google.container.v1.ListUsableSubnetworksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUsableSubnetworksMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Google Kubernetes Engine Cluster Manager v1
   * </pre>
   */
  public static final class ClusterManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<ClusterManagerFutureStub> {
    private ClusterManagerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClusterManagerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all clusters owned by a project in either the specified zone or all
     * zones.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.container.v1.ListClustersResponse>
        listClusters(com.google.container.v1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Cluster>
        getCluster(com.google.container.v1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster, consisting of the specified number and type of Google
     * Compute Engine instances.
     * By default, the cluster is created in the project's
     * [default
     * network](https://cloud.google.com/compute/docs/networks-and-firewalls#networks).
     * One firewall is added for the cluster. After cluster creation,
     * the Kubelet creates routes for each node to allow the containers
     * on that node to communicate with all other instances in the
     * cluster.
     * Finally, an entry is added to the project's global metadata indicating
     * which CIDR range the cluster is using.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        createCluster(com.google.container.v1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        updateCluster(com.google.container.v1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the version and/or image type for the specified node pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        updateNodePool(com.google.container.v1.UpdateNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNodePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the autoscaling settings for the specified node pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        setNodePoolAutoscaling(com.google.container.v1.SetNodePoolAutoscalingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetNodePoolAutoscalingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the logging service for a specific cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        setLoggingService(com.google.container.v1.SetLoggingServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetLoggingServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the monitoring service for a specific cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        setMonitoringService(com.google.container.v1.SetMonitoringServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetMonitoringServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the addons for a specific cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        setAddonsConfig(com.google.container.v1.SetAddonsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetAddonsConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the locations for a specific cluster.
     * Deprecated. Use
     * [projects.locations.clusters.update](https://cloud.google.com/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters/update)
     * instead.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        setLocations(com.google.container.v1.SetLocationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetLocationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the master for a specific cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        updateMaster(com.google.container.v1.UpdateMasterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMasterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets master auth materials. Currently supports changing the admin password
     * or a specific cluster, either via password generation or explicitly setting
     * the password.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        setMasterAuth(com.google.container.v1.SetMasterAuthRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetMasterAuthMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the cluster, including the Kubernetes endpoint and all worker
     * nodes.
     * Firewalls and routes that were configured during cluster creation
     * are also deleted.
     * Other Google Compute Engine resources that might be in use by the cluster,
     * such as load balancer resources, are not deleted if they weren't present
     * when the cluster was initially created.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        deleteCluster(com.google.container.v1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all operations in a project in a specific zone or all zones.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.container.v1.ListOperationsResponse>
        listOperations(com.google.container.v1.ListOperationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOperationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        getOperation(com.google.container.v1.GetOperationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOperationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels the specified operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        cancelOperation(com.google.container.v1.CancelOperationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelOperationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns configuration info about the Google Kubernetes Engine service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.ServerConfig>
        getServerConfig(com.google.container.v1.GetServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServerConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the public component of the cluster signing keys in
     * JSON Web Key format.
     * This API is not yet intended for general use, and is not available for all
     * clusters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.container.v1.GetJSONWebKeysResponse>
        getJSONWebKeys(com.google.container.v1.GetJSONWebKeysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJSONWebKeysMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the node pools for a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.container.v1.ListNodePoolsResponse>
        listNodePools(com.google.container.v1.ListNodePoolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNodePoolsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the requested node pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.NodePool>
        getNodePool(com.google.container.v1.GetNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNodePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a node pool for a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        createNodePool(com.google.container.v1.CreateNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNodePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a node pool from a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        deleteNodePool(com.google.container.v1.DeleteNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNodePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * CompleteNodePoolUpgrade will signal an on-going node pool upgrade to
     * complete.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        completeNodePoolUpgrade(com.google.container.v1.CompleteNodePoolUpgradeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompleteNodePoolUpgradeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a previously Aborted or Failed NodePool upgrade.
     * This makes no changes if the last upgrade successfully completed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        rollbackNodePoolUpgrade(com.google.container.v1.RollbackNodePoolUpgradeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollbackNodePoolUpgradeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the NodeManagement options for a node pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        setNodePoolManagement(com.google.container.v1.SetNodePoolManagementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetNodePoolManagementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets labels on a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        setLabels(com.google.container.v1.SetLabelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetLabelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Enables or disables the ABAC authorization mechanism on a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        setLegacyAbac(com.google.container.v1.SetLegacyAbacRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetLegacyAbacMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts master IP rotation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        startIPRotation(com.google.container.v1.StartIPRotationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartIPRotationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Completes master IP rotation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        completeIPRotation(com.google.container.v1.CompleteIPRotationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompleteIPRotationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the size for a specific node pool. The new size will be used for all
     * replicas, including future replicas created by modifying
     * [NodePool.locations][google.container.v1.NodePool.locations].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        setNodePoolSize(com.google.container.v1.SetNodePoolSizeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetNodePoolSizeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Enables or disables Network Policy for a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        setNetworkPolicy(com.google.container.v1.SetNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetNetworkPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the maintenance policy for a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation>
        setMaintenancePolicy(com.google.container.v1.SetMaintenancePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetMaintenancePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists subnetworks that are usable for creating clusters in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.container.v1.ListUsableSubnetworksResponse>
        listUsableSubnetworks(com.google.container.v1.ListUsableSubnetworksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUsableSubnetworksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CLUSTERS = 0;
  private static final int METHODID_GET_CLUSTER = 1;
  private static final int METHODID_CREATE_CLUSTER = 2;
  private static final int METHODID_UPDATE_CLUSTER = 3;
  private static final int METHODID_UPDATE_NODE_POOL = 4;
  private static final int METHODID_SET_NODE_POOL_AUTOSCALING = 5;
  private static final int METHODID_SET_LOGGING_SERVICE = 6;
  private static final int METHODID_SET_MONITORING_SERVICE = 7;
  private static final int METHODID_SET_ADDONS_CONFIG = 8;
  private static final int METHODID_SET_LOCATIONS = 9;
  private static final int METHODID_UPDATE_MASTER = 10;
  private static final int METHODID_SET_MASTER_AUTH = 11;
  private static final int METHODID_DELETE_CLUSTER = 12;
  private static final int METHODID_LIST_OPERATIONS = 13;
  private static final int METHODID_GET_OPERATION = 14;
  private static final int METHODID_CANCEL_OPERATION = 15;
  private static final int METHODID_GET_SERVER_CONFIG = 16;
  private static final int METHODID_GET_JSONWEB_KEYS = 17;
  private static final int METHODID_LIST_NODE_POOLS = 18;
  private static final int METHODID_GET_NODE_POOL = 19;
  private static final int METHODID_CREATE_NODE_POOL = 20;
  private static final int METHODID_DELETE_NODE_POOL = 21;
  private static final int METHODID_COMPLETE_NODE_POOL_UPGRADE = 22;
  private static final int METHODID_ROLLBACK_NODE_POOL_UPGRADE = 23;
  private static final int METHODID_SET_NODE_POOL_MANAGEMENT = 24;
  private static final int METHODID_SET_LABELS = 25;
  private static final int METHODID_SET_LEGACY_ABAC = 26;
  private static final int METHODID_START_IPROTATION = 27;
  private static final int METHODID_COMPLETE_IPROTATION = 28;
  private static final int METHODID_SET_NODE_POOL_SIZE = 29;
  private static final int METHODID_SET_NETWORK_POLICY = 30;
  private static final int METHODID_SET_MAINTENANCE_POLICY = 31;
  private static final int METHODID_LIST_USABLE_SUBNETWORKS = 32;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClusterManagerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClusterManagerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters(
              (com.google.container.v1.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.ListClustersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster(
              (com.google.container.v1.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Cluster>) responseObserver);
          break;
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster(
              (com.google.container.v1.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster(
              (com.google.container.v1.UpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_NODE_POOL:
          serviceImpl.updateNodePool(
              (com.google.container.v1.UpdateNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_NODE_POOL_AUTOSCALING:
          serviceImpl.setNodePoolAutoscaling(
              (com.google.container.v1.SetNodePoolAutoscalingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_LOGGING_SERVICE:
          serviceImpl.setLoggingService(
              (com.google.container.v1.SetLoggingServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_MONITORING_SERVICE:
          serviceImpl.setMonitoringService(
              (com.google.container.v1.SetMonitoringServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_ADDONS_CONFIG:
          serviceImpl.setAddonsConfig(
              (com.google.container.v1.SetAddonsConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_LOCATIONS:
          serviceImpl.setLocations(
              (com.google.container.v1.SetLocationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MASTER:
          serviceImpl.updateMaster(
              (com.google.container.v1.UpdateMasterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_MASTER_AUTH:
          serviceImpl.setMasterAuth(
              (com.google.container.v1.SetMasterAuthRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster(
              (com.google.container.v1.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_LIST_OPERATIONS:
          serviceImpl.listOperations(
              (com.google.container.v1.ListOperationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.ListOperationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_OPERATION:
          serviceImpl.getOperation(
              (com.google.container.v1.GetOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_CANCEL_OPERATION:
          serviceImpl.cancelOperation(
              (com.google.container.v1.CancelOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_SERVER_CONFIG:
          serviceImpl.getServerConfig(
              (com.google.container.v1.GetServerConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.ServerConfig>) responseObserver);
          break;
        case METHODID_GET_JSONWEB_KEYS:
          serviceImpl.getJSONWebKeys(
              (com.google.container.v1.GetJSONWebKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.GetJSONWebKeysResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_NODE_POOLS:
          serviceImpl.listNodePools(
              (com.google.container.v1.ListNodePoolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.ListNodePoolsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_NODE_POOL:
          serviceImpl.getNodePool(
              (com.google.container.v1.GetNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.NodePool>) responseObserver);
          break;
        case METHODID_CREATE_NODE_POOL:
          serviceImpl.createNodePool(
              (com.google.container.v1.CreateNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_DELETE_NODE_POOL:
          serviceImpl.deleteNodePool(
              (com.google.container.v1.DeleteNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_COMPLETE_NODE_POOL_UPGRADE:
          serviceImpl.completeNodePoolUpgrade(
              (com.google.container.v1.CompleteNodePoolUpgradeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ROLLBACK_NODE_POOL_UPGRADE:
          serviceImpl.rollbackNodePoolUpgrade(
              (com.google.container.v1.RollbackNodePoolUpgradeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_NODE_POOL_MANAGEMENT:
          serviceImpl.setNodePoolManagement(
              (com.google.container.v1.SetNodePoolManagementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_LABELS:
          serviceImpl.setLabels(
              (com.google.container.v1.SetLabelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_LEGACY_ABAC:
          serviceImpl.setLegacyAbac(
              (com.google.container.v1.SetLegacyAbacRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_START_IPROTATION:
          serviceImpl.startIPRotation(
              (com.google.container.v1.StartIPRotationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_COMPLETE_IPROTATION:
          serviceImpl.completeIPRotation(
              (com.google.container.v1.CompleteIPRotationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_NODE_POOL_SIZE:
          serviceImpl.setNodePoolSize(
              (com.google.container.v1.SetNodePoolSizeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_NETWORK_POLICY:
          serviceImpl.setNetworkPolicy(
              (com.google.container.v1.SetNetworkPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_MAINTENANCE_POLICY:
          serviceImpl.setMaintenancePolicy(
              (com.google.container.v1.SetMaintenancePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_LIST_USABLE_SUBNETWORKS:
          serviceImpl.listUsableSubnetworks(
              (com.google.container.v1.ListUsableSubnetworksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.ListUsableSubnetworksResponse>)
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

  private abstract static class ClusterManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClusterManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.container.v1.ClusterServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClusterManager");
    }
  }

  private static final class ClusterManagerFileDescriptorSupplier
      extends ClusterManagerBaseDescriptorSupplier {
    ClusterManagerFileDescriptorSupplier() {}
  }

  private static final class ClusterManagerMethodDescriptorSupplier
      extends ClusterManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClusterManagerMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClusterManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ClusterManagerFileDescriptorSupplier())
                      .addMethod(getListClustersMethod())
                      .addMethod(getGetClusterMethod())
                      .addMethod(getCreateClusterMethod())
                      .addMethod(getUpdateClusterMethod())
                      .addMethod(getUpdateNodePoolMethod())
                      .addMethod(getSetNodePoolAutoscalingMethod())
                      .addMethod(getSetLoggingServiceMethod())
                      .addMethod(getSetMonitoringServiceMethod())
                      .addMethod(getSetAddonsConfigMethod())
                      .addMethod(getSetLocationsMethod())
                      .addMethod(getUpdateMasterMethod())
                      .addMethod(getSetMasterAuthMethod())
                      .addMethod(getDeleteClusterMethod())
                      .addMethod(getListOperationsMethod())
                      .addMethod(getGetOperationMethod())
                      .addMethod(getCancelOperationMethod())
                      .addMethod(getGetServerConfigMethod())
                      .addMethod(getGetJSONWebKeysMethod())
                      .addMethod(getListNodePoolsMethod())
                      .addMethod(getGetNodePoolMethod())
                      .addMethod(getCreateNodePoolMethod())
                      .addMethod(getDeleteNodePoolMethod())
                      .addMethod(getCompleteNodePoolUpgradeMethod())
                      .addMethod(getRollbackNodePoolUpgradeMethod())
                      .addMethod(getSetNodePoolManagementMethod())
                      .addMethod(getSetLabelsMethod())
                      .addMethod(getSetLegacyAbacMethod())
                      .addMethod(getStartIPRotationMethod())
                      .addMethod(getCompleteIPRotationMethod())
                      .addMethod(getSetNodePoolSizeMethod())
                      .addMethod(getSetNetworkPolicyMethod())
                      .addMethod(getSetMaintenancePolicyMethod())
                      .addMethod(getListUsableSubnetworksMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
