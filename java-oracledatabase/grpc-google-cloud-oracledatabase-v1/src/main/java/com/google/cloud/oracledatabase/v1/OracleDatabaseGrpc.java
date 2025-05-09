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
package com.google.cloud.oracledatabase.v1;

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
    comments = "Source: google/cloud/oracledatabase/v1/oracledatabase.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OracleDatabaseGrpc {

  private OracleDatabaseGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.oracledatabase.v1.OracleDatabase";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest,
          com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse>
      getListCloudExadataInfrastructuresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCloudExadataInfrastructures",
      requestType = com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest.class,
      responseType =
          com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest,
          com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse>
      getListCloudExadataInfrastructuresMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest,
            com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse>
        getListCloudExadataInfrastructuresMethod;
    if ((getListCloudExadataInfrastructuresMethod =
            OracleDatabaseGrpc.getListCloudExadataInfrastructuresMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListCloudExadataInfrastructuresMethod =
                OracleDatabaseGrpc.getListCloudExadataInfrastructuresMethod)
            == null) {
          OracleDatabaseGrpc.getListCloudExadataInfrastructuresMethod =
              getListCloudExadataInfrastructuresMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest,
                          com.google.cloud.oracledatabase.v1
                              .ListCloudExadataInfrastructuresResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCloudExadataInfrastructures"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .ListCloudExadataInfrastructuresRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .ListCloudExadataInfrastructuresResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier(
                              "ListCloudExadataInfrastructures"))
                      .build();
        }
      }
    }
    return getListCloudExadataInfrastructuresMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest,
          com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure>
      getGetCloudExadataInfrastructureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCloudExadataInfrastructure",
      requestType = com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest,
          com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure>
      getGetCloudExadataInfrastructureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest,
            com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure>
        getGetCloudExadataInfrastructureMethod;
    if ((getGetCloudExadataInfrastructureMethod =
            OracleDatabaseGrpc.getGetCloudExadataInfrastructureMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getGetCloudExadataInfrastructureMethod =
                OracleDatabaseGrpc.getGetCloudExadataInfrastructureMethod)
            == null) {
          OracleDatabaseGrpc.getGetCloudExadataInfrastructureMethod =
              getGetCloudExadataInfrastructureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest,
                          com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCloudExadataInfrastructure"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .GetCloudExadataInfrastructureRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier(
                              "GetCloudExadataInfrastructure"))
                      .build();
        }
      }
    }
    return getGetCloudExadataInfrastructureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest,
          com.google.longrunning.Operation>
      getCreateCloudExadataInfrastructureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCloudExadataInfrastructure",
      requestType =
          com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest,
          com.google.longrunning.Operation>
      getCreateCloudExadataInfrastructureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest,
            com.google.longrunning.Operation>
        getCreateCloudExadataInfrastructureMethod;
    if ((getCreateCloudExadataInfrastructureMethod =
            OracleDatabaseGrpc.getCreateCloudExadataInfrastructureMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getCreateCloudExadataInfrastructureMethod =
                OracleDatabaseGrpc.getCreateCloudExadataInfrastructureMethod)
            == null) {
          OracleDatabaseGrpc.getCreateCloudExadataInfrastructureMethod =
              getCreateCloudExadataInfrastructureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCloudExadataInfrastructure"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .CreateCloudExadataInfrastructureRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier(
                              "CreateCloudExadataInfrastructure"))
                      .build();
        }
      }
    }
    return getCreateCloudExadataInfrastructureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest,
          com.google.longrunning.Operation>
      getDeleteCloudExadataInfrastructureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCloudExadataInfrastructure",
      requestType =
          com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest,
          com.google.longrunning.Operation>
      getDeleteCloudExadataInfrastructureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest,
            com.google.longrunning.Operation>
        getDeleteCloudExadataInfrastructureMethod;
    if ((getDeleteCloudExadataInfrastructureMethod =
            OracleDatabaseGrpc.getDeleteCloudExadataInfrastructureMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getDeleteCloudExadataInfrastructureMethod =
                OracleDatabaseGrpc.getDeleteCloudExadataInfrastructureMethod)
            == null) {
          OracleDatabaseGrpc.getDeleteCloudExadataInfrastructureMethod =
              getDeleteCloudExadataInfrastructureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCloudExadataInfrastructure"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .DeleteCloudExadataInfrastructureRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier(
                              "DeleteCloudExadataInfrastructure"))
                      .build();
        }
      }
    }
    return getDeleteCloudExadataInfrastructureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest,
          com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse>
      getListCloudVmClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCloudVmClusters",
      requestType = com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest,
          com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse>
      getListCloudVmClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest,
            com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse>
        getListCloudVmClustersMethod;
    if ((getListCloudVmClustersMethod = OracleDatabaseGrpc.getListCloudVmClustersMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListCloudVmClustersMethod = OracleDatabaseGrpc.getListCloudVmClustersMethod)
            == null) {
          OracleDatabaseGrpc.getListCloudVmClustersMethod =
              getListCloudVmClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest,
                          com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCloudVmClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListCloudVmClusters"))
                      .build();
        }
      }
    }
    return getListCloudVmClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest,
          com.google.cloud.oracledatabase.v1.CloudVmCluster>
      getGetCloudVmClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCloudVmCluster",
      requestType = com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.CloudVmCluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest,
          com.google.cloud.oracledatabase.v1.CloudVmCluster>
      getGetCloudVmClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest,
            com.google.cloud.oracledatabase.v1.CloudVmCluster>
        getGetCloudVmClusterMethod;
    if ((getGetCloudVmClusterMethod = OracleDatabaseGrpc.getGetCloudVmClusterMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getGetCloudVmClusterMethod = OracleDatabaseGrpc.getGetCloudVmClusterMethod) == null) {
          OracleDatabaseGrpc.getGetCloudVmClusterMethod =
              getGetCloudVmClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest,
                          com.google.cloud.oracledatabase.v1.CloudVmCluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCloudVmCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.CloudVmCluster
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("GetCloudVmCluster"))
                      .build();
        }
      }
    }
    return getGetCloudVmClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest,
          com.google.longrunning.Operation>
      getCreateCloudVmClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCloudVmCluster",
      requestType = com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest,
          com.google.longrunning.Operation>
      getCreateCloudVmClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest,
            com.google.longrunning.Operation>
        getCreateCloudVmClusterMethod;
    if ((getCreateCloudVmClusterMethod = OracleDatabaseGrpc.getCreateCloudVmClusterMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getCreateCloudVmClusterMethod = OracleDatabaseGrpc.getCreateCloudVmClusterMethod)
            == null) {
          OracleDatabaseGrpc.getCreateCloudVmClusterMethod =
              getCreateCloudVmClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCloudVmCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("CreateCloudVmCluster"))
                      .build();
        }
      }
    }
    return getCreateCloudVmClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest,
          com.google.longrunning.Operation>
      getDeleteCloudVmClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCloudVmCluster",
      requestType = com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest,
          com.google.longrunning.Operation>
      getDeleteCloudVmClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest,
            com.google.longrunning.Operation>
        getDeleteCloudVmClusterMethod;
    if ((getDeleteCloudVmClusterMethod = OracleDatabaseGrpc.getDeleteCloudVmClusterMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getDeleteCloudVmClusterMethod = OracleDatabaseGrpc.getDeleteCloudVmClusterMethod)
            == null) {
          OracleDatabaseGrpc.getDeleteCloudVmClusterMethod =
              getDeleteCloudVmClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCloudVmCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("DeleteCloudVmCluster"))
                      .build();
        }
      }
    }
    return getDeleteCloudVmClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListEntitlementsRequest,
          com.google.cloud.oracledatabase.v1.ListEntitlementsResponse>
      getListEntitlementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntitlements",
      requestType = com.google.cloud.oracledatabase.v1.ListEntitlementsRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListEntitlementsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListEntitlementsRequest,
          com.google.cloud.oracledatabase.v1.ListEntitlementsResponse>
      getListEntitlementsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListEntitlementsRequest,
            com.google.cloud.oracledatabase.v1.ListEntitlementsResponse>
        getListEntitlementsMethod;
    if ((getListEntitlementsMethod = OracleDatabaseGrpc.getListEntitlementsMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListEntitlementsMethod = OracleDatabaseGrpc.getListEntitlementsMethod) == null) {
          OracleDatabaseGrpc.getListEntitlementsMethod =
              getListEntitlementsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListEntitlementsRequest,
                          com.google.cloud.oracledatabase.v1.ListEntitlementsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEntitlements"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListEntitlementsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListEntitlementsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListEntitlements"))
                      .build();
        }
      }
    }
    return getListEntitlementsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDbServersRequest,
          com.google.cloud.oracledatabase.v1.ListDbServersResponse>
      getListDbServersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDbServers",
      requestType = com.google.cloud.oracledatabase.v1.ListDbServersRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListDbServersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDbServersRequest,
          com.google.cloud.oracledatabase.v1.ListDbServersResponse>
      getListDbServersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListDbServersRequest,
            com.google.cloud.oracledatabase.v1.ListDbServersResponse>
        getListDbServersMethod;
    if ((getListDbServersMethod = OracleDatabaseGrpc.getListDbServersMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListDbServersMethod = OracleDatabaseGrpc.getListDbServersMethod) == null) {
          OracleDatabaseGrpc.getListDbServersMethod =
              getListDbServersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListDbServersRequest,
                          com.google.cloud.oracledatabase.v1.ListDbServersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDbServers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDbServersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDbServersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListDbServers"))
                      .build();
        }
      }
    }
    return getListDbServersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDbNodesRequest,
          com.google.cloud.oracledatabase.v1.ListDbNodesResponse>
      getListDbNodesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDbNodes",
      requestType = com.google.cloud.oracledatabase.v1.ListDbNodesRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListDbNodesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDbNodesRequest,
          com.google.cloud.oracledatabase.v1.ListDbNodesResponse>
      getListDbNodesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListDbNodesRequest,
            com.google.cloud.oracledatabase.v1.ListDbNodesResponse>
        getListDbNodesMethod;
    if ((getListDbNodesMethod = OracleDatabaseGrpc.getListDbNodesMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListDbNodesMethod = OracleDatabaseGrpc.getListDbNodesMethod) == null) {
          OracleDatabaseGrpc.getListDbNodesMethod =
              getListDbNodesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListDbNodesRequest,
                          com.google.cloud.oracledatabase.v1.ListDbNodesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDbNodes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDbNodesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDbNodesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListDbNodes"))
                      .build();
        }
      }
    }
    return getListDbNodesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListGiVersionsRequest,
          com.google.cloud.oracledatabase.v1.ListGiVersionsResponse>
      getListGiVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGiVersions",
      requestType = com.google.cloud.oracledatabase.v1.ListGiVersionsRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListGiVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListGiVersionsRequest,
          com.google.cloud.oracledatabase.v1.ListGiVersionsResponse>
      getListGiVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListGiVersionsRequest,
            com.google.cloud.oracledatabase.v1.ListGiVersionsResponse>
        getListGiVersionsMethod;
    if ((getListGiVersionsMethod = OracleDatabaseGrpc.getListGiVersionsMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListGiVersionsMethod = OracleDatabaseGrpc.getListGiVersionsMethod) == null) {
          OracleDatabaseGrpc.getListGiVersionsMethod =
              getListGiVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListGiVersionsRequest,
                          com.google.cloud.oracledatabase.v1.ListGiVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGiVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListGiVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListGiVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListGiVersions"))
                      .build();
        }
      }
    }
    return getListGiVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest,
          com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse>
      getListDbSystemShapesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDbSystemShapes",
      requestType = com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest,
          com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse>
      getListDbSystemShapesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest,
            com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse>
        getListDbSystemShapesMethod;
    if ((getListDbSystemShapesMethod = OracleDatabaseGrpc.getListDbSystemShapesMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListDbSystemShapesMethod = OracleDatabaseGrpc.getListDbSystemShapesMethod)
            == null) {
          OracleDatabaseGrpc.getListDbSystemShapesMethod =
              getListDbSystemShapesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest,
                          com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDbSystemShapes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListDbSystemShapes"))
                      .build();
        }
      }
    }
    return getListDbSystemShapesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest,
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse>
      getListAutonomousDatabasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAutonomousDatabases",
      requestType = com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest,
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse>
      getListAutonomousDatabasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest,
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse>
        getListAutonomousDatabasesMethod;
    if ((getListAutonomousDatabasesMethod = OracleDatabaseGrpc.getListAutonomousDatabasesMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListAutonomousDatabasesMethod = OracleDatabaseGrpc.getListAutonomousDatabasesMethod)
            == null) {
          OracleDatabaseGrpc.getListAutonomousDatabasesMethod =
              getListAutonomousDatabasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest,
                          com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAutonomousDatabases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListAutonomousDatabases"))
                      .build();
        }
      }
    }
    return getListAutonomousDatabasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest,
          com.google.cloud.oracledatabase.v1.AutonomousDatabase>
      getGetAutonomousDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAutonomousDatabase",
      requestType = com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.AutonomousDatabase.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest,
          com.google.cloud.oracledatabase.v1.AutonomousDatabase>
      getGetAutonomousDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest,
            com.google.cloud.oracledatabase.v1.AutonomousDatabase>
        getGetAutonomousDatabaseMethod;
    if ((getGetAutonomousDatabaseMethod = OracleDatabaseGrpc.getGetAutonomousDatabaseMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getGetAutonomousDatabaseMethod = OracleDatabaseGrpc.getGetAutonomousDatabaseMethod)
            == null) {
          OracleDatabaseGrpc.getGetAutonomousDatabaseMethod =
              getGetAutonomousDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest,
                          com.google.cloud.oracledatabase.v1.AutonomousDatabase>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAutonomousDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.AutonomousDatabase
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("GetAutonomousDatabase"))
                      .build();
        }
      }
    }
    return getGetAutonomousDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getCreateAutonomousDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAutonomousDatabase",
      requestType = com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getCreateAutonomousDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest,
            com.google.longrunning.Operation>
        getCreateAutonomousDatabaseMethod;
    if ((getCreateAutonomousDatabaseMethod = OracleDatabaseGrpc.getCreateAutonomousDatabaseMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getCreateAutonomousDatabaseMethod =
                OracleDatabaseGrpc.getCreateAutonomousDatabaseMethod)
            == null) {
          OracleDatabaseGrpc.getCreateAutonomousDatabaseMethod =
              getCreateAutonomousDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAutonomousDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("CreateAutonomousDatabase"))
                      .build();
        }
      }
    }
    return getCreateAutonomousDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getDeleteAutonomousDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAutonomousDatabase",
      requestType = com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getDeleteAutonomousDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest,
            com.google.longrunning.Operation>
        getDeleteAutonomousDatabaseMethod;
    if ((getDeleteAutonomousDatabaseMethod = OracleDatabaseGrpc.getDeleteAutonomousDatabaseMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getDeleteAutonomousDatabaseMethod =
                OracleDatabaseGrpc.getDeleteAutonomousDatabaseMethod)
            == null) {
          OracleDatabaseGrpc.getDeleteAutonomousDatabaseMethod =
              getDeleteAutonomousDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAutonomousDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("DeleteAutonomousDatabase"))
                      .build();
        }
      }
    }
    return getDeleteAutonomousDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getRestoreAutonomousDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreAutonomousDatabase",
      requestType = com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getRestoreAutonomousDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest,
            com.google.longrunning.Operation>
        getRestoreAutonomousDatabaseMethod;
    if ((getRestoreAutonomousDatabaseMethod = OracleDatabaseGrpc.getRestoreAutonomousDatabaseMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getRestoreAutonomousDatabaseMethod =
                OracleDatabaseGrpc.getRestoreAutonomousDatabaseMethod)
            == null) {
          OracleDatabaseGrpc.getRestoreAutonomousDatabaseMethod =
              getRestoreAutonomousDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RestoreAutonomousDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("RestoreAutonomousDatabase"))
                      .build();
        }
      }
    }
    return getRestoreAutonomousDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest,
          com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse>
      getGenerateAutonomousDatabaseWalletMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAutonomousDatabaseWallet",
      requestType =
          com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest.class,
      responseType =
          com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest,
          com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse>
      getGenerateAutonomousDatabaseWalletMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest,
            com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse>
        getGenerateAutonomousDatabaseWalletMethod;
    if ((getGenerateAutonomousDatabaseWalletMethod =
            OracleDatabaseGrpc.getGenerateAutonomousDatabaseWalletMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getGenerateAutonomousDatabaseWalletMethod =
                OracleDatabaseGrpc.getGenerateAutonomousDatabaseWalletMethod)
            == null) {
          OracleDatabaseGrpc.getGenerateAutonomousDatabaseWalletMethod =
              getGenerateAutonomousDatabaseWalletMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest,
                          com.google.cloud.oracledatabase.v1
                              .GenerateAutonomousDatabaseWalletResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateAutonomousDatabaseWallet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .GenerateAutonomousDatabaseWalletRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .GenerateAutonomousDatabaseWalletResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier(
                              "GenerateAutonomousDatabaseWallet"))
                      .build();
        }
      }
    }
    return getGenerateAutonomousDatabaseWalletMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest,
          com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse>
      getListAutonomousDbVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAutonomousDbVersions",
      requestType = com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest,
          com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse>
      getListAutonomousDbVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest,
            com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse>
        getListAutonomousDbVersionsMethod;
    if ((getListAutonomousDbVersionsMethod = OracleDatabaseGrpc.getListAutonomousDbVersionsMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListAutonomousDbVersionsMethod =
                OracleDatabaseGrpc.getListAutonomousDbVersionsMethod)
            == null) {
          OracleDatabaseGrpc.getListAutonomousDbVersionsMethod =
              getListAutonomousDbVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest,
                          com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAutonomousDbVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListAutonomousDbVersions"))
                      .build();
        }
      }
    }
    return getListAutonomousDbVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest,
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsResponse>
      getListAutonomousDatabaseCharacterSetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAutonomousDatabaseCharacterSets",
      requestType =
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest.class,
      responseType =
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest,
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsResponse>
      getListAutonomousDatabaseCharacterSetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest,
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsResponse>
        getListAutonomousDatabaseCharacterSetsMethod;
    if ((getListAutonomousDatabaseCharacterSetsMethod =
            OracleDatabaseGrpc.getListAutonomousDatabaseCharacterSetsMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListAutonomousDatabaseCharacterSetsMethod =
                OracleDatabaseGrpc.getListAutonomousDatabaseCharacterSetsMethod)
            == null) {
          OracleDatabaseGrpc.getListAutonomousDatabaseCharacterSetsMethod =
              getListAutonomousDatabaseCharacterSetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1
                              .ListAutonomousDatabaseCharacterSetsRequest,
                          com.google.cloud.oracledatabase.v1
                              .ListAutonomousDatabaseCharacterSetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListAutonomousDatabaseCharacterSets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .ListAutonomousDatabaseCharacterSetsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .ListAutonomousDatabaseCharacterSetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier(
                              "ListAutonomousDatabaseCharacterSets"))
                      .build();
        }
      }
    }
    return getListAutonomousDatabaseCharacterSetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest,
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse>
      getListAutonomousDatabaseBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAutonomousDatabaseBackups",
      requestType = com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest,
          com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse>
      getListAutonomousDatabaseBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest,
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse>
        getListAutonomousDatabaseBackupsMethod;
    if ((getListAutonomousDatabaseBackupsMethod =
            OracleDatabaseGrpc.getListAutonomousDatabaseBackupsMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListAutonomousDatabaseBackupsMethod =
                OracleDatabaseGrpc.getListAutonomousDatabaseBackupsMethod)
            == null) {
          OracleDatabaseGrpc.getListAutonomousDatabaseBackupsMethod =
              getListAutonomousDatabaseBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest,
                          com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAutonomousDatabaseBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .ListAutonomousDatabaseBackupsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .ListAutonomousDatabaseBackupsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier(
                              "ListAutonomousDatabaseBackups"))
                      .build();
        }
      }
    }
    return getListAutonomousDatabaseBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getStopAutonomousDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopAutonomousDatabase",
      requestType = com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getStopAutonomousDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest,
            com.google.longrunning.Operation>
        getStopAutonomousDatabaseMethod;
    if ((getStopAutonomousDatabaseMethod = OracleDatabaseGrpc.getStopAutonomousDatabaseMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getStopAutonomousDatabaseMethod = OracleDatabaseGrpc.getStopAutonomousDatabaseMethod)
            == null) {
          OracleDatabaseGrpc.getStopAutonomousDatabaseMethod =
              getStopAutonomousDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "StopAutonomousDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("StopAutonomousDatabase"))
                      .build();
        }
      }
    }
    return getStopAutonomousDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getStartAutonomousDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartAutonomousDatabase",
      requestType = com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getStartAutonomousDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest,
            com.google.longrunning.Operation>
        getStartAutonomousDatabaseMethod;
    if ((getStartAutonomousDatabaseMethod = OracleDatabaseGrpc.getStartAutonomousDatabaseMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getStartAutonomousDatabaseMethod = OracleDatabaseGrpc.getStartAutonomousDatabaseMethod)
            == null) {
          OracleDatabaseGrpc.getStartAutonomousDatabaseMethod =
              getStartAutonomousDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "StartAutonomousDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("StartAutonomousDatabase"))
                      .build();
        }
      }
    }
    return getStartAutonomousDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getRestartAutonomousDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestartAutonomousDatabase",
      requestType = com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getRestartAutonomousDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest,
            com.google.longrunning.Operation>
        getRestartAutonomousDatabaseMethod;
    if ((getRestartAutonomousDatabaseMethod = OracleDatabaseGrpc.getRestartAutonomousDatabaseMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getRestartAutonomousDatabaseMethod =
                OracleDatabaseGrpc.getRestartAutonomousDatabaseMethod)
            == null) {
          OracleDatabaseGrpc.getRestartAutonomousDatabaseMethod =
              getRestartAutonomousDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RestartAutonomousDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("RestartAutonomousDatabase"))
                      .build();
        }
      }
    }
    return getRestartAutonomousDatabaseMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static OracleDatabaseStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OracleDatabaseStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OracleDatabaseStub>() {
          @java.lang.Override
          public OracleDatabaseStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OracleDatabaseStub(channel, callOptions);
          }
        };
    return OracleDatabaseStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static OracleDatabaseBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OracleDatabaseBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OracleDatabaseBlockingV2Stub>() {
          @java.lang.Override
          public OracleDatabaseBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OracleDatabaseBlockingV2Stub(channel, callOptions);
          }
        };
    return OracleDatabaseBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OracleDatabaseBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OracleDatabaseBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OracleDatabaseBlockingStub>() {
          @java.lang.Override
          public OracleDatabaseBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OracleDatabaseBlockingStub(channel, callOptions);
          }
        };
    return OracleDatabaseBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static OracleDatabaseFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OracleDatabaseFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OracleDatabaseFutureStub>() {
          @java.lang.Override
          public OracleDatabaseFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OracleDatabaseFutureStub(channel, callOptions);
          }
        };
    return OracleDatabaseFutureStub.newStub(factory, channel);
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
     * Lists Exadata Infrastructures in a given project and location.
     * </pre>
     */
    default void listCloudExadataInfrastructures(
        com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCloudExadataInfrastructuresMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Exadata Infrastructure.
     * </pre>
     */
    default void getCloudExadataInfrastructure(
        com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCloudExadataInfrastructureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Exadata Infrastructure in a given project and location.
     * </pre>
     */
    default void createCloudExadataInfrastructure(
        com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCloudExadataInfrastructureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Exadata Infrastructure.
     * </pre>
     */
    default void deleteCloudExadataInfrastructure(
        com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCloudExadataInfrastructureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the VM Clusters in a given project and location.
     * </pre>
     */
    default void listCloudVmClusters(
        com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCloudVmClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single VM Cluster.
     * </pre>
     */
    default void getCloudVmCluster(
        com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.CloudVmCluster>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCloudVmClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new VM Cluster in a given project and location.
     * </pre>
     */
    default void createCloudVmCluster(
        com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCloudVmClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single VM Cluster.
     * </pre>
     */
    default void deleteCloudVmCluster(
        com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCloudVmClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the entitlements in a given project.
     * </pre>
     */
    default void listEntitlements(
        com.google.cloud.oracledatabase.v1.ListEntitlementsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListEntitlementsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEntitlementsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the database servers of an Exadata Infrastructure instance.
     * </pre>
     */
    default void listDbServers(
        com.google.cloud.oracledatabase.v1.ListDbServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListDbServersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDbServersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the database nodes of a VM Cluster.
     * </pre>
     */
    default void listDbNodes(
        com.google.cloud.oracledatabase.v1.ListDbNodesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListDbNodesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDbNodesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the valid Oracle Grid Infrastructure (GI) versions for the given
     * project and location.
     * </pre>
     */
    default void listGiVersions(
        com.google.cloud.oracledatabase.v1.ListGiVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListGiVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGiVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the database system shapes available for the project and location.
     * </pre>
     */
    default void listDbSystemShapes(
        com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDbSystemShapesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Autonomous Databases in a given project and location.
     * </pre>
     */
    default void listAutonomousDatabases(
        com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAutonomousDatabasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single Autonomous Database.
     * </pre>
     */
    default void getAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.AutonomousDatabase>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAutonomousDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Autonomous Database in a given project and location.
     * </pre>
     */
    default void createAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAutonomousDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Autonomous Database.
     * </pre>
     */
    default void deleteAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAutonomousDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores a single Autonomous Database.
     * </pre>
     */
    default void restoreAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreAutonomousDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a wallet for an Autonomous Database.
     * </pre>
     */
    default void generateAutonomousDatabaseWallet(
        com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateAutonomousDatabaseWalletMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the available Autonomous Database versions for a project and
     * location.
     * </pre>
     */
    default void listAutonomousDbVersions(
        com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAutonomousDbVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Autonomous Database Character Sets in a given project and location.
     * </pre>
     */
    default void listAutonomousDatabaseCharacterSets(
        com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAutonomousDatabaseCharacterSetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the long-term and automatic backups of an Autonomous Database.
     * </pre>
     */
    default void listAutonomousDatabaseBackups(
        com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAutonomousDatabaseBackupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops an Autonomous Database.
     * </pre>
     */
    default void stopAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStopAutonomousDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts an Autonomous Database.
     * </pre>
     */
    default void startAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartAutonomousDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restarts an Autonomous Database.
     * </pre>
     */
    default void restartAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestartAutonomousDatabaseMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OracleDatabase.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class OracleDatabaseImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return OracleDatabaseGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OracleDatabase.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class OracleDatabaseStub
      extends io.grpc.stub.AbstractAsyncStub<OracleDatabaseStub> {
    private OracleDatabaseStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OracleDatabaseStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OracleDatabaseStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Exadata Infrastructures in a given project and location.
     * </pre>
     */
    public void listCloudExadataInfrastructures(
        com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCloudExadataInfrastructuresMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Exadata Infrastructure.
     * </pre>
     */
    public void getCloudExadataInfrastructure(
        com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCloudExadataInfrastructureMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Exadata Infrastructure in a given project and location.
     * </pre>
     */
    public void createCloudExadataInfrastructure(
        com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCloudExadataInfrastructureMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Exadata Infrastructure.
     * </pre>
     */
    public void deleteCloudExadataInfrastructure(
        com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCloudExadataInfrastructureMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the VM Clusters in a given project and location.
     * </pre>
     */
    public void listCloudVmClusters(
        com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCloudVmClustersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single VM Cluster.
     * </pre>
     */
    public void getCloudVmCluster(
        com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.CloudVmCluster>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCloudVmClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new VM Cluster in a given project and location.
     * </pre>
     */
    public void createCloudVmCluster(
        com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCloudVmClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single VM Cluster.
     * </pre>
     */
    public void deleteCloudVmCluster(
        com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCloudVmClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the entitlements in a given project.
     * </pre>
     */
    public void listEntitlements(
        com.google.cloud.oracledatabase.v1.ListEntitlementsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListEntitlementsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEntitlementsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the database servers of an Exadata Infrastructure instance.
     * </pre>
     */
    public void listDbServers(
        com.google.cloud.oracledatabase.v1.ListDbServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListDbServersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDbServersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the database nodes of a VM Cluster.
     * </pre>
     */
    public void listDbNodes(
        com.google.cloud.oracledatabase.v1.ListDbNodesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListDbNodesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDbNodesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the valid Oracle Grid Infrastructure (GI) versions for the given
     * project and location.
     * </pre>
     */
    public void listGiVersions(
        com.google.cloud.oracledatabase.v1.ListGiVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListGiVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGiVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the database system shapes available for the project and location.
     * </pre>
     */
    public void listDbSystemShapes(
        com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDbSystemShapesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Autonomous Databases in a given project and location.
     * </pre>
     */
    public void listAutonomousDatabases(
        com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAutonomousDatabasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single Autonomous Database.
     * </pre>
     */
    public void getAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.AutonomousDatabase>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAutonomousDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Autonomous Database in a given project and location.
     * </pre>
     */
    public void createAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAutonomousDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Autonomous Database.
     * </pre>
     */
    public void deleteAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAutonomousDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores a single Autonomous Database.
     * </pre>
     */
    public void restoreAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreAutonomousDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a wallet for an Autonomous Database.
     * </pre>
     */
    public void generateAutonomousDatabaseWallet(
        com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateAutonomousDatabaseWalletMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the available Autonomous Database versions for a project and
     * location.
     * </pre>
     */
    public void listAutonomousDbVersions(
        com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAutonomousDbVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Autonomous Database Character Sets in a given project and location.
     * </pre>
     */
    public void listAutonomousDatabaseCharacterSets(
        com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAutonomousDatabaseCharacterSetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the long-term and automatic backups of an Autonomous Database.
     * </pre>
     */
    public void listAutonomousDatabaseBackups(
        com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAutonomousDatabaseBackupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops an Autonomous Database.
     * </pre>
     */
    public void stopAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopAutonomousDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts an Autonomous Database.
     * </pre>
     */
    public void startAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartAutonomousDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restarts an Autonomous Database.
     * </pre>
     */
    public void restartAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestartAutonomousDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OracleDatabase.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class OracleDatabaseBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<OracleDatabaseBlockingV2Stub> {
    private OracleDatabaseBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OracleDatabaseBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OracleDatabaseBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Exadata Infrastructures in a given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse
        listCloudExadataInfrastructures(
            com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCloudExadataInfrastructuresMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Exadata Infrastructure.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure
        getCloudExadataInfrastructure(
            com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCloudExadataInfrastructureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Exadata Infrastructure in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCloudExadataInfrastructure(
        com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCloudExadataInfrastructureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Exadata Infrastructure.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCloudExadataInfrastructure(
        com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCloudExadataInfrastructureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the VM Clusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse listCloudVmClusters(
        com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCloudVmClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single VM Cluster.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.CloudVmCluster getCloudVmCluster(
        com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCloudVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new VM Cluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCloudVmCluster(
        com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCloudVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single VM Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCloudVmCluster(
        com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCloudVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the entitlements in a given project.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListEntitlementsResponse listEntitlements(
        com.google.cloud.oracledatabase.v1.ListEntitlementsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntitlementsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the database servers of an Exadata Infrastructure instance.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDbServersResponse listDbServers(
        com.google.cloud.oracledatabase.v1.ListDbServersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDbServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the database nodes of a VM Cluster.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDbNodesResponse listDbNodes(
        com.google.cloud.oracledatabase.v1.ListDbNodesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDbNodesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the valid Oracle Grid Infrastructure (GI) versions for the given
     * project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListGiVersionsResponse listGiVersions(
        com.google.cloud.oracledatabase.v1.ListGiVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGiVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the database system shapes available for the project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse listDbSystemShapes(
        com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDbSystemShapesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Autonomous Databases in a given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse
        listAutonomousDatabases(
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAutonomousDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single Autonomous Database.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.AutonomousDatabase getAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Autonomous Database in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Autonomous Database.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a single Autonomous Database.
     * </pre>
     */
    public com.google.longrunning.Operation restoreAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a wallet for an Autonomous Database.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse
        generateAutonomousDatabaseWallet(
            com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateAutonomousDatabaseWalletMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the available Autonomous Database versions for a project and
     * location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse
        listAutonomousDbVersions(
            com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAutonomousDbVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Autonomous Database Character Sets in a given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsResponse
        listAutonomousDatabaseCharacterSets(
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAutonomousDatabaseCharacterSetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the long-term and automatic backups of an Autonomous Database.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse
        listAutonomousDatabaseBackups(
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAutonomousDatabaseBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops an Autonomous Database.
     * </pre>
     */
    public com.google.longrunning.Operation stopAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts an Autonomous Database.
     * </pre>
     */
    public com.google.longrunning.Operation startAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restarts an Autonomous Database.
     * </pre>
     */
    public com.google.longrunning.Operation restartAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestartAutonomousDatabaseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service OracleDatabase.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class OracleDatabaseBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OracleDatabaseBlockingStub> {
    private OracleDatabaseBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OracleDatabaseBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OracleDatabaseBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Exadata Infrastructures in a given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse
        listCloudExadataInfrastructures(
            com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCloudExadataInfrastructuresMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Exadata Infrastructure.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure
        getCloudExadataInfrastructure(
            com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCloudExadataInfrastructureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Exadata Infrastructure in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCloudExadataInfrastructure(
        com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCloudExadataInfrastructureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Exadata Infrastructure.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCloudExadataInfrastructure(
        com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCloudExadataInfrastructureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the VM Clusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse listCloudVmClusters(
        com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCloudVmClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single VM Cluster.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.CloudVmCluster getCloudVmCluster(
        com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCloudVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new VM Cluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCloudVmCluster(
        com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCloudVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single VM Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCloudVmCluster(
        com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCloudVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the entitlements in a given project.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListEntitlementsResponse listEntitlements(
        com.google.cloud.oracledatabase.v1.ListEntitlementsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntitlementsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the database servers of an Exadata Infrastructure instance.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDbServersResponse listDbServers(
        com.google.cloud.oracledatabase.v1.ListDbServersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDbServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the database nodes of a VM Cluster.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDbNodesResponse listDbNodes(
        com.google.cloud.oracledatabase.v1.ListDbNodesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDbNodesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the valid Oracle Grid Infrastructure (GI) versions for the given
     * project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListGiVersionsResponse listGiVersions(
        com.google.cloud.oracledatabase.v1.ListGiVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGiVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the database system shapes available for the project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse listDbSystemShapes(
        com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDbSystemShapesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Autonomous Databases in a given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse
        listAutonomousDatabases(
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAutonomousDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single Autonomous Database.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.AutonomousDatabase getAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Autonomous Database in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Autonomous Database.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a single Autonomous Database.
     * </pre>
     */
    public com.google.longrunning.Operation restoreAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a wallet for an Autonomous Database.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse
        generateAutonomousDatabaseWallet(
            com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateAutonomousDatabaseWalletMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the available Autonomous Database versions for a project and
     * location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse
        listAutonomousDbVersions(
            com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAutonomousDbVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Autonomous Database Character Sets in a given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsResponse
        listAutonomousDatabaseCharacterSets(
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAutonomousDatabaseCharacterSetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the long-term and automatic backups of an Autonomous Database.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse
        listAutonomousDatabaseBackups(
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAutonomousDatabaseBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops an Autonomous Database.
     * </pre>
     */
    public com.google.longrunning.Operation stopAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts an Autonomous Database.
     * </pre>
     */
    public com.google.longrunning.Operation startAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restarts an Autonomous Database.
     * </pre>
     */
    public com.google.longrunning.Operation restartAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestartAutonomousDatabaseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OracleDatabase.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class OracleDatabaseFutureStub
      extends io.grpc.stub.AbstractFutureStub<OracleDatabaseFutureStub> {
    private OracleDatabaseFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OracleDatabaseFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OracleDatabaseFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Exadata Infrastructures in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse>
        listCloudExadataInfrastructures(
            com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCloudExadataInfrastructuresMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Exadata Infrastructure.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure>
        getCloudExadataInfrastructure(
            com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCloudExadataInfrastructureMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Exadata Infrastructure in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCloudExadataInfrastructure(
            com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCloudExadataInfrastructureMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Exadata Infrastructure.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCloudExadataInfrastructure(
            com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCloudExadataInfrastructureMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists the VM Clusters in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse>
        listCloudVmClusters(com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCloudVmClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single VM Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.CloudVmCluster>
        getCloudVmCluster(com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCloudVmClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new VM Cluster in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCloudVmCluster(
            com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCloudVmClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single VM Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCloudVmCluster(
            com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCloudVmClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the entitlements in a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListEntitlementsResponse>
        listEntitlements(com.google.cloud.oracledatabase.v1.ListEntitlementsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEntitlementsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the database servers of an Exadata Infrastructure instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListDbServersResponse>
        listDbServers(com.google.cloud.oracledatabase.v1.ListDbServersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDbServersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the database nodes of a VM Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListDbNodesResponse>
        listDbNodes(com.google.cloud.oracledatabase.v1.ListDbNodesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDbNodesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the valid Oracle Grid Infrastructure (GI) versions for the given
     * project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListGiVersionsResponse>
        listGiVersions(com.google.cloud.oracledatabase.v1.ListGiVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGiVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the database system shapes available for the project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse>
        listDbSystemShapes(com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDbSystemShapesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Autonomous Databases in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse>
        listAutonomousDatabases(
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAutonomousDatabasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single Autonomous Database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.AutonomousDatabase>
        getAutonomousDatabase(
            com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAutonomousDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Autonomous Database in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAutonomousDatabase(
            com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAutonomousDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Autonomous Database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAutonomousDatabase(
            com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAutonomousDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a single Autonomous Database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restoreAutonomousDatabase(
            com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreAutonomousDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a wallet for an Autonomous Database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse>
        generateAutonomousDatabaseWallet(
            com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateAutonomousDatabaseWalletMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the available Autonomous Database versions for a project and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse>
        listAutonomousDbVersions(
            com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAutonomousDbVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Autonomous Database Character Sets in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsResponse>
        listAutonomousDatabaseCharacterSets(
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAutonomousDatabaseCharacterSetsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists the long-term and automatic backups of an Autonomous Database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse>
        listAutonomousDatabaseBackups(
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAutonomousDatabaseBackupsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Stops an Autonomous Database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        stopAutonomousDatabase(
            com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopAutonomousDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts an Autonomous Database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        startAutonomousDatabase(
            com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartAutonomousDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restarts an Autonomous Database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restartAutonomousDatabase(
            com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestartAutonomousDatabaseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CLOUD_EXADATA_INFRASTRUCTURES = 0;
  private static final int METHODID_GET_CLOUD_EXADATA_INFRASTRUCTURE = 1;
  private static final int METHODID_CREATE_CLOUD_EXADATA_INFRASTRUCTURE = 2;
  private static final int METHODID_DELETE_CLOUD_EXADATA_INFRASTRUCTURE = 3;
  private static final int METHODID_LIST_CLOUD_VM_CLUSTERS = 4;
  private static final int METHODID_GET_CLOUD_VM_CLUSTER = 5;
  private static final int METHODID_CREATE_CLOUD_VM_CLUSTER = 6;
  private static final int METHODID_DELETE_CLOUD_VM_CLUSTER = 7;
  private static final int METHODID_LIST_ENTITLEMENTS = 8;
  private static final int METHODID_LIST_DB_SERVERS = 9;
  private static final int METHODID_LIST_DB_NODES = 10;
  private static final int METHODID_LIST_GI_VERSIONS = 11;
  private static final int METHODID_LIST_DB_SYSTEM_SHAPES = 12;
  private static final int METHODID_LIST_AUTONOMOUS_DATABASES = 13;
  private static final int METHODID_GET_AUTONOMOUS_DATABASE = 14;
  private static final int METHODID_CREATE_AUTONOMOUS_DATABASE = 15;
  private static final int METHODID_DELETE_AUTONOMOUS_DATABASE = 16;
  private static final int METHODID_RESTORE_AUTONOMOUS_DATABASE = 17;
  private static final int METHODID_GENERATE_AUTONOMOUS_DATABASE_WALLET = 18;
  private static final int METHODID_LIST_AUTONOMOUS_DB_VERSIONS = 19;
  private static final int METHODID_LIST_AUTONOMOUS_DATABASE_CHARACTER_SETS = 20;
  private static final int METHODID_LIST_AUTONOMOUS_DATABASE_BACKUPS = 21;
  private static final int METHODID_STOP_AUTONOMOUS_DATABASE = 22;
  private static final int METHODID_START_AUTONOMOUS_DATABASE = 23;
  private static final int METHODID_RESTART_AUTONOMOUS_DATABASE = 24;

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
        case METHODID_LIST_CLOUD_EXADATA_INFRASTRUCTURES:
          serviceImpl.listCloudExadataInfrastructures(
              (com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLOUD_EXADATA_INFRASTRUCTURE:
          serviceImpl.getCloudExadataInfrastructure(
              (com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure>)
                  responseObserver);
          break;
        case METHODID_CREATE_CLOUD_EXADATA_INFRASTRUCTURE:
          serviceImpl.createCloudExadataInfrastructure(
              (com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLOUD_EXADATA_INFRASTRUCTURE:
          serviceImpl.deleteCloudExadataInfrastructure(
              (com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CLOUD_VM_CLUSTERS:
          serviceImpl.listCloudVmClusters(
              (com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLOUD_VM_CLUSTER:
          serviceImpl.getCloudVmCluster(
              (com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.CloudVmCluster>)
                  responseObserver);
          break;
        case METHODID_CREATE_CLOUD_VM_CLUSTER:
          serviceImpl.createCloudVmCluster(
              (com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLOUD_VM_CLUSTER:
          serviceImpl.deleteCloudVmCluster(
              (com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ENTITLEMENTS:
          serviceImpl.listEntitlements(
              (com.google.cloud.oracledatabase.v1.ListEntitlementsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListEntitlementsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_DB_SERVERS:
          serviceImpl.listDbServers(
              (com.google.cloud.oracledatabase.v1.ListDbServersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListDbServersResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_DB_NODES:
          serviceImpl.listDbNodes(
              (com.google.cloud.oracledatabase.v1.ListDbNodesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListDbNodesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_GI_VERSIONS:
          serviceImpl.listGiVersions(
              (com.google.cloud.oracledatabase.v1.ListGiVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListGiVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_DB_SYSTEM_SHAPES:
          serviceImpl.listDbSystemShapes(
              (com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_AUTONOMOUS_DATABASES:
          serviceImpl.listAutonomousDatabases(
              (com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AUTONOMOUS_DATABASE:
          serviceImpl.getAutonomousDatabase(
              (com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.AutonomousDatabase>)
                  responseObserver);
          break;
        case METHODID_CREATE_AUTONOMOUS_DATABASE:
          serviceImpl.createAutonomousDatabase(
              (com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_AUTONOMOUS_DATABASE:
          serviceImpl.deleteAutonomousDatabase(
              (com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTORE_AUTONOMOUS_DATABASE:
          serviceImpl.restoreAutonomousDatabase(
              (com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_AUTONOMOUS_DATABASE_WALLET:
          serviceImpl.generateAutonomousDatabaseWallet(
              (com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_AUTONOMOUS_DB_VERSIONS:
          serviceImpl.listAutonomousDbVersions(
              (com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_AUTONOMOUS_DATABASE_CHARACTER_SETS:
          serviceImpl.listAutonomousDatabaseCharacterSets(
              (com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1
                          .ListAutonomousDatabaseCharacterSetsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_AUTONOMOUS_DATABASE_BACKUPS:
          serviceImpl.listAutonomousDatabaseBackups(
              (com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_STOP_AUTONOMOUS_DATABASE:
          serviceImpl.stopAutonomousDatabase(
              (com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_AUTONOMOUS_DATABASE:
          serviceImpl.startAutonomousDatabase(
              (com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTART_AUTONOMOUS_DATABASE:
          serviceImpl.restartAutonomousDatabase(
              (com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest) request,
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
            getListCloudExadataInfrastructuresMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest,
                    com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresResponse>(
                    service, METHODID_LIST_CLOUD_EXADATA_INFRASTRUCTURES)))
        .addMethod(
            getGetCloudExadataInfrastructureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest,
                    com.google.cloud.oracledatabase.v1.CloudExadataInfrastructure>(
                    service, METHODID_GET_CLOUD_EXADATA_INFRASTRUCTURE)))
        .addMethod(
            getCreateCloudExadataInfrastructureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_CLOUD_EXADATA_INFRASTRUCTURE)))
        .addMethod(
            getDeleteCloudExadataInfrastructureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_CLOUD_EXADATA_INFRASTRUCTURE)))
        .addMethod(
            getListCloudVmClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest,
                    com.google.cloud.oracledatabase.v1.ListCloudVmClustersResponse>(
                    service, METHODID_LIST_CLOUD_VM_CLUSTERS)))
        .addMethod(
            getGetCloudVmClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest,
                    com.google.cloud.oracledatabase.v1.CloudVmCluster>(
                    service, METHODID_GET_CLOUD_VM_CLUSTER)))
        .addMethod(
            getCreateCloudVmClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CLOUD_VM_CLUSTER)))
        .addMethod(
            getDeleteCloudVmClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CLOUD_VM_CLUSTER)))
        .addMethod(
            getListEntitlementsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListEntitlementsRequest,
                    com.google.cloud.oracledatabase.v1.ListEntitlementsResponse>(
                    service, METHODID_LIST_ENTITLEMENTS)))
        .addMethod(
            getListDbServersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListDbServersRequest,
                    com.google.cloud.oracledatabase.v1.ListDbServersResponse>(
                    service, METHODID_LIST_DB_SERVERS)))
        .addMethod(
            getListDbNodesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListDbNodesRequest,
                    com.google.cloud.oracledatabase.v1.ListDbNodesResponse>(
                    service, METHODID_LIST_DB_NODES)))
        .addMethod(
            getListGiVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListGiVersionsRequest,
                    com.google.cloud.oracledatabase.v1.ListGiVersionsResponse>(
                    service, METHODID_LIST_GI_VERSIONS)))
        .addMethod(
            getListDbSystemShapesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest,
                    com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse>(
                    service, METHODID_LIST_DB_SYSTEM_SHAPES)))
        .addMethod(
            getListAutonomousDatabasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest,
                    com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesResponse>(
                    service, METHODID_LIST_AUTONOMOUS_DATABASES)))
        .addMethod(
            getGetAutonomousDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest,
                    com.google.cloud.oracledatabase.v1.AutonomousDatabase>(
                    service, METHODID_GET_AUTONOMOUS_DATABASE)))
        .addMethod(
            getCreateAutonomousDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_AUTONOMOUS_DATABASE)))
        .addMethod(
            getDeleteAutonomousDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_AUTONOMOUS_DATABASE)))
        .addMethod(
            getRestoreAutonomousDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_RESTORE_AUTONOMOUS_DATABASE)))
        .addMethod(
            getGenerateAutonomousDatabaseWalletMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest,
                    com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletResponse>(
                    service, METHODID_GENERATE_AUTONOMOUS_DATABASE_WALLET)))
        .addMethod(
            getListAutonomousDbVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest,
                    com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsResponse>(
                    service, METHODID_LIST_AUTONOMOUS_DB_VERSIONS)))
        .addMethod(
            getListAutonomousDatabaseCharacterSetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest,
                    com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsResponse>(
                    service, METHODID_LIST_AUTONOMOUS_DATABASE_CHARACTER_SETS)))
        .addMethod(
            getListAutonomousDatabaseBackupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest,
                    com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsResponse>(
                    service, METHODID_LIST_AUTONOMOUS_DATABASE_BACKUPS)))
        .addMethod(
            getStopAutonomousDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest,
                    com.google.longrunning.Operation>(service, METHODID_STOP_AUTONOMOUS_DATABASE)))
        .addMethod(
            getStartAutonomousDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest,
                    com.google.longrunning.Operation>(service, METHODID_START_AUTONOMOUS_DATABASE)))
        .addMethod(
            getRestartAutonomousDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_RESTART_AUTONOMOUS_DATABASE)))
        .build();
  }

  private abstract static class OracleDatabaseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OracleDatabaseBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.oracledatabase.v1.V1mainProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OracleDatabase");
    }
  }

  private static final class OracleDatabaseFileDescriptorSupplier
      extends OracleDatabaseBaseDescriptorSupplier {
    OracleDatabaseFileDescriptorSupplier() {}
  }

  private static final class OracleDatabaseMethodDescriptorSupplier
      extends OracleDatabaseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OracleDatabaseMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OracleDatabaseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new OracleDatabaseFileDescriptorSupplier())
                      .addMethod(getListCloudExadataInfrastructuresMethod())
                      .addMethod(getGetCloudExadataInfrastructureMethod())
                      .addMethod(getCreateCloudExadataInfrastructureMethod())
                      .addMethod(getDeleteCloudExadataInfrastructureMethod())
                      .addMethod(getListCloudVmClustersMethod())
                      .addMethod(getGetCloudVmClusterMethod())
                      .addMethod(getCreateCloudVmClusterMethod())
                      .addMethod(getDeleteCloudVmClusterMethod())
                      .addMethod(getListEntitlementsMethod())
                      .addMethod(getListDbServersMethod())
                      .addMethod(getListDbNodesMethod())
                      .addMethod(getListGiVersionsMethod())
                      .addMethod(getListDbSystemShapesMethod())
                      .addMethod(getListAutonomousDatabasesMethod())
                      .addMethod(getGetAutonomousDatabaseMethod())
                      .addMethod(getCreateAutonomousDatabaseMethod())
                      .addMethod(getDeleteAutonomousDatabaseMethod())
                      .addMethod(getRestoreAutonomousDatabaseMethod())
                      .addMethod(getGenerateAutonomousDatabaseWalletMethod())
                      .addMethod(getListAutonomousDbVersionsMethod())
                      .addMethod(getListAutonomousDatabaseCharacterSetsMethod())
                      .addMethod(getListAutonomousDatabaseBackupsMethod())
                      .addMethod(getStopAutonomousDatabaseMethod())
                      .addMethod(getStartAutonomousDatabaseMethod())
                      .addMethod(getRestartAutonomousDatabaseMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
