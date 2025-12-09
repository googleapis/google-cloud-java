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
          com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest,
          com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse>
      getListMinorVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMinorVersions",
      requestType = com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest,
          com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse>
      getListMinorVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest,
            com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse>
        getListMinorVersionsMethod;
    if ((getListMinorVersionsMethod = OracleDatabaseGrpc.getListMinorVersionsMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListMinorVersionsMethod = OracleDatabaseGrpc.getListMinorVersionsMethod) == null) {
          OracleDatabaseGrpc.getListMinorVersionsMethod =
              getListMinorVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest,
                          com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMinorVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListMinorVersions"))
                      .build();
        }
      }
    }
    return getListMinorVersionsMethod;
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
          com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getUpdateAutonomousDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAutonomousDatabase",
      requestType = com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getUpdateAutonomousDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest,
            com.google.longrunning.Operation>
        getUpdateAutonomousDatabaseMethod;
    if ((getUpdateAutonomousDatabaseMethod = OracleDatabaseGrpc.getUpdateAutonomousDatabaseMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getUpdateAutonomousDatabaseMethod =
                OracleDatabaseGrpc.getUpdateAutonomousDatabaseMethod)
            == null) {
          OracleDatabaseGrpc.getUpdateAutonomousDatabaseMethod =
              getUpdateAutonomousDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAutonomousDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("UpdateAutonomousDatabase"))
                      .build();
        }
      }
    }
    return getUpdateAutonomousDatabaseMethod;
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getSwitchoverAutonomousDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SwitchoverAutonomousDatabase",
      requestType = com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getSwitchoverAutonomousDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest,
            com.google.longrunning.Operation>
        getSwitchoverAutonomousDatabaseMethod;
    if ((getSwitchoverAutonomousDatabaseMethod =
            OracleDatabaseGrpc.getSwitchoverAutonomousDatabaseMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getSwitchoverAutonomousDatabaseMethod =
                OracleDatabaseGrpc.getSwitchoverAutonomousDatabaseMethod)
            == null) {
          OracleDatabaseGrpc.getSwitchoverAutonomousDatabaseMethod =
              getSwitchoverAutonomousDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SwitchoverAutonomousDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier(
                              "SwitchoverAutonomousDatabase"))
                      .build();
        }
      }
    }
    return getSwitchoverAutonomousDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getFailoverAutonomousDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FailoverAutonomousDatabase",
      requestType = com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest,
          com.google.longrunning.Operation>
      getFailoverAutonomousDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest,
            com.google.longrunning.Operation>
        getFailoverAutonomousDatabaseMethod;
    if ((getFailoverAutonomousDatabaseMethod =
            OracleDatabaseGrpc.getFailoverAutonomousDatabaseMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getFailoverAutonomousDatabaseMethod =
                OracleDatabaseGrpc.getFailoverAutonomousDatabaseMethod)
            == null) {
          OracleDatabaseGrpc.getFailoverAutonomousDatabaseMethod =
              getFailoverAutonomousDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FailoverAutonomousDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("FailoverAutonomousDatabase"))
                      .build();
        }
      }
    }
    return getFailoverAutonomousDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest,
          com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse>
      getListOdbNetworksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOdbNetworks",
      requestType = com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest,
          com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse>
      getListOdbNetworksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest,
            com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse>
        getListOdbNetworksMethod;
    if ((getListOdbNetworksMethod = OracleDatabaseGrpc.getListOdbNetworksMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListOdbNetworksMethod = OracleDatabaseGrpc.getListOdbNetworksMethod) == null) {
          OracleDatabaseGrpc.getListOdbNetworksMethod =
              getListOdbNetworksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest,
                          com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOdbNetworks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListOdbNetworks"))
                      .build();
        }
      }
    }
    return getListOdbNetworksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest,
          com.google.cloud.oracledatabase.v1.OdbNetwork>
      getGetOdbNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOdbNetwork",
      requestType = com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.OdbNetwork.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest,
          com.google.cloud.oracledatabase.v1.OdbNetwork>
      getGetOdbNetworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest,
            com.google.cloud.oracledatabase.v1.OdbNetwork>
        getGetOdbNetworkMethod;
    if ((getGetOdbNetworkMethod = OracleDatabaseGrpc.getGetOdbNetworkMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getGetOdbNetworkMethod = OracleDatabaseGrpc.getGetOdbNetworkMethod) == null) {
          OracleDatabaseGrpc.getGetOdbNetworkMethod =
              getGetOdbNetworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest,
                          com.google.cloud.oracledatabase.v1.OdbNetwork>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOdbNetwork"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.OdbNetwork.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("GetOdbNetwork"))
                      .build();
        }
      }
    }
    return getGetOdbNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest,
          com.google.longrunning.Operation>
      getCreateOdbNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOdbNetwork",
      requestType = com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest,
          com.google.longrunning.Operation>
      getCreateOdbNetworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest,
            com.google.longrunning.Operation>
        getCreateOdbNetworkMethod;
    if ((getCreateOdbNetworkMethod = OracleDatabaseGrpc.getCreateOdbNetworkMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getCreateOdbNetworkMethod = OracleDatabaseGrpc.getCreateOdbNetworkMethod) == null) {
          OracleDatabaseGrpc.getCreateOdbNetworkMethod =
              getCreateOdbNetworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateOdbNetwork"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("CreateOdbNetwork"))
                      .build();
        }
      }
    }
    return getCreateOdbNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest,
          com.google.longrunning.Operation>
      getDeleteOdbNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteOdbNetwork",
      requestType = com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest,
          com.google.longrunning.Operation>
      getDeleteOdbNetworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest,
            com.google.longrunning.Operation>
        getDeleteOdbNetworkMethod;
    if ((getDeleteOdbNetworkMethod = OracleDatabaseGrpc.getDeleteOdbNetworkMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getDeleteOdbNetworkMethod = OracleDatabaseGrpc.getDeleteOdbNetworkMethod) == null) {
          OracleDatabaseGrpc.getDeleteOdbNetworkMethod =
              getDeleteOdbNetworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteOdbNetwork"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("DeleteOdbNetwork"))
                      .build();
        }
      }
    }
    return getDeleteOdbNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest,
          com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse>
      getListOdbSubnetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOdbSubnets",
      requestType = com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest,
          com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse>
      getListOdbSubnetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest,
            com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse>
        getListOdbSubnetsMethod;
    if ((getListOdbSubnetsMethod = OracleDatabaseGrpc.getListOdbSubnetsMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListOdbSubnetsMethod = OracleDatabaseGrpc.getListOdbSubnetsMethod) == null) {
          OracleDatabaseGrpc.getListOdbSubnetsMethod =
              getListOdbSubnetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest,
                          com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOdbSubnets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListOdbSubnets"))
                      .build();
        }
      }
    }
    return getListOdbSubnetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest,
          com.google.cloud.oracledatabase.v1.OdbSubnet>
      getGetOdbSubnetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOdbSubnet",
      requestType = com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.OdbSubnet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest,
          com.google.cloud.oracledatabase.v1.OdbSubnet>
      getGetOdbSubnetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest,
            com.google.cloud.oracledatabase.v1.OdbSubnet>
        getGetOdbSubnetMethod;
    if ((getGetOdbSubnetMethod = OracleDatabaseGrpc.getGetOdbSubnetMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getGetOdbSubnetMethod = OracleDatabaseGrpc.getGetOdbSubnetMethod) == null) {
          OracleDatabaseGrpc.getGetOdbSubnetMethod =
              getGetOdbSubnetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest,
                          com.google.cloud.oracledatabase.v1.OdbSubnet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOdbSubnet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.OdbSubnet.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("GetOdbSubnet"))
                      .build();
        }
      }
    }
    return getGetOdbSubnetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest,
          com.google.longrunning.Operation>
      getCreateOdbSubnetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOdbSubnet",
      requestType = com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest,
          com.google.longrunning.Operation>
      getCreateOdbSubnetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest,
            com.google.longrunning.Operation>
        getCreateOdbSubnetMethod;
    if ((getCreateOdbSubnetMethod = OracleDatabaseGrpc.getCreateOdbSubnetMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getCreateOdbSubnetMethod = OracleDatabaseGrpc.getCreateOdbSubnetMethod) == null) {
          OracleDatabaseGrpc.getCreateOdbSubnetMethod =
              getCreateOdbSubnetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateOdbSubnet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("CreateOdbSubnet"))
                      .build();
        }
      }
    }
    return getCreateOdbSubnetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest,
          com.google.longrunning.Operation>
      getDeleteOdbSubnetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteOdbSubnet",
      requestType = com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest,
          com.google.longrunning.Operation>
      getDeleteOdbSubnetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest,
            com.google.longrunning.Operation>
        getDeleteOdbSubnetMethod;
    if ((getDeleteOdbSubnetMethod = OracleDatabaseGrpc.getDeleteOdbSubnetMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getDeleteOdbSubnetMethod = OracleDatabaseGrpc.getDeleteOdbSubnetMethod) == null) {
          OracleDatabaseGrpc.getDeleteOdbSubnetMethod =
              getDeleteOdbSubnetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteOdbSubnet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("DeleteOdbSubnet"))
                      .build();
        }
      }
    }
    return getDeleteOdbSubnetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest,
          com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse>
      getListExadbVmClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExadbVmClusters",
      requestType = com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest,
          com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse>
      getListExadbVmClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest,
            com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse>
        getListExadbVmClustersMethod;
    if ((getListExadbVmClustersMethod = OracleDatabaseGrpc.getListExadbVmClustersMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListExadbVmClustersMethod = OracleDatabaseGrpc.getListExadbVmClustersMethod)
            == null) {
          OracleDatabaseGrpc.getListExadbVmClustersMethod =
              getListExadbVmClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest,
                          com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListExadbVmClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListExadbVmClusters"))
                      .build();
        }
      }
    }
    return getListExadbVmClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest,
          com.google.cloud.oracledatabase.v1.ExadbVmCluster>
      getGetExadbVmClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExadbVmCluster",
      requestType = com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ExadbVmCluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest,
          com.google.cloud.oracledatabase.v1.ExadbVmCluster>
      getGetExadbVmClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest,
            com.google.cloud.oracledatabase.v1.ExadbVmCluster>
        getGetExadbVmClusterMethod;
    if ((getGetExadbVmClusterMethod = OracleDatabaseGrpc.getGetExadbVmClusterMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getGetExadbVmClusterMethod = OracleDatabaseGrpc.getGetExadbVmClusterMethod) == null) {
          OracleDatabaseGrpc.getGetExadbVmClusterMethod =
              getGetExadbVmClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest,
                          com.google.cloud.oracledatabase.v1.ExadbVmCluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExadbVmCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ExadbVmCluster
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("GetExadbVmCluster"))
                      .build();
        }
      }
    }
    return getGetExadbVmClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest,
          com.google.longrunning.Operation>
      getCreateExadbVmClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExadbVmCluster",
      requestType = com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest,
          com.google.longrunning.Operation>
      getCreateExadbVmClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest,
            com.google.longrunning.Operation>
        getCreateExadbVmClusterMethod;
    if ((getCreateExadbVmClusterMethod = OracleDatabaseGrpc.getCreateExadbVmClusterMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getCreateExadbVmClusterMethod = OracleDatabaseGrpc.getCreateExadbVmClusterMethod)
            == null) {
          OracleDatabaseGrpc.getCreateExadbVmClusterMethod =
              getCreateExadbVmClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateExadbVmCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("CreateExadbVmCluster"))
                      .build();
        }
      }
    }
    return getCreateExadbVmClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest,
          com.google.longrunning.Operation>
      getDeleteExadbVmClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExadbVmCluster",
      requestType = com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest,
          com.google.longrunning.Operation>
      getDeleteExadbVmClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest,
            com.google.longrunning.Operation>
        getDeleteExadbVmClusterMethod;
    if ((getDeleteExadbVmClusterMethod = OracleDatabaseGrpc.getDeleteExadbVmClusterMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getDeleteExadbVmClusterMethod = OracleDatabaseGrpc.getDeleteExadbVmClusterMethod)
            == null) {
          OracleDatabaseGrpc.getDeleteExadbVmClusterMethod =
              getDeleteExadbVmClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteExadbVmCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("DeleteExadbVmCluster"))
                      .build();
        }
      }
    }
    return getDeleteExadbVmClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest,
          com.google.longrunning.Operation>
      getUpdateExadbVmClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExadbVmCluster",
      requestType = com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest,
          com.google.longrunning.Operation>
      getUpdateExadbVmClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest,
            com.google.longrunning.Operation>
        getUpdateExadbVmClusterMethod;
    if ((getUpdateExadbVmClusterMethod = OracleDatabaseGrpc.getUpdateExadbVmClusterMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getUpdateExadbVmClusterMethod = OracleDatabaseGrpc.getUpdateExadbVmClusterMethod)
            == null) {
          OracleDatabaseGrpc.getUpdateExadbVmClusterMethod =
              getUpdateExadbVmClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateExadbVmCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("UpdateExadbVmCluster"))
                      .build();
        }
      }
    }
    return getUpdateExadbVmClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest,
          com.google.longrunning.Operation>
      getRemoveVirtualMachineExadbVmClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveVirtualMachineExadbVmCluster",
      requestType =
          com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest,
          com.google.longrunning.Operation>
      getRemoveVirtualMachineExadbVmClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest,
            com.google.longrunning.Operation>
        getRemoveVirtualMachineExadbVmClusterMethod;
    if ((getRemoveVirtualMachineExadbVmClusterMethod =
            OracleDatabaseGrpc.getRemoveVirtualMachineExadbVmClusterMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getRemoveVirtualMachineExadbVmClusterMethod =
                OracleDatabaseGrpc.getRemoveVirtualMachineExadbVmClusterMethod)
            == null) {
          OracleDatabaseGrpc.getRemoveVirtualMachineExadbVmClusterMethod =
              getRemoveVirtualMachineExadbVmClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1
                              .RemoveVirtualMachineExadbVmClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "RemoveVirtualMachineExadbVmCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .RemoveVirtualMachineExadbVmClusterRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier(
                              "RemoveVirtualMachineExadbVmCluster"))
                      .build();
        }
      }
    }
    return getRemoveVirtualMachineExadbVmClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest,
          com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse>
      getListExascaleDbStorageVaultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExascaleDbStorageVaults",
      requestType = com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest,
          com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse>
      getListExascaleDbStorageVaultsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest,
            com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse>
        getListExascaleDbStorageVaultsMethod;
    if ((getListExascaleDbStorageVaultsMethod =
            OracleDatabaseGrpc.getListExascaleDbStorageVaultsMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListExascaleDbStorageVaultsMethod =
                OracleDatabaseGrpc.getListExascaleDbStorageVaultsMethod)
            == null) {
          OracleDatabaseGrpc.getListExascaleDbStorageVaultsMethod =
              getListExascaleDbStorageVaultsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest,
                          com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListExascaleDbStorageVaults"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListExascaleDbStorageVaults"))
                      .build();
        }
      }
    }
    return getListExascaleDbStorageVaultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest,
          com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault>
      getGetExascaleDbStorageVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExascaleDbStorageVault",
      requestType = com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest,
          com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault>
      getGetExascaleDbStorageVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest,
            com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault>
        getGetExascaleDbStorageVaultMethod;
    if ((getGetExascaleDbStorageVaultMethod = OracleDatabaseGrpc.getGetExascaleDbStorageVaultMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getGetExascaleDbStorageVaultMethod =
                OracleDatabaseGrpc.getGetExascaleDbStorageVaultMethod)
            == null) {
          OracleDatabaseGrpc.getGetExascaleDbStorageVaultMethod =
              getGetExascaleDbStorageVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest,
                          com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetExascaleDbStorageVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("GetExascaleDbStorageVault"))
                      .build();
        }
      }
    }
    return getGetExascaleDbStorageVaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest,
          com.google.longrunning.Operation>
      getCreateExascaleDbStorageVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExascaleDbStorageVault",
      requestType = com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest,
          com.google.longrunning.Operation>
      getCreateExascaleDbStorageVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest,
            com.google.longrunning.Operation>
        getCreateExascaleDbStorageVaultMethod;
    if ((getCreateExascaleDbStorageVaultMethod =
            OracleDatabaseGrpc.getCreateExascaleDbStorageVaultMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getCreateExascaleDbStorageVaultMethod =
                OracleDatabaseGrpc.getCreateExascaleDbStorageVaultMethod)
            == null) {
          OracleDatabaseGrpc.getCreateExascaleDbStorageVaultMethod =
              getCreateExascaleDbStorageVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateExascaleDbStorageVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier(
                              "CreateExascaleDbStorageVault"))
                      .build();
        }
      }
    }
    return getCreateExascaleDbStorageVaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest,
          com.google.longrunning.Operation>
      getDeleteExascaleDbStorageVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExascaleDbStorageVault",
      requestType = com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest,
          com.google.longrunning.Operation>
      getDeleteExascaleDbStorageVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest,
            com.google.longrunning.Operation>
        getDeleteExascaleDbStorageVaultMethod;
    if ((getDeleteExascaleDbStorageVaultMethod =
            OracleDatabaseGrpc.getDeleteExascaleDbStorageVaultMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getDeleteExascaleDbStorageVaultMethod =
                OracleDatabaseGrpc.getDeleteExascaleDbStorageVaultMethod)
            == null) {
          OracleDatabaseGrpc.getDeleteExascaleDbStorageVaultMethod =
              getDeleteExascaleDbStorageVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteExascaleDbStorageVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier(
                              "DeleteExascaleDbStorageVault"))
                      .build();
        }
      }
    }
    return getDeleteExascaleDbStorageVaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest,
          com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse>
      getListDbSystemInitialStorageSizesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDbSystemInitialStorageSizes",
      requestType = com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest.class,
      responseType =
          com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest,
          com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse>
      getListDbSystemInitialStorageSizesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest,
            com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse>
        getListDbSystemInitialStorageSizesMethod;
    if ((getListDbSystemInitialStorageSizesMethod =
            OracleDatabaseGrpc.getListDbSystemInitialStorageSizesMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListDbSystemInitialStorageSizesMethod =
                OracleDatabaseGrpc.getListDbSystemInitialStorageSizesMethod)
            == null) {
          OracleDatabaseGrpc.getListDbSystemInitialStorageSizesMethod =
              getListDbSystemInitialStorageSizesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest,
                          com.google.cloud.oracledatabase.v1
                              .ListDbSystemInitialStorageSizesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDbSystemInitialStorageSizes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .ListDbSystemInitialStorageSizesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1
                                  .ListDbSystemInitialStorageSizesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier(
                              "ListDbSystemInitialStorageSizes"))
                      .build();
        }
      }
    }
    return getListDbSystemInitialStorageSizesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDatabasesRequest,
          com.google.cloud.oracledatabase.v1.ListDatabasesResponse>
      getListDatabasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatabases",
      requestType = com.google.cloud.oracledatabase.v1.ListDatabasesRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListDatabasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDatabasesRequest,
          com.google.cloud.oracledatabase.v1.ListDatabasesResponse>
      getListDatabasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListDatabasesRequest,
            com.google.cloud.oracledatabase.v1.ListDatabasesResponse>
        getListDatabasesMethod;
    if ((getListDatabasesMethod = OracleDatabaseGrpc.getListDatabasesMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListDatabasesMethod = OracleDatabaseGrpc.getListDatabasesMethod) == null) {
          OracleDatabaseGrpc.getListDatabasesMethod =
              getListDatabasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListDatabasesRequest,
                          com.google.cloud.oracledatabase.v1.ListDatabasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatabases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDatabasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDatabasesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListDatabases"))
                      .build();
        }
      }
    }
    return getListDatabasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetDatabaseRequest,
          com.google.cloud.oracledatabase.v1.Database>
      getGetDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDatabase",
      requestType = com.google.cloud.oracledatabase.v1.GetDatabaseRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.Database.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetDatabaseRequest,
          com.google.cloud.oracledatabase.v1.Database>
      getGetDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.GetDatabaseRequest,
            com.google.cloud.oracledatabase.v1.Database>
        getGetDatabaseMethod;
    if ((getGetDatabaseMethod = OracleDatabaseGrpc.getGetDatabaseMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getGetDatabaseMethod = OracleDatabaseGrpc.getGetDatabaseMethod) == null) {
          OracleDatabaseGrpc.getGetDatabaseMethod =
              getGetDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.GetDatabaseRequest,
                          com.google.cloud.oracledatabase.v1.Database>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.GetDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.Database.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("GetDatabase"))
                      .build();
        }
      }
    }
    return getGetDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest,
          com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse>
      getListPluggableDatabasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPluggableDatabases",
      requestType = com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest,
          com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse>
      getListPluggableDatabasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest,
            com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse>
        getListPluggableDatabasesMethod;
    if ((getListPluggableDatabasesMethod = OracleDatabaseGrpc.getListPluggableDatabasesMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListPluggableDatabasesMethod = OracleDatabaseGrpc.getListPluggableDatabasesMethod)
            == null) {
          OracleDatabaseGrpc.getListPluggableDatabasesMethod =
              getListPluggableDatabasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest,
                          com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPluggableDatabases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListPluggableDatabases"))
                      .build();
        }
      }
    }
    return getListPluggableDatabasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest,
          com.google.cloud.oracledatabase.v1.PluggableDatabase>
      getGetPluggableDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPluggableDatabase",
      requestType = com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.PluggableDatabase.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest,
          com.google.cloud.oracledatabase.v1.PluggableDatabase>
      getGetPluggableDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest,
            com.google.cloud.oracledatabase.v1.PluggableDatabase>
        getGetPluggableDatabaseMethod;
    if ((getGetPluggableDatabaseMethod = OracleDatabaseGrpc.getGetPluggableDatabaseMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getGetPluggableDatabaseMethod = OracleDatabaseGrpc.getGetPluggableDatabaseMethod)
            == null) {
          OracleDatabaseGrpc.getGetPluggableDatabaseMethod =
              getGetPluggableDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest,
                          com.google.cloud.oracledatabase.v1.PluggableDatabase>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetPluggableDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.PluggableDatabase
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("GetPluggableDatabase"))
                      .build();
        }
      }
    }
    return getGetPluggableDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDbSystemsRequest,
          com.google.cloud.oracledatabase.v1.ListDbSystemsResponse>
      getListDbSystemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDbSystems",
      requestType = com.google.cloud.oracledatabase.v1.ListDbSystemsRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListDbSystemsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDbSystemsRequest,
          com.google.cloud.oracledatabase.v1.ListDbSystemsResponse>
      getListDbSystemsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListDbSystemsRequest,
            com.google.cloud.oracledatabase.v1.ListDbSystemsResponse>
        getListDbSystemsMethod;
    if ((getListDbSystemsMethod = OracleDatabaseGrpc.getListDbSystemsMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListDbSystemsMethod = OracleDatabaseGrpc.getListDbSystemsMethod) == null) {
          OracleDatabaseGrpc.getListDbSystemsMethod =
              getListDbSystemsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListDbSystemsRequest,
                          com.google.cloud.oracledatabase.v1.ListDbSystemsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDbSystems"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDbSystemsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDbSystemsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListDbSystems"))
                      .build();
        }
      }
    }
    return getListDbSystemsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetDbSystemRequest,
          com.google.cloud.oracledatabase.v1.DbSystem>
      getGetDbSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDbSystem",
      requestType = com.google.cloud.oracledatabase.v1.GetDbSystemRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.DbSystem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.GetDbSystemRequest,
          com.google.cloud.oracledatabase.v1.DbSystem>
      getGetDbSystemMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.GetDbSystemRequest,
            com.google.cloud.oracledatabase.v1.DbSystem>
        getGetDbSystemMethod;
    if ((getGetDbSystemMethod = OracleDatabaseGrpc.getGetDbSystemMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getGetDbSystemMethod = OracleDatabaseGrpc.getGetDbSystemMethod) == null) {
          OracleDatabaseGrpc.getGetDbSystemMethod =
              getGetDbSystemMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.GetDbSystemRequest,
                          com.google.cloud.oracledatabase.v1.DbSystem>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDbSystem"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.GetDbSystemRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.DbSystem.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("GetDbSystem"))
                      .build();
        }
      }
    }
    return getGetDbSystemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateDbSystemRequest,
          com.google.longrunning.Operation>
      getCreateDbSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDbSystem",
      requestType = com.google.cloud.oracledatabase.v1.CreateDbSystemRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.CreateDbSystemRequest,
          com.google.longrunning.Operation>
      getCreateDbSystemMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.CreateDbSystemRequest,
            com.google.longrunning.Operation>
        getCreateDbSystemMethod;
    if ((getCreateDbSystemMethod = OracleDatabaseGrpc.getCreateDbSystemMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getCreateDbSystemMethod = OracleDatabaseGrpc.getCreateDbSystemMethod) == null) {
          OracleDatabaseGrpc.getCreateDbSystemMethod =
              getCreateDbSystemMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.CreateDbSystemRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDbSystem"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.CreateDbSystemRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("CreateDbSystem"))
                      .build();
        }
      }
    }
    return getCreateDbSystemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest,
          com.google.longrunning.Operation>
      getDeleteDbSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDbSystem",
      requestType = com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest,
          com.google.longrunning.Operation>
      getDeleteDbSystemMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest,
            com.google.longrunning.Operation>
        getDeleteDbSystemMethod;
    if ((getDeleteDbSystemMethod = OracleDatabaseGrpc.getDeleteDbSystemMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getDeleteDbSystemMethod = OracleDatabaseGrpc.getDeleteDbSystemMethod) == null) {
          OracleDatabaseGrpc.getDeleteDbSystemMethod =
              getDeleteDbSystemMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDbSystem"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("DeleteDbSystem"))
                      .build();
        }
      }
    }
    return getDeleteDbSystemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDbVersionsRequest,
          com.google.cloud.oracledatabase.v1.ListDbVersionsResponse>
      getListDbVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDbVersions",
      requestType = com.google.cloud.oracledatabase.v1.ListDbVersionsRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListDbVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDbVersionsRequest,
          com.google.cloud.oracledatabase.v1.ListDbVersionsResponse>
      getListDbVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListDbVersionsRequest,
            com.google.cloud.oracledatabase.v1.ListDbVersionsResponse>
        getListDbVersionsMethod;
    if ((getListDbVersionsMethod = OracleDatabaseGrpc.getListDbVersionsMethod) == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListDbVersionsMethod = OracleDatabaseGrpc.getListDbVersionsMethod) == null) {
          OracleDatabaseGrpc.getListDbVersionsMethod =
              getListDbVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListDbVersionsRequest,
                          com.google.cloud.oracledatabase.v1.ListDbVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDbVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDbVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDbVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListDbVersions"))
                      .build();
        }
      }
    }
    return getListDbVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest,
          com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse>
      getListDatabaseCharacterSetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatabaseCharacterSets",
      requestType = com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest.class,
      responseType = com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest,
          com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse>
      getListDatabaseCharacterSetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest,
            com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse>
        getListDatabaseCharacterSetsMethod;
    if ((getListDatabaseCharacterSetsMethod = OracleDatabaseGrpc.getListDatabaseCharacterSetsMethod)
        == null) {
      synchronized (OracleDatabaseGrpc.class) {
        if ((getListDatabaseCharacterSetsMethod =
                OracleDatabaseGrpc.getListDatabaseCharacterSetsMethod)
            == null) {
          OracleDatabaseGrpc.getListDatabaseCharacterSetsMethod =
              getListDatabaseCharacterSetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest,
                          com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDatabaseCharacterSets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OracleDatabaseMethodDescriptorSupplier("ListDatabaseCharacterSets"))
                      .build();
        }
      }
    }
    return getListDatabaseCharacterSetsMethod;
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
     * Lists all the valid minor versions for the given
     * project, location, gi version and shape family.
     * </pre>
     */
    default void listMinorVersions(
        com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMinorVersionsMethod(), responseObserver);
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
     * Updates the parameters of a single Autonomous Database.
     * </pre>
     */
    default void updateAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAutonomousDatabaseMethod(), responseObserver);
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

    /**
     *
     *
     * <pre>
     * Initiates a switchover of specified autonomous database to the associated
     * peer database.
     * </pre>
     */
    default void switchoverAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSwitchoverAutonomousDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a failover to target autonomous database from the associated
     * primary database.
     * </pre>
     */
    default void failoverAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFailoverAutonomousDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the ODB Networks in a given project and location.
     * </pre>
     */
    default void listOdbNetworks(
        com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOdbNetworksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ODB Network.
     * </pre>
     */
    default void getOdbNetwork(
        com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.OdbNetwork>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOdbNetworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ODB Network in a given project and location.
     * </pre>
     */
    default void createOdbNetwork(
        com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateOdbNetworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ODB Network.
     * </pre>
     */
    default void deleteOdbNetwork(
        com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteOdbNetworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the ODB Subnets in a given ODB Network.
     * </pre>
     */
    default void listOdbSubnets(
        com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOdbSubnetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ODB Subnet.
     * </pre>
     */
    default void getOdbSubnet(
        com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.OdbSubnet>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOdbSubnetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ODB Subnet in a given ODB Network.
     * </pre>
     */
    default void createOdbSubnet(
        com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateOdbSubnetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ODB Subnet.
     * </pre>
     */
    default void deleteOdbSubnet(
        com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteOdbSubnetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the Exadb (Exascale) VM Clusters for the given project and
     * location.
     * </pre>
     */
    default void listExadbVmClusters(
        com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExadbVmClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Exadb (Exascale) VM Cluster.
     * </pre>
     */
    default void getExadbVmCluster(
        com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ExadbVmCluster>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExadbVmClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Exadb (Exascale) VM Cluster resource.
     * </pre>
     */
    default void createExadbVmCluster(
        com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExadbVmClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Exadb (Exascale) VM Cluster.
     * </pre>
     */
    default void deleteExadbVmCluster(
        com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExadbVmClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Exadb (Exascale) VM Cluster. To add virtual machines to
     * existing exadb vm cluster, only pass the node count.
     * </pre>
     */
    default void updateExadbVmCluster(
        com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateExadbVmClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes virtual machines from an existing exadb vm cluster.
     * </pre>
     */
    default void removeVirtualMachineExadbVmCluster(
        com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveVirtualMachineExadbVmClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the ExascaleDB Storage Vaults for the given project and
     * location.
     * </pre>
     */
    default void listExascaleDbStorageVaults(
        com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExascaleDbStorageVaultsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ExascaleDB Storage Vault.
     * </pre>
     */
    default void getExascaleDbStorageVault(
        com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExascaleDbStorageVaultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ExascaleDB Storage Vault resource.
     * </pre>
     */
    default void createExascaleDbStorageVault(
        com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExascaleDbStorageVaultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ExascaleDB Storage Vault.
     * </pre>
     */
    default void deleteExascaleDbStorageVault(
        com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExascaleDbStorageVaultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the DbSystemInitialStorageSizes for the given project and
     * location.
     * </pre>
     */
    default void listDbSystemInitialStorageSizes(
        com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDbSystemInitialStorageSizesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the Databases for the given project, location and DbSystem.
     * </pre>
     */
    default void listDatabases(
        com.google.cloud.oracledatabase.v1.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatabasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Database.
     * </pre>
     */
    default void getDatabase(
        com.google.cloud.oracledatabase.v1.GetDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.Database> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the PluggableDatabases for the given project, location and
     * Container Database.
     * </pre>
     */
    default void listPluggableDatabases(
        com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPluggableDatabasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PluggableDatabase.
     * </pre>
     */
    default void getPluggableDatabase(
        com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.PluggableDatabase>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPluggableDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the DbSystems for the given project and location.
     * </pre>
     */
    default void listDbSystems(
        com.google.cloud.oracledatabase.v1.ListDbSystemsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListDbSystemsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDbSystemsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DbSystem.
     * </pre>
     */
    default void getDbSystem(
        com.google.cloud.oracledatabase.v1.GetDbSystemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.DbSystem> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDbSystemMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DbSystem in a given project and location.
     * </pre>
     */
    default void createDbSystem(
        com.google.cloud.oracledatabase.v1.CreateDbSystemRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDbSystemMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DbSystem.
     * </pre>
     */
    default void deleteDbSystem(
        com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDbSystemMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List DbVersions for the given project and location.
     * </pre>
     */
    default void listDbVersions(
        com.google.cloud.oracledatabase.v1.ListDbVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListDbVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDbVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List DatabaseCharacterSets for the given project and location.
     * </pre>
     */
    default void listDatabaseCharacterSets(
        com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatabaseCharacterSetsMethod(), responseObserver);
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
     * Lists all the valid minor versions for the given
     * project, location, gi version and shape family.
     * </pre>
     */
    public void listMinorVersions(
        com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMinorVersionsMethod(), getCallOptions()),
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
     * Updates the parameters of a single Autonomous Database.
     * </pre>
     */
    public void updateAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAutonomousDatabaseMethod(), getCallOptions()),
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

    /**
     *
     *
     * <pre>
     * Initiates a switchover of specified autonomous database to the associated
     * peer database.
     * </pre>
     */
    public void switchoverAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSwitchoverAutonomousDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a failover to target autonomous database from the associated
     * primary database.
     * </pre>
     */
    public void failoverAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFailoverAutonomousDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the ODB Networks in a given project and location.
     * </pre>
     */
    public void listOdbNetworks(
        com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOdbNetworksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ODB Network.
     * </pre>
     */
    public void getOdbNetwork(
        com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.OdbNetwork>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOdbNetworkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ODB Network in a given project and location.
     * </pre>
     */
    public void createOdbNetwork(
        com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOdbNetworkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ODB Network.
     * </pre>
     */
    public void deleteOdbNetwork(
        com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteOdbNetworkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the ODB Subnets in a given ODB Network.
     * </pre>
     */
    public void listOdbSubnets(
        com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOdbSubnetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ODB Subnet.
     * </pre>
     */
    public void getOdbSubnet(
        com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.OdbSubnet>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOdbSubnetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ODB Subnet in a given ODB Network.
     * </pre>
     */
    public void createOdbSubnet(
        com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOdbSubnetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ODB Subnet.
     * </pre>
     */
    public void deleteOdbSubnet(
        com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteOdbSubnetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the Exadb (Exascale) VM Clusters for the given project and
     * location.
     * </pre>
     */
    public void listExadbVmClusters(
        com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExadbVmClustersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Exadb (Exascale) VM Cluster.
     * </pre>
     */
    public void getExadbVmCluster(
        com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ExadbVmCluster>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExadbVmClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Exadb (Exascale) VM Cluster resource.
     * </pre>
     */
    public void createExadbVmCluster(
        com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExadbVmClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Exadb (Exascale) VM Cluster.
     * </pre>
     */
    public void deleteExadbVmCluster(
        com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExadbVmClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Exadb (Exascale) VM Cluster. To add virtual machines to
     * existing exadb vm cluster, only pass the node count.
     * </pre>
     */
    public void updateExadbVmCluster(
        com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExadbVmClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes virtual machines from an existing exadb vm cluster.
     * </pre>
     */
    public void removeVirtualMachineExadbVmCluster(
        com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveVirtualMachineExadbVmClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the ExascaleDB Storage Vaults for the given project and
     * location.
     * </pre>
     */
    public void listExascaleDbStorageVaults(
        com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExascaleDbStorageVaultsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ExascaleDB Storage Vault.
     * </pre>
     */
    public void getExascaleDbStorageVault(
        com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExascaleDbStorageVaultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ExascaleDB Storage Vault resource.
     * </pre>
     */
    public void createExascaleDbStorageVault(
        com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExascaleDbStorageVaultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ExascaleDB Storage Vault.
     * </pre>
     */
    public void deleteExascaleDbStorageVault(
        com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExascaleDbStorageVaultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the DbSystemInitialStorageSizes for the given project and
     * location.
     * </pre>
     */
    public void listDbSystemInitialStorageSizes(
        com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDbSystemInitialStorageSizesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the Databases for the given project, location and DbSystem.
     * </pre>
     */
    public void listDatabases(
        com.google.cloud.oracledatabase.v1.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListDatabasesResponse>
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
     * Gets details of a single Database.
     * </pre>
     */
    public void getDatabase(
        com.google.cloud.oracledatabase.v1.GetDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.Database> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the PluggableDatabases for the given project, location and
     * Container Database.
     * </pre>
     */
    public void listPluggableDatabases(
        com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPluggableDatabasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PluggableDatabase.
     * </pre>
     */
    public void getPluggableDatabase(
        com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.PluggableDatabase>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPluggableDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the DbSystems for the given project and location.
     * </pre>
     */
    public void listDbSystems(
        com.google.cloud.oracledatabase.v1.ListDbSystemsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListDbSystemsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDbSystemsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DbSystem.
     * </pre>
     */
    public void getDbSystem(
        com.google.cloud.oracledatabase.v1.GetDbSystemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.DbSystem> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDbSystemMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DbSystem in a given project and location.
     * </pre>
     */
    public void createDbSystem(
        com.google.cloud.oracledatabase.v1.CreateDbSystemRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDbSystemMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DbSystem.
     * </pre>
     */
    public void deleteDbSystem(
        com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDbSystemMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List DbVersions for the given project and location.
     * </pre>
     */
    public void listDbVersions(
        com.google.cloud.oracledatabase.v1.ListDbVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ListDbVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDbVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List DatabaseCharacterSets for the given project and location.
     * </pre>
     */
    public void listDatabaseCharacterSets(
        com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatabaseCharacterSetsMethod(), getCallOptions()),
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
            com.google.cloud.oracledatabase.v1.ListCloudExadataInfrastructuresRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
            com.google.cloud.oracledatabase.v1.GetCloudExadataInfrastructureRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.CreateCloudExadataInfrastructureRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.DeleteCloudExadataInfrastructureRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.ListCloudVmClustersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.GetCloudVmClusterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.CreateCloudVmClusterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.DeleteCloudVmClusterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.ListEntitlementsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.ListDbServersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.ListDbNodesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.ListGiVersionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListGiVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the valid minor versions for the given
     * project, location, gi version and shape family.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse listMinorVersions(
        com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMinorVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the database system shapes available for the project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDbSystemShapesResponse listDbSystemShapes(
        com.google.cloud.oracledatabase.v1.ListDbSystemShapesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabasesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.GetAutonomousDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.CreateAutonomousDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Autonomous Database.
     * </pre>
     */
    public com.google.longrunning.Operation updateAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Autonomous Database.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.DeleteAutonomousDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.RestoreAutonomousDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
            com.google.cloud.oracledatabase.v1.GenerateAutonomousDatabaseWalletRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
            com.google.cloud.oracledatabase.v1.ListAutonomousDbVersionsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseCharacterSetsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
            com.google.cloud.oracledatabase.v1.ListAutonomousDatabaseBackupsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.StopAutonomousDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.StartAutonomousDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.oracledatabase.v1.RestartAutonomousDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRestartAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a switchover of specified autonomous database to the associated
     * peer database.
     * </pre>
     */
    public com.google.longrunning.Operation switchoverAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSwitchoverAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a failover to target autonomous database from the associated
     * primary database.
     * </pre>
     */
    public com.google.longrunning.Operation failoverAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFailoverAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the ODB Networks in a given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse listOdbNetworks(
        com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListOdbNetworksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ODB Network.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.OdbNetwork getOdbNetwork(
        com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetOdbNetworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ODB Network in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createOdbNetwork(
        com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateOdbNetworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ODB Network.
     * </pre>
     */
    public com.google.longrunning.Operation deleteOdbNetwork(
        com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteOdbNetworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the ODB Subnets in a given ODB Network.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse listOdbSubnets(
        com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListOdbSubnetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ODB Subnet.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.OdbSubnet getOdbSubnet(
        com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetOdbSubnetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ODB Subnet in a given ODB Network.
     * </pre>
     */
    public com.google.longrunning.Operation createOdbSubnet(
        com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateOdbSubnetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ODB Subnet.
     * </pre>
     */
    public com.google.longrunning.Operation deleteOdbSubnet(
        com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteOdbSubnetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the Exadb (Exascale) VM Clusters for the given project and
     * location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse listExadbVmClusters(
        com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListExadbVmClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Exadb (Exascale) VM Cluster.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ExadbVmCluster getExadbVmCluster(
        com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetExadbVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Exadb (Exascale) VM Cluster resource.
     * </pre>
     */
    public com.google.longrunning.Operation createExadbVmCluster(
        com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateExadbVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Exadb (Exascale) VM Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteExadbVmCluster(
        com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteExadbVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Exadb (Exascale) VM Cluster. To add virtual machines to
     * existing exadb vm cluster, only pass the node count.
     * </pre>
     */
    public com.google.longrunning.Operation updateExadbVmCluster(
        com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateExadbVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes virtual machines from an existing exadb vm cluster.
     * </pre>
     */
    public com.google.longrunning.Operation removeVirtualMachineExadbVmCluster(
        com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRemoveVirtualMachineExadbVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the ExascaleDB Storage Vaults for the given project and
     * location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse
        listExascaleDbStorageVaults(
            com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListExascaleDbStorageVaultsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ExascaleDB Storage Vault.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault getExascaleDbStorageVault(
        com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetExascaleDbStorageVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ExascaleDB Storage Vault resource.
     * </pre>
     */
    public com.google.longrunning.Operation createExascaleDbStorageVault(
        com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateExascaleDbStorageVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ExascaleDB Storage Vault.
     * </pre>
     */
    public com.google.longrunning.Operation deleteExascaleDbStorageVault(
        com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteExascaleDbStorageVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the DbSystemInitialStorageSizes for the given project and
     * location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse
        listDbSystemInitialStorageSizes(
            com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDbSystemInitialStorageSizesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the Databases for the given project, location and DbSystem.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDatabasesResponse listDatabases(
        com.google.cloud.oracledatabase.v1.ListDatabasesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Database.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.Database getDatabase(
        com.google.cloud.oracledatabase.v1.GetDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the PluggableDatabases for the given project, location and
     * Container Database.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse listPluggableDatabases(
        com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListPluggableDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PluggableDatabase.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.PluggableDatabase getPluggableDatabase(
        com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetPluggableDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the DbSystems for the given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDbSystemsResponse listDbSystems(
        com.google.cloud.oracledatabase.v1.ListDbSystemsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDbSystemsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DbSystem.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.DbSystem getDbSystem(
        com.google.cloud.oracledatabase.v1.GetDbSystemRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDbSystemMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DbSystem in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createDbSystem(
        com.google.cloud.oracledatabase.v1.CreateDbSystemRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateDbSystemMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DbSystem.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDbSystem(
        com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteDbSystemMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List DbVersions for the given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDbVersionsResponse listDbVersions(
        com.google.cloud.oracledatabase.v1.ListDbVersionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDbVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List DatabaseCharacterSets for the given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse
        listDatabaseCharacterSets(
            com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDatabaseCharacterSetsMethod(), getCallOptions(), request);
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
     * Lists all the valid minor versions for the given
     * project, location, gi version and shape family.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse listMinorVersions(
        com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMinorVersionsMethod(), getCallOptions(), request);
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
     * Updates the parameters of a single Autonomous Database.
     * </pre>
     */
    public com.google.longrunning.Operation updateAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAutonomousDatabaseMethod(), getCallOptions(), request);
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

    /**
     *
     *
     * <pre>
     * Initiates a switchover of specified autonomous database to the associated
     * peer database.
     * </pre>
     */
    public com.google.longrunning.Operation switchoverAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSwitchoverAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a failover to target autonomous database from the associated
     * primary database.
     * </pre>
     */
    public com.google.longrunning.Operation failoverAutonomousDatabase(
        com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFailoverAutonomousDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the ODB Networks in a given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse listOdbNetworks(
        com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOdbNetworksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ODB Network.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.OdbNetwork getOdbNetwork(
        com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOdbNetworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ODB Network in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createOdbNetwork(
        com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOdbNetworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ODB Network.
     * </pre>
     */
    public com.google.longrunning.Operation deleteOdbNetwork(
        com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteOdbNetworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the ODB Subnets in a given ODB Network.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse listOdbSubnets(
        com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOdbSubnetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ODB Subnet.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.OdbSubnet getOdbSubnet(
        com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOdbSubnetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ODB Subnet in a given ODB Network.
     * </pre>
     */
    public com.google.longrunning.Operation createOdbSubnet(
        com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOdbSubnetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ODB Subnet.
     * </pre>
     */
    public com.google.longrunning.Operation deleteOdbSubnet(
        com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteOdbSubnetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the Exadb (Exascale) VM Clusters for the given project and
     * location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse listExadbVmClusters(
        com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExadbVmClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Exadb (Exascale) VM Cluster.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ExadbVmCluster getExadbVmCluster(
        com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExadbVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Exadb (Exascale) VM Cluster resource.
     * </pre>
     */
    public com.google.longrunning.Operation createExadbVmCluster(
        com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExadbVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Exadb (Exascale) VM Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteExadbVmCluster(
        com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExadbVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Exadb (Exascale) VM Cluster. To add virtual machines to
     * existing exadb vm cluster, only pass the node count.
     * </pre>
     */
    public com.google.longrunning.Operation updateExadbVmCluster(
        com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExadbVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes virtual machines from an existing exadb vm cluster.
     * </pre>
     */
    public com.google.longrunning.Operation removeVirtualMachineExadbVmCluster(
        com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveVirtualMachineExadbVmClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the ExascaleDB Storage Vaults for the given project and
     * location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse
        listExascaleDbStorageVaults(
            com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExascaleDbStorageVaultsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ExascaleDB Storage Vault.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault getExascaleDbStorageVault(
        com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExascaleDbStorageVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ExascaleDB Storage Vault resource.
     * </pre>
     */
    public com.google.longrunning.Operation createExascaleDbStorageVault(
        com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExascaleDbStorageVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ExascaleDB Storage Vault.
     * </pre>
     */
    public com.google.longrunning.Operation deleteExascaleDbStorageVault(
        com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExascaleDbStorageVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the DbSystemInitialStorageSizes for the given project and
     * location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse
        listDbSystemInitialStorageSizes(
            com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDbSystemInitialStorageSizesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the Databases for the given project, location and DbSystem.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDatabasesResponse listDatabases(
        com.google.cloud.oracledatabase.v1.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Database.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.Database getDatabase(
        com.google.cloud.oracledatabase.v1.GetDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the PluggableDatabases for the given project, location and
     * Container Database.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse listPluggableDatabases(
        com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPluggableDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PluggableDatabase.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.PluggableDatabase getPluggableDatabase(
        com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPluggableDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the DbSystems for the given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDbSystemsResponse listDbSystems(
        com.google.cloud.oracledatabase.v1.ListDbSystemsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDbSystemsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DbSystem.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.DbSystem getDbSystem(
        com.google.cloud.oracledatabase.v1.GetDbSystemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDbSystemMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DbSystem in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createDbSystem(
        com.google.cloud.oracledatabase.v1.CreateDbSystemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDbSystemMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DbSystem.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDbSystem(
        com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDbSystemMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List DbVersions for the given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDbVersionsResponse listDbVersions(
        com.google.cloud.oracledatabase.v1.ListDbVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDbVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List DatabaseCharacterSets for the given project and location.
     * </pre>
     */
    public com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse
        listDatabaseCharacterSets(
            com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatabaseCharacterSetsMethod(), getCallOptions(), request);
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
     * Lists all the valid minor versions for the given
     * project, location, gi version and shape family.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse>
        listMinorVersions(com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMinorVersionsMethod(), getCallOptions()), request);
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
     * Updates the parameters of a single Autonomous Database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateAutonomousDatabase(
            com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAutonomousDatabaseMethod(), getCallOptions()), request);
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

    /**
     *
     *
     * <pre>
     * Initiates a switchover of specified autonomous database to the associated
     * peer database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        switchoverAutonomousDatabase(
            com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSwitchoverAutonomousDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a failover to target autonomous database from the associated
     * primary database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        failoverAutonomousDatabase(
            com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFailoverAutonomousDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the ODB Networks in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse>
        listOdbNetworks(com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOdbNetworksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ODB Network.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.OdbNetwork>
        getOdbNetwork(com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOdbNetworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ODB Network in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createOdbNetwork(com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOdbNetworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ODB Network.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteOdbNetwork(com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteOdbNetworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the ODB Subnets in a given ODB Network.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse>
        listOdbSubnets(com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOdbSubnetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ODB Subnet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.OdbSubnet>
        getOdbSubnet(com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOdbSubnetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ODB Subnet in a given ODB Network.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createOdbSubnet(com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOdbSubnetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ODB Subnet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteOdbSubnet(com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteOdbSubnetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the Exadb (Exascale) VM Clusters for the given project and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse>
        listExadbVmClusters(com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExadbVmClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Exadb (Exascale) VM Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ExadbVmCluster>
        getExadbVmCluster(com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExadbVmClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Exadb (Exascale) VM Cluster resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createExadbVmCluster(
            com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExadbVmClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Exadb (Exascale) VM Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteExadbVmCluster(
            com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExadbVmClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Exadb (Exascale) VM Cluster. To add virtual machines to
     * existing exadb vm cluster, only pass the node count.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateExadbVmCluster(
            com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExadbVmClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes virtual machines from an existing exadb vm cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        removeVirtualMachineExadbVmCluster(
            com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveVirtualMachineExadbVmClusterMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the ExascaleDB Storage Vaults for the given project and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse>
        listExascaleDbStorageVaults(
            com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExascaleDbStorageVaultsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ExascaleDB Storage Vault.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault>
        getExascaleDbStorageVault(
            com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExascaleDbStorageVaultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ExascaleDB Storage Vault resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createExascaleDbStorageVault(
            com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExascaleDbStorageVaultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ExascaleDB Storage Vault.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteExascaleDbStorageVault(
            com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExascaleDbStorageVaultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the DbSystemInitialStorageSizes for the given project and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse>
        listDbSystemInitialStorageSizes(
            com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDbSystemInitialStorageSizesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the Databases for the given project, location and DbSystem.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListDatabasesResponse>
        listDatabases(com.google.cloud.oracledatabase.v1.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatabasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.Database>
        getDatabase(com.google.cloud.oracledatabase.v1.GetDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the PluggableDatabases for the given project, location and
     * Container Database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse>
        listPluggableDatabases(
            com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPluggableDatabasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PluggableDatabase.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.PluggableDatabase>
        getPluggableDatabase(
            com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPluggableDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the DbSystems for the given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListDbSystemsResponse>
        listDbSystems(com.google.cloud.oracledatabase.v1.ListDbSystemsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDbSystemsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DbSystem.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.DbSystem>
        getDbSystem(com.google.cloud.oracledatabase.v1.GetDbSystemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDbSystemMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DbSystem in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDbSystem(com.google.cloud.oracledatabase.v1.CreateDbSystemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDbSystemMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DbSystem.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDbSystem(com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDbSystemMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List DbVersions for the given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListDbVersionsResponse>
        listDbVersions(com.google.cloud.oracledatabase.v1.ListDbVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDbVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List DatabaseCharacterSets for the given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse>
        listDatabaseCharacterSets(
            com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatabaseCharacterSetsMethod(), getCallOptions()), request);
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
  private static final int METHODID_LIST_MINOR_VERSIONS = 12;
  private static final int METHODID_LIST_DB_SYSTEM_SHAPES = 13;
  private static final int METHODID_LIST_AUTONOMOUS_DATABASES = 14;
  private static final int METHODID_GET_AUTONOMOUS_DATABASE = 15;
  private static final int METHODID_CREATE_AUTONOMOUS_DATABASE = 16;
  private static final int METHODID_UPDATE_AUTONOMOUS_DATABASE = 17;
  private static final int METHODID_DELETE_AUTONOMOUS_DATABASE = 18;
  private static final int METHODID_RESTORE_AUTONOMOUS_DATABASE = 19;
  private static final int METHODID_GENERATE_AUTONOMOUS_DATABASE_WALLET = 20;
  private static final int METHODID_LIST_AUTONOMOUS_DB_VERSIONS = 21;
  private static final int METHODID_LIST_AUTONOMOUS_DATABASE_CHARACTER_SETS = 22;
  private static final int METHODID_LIST_AUTONOMOUS_DATABASE_BACKUPS = 23;
  private static final int METHODID_STOP_AUTONOMOUS_DATABASE = 24;
  private static final int METHODID_START_AUTONOMOUS_DATABASE = 25;
  private static final int METHODID_RESTART_AUTONOMOUS_DATABASE = 26;
  private static final int METHODID_SWITCHOVER_AUTONOMOUS_DATABASE = 27;
  private static final int METHODID_FAILOVER_AUTONOMOUS_DATABASE = 28;
  private static final int METHODID_LIST_ODB_NETWORKS = 29;
  private static final int METHODID_GET_ODB_NETWORK = 30;
  private static final int METHODID_CREATE_ODB_NETWORK = 31;
  private static final int METHODID_DELETE_ODB_NETWORK = 32;
  private static final int METHODID_LIST_ODB_SUBNETS = 33;
  private static final int METHODID_GET_ODB_SUBNET = 34;
  private static final int METHODID_CREATE_ODB_SUBNET = 35;
  private static final int METHODID_DELETE_ODB_SUBNET = 36;
  private static final int METHODID_LIST_EXADB_VM_CLUSTERS = 37;
  private static final int METHODID_GET_EXADB_VM_CLUSTER = 38;
  private static final int METHODID_CREATE_EXADB_VM_CLUSTER = 39;
  private static final int METHODID_DELETE_EXADB_VM_CLUSTER = 40;
  private static final int METHODID_UPDATE_EXADB_VM_CLUSTER = 41;
  private static final int METHODID_REMOVE_VIRTUAL_MACHINE_EXADB_VM_CLUSTER = 42;
  private static final int METHODID_LIST_EXASCALE_DB_STORAGE_VAULTS = 43;
  private static final int METHODID_GET_EXASCALE_DB_STORAGE_VAULT = 44;
  private static final int METHODID_CREATE_EXASCALE_DB_STORAGE_VAULT = 45;
  private static final int METHODID_DELETE_EXASCALE_DB_STORAGE_VAULT = 46;
  private static final int METHODID_LIST_DB_SYSTEM_INITIAL_STORAGE_SIZES = 47;
  private static final int METHODID_LIST_DATABASES = 48;
  private static final int METHODID_GET_DATABASE = 49;
  private static final int METHODID_LIST_PLUGGABLE_DATABASES = 50;
  private static final int METHODID_GET_PLUGGABLE_DATABASE = 51;
  private static final int METHODID_LIST_DB_SYSTEMS = 52;
  private static final int METHODID_GET_DB_SYSTEM = 53;
  private static final int METHODID_CREATE_DB_SYSTEM = 54;
  private static final int METHODID_DELETE_DB_SYSTEM = 55;
  private static final int METHODID_LIST_DB_VERSIONS = 56;
  private static final int METHODID_LIST_DATABASE_CHARACTER_SETS = 57;

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
        case METHODID_LIST_MINOR_VERSIONS:
          serviceImpl.listMinorVersions(
              (com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse>)
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
        case METHODID_UPDATE_AUTONOMOUS_DATABASE:
          serviceImpl.updateAutonomousDatabase(
              (com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest) request,
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
        case METHODID_SWITCHOVER_AUTONOMOUS_DATABASE:
          serviceImpl.switchoverAutonomousDatabase(
              (com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FAILOVER_AUTONOMOUS_DATABASE:
          serviceImpl.failoverAutonomousDatabase(
              (com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ODB_NETWORKS:
          serviceImpl.listOdbNetworks(
              (com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ODB_NETWORK:
          serviceImpl.getOdbNetwork(
              (com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.OdbNetwork>)
                  responseObserver);
          break;
        case METHODID_CREATE_ODB_NETWORK:
          serviceImpl.createOdbNetwork(
              (com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ODB_NETWORK:
          serviceImpl.deleteOdbNetwork(
              (com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ODB_SUBNETS:
          serviceImpl.listOdbSubnets(
              (com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ODB_SUBNET:
          serviceImpl.getOdbSubnet(
              (com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.OdbSubnet>)
                  responseObserver);
          break;
        case METHODID_CREATE_ODB_SUBNET:
          serviceImpl.createOdbSubnet(
              (com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ODB_SUBNET:
          serviceImpl.deleteOdbSubnet(
              (com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_EXADB_VM_CLUSTERS:
          serviceImpl.listExadbVmClusters(
              (com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EXADB_VM_CLUSTER:
          serviceImpl.getExadbVmCluster(
              (com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.ExadbVmCluster>)
                  responseObserver);
          break;
        case METHODID_CREATE_EXADB_VM_CLUSTER:
          serviceImpl.createExadbVmCluster(
              (com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_EXADB_VM_CLUSTER:
          serviceImpl.deleteExadbVmCluster(
              (com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_EXADB_VM_CLUSTER:
          serviceImpl.updateExadbVmCluster(
              (com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REMOVE_VIRTUAL_MACHINE_EXADB_VM_CLUSTER:
          serviceImpl.removeVirtualMachineExadbVmCluster(
              (com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_EXASCALE_DB_STORAGE_VAULTS:
          serviceImpl.listExascaleDbStorageVaults(
              (com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EXASCALE_DB_STORAGE_VAULT:
          serviceImpl.getExascaleDbStorageVault(
              (com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault>)
                  responseObserver);
          break;
        case METHODID_CREATE_EXASCALE_DB_STORAGE_VAULT:
          serviceImpl.createExascaleDbStorageVault(
              (com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_EXASCALE_DB_STORAGE_VAULT:
          serviceImpl.deleteExascaleDbStorageVault(
              (com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DB_SYSTEM_INITIAL_STORAGE_SIZES:
          serviceImpl.listDbSystemInitialStorageSizes(
              (com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_DATABASES:
          serviceImpl.listDatabases(
              (com.google.cloud.oracledatabase.v1.ListDatabasesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListDatabasesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATABASE:
          serviceImpl.getDatabase(
              (com.google.cloud.oracledatabase.v1.GetDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.Database>)
                  responseObserver);
          break;
        case METHODID_LIST_PLUGGABLE_DATABASES:
          serviceImpl.listPluggableDatabases(
              (com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PLUGGABLE_DATABASE:
          serviceImpl.getPluggableDatabase(
              (com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.PluggableDatabase>)
                  responseObserver);
          break;
        case METHODID_LIST_DB_SYSTEMS:
          serviceImpl.listDbSystems(
              (com.google.cloud.oracledatabase.v1.ListDbSystemsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListDbSystemsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DB_SYSTEM:
          serviceImpl.getDbSystem(
              (com.google.cloud.oracledatabase.v1.GetDbSystemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.oracledatabase.v1.DbSystem>)
                  responseObserver);
          break;
        case METHODID_CREATE_DB_SYSTEM:
          serviceImpl.createDbSystem(
              (com.google.cloud.oracledatabase.v1.CreateDbSystemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DB_SYSTEM:
          serviceImpl.deleteDbSystem(
              (com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DB_VERSIONS:
          serviceImpl.listDbVersions(
              (com.google.cloud.oracledatabase.v1.ListDbVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListDbVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_DATABASE_CHARACTER_SETS:
          serviceImpl.listDatabaseCharacterSets(
              (com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse>)
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
            getListMinorVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListMinorVersionsRequest,
                    com.google.cloud.oracledatabase.v1.ListMinorVersionsResponse>(
                    service, METHODID_LIST_MINOR_VERSIONS)))
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
            getUpdateAutonomousDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.UpdateAutonomousDatabaseRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_AUTONOMOUS_DATABASE)))
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
        .addMethod(
            getSwitchoverAutonomousDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.SwitchoverAutonomousDatabaseRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_SWITCHOVER_AUTONOMOUS_DATABASE)))
        .addMethod(
            getFailoverAutonomousDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.FailoverAutonomousDatabaseRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_FAILOVER_AUTONOMOUS_DATABASE)))
        .addMethod(
            getListOdbNetworksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListOdbNetworksRequest,
                    com.google.cloud.oracledatabase.v1.ListOdbNetworksResponse>(
                    service, METHODID_LIST_ODB_NETWORKS)))
        .addMethod(
            getGetOdbNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.GetOdbNetworkRequest,
                    com.google.cloud.oracledatabase.v1.OdbNetwork>(
                    service, METHODID_GET_ODB_NETWORK)))
        .addMethod(
            getCreateOdbNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ODB_NETWORK)))
        .addMethod(
            getDeleteOdbNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.DeleteOdbNetworkRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ODB_NETWORK)))
        .addMethod(
            getListOdbSubnetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListOdbSubnetsRequest,
                    com.google.cloud.oracledatabase.v1.ListOdbSubnetsResponse>(
                    service, METHODID_LIST_ODB_SUBNETS)))
        .addMethod(
            getGetOdbSubnetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.GetOdbSubnetRequest,
                    com.google.cloud.oracledatabase.v1.OdbSubnet>(
                    service, METHODID_GET_ODB_SUBNET)))
        .addMethod(
            getCreateOdbSubnetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.CreateOdbSubnetRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ODB_SUBNET)))
        .addMethod(
            getDeleteOdbSubnetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.DeleteOdbSubnetRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ODB_SUBNET)))
        .addMethod(
            getListExadbVmClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListExadbVmClustersRequest,
                    com.google.cloud.oracledatabase.v1.ListExadbVmClustersResponse>(
                    service, METHODID_LIST_EXADB_VM_CLUSTERS)))
        .addMethod(
            getGetExadbVmClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.GetExadbVmClusterRequest,
                    com.google.cloud.oracledatabase.v1.ExadbVmCluster>(
                    service, METHODID_GET_EXADB_VM_CLUSTER)))
        .addMethod(
            getCreateExadbVmClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.CreateExadbVmClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_EXADB_VM_CLUSTER)))
        .addMethod(
            getDeleteExadbVmClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.DeleteExadbVmClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_EXADB_VM_CLUSTER)))
        .addMethod(
            getUpdateExadbVmClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.UpdateExadbVmClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_EXADB_VM_CLUSTER)))
        .addMethod(
            getRemoveVirtualMachineExadbVmClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.RemoveVirtualMachineExadbVmClusterRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_REMOVE_VIRTUAL_MACHINE_EXADB_VM_CLUSTER)))
        .addMethod(
            getListExascaleDbStorageVaultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsRequest,
                    com.google.cloud.oracledatabase.v1.ListExascaleDbStorageVaultsResponse>(
                    service, METHODID_LIST_EXASCALE_DB_STORAGE_VAULTS)))
        .addMethod(
            getGetExascaleDbStorageVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.GetExascaleDbStorageVaultRequest,
                    com.google.cloud.oracledatabase.v1.ExascaleDbStorageVault>(
                    service, METHODID_GET_EXASCALE_DB_STORAGE_VAULT)))
        .addMethod(
            getCreateExascaleDbStorageVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.CreateExascaleDbStorageVaultRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_EXASCALE_DB_STORAGE_VAULT)))
        .addMethod(
            getDeleteExascaleDbStorageVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.DeleteExascaleDbStorageVaultRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_EXASCALE_DB_STORAGE_VAULT)))
        .addMethod(
            getListDbSystemInitialStorageSizesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesRequest,
                    com.google.cloud.oracledatabase.v1.ListDbSystemInitialStorageSizesResponse>(
                    service, METHODID_LIST_DB_SYSTEM_INITIAL_STORAGE_SIZES)))
        .addMethod(
            getListDatabasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListDatabasesRequest,
                    com.google.cloud.oracledatabase.v1.ListDatabasesResponse>(
                    service, METHODID_LIST_DATABASES)))
        .addMethod(
            getGetDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.GetDatabaseRequest,
                    com.google.cloud.oracledatabase.v1.Database>(service, METHODID_GET_DATABASE)))
        .addMethod(
            getListPluggableDatabasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListPluggableDatabasesRequest,
                    com.google.cloud.oracledatabase.v1.ListPluggableDatabasesResponse>(
                    service, METHODID_LIST_PLUGGABLE_DATABASES)))
        .addMethod(
            getGetPluggableDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.GetPluggableDatabaseRequest,
                    com.google.cloud.oracledatabase.v1.PluggableDatabase>(
                    service, METHODID_GET_PLUGGABLE_DATABASE)))
        .addMethod(
            getListDbSystemsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListDbSystemsRequest,
                    com.google.cloud.oracledatabase.v1.ListDbSystemsResponse>(
                    service, METHODID_LIST_DB_SYSTEMS)))
        .addMethod(
            getGetDbSystemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.GetDbSystemRequest,
                    com.google.cloud.oracledatabase.v1.DbSystem>(service, METHODID_GET_DB_SYSTEM)))
        .addMethod(
            getCreateDbSystemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.CreateDbSystemRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DB_SYSTEM)))
        .addMethod(
            getDeleteDbSystemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DB_SYSTEM)))
        .addMethod(
            getListDbVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListDbVersionsRequest,
                    com.google.cloud.oracledatabase.v1.ListDbVersionsResponse>(
                    service, METHODID_LIST_DB_VERSIONS)))
        .addMethod(
            getListDatabaseCharacterSetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsRequest,
                    com.google.cloud.oracledatabase.v1.ListDatabaseCharacterSetsResponse>(
                    service, METHODID_LIST_DATABASE_CHARACTER_SETS)))
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
                      .addMethod(getListMinorVersionsMethod())
                      .addMethod(getListDbSystemShapesMethod())
                      .addMethod(getListAutonomousDatabasesMethod())
                      .addMethod(getGetAutonomousDatabaseMethod())
                      .addMethod(getCreateAutonomousDatabaseMethod())
                      .addMethod(getUpdateAutonomousDatabaseMethod())
                      .addMethod(getDeleteAutonomousDatabaseMethod())
                      .addMethod(getRestoreAutonomousDatabaseMethod())
                      .addMethod(getGenerateAutonomousDatabaseWalletMethod())
                      .addMethod(getListAutonomousDbVersionsMethod())
                      .addMethod(getListAutonomousDatabaseCharacterSetsMethod())
                      .addMethod(getListAutonomousDatabaseBackupsMethod())
                      .addMethod(getStopAutonomousDatabaseMethod())
                      .addMethod(getStartAutonomousDatabaseMethod())
                      .addMethod(getRestartAutonomousDatabaseMethod())
                      .addMethod(getSwitchoverAutonomousDatabaseMethod())
                      .addMethod(getFailoverAutonomousDatabaseMethod())
                      .addMethod(getListOdbNetworksMethod())
                      .addMethod(getGetOdbNetworkMethod())
                      .addMethod(getCreateOdbNetworkMethod())
                      .addMethod(getDeleteOdbNetworkMethod())
                      .addMethod(getListOdbSubnetsMethod())
                      .addMethod(getGetOdbSubnetMethod())
                      .addMethod(getCreateOdbSubnetMethod())
                      .addMethod(getDeleteOdbSubnetMethod())
                      .addMethod(getListExadbVmClustersMethod())
                      .addMethod(getGetExadbVmClusterMethod())
                      .addMethod(getCreateExadbVmClusterMethod())
                      .addMethod(getDeleteExadbVmClusterMethod())
                      .addMethod(getUpdateExadbVmClusterMethod())
                      .addMethod(getRemoveVirtualMachineExadbVmClusterMethod())
                      .addMethod(getListExascaleDbStorageVaultsMethod())
                      .addMethod(getGetExascaleDbStorageVaultMethod())
                      .addMethod(getCreateExascaleDbStorageVaultMethod())
                      .addMethod(getDeleteExascaleDbStorageVaultMethod())
                      .addMethod(getListDbSystemInitialStorageSizesMethod())
                      .addMethod(getListDatabasesMethod())
                      .addMethod(getGetDatabaseMethod())
                      .addMethod(getListPluggableDatabasesMethod())
                      .addMethod(getGetPluggableDatabaseMethod())
                      .addMethod(getListDbSystemsMethod())
                      .addMethod(getGetDbSystemMethod())
                      .addMethod(getCreateDbSystemMethod())
                      .addMethod(getDeleteDbSystemMethod())
                      .addMethod(getListDbVersionsMethod())
                      .addMethod(getListDatabaseCharacterSetsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
