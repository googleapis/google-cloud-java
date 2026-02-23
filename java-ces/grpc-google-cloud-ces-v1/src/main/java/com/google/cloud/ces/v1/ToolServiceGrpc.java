/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.ces.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Tool service provides APIs for interacting with CES tools.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ToolServiceGrpc {

  private ToolServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.ces.v1.ToolService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ExecuteToolRequest, com.google.cloud.ces.v1.ExecuteToolResponse>
      getExecuteToolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteTool",
      requestType = com.google.cloud.ces.v1.ExecuteToolRequest.class,
      responseType = com.google.cloud.ces.v1.ExecuteToolResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.ExecuteToolRequest, com.google.cloud.ces.v1.ExecuteToolResponse>
      getExecuteToolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.ExecuteToolRequest, com.google.cloud.ces.v1.ExecuteToolResponse>
        getExecuteToolMethod;
    if ((getExecuteToolMethod = ToolServiceGrpc.getExecuteToolMethod) == null) {
      synchronized (ToolServiceGrpc.class) {
        if ((getExecuteToolMethod = ToolServiceGrpc.getExecuteToolMethod) == null) {
          ToolServiceGrpc.getExecuteToolMethod =
              getExecuteToolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.ExecuteToolRequest,
                          com.google.cloud.ces.v1.ExecuteToolResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteTool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ExecuteToolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.ExecuteToolResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ToolServiceMethodDescriptorSupplier("ExecuteTool"))
                      .build();
        }
      }
    }
    return getExecuteToolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.RetrieveToolSchemaRequest,
          com.google.cloud.ces.v1.RetrieveToolSchemaResponse>
      getRetrieveToolSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveToolSchema",
      requestType = com.google.cloud.ces.v1.RetrieveToolSchemaRequest.class,
      responseType = com.google.cloud.ces.v1.RetrieveToolSchemaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.RetrieveToolSchemaRequest,
          com.google.cloud.ces.v1.RetrieveToolSchemaResponse>
      getRetrieveToolSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.RetrieveToolSchemaRequest,
            com.google.cloud.ces.v1.RetrieveToolSchemaResponse>
        getRetrieveToolSchemaMethod;
    if ((getRetrieveToolSchemaMethod = ToolServiceGrpc.getRetrieveToolSchemaMethod) == null) {
      synchronized (ToolServiceGrpc.class) {
        if ((getRetrieveToolSchemaMethod = ToolServiceGrpc.getRetrieveToolSchemaMethod) == null) {
          ToolServiceGrpc.getRetrieveToolSchemaMethod =
              getRetrieveToolSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.RetrieveToolSchemaRequest,
                          com.google.cloud.ces.v1.RetrieveToolSchemaResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RetrieveToolSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.RetrieveToolSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.RetrieveToolSchemaResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ToolServiceMethodDescriptorSupplier("RetrieveToolSchema"))
                      .build();
        }
      }
    }
    return getRetrieveToolSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.RetrieveToolsRequest,
          com.google.cloud.ces.v1.RetrieveToolsResponse>
      getRetrieveToolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveTools",
      requestType = com.google.cloud.ces.v1.RetrieveToolsRequest.class,
      responseType = com.google.cloud.ces.v1.RetrieveToolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.RetrieveToolsRequest,
          com.google.cloud.ces.v1.RetrieveToolsResponse>
      getRetrieveToolsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.RetrieveToolsRequest,
            com.google.cloud.ces.v1.RetrieveToolsResponse>
        getRetrieveToolsMethod;
    if ((getRetrieveToolsMethod = ToolServiceGrpc.getRetrieveToolsMethod) == null) {
      synchronized (ToolServiceGrpc.class) {
        if ((getRetrieveToolsMethod = ToolServiceGrpc.getRetrieveToolsMethod) == null) {
          ToolServiceGrpc.getRetrieveToolsMethod =
              getRetrieveToolsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.RetrieveToolsRequest,
                          com.google.cloud.ces.v1.RetrieveToolsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RetrieveTools"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.RetrieveToolsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.RetrieveToolsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ToolServiceMethodDescriptorSupplier("RetrieveTools"))
                      .build();
        }
      }
    }
    return getRetrieveToolsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ToolServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ToolServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ToolServiceStub>() {
          @java.lang.Override
          public ToolServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ToolServiceStub(channel, callOptions);
          }
        };
    return ToolServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ToolServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ToolServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ToolServiceBlockingV2Stub>() {
          @java.lang.Override
          public ToolServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ToolServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return ToolServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ToolServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ToolServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ToolServiceBlockingStub>() {
          @java.lang.Override
          public ToolServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ToolServiceBlockingStub(channel, callOptions);
          }
        };
    return ToolServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ToolServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ToolServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ToolServiceFutureStub>() {
          @java.lang.Override
          public ToolServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ToolServiceFutureStub(channel, callOptions);
          }
        };
    return ToolServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Tool service provides APIs for interacting with CES tools.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Executes the given tool with the given arguments.
     * </pre>
     */
    default void executeTool(
        com.google.cloud.ces.v1.ExecuteToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ExecuteToolResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExecuteToolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the schema of the given tool. The schema is computed on the fly
     * for the given instance of the tool.
     * </pre>
     */
    default void retrieveToolSchema(
        com.google.cloud.ces.v1.RetrieveToolSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.RetrieveToolSchemaResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveToolSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the list of tools included in the specified toolset.
     * </pre>
     */
    default void retrieveTools(
        com.google.cloud.ces.v1.RetrieveToolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.RetrieveToolsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveToolsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ToolService.
   *
   * <pre>
   * Tool service provides APIs for interacting with CES tools.
   * </pre>
   */
  public abstract static class ToolServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ToolServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ToolService.
   *
   * <pre>
   * Tool service provides APIs for interacting with CES tools.
   * </pre>
   */
  public static final class ToolServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ToolServiceStub> {
    private ToolServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ToolServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ToolServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Executes the given tool with the given arguments.
     * </pre>
     */
    public void executeTool(
        com.google.cloud.ces.v1.ExecuteToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ExecuteToolResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteToolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the schema of the given tool. The schema is computed on the fly
     * for the given instance of the tool.
     * </pre>
     */
    public void retrieveToolSchema(
        com.google.cloud.ces.v1.RetrieveToolSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.RetrieveToolSchemaResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveToolSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the list of tools included in the specified toolset.
     * </pre>
     */
    public void retrieveTools(
        com.google.cloud.ces.v1.RetrieveToolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.RetrieveToolsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveToolsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ToolService.
   *
   * <pre>
   * Tool service provides APIs for interacting with CES tools.
   * </pre>
   */
  public static final class ToolServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ToolServiceBlockingV2Stub> {
    private ToolServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ToolServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ToolServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Executes the given tool with the given arguments.
     * </pre>
     */
    public com.google.cloud.ces.v1.ExecuteToolResponse executeTool(
        com.google.cloud.ces.v1.ExecuteToolRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExecuteToolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the schema of the given tool. The schema is computed on the fly
     * for the given instance of the tool.
     * </pre>
     */
    public com.google.cloud.ces.v1.RetrieveToolSchemaResponse retrieveToolSchema(
        com.google.cloud.ces.v1.RetrieveToolSchemaRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRetrieveToolSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the list of tools included in the specified toolset.
     * </pre>
     */
    public com.google.cloud.ces.v1.RetrieveToolsResponse retrieveTools(
        com.google.cloud.ces.v1.RetrieveToolsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRetrieveToolsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ToolService.
   *
   * <pre>
   * Tool service provides APIs for interacting with CES tools.
   * </pre>
   */
  public static final class ToolServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ToolServiceBlockingStub> {
    private ToolServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ToolServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ToolServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Executes the given tool with the given arguments.
     * </pre>
     */
    public com.google.cloud.ces.v1.ExecuteToolResponse executeTool(
        com.google.cloud.ces.v1.ExecuteToolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteToolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the schema of the given tool. The schema is computed on the fly
     * for the given instance of the tool.
     * </pre>
     */
    public com.google.cloud.ces.v1.RetrieveToolSchemaResponse retrieveToolSchema(
        com.google.cloud.ces.v1.RetrieveToolSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveToolSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the list of tools included in the specified toolset.
     * </pre>
     */
    public com.google.cloud.ces.v1.RetrieveToolsResponse retrieveTools(
        com.google.cloud.ces.v1.RetrieveToolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveToolsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ToolService.
   *
   * <pre>
   * Tool service provides APIs for interacting with CES tools.
   * </pre>
   */
  public static final class ToolServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ToolServiceFutureStub> {
    private ToolServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ToolServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ToolServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Executes the given tool with the given arguments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.ExecuteToolResponse>
        executeTool(com.google.cloud.ces.v1.ExecuteToolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteToolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the schema of the given tool. The schema is computed on the fly
     * for the given instance of the tool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.RetrieveToolSchemaResponse>
        retrieveToolSchema(com.google.cloud.ces.v1.RetrieveToolSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveToolSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the list of tools included in the specified toolset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.RetrieveToolsResponse>
        retrieveTools(com.google.cloud.ces.v1.RetrieveToolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveToolsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXECUTE_TOOL = 0;
  private static final int METHODID_RETRIEVE_TOOL_SCHEMA = 1;
  private static final int METHODID_RETRIEVE_TOOLS = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_EXECUTE_TOOL:
          serviceImpl.executeTool(
              (com.google.cloud.ces.v1.ExecuteToolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.ExecuteToolResponse>)
                  responseObserver);
          break;
        case METHODID_RETRIEVE_TOOL_SCHEMA:
          serviceImpl.retrieveToolSchema(
              (com.google.cloud.ces.v1.RetrieveToolSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.RetrieveToolSchemaResponse>)
                  responseObserver);
          break;
        case METHODID_RETRIEVE_TOOLS:
          serviceImpl.retrieveTools(
              (com.google.cloud.ces.v1.RetrieveToolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.RetrieveToolsResponse>)
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getExecuteToolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.ExecuteToolRequest,
                    com.google.cloud.ces.v1.ExecuteToolResponse>(service, METHODID_EXECUTE_TOOL)))
        .addMethod(
            getRetrieveToolSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.RetrieveToolSchemaRequest,
                    com.google.cloud.ces.v1.RetrieveToolSchemaResponse>(
                    service, METHODID_RETRIEVE_TOOL_SCHEMA)))
        .addMethod(
            getRetrieveToolsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.RetrieveToolsRequest,
                    com.google.cloud.ces.v1.RetrieveToolsResponse>(
                    service, METHODID_RETRIEVE_TOOLS)))
        .build();
  }

  private abstract static class ToolServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ToolServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.ces.v1.ToolServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ToolService");
    }
  }

  private static final class ToolServiceFileDescriptorSupplier
      extends ToolServiceBaseDescriptorSupplier {
    ToolServiceFileDescriptorSupplier() {}
  }

  private static final class ToolServiceMethodDescriptorSupplier
      extends ToolServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ToolServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ToolServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ToolServiceFileDescriptorSupplier())
                      .addMethod(getExecuteToolMethod())
                      .addMethod(getRetrieveToolSchemaMethod())
                      .addMethod(getRetrieveToolsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
