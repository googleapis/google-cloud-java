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
package com.google.cloud.apiregistry.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Cloud API Registry service provides a central registry for managing API
 * Data.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudApiRegistryGrpc {

  private CloudApiRegistryGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.apiregistry.v1.CloudApiRegistry";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apiregistry.v1.GetMcpServerRequest,
          com.google.cloud.apiregistry.v1.McpServer>
      getGetMcpServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMcpServer",
      requestType = com.google.cloud.apiregistry.v1.GetMcpServerRequest.class,
      responseType = com.google.cloud.apiregistry.v1.McpServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apiregistry.v1.GetMcpServerRequest,
          com.google.cloud.apiregistry.v1.McpServer>
      getGetMcpServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apiregistry.v1.GetMcpServerRequest,
            com.google.cloud.apiregistry.v1.McpServer>
        getGetMcpServerMethod;
    if ((getGetMcpServerMethod = CloudApiRegistryGrpc.getGetMcpServerMethod) == null) {
      synchronized (CloudApiRegistryGrpc.class) {
        if ((getGetMcpServerMethod = CloudApiRegistryGrpc.getGetMcpServerMethod) == null) {
          CloudApiRegistryGrpc.getGetMcpServerMethod =
              getGetMcpServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apiregistry.v1.GetMcpServerRequest,
                          com.google.cloud.apiregistry.v1.McpServer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMcpServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apiregistry.v1.GetMcpServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apiregistry.v1.McpServer.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudApiRegistryMethodDescriptorSupplier("GetMcpServer"))
                      .build();
        }
      }
    }
    return getGetMcpServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apiregistry.v1.ListMcpServersRequest,
          com.google.cloud.apiregistry.v1.ListMcpServersResponse>
      getListMcpServersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMcpServers",
      requestType = com.google.cloud.apiregistry.v1.ListMcpServersRequest.class,
      responseType = com.google.cloud.apiregistry.v1.ListMcpServersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apiregistry.v1.ListMcpServersRequest,
          com.google.cloud.apiregistry.v1.ListMcpServersResponse>
      getListMcpServersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apiregistry.v1.ListMcpServersRequest,
            com.google.cloud.apiregistry.v1.ListMcpServersResponse>
        getListMcpServersMethod;
    if ((getListMcpServersMethod = CloudApiRegistryGrpc.getListMcpServersMethod) == null) {
      synchronized (CloudApiRegistryGrpc.class) {
        if ((getListMcpServersMethod = CloudApiRegistryGrpc.getListMcpServersMethod) == null) {
          CloudApiRegistryGrpc.getListMcpServersMethod =
              getListMcpServersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apiregistry.v1.ListMcpServersRequest,
                          com.google.cloud.apiregistry.v1.ListMcpServersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMcpServers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apiregistry.v1.ListMcpServersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apiregistry.v1.ListMcpServersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudApiRegistryMethodDescriptorSupplier("ListMcpServers"))
                      .build();
        }
      }
    }
    return getListMcpServersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apiregistry.v1.GetMcpToolRequest,
          com.google.cloud.apiregistry.v1.McpTool>
      getGetMcpToolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMcpTool",
      requestType = com.google.cloud.apiregistry.v1.GetMcpToolRequest.class,
      responseType = com.google.cloud.apiregistry.v1.McpTool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apiregistry.v1.GetMcpToolRequest,
          com.google.cloud.apiregistry.v1.McpTool>
      getGetMcpToolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apiregistry.v1.GetMcpToolRequest,
            com.google.cloud.apiregistry.v1.McpTool>
        getGetMcpToolMethod;
    if ((getGetMcpToolMethod = CloudApiRegistryGrpc.getGetMcpToolMethod) == null) {
      synchronized (CloudApiRegistryGrpc.class) {
        if ((getGetMcpToolMethod = CloudApiRegistryGrpc.getGetMcpToolMethod) == null) {
          CloudApiRegistryGrpc.getGetMcpToolMethod =
              getGetMcpToolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apiregistry.v1.GetMcpToolRequest,
                          com.google.cloud.apiregistry.v1.McpTool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMcpTool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apiregistry.v1.GetMcpToolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apiregistry.v1.McpTool.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudApiRegistryMethodDescriptorSupplier("GetMcpTool"))
                      .build();
        }
      }
    }
    return getGetMcpToolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apiregistry.v1.ListMcpToolsRequest,
          com.google.cloud.apiregistry.v1.ListMcpToolsResponse>
      getListMcpToolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMcpTools",
      requestType = com.google.cloud.apiregistry.v1.ListMcpToolsRequest.class,
      responseType = com.google.cloud.apiregistry.v1.ListMcpToolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apiregistry.v1.ListMcpToolsRequest,
          com.google.cloud.apiregistry.v1.ListMcpToolsResponse>
      getListMcpToolsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apiregistry.v1.ListMcpToolsRequest,
            com.google.cloud.apiregistry.v1.ListMcpToolsResponse>
        getListMcpToolsMethod;
    if ((getListMcpToolsMethod = CloudApiRegistryGrpc.getListMcpToolsMethod) == null) {
      synchronized (CloudApiRegistryGrpc.class) {
        if ((getListMcpToolsMethod = CloudApiRegistryGrpc.getListMcpToolsMethod) == null) {
          CloudApiRegistryGrpc.getListMcpToolsMethod =
              getListMcpToolsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apiregistry.v1.ListMcpToolsRequest,
                          com.google.cloud.apiregistry.v1.ListMcpToolsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMcpTools"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apiregistry.v1.ListMcpToolsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apiregistry.v1.ListMcpToolsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudApiRegistryMethodDescriptorSupplier("ListMcpTools"))
                      .build();
        }
      }
    }
    return getListMcpToolsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudApiRegistryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudApiRegistryStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudApiRegistryStub>() {
          @java.lang.Override
          public CloudApiRegistryStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudApiRegistryStub(channel, callOptions);
          }
        };
    return CloudApiRegistryStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static CloudApiRegistryBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudApiRegistryBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudApiRegistryBlockingV2Stub>() {
          @java.lang.Override
          public CloudApiRegistryBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudApiRegistryBlockingV2Stub(channel, callOptions);
          }
        };
    return CloudApiRegistryBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudApiRegistryBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudApiRegistryBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudApiRegistryBlockingStub>() {
          @java.lang.Override
          public CloudApiRegistryBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudApiRegistryBlockingStub(channel, callOptions);
          }
        };
    return CloudApiRegistryBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudApiRegistryFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudApiRegistryFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudApiRegistryFutureStub>() {
          @java.lang.Override
          public CloudApiRegistryFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudApiRegistryFutureStub(channel, callOptions);
          }
        };
    return CloudApiRegistryFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Cloud API Registry service provides a central registry for managing API
   * Data.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a single McpServer.
     * </pre>
     */
    default void getMcpServer(
        com.google.cloud.apiregistry.v1.GetMcpServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apiregistry.v1.McpServer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMcpServerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers in a given Project.
     * </pre>
     */
    default void listMcpServers(
        com.google.cloud.apiregistry.v1.ListMcpServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apiregistry.v1.ListMcpServersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMcpServersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a single McpTool.
     * </pre>
     */
    default void getMcpTool(
        com.google.cloud.apiregistry.v1.GetMcpToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apiregistry.v1.McpTool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMcpToolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists McpTools in a given McpServer.
     * </pre>
     */
    default void listMcpTools(
        com.google.cloud.apiregistry.v1.ListMcpToolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apiregistry.v1.ListMcpToolsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMcpToolsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CloudApiRegistry.
   *
   * <pre>
   * The Cloud API Registry service provides a central registry for managing API
   * Data.
   * </pre>
   */
  public abstract static class CloudApiRegistryImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CloudApiRegistryGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CloudApiRegistry.
   *
   * <pre>
   * The Cloud API Registry service provides a central registry for managing API
   * Data.
   * </pre>
   */
  public static final class CloudApiRegistryStub
      extends io.grpc.stub.AbstractAsyncStub<CloudApiRegistryStub> {
    private CloudApiRegistryStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudApiRegistryStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudApiRegistryStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single McpServer.
     * </pre>
     */
    public void getMcpServer(
        com.google.cloud.apiregistry.v1.GetMcpServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apiregistry.v1.McpServer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMcpServerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers in a given Project.
     * </pre>
     */
    public void listMcpServers(
        com.google.cloud.apiregistry.v1.ListMcpServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apiregistry.v1.ListMcpServersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMcpServersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a single McpTool.
     * </pre>
     */
    public void getMcpTool(
        com.google.cloud.apiregistry.v1.GetMcpToolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apiregistry.v1.McpTool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMcpToolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists McpTools in a given McpServer.
     * </pre>
     */
    public void listMcpTools(
        com.google.cloud.apiregistry.v1.ListMcpToolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apiregistry.v1.ListMcpToolsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMcpToolsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CloudApiRegistry.
   *
   * <pre>
   * The Cloud API Registry service provides a central registry for managing API
   * Data.
   * </pre>
   */
  public static final class CloudApiRegistryBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CloudApiRegistryBlockingV2Stub> {
    private CloudApiRegistryBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudApiRegistryBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudApiRegistryBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single McpServer.
     * </pre>
     */
    public com.google.cloud.apiregistry.v1.McpServer getMcpServer(
        com.google.cloud.apiregistry.v1.GetMcpServerRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMcpServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers in a given Project.
     * </pre>
     */
    public com.google.cloud.apiregistry.v1.ListMcpServersResponse listMcpServers(
        com.google.cloud.apiregistry.v1.ListMcpServersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMcpServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single McpTool.
     * </pre>
     */
    public com.google.cloud.apiregistry.v1.McpTool getMcpTool(
        com.google.cloud.apiregistry.v1.GetMcpToolRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMcpToolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists McpTools in a given McpServer.
     * </pre>
     */
    public com.google.cloud.apiregistry.v1.ListMcpToolsResponse listMcpTools(
        com.google.cloud.apiregistry.v1.ListMcpToolsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMcpToolsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CloudApiRegistry.
   *
   * <pre>
   * The Cloud API Registry service provides a central registry for managing API
   * Data.
   * </pre>
   */
  public static final class CloudApiRegistryBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudApiRegistryBlockingStub> {
    private CloudApiRegistryBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudApiRegistryBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudApiRegistryBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single McpServer.
     * </pre>
     */
    public com.google.cloud.apiregistry.v1.McpServer getMcpServer(
        com.google.cloud.apiregistry.v1.GetMcpServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMcpServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers in a given Project.
     * </pre>
     */
    public com.google.cloud.apiregistry.v1.ListMcpServersResponse listMcpServers(
        com.google.cloud.apiregistry.v1.ListMcpServersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMcpServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single McpTool.
     * </pre>
     */
    public com.google.cloud.apiregistry.v1.McpTool getMcpTool(
        com.google.cloud.apiregistry.v1.GetMcpToolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMcpToolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists McpTools in a given McpServer.
     * </pre>
     */
    public com.google.cloud.apiregistry.v1.ListMcpToolsResponse listMcpTools(
        com.google.cloud.apiregistry.v1.ListMcpToolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMcpToolsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CloudApiRegistry.
   *
   * <pre>
   * The Cloud API Registry service provides a central registry for managing API
   * Data.
   * </pre>
   */
  public static final class CloudApiRegistryFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudApiRegistryFutureStub> {
    private CloudApiRegistryFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudApiRegistryFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudApiRegistryFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single McpServer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apiregistry.v1.McpServer>
        getMcpServer(com.google.cloud.apiregistry.v1.GetMcpServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMcpServerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists McpServers in a given Project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apiregistry.v1.ListMcpServersResponse>
        listMcpServers(com.google.cloud.apiregistry.v1.ListMcpServersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMcpServersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single McpTool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apiregistry.v1.McpTool>
        getMcpTool(com.google.cloud.apiregistry.v1.GetMcpToolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMcpToolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists McpTools in a given McpServer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apiregistry.v1.ListMcpToolsResponse>
        listMcpTools(com.google.cloud.apiregistry.v1.ListMcpToolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMcpToolsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MCP_SERVER = 0;
  private static final int METHODID_LIST_MCP_SERVERS = 1;
  private static final int METHODID_GET_MCP_TOOL = 2;
  private static final int METHODID_LIST_MCP_TOOLS = 3;

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
        case METHODID_GET_MCP_SERVER:
          serviceImpl.getMcpServer(
              (com.google.cloud.apiregistry.v1.GetMcpServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apiregistry.v1.McpServer>)
                  responseObserver);
          break;
        case METHODID_LIST_MCP_SERVERS:
          serviceImpl.listMcpServers(
              (com.google.cloud.apiregistry.v1.ListMcpServersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apiregistry.v1.ListMcpServersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MCP_TOOL:
          serviceImpl.getMcpTool(
              (com.google.cloud.apiregistry.v1.GetMcpToolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apiregistry.v1.McpTool>)
                  responseObserver);
          break;
        case METHODID_LIST_MCP_TOOLS:
          serviceImpl.listMcpTools(
              (com.google.cloud.apiregistry.v1.ListMcpToolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apiregistry.v1.ListMcpToolsResponse>)
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
            getGetMcpServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apiregistry.v1.GetMcpServerRequest,
                    com.google.cloud.apiregistry.v1.McpServer>(service, METHODID_GET_MCP_SERVER)))
        .addMethod(
            getListMcpServersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apiregistry.v1.ListMcpServersRequest,
                    com.google.cloud.apiregistry.v1.ListMcpServersResponse>(
                    service, METHODID_LIST_MCP_SERVERS)))
        .addMethod(
            getGetMcpToolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apiregistry.v1.GetMcpToolRequest,
                    com.google.cloud.apiregistry.v1.McpTool>(service, METHODID_GET_MCP_TOOL)))
        .addMethod(
            getListMcpToolsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apiregistry.v1.ListMcpToolsRequest,
                    com.google.cloud.apiregistry.v1.ListMcpToolsResponse>(
                    service, METHODID_LIST_MCP_TOOLS)))
        .build();
  }

  private abstract static class CloudApiRegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudApiRegistryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apiregistry.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudApiRegistry");
    }
  }

  private static final class CloudApiRegistryFileDescriptorSupplier
      extends CloudApiRegistryBaseDescriptorSupplier {
    CloudApiRegistryFileDescriptorSupplier() {}
  }

  private static final class CloudApiRegistryMethodDescriptorSupplier
      extends CloudApiRegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CloudApiRegistryMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CloudApiRegistryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CloudApiRegistryFileDescriptorSupplier())
                      .addMethod(getGetMcpServerMethod())
                      .addMethod(getListMcpServersMethod())
                      .addMethod(getGetMcpToolMethod())
                      .addMethod(getListMcpToolsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
