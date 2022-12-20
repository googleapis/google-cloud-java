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
package com.google.cloud.gkemulticloud.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The AzureClusters API provides a single centrally managed service
 * to create and manage Anthos clusters that run on Azure infrastructure.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gkemulticloud/v1/azure_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AzureClustersGrpc {

  private AzureClustersGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gkemulticloud.v1.AzureClusters";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest,
          com.google.longrunning.Operation>
      getCreateAzureClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAzureClient",
      requestType = com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest,
          com.google.longrunning.Operation>
      getCreateAzureClientMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest,
            com.google.longrunning.Operation>
        getCreateAzureClientMethod;
    if ((getCreateAzureClientMethod = AzureClustersGrpc.getCreateAzureClientMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getCreateAzureClientMethod = AzureClustersGrpc.getCreateAzureClientMethod) == null) {
          AzureClustersGrpc.getCreateAzureClientMethod =
              getCreateAzureClientMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAzureClient"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("CreateAzureClient"))
                      .build();
        }
      }
    }
    return getCreateAzureClientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GetAzureClientRequest,
          com.google.cloud.gkemulticloud.v1.AzureClient>
      getGetAzureClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAzureClient",
      requestType = com.google.cloud.gkemulticloud.v1.GetAzureClientRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.AzureClient.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GetAzureClientRequest,
          com.google.cloud.gkemulticloud.v1.AzureClient>
      getGetAzureClientMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.GetAzureClientRequest,
            com.google.cloud.gkemulticloud.v1.AzureClient>
        getGetAzureClientMethod;
    if ((getGetAzureClientMethod = AzureClustersGrpc.getGetAzureClientMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getGetAzureClientMethod = AzureClustersGrpc.getGetAzureClientMethod) == null) {
          AzureClustersGrpc.getGetAzureClientMethod =
              getGetAzureClientMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.GetAzureClientRequest,
                          com.google.cloud.gkemulticloud.v1.AzureClient>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAzureClient"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.GetAzureClientRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.AzureClient.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("GetAzureClient"))
                      .build();
        }
      }
    }
    return getGetAzureClientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest,
          com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse>
      getListAzureClientsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAzureClients",
      requestType = com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest,
          com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse>
      getListAzureClientsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest,
            com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse>
        getListAzureClientsMethod;
    if ((getListAzureClientsMethod = AzureClustersGrpc.getListAzureClientsMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getListAzureClientsMethod = AzureClustersGrpc.getListAzureClientsMethod) == null) {
          AzureClustersGrpc.getListAzureClientsMethod =
              getListAzureClientsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest,
                          com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAzureClients"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("ListAzureClients"))
                      .build();
        }
      }
    }
    return getListAzureClientsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest,
          com.google.longrunning.Operation>
      getDeleteAzureClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAzureClient",
      requestType = com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest,
          com.google.longrunning.Operation>
      getDeleteAzureClientMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest,
            com.google.longrunning.Operation>
        getDeleteAzureClientMethod;
    if ((getDeleteAzureClientMethod = AzureClustersGrpc.getDeleteAzureClientMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getDeleteAzureClientMethod = AzureClustersGrpc.getDeleteAzureClientMethod) == null) {
          AzureClustersGrpc.getDeleteAzureClientMethod =
              getDeleteAzureClientMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAzureClient"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("DeleteAzureClient"))
                      .build();
        }
      }
    }
    return getDeleteAzureClientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest,
          com.google.longrunning.Operation>
      getCreateAzureClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAzureCluster",
      requestType = com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest,
          com.google.longrunning.Operation>
      getCreateAzureClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest,
            com.google.longrunning.Operation>
        getCreateAzureClusterMethod;
    if ((getCreateAzureClusterMethod = AzureClustersGrpc.getCreateAzureClusterMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getCreateAzureClusterMethod = AzureClustersGrpc.getCreateAzureClusterMethod) == null) {
          AzureClustersGrpc.getCreateAzureClusterMethod =
              getCreateAzureClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAzureCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("CreateAzureCluster"))
                      .build();
        }
      }
    }
    return getCreateAzureClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest,
          com.google.longrunning.Operation>
      getUpdateAzureClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAzureCluster",
      requestType = com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest,
          com.google.longrunning.Operation>
      getUpdateAzureClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest,
            com.google.longrunning.Operation>
        getUpdateAzureClusterMethod;
    if ((getUpdateAzureClusterMethod = AzureClustersGrpc.getUpdateAzureClusterMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getUpdateAzureClusterMethod = AzureClustersGrpc.getUpdateAzureClusterMethod) == null) {
          AzureClustersGrpc.getUpdateAzureClusterMethod =
              getUpdateAzureClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAzureCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("UpdateAzureCluster"))
                      .build();
        }
      }
    }
    return getUpdateAzureClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest,
          com.google.cloud.gkemulticloud.v1.AzureCluster>
      getGetAzureClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAzureCluster",
      requestType = com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.AzureCluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest,
          com.google.cloud.gkemulticloud.v1.AzureCluster>
      getGetAzureClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest,
            com.google.cloud.gkemulticloud.v1.AzureCluster>
        getGetAzureClusterMethod;
    if ((getGetAzureClusterMethod = AzureClustersGrpc.getGetAzureClusterMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getGetAzureClusterMethod = AzureClustersGrpc.getGetAzureClusterMethod) == null) {
          AzureClustersGrpc.getGetAzureClusterMethod =
              getGetAzureClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest,
                          com.google.cloud.gkemulticloud.v1.AzureCluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAzureCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.AzureCluster.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("GetAzureCluster"))
                      .build();
        }
      }
    }
    return getGetAzureClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest,
          com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse>
      getListAzureClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAzureClusters",
      requestType = com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest,
          com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse>
      getListAzureClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest,
            com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse>
        getListAzureClustersMethod;
    if ((getListAzureClustersMethod = AzureClustersGrpc.getListAzureClustersMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getListAzureClustersMethod = AzureClustersGrpc.getListAzureClustersMethod) == null) {
          AzureClustersGrpc.getListAzureClustersMethod =
              getListAzureClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest,
                          com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAzureClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("ListAzureClusters"))
                      .build();
        }
      }
    }
    return getListAzureClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest,
          com.google.longrunning.Operation>
      getDeleteAzureClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAzureCluster",
      requestType = com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest,
          com.google.longrunning.Operation>
      getDeleteAzureClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest,
            com.google.longrunning.Operation>
        getDeleteAzureClusterMethod;
    if ((getDeleteAzureClusterMethod = AzureClustersGrpc.getDeleteAzureClusterMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getDeleteAzureClusterMethod = AzureClustersGrpc.getDeleteAzureClusterMethod) == null) {
          AzureClustersGrpc.getDeleteAzureClusterMethod =
              getDeleteAzureClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAzureCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("DeleteAzureCluster"))
                      .build();
        }
      }
    }
    return getDeleteAzureClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest,
          com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse>
      getGenerateAzureAccessTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAzureAccessToken",
      requestType = com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest,
          com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse>
      getGenerateAzureAccessTokenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest,
            com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse>
        getGenerateAzureAccessTokenMethod;
    if ((getGenerateAzureAccessTokenMethod = AzureClustersGrpc.getGenerateAzureAccessTokenMethod)
        == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getGenerateAzureAccessTokenMethod =
                AzureClustersGrpc.getGenerateAzureAccessTokenMethod)
            == null) {
          AzureClustersGrpc.getGenerateAzureAccessTokenMethod =
              getGenerateAzureAccessTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest,
                          com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateAzureAccessToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("GenerateAzureAccessToken"))
                      .build();
        }
      }
    }
    return getGenerateAzureAccessTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest,
          com.google.longrunning.Operation>
      getCreateAzureNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAzureNodePool",
      requestType = com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest,
          com.google.longrunning.Operation>
      getCreateAzureNodePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest,
            com.google.longrunning.Operation>
        getCreateAzureNodePoolMethod;
    if ((getCreateAzureNodePoolMethod = AzureClustersGrpc.getCreateAzureNodePoolMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getCreateAzureNodePoolMethod = AzureClustersGrpc.getCreateAzureNodePoolMethod)
            == null) {
          AzureClustersGrpc.getCreateAzureNodePoolMethod =
              getCreateAzureNodePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAzureNodePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("CreateAzureNodePool"))
                      .build();
        }
      }
    }
    return getCreateAzureNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest,
          com.google.longrunning.Operation>
      getUpdateAzureNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAzureNodePool",
      requestType = com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest,
          com.google.longrunning.Operation>
      getUpdateAzureNodePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest,
            com.google.longrunning.Operation>
        getUpdateAzureNodePoolMethod;
    if ((getUpdateAzureNodePoolMethod = AzureClustersGrpc.getUpdateAzureNodePoolMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getUpdateAzureNodePoolMethod = AzureClustersGrpc.getUpdateAzureNodePoolMethod)
            == null) {
          AzureClustersGrpc.getUpdateAzureNodePoolMethod =
              getUpdateAzureNodePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAzureNodePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("UpdateAzureNodePool"))
                      .build();
        }
      }
    }
    return getUpdateAzureNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest,
          com.google.cloud.gkemulticloud.v1.AzureNodePool>
      getGetAzureNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAzureNodePool",
      requestType = com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.AzureNodePool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest,
          com.google.cloud.gkemulticloud.v1.AzureNodePool>
      getGetAzureNodePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest,
            com.google.cloud.gkemulticloud.v1.AzureNodePool>
        getGetAzureNodePoolMethod;
    if ((getGetAzureNodePoolMethod = AzureClustersGrpc.getGetAzureNodePoolMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getGetAzureNodePoolMethod = AzureClustersGrpc.getGetAzureNodePoolMethod) == null) {
          AzureClustersGrpc.getGetAzureNodePoolMethod =
              getGetAzureNodePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest,
                          com.google.cloud.gkemulticloud.v1.AzureNodePool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAzureNodePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.AzureNodePool.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("GetAzureNodePool"))
                      .build();
        }
      }
    }
    return getGetAzureNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest,
          com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse>
      getListAzureNodePoolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAzureNodePools",
      requestType = com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest,
          com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse>
      getListAzureNodePoolsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest,
            com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse>
        getListAzureNodePoolsMethod;
    if ((getListAzureNodePoolsMethod = AzureClustersGrpc.getListAzureNodePoolsMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getListAzureNodePoolsMethod = AzureClustersGrpc.getListAzureNodePoolsMethod) == null) {
          AzureClustersGrpc.getListAzureNodePoolsMethod =
              getListAzureNodePoolsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest,
                          com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAzureNodePools"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("ListAzureNodePools"))
                      .build();
        }
      }
    }
    return getListAzureNodePoolsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest,
          com.google.longrunning.Operation>
      getDeleteAzureNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAzureNodePool",
      requestType = com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest,
          com.google.longrunning.Operation>
      getDeleteAzureNodePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest,
            com.google.longrunning.Operation>
        getDeleteAzureNodePoolMethod;
    if ((getDeleteAzureNodePoolMethod = AzureClustersGrpc.getDeleteAzureNodePoolMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getDeleteAzureNodePoolMethod = AzureClustersGrpc.getDeleteAzureNodePoolMethod)
            == null) {
          AzureClustersGrpc.getDeleteAzureNodePoolMethod =
              getDeleteAzureNodePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAzureNodePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("DeleteAzureNodePool"))
                      .build();
        }
      }
    }
    return getDeleteAzureNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest,
          com.google.cloud.gkemulticloud.v1.AzureServerConfig>
      getGetAzureServerConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAzureServerConfig",
      requestType = com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.AzureServerConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest,
          com.google.cloud.gkemulticloud.v1.AzureServerConfig>
      getGetAzureServerConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest,
            com.google.cloud.gkemulticloud.v1.AzureServerConfig>
        getGetAzureServerConfigMethod;
    if ((getGetAzureServerConfigMethod = AzureClustersGrpc.getGetAzureServerConfigMethod) == null) {
      synchronized (AzureClustersGrpc.class) {
        if ((getGetAzureServerConfigMethod = AzureClustersGrpc.getGetAzureServerConfigMethod)
            == null) {
          AzureClustersGrpc.getGetAzureServerConfigMethod =
              getGetAzureServerConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest,
                          com.google.cloud.gkemulticloud.v1.AzureServerConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAzureServerConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.AzureServerConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AzureClustersMethodDescriptorSupplier("GetAzureServerConfig"))
                      .build();
        }
      }
    }
    return getGetAzureServerConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AzureClustersStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AzureClustersStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AzureClustersStub>() {
          @java.lang.Override
          public AzureClustersStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AzureClustersStub(channel, callOptions);
          }
        };
    return AzureClustersStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AzureClustersBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AzureClustersBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AzureClustersBlockingStub>() {
          @java.lang.Override
          public AzureClustersBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AzureClustersBlockingStub(channel, callOptions);
          }
        };
    return AzureClustersBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AzureClustersFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AzureClustersFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AzureClustersFutureStub>() {
          @java.lang.Override
          public AzureClustersFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AzureClustersFutureStub(channel, callOptions);
          }
        };
    return AzureClustersFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The AzureClusters API provides a single centrally managed service
   * to create and manage Anthos clusters that run on Azure infrastructure.
   * </pre>
   */
  public abstract static class AzureClustersImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
     * resource on a given Google Cloud project and region.
     * `AzureClient` resources hold client authentication
     * information needed by the Anthos Multicloud API to manage Azure resources
     * on your Azure subscription on your behalf.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void createAzureClient(
        com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAzureClientMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource.
     * </pre>
     */
    public void getAzureClient(
        com.google.cloud.gkemulticloud.v1.GetAzureClientRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AzureClient>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAzureClientMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
     * resources on a given Google Cloud project and region.
     * </pre>
     */
    public void listAzureClients(
        com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAzureClientsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
     * resource.
     * If the client is used by one or more clusters, deletion will
     * fail and a `FAILED_PRECONDITION` error will be returned.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void deleteAzureClient(
        com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAzureClientMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster]
     * resource on a given GCP project and region.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void createAzureCluster(
        com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAzureClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
     * </pre>
     */
    public void updateAzureCluster(
        com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAzureClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
     * </pre>
     */
    public void getAzureCluster(
        com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AzureCluster>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAzureClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster]
     * resources on a given Google Cloud project and region.
     * </pre>
     */
    public void listAzureClusters(
        com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAzureClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
     * Fails if the cluster has one or more associated
     * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void deleteAzureCluster(
        com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAzureClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived access token to authenticate to a given
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
     * </pre>
     */
    public void generateAzureAccessToken(
        com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateAzureAccessTokenMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool],
     * attached to a given
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void createAzureNodePool(
        com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAzureNodePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool].
     * </pre>
     */
    public void updateAzureNodePool(
        com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAzureNodePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
     * </pre>
     */
    public void getAzureNodePool(
        com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AzureNodePool>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAzureNodePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool]
     * resources on a given
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
     * </pre>
     */
    public void listAzureNodePools(
        com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAzureNodePoolsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific
     * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void deleteAzureNodePool(
        com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAzureNodePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information, such as supported Azure regions and Kubernetes
     * versions, on a given Google Cloud location.
     * </pre>
     */
    public void getAzureServerConfig(
        com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AzureServerConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAzureServerConfigMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateAzureClientMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_AZURE_CLIENT)))
          .addMethod(
              getGetAzureClientMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.GetAzureClientRequest,
                      com.google.cloud.gkemulticloud.v1.AzureClient>(
                      this, METHODID_GET_AZURE_CLIENT)))
          .addMethod(
              getListAzureClientsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest,
                      com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse>(
                      this, METHODID_LIST_AZURE_CLIENTS)))
          .addMethod(
              getDeleteAzureClientMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_AZURE_CLIENT)))
          .addMethod(
              getCreateAzureClusterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_AZURE_CLUSTER)))
          .addMethod(
              getUpdateAzureClusterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_AZURE_CLUSTER)))
          .addMethod(
              getGetAzureClusterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest,
                      com.google.cloud.gkemulticloud.v1.AzureCluster>(
                      this, METHODID_GET_AZURE_CLUSTER)))
          .addMethod(
              getListAzureClustersMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest,
                      com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse>(
                      this, METHODID_LIST_AZURE_CLUSTERS)))
          .addMethod(
              getDeleteAzureClusterMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_AZURE_CLUSTER)))
          .addMethod(
              getGenerateAzureAccessTokenMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest,
                      com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse>(
                      this, METHODID_GENERATE_AZURE_ACCESS_TOKEN)))
          .addMethod(
              getCreateAzureNodePoolMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_AZURE_NODE_POOL)))
          .addMethod(
              getUpdateAzureNodePoolMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_AZURE_NODE_POOL)))
          .addMethod(
              getGetAzureNodePoolMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest,
                      com.google.cloud.gkemulticloud.v1.AzureNodePool>(
                      this, METHODID_GET_AZURE_NODE_POOL)))
          .addMethod(
              getListAzureNodePoolsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest,
                      com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse>(
                      this, METHODID_LIST_AZURE_NODE_POOLS)))
          .addMethod(
              getDeleteAzureNodePoolMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_AZURE_NODE_POOL)))
          .addMethod(
              getGetAzureServerConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest,
                      com.google.cloud.gkemulticloud.v1.AzureServerConfig>(
                      this, METHODID_GET_AZURE_SERVER_CONFIG)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The AzureClusters API provides a single centrally managed service
   * to create and manage Anthos clusters that run on Azure infrastructure.
   * </pre>
   */
  public static final class AzureClustersStub
      extends io.grpc.stub.AbstractAsyncStub<AzureClustersStub> {
    private AzureClustersStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AzureClustersStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AzureClustersStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
     * resource on a given Google Cloud project and region.
     * `AzureClient` resources hold client authentication
     * information needed by the Anthos Multicloud API to manage Azure resources
     * on your Azure subscription on your behalf.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void createAzureClient(
        com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAzureClientMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource.
     * </pre>
     */
    public void getAzureClient(
        com.google.cloud.gkemulticloud.v1.GetAzureClientRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AzureClient>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAzureClientMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
     * resources on a given Google Cloud project and region.
     * </pre>
     */
    public void listAzureClients(
        com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAzureClientsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
     * resource.
     * If the client is used by one or more clusters, deletion will
     * fail and a `FAILED_PRECONDITION` error will be returned.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void deleteAzureClient(
        com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAzureClientMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster]
     * resource on a given GCP project and region.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void createAzureCluster(
        com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAzureClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
     * </pre>
     */
    public void updateAzureCluster(
        com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAzureClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
     * </pre>
     */
    public void getAzureCluster(
        com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AzureCluster>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAzureClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster]
     * resources on a given Google Cloud project and region.
     * </pre>
     */
    public void listAzureClusters(
        com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAzureClustersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
     * Fails if the cluster has one or more associated
     * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void deleteAzureCluster(
        com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAzureClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived access token to authenticate to a given
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
     * </pre>
     */
    public void generateAzureAccessToken(
        com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateAzureAccessTokenMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool],
     * attached to a given
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void createAzureNodePool(
        com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAzureNodePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool].
     * </pre>
     */
    public void updateAzureNodePool(
        com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAzureNodePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
     * </pre>
     */
    public void getAzureNodePool(
        com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AzureNodePool>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAzureNodePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool]
     * resources on a given
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
     * </pre>
     */
    public void listAzureNodePools(
        com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAzureNodePoolsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific
     * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void deleteAzureNodePool(
        com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAzureNodePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information, such as supported Azure regions and Kubernetes
     * versions, on a given Google Cloud location.
     * </pre>
     */
    public void getAzureServerConfig(
        com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AzureServerConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAzureServerConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The AzureClusters API provides a single centrally managed service
   * to create and manage Anthos clusters that run on Azure infrastructure.
   * </pre>
   */
  public static final class AzureClustersBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AzureClustersBlockingStub> {
    private AzureClustersBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AzureClustersBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AzureClustersBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
     * resource on a given Google Cloud project and region.
     * `AzureClient` resources hold client authentication
     * information needed by the Anthos Multicloud API to manage Azure resources
     * on your Azure subscription on your behalf.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.longrunning.Operation createAzureClient(
        com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAzureClientMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.AzureClient getAzureClient(
        com.google.cloud.gkemulticloud.v1.GetAzureClientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAzureClientMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
     * resources on a given Google Cloud project and region.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse listAzureClients(
        com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAzureClientsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
     * resource.
     * If the client is used by one or more clusters, deletion will
     * fail and a `FAILED_PRECONDITION` error will be returned.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAzureClient(
        com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAzureClientMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster]
     * resource on a given GCP project and region.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.longrunning.Operation createAzureCluster(
        com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAzureClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
     * </pre>
     */
    public com.google.longrunning.Operation updateAzureCluster(
        com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAzureClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.AzureCluster getAzureCluster(
        com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAzureClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster]
     * resources on a given Google Cloud project and region.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse listAzureClusters(
        com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAzureClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
     * Fails if the cluster has one or more associated
     * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAzureCluster(
        com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAzureClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived access token to authenticate to a given
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse
        generateAzureAccessToken(
            com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateAzureAccessTokenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool],
     * attached to a given
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.longrunning.Operation createAzureNodePool(
        com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAzureNodePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool].
     * </pre>
     */
    public com.google.longrunning.Operation updateAzureNodePool(
        com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAzureNodePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.AzureNodePool getAzureNodePool(
        com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAzureNodePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool]
     * resources on a given
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse listAzureNodePools(
        com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAzureNodePoolsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific
     * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAzureNodePool(
        com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAzureNodePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information, such as supported Azure regions and Kubernetes
     * versions, on a given Google Cloud location.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.AzureServerConfig getAzureServerConfig(
        com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAzureServerConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The AzureClusters API provides a single centrally managed service
   * to create and manage Anthos clusters that run on Azure infrastructure.
   * </pre>
   */
  public static final class AzureClustersFutureStub
      extends io.grpc.stub.AbstractFutureStub<AzureClustersFutureStub> {
    private AzureClustersFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AzureClustersFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AzureClustersFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
     * resource on a given Google Cloud project and region.
     * `AzureClient` resources hold client authentication
     * information needed by the Anthos Multicloud API to manage Azure resources
     * on your Azure subscription on your behalf.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAzureClient(com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAzureClientMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkemulticloud.v1.AzureClient>
        getAzureClient(com.google.cloud.gkemulticloud.v1.GetAzureClientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAzureClientMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
     * resources on a given Google Cloud project and region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse>
        listAzureClients(com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAzureClientsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
     * resource.
     * If the client is used by one or more clusters, deletion will
     * fail and a `FAILED_PRECONDITION` error will be returned.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAzureClient(com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAzureClientMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster]
     * resource on a given GCP project and region.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAzureCluster(com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAzureClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateAzureCluster(com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAzureClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkemulticloud.v1.AzureCluster>
        getAzureCluster(com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAzureClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster]
     * resources on a given Google Cloud project and region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse>
        listAzureClusters(com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAzureClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
     * Fails if the cluster has one or more associated
     * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAzureCluster(com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAzureClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived access token to authenticate to a given
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse>
        generateAzureAccessToken(
            com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateAzureAccessTokenMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool],
     * attached to a given
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAzureNodePool(com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAzureNodePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateAzureNodePool(com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAzureNodePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkemulticloud.v1.AzureNodePool>
        getAzureNodePool(com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAzureNodePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool]
     * resources on a given
     * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse>
        listAzureNodePools(com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAzureNodePoolsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific
     * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAzureNodePool(com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAzureNodePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information, such as supported Azure regions and Kubernetes
     * versions, on a given Google Cloud location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkemulticloud.v1.AzureServerConfig>
        getAzureServerConfig(
            com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAzureServerConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_AZURE_CLIENT = 0;
  private static final int METHODID_GET_AZURE_CLIENT = 1;
  private static final int METHODID_LIST_AZURE_CLIENTS = 2;
  private static final int METHODID_DELETE_AZURE_CLIENT = 3;
  private static final int METHODID_CREATE_AZURE_CLUSTER = 4;
  private static final int METHODID_UPDATE_AZURE_CLUSTER = 5;
  private static final int METHODID_GET_AZURE_CLUSTER = 6;
  private static final int METHODID_LIST_AZURE_CLUSTERS = 7;
  private static final int METHODID_DELETE_AZURE_CLUSTER = 8;
  private static final int METHODID_GENERATE_AZURE_ACCESS_TOKEN = 9;
  private static final int METHODID_CREATE_AZURE_NODE_POOL = 10;
  private static final int METHODID_UPDATE_AZURE_NODE_POOL = 11;
  private static final int METHODID_GET_AZURE_NODE_POOL = 12;
  private static final int METHODID_LIST_AZURE_NODE_POOLS = 13;
  private static final int METHODID_DELETE_AZURE_NODE_POOL = 14;
  private static final int METHODID_GET_AZURE_SERVER_CONFIG = 15;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AzureClustersImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AzureClustersImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_AZURE_CLIENT:
          serviceImpl.createAzureClient(
              (com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_AZURE_CLIENT:
          serviceImpl.getAzureClient(
              (com.google.cloud.gkemulticloud.v1.GetAzureClientRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AzureClient>)
                  responseObserver);
          break;
        case METHODID_LIST_AZURE_CLIENTS:
          serviceImpl.listAzureClients(
              (com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_AZURE_CLIENT:
          serviceImpl.deleteAzureClient(
              (com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_AZURE_CLUSTER:
          serviceImpl.createAzureCluster(
              (com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_AZURE_CLUSTER:
          serviceImpl.updateAzureCluster(
              (com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_AZURE_CLUSTER:
          serviceImpl.getAzureCluster(
              (com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AzureCluster>)
                  responseObserver);
          break;
        case METHODID_LIST_AZURE_CLUSTERS:
          serviceImpl.listAzureClusters(
              (com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_AZURE_CLUSTER:
          serviceImpl.deleteAzureCluster(
              (com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_AZURE_ACCESS_TOKEN:
          serviceImpl.generateAzureAccessToken(
              (com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_AZURE_NODE_POOL:
          serviceImpl.createAzureNodePool(
              (com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_AZURE_NODE_POOL:
          serviceImpl.updateAzureNodePool(
              (com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_AZURE_NODE_POOL:
          serviceImpl.getAzureNodePool(
              (com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AzureNodePool>)
                  responseObserver);
          break;
        case METHODID_LIST_AZURE_NODE_POOLS:
          serviceImpl.listAzureNodePools(
              (com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_AZURE_NODE_POOL:
          serviceImpl.deleteAzureNodePool(
              (com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_AZURE_SERVER_CONFIG:
          serviceImpl.getAzureServerConfig(
              (com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AzureServerConfig>)
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

  private abstract static class AzureClustersBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AzureClustersBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gkemulticloud.v1.AzureServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AzureClusters");
    }
  }

  private static final class AzureClustersFileDescriptorSupplier
      extends AzureClustersBaseDescriptorSupplier {
    AzureClustersFileDescriptorSupplier() {}
  }

  private static final class AzureClustersMethodDescriptorSupplier
      extends AzureClustersBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AzureClustersMethodDescriptorSupplier(String methodName) {
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
      synchronized (AzureClustersGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AzureClustersFileDescriptorSupplier())
                      .addMethod(getCreateAzureClientMethod())
                      .addMethod(getGetAzureClientMethod())
                      .addMethod(getListAzureClientsMethod())
                      .addMethod(getDeleteAzureClientMethod())
                      .addMethod(getCreateAzureClusterMethod())
                      .addMethod(getUpdateAzureClusterMethod())
                      .addMethod(getGetAzureClusterMethod())
                      .addMethod(getListAzureClustersMethod())
                      .addMethod(getDeleteAzureClusterMethod())
                      .addMethod(getGenerateAzureAccessTokenMethod())
                      .addMethod(getCreateAzureNodePoolMethod())
                      .addMethod(getUpdateAzureNodePoolMethod())
                      .addMethod(getGetAzureNodePoolMethod())
                      .addMethod(getListAzureNodePoolsMethod())
                      .addMethod(getDeleteAzureNodePoolMethod())
                      .addMethod(getGetAzureServerConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
