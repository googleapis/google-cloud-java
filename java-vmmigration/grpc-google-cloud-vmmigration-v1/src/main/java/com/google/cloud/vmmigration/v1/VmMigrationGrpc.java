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
package com.google.cloud.vmmigration.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * VM Migration Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/vmmigration/v1/vmmigration.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VmMigrationGrpc {

  private VmMigrationGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.vmmigration.v1.VmMigration";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListSourcesRequest,
          com.google.cloud.vmmigration.v1.ListSourcesResponse>
      getListSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSources",
      requestType = com.google.cloud.vmmigration.v1.ListSourcesRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ListSourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListSourcesRequest,
          com.google.cloud.vmmigration.v1.ListSourcesResponse>
      getListSourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ListSourcesRequest,
            com.google.cloud.vmmigration.v1.ListSourcesResponse>
        getListSourcesMethod;
    if ((getListSourcesMethod = VmMigrationGrpc.getListSourcesMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getListSourcesMethod = VmMigrationGrpc.getListSourcesMethod) == null) {
          VmMigrationGrpc.getListSourcesMethod =
              getListSourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ListSourcesRequest,
                          com.google.cloud.vmmigration.v1.ListSourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListSourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListSourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new VmMigrationMethodDescriptorSupplier("ListSources"))
                      .build();
        }
      }
    }
    return getListSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetSourceRequest, com.google.cloud.vmmigration.v1.Source>
      getGetSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSource",
      requestType = com.google.cloud.vmmigration.v1.GetSourceRequest.class,
      responseType = com.google.cloud.vmmigration.v1.Source.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetSourceRequest, com.google.cloud.vmmigration.v1.Source>
      getGetSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.GetSourceRequest,
            com.google.cloud.vmmigration.v1.Source>
        getGetSourceMethod;
    if ((getGetSourceMethod = VmMigrationGrpc.getGetSourceMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getGetSourceMethod = VmMigrationGrpc.getGetSourceMethod) == null) {
          VmMigrationGrpc.getGetSourceMethod =
              getGetSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.GetSourceRequest,
                          com.google.cloud.vmmigration.v1.Source>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.GetSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.Source.getDefaultInstance()))
                      .setSchemaDescriptor(new VmMigrationMethodDescriptorSupplier("GetSource"))
                      .build();
        }
      }
    }
    return getGetSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateSourceRequest, com.google.longrunning.Operation>
      getCreateSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSource",
      requestType = com.google.cloud.vmmigration.v1.CreateSourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateSourceRequest, com.google.longrunning.Operation>
      getCreateSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CreateSourceRequest, com.google.longrunning.Operation>
        getCreateSourceMethod;
    if ((getCreateSourceMethod = VmMigrationGrpc.getCreateSourceMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCreateSourceMethod = VmMigrationGrpc.getCreateSourceMethod) == null) {
          VmMigrationGrpc.getCreateSourceMethod =
              getCreateSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CreateSourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CreateSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new VmMigrationMethodDescriptorSupplier("CreateSource"))
                      .build();
        }
      }
    }
    return getCreateSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.UpdateSourceRequest, com.google.longrunning.Operation>
      getUpdateSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSource",
      requestType = com.google.cloud.vmmigration.v1.UpdateSourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.UpdateSourceRequest, com.google.longrunning.Operation>
      getUpdateSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.UpdateSourceRequest, com.google.longrunning.Operation>
        getUpdateSourceMethod;
    if ((getUpdateSourceMethod = VmMigrationGrpc.getUpdateSourceMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getUpdateSourceMethod = VmMigrationGrpc.getUpdateSourceMethod) == null) {
          VmMigrationGrpc.getUpdateSourceMethod =
              getUpdateSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.UpdateSourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.UpdateSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new VmMigrationMethodDescriptorSupplier("UpdateSource"))
                      .build();
        }
      }
    }
    return getUpdateSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteSourceRequest, com.google.longrunning.Operation>
      getDeleteSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSource",
      requestType = com.google.cloud.vmmigration.v1.DeleteSourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteSourceRequest, com.google.longrunning.Operation>
      getDeleteSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.DeleteSourceRequest, com.google.longrunning.Operation>
        getDeleteSourceMethod;
    if ((getDeleteSourceMethod = VmMigrationGrpc.getDeleteSourceMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getDeleteSourceMethod = VmMigrationGrpc.getDeleteSourceMethod) == null) {
          VmMigrationGrpc.getDeleteSourceMethod =
              getDeleteSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.DeleteSourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.DeleteSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new VmMigrationMethodDescriptorSupplier("DeleteSource"))
                      .build();
        }
      }
    }
    return getDeleteSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.FetchInventoryRequest,
          com.google.cloud.vmmigration.v1.FetchInventoryResponse>
      getFetchInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchInventory",
      requestType = com.google.cloud.vmmigration.v1.FetchInventoryRequest.class,
      responseType = com.google.cloud.vmmigration.v1.FetchInventoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.FetchInventoryRequest,
          com.google.cloud.vmmigration.v1.FetchInventoryResponse>
      getFetchInventoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.FetchInventoryRequest,
            com.google.cloud.vmmigration.v1.FetchInventoryResponse>
        getFetchInventoryMethod;
    if ((getFetchInventoryMethod = VmMigrationGrpc.getFetchInventoryMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getFetchInventoryMethod = VmMigrationGrpc.getFetchInventoryMethod) == null) {
          VmMigrationGrpc.getFetchInventoryMethod =
              getFetchInventoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.FetchInventoryRequest,
                          com.google.cloud.vmmigration.v1.FetchInventoryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchInventory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.FetchInventoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.FetchInventoryResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("FetchInventory"))
                      .build();
        }
      }
    }
    return getFetchInventoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest,
          com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse>
      getFetchStorageInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchStorageInventory",
      requestType = com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest.class,
      responseType = com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest,
          com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse>
      getFetchStorageInventoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest,
            com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse>
        getFetchStorageInventoryMethod;
    if ((getFetchStorageInventoryMethod = VmMigrationGrpc.getFetchStorageInventoryMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getFetchStorageInventoryMethod = VmMigrationGrpc.getFetchStorageInventoryMethod)
            == null) {
          VmMigrationGrpc.getFetchStorageInventoryMethod =
              getFetchStorageInventoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest,
                          com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchStorageInventory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("FetchStorageInventory"))
                      .build();
        }
      }
    }
    return getFetchStorageInventoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest,
          com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse>
      getListUtilizationReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUtilizationReports",
      requestType = com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest,
          com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse>
      getListUtilizationReportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest,
            com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse>
        getListUtilizationReportsMethod;
    if ((getListUtilizationReportsMethod = VmMigrationGrpc.getListUtilizationReportsMethod)
        == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getListUtilizationReportsMethod = VmMigrationGrpc.getListUtilizationReportsMethod)
            == null) {
          VmMigrationGrpc.getListUtilizationReportsMethod =
              getListUtilizationReportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest,
                          com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListUtilizationReports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("ListUtilizationReports"))
                      .build();
        }
      }
    }
    return getListUtilizationReportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetUtilizationReportRequest,
          com.google.cloud.vmmigration.v1.UtilizationReport>
      getGetUtilizationReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUtilizationReport",
      requestType = com.google.cloud.vmmigration.v1.GetUtilizationReportRequest.class,
      responseType = com.google.cloud.vmmigration.v1.UtilizationReport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetUtilizationReportRequest,
          com.google.cloud.vmmigration.v1.UtilizationReport>
      getGetUtilizationReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.GetUtilizationReportRequest,
            com.google.cloud.vmmigration.v1.UtilizationReport>
        getGetUtilizationReportMethod;
    if ((getGetUtilizationReportMethod = VmMigrationGrpc.getGetUtilizationReportMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getGetUtilizationReportMethod = VmMigrationGrpc.getGetUtilizationReportMethod)
            == null) {
          VmMigrationGrpc.getGetUtilizationReportMethod =
              getGetUtilizationReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.GetUtilizationReportRequest,
                          com.google.cloud.vmmigration.v1.UtilizationReport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetUtilizationReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.GetUtilizationReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.UtilizationReport
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("GetUtilizationReport"))
                      .build();
        }
      }
    }
    return getGetUtilizationReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest,
          com.google.longrunning.Operation>
      getCreateUtilizationReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUtilizationReport",
      requestType = com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest,
          com.google.longrunning.Operation>
      getCreateUtilizationReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest,
            com.google.longrunning.Operation>
        getCreateUtilizationReportMethod;
    if ((getCreateUtilizationReportMethod = VmMigrationGrpc.getCreateUtilizationReportMethod)
        == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCreateUtilizationReportMethod = VmMigrationGrpc.getCreateUtilizationReportMethod)
            == null) {
          VmMigrationGrpc.getCreateUtilizationReportMethod =
              getCreateUtilizationReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateUtilizationReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("CreateUtilizationReport"))
                      .build();
        }
      }
    }
    return getCreateUtilizationReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest,
          com.google.longrunning.Operation>
      getDeleteUtilizationReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUtilizationReport",
      requestType = com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest,
          com.google.longrunning.Operation>
      getDeleteUtilizationReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest,
            com.google.longrunning.Operation>
        getDeleteUtilizationReportMethod;
    if ((getDeleteUtilizationReportMethod = VmMigrationGrpc.getDeleteUtilizationReportMethod)
        == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getDeleteUtilizationReportMethod = VmMigrationGrpc.getDeleteUtilizationReportMethod)
            == null) {
          VmMigrationGrpc.getDeleteUtilizationReportMethod =
              getDeleteUtilizationReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteUtilizationReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("DeleteUtilizationReport"))
                      .build();
        }
      }
    }
    return getDeleteUtilizationReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest,
          com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse>
      getListDatacenterConnectorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatacenterConnectors",
      requestType = com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest,
          com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse>
      getListDatacenterConnectorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest,
            com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse>
        getListDatacenterConnectorsMethod;
    if ((getListDatacenterConnectorsMethod = VmMigrationGrpc.getListDatacenterConnectorsMethod)
        == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getListDatacenterConnectorsMethod = VmMigrationGrpc.getListDatacenterConnectorsMethod)
            == null) {
          VmMigrationGrpc.getListDatacenterConnectorsMethod =
              getListDatacenterConnectorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest,
                          com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDatacenterConnectors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("ListDatacenterConnectors"))
                      .build();
        }
      }
    }
    return getListDatacenterConnectorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest,
          com.google.cloud.vmmigration.v1.DatacenterConnector>
      getGetDatacenterConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDatacenterConnector",
      requestType = com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest.class,
      responseType = com.google.cloud.vmmigration.v1.DatacenterConnector.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest,
          com.google.cloud.vmmigration.v1.DatacenterConnector>
      getGetDatacenterConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest,
            com.google.cloud.vmmigration.v1.DatacenterConnector>
        getGetDatacenterConnectorMethod;
    if ((getGetDatacenterConnectorMethod = VmMigrationGrpc.getGetDatacenterConnectorMethod)
        == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getGetDatacenterConnectorMethod = VmMigrationGrpc.getGetDatacenterConnectorMethod)
            == null) {
          VmMigrationGrpc.getGetDatacenterConnectorMethod =
              getGetDatacenterConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest,
                          com.google.cloud.vmmigration.v1.DatacenterConnector>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDatacenterConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.DatacenterConnector
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("GetDatacenterConnector"))
                      .build();
        }
      }
    }
    return getGetDatacenterConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest,
          com.google.longrunning.Operation>
      getCreateDatacenterConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDatacenterConnector",
      requestType = com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest,
          com.google.longrunning.Operation>
      getCreateDatacenterConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest,
            com.google.longrunning.Operation>
        getCreateDatacenterConnectorMethod;
    if ((getCreateDatacenterConnectorMethod = VmMigrationGrpc.getCreateDatacenterConnectorMethod)
        == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCreateDatacenterConnectorMethod =
                VmMigrationGrpc.getCreateDatacenterConnectorMethod)
            == null) {
          VmMigrationGrpc.getCreateDatacenterConnectorMethod =
              getCreateDatacenterConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDatacenterConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("CreateDatacenterConnector"))
                      .build();
        }
      }
    }
    return getCreateDatacenterConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest,
          com.google.longrunning.Operation>
      getDeleteDatacenterConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDatacenterConnector",
      requestType = com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest,
          com.google.longrunning.Operation>
      getDeleteDatacenterConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest,
            com.google.longrunning.Operation>
        getDeleteDatacenterConnectorMethod;
    if ((getDeleteDatacenterConnectorMethod = VmMigrationGrpc.getDeleteDatacenterConnectorMethod)
        == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getDeleteDatacenterConnectorMethod =
                VmMigrationGrpc.getDeleteDatacenterConnectorMethod)
            == null) {
          VmMigrationGrpc.getDeleteDatacenterConnectorMethod =
              getDeleteDatacenterConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDatacenterConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("DeleteDatacenterConnector"))
                      .build();
        }
      }
    }
    return getDeleteDatacenterConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.UpgradeApplianceRequest, com.google.longrunning.Operation>
      getUpgradeApplianceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpgradeAppliance",
      requestType = com.google.cloud.vmmigration.v1.UpgradeApplianceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.UpgradeApplianceRequest, com.google.longrunning.Operation>
      getUpgradeApplianceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.UpgradeApplianceRequest,
            com.google.longrunning.Operation>
        getUpgradeApplianceMethod;
    if ((getUpgradeApplianceMethod = VmMigrationGrpc.getUpgradeApplianceMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getUpgradeApplianceMethod = VmMigrationGrpc.getUpgradeApplianceMethod) == null) {
          VmMigrationGrpc.getUpgradeApplianceMethod =
              getUpgradeApplianceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.UpgradeApplianceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpgradeAppliance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.UpgradeApplianceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("UpgradeAppliance"))
                      .build();
        }
      }
    }
    return getUpgradeApplianceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateMigratingVmRequest,
          com.google.longrunning.Operation>
      getCreateMigratingVmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMigratingVm",
      requestType = com.google.cloud.vmmigration.v1.CreateMigratingVmRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateMigratingVmRequest,
          com.google.longrunning.Operation>
      getCreateMigratingVmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CreateMigratingVmRequest,
            com.google.longrunning.Operation>
        getCreateMigratingVmMethod;
    if ((getCreateMigratingVmMethod = VmMigrationGrpc.getCreateMigratingVmMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCreateMigratingVmMethod = VmMigrationGrpc.getCreateMigratingVmMethod) == null) {
          VmMigrationGrpc.getCreateMigratingVmMethod =
              getCreateMigratingVmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CreateMigratingVmRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMigratingVm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CreateMigratingVmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("CreateMigratingVm"))
                      .build();
        }
      }
    }
    return getCreateMigratingVmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListMigratingVmsRequest,
          com.google.cloud.vmmigration.v1.ListMigratingVmsResponse>
      getListMigratingVmsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMigratingVms",
      requestType = com.google.cloud.vmmigration.v1.ListMigratingVmsRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ListMigratingVmsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListMigratingVmsRequest,
          com.google.cloud.vmmigration.v1.ListMigratingVmsResponse>
      getListMigratingVmsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ListMigratingVmsRequest,
            com.google.cloud.vmmigration.v1.ListMigratingVmsResponse>
        getListMigratingVmsMethod;
    if ((getListMigratingVmsMethod = VmMigrationGrpc.getListMigratingVmsMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getListMigratingVmsMethod = VmMigrationGrpc.getListMigratingVmsMethod) == null) {
          VmMigrationGrpc.getListMigratingVmsMethod =
              getListMigratingVmsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ListMigratingVmsRequest,
                          com.google.cloud.vmmigration.v1.ListMigratingVmsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMigratingVms"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListMigratingVmsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListMigratingVmsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("ListMigratingVms"))
                      .build();
        }
      }
    }
    return getListMigratingVmsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetMigratingVmRequest,
          com.google.cloud.vmmigration.v1.MigratingVm>
      getGetMigratingVmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMigratingVm",
      requestType = com.google.cloud.vmmigration.v1.GetMigratingVmRequest.class,
      responseType = com.google.cloud.vmmigration.v1.MigratingVm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetMigratingVmRequest,
          com.google.cloud.vmmigration.v1.MigratingVm>
      getGetMigratingVmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.GetMigratingVmRequest,
            com.google.cloud.vmmigration.v1.MigratingVm>
        getGetMigratingVmMethod;
    if ((getGetMigratingVmMethod = VmMigrationGrpc.getGetMigratingVmMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getGetMigratingVmMethod = VmMigrationGrpc.getGetMigratingVmMethod) == null) {
          VmMigrationGrpc.getGetMigratingVmMethod =
              getGetMigratingVmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.GetMigratingVmRequest,
                          com.google.cloud.vmmigration.v1.MigratingVm>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMigratingVm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.GetMigratingVmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.MigratingVm.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("GetMigratingVm"))
                      .build();
        }
      }
    }
    return getGetMigratingVmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest,
          com.google.longrunning.Operation>
      getUpdateMigratingVmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMigratingVm",
      requestType = com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest,
          com.google.longrunning.Operation>
      getUpdateMigratingVmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest,
            com.google.longrunning.Operation>
        getUpdateMigratingVmMethod;
    if ((getUpdateMigratingVmMethod = VmMigrationGrpc.getUpdateMigratingVmMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getUpdateMigratingVmMethod = VmMigrationGrpc.getUpdateMigratingVmMethod) == null) {
          VmMigrationGrpc.getUpdateMigratingVmMethod =
              getUpdateMigratingVmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMigratingVm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("UpdateMigratingVm"))
                      .build();
        }
      }
    }
    return getUpdateMigratingVmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest,
          com.google.longrunning.Operation>
      getDeleteMigratingVmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMigratingVm",
      requestType = com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest,
          com.google.longrunning.Operation>
      getDeleteMigratingVmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest,
            com.google.longrunning.Operation>
        getDeleteMigratingVmMethod;
    if ((getDeleteMigratingVmMethod = VmMigrationGrpc.getDeleteMigratingVmMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getDeleteMigratingVmMethod = VmMigrationGrpc.getDeleteMigratingVmMethod) == null) {
          VmMigrationGrpc.getDeleteMigratingVmMethod =
              getDeleteMigratingVmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMigratingVm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("DeleteMigratingVm"))
                      .build();
        }
      }
    }
    return getDeleteMigratingVmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.StartMigrationRequest, com.google.longrunning.Operation>
      getStartMigrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartMigration",
      requestType = com.google.cloud.vmmigration.v1.StartMigrationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.StartMigrationRequest, com.google.longrunning.Operation>
      getStartMigrationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.StartMigrationRequest, com.google.longrunning.Operation>
        getStartMigrationMethod;
    if ((getStartMigrationMethod = VmMigrationGrpc.getStartMigrationMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getStartMigrationMethod = VmMigrationGrpc.getStartMigrationMethod) == null) {
          VmMigrationGrpc.getStartMigrationMethod =
              getStartMigrationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.StartMigrationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartMigration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.StartMigrationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("StartMigration"))
                      .build();
        }
      }
    }
    return getStartMigrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ResumeMigrationRequest, com.google.longrunning.Operation>
      getResumeMigrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeMigration",
      requestType = com.google.cloud.vmmigration.v1.ResumeMigrationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ResumeMigrationRequest, com.google.longrunning.Operation>
      getResumeMigrationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ResumeMigrationRequest,
            com.google.longrunning.Operation>
        getResumeMigrationMethod;
    if ((getResumeMigrationMethod = VmMigrationGrpc.getResumeMigrationMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getResumeMigrationMethod = VmMigrationGrpc.getResumeMigrationMethod) == null) {
          VmMigrationGrpc.getResumeMigrationMethod =
              getResumeMigrationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ResumeMigrationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResumeMigration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ResumeMigrationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("ResumeMigration"))
                      .build();
        }
      }
    }
    return getResumeMigrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.PauseMigrationRequest, com.google.longrunning.Operation>
      getPauseMigrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PauseMigration",
      requestType = com.google.cloud.vmmigration.v1.PauseMigrationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.PauseMigrationRequest, com.google.longrunning.Operation>
      getPauseMigrationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.PauseMigrationRequest, com.google.longrunning.Operation>
        getPauseMigrationMethod;
    if ((getPauseMigrationMethod = VmMigrationGrpc.getPauseMigrationMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getPauseMigrationMethod = VmMigrationGrpc.getPauseMigrationMethod) == null) {
          VmMigrationGrpc.getPauseMigrationMethod =
              getPauseMigrationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.PauseMigrationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PauseMigration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.PauseMigrationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("PauseMigration"))
                      .build();
        }
      }
    }
    return getPauseMigrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.FinalizeMigrationRequest,
          com.google.longrunning.Operation>
      getFinalizeMigrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FinalizeMigration",
      requestType = com.google.cloud.vmmigration.v1.FinalizeMigrationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.FinalizeMigrationRequest,
          com.google.longrunning.Operation>
      getFinalizeMigrationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.FinalizeMigrationRequest,
            com.google.longrunning.Operation>
        getFinalizeMigrationMethod;
    if ((getFinalizeMigrationMethod = VmMigrationGrpc.getFinalizeMigrationMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getFinalizeMigrationMethod = VmMigrationGrpc.getFinalizeMigrationMethod) == null) {
          VmMigrationGrpc.getFinalizeMigrationMethod =
              getFinalizeMigrationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.FinalizeMigrationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FinalizeMigration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.FinalizeMigrationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("FinalizeMigration"))
                      .build();
        }
      }
    }
    return getFinalizeMigrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ExtendMigrationRequest, com.google.longrunning.Operation>
      getExtendMigrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExtendMigration",
      requestType = com.google.cloud.vmmigration.v1.ExtendMigrationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ExtendMigrationRequest, com.google.longrunning.Operation>
      getExtendMigrationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ExtendMigrationRequest,
            com.google.longrunning.Operation>
        getExtendMigrationMethod;
    if ((getExtendMigrationMethod = VmMigrationGrpc.getExtendMigrationMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getExtendMigrationMethod = VmMigrationGrpc.getExtendMigrationMethod) == null) {
          VmMigrationGrpc.getExtendMigrationMethod =
              getExtendMigrationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ExtendMigrationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExtendMigration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ExtendMigrationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("ExtendMigration"))
                      .build();
        }
      }
    }
    return getExtendMigrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateCloneJobRequest, com.google.longrunning.Operation>
      getCreateCloneJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCloneJob",
      requestType = com.google.cloud.vmmigration.v1.CreateCloneJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateCloneJobRequest, com.google.longrunning.Operation>
      getCreateCloneJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CreateCloneJobRequest, com.google.longrunning.Operation>
        getCreateCloneJobMethod;
    if ((getCreateCloneJobMethod = VmMigrationGrpc.getCreateCloneJobMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCreateCloneJobMethod = VmMigrationGrpc.getCreateCloneJobMethod) == null) {
          VmMigrationGrpc.getCreateCloneJobMethod =
              getCreateCloneJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CreateCloneJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCloneJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CreateCloneJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("CreateCloneJob"))
                      .build();
        }
      }
    }
    return getCreateCloneJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CancelCloneJobRequest, com.google.longrunning.Operation>
      getCancelCloneJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelCloneJob",
      requestType = com.google.cloud.vmmigration.v1.CancelCloneJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CancelCloneJobRequest, com.google.longrunning.Operation>
      getCancelCloneJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CancelCloneJobRequest, com.google.longrunning.Operation>
        getCancelCloneJobMethod;
    if ((getCancelCloneJobMethod = VmMigrationGrpc.getCancelCloneJobMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCancelCloneJobMethod = VmMigrationGrpc.getCancelCloneJobMethod) == null) {
          VmMigrationGrpc.getCancelCloneJobMethod =
              getCancelCloneJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CancelCloneJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelCloneJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CancelCloneJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("CancelCloneJob"))
                      .build();
        }
      }
    }
    return getCancelCloneJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListCloneJobsRequest,
          com.google.cloud.vmmigration.v1.ListCloneJobsResponse>
      getListCloneJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCloneJobs",
      requestType = com.google.cloud.vmmigration.v1.ListCloneJobsRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ListCloneJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListCloneJobsRequest,
          com.google.cloud.vmmigration.v1.ListCloneJobsResponse>
      getListCloneJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ListCloneJobsRequest,
            com.google.cloud.vmmigration.v1.ListCloneJobsResponse>
        getListCloneJobsMethod;
    if ((getListCloneJobsMethod = VmMigrationGrpc.getListCloneJobsMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getListCloneJobsMethod = VmMigrationGrpc.getListCloneJobsMethod) == null) {
          VmMigrationGrpc.getListCloneJobsMethod =
              getListCloneJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ListCloneJobsRequest,
                          com.google.cloud.vmmigration.v1.ListCloneJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCloneJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListCloneJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListCloneJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new VmMigrationMethodDescriptorSupplier("ListCloneJobs"))
                      .build();
        }
      }
    }
    return getListCloneJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetCloneJobRequest,
          com.google.cloud.vmmigration.v1.CloneJob>
      getGetCloneJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCloneJob",
      requestType = com.google.cloud.vmmigration.v1.GetCloneJobRequest.class,
      responseType = com.google.cloud.vmmigration.v1.CloneJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetCloneJobRequest,
          com.google.cloud.vmmigration.v1.CloneJob>
      getGetCloneJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.GetCloneJobRequest,
            com.google.cloud.vmmigration.v1.CloneJob>
        getGetCloneJobMethod;
    if ((getGetCloneJobMethod = VmMigrationGrpc.getGetCloneJobMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getGetCloneJobMethod = VmMigrationGrpc.getGetCloneJobMethod) == null) {
          VmMigrationGrpc.getGetCloneJobMethod =
              getGetCloneJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.GetCloneJobRequest,
                          com.google.cloud.vmmigration.v1.CloneJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCloneJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.GetCloneJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CloneJob.getDefaultInstance()))
                      .setSchemaDescriptor(new VmMigrationMethodDescriptorSupplier("GetCloneJob"))
                      .build();
        }
      }
    }
    return getGetCloneJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateCutoverJobRequest, com.google.longrunning.Operation>
      getCreateCutoverJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCutoverJob",
      requestType = com.google.cloud.vmmigration.v1.CreateCutoverJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateCutoverJobRequest, com.google.longrunning.Operation>
      getCreateCutoverJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CreateCutoverJobRequest,
            com.google.longrunning.Operation>
        getCreateCutoverJobMethod;
    if ((getCreateCutoverJobMethod = VmMigrationGrpc.getCreateCutoverJobMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCreateCutoverJobMethod = VmMigrationGrpc.getCreateCutoverJobMethod) == null) {
          VmMigrationGrpc.getCreateCutoverJobMethod =
              getCreateCutoverJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CreateCutoverJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCutoverJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CreateCutoverJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("CreateCutoverJob"))
                      .build();
        }
      }
    }
    return getCreateCutoverJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CancelCutoverJobRequest, com.google.longrunning.Operation>
      getCancelCutoverJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelCutoverJob",
      requestType = com.google.cloud.vmmigration.v1.CancelCutoverJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CancelCutoverJobRequest, com.google.longrunning.Operation>
      getCancelCutoverJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CancelCutoverJobRequest,
            com.google.longrunning.Operation>
        getCancelCutoverJobMethod;
    if ((getCancelCutoverJobMethod = VmMigrationGrpc.getCancelCutoverJobMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCancelCutoverJobMethod = VmMigrationGrpc.getCancelCutoverJobMethod) == null) {
          VmMigrationGrpc.getCancelCutoverJobMethod =
              getCancelCutoverJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CancelCutoverJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelCutoverJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CancelCutoverJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("CancelCutoverJob"))
                      .build();
        }
      }
    }
    return getCancelCutoverJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListCutoverJobsRequest,
          com.google.cloud.vmmigration.v1.ListCutoverJobsResponse>
      getListCutoverJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCutoverJobs",
      requestType = com.google.cloud.vmmigration.v1.ListCutoverJobsRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ListCutoverJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListCutoverJobsRequest,
          com.google.cloud.vmmigration.v1.ListCutoverJobsResponse>
      getListCutoverJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ListCutoverJobsRequest,
            com.google.cloud.vmmigration.v1.ListCutoverJobsResponse>
        getListCutoverJobsMethod;
    if ((getListCutoverJobsMethod = VmMigrationGrpc.getListCutoverJobsMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getListCutoverJobsMethod = VmMigrationGrpc.getListCutoverJobsMethod) == null) {
          VmMigrationGrpc.getListCutoverJobsMethod =
              getListCutoverJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ListCutoverJobsRequest,
                          com.google.cloud.vmmigration.v1.ListCutoverJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCutoverJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListCutoverJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListCutoverJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("ListCutoverJobs"))
                      .build();
        }
      }
    }
    return getListCutoverJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetCutoverJobRequest,
          com.google.cloud.vmmigration.v1.CutoverJob>
      getGetCutoverJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCutoverJob",
      requestType = com.google.cloud.vmmigration.v1.GetCutoverJobRequest.class,
      responseType = com.google.cloud.vmmigration.v1.CutoverJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetCutoverJobRequest,
          com.google.cloud.vmmigration.v1.CutoverJob>
      getGetCutoverJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.GetCutoverJobRequest,
            com.google.cloud.vmmigration.v1.CutoverJob>
        getGetCutoverJobMethod;
    if ((getGetCutoverJobMethod = VmMigrationGrpc.getGetCutoverJobMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getGetCutoverJobMethod = VmMigrationGrpc.getGetCutoverJobMethod) == null) {
          VmMigrationGrpc.getGetCutoverJobMethod =
              getGetCutoverJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.GetCutoverJobRequest,
                          com.google.cloud.vmmigration.v1.CutoverJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCutoverJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.GetCutoverJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CutoverJob.getDefaultInstance()))
                      .setSchemaDescriptor(new VmMigrationMethodDescriptorSupplier("GetCutoverJob"))
                      .build();
        }
      }
    }
    return getGetCutoverJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListGroupsRequest,
          com.google.cloud.vmmigration.v1.ListGroupsResponse>
      getListGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGroups",
      requestType = com.google.cloud.vmmigration.v1.ListGroupsRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ListGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListGroupsRequest,
          com.google.cloud.vmmigration.v1.ListGroupsResponse>
      getListGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ListGroupsRequest,
            com.google.cloud.vmmigration.v1.ListGroupsResponse>
        getListGroupsMethod;
    if ((getListGroupsMethod = VmMigrationGrpc.getListGroupsMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getListGroupsMethod = VmMigrationGrpc.getListGroupsMethod) == null) {
          VmMigrationGrpc.getListGroupsMethod =
              getListGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ListGroupsRequest,
                          com.google.cloud.vmmigration.v1.ListGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new VmMigrationMethodDescriptorSupplier("ListGroups"))
                      .build();
        }
      }
    }
    return getListGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetGroupRequest, com.google.cloud.vmmigration.v1.Group>
      getGetGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGroup",
      requestType = com.google.cloud.vmmigration.v1.GetGroupRequest.class,
      responseType = com.google.cloud.vmmigration.v1.Group.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetGroupRequest, com.google.cloud.vmmigration.v1.Group>
      getGetGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.GetGroupRequest, com.google.cloud.vmmigration.v1.Group>
        getGetGroupMethod;
    if ((getGetGroupMethod = VmMigrationGrpc.getGetGroupMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getGetGroupMethod = VmMigrationGrpc.getGetGroupMethod) == null) {
          VmMigrationGrpc.getGetGroupMethod =
              getGetGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.GetGroupRequest,
                          com.google.cloud.vmmigration.v1.Group>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.GetGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.Group.getDefaultInstance()))
                      .setSchemaDescriptor(new VmMigrationMethodDescriptorSupplier("GetGroup"))
                      .build();
        }
      }
    }
    return getGetGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateGroupRequest, com.google.longrunning.Operation>
      getCreateGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGroup",
      requestType = com.google.cloud.vmmigration.v1.CreateGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateGroupRequest, com.google.longrunning.Operation>
      getCreateGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CreateGroupRequest, com.google.longrunning.Operation>
        getCreateGroupMethod;
    if ((getCreateGroupMethod = VmMigrationGrpc.getCreateGroupMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCreateGroupMethod = VmMigrationGrpc.getCreateGroupMethod) == null) {
          VmMigrationGrpc.getCreateGroupMethod =
              getCreateGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CreateGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CreateGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new VmMigrationMethodDescriptorSupplier("CreateGroup"))
                      .build();
        }
      }
    }
    return getCreateGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.UpdateGroupRequest, com.google.longrunning.Operation>
      getUpdateGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGroup",
      requestType = com.google.cloud.vmmigration.v1.UpdateGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.UpdateGroupRequest, com.google.longrunning.Operation>
      getUpdateGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.UpdateGroupRequest, com.google.longrunning.Operation>
        getUpdateGroupMethod;
    if ((getUpdateGroupMethod = VmMigrationGrpc.getUpdateGroupMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getUpdateGroupMethod = VmMigrationGrpc.getUpdateGroupMethod) == null) {
          VmMigrationGrpc.getUpdateGroupMethod =
              getUpdateGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.UpdateGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.UpdateGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new VmMigrationMethodDescriptorSupplier("UpdateGroup"))
                      .build();
        }
      }
    }
    return getUpdateGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteGroupRequest, com.google.longrunning.Operation>
      getDeleteGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGroup",
      requestType = com.google.cloud.vmmigration.v1.DeleteGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteGroupRequest, com.google.longrunning.Operation>
      getDeleteGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.DeleteGroupRequest, com.google.longrunning.Operation>
        getDeleteGroupMethod;
    if ((getDeleteGroupMethod = VmMigrationGrpc.getDeleteGroupMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getDeleteGroupMethod = VmMigrationGrpc.getDeleteGroupMethod) == null) {
          VmMigrationGrpc.getDeleteGroupMethod =
              getDeleteGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.DeleteGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.DeleteGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new VmMigrationMethodDescriptorSupplier("DeleteGroup"))
                      .build();
        }
      }
    }
    return getDeleteGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.AddGroupMigrationRequest,
          com.google.longrunning.Operation>
      getAddGroupMigrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddGroupMigration",
      requestType = com.google.cloud.vmmigration.v1.AddGroupMigrationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.AddGroupMigrationRequest,
          com.google.longrunning.Operation>
      getAddGroupMigrationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.AddGroupMigrationRequest,
            com.google.longrunning.Operation>
        getAddGroupMigrationMethod;
    if ((getAddGroupMigrationMethod = VmMigrationGrpc.getAddGroupMigrationMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getAddGroupMigrationMethod = VmMigrationGrpc.getAddGroupMigrationMethod) == null) {
          VmMigrationGrpc.getAddGroupMigrationMethod =
              getAddGroupMigrationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.AddGroupMigrationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddGroupMigration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.AddGroupMigrationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("AddGroupMigration"))
                      .build();
        }
      }
    }
    return getAddGroupMigrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest,
          com.google.longrunning.Operation>
      getRemoveGroupMigrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveGroupMigration",
      requestType = com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest,
          com.google.longrunning.Operation>
      getRemoveGroupMigrationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest,
            com.google.longrunning.Operation>
        getRemoveGroupMigrationMethod;
    if ((getRemoveGroupMigrationMethod = VmMigrationGrpc.getRemoveGroupMigrationMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getRemoveGroupMigrationMethod = VmMigrationGrpc.getRemoveGroupMigrationMethod)
            == null) {
          VmMigrationGrpc.getRemoveGroupMigrationMethod =
              getRemoveGroupMigrationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RemoveGroupMigration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("RemoveGroupMigration"))
                      .build();
        }
      }
    }
    return getRemoveGroupMigrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListTargetProjectsRequest,
          com.google.cloud.vmmigration.v1.ListTargetProjectsResponse>
      getListTargetProjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTargetProjects",
      requestType = com.google.cloud.vmmigration.v1.ListTargetProjectsRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ListTargetProjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListTargetProjectsRequest,
          com.google.cloud.vmmigration.v1.ListTargetProjectsResponse>
      getListTargetProjectsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ListTargetProjectsRequest,
            com.google.cloud.vmmigration.v1.ListTargetProjectsResponse>
        getListTargetProjectsMethod;
    if ((getListTargetProjectsMethod = VmMigrationGrpc.getListTargetProjectsMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getListTargetProjectsMethod = VmMigrationGrpc.getListTargetProjectsMethod) == null) {
          VmMigrationGrpc.getListTargetProjectsMethod =
              getListTargetProjectsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ListTargetProjectsRequest,
                          com.google.cloud.vmmigration.v1.ListTargetProjectsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTargetProjects"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListTargetProjectsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListTargetProjectsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("ListTargetProjects"))
                      .build();
        }
      }
    }
    return getListTargetProjectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetTargetProjectRequest,
          com.google.cloud.vmmigration.v1.TargetProject>
      getGetTargetProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTargetProject",
      requestType = com.google.cloud.vmmigration.v1.GetTargetProjectRequest.class,
      responseType = com.google.cloud.vmmigration.v1.TargetProject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetTargetProjectRequest,
          com.google.cloud.vmmigration.v1.TargetProject>
      getGetTargetProjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.GetTargetProjectRequest,
            com.google.cloud.vmmigration.v1.TargetProject>
        getGetTargetProjectMethod;
    if ((getGetTargetProjectMethod = VmMigrationGrpc.getGetTargetProjectMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getGetTargetProjectMethod = VmMigrationGrpc.getGetTargetProjectMethod) == null) {
          VmMigrationGrpc.getGetTargetProjectMethod =
              getGetTargetProjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.GetTargetProjectRequest,
                          com.google.cloud.vmmigration.v1.TargetProject>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTargetProject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.GetTargetProjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.TargetProject.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("GetTargetProject"))
                      .build();
        }
      }
    }
    return getGetTargetProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateTargetProjectRequest,
          com.google.longrunning.Operation>
      getCreateTargetProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTargetProject",
      requestType = com.google.cloud.vmmigration.v1.CreateTargetProjectRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateTargetProjectRequest,
          com.google.longrunning.Operation>
      getCreateTargetProjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CreateTargetProjectRequest,
            com.google.longrunning.Operation>
        getCreateTargetProjectMethod;
    if ((getCreateTargetProjectMethod = VmMigrationGrpc.getCreateTargetProjectMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCreateTargetProjectMethod = VmMigrationGrpc.getCreateTargetProjectMethod) == null) {
          VmMigrationGrpc.getCreateTargetProjectMethod =
              getCreateTargetProjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CreateTargetProjectRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateTargetProject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CreateTargetProjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("CreateTargetProject"))
                      .build();
        }
      }
    }
    return getCreateTargetProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest,
          com.google.longrunning.Operation>
      getUpdateTargetProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTargetProject",
      requestType = com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest,
          com.google.longrunning.Operation>
      getUpdateTargetProjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest,
            com.google.longrunning.Operation>
        getUpdateTargetProjectMethod;
    if ((getUpdateTargetProjectMethod = VmMigrationGrpc.getUpdateTargetProjectMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getUpdateTargetProjectMethod = VmMigrationGrpc.getUpdateTargetProjectMethod) == null) {
          VmMigrationGrpc.getUpdateTargetProjectMethod =
              getUpdateTargetProjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateTargetProject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("UpdateTargetProject"))
                      .build();
        }
      }
    }
    return getUpdateTargetProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest,
          com.google.longrunning.Operation>
      getDeleteTargetProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTargetProject",
      requestType = com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest,
          com.google.longrunning.Operation>
      getDeleteTargetProjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest,
            com.google.longrunning.Operation>
        getDeleteTargetProjectMethod;
    if ((getDeleteTargetProjectMethod = VmMigrationGrpc.getDeleteTargetProjectMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getDeleteTargetProjectMethod = VmMigrationGrpc.getDeleteTargetProjectMethod) == null) {
          VmMigrationGrpc.getDeleteTargetProjectMethod =
              getDeleteTargetProjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteTargetProject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("DeleteTargetProject"))
                      .build();
        }
      }
    }
    return getDeleteTargetProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest,
          com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse>
      getListReplicationCyclesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReplicationCycles",
      requestType = com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest,
          com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse>
      getListReplicationCyclesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest,
            com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse>
        getListReplicationCyclesMethod;
    if ((getListReplicationCyclesMethod = VmMigrationGrpc.getListReplicationCyclesMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getListReplicationCyclesMethod = VmMigrationGrpc.getListReplicationCyclesMethod)
            == null) {
          VmMigrationGrpc.getListReplicationCyclesMethod =
              getListReplicationCyclesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest,
                          com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListReplicationCycles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("ListReplicationCycles"))
                      .build();
        }
      }
    }
    return getListReplicationCyclesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetReplicationCycleRequest,
          com.google.cloud.vmmigration.v1.ReplicationCycle>
      getGetReplicationCycleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReplicationCycle",
      requestType = com.google.cloud.vmmigration.v1.GetReplicationCycleRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ReplicationCycle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetReplicationCycleRequest,
          com.google.cloud.vmmigration.v1.ReplicationCycle>
      getGetReplicationCycleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.GetReplicationCycleRequest,
            com.google.cloud.vmmigration.v1.ReplicationCycle>
        getGetReplicationCycleMethod;
    if ((getGetReplicationCycleMethod = VmMigrationGrpc.getGetReplicationCycleMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getGetReplicationCycleMethod = VmMigrationGrpc.getGetReplicationCycleMethod) == null) {
          VmMigrationGrpc.getGetReplicationCycleMethod =
              getGetReplicationCycleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.GetReplicationCycleRequest,
                          com.google.cloud.vmmigration.v1.ReplicationCycle>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetReplicationCycle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.GetReplicationCycleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ReplicationCycle
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("GetReplicationCycle"))
                      .build();
        }
      }
    }
    return getGetReplicationCycleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListImageImportsRequest,
          com.google.cloud.vmmigration.v1.ListImageImportsResponse>
      getListImageImportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListImageImports",
      requestType = com.google.cloud.vmmigration.v1.ListImageImportsRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ListImageImportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListImageImportsRequest,
          com.google.cloud.vmmigration.v1.ListImageImportsResponse>
      getListImageImportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ListImageImportsRequest,
            com.google.cloud.vmmigration.v1.ListImageImportsResponse>
        getListImageImportsMethod;
    if ((getListImageImportsMethod = VmMigrationGrpc.getListImageImportsMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getListImageImportsMethod = VmMigrationGrpc.getListImageImportsMethod) == null) {
          VmMigrationGrpc.getListImageImportsMethod =
              getListImageImportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ListImageImportsRequest,
                          com.google.cloud.vmmigration.v1.ListImageImportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListImageImports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListImageImportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListImageImportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("ListImageImports"))
                      .build();
        }
      }
    }
    return getListImageImportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetImageImportRequest,
          com.google.cloud.vmmigration.v1.ImageImport>
      getGetImageImportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetImageImport",
      requestType = com.google.cloud.vmmigration.v1.GetImageImportRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ImageImport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetImageImportRequest,
          com.google.cloud.vmmigration.v1.ImageImport>
      getGetImageImportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.GetImageImportRequest,
            com.google.cloud.vmmigration.v1.ImageImport>
        getGetImageImportMethod;
    if ((getGetImageImportMethod = VmMigrationGrpc.getGetImageImportMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getGetImageImportMethod = VmMigrationGrpc.getGetImageImportMethod) == null) {
          VmMigrationGrpc.getGetImageImportMethod =
              getGetImageImportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.GetImageImportRequest,
                          com.google.cloud.vmmigration.v1.ImageImport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetImageImport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.GetImageImportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ImageImport.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("GetImageImport"))
                      .build();
        }
      }
    }
    return getGetImageImportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateImageImportRequest,
          com.google.longrunning.Operation>
      getCreateImageImportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateImageImport",
      requestType = com.google.cloud.vmmigration.v1.CreateImageImportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateImageImportRequest,
          com.google.longrunning.Operation>
      getCreateImageImportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CreateImageImportRequest,
            com.google.longrunning.Operation>
        getCreateImageImportMethod;
    if ((getCreateImageImportMethod = VmMigrationGrpc.getCreateImageImportMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCreateImageImportMethod = VmMigrationGrpc.getCreateImageImportMethod) == null) {
          VmMigrationGrpc.getCreateImageImportMethod =
              getCreateImageImportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CreateImageImportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateImageImport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CreateImageImportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("CreateImageImport"))
                      .build();
        }
      }
    }
    return getCreateImageImportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteImageImportRequest,
          com.google.longrunning.Operation>
      getDeleteImageImportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteImageImport",
      requestType = com.google.cloud.vmmigration.v1.DeleteImageImportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteImageImportRequest,
          com.google.longrunning.Operation>
      getDeleteImageImportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.DeleteImageImportRequest,
            com.google.longrunning.Operation>
        getDeleteImageImportMethod;
    if ((getDeleteImageImportMethod = VmMigrationGrpc.getDeleteImageImportMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getDeleteImageImportMethod = VmMigrationGrpc.getDeleteImageImportMethod) == null) {
          VmMigrationGrpc.getDeleteImageImportMethod =
              getDeleteImageImportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.DeleteImageImportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteImageImport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.DeleteImageImportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("DeleteImageImport"))
                      .build();
        }
      }
    }
    return getDeleteImageImportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListImageImportJobsRequest,
          com.google.cloud.vmmigration.v1.ListImageImportJobsResponse>
      getListImageImportJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListImageImportJobs",
      requestType = com.google.cloud.vmmigration.v1.ListImageImportJobsRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ListImageImportJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListImageImportJobsRequest,
          com.google.cloud.vmmigration.v1.ListImageImportJobsResponse>
      getListImageImportJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ListImageImportJobsRequest,
            com.google.cloud.vmmigration.v1.ListImageImportJobsResponse>
        getListImageImportJobsMethod;
    if ((getListImageImportJobsMethod = VmMigrationGrpc.getListImageImportJobsMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getListImageImportJobsMethod = VmMigrationGrpc.getListImageImportJobsMethod) == null) {
          VmMigrationGrpc.getListImageImportJobsMethod =
              getListImageImportJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ListImageImportJobsRequest,
                          com.google.cloud.vmmigration.v1.ListImageImportJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListImageImportJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListImageImportJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListImageImportJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("ListImageImportJobs"))
                      .build();
        }
      }
    }
    return getListImageImportJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetImageImportJobRequest,
          com.google.cloud.vmmigration.v1.ImageImportJob>
      getGetImageImportJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetImageImportJob",
      requestType = com.google.cloud.vmmigration.v1.GetImageImportJobRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ImageImportJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetImageImportJobRequest,
          com.google.cloud.vmmigration.v1.ImageImportJob>
      getGetImageImportJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.GetImageImportJobRequest,
            com.google.cloud.vmmigration.v1.ImageImportJob>
        getGetImageImportJobMethod;
    if ((getGetImageImportJobMethod = VmMigrationGrpc.getGetImageImportJobMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getGetImageImportJobMethod = VmMigrationGrpc.getGetImageImportJobMethod) == null) {
          VmMigrationGrpc.getGetImageImportJobMethod =
              getGetImageImportJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.GetImageImportJobRequest,
                          com.google.cloud.vmmigration.v1.ImageImportJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetImageImportJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.GetImageImportJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ImageImportJob.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("GetImageImportJob"))
                      .build();
        }
      }
    }
    return getGetImageImportJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CancelImageImportJobRequest,
          com.google.longrunning.Operation>
      getCancelImageImportJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelImageImportJob",
      requestType = com.google.cloud.vmmigration.v1.CancelImageImportJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CancelImageImportJobRequest,
          com.google.longrunning.Operation>
      getCancelImageImportJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CancelImageImportJobRequest,
            com.google.longrunning.Operation>
        getCancelImageImportJobMethod;
    if ((getCancelImageImportJobMethod = VmMigrationGrpc.getCancelImageImportJobMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCancelImageImportJobMethod = VmMigrationGrpc.getCancelImageImportJobMethod)
            == null) {
          VmMigrationGrpc.getCancelImageImportJobMethod =
              getCancelImageImportJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CancelImageImportJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CancelImageImportJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CancelImageImportJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("CancelImageImportJob"))
                      .build();
        }
      }
    }
    return getCancelImageImportJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest,
          com.google.longrunning.Operation>
      getCreateDiskMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDiskMigrationJob",
      requestType = com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest,
          com.google.longrunning.Operation>
      getCreateDiskMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest,
            com.google.longrunning.Operation>
        getCreateDiskMigrationJobMethod;
    if ((getCreateDiskMigrationJobMethod = VmMigrationGrpc.getCreateDiskMigrationJobMethod)
        == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCreateDiskMigrationJobMethod = VmMigrationGrpc.getCreateDiskMigrationJobMethod)
            == null) {
          VmMigrationGrpc.getCreateDiskMigrationJobMethod =
              getCreateDiskMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDiskMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("CreateDiskMigrationJob"))
                      .build();
        }
      }
    }
    return getCreateDiskMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest,
          com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse>
      getListDiskMigrationJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDiskMigrationJobs",
      requestType = com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest.class,
      responseType = com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest,
          com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse>
      getListDiskMigrationJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest,
            com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse>
        getListDiskMigrationJobsMethod;
    if ((getListDiskMigrationJobsMethod = VmMigrationGrpc.getListDiskMigrationJobsMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getListDiskMigrationJobsMethod = VmMigrationGrpc.getListDiskMigrationJobsMethod)
            == null) {
          VmMigrationGrpc.getListDiskMigrationJobsMethod =
              getListDiskMigrationJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest,
                          com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDiskMigrationJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("ListDiskMigrationJobs"))
                      .build();
        }
      }
    }
    return getListDiskMigrationJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest,
          com.google.cloud.vmmigration.v1.DiskMigrationJob>
      getGetDiskMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDiskMigrationJob",
      requestType = com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest.class,
      responseType = com.google.cloud.vmmigration.v1.DiskMigrationJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest,
          com.google.cloud.vmmigration.v1.DiskMigrationJob>
      getGetDiskMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest,
            com.google.cloud.vmmigration.v1.DiskMigrationJob>
        getGetDiskMigrationJobMethod;
    if ((getGetDiskMigrationJobMethod = VmMigrationGrpc.getGetDiskMigrationJobMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getGetDiskMigrationJobMethod = VmMigrationGrpc.getGetDiskMigrationJobMethod) == null) {
          VmMigrationGrpc.getGetDiskMigrationJobMethod =
              getGetDiskMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest,
                          com.google.cloud.vmmigration.v1.DiskMigrationJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDiskMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.DiskMigrationJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("GetDiskMigrationJob"))
                      .build();
        }
      }
    }
    return getGetDiskMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest,
          com.google.longrunning.Operation>
      getUpdateDiskMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDiskMigrationJob",
      requestType = com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest,
          com.google.longrunning.Operation>
      getUpdateDiskMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest,
            com.google.longrunning.Operation>
        getUpdateDiskMigrationJobMethod;
    if ((getUpdateDiskMigrationJobMethod = VmMigrationGrpc.getUpdateDiskMigrationJobMethod)
        == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getUpdateDiskMigrationJobMethod = VmMigrationGrpc.getUpdateDiskMigrationJobMethod)
            == null) {
          VmMigrationGrpc.getUpdateDiskMigrationJobMethod =
              getUpdateDiskMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDiskMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("UpdateDiskMigrationJob"))
                      .build();
        }
      }
    }
    return getUpdateDiskMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest,
          com.google.longrunning.Operation>
      getDeleteDiskMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDiskMigrationJob",
      requestType = com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest,
          com.google.longrunning.Operation>
      getDeleteDiskMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest,
            com.google.longrunning.Operation>
        getDeleteDiskMigrationJobMethod;
    if ((getDeleteDiskMigrationJobMethod = VmMigrationGrpc.getDeleteDiskMigrationJobMethod)
        == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getDeleteDiskMigrationJobMethod = VmMigrationGrpc.getDeleteDiskMigrationJobMethod)
            == null) {
          VmMigrationGrpc.getDeleteDiskMigrationJobMethod =
              getDeleteDiskMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDiskMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("DeleteDiskMigrationJob"))
                      .build();
        }
      }
    }
    return getDeleteDiskMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest,
          com.google.longrunning.Operation>
      getRunDiskMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunDiskMigrationJob",
      requestType = com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest,
          com.google.longrunning.Operation>
      getRunDiskMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest,
            com.google.longrunning.Operation>
        getRunDiskMigrationJobMethod;
    if ((getRunDiskMigrationJobMethod = VmMigrationGrpc.getRunDiskMigrationJobMethod) == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getRunDiskMigrationJobMethod = VmMigrationGrpc.getRunDiskMigrationJobMethod) == null) {
          VmMigrationGrpc.getRunDiskMigrationJobMethod =
              getRunDiskMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RunDiskMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("RunDiskMigrationJob"))
                      .build();
        }
      }
    }
    return getRunDiskMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest,
          com.google.longrunning.Operation>
      getCancelDiskMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelDiskMigrationJob",
      requestType = com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest,
          com.google.longrunning.Operation>
      getCancelDiskMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest,
            com.google.longrunning.Operation>
        getCancelDiskMigrationJobMethod;
    if ((getCancelDiskMigrationJobMethod = VmMigrationGrpc.getCancelDiskMigrationJobMethod)
        == null) {
      synchronized (VmMigrationGrpc.class) {
        if ((getCancelDiskMigrationJobMethod = VmMigrationGrpc.getCancelDiskMigrationJobMethod)
            == null) {
          VmMigrationGrpc.getCancelDiskMigrationJobMethod =
              getCancelDiskMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CancelDiskMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VmMigrationMethodDescriptorSupplier("CancelDiskMigrationJob"))
                      .build();
        }
      }
    }
    return getCancelDiskMigrationJobMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static VmMigrationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VmMigrationStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VmMigrationStub>() {
          @java.lang.Override
          public VmMigrationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VmMigrationStub(channel, callOptions);
          }
        };
    return VmMigrationStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static VmMigrationBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VmMigrationBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VmMigrationBlockingV2Stub>() {
          @java.lang.Override
          public VmMigrationBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VmMigrationBlockingV2Stub(channel, callOptions);
          }
        };
    return VmMigrationBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VmMigrationBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VmMigrationBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VmMigrationBlockingStub>() {
          @java.lang.Override
          public VmMigrationBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VmMigrationBlockingStub(channel, callOptions);
          }
        };
    return VmMigrationBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static VmMigrationFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VmMigrationFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VmMigrationFutureStub>() {
          @java.lang.Override
          public VmMigrationFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VmMigrationFutureStub(channel, callOptions);
          }
        };
    return VmMigrationFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * VM Migration Service
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Sources in a given project and location.
     * </pre>
     */
    default void listSources(
        com.google.cloud.vmmigration.v1.ListSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListSourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Source.
     * </pre>
     */
    default void getSource(
        com.google.cloud.vmmigration.v1.GetSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.Source> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Source in a given project and location.
     * </pre>
     */
    default void createSource(
        com.google.cloud.vmmigration.v1.CreateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Source.
     * </pre>
     */
    default void updateSource(
        com.google.cloud.vmmigration.v1.UpdateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Source.
     * </pre>
     */
    default void deleteSource(
        com.google.cloud.vmmigration.v1.DeleteSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List remote source's inventory of VMs.
     * The remote source is the onprem vCenter (remote in the sense it's not in
     * Compute Engine). The inventory describes the list of existing VMs in that
     * source. Note that this operation lists the VMs on the remote source, as
     * opposed to listing the MigratingVms resources in the vmmigration service.
     * </pre>
     */
    default void fetchInventory(
        com.google.cloud.vmmigration.v1.FetchInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.FetchInventoryResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchInventoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List remote source's inventory of storage resources.
     * The remote source is another cloud vendor (e.g. AWS, Azure).
     * The inventory describes the list of existing storage resources in that
     * source. Note that this operation lists the resources on the remote source,
     * as opposed to listing the MigratingVms resources in the vmmigration
     * service.
     * </pre>
     */
    default void fetchStorageInventory(
        com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchStorageInventoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Utilization Reports of the given Source.
     * </pre>
     */
    default void listUtilizationReports(
        com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUtilizationReportsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a single Utilization Report.
     * </pre>
     */
    default void getUtilizationReport(
        com.google.cloud.vmmigration.v1.GetUtilizationReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.UtilizationReport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetUtilizationReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new UtilizationReport.
     * </pre>
     */
    default void createUtilizationReport(
        com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateUtilizationReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Utilization Report.
     * </pre>
     */
    default void deleteUtilizationReport(
        com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteUtilizationReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DatacenterConnectors in a given Source.
     * </pre>
     */
    default void listDatacenterConnectors(
        com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatacenterConnectorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DatacenterConnector.
     * </pre>
     */
    default void getDatacenterConnector(
        com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.DatacenterConnector>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDatacenterConnectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DatacenterConnector in a given Source.
     * </pre>
     */
    default void createDatacenterConnector(
        com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDatacenterConnectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DatacenterConnector.
     * </pre>
     */
    default void deleteDatacenterConnector(
        com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDatacenterConnectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upgrades the appliance relate to this DatacenterConnector to the in-place
     * updateable version.
     * </pre>
     */
    default void upgradeAppliance(
        com.google.cloud.vmmigration.v1.UpgradeApplianceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpgradeApplianceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new MigratingVm in a given Source.
     * </pre>
     */
    default void createMigratingVm(
        com.google.cloud.vmmigration.v1.CreateMigratingVmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMigratingVmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MigratingVms in a given Source.
     * </pre>
     */
    default void listMigratingVms(
        com.google.cloud.vmmigration.v1.ListMigratingVmsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListMigratingVmsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMigratingVmsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single MigratingVm.
     * </pre>
     */
    default void getMigratingVm(
        com.google.cloud.vmmigration.v1.GetMigratingVmRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.MigratingVm> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMigratingVmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single MigratingVm.
     * </pre>
     */
    default void updateMigratingVm(
        com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMigratingVmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single MigratingVm.
     * </pre>
     */
    default void deleteMigratingVm(
        com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMigratingVmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts migration for a VM. Starts the process of uploading
     * data and creating snapshots, in replication cycles scheduled by the policy.
     * </pre>
     */
    default void startMigration(
        com.google.cloud.vmmigration.v1.StartMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartMigrationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes a migration for a VM. When called on a paused migration, will start
     * the process of uploading data and creating snapshots; when called on a
     * completed cut-over migration, will update the migration to active state and
     * start the process of uploading data and creating snapshots.
     * </pre>
     */
    default void resumeMigration(
        com.google.cloud.vmmigration.v1.ResumeMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResumeMigrationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses a migration for a VM. If cycle tasks are running they will be
     * cancelled, preserving source task data. Further replication cycles will not
     * be triggered while the VM is paused.
     * </pre>
     */
    default void pauseMigration(
        com.google.cloud.vmmigration.v1.PauseMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPauseMigrationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks a migration as completed, deleting migration resources that are no
     * longer being used. Only applicable after cutover is done.
     * </pre>
     */
    default void finalizeMigration(
        com.google.cloud.vmmigration.v1.FinalizeMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFinalizeMigrationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Extend the migrating VM time to live.
     * </pre>
     */
    default void extendMigration(
        com.google.cloud.vmmigration.v1.ExtendMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExtendMigrationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Clone of a specific migrating VM.
     * </pre>
     */
    default void createCloneJob(
        com.google.cloud.vmmigration.v1.CreateCloneJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCloneJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running clone job.
     * </pre>
     */
    default void cancelCloneJob(
        com.google.cloud.vmmigration.v1.CancelCloneJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelCloneJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the CloneJobs of a migrating VM. Only 25 most recent CloneJobs are
     * listed.
     * </pre>
     */
    default void listCloneJobs(
        com.google.cloud.vmmigration.v1.ListCloneJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListCloneJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCloneJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloneJob.
     * </pre>
     */
    default void getCloneJob(
        com.google.cloud.vmmigration.v1.GetCloneJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.CloneJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCloneJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Cutover of a specific migrating VM.
     * The returned LRO is completed when the cutover job resource is created
     * and the job is initiated.
     * </pre>
     */
    default void createCutoverJob(
        com.google.cloud.vmmigration.v1.CreateCutoverJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCutoverJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running cutover job.
     * </pre>
     */
    default void cancelCutoverJob(
        com.google.cloud.vmmigration.v1.CancelCutoverJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelCutoverJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the CutoverJobs of a migrating VM. Only 25 most recent CutoverJobs
     * are listed.
     * </pre>
     */
    default void listCutoverJobs(
        com.google.cloud.vmmigration.v1.ListCutoverJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListCutoverJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCutoverJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CutoverJob.
     * </pre>
     */
    default void getCutoverJob(
        com.google.cloud.vmmigration.v1.GetCutoverJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.CutoverJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCutoverJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Groups in a given project and location.
     * </pre>
     */
    default void listGroups(
        com.google.cloud.vmmigration.v1.ListGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Group.
     * </pre>
     */
    default void getGroup(
        com.google.cloud.vmmigration.v1.GetGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.Group> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Group in a given project and location.
     * </pre>
     */
    default void createGroup(
        com.google.cloud.vmmigration.v1.CreateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Group.
     * </pre>
     */
    default void updateGroup(
        com.google.cloud.vmmigration.v1.UpdateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Group.
     * </pre>
     */
    default void deleteGroup(
        com.google.cloud.vmmigration.v1.DeleteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a MigratingVm to a Group.
     * </pre>
     */
    default void addGroupMigration(
        com.google.cloud.vmmigration.v1.AddGroupMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddGroupMigrationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a MigratingVm from a Group.
     * </pre>
     */
    default void removeGroupMigration(
        com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveGroupMigrationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TargetProjects in a given project.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    default void listTargetProjects(
        com.google.cloud.vmmigration.v1.ListTargetProjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListTargetProjectsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTargetProjectsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    default void getTargetProject(
        com.google.cloud.vmmigration.v1.GetTargetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.TargetProject>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTargetProjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TargetProject in a given project.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    default void createTargetProject(
        com.google.cloud.vmmigration.v1.CreateTargetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTargetProjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    default void updateTargetProject(
        com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTargetProjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    default void deleteTargetProject(
        com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTargetProjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ReplicationCycles in a given MigratingVM.
     * </pre>
     */
    default void listReplicationCycles(
        com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReplicationCyclesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReplicationCycle.
     * </pre>
     */
    default void getReplicationCycle(
        com.google.cloud.vmmigration.v1.GetReplicationCycleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ReplicationCycle>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetReplicationCycleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ImageImports in a given project.
     * </pre>
     */
    default void listImageImports(
        com.google.cloud.vmmigration.v1.ListImageImportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListImageImportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListImageImportsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ImageImport.
     * </pre>
     */
    default void getImageImport(
        com.google.cloud.vmmigration.v1.GetImageImportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ImageImport> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetImageImportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ImageImport in a given project.
     * </pre>
     */
    default void createImageImport(
        com.google.cloud.vmmigration.v1.CreateImageImportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateImageImportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ImageImport.
     * </pre>
     */
    default void deleteImageImport(
        com.google.cloud.vmmigration.v1.DeleteImageImportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteImageImportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ImageImportJobs in a given project.
     * </pre>
     */
    default void listImageImportJobs(
        com.google.cloud.vmmigration.v1.ListImageImportJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListImageImportJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListImageImportJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ImageImportJob.
     * </pre>
     */
    default void getImageImportJob(
        com.google.cloud.vmmigration.v1.GetImageImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ImageImportJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetImageImportJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running clone job.
     * </pre>
     */
    default void cancelImageImportJob(
        com.google.cloud.vmmigration.v1.CancelImageImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelImageImportJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new disk migration job in a given Source.
     * </pre>
     */
    default void createDiskMigrationJob(
        com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDiskMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DiskMigrationJobs in a given Source.
     * </pre>
     */
    default void listDiskMigrationJobs(
        com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDiskMigrationJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DiskMigrationJob.
     * </pre>
     */
    default void getDiskMigrationJob(
        com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.DiskMigrationJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDiskMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single DiskMigrationJob.
     * </pre>
     */
    default void updateDiskMigrationJob(
        com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDiskMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DiskMigrationJob.
     * </pre>
     */
    default void deleteDiskMigrationJob(
        com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDiskMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs the disk migration job.
     * </pre>
     */
    default void runDiskMigrationJob(
        com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunDiskMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels the disk migration job.
     * </pre>
     */
    default void cancelDiskMigrationJob(
        com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelDiskMigrationJobMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service VmMigration.
   *
   * <pre>
   * VM Migration Service
   * </pre>
   */
  public abstract static class VmMigrationImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return VmMigrationGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service VmMigration.
   *
   * <pre>
   * VM Migration Service
   * </pre>
   */
  public static final class VmMigrationStub
      extends io.grpc.stub.AbstractAsyncStub<VmMigrationStub> {
    private VmMigrationStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VmMigrationStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VmMigrationStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Sources in a given project and location.
     * </pre>
     */
    public void listSources(
        com.google.cloud.vmmigration.v1.ListSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListSourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Source.
     * </pre>
     */
    public void getSource(
        com.google.cloud.vmmigration.v1.GetSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.Source> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Source in a given project and location.
     * </pre>
     */
    public void createSource(
        com.google.cloud.vmmigration.v1.CreateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Source.
     * </pre>
     */
    public void updateSource(
        com.google.cloud.vmmigration.v1.UpdateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Source.
     * </pre>
     */
    public void deleteSource(
        com.google.cloud.vmmigration.v1.DeleteSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List remote source's inventory of VMs.
     * The remote source is the onprem vCenter (remote in the sense it's not in
     * Compute Engine). The inventory describes the list of existing VMs in that
     * source. Note that this operation lists the VMs on the remote source, as
     * opposed to listing the MigratingVms resources in the vmmigration service.
     * </pre>
     */
    public void fetchInventory(
        com.google.cloud.vmmigration.v1.FetchInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.FetchInventoryResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchInventoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List remote source's inventory of storage resources.
     * The remote source is another cloud vendor (e.g. AWS, Azure).
     * The inventory describes the list of existing storage resources in that
     * source. Note that this operation lists the resources on the remote source,
     * as opposed to listing the MigratingVms resources in the vmmigration
     * service.
     * </pre>
     */
    public void fetchStorageInventory(
        com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchStorageInventoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Utilization Reports of the given Source.
     * </pre>
     */
    public void listUtilizationReports(
        com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUtilizationReportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a single Utilization Report.
     * </pre>
     */
    public void getUtilizationReport(
        com.google.cloud.vmmigration.v1.GetUtilizationReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.UtilizationReport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUtilizationReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new UtilizationReport.
     * </pre>
     */
    public void createUtilizationReport(
        com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUtilizationReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Utilization Report.
     * </pre>
     */
    public void deleteUtilizationReport(
        com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUtilizationReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DatacenterConnectors in a given Source.
     * </pre>
     */
    public void listDatacenterConnectors(
        com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatacenterConnectorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DatacenterConnector.
     * </pre>
     */
    public void getDatacenterConnector(
        com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.DatacenterConnector>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatacenterConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DatacenterConnector in a given Source.
     * </pre>
     */
    public void createDatacenterConnector(
        com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDatacenterConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DatacenterConnector.
     * </pre>
     */
    public void deleteDatacenterConnector(
        com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDatacenterConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upgrades the appliance relate to this DatacenterConnector to the in-place
     * updateable version.
     * </pre>
     */
    public void upgradeAppliance(
        com.google.cloud.vmmigration.v1.UpgradeApplianceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpgradeApplianceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new MigratingVm in a given Source.
     * </pre>
     */
    public void createMigratingVm(
        com.google.cloud.vmmigration.v1.CreateMigratingVmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMigratingVmMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MigratingVms in a given Source.
     * </pre>
     */
    public void listMigratingVms(
        com.google.cloud.vmmigration.v1.ListMigratingVmsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListMigratingVmsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMigratingVmsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single MigratingVm.
     * </pre>
     */
    public void getMigratingVm(
        com.google.cloud.vmmigration.v1.GetMigratingVmRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.MigratingVm> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMigratingVmMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single MigratingVm.
     * </pre>
     */
    public void updateMigratingVm(
        com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMigratingVmMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single MigratingVm.
     * </pre>
     */
    public void deleteMigratingVm(
        com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMigratingVmMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts migration for a VM. Starts the process of uploading
     * data and creating snapshots, in replication cycles scheduled by the policy.
     * </pre>
     */
    public void startMigration(
        com.google.cloud.vmmigration.v1.StartMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartMigrationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes a migration for a VM. When called on a paused migration, will start
     * the process of uploading data and creating snapshots; when called on a
     * completed cut-over migration, will update the migration to active state and
     * start the process of uploading data and creating snapshots.
     * </pre>
     */
    public void resumeMigration(
        com.google.cloud.vmmigration.v1.ResumeMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeMigrationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses a migration for a VM. If cycle tasks are running they will be
     * cancelled, preserving source task data. Further replication cycles will not
     * be triggered while the VM is paused.
     * </pre>
     */
    public void pauseMigration(
        com.google.cloud.vmmigration.v1.PauseMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPauseMigrationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks a migration as completed, deleting migration resources that are no
     * longer being used. Only applicable after cutover is done.
     * </pre>
     */
    public void finalizeMigration(
        com.google.cloud.vmmigration.v1.FinalizeMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFinalizeMigrationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Extend the migrating VM time to live.
     * </pre>
     */
    public void extendMigration(
        com.google.cloud.vmmigration.v1.ExtendMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExtendMigrationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Clone of a specific migrating VM.
     * </pre>
     */
    public void createCloneJob(
        com.google.cloud.vmmigration.v1.CreateCloneJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCloneJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running clone job.
     * </pre>
     */
    public void cancelCloneJob(
        com.google.cloud.vmmigration.v1.CancelCloneJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelCloneJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the CloneJobs of a migrating VM. Only 25 most recent CloneJobs are
     * listed.
     * </pre>
     */
    public void listCloneJobs(
        com.google.cloud.vmmigration.v1.ListCloneJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListCloneJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCloneJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloneJob.
     * </pre>
     */
    public void getCloneJob(
        com.google.cloud.vmmigration.v1.GetCloneJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.CloneJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCloneJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Cutover of a specific migrating VM.
     * The returned LRO is completed when the cutover job resource is created
     * and the job is initiated.
     * </pre>
     */
    public void createCutoverJob(
        com.google.cloud.vmmigration.v1.CreateCutoverJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCutoverJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running cutover job.
     * </pre>
     */
    public void cancelCutoverJob(
        com.google.cloud.vmmigration.v1.CancelCutoverJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelCutoverJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the CutoverJobs of a migrating VM. Only 25 most recent CutoverJobs
     * are listed.
     * </pre>
     */
    public void listCutoverJobs(
        com.google.cloud.vmmigration.v1.ListCutoverJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListCutoverJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCutoverJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CutoverJob.
     * </pre>
     */
    public void getCutoverJob(
        com.google.cloud.vmmigration.v1.GetCutoverJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.CutoverJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCutoverJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Groups in a given project and location.
     * </pre>
     */
    public void listGroups(
        com.google.cloud.vmmigration.v1.ListGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGroupsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Group.
     * </pre>
     */
    public void getGroup(
        com.google.cloud.vmmigration.v1.GetGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.Group> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Group in a given project and location.
     * </pre>
     */
    public void createGroup(
        com.google.cloud.vmmigration.v1.CreateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Group.
     * </pre>
     */
    public void updateGroup(
        com.google.cloud.vmmigration.v1.UpdateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Group.
     * </pre>
     */
    public void deleteGroup(
        com.google.cloud.vmmigration.v1.DeleteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a MigratingVm to a Group.
     * </pre>
     */
    public void addGroupMigration(
        com.google.cloud.vmmigration.v1.AddGroupMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddGroupMigrationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a MigratingVm from a Group.
     * </pre>
     */
    public void removeGroupMigration(
        com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveGroupMigrationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TargetProjects in a given project.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public void listTargetProjects(
        com.google.cloud.vmmigration.v1.ListTargetProjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListTargetProjectsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTargetProjectsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public void getTargetProject(
        com.google.cloud.vmmigration.v1.GetTargetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.TargetProject>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTargetProjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TargetProject in a given project.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public void createTargetProject(
        com.google.cloud.vmmigration.v1.CreateTargetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTargetProjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public void updateTargetProject(
        com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTargetProjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public void deleteTargetProject(
        com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTargetProjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ReplicationCycles in a given MigratingVM.
     * </pre>
     */
    public void listReplicationCycles(
        com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReplicationCyclesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReplicationCycle.
     * </pre>
     */
    public void getReplicationCycle(
        com.google.cloud.vmmigration.v1.GetReplicationCycleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ReplicationCycle>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReplicationCycleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ImageImports in a given project.
     * </pre>
     */
    public void listImageImports(
        com.google.cloud.vmmigration.v1.ListImageImportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListImageImportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListImageImportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ImageImport.
     * </pre>
     */
    public void getImageImport(
        com.google.cloud.vmmigration.v1.GetImageImportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ImageImport> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetImageImportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ImageImport in a given project.
     * </pre>
     */
    public void createImageImport(
        com.google.cloud.vmmigration.v1.CreateImageImportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateImageImportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ImageImport.
     * </pre>
     */
    public void deleteImageImport(
        com.google.cloud.vmmigration.v1.DeleteImageImportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteImageImportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ImageImportJobs in a given project.
     * </pre>
     */
    public void listImageImportJobs(
        com.google.cloud.vmmigration.v1.ListImageImportJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListImageImportJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListImageImportJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ImageImportJob.
     * </pre>
     */
    public void getImageImportJob(
        com.google.cloud.vmmigration.v1.GetImageImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ImageImportJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetImageImportJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running clone job.
     * </pre>
     */
    public void cancelImageImportJob(
        com.google.cloud.vmmigration.v1.CancelImageImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelImageImportJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new disk migration job in a given Source.
     * </pre>
     */
    public void createDiskMigrationJob(
        com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDiskMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DiskMigrationJobs in a given Source.
     * </pre>
     */
    public void listDiskMigrationJobs(
        com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDiskMigrationJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DiskMigrationJob.
     * </pre>
     */
    public void getDiskMigrationJob(
        com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.DiskMigrationJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDiskMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single DiskMigrationJob.
     * </pre>
     */
    public void updateDiskMigrationJob(
        com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDiskMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DiskMigrationJob.
     * </pre>
     */
    public void deleteDiskMigrationJob(
        com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDiskMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs the disk migration job.
     * </pre>
     */
    public void runDiskMigrationJob(
        com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunDiskMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels the disk migration job.
     * </pre>
     */
    public void cancelDiskMigrationJob(
        com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelDiskMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service VmMigration.
   *
   * <pre>
   * VM Migration Service
   * </pre>
   */
  public static final class VmMigrationBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<VmMigrationBlockingV2Stub> {
    private VmMigrationBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VmMigrationBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VmMigrationBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Sources in a given project and location.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListSourcesResponse listSources(
        com.google.cloud.vmmigration.v1.ListSourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Source.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.Source getSource(
        com.google.cloud.vmmigration.v1.GetSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Source in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSource(
        com.google.cloud.vmmigration.v1.CreateSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Source.
     * </pre>
     */
    public com.google.longrunning.Operation updateSource(
        com.google.cloud.vmmigration.v1.UpdateSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Source.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSource(
        com.google.cloud.vmmigration.v1.DeleteSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List remote source's inventory of VMs.
     * The remote source is the onprem vCenter (remote in the sense it's not in
     * Compute Engine). The inventory describes the list of existing VMs in that
     * source. Note that this operation lists the VMs on the remote source, as
     * opposed to listing the MigratingVms resources in the vmmigration service.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.FetchInventoryResponse fetchInventory(
        com.google.cloud.vmmigration.v1.FetchInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchInventoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List remote source's inventory of storage resources.
     * The remote source is another cloud vendor (e.g. AWS, Azure).
     * The inventory describes the list of existing storage resources in that
     * source. Note that this operation lists the resources on the remote source,
     * as opposed to listing the MigratingVms resources in the vmmigration
     * service.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse fetchStorageInventory(
        com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchStorageInventoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Utilization Reports of the given Source.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse listUtilizationReports(
        com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUtilizationReportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single Utilization Report.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.UtilizationReport getUtilizationReport(
        com.google.cloud.vmmigration.v1.GetUtilizationReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUtilizationReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new UtilizationReport.
     * </pre>
     */
    public com.google.longrunning.Operation createUtilizationReport(
        com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUtilizationReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Utilization Report.
     * </pre>
     */
    public com.google.longrunning.Operation deleteUtilizationReport(
        com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUtilizationReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DatacenterConnectors in a given Source.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse
        listDatacenterConnectors(
            com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatacenterConnectorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DatacenterConnector.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.DatacenterConnector getDatacenterConnector(
        com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatacenterConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DatacenterConnector in a given Source.
     * </pre>
     */
    public com.google.longrunning.Operation createDatacenterConnector(
        com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatacenterConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DatacenterConnector.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDatacenterConnector(
        com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDatacenterConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Upgrades the appliance relate to this DatacenterConnector to the in-place
     * updateable version.
     * </pre>
     */
    public com.google.longrunning.Operation upgradeAppliance(
        com.google.cloud.vmmigration.v1.UpgradeApplianceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpgradeApplianceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new MigratingVm in a given Source.
     * </pre>
     */
    public com.google.longrunning.Operation createMigratingVm(
        com.google.cloud.vmmigration.v1.CreateMigratingVmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMigratingVmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MigratingVms in a given Source.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListMigratingVmsResponse listMigratingVms(
        com.google.cloud.vmmigration.v1.ListMigratingVmsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMigratingVmsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single MigratingVm.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.MigratingVm getMigratingVm(
        com.google.cloud.vmmigration.v1.GetMigratingVmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMigratingVmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single MigratingVm.
     * </pre>
     */
    public com.google.longrunning.Operation updateMigratingVm(
        com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMigratingVmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single MigratingVm.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMigratingVm(
        com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMigratingVmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts migration for a VM. Starts the process of uploading
     * data and creating snapshots, in replication cycles scheduled by the policy.
     * </pre>
     */
    public com.google.longrunning.Operation startMigration(
        com.google.cloud.vmmigration.v1.StartMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes a migration for a VM. When called on a paused migration, will start
     * the process of uploading data and creating snapshots; when called on a
     * completed cut-over migration, will update the migration to active state and
     * start the process of uploading data and creating snapshots.
     * </pre>
     */
    public com.google.longrunning.Operation resumeMigration(
        com.google.cloud.vmmigration.v1.ResumeMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses a migration for a VM. If cycle tasks are running they will be
     * cancelled, preserving source task data. Further replication cycles will not
     * be triggered while the VM is paused.
     * </pre>
     */
    public com.google.longrunning.Operation pauseMigration(
        com.google.cloud.vmmigration.v1.PauseMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPauseMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Marks a migration as completed, deleting migration resources that are no
     * longer being used. Only applicable after cutover is done.
     * </pre>
     */
    public com.google.longrunning.Operation finalizeMigration(
        com.google.cloud.vmmigration.v1.FinalizeMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFinalizeMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Extend the migrating VM time to live.
     * </pre>
     */
    public com.google.longrunning.Operation extendMigration(
        com.google.cloud.vmmigration.v1.ExtendMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExtendMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Clone of a specific migrating VM.
     * </pre>
     */
    public com.google.longrunning.Operation createCloneJob(
        com.google.cloud.vmmigration.v1.CreateCloneJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCloneJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running clone job.
     * </pre>
     */
    public com.google.longrunning.Operation cancelCloneJob(
        com.google.cloud.vmmigration.v1.CancelCloneJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelCloneJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the CloneJobs of a migrating VM. Only 25 most recent CloneJobs are
     * listed.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListCloneJobsResponse listCloneJobs(
        com.google.cloud.vmmigration.v1.ListCloneJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCloneJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloneJob.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.CloneJob getCloneJob(
        com.google.cloud.vmmigration.v1.GetCloneJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCloneJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Cutover of a specific migrating VM.
     * The returned LRO is completed when the cutover job resource is created
     * and the job is initiated.
     * </pre>
     */
    public com.google.longrunning.Operation createCutoverJob(
        com.google.cloud.vmmigration.v1.CreateCutoverJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCutoverJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running cutover job.
     * </pre>
     */
    public com.google.longrunning.Operation cancelCutoverJob(
        com.google.cloud.vmmigration.v1.CancelCutoverJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelCutoverJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the CutoverJobs of a migrating VM. Only 25 most recent CutoverJobs
     * are listed.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListCutoverJobsResponse listCutoverJobs(
        com.google.cloud.vmmigration.v1.ListCutoverJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCutoverJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CutoverJob.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.CutoverJob getCutoverJob(
        com.google.cloud.vmmigration.v1.GetCutoverJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCutoverJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Groups in a given project and location.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListGroupsResponse listGroups(
        com.google.cloud.vmmigration.v1.ListGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Group.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.Group getGroup(
        com.google.cloud.vmmigration.v1.GetGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Group in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGroup(
        com.google.cloud.vmmigration.v1.CreateGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Group.
     * </pre>
     */
    public com.google.longrunning.Operation updateGroup(
        com.google.cloud.vmmigration.v1.UpdateGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Group.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGroup(
        com.google.cloud.vmmigration.v1.DeleteGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a MigratingVm to a Group.
     * </pre>
     */
    public com.google.longrunning.Operation addGroupMigration(
        com.google.cloud.vmmigration.v1.AddGroupMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddGroupMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a MigratingVm from a Group.
     * </pre>
     */
    public com.google.longrunning.Operation removeGroupMigration(
        com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveGroupMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TargetProjects in a given project.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListTargetProjectsResponse listTargetProjects(
        com.google.cloud.vmmigration.v1.ListTargetProjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTargetProjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.TargetProject getTargetProject(
        com.google.cloud.vmmigration.v1.GetTargetProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTargetProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TargetProject in a given project.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.longrunning.Operation createTargetProject(
        com.google.cloud.vmmigration.v1.CreateTargetProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTargetProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.longrunning.Operation updateTargetProject(
        com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTargetProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTargetProject(
        com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTargetProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ReplicationCycles in a given MigratingVM.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse listReplicationCycles(
        com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReplicationCyclesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReplicationCycle.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ReplicationCycle getReplicationCycle(
        com.google.cloud.vmmigration.v1.GetReplicationCycleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReplicationCycleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ImageImports in a given project.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListImageImportsResponse listImageImports(
        com.google.cloud.vmmigration.v1.ListImageImportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListImageImportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ImageImport.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ImageImport getImageImport(
        com.google.cloud.vmmigration.v1.GetImageImportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetImageImportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ImageImport in a given project.
     * </pre>
     */
    public com.google.longrunning.Operation createImageImport(
        com.google.cloud.vmmigration.v1.CreateImageImportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateImageImportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ImageImport.
     * </pre>
     */
    public com.google.longrunning.Operation deleteImageImport(
        com.google.cloud.vmmigration.v1.DeleteImageImportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteImageImportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ImageImportJobs in a given project.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListImageImportJobsResponse listImageImportJobs(
        com.google.cloud.vmmigration.v1.ListImageImportJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListImageImportJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ImageImportJob.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ImageImportJob getImageImportJob(
        com.google.cloud.vmmigration.v1.GetImageImportJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetImageImportJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running clone job.
     * </pre>
     */
    public com.google.longrunning.Operation cancelImageImportJob(
        com.google.cloud.vmmigration.v1.CancelImageImportJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelImageImportJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new disk migration job in a given Source.
     * </pre>
     */
    public com.google.longrunning.Operation createDiskMigrationJob(
        com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDiskMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DiskMigrationJobs in a given Source.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse listDiskMigrationJobs(
        com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDiskMigrationJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DiskMigrationJob.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.DiskMigrationJob getDiskMigrationJob(
        com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDiskMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single DiskMigrationJob.
     * </pre>
     */
    public com.google.longrunning.Operation updateDiskMigrationJob(
        com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDiskMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DiskMigrationJob.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDiskMigrationJob(
        com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDiskMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs the disk migration job.
     * </pre>
     */
    public com.google.longrunning.Operation runDiskMigrationJob(
        com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunDiskMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels the disk migration job.
     * </pre>
     */
    public com.google.longrunning.Operation cancelDiskMigrationJob(
        com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelDiskMigrationJobMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service VmMigration.
   *
   * <pre>
   * VM Migration Service
   * </pre>
   */
  public static final class VmMigrationBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<VmMigrationBlockingStub> {
    private VmMigrationBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VmMigrationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VmMigrationBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Sources in a given project and location.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListSourcesResponse listSources(
        com.google.cloud.vmmigration.v1.ListSourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Source.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.Source getSource(
        com.google.cloud.vmmigration.v1.GetSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Source in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSource(
        com.google.cloud.vmmigration.v1.CreateSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Source.
     * </pre>
     */
    public com.google.longrunning.Operation updateSource(
        com.google.cloud.vmmigration.v1.UpdateSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Source.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSource(
        com.google.cloud.vmmigration.v1.DeleteSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List remote source's inventory of VMs.
     * The remote source is the onprem vCenter (remote in the sense it's not in
     * Compute Engine). The inventory describes the list of existing VMs in that
     * source. Note that this operation lists the VMs on the remote source, as
     * opposed to listing the MigratingVms resources in the vmmigration service.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.FetchInventoryResponse fetchInventory(
        com.google.cloud.vmmigration.v1.FetchInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchInventoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List remote source's inventory of storage resources.
     * The remote source is another cloud vendor (e.g. AWS, Azure).
     * The inventory describes the list of existing storage resources in that
     * source. Note that this operation lists the resources on the remote source,
     * as opposed to listing the MigratingVms resources in the vmmigration
     * service.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse fetchStorageInventory(
        com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchStorageInventoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Utilization Reports of the given Source.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse listUtilizationReports(
        com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUtilizationReportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single Utilization Report.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.UtilizationReport getUtilizationReport(
        com.google.cloud.vmmigration.v1.GetUtilizationReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUtilizationReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new UtilizationReport.
     * </pre>
     */
    public com.google.longrunning.Operation createUtilizationReport(
        com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUtilizationReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Utilization Report.
     * </pre>
     */
    public com.google.longrunning.Operation deleteUtilizationReport(
        com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUtilizationReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DatacenterConnectors in a given Source.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse
        listDatacenterConnectors(
            com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatacenterConnectorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DatacenterConnector.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.DatacenterConnector getDatacenterConnector(
        com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatacenterConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DatacenterConnector in a given Source.
     * </pre>
     */
    public com.google.longrunning.Operation createDatacenterConnector(
        com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatacenterConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DatacenterConnector.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDatacenterConnector(
        com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDatacenterConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Upgrades the appliance relate to this DatacenterConnector to the in-place
     * updateable version.
     * </pre>
     */
    public com.google.longrunning.Operation upgradeAppliance(
        com.google.cloud.vmmigration.v1.UpgradeApplianceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpgradeApplianceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new MigratingVm in a given Source.
     * </pre>
     */
    public com.google.longrunning.Operation createMigratingVm(
        com.google.cloud.vmmigration.v1.CreateMigratingVmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMigratingVmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MigratingVms in a given Source.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListMigratingVmsResponse listMigratingVms(
        com.google.cloud.vmmigration.v1.ListMigratingVmsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMigratingVmsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single MigratingVm.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.MigratingVm getMigratingVm(
        com.google.cloud.vmmigration.v1.GetMigratingVmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMigratingVmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single MigratingVm.
     * </pre>
     */
    public com.google.longrunning.Operation updateMigratingVm(
        com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMigratingVmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single MigratingVm.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMigratingVm(
        com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMigratingVmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts migration for a VM. Starts the process of uploading
     * data and creating snapshots, in replication cycles scheduled by the policy.
     * </pre>
     */
    public com.google.longrunning.Operation startMigration(
        com.google.cloud.vmmigration.v1.StartMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes a migration for a VM. When called on a paused migration, will start
     * the process of uploading data and creating snapshots; when called on a
     * completed cut-over migration, will update the migration to active state and
     * start the process of uploading data and creating snapshots.
     * </pre>
     */
    public com.google.longrunning.Operation resumeMigration(
        com.google.cloud.vmmigration.v1.ResumeMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses a migration for a VM. If cycle tasks are running they will be
     * cancelled, preserving source task data. Further replication cycles will not
     * be triggered while the VM is paused.
     * </pre>
     */
    public com.google.longrunning.Operation pauseMigration(
        com.google.cloud.vmmigration.v1.PauseMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPauseMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Marks a migration as completed, deleting migration resources that are no
     * longer being used. Only applicable after cutover is done.
     * </pre>
     */
    public com.google.longrunning.Operation finalizeMigration(
        com.google.cloud.vmmigration.v1.FinalizeMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFinalizeMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Extend the migrating VM time to live.
     * </pre>
     */
    public com.google.longrunning.Operation extendMigration(
        com.google.cloud.vmmigration.v1.ExtendMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExtendMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Clone of a specific migrating VM.
     * </pre>
     */
    public com.google.longrunning.Operation createCloneJob(
        com.google.cloud.vmmigration.v1.CreateCloneJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCloneJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running clone job.
     * </pre>
     */
    public com.google.longrunning.Operation cancelCloneJob(
        com.google.cloud.vmmigration.v1.CancelCloneJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelCloneJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the CloneJobs of a migrating VM. Only 25 most recent CloneJobs are
     * listed.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListCloneJobsResponse listCloneJobs(
        com.google.cloud.vmmigration.v1.ListCloneJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCloneJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloneJob.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.CloneJob getCloneJob(
        com.google.cloud.vmmigration.v1.GetCloneJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCloneJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Cutover of a specific migrating VM.
     * The returned LRO is completed when the cutover job resource is created
     * and the job is initiated.
     * </pre>
     */
    public com.google.longrunning.Operation createCutoverJob(
        com.google.cloud.vmmigration.v1.CreateCutoverJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCutoverJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running cutover job.
     * </pre>
     */
    public com.google.longrunning.Operation cancelCutoverJob(
        com.google.cloud.vmmigration.v1.CancelCutoverJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelCutoverJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the CutoverJobs of a migrating VM. Only 25 most recent CutoverJobs
     * are listed.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListCutoverJobsResponse listCutoverJobs(
        com.google.cloud.vmmigration.v1.ListCutoverJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCutoverJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CutoverJob.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.CutoverJob getCutoverJob(
        com.google.cloud.vmmigration.v1.GetCutoverJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCutoverJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Groups in a given project and location.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListGroupsResponse listGroups(
        com.google.cloud.vmmigration.v1.ListGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Group.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.Group getGroup(
        com.google.cloud.vmmigration.v1.GetGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Group in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGroup(
        com.google.cloud.vmmigration.v1.CreateGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Group.
     * </pre>
     */
    public com.google.longrunning.Operation updateGroup(
        com.google.cloud.vmmigration.v1.UpdateGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Group.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGroup(
        com.google.cloud.vmmigration.v1.DeleteGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a MigratingVm to a Group.
     * </pre>
     */
    public com.google.longrunning.Operation addGroupMigration(
        com.google.cloud.vmmigration.v1.AddGroupMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddGroupMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a MigratingVm from a Group.
     * </pre>
     */
    public com.google.longrunning.Operation removeGroupMigration(
        com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveGroupMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TargetProjects in a given project.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListTargetProjectsResponse listTargetProjects(
        com.google.cloud.vmmigration.v1.ListTargetProjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTargetProjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.TargetProject getTargetProject(
        com.google.cloud.vmmigration.v1.GetTargetProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTargetProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TargetProject in a given project.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.longrunning.Operation createTargetProject(
        com.google.cloud.vmmigration.v1.CreateTargetProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTargetProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.longrunning.Operation updateTargetProject(
        com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTargetProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTargetProject(
        com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTargetProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ReplicationCycles in a given MigratingVM.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse listReplicationCycles(
        com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReplicationCyclesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReplicationCycle.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ReplicationCycle getReplicationCycle(
        com.google.cloud.vmmigration.v1.GetReplicationCycleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReplicationCycleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ImageImports in a given project.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListImageImportsResponse listImageImports(
        com.google.cloud.vmmigration.v1.ListImageImportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListImageImportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ImageImport.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ImageImport getImageImport(
        com.google.cloud.vmmigration.v1.GetImageImportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetImageImportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ImageImport in a given project.
     * </pre>
     */
    public com.google.longrunning.Operation createImageImport(
        com.google.cloud.vmmigration.v1.CreateImageImportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateImageImportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ImageImport.
     * </pre>
     */
    public com.google.longrunning.Operation deleteImageImport(
        com.google.cloud.vmmigration.v1.DeleteImageImportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteImageImportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ImageImportJobs in a given project.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListImageImportJobsResponse listImageImportJobs(
        com.google.cloud.vmmigration.v1.ListImageImportJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListImageImportJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ImageImportJob.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ImageImportJob getImageImportJob(
        com.google.cloud.vmmigration.v1.GetImageImportJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetImageImportJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running clone job.
     * </pre>
     */
    public com.google.longrunning.Operation cancelImageImportJob(
        com.google.cloud.vmmigration.v1.CancelImageImportJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelImageImportJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new disk migration job in a given Source.
     * </pre>
     */
    public com.google.longrunning.Operation createDiskMigrationJob(
        com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDiskMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DiskMigrationJobs in a given Source.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse listDiskMigrationJobs(
        com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDiskMigrationJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DiskMigrationJob.
     * </pre>
     */
    public com.google.cloud.vmmigration.v1.DiskMigrationJob getDiskMigrationJob(
        com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDiskMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single DiskMigrationJob.
     * </pre>
     */
    public com.google.longrunning.Operation updateDiskMigrationJob(
        com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDiskMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DiskMigrationJob.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDiskMigrationJob(
        com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDiskMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs the disk migration job.
     * </pre>
     */
    public com.google.longrunning.Operation runDiskMigrationJob(
        com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunDiskMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels the disk migration job.
     * </pre>
     */
    public com.google.longrunning.Operation cancelDiskMigrationJob(
        com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelDiskMigrationJobMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service VmMigration.
   *
   * <pre>
   * VM Migration Service
   * </pre>
   */
  public static final class VmMigrationFutureStub
      extends io.grpc.stub.AbstractFutureStub<VmMigrationFutureStub> {
    private VmMigrationFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VmMigrationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VmMigrationFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Sources in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ListSourcesResponse>
        listSources(com.google.cloud.vmmigration.v1.ListSourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.Source>
        getSource(com.google.cloud.vmmigration.v1.GetSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Source in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSource(com.google.cloud.vmmigration.v1.CreateSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSource(com.google.cloud.vmmigration.v1.UpdateSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSource(com.google.cloud.vmmigration.v1.DeleteSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List remote source's inventory of VMs.
     * The remote source is the onprem vCenter (remote in the sense it's not in
     * Compute Engine). The inventory describes the list of existing VMs in that
     * source. Note that this operation lists the VMs on the remote source, as
     * opposed to listing the MigratingVms resources in the vmmigration service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.FetchInventoryResponse>
        fetchInventory(com.google.cloud.vmmigration.v1.FetchInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchInventoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List remote source's inventory of storage resources.
     * The remote source is another cloud vendor (e.g. AWS, Azure).
     * The inventory describes the list of existing storage resources in that
     * source. Note that this operation lists the resources on the remote source,
     * as opposed to listing the MigratingVms resources in the vmmigration
     * service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse>
        fetchStorageInventory(
            com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchStorageInventoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Utilization Reports of the given Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse>
        listUtilizationReports(
            com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUtilizationReportsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single Utilization Report.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.UtilizationReport>
        getUtilizationReport(com.google.cloud.vmmigration.v1.GetUtilizationReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUtilizationReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new UtilizationReport.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createUtilizationReport(
            com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUtilizationReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Utilization Report.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteUtilizationReport(
            com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUtilizationReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DatacenterConnectors in a given Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse>
        listDatacenterConnectors(
            com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatacenterConnectorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DatacenterConnector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.DatacenterConnector>
        getDatacenterConnector(
            com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatacenterConnectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DatacenterConnector in a given Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDatacenterConnector(
            com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDatacenterConnectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DatacenterConnector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDatacenterConnector(
            com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDatacenterConnectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Upgrades the appliance relate to this DatacenterConnector to the in-place
     * updateable version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        upgradeAppliance(com.google.cloud.vmmigration.v1.UpgradeApplianceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpgradeApplianceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new MigratingVm in a given Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMigratingVm(com.google.cloud.vmmigration.v1.CreateMigratingVmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMigratingVmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MigratingVms in a given Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ListMigratingVmsResponse>
        listMigratingVms(com.google.cloud.vmmigration.v1.ListMigratingVmsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMigratingVmsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single MigratingVm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.MigratingVm>
        getMigratingVm(com.google.cloud.vmmigration.v1.GetMigratingVmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMigratingVmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single MigratingVm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMigratingVm(com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMigratingVmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single MigratingVm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMigratingVm(com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMigratingVmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts migration for a VM. Starts the process of uploading
     * data and creating snapshots, in replication cycles scheduled by the policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        startMigration(com.google.cloud.vmmigration.v1.StartMigrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartMigrationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes a migration for a VM. When called on a paused migration, will start
     * the process of uploading data and creating snapshots; when called on a
     * completed cut-over migration, will update the migration to active state and
     * start the process of uploading data and creating snapshots.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        resumeMigration(com.google.cloud.vmmigration.v1.ResumeMigrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeMigrationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses a migration for a VM. If cycle tasks are running they will be
     * cancelled, preserving source task data. Further replication cycles will not
     * be triggered while the VM is paused.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        pauseMigration(com.google.cloud.vmmigration.v1.PauseMigrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPauseMigrationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Marks a migration as completed, deleting migration resources that are no
     * longer being used. Only applicable after cutover is done.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        finalizeMigration(com.google.cloud.vmmigration.v1.FinalizeMigrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFinalizeMigrationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Extend the migrating VM time to live.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        extendMigration(com.google.cloud.vmmigration.v1.ExtendMigrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExtendMigrationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Clone of a specific migrating VM.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCloneJob(com.google.cloud.vmmigration.v1.CreateCloneJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCloneJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running clone job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        cancelCloneJob(com.google.cloud.vmmigration.v1.CancelCloneJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelCloneJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the CloneJobs of a migrating VM. Only 25 most recent CloneJobs are
     * listed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ListCloneJobsResponse>
        listCloneJobs(com.google.cloud.vmmigration.v1.ListCloneJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCloneJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CloneJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.CloneJob>
        getCloneJob(com.google.cloud.vmmigration.v1.GetCloneJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCloneJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Cutover of a specific migrating VM.
     * The returned LRO is completed when the cutover job resource is created
     * and the job is initiated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCutoverJob(com.google.cloud.vmmigration.v1.CreateCutoverJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCutoverJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running cutover job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        cancelCutoverJob(com.google.cloud.vmmigration.v1.CancelCutoverJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelCutoverJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the CutoverJobs of a migrating VM. Only 25 most recent CutoverJobs
     * are listed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ListCutoverJobsResponse>
        listCutoverJobs(com.google.cloud.vmmigration.v1.ListCutoverJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCutoverJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CutoverJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.CutoverJob>
        getCutoverJob(com.google.cloud.vmmigration.v1.GetCutoverJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCutoverJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Groups in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ListGroupsResponse>
        listGroups(com.google.cloud.vmmigration.v1.ListGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmmigration.v1.Group>
        getGroup(com.google.cloud.vmmigration.v1.GetGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Group in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGroup(com.google.cloud.vmmigration.v1.CreateGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGroup(com.google.cloud.vmmigration.v1.UpdateGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGroup(com.google.cloud.vmmigration.v1.DeleteGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a MigratingVm to a Group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        addGroupMigration(com.google.cloud.vmmigration.v1.AddGroupMigrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddGroupMigrationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a MigratingVm from a Group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        removeGroupMigration(com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveGroupMigrationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TargetProjects in a given project.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ListTargetProjectsResponse>
        listTargetProjects(com.google.cloud.vmmigration.v1.ListTargetProjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTargetProjectsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.TargetProject>
        getTargetProject(com.google.cloud.vmmigration.v1.GetTargetProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTargetProjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TargetProject in a given project.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createTargetProject(com.google.cloud.vmmigration.v1.CreateTargetProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTargetProjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateTargetProject(com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTargetProjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TargetProject.
     * NOTE: TargetProject is a global resource; hence the only supported value
     * for location is `global`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteTargetProject(com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTargetProjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ReplicationCycles in a given MigratingVM.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse>
        listReplicationCycles(
            com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReplicationCyclesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ReplicationCycle.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ReplicationCycle>
        getReplicationCycle(com.google.cloud.vmmigration.v1.GetReplicationCycleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReplicationCycleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ImageImports in a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ListImageImportsResponse>
        listImageImports(com.google.cloud.vmmigration.v1.ListImageImportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListImageImportsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ImageImport.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ImageImport>
        getImageImport(com.google.cloud.vmmigration.v1.GetImageImportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetImageImportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ImageImport in a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createImageImport(com.google.cloud.vmmigration.v1.CreateImageImportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateImageImportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ImageImport.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteImageImport(com.google.cloud.vmmigration.v1.DeleteImageImportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteImageImportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ImageImportJobs in a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ListImageImportJobsResponse>
        listImageImportJobs(com.google.cloud.vmmigration.v1.ListImageImportJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListImageImportJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ImageImportJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ImageImportJob>
        getImageImportJob(com.google.cloud.vmmigration.v1.GetImageImportJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetImageImportJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the cancellation of a running clone job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        cancelImageImportJob(com.google.cloud.vmmigration.v1.CancelImageImportJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelImageImportJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new disk migration job in a given Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDiskMigrationJob(
            com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDiskMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DiskMigrationJobs in a given Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse>
        listDiskMigrationJobs(
            com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDiskMigrationJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DiskMigrationJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vmmigration.v1.DiskMigrationJob>
        getDiskMigrationJob(com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDiskMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single DiskMigrationJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDiskMigrationJob(
            com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDiskMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DiskMigrationJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDiskMigrationJob(
            com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDiskMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Runs the disk migration job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        runDiskMigrationJob(com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunDiskMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels the disk migration job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        cancelDiskMigrationJob(
            com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelDiskMigrationJobMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SOURCES = 0;
  private static final int METHODID_GET_SOURCE = 1;
  private static final int METHODID_CREATE_SOURCE = 2;
  private static final int METHODID_UPDATE_SOURCE = 3;
  private static final int METHODID_DELETE_SOURCE = 4;
  private static final int METHODID_FETCH_INVENTORY = 5;
  private static final int METHODID_FETCH_STORAGE_INVENTORY = 6;
  private static final int METHODID_LIST_UTILIZATION_REPORTS = 7;
  private static final int METHODID_GET_UTILIZATION_REPORT = 8;
  private static final int METHODID_CREATE_UTILIZATION_REPORT = 9;
  private static final int METHODID_DELETE_UTILIZATION_REPORT = 10;
  private static final int METHODID_LIST_DATACENTER_CONNECTORS = 11;
  private static final int METHODID_GET_DATACENTER_CONNECTOR = 12;
  private static final int METHODID_CREATE_DATACENTER_CONNECTOR = 13;
  private static final int METHODID_DELETE_DATACENTER_CONNECTOR = 14;
  private static final int METHODID_UPGRADE_APPLIANCE = 15;
  private static final int METHODID_CREATE_MIGRATING_VM = 16;
  private static final int METHODID_LIST_MIGRATING_VMS = 17;
  private static final int METHODID_GET_MIGRATING_VM = 18;
  private static final int METHODID_UPDATE_MIGRATING_VM = 19;
  private static final int METHODID_DELETE_MIGRATING_VM = 20;
  private static final int METHODID_START_MIGRATION = 21;
  private static final int METHODID_RESUME_MIGRATION = 22;
  private static final int METHODID_PAUSE_MIGRATION = 23;
  private static final int METHODID_FINALIZE_MIGRATION = 24;
  private static final int METHODID_EXTEND_MIGRATION = 25;
  private static final int METHODID_CREATE_CLONE_JOB = 26;
  private static final int METHODID_CANCEL_CLONE_JOB = 27;
  private static final int METHODID_LIST_CLONE_JOBS = 28;
  private static final int METHODID_GET_CLONE_JOB = 29;
  private static final int METHODID_CREATE_CUTOVER_JOB = 30;
  private static final int METHODID_CANCEL_CUTOVER_JOB = 31;
  private static final int METHODID_LIST_CUTOVER_JOBS = 32;
  private static final int METHODID_GET_CUTOVER_JOB = 33;
  private static final int METHODID_LIST_GROUPS = 34;
  private static final int METHODID_GET_GROUP = 35;
  private static final int METHODID_CREATE_GROUP = 36;
  private static final int METHODID_UPDATE_GROUP = 37;
  private static final int METHODID_DELETE_GROUP = 38;
  private static final int METHODID_ADD_GROUP_MIGRATION = 39;
  private static final int METHODID_REMOVE_GROUP_MIGRATION = 40;
  private static final int METHODID_LIST_TARGET_PROJECTS = 41;
  private static final int METHODID_GET_TARGET_PROJECT = 42;
  private static final int METHODID_CREATE_TARGET_PROJECT = 43;
  private static final int METHODID_UPDATE_TARGET_PROJECT = 44;
  private static final int METHODID_DELETE_TARGET_PROJECT = 45;
  private static final int METHODID_LIST_REPLICATION_CYCLES = 46;
  private static final int METHODID_GET_REPLICATION_CYCLE = 47;
  private static final int METHODID_LIST_IMAGE_IMPORTS = 48;
  private static final int METHODID_GET_IMAGE_IMPORT = 49;
  private static final int METHODID_CREATE_IMAGE_IMPORT = 50;
  private static final int METHODID_DELETE_IMAGE_IMPORT = 51;
  private static final int METHODID_LIST_IMAGE_IMPORT_JOBS = 52;
  private static final int METHODID_GET_IMAGE_IMPORT_JOB = 53;
  private static final int METHODID_CANCEL_IMAGE_IMPORT_JOB = 54;
  private static final int METHODID_CREATE_DISK_MIGRATION_JOB = 55;
  private static final int METHODID_LIST_DISK_MIGRATION_JOBS = 56;
  private static final int METHODID_GET_DISK_MIGRATION_JOB = 57;
  private static final int METHODID_UPDATE_DISK_MIGRATION_JOB = 58;
  private static final int METHODID_DELETE_DISK_MIGRATION_JOB = 59;
  private static final int METHODID_RUN_DISK_MIGRATION_JOB = 60;
  private static final int METHODID_CANCEL_DISK_MIGRATION_JOB = 61;

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
        case METHODID_LIST_SOURCES:
          serviceImpl.listSources(
              (com.google.cloud.vmmigration.v1.ListSourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListSourcesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SOURCE:
          serviceImpl.getSource(
              (com.google.cloud.vmmigration.v1.GetSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.Source>)
                  responseObserver);
          break;
        case METHODID_CREATE_SOURCE:
          serviceImpl.createSource(
              (com.google.cloud.vmmigration.v1.CreateSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SOURCE:
          serviceImpl.updateSource(
              (com.google.cloud.vmmigration.v1.UpdateSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SOURCE:
          serviceImpl.deleteSource(
              (com.google.cloud.vmmigration.v1.DeleteSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FETCH_INVENTORY:
          serviceImpl.fetchInventory(
              (com.google.cloud.vmmigration.v1.FetchInventoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.FetchInventoryResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_STORAGE_INVENTORY:
          serviceImpl.fetchStorageInventory(
              (com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_UTILIZATION_REPORTS:
          serviceImpl.listUtilizationReports(
              (com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_UTILIZATION_REPORT:
          serviceImpl.getUtilizationReport(
              (com.google.cloud.vmmigration.v1.GetUtilizationReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.UtilizationReport>)
                  responseObserver);
          break;
        case METHODID_CREATE_UTILIZATION_REPORT:
          serviceImpl.createUtilizationReport(
              (com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_UTILIZATION_REPORT:
          serviceImpl.deleteUtilizationReport(
              (com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DATACENTER_CONNECTORS:
          serviceImpl.listDatacenterConnectors(
              (com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATACENTER_CONNECTOR:
          serviceImpl.getDatacenterConnector(
              (com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.DatacenterConnector>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATACENTER_CONNECTOR:
          serviceImpl.createDatacenterConnector(
              (com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DATACENTER_CONNECTOR:
          serviceImpl.deleteDatacenterConnector(
              (com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPGRADE_APPLIANCE:
          serviceImpl.upgradeAppliance(
              (com.google.cloud.vmmigration.v1.UpgradeApplianceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_MIGRATING_VM:
          serviceImpl.createMigratingVm(
              (com.google.cloud.vmmigration.v1.CreateMigratingVmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_MIGRATING_VMS:
          serviceImpl.listMigratingVms(
              (com.google.cloud.vmmigration.v1.ListMigratingVmsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmmigration.v1.ListMigratingVmsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MIGRATING_VM:
          serviceImpl.getMigratingVm(
              (com.google.cloud.vmmigration.v1.GetMigratingVmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.MigratingVm>)
                  responseObserver);
          break;
        case METHODID_UPDATE_MIGRATING_VM:
          serviceImpl.updateMigratingVm(
              (com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MIGRATING_VM:
          serviceImpl.deleteMigratingVm(
              (com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_MIGRATION:
          serviceImpl.startMigration(
              (com.google.cloud.vmmigration.v1.StartMigrationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESUME_MIGRATION:
          serviceImpl.resumeMigration(
              (com.google.cloud.vmmigration.v1.ResumeMigrationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PAUSE_MIGRATION:
          serviceImpl.pauseMigration(
              (com.google.cloud.vmmigration.v1.PauseMigrationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FINALIZE_MIGRATION:
          serviceImpl.finalizeMigration(
              (com.google.cloud.vmmigration.v1.FinalizeMigrationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXTEND_MIGRATION:
          serviceImpl.extendMigration(
              (com.google.cloud.vmmigration.v1.ExtendMigrationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_CLONE_JOB:
          serviceImpl.createCloneJob(
              (com.google.cloud.vmmigration.v1.CreateCloneJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CANCEL_CLONE_JOB:
          serviceImpl.cancelCloneJob(
              (com.google.cloud.vmmigration.v1.CancelCloneJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CLONE_JOBS:
          serviceImpl.listCloneJobs(
              (com.google.cloud.vmmigration.v1.ListCloneJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListCloneJobsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLONE_JOB:
          serviceImpl.getCloneJob(
              (com.google.cloud.vmmigration.v1.GetCloneJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.CloneJob>)
                  responseObserver);
          break;
        case METHODID_CREATE_CUTOVER_JOB:
          serviceImpl.createCutoverJob(
              (com.google.cloud.vmmigration.v1.CreateCutoverJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CANCEL_CUTOVER_JOB:
          serviceImpl.cancelCutoverJob(
              (com.google.cloud.vmmigration.v1.CancelCutoverJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CUTOVER_JOBS:
          serviceImpl.listCutoverJobs(
              (com.google.cloud.vmmigration.v1.ListCutoverJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListCutoverJobsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CUTOVER_JOB:
          serviceImpl.getCutoverJob(
              (com.google.cloud.vmmigration.v1.GetCutoverJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.CutoverJob>)
                  responseObserver);
          break;
        case METHODID_LIST_GROUPS:
          serviceImpl.listGroups(
              (com.google.cloud.vmmigration.v1.ListGroupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ListGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GROUP:
          serviceImpl.getGroup(
              (com.google.cloud.vmmigration.v1.GetGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.Group>)
                  responseObserver);
          break;
        case METHODID_CREATE_GROUP:
          serviceImpl.createGroup(
              (com.google.cloud.vmmigration.v1.CreateGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP:
          serviceImpl.updateGroup(
              (com.google.cloud.vmmigration.v1.UpdateGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GROUP:
          serviceImpl.deleteGroup(
              (com.google.cloud.vmmigration.v1.DeleteGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ADD_GROUP_MIGRATION:
          serviceImpl.addGroupMigration(
              (com.google.cloud.vmmigration.v1.AddGroupMigrationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REMOVE_GROUP_MIGRATION:
          serviceImpl.removeGroupMigration(
              (com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_TARGET_PROJECTS:
          serviceImpl.listTargetProjects(
              (com.google.cloud.vmmigration.v1.ListTargetProjectsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmmigration.v1.ListTargetProjectsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TARGET_PROJECT:
          serviceImpl.getTargetProject(
              (com.google.cloud.vmmigration.v1.GetTargetProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.TargetProject>)
                  responseObserver);
          break;
        case METHODID_CREATE_TARGET_PROJECT:
          serviceImpl.createTargetProject(
              (com.google.cloud.vmmigration.v1.CreateTargetProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_TARGET_PROJECT:
          serviceImpl.updateTargetProject(
              (com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TARGET_PROJECT:
          serviceImpl.deleteTargetProject(
              (com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_REPLICATION_CYCLES:
          serviceImpl.listReplicationCycles(
              (com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REPLICATION_CYCLE:
          serviceImpl.getReplicationCycle(
              (com.google.cloud.vmmigration.v1.GetReplicationCycleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ReplicationCycle>)
                  responseObserver);
          break;
        case METHODID_LIST_IMAGE_IMPORTS:
          serviceImpl.listImageImports(
              (com.google.cloud.vmmigration.v1.ListImageImportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmmigration.v1.ListImageImportsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_IMAGE_IMPORT:
          serviceImpl.getImageImport(
              (com.google.cloud.vmmigration.v1.GetImageImportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ImageImport>)
                  responseObserver);
          break;
        case METHODID_CREATE_IMAGE_IMPORT:
          serviceImpl.createImageImport(
              (com.google.cloud.vmmigration.v1.CreateImageImportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_IMAGE_IMPORT:
          serviceImpl.deleteImageImport(
              (com.google.cloud.vmmigration.v1.DeleteImageImportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_IMAGE_IMPORT_JOBS:
          serviceImpl.listImageImportJobs(
              (com.google.cloud.vmmigration.v1.ListImageImportJobsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmmigration.v1.ListImageImportJobsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_IMAGE_IMPORT_JOB:
          serviceImpl.getImageImportJob(
              (com.google.cloud.vmmigration.v1.GetImageImportJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.ImageImportJob>)
                  responseObserver);
          break;
        case METHODID_CANCEL_IMAGE_IMPORT_JOB:
          serviceImpl.cancelImageImportJob(
              (com.google.cloud.vmmigration.v1.CancelImageImportJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_DISK_MIGRATION_JOB:
          serviceImpl.createDiskMigrationJob(
              (com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DISK_MIGRATION_JOBS:
          serviceImpl.listDiskMigrationJobs(
              (com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DISK_MIGRATION_JOB:
          serviceImpl.getDiskMigrationJob(
              (com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmmigration.v1.DiskMigrationJob>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DISK_MIGRATION_JOB:
          serviceImpl.updateDiskMigrationJob(
              (com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DISK_MIGRATION_JOB:
          serviceImpl.deleteDiskMigrationJob(
              (com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RUN_DISK_MIGRATION_JOB:
          serviceImpl.runDiskMigrationJob(
              (com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CANCEL_DISK_MIGRATION_JOB:
          serviceImpl.cancelDiskMigrationJob(
              (com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest) request,
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
            getListSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ListSourcesRequest,
                    com.google.cloud.vmmigration.v1.ListSourcesResponse>(
                    service, METHODID_LIST_SOURCES)))
        .addMethod(
            getGetSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.GetSourceRequest,
                    com.google.cloud.vmmigration.v1.Source>(service, METHODID_GET_SOURCE)))
        .addMethod(
            getCreateSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CreateSourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SOURCE)))
        .addMethod(
            getUpdateSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.UpdateSourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SOURCE)))
        .addMethod(
            getDeleteSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.DeleteSourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SOURCE)))
        .addMethod(
            getFetchInventoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.FetchInventoryRequest,
                    com.google.cloud.vmmigration.v1.FetchInventoryResponse>(
                    service, METHODID_FETCH_INVENTORY)))
        .addMethod(
            getFetchStorageInventoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest,
                    com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse>(
                    service, METHODID_FETCH_STORAGE_INVENTORY)))
        .addMethod(
            getListUtilizationReportsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest,
                    com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse>(
                    service, METHODID_LIST_UTILIZATION_REPORTS)))
        .addMethod(
            getGetUtilizationReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.GetUtilizationReportRequest,
                    com.google.cloud.vmmigration.v1.UtilizationReport>(
                    service, METHODID_GET_UTILIZATION_REPORT)))
        .addMethod(
            getCreateUtilizationReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_UTILIZATION_REPORT)))
        .addMethod(
            getDeleteUtilizationReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_UTILIZATION_REPORT)))
        .addMethod(
            getListDatacenterConnectorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest,
                    com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse>(
                    service, METHODID_LIST_DATACENTER_CONNECTORS)))
        .addMethod(
            getGetDatacenterConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest,
                    com.google.cloud.vmmigration.v1.DatacenterConnector>(
                    service, METHODID_GET_DATACENTER_CONNECTOR)))
        .addMethod(
            getCreateDatacenterConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_DATACENTER_CONNECTOR)))
        .addMethod(
            getDeleteDatacenterConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_DATACENTER_CONNECTOR)))
        .addMethod(
            getUpgradeApplianceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.UpgradeApplianceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPGRADE_APPLIANCE)))
        .addMethod(
            getCreateMigratingVmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CreateMigratingVmRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_MIGRATING_VM)))
        .addMethod(
            getListMigratingVmsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ListMigratingVmsRequest,
                    com.google.cloud.vmmigration.v1.ListMigratingVmsResponse>(
                    service, METHODID_LIST_MIGRATING_VMS)))
        .addMethod(
            getGetMigratingVmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.GetMigratingVmRequest,
                    com.google.cloud.vmmigration.v1.MigratingVm>(
                    service, METHODID_GET_MIGRATING_VM)))
        .addMethod(
            getUpdateMigratingVmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_MIGRATING_VM)))
        .addMethod(
            getDeleteMigratingVmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_MIGRATING_VM)))
        .addMethod(
            getStartMigrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.StartMigrationRequest,
                    com.google.longrunning.Operation>(service, METHODID_START_MIGRATION)))
        .addMethod(
            getResumeMigrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ResumeMigrationRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESUME_MIGRATION)))
        .addMethod(
            getPauseMigrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.PauseMigrationRequest,
                    com.google.longrunning.Operation>(service, METHODID_PAUSE_MIGRATION)))
        .addMethod(
            getFinalizeMigrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.FinalizeMigrationRequest,
                    com.google.longrunning.Operation>(service, METHODID_FINALIZE_MIGRATION)))
        .addMethod(
            getExtendMigrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ExtendMigrationRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXTEND_MIGRATION)))
        .addMethod(
            getCreateCloneJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CreateCloneJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CLONE_JOB)))
        .addMethod(
            getCancelCloneJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CancelCloneJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_CANCEL_CLONE_JOB)))
        .addMethod(
            getListCloneJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ListCloneJobsRequest,
                    com.google.cloud.vmmigration.v1.ListCloneJobsResponse>(
                    service, METHODID_LIST_CLONE_JOBS)))
        .addMethod(
            getGetCloneJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.GetCloneJobRequest,
                    com.google.cloud.vmmigration.v1.CloneJob>(service, METHODID_GET_CLONE_JOB)))
        .addMethod(
            getCreateCutoverJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CreateCutoverJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CUTOVER_JOB)))
        .addMethod(
            getCancelCutoverJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CancelCutoverJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_CANCEL_CUTOVER_JOB)))
        .addMethod(
            getListCutoverJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ListCutoverJobsRequest,
                    com.google.cloud.vmmigration.v1.ListCutoverJobsResponse>(
                    service, METHODID_LIST_CUTOVER_JOBS)))
        .addMethod(
            getGetCutoverJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.GetCutoverJobRequest,
                    com.google.cloud.vmmigration.v1.CutoverJob>(service, METHODID_GET_CUTOVER_JOB)))
        .addMethod(
            getListGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ListGroupsRequest,
                    com.google.cloud.vmmigration.v1.ListGroupsResponse>(
                    service, METHODID_LIST_GROUPS)))
        .addMethod(
            getGetGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.GetGroupRequest,
                    com.google.cloud.vmmigration.v1.Group>(service, METHODID_GET_GROUP)))
        .addMethod(
            getCreateGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CreateGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_GROUP)))
        .addMethod(
            getUpdateGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.UpdateGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_GROUP)))
        .addMethod(
            getDeleteGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.DeleteGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_GROUP)))
        .addMethod(
            getAddGroupMigrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.AddGroupMigrationRequest,
                    com.google.longrunning.Operation>(service, METHODID_ADD_GROUP_MIGRATION)))
        .addMethod(
            getRemoveGroupMigrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest,
                    com.google.longrunning.Operation>(service, METHODID_REMOVE_GROUP_MIGRATION)))
        .addMethod(
            getListTargetProjectsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ListTargetProjectsRequest,
                    com.google.cloud.vmmigration.v1.ListTargetProjectsResponse>(
                    service, METHODID_LIST_TARGET_PROJECTS)))
        .addMethod(
            getGetTargetProjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.GetTargetProjectRequest,
                    com.google.cloud.vmmigration.v1.TargetProject>(
                    service, METHODID_GET_TARGET_PROJECT)))
        .addMethod(
            getCreateTargetProjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CreateTargetProjectRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_TARGET_PROJECT)))
        .addMethod(
            getUpdateTargetProjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_TARGET_PROJECT)))
        .addMethod(
            getDeleteTargetProjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_TARGET_PROJECT)))
        .addMethod(
            getListReplicationCyclesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest,
                    com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse>(
                    service, METHODID_LIST_REPLICATION_CYCLES)))
        .addMethod(
            getGetReplicationCycleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.GetReplicationCycleRequest,
                    com.google.cloud.vmmigration.v1.ReplicationCycle>(
                    service, METHODID_GET_REPLICATION_CYCLE)))
        .addMethod(
            getListImageImportsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ListImageImportsRequest,
                    com.google.cloud.vmmigration.v1.ListImageImportsResponse>(
                    service, METHODID_LIST_IMAGE_IMPORTS)))
        .addMethod(
            getGetImageImportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.GetImageImportRequest,
                    com.google.cloud.vmmigration.v1.ImageImport>(
                    service, METHODID_GET_IMAGE_IMPORT)))
        .addMethod(
            getCreateImageImportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CreateImageImportRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_IMAGE_IMPORT)))
        .addMethod(
            getDeleteImageImportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.DeleteImageImportRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_IMAGE_IMPORT)))
        .addMethod(
            getListImageImportJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ListImageImportJobsRequest,
                    com.google.cloud.vmmigration.v1.ListImageImportJobsResponse>(
                    service, METHODID_LIST_IMAGE_IMPORT_JOBS)))
        .addMethod(
            getGetImageImportJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.GetImageImportJobRequest,
                    com.google.cloud.vmmigration.v1.ImageImportJob>(
                    service, METHODID_GET_IMAGE_IMPORT_JOB)))
        .addMethod(
            getCancelImageImportJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CancelImageImportJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_CANCEL_IMAGE_IMPORT_JOB)))
        .addMethod(
            getCreateDiskMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DISK_MIGRATION_JOB)))
        .addMethod(
            getListDiskMigrationJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest,
                    com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse>(
                    service, METHODID_LIST_DISK_MIGRATION_JOBS)))
        .addMethod(
            getGetDiskMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest,
                    com.google.cloud.vmmigration.v1.DiskMigrationJob>(
                    service, METHODID_GET_DISK_MIGRATION_JOB)))
        .addMethod(
            getUpdateDiskMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DISK_MIGRATION_JOB)))
        .addMethod(
            getDeleteDiskMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DISK_MIGRATION_JOB)))
        .addMethod(
            getRunDiskMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_RUN_DISK_MIGRATION_JOB)))
        .addMethod(
            getCancelDiskMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_CANCEL_DISK_MIGRATION_JOB)))
        .build();
  }

  private abstract static class VmMigrationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VmMigrationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.vmmigration.v1.VmMigrationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VmMigration");
    }
  }

  private static final class VmMigrationFileDescriptorSupplier
      extends VmMigrationBaseDescriptorSupplier {
    VmMigrationFileDescriptorSupplier() {}
  }

  private static final class VmMigrationMethodDescriptorSupplier
      extends VmMigrationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    VmMigrationMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (VmMigrationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new VmMigrationFileDescriptorSupplier())
                      .addMethod(getListSourcesMethod())
                      .addMethod(getGetSourceMethod())
                      .addMethod(getCreateSourceMethod())
                      .addMethod(getUpdateSourceMethod())
                      .addMethod(getDeleteSourceMethod())
                      .addMethod(getFetchInventoryMethod())
                      .addMethod(getFetchStorageInventoryMethod())
                      .addMethod(getListUtilizationReportsMethod())
                      .addMethod(getGetUtilizationReportMethod())
                      .addMethod(getCreateUtilizationReportMethod())
                      .addMethod(getDeleteUtilizationReportMethod())
                      .addMethod(getListDatacenterConnectorsMethod())
                      .addMethod(getGetDatacenterConnectorMethod())
                      .addMethod(getCreateDatacenterConnectorMethod())
                      .addMethod(getDeleteDatacenterConnectorMethod())
                      .addMethod(getUpgradeApplianceMethod())
                      .addMethod(getCreateMigratingVmMethod())
                      .addMethod(getListMigratingVmsMethod())
                      .addMethod(getGetMigratingVmMethod())
                      .addMethod(getUpdateMigratingVmMethod())
                      .addMethod(getDeleteMigratingVmMethod())
                      .addMethod(getStartMigrationMethod())
                      .addMethod(getResumeMigrationMethod())
                      .addMethod(getPauseMigrationMethod())
                      .addMethod(getFinalizeMigrationMethod())
                      .addMethod(getExtendMigrationMethod())
                      .addMethod(getCreateCloneJobMethod())
                      .addMethod(getCancelCloneJobMethod())
                      .addMethod(getListCloneJobsMethod())
                      .addMethod(getGetCloneJobMethod())
                      .addMethod(getCreateCutoverJobMethod())
                      .addMethod(getCancelCutoverJobMethod())
                      .addMethod(getListCutoverJobsMethod())
                      .addMethod(getGetCutoverJobMethod())
                      .addMethod(getListGroupsMethod())
                      .addMethod(getGetGroupMethod())
                      .addMethod(getCreateGroupMethod())
                      .addMethod(getUpdateGroupMethod())
                      .addMethod(getDeleteGroupMethod())
                      .addMethod(getAddGroupMigrationMethod())
                      .addMethod(getRemoveGroupMigrationMethod())
                      .addMethod(getListTargetProjectsMethod())
                      .addMethod(getGetTargetProjectMethod())
                      .addMethod(getCreateTargetProjectMethod())
                      .addMethod(getUpdateTargetProjectMethod())
                      .addMethod(getDeleteTargetProjectMethod())
                      .addMethod(getListReplicationCyclesMethod())
                      .addMethod(getGetReplicationCycleMethod())
                      .addMethod(getListImageImportsMethod())
                      .addMethod(getGetImageImportMethod())
                      .addMethod(getCreateImageImportMethod())
                      .addMethod(getDeleteImageImportMethod())
                      .addMethod(getListImageImportJobsMethod())
                      .addMethod(getGetImageImportJobMethod())
                      .addMethod(getCancelImageImportJobMethod())
                      .addMethod(getCreateDiskMigrationJobMethod())
                      .addMethod(getListDiskMigrationJobsMethod())
                      .addMethod(getGetDiskMigrationJobMethod())
                      .addMethod(getUpdateDiskMigrationJobMethod())
                      .addMethod(getDeleteDiskMigrationJobMethod())
                      .addMethod(getRunDiskMigrationJobMethod())
                      .addMethod(getCancelDiskMigrationJobMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
