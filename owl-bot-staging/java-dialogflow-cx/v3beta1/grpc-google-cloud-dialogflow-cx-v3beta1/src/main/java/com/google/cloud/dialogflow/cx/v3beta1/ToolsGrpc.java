package com.google.cloud.dialogflow.cx.v3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for managing [Tools][google.cloud.dialogflow.cx.v3beta1.Tool].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3beta1/tool.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ToolsGrpc {

  private ToolsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dialogflow.cx.v3beta1.Tools";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest,
      com.google.cloud.dialogflow.cx.v3beta1.Tool> getCreateToolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTool",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Tool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest,
      com.google.cloud.dialogflow.cx.v3beta1.Tool> getCreateToolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest, com.google.cloud.dialogflow.cx.v3beta1.Tool> getCreateToolMethod;
    if ((getCreateToolMethod = ToolsGrpc.getCreateToolMethod) == null) {
      synchronized (ToolsGrpc.class) {
        if ((getCreateToolMethod = ToolsGrpc.getCreateToolMethod) == null) {
          ToolsGrpc.getCreateToolMethod = getCreateToolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest, com.google.cloud.dialogflow.cx.v3beta1.Tool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.Tool.getDefaultInstance()))
              .setSchemaDescriptor(new ToolsMethodDescriptorSupplier("CreateTool"))
              .build();
        }
      }
    }
    return getCreateToolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest,
      com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse> getListToolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTools",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest,
      com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse> getListToolsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest, com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse> getListToolsMethod;
    if ((getListToolsMethod = ToolsGrpc.getListToolsMethod) == null) {
      synchronized (ToolsGrpc.class) {
        if ((getListToolsMethod = ToolsGrpc.getListToolsMethod) == null) {
          ToolsGrpc.getListToolsMethod = getListToolsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest, com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTools"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ToolsMethodDescriptorSupplier("ListTools"))
              .build();
        }
      }
    }
    return getListToolsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest,
      com.google.longrunning.Operation> getExportToolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportTools",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest,
      com.google.longrunning.Operation> getExportToolsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest, com.google.longrunning.Operation> getExportToolsMethod;
    if ((getExportToolsMethod = ToolsGrpc.getExportToolsMethod) == null) {
      synchronized (ToolsGrpc.class) {
        if ((getExportToolsMethod = ToolsGrpc.getExportToolsMethod) == null) {
          ToolsGrpc.getExportToolsMethod = getExportToolsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportTools"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ToolsMethodDescriptorSupplier("ExportTools"))
              .build();
        }
      }
    }
    return getExportToolsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest,
      com.google.cloud.dialogflow.cx.v3beta1.Tool> getGetToolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTool",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Tool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest,
      com.google.cloud.dialogflow.cx.v3beta1.Tool> getGetToolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest, com.google.cloud.dialogflow.cx.v3beta1.Tool> getGetToolMethod;
    if ((getGetToolMethod = ToolsGrpc.getGetToolMethod) == null) {
      synchronized (ToolsGrpc.class) {
        if ((getGetToolMethod = ToolsGrpc.getGetToolMethod) == null) {
          ToolsGrpc.getGetToolMethod = getGetToolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest, com.google.cloud.dialogflow.cx.v3beta1.Tool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.Tool.getDefaultInstance()))
              .setSchemaDescriptor(new ToolsMethodDescriptorSupplier("GetTool"))
              .build();
        }
      }
    }
    return getGetToolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest,
      com.google.cloud.dialogflow.cx.v3beta1.Tool> getUpdateToolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTool",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Tool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest,
      com.google.cloud.dialogflow.cx.v3beta1.Tool> getUpdateToolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest, com.google.cloud.dialogflow.cx.v3beta1.Tool> getUpdateToolMethod;
    if ((getUpdateToolMethod = ToolsGrpc.getUpdateToolMethod) == null) {
      synchronized (ToolsGrpc.class) {
        if ((getUpdateToolMethod = ToolsGrpc.getUpdateToolMethod) == null) {
          ToolsGrpc.getUpdateToolMethod = getUpdateToolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest, com.google.cloud.dialogflow.cx.v3beta1.Tool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.Tool.getDefaultInstance()))
              .setSchemaDescriptor(new ToolsMethodDescriptorSupplier("UpdateTool"))
              .build();
        }
      }
    }
    return getUpdateToolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest,
      com.google.protobuf.Empty> getDeleteToolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTool",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest,
      com.google.protobuf.Empty> getDeleteToolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest, com.google.protobuf.Empty> getDeleteToolMethod;
    if ((getDeleteToolMethod = ToolsGrpc.getDeleteToolMethod) == null) {
      synchronized (ToolsGrpc.class) {
        if ((getDeleteToolMethod = ToolsGrpc.getDeleteToolMethod) == null) {
          ToolsGrpc.getDeleteToolMethod = getDeleteToolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ToolsMethodDescriptorSupplier("DeleteTool"))
              .build();
        }
      }
    }
    return getDeleteToolMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ToolsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ToolsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ToolsStub>() {
        @java.lang.Override
        public ToolsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ToolsStub(channel, callOptions);
        }
      };
    return ToolsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ToolsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ToolsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ToolsBlockingStub>() {
        @java.lang.Override
        public ToolsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ToolsBlockingStub(channel, callOptions);
        }
      };
    return ToolsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ToolsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ToolsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ToolsFutureStub>() {
        @java.lang.Override
        public ToolsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ToolsFutureStub(channel, callOptions);
        }
      };
    return ToolsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for managing [Tools][google.cloud.dialogflow.cx.v3beta1.Tool].
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Creates a [Tool][google.cloud.dialogflow.cx.v3beta1.Tool] in the specified
     * agent.
     * </pre>
     */
    default void createTool(com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Tool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateToolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a list of [Tools][google.cloud.dialogflow.cx.v3beta1.Tool] in the
     * specified agent.
     * </pre>
     */
    default void listTools(com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListToolsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Exports the selected tools.
     * </pre>
     */
    default void exportTools(com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportToolsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified [Tool][google.cloud.dialogflow.cx.v3beta1.Tool].
     * </pre>
     */
    default void getTool(com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Tool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetToolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update the specified [Tool][google.cloud.dialogflow.cx.v3beta1.Tool].
     * </pre>
     */
    default void updateTool(com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Tool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateToolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a specified [Tool][google.cloud.dialogflow.cx.v3beta1.Tool].
     * </pre>
     */
    default void deleteTool(com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteToolMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Tools.
   * <pre>
   * Service for managing [Tools][google.cloud.dialogflow.cx.v3beta1.Tool].
   * </pre>
   */
  public static abstract class ToolsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ToolsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Tools.
   * <pre>
   * Service for managing [Tools][google.cloud.dialogflow.cx.v3beta1.Tool].
   * </pre>
   */
  public static final class ToolsStub
      extends io.grpc.stub.AbstractAsyncStub<ToolsStub> {
    private ToolsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ToolsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ToolsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a [Tool][google.cloud.dialogflow.cx.v3beta1.Tool] in the specified
     * agent.
     * </pre>
     */
    public void createTool(com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Tool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateToolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a list of [Tools][google.cloud.dialogflow.cx.v3beta1.Tool] in the
     * specified agent.
     * </pre>
     */
    public void listTools(com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListToolsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Exports the selected tools.
     * </pre>
     */
    public void exportTools(com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportToolsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified [Tool][google.cloud.dialogflow.cx.v3beta1.Tool].
     * </pre>
     */
    public void getTool(com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Tool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetToolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update the specified [Tool][google.cloud.dialogflow.cx.v3beta1.Tool].
     * </pre>
     */
    public void updateTool(com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Tool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateToolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a specified [Tool][google.cloud.dialogflow.cx.v3beta1.Tool].
     * </pre>
     */
    public void deleteTool(com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteToolMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Tools.
   * <pre>
   * Service for managing [Tools][google.cloud.dialogflow.cx.v3beta1.Tool].
   * </pre>
   */
  public static final class ToolsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ToolsBlockingStub> {
    private ToolsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ToolsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ToolsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a [Tool][google.cloud.dialogflow.cx.v3beta1.Tool] in the specified
     * agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Tool createTool(com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateToolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a list of [Tools][google.cloud.dialogflow.cx.v3beta1.Tool] in the
     * specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse listTools(com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListToolsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Exports the selected tools.
     * </pre>
     */
    public com.google.longrunning.Operation exportTools(com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportToolsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the specified [Tool][google.cloud.dialogflow.cx.v3beta1.Tool].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Tool getTool(com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetToolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update the specified [Tool][google.cloud.dialogflow.cx.v3beta1.Tool].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Tool updateTool(com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateToolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a specified [Tool][google.cloud.dialogflow.cx.v3beta1.Tool].
     * </pre>
     */
    public com.google.protobuf.Empty deleteTool(com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteToolMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Tools.
   * <pre>
   * Service for managing [Tools][google.cloud.dialogflow.cx.v3beta1.Tool].
   * </pre>
   */
  public static final class ToolsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ToolsFutureStub> {
    private ToolsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ToolsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ToolsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a [Tool][google.cloud.dialogflow.cx.v3beta1.Tool] in the specified
     * agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.Tool> createTool(
        com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateToolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a list of [Tools][google.cloud.dialogflow.cx.v3beta1.Tool] in the
     * specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse> listTools(
        com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListToolsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Exports the selected tools.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> exportTools(
        com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportToolsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves the specified [Tool][google.cloud.dialogflow.cx.v3beta1.Tool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.Tool> getTool(
        com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetToolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update the specified [Tool][google.cloud.dialogflow.cx.v3beta1.Tool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3beta1.Tool> updateTool(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateToolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a specified [Tool][google.cloud.dialogflow.cx.v3beta1.Tool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTool(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteToolMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TOOL = 0;
  private static final int METHODID_LIST_TOOLS = 1;
  private static final int METHODID_EXPORT_TOOLS = 2;
  private static final int METHODID_GET_TOOL = 3;
  private static final int METHODID_UPDATE_TOOL = 4;
  private static final int METHODID_DELETE_TOOL = 5;

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
        case METHODID_CREATE_TOOL:
          serviceImpl.createTool((com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Tool>) responseObserver);
          break;
        case METHODID_LIST_TOOLS:
          serviceImpl.listTools((com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse>) responseObserver);
          break;
        case METHODID_EXPORT_TOOLS:
          serviceImpl.exportTools((com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_TOOL:
          serviceImpl.getTool((com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Tool>) responseObserver);
          break;
        case METHODID_UPDATE_TOOL:
          serviceImpl.updateTool((com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Tool>) responseObserver);
          break;
        case METHODID_DELETE_TOOL:
          serviceImpl.deleteTool((com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateToolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest,
              com.google.cloud.dialogflow.cx.v3beta1.Tool>(
                service, METHODID_CREATE_TOOL)))
        .addMethod(
          getListToolsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest,
              com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse>(
                service, METHODID_LIST_TOOLS)))
        .addMethod(
          getExportToolsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest,
              com.google.longrunning.Operation>(
                service, METHODID_EXPORT_TOOLS)))
        .addMethod(
          getGetToolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest,
              com.google.cloud.dialogflow.cx.v3beta1.Tool>(
                service, METHODID_GET_TOOL)))
        .addMethod(
          getUpdateToolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest,
              com.google.cloud.dialogflow.cx.v3beta1.Tool>(
                service, METHODID_UPDATE_TOOL)))
        .addMethod(
          getDeleteToolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_TOOL)))
        .build();
  }

  private static abstract class ToolsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ToolsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3beta1.ToolProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Tools");
    }
  }

  private static final class ToolsFileDescriptorSupplier
      extends ToolsBaseDescriptorSupplier {
    ToolsFileDescriptorSupplier() {}
  }

  private static final class ToolsMethodDescriptorSupplier
      extends ToolsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ToolsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ToolsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ToolsFileDescriptorSupplier())
              .addMethod(getCreateToolMethod())
              .addMethod(getListToolsMethod())
              .addMethod(getExportToolsMethod())
              .addMethod(getGetToolMethod())
              .addMethod(getUpdateToolMethod())
              .addMethod(getDeleteToolMethod())
              .build();
        }
      }
    }
    return result;
  }
}
