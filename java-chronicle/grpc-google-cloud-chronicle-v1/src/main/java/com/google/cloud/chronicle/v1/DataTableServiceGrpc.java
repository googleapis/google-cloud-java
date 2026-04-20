/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * DataTableManager provides an interface for managing data tables.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DataTableServiceGrpc {

  private DataTableServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.chronicle.v1.DataTableService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.CreateDataTableRequest,
          com.google.cloud.chronicle.v1.DataTable>
      getCreateDataTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataTable",
      requestType = com.google.cloud.chronicle.v1.CreateDataTableRequest.class,
      responseType = com.google.cloud.chronicle.v1.DataTable.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.CreateDataTableRequest,
          com.google.cloud.chronicle.v1.DataTable>
      getCreateDataTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.CreateDataTableRequest,
            com.google.cloud.chronicle.v1.DataTable>
        getCreateDataTableMethod;
    if ((getCreateDataTableMethod = DataTableServiceGrpc.getCreateDataTableMethod) == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getCreateDataTableMethod = DataTableServiceGrpc.getCreateDataTableMethod) == null) {
          DataTableServiceGrpc.getCreateDataTableMethod =
              getCreateDataTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.CreateDataTableRequest,
                          com.google.cloud.chronicle.v1.DataTable>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.CreateDataTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DataTable.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("CreateDataTable"))
                      .build();
        }
      }
    }
    return getCreateDataTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListDataTablesRequest,
          com.google.cloud.chronicle.v1.ListDataTablesResponse>
      getListDataTablesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataTables",
      requestType = com.google.cloud.chronicle.v1.ListDataTablesRequest.class,
      responseType = com.google.cloud.chronicle.v1.ListDataTablesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListDataTablesRequest,
          com.google.cloud.chronicle.v1.ListDataTablesResponse>
      getListDataTablesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ListDataTablesRequest,
            com.google.cloud.chronicle.v1.ListDataTablesResponse>
        getListDataTablesMethod;
    if ((getListDataTablesMethod = DataTableServiceGrpc.getListDataTablesMethod) == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getListDataTablesMethod = DataTableServiceGrpc.getListDataTablesMethod) == null) {
          DataTableServiceGrpc.getListDataTablesMethod =
              getListDataTablesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ListDataTablesRequest,
                          com.google.cloud.chronicle.v1.ListDataTablesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataTables"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListDataTablesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListDataTablesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("ListDataTables"))
                      .build();
        }
      }
    }
    return getListDataTablesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetDataTableRequest,
          com.google.cloud.chronicle.v1.DataTable>
      getGetDataTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataTable",
      requestType = com.google.cloud.chronicle.v1.GetDataTableRequest.class,
      responseType = com.google.cloud.chronicle.v1.DataTable.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetDataTableRequest,
          com.google.cloud.chronicle.v1.DataTable>
      getGetDataTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GetDataTableRequest,
            com.google.cloud.chronicle.v1.DataTable>
        getGetDataTableMethod;
    if ((getGetDataTableMethod = DataTableServiceGrpc.getGetDataTableMethod) == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getGetDataTableMethod = DataTableServiceGrpc.getGetDataTableMethod) == null) {
          DataTableServiceGrpc.getGetDataTableMethod =
              getGetDataTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GetDataTableRequest,
                          com.google.cloud.chronicle.v1.DataTable>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GetDataTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DataTable.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("GetDataTable"))
                      .build();
        }
      }
    }
    return getGetDataTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateDataTableRequest,
          com.google.cloud.chronicle.v1.DataTable>
      getUpdateDataTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataTable",
      requestType = com.google.cloud.chronicle.v1.UpdateDataTableRequest.class,
      responseType = com.google.cloud.chronicle.v1.DataTable.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateDataTableRequest,
          com.google.cloud.chronicle.v1.DataTable>
      getUpdateDataTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.UpdateDataTableRequest,
            com.google.cloud.chronicle.v1.DataTable>
        getUpdateDataTableMethod;
    if ((getUpdateDataTableMethod = DataTableServiceGrpc.getUpdateDataTableMethod) == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getUpdateDataTableMethod = DataTableServiceGrpc.getUpdateDataTableMethod) == null) {
          DataTableServiceGrpc.getUpdateDataTableMethod =
              getUpdateDataTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.UpdateDataTableRequest,
                          com.google.cloud.chronicle.v1.DataTable>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.UpdateDataTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DataTable.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("UpdateDataTable"))
                      .build();
        }
      }
    }
    return getUpdateDataTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DeleteDataTableRequest, com.google.protobuf.Empty>
      getDeleteDataTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataTable",
      requestType = com.google.cloud.chronicle.v1.DeleteDataTableRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DeleteDataTableRequest, com.google.protobuf.Empty>
      getDeleteDataTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.DeleteDataTableRequest, com.google.protobuf.Empty>
        getDeleteDataTableMethod;
    if ((getDeleteDataTableMethod = DataTableServiceGrpc.getDeleteDataTableMethod) == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getDeleteDataTableMethod = DataTableServiceGrpc.getDeleteDataTableMethod) == null) {
          DataTableServiceGrpc.getDeleteDataTableMethod =
              getDeleteDataTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.DeleteDataTableRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DeleteDataTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("DeleteDataTable"))
                      .build();
        }
      }
    }
    return getDeleteDataTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.CreateDataTableRowRequest,
          com.google.cloud.chronicle.v1.DataTableRow>
      getCreateDataTableRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataTableRow",
      requestType = com.google.cloud.chronicle.v1.CreateDataTableRowRequest.class,
      responseType = com.google.cloud.chronicle.v1.DataTableRow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.CreateDataTableRowRequest,
          com.google.cloud.chronicle.v1.DataTableRow>
      getCreateDataTableRowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.CreateDataTableRowRequest,
            com.google.cloud.chronicle.v1.DataTableRow>
        getCreateDataTableRowMethod;
    if ((getCreateDataTableRowMethod = DataTableServiceGrpc.getCreateDataTableRowMethod) == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getCreateDataTableRowMethod = DataTableServiceGrpc.getCreateDataTableRowMethod)
            == null) {
          DataTableServiceGrpc.getCreateDataTableRowMethod =
              getCreateDataTableRowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.CreateDataTableRowRequest,
                          com.google.cloud.chronicle.v1.DataTableRow>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataTableRow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.CreateDataTableRowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DataTableRow.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("CreateDataTableRow"))
                      .build();
        }
      }
    }
    return getCreateDataTableRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateDataTableRowRequest,
          com.google.cloud.chronicle.v1.DataTableRow>
      getUpdateDataTableRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataTableRow",
      requestType = com.google.cloud.chronicle.v1.UpdateDataTableRowRequest.class,
      responseType = com.google.cloud.chronicle.v1.DataTableRow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateDataTableRowRequest,
          com.google.cloud.chronicle.v1.DataTableRow>
      getUpdateDataTableRowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.UpdateDataTableRowRequest,
            com.google.cloud.chronicle.v1.DataTableRow>
        getUpdateDataTableRowMethod;
    if ((getUpdateDataTableRowMethod = DataTableServiceGrpc.getUpdateDataTableRowMethod) == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getUpdateDataTableRowMethod = DataTableServiceGrpc.getUpdateDataTableRowMethod)
            == null) {
          DataTableServiceGrpc.getUpdateDataTableRowMethod =
              getUpdateDataTableRowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.UpdateDataTableRowRequest,
                          com.google.cloud.chronicle.v1.DataTableRow>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataTableRow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.UpdateDataTableRowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DataTableRow.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("UpdateDataTableRow"))
                      .build();
        }
      }
    }
    return getUpdateDataTableRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListDataTableRowsRequest,
          com.google.cloud.chronicle.v1.ListDataTableRowsResponse>
      getListDataTableRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataTableRows",
      requestType = com.google.cloud.chronicle.v1.ListDataTableRowsRequest.class,
      responseType = com.google.cloud.chronicle.v1.ListDataTableRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListDataTableRowsRequest,
          com.google.cloud.chronicle.v1.ListDataTableRowsResponse>
      getListDataTableRowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ListDataTableRowsRequest,
            com.google.cloud.chronicle.v1.ListDataTableRowsResponse>
        getListDataTableRowsMethod;
    if ((getListDataTableRowsMethod = DataTableServiceGrpc.getListDataTableRowsMethod) == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getListDataTableRowsMethod = DataTableServiceGrpc.getListDataTableRowsMethod)
            == null) {
          DataTableServiceGrpc.getListDataTableRowsMethod =
              getListDataTableRowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ListDataTableRowsRequest,
                          com.google.cloud.chronicle.v1.ListDataTableRowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataTableRows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListDataTableRowsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListDataTableRowsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("ListDataTableRows"))
                      .build();
        }
      }
    }
    return getListDataTableRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetDataTableRowRequest,
          com.google.cloud.chronicle.v1.DataTableRow>
      getGetDataTableRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataTableRow",
      requestType = com.google.cloud.chronicle.v1.GetDataTableRowRequest.class,
      responseType = com.google.cloud.chronicle.v1.DataTableRow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetDataTableRowRequest,
          com.google.cloud.chronicle.v1.DataTableRow>
      getGetDataTableRowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GetDataTableRowRequest,
            com.google.cloud.chronicle.v1.DataTableRow>
        getGetDataTableRowMethod;
    if ((getGetDataTableRowMethod = DataTableServiceGrpc.getGetDataTableRowMethod) == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getGetDataTableRowMethod = DataTableServiceGrpc.getGetDataTableRowMethod) == null) {
          DataTableServiceGrpc.getGetDataTableRowMethod =
              getGetDataTableRowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GetDataTableRowRequest,
                          com.google.cloud.chronicle.v1.DataTableRow>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataTableRow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GetDataTableRowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DataTableRow.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("GetDataTableRow"))
                      .build();
        }
      }
    }
    return getGetDataTableRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DeleteDataTableRowRequest, com.google.protobuf.Empty>
      getDeleteDataTableRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataTableRow",
      requestType = com.google.cloud.chronicle.v1.DeleteDataTableRowRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.DeleteDataTableRowRequest, com.google.protobuf.Empty>
      getDeleteDataTableRowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.DeleteDataTableRowRequest, com.google.protobuf.Empty>
        getDeleteDataTableRowMethod;
    if ((getDeleteDataTableRowMethod = DataTableServiceGrpc.getDeleteDataTableRowMethod) == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getDeleteDataTableRowMethod = DataTableServiceGrpc.getDeleteDataTableRowMethod)
            == null) {
          DataTableServiceGrpc.getDeleteDataTableRowMethod =
              getDeleteDataTableRowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.DeleteDataTableRowRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataTableRow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DeleteDataTableRowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("DeleteDataTableRow"))
                      .build();
        }
      }
    }
    return getDeleteDataTableRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest,
          com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse>
      getBulkCreateDataTableRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkCreateDataTableRows",
      requestType = com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest.class,
      responseType = com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest,
          com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse>
      getBulkCreateDataTableRowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest,
            com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse>
        getBulkCreateDataTableRowsMethod;
    if ((getBulkCreateDataTableRowsMethod = DataTableServiceGrpc.getBulkCreateDataTableRowsMethod)
        == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getBulkCreateDataTableRowsMethod =
                DataTableServiceGrpc.getBulkCreateDataTableRowsMethod)
            == null) {
          DataTableServiceGrpc.getBulkCreateDataTableRowsMethod =
              getBulkCreateDataTableRowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest,
                          com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BulkCreateDataTableRows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("BulkCreateDataTableRows"))
                      .build();
        }
      }
    }
    return getBulkCreateDataTableRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest,
          com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse>
      getBulkGetDataTableRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkGetDataTableRows",
      requestType = com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest.class,
      responseType = com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest,
          com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse>
      getBulkGetDataTableRowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest,
            com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse>
        getBulkGetDataTableRowsMethod;
    if ((getBulkGetDataTableRowsMethod = DataTableServiceGrpc.getBulkGetDataTableRowsMethod)
        == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getBulkGetDataTableRowsMethod = DataTableServiceGrpc.getBulkGetDataTableRowsMethod)
            == null) {
          DataTableServiceGrpc.getBulkGetDataTableRowsMethod =
              getBulkGetDataTableRowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest,
                          com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BulkGetDataTableRows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("BulkGetDataTableRows"))
                      .build();
        }
      }
    }
    return getBulkGetDataTableRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest,
          com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse>
      getBulkReplaceDataTableRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkReplaceDataTableRows",
      requestType = com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest.class,
      responseType = com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest,
          com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse>
      getBulkReplaceDataTableRowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest,
            com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse>
        getBulkReplaceDataTableRowsMethod;
    if ((getBulkReplaceDataTableRowsMethod = DataTableServiceGrpc.getBulkReplaceDataTableRowsMethod)
        == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getBulkReplaceDataTableRowsMethod =
                DataTableServiceGrpc.getBulkReplaceDataTableRowsMethod)
            == null) {
          DataTableServiceGrpc.getBulkReplaceDataTableRowsMethod =
              getBulkReplaceDataTableRowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest,
                          com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BulkReplaceDataTableRows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("BulkReplaceDataTableRows"))
                      .build();
        }
      }
    }
    return getBulkReplaceDataTableRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest,
          com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse>
      getBulkUpdateDataTableRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkUpdateDataTableRows",
      requestType = com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest.class,
      responseType = com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest,
          com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse>
      getBulkUpdateDataTableRowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest,
            com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse>
        getBulkUpdateDataTableRowsMethod;
    if ((getBulkUpdateDataTableRowsMethod = DataTableServiceGrpc.getBulkUpdateDataTableRowsMethod)
        == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getBulkUpdateDataTableRowsMethod =
                DataTableServiceGrpc.getBulkUpdateDataTableRowsMethod)
            == null) {
          DataTableServiceGrpc.getBulkUpdateDataTableRowsMethod =
              getBulkUpdateDataTableRowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest,
                          com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BulkUpdateDataTableRows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier("BulkUpdateDataTableRows"))
                      .build();
        }
      }
    }
    return getBulkUpdateDataTableRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest,
          com.google.cloud.chronicle.v1.DataTableOperationErrors>
      getGetDataTableOperationErrorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataTableOperationErrors",
      requestType = com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest.class,
      responseType = com.google.cloud.chronicle.v1.DataTableOperationErrors.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest,
          com.google.cloud.chronicle.v1.DataTableOperationErrors>
      getGetDataTableOperationErrorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest,
            com.google.cloud.chronicle.v1.DataTableOperationErrors>
        getGetDataTableOperationErrorsMethod;
    if ((getGetDataTableOperationErrorsMethod =
            DataTableServiceGrpc.getGetDataTableOperationErrorsMethod)
        == null) {
      synchronized (DataTableServiceGrpc.class) {
        if ((getGetDataTableOperationErrorsMethod =
                DataTableServiceGrpc.getGetDataTableOperationErrorsMethod)
            == null) {
          DataTableServiceGrpc.getGetDataTableOperationErrorsMethod =
              getGetDataTableOperationErrorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest,
                          com.google.cloud.chronicle.v1.DataTableOperationErrors>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDataTableOperationErrors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.DataTableOperationErrors
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTableServiceMethodDescriptorSupplier(
                              "GetDataTableOperationErrors"))
                      .build();
        }
      }
    }
    return getGetDataTableOperationErrorsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataTableServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTableServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTableServiceStub>() {
          @java.lang.Override
          public DataTableServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTableServiceStub(channel, callOptions);
          }
        };
    return DataTableServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DataTableServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTableServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTableServiceBlockingV2Stub>() {
          @java.lang.Override
          public DataTableServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTableServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DataTableServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataTableServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTableServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTableServiceBlockingStub>() {
          @java.lang.Override
          public DataTableServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTableServiceBlockingStub(channel, callOptions);
          }
        };
    return DataTableServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataTableServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTableServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTableServiceFutureStub>() {
          @java.lang.Override
          public DataTableServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTableServiceFutureStub(channel, callOptions);
          }
        };
    return DataTableServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * DataTableManager provides an interface for managing data tables.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create a new data table.
     * </pre>
     */
    default void createDataTable(
        com.google.cloud.chronicle.v1.CreateDataTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTable> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List data tables.
     * </pre>
     */
    default void listDataTables(
        com.google.cloud.chronicle.v1.ListDataTablesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListDataTablesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataTablesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get data table info.
     * </pre>
     */
    default void getDataTable(
        com.google.cloud.chronicle.v1.GetDataTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTable> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update data table.
     * </pre>
     */
    default void updateDataTable(
        com.google.cloud.chronicle.v1.UpdateDataTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTable> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete data table.
     * </pre>
     */
    default void deleteDataTable(
        com.google.cloud.chronicle.v1.DeleteDataTableRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new data table row.
     * </pre>
     */
    default void createDataTableRow(
        com.google.cloud.chronicle.v1.CreateDataTableRowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTableRow> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataTableRowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update data table row
     * </pre>
     */
    default void updateDataTableRow(
        com.google.cloud.chronicle.v1.UpdateDataTableRowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTableRow> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataTableRowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List data table rows.
     * </pre>
     */
    default void listDataTableRows(
        com.google.cloud.chronicle.v1.ListDataTableRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListDataTableRowsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataTableRowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get data table row
     * </pre>
     */
    default void getDataTableRow(
        com.google.cloud.chronicle.v1.GetDataTableRowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTableRow> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataTableRowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete data table row.
     * </pre>
     */
    default void deleteDataTableRow(
        com.google.cloud.chronicle.v1.DeleteDataTableRowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataTableRowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create data table rows in bulk.
     * </pre>
     */
    default void bulkCreateDataTableRows(
        com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBulkCreateDataTableRowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get data table rows in bulk.
     * </pre>
     */
    default void bulkGetDataTableRows(
        com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBulkGetDataTableRowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Replace all existing data table rows with new data table rows.
     * </pre>
     */
    default void bulkReplaceDataTableRows(
        com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBulkReplaceDataTableRowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update data table rows in bulk.
     * </pre>
     */
    default void bulkUpdateDataTableRows(
        com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBulkUpdateDataTableRowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the error for a data table operation.
     * </pre>
     */
    default void getDataTableOperationErrors(
        com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTableOperationErrors>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataTableOperationErrorsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataTableService.
   *
   * <pre>
   * DataTableManager provides an interface for managing data tables.
   * </pre>
   */
  public abstract static class DataTableServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataTableServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataTableService.
   *
   * <pre>
   * DataTableManager provides an interface for managing data tables.
   * </pre>
   */
  public static final class DataTableServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataTableServiceStub> {
    private DataTableServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTableServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTableServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a new data table.
     * </pre>
     */
    public void createDataTable(
        com.google.cloud.chronicle.v1.CreateDataTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTable> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List data tables.
     * </pre>
     */
    public void listDataTables(
        com.google.cloud.chronicle.v1.ListDataTablesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListDataTablesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataTablesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get data table info.
     * </pre>
     */
    public void getDataTable(
        com.google.cloud.chronicle.v1.GetDataTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTable> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update data table.
     * </pre>
     */
    public void updateDataTable(
        com.google.cloud.chronicle.v1.UpdateDataTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTable> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete data table.
     * </pre>
     */
    public void deleteDataTable(
        com.google.cloud.chronicle.v1.DeleteDataTableRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new data table row.
     * </pre>
     */
    public void createDataTableRow(
        com.google.cloud.chronicle.v1.CreateDataTableRowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTableRow> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataTableRowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update data table row
     * </pre>
     */
    public void updateDataTableRow(
        com.google.cloud.chronicle.v1.UpdateDataTableRowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTableRow> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataTableRowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List data table rows.
     * </pre>
     */
    public void listDataTableRows(
        com.google.cloud.chronicle.v1.ListDataTableRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListDataTableRowsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataTableRowsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get data table row
     * </pre>
     */
    public void getDataTableRow(
        com.google.cloud.chronicle.v1.GetDataTableRowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTableRow> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataTableRowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete data table row.
     * </pre>
     */
    public void deleteDataTableRow(
        com.google.cloud.chronicle.v1.DeleteDataTableRowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataTableRowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create data table rows in bulk.
     * </pre>
     */
    public void bulkCreateDataTableRows(
        com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBulkCreateDataTableRowsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get data table rows in bulk.
     * </pre>
     */
    public void bulkGetDataTableRows(
        com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBulkGetDataTableRowsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Replace all existing data table rows with new data table rows.
     * </pre>
     */
    public void bulkReplaceDataTableRows(
        com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBulkReplaceDataTableRowsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update data table rows in bulk.
     * </pre>
     */
    public void bulkUpdateDataTableRows(
        com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBulkUpdateDataTableRowsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the error for a data table operation.
     * </pre>
     */
    public void getDataTableOperationErrors(
        com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTableOperationErrors>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataTableOperationErrorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataTableService.
   *
   * <pre>
   * DataTableManager provides an interface for managing data tables.
   * </pre>
   */
  public static final class DataTableServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DataTableServiceBlockingV2Stub> {
    private DataTableServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTableServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTableServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a new data table.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTable createDataTable(
        com.google.cloud.chronicle.v1.CreateDataTableRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateDataTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List data tables.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListDataTablesResponse listDataTables(
        com.google.cloud.chronicle.v1.ListDataTablesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDataTablesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get data table info.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTable getDataTable(
        com.google.cloud.chronicle.v1.GetDataTableRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDataTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update data table.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTable updateDataTable(
        com.google.cloud.chronicle.v1.UpdateDataTableRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateDataTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete data table.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataTable(
        com.google.cloud.chronicle.v1.DeleteDataTableRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteDataTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new data table row.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTableRow createDataTableRow(
        com.google.cloud.chronicle.v1.CreateDataTableRowRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateDataTableRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update data table row
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTableRow updateDataTableRow(
        com.google.cloud.chronicle.v1.UpdateDataTableRowRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateDataTableRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List data table rows.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListDataTableRowsResponse listDataTableRows(
        com.google.cloud.chronicle.v1.ListDataTableRowsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDataTableRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get data table row
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTableRow getDataTableRow(
        com.google.cloud.chronicle.v1.GetDataTableRowRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDataTableRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete data table row.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataTableRow(
        com.google.cloud.chronicle.v1.DeleteDataTableRowRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteDataTableRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create data table rows in bulk.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse bulkCreateDataTableRows(
        com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBulkCreateDataTableRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get data table rows in bulk.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse bulkGetDataTableRows(
        com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBulkGetDataTableRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Replace all existing data table rows with new data table rows.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse bulkReplaceDataTableRows(
        com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBulkReplaceDataTableRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update data table rows in bulk.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse bulkUpdateDataTableRows(
        com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBulkUpdateDataTableRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get the error for a data table operation.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTableOperationErrors getDataTableOperationErrors(
        com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDataTableOperationErrorsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DataTableService.
   *
   * <pre>
   * DataTableManager provides an interface for managing data tables.
   * </pre>
   */
  public static final class DataTableServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataTableServiceBlockingStub> {
    private DataTableServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTableServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTableServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a new data table.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTable createDataTable(
        com.google.cloud.chronicle.v1.CreateDataTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List data tables.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListDataTablesResponse listDataTables(
        com.google.cloud.chronicle.v1.ListDataTablesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataTablesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get data table info.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTable getDataTable(
        com.google.cloud.chronicle.v1.GetDataTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update data table.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTable updateDataTable(
        com.google.cloud.chronicle.v1.UpdateDataTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete data table.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataTable(
        com.google.cloud.chronicle.v1.DeleteDataTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new data table row.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTableRow createDataTableRow(
        com.google.cloud.chronicle.v1.CreateDataTableRowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataTableRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update data table row
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTableRow updateDataTableRow(
        com.google.cloud.chronicle.v1.UpdateDataTableRowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataTableRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List data table rows.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListDataTableRowsResponse listDataTableRows(
        com.google.cloud.chronicle.v1.ListDataTableRowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataTableRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get data table row
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTableRow getDataTableRow(
        com.google.cloud.chronicle.v1.GetDataTableRowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataTableRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete data table row.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataTableRow(
        com.google.cloud.chronicle.v1.DeleteDataTableRowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataTableRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create data table rows in bulk.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse bulkCreateDataTableRows(
        com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkCreateDataTableRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get data table rows in bulk.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse bulkGetDataTableRows(
        com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkGetDataTableRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Replace all existing data table rows with new data table rows.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse bulkReplaceDataTableRows(
        com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkReplaceDataTableRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update data table rows in bulk.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse bulkUpdateDataTableRows(
        com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkUpdateDataTableRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get the error for a data table operation.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.DataTableOperationErrors getDataTableOperationErrors(
        com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataTableOperationErrorsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataTableService.
   *
   * <pre>
   * DataTableManager provides an interface for managing data tables.
   * </pre>
   */
  public static final class DataTableServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataTableServiceFutureStub> {
    private DataTableServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTableServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTableServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a new data table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.DataTable>
        createDataTable(com.google.cloud.chronicle.v1.CreateDataTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List data tables.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ListDataTablesResponse>
        listDataTables(com.google.cloud.chronicle.v1.ListDataTablesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataTablesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get data table info.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.DataTable>
        getDataTable(com.google.cloud.chronicle.v1.GetDataTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update data table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.DataTable>
        updateDataTable(com.google.cloud.chronicle.v1.UpdateDataTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete data table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDataTable(com.google.cloud.chronicle.v1.DeleteDataTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new data table row.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.DataTableRow>
        createDataTableRow(com.google.cloud.chronicle.v1.CreateDataTableRowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataTableRowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update data table row
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.DataTableRow>
        updateDataTableRow(com.google.cloud.chronicle.v1.UpdateDataTableRowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataTableRowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List data table rows.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ListDataTableRowsResponse>
        listDataTableRows(com.google.cloud.chronicle.v1.ListDataTableRowsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataTableRowsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get data table row
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.DataTableRow>
        getDataTableRow(com.google.cloud.chronicle.v1.GetDataTableRowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataTableRowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete data table row.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDataTableRow(com.google.cloud.chronicle.v1.DeleteDataTableRowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataTableRowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create data table rows in bulk.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse>
        bulkCreateDataTableRows(
            com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBulkCreateDataTableRowsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get data table rows in bulk.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse>
        bulkGetDataTableRows(com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBulkGetDataTableRowsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Replace all existing data table rows with new data table rows.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse>
        bulkReplaceDataTableRows(
            com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBulkReplaceDataTableRowsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update data table rows in bulk.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse>
        bulkUpdateDataTableRows(
            com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBulkUpdateDataTableRowsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get the error for a data table operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.DataTableOperationErrors>
        getDataTableOperationErrors(
            com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataTableOperationErrorsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DATA_TABLE = 0;
  private static final int METHODID_LIST_DATA_TABLES = 1;
  private static final int METHODID_GET_DATA_TABLE = 2;
  private static final int METHODID_UPDATE_DATA_TABLE = 3;
  private static final int METHODID_DELETE_DATA_TABLE = 4;
  private static final int METHODID_CREATE_DATA_TABLE_ROW = 5;
  private static final int METHODID_UPDATE_DATA_TABLE_ROW = 6;
  private static final int METHODID_LIST_DATA_TABLE_ROWS = 7;
  private static final int METHODID_GET_DATA_TABLE_ROW = 8;
  private static final int METHODID_DELETE_DATA_TABLE_ROW = 9;
  private static final int METHODID_BULK_CREATE_DATA_TABLE_ROWS = 10;
  private static final int METHODID_BULK_GET_DATA_TABLE_ROWS = 11;
  private static final int METHODID_BULK_REPLACE_DATA_TABLE_ROWS = 12;
  private static final int METHODID_BULK_UPDATE_DATA_TABLE_ROWS = 13;
  private static final int METHODID_GET_DATA_TABLE_OPERATION_ERRORS = 14;

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
        case METHODID_CREATE_DATA_TABLE:
          serviceImpl.createDataTable(
              (com.google.cloud.chronicle.v1.CreateDataTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTable>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_TABLES:
          serviceImpl.listDataTables(
              (com.google.cloud.chronicle.v1.ListDataTablesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListDataTablesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_TABLE:
          serviceImpl.getDataTable(
              (com.google.cloud.chronicle.v1.GetDataTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTable>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_TABLE:
          serviceImpl.updateDataTable(
              (com.google.cloud.chronicle.v1.UpdateDataTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTable>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATA_TABLE:
          serviceImpl.deleteDataTable(
              (com.google.cloud.chronicle.v1.DeleteDataTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_DATA_TABLE_ROW:
          serviceImpl.createDataTableRow(
              (com.google.cloud.chronicle.v1.CreateDataTableRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTableRow>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_TABLE_ROW:
          serviceImpl.updateDataTableRow(
              (com.google.cloud.chronicle.v1.UpdateDataTableRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTableRow>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_TABLE_ROWS:
          serviceImpl.listDataTableRows(
              (com.google.cloud.chronicle.v1.ListDataTableRowsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListDataTableRowsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_TABLE_ROW:
          serviceImpl.getDataTableRow(
              (com.google.cloud.chronicle.v1.GetDataTableRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTableRow>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATA_TABLE_ROW:
          serviceImpl.deleteDataTableRow(
              (com.google.cloud.chronicle.v1.DeleteDataTableRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BULK_CREATE_DATA_TABLE_ROWS:
          serviceImpl.bulkCreateDataTableRows(
              (com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse>)
                  responseObserver);
          break;
        case METHODID_BULK_GET_DATA_TABLE_ROWS:
          serviceImpl.bulkGetDataTableRows(
              (com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse>)
                  responseObserver);
          break;
        case METHODID_BULK_REPLACE_DATA_TABLE_ROWS:
          serviceImpl.bulkReplaceDataTableRows(
              (com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse>)
                  responseObserver);
          break;
        case METHODID_BULK_UPDATE_DATA_TABLE_ROWS:
          serviceImpl.bulkUpdateDataTableRows(
              (com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_TABLE_OPERATION_ERRORS:
          serviceImpl.getDataTableOperationErrors(
              (com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.DataTableOperationErrors>)
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
            getCreateDataTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.CreateDataTableRequest,
                    com.google.cloud.chronicle.v1.DataTable>(service, METHODID_CREATE_DATA_TABLE)))
        .addMethod(
            getListDataTablesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ListDataTablesRequest,
                    com.google.cloud.chronicle.v1.ListDataTablesResponse>(
                    service, METHODID_LIST_DATA_TABLES)))
        .addMethod(
            getGetDataTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GetDataTableRequest,
                    com.google.cloud.chronicle.v1.DataTable>(service, METHODID_GET_DATA_TABLE)))
        .addMethod(
            getUpdateDataTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.UpdateDataTableRequest,
                    com.google.cloud.chronicle.v1.DataTable>(service, METHODID_UPDATE_DATA_TABLE)))
        .addMethod(
            getDeleteDataTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.DeleteDataTableRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DATA_TABLE)))
        .addMethod(
            getCreateDataTableRowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.CreateDataTableRowRequest,
                    com.google.cloud.chronicle.v1.DataTableRow>(
                    service, METHODID_CREATE_DATA_TABLE_ROW)))
        .addMethod(
            getUpdateDataTableRowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.UpdateDataTableRowRequest,
                    com.google.cloud.chronicle.v1.DataTableRow>(
                    service, METHODID_UPDATE_DATA_TABLE_ROW)))
        .addMethod(
            getListDataTableRowsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ListDataTableRowsRequest,
                    com.google.cloud.chronicle.v1.ListDataTableRowsResponse>(
                    service, METHODID_LIST_DATA_TABLE_ROWS)))
        .addMethod(
            getGetDataTableRowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GetDataTableRowRequest,
                    com.google.cloud.chronicle.v1.DataTableRow>(
                    service, METHODID_GET_DATA_TABLE_ROW)))
        .addMethod(
            getDeleteDataTableRowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.DeleteDataTableRowRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DATA_TABLE_ROW)))
        .addMethod(
            getBulkCreateDataTableRowsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest,
                    com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse>(
                    service, METHODID_BULK_CREATE_DATA_TABLE_ROWS)))
        .addMethod(
            getBulkGetDataTableRowsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest,
                    com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse>(
                    service, METHODID_BULK_GET_DATA_TABLE_ROWS)))
        .addMethod(
            getBulkReplaceDataTableRowsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest,
                    com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse>(
                    service, METHODID_BULK_REPLACE_DATA_TABLE_ROWS)))
        .addMethod(
            getBulkUpdateDataTableRowsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest,
                    com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse>(
                    service, METHODID_BULK_UPDATE_DATA_TABLE_ROWS)))
        .addMethod(
            getGetDataTableOperationErrorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest,
                    com.google.cloud.chronicle.v1.DataTableOperationErrors>(
                    service, METHODID_GET_DATA_TABLE_OPERATION_ERRORS)))
        .build();
  }

  private abstract static class DataTableServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataTableServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.chronicle.v1.DataTableProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataTableService");
    }
  }

  private static final class DataTableServiceFileDescriptorSupplier
      extends DataTableServiceBaseDescriptorSupplier {
    DataTableServiceFileDescriptorSupplier() {}
  }

  private static final class DataTableServiceMethodDescriptorSupplier
      extends DataTableServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataTableServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataTableServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataTableServiceFileDescriptorSupplier())
                      .addMethod(getCreateDataTableMethod())
                      .addMethod(getListDataTablesMethod())
                      .addMethod(getGetDataTableMethod())
                      .addMethod(getUpdateDataTableMethod())
                      .addMethod(getDeleteDataTableMethod())
                      .addMethod(getCreateDataTableRowMethod())
                      .addMethod(getUpdateDataTableRowMethod())
                      .addMethod(getListDataTableRowsMethod())
                      .addMethod(getGetDataTableRowMethod())
                      .addMethod(getDeleteDataTableRowMethod())
                      .addMethod(getBulkCreateDataTableRowsMethod())
                      .addMethod(getBulkGetDataTableRowsMethod())
                      .addMethod(getBulkReplaceDataTableRowsMethod())
                      .addMethod(getBulkUpdateDataTableRowsMethod())
                      .addMethod(getGetDataTableOperationErrorsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
