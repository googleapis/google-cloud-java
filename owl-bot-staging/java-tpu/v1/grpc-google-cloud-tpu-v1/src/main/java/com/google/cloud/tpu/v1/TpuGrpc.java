package com.google.cloud.tpu.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Manages TPU nodes and other resources
 * TPU API v1
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/tpu/v1/cloud_tpu.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TpuGrpc {

  private TpuGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.tpu.v1.Tpu";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.ListNodesRequest,
      com.google.cloud.tpu.v1.ListNodesResponse> getListNodesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNodes",
      requestType = com.google.cloud.tpu.v1.ListNodesRequest.class,
      responseType = com.google.cloud.tpu.v1.ListNodesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.ListNodesRequest,
      com.google.cloud.tpu.v1.ListNodesResponse> getListNodesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.ListNodesRequest, com.google.cloud.tpu.v1.ListNodesResponse> getListNodesMethod;
    if ((getListNodesMethod = TpuGrpc.getListNodesMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getListNodesMethod = TpuGrpc.getListNodesMethod) == null) {
          TpuGrpc.getListNodesMethod = getListNodesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.tpu.v1.ListNodesRequest, com.google.cloud.tpu.v1.ListNodesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNodes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.ListNodesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.ListNodesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TpuMethodDescriptorSupplier("ListNodes"))
              .build();
        }
      }
    }
    return getListNodesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.GetNodeRequest,
      com.google.cloud.tpu.v1.Node> getGetNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNode",
      requestType = com.google.cloud.tpu.v1.GetNodeRequest.class,
      responseType = com.google.cloud.tpu.v1.Node.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.GetNodeRequest,
      com.google.cloud.tpu.v1.Node> getGetNodeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.GetNodeRequest, com.google.cloud.tpu.v1.Node> getGetNodeMethod;
    if ((getGetNodeMethod = TpuGrpc.getGetNodeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getGetNodeMethod = TpuGrpc.getGetNodeMethod) == null) {
          TpuGrpc.getGetNodeMethod = getGetNodeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.tpu.v1.GetNodeRequest, com.google.cloud.tpu.v1.Node>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.GetNodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.Node.getDefaultInstance()))
              .setSchemaDescriptor(new TpuMethodDescriptorSupplier("GetNode"))
              .build();
        }
      }
    }
    return getGetNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.CreateNodeRequest,
      com.google.longrunning.Operation> getCreateNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNode",
      requestType = com.google.cloud.tpu.v1.CreateNodeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.CreateNodeRequest,
      com.google.longrunning.Operation> getCreateNodeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.CreateNodeRequest, com.google.longrunning.Operation> getCreateNodeMethod;
    if ((getCreateNodeMethod = TpuGrpc.getCreateNodeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getCreateNodeMethod = TpuGrpc.getCreateNodeMethod) == null) {
          TpuGrpc.getCreateNodeMethod = getCreateNodeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.tpu.v1.CreateNodeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.CreateNodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TpuMethodDescriptorSupplier("CreateNode"))
              .build();
        }
      }
    }
    return getCreateNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.DeleteNodeRequest,
      com.google.longrunning.Operation> getDeleteNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNode",
      requestType = com.google.cloud.tpu.v1.DeleteNodeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.DeleteNodeRequest,
      com.google.longrunning.Operation> getDeleteNodeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.DeleteNodeRequest, com.google.longrunning.Operation> getDeleteNodeMethod;
    if ((getDeleteNodeMethod = TpuGrpc.getDeleteNodeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getDeleteNodeMethod = TpuGrpc.getDeleteNodeMethod) == null) {
          TpuGrpc.getDeleteNodeMethod = getDeleteNodeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.tpu.v1.DeleteNodeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.DeleteNodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TpuMethodDescriptorSupplier("DeleteNode"))
              .build();
        }
      }
    }
    return getDeleteNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.ReimageNodeRequest,
      com.google.longrunning.Operation> getReimageNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReimageNode",
      requestType = com.google.cloud.tpu.v1.ReimageNodeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.ReimageNodeRequest,
      com.google.longrunning.Operation> getReimageNodeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.ReimageNodeRequest, com.google.longrunning.Operation> getReimageNodeMethod;
    if ((getReimageNodeMethod = TpuGrpc.getReimageNodeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getReimageNodeMethod = TpuGrpc.getReimageNodeMethod) == null) {
          TpuGrpc.getReimageNodeMethod = getReimageNodeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.tpu.v1.ReimageNodeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReimageNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.ReimageNodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TpuMethodDescriptorSupplier("ReimageNode"))
              .build();
        }
      }
    }
    return getReimageNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.StopNodeRequest,
      com.google.longrunning.Operation> getStopNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopNode",
      requestType = com.google.cloud.tpu.v1.StopNodeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.StopNodeRequest,
      com.google.longrunning.Operation> getStopNodeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.StopNodeRequest, com.google.longrunning.Operation> getStopNodeMethod;
    if ((getStopNodeMethod = TpuGrpc.getStopNodeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getStopNodeMethod = TpuGrpc.getStopNodeMethod) == null) {
          TpuGrpc.getStopNodeMethod = getStopNodeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.tpu.v1.StopNodeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.StopNodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TpuMethodDescriptorSupplier("StopNode"))
              .build();
        }
      }
    }
    return getStopNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.StartNodeRequest,
      com.google.longrunning.Operation> getStartNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartNode",
      requestType = com.google.cloud.tpu.v1.StartNodeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.StartNodeRequest,
      com.google.longrunning.Operation> getStartNodeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.StartNodeRequest, com.google.longrunning.Operation> getStartNodeMethod;
    if ((getStartNodeMethod = TpuGrpc.getStartNodeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getStartNodeMethod = TpuGrpc.getStartNodeMethod) == null) {
          TpuGrpc.getStartNodeMethod = getStartNodeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.tpu.v1.StartNodeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.StartNodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TpuMethodDescriptorSupplier("StartNode"))
              .build();
        }
      }
    }
    return getStartNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest,
      com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse> getListTensorFlowVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTensorFlowVersions",
      requestType = com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest.class,
      responseType = com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest,
      com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse> getListTensorFlowVersionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest, com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse> getListTensorFlowVersionsMethod;
    if ((getListTensorFlowVersionsMethod = TpuGrpc.getListTensorFlowVersionsMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getListTensorFlowVersionsMethod = TpuGrpc.getListTensorFlowVersionsMethod) == null) {
          TpuGrpc.getListTensorFlowVersionsMethod = getListTensorFlowVersionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest, com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTensorFlowVersions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TpuMethodDescriptorSupplier("ListTensorFlowVersions"))
              .build();
        }
      }
    }
    return getListTensorFlowVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.GetTensorFlowVersionRequest,
      com.google.cloud.tpu.v1.TensorFlowVersion> getGetTensorFlowVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTensorFlowVersion",
      requestType = com.google.cloud.tpu.v1.GetTensorFlowVersionRequest.class,
      responseType = com.google.cloud.tpu.v1.TensorFlowVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.GetTensorFlowVersionRequest,
      com.google.cloud.tpu.v1.TensorFlowVersion> getGetTensorFlowVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.GetTensorFlowVersionRequest, com.google.cloud.tpu.v1.TensorFlowVersion> getGetTensorFlowVersionMethod;
    if ((getGetTensorFlowVersionMethod = TpuGrpc.getGetTensorFlowVersionMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getGetTensorFlowVersionMethod = TpuGrpc.getGetTensorFlowVersionMethod) == null) {
          TpuGrpc.getGetTensorFlowVersionMethod = getGetTensorFlowVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.tpu.v1.GetTensorFlowVersionRequest, com.google.cloud.tpu.v1.TensorFlowVersion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTensorFlowVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.GetTensorFlowVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.TensorFlowVersion.getDefaultInstance()))
              .setSchemaDescriptor(new TpuMethodDescriptorSupplier("GetTensorFlowVersion"))
              .build();
        }
      }
    }
    return getGetTensorFlowVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.ListAcceleratorTypesRequest,
      com.google.cloud.tpu.v1.ListAcceleratorTypesResponse> getListAcceleratorTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAcceleratorTypes",
      requestType = com.google.cloud.tpu.v1.ListAcceleratorTypesRequest.class,
      responseType = com.google.cloud.tpu.v1.ListAcceleratorTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.ListAcceleratorTypesRequest,
      com.google.cloud.tpu.v1.ListAcceleratorTypesResponse> getListAcceleratorTypesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.ListAcceleratorTypesRequest, com.google.cloud.tpu.v1.ListAcceleratorTypesResponse> getListAcceleratorTypesMethod;
    if ((getListAcceleratorTypesMethod = TpuGrpc.getListAcceleratorTypesMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getListAcceleratorTypesMethod = TpuGrpc.getListAcceleratorTypesMethod) == null) {
          TpuGrpc.getListAcceleratorTypesMethod = getListAcceleratorTypesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.tpu.v1.ListAcceleratorTypesRequest, com.google.cloud.tpu.v1.ListAcceleratorTypesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAcceleratorTypes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.ListAcceleratorTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.ListAcceleratorTypesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TpuMethodDescriptorSupplier("ListAcceleratorTypes"))
              .build();
        }
      }
    }
    return getListAcceleratorTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.GetAcceleratorTypeRequest,
      com.google.cloud.tpu.v1.AcceleratorType> getGetAcceleratorTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAcceleratorType",
      requestType = com.google.cloud.tpu.v1.GetAcceleratorTypeRequest.class,
      responseType = com.google.cloud.tpu.v1.AcceleratorType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.GetAcceleratorTypeRequest,
      com.google.cloud.tpu.v1.AcceleratorType> getGetAcceleratorTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.tpu.v1.GetAcceleratorTypeRequest, com.google.cloud.tpu.v1.AcceleratorType> getGetAcceleratorTypeMethod;
    if ((getGetAcceleratorTypeMethod = TpuGrpc.getGetAcceleratorTypeMethod) == null) {
      synchronized (TpuGrpc.class) {
        if ((getGetAcceleratorTypeMethod = TpuGrpc.getGetAcceleratorTypeMethod) == null) {
          TpuGrpc.getGetAcceleratorTypeMethod = getGetAcceleratorTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.tpu.v1.GetAcceleratorTypeRequest, com.google.cloud.tpu.v1.AcceleratorType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAcceleratorType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.GetAcceleratorTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.tpu.v1.AcceleratorType.getDefaultInstance()))
              .setSchemaDescriptor(new TpuMethodDescriptorSupplier("GetAcceleratorType"))
              .build();
        }
      }
    }
    return getGetAcceleratorTypeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TpuStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TpuStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TpuStub>() {
        @java.lang.Override
        public TpuStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TpuStub(channel, callOptions);
        }
      };
    return TpuStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TpuBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TpuBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TpuBlockingStub>() {
        @java.lang.Override
        public TpuBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TpuBlockingStub(channel, callOptions);
        }
      };
    return TpuBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TpuFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TpuFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TpuFutureStub>() {
        @java.lang.Override
        public TpuFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TpuFutureStub(channel, callOptions);
        }
      };
    return TpuFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Manages TPU nodes and other resources
   * TPU API v1
   * </pre>
   */
  public static abstract class TpuImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists nodes.
     * </pre>
     */
    public void listNodes(com.google.cloud.tpu.v1.ListNodesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.ListNodesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListNodesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a node.
     * </pre>
     */
    public void getNode(com.google.cloud.tpu.v1.GetNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.Node> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNodeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a node.
     * </pre>
     */
    public void createNode(com.google.cloud.tpu.v1.CreateNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateNodeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a node.
     * </pre>
     */
    public void deleteNode(com.google.cloud.tpu.v1.DeleteNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteNodeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Reimages a node's OS.
     * </pre>
     */
    public void reimageNode(com.google.cloud.tpu.v1.ReimageNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReimageNodeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Stops a node.
     * </pre>
     */
    public void stopNode(com.google.cloud.tpu.v1.StopNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopNodeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Starts a node.
     * </pre>
     */
    public void startNode(com.google.cloud.tpu.v1.StartNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartNodeMethod(), responseObserver);
    }

    /**
     * <pre>
     * List TensorFlow versions supported by this API.
     * </pre>
     */
    public void listTensorFlowVersions(com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTensorFlowVersionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets TensorFlow Version.
     * </pre>
     */
    public void getTensorFlowVersion(com.google.cloud.tpu.v1.GetTensorFlowVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.TensorFlowVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTensorFlowVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists accelerator types supported by this API.
     * </pre>
     */
    public void listAcceleratorTypes(com.google.cloud.tpu.v1.ListAcceleratorTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.ListAcceleratorTypesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAcceleratorTypesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets AcceleratorType.
     * </pre>
     */
    public void getAcceleratorType(com.google.cloud.tpu.v1.GetAcceleratorTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.AcceleratorType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAcceleratorTypeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListNodesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.tpu.v1.ListNodesRequest,
                com.google.cloud.tpu.v1.ListNodesResponse>(
                  this, METHODID_LIST_NODES)))
          .addMethod(
            getGetNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.tpu.v1.GetNodeRequest,
                com.google.cloud.tpu.v1.Node>(
                  this, METHODID_GET_NODE)))
          .addMethod(
            getCreateNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.tpu.v1.CreateNodeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_NODE)))
          .addMethod(
            getDeleteNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.tpu.v1.DeleteNodeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_NODE)))
          .addMethod(
            getReimageNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.tpu.v1.ReimageNodeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_REIMAGE_NODE)))
          .addMethod(
            getStopNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.tpu.v1.StopNodeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_STOP_NODE)))
          .addMethod(
            getStartNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.tpu.v1.StartNodeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_START_NODE)))
          .addMethod(
            getListTensorFlowVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest,
                com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse>(
                  this, METHODID_LIST_TENSOR_FLOW_VERSIONS)))
          .addMethod(
            getGetTensorFlowVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.tpu.v1.GetTensorFlowVersionRequest,
                com.google.cloud.tpu.v1.TensorFlowVersion>(
                  this, METHODID_GET_TENSOR_FLOW_VERSION)))
          .addMethod(
            getListAcceleratorTypesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.tpu.v1.ListAcceleratorTypesRequest,
                com.google.cloud.tpu.v1.ListAcceleratorTypesResponse>(
                  this, METHODID_LIST_ACCELERATOR_TYPES)))
          .addMethod(
            getGetAcceleratorTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.tpu.v1.GetAcceleratorTypeRequest,
                com.google.cloud.tpu.v1.AcceleratorType>(
                  this, METHODID_GET_ACCELERATOR_TYPE)))
          .build();
    }
  }

  /**
   * <pre>
   * Manages TPU nodes and other resources
   * TPU API v1
   * </pre>
   */
  public static final class TpuStub extends io.grpc.stub.AbstractAsyncStub<TpuStub> {
    private TpuStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TpuStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TpuStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists nodes.
     * </pre>
     */
    public void listNodes(com.google.cloud.tpu.v1.ListNodesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.ListNodesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNodesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a node.
     * </pre>
     */
    public void getNode(com.google.cloud.tpu.v1.GetNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.Node> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a node.
     * </pre>
     */
    public void createNode(com.google.cloud.tpu.v1.CreateNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a node.
     * </pre>
     */
    public void deleteNode(com.google.cloud.tpu.v1.DeleteNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Reimages a node's OS.
     * </pre>
     */
    public void reimageNode(com.google.cloud.tpu.v1.ReimageNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReimageNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Stops a node.
     * </pre>
     */
    public void stopNode(com.google.cloud.tpu.v1.StopNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Starts a node.
     * </pre>
     */
    public void startNode(com.google.cloud.tpu.v1.StartNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List TensorFlow versions supported by this API.
     * </pre>
     */
    public void listTensorFlowVersions(com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTensorFlowVersionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets TensorFlow Version.
     * </pre>
     */
    public void getTensorFlowVersion(com.google.cloud.tpu.v1.GetTensorFlowVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.TensorFlowVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTensorFlowVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists accelerator types supported by this API.
     * </pre>
     */
    public void listAcceleratorTypes(com.google.cloud.tpu.v1.ListAcceleratorTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.ListAcceleratorTypesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAcceleratorTypesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets AcceleratorType.
     * </pre>
     */
    public void getAcceleratorType(com.google.cloud.tpu.v1.GetAcceleratorTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.AcceleratorType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAcceleratorTypeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Manages TPU nodes and other resources
   * TPU API v1
   * </pre>
   */
  public static final class TpuBlockingStub extends io.grpc.stub.AbstractBlockingStub<TpuBlockingStub> {
    private TpuBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TpuBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TpuBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists nodes.
     * </pre>
     */
    public com.google.cloud.tpu.v1.ListNodesResponse listNodes(com.google.cloud.tpu.v1.ListNodesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNodesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the details of a node.
     * </pre>
     */
    public com.google.cloud.tpu.v1.Node getNode(com.google.cloud.tpu.v1.GetNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNodeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a node.
     * </pre>
     */
    public com.google.longrunning.Operation createNode(com.google.cloud.tpu.v1.CreateNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNodeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a node.
     * </pre>
     */
    public com.google.longrunning.Operation deleteNode(com.google.cloud.tpu.v1.DeleteNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNodeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Reimages a node's OS.
     * </pre>
     */
    public com.google.longrunning.Operation reimageNode(com.google.cloud.tpu.v1.ReimageNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReimageNodeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Stops a node.
     * </pre>
     */
    public com.google.longrunning.Operation stopNode(com.google.cloud.tpu.v1.StopNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopNodeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Starts a node.
     * </pre>
     */
    public com.google.longrunning.Operation startNode(com.google.cloud.tpu.v1.StartNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartNodeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List TensorFlow versions supported by this API.
     * </pre>
     */
    public com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse listTensorFlowVersions(com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTensorFlowVersionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets TensorFlow Version.
     * </pre>
     */
    public com.google.cloud.tpu.v1.TensorFlowVersion getTensorFlowVersion(com.google.cloud.tpu.v1.GetTensorFlowVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTensorFlowVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists accelerator types supported by this API.
     * </pre>
     */
    public com.google.cloud.tpu.v1.ListAcceleratorTypesResponse listAcceleratorTypes(com.google.cloud.tpu.v1.ListAcceleratorTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAcceleratorTypesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets AcceleratorType.
     * </pre>
     */
    public com.google.cloud.tpu.v1.AcceleratorType getAcceleratorType(com.google.cloud.tpu.v1.GetAcceleratorTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAcceleratorTypeMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Manages TPU nodes and other resources
   * TPU API v1
   * </pre>
   */
  public static final class TpuFutureStub extends io.grpc.stub.AbstractFutureStub<TpuFutureStub> {
    private TpuFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TpuFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TpuFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists nodes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.tpu.v1.ListNodesResponse> listNodes(
        com.google.cloud.tpu.v1.ListNodesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNodesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the details of a node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.tpu.v1.Node> getNode(
        com.google.cloud.tpu.v1.GetNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNodeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createNode(
        com.google.cloud.tpu.v1.CreateNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNodeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteNode(
        com.google.cloud.tpu.v1.DeleteNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNodeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Reimages a node's OS.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> reimageNode(
        com.google.cloud.tpu.v1.ReimageNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReimageNodeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Stops a node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> stopNode(
        com.google.cloud.tpu.v1.StopNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopNodeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Starts a node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> startNode(
        com.google.cloud.tpu.v1.StartNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartNodeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List TensorFlow versions supported by this API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse> listTensorFlowVersions(
        com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTensorFlowVersionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets TensorFlow Version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.tpu.v1.TensorFlowVersion> getTensorFlowVersion(
        com.google.cloud.tpu.v1.GetTensorFlowVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTensorFlowVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists accelerator types supported by this API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.tpu.v1.ListAcceleratorTypesResponse> listAcceleratorTypes(
        com.google.cloud.tpu.v1.ListAcceleratorTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAcceleratorTypesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets AcceleratorType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.tpu.v1.AcceleratorType> getAcceleratorType(
        com.google.cloud.tpu.v1.GetAcceleratorTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAcceleratorTypeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_NODES = 0;
  private static final int METHODID_GET_NODE = 1;
  private static final int METHODID_CREATE_NODE = 2;
  private static final int METHODID_DELETE_NODE = 3;
  private static final int METHODID_REIMAGE_NODE = 4;
  private static final int METHODID_STOP_NODE = 5;
  private static final int METHODID_START_NODE = 6;
  private static final int METHODID_LIST_TENSOR_FLOW_VERSIONS = 7;
  private static final int METHODID_GET_TENSOR_FLOW_VERSION = 8;
  private static final int METHODID_LIST_ACCELERATOR_TYPES = 9;
  private static final int METHODID_GET_ACCELERATOR_TYPE = 10;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TpuImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TpuImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_NODES:
          serviceImpl.listNodes((com.google.cloud.tpu.v1.ListNodesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.ListNodesResponse>) responseObserver);
          break;
        case METHODID_GET_NODE:
          serviceImpl.getNode((com.google.cloud.tpu.v1.GetNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.Node>) responseObserver);
          break;
        case METHODID_CREATE_NODE:
          serviceImpl.createNode((com.google.cloud.tpu.v1.CreateNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_NODE:
          serviceImpl.deleteNode((com.google.cloud.tpu.v1.DeleteNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REIMAGE_NODE:
          serviceImpl.reimageNode((com.google.cloud.tpu.v1.ReimageNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_STOP_NODE:
          serviceImpl.stopNode((com.google.cloud.tpu.v1.StopNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_NODE:
          serviceImpl.startNode((com.google.cloud.tpu.v1.StartNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_TENSOR_FLOW_VERSIONS:
          serviceImpl.listTensorFlowVersions((com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse>) responseObserver);
          break;
        case METHODID_GET_TENSOR_FLOW_VERSION:
          serviceImpl.getTensorFlowVersion((com.google.cloud.tpu.v1.GetTensorFlowVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.TensorFlowVersion>) responseObserver);
          break;
        case METHODID_LIST_ACCELERATOR_TYPES:
          serviceImpl.listAcceleratorTypes((com.google.cloud.tpu.v1.ListAcceleratorTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.ListAcceleratorTypesResponse>) responseObserver);
          break;
        case METHODID_GET_ACCELERATOR_TYPE:
          serviceImpl.getAcceleratorType((com.google.cloud.tpu.v1.GetAcceleratorTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.tpu.v1.AcceleratorType>) responseObserver);
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

  private static abstract class TpuBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TpuBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.tpu.v1.CloudTpuProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Tpu");
    }
  }

  private static final class TpuFileDescriptorSupplier
      extends TpuBaseDescriptorSupplier {
    TpuFileDescriptorSupplier() {}
  }

  private static final class TpuMethodDescriptorSupplier
      extends TpuBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TpuMethodDescriptorSupplier(String methodName) {
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
      synchronized (TpuGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TpuFileDescriptorSupplier())
              .addMethod(getListNodesMethod())
              .addMethod(getGetNodeMethod())
              .addMethod(getCreateNodeMethod())
              .addMethod(getDeleteNodeMethod())
              .addMethod(getReimageNodeMethod())
              .addMethod(getStopNodeMethod())
              .addMethod(getStartNodeMethod())
              .addMethod(getListTensorFlowVersionsMethod())
              .addMethod(getGetTensorFlowVersionMethod())
              .addMethod(getListAcceleratorTypesMethod())
              .addMethod(getGetAcceleratorTypeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
