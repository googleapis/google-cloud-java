package com.google.cloud.bigquery.datatransfer.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The Google BigQuery Data Transfer Service API enables BigQuery users to
 * configure the transfer of their data from other Google Products into BigQuery.
 * This service contains methods that are end user exposed. It backs up the
 * frontend.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/bigquery/datatransfer/v1/datatransfer.proto")
public final class DataTransferServiceGrpc {

  private DataTransferServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.bigquery.datatransfer.v1.DataTransferService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetDataSourceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest,
      com.google.cloud.bigquery.datatransfer.v1.DataSource> METHOD_GET_DATA_SOURCE = getGetDataSourceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest,
      com.google.cloud.bigquery.datatransfer.v1.DataSource> getGetDataSourceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest,
      com.google.cloud.bigquery.datatransfer.v1.DataSource> getGetDataSourceMethod() {
    return getGetDataSourceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest,
      com.google.cloud.bigquery.datatransfer.v1.DataSource> getGetDataSourceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest, com.google.cloud.bigquery.datatransfer.v1.DataSource> getGetDataSourceMethod;
    if ((getGetDataSourceMethod = DataTransferServiceGrpc.getGetDataSourceMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getGetDataSourceMethod = DataTransferServiceGrpc.getGetDataSourceMethod) == null) {
          DataTransferServiceGrpc.getGetDataSourceMethod = getGetDataSourceMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest, com.google.cloud.bigquery.datatransfer.v1.DataSource>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService", "GetDataSource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.DataSource.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("GetDataSource"))
                  .build();
          }
        }
     }
     return getGetDataSourceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListDataSourcesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> METHOD_LIST_DATA_SOURCES = getListDataSourcesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> getListDataSourcesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> getListDataSourcesMethod() {
    return getListDataSourcesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> getListDataSourcesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest, com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> getListDataSourcesMethod;
    if ((getListDataSourcesMethod = DataTransferServiceGrpc.getListDataSourcesMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListDataSourcesMethod = DataTransferServiceGrpc.getListDataSourcesMethod) == null) {
          DataTransferServiceGrpc.getListDataSourcesMethod = getListDataSourcesMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest, com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService", "ListDataSources"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("ListDataSources"))
                  .build();
          }
        }
     }
     return getListDataSourcesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateTransferConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> METHOD_CREATE_TRANSFER_CONFIG = getCreateTransferConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getCreateTransferConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getCreateTransferConfigMethod() {
    return getCreateTransferConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getCreateTransferConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest, com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getCreateTransferConfigMethod;
    if ((getCreateTransferConfigMethod = DataTransferServiceGrpc.getCreateTransferConfigMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getCreateTransferConfigMethod = DataTransferServiceGrpc.getCreateTransferConfigMethod) == null) {
          DataTransferServiceGrpc.getCreateTransferConfigMethod = getCreateTransferConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest, com.google.cloud.bigquery.datatransfer.v1.TransferConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService", "CreateTransferConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.TransferConfig.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("CreateTransferConfig"))
                  .build();
          }
        }
     }
     return getCreateTransferConfigMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateTransferConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> METHOD_UPDATE_TRANSFER_CONFIG = getUpdateTransferConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getUpdateTransferConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getUpdateTransferConfigMethod() {
    return getUpdateTransferConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getUpdateTransferConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest, com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getUpdateTransferConfigMethod;
    if ((getUpdateTransferConfigMethod = DataTransferServiceGrpc.getUpdateTransferConfigMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getUpdateTransferConfigMethod = DataTransferServiceGrpc.getUpdateTransferConfigMethod) == null) {
          DataTransferServiceGrpc.getUpdateTransferConfigMethod = getUpdateTransferConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest, com.google.cloud.bigquery.datatransfer.v1.TransferConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService", "UpdateTransferConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.TransferConfig.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("UpdateTransferConfig"))
                  .build();
          }
        }
     }
     return getUpdateTransferConfigMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteTransferConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest,
      com.google.protobuf.Empty> METHOD_DELETE_TRANSFER_CONFIG = getDeleteTransferConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest,
      com.google.protobuf.Empty> getDeleteTransferConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest,
      com.google.protobuf.Empty> getDeleteTransferConfigMethod() {
    return getDeleteTransferConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest,
      com.google.protobuf.Empty> getDeleteTransferConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest, com.google.protobuf.Empty> getDeleteTransferConfigMethod;
    if ((getDeleteTransferConfigMethod = DataTransferServiceGrpc.getDeleteTransferConfigMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getDeleteTransferConfigMethod = DataTransferServiceGrpc.getDeleteTransferConfigMethod) == null) {
          DataTransferServiceGrpc.getDeleteTransferConfigMethod = getDeleteTransferConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService", "DeleteTransferConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("DeleteTransferConfig"))
                  .build();
          }
        }
     }
     return getDeleteTransferConfigMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTransferConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> METHOD_GET_TRANSFER_CONFIG = getGetTransferConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getGetTransferConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getGetTransferConfigMethod() {
    return getGetTransferConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getGetTransferConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest, com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getGetTransferConfigMethod;
    if ((getGetTransferConfigMethod = DataTransferServiceGrpc.getGetTransferConfigMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getGetTransferConfigMethod = DataTransferServiceGrpc.getGetTransferConfigMethod) == null) {
          DataTransferServiceGrpc.getGetTransferConfigMethod = getGetTransferConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest, com.google.cloud.bigquery.datatransfer.v1.TransferConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService", "GetTransferConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.TransferConfig.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("GetTransferConfig"))
                  .build();
          }
        }
     }
     return getGetTransferConfigMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListTransferConfigsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> METHOD_LIST_TRANSFER_CONFIGS = getListTransferConfigsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> getListTransferConfigsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> getListTransferConfigsMethod() {
    return getListTransferConfigsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> getListTransferConfigsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest, com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> getListTransferConfigsMethod;
    if ((getListTransferConfigsMethod = DataTransferServiceGrpc.getListTransferConfigsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListTransferConfigsMethod = DataTransferServiceGrpc.getListTransferConfigsMethod) == null) {
          DataTransferServiceGrpc.getListTransferConfigsMethod = getListTransferConfigsMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest, com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService", "ListTransferConfigs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("ListTransferConfigs"))
                  .build();
          }
        }
     }
     return getListTransferConfigsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getScheduleTransferRunsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> METHOD_SCHEDULE_TRANSFER_RUNS = getScheduleTransferRunsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> getScheduleTransferRunsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> getScheduleTransferRunsMethod() {
    return getScheduleTransferRunsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> getScheduleTransferRunsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest, com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> getScheduleTransferRunsMethod;
    if ((getScheduleTransferRunsMethod = DataTransferServiceGrpc.getScheduleTransferRunsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getScheduleTransferRunsMethod = DataTransferServiceGrpc.getScheduleTransferRunsMethod) == null) {
          DataTransferServiceGrpc.getScheduleTransferRunsMethod = getScheduleTransferRunsMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest, com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService", "ScheduleTransferRuns"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("ScheduleTransferRuns"))
                  .build();
          }
        }
     }
     return getScheduleTransferRunsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTransferRunMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferRun> METHOD_GET_TRANSFER_RUN = getGetTransferRunMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferRun> getGetTransferRunMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferRun> getGetTransferRunMethod() {
    return getGetTransferRunMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferRun> getGetTransferRunMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest, com.google.cloud.bigquery.datatransfer.v1.TransferRun> getGetTransferRunMethod;
    if ((getGetTransferRunMethod = DataTransferServiceGrpc.getGetTransferRunMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getGetTransferRunMethod = DataTransferServiceGrpc.getGetTransferRunMethod) == null) {
          DataTransferServiceGrpc.getGetTransferRunMethod = getGetTransferRunMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest, com.google.cloud.bigquery.datatransfer.v1.TransferRun>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService", "GetTransferRun"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.TransferRun.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("GetTransferRun"))
                  .build();
          }
        }
     }
     return getGetTransferRunMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteTransferRunMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest,
      com.google.protobuf.Empty> METHOD_DELETE_TRANSFER_RUN = getDeleteTransferRunMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest,
      com.google.protobuf.Empty> getDeleteTransferRunMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest,
      com.google.protobuf.Empty> getDeleteTransferRunMethod() {
    return getDeleteTransferRunMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest,
      com.google.protobuf.Empty> getDeleteTransferRunMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest, com.google.protobuf.Empty> getDeleteTransferRunMethod;
    if ((getDeleteTransferRunMethod = DataTransferServiceGrpc.getDeleteTransferRunMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getDeleteTransferRunMethod = DataTransferServiceGrpc.getDeleteTransferRunMethod) == null) {
          DataTransferServiceGrpc.getDeleteTransferRunMethod = getDeleteTransferRunMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService", "DeleteTransferRun"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("DeleteTransferRun"))
                  .build();
          }
        }
     }
     return getDeleteTransferRunMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListTransferRunsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> METHOD_LIST_TRANSFER_RUNS = getListTransferRunsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> getListTransferRunsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> getListTransferRunsMethod() {
    return getListTransferRunsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> getListTransferRunsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest, com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> getListTransferRunsMethod;
    if ((getListTransferRunsMethod = DataTransferServiceGrpc.getListTransferRunsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListTransferRunsMethod = DataTransferServiceGrpc.getListTransferRunsMethod) == null) {
          DataTransferServiceGrpc.getListTransferRunsMethod = getListTransferRunsMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest, com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService", "ListTransferRuns"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("ListTransferRuns"))
                  .build();
          }
        }
     }
     return getListTransferRunsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListTransferLogsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> METHOD_LIST_TRANSFER_LOGS = getListTransferLogsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> getListTransferLogsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> getListTransferLogsMethod() {
    return getListTransferLogsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> getListTransferLogsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest, com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> getListTransferLogsMethod;
    if ((getListTransferLogsMethod = DataTransferServiceGrpc.getListTransferLogsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListTransferLogsMethod = DataTransferServiceGrpc.getListTransferLogsMethod) == null) {
          DataTransferServiceGrpc.getListTransferLogsMethod = getListTransferLogsMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest, com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService", "ListTransferLogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("ListTransferLogs"))
                  .build();
          }
        }
     }
     return getListTransferLogsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCheckValidCredsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest,
      com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> METHOD_CHECK_VALID_CREDS = getCheckValidCredsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest,
      com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> getCheckValidCredsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest,
      com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> getCheckValidCredsMethod() {
    return getCheckValidCredsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest,
      com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> getCheckValidCredsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest, com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> getCheckValidCredsMethod;
    if ((getCheckValidCredsMethod = DataTransferServiceGrpc.getCheckValidCredsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getCheckValidCredsMethod = DataTransferServiceGrpc.getCheckValidCredsMethod) == null) {
          DataTransferServiceGrpc.getCheckValidCredsMethod = getCheckValidCredsMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest, com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService", "CheckValidCreds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("CheckValidCreds"))
                  .build();
          }
        }
     }
     return getCheckValidCredsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataTransferServiceStub newStub(io.grpc.Channel channel) {
    return new DataTransferServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataTransferServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DataTransferServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataTransferServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DataTransferServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The Google BigQuery Data Transfer Service API enables BigQuery users to
   * configure the transfer of their data from other Google Products into BigQuery.
   * This service contains methods that are end user exposed. It backs up the
   * frontend.
   * </pre>
   */
  public static abstract class DataTransferServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Retrieves a supported data source and returns its settings,
     * which can be used for UI rendering.
     * </pre>
     */
    public void getDataSource(com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.DataSource> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDataSourceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists supported data sources and returns their settings,
     * which can be used for UI rendering.
     * </pre>
     */
    public void listDataSources(com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListDataSourcesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new data transfer configuration.
     * </pre>
     */
    public void createTransferConfig(com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateTransferConfigMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates a data transfer configuration.
     * All fields must be set, even if they are not updated.
     * </pre>
     */
    public void updateTransferConfig(com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateTransferConfigMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a data transfer configuration,
     * including any associated transfer runs and logs.
     * </pre>
     */
    public void deleteTransferConfig(com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTransferConfigMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns information about a data transfer config.
     * </pre>
     */
    public void getTransferConfig(com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransferConfigMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns information about all data transfers in the project.
     * </pre>
     */
    public void listTransferConfigs(com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListTransferConfigsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates transfer runs for a time range [start_time, end_time].
     * For each date - or whatever granularity the data source supports - in the
     * range, one transfer run is created.
     * Note that runs are created per UTC time in the time range.
     * </pre>
     */
    public void scheduleTransferRuns(com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getScheduleTransferRunsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns information about the particular transfer run.
     * </pre>
     */
    public void getTransferRun(com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferRun> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransferRunMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified transfer run.
     * </pre>
     */
    public void deleteTransferRun(com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTransferRunMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns information about running and completed jobs.
     * </pre>
     */
    public void listTransferRuns(com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListTransferRunsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns user facing log messages for the data transfer run.
     * </pre>
     */
    public void listTransferLogs(com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListTransferLogsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns true if valid credentials exist for the given data source and
     * requesting user.
     * Some data sources doesn't support service account, so we need to talk to
     * them on behalf of the end user. This API just checks whether we have OAuth
     * token for the particular user, which is a pre-requisite before user can
     * create a transfer config.
     * </pre>
     */
    public void checkValidCreds(com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckValidCredsMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDataSourceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest,
                com.google.cloud.bigquery.datatransfer.v1.DataSource>(
                  this, METHODID_GET_DATA_SOURCE)))
          .addMethod(
            getListDataSourcesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest,
                com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>(
                  this, METHODID_LIST_DATA_SOURCES)))
          .addMethod(
            getCreateTransferConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest,
                com.google.cloud.bigquery.datatransfer.v1.TransferConfig>(
                  this, METHODID_CREATE_TRANSFER_CONFIG)))
          .addMethod(
            getUpdateTransferConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest,
                com.google.cloud.bigquery.datatransfer.v1.TransferConfig>(
                  this, METHODID_UPDATE_TRANSFER_CONFIG)))
          .addMethod(
            getDeleteTransferConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_TRANSFER_CONFIG)))
          .addMethod(
            getGetTransferConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest,
                com.google.cloud.bigquery.datatransfer.v1.TransferConfig>(
                  this, METHODID_GET_TRANSFER_CONFIG)))
          .addMethod(
            getListTransferConfigsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest,
                com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>(
                  this, METHODID_LIST_TRANSFER_CONFIGS)))
          .addMethod(
            getScheduleTransferRunsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest,
                com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>(
                  this, METHODID_SCHEDULE_TRANSFER_RUNS)))
          .addMethod(
            getGetTransferRunMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest,
                com.google.cloud.bigquery.datatransfer.v1.TransferRun>(
                  this, METHODID_GET_TRANSFER_RUN)))
          .addMethod(
            getDeleteTransferRunMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_TRANSFER_RUN)))
          .addMethod(
            getListTransferRunsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest,
                com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>(
                  this, METHODID_LIST_TRANSFER_RUNS)))
          .addMethod(
            getListTransferLogsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest,
                com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>(
                  this, METHODID_LIST_TRANSFER_LOGS)))
          .addMethod(
            getCheckValidCredsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest,
                com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>(
                  this, METHODID_CHECK_VALID_CREDS)))
          .build();
    }
  }

  /**
   * <pre>
   * The Google BigQuery Data Transfer Service API enables BigQuery users to
   * configure the transfer of their data from other Google Products into BigQuery.
   * This service contains methods that are end user exposed. It backs up the
   * frontend.
   * </pre>
   */
  public static final class DataTransferServiceStub extends io.grpc.stub.AbstractStub<DataTransferServiceStub> {
    private DataTransferServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DataTransferServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DataTransferServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves a supported data source and returns its settings,
     * which can be used for UI rendering.
     * </pre>
     */
    public void getDataSource(com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.DataSource> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDataSourceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists supported data sources and returns their settings,
     * which can be used for UI rendering.
     * </pre>
     */
    public void listDataSources(com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListDataSourcesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new data transfer configuration.
     * </pre>
     */
    public void createTransferConfig(com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateTransferConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a data transfer configuration.
     * All fields must be set, even if they are not updated.
     * </pre>
     */
    public void updateTransferConfig(com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateTransferConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a data transfer configuration,
     * including any associated transfer runs and logs.
     * </pre>
     */
    public void deleteTransferConfig(com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTransferConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns information about a data transfer config.
     * </pre>
     */
    public void getTransferConfig(com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTransferConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns information about all data transfers in the project.
     * </pre>
     */
    public void listTransferConfigs(com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTransferConfigsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates transfer runs for a time range [start_time, end_time].
     * For each date - or whatever granularity the data source supports - in the
     * range, one transfer run is created.
     * Note that runs are created per UTC time in the time range.
     * </pre>
     */
    public void scheduleTransferRuns(com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getScheduleTransferRunsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns information about the particular transfer run.
     * </pre>
     */
    public void getTransferRun(com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferRun> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTransferRunMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified transfer run.
     * </pre>
     */
    public void deleteTransferRun(com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTransferRunMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns information about running and completed jobs.
     * </pre>
     */
    public void listTransferRuns(com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTransferRunsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns user facing log messages for the data transfer run.
     * </pre>
     */
    public void listTransferLogs(com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTransferLogsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns true if valid credentials exist for the given data source and
     * requesting user.
     * Some data sources doesn't support service account, so we need to talk to
     * them on behalf of the end user. This API just checks whether we have OAuth
     * token for the particular user, which is a pre-requisite before user can
     * create a transfer config.
     * </pre>
     */
    public void checkValidCreds(com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckValidCredsMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Google BigQuery Data Transfer Service API enables BigQuery users to
   * configure the transfer of their data from other Google Products into BigQuery.
   * This service contains methods that are end user exposed. It backs up the
   * frontend.
   * </pre>
   */
  public static final class DataTransferServiceBlockingStub extends io.grpc.stub.AbstractStub<DataTransferServiceBlockingStub> {
    private DataTransferServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DataTransferServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DataTransferServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves a supported data source and returns its settings,
     * which can be used for UI rendering.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.DataSource getDataSource(com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDataSourceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists supported data sources and returns their settings,
     * which can be used for UI rendering.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse listDataSources(com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListDataSourcesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new data transfer configuration.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.TransferConfig createTransferConfig(com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateTransferConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a data transfer configuration.
     * All fields must be set, even if they are not updated.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.TransferConfig updateTransferConfig(com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateTransferConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a data transfer configuration,
     * including any associated transfer runs and logs.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTransferConfig(com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteTransferConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns information about a data transfer config.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.TransferConfig getTransferConfig(com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTransferConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns information about all data transfers in the project.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse listTransferConfigs(com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTransferConfigsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates transfer runs for a time range [start_time, end_time].
     * For each date - or whatever granularity the data source supports - in the
     * range, one transfer run is created.
     * Note that runs are created per UTC time in the time range.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse scheduleTransferRuns(com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest request) {
      return blockingUnaryCall(
          getChannel(), getScheduleTransferRunsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns information about the particular transfer run.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.TransferRun getTransferRun(com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTransferRunMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified transfer run.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTransferRun(com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteTransferRunMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns information about running and completed jobs.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse listTransferRuns(com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTransferRunsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns user facing log messages for the data transfer run.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse listTransferLogs(com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTransferLogsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns true if valid credentials exist for the given data source and
     * requesting user.
     * Some data sources doesn't support service account, so we need to talk to
     * them on behalf of the end user. This API just checks whether we have OAuth
     * token for the particular user, which is a pre-requisite before user can
     * create a transfer config.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse checkValidCreds(com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckValidCredsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Google BigQuery Data Transfer Service API enables BigQuery users to
   * configure the transfer of their data from other Google Products into BigQuery.
   * This service contains methods that are end user exposed. It backs up the
   * frontend.
   * </pre>
   */
  public static final class DataTransferServiceFutureStub extends io.grpc.stub.AbstractStub<DataTransferServiceFutureStub> {
    private DataTransferServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DataTransferServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DataTransferServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves a supported data source and returns its settings,
     * which can be used for UI rendering.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.DataSource> getDataSource(
        com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDataSourceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists supported data sources and returns their settings,
     * which can be used for UI rendering.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> listDataSources(
        com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListDataSourcesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new data transfer configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> createTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateTransferConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a data transfer configuration.
     * All fields must be set, even if they are not updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> updateTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateTransferConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a data transfer configuration,
     * including any associated transfer runs and logs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTransferConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns information about a data transfer config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTransferConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns information about all data transfers in the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> listTransferConfigs(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTransferConfigsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates transfer runs for a time range [start_time, end_time].
     * For each date - or whatever granularity the data source supports - in the
     * range, one transfer run is created.
     * Note that runs are created per UTC time in the time range.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> scheduleTransferRuns(
        com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getScheduleTransferRunsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns information about the particular transfer run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.TransferRun> getTransferRun(
        com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTransferRunMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified transfer run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTransferRun(
        com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTransferRunMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns information about running and completed jobs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> listTransferRuns(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTransferRunsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns user facing log messages for the data transfer run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> listTransferLogs(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTransferLogsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns true if valid credentials exist for the given data source and
     * requesting user.
     * Some data sources doesn't support service account, so we need to talk to
     * them on behalf of the end user. This API just checks whether we have OAuth
     * token for the particular user, which is a pre-requisite before user can
     * create a transfer config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> checkValidCreds(
        com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckValidCredsMethodHelper(), getCallOptions()), request);
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
  private static final int METHODID_GET_TRANSFER_RUN = 8;
  private static final int METHODID_DELETE_TRANSFER_RUN = 9;
  private static final int METHODID_LIST_TRANSFER_RUNS = 10;
  private static final int METHODID_LIST_TRANSFER_LOGS = 11;
  private static final int METHODID_CHECK_VALID_CREDS = 12;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.getDataSource((com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.DataSource>) responseObserver);
          break;
        case METHODID_LIST_DATA_SOURCES:
          serviceImpl.listDataSources((com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>) responseObserver);
          break;
        case METHODID_CREATE_TRANSFER_CONFIG:
          serviceImpl.createTransferConfig((com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig>) responseObserver);
          break;
        case METHODID_UPDATE_TRANSFER_CONFIG:
          serviceImpl.updateTransferConfig((com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig>) responseObserver);
          break;
        case METHODID_DELETE_TRANSFER_CONFIG:
          serviceImpl.deleteTransferConfig((com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_TRANSFER_CONFIG:
          serviceImpl.getTransferConfig((com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig>) responseObserver);
          break;
        case METHODID_LIST_TRANSFER_CONFIGS:
          serviceImpl.listTransferConfigs((com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>) responseObserver);
          break;
        case METHODID_SCHEDULE_TRANSFER_RUNS:
          serviceImpl.scheduleTransferRuns((com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>) responseObserver);
          break;
        case METHODID_GET_TRANSFER_RUN:
          serviceImpl.getTransferRun((com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferRun>) responseObserver);
          break;
        case METHODID_DELETE_TRANSFER_RUN:
          serviceImpl.deleteTransferRun((com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_TRANSFER_RUNS:
          serviceImpl.listTransferRuns((com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>) responseObserver);
          break;
        case METHODID_LIST_TRANSFER_LOGS:
          serviceImpl.listTransferLogs((com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>) responseObserver);
          break;
        case METHODID_CHECK_VALID_CREDS:
          serviceImpl.checkValidCreds((com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>) responseObserver);
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

  private static abstract class DataTransferServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
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
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataTransferServiceFileDescriptorSupplier())
              .addMethod(getGetDataSourceMethodHelper())
              .addMethod(getListDataSourcesMethodHelper())
              .addMethod(getCreateTransferConfigMethodHelper())
              .addMethod(getUpdateTransferConfigMethodHelper())
              .addMethod(getDeleteTransferConfigMethodHelper())
              .addMethod(getGetTransferConfigMethodHelper())
              .addMethod(getListTransferConfigsMethodHelper())
              .addMethod(getScheduleTransferRunsMethodHelper())
              .addMethod(getGetTransferRunMethodHelper())
              .addMethod(getDeleteTransferRunMethodHelper())
              .addMethod(getListTransferRunsMethodHelper())
              .addMethod(getListTransferLogsMethodHelper())
              .addMethod(getCheckValidCredsMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
