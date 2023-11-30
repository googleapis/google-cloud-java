package com.google.cloud.notebooks.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * API v2 service for Workbench Notebooks Instances.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/notebooks/v2/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NotebookServiceGrpc {

  private NotebookServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.notebooks.v2.NotebookService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.ListInstancesRequest,
      com.google.cloud.notebooks.v2.ListInstancesResponse> getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.notebooks.v2.ListInstancesRequest.class,
      responseType = com.google.cloud.notebooks.v2.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.ListInstancesRequest,
      com.google.cloud.notebooks.v2.ListInstancesResponse> getListInstancesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.ListInstancesRequest, com.google.cloud.notebooks.v2.ListInstancesResponse> getListInstancesMethod;
    if ((getListInstancesMethod = NotebookServiceGrpc.getListInstancesMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getListInstancesMethod = NotebookServiceGrpc.getListInstancesMethod) == null) {
          NotebookServiceGrpc.getListInstancesMethod = getListInstancesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v2.ListInstancesRequest, com.google.cloud.notebooks.v2.ListInstancesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.ListInstancesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NotebookServiceMethodDescriptorSupplier("ListInstances"))
              .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.GetInstanceRequest,
      com.google.cloud.notebooks.v2.Instance> getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.notebooks.v2.GetInstanceRequest.class,
      responseType = com.google.cloud.notebooks.v2.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.GetInstanceRequest,
      com.google.cloud.notebooks.v2.Instance> getGetInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.GetInstanceRequest, com.google.cloud.notebooks.v2.Instance> getGetInstanceMethod;
    if ((getGetInstanceMethod = NotebookServiceGrpc.getGetInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getGetInstanceMethod = NotebookServiceGrpc.getGetInstanceMethod) == null) {
          NotebookServiceGrpc.getGetInstanceMethod = getGetInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v2.GetInstanceRequest, com.google.cloud.notebooks.v2.Instance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.GetInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.Instance.getDefaultInstance()))
              .setSchemaDescriptor(new NotebookServiceMethodDescriptorSupplier("GetInstance"))
              .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.notebooks.v2.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.CreateInstanceRequest, com.google.longrunning.Operation> getCreateInstanceMethod;
    if ((getCreateInstanceMethod = NotebookServiceGrpc.getCreateInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getCreateInstanceMethod = NotebookServiceGrpc.getCreateInstanceMethod) == null) {
          NotebookServiceGrpc.getCreateInstanceMethod = getCreateInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v2.CreateInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NotebookServiceMethodDescriptorSupplier("CreateInstance"))
              .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.UpdateInstanceRequest,
      com.google.longrunning.Operation> getUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstance",
      requestType = com.google.cloud.notebooks.v2.UpdateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.UpdateInstanceRequest,
      com.google.longrunning.Operation> getUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.UpdateInstanceRequest, com.google.longrunning.Operation> getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = NotebookServiceGrpc.getUpdateInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getUpdateInstanceMethod = NotebookServiceGrpc.getUpdateInstanceMethod) == null) {
          NotebookServiceGrpc.getUpdateInstanceMethod = getUpdateInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v2.UpdateInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.UpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NotebookServiceMethodDescriptorSupplier("UpdateInstance"))
              .build();
        }
      }
    }
    return getUpdateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.DeleteInstanceRequest,
      com.google.longrunning.Operation> getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.notebooks.v2.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.DeleteInstanceRequest,
      com.google.longrunning.Operation> getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.DeleteInstanceRequest, com.google.longrunning.Operation> getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = NotebookServiceGrpc.getDeleteInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getDeleteInstanceMethod = NotebookServiceGrpc.getDeleteInstanceMethod) == null) {
          NotebookServiceGrpc.getDeleteInstanceMethod = getDeleteInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v2.DeleteInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NotebookServiceMethodDescriptorSupplier("DeleteInstance"))
              .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.StartInstanceRequest,
      com.google.longrunning.Operation> getStartInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartInstance",
      requestType = com.google.cloud.notebooks.v2.StartInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.StartInstanceRequest,
      com.google.longrunning.Operation> getStartInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.StartInstanceRequest, com.google.longrunning.Operation> getStartInstanceMethod;
    if ((getStartInstanceMethod = NotebookServiceGrpc.getStartInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getStartInstanceMethod = NotebookServiceGrpc.getStartInstanceMethod) == null) {
          NotebookServiceGrpc.getStartInstanceMethod = getStartInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v2.StartInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.StartInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NotebookServiceMethodDescriptorSupplier("StartInstance"))
              .build();
        }
      }
    }
    return getStartInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.StopInstanceRequest,
      com.google.longrunning.Operation> getStopInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopInstance",
      requestType = com.google.cloud.notebooks.v2.StopInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.StopInstanceRequest,
      com.google.longrunning.Operation> getStopInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.StopInstanceRequest, com.google.longrunning.Operation> getStopInstanceMethod;
    if ((getStopInstanceMethod = NotebookServiceGrpc.getStopInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getStopInstanceMethod = NotebookServiceGrpc.getStopInstanceMethod) == null) {
          NotebookServiceGrpc.getStopInstanceMethod = getStopInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v2.StopInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.StopInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NotebookServiceMethodDescriptorSupplier("StopInstance"))
              .build();
        }
      }
    }
    return getStopInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.ResetInstanceRequest,
      com.google.longrunning.Operation> getResetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetInstance",
      requestType = com.google.cloud.notebooks.v2.ResetInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.ResetInstanceRequest,
      com.google.longrunning.Operation> getResetInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.ResetInstanceRequest, com.google.longrunning.Operation> getResetInstanceMethod;
    if ((getResetInstanceMethod = NotebookServiceGrpc.getResetInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getResetInstanceMethod = NotebookServiceGrpc.getResetInstanceMethod) == null) {
          NotebookServiceGrpc.getResetInstanceMethod = getResetInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v2.ResetInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.ResetInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NotebookServiceMethodDescriptorSupplier("ResetInstance"))
              .build();
        }
      }
    }
    return getResetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityRequest,
      com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityResponse> getCheckInstanceUpgradabilityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckInstanceUpgradability",
      requestType = com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityRequest.class,
      responseType = com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityRequest,
      com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityResponse> getCheckInstanceUpgradabilityMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityRequest, com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityResponse> getCheckInstanceUpgradabilityMethod;
    if ((getCheckInstanceUpgradabilityMethod = NotebookServiceGrpc.getCheckInstanceUpgradabilityMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getCheckInstanceUpgradabilityMethod = NotebookServiceGrpc.getCheckInstanceUpgradabilityMethod) == null) {
          NotebookServiceGrpc.getCheckInstanceUpgradabilityMethod = getCheckInstanceUpgradabilityMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityRequest, com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckInstanceUpgradability"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NotebookServiceMethodDescriptorSupplier("CheckInstanceUpgradability"))
              .build();
        }
      }
    }
    return getCheckInstanceUpgradabilityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.UpgradeInstanceRequest,
      com.google.longrunning.Operation> getUpgradeInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpgradeInstance",
      requestType = com.google.cloud.notebooks.v2.UpgradeInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.UpgradeInstanceRequest,
      com.google.longrunning.Operation> getUpgradeInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.UpgradeInstanceRequest, com.google.longrunning.Operation> getUpgradeInstanceMethod;
    if ((getUpgradeInstanceMethod = NotebookServiceGrpc.getUpgradeInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getUpgradeInstanceMethod = NotebookServiceGrpc.getUpgradeInstanceMethod) == null) {
          NotebookServiceGrpc.getUpgradeInstanceMethod = getUpgradeInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v2.UpgradeInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpgradeInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.UpgradeInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NotebookServiceMethodDescriptorSupplier("UpgradeInstance"))
              .build();
        }
      }
    }
    return getUpgradeInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.RollbackInstanceRequest,
      com.google.longrunning.Operation> getRollbackInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollbackInstance",
      requestType = com.google.cloud.notebooks.v2.RollbackInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.RollbackInstanceRequest,
      com.google.longrunning.Operation> getRollbackInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.RollbackInstanceRequest, com.google.longrunning.Operation> getRollbackInstanceMethod;
    if ((getRollbackInstanceMethod = NotebookServiceGrpc.getRollbackInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getRollbackInstanceMethod = NotebookServiceGrpc.getRollbackInstanceMethod) == null) {
          NotebookServiceGrpc.getRollbackInstanceMethod = getRollbackInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v2.RollbackInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RollbackInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.RollbackInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NotebookServiceMethodDescriptorSupplier("RollbackInstance"))
              .build();
        }
      }
    }
    return getRollbackInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.DiagnoseInstanceRequest,
      com.google.longrunning.Operation> getDiagnoseInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DiagnoseInstance",
      requestType = com.google.cloud.notebooks.v2.DiagnoseInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.DiagnoseInstanceRequest,
      com.google.longrunning.Operation> getDiagnoseInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.notebooks.v2.DiagnoseInstanceRequest, com.google.longrunning.Operation> getDiagnoseInstanceMethod;
    if ((getDiagnoseInstanceMethod = NotebookServiceGrpc.getDiagnoseInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getDiagnoseInstanceMethod = NotebookServiceGrpc.getDiagnoseInstanceMethod) == null) {
          NotebookServiceGrpc.getDiagnoseInstanceMethod = getDiagnoseInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.notebooks.v2.DiagnoseInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DiagnoseInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.notebooks.v2.DiagnoseInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NotebookServiceMethodDescriptorSupplier("DiagnoseInstance"))
              .build();
        }
      }
    }
    return getDiagnoseInstanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NotebookServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotebookServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotebookServiceStub>() {
        @java.lang.Override
        public NotebookServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotebookServiceStub(channel, callOptions);
        }
      };
    return NotebookServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NotebookServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotebookServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotebookServiceBlockingStub>() {
        @java.lang.Override
        public NotebookServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotebookServiceBlockingStub(channel, callOptions);
        }
      };
    return NotebookServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NotebookServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotebookServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotebookServiceFutureStub>() {
        @java.lang.Override
        public NotebookServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotebookServiceFutureStub(channel, callOptions);
        }
      };
    return NotebookServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * API v2 service for Workbench Notebooks Instances.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Lists instances in a given project and location.
     * </pre>
     */
    default void listInstances(com.google.cloud.notebooks.v2.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v2.ListInstancesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListInstancesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    default void getInstance(com.google.cloud.notebooks.v2.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v2.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    default void createInstance(com.google.cloud.notebooks.v2.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * UpdateInstance updates an Instance.
     * </pre>
     */
    default void updateInstance(com.google.cloud.notebooks.v2.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    default void deleteInstance(com.google.cloud.notebooks.v2.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Starts a notebook instance.
     * </pre>
     */
    default void startInstance(com.google.cloud.notebooks.v2.StartInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Stops a notebook instance.
     * </pre>
     */
    default void stopInstance(com.google.cloud.notebooks.v2.StopInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Resets a notebook instance.
     * </pre>
     */
    default void resetInstance(com.google.cloud.notebooks.v2.ResetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResetInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Checks whether a notebook instance is upgradable.
     * </pre>
     */
    default void checkInstanceUpgradability(com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckInstanceUpgradabilityMethod(), responseObserver);
    }

    /**
     * <pre>
     * Upgrades a notebook instance to the latest version.
     * </pre>
     */
    default void upgradeInstance(com.google.cloud.notebooks.v2.UpgradeInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpgradeInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Rollbacks a notebook instance to the previous version.
     * </pre>
     */
    default void rollbackInstance(com.google.cloud.notebooks.v2.RollbackInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRollbackInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a Diagnostic File and runs Diagnostic Tool given an Instance.
     * </pre>
     */
    default void diagnoseInstance(com.google.cloud.notebooks.v2.DiagnoseInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDiagnoseInstanceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service NotebookService.
   * <pre>
   * API v2 service for Workbench Notebooks Instances.
   * </pre>
   */
  public static abstract class NotebookServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return NotebookServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service NotebookService.
   * <pre>
   * API v2 service for Workbench Notebooks Instances.
   * </pre>
   */
  public static final class NotebookServiceStub
      extends io.grpc.stub.AbstractAsyncStub<NotebookServiceStub> {
    private NotebookServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotebookServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotebookServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists instances in a given project and location.
     * </pre>
     */
    public void listInstances(com.google.cloud.notebooks.v2.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v2.ListInstancesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public void getInstance(com.google.cloud.notebooks.v2.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v2.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public void createInstance(com.google.cloud.notebooks.v2.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UpdateInstance updates an Instance.
     * </pre>
     */
    public void updateInstance(com.google.cloud.notebooks.v2.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public void deleteInstance(com.google.cloud.notebooks.v2.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Starts a notebook instance.
     * </pre>
     */
    public void startInstance(com.google.cloud.notebooks.v2.StartInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Stops a notebook instance.
     * </pre>
     */
    public void stopInstance(com.google.cloud.notebooks.v2.StopInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Resets a notebook instance.
     * </pre>
     */
    public void resetInstance(com.google.cloud.notebooks.v2.ResetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Checks whether a notebook instance is upgradable.
     * </pre>
     */
    public void checkInstanceUpgradability(com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckInstanceUpgradabilityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Upgrades a notebook instance to the latest version.
     * </pre>
     */
    public void upgradeInstance(com.google.cloud.notebooks.v2.UpgradeInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpgradeInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Rollbacks a notebook instance to the previous version.
     * </pre>
     */
    public void rollbackInstance(com.google.cloud.notebooks.v2.RollbackInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollbackInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a Diagnostic File and runs Diagnostic Tool given an Instance.
     * </pre>
     */
    public void diagnoseInstance(com.google.cloud.notebooks.v2.DiagnoseInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDiagnoseInstanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service NotebookService.
   * <pre>
   * API v2 service for Workbench Notebooks Instances.
   * </pre>
   */
  public static final class NotebookServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NotebookServiceBlockingStub> {
    private NotebookServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotebookServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotebookServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.notebooks.v2.ListInstancesResponse listInstances(com.google.cloud.notebooks.v2.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.cloud.notebooks.v2.Instance getInstance(com.google.cloud.notebooks.v2.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(com.google.cloud.notebooks.v2.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * UpdateInstance updates an Instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(com.google.cloud.notebooks.v2.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(com.google.cloud.notebooks.v2.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Starts a notebook instance.
     * </pre>
     */
    public com.google.longrunning.Operation startInstance(com.google.cloud.notebooks.v2.StartInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Stops a notebook instance.
     * </pre>
     */
    public com.google.longrunning.Operation stopInstance(com.google.cloud.notebooks.v2.StopInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Resets a notebook instance.
     * </pre>
     */
    public com.google.longrunning.Operation resetInstance(com.google.cloud.notebooks.v2.ResetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Checks whether a notebook instance is upgradable.
     * </pre>
     */
    public com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityResponse checkInstanceUpgradability(com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckInstanceUpgradabilityMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Upgrades a notebook instance to the latest version.
     * </pre>
     */
    public com.google.longrunning.Operation upgradeInstance(com.google.cloud.notebooks.v2.UpgradeInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpgradeInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Rollbacks a notebook instance to the previous version.
     * </pre>
     */
    public com.google.longrunning.Operation rollbackInstance(com.google.cloud.notebooks.v2.RollbackInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a Diagnostic File and runs Diagnostic Tool given an Instance.
     * </pre>
     */
    public com.google.longrunning.Operation diagnoseInstance(com.google.cloud.notebooks.v2.DiagnoseInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDiagnoseInstanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service NotebookService.
   * <pre>
   * API v2 service for Workbench Notebooks Instances.
   * </pre>
   */
  public static final class NotebookServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<NotebookServiceFutureStub> {
    private NotebookServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotebookServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotebookServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists instances in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.notebooks.v2.ListInstancesResponse> listInstances(
        com.google.cloud.notebooks.v2.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.notebooks.v2.Instance> getInstance(
        com.google.cloud.notebooks.v2.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createInstance(
        com.google.cloud.notebooks.v2.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * UpdateInstance updates an Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateInstance(
        com.google.cloud.notebooks.v2.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteInstance(
        com.google.cloud.notebooks.v2.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Starts a notebook instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> startInstance(
        com.google.cloud.notebooks.v2.StartInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Stops a notebook instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> stopInstance(
        com.google.cloud.notebooks.v2.StopInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Resets a notebook instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> resetInstance(
        com.google.cloud.notebooks.v2.ResetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Checks whether a notebook instance is upgradable.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityResponse> checkInstanceUpgradability(
        com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckInstanceUpgradabilityMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Upgrades a notebook instance to the latest version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> upgradeInstance(
        com.google.cloud.notebooks.v2.UpgradeInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpgradeInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Rollbacks a notebook instance to the previous version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> rollbackInstance(
        com.google.cloud.notebooks.v2.RollbackInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollbackInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a Diagnostic File and runs Diagnostic Tool given an Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> diagnoseInstance(
        com.google.cloud.notebooks.v2.DiagnoseInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDiagnoseInstanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_CREATE_INSTANCE = 2;
  private static final int METHODID_UPDATE_INSTANCE = 3;
  private static final int METHODID_DELETE_INSTANCE = 4;
  private static final int METHODID_START_INSTANCE = 5;
  private static final int METHODID_STOP_INSTANCE = 6;
  private static final int METHODID_RESET_INSTANCE = 7;
  private static final int METHODID_CHECK_INSTANCE_UPGRADABILITY = 8;
  private static final int METHODID_UPGRADE_INSTANCE = 9;
  private static final int METHODID_ROLLBACK_INSTANCE = 10;
  private static final int METHODID_DIAGNOSE_INSTANCE = 11;

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
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances((com.google.cloud.notebooks.v2.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v2.ListInstancesResponse>) responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance((com.google.cloud.notebooks.v2.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v2.Instance>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance((com.google.cloud.notebooks.v2.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance((com.google.cloud.notebooks.v2.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance((com.google.cloud.notebooks.v2.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_INSTANCE:
          serviceImpl.startInstance((com.google.cloud.notebooks.v2.StartInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_STOP_INSTANCE:
          serviceImpl.stopInstance((com.google.cloud.notebooks.v2.StopInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESET_INSTANCE:
          serviceImpl.resetInstance((com.google.cloud.notebooks.v2.ResetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CHECK_INSTANCE_UPGRADABILITY:
          serviceImpl.checkInstanceUpgradability((com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityResponse>) responseObserver);
          break;
        case METHODID_UPGRADE_INSTANCE:
          serviceImpl.upgradeInstance((com.google.cloud.notebooks.v2.UpgradeInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ROLLBACK_INSTANCE:
          serviceImpl.rollbackInstance((com.google.cloud.notebooks.v2.RollbackInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DIAGNOSE_INSTANCE:
          serviceImpl.diagnoseInstance((com.google.cloud.notebooks.v2.DiagnoseInstanceRequest) request,
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
          getListInstancesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.notebooks.v2.ListInstancesRequest,
              com.google.cloud.notebooks.v2.ListInstancesResponse>(
                service, METHODID_LIST_INSTANCES)))
        .addMethod(
          getGetInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.notebooks.v2.GetInstanceRequest,
              com.google.cloud.notebooks.v2.Instance>(
                service, METHODID_GET_INSTANCE)))
        .addMethod(
          getCreateInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.notebooks.v2.CreateInstanceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_INSTANCE)))
        .addMethod(
          getUpdateInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.notebooks.v2.UpdateInstanceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_INSTANCE)))
        .addMethod(
          getDeleteInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.notebooks.v2.DeleteInstanceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_INSTANCE)))
        .addMethod(
          getStartInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.notebooks.v2.StartInstanceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_START_INSTANCE)))
        .addMethod(
          getStopInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.notebooks.v2.StopInstanceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_STOP_INSTANCE)))
        .addMethod(
          getResetInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.notebooks.v2.ResetInstanceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_RESET_INSTANCE)))
        .addMethod(
          getCheckInstanceUpgradabilityMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityRequest,
              com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityResponse>(
                service, METHODID_CHECK_INSTANCE_UPGRADABILITY)))
        .addMethod(
          getUpgradeInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.notebooks.v2.UpgradeInstanceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPGRADE_INSTANCE)))
        .addMethod(
          getRollbackInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.notebooks.v2.RollbackInstanceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_ROLLBACK_INSTANCE)))
        .addMethod(
          getDiagnoseInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.notebooks.v2.DiagnoseInstanceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DIAGNOSE_INSTANCE)))
        .build();
  }

  private static abstract class NotebookServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NotebookServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.notebooks.v2.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NotebookService");
    }
  }

  private static final class NotebookServiceFileDescriptorSupplier
      extends NotebookServiceBaseDescriptorSupplier {
    NotebookServiceFileDescriptorSupplier() {}
  }

  private static final class NotebookServiceMethodDescriptorSupplier
      extends NotebookServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NotebookServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (NotebookServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NotebookServiceFileDescriptorSupplier())
              .addMethod(getListInstancesMethod())
              .addMethod(getGetInstanceMethod())
              .addMethod(getCreateInstanceMethod())
              .addMethod(getUpdateInstanceMethod())
              .addMethod(getDeleteInstanceMethod())
              .addMethod(getStartInstanceMethod())
              .addMethod(getStopInstanceMethod())
              .addMethod(getResetInstanceMethod())
              .addMethod(getCheckInstanceUpgradabilityMethod())
              .addMethod(getUpgradeInstanceMethod())
              .addMethod(getRollbackInstanceMethod())
              .addMethod(getDiagnoseInstanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
