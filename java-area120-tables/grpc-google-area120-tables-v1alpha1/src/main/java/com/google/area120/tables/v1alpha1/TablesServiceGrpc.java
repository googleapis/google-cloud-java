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
package com.google.area120.tables.v1alpha1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * The Tables Service provides an API for reading and updating tables.
 * It defines the following resource model:
 * - The API has a collection of [Table][google.area120.tables.v1alpha1.Table]
 *   resources, named `tables/&#42;`
 * - Each Table has a collection of [Row][google.area120.tables.v1alpha1.Row]
 *   resources, named `tables/&#42;&#47;rows/&#42;`
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/area120/tables/v1alpha1/tables.proto")
public final class TablesServiceGrpc {

  private TablesServiceGrpc() {}

  public static final String SERVICE_NAME = "google.area120.tables.v1alpha1.TablesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.GetTableRequest,
          com.google.area120.tables.v1alpha1.Table>
      getGetTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTable",
      requestType = com.google.area120.tables.v1alpha1.GetTableRequest.class,
      responseType = com.google.area120.tables.v1alpha1.Table.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.GetTableRequest,
          com.google.area120.tables.v1alpha1.Table>
      getGetTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.area120.tables.v1alpha1.GetTableRequest,
            com.google.area120.tables.v1alpha1.Table>
        getGetTableMethod;
    if ((getGetTableMethod = TablesServiceGrpc.getGetTableMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getGetTableMethod = TablesServiceGrpc.getGetTableMethod) == null) {
          TablesServiceGrpc.getGetTableMethod =
              getGetTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.area120.tables.v1alpha1.GetTableRequest,
                          com.google.area120.tables.v1alpha1.Table>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.GetTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.Table.getDefaultInstance()))
                      .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("GetTable"))
                      .build();
        }
      }
    }
    return getGetTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.ListTablesRequest,
          com.google.area120.tables.v1alpha1.ListTablesResponse>
      getListTablesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTables",
      requestType = com.google.area120.tables.v1alpha1.ListTablesRequest.class,
      responseType = com.google.area120.tables.v1alpha1.ListTablesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.ListTablesRequest,
          com.google.area120.tables.v1alpha1.ListTablesResponse>
      getListTablesMethod() {
    io.grpc.MethodDescriptor<
            com.google.area120.tables.v1alpha1.ListTablesRequest,
            com.google.area120.tables.v1alpha1.ListTablesResponse>
        getListTablesMethod;
    if ((getListTablesMethod = TablesServiceGrpc.getListTablesMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getListTablesMethod = TablesServiceGrpc.getListTablesMethod) == null) {
          TablesServiceGrpc.getListTablesMethod =
              getListTablesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.area120.tables.v1alpha1.ListTablesRequest,
                          com.google.area120.tables.v1alpha1.ListTablesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTables"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.ListTablesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.ListTablesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("ListTables"))
                      .build();
        }
      }
    }
    return getListTablesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.GetRowRequest, com.google.area120.tables.v1alpha1.Row>
      getGetRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRow",
      requestType = com.google.area120.tables.v1alpha1.GetRowRequest.class,
      responseType = com.google.area120.tables.v1alpha1.Row.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.GetRowRequest, com.google.area120.tables.v1alpha1.Row>
      getGetRowMethod() {
    io.grpc.MethodDescriptor<
            com.google.area120.tables.v1alpha1.GetRowRequest,
            com.google.area120.tables.v1alpha1.Row>
        getGetRowMethod;
    if ((getGetRowMethod = TablesServiceGrpc.getGetRowMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getGetRowMethod = TablesServiceGrpc.getGetRowMethod) == null) {
          TablesServiceGrpc.getGetRowMethod =
              getGetRowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.area120.tables.v1alpha1.GetRowRequest,
                          com.google.area120.tables.v1alpha1.Row>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.GetRowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.Row.getDefaultInstance()))
                      .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("GetRow"))
                      .build();
        }
      }
    }
    return getGetRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.ListRowsRequest,
          com.google.area120.tables.v1alpha1.ListRowsResponse>
      getListRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRows",
      requestType = com.google.area120.tables.v1alpha1.ListRowsRequest.class,
      responseType = com.google.area120.tables.v1alpha1.ListRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.ListRowsRequest,
          com.google.area120.tables.v1alpha1.ListRowsResponse>
      getListRowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.area120.tables.v1alpha1.ListRowsRequest,
            com.google.area120.tables.v1alpha1.ListRowsResponse>
        getListRowsMethod;
    if ((getListRowsMethod = TablesServiceGrpc.getListRowsMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getListRowsMethod = TablesServiceGrpc.getListRowsMethod) == null) {
          TablesServiceGrpc.getListRowsMethod =
              getListRowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.area120.tables.v1alpha1.ListRowsRequest,
                          com.google.area120.tables.v1alpha1.ListRowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.ListRowsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.ListRowsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("ListRows"))
                      .build();
        }
      }
    }
    return getListRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.CreateRowRequest,
          com.google.area120.tables.v1alpha1.Row>
      getCreateRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRow",
      requestType = com.google.area120.tables.v1alpha1.CreateRowRequest.class,
      responseType = com.google.area120.tables.v1alpha1.Row.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.CreateRowRequest,
          com.google.area120.tables.v1alpha1.Row>
      getCreateRowMethod() {
    io.grpc.MethodDescriptor<
            com.google.area120.tables.v1alpha1.CreateRowRequest,
            com.google.area120.tables.v1alpha1.Row>
        getCreateRowMethod;
    if ((getCreateRowMethod = TablesServiceGrpc.getCreateRowMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getCreateRowMethod = TablesServiceGrpc.getCreateRowMethod) == null) {
          TablesServiceGrpc.getCreateRowMethod =
              getCreateRowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.area120.tables.v1alpha1.CreateRowRequest,
                          com.google.area120.tables.v1alpha1.Row>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.CreateRowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.Row.getDefaultInstance()))
                      .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("CreateRow"))
                      .build();
        }
      }
    }
    return getCreateRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.BatchCreateRowsRequest,
          com.google.area120.tables.v1alpha1.BatchCreateRowsResponse>
      getBatchCreateRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateRows",
      requestType = com.google.area120.tables.v1alpha1.BatchCreateRowsRequest.class,
      responseType = com.google.area120.tables.v1alpha1.BatchCreateRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.BatchCreateRowsRequest,
          com.google.area120.tables.v1alpha1.BatchCreateRowsResponse>
      getBatchCreateRowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.area120.tables.v1alpha1.BatchCreateRowsRequest,
            com.google.area120.tables.v1alpha1.BatchCreateRowsResponse>
        getBatchCreateRowsMethod;
    if ((getBatchCreateRowsMethod = TablesServiceGrpc.getBatchCreateRowsMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getBatchCreateRowsMethod = TablesServiceGrpc.getBatchCreateRowsMethod) == null) {
          TablesServiceGrpc.getBatchCreateRowsMethod =
              getBatchCreateRowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.area120.tables.v1alpha1.BatchCreateRowsRequest,
                          com.google.area120.tables.v1alpha1.BatchCreateRowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchCreateRows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.BatchCreateRowsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.BatchCreateRowsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TablesServiceMethodDescriptorSupplier("BatchCreateRows"))
                      .build();
        }
      }
    }
    return getBatchCreateRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.UpdateRowRequest,
          com.google.area120.tables.v1alpha1.Row>
      getUpdateRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRow",
      requestType = com.google.area120.tables.v1alpha1.UpdateRowRequest.class,
      responseType = com.google.area120.tables.v1alpha1.Row.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.UpdateRowRequest,
          com.google.area120.tables.v1alpha1.Row>
      getUpdateRowMethod() {
    io.grpc.MethodDescriptor<
            com.google.area120.tables.v1alpha1.UpdateRowRequest,
            com.google.area120.tables.v1alpha1.Row>
        getUpdateRowMethod;
    if ((getUpdateRowMethod = TablesServiceGrpc.getUpdateRowMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getUpdateRowMethod = TablesServiceGrpc.getUpdateRowMethod) == null) {
          TablesServiceGrpc.getUpdateRowMethod =
              getUpdateRowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.area120.tables.v1alpha1.UpdateRowRequest,
                          com.google.area120.tables.v1alpha1.Row>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.UpdateRowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.Row.getDefaultInstance()))
                      .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("UpdateRow"))
                      .build();
        }
      }
    }
    return getUpdateRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest,
          com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse>
      getBatchUpdateRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateRows",
      requestType = com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest.class,
      responseType = com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest,
          com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse>
      getBatchUpdateRowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest,
            com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse>
        getBatchUpdateRowsMethod;
    if ((getBatchUpdateRowsMethod = TablesServiceGrpc.getBatchUpdateRowsMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getBatchUpdateRowsMethod = TablesServiceGrpc.getBatchUpdateRowsMethod) == null) {
          TablesServiceGrpc.getBatchUpdateRowsMethod =
              getBatchUpdateRowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest,
                          com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchUpdateRows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TablesServiceMethodDescriptorSupplier("BatchUpdateRows"))
                      .build();
        }
      }
    }
    return getBatchUpdateRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.DeleteRowRequest, com.google.protobuf.Empty>
      getDeleteRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRow",
      requestType = com.google.area120.tables.v1alpha1.DeleteRowRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.area120.tables.v1alpha1.DeleteRowRequest, com.google.protobuf.Empty>
      getDeleteRowMethod() {
    io.grpc.MethodDescriptor<
            com.google.area120.tables.v1alpha1.DeleteRowRequest, com.google.protobuf.Empty>
        getDeleteRowMethod;
    if ((getDeleteRowMethod = TablesServiceGrpc.getDeleteRowMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getDeleteRowMethod = TablesServiceGrpc.getDeleteRowMethod) == null) {
          TablesServiceGrpc.getDeleteRowMethod =
              getDeleteRowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.area120.tables.v1alpha1.DeleteRowRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.area120.tables.v1alpha1.DeleteRowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("DeleteRow"))
                      .build();
        }
      }
    }
    return getDeleteRowMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TablesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TablesServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TablesServiceStub>() {
          @java.lang.Override
          public TablesServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TablesServiceStub(channel, callOptions);
          }
        };
    return TablesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TablesServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TablesServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TablesServiceBlockingStub>() {
          @java.lang.Override
          public TablesServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TablesServiceBlockingStub(channel, callOptions);
          }
        };
    return TablesServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TablesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TablesServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TablesServiceFutureStub>() {
          @java.lang.Override
          public TablesServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TablesServiceFutureStub(channel, callOptions);
          }
        };
    return TablesServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Tables Service provides an API for reading and updating tables.
   * It defines the following resource model:
   * - The API has a collection of [Table][google.area120.tables.v1alpha1.Table]
   *   resources, named `tables/&#42;`
   * - Each Table has a collection of [Row][google.area120.tables.v1alpha1.Row]
   *   resources, named `tables/&#42;&#47;rows/&#42;`
   * </pre>
   */
  public abstract static class TablesServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Gets a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public void getTable(
        com.google.area120.tables.v1alpha1.GetTableRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Table> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists tables for the user.
     * </pre>
     */
    public void listTables(
        com.google.area120.tables.v1alpha1.ListTablesRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListTablesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListTablesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a row. Returns NOT_FOUND if the row does not exist in the table.
     * </pre>
     */
    public void getRow(
        com.google.area120.tables.v1alpha1.GetRowRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists rows in a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public void listRows(
        com.google.area120.tables.v1alpha1.ListRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListRowsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListRowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a row.
     * </pre>
     */
    public void createRow(
        com.google.area120.tables.v1alpha1.CreateRowRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateRowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple rows.
     * </pre>
     */
    public void batchCreateRows(
        com.google.area120.tables.v1alpha1.BatchCreateRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.BatchCreateRowsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getBatchCreateRowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a row.
     * </pre>
     */
    public void updateRow(
        com.google.area120.tables.v1alpha1.UpdateRowRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateRowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates multiple rows.
     * </pre>
     */
    public void batchUpdateRows(
        com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getBatchUpdateRowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a row.
     * </pre>
     */
    public void deleteRow(
        com.google.area120.tables.v1alpha1.DeleteRowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteRowMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetTableMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.area120.tables.v1alpha1.GetTableRequest,
                      com.google.area120.tables.v1alpha1.Table>(this, METHODID_GET_TABLE)))
          .addMethod(
              getListTablesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.area120.tables.v1alpha1.ListTablesRequest,
                      com.google.area120.tables.v1alpha1.ListTablesResponse>(
                      this, METHODID_LIST_TABLES)))
          .addMethod(
              getGetRowMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.area120.tables.v1alpha1.GetRowRequest,
                      com.google.area120.tables.v1alpha1.Row>(this, METHODID_GET_ROW)))
          .addMethod(
              getListRowsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.area120.tables.v1alpha1.ListRowsRequest,
                      com.google.area120.tables.v1alpha1.ListRowsResponse>(
                      this, METHODID_LIST_ROWS)))
          .addMethod(
              getCreateRowMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.area120.tables.v1alpha1.CreateRowRequest,
                      com.google.area120.tables.v1alpha1.Row>(this, METHODID_CREATE_ROW)))
          .addMethod(
              getBatchCreateRowsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.area120.tables.v1alpha1.BatchCreateRowsRequest,
                      com.google.area120.tables.v1alpha1.BatchCreateRowsResponse>(
                      this, METHODID_BATCH_CREATE_ROWS)))
          .addMethod(
              getUpdateRowMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.area120.tables.v1alpha1.UpdateRowRequest,
                      com.google.area120.tables.v1alpha1.Row>(this, METHODID_UPDATE_ROW)))
          .addMethod(
              getBatchUpdateRowsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest,
                      com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse>(
                      this, METHODID_BATCH_UPDATE_ROWS)))
          .addMethod(
              getDeleteRowMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.area120.tables.v1alpha1.DeleteRowRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ROW)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The Tables Service provides an API for reading and updating tables.
   * It defines the following resource model:
   * - The API has a collection of [Table][google.area120.tables.v1alpha1.Table]
   *   resources, named `tables/&#42;`
   * - Each Table has a collection of [Row][google.area120.tables.v1alpha1.Row]
   *   resources, named `tables/&#42;&#47;rows/&#42;`
   * </pre>
   */
  public static final class TablesServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TablesServiceStub> {
    private TablesServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TablesServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TablesServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public void getTable(
        com.google.area120.tables.v1alpha1.GetTableRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Table> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists tables for the user.
     * </pre>
     */
    public void listTables(
        com.google.area120.tables.v1alpha1.ListTablesRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListTablesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTablesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a row. Returns NOT_FOUND if the row does not exist in the table.
     * </pre>
     */
    public void getRow(
        com.google.area120.tables.v1alpha1.GetRowRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists rows in a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public void listRows(
        com.google.area120.tables.v1alpha1.ListRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListRowsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListRowsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a row.
     * </pre>
     */
    public void createRow(
        com.google.area120.tables.v1alpha1.CreateRowRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateRowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple rows.
     * </pre>
     */
    public void batchCreateRows(
        com.google.area120.tables.v1alpha1.BatchCreateRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.BatchCreateRowsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchCreateRowsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a row.
     * </pre>
     */
    public void updateRow(
        com.google.area120.tables.v1alpha1.UpdateRowRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateRowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates multiple rows.
     * </pre>
     */
    public void batchUpdateRows(
        com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchUpdateRowsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a row.
     * </pre>
     */
    public void deleteRow(
        com.google.area120.tables.v1alpha1.DeleteRowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteRowMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The Tables Service provides an API for reading and updating tables.
   * It defines the following resource model:
   * - The API has a collection of [Table][google.area120.tables.v1alpha1.Table]
   *   resources, named `tables/&#42;`
   * - Each Table has a collection of [Row][google.area120.tables.v1alpha1.Row]
   *   resources, named `tables/&#42;&#47;rows/&#42;`
   * </pre>
   */
  public static final class TablesServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TablesServiceBlockingStub> {
    private TablesServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TablesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TablesServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.Table getTable(
        com.google.area120.tables.v1alpha1.GetTableRequest request) {
      return blockingUnaryCall(getChannel(), getGetTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists tables for the user.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.ListTablesResponse listTables(
        com.google.area120.tables.v1alpha1.ListTablesRequest request) {
      return blockingUnaryCall(getChannel(), getListTablesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a row. Returns NOT_FOUND if the row does not exist in the table.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.Row getRow(
        com.google.area120.tables.v1alpha1.GetRowRequest request) {
      return blockingUnaryCall(getChannel(), getGetRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists rows in a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.ListRowsResponse listRows(
        com.google.area120.tables.v1alpha1.ListRowsRequest request) {
      return blockingUnaryCall(getChannel(), getListRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a row.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.Row createRow(
        com.google.area120.tables.v1alpha1.CreateRowRequest request) {
      return blockingUnaryCall(getChannel(), getCreateRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple rows.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.BatchCreateRowsResponse batchCreateRows(
        com.google.area120.tables.v1alpha1.BatchCreateRowsRequest request) {
      return blockingUnaryCall(getChannel(), getBatchCreateRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a row.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.Row updateRow(
        com.google.area120.tables.v1alpha1.UpdateRowRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateRowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates multiple rows.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse batchUpdateRows(
        com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest request) {
      return blockingUnaryCall(getChannel(), getBatchUpdateRowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a row.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRow(
        com.google.area120.tables.v1alpha1.DeleteRowRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteRowMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The Tables Service provides an API for reading and updating tables.
   * It defines the following resource model:
   * - The API has a collection of [Table][google.area120.tables.v1alpha1.Table]
   *   resources, named `tables/&#42;`
   * - Each Table has a collection of [Row][google.area120.tables.v1alpha1.Row]
   *   resources, named `tables/&#42;&#47;rows/&#42;`
   * </pre>
   */
  public static final class TablesServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TablesServiceFutureStub> {
    private TablesServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TablesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TablesServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.area120.tables.v1alpha1.Table>
        getTable(com.google.area120.tables.v1alpha1.GetTableRequest request) {
      return futureUnaryCall(getChannel().newCall(getGetTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists tables for the user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.area120.tables.v1alpha1.ListTablesResponse>
        listTables(com.google.area120.tables.v1alpha1.ListTablesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTablesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a row. Returns NOT_FOUND if the row does not exist in the table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.area120.tables.v1alpha1.Row>
        getRow(com.google.area120.tables.v1alpha1.GetRowRequest request) {
      return futureUnaryCall(getChannel().newCall(getGetRowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists rows in a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.area120.tables.v1alpha1.ListRowsResponse>
        listRows(com.google.area120.tables.v1alpha1.ListRowsRequest request) {
      return futureUnaryCall(getChannel().newCall(getListRowsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a row.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.area120.tables.v1alpha1.Row>
        createRow(com.google.area120.tables.v1alpha1.CreateRowRequest request) {
      return futureUnaryCall(getChannel().newCall(getCreateRowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates multiple rows.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.area120.tables.v1alpha1.BatchCreateRowsResponse>
        batchCreateRows(com.google.area120.tables.v1alpha1.BatchCreateRowsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchCreateRowsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a row.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.area120.tables.v1alpha1.Row>
        updateRow(com.google.area120.tables.v1alpha1.UpdateRowRequest request) {
      return futureUnaryCall(getChannel().newCall(getUpdateRowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates multiple rows.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse>
        batchUpdateRows(com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchUpdateRowsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a row.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteRow(
        com.google.area120.tables.v1alpha1.DeleteRowRequest request) {
      return futureUnaryCall(getChannel().newCall(getDeleteRowMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TABLE = 0;
  private static final int METHODID_LIST_TABLES = 1;
  private static final int METHODID_GET_ROW = 2;
  private static final int METHODID_LIST_ROWS = 3;
  private static final int METHODID_CREATE_ROW = 4;
  private static final int METHODID_BATCH_CREATE_ROWS = 5;
  private static final int METHODID_UPDATE_ROW = 6;
  private static final int METHODID_BATCH_UPDATE_ROWS = 7;
  private static final int METHODID_DELETE_ROW = 8;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TablesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TablesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TABLE:
          serviceImpl.getTable(
              (com.google.area120.tables.v1alpha1.GetTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Table>)
                  responseObserver);
          break;
        case METHODID_LIST_TABLES:
          serviceImpl.listTables(
              (com.google.area120.tables.v1alpha1.ListTablesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListTablesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ROW:
          serviceImpl.getRow(
              (com.google.area120.tables.v1alpha1.GetRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row>)
                  responseObserver);
          break;
        case METHODID_LIST_ROWS:
          serviceImpl.listRows(
              (com.google.area120.tables.v1alpha1.ListRowsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListRowsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_ROW:
          serviceImpl.createRow(
              (com.google.area120.tables.v1alpha1.CreateRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row>)
                  responseObserver);
          break;
        case METHODID_BATCH_CREATE_ROWS:
          serviceImpl.batchCreateRows(
              (com.google.area120.tables.v1alpha1.BatchCreateRowsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.area120.tables.v1alpha1.BatchCreateRowsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ROW:
          serviceImpl.updateRow(
              (com.google.area120.tables.v1alpha1.UpdateRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row>)
                  responseObserver);
          break;
        case METHODID_BATCH_UPDATE_ROWS:
          serviceImpl.batchUpdateRows(
              (com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ROW:
          serviceImpl.deleteRow(
              (com.google.area120.tables.v1alpha1.DeleteRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private abstract static class TablesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TablesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.area120.tables.v1alpha1.TablesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TablesService");
    }
  }

  private static final class TablesServiceFileDescriptorSupplier
      extends TablesServiceBaseDescriptorSupplier {
    TablesServiceFileDescriptorSupplier() {}
  }

  private static final class TablesServiceMethodDescriptorSupplier
      extends TablesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TablesServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TablesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TablesServiceFileDescriptorSupplier())
                      .addMethod(getGetTableMethod())
                      .addMethod(getListTablesMethod())
                      .addMethod(getGetRowMethod())
                      .addMethod(getListRowsMethod())
                      .addMethod(getCreateRowMethod())
                      .addMethod(getBatchCreateRowsMethod())
                      .addMethod(getUpdateRowMethod())
                      .addMethod(getBatchUpdateRowsMethod())
                      .addMethod(getDeleteRowMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
