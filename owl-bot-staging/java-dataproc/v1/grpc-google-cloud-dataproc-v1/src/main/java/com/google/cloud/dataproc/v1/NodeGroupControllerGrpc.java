package com.google.cloud.dataproc.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The `NodeGroupControllerService` provides methods to manage node groups
 * of Compute Engine managed instances.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataproc/v1/node_groups.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NodeGroupControllerGrpc {

  private NodeGroupControllerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dataproc.v1.NodeGroupController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateNodeGroupRequest,
      com.google.longrunning.Operation> getCreateNodeGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNodeGroup",
      requestType = com.google.cloud.dataproc.v1.CreateNodeGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateNodeGroupRequest,
      com.google.longrunning.Operation> getCreateNodeGroupMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateNodeGroupRequest, com.google.longrunning.Operation> getCreateNodeGroupMethod;
    if ((getCreateNodeGroupMethod = NodeGroupControllerGrpc.getCreateNodeGroupMethod) == null) {
      synchronized (NodeGroupControllerGrpc.class) {
        if ((getCreateNodeGroupMethod = NodeGroupControllerGrpc.getCreateNodeGroupMethod) == null) {
          NodeGroupControllerGrpc.getCreateNodeGroupMethod = getCreateNodeGroupMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.CreateNodeGroupRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNodeGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.CreateNodeGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NodeGroupControllerMethodDescriptorSupplier("CreateNodeGroup"))
              .build();
        }
      }
    }
    return getCreateNodeGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ResizeNodeGroupRequest,
      com.google.longrunning.Operation> getResizeNodeGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResizeNodeGroup",
      requestType = com.google.cloud.dataproc.v1.ResizeNodeGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ResizeNodeGroupRequest,
      com.google.longrunning.Operation> getResizeNodeGroupMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ResizeNodeGroupRequest, com.google.longrunning.Operation> getResizeNodeGroupMethod;
    if ((getResizeNodeGroupMethod = NodeGroupControllerGrpc.getResizeNodeGroupMethod) == null) {
      synchronized (NodeGroupControllerGrpc.class) {
        if ((getResizeNodeGroupMethod = NodeGroupControllerGrpc.getResizeNodeGroupMethod) == null) {
          NodeGroupControllerGrpc.getResizeNodeGroupMethod = getResizeNodeGroupMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.ResizeNodeGroupRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResizeNodeGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.ResizeNodeGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NodeGroupControllerMethodDescriptorSupplier("ResizeNodeGroup"))
              .build();
        }
      }
    }
    return getResizeNodeGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetNodeGroupRequest,
      com.google.cloud.dataproc.v1.NodeGroup> getGetNodeGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNodeGroup",
      requestType = com.google.cloud.dataproc.v1.GetNodeGroupRequest.class,
      responseType = com.google.cloud.dataproc.v1.NodeGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetNodeGroupRequest,
      com.google.cloud.dataproc.v1.NodeGroup> getGetNodeGroupMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetNodeGroupRequest, com.google.cloud.dataproc.v1.NodeGroup> getGetNodeGroupMethod;
    if ((getGetNodeGroupMethod = NodeGroupControllerGrpc.getGetNodeGroupMethod) == null) {
      synchronized (NodeGroupControllerGrpc.class) {
        if ((getGetNodeGroupMethod = NodeGroupControllerGrpc.getGetNodeGroupMethod) == null) {
          NodeGroupControllerGrpc.getGetNodeGroupMethod = getGetNodeGroupMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.GetNodeGroupRequest, com.google.cloud.dataproc.v1.NodeGroup>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNodeGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.GetNodeGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.NodeGroup.getDefaultInstance()))
              .setSchemaDescriptor(new NodeGroupControllerMethodDescriptorSupplier("GetNodeGroup"))
              .build();
        }
      }
    }
    return getGetNodeGroupMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NodeGroupControllerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NodeGroupControllerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NodeGroupControllerStub>() {
        @java.lang.Override
        public NodeGroupControllerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NodeGroupControllerStub(channel, callOptions);
        }
      };
    return NodeGroupControllerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NodeGroupControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NodeGroupControllerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NodeGroupControllerBlockingStub>() {
        @java.lang.Override
        public NodeGroupControllerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NodeGroupControllerBlockingStub(channel, callOptions);
        }
      };
    return NodeGroupControllerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NodeGroupControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NodeGroupControllerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NodeGroupControllerFutureStub>() {
        @java.lang.Override
        public NodeGroupControllerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NodeGroupControllerFutureStub(channel, callOptions);
        }
      };
    return NodeGroupControllerFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The `NodeGroupControllerService` provides methods to manage node groups
   * of Compute Engine managed instances.
   * </pre>
   */
  public static abstract class NodeGroupControllerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a node group in a cluster. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] is
     * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
     * </pre>
     */
    public void createNodeGroup(com.google.cloud.dataproc.v1.CreateNodeGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateNodeGroupMethod(), responseObserver);
    }

    /**
     * <pre>
     * Resizes a node group in a cluster. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] is
     * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
     * </pre>
     */
    public void resizeNodeGroup(com.google.cloud.dataproc.v1.ResizeNodeGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResizeNodeGroupMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the resource representation for a node group in a
     * cluster.
     * </pre>
     */
    public void getNodeGroup(com.google.cloud.dataproc.v1.GetNodeGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.NodeGroup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNodeGroupMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateNodeGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.CreateNodeGroupRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_NODE_GROUP)))
          .addMethod(
            getResizeNodeGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.ResizeNodeGroupRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RESIZE_NODE_GROUP)))
          .addMethod(
            getGetNodeGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.GetNodeGroupRequest,
                com.google.cloud.dataproc.v1.NodeGroup>(
                  this, METHODID_GET_NODE_GROUP)))
          .build();
    }
  }

  /**
   * <pre>
   * The `NodeGroupControllerService` provides methods to manage node groups
   * of Compute Engine managed instances.
   * </pre>
   */
  public static final class NodeGroupControllerStub extends io.grpc.stub.AbstractAsyncStub<NodeGroupControllerStub> {
    private NodeGroupControllerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NodeGroupControllerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NodeGroupControllerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a node group in a cluster. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] is
     * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
     * </pre>
     */
    public void createNodeGroup(com.google.cloud.dataproc.v1.CreateNodeGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNodeGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Resizes a node group in a cluster. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] is
     * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
     * </pre>
     */
    public void resizeNodeGroup(com.google.cloud.dataproc.v1.ResizeNodeGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResizeNodeGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the resource representation for a node group in a
     * cluster.
     * </pre>
     */
    public void getNodeGroup(com.google.cloud.dataproc.v1.GetNodeGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.NodeGroup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNodeGroupMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The `NodeGroupControllerService` provides methods to manage node groups
   * of Compute Engine managed instances.
   * </pre>
   */
  public static final class NodeGroupControllerBlockingStub extends io.grpc.stub.AbstractBlockingStub<NodeGroupControllerBlockingStub> {
    private NodeGroupControllerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NodeGroupControllerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NodeGroupControllerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a node group in a cluster. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] is
     * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
     * </pre>
     */
    public com.google.longrunning.Operation createNodeGroup(com.google.cloud.dataproc.v1.CreateNodeGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNodeGroupMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Resizes a node group in a cluster. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] is
     * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
     * </pre>
     */
    public com.google.longrunning.Operation resizeNodeGroup(com.google.cloud.dataproc.v1.ResizeNodeGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResizeNodeGroupMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the resource representation for a node group in a
     * cluster.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.NodeGroup getNodeGroup(com.google.cloud.dataproc.v1.GetNodeGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNodeGroupMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The `NodeGroupControllerService` provides methods to manage node groups
   * of Compute Engine managed instances.
   * </pre>
   */
  public static final class NodeGroupControllerFutureStub extends io.grpc.stub.AbstractFutureStub<NodeGroupControllerFutureStub> {
    private NodeGroupControllerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NodeGroupControllerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NodeGroupControllerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a node group in a cluster. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] is
     * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createNodeGroup(
        com.google.cloud.dataproc.v1.CreateNodeGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNodeGroupMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Resizes a node group in a cluster. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] is
     * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> resizeNodeGroup(
        com.google.cloud.dataproc.v1.ResizeNodeGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResizeNodeGroupMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the resource representation for a node group in a
     * cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.NodeGroup> getNodeGroup(
        com.google.cloud.dataproc.v1.GetNodeGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNodeGroupMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_NODE_GROUP = 0;
  private static final int METHODID_RESIZE_NODE_GROUP = 1;
  private static final int METHODID_GET_NODE_GROUP = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NodeGroupControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NodeGroupControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_NODE_GROUP:
          serviceImpl.createNodeGroup((com.google.cloud.dataproc.v1.CreateNodeGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESIZE_NODE_GROUP:
          serviceImpl.resizeNodeGroup((com.google.cloud.dataproc.v1.ResizeNodeGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_NODE_GROUP:
          serviceImpl.getNodeGroup((com.google.cloud.dataproc.v1.GetNodeGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.NodeGroup>) responseObserver);
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

  private static abstract class NodeGroupControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NodeGroupControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataproc.v1.NodeGroupsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NodeGroupController");
    }
  }

  private static final class NodeGroupControllerFileDescriptorSupplier
      extends NodeGroupControllerBaseDescriptorSupplier {
    NodeGroupControllerFileDescriptorSupplier() {}
  }

  private static final class NodeGroupControllerMethodDescriptorSupplier
      extends NodeGroupControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NodeGroupControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (NodeGroupControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NodeGroupControllerFileDescriptorSupplier())
              .addMethod(getCreateNodeGroupMethod())
              .addMethod(getResizeNodeGroupMethod())
              .addMethod(getGetNodeGroupMethod())
              .build();
        }
      }
    }
    return result;
  }
}
