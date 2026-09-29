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
package com.google.cloud.dialogflow.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing companion agents.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class CompanionAgentsGrpc {

  private CompanionAgentsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dialogflow.v2.CompanionAgents";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest,
          com.google.cloud.dialogflow.v2.CompanionAgent>
      getCreateCompanionAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCompanionAgent",
      requestType = com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest.class,
      responseType = com.google.cloud.dialogflow.v2.CompanionAgent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest,
          com.google.cloud.dialogflow.v2.CompanionAgent>
      getCreateCompanionAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest,
            com.google.cloud.dialogflow.v2.CompanionAgent>
        getCreateCompanionAgentMethod;
    if ((getCreateCompanionAgentMethod = CompanionAgentsGrpc.getCreateCompanionAgentMethod)
        == null) {
      synchronized (CompanionAgentsGrpc.class) {
        if ((getCreateCompanionAgentMethod = CompanionAgentsGrpc.getCreateCompanionAgentMethod)
            == null) {
          CompanionAgentsGrpc.getCreateCompanionAgentMethod =
              getCreateCompanionAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest,
                          com.google.cloud.dialogflow.v2.CompanionAgent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCompanionAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.CompanionAgent.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompanionAgentsMethodDescriptorSupplier("CreateCompanionAgent"))
                      .build();
        }
      }
    }
    return getCreateCompanionAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetCompanionAgentRequest,
          com.google.cloud.dialogflow.v2.CompanionAgent>
      getGetCompanionAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCompanionAgent",
      requestType = com.google.cloud.dialogflow.v2.GetCompanionAgentRequest.class,
      responseType = com.google.cloud.dialogflow.v2.CompanionAgent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetCompanionAgentRequest,
          com.google.cloud.dialogflow.v2.CompanionAgent>
      getGetCompanionAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.GetCompanionAgentRequest,
            com.google.cloud.dialogflow.v2.CompanionAgent>
        getGetCompanionAgentMethod;
    if ((getGetCompanionAgentMethod = CompanionAgentsGrpc.getGetCompanionAgentMethod) == null) {
      synchronized (CompanionAgentsGrpc.class) {
        if ((getGetCompanionAgentMethod = CompanionAgentsGrpc.getGetCompanionAgentMethod) == null) {
          CompanionAgentsGrpc.getGetCompanionAgentMethod =
              getGetCompanionAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.GetCompanionAgentRequest,
                          com.google.cloud.dialogflow.v2.CompanionAgent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCompanionAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GetCompanionAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.CompanionAgent.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompanionAgentsMethodDescriptorSupplier("GetCompanionAgent"))
                      .build();
        }
      }
    }
    return getGetCompanionAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest,
          com.google.cloud.dialogflow.v2.CompanionAgent>
      getUpdateCompanionAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCompanionAgent",
      requestType = com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest.class,
      responseType = com.google.cloud.dialogflow.v2.CompanionAgent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest,
          com.google.cloud.dialogflow.v2.CompanionAgent>
      getUpdateCompanionAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest,
            com.google.cloud.dialogflow.v2.CompanionAgent>
        getUpdateCompanionAgentMethod;
    if ((getUpdateCompanionAgentMethod = CompanionAgentsGrpc.getUpdateCompanionAgentMethod)
        == null) {
      synchronized (CompanionAgentsGrpc.class) {
        if ((getUpdateCompanionAgentMethod = CompanionAgentsGrpc.getUpdateCompanionAgentMethod)
            == null) {
          CompanionAgentsGrpc.getUpdateCompanionAgentMethod =
              getUpdateCompanionAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest,
                          com.google.cloud.dialogflow.v2.CompanionAgent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCompanionAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.CompanionAgent.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompanionAgentsMethodDescriptorSupplier("UpdateCompanionAgent"))
                      .build();
        }
      }
    }
    return getUpdateCompanionAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest, com.google.protobuf.Empty>
      getDeleteCompanionAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCompanionAgent",
      requestType = com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest, com.google.protobuf.Empty>
      getDeleteCompanionAgentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest, com.google.protobuf.Empty>
        getDeleteCompanionAgentMethod;
    if ((getDeleteCompanionAgentMethod = CompanionAgentsGrpc.getDeleteCompanionAgentMethod)
        == null) {
      synchronized (CompanionAgentsGrpc.class) {
        if ((getDeleteCompanionAgentMethod = CompanionAgentsGrpc.getDeleteCompanionAgentMethod)
            == null) {
          CompanionAgentsGrpc.getDeleteCompanionAgentMethod =
              getDeleteCompanionAgentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCompanionAgent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompanionAgentsMethodDescriptorSupplier("DeleteCompanionAgent"))
                      .build();
        }
      }
    }
    return getDeleteCompanionAgentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest,
          com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse>
      getListCompanionAgentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCompanionAgents",
      requestType = com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest,
          com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse>
      getListCompanionAgentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest,
            com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse>
        getListCompanionAgentsMethod;
    if ((getListCompanionAgentsMethod = CompanionAgentsGrpc.getListCompanionAgentsMethod) == null) {
      synchronized (CompanionAgentsGrpc.class) {
        if ((getListCompanionAgentsMethod = CompanionAgentsGrpc.getListCompanionAgentsMethod)
            == null) {
          CompanionAgentsGrpc.getListCompanionAgentsMethod =
              getListCompanionAgentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest,
                          com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCompanionAgents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompanionAgentsMethodDescriptorSupplier("ListCompanionAgents"))
                      .build();
        }
      }
    }
    return getListCompanionAgentsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CompanionAgentsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompanionAgentsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompanionAgentsStub>() {
          @java.lang.Override
          public CompanionAgentsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompanionAgentsStub(channel, callOptions);
          }
        };
    return CompanionAgentsStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static CompanionAgentsBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompanionAgentsBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompanionAgentsBlockingV2Stub>() {
          @java.lang.Override
          public CompanionAgentsBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompanionAgentsBlockingV2Stub(channel, callOptions);
          }
        };
    return CompanionAgentsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CompanionAgentsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompanionAgentsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompanionAgentsBlockingStub>() {
          @java.lang.Override
          public CompanionAgentsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompanionAgentsBlockingStub(channel, callOptions);
          }
        };
    return CompanionAgentsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CompanionAgentsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompanionAgentsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompanionAgentsFutureStub>() {
          @java.lang.Override
          public CompanionAgentsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompanionAgentsFutureStub(channel, callOptions);
          }
        };
    return CompanionAgentsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing companion agents.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a companion agent.
     * </pre>
     */
    default void createCompanionAgent(
        com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.CompanionAgent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCompanionAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a companion agent.
     * </pre>
     */
    default void getCompanionAgent(
        com.google.cloud.dialogflow.v2.GetCompanionAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.CompanionAgent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCompanionAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a companion agent.
     * </pre>
     */
    default void updateCompanionAgent(
        com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.CompanionAgent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCompanionAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a companion agent.
     * </pre>
     */
    default void deleteCompanionAgent(
        com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCompanionAgentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists companion agents.
     * </pre>
     */
    default void listCompanionAgents(
        com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCompanionAgentsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CompanionAgents.
   *
   * <pre>
   * Service for managing companion agents.
   * </pre>
   */
  public abstract static class CompanionAgentsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CompanionAgentsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CompanionAgents.
   *
   * <pre>
   * Service for managing companion agents.
   * </pre>
   */
  public static final class CompanionAgentsStub
      extends io.grpc.stub.AbstractAsyncStub<CompanionAgentsStub> {
    private CompanionAgentsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompanionAgentsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompanionAgentsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a companion agent.
     * </pre>
     */
    public void createCompanionAgent(
        com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.CompanionAgent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCompanionAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a companion agent.
     * </pre>
     */
    public void getCompanionAgent(
        com.google.cloud.dialogflow.v2.GetCompanionAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.CompanionAgent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCompanionAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a companion agent.
     * </pre>
     */
    public void updateCompanionAgent(
        com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.CompanionAgent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCompanionAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a companion agent.
     * </pre>
     */
    public void deleteCompanionAgent(
        com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCompanionAgentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists companion agents.
     * </pre>
     */
    public void listCompanionAgents(
        com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCompanionAgentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CompanionAgents.
   *
   * <pre>
   * Service for managing companion agents.
   * </pre>
   */
  public static final class CompanionAgentsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CompanionAgentsBlockingV2Stub> {
    private CompanionAgentsBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompanionAgentsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompanionAgentsBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a companion agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.CompanionAgent createCompanionAgent(
        com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateCompanionAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a companion agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.CompanionAgent getCompanionAgent(
        com.google.cloud.dialogflow.v2.GetCompanionAgentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCompanionAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a companion agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.CompanionAgent updateCompanionAgent(
        com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateCompanionAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a companion agent.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCompanionAgent(
        com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteCompanionAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists companion agents.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse listCompanionAgents(
        com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListCompanionAgentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CompanionAgents.
   *
   * <pre>
   * Service for managing companion agents.
   * </pre>
   */
  public static final class CompanionAgentsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CompanionAgentsBlockingStub> {
    private CompanionAgentsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompanionAgentsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompanionAgentsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a companion agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.CompanionAgent createCompanionAgent(
        com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCompanionAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a companion agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.CompanionAgent getCompanionAgent(
        com.google.cloud.dialogflow.v2.GetCompanionAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCompanionAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a companion agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.CompanionAgent updateCompanionAgent(
        com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCompanionAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a companion agent.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCompanionAgent(
        com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCompanionAgentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists companion agents.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse listCompanionAgents(
        com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCompanionAgentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CompanionAgents.
   *
   * <pre>
   * Service for managing companion agents.
   * </pre>
   */
  public static final class CompanionAgentsFutureStub
      extends io.grpc.stub.AbstractFutureStub<CompanionAgentsFutureStub> {
    private CompanionAgentsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompanionAgentsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompanionAgentsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a companion agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.CompanionAgent>
        createCompanionAgent(com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCompanionAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a companion agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.CompanionAgent>
        getCompanionAgent(com.google.cloud.dialogflow.v2.GetCompanionAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCompanionAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a companion agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.CompanionAgent>
        updateCompanionAgent(com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCompanionAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a companion agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCompanionAgent(com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCompanionAgentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists companion agents.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse>
        listCompanionAgents(com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCompanionAgentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_COMPANION_AGENT = 0;
  private static final int METHODID_GET_COMPANION_AGENT = 1;
  private static final int METHODID_UPDATE_COMPANION_AGENT = 2;
  private static final int METHODID_DELETE_COMPANION_AGENT = 3;
  private static final int METHODID_LIST_COMPANION_AGENTS = 4;

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
        case METHODID_CREATE_COMPANION_AGENT:
          serviceImpl.createCompanionAgent(
              (com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.CompanionAgent>)
                  responseObserver);
          break;
        case METHODID_GET_COMPANION_AGENT:
          serviceImpl.getCompanionAgent(
              (com.google.cloud.dialogflow.v2.GetCompanionAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.CompanionAgent>)
                  responseObserver);
          break;
        case METHODID_UPDATE_COMPANION_AGENT:
          serviceImpl.updateCompanionAgent(
              (com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.CompanionAgent>)
                  responseObserver);
          break;
        case METHODID_DELETE_COMPANION_AGENT:
          serviceImpl.deleteCompanionAgent(
              (com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_COMPANION_AGENTS:
          serviceImpl.listCompanionAgents(
              (com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse>)
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
            getCreateCompanionAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest,
                    com.google.cloud.dialogflow.v2.CompanionAgent>(
                    service, METHODID_CREATE_COMPANION_AGENT)))
        .addMethod(
            getGetCompanionAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.GetCompanionAgentRequest,
                    com.google.cloud.dialogflow.v2.CompanionAgent>(
                    service, METHODID_GET_COMPANION_AGENT)))
        .addMethod(
            getUpdateCompanionAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest,
                    com.google.cloud.dialogflow.v2.CompanionAgent>(
                    service, METHODID_UPDATE_COMPANION_AGENT)))
        .addMethod(
            getDeleteCompanionAgentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_COMPANION_AGENT)))
        .addMethod(
            getListCompanionAgentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest,
                    com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse>(
                    service, METHODID_LIST_COMPANION_AGENTS)))
        .build();
  }

  private abstract static class CompanionAgentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CompanionAgentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.CompanionAgentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CompanionAgents");
    }
  }

  private static final class CompanionAgentsFileDescriptorSupplier
      extends CompanionAgentsBaseDescriptorSupplier {
    CompanionAgentsFileDescriptorSupplier() {}
  }

  private static final class CompanionAgentsMethodDescriptorSupplier
      extends CompanionAgentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CompanionAgentsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CompanionAgentsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CompanionAgentsFileDescriptorSupplier())
                      .addMethod(getCreateCompanionAgentMethod())
                      .addMethod(getGetCompanionAgentMethod())
                      .addMethod(getUpdateCompanionAgentMethod())
                      .addMethod(getDeleteCompanionAgentMethod())
                      .addMethod(getListCompanionAgentsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
