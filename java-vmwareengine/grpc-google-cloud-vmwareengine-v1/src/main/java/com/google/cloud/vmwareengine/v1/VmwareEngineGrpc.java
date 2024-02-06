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
package com.google.cloud.vmwareengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * VMwareEngine manages VMware's private clusters in the Cloud.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/vmwareengine/v1/vmwareengine.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VmwareEngineGrpc {

  private VmwareEngineGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.vmwareengine.v1.VmwareEngine";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest,
          com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse>
      getListPrivateCloudsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPrivateClouds",
      requestType = com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest,
          com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse>
      getListPrivateCloudsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest,
            com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse>
        getListPrivateCloudsMethod;
    if ((getListPrivateCloudsMethod = VmwareEngineGrpc.getListPrivateCloudsMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListPrivateCloudsMethod = VmwareEngineGrpc.getListPrivateCloudsMethod) == null) {
          VmwareEngineGrpc.getListPrivateCloudsMethod =
              getListPrivateCloudsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest,
                          com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPrivateClouds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ListPrivateClouds"))
                      .build();
        }
      }
    }
    return getListPrivateCloudsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest,
          com.google.cloud.vmwareengine.v1.PrivateCloud>
      getGetPrivateCloudMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPrivateCloud",
      requestType = com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.PrivateCloud.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest,
          com.google.cloud.vmwareengine.v1.PrivateCloud>
      getGetPrivateCloudMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest,
            com.google.cloud.vmwareengine.v1.PrivateCloud>
        getGetPrivateCloudMethod;
    if ((getGetPrivateCloudMethod = VmwareEngineGrpc.getGetPrivateCloudMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetPrivateCloudMethod = VmwareEngineGrpc.getGetPrivateCloudMethod) == null) {
          VmwareEngineGrpc.getGetPrivateCloudMethod =
              getGetPrivateCloudMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest,
                          com.google.cloud.vmwareengine.v1.PrivateCloud>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPrivateCloud"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.PrivateCloud.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("GetPrivateCloud"))
                      .build();
        }
      }
    }
    return getGetPrivateCloudMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest,
          com.google.longrunning.Operation>
      getCreatePrivateCloudMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePrivateCloud",
      requestType = com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest,
          com.google.longrunning.Operation>
      getCreatePrivateCloudMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest,
            com.google.longrunning.Operation>
        getCreatePrivateCloudMethod;
    if ((getCreatePrivateCloudMethod = VmwareEngineGrpc.getCreatePrivateCloudMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreatePrivateCloudMethod = VmwareEngineGrpc.getCreatePrivateCloudMethod) == null) {
          VmwareEngineGrpc.getCreatePrivateCloudMethod =
              getCreatePrivateCloudMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePrivateCloud"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("CreatePrivateCloud"))
                      .build();
        }
      }
    }
    return getCreatePrivateCloudMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest,
          com.google.longrunning.Operation>
      getUpdatePrivateCloudMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePrivateCloud",
      requestType = com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest,
          com.google.longrunning.Operation>
      getUpdatePrivateCloudMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest,
            com.google.longrunning.Operation>
        getUpdatePrivateCloudMethod;
    if ((getUpdatePrivateCloudMethod = VmwareEngineGrpc.getUpdatePrivateCloudMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdatePrivateCloudMethod = VmwareEngineGrpc.getUpdatePrivateCloudMethod) == null) {
          VmwareEngineGrpc.getUpdatePrivateCloudMethod =
              getUpdatePrivateCloudMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePrivateCloud"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("UpdatePrivateCloud"))
                      .build();
        }
      }
    }
    return getUpdatePrivateCloudMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest,
          com.google.longrunning.Operation>
      getDeletePrivateCloudMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePrivateCloud",
      requestType = com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest,
          com.google.longrunning.Operation>
      getDeletePrivateCloudMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest,
            com.google.longrunning.Operation>
        getDeletePrivateCloudMethod;
    if ((getDeletePrivateCloudMethod = VmwareEngineGrpc.getDeletePrivateCloudMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeletePrivateCloudMethod = VmwareEngineGrpc.getDeletePrivateCloudMethod) == null) {
          VmwareEngineGrpc.getDeletePrivateCloudMethod =
              getDeletePrivateCloudMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePrivateCloud"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("DeletePrivateCloud"))
                      .build();
        }
      }
    }
    return getDeletePrivateCloudMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest,
          com.google.longrunning.Operation>
      getUndeletePrivateCloudMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeletePrivateCloud",
      requestType = com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest,
          com.google.longrunning.Operation>
      getUndeletePrivateCloudMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest,
            com.google.longrunning.Operation>
        getUndeletePrivateCloudMethod;
    if ((getUndeletePrivateCloudMethod = VmwareEngineGrpc.getUndeletePrivateCloudMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUndeletePrivateCloudMethod = VmwareEngineGrpc.getUndeletePrivateCloudMethod)
            == null) {
          VmwareEngineGrpc.getUndeletePrivateCloudMethod =
              getUndeletePrivateCloudMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UndeletePrivateCloud"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("UndeletePrivateCloud"))
                      .build();
        }
      }
    }
    return getUndeletePrivateCloudMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListClustersRequest,
          com.google.cloud.vmwareengine.v1.ListClustersResponse>
      getListClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClusters",
      requestType = com.google.cloud.vmwareengine.v1.ListClustersRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListClustersRequest,
          com.google.cloud.vmwareengine.v1.ListClustersResponse>
      getListClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListClustersRequest,
            com.google.cloud.vmwareengine.v1.ListClustersResponse>
        getListClustersMethod;
    if ((getListClustersMethod = VmwareEngineGrpc.getListClustersMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListClustersMethod = VmwareEngineGrpc.getListClustersMethod) == null) {
          VmwareEngineGrpc.getListClustersMethod =
              getListClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListClustersRequest,
                          com.google.cloud.vmwareengine.v1.ListClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ListClusters"))
                      .build();
        }
      }
    }
    return getListClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetClusterRequest,
          com.google.cloud.vmwareengine.v1.Cluster>
      getGetClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCluster",
      requestType = com.google.cloud.vmwareengine.v1.GetClusterRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.Cluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetClusterRequest,
          com.google.cloud.vmwareengine.v1.Cluster>
      getGetClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetClusterRequest,
            com.google.cloud.vmwareengine.v1.Cluster>
        getGetClusterMethod;
    if ((getGetClusterMethod = VmwareEngineGrpc.getGetClusterMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetClusterMethod = VmwareEngineGrpc.getGetClusterMethod) == null) {
          VmwareEngineGrpc.getGetClusterMethod =
              getGetClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetClusterRequest,
                          com.google.cloud.vmwareengine.v1.Cluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.Cluster.getDefaultInstance()))
                      .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("GetCluster"))
                      .build();
        }
      }
    }
    return getGetClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCluster",
      requestType = com.google.cloud.vmwareengine.v1.CreateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.CreateClusterRequest, com.google.longrunning.Operation>
        getCreateClusterMethod;
    if ((getCreateClusterMethod = VmwareEngineGrpc.getCreateClusterMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreateClusterMethod = VmwareEngineGrpc.getCreateClusterMethod) == null) {
          VmwareEngineGrpc.getCreateClusterMethod =
              getCreateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.CreateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.CreateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("CreateCluster"))
                      .build();
        }
      }
    }
    return getCreateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateClusterRequest, com.google.longrunning.Operation>
      getUpdateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCluster",
      requestType = com.google.cloud.vmwareengine.v1.UpdateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateClusterRequest, com.google.longrunning.Operation>
      getUpdateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.UpdateClusterRequest, com.google.longrunning.Operation>
        getUpdateClusterMethod;
    if ((getUpdateClusterMethod = VmwareEngineGrpc.getUpdateClusterMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdateClusterMethod = VmwareEngineGrpc.getUpdateClusterMethod) == null) {
          VmwareEngineGrpc.getUpdateClusterMethod =
              getUpdateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.UpdateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.UpdateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("UpdateCluster"))
                      .build();
        }
      }
    }
    return getUpdateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteClusterRequest, com.google.longrunning.Operation>
      getDeleteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCluster",
      requestType = com.google.cloud.vmwareengine.v1.DeleteClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteClusterRequest, com.google.longrunning.Operation>
      getDeleteClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.DeleteClusterRequest, com.google.longrunning.Operation>
        getDeleteClusterMethod;
    if ((getDeleteClusterMethod = VmwareEngineGrpc.getDeleteClusterMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeleteClusterMethod = VmwareEngineGrpc.getDeleteClusterMethod) == null) {
          VmwareEngineGrpc.getDeleteClusterMethod =
              getDeleteClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.DeleteClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.DeleteClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("DeleteCluster"))
                      .build();
        }
      }
    }
    return getDeleteClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListNodesRequest,
          com.google.cloud.vmwareengine.v1.ListNodesResponse>
      getListNodesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNodes",
      requestType = com.google.cloud.vmwareengine.v1.ListNodesRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListNodesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListNodesRequest,
          com.google.cloud.vmwareengine.v1.ListNodesResponse>
      getListNodesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListNodesRequest,
            com.google.cloud.vmwareengine.v1.ListNodesResponse>
        getListNodesMethod;
    if ((getListNodesMethod = VmwareEngineGrpc.getListNodesMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListNodesMethod = VmwareEngineGrpc.getListNodesMethod) == null) {
          VmwareEngineGrpc.getListNodesMethod =
              getListNodesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListNodesRequest,
                          com.google.cloud.vmwareengine.v1.ListNodesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNodes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListNodesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListNodesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ListNodes"))
                      .build();
        }
      }
    }
    return getListNodesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetNodeRequest, com.google.cloud.vmwareengine.v1.Node>
      getGetNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNode",
      requestType = com.google.cloud.vmwareengine.v1.GetNodeRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.Node.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetNodeRequest, com.google.cloud.vmwareengine.v1.Node>
      getGetNodeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetNodeRequest, com.google.cloud.vmwareengine.v1.Node>
        getGetNodeMethod;
    if ((getGetNodeMethod = VmwareEngineGrpc.getGetNodeMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetNodeMethod = VmwareEngineGrpc.getGetNodeMethod) == null) {
          VmwareEngineGrpc.getGetNodeMethod =
              getGetNodeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetNodeRequest,
                          com.google.cloud.vmwareengine.v1.Node>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNode"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetNodeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.Node.getDefaultInstance()))
                      .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("GetNode"))
                      .build();
        }
      }
    }
    return getGetNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest,
          com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse>
      getListExternalAddressesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExternalAddresses",
      requestType = com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest,
          com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse>
      getListExternalAddressesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest,
            com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse>
        getListExternalAddressesMethod;
    if ((getListExternalAddressesMethod = VmwareEngineGrpc.getListExternalAddressesMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListExternalAddressesMethod = VmwareEngineGrpc.getListExternalAddressesMethod)
            == null) {
          VmwareEngineGrpc.getListExternalAddressesMethod =
              getListExternalAddressesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest,
                          com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListExternalAddresses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ListExternalAddresses"))
                      .build();
        }
      }
    }
    return getListExternalAddressesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesRequest,
          com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesResponse>
      getFetchNetworkPolicyExternalAddressesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchNetworkPolicyExternalAddresses",
      requestType =
          com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesRequest.class,
      responseType =
          com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesRequest,
          com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesResponse>
      getFetchNetworkPolicyExternalAddressesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesRequest,
            com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesResponse>
        getFetchNetworkPolicyExternalAddressesMethod;
    if ((getFetchNetworkPolicyExternalAddressesMethod =
            VmwareEngineGrpc.getFetchNetworkPolicyExternalAddressesMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getFetchNetworkPolicyExternalAddressesMethod =
                VmwareEngineGrpc.getFetchNetworkPolicyExternalAddressesMethod)
            == null) {
          VmwareEngineGrpc.getFetchNetworkPolicyExternalAddressesMethod =
              getFetchNetworkPolicyExternalAddressesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesRequest,
                          com.google.cloud.vmwareengine.v1
                              .FetchNetworkPolicyExternalAddressesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "FetchNetworkPolicyExternalAddresses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1
                                  .FetchNetworkPolicyExternalAddressesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1
                                  .FetchNetworkPolicyExternalAddressesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier(
                              "FetchNetworkPolicyExternalAddresses"))
                      .build();
        }
      }
    }
    return getFetchNetworkPolicyExternalAddressesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetExternalAddressRequest,
          com.google.cloud.vmwareengine.v1.ExternalAddress>
      getGetExternalAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExternalAddress",
      requestType = com.google.cloud.vmwareengine.v1.GetExternalAddressRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ExternalAddress.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetExternalAddressRequest,
          com.google.cloud.vmwareengine.v1.ExternalAddress>
      getGetExternalAddressMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetExternalAddressRequest,
            com.google.cloud.vmwareengine.v1.ExternalAddress>
        getGetExternalAddressMethod;
    if ((getGetExternalAddressMethod = VmwareEngineGrpc.getGetExternalAddressMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetExternalAddressMethod = VmwareEngineGrpc.getGetExternalAddressMethod) == null) {
          VmwareEngineGrpc.getGetExternalAddressMethod =
              getGetExternalAddressMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetExternalAddressRequest,
                          com.google.cloud.vmwareengine.v1.ExternalAddress>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExternalAddress"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetExternalAddressRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ExternalAddress
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("GetExternalAddress"))
                      .build();
        }
      }
    }
    return getGetExternalAddressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest,
          com.google.longrunning.Operation>
      getCreateExternalAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExternalAddress",
      requestType = com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest,
          com.google.longrunning.Operation>
      getCreateExternalAddressMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest,
            com.google.longrunning.Operation>
        getCreateExternalAddressMethod;
    if ((getCreateExternalAddressMethod = VmwareEngineGrpc.getCreateExternalAddressMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreateExternalAddressMethod = VmwareEngineGrpc.getCreateExternalAddressMethod)
            == null) {
          VmwareEngineGrpc.getCreateExternalAddressMethod =
              getCreateExternalAddressMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateExternalAddress"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("CreateExternalAddress"))
                      .build();
        }
      }
    }
    return getCreateExternalAddressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest,
          com.google.longrunning.Operation>
      getUpdateExternalAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExternalAddress",
      requestType = com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest,
          com.google.longrunning.Operation>
      getUpdateExternalAddressMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest,
            com.google.longrunning.Operation>
        getUpdateExternalAddressMethod;
    if ((getUpdateExternalAddressMethod = VmwareEngineGrpc.getUpdateExternalAddressMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdateExternalAddressMethod = VmwareEngineGrpc.getUpdateExternalAddressMethod)
            == null) {
          VmwareEngineGrpc.getUpdateExternalAddressMethod =
              getUpdateExternalAddressMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateExternalAddress"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("UpdateExternalAddress"))
                      .build();
        }
      }
    }
    return getUpdateExternalAddressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest,
          com.google.longrunning.Operation>
      getDeleteExternalAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExternalAddress",
      requestType = com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest,
          com.google.longrunning.Operation>
      getDeleteExternalAddressMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest,
            com.google.longrunning.Operation>
        getDeleteExternalAddressMethod;
    if ((getDeleteExternalAddressMethod = VmwareEngineGrpc.getDeleteExternalAddressMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeleteExternalAddressMethod = VmwareEngineGrpc.getDeleteExternalAddressMethod)
            == null) {
          VmwareEngineGrpc.getDeleteExternalAddressMethod =
              getDeleteExternalAddressMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteExternalAddress"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("DeleteExternalAddress"))
                      .build();
        }
      }
    }
    return getDeleteExternalAddressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListSubnetsRequest,
          com.google.cloud.vmwareengine.v1.ListSubnetsResponse>
      getListSubnetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubnets",
      requestType = com.google.cloud.vmwareengine.v1.ListSubnetsRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListSubnetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListSubnetsRequest,
          com.google.cloud.vmwareengine.v1.ListSubnetsResponse>
      getListSubnetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListSubnetsRequest,
            com.google.cloud.vmwareengine.v1.ListSubnetsResponse>
        getListSubnetsMethod;
    if ((getListSubnetsMethod = VmwareEngineGrpc.getListSubnetsMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListSubnetsMethod = VmwareEngineGrpc.getListSubnetsMethod) == null) {
          VmwareEngineGrpc.getListSubnetsMethod =
              getListSubnetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListSubnetsRequest,
                          com.google.cloud.vmwareengine.v1.ListSubnetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSubnets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListSubnetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListSubnetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ListSubnets"))
                      .build();
        }
      }
    }
    return getListSubnetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetSubnetRequest,
          com.google.cloud.vmwareengine.v1.Subnet>
      getGetSubnetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubnet",
      requestType = com.google.cloud.vmwareengine.v1.GetSubnetRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.Subnet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetSubnetRequest,
          com.google.cloud.vmwareengine.v1.Subnet>
      getGetSubnetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetSubnetRequest,
            com.google.cloud.vmwareengine.v1.Subnet>
        getGetSubnetMethod;
    if ((getGetSubnetMethod = VmwareEngineGrpc.getGetSubnetMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetSubnetMethod = VmwareEngineGrpc.getGetSubnetMethod) == null) {
          VmwareEngineGrpc.getGetSubnetMethod =
              getGetSubnetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetSubnetRequest,
                          com.google.cloud.vmwareengine.v1.Subnet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSubnet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetSubnetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.Subnet.getDefaultInstance()))
                      .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("GetSubnet"))
                      .build();
        }
      }
    }
    return getGetSubnetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateSubnetRequest, com.google.longrunning.Operation>
      getUpdateSubnetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSubnet",
      requestType = com.google.cloud.vmwareengine.v1.UpdateSubnetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateSubnetRequest, com.google.longrunning.Operation>
      getUpdateSubnetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.UpdateSubnetRequest, com.google.longrunning.Operation>
        getUpdateSubnetMethod;
    if ((getUpdateSubnetMethod = VmwareEngineGrpc.getUpdateSubnetMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdateSubnetMethod = VmwareEngineGrpc.getUpdateSubnetMethod) == null) {
          VmwareEngineGrpc.getUpdateSubnetMethod =
              getUpdateSubnetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.UpdateSubnetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSubnet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.UpdateSubnetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("UpdateSubnet"))
                      .build();
        }
      }
    }
    return getUpdateSubnetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest,
          com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse>
      getListExternalAccessRulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExternalAccessRules",
      requestType = com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest,
          com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse>
      getListExternalAccessRulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest,
            com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse>
        getListExternalAccessRulesMethod;
    if ((getListExternalAccessRulesMethod = VmwareEngineGrpc.getListExternalAccessRulesMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListExternalAccessRulesMethod = VmwareEngineGrpc.getListExternalAccessRulesMethod)
            == null) {
          VmwareEngineGrpc.getListExternalAccessRulesMethod =
              getListExternalAccessRulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest,
                          com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListExternalAccessRules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ListExternalAccessRules"))
                      .build();
        }
      }
    }
    return getListExternalAccessRulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest,
          com.google.cloud.vmwareengine.v1.ExternalAccessRule>
      getGetExternalAccessRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExternalAccessRule",
      requestType = com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ExternalAccessRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest,
          com.google.cloud.vmwareengine.v1.ExternalAccessRule>
      getGetExternalAccessRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest,
            com.google.cloud.vmwareengine.v1.ExternalAccessRule>
        getGetExternalAccessRuleMethod;
    if ((getGetExternalAccessRuleMethod = VmwareEngineGrpc.getGetExternalAccessRuleMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetExternalAccessRuleMethod = VmwareEngineGrpc.getGetExternalAccessRuleMethod)
            == null) {
          VmwareEngineGrpc.getGetExternalAccessRuleMethod =
              getGetExternalAccessRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest,
                          com.google.cloud.vmwareengine.v1.ExternalAccessRule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetExternalAccessRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ExternalAccessRule
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("GetExternalAccessRule"))
                      .build();
        }
      }
    }
    return getGetExternalAccessRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest,
          com.google.longrunning.Operation>
      getCreateExternalAccessRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExternalAccessRule",
      requestType = com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest,
          com.google.longrunning.Operation>
      getCreateExternalAccessRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest,
            com.google.longrunning.Operation>
        getCreateExternalAccessRuleMethod;
    if ((getCreateExternalAccessRuleMethod = VmwareEngineGrpc.getCreateExternalAccessRuleMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreateExternalAccessRuleMethod = VmwareEngineGrpc.getCreateExternalAccessRuleMethod)
            == null) {
          VmwareEngineGrpc.getCreateExternalAccessRuleMethod =
              getCreateExternalAccessRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateExternalAccessRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("CreateExternalAccessRule"))
                      .build();
        }
      }
    }
    return getCreateExternalAccessRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest,
          com.google.longrunning.Operation>
      getUpdateExternalAccessRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExternalAccessRule",
      requestType = com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest,
          com.google.longrunning.Operation>
      getUpdateExternalAccessRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest,
            com.google.longrunning.Operation>
        getUpdateExternalAccessRuleMethod;
    if ((getUpdateExternalAccessRuleMethod = VmwareEngineGrpc.getUpdateExternalAccessRuleMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdateExternalAccessRuleMethod = VmwareEngineGrpc.getUpdateExternalAccessRuleMethod)
            == null) {
          VmwareEngineGrpc.getUpdateExternalAccessRuleMethod =
              getUpdateExternalAccessRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateExternalAccessRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("UpdateExternalAccessRule"))
                      .build();
        }
      }
    }
    return getUpdateExternalAccessRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest,
          com.google.longrunning.Operation>
      getDeleteExternalAccessRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExternalAccessRule",
      requestType = com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest,
          com.google.longrunning.Operation>
      getDeleteExternalAccessRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest,
            com.google.longrunning.Operation>
        getDeleteExternalAccessRuleMethod;
    if ((getDeleteExternalAccessRuleMethod = VmwareEngineGrpc.getDeleteExternalAccessRuleMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeleteExternalAccessRuleMethod = VmwareEngineGrpc.getDeleteExternalAccessRuleMethod)
            == null) {
          VmwareEngineGrpc.getDeleteExternalAccessRuleMethod =
              getDeleteExternalAccessRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteExternalAccessRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("DeleteExternalAccessRule"))
                      .build();
        }
      }
    }
    return getDeleteExternalAccessRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListLoggingServersRequest,
          com.google.cloud.vmwareengine.v1.ListLoggingServersResponse>
      getListLoggingServersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLoggingServers",
      requestType = com.google.cloud.vmwareengine.v1.ListLoggingServersRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListLoggingServersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListLoggingServersRequest,
          com.google.cloud.vmwareengine.v1.ListLoggingServersResponse>
      getListLoggingServersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListLoggingServersRequest,
            com.google.cloud.vmwareengine.v1.ListLoggingServersResponse>
        getListLoggingServersMethod;
    if ((getListLoggingServersMethod = VmwareEngineGrpc.getListLoggingServersMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListLoggingServersMethod = VmwareEngineGrpc.getListLoggingServersMethod) == null) {
          VmwareEngineGrpc.getListLoggingServersMethod =
              getListLoggingServersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListLoggingServersRequest,
                          com.google.cloud.vmwareengine.v1.ListLoggingServersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLoggingServers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListLoggingServersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListLoggingServersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ListLoggingServers"))
                      .build();
        }
      }
    }
    return getListLoggingServersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetLoggingServerRequest,
          com.google.cloud.vmwareengine.v1.LoggingServer>
      getGetLoggingServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLoggingServer",
      requestType = com.google.cloud.vmwareengine.v1.GetLoggingServerRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.LoggingServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetLoggingServerRequest,
          com.google.cloud.vmwareengine.v1.LoggingServer>
      getGetLoggingServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetLoggingServerRequest,
            com.google.cloud.vmwareengine.v1.LoggingServer>
        getGetLoggingServerMethod;
    if ((getGetLoggingServerMethod = VmwareEngineGrpc.getGetLoggingServerMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetLoggingServerMethod = VmwareEngineGrpc.getGetLoggingServerMethod) == null) {
          VmwareEngineGrpc.getGetLoggingServerMethod =
              getGetLoggingServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetLoggingServerRequest,
                          com.google.cloud.vmwareengine.v1.LoggingServer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLoggingServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetLoggingServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.LoggingServer.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("GetLoggingServer"))
                      .build();
        }
      }
    }
    return getGetLoggingServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest,
          com.google.longrunning.Operation>
      getCreateLoggingServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLoggingServer",
      requestType = com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest,
          com.google.longrunning.Operation>
      getCreateLoggingServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest,
            com.google.longrunning.Operation>
        getCreateLoggingServerMethod;
    if ((getCreateLoggingServerMethod = VmwareEngineGrpc.getCreateLoggingServerMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreateLoggingServerMethod = VmwareEngineGrpc.getCreateLoggingServerMethod)
            == null) {
          VmwareEngineGrpc.getCreateLoggingServerMethod =
              getCreateLoggingServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateLoggingServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("CreateLoggingServer"))
                      .build();
        }
      }
    }
    return getCreateLoggingServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest,
          com.google.longrunning.Operation>
      getUpdateLoggingServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateLoggingServer",
      requestType = com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest,
          com.google.longrunning.Operation>
      getUpdateLoggingServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest,
            com.google.longrunning.Operation>
        getUpdateLoggingServerMethod;
    if ((getUpdateLoggingServerMethod = VmwareEngineGrpc.getUpdateLoggingServerMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdateLoggingServerMethod = VmwareEngineGrpc.getUpdateLoggingServerMethod)
            == null) {
          VmwareEngineGrpc.getUpdateLoggingServerMethod =
              getUpdateLoggingServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateLoggingServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("UpdateLoggingServer"))
                      .build();
        }
      }
    }
    return getUpdateLoggingServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest,
          com.google.longrunning.Operation>
      getDeleteLoggingServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLoggingServer",
      requestType = com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest,
          com.google.longrunning.Operation>
      getDeleteLoggingServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest,
            com.google.longrunning.Operation>
        getDeleteLoggingServerMethod;
    if ((getDeleteLoggingServerMethod = VmwareEngineGrpc.getDeleteLoggingServerMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeleteLoggingServerMethod = VmwareEngineGrpc.getDeleteLoggingServerMethod)
            == null) {
          VmwareEngineGrpc.getDeleteLoggingServerMethod =
              getDeleteLoggingServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteLoggingServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("DeleteLoggingServer"))
                      .build();
        }
      }
    }
    return getDeleteLoggingServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListNodeTypesRequest,
          com.google.cloud.vmwareengine.v1.ListNodeTypesResponse>
      getListNodeTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNodeTypes",
      requestType = com.google.cloud.vmwareengine.v1.ListNodeTypesRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListNodeTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListNodeTypesRequest,
          com.google.cloud.vmwareengine.v1.ListNodeTypesResponse>
      getListNodeTypesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListNodeTypesRequest,
            com.google.cloud.vmwareengine.v1.ListNodeTypesResponse>
        getListNodeTypesMethod;
    if ((getListNodeTypesMethod = VmwareEngineGrpc.getListNodeTypesMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListNodeTypesMethod = VmwareEngineGrpc.getListNodeTypesMethod) == null) {
          VmwareEngineGrpc.getListNodeTypesMethod =
              getListNodeTypesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListNodeTypesRequest,
                          com.google.cloud.vmwareengine.v1.ListNodeTypesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNodeTypes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListNodeTypesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListNodeTypesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ListNodeTypes"))
                      .build();
        }
      }
    }
    return getListNodeTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetNodeTypeRequest,
          com.google.cloud.vmwareengine.v1.NodeType>
      getGetNodeTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNodeType",
      requestType = com.google.cloud.vmwareengine.v1.GetNodeTypeRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.NodeType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetNodeTypeRequest,
          com.google.cloud.vmwareengine.v1.NodeType>
      getGetNodeTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetNodeTypeRequest,
            com.google.cloud.vmwareengine.v1.NodeType>
        getGetNodeTypeMethod;
    if ((getGetNodeTypeMethod = VmwareEngineGrpc.getGetNodeTypeMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetNodeTypeMethod = VmwareEngineGrpc.getGetNodeTypeMethod) == null) {
          VmwareEngineGrpc.getGetNodeTypeMethod =
              getGetNodeTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetNodeTypeRequest,
                          com.google.cloud.vmwareengine.v1.NodeType>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNodeType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetNodeTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.NodeType.getDefaultInstance()))
                      .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("GetNodeType"))
                      .build();
        }
      }
    }
    return getGetNodeTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest,
          com.google.cloud.vmwareengine.v1.Credentials>
      getShowNsxCredentialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ShowNsxCredentials",
      requestType = com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.Credentials.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest,
          com.google.cloud.vmwareengine.v1.Credentials>
      getShowNsxCredentialsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest,
            com.google.cloud.vmwareengine.v1.Credentials>
        getShowNsxCredentialsMethod;
    if ((getShowNsxCredentialsMethod = VmwareEngineGrpc.getShowNsxCredentialsMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getShowNsxCredentialsMethod = VmwareEngineGrpc.getShowNsxCredentialsMethod) == null) {
          VmwareEngineGrpc.getShowNsxCredentialsMethod =
              getShowNsxCredentialsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest,
                          com.google.cloud.vmwareengine.v1.Credentials>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ShowNsxCredentials"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.Credentials.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ShowNsxCredentials"))
                      .build();
        }
      }
    }
    return getShowNsxCredentialsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest,
          com.google.cloud.vmwareengine.v1.Credentials>
      getShowVcenterCredentialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ShowVcenterCredentials",
      requestType = com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.Credentials.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest,
          com.google.cloud.vmwareengine.v1.Credentials>
      getShowVcenterCredentialsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest,
            com.google.cloud.vmwareengine.v1.Credentials>
        getShowVcenterCredentialsMethod;
    if ((getShowVcenterCredentialsMethod = VmwareEngineGrpc.getShowVcenterCredentialsMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getShowVcenterCredentialsMethod = VmwareEngineGrpc.getShowVcenterCredentialsMethod)
            == null) {
          VmwareEngineGrpc.getShowVcenterCredentialsMethod =
              getShowVcenterCredentialsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest,
                          com.google.cloud.vmwareengine.v1.Credentials>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ShowVcenterCredentials"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.Credentials.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ShowVcenterCredentials"))
                      .build();
        }
      }
    }
    return getShowVcenterCredentialsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest,
          com.google.longrunning.Operation>
      getResetNsxCredentialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetNsxCredentials",
      requestType = com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest,
          com.google.longrunning.Operation>
      getResetNsxCredentialsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest,
            com.google.longrunning.Operation>
        getResetNsxCredentialsMethod;
    if ((getResetNsxCredentialsMethod = VmwareEngineGrpc.getResetNsxCredentialsMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getResetNsxCredentialsMethod = VmwareEngineGrpc.getResetNsxCredentialsMethod)
            == null) {
          VmwareEngineGrpc.getResetNsxCredentialsMethod =
              getResetNsxCredentialsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ResetNsxCredentials"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ResetNsxCredentials"))
                      .build();
        }
      }
    }
    return getResetNsxCredentialsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest,
          com.google.longrunning.Operation>
      getResetVcenterCredentialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetVcenterCredentials",
      requestType = com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest,
          com.google.longrunning.Operation>
      getResetVcenterCredentialsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest,
            com.google.longrunning.Operation>
        getResetVcenterCredentialsMethod;
    if ((getResetVcenterCredentialsMethod = VmwareEngineGrpc.getResetVcenterCredentialsMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getResetVcenterCredentialsMethod = VmwareEngineGrpc.getResetVcenterCredentialsMethod)
            == null) {
          VmwareEngineGrpc.getResetVcenterCredentialsMethod =
              getResetVcenterCredentialsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ResetVcenterCredentials"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ResetVcenterCredentials"))
                      .build();
        }
      }
    }
    return getResetVcenterCredentialsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest,
          com.google.cloud.vmwareengine.v1.DnsForwarding>
      getGetDnsForwardingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDnsForwarding",
      requestType = com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.DnsForwarding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest,
          com.google.cloud.vmwareengine.v1.DnsForwarding>
      getGetDnsForwardingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest,
            com.google.cloud.vmwareengine.v1.DnsForwarding>
        getGetDnsForwardingMethod;
    if ((getGetDnsForwardingMethod = VmwareEngineGrpc.getGetDnsForwardingMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetDnsForwardingMethod = VmwareEngineGrpc.getGetDnsForwardingMethod) == null) {
          VmwareEngineGrpc.getGetDnsForwardingMethod =
              getGetDnsForwardingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest,
                          com.google.cloud.vmwareengine.v1.DnsForwarding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDnsForwarding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.DnsForwarding.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("GetDnsForwarding"))
                      .build();
        }
      }
    }
    return getGetDnsForwardingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest,
          com.google.longrunning.Operation>
      getUpdateDnsForwardingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDnsForwarding",
      requestType = com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest,
          com.google.longrunning.Operation>
      getUpdateDnsForwardingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest,
            com.google.longrunning.Operation>
        getUpdateDnsForwardingMethod;
    if ((getUpdateDnsForwardingMethod = VmwareEngineGrpc.getUpdateDnsForwardingMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdateDnsForwardingMethod = VmwareEngineGrpc.getUpdateDnsForwardingMethod)
            == null) {
          VmwareEngineGrpc.getUpdateDnsForwardingMethod =
              getUpdateDnsForwardingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDnsForwarding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("UpdateDnsForwarding"))
                      .build();
        }
      }
    }
    return getUpdateDnsForwardingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest,
          com.google.cloud.vmwareengine.v1.NetworkPeering>
      getGetNetworkPeeringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNetworkPeering",
      requestType = com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.NetworkPeering.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest,
          com.google.cloud.vmwareengine.v1.NetworkPeering>
      getGetNetworkPeeringMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest,
            com.google.cloud.vmwareengine.v1.NetworkPeering>
        getGetNetworkPeeringMethod;
    if ((getGetNetworkPeeringMethod = VmwareEngineGrpc.getGetNetworkPeeringMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetNetworkPeeringMethod = VmwareEngineGrpc.getGetNetworkPeeringMethod) == null) {
          VmwareEngineGrpc.getGetNetworkPeeringMethod =
              getGetNetworkPeeringMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest,
                          com.google.cloud.vmwareengine.v1.NetworkPeering>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNetworkPeering"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.NetworkPeering.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("GetNetworkPeering"))
                      .build();
        }
      }
    }
    return getGetNetworkPeeringMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest,
          com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse>
      getListNetworkPeeringsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNetworkPeerings",
      requestType = com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest,
          com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse>
      getListNetworkPeeringsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest,
            com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse>
        getListNetworkPeeringsMethod;
    if ((getListNetworkPeeringsMethod = VmwareEngineGrpc.getListNetworkPeeringsMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListNetworkPeeringsMethod = VmwareEngineGrpc.getListNetworkPeeringsMethod)
            == null) {
          VmwareEngineGrpc.getListNetworkPeeringsMethod =
              getListNetworkPeeringsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest,
                          com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListNetworkPeerings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ListNetworkPeerings"))
                      .build();
        }
      }
    }
    return getListNetworkPeeringsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest,
          com.google.longrunning.Operation>
      getCreateNetworkPeeringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNetworkPeering",
      requestType = com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest,
          com.google.longrunning.Operation>
      getCreateNetworkPeeringMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest,
            com.google.longrunning.Operation>
        getCreateNetworkPeeringMethod;
    if ((getCreateNetworkPeeringMethod = VmwareEngineGrpc.getCreateNetworkPeeringMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreateNetworkPeeringMethod = VmwareEngineGrpc.getCreateNetworkPeeringMethod)
            == null) {
          VmwareEngineGrpc.getCreateNetworkPeeringMethod =
              getCreateNetworkPeeringMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateNetworkPeering"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("CreateNetworkPeering"))
                      .build();
        }
      }
    }
    return getCreateNetworkPeeringMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest,
          com.google.longrunning.Operation>
      getDeleteNetworkPeeringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNetworkPeering",
      requestType = com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest,
          com.google.longrunning.Operation>
      getDeleteNetworkPeeringMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest,
            com.google.longrunning.Operation>
        getDeleteNetworkPeeringMethod;
    if ((getDeleteNetworkPeeringMethod = VmwareEngineGrpc.getDeleteNetworkPeeringMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeleteNetworkPeeringMethod = VmwareEngineGrpc.getDeleteNetworkPeeringMethod)
            == null) {
          VmwareEngineGrpc.getDeleteNetworkPeeringMethod =
              getDeleteNetworkPeeringMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteNetworkPeering"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("DeleteNetworkPeering"))
                      .build();
        }
      }
    }
    return getDeleteNetworkPeeringMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest,
          com.google.longrunning.Operation>
      getUpdateNetworkPeeringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNetworkPeering",
      requestType = com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest,
          com.google.longrunning.Operation>
      getUpdateNetworkPeeringMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest,
            com.google.longrunning.Operation>
        getUpdateNetworkPeeringMethod;
    if ((getUpdateNetworkPeeringMethod = VmwareEngineGrpc.getUpdateNetworkPeeringMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdateNetworkPeeringMethod = VmwareEngineGrpc.getUpdateNetworkPeeringMethod)
            == null) {
          VmwareEngineGrpc.getUpdateNetworkPeeringMethod =
              getUpdateNetworkPeeringMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateNetworkPeering"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("UpdateNetworkPeering"))
                      .build();
        }
      }
    }
    return getUpdateNetworkPeeringMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest,
          com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse>
      getListPeeringRoutesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPeeringRoutes",
      requestType = com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest,
          com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse>
      getListPeeringRoutesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest,
            com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse>
        getListPeeringRoutesMethod;
    if ((getListPeeringRoutesMethod = VmwareEngineGrpc.getListPeeringRoutesMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListPeeringRoutesMethod = VmwareEngineGrpc.getListPeeringRoutesMethod) == null) {
          VmwareEngineGrpc.getListPeeringRoutesMethod =
              getListPeeringRoutesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest,
                          com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPeeringRoutes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ListPeeringRoutes"))
                      .build();
        }
      }
    }
    return getListPeeringRoutesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest,
          com.google.longrunning.Operation>
      getCreateHcxActivationKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHcxActivationKey",
      requestType = com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest,
          com.google.longrunning.Operation>
      getCreateHcxActivationKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest,
            com.google.longrunning.Operation>
        getCreateHcxActivationKeyMethod;
    if ((getCreateHcxActivationKeyMethod = VmwareEngineGrpc.getCreateHcxActivationKeyMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreateHcxActivationKeyMethod = VmwareEngineGrpc.getCreateHcxActivationKeyMethod)
            == null) {
          VmwareEngineGrpc.getCreateHcxActivationKeyMethod =
              getCreateHcxActivationKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateHcxActivationKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("CreateHcxActivationKey"))
                      .build();
        }
      }
    }
    return getCreateHcxActivationKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest,
          com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse>
      getListHcxActivationKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHcxActivationKeys",
      requestType = com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest,
          com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse>
      getListHcxActivationKeysMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest,
            com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse>
        getListHcxActivationKeysMethod;
    if ((getListHcxActivationKeysMethod = VmwareEngineGrpc.getListHcxActivationKeysMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListHcxActivationKeysMethod = VmwareEngineGrpc.getListHcxActivationKeysMethod)
            == null) {
          VmwareEngineGrpc.getListHcxActivationKeysMethod =
              getListHcxActivationKeysMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest,
                          com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListHcxActivationKeys"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ListHcxActivationKeys"))
                      .build();
        }
      }
    }
    return getListHcxActivationKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest,
          com.google.cloud.vmwareengine.v1.HcxActivationKey>
      getGetHcxActivationKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHcxActivationKey",
      requestType = com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.HcxActivationKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest,
          com.google.cloud.vmwareengine.v1.HcxActivationKey>
      getGetHcxActivationKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest,
            com.google.cloud.vmwareengine.v1.HcxActivationKey>
        getGetHcxActivationKeyMethod;
    if ((getGetHcxActivationKeyMethod = VmwareEngineGrpc.getGetHcxActivationKeyMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetHcxActivationKeyMethod = VmwareEngineGrpc.getGetHcxActivationKeyMethod)
            == null) {
          VmwareEngineGrpc.getGetHcxActivationKeyMethod =
              getGetHcxActivationKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest,
                          com.google.cloud.vmwareengine.v1.HcxActivationKey>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetHcxActivationKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.HcxActivationKey
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("GetHcxActivationKey"))
                      .build();
        }
      }
    }
    return getGetHcxActivationKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest,
          com.google.cloud.vmwareengine.v1.NetworkPolicy>
      getGetNetworkPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNetworkPolicy",
      requestType = com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.NetworkPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest,
          com.google.cloud.vmwareengine.v1.NetworkPolicy>
      getGetNetworkPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest,
            com.google.cloud.vmwareengine.v1.NetworkPolicy>
        getGetNetworkPolicyMethod;
    if ((getGetNetworkPolicyMethod = VmwareEngineGrpc.getGetNetworkPolicyMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetNetworkPolicyMethod = VmwareEngineGrpc.getGetNetworkPolicyMethod) == null) {
          VmwareEngineGrpc.getGetNetworkPolicyMethod =
              getGetNetworkPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest,
                          com.google.cloud.vmwareengine.v1.NetworkPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNetworkPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.NetworkPolicy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("GetNetworkPolicy"))
                      .build();
        }
      }
    }
    return getGetNetworkPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest,
          com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse>
      getListNetworkPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNetworkPolicies",
      requestType = com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest,
          com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse>
      getListNetworkPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest,
            com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse>
        getListNetworkPoliciesMethod;
    if ((getListNetworkPoliciesMethod = VmwareEngineGrpc.getListNetworkPoliciesMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListNetworkPoliciesMethod = VmwareEngineGrpc.getListNetworkPoliciesMethod)
            == null) {
          VmwareEngineGrpc.getListNetworkPoliciesMethod =
              getListNetworkPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest,
                          com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListNetworkPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ListNetworkPolicies"))
                      .build();
        }
      }
    }
    return getListNetworkPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest,
          com.google.longrunning.Operation>
      getCreateNetworkPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNetworkPolicy",
      requestType = com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest,
          com.google.longrunning.Operation>
      getCreateNetworkPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest,
            com.google.longrunning.Operation>
        getCreateNetworkPolicyMethod;
    if ((getCreateNetworkPolicyMethod = VmwareEngineGrpc.getCreateNetworkPolicyMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreateNetworkPolicyMethod = VmwareEngineGrpc.getCreateNetworkPolicyMethod)
            == null) {
          VmwareEngineGrpc.getCreateNetworkPolicyMethod =
              getCreateNetworkPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateNetworkPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("CreateNetworkPolicy"))
                      .build();
        }
      }
    }
    return getCreateNetworkPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateNetworkPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNetworkPolicy",
      requestType = com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateNetworkPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest,
            com.google.longrunning.Operation>
        getUpdateNetworkPolicyMethod;
    if ((getUpdateNetworkPolicyMethod = VmwareEngineGrpc.getUpdateNetworkPolicyMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdateNetworkPolicyMethod = VmwareEngineGrpc.getUpdateNetworkPolicyMethod)
            == null) {
          VmwareEngineGrpc.getUpdateNetworkPolicyMethod =
              getUpdateNetworkPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateNetworkPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("UpdateNetworkPolicy"))
                      .build();
        }
      }
    }
    return getUpdateNetworkPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteNetworkPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNetworkPolicy",
      requestType = com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteNetworkPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest,
            com.google.longrunning.Operation>
        getDeleteNetworkPolicyMethod;
    if ((getDeleteNetworkPolicyMethod = VmwareEngineGrpc.getDeleteNetworkPolicyMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeleteNetworkPolicyMethod = VmwareEngineGrpc.getDeleteNetworkPolicyMethod)
            == null) {
          VmwareEngineGrpc.getDeleteNetworkPolicyMethod =
              getDeleteNetworkPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteNetworkPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("DeleteNetworkPolicy"))
                      .build();
        }
      }
    }
    return getDeleteNetworkPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest,
          com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse>
      getListManagementDnsZoneBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListManagementDnsZoneBindings",
      requestType = com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest,
          com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse>
      getListManagementDnsZoneBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest,
            com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse>
        getListManagementDnsZoneBindingsMethod;
    if ((getListManagementDnsZoneBindingsMethod =
            VmwareEngineGrpc.getListManagementDnsZoneBindingsMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListManagementDnsZoneBindingsMethod =
                VmwareEngineGrpc.getListManagementDnsZoneBindingsMethod)
            == null) {
          VmwareEngineGrpc.getListManagementDnsZoneBindingsMethod =
              getListManagementDnsZoneBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest,
                          com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListManagementDnsZoneBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ListManagementDnsZoneBindings"))
                      .build();
        }
      }
    }
    return getListManagementDnsZoneBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest,
          com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding>
      getGetManagementDnsZoneBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetManagementDnsZoneBinding",
      requestType = com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest,
          com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding>
      getGetManagementDnsZoneBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest,
            com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding>
        getGetManagementDnsZoneBindingMethod;
    if ((getGetManagementDnsZoneBindingMethod =
            VmwareEngineGrpc.getGetManagementDnsZoneBindingMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetManagementDnsZoneBindingMethod =
                VmwareEngineGrpc.getGetManagementDnsZoneBindingMethod)
            == null) {
          VmwareEngineGrpc.getGetManagementDnsZoneBindingMethod =
              getGetManagementDnsZoneBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest,
                          com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetManagementDnsZoneBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("GetManagementDnsZoneBinding"))
                      .build();
        }
      }
    }
    return getGetManagementDnsZoneBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest,
          com.google.longrunning.Operation>
      getCreateManagementDnsZoneBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateManagementDnsZoneBinding",
      requestType = com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest,
          com.google.longrunning.Operation>
      getCreateManagementDnsZoneBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest,
            com.google.longrunning.Operation>
        getCreateManagementDnsZoneBindingMethod;
    if ((getCreateManagementDnsZoneBindingMethod =
            VmwareEngineGrpc.getCreateManagementDnsZoneBindingMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreateManagementDnsZoneBindingMethod =
                VmwareEngineGrpc.getCreateManagementDnsZoneBindingMethod)
            == null) {
          VmwareEngineGrpc.getCreateManagementDnsZoneBindingMethod =
              getCreateManagementDnsZoneBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateManagementDnsZoneBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier(
                              "CreateManagementDnsZoneBinding"))
                      .build();
        }
      }
    }
    return getCreateManagementDnsZoneBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest,
          com.google.longrunning.Operation>
      getUpdateManagementDnsZoneBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateManagementDnsZoneBinding",
      requestType = com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest,
          com.google.longrunning.Operation>
      getUpdateManagementDnsZoneBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest,
            com.google.longrunning.Operation>
        getUpdateManagementDnsZoneBindingMethod;
    if ((getUpdateManagementDnsZoneBindingMethod =
            VmwareEngineGrpc.getUpdateManagementDnsZoneBindingMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdateManagementDnsZoneBindingMethod =
                VmwareEngineGrpc.getUpdateManagementDnsZoneBindingMethod)
            == null) {
          VmwareEngineGrpc.getUpdateManagementDnsZoneBindingMethod =
              getUpdateManagementDnsZoneBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateManagementDnsZoneBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier(
                              "UpdateManagementDnsZoneBinding"))
                      .build();
        }
      }
    }
    return getUpdateManagementDnsZoneBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest,
          com.google.longrunning.Operation>
      getDeleteManagementDnsZoneBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteManagementDnsZoneBinding",
      requestType = com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest,
          com.google.longrunning.Operation>
      getDeleteManagementDnsZoneBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest,
            com.google.longrunning.Operation>
        getDeleteManagementDnsZoneBindingMethod;
    if ((getDeleteManagementDnsZoneBindingMethod =
            VmwareEngineGrpc.getDeleteManagementDnsZoneBindingMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeleteManagementDnsZoneBindingMethod =
                VmwareEngineGrpc.getDeleteManagementDnsZoneBindingMethod)
            == null) {
          VmwareEngineGrpc.getDeleteManagementDnsZoneBindingMethod =
              getDeleteManagementDnsZoneBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteManagementDnsZoneBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier(
                              "DeleteManagementDnsZoneBinding"))
                      .build();
        }
      }
    }
    return getDeleteManagementDnsZoneBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest,
          com.google.longrunning.Operation>
      getRepairManagementDnsZoneBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RepairManagementDnsZoneBinding",
      requestType = com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest,
          com.google.longrunning.Operation>
      getRepairManagementDnsZoneBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest,
            com.google.longrunning.Operation>
        getRepairManagementDnsZoneBindingMethod;
    if ((getRepairManagementDnsZoneBindingMethod =
            VmwareEngineGrpc.getRepairManagementDnsZoneBindingMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getRepairManagementDnsZoneBindingMethod =
                VmwareEngineGrpc.getRepairManagementDnsZoneBindingMethod)
            == null) {
          VmwareEngineGrpc.getRepairManagementDnsZoneBindingMethod =
              getRepairManagementDnsZoneBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RepairManagementDnsZoneBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier(
                              "RepairManagementDnsZoneBinding"))
                      .build();
        }
      }
    }
    return getRepairManagementDnsZoneBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest,
          com.google.longrunning.Operation>
      getCreateVmwareEngineNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVmwareEngineNetwork",
      requestType = com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest,
          com.google.longrunning.Operation>
      getCreateVmwareEngineNetworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest,
            com.google.longrunning.Operation>
        getCreateVmwareEngineNetworkMethod;
    if ((getCreateVmwareEngineNetworkMethod = VmwareEngineGrpc.getCreateVmwareEngineNetworkMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreateVmwareEngineNetworkMethod =
                VmwareEngineGrpc.getCreateVmwareEngineNetworkMethod)
            == null) {
          VmwareEngineGrpc.getCreateVmwareEngineNetworkMethod =
              getCreateVmwareEngineNetworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateVmwareEngineNetwork"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("CreateVmwareEngineNetwork"))
                      .build();
        }
      }
    }
    return getCreateVmwareEngineNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest,
          com.google.longrunning.Operation>
      getUpdateVmwareEngineNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVmwareEngineNetwork",
      requestType = com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest,
          com.google.longrunning.Operation>
      getUpdateVmwareEngineNetworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest,
            com.google.longrunning.Operation>
        getUpdateVmwareEngineNetworkMethod;
    if ((getUpdateVmwareEngineNetworkMethod = VmwareEngineGrpc.getUpdateVmwareEngineNetworkMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdateVmwareEngineNetworkMethod =
                VmwareEngineGrpc.getUpdateVmwareEngineNetworkMethod)
            == null) {
          VmwareEngineGrpc.getUpdateVmwareEngineNetworkMethod =
              getUpdateVmwareEngineNetworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateVmwareEngineNetwork"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("UpdateVmwareEngineNetwork"))
                      .build();
        }
      }
    }
    return getUpdateVmwareEngineNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest,
          com.google.longrunning.Operation>
      getDeleteVmwareEngineNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVmwareEngineNetwork",
      requestType = com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest,
          com.google.longrunning.Operation>
      getDeleteVmwareEngineNetworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest,
            com.google.longrunning.Operation>
        getDeleteVmwareEngineNetworkMethod;
    if ((getDeleteVmwareEngineNetworkMethod = VmwareEngineGrpc.getDeleteVmwareEngineNetworkMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeleteVmwareEngineNetworkMethod =
                VmwareEngineGrpc.getDeleteVmwareEngineNetworkMethod)
            == null) {
          VmwareEngineGrpc.getDeleteVmwareEngineNetworkMethod =
              getDeleteVmwareEngineNetworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteVmwareEngineNetwork"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("DeleteVmwareEngineNetwork"))
                      .build();
        }
      }
    }
    return getDeleteVmwareEngineNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest,
          com.google.cloud.vmwareengine.v1.VmwareEngineNetwork>
      getGetVmwareEngineNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVmwareEngineNetwork",
      requestType = com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.VmwareEngineNetwork.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest,
          com.google.cloud.vmwareengine.v1.VmwareEngineNetwork>
      getGetVmwareEngineNetworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest,
            com.google.cloud.vmwareengine.v1.VmwareEngineNetwork>
        getGetVmwareEngineNetworkMethod;
    if ((getGetVmwareEngineNetworkMethod = VmwareEngineGrpc.getGetVmwareEngineNetworkMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetVmwareEngineNetworkMethod = VmwareEngineGrpc.getGetVmwareEngineNetworkMethod)
            == null) {
          VmwareEngineGrpc.getGetVmwareEngineNetworkMethod =
              getGetVmwareEngineNetworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest,
                          com.google.cloud.vmwareengine.v1.VmwareEngineNetwork>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetVmwareEngineNetwork"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.VmwareEngineNetwork
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("GetVmwareEngineNetwork"))
                      .build();
        }
      }
    }
    return getGetVmwareEngineNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest,
          com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse>
      getListVmwareEngineNetworksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVmwareEngineNetworks",
      requestType = com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest,
          com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse>
      getListVmwareEngineNetworksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest,
            com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse>
        getListVmwareEngineNetworksMethod;
    if ((getListVmwareEngineNetworksMethod = VmwareEngineGrpc.getListVmwareEngineNetworksMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListVmwareEngineNetworksMethod = VmwareEngineGrpc.getListVmwareEngineNetworksMethod)
            == null) {
          VmwareEngineGrpc.getListVmwareEngineNetworksMethod =
              getListVmwareEngineNetworksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest,
                          com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListVmwareEngineNetworks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ListVmwareEngineNetworks"))
                      .build();
        }
      }
    }
    return getListVmwareEngineNetworksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest,
          com.google.longrunning.Operation>
      getCreatePrivateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePrivateConnection",
      requestType = com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest,
          com.google.longrunning.Operation>
      getCreatePrivateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest,
            com.google.longrunning.Operation>
        getCreatePrivateConnectionMethod;
    if ((getCreatePrivateConnectionMethod = VmwareEngineGrpc.getCreatePrivateConnectionMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreatePrivateConnectionMethod = VmwareEngineGrpc.getCreatePrivateConnectionMethod)
            == null) {
          VmwareEngineGrpc.getCreatePrivateConnectionMethod =
              getCreatePrivateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreatePrivateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("CreatePrivateConnection"))
                      .build();
        }
      }
    }
    return getCreatePrivateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest,
          com.google.cloud.vmwareengine.v1.PrivateConnection>
      getGetPrivateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPrivateConnection",
      requestType = com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.PrivateConnection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest,
          com.google.cloud.vmwareengine.v1.PrivateConnection>
      getGetPrivateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest,
            com.google.cloud.vmwareengine.v1.PrivateConnection>
        getGetPrivateConnectionMethod;
    if ((getGetPrivateConnectionMethod = VmwareEngineGrpc.getGetPrivateConnectionMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetPrivateConnectionMethod = VmwareEngineGrpc.getGetPrivateConnectionMethod)
            == null) {
          VmwareEngineGrpc.getGetPrivateConnectionMethod =
              getGetPrivateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest,
                          com.google.cloud.vmwareengine.v1.PrivateConnection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetPrivateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.PrivateConnection
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("GetPrivateConnection"))
                      .build();
        }
      }
    }
    return getGetPrivateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest,
          com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse>
      getListPrivateConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPrivateConnections",
      requestType = com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest,
          com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse>
      getListPrivateConnectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest,
            com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse>
        getListPrivateConnectionsMethod;
    if ((getListPrivateConnectionsMethod = VmwareEngineGrpc.getListPrivateConnectionsMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListPrivateConnectionsMethod = VmwareEngineGrpc.getListPrivateConnectionsMethod)
            == null) {
          VmwareEngineGrpc.getListPrivateConnectionsMethod =
              getListPrivateConnectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest,
                          com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPrivateConnections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("ListPrivateConnections"))
                      .build();
        }
      }
    }
    return getListPrivateConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest,
          com.google.longrunning.Operation>
      getUpdatePrivateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePrivateConnection",
      requestType = com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest,
          com.google.longrunning.Operation>
      getUpdatePrivateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest,
            com.google.longrunning.Operation>
        getUpdatePrivateConnectionMethod;
    if ((getUpdatePrivateConnectionMethod = VmwareEngineGrpc.getUpdatePrivateConnectionMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdatePrivateConnectionMethod = VmwareEngineGrpc.getUpdatePrivateConnectionMethod)
            == null) {
          VmwareEngineGrpc.getUpdatePrivateConnectionMethod =
              getUpdatePrivateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdatePrivateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("UpdatePrivateConnection"))
                      .build();
        }
      }
    }
    return getUpdatePrivateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest,
          com.google.longrunning.Operation>
      getDeletePrivateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePrivateConnection",
      requestType = com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest,
          com.google.longrunning.Operation>
      getDeletePrivateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest,
            com.google.longrunning.Operation>
        getDeletePrivateConnectionMethod;
    if ((getDeletePrivateConnectionMethod = VmwareEngineGrpc.getDeletePrivateConnectionMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeletePrivateConnectionMethod = VmwareEngineGrpc.getDeletePrivateConnectionMethod)
            == null) {
          VmwareEngineGrpc.getDeletePrivateConnectionMethod =
              getDeletePrivateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeletePrivateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("DeletePrivateConnection"))
                      .build();
        }
      }
    }
    return getDeletePrivateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesRequest,
          com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesResponse>
      getListPrivateConnectionPeeringRoutesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPrivateConnectionPeeringRoutes",
      requestType =
          com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesRequest.class,
      responseType =
          com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesRequest,
          com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesResponse>
      getListPrivateConnectionPeeringRoutesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesRequest,
            com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesResponse>
        getListPrivateConnectionPeeringRoutesMethod;
    if ((getListPrivateConnectionPeeringRoutesMethod =
            VmwareEngineGrpc.getListPrivateConnectionPeeringRoutesMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListPrivateConnectionPeeringRoutesMethod =
                VmwareEngineGrpc.getListPrivateConnectionPeeringRoutesMethod)
            == null) {
          VmwareEngineGrpc.getListPrivateConnectionPeeringRoutesMethod =
              getListPrivateConnectionPeeringRoutesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesRequest,
                          com.google.cloud.vmwareengine.v1
                              .ListPrivateConnectionPeeringRoutesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListPrivateConnectionPeeringRoutes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1
                                  .ListPrivateConnectionPeeringRoutesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1
                                  .ListPrivateConnectionPeeringRoutesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier(
                              "ListPrivateConnectionPeeringRoutes"))
                      .build();
        }
      }
    }
    return getListPrivateConnectionPeeringRoutesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest,
          com.google.longrunning.Operation>
      getGrantDnsBindPermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GrantDnsBindPermission",
      requestType = com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest,
          com.google.longrunning.Operation>
      getGrantDnsBindPermissionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest,
            com.google.longrunning.Operation>
        getGrantDnsBindPermissionMethod;
    if ((getGrantDnsBindPermissionMethod = VmwareEngineGrpc.getGrantDnsBindPermissionMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGrantDnsBindPermissionMethod = VmwareEngineGrpc.getGrantDnsBindPermissionMethod)
            == null) {
          VmwareEngineGrpc.getGrantDnsBindPermissionMethod =
              getGrantDnsBindPermissionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GrantDnsBindPermission"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("GrantDnsBindPermission"))
                      .build();
        }
      }
    }
    return getGrantDnsBindPermissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest,
          com.google.cloud.vmwareengine.v1.DnsBindPermission>
      getGetDnsBindPermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDnsBindPermission",
      requestType = com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.DnsBindPermission.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest,
          com.google.cloud.vmwareengine.v1.DnsBindPermission>
      getGetDnsBindPermissionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest,
            com.google.cloud.vmwareengine.v1.DnsBindPermission>
        getGetDnsBindPermissionMethod;
    if ((getGetDnsBindPermissionMethod = VmwareEngineGrpc.getGetDnsBindPermissionMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetDnsBindPermissionMethod = VmwareEngineGrpc.getGetDnsBindPermissionMethod)
            == null) {
          VmwareEngineGrpc.getGetDnsBindPermissionMethod =
              getGetDnsBindPermissionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest,
                          com.google.cloud.vmwareengine.v1.DnsBindPermission>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDnsBindPermission"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.DnsBindPermission
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("GetDnsBindPermission"))
                      .build();
        }
      }
    }
    return getGetDnsBindPermissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest,
          com.google.longrunning.Operation>
      getRevokeDnsBindPermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RevokeDnsBindPermission",
      requestType = com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest,
          com.google.longrunning.Operation>
      getRevokeDnsBindPermissionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest,
            com.google.longrunning.Operation>
        getRevokeDnsBindPermissionMethod;
    if ((getRevokeDnsBindPermissionMethod = VmwareEngineGrpc.getRevokeDnsBindPermissionMethod)
        == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getRevokeDnsBindPermissionMethod = VmwareEngineGrpc.getRevokeDnsBindPermissionMethod)
            == null) {
          VmwareEngineGrpc.getRevokeDnsBindPermissionMethod =
              getRevokeDnsBindPermissionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RevokeDnsBindPermission"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmwareEngineMethodDescriptorSupplier("RevokeDnsBindPermission"))
                      .build();
        }
      }
    }
    return getRevokeDnsBindPermissionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static VmwareEngineStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VmwareEngineStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VmwareEngineStub>() {
          @java.lang.Override
          public VmwareEngineStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VmwareEngineStub(channel, callOptions);
          }
        };
    return VmwareEngineStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VmwareEngineBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VmwareEngineBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VmwareEngineBlockingStub>() {
          @java.lang.Override
          public VmwareEngineBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VmwareEngineBlockingStub(channel, callOptions);
          }
        };
    return VmwareEngineBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static VmwareEngineFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VmwareEngineFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VmwareEngineFutureStub>() {
          @java.lang.Override
          public VmwareEngineFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VmwareEngineFutureStub(channel, callOptions);
          }
        };
    return VmwareEngineFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * VMwareEngine manages VMware's private clusters in the Cloud.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists `PrivateCloud` resources in a given project and location.
     * </pre>
     */
    default void listPrivateClouds(
        com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPrivateCloudsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `PrivateCloud` resource by its resource name.
     * </pre>
     */
    default void getPrivateCloud(
        com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.PrivateCloud>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPrivateCloudMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `PrivateCloud` resource in a given project and location.
     * Private clouds of type `STANDARD` and
     * `TIME_LIMITED` are zonal resources, `STRETCHED` private clouds are
     * regional.
     * Creating a private cloud also creates a [management
     * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components)
     * for that private cloud.
     * </pre>
     */
    default void createPrivateCloud(
        com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePrivateCloudMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `PrivateCloud` resource. Only the following fields can be
     * updated: `description`.
     * Only fields specified in `updateMask` are applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    default void updatePrivateCloud(
        com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePrivateCloudMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Schedules a `PrivateCloud` resource for deletion.
     * A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state`
     * set to `DELETED` and `expireTime` set to the time when deletion is final
     * and can no longer be reversed. The delete operation is marked as done
     * as soon as the `PrivateCloud` is successfully scheduled for deletion
     * (this also applies when `delayHours` is set to zero), and the operation is
     * not kept in pending state until `PrivateCloud` is purged.
     * `PrivateCloud` can be restored using `UndeletePrivateCloud` method before
     * the `expireTime` elapses. When `expireTime` is reached, deletion is final
     * and all private cloud resources are irreversibly removed and billing stops.
     * During the final removal process, `PrivateCloud.state` is set to `PURGING`.
     * `PrivateCloud` can be polled using standard `GET` method for the whole
     * period of deletion and purging. It will not be returned only
     * when it is completely purged.
     * </pre>
     */
    default void deletePrivateCloud(
        com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePrivateCloudMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores a private cloud that was previously scheduled for deletion by
     * `DeletePrivateCloud`. A `PrivateCloud` resource scheduled for deletion has
     * `PrivateCloud.state` set to `DELETED` and `PrivateCloud.expireTime` set to
     * the time when deletion can no longer be reversed.
     * </pre>
     */
    default void undeletePrivateCloud(
        com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeletePrivateCloudMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `Cluster` resources in a given private cloud.
     * </pre>
     */
    default void listClusters(
        com.google.cloud.vmwareengine.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `Cluster` resource by its resource name.
     * </pre>
     */
    default void getCluster(
        com.google.cloud.vmwareengine.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Cluster> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new cluster in a given private cloud.
     * Creating a new cluster provides additional nodes for
     * use in the parent private cloud and requires sufficient [node
     * quota](https://cloud.google.com/vmware-engine/quotas).
     * </pre>
     */
    default void createCluster(
        com.google.cloud.vmwareengine.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `Cluster` resource. Only fields specified in `updateMask` are
     * applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    default void updateCluster(
        com.google.cloud.vmwareengine.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or
     * gracefully shut down any workloads running on the cluster before deletion.
     * You cannot delete the management cluster of a private cloud using this
     * method.
     * </pre>
     */
    default void deleteCluster(
        com.google.cloud.vmwareengine.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists nodes in a given cluster.
     * </pre>
     */
    default void listNodes(
        com.google.cloud.vmwareengine.v1.ListNodesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNodesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListNodesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single node.
     * </pre>
     */
    default void getNode(
        com.google.cloud.vmwareengine.v1.GetNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Node> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNodeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists external IP addresses assigned to VMware workload VMs in a given
     * private cloud.
     * </pre>
     */
    default void listExternalAddresses(
        com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExternalAddressesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists external IP addresses assigned to VMware workload VMs within the
     * scope of the given network policy.
     * </pre>
     */
    default void fetchNetworkPolicyExternalAddresses(
        com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchNetworkPolicyExternalAddressesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single external IP address.
     * </pre>
     */
    default void getExternalAddress(
        com.google.cloud.vmwareengine.v1.GetExternalAddressRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ExternalAddress>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExternalAddressMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `ExternalAddress` resource in a given private cloud. The
     * network policy that corresponds to the private cloud must have the external
     * IP address network service enabled (`NetworkPolicy.external_ip`).
     * </pre>
     */
    default void createExternalAddress(
        com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExternalAddressMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single external IP address.
     * Only fields specified in `update_mask` are applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    default void updateExternalAddress(
        com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateExternalAddressMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single external IP address. When you delete an external IP
     * address, connectivity between the external IP address and the corresponding
     * internal IP address is lost.
     * </pre>
     */
    default void deleteExternalAddress(
        com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExternalAddressMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists subnets in a given private cloud.
     * </pre>
     */
    default void listSubnets(
        com.google.cloud.vmwareengine.v1.ListSubnetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListSubnetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSubnetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single subnet.
     * </pre>
     */
    default void getSubnet(
        com.google.cloud.vmwareengine.v1.GetSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Subnet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSubnetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single subnet. Only fields specified in
     * `update_mask` are applied.
     * *Note*: This API is synchronous and always returns a successful
     * `google.longrunning.Operation` (LRO). The returned LRO will only have
     * `done` and `response` fields.
     * </pre>
     */
    default void updateSubnet(
        com.google.cloud.vmwareengine.v1.UpdateSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSubnetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `ExternalAccessRule` resources in the specified network policy.
     * </pre>
     */
    default void listExternalAccessRules(
        com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExternalAccessRulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single external access rule.
     * </pre>
     */
    default void getExternalAccessRule(
        com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ExternalAccessRule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExternalAccessRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new external access rule in a given network policy.
     * </pre>
     */
    default void createExternalAccessRule(
        com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExternalAccessRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single external access rule.
     * Only fields specified in `update_mask` are applied.
     * </pre>
     */
    default void updateExternalAccessRule(
        com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateExternalAccessRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single external access rule.
     * </pre>
     */
    default void deleteExternalAccessRule(
        com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExternalAccessRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists logging servers configured for a given private
     * cloud.
     * </pre>
     */
    default void listLoggingServers(
        com.google.cloud.vmwareengine.v1.ListLoggingServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListLoggingServersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLoggingServersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a logging server.
     * </pre>
     */
    default void getLoggingServer(
        com.google.cloud.vmwareengine.v1.GetLoggingServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.LoggingServer>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLoggingServerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new logging server for a given private cloud.
     * </pre>
     */
    default void createLoggingServer(
        com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateLoggingServerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single logging server.
     * Only fields specified in `update_mask` are applied.
     * </pre>
     */
    default void updateLoggingServer(
        com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateLoggingServerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single logging server.
     * </pre>
     */
    default void deleteLoggingServer(
        com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteLoggingServerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists node types
     * </pre>
     */
    default void listNodeTypes(
        com.google.cloud.vmwareengine.v1.ListNodeTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNodeTypesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNodeTypesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single `NodeType`.
     * </pre>
     */
    default void getNodeType(
        com.google.cloud.vmwareengine.v1.GetNodeTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NodeType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNodeTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of credentials for NSX appliance.
     * </pre>
     */
    default void showNsxCredentials(
        com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Credentials>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getShowNsxCredentialsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of credentials for Vcenter appliance.
     * </pre>
     */
    default void showVcenterCredentials(
        com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Credentials>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getShowVcenterCredentialsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resets credentials of the NSX appliance.
     * </pre>
     */
    default void resetNsxCredentials(
        com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResetNsxCredentialsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resets credentials of the Vcenter appliance.
     * </pre>
     */
    default void resetVcenterCredentials(
        com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResetVcenterCredentialsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the `DnsForwarding` config.
     * </pre>
     */
    default void getDnsForwarding(
        com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.DnsForwarding>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDnsForwardingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of the `DnsForwarding` config, like associated
     * domains. Only fields specified in `update_mask` are applied.
     * </pre>
     */
    default void updateDnsForwarding(
        com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDnsForwardingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `NetworkPeering` resource by its resource name. The resource
     * contains details of the network peering, such as peered
     * networks, import and export custom route configurations, and peering state.
     * NetworkPeering is a global resource and location can only be global.
     * </pre>
     */
    default void getNetworkPeering(
        com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NetworkPeering>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNetworkPeeringMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `NetworkPeering` resources in a given project. NetworkPeering is a
     * global resource and location can only be global.
     * </pre>
     */
    default void listNetworkPeerings(
        com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNetworkPeeringsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new network peering between the peer network and VMware Engine
     * network provided in a `NetworkPeering` resource. NetworkPeering is a
     * global resource and location can only be global.
     * </pre>
     */
    default void createNetworkPeering(
        com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateNetworkPeeringMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `NetworkPeering` resource. When a network peering is deleted for
     * a VMware Engine network, the peer network becomes inaccessible to that
     * VMware Engine network. NetworkPeering is a global resource and location can
     * only be global.
     * </pre>
     */
    default void deleteNetworkPeering(
        com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteNetworkPeeringMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `NetworkPeering` resource. Only the `description` field can be
     * updated. Only fields specified in `updateMask` are applied. NetworkPeering
     * is a global resource and location can only be global.
     * </pre>
     */
    default void updateNetworkPeering(
        com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateNetworkPeeringMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the network peering routes exchanged over a peering connection.
     * NetworkPeering is a global resource and location can only be global.
     * </pre>
     */
    default void listPeeringRoutes(
        com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPeeringRoutesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new HCX activation key in a given private cloud.
     * </pre>
     */
    default void createHcxActivationKey(
        com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateHcxActivationKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `HcxActivationKey` resources in a given private cloud.
     * </pre>
     */
    default void listHcxActivationKeys(
        com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListHcxActivationKeysMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `HcxActivationKey` resource by its resource name.
     * </pre>
     */
    default void getHcxActivationKey(
        com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.HcxActivationKey>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetHcxActivationKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `NetworkPolicy` resource by its resource name.
     * </pre>
     */
    default void getNetworkPolicy(
        com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NetworkPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNetworkPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `NetworkPolicy` resources in a specified project and location.
     * </pre>
     */
    default void listNetworkPolicies(
        com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNetworkPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new network policy in a given VMware Engine network of a
     * project and location (region). A new network policy cannot be created if
     * another network policy already exists in the same scope.
     * </pre>
     */
    default void createNetworkPolicy(
        com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateNetworkPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `NetworkPolicy` resource. Only the following fields can be
     * updated: `internet_access`, `external_ip`, `edge_services_cidr`.
     * Only fields specified in `updateMask` are applied. When updating a network
     * policy, the external IP network service can only be disabled if there are
     * no external IP addresses present in the scope of the policy. Also, a
     * `NetworkService` cannot be updated when `NetworkService.state` is set
     * to `RECONCILING`.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    default void updateNetworkPolicy(
        com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateNetworkPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted
     * when `NetworkService.state` is set to `RECONCILING` for either its external
     * IP or internet access service.
     * </pre>
     */
    default void deleteNetworkPolicy(
        com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteNetworkPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Consumer VPCs bound to Management DNS Zone of a given private cloud.
     * </pre>
     */
    default void listManagementDnsZoneBindings(
        com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListManagementDnsZoneBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a 'ManagementDnsZoneBinding' resource by its resource name.
     * </pre>
     */
    default void getManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetManagementDnsZoneBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `ManagementDnsZoneBinding` resource in a private cloud.
     * This RPC creates the DNS binding and the resource that represents the
     * DNS binding of the consumer VPC network to the management DNS zone. A
     * management DNS zone is the Cloud DNS cross-project binding zone that
     * VMware Engine creates for each private cloud. It contains FQDNs and
     * corresponding IP addresses for the private cloud's ESXi hosts and
     * management VM appliances like vCenter and NSX Manager.
     * </pre>
     */
    default void createManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateManagementDnsZoneBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a `ManagementDnsZoneBinding` resource.
     * Only fields specified in `update_mask` are applied.
     * </pre>
     */
    default void updateManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateManagementDnsZoneBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `ManagementDnsZoneBinding` resource. When a management DNS zone
     * binding is deleted, the corresponding consumer VPC network is no longer
     * bound to the management DNS zone.
     * </pre>
     */
    default void deleteManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteManagementDnsZoneBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retries to create a `ManagementDnsZoneBinding` resource that is
     * in failed state.
     * </pre>
     */
    default void repairManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRepairManagementDnsZoneBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new VMware Engine network that can be used by a private cloud.
     * </pre>
     */
    default void createVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateVmwareEngineNetworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies a VMware Engine network resource. Only the following fields can be
     * updated: `description`. Only fields specified in `updateMask` are
     * applied.
     * </pre>
     */
    default void updateVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateVmwareEngineNetworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware
     * Engine network after all resources that refer to it are deleted. For
     * example, a private cloud, a network peering, and a network policy can all
     * refer to the same VMware Engine network.
     * </pre>
     */
    default void deleteVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteVmwareEngineNetworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `VmwareEngineNetwork` resource by its resource name. The
     * resource contains details of the VMware Engine network, such as its VMware
     * Engine network type, peered networks in a service project, and state
     * (for example, `CREATING`, `ACTIVE`, `DELETING`).
     * </pre>
     */
    default void getVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.VmwareEngineNetwork>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetVmwareEngineNetworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `VmwareEngineNetwork` resources in a given project and location.
     * </pre>
     */
    default void listVmwareEngineNetworks(
        com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVmwareEngineNetworksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new private connection that can be used for accessing private
     * Clouds.
     * </pre>
     */
    default void createPrivateConnection(
        com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePrivateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `PrivateConnection` resource by its resource name. The resource
     * contains details of the private connection, such as connected
     * network, routing mode and state.
     * </pre>
     */
    default void getPrivateConnection(
        com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.PrivateConnection>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPrivateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `PrivateConnection` resources in a given project and location.
     * </pre>
     */
    default void listPrivateConnections(
        com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPrivateConnectionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `PrivateConnection` resource. Only `description` and
     * `routing_mode` fields can be updated. Only fields specified in `updateMask`
     * are applied.
     * </pre>
     */
    default void updatePrivateConnection(
        com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePrivateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `PrivateConnection` resource. When a private connection is
     * deleted for a VMware Engine network, the connected network becomes
     * inaccessible to that VMware Engine network.
     * </pre>
     */
    default void deletePrivateConnection(
        com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePrivateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the private connection routes exchanged over a peering connection.
     * </pre>
     */
    default void listPrivateConnectionPeeringRoutes(
        com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPrivateConnectionPeeringRoutesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Grants the bind permission to the customer provided principal(user /
     * service account) to bind their DNS zone with the intranet VPC associated
     * with the project. DnsBindPermission is a global resource and location can
     * only be global.
     * </pre>
     */
    default void grantDnsBindPermission(
        com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGrantDnsBindPermissionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets all the principals having bind permission on the intranet VPC
     * associated with the consumer project granted by the Grant API.
     * DnsBindPermission is a global resource and location can only be global.
     * </pre>
     */
    default void getDnsBindPermission(
        com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.DnsBindPermission>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDnsBindPermissionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Revokes the bind permission from the customer provided principal(user /
     * service account) on the intranet VPC associated with the consumer project.
     * DnsBindPermission is a global resource and location can only be global.
     * </pre>
     */
    default void revokeDnsBindPermission(
        com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRevokeDnsBindPermissionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service VmwareEngine.
   *
   * <pre>
   * VMwareEngine manages VMware's private clusters in the Cloud.
   * </pre>
   */
  public abstract static class VmwareEngineImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return VmwareEngineGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service VmwareEngine.
   *
   * <pre>
   * VMwareEngine manages VMware's private clusters in the Cloud.
   * </pre>
   */
  public static final class VmwareEngineStub
      extends io.grpc.stub.AbstractAsyncStub<VmwareEngineStub> {
    private VmwareEngineStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VmwareEngineStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VmwareEngineStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists `PrivateCloud` resources in a given project and location.
     * </pre>
     */
    public void listPrivateClouds(
        com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPrivateCloudsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `PrivateCloud` resource by its resource name.
     * </pre>
     */
    public void getPrivateCloud(
        com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.PrivateCloud>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPrivateCloudMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `PrivateCloud` resource in a given project and location.
     * Private clouds of type `STANDARD` and
     * `TIME_LIMITED` are zonal resources, `STRETCHED` private clouds are
     * regional.
     * Creating a private cloud also creates a [management
     * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components)
     * for that private cloud.
     * </pre>
     */
    public void createPrivateCloud(
        com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePrivateCloudMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `PrivateCloud` resource. Only the following fields can be
     * updated: `description`.
     * Only fields specified in `updateMask` are applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public void updatePrivateCloud(
        com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePrivateCloudMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Schedules a `PrivateCloud` resource for deletion.
     * A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state`
     * set to `DELETED` and `expireTime` set to the time when deletion is final
     * and can no longer be reversed. The delete operation is marked as done
     * as soon as the `PrivateCloud` is successfully scheduled for deletion
     * (this also applies when `delayHours` is set to zero), and the operation is
     * not kept in pending state until `PrivateCloud` is purged.
     * `PrivateCloud` can be restored using `UndeletePrivateCloud` method before
     * the `expireTime` elapses. When `expireTime` is reached, deletion is final
     * and all private cloud resources are irreversibly removed and billing stops.
     * During the final removal process, `PrivateCloud.state` is set to `PURGING`.
     * `PrivateCloud` can be polled using standard `GET` method for the whole
     * period of deletion and purging. It will not be returned only
     * when it is completely purged.
     * </pre>
     */
    public void deletePrivateCloud(
        com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePrivateCloudMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores a private cloud that was previously scheduled for deletion by
     * `DeletePrivateCloud`. A `PrivateCloud` resource scheduled for deletion has
     * `PrivateCloud.state` set to `DELETED` and `PrivateCloud.expireTime` set to
     * the time when deletion can no longer be reversed.
     * </pre>
     */
    public void undeletePrivateCloud(
        com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeletePrivateCloudMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `Cluster` resources in a given private cloud.
     * </pre>
     */
    public void listClusters(
        com.google.cloud.vmwareengine.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListClustersResponse>
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
     * Retrieves a `Cluster` resource by its resource name.
     * </pre>
     */
    public void getCluster(
        com.google.cloud.vmwareengine.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Cluster> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new cluster in a given private cloud.
     * Creating a new cluster provides additional nodes for
     * use in the parent private cloud and requires sufficient [node
     * quota](https://cloud.google.com/vmware-engine/quotas).
     * </pre>
     */
    public void createCluster(
        com.google.cloud.vmwareengine.v1.CreateClusterRequest request,
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
     * Modifies a `Cluster` resource. Only fields specified in `updateMask` are
     * applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public void updateCluster(
        com.google.cloud.vmwareengine.v1.UpdateClusterRequest request,
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
     * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or
     * gracefully shut down any workloads running on the cluster before deletion.
     * You cannot delete the management cluster of a private cloud using this
     * method.
     * </pre>
     */
    public void deleteCluster(
        com.google.cloud.vmwareengine.v1.DeleteClusterRequest request,
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
     * Lists nodes in a given cluster.
     * </pre>
     */
    public void listNodes(
        com.google.cloud.vmwareengine.v1.ListNodesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNodesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNodesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single node.
     * </pre>
     */
    public void getNode(
        com.google.cloud.vmwareengine.v1.GetNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Node> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists external IP addresses assigned to VMware workload VMs in a given
     * private cloud.
     * </pre>
     */
    public void listExternalAddresses(
        com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExternalAddressesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists external IP addresses assigned to VMware workload VMs within the
     * scope of the given network policy.
     * </pre>
     */
    public void fetchNetworkPolicyExternalAddresses(
        com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchNetworkPolicyExternalAddressesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single external IP address.
     * </pre>
     */
    public void getExternalAddress(
        com.google.cloud.vmwareengine.v1.GetExternalAddressRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ExternalAddress>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExternalAddressMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `ExternalAddress` resource in a given private cloud. The
     * network policy that corresponds to the private cloud must have the external
     * IP address network service enabled (`NetworkPolicy.external_ip`).
     * </pre>
     */
    public void createExternalAddress(
        com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExternalAddressMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single external IP address.
     * Only fields specified in `update_mask` are applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public void updateExternalAddress(
        com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExternalAddressMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single external IP address. When you delete an external IP
     * address, connectivity between the external IP address and the corresponding
     * internal IP address is lost.
     * </pre>
     */
    public void deleteExternalAddress(
        com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExternalAddressMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists subnets in a given private cloud.
     * </pre>
     */
    public void listSubnets(
        com.google.cloud.vmwareengine.v1.ListSubnetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListSubnetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSubnetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single subnet.
     * </pre>
     */
    public void getSubnet(
        com.google.cloud.vmwareengine.v1.GetSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Subnet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSubnetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single subnet. Only fields specified in
     * `update_mask` are applied.
     * *Note*: This API is synchronous and always returns a successful
     * `google.longrunning.Operation` (LRO). The returned LRO will only have
     * `done` and `response` fields.
     * </pre>
     */
    public void updateSubnet(
        com.google.cloud.vmwareengine.v1.UpdateSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSubnetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `ExternalAccessRule` resources in the specified network policy.
     * </pre>
     */
    public void listExternalAccessRules(
        com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExternalAccessRulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single external access rule.
     * </pre>
     */
    public void getExternalAccessRule(
        com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ExternalAccessRule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExternalAccessRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new external access rule in a given network policy.
     * </pre>
     */
    public void createExternalAccessRule(
        com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExternalAccessRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single external access rule.
     * Only fields specified in `update_mask` are applied.
     * </pre>
     */
    public void updateExternalAccessRule(
        com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExternalAccessRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single external access rule.
     * </pre>
     */
    public void deleteExternalAccessRule(
        com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExternalAccessRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists logging servers configured for a given private
     * cloud.
     * </pre>
     */
    public void listLoggingServers(
        com.google.cloud.vmwareengine.v1.ListLoggingServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListLoggingServersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLoggingServersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a logging server.
     * </pre>
     */
    public void getLoggingServer(
        com.google.cloud.vmwareengine.v1.GetLoggingServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.LoggingServer>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLoggingServerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new logging server for a given private cloud.
     * </pre>
     */
    public void createLoggingServer(
        com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLoggingServerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single logging server.
     * Only fields specified in `update_mask` are applied.
     * </pre>
     */
    public void updateLoggingServer(
        com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateLoggingServerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single logging server.
     * </pre>
     */
    public void deleteLoggingServer(
        com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteLoggingServerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists node types
     * </pre>
     */
    public void listNodeTypes(
        com.google.cloud.vmwareengine.v1.ListNodeTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNodeTypesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNodeTypesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single `NodeType`.
     * </pre>
     */
    public void getNodeType(
        com.google.cloud.vmwareengine.v1.GetNodeTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NodeType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNodeTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of credentials for NSX appliance.
     * </pre>
     */
    public void showNsxCredentials(
        com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Credentials>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowNsxCredentialsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of credentials for Vcenter appliance.
     * </pre>
     */
    public void showVcenterCredentials(
        com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Credentials>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowVcenterCredentialsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resets credentials of the NSX appliance.
     * </pre>
     */
    public void resetNsxCredentials(
        com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetNsxCredentialsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resets credentials of the Vcenter appliance.
     * </pre>
     */
    public void resetVcenterCredentials(
        com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetVcenterCredentialsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the `DnsForwarding` config.
     * </pre>
     */
    public void getDnsForwarding(
        com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.DnsForwarding>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDnsForwardingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of the `DnsForwarding` config, like associated
     * domains. Only fields specified in `update_mask` are applied.
     * </pre>
     */
    public void updateDnsForwarding(
        com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDnsForwardingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `NetworkPeering` resource by its resource name. The resource
     * contains details of the network peering, such as peered
     * networks, import and export custom route configurations, and peering state.
     * NetworkPeering is a global resource and location can only be global.
     * </pre>
     */
    public void getNetworkPeering(
        com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NetworkPeering>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNetworkPeeringMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `NetworkPeering` resources in a given project. NetworkPeering is a
     * global resource and location can only be global.
     * </pre>
     */
    public void listNetworkPeerings(
        com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNetworkPeeringsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new network peering between the peer network and VMware Engine
     * network provided in a `NetworkPeering` resource. NetworkPeering is a
     * global resource and location can only be global.
     * </pre>
     */
    public void createNetworkPeering(
        com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNetworkPeeringMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `NetworkPeering` resource. When a network peering is deleted for
     * a VMware Engine network, the peer network becomes inaccessible to that
     * VMware Engine network. NetworkPeering is a global resource and location can
     * only be global.
     * </pre>
     */
    public void deleteNetworkPeering(
        com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNetworkPeeringMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `NetworkPeering` resource. Only the `description` field can be
     * updated. Only fields specified in `updateMask` are applied. NetworkPeering
     * is a global resource and location can only be global.
     * </pre>
     */
    public void updateNetworkPeering(
        com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNetworkPeeringMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the network peering routes exchanged over a peering connection.
     * NetworkPeering is a global resource and location can only be global.
     * </pre>
     */
    public void listPeeringRoutes(
        com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPeeringRoutesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new HCX activation key in a given private cloud.
     * </pre>
     */
    public void createHcxActivationKey(
        com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHcxActivationKeyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `HcxActivationKey` resources in a given private cloud.
     * </pre>
     */
    public void listHcxActivationKeys(
        com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHcxActivationKeysMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `HcxActivationKey` resource by its resource name.
     * </pre>
     */
    public void getHcxActivationKey(
        com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.HcxActivationKey>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHcxActivationKeyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `NetworkPolicy` resource by its resource name.
     * </pre>
     */
    public void getNetworkPolicy(
        com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NetworkPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNetworkPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `NetworkPolicy` resources in a specified project and location.
     * </pre>
     */
    public void listNetworkPolicies(
        com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNetworkPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new network policy in a given VMware Engine network of a
     * project and location (region). A new network policy cannot be created if
     * another network policy already exists in the same scope.
     * </pre>
     */
    public void createNetworkPolicy(
        com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNetworkPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `NetworkPolicy` resource. Only the following fields can be
     * updated: `internet_access`, `external_ip`, `edge_services_cidr`.
     * Only fields specified in `updateMask` are applied. When updating a network
     * policy, the external IP network service can only be disabled if there are
     * no external IP addresses present in the scope of the policy. Also, a
     * `NetworkService` cannot be updated when `NetworkService.state` is set
     * to `RECONCILING`.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public void updateNetworkPolicy(
        com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNetworkPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted
     * when `NetworkService.state` is set to `RECONCILING` for either its external
     * IP or internet access service.
     * </pre>
     */
    public void deleteNetworkPolicy(
        com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNetworkPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Consumer VPCs bound to Management DNS Zone of a given private cloud.
     * </pre>
     */
    public void listManagementDnsZoneBindings(
        com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListManagementDnsZoneBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a 'ManagementDnsZoneBinding' resource by its resource name.
     * </pre>
     */
    public void getManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetManagementDnsZoneBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `ManagementDnsZoneBinding` resource in a private cloud.
     * This RPC creates the DNS binding and the resource that represents the
     * DNS binding of the consumer VPC network to the management DNS zone. A
     * management DNS zone is the Cloud DNS cross-project binding zone that
     * VMware Engine creates for each private cloud. It contains FQDNs and
     * corresponding IP addresses for the private cloud's ESXi hosts and
     * management VM appliances like vCenter and NSX Manager.
     * </pre>
     */
    public void createManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateManagementDnsZoneBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a `ManagementDnsZoneBinding` resource.
     * Only fields specified in `update_mask` are applied.
     * </pre>
     */
    public void updateManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateManagementDnsZoneBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `ManagementDnsZoneBinding` resource. When a management DNS zone
     * binding is deleted, the corresponding consumer VPC network is no longer
     * bound to the management DNS zone.
     * </pre>
     */
    public void deleteManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteManagementDnsZoneBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retries to create a `ManagementDnsZoneBinding` resource that is
     * in failed state.
     * </pre>
     */
    public void repairManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRepairManagementDnsZoneBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new VMware Engine network that can be used by a private cloud.
     * </pre>
     */
    public void createVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVmwareEngineNetworkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies a VMware Engine network resource. Only the following fields can be
     * updated: `description`. Only fields specified in `updateMask` are
     * applied.
     * </pre>
     */
    public void updateVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVmwareEngineNetworkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware
     * Engine network after all resources that refer to it are deleted. For
     * example, a private cloud, a network peering, and a network policy can all
     * refer to the same VMware Engine network.
     * </pre>
     */
    public void deleteVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVmwareEngineNetworkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `VmwareEngineNetwork` resource by its resource name. The
     * resource contains details of the VMware Engine network, such as its VMware
     * Engine network type, peered networks in a service project, and state
     * (for example, `CREATING`, `ACTIVE`, `DELETING`).
     * </pre>
     */
    public void getVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.VmwareEngineNetwork>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVmwareEngineNetworkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `VmwareEngineNetwork` resources in a given project and location.
     * </pre>
     */
    public void listVmwareEngineNetworks(
        com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVmwareEngineNetworksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new private connection that can be used for accessing private
     * Clouds.
     * </pre>
     */
    public void createPrivateConnection(
        com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePrivateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `PrivateConnection` resource by its resource name. The resource
     * contains details of the private connection, such as connected
     * network, routing mode and state.
     * </pre>
     */
    public void getPrivateConnection(
        com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.PrivateConnection>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPrivateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists `PrivateConnection` resources in a given project and location.
     * </pre>
     */
    public void listPrivateConnections(
        com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPrivateConnectionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `PrivateConnection` resource. Only `description` and
     * `routing_mode` fields can be updated. Only fields specified in `updateMask`
     * are applied.
     * </pre>
     */
    public void updatePrivateConnection(
        com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePrivateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `PrivateConnection` resource. When a private connection is
     * deleted for a VMware Engine network, the connected network becomes
     * inaccessible to that VMware Engine network.
     * </pre>
     */
    public void deletePrivateConnection(
        com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePrivateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the private connection routes exchanged over a peering connection.
     * </pre>
     */
    public void listPrivateConnectionPeeringRoutes(
        com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPrivateConnectionPeeringRoutesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Grants the bind permission to the customer provided principal(user /
     * service account) to bind their DNS zone with the intranet VPC associated
     * with the project. DnsBindPermission is a global resource and location can
     * only be global.
     * </pre>
     */
    public void grantDnsBindPermission(
        com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGrantDnsBindPermissionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets all the principals having bind permission on the intranet VPC
     * associated with the consumer project granted by the Grant API.
     * DnsBindPermission is a global resource and location can only be global.
     * </pre>
     */
    public void getDnsBindPermission(
        com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.DnsBindPermission>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDnsBindPermissionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Revokes the bind permission from the customer provided principal(user /
     * service account) on the intranet VPC associated with the consumer project.
     * DnsBindPermission is a global resource and location can only be global.
     * </pre>
     */
    public void revokeDnsBindPermission(
        com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRevokeDnsBindPermissionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service VmwareEngine.
   *
   * <pre>
   * VMwareEngine manages VMware's private clusters in the Cloud.
   * </pre>
   */
  public static final class VmwareEngineBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<VmwareEngineBlockingStub> {
    private VmwareEngineBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VmwareEngineBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VmwareEngineBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists `PrivateCloud` resources in a given project and location.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse listPrivateClouds(
        com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPrivateCloudsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `PrivateCloud` resource by its resource name.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.PrivateCloud getPrivateCloud(
        com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPrivateCloudMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `PrivateCloud` resource in a given project and location.
     * Private clouds of type `STANDARD` and
     * `TIME_LIMITED` are zonal resources, `STRETCHED` private clouds are
     * regional.
     * Creating a private cloud also creates a [management
     * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components)
     * for that private cloud.
     * </pre>
     */
    public com.google.longrunning.Operation createPrivateCloud(
        com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePrivateCloudMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `PrivateCloud` resource. Only the following fields can be
     * updated: `description`.
     * Only fields specified in `updateMask` are applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.longrunning.Operation updatePrivateCloud(
        com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePrivateCloudMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Schedules a `PrivateCloud` resource for deletion.
     * A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state`
     * set to `DELETED` and `expireTime` set to the time when deletion is final
     * and can no longer be reversed. The delete operation is marked as done
     * as soon as the `PrivateCloud` is successfully scheduled for deletion
     * (this also applies when `delayHours` is set to zero), and the operation is
     * not kept in pending state until `PrivateCloud` is purged.
     * `PrivateCloud` can be restored using `UndeletePrivateCloud` method before
     * the `expireTime` elapses. When `expireTime` is reached, deletion is final
     * and all private cloud resources are irreversibly removed and billing stops.
     * During the final removal process, `PrivateCloud.state` is set to `PURGING`.
     * `PrivateCloud` can be polled using standard `GET` method for the whole
     * period of deletion and purging. It will not be returned only
     * when it is completely purged.
     * </pre>
     */
    public com.google.longrunning.Operation deletePrivateCloud(
        com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePrivateCloudMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a private cloud that was previously scheduled for deletion by
     * `DeletePrivateCloud`. A `PrivateCloud` resource scheduled for deletion has
     * `PrivateCloud.state` set to `DELETED` and `PrivateCloud.expireTime` set to
     * the time when deletion can no longer be reversed.
     * </pre>
     */
    public com.google.longrunning.Operation undeletePrivateCloud(
        com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeletePrivateCloudMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `Cluster` resources in a given private cloud.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListClustersResponse listClusters(
        com.google.cloud.vmwareengine.v1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `Cluster` resource by its resource name.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.Cluster getCluster(
        com.google.cloud.vmwareengine.v1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new cluster in a given private cloud.
     * Creating a new cluster provides additional nodes for
     * use in the parent private cloud and requires sufficient [node
     * quota](https://cloud.google.com/vmware-engine/quotas).
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(
        com.google.cloud.vmwareengine.v1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `Cluster` resource. Only fields specified in `updateMask` are
     * applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(
        com.google.cloud.vmwareengine.v1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or
     * gracefully shut down any workloads running on the cluster before deletion.
     * You cannot delete the management cluster of a private cloud using this
     * method.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCluster(
        com.google.cloud.vmwareengine.v1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists nodes in a given cluster.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListNodesResponse listNodes(
        com.google.cloud.vmwareengine.v1.ListNodesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNodesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single node.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.Node getNode(
        com.google.cloud.vmwareengine.v1.GetNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNodeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists external IP addresses assigned to VMware workload VMs in a given
     * private cloud.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse listExternalAddresses(
        com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExternalAddressesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists external IP addresses assigned to VMware workload VMs within the
     * scope of the given network policy.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesResponse
        fetchNetworkPolicyExternalAddresses(
            com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchNetworkPolicyExternalAddressesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single external IP address.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ExternalAddress getExternalAddress(
        com.google.cloud.vmwareengine.v1.GetExternalAddressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExternalAddressMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `ExternalAddress` resource in a given private cloud. The
     * network policy that corresponds to the private cloud must have the external
     * IP address network service enabled (`NetworkPolicy.external_ip`).
     * </pre>
     */
    public com.google.longrunning.Operation createExternalAddress(
        com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExternalAddressMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single external IP address.
     * Only fields specified in `update_mask` are applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.longrunning.Operation updateExternalAddress(
        com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExternalAddressMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single external IP address. When you delete an external IP
     * address, connectivity between the external IP address and the corresponding
     * internal IP address is lost.
     * </pre>
     */
    public com.google.longrunning.Operation deleteExternalAddress(
        com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExternalAddressMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists subnets in a given private cloud.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListSubnetsResponse listSubnets(
        com.google.cloud.vmwareengine.v1.ListSubnetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubnetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single subnet.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.Subnet getSubnet(
        com.google.cloud.vmwareengine.v1.GetSubnetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSubnetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single subnet. Only fields specified in
     * `update_mask` are applied.
     * *Note*: This API is synchronous and always returns a successful
     * `google.longrunning.Operation` (LRO). The returned LRO will only have
     * `done` and `response` fields.
     * </pre>
     */
    public com.google.longrunning.Operation updateSubnet(
        com.google.cloud.vmwareengine.v1.UpdateSubnetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSubnetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `ExternalAccessRule` resources in the specified network policy.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse listExternalAccessRules(
        com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExternalAccessRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single external access rule.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ExternalAccessRule getExternalAccessRule(
        com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExternalAccessRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new external access rule in a given network policy.
     * </pre>
     */
    public com.google.longrunning.Operation createExternalAccessRule(
        com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExternalAccessRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single external access rule.
     * Only fields specified in `update_mask` are applied.
     * </pre>
     */
    public com.google.longrunning.Operation updateExternalAccessRule(
        com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExternalAccessRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single external access rule.
     * </pre>
     */
    public com.google.longrunning.Operation deleteExternalAccessRule(
        com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExternalAccessRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists logging servers configured for a given private
     * cloud.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListLoggingServersResponse listLoggingServers(
        com.google.cloud.vmwareengine.v1.ListLoggingServersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLoggingServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a logging server.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.LoggingServer getLoggingServer(
        com.google.cloud.vmwareengine.v1.GetLoggingServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLoggingServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new logging server for a given private cloud.
     * </pre>
     */
    public com.google.longrunning.Operation createLoggingServer(
        com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLoggingServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single logging server.
     * Only fields specified in `update_mask` are applied.
     * </pre>
     */
    public com.google.longrunning.Operation updateLoggingServer(
        com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateLoggingServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single logging server.
     * </pre>
     */
    public com.google.longrunning.Operation deleteLoggingServer(
        com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteLoggingServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists node types
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListNodeTypesResponse listNodeTypes(
        com.google.cloud.vmwareengine.v1.ListNodeTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNodeTypesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single `NodeType`.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.NodeType getNodeType(
        com.google.cloud.vmwareengine.v1.GetNodeTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNodeTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of credentials for NSX appliance.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.Credentials showNsxCredentials(
        com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowNsxCredentialsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of credentials for Vcenter appliance.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.Credentials showVcenterCredentials(
        com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowVcenterCredentialsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resets credentials of the NSX appliance.
     * </pre>
     */
    public com.google.longrunning.Operation resetNsxCredentials(
        com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetNsxCredentialsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resets credentials of the Vcenter appliance.
     * </pre>
     */
    public com.google.longrunning.Operation resetVcenterCredentials(
        com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetVcenterCredentialsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the `DnsForwarding` config.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.DnsForwarding getDnsForwarding(
        com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDnsForwardingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of the `DnsForwarding` config, like associated
     * domains. Only fields specified in `update_mask` are applied.
     * </pre>
     */
    public com.google.longrunning.Operation updateDnsForwarding(
        com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDnsForwardingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `NetworkPeering` resource by its resource name. The resource
     * contains details of the network peering, such as peered
     * networks, import and export custom route configurations, and peering state.
     * NetworkPeering is a global resource and location can only be global.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.NetworkPeering getNetworkPeering(
        com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNetworkPeeringMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `NetworkPeering` resources in a given project. NetworkPeering is a
     * global resource and location can only be global.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse listNetworkPeerings(
        com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNetworkPeeringsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new network peering between the peer network and VMware Engine
     * network provided in a `NetworkPeering` resource. NetworkPeering is a
     * global resource and location can only be global.
     * </pre>
     */
    public com.google.longrunning.Operation createNetworkPeering(
        com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNetworkPeeringMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `NetworkPeering` resource. When a network peering is deleted for
     * a VMware Engine network, the peer network becomes inaccessible to that
     * VMware Engine network. NetworkPeering is a global resource and location can
     * only be global.
     * </pre>
     */
    public com.google.longrunning.Operation deleteNetworkPeering(
        com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNetworkPeeringMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `NetworkPeering` resource. Only the `description` field can be
     * updated. Only fields specified in `updateMask` are applied. NetworkPeering
     * is a global resource and location can only be global.
     * </pre>
     */
    public com.google.longrunning.Operation updateNetworkPeering(
        com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNetworkPeeringMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the network peering routes exchanged over a peering connection.
     * NetworkPeering is a global resource and location can only be global.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse listPeeringRoutes(
        com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPeeringRoutesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new HCX activation key in a given private cloud.
     * </pre>
     */
    public com.google.longrunning.Operation createHcxActivationKey(
        com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHcxActivationKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `HcxActivationKey` resources in a given private cloud.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse listHcxActivationKeys(
        com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHcxActivationKeysMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `HcxActivationKey` resource by its resource name.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.HcxActivationKey getHcxActivationKey(
        com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHcxActivationKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `NetworkPolicy` resource by its resource name.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.NetworkPolicy getNetworkPolicy(
        com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNetworkPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `NetworkPolicy` resources in a specified project and location.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse listNetworkPolicies(
        com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNetworkPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new network policy in a given VMware Engine network of a
     * project and location (region). A new network policy cannot be created if
     * another network policy already exists in the same scope.
     * </pre>
     */
    public com.google.longrunning.Operation createNetworkPolicy(
        com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNetworkPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `NetworkPolicy` resource. Only the following fields can be
     * updated: `internet_access`, `external_ip`, `edge_services_cidr`.
     * Only fields specified in `updateMask` are applied. When updating a network
     * policy, the external IP network service can only be disabled if there are
     * no external IP addresses present in the scope of the policy. Also, a
     * `NetworkService` cannot be updated when `NetworkService.state` is set
     * to `RECONCILING`.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.longrunning.Operation updateNetworkPolicy(
        com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNetworkPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted
     * when `NetworkService.state` is set to `RECONCILING` for either its external
     * IP or internet access service.
     * </pre>
     */
    public com.google.longrunning.Operation deleteNetworkPolicy(
        com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNetworkPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Consumer VPCs bound to Management DNS Zone of a given private cloud.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse
        listManagementDnsZoneBindings(
            com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListManagementDnsZoneBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a 'ManagementDnsZoneBinding' resource by its resource name.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding getManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetManagementDnsZoneBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `ManagementDnsZoneBinding` resource in a private cloud.
     * This RPC creates the DNS binding and the resource that represents the
     * DNS binding of the consumer VPC network to the management DNS zone. A
     * management DNS zone is the Cloud DNS cross-project binding zone that
     * VMware Engine creates for each private cloud. It contains FQDNs and
     * corresponding IP addresses for the private cloud's ESXi hosts and
     * management VM appliances like vCenter and NSX Manager.
     * </pre>
     */
    public com.google.longrunning.Operation createManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateManagementDnsZoneBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `ManagementDnsZoneBinding` resource.
     * Only fields specified in `update_mask` are applied.
     * </pre>
     */
    public com.google.longrunning.Operation updateManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateManagementDnsZoneBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `ManagementDnsZoneBinding` resource. When a management DNS zone
     * binding is deleted, the corresponding consumer VPC network is no longer
     * bound to the management DNS zone.
     * </pre>
     */
    public com.google.longrunning.Operation deleteManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteManagementDnsZoneBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retries to create a `ManagementDnsZoneBinding` resource that is
     * in failed state.
     * </pre>
     */
    public com.google.longrunning.Operation repairManagementDnsZoneBinding(
        com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRepairManagementDnsZoneBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new VMware Engine network that can be used by a private cloud.
     * </pre>
     */
    public com.google.longrunning.Operation createVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVmwareEngineNetworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a VMware Engine network resource. Only the following fields can be
     * updated: `description`. Only fields specified in `updateMask` are
     * applied.
     * </pre>
     */
    public com.google.longrunning.Operation updateVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVmwareEngineNetworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware
     * Engine network after all resources that refer to it are deleted. For
     * example, a private cloud, a network peering, and a network policy can all
     * refer to the same VMware Engine network.
     * </pre>
     */
    public com.google.longrunning.Operation deleteVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVmwareEngineNetworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `VmwareEngineNetwork` resource by its resource name. The
     * resource contains details of the VMware Engine network, such as its VMware
     * Engine network type, peered networks in a service project, and state
     * (for example, `CREATING`, `ACTIVE`, `DELETING`).
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.VmwareEngineNetwork getVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVmwareEngineNetworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `VmwareEngineNetwork` resources in a given project and location.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse
        listVmwareEngineNetworks(
            com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVmwareEngineNetworksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new private connection that can be used for accessing private
     * Clouds.
     * </pre>
     */
    public com.google.longrunning.Operation createPrivateConnection(
        com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePrivateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `PrivateConnection` resource by its resource name. The resource
     * contains details of the private connection, such as connected
     * network, routing mode and state.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.PrivateConnection getPrivateConnection(
        com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPrivateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `PrivateConnection` resources in a given project and location.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse listPrivateConnections(
        com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPrivateConnectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `PrivateConnection` resource. Only `description` and
     * `routing_mode` fields can be updated. Only fields specified in `updateMask`
     * are applied.
     * </pre>
     */
    public com.google.longrunning.Operation updatePrivateConnection(
        com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePrivateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `PrivateConnection` resource. When a private connection is
     * deleted for a VMware Engine network, the connected network becomes
     * inaccessible to that VMware Engine network.
     * </pre>
     */
    public com.google.longrunning.Operation deletePrivateConnection(
        com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePrivateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the private connection routes exchanged over a peering connection.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesResponse
        listPrivateConnectionPeeringRoutes(
            com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPrivateConnectionPeeringRoutesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Grants the bind permission to the customer provided principal(user /
     * service account) to bind their DNS zone with the intranet VPC associated
     * with the project. DnsBindPermission is a global resource and location can
     * only be global.
     * </pre>
     */
    public com.google.longrunning.Operation grantDnsBindPermission(
        com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGrantDnsBindPermissionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets all the principals having bind permission on the intranet VPC
     * associated with the consumer project granted by the Grant API.
     * DnsBindPermission is a global resource and location can only be global.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.DnsBindPermission getDnsBindPermission(
        com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDnsBindPermissionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Revokes the bind permission from the customer provided principal(user /
     * service account) on the intranet VPC associated with the consumer project.
     * DnsBindPermission is a global resource and location can only be global.
     * </pre>
     */
    public com.google.longrunning.Operation revokeDnsBindPermission(
        com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRevokeDnsBindPermissionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service VmwareEngine.
   *
   * <pre>
   * VMwareEngine manages VMware's private clusters in the Cloud.
   * </pre>
   */
  public static final class VmwareEngineFutureStub
      extends io.grpc.stub.AbstractFutureStub<VmwareEngineFutureStub> {
    private VmwareEngineFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VmwareEngineFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VmwareEngineFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists `PrivateCloud` resources in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse>
        listPrivateClouds(com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPrivateCloudsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `PrivateCloud` resource by its resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.PrivateCloud>
        getPrivateCloud(com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPrivateCloudMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `PrivateCloud` resource in a given project and location.
     * Private clouds of type `STANDARD` and
     * `TIME_LIMITED` are zonal resources, `STRETCHED` private clouds are
     * regional.
     * Creating a private cloud also creates a [management
     * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components)
     * for that private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPrivateCloud(com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePrivateCloudMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `PrivateCloud` resource. Only the following fields can be
     * updated: `description`.
     * Only fields specified in `updateMask` are applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updatePrivateCloud(com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePrivateCloudMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Schedules a `PrivateCloud` resource for deletion.
     * A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state`
     * set to `DELETED` and `expireTime` set to the time when deletion is final
     * and can no longer be reversed. The delete operation is marked as done
     * as soon as the `PrivateCloud` is successfully scheduled for deletion
     * (this also applies when `delayHours` is set to zero), and the operation is
     * not kept in pending state until `PrivateCloud` is purged.
     * `PrivateCloud` can be restored using `UndeletePrivateCloud` method before
     * the `expireTime` elapses. When `expireTime` is reached, deletion is final
     * and all private cloud resources are irreversibly removed and billing stops.
     * During the final removal process, `PrivateCloud.state` is set to `PURGING`.
     * `PrivateCloud` can be polled using standard `GET` method for the whole
     * period of deletion and purging. It will not be returned only
     * when it is completely purged.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePrivateCloud(com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePrivateCloudMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a private cloud that was previously scheduled for deletion by
     * `DeletePrivateCloud`. A `PrivateCloud` resource scheduled for deletion has
     * `PrivateCloud.state` set to `DELETED` and `PrivateCloud.expireTime` set to
     * the time when deletion can no longer be reversed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeletePrivateCloud(com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeletePrivateCloudMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `Cluster` resources in a given private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListClustersResponse>
        listClusters(com.google.cloud.vmwareengine.v1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `Cluster` resource by its resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.Cluster>
        getCluster(com.google.cloud.vmwareengine.v1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new cluster in a given private cloud.
     * Creating a new cluster provides additional nodes for
     * use in the parent private cloud and requires sufficient [node
     * quota](https://cloud.google.com/vmware-engine/quotas).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCluster(com.google.cloud.vmwareengine.v1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `Cluster` resource. Only fields specified in `updateMask` are
     * applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCluster(com.google.cloud.vmwareengine.v1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or
     * gracefully shut down any workloads running on the cluster before deletion.
     * You cannot delete the management cluster of a private cloud using this
     * method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCluster(com.google.cloud.vmwareengine.v1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists nodes in a given cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListNodesResponse>
        listNodes(com.google.cloud.vmwareengine.v1.ListNodesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNodesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.Node>
        getNode(com.google.cloud.vmwareengine.v1.GetNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNodeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists external IP addresses assigned to VMware workload VMs in a given
     * private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse>
        listExternalAddresses(
            com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExternalAddressesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists external IP addresses assigned to VMware workload VMs within the
     * scope of the given network policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesResponse>
        fetchNetworkPolicyExternalAddresses(
            com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchNetworkPolicyExternalAddressesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single external IP address.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ExternalAddress>
        getExternalAddress(com.google.cloud.vmwareengine.v1.GetExternalAddressRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExternalAddressMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `ExternalAddress` resource in a given private cloud. The
     * network policy that corresponds to the private cloud must have the external
     * IP address network service enabled (`NetworkPolicy.external_ip`).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createExternalAddress(
            com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExternalAddressMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single external IP address.
     * Only fields specified in `update_mask` are applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateExternalAddress(
            com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExternalAddressMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single external IP address. When you delete an external IP
     * address, connectivity between the external IP address and the corresponding
     * internal IP address is lost.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteExternalAddress(
            com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExternalAddressMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists subnets in a given private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListSubnetsResponse>
        listSubnets(com.google.cloud.vmwareengine.v1.ListSubnetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSubnetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single subnet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.Subnet>
        getSubnet(com.google.cloud.vmwareengine.v1.GetSubnetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSubnetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single subnet. Only fields specified in
     * `update_mask` are applied.
     * *Note*: This API is synchronous and always returns a successful
     * `google.longrunning.Operation` (LRO). The returned LRO will only have
     * `done` and `response` fields.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSubnet(com.google.cloud.vmwareengine.v1.UpdateSubnetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSubnetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `ExternalAccessRule` resources in the specified network policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse>
        listExternalAccessRules(
            com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExternalAccessRulesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single external access rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ExternalAccessRule>
        getExternalAccessRule(
            com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExternalAccessRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new external access rule in a given network policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createExternalAccessRule(
            com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExternalAccessRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single external access rule.
     * Only fields specified in `update_mask` are applied.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateExternalAccessRule(
            com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExternalAccessRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single external access rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteExternalAccessRule(
            com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExternalAccessRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists logging servers configured for a given private
     * cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListLoggingServersResponse>
        listLoggingServers(com.google.cloud.vmwareengine.v1.ListLoggingServersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLoggingServersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a logging server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.LoggingServer>
        getLoggingServer(com.google.cloud.vmwareengine.v1.GetLoggingServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLoggingServerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new logging server for a given private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createLoggingServer(com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLoggingServerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single logging server.
     * Only fields specified in `update_mask` are applied.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateLoggingServer(com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateLoggingServerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single logging server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteLoggingServer(com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteLoggingServerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists node types
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListNodeTypesResponse>
        listNodeTypes(com.google.cloud.vmwareengine.v1.ListNodeTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNodeTypesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single `NodeType`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.NodeType>
        getNodeType(com.google.cloud.vmwareengine.v1.GetNodeTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNodeTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of credentials for NSX appliance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.Credentials>
        showNsxCredentials(com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowNsxCredentialsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of credentials for Vcenter appliance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.Credentials>
        showVcenterCredentials(
            com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowVcenterCredentialsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resets credentials of the NSX appliance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        resetNsxCredentials(com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetNsxCredentialsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resets credentials of the Vcenter appliance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        resetVcenterCredentials(
            com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetVcenterCredentialsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the `DnsForwarding` config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.DnsForwarding>
        getDnsForwarding(com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDnsForwardingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of the `DnsForwarding` config, like associated
     * domains. Only fields specified in `update_mask` are applied.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDnsForwarding(com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDnsForwardingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `NetworkPeering` resource by its resource name. The resource
     * contains details of the network peering, such as peered
     * networks, import and export custom route configurations, and peering state.
     * NetworkPeering is a global resource and location can only be global.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.NetworkPeering>
        getNetworkPeering(com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNetworkPeeringMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `NetworkPeering` resources in a given project. NetworkPeering is a
     * global resource and location can only be global.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse>
        listNetworkPeerings(com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNetworkPeeringsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new network peering between the peer network and VMware Engine
     * network provided in a `NetworkPeering` resource. NetworkPeering is a
     * global resource and location can only be global.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createNetworkPeering(com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNetworkPeeringMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `NetworkPeering` resource. When a network peering is deleted for
     * a VMware Engine network, the peer network becomes inaccessible to that
     * VMware Engine network. NetworkPeering is a global resource and location can
     * only be global.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteNetworkPeering(com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNetworkPeeringMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `NetworkPeering` resource. Only the `description` field can be
     * updated. Only fields specified in `updateMask` are applied. NetworkPeering
     * is a global resource and location can only be global.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateNetworkPeering(com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNetworkPeeringMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the network peering routes exchanged over a peering connection.
     * NetworkPeering is a global resource and location can only be global.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse>
        listPeeringRoutes(com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPeeringRoutesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new HCX activation key in a given private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createHcxActivationKey(
            com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHcxActivationKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `HcxActivationKey` resources in a given private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse>
        listHcxActivationKeys(
            com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHcxActivationKeysMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `HcxActivationKey` resource by its resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.HcxActivationKey>
        getHcxActivationKey(com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHcxActivationKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `NetworkPolicy` resource by its resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.NetworkPolicy>
        getNetworkPolicy(com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNetworkPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `NetworkPolicy` resources in a specified project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse>
        listNetworkPolicies(com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNetworkPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new network policy in a given VMware Engine network of a
     * project and location (region). A new network policy cannot be created if
     * another network policy already exists in the same scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createNetworkPolicy(com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNetworkPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `NetworkPolicy` resource. Only the following fields can be
     * updated: `internet_access`, `external_ip`, `edge_services_cidr`.
     * Only fields specified in `updateMask` are applied. When updating a network
     * policy, the external IP network service can only be disabled if there are
     * no external IP addresses present in the scope of the policy. Also, a
     * `NetworkService` cannot be updated when `NetworkService.state` is set
     * to `RECONCILING`.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateNetworkPolicy(com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNetworkPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted
     * when `NetworkService.state` is set to `RECONCILING` for either its external
     * IP or internet access service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteNetworkPolicy(com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNetworkPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Consumer VPCs bound to Management DNS Zone of a given private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse>
        listManagementDnsZoneBindings(
            com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListManagementDnsZoneBindingsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a 'ManagementDnsZoneBinding' resource by its resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding>
        getManagementDnsZoneBinding(
            com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetManagementDnsZoneBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `ManagementDnsZoneBinding` resource in a private cloud.
     * This RPC creates the DNS binding and the resource that represents the
     * DNS binding of the consumer VPC network to the management DNS zone. A
     * management DNS zone is the Cloud DNS cross-project binding zone that
     * VMware Engine creates for each private cloud. It contains FQDNs and
     * corresponding IP addresses for the private cloud's ESXi hosts and
     * management VM appliances like vCenter and NSX Manager.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createManagementDnsZoneBinding(
            com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateManagementDnsZoneBindingMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `ManagementDnsZoneBinding` resource.
     * Only fields specified in `update_mask` are applied.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateManagementDnsZoneBinding(
            com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateManagementDnsZoneBindingMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `ManagementDnsZoneBinding` resource. When a management DNS zone
     * binding is deleted, the corresponding consumer VPC network is no longer
     * bound to the management DNS zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteManagementDnsZoneBinding(
            com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteManagementDnsZoneBindingMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retries to create a `ManagementDnsZoneBinding` resource that is
     * in failed state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        repairManagementDnsZoneBinding(
            com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRepairManagementDnsZoneBindingMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new VMware Engine network that can be used by a private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createVmwareEngineNetwork(
            com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVmwareEngineNetworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a VMware Engine network resource. Only the following fields can be
     * updated: `description`. Only fields specified in `updateMask` are
     * applied.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateVmwareEngineNetwork(
            com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVmwareEngineNetworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware
     * Engine network after all resources that refer to it are deleted. For
     * example, a private cloud, a network peering, and a network policy can all
     * refer to the same VMware Engine network.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteVmwareEngineNetwork(
            com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVmwareEngineNetworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `VmwareEngineNetwork` resource by its resource name. The
     * resource contains details of the VMware Engine network, such as its VMware
     * Engine network type, peered networks in a service project, and state
     * (for example, `CREATING`, `ACTIVE`, `DELETING`).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.VmwareEngineNetwork>
        getVmwareEngineNetwork(
            com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVmwareEngineNetworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `VmwareEngineNetwork` resources in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse>
        listVmwareEngineNetworks(
            com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVmwareEngineNetworksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new private connection that can be used for accessing private
     * Clouds.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPrivateConnection(
            com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePrivateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `PrivateConnection` resource by its resource name. The resource
     * contains details of the private connection, such as connected
     * network, routing mode and state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.PrivateConnection>
        getPrivateConnection(com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPrivateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists `PrivateConnection` resources in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse>
        listPrivateConnections(
            com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPrivateConnectionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies a `PrivateConnection` resource. Only `description` and
     * `routing_mode` fields can be updated. Only fields specified in `updateMask`
     * are applied.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updatePrivateConnection(
            com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePrivateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `PrivateConnection` resource. When a private connection is
     * deleted for a VMware Engine network, the connected network becomes
     * inaccessible to that VMware Engine network.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePrivateConnection(
            com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePrivateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the private connection routes exchanged over a peering connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesResponse>
        listPrivateConnectionPeeringRoutes(
            com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPrivateConnectionPeeringRoutesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Grants the bind permission to the customer provided principal(user /
     * service account) to bind their DNS zone with the intranet VPC associated
     * with the project. DnsBindPermission is a global resource and location can
     * only be global.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        grantDnsBindPermission(
            com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGrantDnsBindPermissionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets all the principals having bind permission on the intranet VPC
     * associated with the consumer project granted by the Grant API.
     * DnsBindPermission is a global resource and location can only be global.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmwareengine.v1.DnsBindPermission>
        getDnsBindPermission(com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDnsBindPermissionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Revokes the bind permission from the customer provided principal(user /
     * service account) on the intranet VPC associated with the consumer project.
     * DnsBindPermission is a global resource and location can only be global.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        revokeDnsBindPermission(
            com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRevokeDnsBindPermissionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_PRIVATE_CLOUDS = 0;
  private static final int METHODID_GET_PRIVATE_CLOUD = 1;
  private static final int METHODID_CREATE_PRIVATE_CLOUD = 2;
  private static final int METHODID_UPDATE_PRIVATE_CLOUD = 3;
  private static final int METHODID_DELETE_PRIVATE_CLOUD = 4;
  private static final int METHODID_UNDELETE_PRIVATE_CLOUD = 5;
  private static final int METHODID_LIST_CLUSTERS = 6;
  private static final int METHODID_GET_CLUSTER = 7;
  private static final int METHODID_CREATE_CLUSTER = 8;
  private static final int METHODID_UPDATE_CLUSTER = 9;
  private static final int METHODID_DELETE_CLUSTER = 10;
  private static final int METHODID_LIST_NODES = 11;
  private static final int METHODID_GET_NODE = 12;
  private static final int METHODID_LIST_EXTERNAL_ADDRESSES = 13;
  private static final int METHODID_FETCH_NETWORK_POLICY_EXTERNAL_ADDRESSES = 14;
  private static final int METHODID_GET_EXTERNAL_ADDRESS = 15;
  private static final int METHODID_CREATE_EXTERNAL_ADDRESS = 16;
  private static final int METHODID_UPDATE_EXTERNAL_ADDRESS = 17;
  private static final int METHODID_DELETE_EXTERNAL_ADDRESS = 18;
  private static final int METHODID_LIST_SUBNETS = 19;
  private static final int METHODID_GET_SUBNET = 20;
  private static final int METHODID_UPDATE_SUBNET = 21;
  private static final int METHODID_LIST_EXTERNAL_ACCESS_RULES = 22;
  private static final int METHODID_GET_EXTERNAL_ACCESS_RULE = 23;
  private static final int METHODID_CREATE_EXTERNAL_ACCESS_RULE = 24;
  private static final int METHODID_UPDATE_EXTERNAL_ACCESS_RULE = 25;
  private static final int METHODID_DELETE_EXTERNAL_ACCESS_RULE = 26;
  private static final int METHODID_LIST_LOGGING_SERVERS = 27;
  private static final int METHODID_GET_LOGGING_SERVER = 28;
  private static final int METHODID_CREATE_LOGGING_SERVER = 29;
  private static final int METHODID_UPDATE_LOGGING_SERVER = 30;
  private static final int METHODID_DELETE_LOGGING_SERVER = 31;
  private static final int METHODID_LIST_NODE_TYPES = 32;
  private static final int METHODID_GET_NODE_TYPE = 33;
  private static final int METHODID_SHOW_NSX_CREDENTIALS = 34;
  private static final int METHODID_SHOW_VCENTER_CREDENTIALS = 35;
  private static final int METHODID_RESET_NSX_CREDENTIALS = 36;
  private static final int METHODID_RESET_VCENTER_CREDENTIALS = 37;
  private static final int METHODID_GET_DNS_FORWARDING = 38;
  private static final int METHODID_UPDATE_DNS_FORWARDING = 39;
  private static final int METHODID_GET_NETWORK_PEERING = 40;
  private static final int METHODID_LIST_NETWORK_PEERINGS = 41;
  private static final int METHODID_CREATE_NETWORK_PEERING = 42;
  private static final int METHODID_DELETE_NETWORK_PEERING = 43;
  private static final int METHODID_UPDATE_NETWORK_PEERING = 44;
  private static final int METHODID_LIST_PEERING_ROUTES = 45;
  private static final int METHODID_CREATE_HCX_ACTIVATION_KEY = 46;
  private static final int METHODID_LIST_HCX_ACTIVATION_KEYS = 47;
  private static final int METHODID_GET_HCX_ACTIVATION_KEY = 48;
  private static final int METHODID_GET_NETWORK_POLICY = 49;
  private static final int METHODID_LIST_NETWORK_POLICIES = 50;
  private static final int METHODID_CREATE_NETWORK_POLICY = 51;
  private static final int METHODID_UPDATE_NETWORK_POLICY = 52;
  private static final int METHODID_DELETE_NETWORK_POLICY = 53;
  private static final int METHODID_LIST_MANAGEMENT_DNS_ZONE_BINDINGS = 54;
  private static final int METHODID_GET_MANAGEMENT_DNS_ZONE_BINDING = 55;
  private static final int METHODID_CREATE_MANAGEMENT_DNS_ZONE_BINDING = 56;
  private static final int METHODID_UPDATE_MANAGEMENT_DNS_ZONE_BINDING = 57;
  private static final int METHODID_DELETE_MANAGEMENT_DNS_ZONE_BINDING = 58;
  private static final int METHODID_REPAIR_MANAGEMENT_DNS_ZONE_BINDING = 59;
  private static final int METHODID_CREATE_VMWARE_ENGINE_NETWORK = 60;
  private static final int METHODID_UPDATE_VMWARE_ENGINE_NETWORK = 61;
  private static final int METHODID_DELETE_VMWARE_ENGINE_NETWORK = 62;
  private static final int METHODID_GET_VMWARE_ENGINE_NETWORK = 63;
  private static final int METHODID_LIST_VMWARE_ENGINE_NETWORKS = 64;
  private static final int METHODID_CREATE_PRIVATE_CONNECTION = 65;
  private static final int METHODID_GET_PRIVATE_CONNECTION = 66;
  private static final int METHODID_LIST_PRIVATE_CONNECTIONS = 67;
  private static final int METHODID_UPDATE_PRIVATE_CONNECTION = 68;
  private static final int METHODID_DELETE_PRIVATE_CONNECTION = 69;
  private static final int METHODID_LIST_PRIVATE_CONNECTION_PEERING_ROUTES = 70;
  private static final int METHODID_GRANT_DNS_BIND_PERMISSION = 71;
  private static final int METHODID_GET_DNS_BIND_PERMISSION = 72;
  private static final int METHODID_REVOKE_DNS_BIND_PERMISSION = 73;

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
        case METHODID_LIST_PRIVATE_CLOUDS:
          serviceImpl.listPrivateClouds(
              (com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PRIVATE_CLOUD:
          serviceImpl.getPrivateCloud(
              (com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.PrivateCloud>)
                  responseObserver);
          break;
        case METHODID_CREATE_PRIVATE_CLOUD:
          serviceImpl.createPrivateCloud(
              (com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_PRIVATE_CLOUD:
          serviceImpl.updatePrivateCloud(
              (com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_PRIVATE_CLOUD:
          serviceImpl.deletePrivateCloud(
              (com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDELETE_PRIVATE_CLOUD:
          serviceImpl.undeletePrivateCloud(
              (com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters(
              (com.google.cloud.vmwareengine.v1.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListClustersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster(
              (com.google.cloud.vmwareengine.v1.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Cluster>)
                  responseObserver);
          break;
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster(
              (com.google.cloud.vmwareengine.v1.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster(
              (com.google.cloud.vmwareengine.v1.UpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster(
              (com.google.cloud.vmwareengine.v1.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_NODES:
          serviceImpl.listNodes(
              (com.google.cloud.vmwareengine.v1.ListNodesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNodesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_NODE:
          serviceImpl.getNode(
              (com.google.cloud.vmwareengine.v1.GetNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Node>)
                  responseObserver);
          break;
        case METHODID_LIST_EXTERNAL_ADDRESSES:
          serviceImpl.listExternalAddresses(
              (com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_NETWORK_POLICY_EXTERNAL_ADDRESSES:
          serviceImpl.fetchNetworkPolicyExternalAddresses(
              (com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EXTERNAL_ADDRESS:
          serviceImpl.getExternalAddress(
              (com.google.cloud.vmwareengine.v1.GetExternalAddressRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ExternalAddress>)
                  responseObserver);
          break;
        case METHODID_CREATE_EXTERNAL_ADDRESS:
          serviceImpl.createExternalAddress(
              (com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_EXTERNAL_ADDRESS:
          serviceImpl.updateExternalAddress(
              (com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_EXTERNAL_ADDRESS:
          serviceImpl.deleteExternalAddress(
              (com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SUBNETS:
          serviceImpl.listSubnets(
              (com.google.cloud.vmwareengine.v1.ListSubnetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListSubnetsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SUBNET:
          serviceImpl.getSubnet(
              (com.google.cloud.vmwareengine.v1.GetSubnetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Subnet>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SUBNET:
          serviceImpl.updateSubnet(
              (com.google.cloud.vmwareengine.v1.UpdateSubnetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_EXTERNAL_ACCESS_RULES:
          serviceImpl.listExternalAccessRules(
              (com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EXTERNAL_ACCESS_RULE:
          serviceImpl.getExternalAccessRule(
              (com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ExternalAccessRule>)
                  responseObserver);
          break;
        case METHODID_CREATE_EXTERNAL_ACCESS_RULE:
          serviceImpl.createExternalAccessRule(
              (com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_EXTERNAL_ACCESS_RULE:
          serviceImpl.updateExternalAccessRule(
              (com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_EXTERNAL_ACCESS_RULE:
          serviceImpl.deleteExternalAccessRule(
              (com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_LOGGING_SERVERS:
          serviceImpl.listLoggingServers(
              (com.google.cloud.vmwareengine.v1.ListLoggingServersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.ListLoggingServersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_LOGGING_SERVER:
          serviceImpl.getLoggingServer(
              (com.google.cloud.vmwareengine.v1.GetLoggingServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.LoggingServer>)
                  responseObserver);
          break;
        case METHODID_CREATE_LOGGING_SERVER:
          serviceImpl.createLoggingServer(
              (com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_LOGGING_SERVER:
          serviceImpl.updateLoggingServer(
              (com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_LOGGING_SERVER:
          serviceImpl.deleteLoggingServer(
              (com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_NODE_TYPES:
          serviceImpl.listNodeTypes(
              (com.google.cloud.vmwareengine.v1.ListNodeTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNodeTypesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_NODE_TYPE:
          serviceImpl.getNodeType(
              (com.google.cloud.vmwareengine.v1.GetNodeTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NodeType>)
                  responseObserver);
          break;
        case METHODID_SHOW_NSX_CREDENTIALS:
          serviceImpl.showNsxCredentials(
              (com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Credentials>)
                  responseObserver);
          break;
        case METHODID_SHOW_VCENTER_CREDENTIALS:
          serviceImpl.showVcenterCredentials(
              (com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Credentials>)
                  responseObserver);
          break;
        case METHODID_RESET_NSX_CREDENTIALS:
          serviceImpl.resetNsxCredentials(
              (com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESET_VCENTER_CREDENTIALS:
          serviceImpl.resetVcenterCredentials(
              (com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DNS_FORWARDING:
          serviceImpl.getDnsForwarding(
              (com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.DnsForwarding>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DNS_FORWARDING:
          serviceImpl.updateDnsForwarding(
              (com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_NETWORK_PEERING:
          serviceImpl.getNetworkPeering(
              (com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NetworkPeering>)
                  responseObserver);
          break;
        case METHODID_LIST_NETWORK_PEERINGS:
          serviceImpl.listNetworkPeerings(
              (com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_NETWORK_PEERING:
          serviceImpl.createNetworkPeering(
              (com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_NETWORK_PEERING:
          serviceImpl.deleteNetworkPeering(
              (com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_NETWORK_PEERING:
          serviceImpl.updateNetworkPeering(
              (com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_PEERING_ROUTES:
          serviceImpl.listPeeringRoutes(
              (com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_HCX_ACTIVATION_KEY:
          serviceImpl.createHcxActivationKey(
              (com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_HCX_ACTIVATION_KEYS:
          serviceImpl.listHcxActivationKeys(
              (com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse>)
                  responseObserver);
          break;
        case METHODID_GET_HCX_ACTIVATION_KEY:
          serviceImpl.getHcxActivationKey(
              (com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.HcxActivationKey>)
                  responseObserver);
          break;
        case METHODID_GET_NETWORK_POLICY:
          serviceImpl.getNetworkPolicy(
              (com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NetworkPolicy>)
                  responseObserver);
          break;
        case METHODID_LIST_NETWORK_POLICIES:
          serviceImpl.listNetworkPolicies(
              (com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_NETWORK_POLICY:
          serviceImpl.createNetworkPolicy(
              (com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_NETWORK_POLICY:
          serviceImpl.updateNetworkPolicy(
              (com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_NETWORK_POLICY:
          serviceImpl.deleteNetworkPolicy(
              (com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_MANAGEMENT_DNS_ZONE_BINDINGS:
          serviceImpl.listManagementDnsZoneBindings(
              (com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MANAGEMENT_DNS_ZONE_BINDING:
          serviceImpl.getManagementDnsZoneBinding(
              (com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding>)
                  responseObserver);
          break;
        case METHODID_CREATE_MANAGEMENT_DNS_ZONE_BINDING:
          serviceImpl.createManagementDnsZoneBinding(
              (com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MANAGEMENT_DNS_ZONE_BINDING:
          serviceImpl.updateManagementDnsZoneBinding(
              (com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MANAGEMENT_DNS_ZONE_BINDING:
          serviceImpl.deleteManagementDnsZoneBinding(
              (com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REPAIR_MANAGEMENT_DNS_ZONE_BINDING:
          serviceImpl.repairManagementDnsZoneBinding(
              (com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_VMWARE_ENGINE_NETWORK:
          serviceImpl.createVmwareEngineNetwork(
              (com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_VMWARE_ENGINE_NETWORK:
          serviceImpl.updateVmwareEngineNetwork(
              (com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_VMWARE_ENGINE_NETWORK:
          serviceImpl.deleteVmwareEngineNetwork(
              (com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_VMWARE_ENGINE_NETWORK:
          serviceImpl.getVmwareEngineNetwork(
              (com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.VmwareEngineNetwork>)
                  responseObserver);
          break;
        case METHODID_LIST_VMWARE_ENGINE_NETWORKS:
          serviceImpl.listVmwareEngineNetworks(
              (com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_PRIVATE_CONNECTION:
          serviceImpl.createPrivateConnection(
              (com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_PRIVATE_CONNECTION:
          serviceImpl.getPrivateConnection(
              (com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.PrivateConnection>)
                  responseObserver);
          break;
        case METHODID_LIST_PRIVATE_CONNECTIONS:
          serviceImpl.listPrivateConnections(
              (com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PRIVATE_CONNECTION:
          serviceImpl.updatePrivateConnection(
              (com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_PRIVATE_CONNECTION:
          serviceImpl.deletePrivateConnection(
              (com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_PRIVATE_CONNECTION_PEERING_ROUTES:
          serviceImpl.listPrivateConnectionPeeringRoutes(
              (com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesResponse>)
                  responseObserver);
          break;
        case METHODID_GRANT_DNS_BIND_PERMISSION:
          serviceImpl.grantDnsBindPermission(
              (com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DNS_BIND_PERMISSION:
          serviceImpl.getDnsBindPermission(
              (com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.DnsBindPermission>)
                  responseObserver);
          break;
        case METHODID_REVOKE_DNS_BIND_PERMISSION:
          serviceImpl.revokeDnsBindPermission(
              (com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest) request,
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
            getListPrivateCloudsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest,
                    com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse>(
                    service, METHODID_LIST_PRIVATE_CLOUDS)))
        .addMethod(
            getGetPrivateCloudMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest,
                    com.google.cloud.vmwareengine.v1.PrivateCloud>(
                    service, METHODID_GET_PRIVATE_CLOUD)))
        .addMethod(
            getCreatePrivateCloudMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_PRIVATE_CLOUD)))
        .addMethod(
            getUpdatePrivateCloudMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_PRIVATE_CLOUD)))
        .addMethod(
            getDeletePrivateCloudMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_PRIVATE_CLOUD)))
        .addMethod(
            getUndeletePrivateCloudMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest,
                    com.google.longrunning.Operation>(service, METHODID_UNDELETE_PRIVATE_CLOUD)))
        .addMethod(
            getListClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListClustersRequest,
                    com.google.cloud.vmwareengine.v1.ListClustersResponse>(
                    service, METHODID_LIST_CLUSTERS)))
        .addMethod(
            getGetClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetClusterRequest,
                    com.google.cloud.vmwareengine.v1.Cluster>(service, METHODID_GET_CLUSTER)))
        .addMethod(
            getCreateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.CreateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CLUSTER)))
        .addMethod(
            getUpdateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.UpdateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CLUSTER)))
        .addMethod(
            getDeleteClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.DeleteClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CLUSTER)))
        .addMethod(
            getListNodesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListNodesRequest,
                    com.google.cloud.vmwareengine.v1.ListNodesResponse>(
                    service, METHODID_LIST_NODES)))
        .addMethod(
            getGetNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetNodeRequest,
                    com.google.cloud.vmwareengine.v1.Node>(service, METHODID_GET_NODE)))
        .addMethod(
            getListExternalAddressesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest,
                    com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse>(
                    service, METHODID_LIST_EXTERNAL_ADDRESSES)))
        .addMethod(
            getFetchNetworkPolicyExternalAddressesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesRequest,
                    com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesResponse>(
                    service, METHODID_FETCH_NETWORK_POLICY_EXTERNAL_ADDRESSES)))
        .addMethod(
            getGetExternalAddressMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetExternalAddressRequest,
                    com.google.cloud.vmwareengine.v1.ExternalAddress>(
                    service, METHODID_GET_EXTERNAL_ADDRESS)))
        .addMethod(
            getCreateExternalAddressMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_EXTERNAL_ADDRESS)))
        .addMethod(
            getUpdateExternalAddressMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_EXTERNAL_ADDRESS)))
        .addMethod(
            getDeleteExternalAddressMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_EXTERNAL_ADDRESS)))
        .addMethod(
            getListSubnetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListSubnetsRequest,
                    com.google.cloud.vmwareengine.v1.ListSubnetsResponse>(
                    service, METHODID_LIST_SUBNETS)))
        .addMethod(
            getGetSubnetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetSubnetRequest,
                    com.google.cloud.vmwareengine.v1.Subnet>(service, METHODID_GET_SUBNET)))
        .addMethod(
            getUpdateSubnetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.UpdateSubnetRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SUBNET)))
        .addMethod(
            getListExternalAccessRulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest,
                    com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse>(
                    service, METHODID_LIST_EXTERNAL_ACCESS_RULES)))
        .addMethod(
            getGetExternalAccessRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest,
                    com.google.cloud.vmwareengine.v1.ExternalAccessRule>(
                    service, METHODID_GET_EXTERNAL_ACCESS_RULE)))
        .addMethod(
            getCreateExternalAccessRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_EXTERNAL_ACCESS_RULE)))
        .addMethod(
            getUpdateExternalAccessRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_EXTERNAL_ACCESS_RULE)))
        .addMethod(
            getDeleteExternalAccessRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_EXTERNAL_ACCESS_RULE)))
        .addMethod(
            getListLoggingServersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListLoggingServersRequest,
                    com.google.cloud.vmwareengine.v1.ListLoggingServersResponse>(
                    service, METHODID_LIST_LOGGING_SERVERS)))
        .addMethod(
            getGetLoggingServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetLoggingServerRequest,
                    com.google.cloud.vmwareengine.v1.LoggingServer>(
                    service, METHODID_GET_LOGGING_SERVER)))
        .addMethod(
            getCreateLoggingServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_LOGGING_SERVER)))
        .addMethod(
            getUpdateLoggingServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_LOGGING_SERVER)))
        .addMethod(
            getDeleteLoggingServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_LOGGING_SERVER)))
        .addMethod(
            getListNodeTypesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListNodeTypesRequest,
                    com.google.cloud.vmwareengine.v1.ListNodeTypesResponse>(
                    service, METHODID_LIST_NODE_TYPES)))
        .addMethod(
            getGetNodeTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetNodeTypeRequest,
                    com.google.cloud.vmwareengine.v1.NodeType>(service, METHODID_GET_NODE_TYPE)))
        .addMethod(
            getShowNsxCredentialsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest,
                    com.google.cloud.vmwareengine.v1.Credentials>(
                    service, METHODID_SHOW_NSX_CREDENTIALS)))
        .addMethod(
            getShowVcenterCredentialsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest,
                    com.google.cloud.vmwareengine.v1.Credentials>(
                    service, METHODID_SHOW_VCENTER_CREDENTIALS)))
        .addMethod(
            getResetNsxCredentialsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESET_NSX_CREDENTIALS)))
        .addMethod(
            getResetVcenterCredentialsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESET_VCENTER_CREDENTIALS)))
        .addMethod(
            getGetDnsForwardingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest,
                    com.google.cloud.vmwareengine.v1.DnsForwarding>(
                    service, METHODID_GET_DNS_FORWARDING)))
        .addMethod(
            getUpdateDnsForwardingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DNS_FORWARDING)))
        .addMethod(
            getGetNetworkPeeringMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest,
                    com.google.cloud.vmwareengine.v1.NetworkPeering>(
                    service, METHODID_GET_NETWORK_PEERING)))
        .addMethod(
            getListNetworkPeeringsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest,
                    com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse>(
                    service, METHODID_LIST_NETWORK_PEERINGS)))
        .addMethod(
            getCreateNetworkPeeringMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_NETWORK_PEERING)))
        .addMethod(
            getDeleteNetworkPeeringMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_NETWORK_PEERING)))
        .addMethod(
            getUpdateNetworkPeeringMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_NETWORK_PEERING)))
        .addMethod(
            getListPeeringRoutesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest,
                    com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse>(
                    service, METHODID_LIST_PEERING_ROUTES)))
        .addMethod(
            getCreateHcxActivationKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_HCX_ACTIVATION_KEY)))
        .addMethod(
            getListHcxActivationKeysMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest,
                    com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse>(
                    service, METHODID_LIST_HCX_ACTIVATION_KEYS)))
        .addMethod(
            getGetHcxActivationKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest,
                    com.google.cloud.vmwareengine.v1.HcxActivationKey>(
                    service, METHODID_GET_HCX_ACTIVATION_KEY)))
        .addMethod(
            getGetNetworkPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest,
                    com.google.cloud.vmwareengine.v1.NetworkPolicy>(
                    service, METHODID_GET_NETWORK_POLICY)))
        .addMethod(
            getListNetworkPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest,
                    com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse>(
                    service, METHODID_LIST_NETWORK_POLICIES)))
        .addMethod(
            getCreateNetworkPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_NETWORK_POLICY)))
        .addMethod(
            getUpdateNetworkPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_NETWORK_POLICY)))
        .addMethod(
            getDeleteNetworkPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_NETWORK_POLICY)))
        .addMethod(
            getListManagementDnsZoneBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest,
                    com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse>(
                    service, METHODID_LIST_MANAGEMENT_DNS_ZONE_BINDINGS)))
        .addMethod(
            getGetManagementDnsZoneBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest,
                    com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding>(
                    service, METHODID_GET_MANAGEMENT_DNS_ZONE_BINDING)))
        .addMethod(
            getCreateManagementDnsZoneBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_MANAGEMENT_DNS_ZONE_BINDING)))
        .addMethod(
            getUpdateManagementDnsZoneBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_MANAGEMENT_DNS_ZONE_BINDING)))
        .addMethod(
            getDeleteManagementDnsZoneBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_MANAGEMENT_DNS_ZONE_BINDING)))
        .addMethod(
            getRepairManagementDnsZoneBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_REPAIR_MANAGEMENT_DNS_ZONE_BINDING)))
        .addMethod(
            getCreateVmwareEngineNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_VMWARE_ENGINE_NETWORK)))
        .addMethod(
            getUpdateVmwareEngineNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_VMWARE_ENGINE_NETWORK)))
        .addMethod(
            getDeleteVmwareEngineNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_VMWARE_ENGINE_NETWORK)))
        .addMethod(
            getGetVmwareEngineNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest,
                    com.google.cloud.vmwareengine.v1.VmwareEngineNetwork>(
                    service, METHODID_GET_VMWARE_ENGINE_NETWORK)))
        .addMethod(
            getListVmwareEngineNetworksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest,
                    com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse>(
                    service, METHODID_LIST_VMWARE_ENGINE_NETWORKS)))
        .addMethod(
            getCreatePrivateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_PRIVATE_CONNECTION)))
        .addMethod(
            getGetPrivateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest,
                    com.google.cloud.vmwareengine.v1.PrivateConnection>(
                    service, METHODID_GET_PRIVATE_CONNECTION)))
        .addMethod(
            getListPrivateConnectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest,
                    com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse>(
                    service, METHODID_LIST_PRIVATE_CONNECTIONS)))
        .addMethod(
            getUpdatePrivateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_PRIVATE_CONNECTION)))
        .addMethod(
            getDeletePrivateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_PRIVATE_CONNECTION)))
        .addMethod(
            getListPrivateConnectionPeeringRoutesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesRequest,
                    com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesResponse>(
                    service, METHODID_LIST_PRIVATE_CONNECTION_PEERING_ROUTES)))
        .addMethod(
            getGrantDnsBindPermissionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest,
                    com.google.longrunning.Operation>(service, METHODID_GRANT_DNS_BIND_PERMISSION)))
        .addMethod(
            getGetDnsBindPermissionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest,
                    com.google.cloud.vmwareengine.v1.DnsBindPermission>(
                    service, METHODID_GET_DNS_BIND_PERMISSION)))
        .addMethod(
            getRevokeDnsBindPermissionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_REVOKE_DNS_BIND_PERMISSION)))
        .build();
  }

  private abstract static class VmwareEngineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VmwareEngineBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.vmwareengine.v1.VmwareengineProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VmwareEngine");
    }
  }

  private static final class VmwareEngineFileDescriptorSupplier
      extends VmwareEngineBaseDescriptorSupplier {
    VmwareEngineFileDescriptorSupplier() {}
  }

  private static final class VmwareEngineMethodDescriptorSupplier
      extends VmwareEngineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    VmwareEngineMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (VmwareEngineGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new VmwareEngineFileDescriptorSupplier())
                      .addMethod(getListPrivateCloudsMethod())
                      .addMethod(getGetPrivateCloudMethod())
                      .addMethod(getCreatePrivateCloudMethod())
                      .addMethod(getUpdatePrivateCloudMethod())
                      .addMethod(getDeletePrivateCloudMethod())
                      .addMethod(getUndeletePrivateCloudMethod())
                      .addMethod(getListClustersMethod())
                      .addMethod(getGetClusterMethod())
                      .addMethod(getCreateClusterMethod())
                      .addMethod(getUpdateClusterMethod())
                      .addMethod(getDeleteClusterMethod())
                      .addMethod(getListNodesMethod())
                      .addMethod(getGetNodeMethod())
                      .addMethod(getListExternalAddressesMethod())
                      .addMethod(getFetchNetworkPolicyExternalAddressesMethod())
                      .addMethod(getGetExternalAddressMethod())
                      .addMethod(getCreateExternalAddressMethod())
                      .addMethod(getUpdateExternalAddressMethod())
                      .addMethod(getDeleteExternalAddressMethod())
                      .addMethod(getListSubnetsMethod())
                      .addMethod(getGetSubnetMethod())
                      .addMethod(getUpdateSubnetMethod())
                      .addMethod(getListExternalAccessRulesMethod())
                      .addMethod(getGetExternalAccessRuleMethod())
                      .addMethod(getCreateExternalAccessRuleMethod())
                      .addMethod(getUpdateExternalAccessRuleMethod())
                      .addMethod(getDeleteExternalAccessRuleMethod())
                      .addMethod(getListLoggingServersMethod())
                      .addMethod(getGetLoggingServerMethod())
                      .addMethod(getCreateLoggingServerMethod())
                      .addMethod(getUpdateLoggingServerMethod())
                      .addMethod(getDeleteLoggingServerMethod())
                      .addMethod(getListNodeTypesMethod())
                      .addMethod(getGetNodeTypeMethod())
                      .addMethod(getShowNsxCredentialsMethod())
                      .addMethod(getShowVcenterCredentialsMethod())
                      .addMethod(getResetNsxCredentialsMethod())
                      .addMethod(getResetVcenterCredentialsMethod())
                      .addMethod(getGetDnsForwardingMethod())
                      .addMethod(getUpdateDnsForwardingMethod())
                      .addMethod(getGetNetworkPeeringMethod())
                      .addMethod(getListNetworkPeeringsMethod())
                      .addMethod(getCreateNetworkPeeringMethod())
                      .addMethod(getDeleteNetworkPeeringMethod())
                      .addMethod(getUpdateNetworkPeeringMethod())
                      .addMethod(getListPeeringRoutesMethod())
                      .addMethod(getCreateHcxActivationKeyMethod())
                      .addMethod(getListHcxActivationKeysMethod())
                      .addMethod(getGetHcxActivationKeyMethod())
                      .addMethod(getGetNetworkPolicyMethod())
                      .addMethod(getListNetworkPoliciesMethod())
                      .addMethod(getCreateNetworkPolicyMethod())
                      .addMethod(getUpdateNetworkPolicyMethod())
                      .addMethod(getDeleteNetworkPolicyMethod())
                      .addMethod(getListManagementDnsZoneBindingsMethod())
                      .addMethod(getGetManagementDnsZoneBindingMethod())
                      .addMethod(getCreateManagementDnsZoneBindingMethod())
                      .addMethod(getUpdateManagementDnsZoneBindingMethod())
                      .addMethod(getDeleteManagementDnsZoneBindingMethod())
                      .addMethod(getRepairManagementDnsZoneBindingMethod())
                      .addMethod(getCreateVmwareEngineNetworkMethod())
                      .addMethod(getUpdateVmwareEngineNetworkMethod())
                      .addMethod(getDeleteVmwareEngineNetworkMethod())
                      .addMethod(getGetVmwareEngineNetworkMethod())
                      .addMethod(getListVmwareEngineNetworksMethod())
                      .addMethod(getCreatePrivateConnectionMethod())
                      .addMethod(getGetPrivateConnectionMethod())
                      .addMethod(getListPrivateConnectionsMethod())
                      .addMethod(getUpdatePrivateConnectionMethod())
                      .addMethod(getDeletePrivateConnectionMethod())
                      .addMethod(getListPrivateConnectionPeeringRoutesMethod())
                      .addMethod(getGrantDnsBindPermissionMethod())
                      .addMethod(getGetDnsBindPermissionMethod())
                      .addMethod(getRevokeDnsBindPermissionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
