package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * TensorboardService
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/tensorboard_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TensorboardServiceGrpc {

  private TensorboardServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1beta1.TensorboardService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateTensorboardRequest,
      com.google.longrunning.Operation> getCreateTensorboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTensorboard",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateTensorboardRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateTensorboardRequest,
      com.google.longrunning.Operation> getCreateTensorboardMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateTensorboardRequest, com.google.longrunning.Operation> getCreateTensorboardMethod;
    if ((getCreateTensorboardMethod = TensorboardServiceGrpc.getCreateTensorboardMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getCreateTensorboardMethod = TensorboardServiceGrpc.getCreateTensorboardMethod) == null) {
          TensorboardServiceGrpc.getCreateTensorboardMethod = getCreateTensorboardMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.CreateTensorboardRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTensorboard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.CreateTensorboardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("CreateTensorboard"))
              .build();
        }
      }
    }
    return getCreateTensorboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetTensorboardRequest,
      com.google.cloud.aiplatform.v1beta1.Tensorboard> getGetTensorboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTensorboard",
      requestType = com.google.cloud.aiplatform.v1beta1.GetTensorboardRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Tensorboard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetTensorboardRequest,
      com.google.cloud.aiplatform.v1beta1.Tensorboard> getGetTensorboardMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetTensorboardRequest, com.google.cloud.aiplatform.v1beta1.Tensorboard> getGetTensorboardMethod;
    if ((getGetTensorboardMethod = TensorboardServiceGrpc.getGetTensorboardMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getGetTensorboardMethod = TensorboardServiceGrpc.getGetTensorboardMethod) == null) {
          TensorboardServiceGrpc.getGetTensorboardMethod = getGetTensorboardMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.GetTensorboardRequest, com.google.cloud.aiplatform.v1beta1.Tensorboard>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTensorboard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.GetTensorboardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.Tensorboard.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("GetTensorboard"))
              .build();
        }
      }
    }
    return getGetTensorboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRequest,
      com.google.longrunning.Operation> getUpdateTensorboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTensorboard",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRequest,
      com.google.longrunning.Operation> getUpdateTensorboardMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRequest, com.google.longrunning.Operation> getUpdateTensorboardMethod;
    if ((getUpdateTensorboardMethod = TensorboardServiceGrpc.getUpdateTensorboardMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getUpdateTensorboardMethod = TensorboardServiceGrpc.getUpdateTensorboardMethod) == null) {
          TensorboardServiceGrpc.getUpdateTensorboardMethod = getUpdateTensorboardMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTensorboard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("UpdateTensorboard"))
              .build();
        }
      }
    }
    return getUpdateTensorboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListTensorboardsRequest,
      com.google.cloud.aiplatform.v1beta1.ListTensorboardsResponse> getListTensorboardsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTensorboards",
      requestType = com.google.cloud.aiplatform.v1beta1.ListTensorboardsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListTensorboardsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListTensorboardsRequest,
      com.google.cloud.aiplatform.v1beta1.ListTensorboardsResponse> getListTensorboardsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListTensorboardsRequest, com.google.cloud.aiplatform.v1beta1.ListTensorboardsResponse> getListTensorboardsMethod;
    if ((getListTensorboardsMethod = TensorboardServiceGrpc.getListTensorboardsMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getListTensorboardsMethod = TensorboardServiceGrpc.getListTensorboardsMethod) == null) {
          TensorboardServiceGrpc.getListTensorboardsMethod = getListTensorboardsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.ListTensorboardsRequest, com.google.cloud.aiplatform.v1beta1.ListTensorboardsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTensorboards"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ListTensorboardsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ListTensorboardsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("ListTensorboards"))
              .build();
        }
      }
    }
    return getListTensorboardsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRequest,
      com.google.longrunning.Operation> getDeleteTensorboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTensorboard",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRequest,
      com.google.longrunning.Operation> getDeleteTensorboardMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRequest, com.google.longrunning.Operation> getDeleteTensorboardMethod;
    if ((getDeleteTensorboardMethod = TensorboardServiceGrpc.getDeleteTensorboardMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getDeleteTensorboardMethod = TensorboardServiceGrpc.getDeleteTensorboardMethod) == null) {
          TensorboardServiceGrpc.getDeleteTensorboardMethod = getDeleteTensorboardMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTensorboard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("DeleteTensorboard"))
              .build();
        }
      }
    }
    return getDeleteTensorboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateTensorboardExperimentRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> getCreateTensorboardExperimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTensorboardExperiment",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateTensorboardExperimentRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.TensorboardExperiment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateTensorboardExperimentRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> getCreateTensorboardExperimentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateTensorboardExperimentRequest, com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> getCreateTensorboardExperimentMethod;
    if ((getCreateTensorboardExperimentMethod = TensorboardServiceGrpc.getCreateTensorboardExperimentMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getCreateTensorboardExperimentMethod = TensorboardServiceGrpc.getCreateTensorboardExperimentMethod) == null) {
          TensorboardServiceGrpc.getCreateTensorboardExperimentMethod = getCreateTensorboardExperimentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.CreateTensorboardExperimentRequest, com.google.cloud.aiplatform.v1beta1.TensorboardExperiment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTensorboardExperiment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.CreateTensorboardExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.TensorboardExperiment.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("CreateTensorboardExperiment"))
              .build();
        }
      }
    }
    return getCreateTensorboardExperimentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetTensorboardExperimentRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> getGetTensorboardExperimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTensorboardExperiment",
      requestType = com.google.cloud.aiplatform.v1beta1.GetTensorboardExperimentRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.TensorboardExperiment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetTensorboardExperimentRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> getGetTensorboardExperimentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetTensorboardExperimentRequest, com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> getGetTensorboardExperimentMethod;
    if ((getGetTensorboardExperimentMethod = TensorboardServiceGrpc.getGetTensorboardExperimentMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getGetTensorboardExperimentMethod = TensorboardServiceGrpc.getGetTensorboardExperimentMethod) == null) {
          TensorboardServiceGrpc.getGetTensorboardExperimentMethod = getGetTensorboardExperimentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.GetTensorboardExperimentRequest, com.google.cloud.aiplatform.v1beta1.TensorboardExperiment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTensorboardExperiment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.GetTensorboardExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.TensorboardExperiment.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("GetTensorboardExperiment"))
              .build();
        }
      }
    }
    return getGetTensorboardExperimentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardExperimentRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> getUpdateTensorboardExperimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTensorboardExperiment",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateTensorboardExperimentRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.TensorboardExperiment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardExperimentRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> getUpdateTensorboardExperimentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardExperimentRequest, com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> getUpdateTensorboardExperimentMethod;
    if ((getUpdateTensorboardExperimentMethod = TensorboardServiceGrpc.getUpdateTensorboardExperimentMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getUpdateTensorboardExperimentMethod = TensorboardServiceGrpc.getUpdateTensorboardExperimentMethod) == null) {
          TensorboardServiceGrpc.getUpdateTensorboardExperimentMethod = getUpdateTensorboardExperimentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardExperimentRequest, com.google.cloud.aiplatform.v1beta1.TensorboardExperiment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTensorboardExperiment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.UpdateTensorboardExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.TensorboardExperiment.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("UpdateTensorboardExperiment"))
              .build();
        }
      }
    }
    return getUpdateTensorboardExperimentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsRequest,
      com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsResponse> getListTensorboardExperimentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTensorboardExperiments",
      requestType = com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsRequest,
      com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsResponse> getListTensorboardExperimentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsRequest, com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsResponse> getListTensorboardExperimentsMethod;
    if ((getListTensorboardExperimentsMethod = TensorboardServiceGrpc.getListTensorboardExperimentsMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getListTensorboardExperimentsMethod = TensorboardServiceGrpc.getListTensorboardExperimentsMethod) == null) {
          TensorboardServiceGrpc.getListTensorboardExperimentsMethod = getListTensorboardExperimentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsRequest, com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTensorboardExperiments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("ListTensorboardExperiments"))
              .build();
        }
      }
    }
    return getListTensorboardExperimentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardExperimentRequest,
      com.google.longrunning.Operation> getDeleteTensorboardExperimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTensorboardExperiment",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteTensorboardExperimentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardExperimentRequest,
      com.google.longrunning.Operation> getDeleteTensorboardExperimentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardExperimentRequest, com.google.longrunning.Operation> getDeleteTensorboardExperimentMethod;
    if ((getDeleteTensorboardExperimentMethod = TensorboardServiceGrpc.getDeleteTensorboardExperimentMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getDeleteTensorboardExperimentMethod = TensorboardServiceGrpc.getDeleteTensorboardExperimentMethod) == null) {
          TensorboardServiceGrpc.getDeleteTensorboardExperimentMethod = getDeleteTensorboardExperimentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardExperimentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTensorboardExperiment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.DeleteTensorboardExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("DeleteTensorboardExperiment"))
              .build();
        }
      }
    }
    return getDeleteTensorboardExperimentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateTensorboardRunRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardRun> getCreateTensorboardRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTensorboardRun",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateTensorboardRunRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.TensorboardRun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateTensorboardRunRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardRun> getCreateTensorboardRunMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateTensorboardRunRequest, com.google.cloud.aiplatform.v1beta1.TensorboardRun> getCreateTensorboardRunMethod;
    if ((getCreateTensorboardRunMethod = TensorboardServiceGrpc.getCreateTensorboardRunMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getCreateTensorboardRunMethod = TensorboardServiceGrpc.getCreateTensorboardRunMethod) == null) {
          TensorboardServiceGrpc.getCreateTensorboardRunMethod = getCreateTensorboardRunMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.CreateTensorboardRunRequest, com.google.cloud.aiplatform.v1beta1.TensorboardRun>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTensorboardRun"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.CreateTensorboardRunRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.TensorboardRun.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("CreateTensorboardRun"))
              .build();
        }
      }
    }
    return getCreateTensorboardRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsRequest,
      com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsResponse> getBatchCreateTensorboardRunsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateTensorboardRuns",
      requestType = com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsRequest,
      com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsResponse> getBatchCreateTensorboardRunsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsRequest, com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsResponse> getBatchCreateTensorboardRunsMethod;
    if ((getBatchCreateTensorboardRunsMethod = TensorboardServiceGrpc.getBatchCreateTensorboardRunsMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getBatchCreateTensorboardRunsMethod = TensorboardServiceGrpc.getBatchCreateTensorboardRunsMethod) == null) {
          TensorboardServiceGrpc.getBatchCreateTensorboardRunsMethod = getBatchCreateTensorboardRunsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsRequest, com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchCreateTensorboardRuns"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("BatchCreateTensorboardRuns"))
              .build();
        }
      }
    }
    return getBatchCreateTensorboardRunsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetTensorboardRunRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardRun> getGetTensorboardRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTensorboardRun",
      requestType = com.google.cloud.aiplatform.v1beta1.GetTensorboardRunRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.TensorboardRun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetTensorboardRunRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardRun> getGetTensorboardRunMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetTensorboardRunRequest, com.google.cloud.aiplatform.v1beta1.TensorboardRun> getGetTensorboardRunMethod;
    if ((getGetTensorboardRunMethod = TensorboardServiceGrpc.getGetTensorboardRunMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getGetTensorboardRunMethod = TensorboardServiceGrpc.getGetTensorboardRunMethod) == null) {
          TensorboardServiceGrpc.getGetTensorboardRunMethod = getGetTensorboardRunMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.GetTensorboardRunRequest, com.google.cloud.aiplatform.v1beta1.TensorboardRun>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTensorboardRun"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.GetTensorboardRunRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.TensorboardRun.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("GetTensorboardRun"))
              .build();
        }
      }
    }
    return getGetTensorboardRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRunRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardRun> getUpdateTensorboardRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTensorboardRun",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRunRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.TensorboardRun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRunRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardRun> getUpdateTensorboardRunMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRunRequest, com.google.cloud.aiplatform.v1beta1.TensorboardRun> getUpdateTensorboardRunMethod;
    if ((getUpdateTensorboardRunMethod = TensorboardServiceGrpc.getUpdateTensorboardRunMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getUpdateTensorboardRunMethod = TensorboardServiceGrpc.getUpdateTensorboardRunMethod) == null) {
          TensorboardServiceGrpc.getUpdateTensorboardRunMethod = getUpdateTensorboardRunMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRunRequest, com.google.cloud.aiplatform.v1beta1.TensorboardRun>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTensorboardRun"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRunRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.TensorboardRun.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("UpdateTensorboardRun"))
              .build();
        }
      }
    }
    return getUpdateTensorboardRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsRequest,
      com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsResponse> getListTensorboardRunsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTensorboardRuns",
      requestType = com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsRequest,
      com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsResponse> getListTensorboardRunsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsRequest, com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsResponse> getListTensorboardRunsMethod;
    if ((getListTensorboardRunsMethod = TensorboardServiceGrpc.getListTensorboardRunsMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getListTensorboardRunsMethod = TensorboardServiceGrpc.getListTensorboardRunsMethod) == null) {
          TensorboardServiceGrpc.getListTensorboardRunsMethod = getListTensorboardRunsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsRequest, com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTensorboardRuns"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("ListTensorboardRuns"))
              .build();
        }
      }
    }
    return getListTensorboardRunsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRunRequest,
      com.google.longrunning.Operation> getDeleteTensorboardRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTensorboardRun",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRunRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRunRequest,
      com.google.longrunning.Operation> getDeleteTensorboardRunMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRunRequest, com.google.longrunning.Operation> getDeleteTensorboardRunMethod;
    if ((getDeleteTensorboardRunMethod = TensorboardServiceGrpc.getDeleteTensorboardRunMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getDeleteTensorboardRunMethod = TensorboardServiceGrpc.getDeleteTensorboardRunMethod) == null) {
          TensorboardServiceGrpc.getDeleteTensorboardRunMethod = getDeleteTensorboardRunMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRunRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTensorboardRun"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRunRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("DeleteTensorboardRun"))
              .build();
        }
      }
    }
    return getDeleteTensorboardRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesRequest,
      com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesResponse> getBatchCreateTensorboardTimeSeriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateTensorboardTimeSeries",
      requestType = com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesRequest,
      com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesResponse> getBatchCreateTensorboardTimeSeriesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesRequest, com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesResponse> getBatchCreateTensorboardTimeSeriesMethod;
    if ((getBatchCreateTensorboardTimeSeriesMethod = TensorboardServiceGrpc.getBatchCreateTensorboardTimeSeriesMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getBatchCreateTensorboardTimeSeriesMethod = TensorboardServiceGrpc.getBatchCreateTensorboardTimeSeriesMethod) == null) {
          TensorboardServiceGrpc.getBatchCreateTensorboardTimeSeriesMethod = getBatchCreateTensorboardTimeSeriesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesRequest, com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchCreateTensorboardTimeSeries"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("BatchCreateTensorboardTimeSeries"))
              .build();
        }
      }
    }
    return getBatchCreateTensorboardTimeSeriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateTensorboardTimeSeriesRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> getCreateTensorboardTimeSeriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTensorboardTimeSeries",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateTensorboardTimeSeriesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateTensorboardTimeSeriesRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> getCreateTensorboardTimeSeriesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.CreateTensorboardTimeSeriesRequest, com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> getCreateTensorboardTimeSeriesMethod;
    if ((getCreateTensorboardTimeSeriesMethod = TensorboardServiceGrpc.getCreateTensorboardTimeSeriesMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getCreateTensorboardTimeSeriesMethod = TensorboardServiceGrpc.getCreateTensorboardTimeSeriesMethod) == null) {
          TensorboardServiceGrpc.getCreateTensorboardTimeSeriesMethod = getCreateTensorboardTimeSeriesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.CreateTensorboardTimeSeriesRequest, com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTensorboardTimeSeries"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.CreateTensorboardTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("CreateTensorboardTimeSeries"))
              .build();
        }
      }
    }
    return getCreateTensorboardTimeSeriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetTensorboardTimeSeriesRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> getGetTensorboardTimeSeriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTensorboardTimeSeries",
      requestType = com.google.cloud.aiplatform.v1beta1.GetTensorboardTimeSeriesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetTensorboardTimeSeriesRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> getGetTensorboardTimeSeriesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.GetTensorboardTimeSeriesRequest, com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> getGetTensorboardTimeSeriesMethod;
    if ((getGetTensorboardTimeSeriesMethod = TensorboardServiceGrpc.getGetTensorboardTimeSeriesMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getGetTensorboardTimeSeriesMethod = TensorboardServiceGrpc.getGetTensorboardTimeSeriesMethod) == null) {
          TensorboardServiceGrpc.getGetTensorboardTimeSeriesMethod = getGetTensorboardTimeSeriesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.GetTensorboardTimeSeriesRequest, com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTensorboardTimeSeries"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.GetTensorboardTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("GetTensorboardTimeSeries"))
              .build();
        }
      }
    }
    return getGetTensorboardTimeSeriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardTimeSeriesRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> getUpdateTensorboardTimeSeriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTensorboardTimeSeries",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateTensorboardTimeSeriesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardTimeSeriesRequest,
      com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> getUpdateTensorboardTimeSeriesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardTimeSeriesRequest, com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> getUpdateTensorboardTimeSeriesMethod;
    if ((getUpdateTensorboardTimeSeriesMethod = TensorboardServiceGrpc.getUpdateTensorboardTimeSeriesMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getUpdateTensorboardTimeSeriesMethod = TensorboardServiceGrpc.getUpdateTensorboardTimeSeriesMethod) == null) {
          TensorboardServiceGrpc.getUpdateTensorboardTimeSeriesMethod = getUpdateTensorboardTimeSeriesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.UpdateTensorboardTimeSeriesRequest, com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTensorboardTimeSeries"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.UpdateTensorboardTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("UpdateTensorboardTimeSeries"))
              .build();
        }
      }
    }
    return getUpdateTensorboardTimeSeriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesRequest,
      com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesResponse> getListTensorboardTimeSeriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTensorboardTimeSeries",
      requestType = com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesRequest,
      com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesResponse> getListTensorboardTimeSeriesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesRequest, com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesResponse> getListTensorboardTimeSeriesMethod;
    if ((getListTensorboardTimeSeriesMethod = TensorboardServiceGrpc.getListTensorboardTimeSeriesMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getListTensorboardTimeSeriesMethod = TensorboardServiceGrpc.getListTensorboardTimeSeriesMethod) == null) {
          TensorboardServiceGrpc.getListTensorboardTimeSeriesMethod = getListTensorboardTimeSeriesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesRequest, com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTensorboardTimeSeries"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("ListTensorboardTimeSeries"))
              .build();
        }
      }
    }
    return getListTensorboardTimeSeriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardTimeSeriesRequest,
      com.google.longrunning.Operation> getDeleteTensorboardTimeSeriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTensorboardTimeSeries",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteTensorboardTimeSeriesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardTimeSeriesRequest,
      com.google.longrunning.Operation> getDeleteTensorboardTimeSeriesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardTimeSeriesRequest, com.google.longrunning.Operation> getDeleteTensorboardTimeSeriesMethod;
    if ((getDeleteTensorboardTimeSeriesMethod = TensorboardServiceGrpc.getDeleteTensorboardTimeSeriesMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getDeleteTensorboardTimeSeriesMethod = TensorboardServiceGrpc.getDeleteTensorboardTimeSeriesMethod) == null) {
          TensorboardServiceGrpc.getDeleteTensorboardTimeSeriesMethod = getDeleteTensorboardTimeSeriesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.DeleteTensorboardTimeSeriesRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTensorboardTimeSeries"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.DeleteTensorboardTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("DeleteTensorboardTimeSeries"))
              .build();
        }
      }
    }
    return getDeleteTensorboardTimeSeriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest,
      com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataResponse> getBatchReadTensorboardTimeSeriesDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchReadTensorboardTimeSeriesData",
      requestType = com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest,
      com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataResponse> getBatchReadTensorboardTimeSeriesDataMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest, com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataResponse> getBatchReadTensorboardTimeSeriesDataMethod;
    if ((getBatchReadTensorboardTimeSeriesDataMethod = TensorboardServiceGrpc.getBatchReadTensorboardTimeSeriesDataMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getBatchReadTensorboardTimeSeriesDataMethod = TensorboardServiceGrpc.getBatchReadTensorboardTimeSeriesDataMethod) == null) {
          TensorboardServiceGrpc.getBatchReadTensorboardTimeSeriesDataMethod = getBatchReadTensorboardTimeSeriesDataMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest, com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchReadTensorboardTimeSeriesData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("BatchReadTensorboardTimeSeriesData"))
              .build();
        }
      }
    }
    return getBatchReadTensorboardTimeSeriesDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataRequest,
      com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataResponse> getReadTensorboardTimeSeriesDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadTensorboardTimeSeriesData",
      requestType = com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataRequest,
      com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataResponse> getReadTensorboardTimeSeriesDataMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataRequest, com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataResponse> getReadTensorboardTimeSeriesDataMethod;
    if ((getReadTensorboardTimeSeriesDataMethod = TensorboardServiceGrpc.getReadTensorboardTimeSeriesDataMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getReadTensorboardTimeSeriesDataMethod = TensorboardServiceGrpc.getReadTensorboardTimeSeriesDataMethod) == null) {
          TensorboardServiceGrpc.getReadTensorboardTimeSeriesDataMethod = getReadTensorboardTimeSeriesDataMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataRequest, com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadTensorboardTimeSeriesData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("ReadTensorboardTimeSeriesData"))
              .build();
        }
      }
    }
    return getReadTensorboardTimeSeriesDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataRequest,
      com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataResponse> getReadTensorboardBlobDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadTensorboardBlobData",
      requestType = com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataRequest,
      com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataResponse> getReadTensorboardBlobDataMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataRequest, com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataResponse> getReadTensorboardBlobDataMethod;
    if ((getReadTensorboardBlobDataMethod = TensorboardServiceGrpc.getReadTensorboardBlobDataMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getReadTensorboardBlobDataMethod = TensorboardServiceGrpc.getReadTensorboardBlobDataMethod) == null) {
          TensorboardServiceGrpc.getReadTensorboardBlobDataMethod = getReadTensorboardBlobDataMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataRequest, com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadTensorboardBlobData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("ReadTensorboardBlobData"))
              .build();
        }
      }
    }
    return getReadTensorboardBlobDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataRequest,
      com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataResponse> getWriteTensorboardExperimentDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteTensorboardExperimentData",
      requestType = com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataRequest,
      com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataResponse> getWriteTensorboardExperimentDataMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataRequest, com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataResponse> getWriteTensorboardExperimentDataMethod;
    if ((getWriteTensorboardExperimentDataMethod = TensorboardServiceGrpc.getWriteTensorboardExperimentDataMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getWriteTensorboardExperimentDataMethod = TensorboardServiceGrpc.getWriteTensorboardExperimentDataMethod) == null) {
          TensorboardServiceGrpc.getWriteTensorboardExperimentDataMethod = getWriteTensorboardExperimentDataMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataRequest, com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteTensorboardExperimentData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("WriteTensorboardExperimentData"))
              .build();
        }
      }
    }
    return getWriteTensorboardExperimentDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataRequest,
      com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataResponse> getWriteTensorboardRunDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteTensorboardRunData",
      requestType = com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataRequest,
      com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataResponse> getWriteTensorboardRunDataMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataRequest, com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataResponse> getWriteTensorboardRunDataMethod;
    if ((getWriteTensorboardRunDataMethod = TensorboardServiceGrpc.getWriteTensorboardRunDataMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getWriteTensorboardRunDataMethod = TensorboardServiceGrpc.getWriteTensorboardRunDataMethod) == null) {
          TensorboardServiceGrpc.getWriteTensorboardRunDataMethod = getWriteTensorboardRunDataMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataRequest, com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteTensorboardRunData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("WriteTensorboardRunData"))
              .build();
        }
      }
    }
    return getWriteTensorboardRunDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataRequest,
      com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataResponse> getExportTensorboardTimeSeriesDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportTensorboardTimeSeriesData",
      requestType = com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataRequest,
      com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataResponse> getExportTensorboardTimeSeriesDataMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataRequest, com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataResponse> getExportTensorboardTimeSeriesDataMethod;
    if ((getExportTensorboardTimeSeriesDataMethod = TensorboardServiceGrpc.getExportTensorboardTimeSeriesDataMethod) == null) {
      synchronized (TensorboardServiceGrpc.class) {
        if ((getExportTensorboardTimeSeriesDataMethod = TensorboardServiceGrpc.getExportTensorboardTimeSeriesDataMethod) == null) {
          TensorboardServiceGrpc.getExportTensorboardTimeSeriesDataMethod = getExportTensorboardTimeSeriesDataMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataRequest, com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportTensorboardTimeSeriesData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TensorboardServiceMethodDescriptorSupplier("ExportTensorboardTimeSeriesData"))
              .build();
        }
      }
    }
    return getExportTensorboardTimeSeriesDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TensorboardServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TensorboardServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TensorboardServiceStub>() {
        @java.lang.Override
        public TensorboardServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TensorboardServiceStub(channel, callOptions);
        }
      };
    return TensorboardServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TensorboardServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TensorboardServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TensorboardServiceBlockingStub>() {
        @java.lang.Override
        public TensorboardServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TensorboardServiceBlockingStub(channel, callOptions);
        }
      };
    return TensorboardServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TensorboardServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TensorboardServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TensorboardServiceFutureStub>() {
        @java.lang.Override
        public TensorboardServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TensorboardServiceFutureStub(channel, callOptions);
        }
      };
    return TensorboardServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * TensorboardService
   * </pre>
   */
  public static abstract class TensorboardServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a Tensorboard.
     * </pre>
     */
    public void createTensorboard(com.google.cloud.aiplatform.v1beta1.CreateTensorboardRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTensorboardMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a Tensorboard.
     * </pre>
     */
    public void getTensorboard(com.google.cloud.aiplatform.v1beta1.GetTensorboardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Tensorboard> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTensorboardMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a Tensorboard.
     * </pre>
     */
    public void updateTensorboard(com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTensorboardMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Tensorboards in a Location.
     * </pre>
     */
    public void listTensorboards(com.google.cloud.aiplatform.v1beta1.ListTensorboardsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListTensorboardsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTensorboardsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a Tensorboard.
     * </pre>
     */
    public void deleteTensorboard(com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTensorboardMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a TensorboardExperiment.
     * </pre>
     */
    public void createTensorboardExperiment(com.google.cloud.aiplatform.v1beta1.CreateTensorboardExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTensorboardExperimentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a TensorboardExperiment.
     * </pre>
     */
    public void getTensorboardExperiment(com.google.cloud.aiplatform.v1beta1.GetTensorboardExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTensorboardExperimentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a TensorboardExperiment.
     * </pre>
     */
    public void updateTensorboardExperiment(com.google.cloud.aiplatform.v1beta1.UpdateTensorboardExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTensorboardExperimentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists TensorboardExperiments in a Location.
     * </pre>
     */
    public void listTensorboardExperiments(com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTensorboardExperimentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a TensorboardExperiment.
     * </pre>
     */
    public void deleteTensorboardExperiment(com.google.cloud.aiplatform.v1beta1.DeleteTensorboardExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTensorboardExperimentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a TensorboardRun.
     * </pre>
     */
    public void createTensorboardRun(com.google.cloud.aiplatform.v1beta1.CreateTensorboardRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardRun> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTensorboardRunMethod(), responseObserver);
    }

    /**
     * <pre>
     * Batch create TensorboardRuns.
     * </pre>
     */
    public void batchCreateTensorboardRuns(com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchCreateTensorboardRunsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a TensorboardRun.
     * </pre>
     */
    public void getTensorboardRun(com.google.cloud.aiplatform.v1beta1.GetTensorboardRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardRun> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTensorboardRunMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a TensorboardRun.
     * </pre>
     */
    public void updateTensorboardRun(com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardRun> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTensorboardRunMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists TensorboardRuns in a Location.
     * </pre>
     */
    public void listTensorboardRuns(com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTensorboardRunsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a TensorboardRun.
     * </pre>
     */
    public void deleteTensorboardRun(com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRunRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTensorboardRunMethod(), responseObserver);
    }

    /**
     * <pre>
     * Batch create TensorboardTimeSeries that belong to a TensorboardExperiment.
     * </pre>
     */
    public void batchCreateTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchCreateTensorboardTimeSeriesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a TensorboardTimeSeries.
     * </pre>
     */
    public void createTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.CreateTensorboardTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTensorboardTimeSeriesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a TensorboardTimeSeries.
     * </pre>
     */
    public void getTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.GetTensorboardTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTensorboardTimeSeriesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a TensorboardTimeSeries.
     * </pre>
     */
    public void updateTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.UpdateTensorboardTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTensorboardTimeSeriesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists TensorboardTimeSeries in a Location.
     * </pre>
     */
    public void listTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTensorboardTimeSeriesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a TensorboardTimeSeries.
     * </pre>
     */
    public void deleteTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.DeleteTensorboardTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTensorboardTimeSeriesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Reads multiple TensorboardTimeSeries' data. The data point number limit is
     * 1000 for scalars, 100 for tensors and blob references. If the number of
     * data points stored is less than the limit, all data will be returned.
     * Otherwise, that limit number of data points will be randomly selected from
     * this time series and returned.
     * </pre>
     */
    public void batchReadTensorboardTimeSeriesData(com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchReadTensorboardTimeSeriesDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * Reads a TensorboardTimeSeries' data. By default, if the number of data
     * points stored is less than 1000, all data will be returned. Otherwise, 1000
     * data points will be randomly selected from this time series and returned.
     * This value can be changed by changing max_data_points, which can't be
     * greater than 10k.
     * </pre>
     */
    public void readTensorboardTimeSeriesData(com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadTensorboardTimeSeriesDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets bytes of TensorboardBlobs.
     * This is to allow reading blob data stored in consumer project's Cloud
     * Storage bucket without users having to obtain Cloud Storage access
     * permission.
     * </pre>
     */
    public void readTensorboardBlobData(com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadTensorboardBlobDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * Write time series data points of multiple TensorboardTimeSeries in multiple
     * TensorboardRun's. If any data fail to be ingested, an error will be
     * returned.
     * </pre>
     */
    public void writeTensorboardExperimentData(com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteTensorboardExperimentDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * Write time series data points into multiple TensorboardTimeSeries under
     * a TensorboardRun. If any data fail to be ingested, an error will be
     * returned.
     * </pre>
     */
    public void writeTensorboardRunData(com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteTensorboardRunDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * Exports a TensorboardTimeSeries' data. Data is returned in paginated
     * responses.
     * </pre>
     */
    public void exportTensorboardTimeSeriesData(com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportTensorboardTimeSeriesDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateTensorboardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.CreateTensorboardRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_TENSORBOARD)))
          .addMethod(
            getGetTensorboardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.GetTensorboardRequest,
                com.google.cloud.aiplatform.v1beta1.Tensorboard>(
                  this, METHODID_GET_TENSORBOARD)))
          .addMethod(
            getUpdateTensorboardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_TENSORBOARD)))
          .addMethod(
            getListTensorboardsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.ListTensorboardsRequest,
                com.google.cloud.aiplatform.v1beta1.ListTensorboardsResponse>(
                  this, METHODID_LIST_TENSORBOARDS)))
          .addMethod(
            getDeleteTensorboardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_TENSORBOARD)))
          .addMethod(
            getCreateTensorboardExperimentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.CreateTensorboardExperimentRequest,
                com.google.cloud.aiplatform.v1beta1.TensorboardExperiment>(
                  this, METHODID_CREATE_TENSORBOARD_EXPERIMENT)))
          .addMethod(
            getGetTensorboardExperimentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.GetTensorboardExperimentRequest,
                com.google.cloud.aiplatform.v1beta1.TensorboardExperiment>(
                  this, METHODID_GET_TENSORBOARD_EXPERIMENT)))
          .addMethod(
            getUpdateTensorboardExperimentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.UpdateTensorboardExperimentRequest,
                com.google.cloud.aiplatform.v1beta1.TensorboardExperiment>(
                  this, METHODID_UPDATE_TENSORBOARD_EXPERIMENT)))
          .addMethod(
            getListTensorboardExperimentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsRequest,
                com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsResponse>(
                  this, METHODID_LIST_TENSORBOARD_EXPERIMENTS)))
          .addMethod(
            getDeleteTensorboardExperimentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.DeleteTensorboardExperimentRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_TENSORBOARD_EXPERIMENT)))
          .addMethod(
            getCreateTensorboardRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.CreateTensorboardRunRequest,
                com.google.cloud.aiplatform.v1beta1.TensorboardRun>(
                  this, METHODID_CREATE_TENSORBOARD_RUN)))
          .addMethod(
            getBatchCreateTensorboardRunsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsRequest,
                com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsResponse>(
                  this, METHODID_BATCH_CREATE_TENSORBOARD_RUNS)))
          .addMethod(
            getGetTensorboardRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.GetTensorboardRunRequest,
                com.google.cloud.aiplatform.v1beta1.TensorboardRun>(
                  this, METHODID_GET_TENSORBOARD_RUN)))
          .addMethod(
            getUpdateTensorboardRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRunRequest,
                com.google.cloud.aiplatform.v1beta1.TensorboardRun>(
                  this, METHODID_UPDATE_TENSORBOARD_RUN)))
          .addMethod(
            getListTensorboardRunsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsRequest,
                com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsResponse>(
                  this, METHODID_LIST_TENSORBOARD_RUNS)))
          .addMethod(
            getDeleteTensorboardRunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRunRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_TENSORBOARD_RUN)))
          .addMethod(
            getBatchCreateTensorboardTimeSeriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesRequest,
                com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesResponse>(
                  this, METHODID_BATCH_CREATE_TENSORBOARD_TIME_SERIES)))
          .addMethod(
            getCreateTensorboardTimeSeriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.CreateTensorboardTimeSeriesRequest,
                com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries>(
                  this, METHODID_CREATE_TENSORBOARD_TIME_SERIES)))
          .addMethod(
            getGetTensorboardTimeSeriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.GetTensorboardTimeSeriesRequest,
                com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries>(
                  this, METHODID_GET_TENSORBOARD_TIME_SERIES)))
          .addMethod(
            getUpdateTensorboardTimeSeriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.UpdateTensorboardTimeSeriesRequest,
                com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries>(
                  this, METHODID_UPDATE_TENSORBOARD_TIME_SERIES)))
          .addMethod(
            getListTensorboardTimeSeriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesRequest,
                com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesResponse>(
                  this, METHODID_LIST_TENSORBOARD_TIME_SERIES)))
          .addMethod(
            getDeleteTensorboardTimeSeriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.DeleteTensorboardTimeSeriesRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_TENSORBOARD_TIME_SERIES)))
          .addMethod(
            getBatchReadTensorboardTimeSeriesDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest,
                com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataResponse>(
                  this, METHODID_BATCH_READ_TENSORBOARD_TIME_SERIES_DATA)))
          .addMethod(
            getReadTensorboardTimeSeriesDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataRequest,
                com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataResponse>(
                  this, METHODID_READ_TENSORBOARD_TIME_SERIES_DATA)))
          .addMethod(
            getReadTensorboardBlobDataMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataRequest,
                com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataResponse>(
                  this, METHODID_READ_TENSORBOARD_BLOB_DATA)))
          .addMethod(
            getWriteTensorboardExperimentDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataRequest,
                com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataResponse>(
                  this, METHODID_WRITE_TENSORBOARD_EXPERIMENT_DATA)))
          .addMethod(
            getWriteTensorboardRunDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataRequest,
                com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataResponse>(
                  this, METHODID_WRITE_TENSORBOARD_RUN_DATA)))
          .addMethod(
            getExportTensorboardTimeSeriesDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataRequest,
                com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataResponse>(
                  this, METHODID_EXPORT_TENSORBOARD_TIME_SERIES_DATA)))
          .build();
    }
  }

  /**
   * <pre>
   * TensorboardService
   * </pre>
   */
  public static final class TensorboardServiceStub extends io.grpc.stub.AbstractAsyncStub<TensorboardServiceStub> {
    private TensorboardServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TensorboardServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TensorboardServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Tensorboard.
     * </pre>
     */
    public void createTensorboard(com.google.cloud.aiplatform.v1beta1.CreateTensorboardRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTensorboardMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a Tensorboard.
     * </pre>
     */
    public void getTensorboard(com.google.cloud.aiplatform.v1beta1.GetTensorboardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Tensorboard> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTensorboardMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a Tensorboard.
     * </pre>
     */
    public void updateTensorboard(com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTensorboardMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Tensorboards in a Location.
     * </pre>
     */
    public void listTensorboards(com.google.cloud.aiplatform.v1beta1.ListTensorboardsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListTensorboardsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTensorboardsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a Tensorboard.
     * </pre>
     */
    public void deleteTensorboard(com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTensorboardMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a TensorboardExperiment.
     * </pre>
     */
    public void createTensorboardExperiment(com.google.cloud.aiplatform.v1beta1.CreateTensorboardExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTensorboardExperimentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a TensorboardExperiment.
     * </pre>
     */
    public void getTensorboardExperiment(com.google.cloud.aiplatform.v1beta1.GetTensorboardExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTensorboardExperimentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a TensorboardExperiment.
     * </pre>
     */
    public void updateTensorboardExperiment(com.google.cloud.aiplatform.v1beta1.UpdateTensorboardExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTensorboardExperimentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists TensorboardExperiments in a Location.
     * </pre>
     */
    public void listTensorboardExperiments(com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTensorboardExperimentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a TensorboardExperiment.
     * </pre>
     */
    public void deleteTensorboardExperiment(com.google.cloud.aiplatform.v1beta1.DeleteTensorboardExperimentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTensorboardExperimentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a TensorboardRun.
     * </pre>
     */
    public void createTensorboardRun(com.google.cloud.aiplatform.v1beta1.CreateTensorboardRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardRun> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTensorboardRunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Batch create TensorboardRuns.
     * </pre>
     */
    public void batchCreateTensorboardRuns(com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateTensorboardRunsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a TensorboardRun.
     * </pre>
     */
    public void getTensorboardRun(com.google.cloud.aiplatform.v1beta1.GetTensorboardRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardRun> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTensorboardRunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a TensorboardRun.
     * </pre>
     */
    public void updateTensorboardRun(com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardRun> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTensorboardRunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists TensorboardRuns in a Location.
     * </pre>
     */
    public void listTensorboardRuns(com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTensorboardRunsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a TensorboardRun.
     * </pre>
     */
    public void deleteTensorboardRun(com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRunRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTensorboardRunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Batch create TensorboardTimeSeries that belong to a TensorboardExperiment.
     * </pre>
     */
    public void batchCreateTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateTensorboardTimeSeriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a TensorboardTimeSeries.
     * </pre>
     */
    public void createTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.CreateTensorboardTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTensorboardTimeSeriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a TensorboardTimeSeries.
     * </pre>
     */
    public void getTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.GetTensorboardTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTensorboardTimeSeriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a TensorboardTimeSeries.
     * </pre>
     */
    public void updateTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.UpdateTensorboardTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTensorboardTimeSeriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists TensorboardTimeSeries in a Location.
     * </pre>
     */
    public void listTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTensorboardTimeSeriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a TensorboardTimeSeries.
     * </pre>
     */
    public void deleteTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.DeleteTensorboardTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTensorboardTimeSeriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Reads multiple TensorboardTimeSeries' data. The data point number limit is
     * 1000 for scalars, 100 for tensors and blob references. If the number of
     * data points stored is less than the limit, all data will be returned.
     * Otherwise, that limit number of data points will be randomly selected from
     * this time series and returned.
     * </pre>
     */
    public void batchReadTensorboardTimeSeriesData(com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchReadTensorboardTimeSeriesDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Reads a TensorboardTimeSeries' data. By default, if the number of data
     * points stored is less than 1000, all data will be returned. Otherwise, 1000
     * data points will be randomly selected from this time series and returned.
     * This value can be changed by changing max_data_points, which can't be
     * greater than 10k.
     * </pre>
     */
    public void readTensorboardTimeSeriesData(com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadTensorboardTimeSeriesDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets bytes of TensorboardBlobs.
     * This is to allow reading blob data stored in consumer project's Cloud
     * Storage bucket without users having to obtain Cloud Storage access
     * permission.
     * </pre>
     */
    public void readTensorboardBlobData(com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReadTensorboardBlobDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Write time series data points of multiple TensorboardTimeSeries in multiple
     * TensorboardRun's. If any data fail to be ingested, an error will be
     * returned.
     * </pre>
     */
    public void writeTensorboardExperimentData(com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteTensorboardExperimentDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Write time series data points into multiple TensorboardTimeSeries under
     * a TensorboardRun. If any data fail to be ingested, an error will be
     * returned.
     * </pre>
     */
    public void writeTensorboardRunData(com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteTensorboardRunDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Exports a TensorboardTimeSeries' data. Data is returned in paginated
     * responses.
     * </pre>
     */
    public void exportTensorboardTimeSeriesData(com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportTensorboardTimeSeriesDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * TensorboardService
   * </pre>
   */
  public static final class TensorboardServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TensorboardServiceBlockingStub> {
    private TensorboardServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TensorboardServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TensorboardServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Tensorboard.
     * </pre>
     */
    public com.google.longrunning.Operation createTensorboard(com.google.cloud.aiplatform.v1beta1.CreateTensorboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTensorboardMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a Tensorboard.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Tensorboard getTensorboard(com.google.cloud.aiplatform.v1beta1.GetTensorboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTensorboardMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a Tensorboard.
     * </pre>
     */
    public com.google.longrunning.Operation updateTensorboard(com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTensorboardMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Tensorboards in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListTensorboardsResponse listTensorboards(com.google.cloud.aiplatform.v1beta1.ListTensorboardsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTensorboardsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a Tensorboard.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTensorboard(com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTensorboardMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a TensorboardExperiment.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.TensorboardExperiment createTensorboardExperiment(com.google.cloud.aiplatform.v1beta1.CreateTensorboardExperimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTensorboardExperimentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a TensorboardExperiment.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.TensorboardExperiment getTensorboardExperiment(com.google.cloud.aiplatform.v1beta1.GetTensorboardExperimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTensorboardExperimentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a TensorboardExperiment.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.TensorboardExperiment updateTensorboardExperiment(com.google.cloud.aiplatform.v1beta1.UpdateTensorboardExperimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTensorboardExperimentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists TensorboardExperiments in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsResponse listTensorboardExperiments(com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTensorboardExperimentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a TensorboardExperiment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTensorboardExperiment(com.google.cloud.aiplatform.v1beta1.DeleteTensorboardExperimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTensorboardExperimentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a TensorboardRun.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.TensorboardRun createTensorboardRun(com.google.cloud.aiplatform.v1beta1.CreateTensorboardRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTensorboardRunMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Batch create TensorboardRuns.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsResponse batchCreateTensorboardRuns(com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateTensorboardRunsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a TensorboardRun.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.TensorboardRun getTensorboardRun(com.google.cloud.aiplatform.v1beta1.GetTensorboardRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTensorboardRunMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a TensorboardRun.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.TensorboardRun updateTensorboardRun(com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTensorboardRunMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists TensorboardRuns in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsResponse listTensorboardRuns(com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTensorboardRunsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a TensorboardRun.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTensorboardRun(com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTensorboardRunMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Batch create TensorboardTimeSeries that belong to a TensorboardExperiment.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesResponse batchCreateTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateTensorboardTimeSeriesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a TensorboardTimeSeries.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries createTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.CreateTensorboardTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTensorboardTimeSeriesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a TensorboardTimeSeries.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries getTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.GetTensorboardTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTensorboardTimeSeriesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a TensorboardTimeSeries.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries updateTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.UpdateTensorboardTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTensorboardTimeSeriesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists TensorboardTimeSeries in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesResponse listTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTensorboardTimeSeriesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a TensorboardTimeSeries.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTensorboardTimeSeries(com.google.cloud.aiplatform.v1beta1.DeleteTensorboardTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTensorboardTimeSeriesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Reads multiple TensorboardTimeSeries' data. The data point number limit is
     * 1000 for scalars, 100 for tensors and blob references. If the number of
     * data points stored is less than the limit, all data will be returned.
     * Otherwise, that limit number of data points will be randomly selected from
     * this time series and returned.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataResponse batchReadTensorboardTimeSeriesData(com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchReadTensorboardTimeSeriesDataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Reads a TensorboardTimeSeries' data. By default, if the number of data
     * points stored is less than 1000, all data will be returned. Otherwise, 1000
     * data points will be randomly selected from this time series and returned.
     * This value can be changed by changing max_data_points, which can't be
     * greater than 10k.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataResponse readTensorboardTimeSeriesData(com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadTensorboardTimeSeriesDataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets bytes of TensorboardBlobs.
     * This is to allow reading blob data stored in consumer project's Cloud
     * Storage bucket without users having to obtain Cloud Storage access
     * permission.
     * </pre>
     */
    public java.util.Iterator<com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataResponse> readTensorboardBlobData(
        com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReadTensorboardBlobDataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Write time series data points of multiple TensorboardTimeSeries in multiple
     * TensorboardRun's. If any data fail to be ingested, an error will be
     * returned.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataResponse writeTensorboardExperimentData(com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteTensorboardExperimentDataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Write time series data points into multiple TensorboardTimeSeries under
     * a TensorboardRun. If any data fail to be ingested, an error will be
     * returned.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataResponse writeTensorboardRunData(com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteTensorboardRunDataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Exports a TensorboardTimeSeries' data. Data is returned in paginated
     * responses.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataResponse exportTensorboardTimeSeriesData(com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportTensorboardTimeSeriesDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * TensorboardService
   * </pre>
   */
  public static final class TensorboardServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TensorboardServiceFutureStub> {
    private TensorboardServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TensorboardServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TensorboardServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Tensorboard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createTensorboard(
        com.google.cloud.aiplatform.v1beta1.CreateTensorboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTensorboardMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a Tensorboard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.Tensorboard> getTensorboard(
        com.google.cloud.aiplatform.v1beta1.GetTensorboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTensorboardMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a Tensorboard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateTensorboard(
        com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTensorboardMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Tensorboards in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.ListTensorboardsResponse> listTensorboards(
        com.google.cloud.aiplatform.v1beta1.ListTensorboardsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTensorboardsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a Tensorboard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteTensorboard(
        com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTensorboardMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a TensorboardExperiment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> createTensorboardExperiment(
        com.google.cloud.aiplatform.v1beta1.CreateTensorboardExperimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTensorboardExperimentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a TensorboardExperiment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> getTensorboardExperiment(
        com.google.cloud.aiplatform.v1beta1.GetTensorboardExperimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTensorboardExperimentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a TensorboardExperiment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.TensorboardExperiment> updateTensorboardExperiment(
        com.google.cloud.aiplatform.v1beta1.UpdateTensorboardExperimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTensorboardExperimentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists TensorboardExperiments in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsResponse> listTensorboardExperiments(
        com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTensorboardExperimentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a TensorboardExperiment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteTensorboardExperiment(
        com.google.cloud.aiplatform.v1beta1.DeleteTensorboardExperimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTensorboardExperimentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a TensorboardRun.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.TensorboardRun> createTensorboardRun(
        com.google.cloud.aiplatform.v1beta1.CreateTensorboardRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTensorboardRunMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Batch create TensorboardRuns.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsResponse> batchCreateTensorboardRuns(
        com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateTensorboardRunsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a TensorboardRun.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.TensorboardRun> getTensorboardRun(
        com.google.cloud.aiplatform.v1beta1.GetTensorboardRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTensorboardRunMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a TensorboardRun.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.TensorboardRun> updateTensorboardRun(
        com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTensorboardRunMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists TensorboardRuns in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsResponse> listTensorboardRuns(
        com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTensorboardRunsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a TensorboardRun.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteTensorboardRun(
        com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTensorboardRunMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Batch create TensorboardTimeSeries that belong to a TensorboardExperiment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesResponse> batchCreateTensorboardTimeSeries(
        com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateTensorboardTimeSeriesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a TensorboardTimeSeries.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> createTensorboardTimeSeries(
        com.google.cloud.aiplatform.v1beta1.CreateTensorboardTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTensorboardTimeSeriesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a TensorboardTimeSeries.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> getTensorboardTimeSeries(
        com.google.cloud.aiplatform.v1beta1.GetTensorboardTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTensorboardTimeSeriesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a TensorboardTimeSeries.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries> updateTensorboardTimeSeries(
        com.google.cloud.aiplatform.v1beta1.UpdateTensorboardTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTensorboardTimeSeriesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists TensorboardTimeSeries in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesResponse> listTensorboardTimeSeries(
        com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTensorboardTimeSeriesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a TensorboardTimeSeries.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteTensorboardTimeSeries(
        com.google.cloud.aiplatform.v1beta1.DeleteTensorboardTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTensorboardTimeSeriesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Reads multiple TensorboardTimeSeries' data. The data point number limit is
     * 1000 for scalars, 100 for tensors and blob references. If the number of
     * data points stored is less than the limit, all data will be returned.
     * Otherwise, that limit number of data points will be randomly selected from
     * this time series and returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataResponse> batchReadTensorboardTimeSeriesData(
        com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchReadTensorboardTimeSeriesDataMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Reads a TensorboardTimeSeries' data. By default, if the number of data
     * points stored is less than 1000, all data will be returned. Otherwise, 1000
     * data points will be randomly selected from this time series and returned.
     * This value can be changed by changing max_data_points, which can't be
     * greater than 10k.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataResponse> readTensorboardTimeSeriesData(
        com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadTensorboardTimeSeriesDataMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Write time series data points of multiple TensorboardTimeSeries in multiple
     * TensorboardRun's. If any data fail to be ingested, an error will be
     * returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataResponse> writeTensorboardExperimentData(
        com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteTensorboardExperimentDataMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Write time series data points into multiple TensorboardTimeSeries under
     * a TensorboardRun. If any data fail to be ingested, an error will be
     * returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataResponse> writeTensorboardRunData(
        com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteTensorboardRunDataMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Exports a TensorboardTimeSeries' data. Data is returned in paginated
     * responses.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataResponse> exportTensorboardTimeSeriesData(
        com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportTensorboardTimeSeriesDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TENSORBOARD = 0;
  private static final int METHODID_GET_TENSORBOARD = 1;
  private static final int METHODID_UPDATE_TENSORBOARD = 2;
  private static final int METHODID_LIST_TENSORBOARDS = 3;
  private static final int METHODID_DELETE_TENSORBOARD = 4;
  private static final int METHODID_CREATE_TENSORBOARD_EXPERIMENT = 5;
  private static final int METHODID_GET_TENSORBOARD_EXPERIMENT = 6;
  private static final int METHODID_UPDATE_TENSORBOARD_EXPERIMENT = 7;
  private static final int METHODID_LIST_TENSORBOARD_EXPERIMENTS = 8;
  private static final int METHODID_DELETE_TENSORBOARD_EXPERIMENT = 9;
  private static final int METHODID_CREATE_TENSORBOARD_RUN = 10;
  private static final int METHODID_BATCH_CREATE_TENSORBOARD_RUNS = 11;
  private static final int METHODID_GET_TENSORBOARD_RUN = 12;
  private static final int METHODID_UPDATE_TENSORBOARD_RUN = 13;
  private static final int METHODID_LIST_TENSORBOARD_RUNS = 14;
  private static final int METHODID_DELETE_TENSORBOARD_RUN = 15;
  private static final int METHODID_BATCH_CREATE_TENSORBOARD_TIME_SERIES = 16;
  private static final int METHODID_CREATE_TENSORBOARD_TIME_SERIES = 17;
  private static final int METHODID_GET_TENSORBOARD_TIME_SERIES = 18;
  private static final int METHODID_UPDATE_TENSORBOARD_TIME_SERIES = 19;
  private static final int METHODID_LIST_TENSORBOARD_TIME_SERIES = 20;
  private static final int METHODID_DELETE_TENSORBOARD_TIME_SERIES = 21;
  private static final int METHODID_BATCH_READ_TENSORBOARD_TIME_SERIES_DATA = 22;
  private static final int METHODID_READ_TENSORBOARD_TIME_SERIES_DATA = 23;
  private static final int METHODID_READ_TENSORBOARD_BLOB_DATA = 24;
  private static final int METHODID_WRITE_TENSORBOARD_EXPERIMENT_DATA = 25;
  private static final int METHODID_WRITE_TENSORBOARD_RUN_DATA = 26;
  private static final int METHODID_EXPORT_TENSORBOARD_TIME_SERIES_DATA = 27;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TensorboardServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TensorboardServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TENSORBOARD:
          serviceImpl.createTensorboard((com.google.cloud.aiplatform.v1beta1.CreateTensorboardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_TENSORBOARD:
          serviceImpl.getTensorboard((com.google.cloud.aiplatform.v1beta1.GetTensorboardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Tensorboard>) responseObserver);
          break;
        case METHODID_UPDATE_TENSORBOARD:
          serviceImpl.updateTensorboard((com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_TENSORBOARDS:
          serviceImpl.listTensorboards((com.google.cloud.aiplatform.v1beta1.ListTensorboardsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListTensorboardsResponse>) responseObserver);
          break;
        case METHODID_DELETE_TENSORBOARD:
          serviceImpl.deleteTensorboard((com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_TENSORBOARD_EXPERIMENT:
          serviceImpl.createTensorboardExperiment((com.google.cloud.aiplatform.v1beta1.CreateTensorboardExperimentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardExperiment>) responseObserver);
          break;
        case METHODID_GET_TENSORBOARD_EXPERIMENT:
          serviceImpl.getTensorboardExperiment((com.google.cloud.aiplatform.v1beta1.GetTensorboardExperimentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardExperiment>) responseObserver);
          break;
        case METHODID_UPDATE_TENSORBOARD_EXPERIMENT:
          serviceImpl.updateTensorboardExperiment((com.google.cloud.aiplatform.v1beta1.UpdateTensorboardExperimentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardExperiment>) responseObserver);
          break;
        case METHODID_LIST_TENSORBOARD_EXPERIMENTS:
          serviceImpl.listTensorboardExperiments((com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListTensorboardExperimentsResponse>) responseObserver);
          break;
        case METHODID_DELETE_TENSORBOARD_EXPERIMENT:
          serviceImpl.deleteTensorboardExperiment((com.google.cloud.aiplatform.v1beta1.DeleteTensorboardExperimentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_TENSORBOARD_RUN:
          serviceImpl.createTensorboardRun((com.google.cloud.aiplatform.v1beta1.CreateTensorboardRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardRun>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_TENSORBOARD_RUNS:
          serviceImpl.batchCreateTensorboardRuns((com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardRunsResponse>) responseObserver);
          break;
        case METHODID_GET_TENSORBOARD_RUN:
          serviceImpl.getTensorboardRun((com.google.cloud.aiplatform.v1beta1.GetTensorboardRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardRun>) responseObserver);
          break;
        case METHODID_UPDATE_TENSORBOARD_RUN:
          serviceImpl.updateTensorboardRun((com.google.cloud.aiplatform.v1beta1.UpdateTensorboardRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardRun>) responseObserver);
          break;
        case METHODID_LIST_TENSORBOARD_RUNS:
          serviceImpl.listTensorboardRuns((com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListTensorboardRunsResponse>) responseObserver);
          break;
        case METHODID_DELETE_TENSORBOARD_RUN:
          serviceImpl.deleteTensorboardRun((com.google.cloud.aiplatform.v1beta1.DeleteTensorboardRunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_TENSORBOARD_TIME_SERIES:
          serviceImpl.batchCreateTensorboardTimeSeries((com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchCreateTensorboardTimeSeriesResponse>) responseObserver);
          break;
        case METHODID_CREATE_TENSORBOARD_TIME_SERIES:
          serviceImpl.createTensorboardTimeSeries((com.google.cloud.aiplatform.v1beta1.CreateTensorboardTimeSeriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries>) responseObserver);
          break;
        case METHODID_GET_TENSORBOARD_TIME_SERIES:
          serviceImpl.getTensorboardTimeSeries((com.google.cloud.aiplatform.v1beta1.GetTensorboardTimeSeriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries>) responseObserver);
          break;
        case METHODID_UPDATE_TENSORBOARD_TIME_SERIES:
          serviceImpl.updateTensorboardTimeSeries((com.google.cloud.aiplatform.v1beta1.UpdateTensorboardTimeSeriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.TensorboardTimeSeries>) responseObserver);
          break;
        case METHODID_LIST_TENSORBOARD_TIME_SERIES:
          serviceImpl.listTensorboardTimeSeries((com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListTensorboardTimeSeriesResponse>) responseObserver);
          break;
        case METHODID_DELETE_TENSORBOARD_TIME_SERIES:
          serviceImpl.deleteTensorboardTimeSeries((com.google.cloud.aiplatform.v1beta1.DeleteTensorboardTimeSeriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_READ_TENSORBOARD_TIME_SERIES_DATA:
          serviceImpl.batchReadTensorboardTimeSeriesData((com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.BatchReadTensorboardTimeSeriesDataResponse>) responseObserver);
          break;
        case METHODID_READ_TENSORBOARD_TIME_SERIES_DATA:
          serviceImpl.readTensorboardTimeSeriesData((com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ReadTensorboardTimeSeriesDataResponse>) responseObserver);
          break;
        case METHODID_READ_TENSORBOARD_BLOB_DATA:
          serviceImpl.readTensorboardBlobData((com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ReadTensorboardBlobDataResponse>) responseObserver);
          break;
        case METHODID_WRITE_TENSORBOARD_EXPERIMENT_DATA:
          serviceImpl.writeTensorboardExperimentData((com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.WriteTensorboardExperimentDataResponse>) responseObserver);
          break;
        case METHODID_WRITE_TENSORBOARD_RUN_DATA:
          serviceImpl.writeTensorboardRunData((com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.WriteTensorboardRunDataResponse>) responseObserver);
          break;
        case METHODID_EXPORT_TENSORBOARD_TIME_SERIES_DATA:
          serviceImpl.exportTensorboardTimeSeriesData((com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ExportTensorboardTimeSeriesDataResponse>) responseObserver);
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

  private static abstract class TensorboardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TensorboardServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.TensorboardServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TensorboardService");
    }
  }

  private static final class TensorboardServiceFileDescriptorSupplier
      extends TensorboardServiceBaseDescriptorSupplier {
    TensorboardServiceFileDescriptorSupplier() {}
  }

  private static final class TensorboardServiceMethodDescriptorSupplier
      extends TensorboardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TensorboardServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TensorboardServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TensorboardServiceFileDescriptorSupplier())
              .addMethod(getCreateTensorboardMethod())
              .addMethod(getGetTensorboardMethod())
              .addMethod(getUpdateTensorboardMethod())
              .addMethod(getListTensorboardsMethod())
              .addMethod(getDeleteTensorboardMethod())
              .addMethod(getCreateTensorboardExperimentMethod())
              .addMethod(getGetTensorboardExperimentMethod())
              .addMethod(getUpdateTensorboardExperimentMethod())
              .addMethod(getListTensorboardExperimentsMethod())
              .addMethod(getDeleteTensorboardExperimentMethod())
              .addMethod(getCreateTensorboardRunMethod())
              .addMethod(getBatchCreateTensorboardRunsMethod())
              .addMethod(getGetTensorboardRunMethod())
              .addMethod(getUpdateTensorboardRunMethod())
              .addMethod(getListTensorboardRunsMethod())
              .addMethod(getDeleteTensorboardRunMethod())
              .addMethod(getBatchCreateTensorboardTimeSeriesMethod())
              .addMethod(getCreateTensorboardTimeSeriesMethod())
              .addMethod(getGetTensorboardTimeSeriesMethod())
              .addMethod(getUpdateTensorboardTimeSeriesMethod())
              .addMethod(getListTensorboardTimeSeriesMethod())
              .addMethod(getDeleteTensorboardTimeSeriesMethod())
              .addMethod(getBatchReadTensorboardTimeSeriesDataMethod())
              .addMethod(getReadTensorboardTimeSeriesDataMethod())
              .addMethod(getReadTensorboardBlobDataMethod())
              .addMethod(getWriteTensorboardExperimentDataMethod())
              .addMethod(getWriteTensorboardRunDataMethod())
              .addMethod(getExportTensorboardTimeSeriesDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
