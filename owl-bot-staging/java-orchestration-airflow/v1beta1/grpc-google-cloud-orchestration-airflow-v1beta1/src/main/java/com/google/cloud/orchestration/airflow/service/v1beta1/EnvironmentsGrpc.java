package com.google.cloud.orchestration.airflow.service.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Managed Apache Airflow Environments.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/orchestration/airflow/service/v1beta1/environments.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EnvironmentsGrpc {

  private EnvironmentsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.orchestration.airflow.service.v1beta1.Environments";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest,
      com.google.longrunning.Operation> getCreateEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEnvironment",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest,
      com.google.longrunning.Operation> getCreateEnvironmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest, com.google.longrunning.Operation> getCreateEnvironmentMethod;
    if ((getCreateEnvironmentMethod = EnvironmentsGrpc.getCreateEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getCreateEnvironmentMethod = EnvironmentsGrpc.getCreateEnvironmentMethod) == null) {
          EnvironmentsGrpc.getCreateEnvironmentMethod = getCreateEnvironmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEnvironment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("CreateEnvironment"))
              .build();
        }
      }
    }
    return getCreateEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.Environment> getGetEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnvironment",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.Environment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.Environment> getGetEnvironmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest, com.google.cloud.orchestration.airflow.service.v1beta1.Environment> getGetEnvironmentMethod;
    if ((getGetEnvironmentMethod = EnvironmentsGrpc.getGetEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getGetEnvironmentMethod = EnvironmentsGrpc.getGetEnvironmentMethod) == null) {
          EnvironmentsGrpc.getGetEnvironmentMethod = getGetEnvironmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest, com.google.cloud.orchestration.airflow.service.v1beta1.Environment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEnvironment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.Environment.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("GetEnvironment"))
              .build();
        }
      }
    }
    return getGetEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse> getListEnvironmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEnvironments",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse> getListEnvironmentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest, com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse> getListEnvironmentsMethod;
    if ((getListEnvironmentsMethod = EnvironmentsGrpc.getListEnvironmentsMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getListEnvironmentsMethod = EnvironmentsGrpc.getListEnvironmentsMethod) == null) {
          EnvironmentsGrpc.getListEnvironmentsMethod = getListEnvironmentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest, com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEnvironments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("ListEnvironments"))
              .build();
        }
      }
    }
    return getListEnvironmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest,
      com.google.longrunning.Operation> getUpdateEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEnvironment",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest,
      com.google.longrunning.Operation> getUpdateEnvironmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest, com.google.longrunning.Operation> getUpdateEnvironmentMethod;
    if ((getUpdateEnvironmentMethod = EnvironmentsGrpc.getUpdateEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getUpdateEnvironmentMethod = EnvironmentsGrpc.getUpdateEnvironmentMethod) == null) {
          EnvironmentsGrpc.getUpdateEnvironmentMethod = getUpdateEnvironmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEnvironment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("UpdateEnvironment"))
              .build();
        }
      }
    }
    return getUpdateEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest,
      com.google.longrunning.Operation> getDeleteEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEnvironment",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest,
      com.google.longrunning.Operation> getDeleteEnvironmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest, com.google.longrunning.Operation> getDeleteEnvironmentMethod;
    if ((getDeleteEnvironmentMethod = EnvironmentsGrpc.getDeleteEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getDeleteEnvironmentMethod = EnvironmentsGrpc.getDeleteEnvironmentMethod) == null) {
          EnvironmentsGrpc.getDeleteEnvironmentMethod = getDeleteEnvironmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEnvironment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("DeleteEnvironment"))
              .build();
        }
      }
    }
    return getDeleteEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest,
      com.google.longrunning.Operation> getRestartWebServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestartWebServer",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest,
      com.google.longrunning.Operation> getRestartWebServerMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest, com.google.longrunning.Operation> getRestartWebServerMethod;
    if ((getRestartWebServerMethod = EnvironmentsGrpc.getRestartWebServerMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getRestartWebServerMethod = EnvironmentsGrpc.getRestartWebServerMethod) == null) {
          EnvironmentsGrpc.getRestartWebServerMethod = getRestartWebServerMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestartWebServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("RestartWebServer"))
              .build();
        }
      }
    }
    return getRestartWebServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest,
      com.google.longrunning.Operation> getCheckUpgradeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckUpgrade",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest,
      com.google.longrunning.Operation> getCheckUpgradeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest, com.google.longrunning.Operation> getCheckUpgradeMethod;
    if ((getCheckUpgradeMethod = EnvironmentsGrpc.getCheckUpgradeMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getCheckUpgradeMethod = EnvironmentsGrpc.getCheckUpgradeMethod) == null) {
          EnvironmentsGrpc.getCheckUpgradeMethod = getCheckUpgradeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckUpgrade"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("CheckUpgrade"))
              .build();
        }
      }
    }
    return getCheckUpgradeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse> getExecuteAirflowCommandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteAirflowCommand",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse> getExecuteAirflowCommandMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest, com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse> getExecuteAirflowCommandMethod;
    if ((getExecuteAirflowCommandMethod = EnvironmentsGrpc.getExecuteAirflowCommandMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getExecuteAirflowCommandMethod = EnvironmentsGrpc.getExecuteAirflowCommandMethod) == null) {
          EnvironmentsGrpc.getExecuteAirflowCommandMethod = getExecuteAirflowCommandMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest, com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteAirflowCommand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("ExecuteAirflowCommand"))
              .build();
        }
      }
    }
    return getExecuteAirflowCommandMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse> getStopAirflowCommandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopAirflowCommand",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse> getStopAirflowCommandMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest, com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse> getStopAirflowCommandMethod;
    if ((getStopAirflowCommandMethod = EnvironmentsGrpc.getStopAirflowCommandMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getStopAirflowCommandMethod = EnvironmentsGrpc.getStopAirflowCommandMethod) == null) {
          EnvironmentsGrpc.getStopAirflowCommandMethod = getStopAirflowCommandMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest, com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopAirflowCommand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("StopAirflowCommand"))
              .build();
        }
      }
    }
    return getStopAirflowCommandMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse> getPollAirflowCommandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PollAirflowCommand",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse> getPollAirflowCommandMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest, com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse> getPollAirflowCommandMethod;
    if ((getPollAirflowCommandMethod = EnvironmentsGrpc.getPollAirflowCommandMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getPollAirflowCommandMethod = EnvironmentsGrpc.getPollAirflowCommandMethod) == null) {
          EnvironmentsGrpc.getPollAirflowCommandMethod = getPollAirflowCommandMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest, com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PollAirflowCommand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("PollAirflowCommand"))
              .build();
        }
      }
    }
    return getPollAirflowCommandMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse> getListWorkloadsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkloads",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse> getListWorkloadsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest, com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse> getListWorkloadsMethod;
    if ((getListWorkloadsMethod = EnvironmentsGrpc.getListWorkloadsMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getListWorkloadsMethod = EnvironmentsGrpc.getListWorkloadsMethod) == null) {
          EnvironmentsGrpc.getListWorkloadsMethod = getListWorkloadsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest, com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWorkloads"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("ListWorkloads"))
              .build();
        }
      }
    }
    return getListWorkloadsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> getCreateUserWorkloadsSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUserWorkloadsSecret",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> getCreateUserWorkloadsSecretMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest, com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> getCreateUserWorkloadsSecretMethod;
    if ((getCreateUserWorkloadsSecretMethod = EnvironmentsGrpc.getCreateUserWorkloadsSecretMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getCreateUserWorkloadsSecretMethod = EnvironmentsGrpc.getCreateUserWorkloadsSecretMethod) == null) {
          EnvironmentsGrpc.getCreateUserWorkloadsSecretMethod = getCreateUserWorkloadsSecretMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest, com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUserWorkloadsSecret"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("CreateUserWorkloadsSecret"))
              .build();
        }
      }
    }
    return getCreateUserWorkloadsSecretMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> getGetUserWorkloadsSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserWorkloadsSecret",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> getGetUserWorkloadsSecretMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest, com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> getGetUserWorkloadsSecretMethod;
    if ((getGetUserWorkloadsSecretMethod = EnvironmentsGrpc.getGetUserWorkloadsSecretMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getGetUserWorkloadsSecretMethod = EnvironmentsGrpc.getGetUserWorkloadsSecretMethod) == null) {
          EnvironmentsGrpc.getGetUserWorkloadsSecretMethod = getGetUserWorkloadsSecretMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest, com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserWorkloadsSecret"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("GetUserWorkloadsSecret"))
              .build();
        }
      }
    }
    return getGetUserWorkloadsSecretMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse> getListUserWorkloadsSecretsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserWorkloadsSecrets",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse> getListUserWorkloadsSecretsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest, com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse> getListUserWorkloadsSecretsMethod;
    if ((getListUserWorkloadsSecretsMethod = EnvironmentsGrpc.getListUserWorkloadsSecretsMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getListUserWorkloadsSecretsMethod = EnvironmentsGrpc.getListUserWorkloadsSecretsMethod) == null) {
          EnvironmentsGrpc.getListUserWorkloadsSecretsMethod = getListUserWorkloadsSecretsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest, com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUserWorkloadsSecrets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("ListUserWorkloadsSecrets"))
              .build();
        }
      }
    }
    return getListUserWorkloadsSecretsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> getUpdateUserWorkloadsSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUserWorkloadsSecret",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> getUpdateUserWorkloadsSecretMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest, com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> getUpdateUserWorkloadsSecretMethod;
    if ((getUpdateUserWorkloadsSecretMethod = EnvironmentsGrpc.getUpdateUserWorkloadsSecretMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getUpdateUserWorkloadsSecretMethod = EnvironmentsGrpc.getUpdateUserWorkloadsSecretMethod) == null) {
          EnvironmentsGrpc.getUpdateUserWorkloadsSecretMethod = getUpdateUserWorkloadsSecretMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest, com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUserWorkloadsSecret"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("UpdateUserWorkloadsSecret"))
              .build();
        }
      }
    }
    return getUpdateUserWorkloadsSecretMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest,
      com.google.protobuf.Empty> getDeleteUserWorkloadsSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUserWorkloadsSecret",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest,
      com.google.protobuf.Empty> getDeleteUserWorkloadsSecretMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest, com.google.protobuf.Empty> getDeleteUserWorkloadsSecretMethod;
    if ((getDeleteUserWorkloadsSecretMethod = EnvironmentsGrpc.getDeleteUserWorkloadsSecretMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getDeleteUserWorkloadsSecretMethod = EnvironmentsGrpc.getDeleteUserWorkloadsSecretMethod) == null) {
          EnvironmentsGrpc.getDeleteUserWorkloadsSecretMethod = getDeleteUserWorkloadsSecretMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUserWorkloadsSecret"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("DeleteUserWorkloadsSecret"))
              .build();
        }
      }
    }
    return getDeleteUserWorkloadsSecretMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> getCreateUserWorkloadsConfigMapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUserWorkloadsConfigMap",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> getCreateUserWorkloadsConfigMapMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest, com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> getCreateUserWorkloadsConfigMapMethod;
    if ((getCreateUserWorkloadsConfigMapMethod = EnvironmentsGrpc.getCreateUserWorkloadsConfigMapMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getCreateUserWorkloadsConfigMapMethod = EnvironmentsGrpc.getCreateUserWorkloadsConfigMapMethod) == null) {
          EnvironmentsGrpc.getCreateUserWorkloadsConfigMapMethod = getCreateUserWorkloadsConfigMapMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest, com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUserWorkloadsConfigMap"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("CreateUserWorkloadsConfigMap"))
              .build();
        }
      }
    }
    return getCreateUserWorkloadsConfigMapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> getGetUserWorkloadsConfigMapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserWorkloadsConfigMap",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> getGetUserWorkloadsConfigMapMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest, com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> getGetUserWorkloadsConfigMapMethod;
    if ((getGetUserWorkloadsConfigMapMethod = EnvironmentsGrpc.getGetUserWorkloadsConfigMapMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getGetUserWorkloadsConfigMapMethod = EnvironmentsGrpc.getGetUserWorkloadsConfigMapMethod) == null) {
          EnvironmentsGrpc.getGetUserWorkloadsConfigMapMethod = getGetUserWorkloadsConfigMapMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest, com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserWorkloadsConfigMap"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("GetUserWorkloadsConfigMap"))
              .build();
        }
      }
    }
    return getGetUserWorkloadsConfigMapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse> getListUserWorkloadsConfigMapsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserWorkloadsConfigMaps",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse> getListUserWorkloadsConfigMapsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest, com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse> getListUserWorkloadsConfigMapsMethod;
    if ((getListUserWorkloadsConfigMapsMethod = EnvironmentsGrpc.getListUserWorkloadsConfigMapsMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getListUserWorkloadsConfigMapsMethod = EnvironmentsGrpc.getListUserWorkloadsConfigMapsMethod) == null) {
          EnvironmentsGrpc.getListUserWorkloadsConfigMapsMethod = getListUserWorkloadsConfigMapsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest, com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUserWorkloadsConfigMaps"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("ListUserWorkloadsConfigMaps"))
              .build();
        }
      }
    }
    return getListUserWorkloadsConfigMapsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> getUpdateUserWorkloadsConfigMapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUserWorkloadsConfigMap",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> getUpdateUserWorkloadsConfigMapMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest, com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> getUpdateUserWorkloadsConfigMapMethod;
    if ((getUpdateUserWorkloadsConfigMapMethod = EnvironmentsGrpc.getUpdateUserWorkloadsConfigMapMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getUpdateUserWorkloadsConfigMapMethod = EnvironmentsGrpc.getUpdateUserWorkloadsConfigMapMethod) == null) {
          EnvironmentsGrpc.getUpdateUserWorkloadsConfigMapMethod = getUpdateUserWorkloadsConfigMapMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest, com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUserWorkloadsConfigMap"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("UpdateUserWorkloadsConfigMap"))
              .build();
        }
      }
    }
    return getUpdateUserWorkloadsConfigMapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest,
      com.google.protobuf.Empty> getDeleteUserWorkloadsConfigMapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUserWorkloadsConfigMap",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest,
      com.google.protobuf.Empty> getDeleteUserWorkloadsConfigMapMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest, com.google.protobuf.Empty> getDeleteUserWorkloadsConfigMapMethod;
    if ((getDeleteUserWorkloadsConfigMapMethod = EnvironmentsGrpc.getDeleteUserWorkloadsConfigMapMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getDeleteUserWorkloadsConfigMapMethod = EnvironmentsGrpc.getDeleteUserWorkloadsConfigMapMethod) == null) {
          EnvironmentsGrpc.getDeleteUserWorkloadsConfigMapMethod = getDeleteUserWorkloadsConfigMapMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUserWorkloadsConfigMap"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("DeleteUserWorkloadsConfigMap"))
              .build();
        }
      }
    }
    return getDeleteUserWorkloadsConfigMapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest,
      com.google.longrunning.Operation> getSaveSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveSnapshot",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest,
      com.google.longrunning.Operation> getSaveSnapshotMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest, com.google.longrunning.Operation> getSaveSnapshotMethod;
    if ((getSaveSnapshotMethod = EnvironmentsGrpc.getSaveSnapshotMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getSaveSnapshotMethod = EnvironmentsGrpc.getSaveSnapshotMethod) == null) {
          EnvironmentsGrpc.getSaveSnapshotMethod = getSaveSnapshotMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SaveSnapshot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("SaveSnapshot"))
              .build();
        }
      }
    }
    return getSaveSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest,
      com.google.longrunning.Operation> getLoadSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoadSnapshot",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest,
      com.google.longrunning.Operation> getLoadSnapshotMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest, com.google.longrunning.Operation> getLoadSnapshotMethod;
    if ((getLoadSnapshotMethod = EnvironmentsGrpc.getLoadSnapshotMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getLoadSnapshotMethod = EnvironmentsGrpc.getLoadSnapshotMethod) == null) {
          EnvironmentsGrpc.getLoadSnapshotMethod = getLoadSnapshotMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LoadSnapshot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("LoadSnapshot"))
              .build();
        }
      }
    }
    return getLoadSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest,
      com.google.longrunning.Operation> getDatabaseFailoverMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DatabaseFailover",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest,
      com.google.longrunning.Operation> getDatabaseFailoverMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest, com.google.longrunning.Operation> getDatabaseFailoverMethod;
    if ((getDatabaseFailoverMethod = EnvironmentsGrpc.getDatabaseFailoverMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getDatabaseFailoverMethod = EnvironmentsGrpc.getDatabaseFailoverMethod) == null) {
          EnvironmentsGrpc.getDatabaseFailoverMethod = getDatabaseFailoverMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DatabaseFailover"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("DatabaseFailover"))
              .build();
        }
      }
    }
    return getDatabaseFailoverMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse> getFetchDatabasePropertiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchDatabaseProperties",
      requestType = com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest.class,
      responseType = com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest,
      com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse> getFetchDatabasePropertiesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest, com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse> getFetchDatabasePropertiesMethod;
    if ((getFetchDatabasePropertiesMethod = EnvironmentsGrpc.getFetchDatabasePropertiesMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getFetchDatabasePropertiesMethod = EnvironmentsGrpc.getFetchDatabasePropertiesMethod) == null) {
          EnvironmentsGrpc.getFetchDatabasePropertiesMethod = getFetchDatabasePropertiesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest, com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchDatabaseProperties"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("FetchDatabaseProperties"))
              .build();
        }
      }
    }
    return getFetchDatabasePropertiesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EnvironmentsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnvironmentsStub>() {
        @java.lang.Override
        public EnvironmentsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnvironmentsStub(channel, callOptions);
        }
      };
    return EnvironmentsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnvironmentsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnvironmentsBlockingStub>() {
        @java.lang.Override
        public EnvironmentsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnvironmentsBlockingStub(channel, callOptions);
        }
      };
    return EnvironmentsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EnvironmentsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnvironmentsFutureStub>() {
        @java.lang.Override
        public EnvironmentsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnvironmentsFutureStub(channel, callOptions);
        }
      };
    return EnvironmentsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Managed Apache Airflow Environments.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Create a new environment.
     * </pre>
     */
    default void createEnvironment(com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateEnvironmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get an existing environment.
     * </pre>
     */
    default void getEnvironment(com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.Environment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEnvironmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * List environments.
     * </pre>
     */
    default void listEnvironments(com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEnvironmentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update an environment.
     * </pre>
     */
    default void updateEnvironment(com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateEnvironmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Delete an environment.
     * </pre>
     */
    default void deleteEnvironment(com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteEnvironmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Restart Airflow web server.
     * </pre>
     */
    default void restartWebServer(com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRestartWebServerMethod(), responseObserver);
    }

    /**
     * <pre>
     * Check if an upgrade operation on the environment will succeed.
     * In case of problems detailed info can be found in the returned Operation.
     * </pre>
     */
    default void checkUpgrade(com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckUpgradeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Executes Airflow CLI command.
     * </pre>
     */
    default void executeAirflowCommand(com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExecuteAirflowCommandMethod(), responseObserver);
    }

    /**
     * <pre>
     * Stops Airflow CLI command execution.
     * </pre>
     */
    default void stopAirflowCommand(com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopAirflowCommandMethod(), responseObserver);
    }

    /**
     * <pre>
     * Polls Airflow CLI command execution and fetches logs.
     * </pre>
     */
    default void pollAirflowCommand(com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPollAirflowCommandMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists workloads in a Cloud Composer environment. Workload is a unit that
     * runs a single Composer component.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    default void listWorkloads(com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListWorkloadsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a user workloads Secret.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    default void createUserWorkloadsSecret(com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserWorkloadsSecretMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets an existing user workloads Secret.
     * Values of the "data" field in the response are cleared.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    default void getUserWorkloadsSecret(com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserWorkloadsSecretMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists user workloads Secrets.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    default void listUserWorkloadsSecrets(com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUserWorkloadsSecretsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a user workloads Secret.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    default void updateUserWorkloadsSecret(com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserWorkloadsSecretMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a user workloads Secret.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    default void deleteUserWorkloadsSecret(com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserWorkloadsSecretMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    default void createUserWorkloadsConfigMap(com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserWorkloadsConfigMapMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets an existing user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    default void getUserWorkloadsConfigMap(com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserWorkloadsConfigMapMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists user workloads ConfigMaps.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    default void listUserWorkloadsConfigMaps(com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUserWorkloadsConfigMapsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    default void updateUserWorkloadsConfigMap(com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserWorkloadsConfigMapMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    default void deleteUserWorkloadsConfigMap(com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserWorkloadsConfigMapMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a snapshots of a Cloud Composer environment.
     * As a result of this operation, snapshot of environment's state is stored
     * in a location specified in the SaveSnapshotRequest.
     * </pre>
     */
    default void saveSnapshot(com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaveSnapshotMethod(), responseObserver);
    }

    /**
     * <pre>
     * Loads a snapshot of a Cloud Composer environment.
     * As a result of this operation, a snapshot of environment's specified in
     * LoadSnapshotRequest is loaded into the environment.
     * </pre>
     */
    default void loadSnapshot(com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoadSnapshotMethod(), responseObserver);
    }

    /**
     * <pre>
     * Triggers database failover (only for highly resilient environments).
     * </pre>
     */
    default void databaseFailover(com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDatabaseFailoverMethod(), responseObserver);
    }

    /**
     * <pre>
     * Fetches database properties.
     * </pre>
     */
    default void fetchDatabaseProperties(com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchDatabasePropertiesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Environments.
   * <pre>
   * Managed Apache Airflow Environments.
   * </pre>
   */
  public static abstract class EnvironmentsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EnvironmentsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Environments.
   * <pre>
   * Managed Apache Airflow Environments.
   * </pre>
   */
  public static final class EnvironmentsStub
      extends io.grpc.stub.AbstractAsyncStub<EnvironmentsStub> {
    private EnvironmentsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a new environment.
     * </pre>
     */
    public void createEnvironment(com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEnvironmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get an existing environment.
     * </pre>
     */
    public void getEnvironment(com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.Environment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List environments.
     * </pre>
     */
    public void listEnvironments(com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEnvironmentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update an environment.
     * </pre>
     */
    public void updateEnvironment(com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEnvironmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Delete an environment.
     * </pre>
     */
    public void deleteEnvironment(com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEnvironmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Restart Airflow web server.
     * </pre>
     */
    public void restartWebServer(com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestartWebServerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Check if an upgrade operation on the environment will succeed.
     * In case of problems detailed info can be found in the returned Operation.
     * </pre>
     */
    public void checkUpgrade(com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckUpgradeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Executes Airflow CLI command.
     * </pre>
     */
    public void executeAirflowCommand(com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteAirflowCommandMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Stops Airflow CLI command execution.
     * </pre>
     */
    public void stopAirflowCommand(com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopAirflowCommandMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Polls Airflow CLI command execution and fetches logs.
     * </pre>
     */
    public void pollAirflowCommand(com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPollAirflowCommandMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists workloads in a Cloud Composer environment. Workload is a unit that
     * runs a single Composer component.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public void listWorkloads(com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkloadsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a user workloads Secret.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public void createUserWorkloadsSecret(com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserWorkloadsSecretMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets an existing user workloads Secret.
     * Values of the "data" field in the response are cleared.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public void getUserWorkloadsSecret(com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserWorkloadsSecretMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists user workloads Secrets.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public void listUserWorkloadsSecrets(com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUserWorkloadsSecretsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a user workloads Secret.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public void updateUserWorkloadsSecret(com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserWorkloadsSecretMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a user workloads Secret.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public void deleteUserWorkloadsSecret(com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserWorkloadsSecretMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public void createUserWorkloadsConfigMap(com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserWorkloadsConfigMapMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets an existing user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public void getUserWorkloadsConfigMap(com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserWorkloadsConfigMapMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists user workloads ConfigMaps.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public void listUserWorkloadsConfigMaps(com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUserWorkloadsConfigMapsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public void updateUserWorkloadsConfigMap(com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserWorkloadsConfigMapMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public void deleteUserWorkloadsConfigMap(com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserWorkloadsConfigMapMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a snapshots of a Cloud Composer environment.
     * As a result of this operation, snapshot of environment's state is stored
     * in a location specified in the SaveSnapshotRequest.
     * </pre>
     */
    public void saveSnapshot(com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveSnapshotMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Loads a snapshot of a Cloud Composer environment.
     * As a result of this operation, a snapshot of environment's specified in
     * LoadSnapshotRequest is loaded into the environment.
     * </pre>
     */
    public void loadSnapshot(com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoadSnapshotMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Triggers database failover (only for highly resilient environments).
     * </pre>
     */
    public void databaseFailover(com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDatabaseFailoverMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Fetches database properties.
     * </pre>
     */
    public void fetchDatabaseProperties(com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchDatabasePropertiesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Environments.
   * <pre>
   * Managed Apache Airflow Environments.
   * </pre>
   */
  public static final class EnvironmentsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EnvironmentsBlockingStub> {
    private EnvironmentsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a new environment.
     * </pre>
     */
    public com.google.longrunning.Operation createEnvironment(com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get an existing environment.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.Environment getEnvironment(com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List environments.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse listEnvironments(com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEnvironmentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update an environment.
     * </pre>
     */
    public com.google.longrunning.Operation updateEnvironment(com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Delete an environment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEnvironment(com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Restart Airflow web server.
     * </pre>
     */
    public com.google.longrunning.Operation restartWebServer(com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestartWebServerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Check if an upgrade operation on the environment will succeed.
     * In case of problems detailed info can be found in the returned Operation.
     * </pre>
     */
    public com.google.longrunning.Operation checkUpgrade(com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckUpgradeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Executes Airflow CLI command.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse executeAirflowCommand(com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteAirflowCommandMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Stops Airflow CLI command execution.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse stopAirflowCommand(com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopAirflowCommandMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Polls Airflow CLI command execution and fetches logs.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse pollAirflowCommand(com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPollAirflowCommandMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists workloads in a Cloud Composer environment. Workload is a unit that
     * runs a single Composer component.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse listWorkloads(com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkloadsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a user workloads Secret.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret createUserWorkloadsSecret(com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserWorkloadsSecretMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets an existing user workloads Secret.
     * Values of the "data" field in the response are cleared.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret getUserWorkloadsSecret(com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserWorkloadsSecretMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists user workloads Secrets.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse listUserWorkloadsSecrets(com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserWorkloadsSecretsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a user workloads Secret.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret updateUserWorkloadsSecret(com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserWorkloadsSecretMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a user workloads Secret.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUserWorkloadsSecret(com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserWorkloadsSecretMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap createUserWorkloadsConfigMap(com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserWorkloadsConfigMapMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets an existing user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap getUserWorkloadsConfigMap(com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserWorkloadsConfigMapMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists user workloads ConfigMaps.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse listUserWorkloadsConfigMaps(com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserWorkloadsConfigMapsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap updateUserWorkloadsConfigMap(com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserWorkloadsConfigMapMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUserWorkloadsConfigMap(com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserWorkloadsConfigMapMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a snapshots of a Cloud Composer environment.
     * As a result of this operation, snapshot of environment's state is stored
     * in a location specified in the SaveSnapshotRequest.
     * </pre>
     */
    public com.google.longrunning.Operation saveSnapshot(com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveSnapshotMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Loads a snapshot of a Cloud Composer environment.
     * As a result of this operation, a snapshot of environment's specified in
     * LoadSnapshotRequest is loaded into the environment.
     * </pre>
     */
    public com.google.longrunning.Operation loadSnapshot(com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoadSnapshotMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Triggers database failover (only for highly resilient environments).
     * </pre>
     */
    public com.google.longrunning.Operation databaseFailover(com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDatabaseFailoverMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Fetches database properties.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse fetchDatabaseProperties(com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchDatabasePropertiesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Environments.
   * <pre>
   * Managed Apache Airflow Environments.
   * </pre>
   */
  public static final class EnvironmentsFutureStub
      extends io.grpc.stub.AbstractFutureStub<EnvironmentsFutureStub> {
    private EnvironmentsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a new environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createEnvironment(
        com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get an existing environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.Environment> getEnvironment(
        com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List environments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse> listEnvironments(
        com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEnvironmentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update an environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateEnvironment(
        com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Delete an environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteEnvironment(
        com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Restart Airflow web server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> restartWebServer(
        com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestartWebServerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Check if an upgrade operation on the environment will succeed.
     * In case of problems detailed info can be found in the returned Operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> checkUpgrade(
        com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckUpgradeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Executes Airflow CLI command.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse> executeAirflowCommand(
        com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteAirflowCommandMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Stops Airflow CLI command execution.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse> stopAirflowCommand(
        com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopAirflowCommandMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Polls Airflow CLI command execution and fetches logs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse> pollAirflowCommand(
        com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPollAirflowCommandMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists workloads in a Cloud Composer environment. Workload is a unit that
     * runs a single Composer component.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse> listWorkloads(
        com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkloadsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a user workloads Secret.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> createUserWorkloadsSecret(
        com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserWorkloadsSecretMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets an existing user workloads Secret.
     * Values of the "data" field in the response are cleared.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> getUserWorkloadsSecret(
        com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserWorkloadsSecretMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists user workloads Secrets.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse> listUserWorkloadsSecrets(
        com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUserWorkloadsSecretsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a user workloads Secret.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret> updateUserWorkloadsSecret(
        com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserWorkloadsSecretMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a user workloads Secret.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteUserWorkloadsSecret(
        com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserWorkloadsSecretMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> createUserWorkloadsConfigMap(
        com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserWorkloadsConfigMapMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets an existing user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> getUserWorkloadsConfigMap(
        com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserWorkloadsConfigMapMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists user workloads ConfigMaps.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse> listUserWorkloadsConfigMaps(
        com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUserWorkloadsConfigMapsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap> updateUserWorkloadsConfigMap(
        com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserWorkloadsConfigMapMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a user workloads ConfigMap.
     * This method is supported for Cloud Composer environments in versions
     * composer-3.*.*-airflow-*.*.* and newer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteUserWorkloadsConfigMap(
        com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserWorkloadsConfigMapMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a snapshots of a Cloud Composer environment.
     * As a result of this operation, snapshot of environment's state is stored
     * in a location specified in the SaveSnapshotRequest.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> saveSnapshot(
        com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveSnapshotMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Loads a snapshot of a Cloud Composer environment.
     * As a result of this operation, a snapshot of environment's specified in
     * LoadSnapshotRequest is loaded into the environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> loadSnapshot(
        com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoadSnapshotMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Triggers database failover (only for highly resilient environments).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> databaseFailover(
        com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDatabaseFailoverMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Fetches database properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse> fetchDatabaseProperties(
        com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchDatabasePropertiesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ENVIRONMENT = 0;
  private static final int METHODID_GET_ENVIRONMENT = 1;
  private static final int METHODID_LIST_ENVIRONMENTS = 2;
  private static final int METHODID_UPDATE_ENVIRONMENT = 3;
  private static final int METHODID_DELETE_ENVIRONMENT = 4;
  private static final int METHODID_RESTART_WEB_SERVER = 5;
  private static final int METHODID_CHECK_UPGRADE = 6;
  private static final int METHODID_EXECUTE_AIRFLOW_COMMAND = 7;
  private static final int METHODID_STOP_AIRFLOW_COMMAND = 8;
  private static final int METHODID_POLL_AIRFLOW_COMMAND = 9;
  private static final int METHODID_LIST_WORKLOADS = 10;
  private static final int METHODID_CREATE_USER_WORKLOADS_SECRET = 11;
  private static final int METHODID_GET_USER_WORKLOADS_SECRET = 12;
  private static final int METHODID_LIST_USER_WORKLOADS_SECRETS = 13;
  private static final int METHODID_UPDATE_USER_WORKLOADS_SECRET = 14;
  private static final int METHODID_DELETE_USER_WORKLOADS_SECRET = 15;
  private static final int METHODID_CREATE_USER_WORKLOADS_CONFIG_MAP = 16;
  private static final int METHODID_GET_USER_WORKLOADS_CONFIG_MAP = 17;
  private static final int METHODID_LIST_USER_WORKLOADS_CONFIG_MAPS = 18;
  private static final int METHODID_UPDATE_USER_WORKLOADS_CONFIG_MAP = 19;
  private static final int METHODID_DELETE_USER_WORKLOADS_CONFIG_MAP = 20;
  private static final int METHODID_SAVE_SNAPSHOT = 21;
  private static final int METHODID_LOAD_SNAPSHOT = 22;
  private static final int METHODID_DATABASE_FAILOVER = 23;
  private static final int METHODID_FETCH_DATABASE_PROPERTIES = 24;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_CREATE_ENVIRONMENT:
          serviceImpl.createEnvironment((com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ENVIRONMENT:
          serviceImpl.getEnvironment((com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.Environment>) responseObserver);
          break;
        case METHODID_LIST_ENVIRONMENTS:
          serviceImpl.listEnvironments((com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_ENVIRONMENT:
          serviceImpl.updateEnvironment((com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENVIRONMENT:
          serviceImpl.deleteEnvironment((com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTART_WEB_SERVER:
          serviceImpl.restartWebServer((com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CHECK_UPGRADE:
          serviceImpl.checkUpgrade((com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXECUTE_AIRFLOW_COMMAND:
          serviceImpl.executeAirflowCommand((com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse>) responseObserver);
          break;
        case METHODID_STOP_AIRFLOW_COMMAND:
          serviceImpl.stopAirflowCommand((com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse>) responseObserver);
          break;
        case METHODID_POLL_AIRFLOW_COMMAND:
          serviceImpl.pollAirflowCommand((com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse>) responseObserver);
          break;
        case METHODID_LIST_WORKLOADS:
          serviceImpl.listWorkloads((com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse>) responseObserver);
          break;
        case METHODID_CREATE_USER_WORKLOADS_SECRET:
          serviceImpl.createUserWorkloadsSecret((com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret>) responseObserver);
          break;
        case METHODID_GET_USER_WORKLOADS_SECRET:
          serviceImpl.getUserWorkloadsSecret((com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret>) responseObserver);
          break;
        case METHODID_LIST_USER_WORKLOADS_SECRETS:
          serviceImpl.listUserWorkloadsSecrets((com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER_WORKLOADS_SECRET:
          serviceImpl.updateUserWorkloadsSecret((com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret>) responseObserver);
          break;
        case METHODID_DELETE_USER_WORKLOADS_SECRET:
          serviceImpl.deleteUserWorkloadsSecret((com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_USER_WORKLOADS_CONFIG_MAP:
          serviceImpl.createUserWorkloadsConfigMap((com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap>) responseObserver);
          break;
        case METHODID_GET_USER_WORKLOADS_CONFIG_MAP:
          serviceImpl.getUserWorkloadsConfigMap((com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap>) responseObserver);
          break;
        case METHODID_LIST_USER_WORKLOADS_CONFIG_MAPS:
          serviceImpl.listUserWorkloadsConfigMaps((com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER_WORKLOADS_CONFIG_MAP:
          serviceImpl.updateUserWorkloadsConfigMap((com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap>) responseObserver);
          break;
        case METHODID_DELETE_USER_WORKLOADS_CONFIG_MAP:
          serviceImpl.deleteUserWorkloadsConfigMap((com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SAVE_SNAPSHOT:
          serviceImpl.saveSnapshot((com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LOAD_SNAPSHOT:
          serviceImpl.loadSnapshot((com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DATABASE_FAILOVER:
          serviceImpl.databaseFailover((com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FETCH_DATABASE_PROPERTIES:
          serviceImpl.fetchDatabaseProperties((com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse>) responseObserver);
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
          getCreateEnvironmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_ENVIRONMENT)))
        .addMethod(
          getGetEnvironmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.Environment>(
                service, METHODID_GET_ENVIRONMENT)))
        .addMethod(
          getListEnvironmentsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse>(
                service, METHODID_LIST_ENVIRONMENTS)))
        .addMethod(
          getUpdateEnvironmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_ENVIRONMENT)))
        .addMethod(
          getDeleteEnvironmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_ENVIRONMENT)))
        .addMethod(
          getRestartWebServerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest,
              com.google.longrunning.Operation>(
                service, METHODID_RESTART_WEB_SERVER)))
        .addMethod(
          getCheckUpgradeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CHECK_UPGRADE)))
        .addMethod(
          getExecuteAirflowCommandMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse>(
                service, METHODID_EXECUTE_AIRFLOW_COMMAND)))
        .addMethod(
          getStopAirflowCommandMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse>(
                service, METHODID_STOP_AIRFLOW_COMMAND)))
        .addMethod(
          getPollAirflowCommandMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse>(
                service, METHODID_POLL_AIRFLOW_COMMAND)))
        .addMethod(
          getListWorkloadsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse>(
                service, METHODID_LIST_WORKLOADS)))
        .addMethod(
          getCreateUserWorkloadsSecretMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret>(
                service, METHODID_CREATE_USER_WORKLOADS_SECRET)))
        .addMethod(
          getGetUserWorkloadsSecretMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret>(
                service, METHODID_GET_USER_WORKLOADS_SECRET)))
        .addMethod(
          getListUserWorkloadsSecretsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse>(
                service, METHODID_LIST_USER_WORKLOADS_SECRETS)))
        .addMethod(
          getUpdateUserWorkloadsSecretMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret>(
                service, METHODID_UPDATE_USER_WORKLOADS_SECRET)))
        .addMethod(
          getDeleteUserWorkloadsSecretMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_USER_WORKLOADS_SECRET)))
        .addMethod(
          getCreateUserWorkloadsConfigMapMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap>(
                service, METHODID_CREATE_USER_WORKLOADS_CONFIG_MAP)))
        .addMethod(
          getGetUserWorkloadsConfigMapMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap>(
                service, METHODID_GET_USER_WORKLOADS_CONFIG_MAP)))
        .addMethod(
          getListUserWorkloadsConfigMapsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse>(
                service, METHODID_LIST_USER_WORKLOADS_CONFIG_MAPS)))
        .addMethod(
          getUpdateUserWorkloadsConfigMapMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap>(
                service, METHODID_UPDATE_USER_WORKLOADS_CONFIG_MAP)))
        .addMethod(
          getDeleteUserWorkloadsConfigMapMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_USER_WORKLOADS_CONFIG_MAP)))
        .addMethod(
          getSaveSnapshotMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest,
              com.google.longrunning.Operation>(
                service, METHODID_SAVE_SNAPSHOT)))
        .addMethod(
          getLoadSnapshotMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest,
              com.google.longrunning.Operation>(
                service, METHODID_LOAD_SNAPSHOT)))
        .addMethod(
          getDatabaseFailoverMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DATABASE_FAILOVER)))
        .addMethod(
          getFetchDatabasePropertiesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest,
              com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse>(
                service, METHODID_FETCH_DATABASE_PROPERTIES)))
        .build();
  }

  private static abstract class EnvironmentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnvironmentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.orchestration.airflow.service.v1beta1.EnvironmentsOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Environments");
    }
  }

  private static final class EnvironmentsFileDescriptorSupplier
      extends EnvironmentsBaseDescriptorSupplier {
    EnvironmentsFileDescriptorSupplier() {}
  }

  private static final class EnvironmentsMethodDescriptorSupplier
      extends EnvironmentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EnvironmentsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EnvironmentsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EnvironmentsFileDescriptorSupplier())
              .addMethod(getCreateEnvironmentMethod())
              .addMethod(getGetEnvironmentMethod())
              .addMethod(getListEnvironmentsMethod())
              .addMethod(getUpdateEnvironmentMethod())
              .addMethod(getDeleteEnvironmentMethod())
              .addMethod(getRestartWebServerMethod())
              .addMethod(getCheckUpgradeMethod())
              .addMethod(getExecuteAirflowCommandMethod())
              .addMethod(getStopAirflowCommandMethod())
              .addMethod(getPollAirflowCommandMethod())
              .addMethod(getListWorkloadsMethod())
              .addMethod(getCreateUserWorkloadsSecretMethod())
              .addMethod(getGetUserWorkloadsSecretMethod())
              .addMethod(getListUserWorkloadsSecretsMethod())
              .addMethod(getUpdateUserWorkloadsSecretMethod())
              .addMethod(getDeleteUserWorkloadsSecretMethod())
              .addMethod(getCreateUserWorkloadsConfigMapMethod())
              .addMethod(getGetUserWorkloadsConfigMapMethod())
              .addMethod(getListUserWorkloadsConfigMapsMethod())
              .addMethod(getUpdateUserWorkloadsConfigMapMethod())
              .addMethod(getDeleteUserWorkloadsConfigMapMethod())
              .addMethod(getSaveSnapshotMethod())
              .addMethod(getLoadSnapshotMethod())
              .addMethod(getDatabaseFailoverMethod())
              .addMethod(getFetchDatabasePropertiesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
