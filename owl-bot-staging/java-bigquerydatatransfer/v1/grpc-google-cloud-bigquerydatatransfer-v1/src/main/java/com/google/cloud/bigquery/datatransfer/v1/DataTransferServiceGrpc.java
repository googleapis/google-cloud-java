package com.google.cloud.bigquery.datatransfer.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * This API allows users to manage their data transfers into BigQuery.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/datatransfer/v1/datatransfer.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataTransferServiceGrpc {

  private DataTransferServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.bigquery.datatransfer.v1.DataTransferService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest,
      com.google.cloud.bigquery.datatransfer.v1.DataSource> getGetDataSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataSource",
      requestType = com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.DataSource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest,
      com.google.cloud.bigquery.datatransfer.v1.DataSource> getGetDataSourceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest, com.google.cloud.bigquery.datatransfer.v1.DataSource> getGetDataSourceMethod;
    if ((getGetDataSourceMethod = DataTransferServiceGrpc.getGetDataSourceMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getGetDataSourceMethod = DataTransferServiceGrpc.getGetDataSourceMethod) == null) {
          DataTransferServiceGrpc.getGetDataSourceMethod = getGetDataSourceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest, com.google.cloud.bigquery.datatransfer.v1.DataSource>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataSource"))
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

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> getListDataSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataSources",
      requestType = com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> getListDataSourcesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest, com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> getListDataSourcesMethod;
    if ((getListDataSourcesMethod = DataTransferServiceGrpc.getListDataSourcesMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListDataSourcesMethod = DataTransferServiceGrpc.getListDataSourcesMethod) == null) {
          DataTransferServiceGrpc.getListDataSourcesMethod = getListDataSourcesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest, com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataSources"))
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

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getCreateTransferConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTransferConfig",
      requestType = com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.TransferConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getCreateTransferConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest, com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getCreateTransferConfigMethod;
    if ((getCreateTransferConfigMethod = DataTransferServiceGrpc.getCreateTransferConfigMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getCreateTransferConfigMethod = DataTransferServiceGrpc.getCreateTransferConfigMethod) == null) {
          DataTransferServiceGrpc.getCreateTransferConfigMethod = getCreateTransferConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest, com.google.cloud.bigquery.datatransfer.v1.TransferConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTransferConfig"))
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

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getUpdateTransferConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTransferConfig",
      requestType = com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.TransferConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getUpdateTransferConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest, com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getUpdateTransferConfigMethod;
    if ((getUpdateTransferConfigMethod = DataTransferServiceGrpc.getUpdateTransferConfigMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getUpdateTransferConfigMethod = DataTransferServiceGrpc.getUpdateTransferConfigMethod) == null) {
          DataTransferServiceGrpc.getUpdateTransferConfigMethod = getUpdateTransferConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest, com.google.cloud.bigquery.datatransfer.v1.TransferConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTransferConfig"))
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

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest,
      com.google.protobuf.Empty> getDeleteTransferConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTransferConfig",
      requestType = com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest,
      com.google.protobuf.Empty> getDeleteTransferConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest, com.google.protobuf.Empty> getDeleteTransferConfigMethod;
    if ((getDeleteTransferConfigMethod = DataTransferServiceGrpc.getDeleteTransferConfigMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getDeleteTransferConfigMethod = DataTransferServiceGrpc.getDeleteTransferConfigMethod) == null) {
          DataTransferServiceGrpc.getDeleteTransferConfigMethod = getDeleteTransferConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTransferConfig"))
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

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getGetTransferConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransferConfig",
      requestType = com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.TransferConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getGetTransferConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest, com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getGetTransferConfigMethod;
    if ((getGetTransferConfigMethod = DataTransferServiceGrpc.getGetTransferConfigMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getGetTransferConfigMethod = DataTransferServiceGrpc.getGetTransferConfigMethod) == null) {
          DataTransferServiceGrpc.getGetTransferConfigMethod = getGetTransferConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest, com.google.cloud.bigquery.datatransfer.v1.TransferConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTransferConfig"))
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

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> getListTransferConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTransferConfigs",
      requestType = com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> getListTransferConfigsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest, com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> getListTransferConfigsMethod;
    if ((getListTransferConfigsMethod = DataTransferServiceGrpc.getListTransferConfigsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListTransferConfigsMethod = DataTransferServiceGrpc.getListTransferConfigsMethod) == null) {
          DataTransferServiceGrpc.getListTransferConfigsMethod = getListTransferConfigsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest, com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTransferConfigs"))
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

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> getScheduleTransferRunsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ScheduleTransferRuns",
      requestType = com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> getScheduleTransferRunsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest, com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> getScheduleTransferRunsMethod;
    if ((getScheduleTransferRunsMethod = DataTransferServiceGrpc.getScheduleTransferRunsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getScheduleTransferRunsMethod = DataTransferServiceGrpc.getScheduleTransferRunsMethod) == null) {
          DataTransferServiceGrpc.getScheduleTransferRunsMethod = getScheduleTransferRunsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest, com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ScheduleTransferRuns"))
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

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse> getStartManualTransferRunsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartManualTransferRuns",
      requestType = com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse> getStartManualTransferRunsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest, com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse> getStartManualTransferRunsMethod;
    if ((getStartManualTransferRunsMethod = DataTransferServiceGrpc.getStartManualTransferRunsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getStartManualTransferRunsMethod = DataTransferServiceGrpc.getStartManualTransferRunsMethod) == null) {
          DataTransferServiceGrpc.getStartManualTransferRunsMethod = getStartManualTransferRunsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest, com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartManualTransferRuns"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("StartManualTransferRuns"))
              .build();
        }
      }
    }
    return getStartManualTransferRunsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferRun> getGetTransferRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransferRun",
      requestType = com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.TransferRun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest,
      com.google.cloud.bigquery.datatransfer.v1.TransferRun> getGetTransferRunMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest, com.google.cloud.bigquery.datatransfer.v1.TransferRun> getGetTransferRunMethod;
    if ((getGetTransferRunMethod = DataTransferServiceGrpc.getGetTransferRunMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getGetTransferRunMethod = DataTransferServiceGrpc.getGetTransferRunMethod) == null) {
          DataTransferServiceGrpc.getGetTransferRunMethod = getGetTransferRunMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest, com.google.cloud.bigquery.datatransfer.v1.TransferRun>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTransferRun"))
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

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest,
      com.google.protobuf.Empty> getDeleteTransferRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTransferRun",
      requestType = com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest,
      com.google.protobuf.Empty> getDeleteTransferRunMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest, com.google.protobuf.Empty> getDeleteTransferRunMethod;
    if ((getDeleteTransferRunMethod = DataTransferServiceGrpc.getDeleteTransferRunMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getDeleteTransferRunMethod = DataTransferServiceGrpc.getDeleteTransferRunMethod) == null) {
          DataTransferServiceGrpc.getDeleteTransferRunMethod = getDeleteTransferRunMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTransferRun"))
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

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> getListTransferRunsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTransferRuns",
      requestType = com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> getListTransferRunsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest, com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> getListTransferRunsMethod;
    if ((getListTransferRunsMethod = DataTransferServiceGrpc.getListTransferRunsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListTransferRunsMethod = DataTransferServiceGrpc.getListTransferRunsMethod) == null) {
          DataTransferServiceGrpc.getListTransferRunsMethod = getListTransferRunsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest, com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTransferRuns"))
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

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> getListTransferLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTransferLogs",
      requestType = com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest,
      com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> getListTransferLogsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest, com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> getListTransferLogsMethod;
    if ((getListTransferLogsMethod = DataTransferServiceGrpc.getListTransferLogsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getListTransferLogsMethod = DataTransferServiceGrpc.getListTransferLogsMethod) == null) {
          DataTransferServiceGrpc.getListTransferLogsMethod = getListTransferLogsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest, com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTransferLogs"))
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

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest,
      com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> getCheckValidCredsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckValidCreds",
      requestType = com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest.class,
      responseType = com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest,
      com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> getCheckValidCredsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest, com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> getCheckValidCredsMethod;
    if ((getCheckValidCredsMethod = DataTransferServiceGrpc.getCheckValidCredsMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getCheckValidCredsMethod = DataTransferServiceGrpc.getCheckValidCredsMethod) == null) {
          DataTransferServiceGrpc.getCheckValidCredsMethod = getCheckValidCredsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest, com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckValidCreds"))
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

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest,
      com.google.protobuf.Empty> getEnrollDataSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnrollDataSources",
      requestType = com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest,
      com.google.protobuf.Empty> getEnrollDataSourcesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest, com.google.protobuf.Empty> getEnrollDataSourcesMethod;
    if ((getEnrollDataSourcesMethod = DataTransferServiceGrpc.getEnrollDataSourcesMethod) == null) {
      synchronized (DataTransferServiceGrpc.class) {
        if ((getEnrollDataSourcesMethod = DataTransferServiceGrpc.getEnrollDataSourcesMethod) == null) {
          DataTransferServiceGrpc.getEnrollDataSourcesMethod = getEnrollDataSourcesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnrollDataSources"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new DataTransferServiceMethodDescriptorSupplier("EnrollDataSources"))
              .build();
        }
      }
    }
    return getEnrollDataSourcesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataTransferServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceStub>() {
        @java.lang.Override
        public DataTransferServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataTransferServiceStub(channel, callOptions);
        }
      };
    return DataTransferServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataTransferServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceBlockingStub>() {
        @java.lang.Override
        public DataTransferServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataTransferServiceBlockingStub(channel, callOptions);
        }
      };
    return DataTransferServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataTransferServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataTransferServiceFutureStub>() {
        @java.lang.Override
        public DataTransferServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataTransferServiceFutureStub(channel, callOptions);
        }
      };
    return DataTransferServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * This API allows users to manage their data transfers into BigQuery.
   * </pre>
   */
  public static abstract class DataTransferServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Retrieves a supported data source and returns its settings.
     * </pre>
     */
    public void getDataSource(com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.DataSource> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDataSourceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists supported data sources and returns their settings.
     * </pre>
     */
    public void listDataSources(com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDataSourcesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new data transfer configuration.
     * </pre>
     */
    public void createTransferConfig(com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTransferConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a data transfer configuration.
     * All fields must be set, even if they are not updated.
     * </pre>
     */
    public void updateTransferConfig(com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTransferConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a data transfer configuration, including any associated transfer
     * runs and logs.
     * </pre>
     */
    public void deleteTransferConfig(com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTransferConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns information about a data transfer config.
     * </pre>
     */
    public void getTransferConfig(com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTransferConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns information about all transfer configs owned by a project in the
     * specified location.
     * </pre>
     */
    public void listTransferConfigs(com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTransferConfigsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates transfer runs for a time range [start_time, end_time].
     * For each date - or whatever granularity the data source supports - in the
     * range, one transfer run is created.
     * Note that runs are created per UTC time in the time range.
     * DEPRECATED: use StartManualTransferRuns instead.
     * </pre>
     */
    @java.lang.Deprecated
    public void scheduleTransferRuns(com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getScheduleTransferRunsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Start manual transfer runs to be executed now with schedule_time equal to
     * current time. The transfer runs can be created for a time range where the
     * run_time is between start_time (inclusive) and end_time (exclusive), or for
     * a specific run_time.
     * </pre>
     */
    public void startManualTransferRuns(com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartManualTransferRunsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns information about the particular transfer run.
     * </pre>
     */
    public void getTransferRun(com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferRun> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTransferRunMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified transfer run.
     * </pre>
     */
    public void deleteTransferRun(com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTransferRunMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns information about running and completed transfer runs.
     * </pre>
     */
    public void listTransferRuns(com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTransferRunsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns log messages for the transfer run.
     * </pre>
     */
    public void listTransferLogs(com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTransferLogsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns true if valid credentials exist for the given data source and
     * requesting user.
     * </pre>
     */
    public void checkValidCreds(com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckValidCredsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Enroll data sources in a user project. This allows users to create transfer
     * configurations for these data sources. They will also appear in the
     * ListDataSources RPC and as such, will appear in the
     * [BigQuery UI](https://console.cloud.google.com/bigquery), and the documents
     * can be found in the public guide for
     * [BigQuery Web UI](https://cloud.google.com/bigquery/bigquery-web-ui) and
     * [Data Transfer
     * Service](https://cloud.google.com/bigquery/docs/working-with-transfers).
     * </pre>
     */
    public void enrollDataSources(com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEnrollDataSourcesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDataSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest,
                com.google.cloud.bigquery.datatransfer.v1.DataSource>(
                  this, METHODID_GET_DATA_SOURCE)))
          .addMethod(
            getListDataSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest,
                com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse>(
                  this, METHODID_LIST_DATA_SOURCES)))
          .addMethod(
            getCreateTransferConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest,
                com.google.cloud.bigquery.datatransfer.v1.TransferConfig>(
                  this, METHODID_CREATE_TRANSFER_CONFIG)))
          .addMethod(
            getUpdateTransferConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest,
                com.google.cloud.bigquery.datatransfer.v1.TransferConfig>(
                  this, METHODID_UPDATE_TRANSFER_CONFIG)))
          .addMethod(
            getDeleteTransferConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_TRANSFER_CONFIG)))
          .addMethod(
            getGetTransferConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest,
                com.google.cloud.bigquery.datatransfer.v1.TransferConfig>(
                  this, METHODID_GET_TRANSFER_CONFIG)))
          .addMethod(
            getListTransferConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest,
                com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse>(
                  this, METHODID_LIST_TRANSFER_CONFIGS)))
          .addMethod(
            getScheduleTransferRunsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest,
                com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse>(
                  this, METHODID_SCHEDULE_TRANSFER_RUNS)))
          .addMethod(
            getStartManualTransferRunsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest,
                com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse>(
                  this, METHODID_START_MANUAL_TRANSFER_RUNS)))
          .addMethod(
            getGetTransferRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest,
                com.google.cloud.bigquery.datatransfer.v1.TransferRun>(
                  this, METHODID_GET_TRANSFER_RUN)))
          .addMethod(
            getDeleteTransferRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_TRANSFER_RUN)))
          .addMethod(
            getListTransferRunsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest,
                com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse>(
                  this, METHODID_LIST_TRANSFER_RUNS)))
          .addMethod(
            getListTransferLogsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest,
                com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse>(
                  this, METHODID_LIST_TRANSFER_LOGS)))
          .addMethod(
            getCheckValidCredsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest,
                com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse>(
                  this, METHODID_CHECK_VALID_CREDS)))
          .addMethod(
            getEnrollDataSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_ENROLL_DATA_SOURCES)))
          .build();
    }
  }

  /**
   * <pre>
   * This API allows users to manage their data transfers into BigQuery.
   * </pre>
   */
  public static final class DataTransferServiceStub extends io.grpc.stub.AbstractAsyncStub<DataTransferServiceStub> {
    private DataTransferServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTransferServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves a supported data source and returns its settings.
     * </pre>
     */
    public void getDataSource(com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.DataSource> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataSourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists supported data sources and returns their settings.
     * </pre>
     */
    public void listDataSources(com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataSourcesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new data transfer configuration.
     * </pre>
     */
    public void createTransferConfig(com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTransferConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a data transfer configuration.
     * All fields must be set, even if they are not updated.
     * </pre>
     */
    public void updateTransferConfig(com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTransferConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a data transfer configuration, including any associated transfer
     * runs and logs.
     * </pre>
     */
    public void deleteTransferConfig(com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTransferConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns information about a data transfer config.
     * </pre>
     */
    public void getTransferConfig(com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTransferConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns information about all transfer configs owned by a project in the
     * specified location.
     * </pre>
     */
    public void listTransferConfigs(com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTransferConfigsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates transfer runs for a time range [start_time, end_time].
     * For each date - or whatever granularity the data source supports - in the
     * range, one transfer run is created.
     * Note that runs are created per UTC time in the time range.
     * DEPRECATED: use StartManualTransferRuns instead.
     * </pre>
     */
    @java.lang.Deprecated
    public void scheduleTransferRuns(com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getScheduleTransferRunsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Start manual transfer runs to be executed now with schedule_time equal to
     * current time. The transfer runs can be created for a time range where the
     * run_time is between start_time (inclusive) and end_time (exclusive), or for
     * a specific run_time.
     * </pre>
     */
    public void startManualTransferRuns(com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartManualTransferRunsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns information about the particular transfer run.
     * </pre>
     */
    public void getTransferRun(com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.TransferRun> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTransferRunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified transfer run.
     * </pre>
     */
    public void deleteTransferRun(com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTransferRunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns information about running and completed transfer runs.
     * </pre>
     */
    public void listTransferRuns(com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTransferRunsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns log messages for the transfer run.
     * </pre>
     */
    public void listTransferLogs(com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTransferLogsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns true if valid credentials exist for the given data source and
     * requesting user.
     * </pre>
     */
    public void checkValidCreds(com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckValidCredsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Enroll data sources in a user project. This allows users to create transfer
     * configurations for these data sources. They will also appear in the
     * ListDataSources RPC and as such, will appear in the
     * [BigQuery UI](https://console.cloud.google.com/bigquery), and the documents
     * can be found in the public guide for
     * [BigQuery Web UI](https://cloud.google.com/bigquery/bigquery-web-ui) and
     * [Data Transfer
     * Service](https://cloud.google.com/bigquery/docs/working-with-transfers).
     * </pre>
     */
    public void enrollDataSources(com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnrollDataSourcesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * This API allows users to manage their data transfers into BigQuery.
   * </pre>
   */
  public static final class DataTransferServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataTransferServiceBlockingStub> {
    private DataTransferServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTransferServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves a supported data source and returns its settings.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.DataSource getDataSource(com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataSourceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists supported data sources and returns their settings.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse listDataSources(com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataSourcesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new data transfer configuration.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.TransferConfig createTransferConfig(com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTransferConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a data transfer configuration.
     * All fields must be set, even if they are not updated.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.TransferConfig updateTransferConfig(com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTransferConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a data transfer configuration, including any associated transfer
     * runs and logs.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTransferConfig(com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTransferConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns information about a data transfer config.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.TransferConfig getTransferConfig(com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTransferConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns information about all transfer configs owned by a project in the
     * specified location.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse listTransferConfigs(com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTransferConfigsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates transfer runs for a time range [start_time, end_time].
     * For each date - or whatever granularity the data source supports - in the
     * range, one transfer run is created.
     * Note that runs are created per UTC time in the time range.
     * DEPRECATED: use StartManualTransferRuns instead.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse scheduleTransferRuns(com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getScheduleTransferRunsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Start manual transfer runs to be executed now with schedule_time equal to
     * current time. The transfer runs can be created for a time range where the
     * run_time is between start_time (inclusive) and end_time (exclusive), or for
     * a specific run_time.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse startManualTransferRuns(com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartManualTransferRunsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns information about the particular transfer run.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.TransferRun getTransferRun(com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTransferRunMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified transfer run.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTransferRun(com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTransferRunMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns information about running and completed transfer runs.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse listTransferRuns(com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTransferRunsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns log messages for the transfer run.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse listTransferLogs(com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTransferLogsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns true if valid credentials exist for the given data source and
     * requesting user.
     * </pre>
     */
    public com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse checkValidCreds(com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckValidCredsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Enroll data sources in a user project. This allows users to create transfer
     * configurations for these data sources. They will also appear in the
     * ListDataSources RPC and as such, will appear in the
     * [BigQuery UI](https://console.cloud.google.com/bigquery), and the documents
     * can be found in the public guide for
     * [BigQuery Web UI](https://cloud.google.com/bigquery/bigquery-web-ui) and
     * [Data Transfer
     * Service](https://cloud.google.com/bigquery/docs/working-with-transfers).
     * </pre>
     */
    public com.google.protobuf.Empty enrollDataSources(com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnrollDataSourcesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * This API allows users to manage their data transfers into BigQuery.
   * </pre>
   */
  public static final class DataTransferServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DataTransferServiceFutureStub> {
    private DataTransferServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTransferServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves a supported data source and returns its settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.DataSource> getDataSource(
        com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataSourceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists supported data sources and returns their settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse> listDataSources(
        com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataSourcesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new data transfer configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> createTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTransferConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a data transfer configuration.
     * All fields must be set, even if they are not updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> updateTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTransferConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a data transfer configuration, including any associated transfer
     * runs and logs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTransferConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns information about a data transfer config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.TransferConfig> getTransferConfig(
        com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTransferConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns information about all transfer configs owned by a project in the
     * specified location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse> listTransferConfigs(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTransferConfigsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates transfer runs for a time range [start_time, end_time].
     * For each date - or whatever granularity the data source supports - in the
     * range, one transfer run is created.
     * Note that runs are created per UTC time in the time range.
     * DEPRECATED: use StartManualTransferRuns instead.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse> scheduleTransferRuns(
        com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getScheduleTransferRunsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Start manual transfer runs to be executed now with schedule_time equal to
     * current time. The transfer runs can be created for a time range where the
     * run_time is between start_time (inclusive) and end_time (exclusive), or for
     * a specific run_time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse> startManualTransferRuns(
        com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartManualTransferRunsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns information about the particular transfer run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.TransferRun> getTransferRun(
        com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTransferRunMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified transfer run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTransferRun(
        com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTransferRunMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns information about running and completed transfer runs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse> listTransferRuns(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTransferRunsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns log messages for the transfer run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse> listTransferLogs(
        com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTransferLogsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns true if valid credentials exist for the given data source and
     * requesting user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse> checkValidCreds(
        com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckValidCredsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Enroll data sources in a user project. This allows users to create transfer
     * configurations for these data sources. They will also appear in the
     * ListDataSources RPC and as such, will appear in the
     * [BigQuery UI](https://console.cloud.google.com/bigquery), and the documents
     * can be found in the public guide for
     * [BigQuery Web UI](https://cloud.google.com/bigquery/bigquery-web-ui) and
     * [Data Transfer
     * Service](https://cloud.google.com/bigquery/docs/working-with-transfers).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> enrollDataSources(
        com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnrollDataSourcesMethod(), getCallOptions()), request);
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
  private static final int METHODID_ENROLL_DATA_SOURCES = 14;

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
        case METHODID_START_MANUAL_TRANSFER_RUNS:
          serviceImpl.startManualTransferRuns((com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse>) responseObserver);
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
        case METHODID_ENROLL_DATA_SOURCES:
          serviceImpl.enrollDataSources((com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest) request,
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
              .addMethod(getEnrollDataSourcesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
