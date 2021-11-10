/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.workflows.executions.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Executions is used to start and manage running instances of
 * [Workflows][google.cloud.workflows.v1beta.Workflow] called executions.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/workflows/executions/v1beta/executions.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExecutionsGrpc {

  private ExecutionsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.workflows.executions.v1beta.Executions";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest,
          com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse>
      getListExecutionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExecutions",
      requestType = com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest.class,
      responseType = com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest,
          com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse>
      getListExecutionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest,
            com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse>
        getListExecutionsMethod;
    if ((getListExecutionsMethod = ExecutionsGrpc.getListExecutionsMethod) == null) {
      synchronized (ExecutionsGrpc.class) {
        if ((getListExecutionsMethod = ExecutionsGrpc.getListExecutionsMethod) == null) {
          ExecutionsGrpc.getListExecutionsMethod =
              getListExecutionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest,
                          com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExecutions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ExecutionsMethodDescriptorSupplier("ListExecutions"))
                      .build();
        }
      }
    }
    return getListExecutionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest,
          com.google.cloud.workflows.executions.v1beta.Execution>
      getCreateExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExecution",
      requestType = com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest.class,
      responseType = com.google.cloud.workflows.executions.v1beta.Execution.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest,
          com.google.cloud.workflows.executions.v1beta.Execution>
      getCreateExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest,
            com.google.cloud.workflows.executions.v1beta.Execution>
        getCreateExecutionMethod;
    if ((getCreateExecutionMethod = ExecutionsGrpc.getCreateExecutionMethod) == null) {
      synchronized (ExecutionsGrpc.class) {
        if ((getCreateExecutionMethod = ExecutionsGrpc.getCreateExecutionMethod) == null) {
          ExecutionsGrpc.getCreateExecutionMethod =
              getCreateExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest,
                          com.google.cloud.workflows.executions.v1beta.Execution>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.executions.v1beta.Execution
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExecutionsMethodDescriptorSupplier("CreateExecution"))
                      .build();
        }
      }
    }
    return getCreateExecutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workflows.executions.v1beta.GetExecutionRequest,
          com.google.cloud.workflows.executions.v1beta.Execution>
      getGetExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExecution",
      requestType = com.google.cloud.workflows.executions.v1beta.GetExecutionRequest.class,
      responseType = com.google.cloud.workflows.executions.v1beta.Execution.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workflows.executions.v1beta.GetExecutionRequest,
          com.google.cloud.workflows.executions.v1beta.Execution>
      getGetExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workflows.executions.v1beta.GetExecutionRequest,
            com.google.cloud.workflows.executions.v1beta.Execution>
        getGetExecutionMethod;
    if ((getGetExecutionMethod = ExecutionsGrpc.getGetExecutionMethod) == null) {
      synchronized (ExecutionsGrpc.class) {
        if ((getGetExecutionMethod = ExecutionsGrpc.getGetExecutionMethod) == null) {
          ExecutionsGrpc.getGetExecutionMethod =
              getGetExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workflows.executions.v1beta.GetExecutionRequest,
                          com.google.cloud.workflows.executions.v1beta.Execution>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.executions.v1beta.GetExecutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.executions.v1beta.Execution
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ExecutionsMethodDescriptorSupplier("GetExecution"))
                      .build();
        }
      }
    }
    return getGetExecutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest,
          com.google.cloud.workflows.executions.v1beta.Execution>
      getCancelExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelExecution",
      requestType = com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest.class,
      responseType = com.google.cloud.workflows.executions.v1beta.Execution.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest,
          com.google.cloud.workflows.executions.v1beta.Execution>
      getCancelExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest,
            com.google.cloud.workflows.executions.v1beta.Execution>
        getCancelExecutionMethod;
    if ((getCancelExecutionMethod = ExecutionsGrpc.getCancelExecutionMethod) == null) {
      synchronized (ExecutionsGrpc.class) {
        if ((getCancelExecutionMethod = ExecutionsGrpc.getCancelExecutionMethod) == null) {
          ExecutionsGrpc.getCancelExecutionMethod =
              getCancelExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest,
                          com.google.cloud.workflows.executions.v1beta.Execution>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.executions.v1beta.Execution
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExecutionsMethodDescriptorSupplier("CancelExecution"))
                      .build();
        }
      }
    }
    return getCancelExecutionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ExecutionsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExecutionsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExecutionsStub>() {
          @java.lang.Override
          public ExecutionsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExecutionsStub(channel, callOptions);
          }
        };
    return ExecutionsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExecutionsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExecutionsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExecutionsBlockingStub>() {
          @java.lang.Override
          public ExecutionsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExecutionsBlockingStub(channel, callOptions);
          }
        };
    return ExecutionsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ExecutionsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExecutionsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExecutionsFutureStub>() {
          @java.lang.Override
          public ExecutionsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExecutionsFutureStub(channel, callOptions);
          }
        };
    return ExecutionsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Executions is used to start and manage running instances of
   * [Workflows][google.cloud.workflows.v1beta.Workflow] called executions.
   * </pre>
   */
  public abstract static class ExecutionsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns a list of executions which belong to the workflow with
     * the given name. The method returns executions of all workflow
     * revisions. Returned executions are ordered by their start time (newest
     * first).
     * </pre>
     */
    public void listExecutions(
        com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExecutionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new execution using the latest revision of the given workflow.
     * </pre>
     */
    public void createExecution(
        com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workflows.executions.v1beta.Execution>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExecutionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns an execution of the given name.
     * </pre>
     */
    public void getExecution(
        com.google.cloud.workflows.executions.v1beta.GetExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workflows.executions.v1beta.Execution>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExecutionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels an execution of the given name.
     * </pre>
     */
    public void cancelExecution(
        com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workflows.executions.v1beta.Execution>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelExecutionMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListExecutionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest,
                      com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse>(
                      this, METHODID_LIST_EXECUTIONS)))
          .addMethod(
              getCreateExecutionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest,
                      com.google.cloud.workflows.executions.v1beta.Execution>(
                      this, METHODID_CREATE_EXECUTION)))
          .addMethod(
              getGetExecutionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.workflows.executions.v1beta.GetExecutionRequest,
                      com.google.cloud.workflows.executions.v1beta.Execution>(
                      this, METHODID_GET_EXECUTION)))
          .addMethod(
              getCancelExecutionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest,
                      com.google.cloud.workflows.executions.v1beta.Execution>(
                      this, METHODID_CANCEL_EXECUTION)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Executions is used to start and manage running instances of
   * [Workflows][google.cloud.workflows.v1beta.Workflow] called executions.
   * </pre>
   */
  public static final class ExecutionsStub extends io.grpc.stub.AbstractAsyncStub<ExecutionsStub> {
    private ExecutionsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExecutionsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExecutionsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of executions which belong to the workflow with
     * the given name. The method returns executions of all workflow
     * revisions. Returned executions are ordered by their start time (newest
     * first).
     * </pre>
     */
    public void listExecutions(
        com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExecutionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new execution using the latest revision of the given workflow.
     * </pre>
     */
    public void createExecution(
        com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workflows.executions.v1beta.Execution>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns an execution of the given name.
     * </pre>
     */
    public void getExecution(
        com.google.cloud.workflows.executions.v1beta.GetExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workflows.executions.v1beta.Execution>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels an execution of the given name.
     * </pre>
     */
    public void cancelExecution(
        com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workflows.executions.v1beta.Execution>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Executions is used to start and manage running instances of
   * [Workflows][google.cloud.workflows.v1beta.Workflow] called executions.
   * </pre>
   */
  public static final class ExecutionsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ExecutionsBlockingStub> {
    private ExecutionsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExecutionsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExecutionsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of executions which belong to the workflow with
     * the given name. The method returns executions of all workflow
     * revisions. Returned executions are ordered by their start time (newest
     * first).
     * </pre>
     */
    public com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse listExecutions(
        com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExecutionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new execution using the latest revision of the given workflow.
     * </pre>
     */
    public com.google.cloud.workflows.executions.v1beta.Execution createExecution(
        com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns an execution of the given name.
     * </pre>
     */
    public com.google.cloud.workflows.executions.v1beta.Execution getExecution(
        com.google.cloud.workflows.executions.v1beta.GetExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels an execution of the given name.
     * </pre>
     */
    public com.google.cloud.workflows.executions.v1beta.Execution cancelExecution(
        com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelExecutionMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Executions is used to start and manage running instances of
   * [Workflows][google.cloud.workflows.v1beta.Workflow] called executions.
   * </pre>
   */
  public static final class ExecutionsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ExecutionsFutureStub> {
    private ExecutionsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExecutionsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExecutionsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of executions which belong to the workflow with
     * the given name. The method returns executions of all workflow
     * revisions. Returned executions are ordered by their start time (newest
     * first).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse>
        listExecutions(com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExecutionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new execution using the latest revision of the given workflow.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workflows.executions.v1beta.Execution>
        createExecution(
            com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExecutionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns an execution of the given name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workflows.executions.v1beta.Execution>
        getExecution(com.google.cloud.workflows.executions.v1beta.GetExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExecutionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels an execution of the given name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workflows.executions.v1beta.Execution>
        cancelExecution(
            com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelExecutionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_EXECUTIONS = 0;
  private static final int METHODID_CREATE_EXECUTION = 1;
  private static final int METHODID_GET_EXECUTION = 2;
  private static final int METHODID_CANCEL_EXECUTION = 3;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExecutionsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExecutionsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_EXECUTIONS:
          serviceImpl.listExecutions(
              (com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_EXECUTION:
          serviceImpl.createExecution(
              (com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.workflows.executions.v1beta.Execution>)
                  responseObserver);
          break;
        case METHODID_GET_EXECUTION:
          serviceImpl.getExecution(
              (com.google.cloud.workflows.executions.v1beta.GetExecutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.workflows.executions.v1beta.Execution>)
                  responseObserver);
          break;
        case METHODID_CANCEL_EXECUTION:
          serviceImpl.cancelExecution(
              (com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.workflows.executions.v1beta.Execution>)
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

  private abstract static class ExecutionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExecutionsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.workflows.executions.v1beta.ExecutionsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Executions");
    }
  }

  private static final class ExecutionsFileDescriptorSupplier
      extends ExecutionsBaseDescriptorSupplier {
    ExecutionsFileDescriptorSupplier() {}
  }

  private static final class ExecutionsMethodDescriptorSupplier
      extends ExecutionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExecutionsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ExecutionsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ExecutionsFileDescriptorSupplier())
                      .addMethod(getListExecutionsMethod())
                      .addMethod(getCreateExecutionMethod())
                      .addMethod(getGetExecutionMethod())
                      .addMethod(getCancelExecutionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
