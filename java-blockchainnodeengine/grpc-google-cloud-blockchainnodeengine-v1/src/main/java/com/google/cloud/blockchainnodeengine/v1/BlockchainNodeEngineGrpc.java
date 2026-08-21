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
package com.google.cloud.blockchainnodeengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This service is the control plane API for Blockchain Node Engine,
 * and can be used to create, read, and delete blockchain nodes.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class BlockchainNodeEngineGrpc {

  private BlockchainNodeEngineGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.blockchainnodeengine.v1.BlockchainNodeEngine";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest,
          com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse>
      getListBlockchainNodesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBlockchainNodes",
      requestType = com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest.class,
      responseType = com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest,
          com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse>
      getListBlockchainNodesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest,
            com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse>
        getListBlockchainNodesMethod;
    if ((getListBlockchainNodesMethod = BlockchainNodeEngineGrpc.getListBlockchainNodesMethod)
        == null) {
      synchronized (BlockchainNodeEngineGrpc.class) {
        if ((getListBlockchainNodesMethod = BlockchainNodeEngineGrpc.getListBlockchainNodesMethod)
            == null) {
          BlockchainNodeEngineGrpc.getListBlockchainNodesMethod =
              getListBlockchainNodesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest,
                          com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBlockchainNodes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BlockchainNodeEngineMethodDescriptorSupplier("ListBlockchainNodes"))
                      .build();
        }
      }
    }
    return getListBlockchainNodesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest,
          com.google.cloud.blockchainnodeengine.v1.BlockchainNode>
      getGetBlockchainNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBlockchainNode",
      requestType = com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest.class,
      responseType = com.google.cloud.blockchainnodeengine.v1.BlockchainNode.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest,
          com.google.cloud.blockchainnodeengine.v1.BlockchainNode>
      getGetBlockchainNodeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest,
            com.google.cloud.blockchainnodeengine.v1.BlockchainNode>
        getGetBlockchainNodeMethod;
    if ((getGetBlockchainNodeMethod = BlockchainNodeEngineGrpc.getGetBlockchainNodeMethod)
        == null) {
      synchronized (BlockchainNodeEngineGrpc.class) {
        if ((getGetBlockchainNodeMethod = BlockchainNodeEngineGrpc.getGetBlockchainNodeMethod)
            == null) {
          BlockchainNodeEngineGrpc.getGetBlockchainNodeMethod =
              getGetBlockchainNodeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest,
                          com.google.cloud.blockchainnodeengine.v1.BlockchainNode>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBlockchainNode"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.blockchainnodeengine.v1.BlockchainNode
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BlockchainNodeEngineMethodDescriptorSupplier("GetBlockchainNode"))
                      .build();
        }
      }
    }
    return getGetBlockchainNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest,
          com.google.longrunning.Operation>
      getCreateBlockchainNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBlockchainNode",
      requestType = com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest,
          com.google.longrunning.Operation>
      getCreateBlockchainNodeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest,
            com.google.longrunning.Operation>
        getCreateBlockchainNodeMethod;
    if ((getCreateBlockchainNodeMethod = BlockchainNodeEngineGrpc.getCreateBlockchainNodeMethod)
        == null) {
      synchronized (BlockchainNodeEngineGrpc.class) {
        if ((getCreateBlockchainNodeMethod = BlockchainNodeEngineGrpc.getCreateBlockchainNodeMethod)
            == null) {
          BlockchainNodeEngineGrpc.getCreateBlockchainNodeMethod =
              getCreateBlockchainNodeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateBlockchainNode"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BlockchainNodeEngineMethodDescriptorSupplier("CreateBlockchainNode"))
                      .build();
        }
      }
    }
    return getCreateBlockchainNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest,
          com.google.longrunning.Operation>
      getUpdateBlockchainNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBlockchainNode",
      requestType = com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest,
          com.google.longrunning.Operation>
      getUpdateBlockchainNodeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest,
            com.google.longrunning.Operation>
        getUpdateBlockchainNodeMethod;
    if ((getUpdateBlockchainNodeMethod = BlockchainNodeEngineGrpc.getUpdateBlockchainNodeMethod)
        == null) {
      synchronized (BlockchainNodeEngineGrpc.class) {
        if ((getUpdateBlockchainNodeMethod = BlockchainNodeEngineGrpc.getUpdateBlockchainNodeMethod)
            == null) {
          BlockchainNodeEngineGrpc.getUpdateBlockchainNodeMethod =
              getUpdateBlockchainNodeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateBlockchainNode"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BlockchainNodeEngineMethodDescriptorSupplier("UpdateBlockchainNode"))
                      .build();
        }
      }
    }
    return getUpdateBlockchainNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest,
          com.google.longrunning.Operation>
      getDeleteBlockchainNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBlockchainNode",
      requestType = com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest,
          com.google.longrunning.Operation>
      getDeleteBlockchainNodeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest,
            com.google.longrunning.Operation>
        getDeleteBlockchainNodeMethod;
    if ((getDeleteBlockchainNodeMethod = BlockchainNodeEngineGrpc.getDeleteBlockchainNodeMethod)
        == null) {
      synchronized (BlockchainNodeEngineGrpc.class) {
        if ((getDeleteBlockchainNodeMethod = BlockchainNodeEngineGrpc.getDeleteBlockchainNodeMethod)
            == null) {
          BlockchainNodeEngineGrpc.getDeleteBlockchainNodeMethod =
              getDeleteBlockchainNodeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteBlockchainNode"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BlockchainNodeEngineMethodDescriptorSupplier("DeleteBlockchainNode"))
                      .build();
        }
      }
    }
    return getDeleteBlockchainNodeMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BlockchainNodeEngineStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlockchainNodeEngineStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BlockchainNodeEngineStub>() {
          @java.lang.Override
          public BlockchainNodeEngineStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BlockchainNodeEngineStub(channel, callOptions);
          }
        };
    return BlockchainNodeEngineStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static BlockchainNodeEngineBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlockchainNodeEngineBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BlockchainNodeEngineBlockingV2Stub>() {
          @java.lang.Override
          public BlockchainNodeEngineBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BlockchainNodeEngineBlockingV2Stub(channel, callOptions);
          }
        };
    return BlockchainNodeEngineBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BlockchainNodeEngineBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlockchainNodeEngineBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BlockchainNodeEngineBlockingStub>() {
          @java.lang.Override
          public BlockchainNodeEngineBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BlockchainNodeEngineBlockingStub(channel, callOptions);
          }
        };
    return BlockchainNodeEngineBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BlockchainNodeEngineFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlockchainNodeEngineFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BlockchainNodeEngineFutureStub>() {
          @java.lang.Override
          public BlockchainNodeEngineFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BlockchainNodeEngineFutureStub(channel, callOptions);
          }
        };
    return BlockchainNodeEngineFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service is the control plane API for Blockchain Node Engine,
   * and can be used to create, read, and delete blockchain nodes.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists blockchain nodes in a given project and location.
     * </pre>
     */
    default void listBlockchainNodes(
        com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBlockchainNodesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single blockchain node.
     * </pre>
     */
    default void getBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.blockchainnodeengine.v1.BlockchainNode>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBlockchainNodeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new blockchain node in a given project and location.
     * </pre>
     */
    default void createBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBlockchainNodeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single blockchain node.
     * </pre>
     */
    default void updateBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBlockchainNodeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single blockchain node.
     * </pre>
     */
    default void deleteBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBlockchainNodeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BlockchainNodeEngine.
   *
   * <pre>
   * This service is the control plane API for Blockchain Node Engine,
   * and can be used to create, read, and delete blockchain nodes.
   * </pre>
   */
  public abstract static class BlockchainNodeEngineImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BlockchainNodeEngineGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BlockchainNodeEngine.
   *
   * <pre>
   * This service is the control plane API for Blockchain Node Engine,
   * and can be used to create, read, and delete blockchain nodes.
   * </pre>
   */
  public static final class BlockchainNodeEngineStub
      extends io.grpc.stub.AbstractAsyncStub<BlockchainNodeEngineStub> {
    private BlockchainNodeEngineStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlockchainNodeEngineStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlockchainNodeEngineStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists blockchain nodes in a given project and location.
     * </pre>
     */
    public void listBlockchainNodes(
        com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBlockchainNodesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single blockchain node.
     * </pre>
     */
    public void getBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.blockchainnodeengine.v1.BlockchainNode>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBlockchainNodeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new blockchain node in a given project and location.
     * </pre>
     */
    public void createBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBlockchainNodeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single blockchain node.
     * </pre>
     */
    public void updateBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBlockchainNodeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single blockchain node.
     * </pre>
     */
    public void deleteBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBlockchainNodeMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BlockchainNodeEngine.
   *
   * <pre>
   * This service is the control plane API for Blockchain Node Engine,
   * and can be used to create, read, and delete blockchain nodes.
   * </pre>
   */
  public static final class BlockchainNodeEngineBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<BlockchainNodeEngineBlockingV2Stub> {
    private BlockchainNodeEngineBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlockchainNodeEngineBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlockchainNodeEngineBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists blockchain nodes in a given project and location.
     * </pre>
     */
    public com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse listBlockchainNodes(
        com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBlockchainNodesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single blockchain node.
     * </pre>
     */
    public com.google.cloud.blockchainnodeengine.v1.BlockchainNode getBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBlockchainNodeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new blockchain node in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateBlockchainNodeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single blockchain node.
     * </pre>
     */
    public com.google.longrunning.Operation updateBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateBlockchainNodeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single blockchain node.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteBlockchainNodeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service BlockchainNodeEngine.
   *
   * <pre>
   * This service is the control plane API for Blockchain Node Engine,
   * and can be used to create, read, and delete blockchain nodes.
   * </pre>
   */
  public static final class BlockchainNodeEngineBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BlockchainNodeEngineBlockingStub> {
    private BlockchainNodeEngineBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlockchainNodeEngineBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlockchainNodeEngineBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists blockchain nodes in a given project and location.
     * </pre>
     */
    public com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse listBlockchainNodes(
        com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBlockchainNodesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single blockchain node.
     * </pre>
     */
    public com.google.cloud.blockchainnodeengine.v1.BlockchainNode getBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBlockchainNodeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new blockchain node in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBlockchainNodeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single blockchain node.
     * </pre>
     */
    public com.google.longrunning.Operation updateBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBlockchainNodeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single blockchain node.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBlockchainNode(
        com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBlockchainNodeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BlockchainNodeEngine.
   *
   * <pre>
   * This service is the control plane API for Blockchain Node Engine,
   * and can be used to create, read, and delete blockchain nodes.
   * </pre>
   */
  public static final class BlockchainNodeEngineFutureStub
      extends io.grpc.stub.AbstractFutureStub<BlockchainNodeEngineFutureStub> {
    private BlockchainNodeEngineFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlockchainNodeEngineFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlockchainNodeEngineFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists blockchain nodes in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse>
        listBlockchainNodes(
            com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBlockchainNodesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single blockchain node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.blockchainnodeengine.v1.BlockchainNode>
        getBlockchainNode(
            com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBlockchainNodeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new blockchain node in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBlockchainNode(
            com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBlockchainNodeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single blockchain node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBlockchainNode(
            com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBlockchainNodeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single blockchain node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBlockchainNode(
            com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBlockchainNodeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_BLOCKCHAIN_NODES = 0;
  private static final int METHODID_GET_BLOCKCHAIN_NODE = 1;
  private static final int METHODID_CREATE_BLOCKCHAIN_NODE = 2;
  private static final int METHODID_UPDATE_BLOCKCHAIN_NODE = 3;
  private static final int METHODID_DELETE_BLOCKCHAIN_NODE = 4;

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
        case METHODID_LIST_BLOCKCHAIN_NODES:
          serviceImpl.listBlockchainNodes(
              (com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BLOCKCHAIN_NODE:
          serviceImpl.getBlockchainNode(
              (com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.blockchainnodeengine.v1.BlockchainNode>)
                  responseObserver);
          break;
        case METHODID_CREATE_BLOCKCHAIN_NODE:
          serviceImpl.createBlockchainNode(
              (com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_BLOCKCHAIN_NODE:
          serviceImpl.updateBlockchainNode(
              (com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BLOCKCHAIN_NODE:
          serviceImpl.deleteBlockchainNode(
              (com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest) request,
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
            getListBlockchainNodesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest,
                    com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse>(
                    service, METHODID_LIST_BLOCKCHAIN_NODES)))
        .addMethod(
            getGetBlockchainNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest,
                    com.google.cloud.blockchainnodeengine.v1.BlockchainNode>(
                    service, METHODID_GET_BLOCKCHAIN_NODE)))
        .addMethod(
            getCreateBlockchainNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BLOCKCHAIN_NODE)))
        .addMethod(
            getUpdateBlockchainNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BLOCKCHAIN_NODE)))
        .addMethod(
            getDeleteBlockchainNodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BLOCKCHAIN_NODE)))
        .build();
  }

  private abstract static class BlockchainNodeEngineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BlockchainNodeEngineBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.blockchainnodeengine.v1.BlockchainnodeengineProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BlockchainNodeEngine");
    }
  }

  private static final class BlockchainNodeEngineFileDescriptorSupplier
      extends BlockchainNodeEngineBaseDescriptorSupplier {
    BlockchainNodeEngineFileDescriptorSupplier() {}
  }

  private static final class BlockchainNodeEngineMethodDescriptorSupplier
      extends BlockchainNodeEngineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BlockchainNodeEngineMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BlockchainNodeEngineGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BlockchainNodeEngineFileDescriptorSupplier())
                      .addMethod(getListBlockchainNodesMethod())
                      .addMethod(getGetBlockchainNodeMethod())
                      .addMethod(getCreateBlockchainNodeMethod())
                      .addMethod(getUpdateBlockchainNodeMethod())
                      .addMethod(getDeleteBlockchainNodeMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
