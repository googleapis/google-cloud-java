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
package com.google.cloud.eventarc.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Eventarc allows users to subscribe to various events that are provided by
 * Google Cloud services and forward them to supported destinations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/eventarc/v1/eventarc.proto")
public final class EventarcGrpc {

  private EventarcGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.eventarc.v1.Eventarc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetTriggerRequest, com.google.cloud.eventarc.v1.Trigger>
      getGetTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrigger",
      requestType = com.google.cloud.eventarc.v1.GetTriggerRequest.class,
      responseType = com.google.cloud.eventarc.v1.Trigger.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetTriggerRequest, com.google.cloud.eventarc.v1.Trigger>
      getGetTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.GetTriggerRequest, com.google.cloud.eventarc.v1.Trigger>
        getGetTriggerMethod;
    if ((getGetTriggerMethod = EventarcGrpc.getGetTriggerMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getGetTriggerMethod = EventarcGrpc.getGetTriggerMethod) == null) {
          EventarcGrpc.getGetTriggerMethod =
              getGetTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.GetTriggerRequest,
                          com.google.cloud.eventarc.v1.Trigger>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.GetTriggerRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.Trigger.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("GetTrigger"))
                      .build();
        }
      }
    }
    return getGetTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListTriggersRequest,
          com.google.cloud.eventarc.v1.ListTriggersResponse>
      getListTriggersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTriggers",
      requestType = com.google.cloud.eventarc.v1.ListTriggersRequest.class,
      responseType = com.google.cloud.eventarc.v1.ListTriggersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListTriggersRequest,
          com.google.cloud.eventarc.v1.ListTriggersResponse>
      getListTriggersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.ListTriggersRequest,
            com.google.cloud.eventarc.v1.ListTriggersResponse>
        getListTriggersMethod;
    if ((getListTriggersMethod = EventarcGrpc.getListTriggersMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getListTriggersMethod = EventarcGrpc.getListTriggersMethod) == null) {
          EventarcGrpc.getListTriggersMethod =
              getListTriggersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.ListTriggersRequest,
                          com.google.cloud.eventarc.v1.ListTriggersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTriggers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListTriggersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListTriggersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("ListTriggers"))
                      .build();
        }
      }
    }
    return getListTriggersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateTriggerRequest, com.google.longrunning.Operation>
      getCreateTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTrigger",
      requestType = com.google.cloud.eventarc.v1.CreateTriggerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateTriggerRequest, com.google.longrunning.Operation>
      getCreateTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.CreateTriggerRequest, com.google.longrunning.Operation>
        getCreateTriggerMethod;
    if ((getCreateTriggerMethod = EventarcGrpc.getCreateTriggerMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getCreateTriggerMethod = EventarcGrpc.getCreateTriggerMethod) == null) {
          EventarcGrpc.getCreateTriggerMethod =
              getCreateTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.CreateTriggerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.CreateTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("CreateTrigger"))
                      .build();
        }
      }
    }
    return getCreateTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateTriggerRequest, com.google.longrunning.Operation>
      getUpdateTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTrigger",
      requestType = com.google.cloud.eventarc.v1.UpdateTriggerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateTriggerRequest, com.google.longrunning.Operation>
      getUpdateTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.UpdateTriggerRequest, com.google.longrunning.Operation>
        getUpdateTriggerMethod;
    if ((getUpdateTriggerMethod = EventarcGrpc.getUpdateTriggerMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getUpdateTriggerMethod = EventarcGrpc.getUpdateTriggerMethod) == null) {
          EventarcGrpc.getUpdateTriggerMethod =
              getUpdateTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.UpdateTriggerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.UpdateTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("UpdateTrigger"))
                      .build();
        }
      }
    }
    return getUpdateTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteTriggerRequest, com.google.longrunning.Operation>
      getDeleteTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTrigger",
      requestType = com.google.cloud.eventarc.v1.DeleteTriggerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteTriggerRequest, com.google.longrunning.Operation>
      getDeleteTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.DeleteTriggerRequest, com.google.longrunning.Operation>
        getDeleteTriggerMethod;
    if ((getDeleteTriggerMethod = EventarcGrpc.getDeleteTriggerMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getDeleteTriggerMethod = EventarcGrpc.getDeleteTriggerMethod) == null) {
          EventarcGrpc.getDeleteTriggerMethod =
              getDeleteTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.DeleteTriggerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.DeleteTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("DeleteTrigger"))
                      .build();
        }
      }
    }
    return getDeleteTriggerMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EventarcStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventarcStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EventarcStub>() {
          @java.lang.Override
          public EventarcStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EventarcStub(channel, callOptions);
          }
        };
    return EventarcStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventarcBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventarcBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EventarcBlockingStub>() {
          @java.lang.Override
          public EventarcBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EventarcBlockingStub(channel, callOptions);
          }
        };
    return EventarcBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EventarcFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventarcFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EventarcFutureStub>() {
          @java.lang.Override
          public EventarcFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EventarcFutureStub(channel, callOptions);
          }
        };
    return EventarcFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Eventarc allows users to subscribe to various events that are provided by
   * Google Cloud services and forward them to supported destinations.
   * </pre>
   */
  public abstract static class EventarcImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Get a single trigger.
     * </pre>
     */
    public void getTrigger(
        com.google.cloud.eventarc.v1.GetTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Trigger> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTriggerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List triggers.
     * </pre>
     */
    public void listTriggers(
        com.google.cloud.eventarc.v1.ListTriggersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListTriggersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTriggersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new trigger in a particular project and location.
     * </pre>
     */
    public void createTrigger(
        com.google.cloud.eventarc.v1.CreateTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTriggerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single trigger.
     * </pre>
     */
    public void updateTrigger(
        com.google.cloud.eventarc.v1.UpdateTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTriggerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single trigger.
     * </pre>
     */
    public void deleteTrigger(
        com.google.cloud.eventarc.v1.DeleteTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTriggerMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetTriggerMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.GetTriggerRequest,
                      com.google.cloud.eventarc.v1.Trigger>(this, METHODID_GET_TRIGGER)))
          .addMethod(
              getListTriggersMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.ListTriggersRequest,
                      com.google.cloud.eventarc.v1.ListTriggersResponse>(
                      this, METHODID_LIST_TRIGGERS)))
          .addMethod(
              getCreateTriggerMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.CreateTriggerRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_TRIGGER)))
          .addMethod(
              getUpdateTriggerMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.UpdateTriggerRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_TRIGGER)))
          .addMethod(
              getDeleteTriggerMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.DeleteTriggerRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_TRIGGER)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Eventarc allows users to subscribe to various events that are provided by
   * Google Cloud services and forward them to supported destinations.
   * </pre>
   */
  public static final class EventarcStub extends io.grpc.stub.AbstractAsyncStub<EventarcStub> {
    private EventarcStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventarcStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventarcStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a single trigger.
     * </pre>
     */
    public void getTrigger(
        com.google.cloud.eventarc.v1.GetTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Trigger> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTriggerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List triggers.
     * </pre>
     */
    public void listTriggers(
        com.google.cloud.eventarc.v1.ListTriggersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListTriggersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTriggersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new trigger in a particular project and location.
     * </pre>
     */
    public void createTrigger(
        com.google.cloud.eventarc.v1.CreateTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTriggerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single trigger.
     * </pre>
     */
    public void updateTrigger(
        com.google.cloud.eventarc.v1.UpdateTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTriggerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single trigger.
     * </pre>
     */
    public void deleteTrigger(
        com.google.cloud.eventarc.v1.DeleteTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTriggerMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Eventarc allows users to subscribe to various events that are provided by
   * Google Cloud services and forward them to supported destinations.
   * </pre>
   */
  public static final class EventarcBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EventarcBlockingStub> {
    private EventarcBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventarcBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventarcBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a single trigger.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.Trigger getTrigger(
        com.google.cloud.eventarc.v1.GetTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTriggerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List triggers.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.ListTriggersResponse listTriggers(
        com.google.cloud.eventarc.v1.ListTriggersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTriggersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new trigger in a particular project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createTrigger(
        com.google.cloud.eventarc.v1.CreateTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTriggerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single trigger.
     * </pre>
     */
    public com.google.longrunning.Operation updateTrigger(
        com.google.cloud.eventarc.v1.UpdateTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTriggerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single trigger.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTrigger(
        com.google.cloud.eventarc.v1.DeleteTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTriggerMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Eventarc allows users to subscribe to various events that are provided by
   * Google Cloud services and forward them to supported destinations.
   * </pre>
   */
  public static final class EventarcFutureStub
      extends io.grpc.stub.AbstractFutureStub<EventarcFutureStub> {
    private EventarcFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventarcFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventarcFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a single trigger.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.eventarc.v1.Trigger>
        getTrigger(com.google.cloud.eventarc.v1.GetTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTriggerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List triggers.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.ListTriggersResponse>
        listTriggers(com.google.cloud.eventarc.v1.ListTriggersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTriggersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new trigger in a particular project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createTrigger(com.google.cloud.eventarc.v1.CreateTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTriggerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single trigger.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateTrigger(com.google.cloud.eventarc.v1.UpdateTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTriggerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single trigger.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteTrigger(com.google.cloud.eventarc.v1.DeleteTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTriggerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TRIGGER = 0;
  private static final int METHODID_LIST_TRIGGERS = 1;
  private static final int METHODID_CREATE_TRIGGER = 2;
  private static final int METHODID_UPDATE_TRIGGER = 3;
  private static final int METHODID_DELETE_TRIGGER = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EventarcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EventarcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TRIGGER:
          serviceImpl.getTrigger(
              (com.google.cloud.eventarc.v1.GetTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Trigger>) responseObserver);
          break;
        case METHODID_LIST_TRIGGERS:
          serviceImpl.listTriggers(
              (com.google.cloud.eventarc.v1.ListTriggersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListTriggersResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_TRIGGER:
          serviceImpl.createTrigger(
              (com.google.cloud.eventarc.v1.CreateTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_TRIGGER:
          serviceImpl.updateTrigger(
              (com.google.cloud.eventarc.v1.UpdateTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TRIGGER:
          serviceImpl.deleteTrigger(
              (com.google.cloud.eventarc.v1.DeleteTriggerRequest) request,
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

  private abstract static class EventarcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventarcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.eventarc.v1.EventarcProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Eventarc");
    }
  }

  private static final class EventarcFileDescriptorSupplier extends EventarcBaseDescriptorSupplier {
    EventarcFileDescriptorSupplier() {}
  }

  private static final class EventarcMethodDescriptorSupplier extends EventarcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EventarcMethodDescriptorSupplier(String methodName) {
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
      synchronized (EventarcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EventarcFileDescriptorSupplier())
                      .addMethod(getGetTriggerMethod())
                      .addMethod(getListTriggersMethod())
                      .addMethod(getCreateTriggerMethod())
                      .addMethod(getUpdateTriggerMethod())
                      .addMethod(getDeleteTriggerMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
