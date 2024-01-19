/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.policysimulator.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Policy Simulator API service.
 * Policy Simulator is a collection of endpoints for creating, running, and
 * viewing a [Replay][google.cloud.policysimulator.v1.Replay]. A
 * [Replay][google.cloud.policysimulator.v1.Replay] is a type of simulation that
 * lets you see how your principals' access to resources might change if you
 * changed your IAM policy.
 * During a [Replay][google.cloud.policysimulator.v1.Replay], Policy Simulator
 * re-evaluates, or replays, past access attempts under both the current policy
 * and  your proposed policy, and compares those results to determine how your
 * principals' access might change under the proposed policy.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/policysimulator/v1/simulator.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SimulatorGrpc {

  private SimulatorGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.policysimulator.v1.Simulator";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.GetReplayRequest,
          com.google.cloud.policysimulator.v1.Replay>
      getGetReplayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReplay",
      requestType = com.google.cloud.policysimulator.v1.GetReplayRequest.class,
      responseType = com.google.cloud.policysimulator.v1.Replay.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.GetReplayRequest,
          com.google.cloud.policysimulator.v1.Replay>
      getGetReplayMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.policysimulator.v1.GetReplayRequest,
            com.google.cloud.policysimulator.v1.Replay>
        getGetReplayMethod;
    if ((getGetReplayMethod = SimulatorGrpc.getGetReplayMethod) == null) {
      synchronized (SimulatorGrpc.class) {
        if ((getGetReplayMethod = SimulatorGrpc.getGetReplayMethod) == null) {
          SimulatorGrpc.getGetReplayMethod =
              getGetReplayMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.policysimulator.v1.GetReplayRequest,
                          com.google.cloud.policysimulator.v1.Replay>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReplay"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.policysimulator.v1.GetReplayRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.policysimulator.v1.Replay.getDefaultInstance()))
                      .setSchemaDescriptor(new SimulatorMethodDescriptorSupplier("GetReplay"))
                      .build();
        }
      }
    }
    return getGetReplayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.CreateReplayRequest, com.google.longrunning.Operation>
      getCreateReplayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReplay",
      requestType = com.google.cloud.policysimulator.v1.CreateReplayRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.CreateReplayRequest, com.google.longrunning.Operation>
      getCreateReplayMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.policysimulator.v1.CreateReplayRequest,
            com.google.longrunning.Operation>
        getCreateReplayMethod;
    if ((getCreateReplayMethod = SimulatorGrpc.getCreateReplayMethod) == null) {
      synchronized (SimulatorGrpc.class) {
        if ((getCreateReplayMethod = SimulatorGrpc.getCreateReplayMethod) == null) {
          SimulatorGrpc.getCreateReplayMethod =
              getCreateReplayMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.policysimulator.v1.CreateReplayRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReplay"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.policysimulator.v1.CreateReplayRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SimulatorMethodDescriptorSupplier("CreateReplay"))
                      .build();
        }
      }
    }
    return getCreateReplayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.ListReplayResultsRequest,
          com.google.cloud.policysimulator.v1.ListReplayResultsResponse>
      getListReplayResultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReplayResults",
      requestType = com.google.cloud.policysimulator.v1.ListReplayResultsRequest.class,
      responseType = com.google.cloud.policysimulator.v1.ListReplayResultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.ListReplayResultsRequest,
          com.google.cloud.policysimulator.v1.ListReplayResultsResponse>
      getListReplayResultsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.policysimulator.v1.ListReplayResultsRequest,
            com.google.cloud.policysimulator.v1.ListReplayResultsResponse>
        getListReplayResultsMethod;
    if ((getListReplayResultsMethod = SimulatorGrpc.getListReplayResultsMethod) == null) {
      synchronized (SimulatorGrpc.class) {
        if ((getListReplayResultsMethod = SimulatorGrpc.getListReplayResultsMethod) == null) {
          SimulatorGrpc.getListReplayResultsMethod =
              getListReplayResultsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.policysimulator.v1.ListReplayResultsRequest,
                          com.google.cloud.policysimulator.v1.ListReplayResultsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReplayResults"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.policysimulator.v1.ListReplayResultsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.policysimulator.v1.ListReplayResultsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SimulatorMethodDescriptorSupplier("ListReplayResults"))
                      .build();
        }
      }
    }
    return getListReplayResultsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SimulatorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SimulatorStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SimulatorStub>() {
          @java.lang.Override
          public SimulatorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SimulatorStub(channel, callOptions);
          }
        };
    return SimulatorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SimulatorBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SimulatorBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SimulatorBlockingStub>() {
          @java.lang.Override
          public SimulatorBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SimulatorBlockingStub(channel, callOptions);
          }
        };
    return SimulatorBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SimulatorFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SimulatorFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SimulatorFutureStub>() {
          @java.lang.Override
          public SimulatorFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SimulatorFutureStub(channel, callOptions);
          }
        };
    return SimulatorFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Policy Simulator API service.
   * Policy Simulator is a collection of endpoints for creating, running, and
   * viewing a [Replay][google.cloud.policysimulator.v1.Replay]. A
   * [Replay][google.cloud.policysimulator.v1.Replay] is a type of simulation that
   * lets you see how your principals' access to resources might change if you
   * changed your IAM policy.
   * During a [Replay][google.cloud.policysimulator.v1.Replay], Policy Simulator
   * re-evaluates, or replays, past access attempts under both the current policy
   * and  your proposed policy, and compares those results to determine how your
   * principals' access might change under the proposed policy.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets the specified [Replay][google.cloud.policysimulator.v1.Replay]. Each
     * `Replay` is available for at least 7 days.
     * </pre>
     */
    default void getReplay(
        com.google.cloud.policysimulator.v1.GetReplayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.policysimulator.v1.Replay> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReplayMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates and starts a [Replay][google.cloud.policysimulator.v1.Replay] using
     * the given [ReplayConfig][google.cloud.policysimulator.v1.ReplayConfig].
     * </pre>
     */
    default void createReplay(
        com.google.cloud.policysimulator.v1.CreateReplayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReplayMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the results of running a
     * [Replay][google.cloud.policysimulator.v1.Replay].
     * </pre>
     */
    default void listReplayResults(
        com.google.cloud.policysimulator.v1.ListReplayResultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.policysimulator.v1.ListReplayResultsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReplayResultsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Simulator.
   *
   * <pre>
   * Policy Simulator API service.
   * Policy Simulator is a collection of endpoints for creating, running, and
   * viewing a [Replay][google.cloud.policysimulator.v1.Replay]. A
   * [Replay][google.cloud.policysimulator.v1.Replay] is a type of simulation that
   * lets you see how your principals' access to resources might change if you
   * changed your IAM policy.
   * During a [Replay][google.cloud.policysimulator.v1.Replay], Policy Simulator
   * re-evaluates, or replays, past access attempts under both the current policy
   * and  your proposed policy, and compares those results to determine how your
   * principals' access might change under the proposed policy.
   * </pre>
   */
  public abstract static class SimulatorImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SimulatorGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Simulator.
   *
   * <pre>
   * Policy Simulator API service.
   * Policy Simulator is a collection of endpoints for creating, running, and
   * viewing a [Replay][google.cloud.policysimulator.v1.Replay]. A
   * [Replay][google.cloud.policysimulator.v1.Replay] is a type of simulation that
   * lets you see how your principals' access to resources might change if you
   * changed your IAM policy.
   * During a [Replay][google.cloud.policysimulator.v1.Replay], Policy Simulator
   * re-evaluates, or replays, past access attempts under both the current policy
   * and  your proposed policy, and compares those results to determine how your
   * principals' access might change under the proposed policy.
   * </pre>
   */
  public static final class SimulatorStub extends io.grpc.stub.AbstractAsyncStub<SimulatorStub> {
    private SimulatorStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimulatorStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SimulatorStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified [Replay][google.cloud.policysimulator.v1.Replay]. Each
     * `Replay` is available for at least 7 days.
     * </pre>
     */
    public void getReplay(
        com.google.cloud.policysimulator.v1.GetReplayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.policysimulator.v1.Replay> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReplayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates and starts a [Replay][google.cloud.policysimulator.v1.Replay] using
     * the given [ReplayConfig][google.cloud.policysimulator.v1.ReplayConfig].
     * </pre>
     */
    public void createReplay(
        com.google.cloud.policysimulator.v1.CreateReplayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReplayMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the results of running a
     * [Replay][google.cloud.policysimulator.v1.Replay].
     * </pre>
     */
    public void listReplayResults(
        com.google.cloud.policysimulator.v1.ListReplayResultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.policysimulator.v1.ListReplayResultsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReplayResultsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Simulator.
   *
   * <pre>
   * Policy Simulator API service.
   * Policy Simulator is a collection of endpoints for creating, running, and
   * viewing a [Replay][google.cloud.policysimulator.v1.Replay]. A
   * [Replay][google.cloud.policysimulator.v1.Replay] is a type of simulation that
   * lets you see how your principals' access to resources might change if you
   * changed your IAM policy.
   * During a [Replay][google.cloud.policysimulator.v1.Replay], Policy Simulator
   * re-evaluates, or replays, past access attempts under both the current policy
   * and  your proposed policy, and compares those results to determine how your
   * principals' access might change under the proposed policy.
   * </pre>
   */
  public static final class SimulatorBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SimulatorBlockingStub> {
    private SimulatorBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimulatorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SimulatorBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified [Replay][google.cloud.policysimulator.v1.Replay]. Each
     * `Replay` is available for at least 7 days.
     * </pre>
     */
    public com.google.cloud.policysimulator.v1.Replay getReplay(
        com.google.cloud.policysimulator.v1.GetReplayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReplayMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates and starts a [Replay][google.cloud.policysimulator.v1.Replay] using
     * the given [ReplayConfig][google.cloud.policysimulator.v1.ReplayConfig].
     * </pre>
     */
    public com.google.longrunning.Operation createReplay(
        com.google.cloud.policysimulator.v1.CreateReplayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReplayMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the results of running a
     * [Replay][google.cloud.policysimulator.v1.Replay].
     * </pre>
     */
    public com.google.cloud.policysimulator.v1.ListReplayResultsResponse listReplayResults(
        com.google.cloud.policysimulator.v1.ListReplayResultsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReplayResultsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Simulator.
   *
   * <pre>
   * Policy Simulator API service.
   * Policy Simulator is a collection of endpoints for creating, running, and
   * viewing a [Replay][google.cloud.policysimulator.v1.Replay]. A
   * [Replay][google.cloud.policysimulator.v1.Replay] is a type of simulation that
   * lets you see how your principals' access to resources might change if you
   * changed your IAM policy.
   * During a [Replay][google.cloud.policysimulator.v1.Replay], Policy Simulator
   * re-evaluates, or replays, past access attempts under both the current policy
   * and  your proposed policy, and compares those results to determine how your
   * principals' access might change under the proposed policy.
   * </pre>
   */
  public static final class SimulatorFutureStub
      extends io.grpc.stub.AbstractFutureStub<SimulatorFutureStub> {
    private SimulatorFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimulatorFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SimulatorFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified [Replay][google.cloud.policysimulator.v1.Replay]. Each
     * `Replay` is available for at least 7 days.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.policysimulator.v1.Replay>
        getReplay(com.google.cloud.policysimulator.v1.GetReplayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReplayMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates and starts a [Replay][google.cloud.policysimulator.v1.Replay] using
     * the given [ReplayConfig][google.cloud.policysimulator.v1.ReplayConfig].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createReplay(com.google.cloud.policysimulator.v1.CreateReplayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReplayMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the results of running a
     * [Replay][google.cloud.policysimulator.v1.Replay].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.policysimulator.v1.ListReplayResultsResponse>
        listReplayResults(com.google.cloud.policysimulator.v1.ListReplayResultsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReplayResultsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REPLAY = 0;
  private static final int METHODID_CREATE_REPLAY = 1;
  private static final int METHODID_LIST_REPLAY_RESULTS = 2;

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
        case METHODID_GET_REPLAY:
          serviceImpl.getReplay(
              (com.google.cloud.policysimulator.v1.GetReplayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.policysimulator.v1.Replay>)
                  responseObserver);
          break;
        case METHODID_CREATE_REPLAY:
          serviceImpl.createReplay(
              (com.google.cloud.policysimulator.v1.CreateReplayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_REPLAY_RESULTS:
          serviceImpl.listReplayResults(
              (com.google.cloud.policysimulator.v1.ListReplayResultsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.policysimulator.v1.ListReplayResultsResponse>)
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
            getGetReplayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.policysimulator.v1.GetReplayRequest,
                    com.google.cloud.policysimulator.v1.Replay>(service, METHODID_GET_REPLAY)))
        .addMethod(
            getCreateReplayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.policysimulator.v1.CreateReplayRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_REPLAY)))
        .addMethod(
            getListReplayResultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.policysimulator.v1.ListReplayResultsRequest,
                    com.google.cloud.policysimulator.v1.ListReplayResultsResponse>(
                    service, METHODID_LIST_REPLAY_RESULTS)))
        .build();
  }

  private abstract static class SimulatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SimulatorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.policysimulator.v1.SimulatorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Simulator");
    }
  }

  private static final class SimulatorFileDescriptorSupplier
      extends SimulatorBaseDescriptorSupplier {
    SimulatorFileDescriptorSupplier() {}
  }

  private static final class SimulatorMethodDescriptorSupplier
      extends SimulatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SimulatorMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SimulatorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SimulatorFileDescriptorSupplier())
                      .addMethod(getGetReplayMethod())
                      .addMethod(getCreateReplayMethod())
                      .addMethod(getListReplayResultsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
