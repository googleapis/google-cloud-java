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
package com.google.cloud.bigquery.datatransfer.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/** */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/datatransfer/v1/datatransfer.proto")
public final class DataTransferServiceGrpc {

  private DataTransferServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.bigquery.datatransfer.v1.DataTransferService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest,
          com.google.cloud.bigquery.datatransfer.v1.DataSource>
      getGetDataSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataSource",
      requestType = com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.DataSource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest,
          com.google.cloud.bigquery.datatransfer.v1.DataSource>
      getGetDataSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest,
            com.google.cloud.bigquery.datatransfer.v1.DataSource>
        getGetDataSourceMethod;
    if ((getGetDataSourceMethod = DataTransferServiceGrpc.getGetDataSourceMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getGetDataSourceMethod = DataTransferServiceGrpc.getGetDataSourceMethod) == null) {
          DataTransferServiceGrpc.getGetDataSourceMethod =
              getGetDataSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest,
                          com.google.cloud.bigquery.datatransfer.v1.DataSource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.DataSource
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("GetDataSource"))
                      .build();
        }
      }
    }
    return getGetDataSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest,
          com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>
      getListDataSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataSources",
      requestType = com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest,
          com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>
      getListDataSourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest,
            com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>
        getListDataSourcesMethod;
    if ((getListDataSourcesMethod = DataTransferServiceGrpc.getListDataSourcesMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListDataSourcesMethod = DataTransferServiceGrpc.getListDataSourcesMethod) == null) {
          DataTransferServiceGrpc.getListDataSourcesMethod =
              getListDataSourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest,
                          com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataSources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("ListDataSources"))
                      .build();
        }
      }
    }
    return getListDataSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest,
          com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
      getCreateTransferConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTransferConfig",
      requestType = com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.TransferConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest,
          com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
      getCreateTransferConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest,
            com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
        getCreateTransferConfigMethod;
    if ((getCreateTransferConfigMethod = DataTransferServiceGrpc.getCreateTransferConfigMethod)
        == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getCreateTransferConfigMethod = DataTransferServiceGrpc.getCreateTransferConfigMethod)
            == null) {
          DataTransferServiceGrpc.getCreateTransferConfigMethod =
              getCreateTransferConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest,
                          com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateTransferConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.TransferConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("CreateTransferConfig"))
                      .build();
        }
      }
    }
    return getCreateTransferConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest,
          com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
      getUpdateTransferConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTransferConfig",
      requestType = com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.TransferConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest,
          com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
      getUpdateTransferConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest,
            com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
        getUpdateTransferConfigMethod;
    if ((getUpdateTransferConfigMethod = DataTransferServiceGrpc.getUpdateTransferConfigMethod)
        == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getUpdateTransferConfigMethod = DataTransferServiceGrpc.getUpdateTransferConfigMethod)
            == null) {
          DataTransferServiceGrpc.getUpdateTransferConfigMethod =
              getUpdateTransferConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest,
                          com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateTransferConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.TransferConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("UpdateTransferConfig"))
                      .build();
        }
      }
    }
    return getUpdateTransferConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest,
          com.google.protobuf.Empty>
      getDeleteTransferConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTransferConfig",
      requestType = com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest,
          com.google.protobuf.Empty>
      getDeleteTransferConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest,
            com.google.protobuf.Empty>
        getDeleteTransferConfigMethod;
    if ((getDeleteTransferConfigMethod = DataTransferServiceGrpc.getDeleteTransferConfigMethod)
        == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getDeleteTransferConfigMethod = DataTransferServiceGrpc.getDeleteTransferConfigMethod)
            == null) {
          DataTransferServiceGrpc.getDeleteTransferConfigMethod =
              getDeleteTransferConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteTransferConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("DeleteTransferConfig"))
                      .build();
        }
      }
    }
    return getDeleteTransferConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest,
          com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
      getGetTransferConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransferConfig",
      requestType = com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.TransferConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest,
          com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
      getGetTransferConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest,
            com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
        getGetTransferConfigMethod;
    if ((getGetTransferConfigMethod = DataTransferServiceGrpc.getGetTransferConfigMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getGetTransferConfigMethod = DataTransferServiceGrpc.getGetTransferConfigMethod)
            == null) {
          DataTransferServiceGrpc.getGetTransferConfigMethod =
              getGetTransferConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest,
                          com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTransferConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.TransferConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("GetTransferConfig"))
                      .build();
        }
      }
    }
    return getGetTransferConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest,
          com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>
      getListTransferConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTransferConfigs",
      requestType = com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest,
          com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>
      getListTransferConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest,
            com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>
        getListTransferConfigsMethod;
    if ((getListTransferConfigsMethod = DataTransferServiceGrpc.getListTransferConfigsMethod)
        == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListTransferConfigsMethod = DataTransferServiceGrpc.getListTransferConfigsMethod)
            == null) {
          DataTransferServiceGrpc.getListTransferConfigsMethod =
              getListTransferConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest,
                          com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListTransferConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("ListTransferConfigs"))
                      .build();
        }
      }
    }
    return getListTransferConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest,
          com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>
      getScheduleTransferRunsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ScheduleTransferRuns",
      requestType = com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest,
          com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>
      getScheduleTransferRunsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest,
            com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>
        getScheduleTransferRunsMethod;
    if ((getScheduleTransferRunsMethod = DataTransferServiceGrpc.getScheduleTransferRunsMethod)
        == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getScheduleTransferRunsMethod = DataTransferServiceGrpc.getScheduleTransferRunsMethod)
            == null) {
          DataTransferServiceGrpc.getScheduleTransferRunsMethod =
              getScheduleTransferRunsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest,
                          com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ScheduleTransferRuns"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("ScheduleTransferRuns"))
                      .build();
        }
      }
    }
    return getScheduleTransferRunsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest,
          com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse>
      getStartManualTransferRunsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartManualTransferRuns",
      requestType = com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest.class,
      responseType =
          com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest,
          com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse>
      getStartManualTransferRunsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest,
            com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse>
        getStartManualTransferRunsMethod;
    if ((getStartManualTransferRunsMethod =
            DataTransferServiceGrpc.getStartManualTransferRunsMethod)
        == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getStartManualTransferRunsMethod =
                DataTransferServiceGrpc.getStartManualTransferRunsMethod)
            == null) {
          DataTransferServiceGrpc.getStartManualTransferRunsMethod =
              getStartManualTransferRunsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest,
                          com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "StartManualTransferRuns"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1
                                  .StartManualTransferRunsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1
                                  .StartManualTransferRunsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier(
                              "StartManualTransferRuns"))
                      .build();
        }
      }
    }
    return getStartManualTransferRunsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest,
          com.google.cloud.bigquery.datatransfer.v1.TransferRun>
      getGetTransferRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransferRun",
      requestType = com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.TransferRun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest,
          com.google.cloud.bigquery.datatransfer.v1.TransferRun>
      getGetTransferRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest,
            com.google.cloud.bigquery.datatransfer.v1.TransferRun>
        getGetTransferRunMethod;
    if ((getGetTransferRunMethod = DataTransferServiceGrpc.getGetTransferRunMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getGetTransferRunMethod = DataTransferServiceGrpc.getGetTransferRunMethod) == null) {
          DataTransferServiceGrpc.getGetTransferRunMethod =
              getGetTransferRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest,
                          com.google.cloud.bigquery.datatransfer.v1.TransferRun>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTransferRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.TransferRun
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("GetTransferRun"))
                      .build();
        }
      }
    }
    return getGetTransferRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest,
          com.google.protobuf.Empty>
      getDeleteTransferRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTransferRun",
      requestType = com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest,
          com.google.protobuf.Empty>
      getDeleteTransferRunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest,
            com.google.protobuf.Empty>
        getDeleteTransferRunMethod;
    if ((getDeleteTransferRunMethod = DataTransferServiceGrpc.getDeleteTransferRunMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getDeleteTransferRunMethod = DataTransferServiceGrpc.getDeleteTransferRunMethod)
            == null) {
          DataTransferServiceGrpc.getDeleteTransferRunMethod =
              getDeleteTransferRunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTransferRun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("DeleteTransferRun"))
                      .build();
        }
      }
    }
    return getDeleteTransferRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest,
          com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>
      getListTransferRunsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTransferRuns",
      requestType = com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest,
          com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>
      getListTransferRunsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest,
            com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>
        getListTransferRunsMethod;
    if ((getListTransferRunsMethod = DataTransferServiceGrpc.getListTransferRunsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListTransferRunsMethod = DataTransferServiceGrpc.getListTransferRunsMethod)
            == null) {
          DataTransferServiceGrpc.getListTransferRunsMethod =
              getListTransferRunsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest,
                          com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTransferRuns"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("ListTransferRuns"))
                      .build();
        }
      }
    }
    return getListTransferRunsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest,
          com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>
      getListTransferLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTransferLogs",
      requestType = com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest,
          com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>
      getListTransferLogsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest,
            com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>
        getListTransferLogsMethod;
    if ((getListTransferLogsMethod = DataTransferServiceGrpc.getListTransferLogsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListTransferLogsMethod = DataTransferServiceGrpc.getListTransferLogsMethod)
            == null) {
          DataTransferServiceGrpc.getListTransferLogsMethod =
              getListTransferLogsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest,
                          com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTransferLogs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("ListTransferLogs"))
                      .build();
        }
      }
    }
    return getListTransferLogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest,
          com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>
      getCheckValidCredsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckValidCreds",
      requestType = com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest,
          com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>
      getCheckValidCredsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest,
            com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>
        getCheckValidCredsMethod;
    if ((getCheckValidCredsMethod = DataTransferServiceGrpc.getCheckValidCredsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getCheckValidCredsMethod = DataTransferServiceGrpc.getCheckValidCredsMethod) == null) {
          DataTransferServiceGrpc.getCheckValidCredsMethod =
              getCheckValidCredsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest,
                          com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckValidCreds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTransferServiceMethodDescriptorSupplier("CheckValidCreds"))
                      .build();
        }
      }
    }
    return getCheckValidCredsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataTransferServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceStub>() {
          @java.lang.Override
          public DataTransferServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTransferServiceStub(channel, callOptions);
          }
        };
    return DataTransferServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataTransferServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceBlockingStub>() {
          @java.lang.Override
          public DataTransferServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTransferServiceBlockingStub(channel, callOptions);
          }
        };
    return DataTransferServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataTransferServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceFutureStub>() {
          @java.lang.Override
          public DataTransferServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTransferServiceFutureStub(channel, callOptions);
          }
        };
    return DataTransferServiceFutureStub.newStub(factory, channel);
  }

  /** */
  public abstract static class DataTransferServiceImplBase implements io.grpc.BindableService {

    /** */
    public void getDataSource(
        com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.DataSource>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetDataSourceMethod(), responseObserver);
    }

    /** */
    public void listDataSources(
        com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListDataSourcesMethod(), responseObserver);
    }

    /** */
    public void createTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateTransferConfigMethod(), responseObserver);
    }

    /** */
    public void updateTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateTransferConfigMethod(), responseObserver);
    }

    /** */
    public void deleteTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTransferConfigMethod(), responseObserver);
    }

    /** */
    public void getTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransferConfigMethod(), responseObserver);
    }

    /** */
    public void listTransferConfigs(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListTransferConfigsMethod(), responseObserver);
    }

    /** */
    @java.lang.Deprecated
    public void scheduleTransferRuns(
        com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getScheduleTransferRunsMethod(), responseObserver);
    }

    /** */
    public void startManualTransferRuns(
        com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getStartManualTransferRunsMethod(), responseObserver);
    }

    /** */
    public void getTransferRun(
        com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferRun>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransferRunMethod(), responseObserver);
    }

    /** */
    public void deleteTransferRun(
        com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTransferRunMethod(), responseObserver);
    }

    /** */
    public void listTransferRuns(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListTransferRunsMethod(), responseObserver);
    }

    /** */
    public void listTransferLogs(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListTransferLogsMethod(), responseObserver);
    }

    /** */
    public void checkValidCreds(
        com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCheckValidCredsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetDataSourceMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest,
                      com.google.cloud.bigquery.datatransfer.v1.DataSource>(
                      this, METHODID_GET_DATA_SOURCE)))
          .addMethod(
              getListDataSourcesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest,
                      com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>(
                      this, METHODID_LIST_DATA_SOURCES)))
          .addMethod(
              getCreateTransferConfigMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest,
                      com.google.cloud.bigquery.datatransfer.v1.TransferConfig>(
                      this, METHODID_CREATE_TRANSFER_CONFIG)))
          .addMethod(
              getUpdateTransferConfigMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest,
                      com.google.cloud.bigquery.datatransfer.v1.TransferConfig>(
                      this, METHODID_UPDATE_TRANSFER_CONFIG)))
          .addMethod(
              getDeleteTransferConfigMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_TRANSFER_CONFIG)))
          .addMethod(
              getGetTransferConfigMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest,
                      com.google.cloud.bigquery.datatransfer.v1.TransferConfig>(
                      this, METHODID_GET_TRANSFER_CONFIG)))
          .addMethod(
              getListTransferConfigsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest,
                      com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>(
                      this, METHODID_LIST_TRANSFER_CONFIGS)))
          .addMethod(
              getScheduleTransferRunsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest,
                      com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>(
                      this, METHODID_SCHEDULE_TRANSFER_RUNS)))
          .addMethod(
              getStartManualTransferRunsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest,
                      com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse>(
                      this, METHODID_START_MANUAL_TRANSFER_RUNS)))
          .addMethod(
              getGetTransferRunMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest,
                      com.google.cloud.bigquery.datatransfer.v1.TransferRun>(
                      this, METHODID_GET_TRANSFER_RUN)))
          .addMethod(
              getDeleteTransferRunMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_TRANSFER_RUN)))
          .addMethod(
              getListTransferRunsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest,
                      com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>(
                      this, METHODID_LIST_TRANSFER_RUNS)))
          .addMethod(
              getListTransferLogsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest,
                      com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>(
                      this, METHODID_LIST_TRANSFER_LOGS)))
          .addMethod(
              getCheckValidCredsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest,
                      com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>(
                      this, METHODID_CHECK_VALID_CREDS)))
          .build();
    }
  }

  /** */
  public static final class DataTransferServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataTransferServiceStub> {
    private DataTransferServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTransferServiceStub(channel, callOptions);
    }

    /** */
    public void getDataSource(
        com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.DataSource>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDataSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void listDataSources(
        com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListDataSourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void createTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateTransferConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void updateTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateTransferConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void deleteTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTransferConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTransferConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void listTransferConfigs(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTransferConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    @java.lang.Deprecated
    public void scheduleTransferRuns(
        com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getScheduleTransferRunsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void startManualTransferRuns(
        com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStartManualTransferRunsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getTransferRun(
        com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferRun>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTransferRunMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void deleteTransferRun(
        com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTransferRunMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void listTransferRuns(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTransferRunsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void listTransferLogs(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTransferLogsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void checkValidCreds(
        com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckValidCredsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /** */
  public static final class DataTransferServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataTransferServiceBlockingStub> {
    private DataTransferServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTransferServiceBlockingStub(channel, callOptions);
    }

    /** */
    public com.google.cloud.bigquery.datatransfer.v1.DataSource getDataSource(
        com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest request) {
      return blockingUnaryCall(getChannel(), getGetDataSourceMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse listDataSources(
        com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest request) {
      return blockingUnaryCall(getChannel(), getListDataSourcesMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.datatransfer.v1.TransferConfig createTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateTransferConfigMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.datatransfer.v1.TransferConfig updateTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateTransferConfigMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.protobuf.Empty deleteTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteTransferConfigMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.datatransfer.v1.TransferConfig getTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTransferConfigMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse
        listTransferConfigs(
            com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTransferConfigsMethod(), getCallOptions(), request);
    }

    /** */
    @java.lang.Deprecated
    public com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse
        scheduleTransferRuns(
            com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest request) {
      return blockingUnaryCall(
          getChannel(), getScheduleTransferRunsMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse
        startManualTransferRuns(
            com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest request) {
      return blockingUnaryCall(
          getChannel(), getStartManualTransferRunsMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.datatransfer.v1.TransferRun getTransferRun(
        com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest request) {
      return blockingUnaryCall(getChannel(), getGetTransferRunMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.protobuf.Empty deleteTransferRun(
        com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteTransferRunMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse listTransferRuns(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTransferRunsMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse listTransferLogs(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTransferLogsMethod(), getCallOptions(), request);
    }

    /** */
    public com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse checkValidCreds(
        com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest request) {
      return blockingUnaryCall(getChannel(), getCheckValidCredsMethod(), getCallOptions(), request);
    }
  }

  /** */
  public static final class DataTransferServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataTransferServiceFutureStub> {
    private DataTransferServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTransferServiceFutureStub(channel, callOptions);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datatransfer.v1.DataSource>
        getDataSource(com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDataSourceMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>
        listDataSources(com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListDataSourcesMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
        createTransferConfig(
            com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateTransferConfigMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
        updateTransferConfig(
            com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateTransferConfigMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTransferConfig(
            com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTransferConfigMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datatransfer.v1.TransferConfig>
        getTransferConfig(
            com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTransferConfigMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>
        listTransferConfigs(
            com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTransferConfigsMethod(), getCallOptions()), request);
    }

    /** */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>
        scheduleTransferRuns(
            com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getScheduleTransferRunsMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse>
        startManualTransferRuns(
            com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStartManualTransferRunsMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datatransfer.v1.TransferRun>
        getTransferRun(com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTransferRunMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTransferRun(
            com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTransferRunMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>
        listTransferRuns(
            com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTransferRunsMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>
        listTransferLogs(
            com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTransferLogsMethod(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>
        checkValidCreds(com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckValidCredsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DATA_SOURCE = 0;
  private static final int METHODID_LIST_DATA_SOURCES = 1;
  private static final int METHODID_CREATE_TRANSFER_CONFIG = 2;
  private static final int METHODID_UPDATE_TRANSFER_CONFIG = 3;
  private static final int METHODID_DELETE_TRANSFER_CONFIG = 4;
  private static final int METHODID_GET_TRANSFER_CONFIG = 5;
  private static final int METHODID_LIST_TRANSFER_CONFIGS = 6;
  private static final int METHODID_SCHEDULE_TRANSFER_RUNS = 7;
  private static final int METHODID_START_MANUAL_TRANSFER_RUNS = 8;
  private static final int METHODID_GET_TRANSFER_RUN = 9;
  private static final int METHODID_DELETE_TRANSFER_RUN = 10;
  private static final int METHODID_LIST_TRANSFER_RUNS = 11;
  private static final int METHODID_LIST_TRANSFER_LOGS = 12;
  private static final int METHODID_CHECK_VALID_CREDS = 13;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataTransferServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataTransferServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DATA_SOURCE:
          serviceImpl.getDataSource(
              (com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.DataSource>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_SOURCES:
          serviceImpl.listDataSources(
              (com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_TRANSFER_CONFIG:
          serviceImpl.createTransferConfig(
              (com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datatransfer.v1.TransferConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TRANSFER_CONFIG:
          serviceImpl.updateTransferConfig(
              (com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datatransfer.v1.TransferConfig>)
                  responseObserver);
          break;
        case METHODID_DELETE_TRANSFER_CONFIG:
          serviceImpl.deleteTransferConfig(
              (com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_TRANSFER_CONFIG:
          serviceImpl.getTransferConfig(
              (com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datatransfer.v1.TransferConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_TRANSFER_CONFIGS:
          serviceImpl.listTransferConfigs(
              (com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_SCHEDULE_TRANSFER_RUNS:
          serviceImpl.scheduleTransferRuns(
              (com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>)
                  responseObserver);
          break;
        case METHODID_START_MANUAL_TRANSFER_RUNS:
          serviceImpl.startManualTransferRuns(
              (com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TRANSFER_RUN:
          serviceImpl.getTransferRun(
              (com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferRun>)
                  responseObserver);
          break;
        case METHODID_DELETE_TRANSFER_RUN:
          serviceImpl.deleteTransferRun(
              (com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_TRANSFER_RUNS:
          serviceImpl.listTransferRuns(
              (com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_TRANSFER_LOGS:
          serviceImpl.listTransferLogs(
              (com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>)
                  responseObserver);
          break;
        case METHODID_CHECK_VALID_CREDS:
          serviceImpl.checkValidCreds(
              (com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>)
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

  private abstract static class DataTransferServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataTransferServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.bigquery.datatransfer.v1.DataTransferProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataTransferService");
    }
  }

  private static final class DataTransferServiceFileDescriptorSupplier
      extends DataTransferServiceBaseDescriptorSupplier {
    DataTransferServiceFileDescriptorSupplier() {}
  }

  private static final class DataTransferServiceMethodDescriptorSupplier
      extends DataTransferServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataTransferServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataTransferServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataTransferServiceFileDescriptorSupplier())
                      .addMethod(getGetDataSourceMethod())
                      .addMethod(getListDataSourcesMethod())
                      .addMethod(getCreateTransferConfigMethod())
                      .addMethod(getUpdateTransferConfigMethod())
                      .addMethod(getDeleteTransferConfigMethod())
                      .addMethod(getGetTransferConfigMethod())
                      .addMethod(getListTransferConfigsMethod())
                      .addMethod(getScheduleTransferRunsMethod())
                      .addMethod(getStartManualTransferRunsMethod())
                      .addMethod(getGetTransferRunMethod())
                      .addMethod(getDeleteTransferRunMethod())
                      .addMethod(getListTransferRunsMethod())
                      .addMethod(getListTransferLogsMethod())
                      .addMethod(getCheckValidCredsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
