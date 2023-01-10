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
package com.google.monitoring.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The SnoozeService API is used to temporarily prevent an alert policy from
 * generating alerts. A Snooze is a description of the criteria under which one
 * or more alert policies should not fire alerts for the specified duration.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/monitoring/v3/snooze_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SnoozeServiceGrpc {

  private SnoozeServiceGrpc() {}

  public static final String SERVICE_NAME = "google.monitoring.v3.SnoozeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateSnoozeRequest, com.google.monitoring.v3.Snooze>
      getCreateSnoozeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSnooze",
      requestType = com.google.monitoring.v3.CreateSnoozeRequest.class,
      responseType = com.google.monitoring.v3.Snooze.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateSnoozeRequest, com.google.monitoring.v3.Snooze>
      getCreateSnoozeMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.CreateSnoozeRequest, com.google.monitoring.v3.Snooze>
        getCreateSnoozeMethod;
    if ((getCreateSnoozeMethod = SnoozeServiceGrpc.getCreateSnoozeMethod) == null) {
      synchronized (SnoozeServiceGrpc.class) {
        if ((getCreateSnoozeMethod = SnoozeServiceGrpc.getCreateSnoozeMethod) == null) {
          SnoozeServiceGrpc.getCreateSnoozeMethod =
              getCreateSnoozeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.CreateSnoozeRequest,
                          com.google.monitoring.v3.Snooze>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSnooze"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.CreateSnoozeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.Snooze.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SnoozeServiceMethodDescriptorSupplier("CreateSnooze"))
                      .build();
        }
      }
    }
    return getCreateSnoozeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListSnoozesRequest, com.google.monitoring.v3.ListSnoozesResponse>
      getListSnoozesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSnoozes",
      requestType = com.google.monitoring.v3.ListSnoozesRequest.class,
      responseType = com.google.monitoring.v3.ListSnoozesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListSnoozesRequest, com.google.monitoring.v3.ListSnoozesResponse>
      getListSnoozesMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.ListSnoozesRequest,
            com.google.monitoring.v3.ListSnoozesResponse>
        getListSnoozesMethod;
    if ((getListSnoozesMethod = SnoozeServiceGrpc.getListSnoozesMethod) == null) {
      synchronized (SnoozeServiceGrpc.class) {
        if ((getListSnoozesMethod = SnoozeServiceGrpc.getListSnoozesMethod) == null) {
          SnoozeServiceGrpc.getListSnoozesMethod =
              getListSnoozesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.ListSnoozesRequest,
                          com.google.monitoring.v3.ListSnoozesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSnoozes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ListSnoozesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ListSnoozesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SnoozeServiceMethodDescriptorSupplier("ListSnoozes"))
                      .build();
        }
      }
    }
    return getListSnoozesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetSnoozeRequest, com.google.monitoring.v3.Snooze>
      getGetSnoozeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSnooze",
      requestType = com.google.monitoring.v3.GetSnoozeRequest.class,
      responseType = com.google.monitoring.v3.Snooze.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetSnoozeRequest, com.google.monitoring.v3.Snooze>
      getGetSnoozeMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.GetSnoozeRequest, com.google.monitoring.v3.Snooze>
        getGetSnoozeMethod;
    if ((getGetSnoozeMethod = SnoozeServiceGrpc.getGetSnoozeMethod) == null) {
      synchronized (SnoozeServiceGrpc.class) {
        if ((getGetSnoozeMethod = SnoozeServiceGrpc.getGetSnoozeMethod) == null) {
          SnoozeServiceGrpc.getGetSnoozeMethod =
              getGetSnoozeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.GetSnoozeRequest, com.google.monitoring.v3.Snooze>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSnooze"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.GetSnoozeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.Snooze.getDefaultInstance()))
                      .setSchemaDescriptor(new SnoozeServiceMethodDescriptorSupplier("GetSnooze"))
                      .build();
        }
      }
    }
    return getGetSnoozeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateSnoozeRequest, com.google.monitoring.v3.Snooze>
      getUpdateSnoozeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSnooze",
      requestType = com.google.monitoring.v3.UpdateSnoozeRequest.class,
      responseType = com.google.monitoring.v3.Snooze.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateSnoozeRequest, com.google.monitoring.v3.Snooze>
      getUpdateSnoozeMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.UpdateSnoozeRequest, com.google.monitoring.v3.Snooze>
        getUpdateSnoozeMethod;
    if ((getUpdateSnoozeMethod = SnoozeServiceGrpc.getUpdateSnoozeMethod) == null) {
      synchronized (SnoozeServiceGrpc.class) {
        if ((getUpdateSnoozeMethod = SnoozeServiceGrpc.getUpdateSnoozeMethod) == null) {
          SnoozeServiceGrpc.getUpdateSnoozeMethod =
              getUpdateSnoozeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.UpdateSnoozeRequest,
                          com.google.monitoring.v3.Snooze>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSnooze"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.UpdateSnoozeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.Snooze.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SnoozeServiceMethodDescriptorSupplier("UpdateSnooze"))
                      .build();
        }
      }
    }
    return getUpdateSnoozeMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SnoozeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SnoozeServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SnoozeServiceStub>() {
          @java.lang.Override
          public SnoozeServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SnoozeServiceStub(channel, callOptions);
          }
        };
    return SnoozeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SnoozeServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SnoozeServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SnoozeServiceBlockingStub>() {
          @java.lang.Override
          public SnoozeServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SnoozeServiceBlockingStub(channel, callOptions);
          }
        };
    return SnoozeServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SnoozeServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SnoozeServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SnoozeServiceFutureStub>() {
          @java.lang.Override
          public SnoozeServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SnoozeServiceFutureStub(channel, callOptions);
          }
        };
    return SnoozeServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The SnoozeService API is used to temporarily prevent an alert policy from
   * generating alerts. A Snooze is a description of the criteria under which one
   * or more alert policies should not fire alerts for the specified duration.
   * </pre>
   */
  public abstract static class SnoozeServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a `Snooze` that will prevent alerts, which match the provided
     * criteria, from being opened. The `Snooze` applies for a specific time
     * interval.
     * </pre>
     */
    public void createSnooze(
        com.google.monitoring.v3.CreateSnoozeRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.Snooze> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSnoozeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the `Snooze`s associated with a project. Can optionally pass in
     * `filter`, which specifies predicates to match `Snooze`s.
     * </pre>
     */
    public void listSnoozes(
        com.google.monitoring.v3.ListSnoozesRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListSnoozesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSnoozesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `Snooze` by `name`.
     * </pre>
     */
    public void getSnooze(
        com.google.monitoring.v3.GetSnoozeRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.Snooze> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSnoozeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a `Snooze`, identified by its `name`, with the parameters in the
     * given `Snooze` object.
     * </pre>
     */
    public void updateSnooze(
        com.google.monitoring.v3.UpdateSnoozeRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.Snooze> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSnoozeMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateSnoozeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.CreateSnoozeRequest,
                      com.google.monitoring.v3.Snooze>(this, METHODID_CREATE_SNOOZE)))
          .addMethod(
              getListSnoozesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.ListSnoozesRequest,
                      com.google.monitoring.v3.ListSnoozesResponse>(this, METHODID_LIST_SNOOZES)))
          .addMethod(
              getGetSnoozeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.GetSnoozeRequest, com.google.monitoring.v3.Snooze>(
                      this, METHODID_GET_SNOOZE)))
          .addMethod(
              getUpdateSnoozeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.UpdateSnoozeRequest,
                      com.google.monitoring.v3.Snooze>(this, METHODID_UPDATE_SNOOZE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The SnoozeService API is used to temporarily prevent an alert policy from
   * generating alerts. A Snooze is a description of the criteria under which one
   * or more alert policies should not fire alerts for the specified duration.
   * </pre>
   */
  public static final class SnoozeServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SnoozeServiceStub> {
    private SnoozeServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SnoozeServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SnoozeServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a `Snooze` that will prevent alerts, which match the provided
     * criteria, from being opened. The `Snooze` applies for a specific time
     * interval.
     * </pre>
     */
    public void createSnooze(
        com.google.monitoring.v3.CreateSnoozeRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.Snooze> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSnoozeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the `Snooze`s associated with a project. Can optionally pass in
     * `filter`, which specifies predicates to match `Snooze`s.
     * </pre>
     */
    public void listSnoozes(
        com.google.monitoring.v3.ListSnoozesRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListSnoozesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSnoozesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `Snooze` by `name`.
     * </pre>
     */
    public void getSnooze(
        com.google.monitoring.v3.GetSnoozeRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.Snooze> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSnoozeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a `Snooze`, identified by its `name`, with the parameters in the
     * given `Snooze` object.
     * </pre>
     */
    public void updateSnooze(
        com.google.monitoring.v3.UpdateSnoozeRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.Snooze> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSnoozeMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The SnoozeService API is used to temporarily prevent an alert policy from
   * generating alerts. A Snooze is a description of the criteria under which one
   * or more alert policies should not fire alerts for the specified duration.
   * </pre>
   */
  public static final class SnoozeServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SnoozeServiceBlockingStub> {
    private SnoozeServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SnoozeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SnoozeServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a `Snooze` that will prevent alerts, which match the provided
     * criteria, from being opened. The `Snooze` applies for a specific time
     * interval.
     * </pre>
     */
    public com.google.monitoring.v3.Snooze createSnooze(
        com.google.monitoring.v3.CreateSnoozeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSnoozeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the `Snooze`s associated with a project. Can optionally pass in
     * `filter`, which specifies predicates to match `Snooze`s.
     * </pre>
     */
    public com.google.monitoring.v3.ListSnoozesResponse listSnoozes(
        com.google.monitoring.v3.ListSnoozesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSnoozesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `Snooze` by `name`.
     * </pre>
     */
    public com.google.monitoring.v3.Snooze getSnooze(
        com.google.monitoring.v3.GetSnoozeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSnoozeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `Snooze`, identified by its `name`, with the parameters in the
     * given `Snooze` object.
     * </pre>
     */
    public com.google.monitoring.v3.Snooze updateSnooze(
        com.google.monitoring.v3.UpdateSnoozeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSnoozeMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The SnoozeService API is used to temporarily prevent an alert policy from
   * generating alerts. A Snooze is a description of the criteria under which one
   * or more alert policies should not fire alerts for the specified duration.
   * </pre>
   */
  public static final class SnoozeServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SnoozeServiceFutureStub> {
    private SnoozeServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SnoozeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SnoozeServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a `Snooze` that will prevent alerts, which match the provided
     * criteria, from being opened. The `Snooze` applies for a specific time
     * interval.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.Snooze>
        createSnooze(com.google.monitoring.v3.CreateSnoozeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSnoozeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the `Snooze`s associated with a project. Can optionally pass in
     * `filter`, which specifies predicates to match `Snooze`s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.v3.ListSnoozesResponse>
        listSnoozes(com.google.monitoring.v3.ListSnoozesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSnoozesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a `Snooze` by `name`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.Snooze>
        getSnooze(com.google.monitoring.v3.GetSnoozeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSnoozeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `Snooze`, identified by its `name`, with the parameters in the
     * given `Snooze` object.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.Snooze>
        updateSnooze(com.google.monitoring.v3.UpdateSnoozeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSnoozeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SNOOZE = 0;
  private static final int METHODID_LIST_SNOOZES = 1;
  private static final int METHODID_GET_SNOOZE = 2;
  private static final int METHODID_UPDATE_SNOOZE = 3;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SnoozeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SnoozeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SNOOZE:
          serviceImpl.createSnooze(
              (com.google.monitoring.v3.CreateSnoozeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.Snooze>) responseObserver);
          break;
        case METHODID_LIST_SNOOZES:
          serviceImpl.listSnoozes(
              (com.google.monitoring.v3.ListSnoozesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListSnoozesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SNOOZE:
          serviceImpl.getSnooze(
              (com.google.monitoring.v3.GetSnoozeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.Snooze>) responseObserver);
          break;
        case METHODID_UPDATE_SNOOZE:
          serviceImpl.updateSnooze(
              (com.google.monitoring.v3.UpdateSnoozeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.Snooze>) responseObserver);
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

  private abstract static class SnoozeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SnoozeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.monitoring.v3.SnoozeServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SnoozeService");
    }
  }

  private static final class SnoozeServiceFileDescriptorSupplier
      extends SnoozeServiceBaseDescriptorSupplier {
    SnoozeServiceFileDescriptorSupplier() {}
  }

  private static final class SnoozeServiceMethodDescriptorSupplier
      extends SnoozeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SnoozeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SnoozeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SnoozeServiceFileDescriptorSupplier())
                      .addMethod(getCreateSnoozeMethod())
                      .addMethod(getListSnoozesMethod())
                      .addMethod(getGetSnoozeMethod())
                      .addMethod(getUpdateSnoozeMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
