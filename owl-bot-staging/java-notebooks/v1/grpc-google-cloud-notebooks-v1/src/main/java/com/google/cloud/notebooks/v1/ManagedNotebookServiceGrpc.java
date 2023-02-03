package com.google.cloud.notebooks.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * API v1 service for Managed Notebooks.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/notebooks/v1/managed_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ManagedNotebookServiceGrpc {

  private ManagedNotebookServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.notebooks.v1.ManagedNotebookService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.ListRuntimesRequest,
      com.google.cloud.notebooks.v1.ListRuntimesResponse> getListRuntimesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRuntimes",
      requestType = com.google.cloud.notebooks.v1.ListRuntimesRequest.class,
      responseType = com.google.cloud.notebooks.v1.ListRuntimesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.ListRuntimesRequest,
      com.google.cloud.notebooks.v1.ListRuntimesResponse> getListRuntimesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.ListRuntimesRequest, com.google.cloud.notebooks.v1.ListRuntimesResponse> getListRuntimesMethod;
    if ((getListRuntimesMethod = ManagedNotebookServiceGrpc.getListRuntimesMethod) == null) {
      synchronized (ManagedNotebookServiceGrpc.class) {
        if ((getListRuntimesMethod = ManagedNotebookServiceGrpc.getListRuntimesMethod) == null) {
          ManagedNotebookServiceGrpc.getListRuntimesMethod = getListRuntimesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v1.ListRuntimesRequest, com.google.cloud.notebooks.v1.ListRuntimesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRuntimes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.ListRuntimesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.ListRuntimesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedNotebookServiceMethodDescriptorSupplier("ListRuntimes"))
              .build();
        }
      }
    }
    return getListRuntimesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.GetRuntimeRequest,
      com.google.cloud.notebooks.v1.Runtime> getGetRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRuntime",
      requestType = com.google.cloud.notebooks.v1.GetRuntimeRequest.class,
      responseType = com.google.cloud.notebooks.v1.Runtime.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.GetRuntimeRequest,
      com.google.cloud.notebooks.v1.Runtime> getGetRuntimeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.GetRuntimeRequest, com.google.cloud.notebooks.v1.Runtime> getGetRuntimeMethod;
    if ((getGetRuntimeMethod = ManagedNotebookServiceGrpc.getGetRuntimeMethod) == null) {
      synchronized (ManagedNotebookServiceGrpc.class) {
        if ((getGetRuntimeMethod = ManagedNotebookServiceGrpc.getGetRuntimeMethod) == null) {
          ManagedNotebookServiceGrpc.getGetRuntimeMethod = getGetRuntimeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v1.GetRuntimeRequest, com.google.cloud.notebooks.v1.Runtime>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRuntime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.GetRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.Runtime.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedNotebookServiceMethodDescriptorSupplier("GetRuntime"))
              .build();
        }
      }
    }
    return getGetRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.CreateRuntimeRequest,
      com.google.longrunning.Operation> getCreateRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRuntime",
      requestType = com.google.cloud.notebooks.v1.CreateRuntimeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.CreateRuntimeRequest,
      com.google.longrunning.Operation> getCreateRuntimeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.CreateRuntimeRequest, com.google.longrunning.Operation> getCreateRuntimeMethod;
    if ((getCreateRuntimeMethod = ManagedNotebookServiceGrpc.getCreateRuntimeMethod) == null) {
      synchronized (ManagedNotebookServiceGrpc.class) {
        if ((getCreateRuntimeMethod = ManagedNotebookServiceGrpc.getCreateRuntimeMethod) == null) {
          ManagedNotebookServiceGrpc.getCreateRuntimeMethod = getCreateRuntimeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v1.CreateRuntimeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRuntime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.CreateRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedNotebookServiceMethodDescriptorSupplier("CreateRuntime"))
              .build();
        }
      }
    }
    return getCreateRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.UpdateRuntimeRequest,
      com.google.longrunning.Operation> getUpdateRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRuntime",
      requestType = com.google.cloud.notebooks.v1.UpdateRuntimeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.UpdateRuntimeRequest,
      com.google.longrunning.Operation> getUpdateRuntimeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.UpdateRuntimeRequest, com.google.longrunning.Operation> getUpdateRuntimeMethod;
    if ((getUpdateRuntimeMethod = ManagedNotebookServiceGrpc.getUpdateRuntimeMethod) == null) {
      synchronized (ManagedNotebookServiceGrpc.class) {
        if ((getUpdateRuntimeMethod = ManagedNotebookServiceGrpc.getUpdateRuntimeMethod) == null) {
          ManagedNotebookServiceGrpc.getUpdateRuntimeMethod = getUpdateRuntimeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v1.UpdateRuntimeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRuntime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.UpdateRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedNotebookServiceMethodDescriptorSupplier("UpdateRuntime"))
              .build();
        }
      }
    }
    return getUpdateRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.DeleteRuntimeRequest,
      com.google.longrunning.Operation> getDeleteRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRuntime",
      requestType = com.google.cloud.notebooks.v1.DeleteRuntimeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.DeleteRuntimeRequest,
      com.google.longrunning.Operation> getDeleteRuntimeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.DeleteRuntimeRequest, com.google.longrunning.Operation> getDeleteRuntimeMethod;
    if ((getDeleteRuntimeMethod = ManagedNotebookServiceGrpc.getDeleteRuntimeMethod) == null) {
      synchronized (ManagedNotebookServiceGrpc.class) {
        if ((getDeleteRuntimeMethod = ManagedNotebookServiceGrpc.getDeleteRuntimeMethod) == null) {
          ManagedNotebookServiceGrpc.getDeleteRuntimeMethod = getDeleteRuntimeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v1.DeleteRuntimeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRuntime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.DeleteRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedNotebookServiceMethodDescriptorSupplier("DeleteRuntime"))
              .build();
        }
      }
    }
    return getDeleteRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.StartRuntimeRequest,
      com.google.longrunning.Operation> getStartRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartRuntime",
      requestType = com.google.cloud.notebooks.v1.StartRuntimeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.StartRuntimeRequest,
      com.google.longrunning.Operation> getStartRuntimeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.StartRuntimeRequest, com.google.longrunning.Operation> getStartRuntimeMethod;
    if ((getStartRuntimeMethod = ManagedNotebookServiceGrpc.getStartRuntimeMethod) == null) {
      synchronized (ManagedNotebookServiceGrpc.class) {
        if ((getStartRuntimeMethod = ManagedNotebookServiceGrpc.getStartRuntimeMethod) == null) {
          ManagedNotebookServiceGrpc.getStartRuntimeMethod = getStartRuntimeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v1.StartRuntimeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartRuntime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.StartRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedNotebookServiceMethodDescriptorSupplier("StartRuntime"))
              .build();
        }
      }
    }
    return getStartRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.StopRuntimeRequest,
      com.google.longrunning.Operation> getStopRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopRuntime",
      requestType = com.google.cloud.notebooks.v1.StopRuntimeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.StopRuntimeRequest,
      com.google.longrunning.Operation> getStopRuntimeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.StopRuntimeRequest, com.google.longrunning.Operation> getStopRuntimeMethod;
    if ((getStopRuntimeMethod = ManagedNotebookServiceGrpc.getStopRuntimeMethod) == null) {
      synchronized (ManagedNotebookServiceGrpc.class) {
        if ((getStopRuntimeMethod = ManagedNotebookServiceGrpc.getStopRuntimeMethod) == null) {
          ManagedNotebookServiceGrpc.getStopRuntimeMethod = getStopRuntimeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v1.StopRuntimeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopRuntime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.StopRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedNotebookServiceMethodDescriptorSupplier("StopRuntime"))
              .build();
        }
      }
    }
    return getStopRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.SwitchRuntimeRequest,
      com.google.longrunning.Operation> getSwitchRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SwitchRuntime",
      requestType = com.google.cloud.notebooks.v1.SwitchRuntimeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.SwitchRuntimeRequest,
      com.google.longrunning.Operation> getSwitchRuntimeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.SwitchRuntimeRequest, com.google.longrunning.Operation> getSwitchRuntimeMethod;
    if ((getSwitchRuntimeMethod = ManagedNotebookServiceGrpc.getSwitchRuntimeMethod) == null) {
      synchronized (ManagedNotebookServiceGrpc.class) {
        if ((getSwitchRuntimeMethod = ManagedNotebookServiceGrpc.getSwitchRuntimeMethod) == null) {
          ManagedNotebookServiceGrpc.getSwitchRuntimeMethod = getSwitchRuntimeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v1.SwitchRuntimeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SwitchRuntime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.SwitchRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedNotebookServiceMethodDescriptorSupplier("SwitchRuntime"))
              .build();
        }
      }
    }
    return getSwitchRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.ResetRuntimeRequest,
      com.google.longrunning.Operation> getResetRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetRuntime",
      requestType = com.google.cloud.notebooks.v1.ResetRuntimeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.ResetRuntimeRequest,
      com.google.longrunning.Operation> getResetRuntimeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.ResetRuntimeRequest, com.google.longrunning.Operation> getResetRuntimeMethod;
    if ((getResetRuntimeMethod = ManagedNotebookServiceGrpc.getResetRuntimeMethod) == null) {
      synchronized (ManagedNotebookServiceGrpc.class) {
        if ((getResetRuntimeMethod = ManagedNotebookServiceGrpc.getResetRuntimeMethod) == null) {
          ManagedNotebookServiceGrpc.getResetRuntimeMethod = getResetRuntimeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v1.ResetRuntimeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetRuntime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.ResetRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedNotebookServiceMethodDescriptorSupplier("ResetRuntime"))
              .build();
        }
      }
    }
    return getResetRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.UpgradeRuntimeRequest,
      com.google.longrunning.Operation> getUpgradeRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpgradeRuntime",
      requestType = com.google.cloud.notebooks.v1.UpgradeRuntimeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.UpgradeRuntimeRequest,
      com.google.longrunning.Operation> getUpgradeRuntimeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.UpgradeRuntimeRequest, com.google.longrunning.Operation> getUpgradeRuntimeMethod;
    if ((getUpgradeRuntimeMethod = ManagedNotebookServiceGrpc.getUpgradeRuntimeMethod) == null) {
      synchronized (ManagedNotebookServiceGrpc.class) {
        if ((getUpgradeRuntimeMethod = ManagedNotebookServiceGrpc.getUpgradeRuntimeMethod) == null) {
          ManagedNotebookServiceGrpc.getUpgradeRuntimeMethod = getUpgradeRuntimeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v1.UpgradeRuntimeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpgradeRuntime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.UpgradeRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedNotebookServiceMethodDescriptorSupplier("UpgradeRuntime"))
              .build();
        }
      }
    }
    return getUpgradeRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.ReportRuntimeEventRequest,
      com.google.longrunning.Operation> getReportRuntimeEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportRuntimeEvent",
      requestType = com.google.cloud.notebooks.v1.ReportRuntimeEventRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.ReportRuntimeEventRequest,
      com.google.longrunning.Operation> getReportRuntimeEventMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.ReportRuntimeEventRequest, com.google.longrunning.Operation> getReportRuntimeEventMethod;
    if ((getReportRuntimeEventMethod = ManagedNotebookServiceGrpc.getReportRuntimeEventMethod) == null) {
      synchronized (ManagedNotebookServiceGrpc.class) {
        if ((getReportRuntimeEventMethod = ManagedNotebookServiceGrpc.getReportRuntimeEventMethod) == null) {
          ManagedNotebookServiceGrpc.getReportRuntimeEventMethod = getReportRuntimeEventMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v1.ReportRuntimeEventRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReportRuntimeEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.ReportRuntimeEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedNotebookServiceMethodDescriptorSupplier("ReportRuntimeEvent"))
              .build();
        }
      }
    }
    return getReportRuntimeEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest,
      com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse> getRefreshRuntimeTokenInternalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RefreshRuntimeTokenInternal",
      requestType = com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest.class,
      responseType = com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest,
      com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse> getRefreshRuntimeTokenInternalMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest, com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse> getRefreshRuntimeTokenInternalMethod;
    if ((getRefreshRuntimeTokenInternalMethod = ManagedNotebookServiceGrpc.getRefreshRuntimeTokenInternalMethod) == null) {
      synchronized (ManagedNotebookServiceGrpc.class) {
        if ((getRefreshRuntimeTokenInternalMethod = ManagedNotebookServiceGrpc.getRefreshRuntimeTokenInternalMethod) == null) {
          ManagedNotebookServiceGrpc.getRefreshRuntimeTokenInternalMethod = getRefreshRuntimeTokenInternalMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest, com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RefreshRuntimeTokenInternal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedNotebookServiceMethodDescriptorSupplier("RefreshRuntimeTokenInternal"))
              .build();
        }
      }
    }
    return getRefreshRuntimeTokenInternalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest,
      com.google.longrunning.Operation> getDiagnoseRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DiagnoseRuntime",
      requestType = com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest,
      com.google.longrunning.Operation> getDiagnoseRuntimeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest, com.google.longrunning.Operation> getDiagnoseRuntimeMethod;
    if ((getDiagnoseRuntimeMethod = ManagedNotebookServiceGrpc.getDiagnoseRuntimeMethod) == null) {
      synchronized (ManagedNotebookServiceGrpc.class) {
        if ((getDiagnoseRuntimeMethod = ManagedNotebookServiceGrpc.getDiagnoseRuntimeMethod) == null) {
          ManagedNotebookServiceGrpc.getDiagnoseRuntimeMethod = getDiagnoseRuntimeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DiagnoseRuntime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedNotebookServiceMethodDescriptorSupplier("DiagnoseRuntime"))
              .build();
        }
      }
    }
    return getDiagnoseRuntimeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ManagedNotebookServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagedNotebookServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManagedNotebookServiceStub>() {
        @java.lang.Override
        public ManagedNotebookServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManagedNotebookServiceStub(channel, callOptions);
        }
      };
    return ManagedNotebookServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ManagedNotebookServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagedNotebookServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManagedNotebookServiceBlockingStub>() {
        @java.lang.Override
        public ManagedNotebookServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManagedNotebookServiceBlockingStub(channel, callOptions);
        }
      };
    return ManagedNotebookServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ManagedNotebookServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagedNotebookServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManagedNotebookServiceFutureStub>() {
        @java.lang.Override
        public ManagedNotebookServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManagedNotebookServiceFutureStub(channel, callOptions);
        }
      };
    return ManagedNotebookServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * API v1 service for Managed Notebooks.
   * </pre>
   */
  public static abstract class ManagedNotebookServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists Runtimes in a given project and location.
     * </pre>
     */
    public void listRuntimes(com.google.cloud.notebooks.v1.ListRuntimesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListRuntimesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRuntimesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Runtime. The location must be a regional endpoint
     * rather than zonal.
     * </pre>
     */
    public void getRuntime(com.google.cloud.notebooks.v1.GetRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Runtime> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRuntimeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Runtime in a given project and location.
     * </pre>
     */
    public void createRuntime(com.google.cloud.notebooks.v1.CreateRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRuntimeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update Notebook Runtime configuration.
     * </pre>
     */
    public void updateRuntime(com.google.cloud.notebooks.v1.UpdateRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateRuntimeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Runtime.
     * </pre>
     */
    public void deleteRuntime(com.google.cloud.notebooks.v1.DeleteRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRuntimeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Starts a Managed Notebook Runtime.
     * Perform "Start" on GPU instances; "Resume" on CPU instances
     * See:
     * https://cloud.google.com/compute/docs/instances/stop-start-instance
     * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
     * </pre>
     */
    public void startRuntime(com.google.cloud.notebooks.v1.StartRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartRuntimeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Stops a Managed Notebook Runtime.
     * Perform "Stop" on GPU instances; "Suspend" on CPU instances
     * See:
     * https://cloud.google.com/compute/docs/instances/stop-start-instance
     * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
     * </pre>
     */
    public void stopRuntime(com.google.cloud.notebooks.v1.StopRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopRuntimeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Switch a Managed Notebook Runtime.
     * </pre>
     */
    public void switchRuntime(com.google.cloud.notebooks.v1.SwitchRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSwitchRuntimeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Resets a Managed Notebook Runtime.
     * </pre>
     */
    public void resetRuntime(com.google.cloud.notebooks.v1.ResetRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResetRuntimeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Upgrades a Managed Notebook Runtime to the latest version.
     * </pre>
     */
    public void upgradeRuntime(com.google.cloud.notebooks.v1.UpgradeRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpgradeRuntimeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Report and process a runtime event.
     * </pre>
     */
    public void reportRuntimeEvent(com.google.cloud.notebooks.v1.ReportRuntimeEventRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReportRuntimeEventMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets an access token for the consumer service account that the customer
     * attached to the runtime. Only accessible from the tenant instance.
     * </pre>
     */
    public void refreshRuntimeTokenInternal(com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRefreshRuntimeTokenInternalMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a Diagnostic File and runs Diagnostic Tool given a Runtime.
     * </pre>
     */
    public void diagnoseRuntime(com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDiagnoseRuntimeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListRuntimesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.notebooks.v1.ListRuntimesRequest,
                com.google.cloud.notebooks.v1.ListRuntimesResponse>(
                  this, METHODID_LIST_RUNTIMES)))
          .addMethod(
            getGetRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.notebooks.v1.GetRuntimeRequest,
                com.google.cloud.notebooks.v1.Runtime>(
                  this, METHODID_GET_RUNTIME)))
          .addMethod(
            getCreateRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.notebooks.v1.CreateRuntimeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_RUNTIME)))
          .addMethod(
            getUpdateRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.notebooks.v1.UpdateRuntimeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_RUNTIME)))
          .addMethod(
            getDeleteRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.notebooks.v1.DeleteRuntimeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_RUNTIME)))
          .addMethod(
            getStartRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.notebooks.v1.StartRuntimeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_START_RUNTIME)))
          .addMethod(
            getStopRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.notebooks.v1.StopRuntimeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_STOP_RUNTIME)))
          .addMethod(
            getSwitchRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.notebooks.v1.SwitchRuntimeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_SWITCH_RUNTIME)))
          .addMethod(
            getResetRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.notebooks.v1.ResetRuntimeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RESET_RUNTIME)))
          .addMethod(
            getUpgradeRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.notebooks.v1.UpgradeRuntimeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPGRADE_RUNTIME)))
          .addMethod(
            getReportRuntimeEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.notebooks.v1.ReportRuntimeEventRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_REPORT_RUNTIME_EVENT)))
          .addMethod(
            getRefreshRuntimeTokenInternalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest,
                com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse>(
                  this, METHODID_REFRESH_RUNTIME_TOKEN_INTERNAL)))
          .addMethod(
            getDiagnoseRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DIAGNOSE_RUNTIME)))
          .build();
    }
  }

  /**
   * <pre>
   * API v1 service for Managed Notebooks.
   * </pre>
   */
  public static final class ManagedNotebookServiceStub extends io.grpc.stub.AbstractAsyncStub<ManagedNotebookServiceStub> {
    private ManagedNotebookServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagedNotebookServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagedNotebookServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Runtimes in a given project and location.
     * </pre>
     */
    public void listRuntimes(com.google.cloud.notebooks.v1.ListRuntimesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListRuntimesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRuntimesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Runtime. The location must be a regional endpoint
     * rather than zonal.
     * </pre>
     */
    public void getRuntime(com.google.cloud.notebooks.v1.GetRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Runtime> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRuntimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Runtime in a given project and location.
     * </pre>
     */
    public void createRuntime(com.google.cloud.notebooks.v1.CreateRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRuntimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update Notebook Runtime configuration.
     * </pre>
     */
    public void updateRuntime(com.google.cloud.notebooks.v1.UpdateRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRuntimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Runtime.
     * </pre>
     */
    public void deleteRuntime(com.google.cloud.notebooks.v1.DeleteRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRuntimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Starts a Managed Notebook Runtime.
     * Perform "Start" on GPU instances; "Resume" on CPU instances
     * See:
     * https://cloud.google.com/compute/docs/instances/stop-start-instance
     * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
     * </pre>
     */
    public void startRuntime(com.google.cloud.notebooks.v1.StartRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartRuntimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Stops a Managed Notebook Runtime.
     * Perform "Stop" on GPU instances; "Suspend" on CPU instances
     * See:
     * https://cloud.google.com/compute/docs/instances/stop-start-instance
     * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
     * </pre>
     */
    public void stopRuntime(com.google.cloud.notebooks.v1.StopRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopRuntimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Switch a Managed Notebook Runtime.
     * </pre>
     */
    public void switchRuntime(com.google.cloud.notebooks.v1.SwitchRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSwitchRuntimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Resets a Managed Notebook Runtime.
     * </pre>
     */
    public void resetRuntime(com.google.cloud.notebooks.v1.ResetRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetRuntimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Upgrades a Managed Notebook Runtime to the latest version.
     * </pre>
     */
    public void upgradeRuntime(com.google.cloud.notebooks.v1.UpgradeRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpgradeRuntimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Report and process a runtime event.
     * </pre>
     */
    public void reportRuntimeEvent(com.google.cloud.notebooks.v1.ReportRuntimeEventRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportRuntimeEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets an access token for the consumer service account that the customer
     * attached to the runtime. Only accessible from the tenant instance.
     * </pre>
     */
    public void refreshRuntimeTokenInternal(com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRefreshRuntimeTokenInternalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a Diagnostic File and runs Diagnostic Tool given a Runtime.
     * </pre>
     */
    public void diagnoseRuntime(com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDiagnoseRuntimeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * API v1 service for Managed Notebooks.
   * </pre>
   */
  public static final class ManagedNotebookServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ManagedNotebookServiceBlockingStub> {
    private ManagedNotebookServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagedNotebookServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagedNotebookServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Runtimes in a given project and location.
     * </pre>
     */
    public com.google.cloud.notebooks.v1.ListRuntimesResponse listRuntimes(com.google.cloud.notebooks.v1.ListRuntimesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRuntimesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Runtime. The location must be a regional endpoint
     * rather than zonal.
     * </pre>
     */
    public com.google.cloud.notebooks.v1.Runtime getRuntime(com.google.cloud.notebooks.v1.GetRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRuntimeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Runtime in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createRuntime(com.google.cloud.notebooks.v1.CreateRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRuntimeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update Notebook Runtime configuration.
     * </pre>
     */
    public com.google.longrunning.Operation updateRuntime(com.google.cloud.notebooks.v1.UpdateRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRuntimeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single Runtime.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRuntime(com.google.cloud.notebooks.v1.DeleteRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRuntimeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Starts a Managed Notebook Runtime.
     * Perform "Start" on GPU instances; "Resume" on CPU instances
     * See:
     * https://cloud.google.com/compute/docs/instances/stop-start-instance
     * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
     * </pre>
     */
    public com.google.longrunning.Operation startRuntime(com.google.cloud.notebooks.v1.StartRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartRuntimeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Stops a Managed Notebook Runtime.
     * Perform "Stop" on GPU instances; "Suspend" on CPU instances
     * See:
     * https://cloud.google.com/compute/docs/instances/stop-start-instance
     * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
     * </pre>
     */
    public com.google.longrunning.Operation stopRuntime(com.google.cloud.notebooks.v1.StopRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopRuntimeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Switch a Managed Notebook Runtime.
     * </pre>
     */
    public com.google.longrunning.Operation switchRuntime(com.google.cloud.notebooks.v1.SwitchRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSwitchRuntimeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Resets a Managed Notebook Runtime.
     * </pre>
     */
    public com.google.longrunning.Operation resetRuntime(com.google.cloud.notebooks.v1.ResetRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetRuntimeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Upgrades a Managed Notebook Runtime to the latest version.
     * </pre>
     */
    public com.google.longrunning.Operation upgradeRuntime(com.google.cloud.notebooks.v1.UpgradeRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpgradeRuntimeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Report and process a runtime event.
     * </pre>
     */
    public com.google.longrunning.Operation reportRuntimeEvent(com.google.cloud.notebooks.v1.ReportRuntimeEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportRuntimeEventMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets an access token for the consumer service account that the customer
     * attached to the runtime. Only accessible from the tenant instance.
     * </pre>
     */
    public com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse refreshRuntimeTokenInternal(com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRefreshRuntimeTokenInternalMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a Diagnostic File and runs Diagnostic Tool given a Runtime.
     * </pre>
     */
    public com.google.longrunning.Operation diagnoseRuntime(com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDiagnoseRuntimeMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * API v1 service for Managed Notebooks.
   * </pre>
   */
  public static final class ManagedNotebookServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ManagedNotebookServiceFutureStub> {
    private ManagedNotebookServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagedNotebookServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagedNotebookServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Runtimes in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.notebooks.v1.ListRuntimesResponse> listRuntimes(
        com.google.cloud.notebooks.v1.ListRuntimesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRuntimesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Runtime. The location must be a regional endpoint
     * rather than zonal.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.notebooks.v1.Runtime> getRuntime(
        com.google.cloud.notebooks.v1.GetRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRuntimeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new Runtime in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createRuntime(
        com.google.cloud.notebooks.v1.CreateRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRuntimeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update Notebook Runtime configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateRuntime(
        com.google.cloud.notebooks.v1.UpdateRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRuntimeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single Runtime.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteRuntime(
        com.google.cloud.notebooks.v1.DeleteRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRuntimeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Starts a Managed Notebook Runtime.
     * Perform "Start" on GPU instances; "Resume" on CPU instances
     * See:
     * https://cloud.google.com/compute/docs/instances/stop-start-instance
     * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> startRuntime(
        com.google.cloud.notebooks.v1.StartRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartRuntimeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Stops a Managed Notebook Runtime.
     * Perform "Stop" on GPU instances; "Suspend" on CPU instances
     * See:
     * https://cloud.google.com/compute/docs/instances/stop-start-instance
     * https://cloud.google.com/compute/docs/instances/suspend-resume-instance
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> stopRuntime(
        com.google.cloud.notebooks.v1.StopRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopRuntimeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Switch a Managed Notebook Runtime.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> switchRuntime(
        com.google.cloud.notebooks.v1.SwitchRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSwitchRuntimeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Resets a Managed Notebook Runtime.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> resetRuntime(
        com.google.cloud.notebooks.v1.ResetRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetRuntimeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Upgrades a Managed Notebook Runtime to the latest version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> upgradeRuntime(
        com.google.cloud.notebooks.v1.UpgradeRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpgradeRuntimeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Report and process a runtime event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> reportRuntimeEvent(
        com.google.cloud.notebooks.v1.ReportRuntimeEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportRuntimeEventMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets an access token for the consumer service account that the customer
     * attached to the runtime. Only accessible from the tenant instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse> refreshRuntimeTokenInternal(
        com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRefreshRuntimeTokenInternalMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a Diagnostic File and runs Diagnostic Tool given a Runtime.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> diagnoseRuntime(
        com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDiagnoseRuntimeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_RUNTIMES = 0;
  private static final int METHODID_GET_RUNTIME = 1;
  private static final int METHODID_CREATE_RUNTIME = 2;
  private static final int METHODID_UPDATE_RUNTIME = 3;
  private static final int METHODID_DELETE_RUNTIME = 4;
  private static final int METHODID_START_RUNTIME = 5;
  private static final int METHODID_STOP_RUNTIME = 6;
  private static final int METHODID_SWITCH_RUNTIME = 7;
  private static final int METHODID_RESET_RUNTIME = 8;
  private static final int METHODID_UPGRADE_RUNTIME = 9;
  private static final int METHODID_REPORT_RUNTIME_EVENT = 10;
  private static final int METHODID_REFRESH_RUNTIME_TOKEN_INTERNAL = 11;
  private static final int METHODID_DIAGNOSE_RUNTIME = 12;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ManagedNotebookServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ManagedNotebookServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_RUNTIMES:
          serviceImpl.listRuntimes((com.google.cloud.notebooks.v1.ListRuntimesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListRuntimesResponse>) responseObserver);
          break;
        case METHODID_GET_RUNTIME:
          serviceImpl.getRuntime((com.google.cloud.notebooks.v1.GetRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Runtime>) responseObserver);
          break;
        case METHODID_CREATE_RUNTIME:
          serviceImpl.createRuntime((com.google.cloud.notebooks.v1.CreateRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_RUNTIME:
          serviceImpl.updateRuntime((com.google.cloud.notebooks.v1.UpdateRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_RUNTIME:
          serviceImpl.deleteRuntime((com.google.cloud.notebooks.v1.DeleteRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_RUNTIME:
          serviceImpl.startRuntime((com.google.cloud.notebooks.v1.StartRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_STOP_RUNTIME:
          serviceImpl.stopRuntime((com.google.cloud.notebooks.v1.StopRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SWITCH_RUNTIME:
          serviceImpl.switchRuntime((com.google.cloud.notebooks.v1.SwitchRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESET_RUNTIME:
          serviceImpl.resetRuntime((com.google.cloud.notebooks.v1.ResetRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPGRADE_RUNTIME:
          serviceImpl.upgradeRuntime((com.google.cloud.notebooks.v1.UpgradeRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REPORT_RUNTIME_EVENT:
          serviceImpl.reportRuntimeEvent((com.google.cloud.notebooks.v1.ReportRuntimeEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REFRESH_RUNTIME_TOKEN_INTERNAL:
          serviceImpl.refreshRuntimeTokenInternal((com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse>) responseObserver);
          break;
        case METHODID_DIAGNOSE_RUNTIME:
          serviceImpl.diagnoseRuntime((com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest) request,
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

  private static abstract class ManagedNotebookServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ManagedNotebookServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.notebooks.v1.ManagedNotebooksProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ManagedNotebookService");
    }
  }

  private static final class ManagedNotebookServiceFileDescriptorSupplier
      extends ManagedNotebookServiceBaseDescriptorSupplier {
    ManagedNotebookServiceFileDescriptorSupplier() {}
  }

  private static final class ManagedNotebookServiceMethodDescriptorSupplier
      extends ManagedNotebookServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ManagedNotebookServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ManagedNotebookServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ManagedNotebookServiceFileDescriptorSupplier())
              .addMethod(getListRuntimesMethod())
              .addMethod(getGetRuntimeMethod())
              .addMethod(getCreateRuntimeMethod())
              .addMethod(getUpdateRuntimeMethod())
              .addMethod(getDeleteRuntimeMethod())
              .addMethod(getStartRuntimeMethod())
              .addMethod(getStopRuntimeMethod())
              .addMethod(getSwitchRuntimeMethod())
              .addMethod(getResetRuntimeMethod())
              .addMethod(getUpgradeRuntimeMethod())
              .addMethod(getReportRuntimeEventMethod())
              .addMethod(getRefreshRuntimeTokenInternalMethod())
              .addMethod(getDiagnoseRuntimeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
