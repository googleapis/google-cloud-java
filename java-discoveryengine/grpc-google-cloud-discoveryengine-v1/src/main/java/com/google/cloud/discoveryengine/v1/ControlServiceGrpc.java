/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.discoveryengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for performing CRUD operations on Controls.
 * Controls allow for custom logic to be implemented in the serving path.
 * Controls need to be attached to a Serving Config to be considered during a
 * request.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1/control_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ControlServiceGrpc {

  private ControlServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1.ControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.CreateControlRequest,
          com.google.cloud.discoveryengine.v1.Control>
      getCreateControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateControl",
      requestType = com.google.cloud.discoveryengine.v1.CreateControlRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.Control.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.CreateControlRequest,
          com.google.cloud.discoveryengine.v1.Control>
      getCreateControlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.CreateControlRequest,
            com.google.cloud.discoveryengine.v1.Control>
        getCreateControlMethod;
    if ((getCreateControlMethod = ControlServiceGrpc.getCreateControlMethod) == null) {
      synchronized (ControlServiceGrpc.class) {
        if ((getCreateControlMethod = ControlServiceGrpc.getCreateControlMethod) == null) {
          ControlServiceGrpc.getCreateControlMethod =
              getCreateControlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.CreateControlRequest,
                          com.google.cloud.discoveryengine.v1.Control>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateControl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.CreateControlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.Control.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ControlServiceMethodDescriptorSupplier("CreateControl"))
                      .build();
        }
      }
    }
    return getCreateControlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.DeleteControlRequest, com.google.protobuf.Empty>
      getDeleteControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteControl",
      requestType = com.google.cloud.discoveryengine.v1.DeleteControlRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.DeleteControlRequest, com.google.protobuf.Empty>
      getDeleteControlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.DeleteControlRequest, com.google.protobuf.Empty>
        getDeleteControlMethod;
    if ((getDeleteControlMethod = ControlServiceGrpc.getDeleteControlMethod) == null) {
      synchronized (ControlServiceGrpc.class) {
        if ((getDeleteControlMethod = ControlServiceGrpc.getDeleteControlMethod) == null) {
          ControlServiceGrpc.getDeleteControlMethod =
              getDeleteControlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.DeleteControlRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteControl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.DeleteControlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ControlServiceMethodDescriptorSupplier("DeleteControl"))
                      .build();
        }
      }
    }
    return getDeleteControlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.UpdateControlRequest,
          com.google.cloud.discoveryengine.v1.Control>
      getUpdateControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateControl",
      requestType = com.google.cloud.discoveryengine.v1.UpdateControlRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.Control.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.UpdateControlRequest,
          com.google.cloud.discoveryengine.v1.Control>
      getUpdateControlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.UpdateControlRequest,
            com.google.cloud.discoveryengine.v1.Control>
        getUpdateControlMethod;
    if ((getUpdateControlMethod = ControlServiceGrpc.getUpdateControlMethod) == null) {
      synchronized (ControlServiceGrpc.class) {
        if ((getUpdateControlMethod = ControlServiceGrpc.getUpdateControlMethod) == null) {
          ControlServiceGrpc.getUpdateControlMethod =
              getUpdateControlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.UpdateControlRequest,
                          com.google.cloud.discoveryengine.v1.Control>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateControl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.UpdateControlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.Control.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ControlServiceMethodDescriptorSupplier("UpdateControl"))
                      .build();
        }
      }
    }
    return getUpdateControlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.GetControlRequest,
          com.google.cloud.discoveryengine.v1.Control>
      getGetControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetControl",
      requestType = com.google.cloud.discoveryengine.v1.GetControlRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.Control.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.GetControlRequest,
          com.google.cloud.discoveryengine.v1.Control>
      getGetControlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.GetControlRequest,
            com.google.cloud.discoveryengine.v1.Control>
        getGetControlMethod;
    if ((getGetControlMethod = ControlServiceGrpc.getGetControlMethod) == null) {
      synchronized (ControlServiceGrpc.class) {
        if ((getGetControlMethod = ControlServiceGrpc.getGetControlMethod) == null) {
          ControlServiceGrpc.getGetControlMethod =
              getGetControlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.GetControlRequest,
                          com.google.cloud.discoveryengine.v1.Control>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetControl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.GetControlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.Control.getDefaultInstance()))
                      .setSchemaDescriptor(new ControlServiceMethodDescriptorSupplier("GetControl"))
                      .build();
        }
      }
    }
    return getGetControlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ListControlsRequest,
          com.google.cloud.discoveryengine.v1.ListControlsResponse>
      getListControlsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListControls",
      requestType = com.google.cloud.discoveryengine.v1.ListControlsRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.ListControlsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ListControlsRequest,
          com.google.cloud.discoveryengine.v1.ListControlsResponse>
      getListControlsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.ListControlsRequest,
            com.google.cloud.discoveryengine.v1.ListControlsResponse>
        getListControlsMethod;
    if ((getListControlsMethod = ControlServiceGrpc.getListControlsMethod) == null) {
      synchronized (ControlServiceGrpc.class) {
        if ((getListControlsMethod = ControlServiceGrpc.getListControlsMethod) == null) {
          ControlServiceGrpc.getListControlsMethod =
              getListControlsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.ListControlsRequest,
                          com.google.cloud.discoveryengine.v1.ListControlsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListControls"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.ListControlsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.ListControlsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ControlServiceMethodDescriptorSupplier("ListControls"))
                      .build();
        }
      }
    }
    return getListControlsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ControlServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ControlServiceStub>() {
          @java.lang.Override
          public ControlServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ControlServiceStub(channel, callOptions);
          }
        };
    return ControlServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ControlServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ControlServiceBlockingStub>() {
          @java.lang.Override
          public ControlServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ControlServiceBlockingStub(channel, callOptions);
          }
        };
    return ControlServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ControlServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ControlServiceFutureStub>() {
          @java.lang.Override
          public ControlServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ControlServiceFutureStub(channel, callOptions);
          }
        };
    return ControlServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for performing CRUD operations on Controls.
   * Controls allow for custom logic to be implemented in the serving path.
   * Controls need to be attached to a Serving Config to be considered during a
   * request.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a Control.
     * By default 1000 controls are allowed for a data store.
     * A request can be submitted to adjust this limit.
     * If the [Control][google.cloud.discoveryengine.v1.Control] to create already
     * exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    default void createControl(
        com.google.cloud.discoveryengine.v1.CreateControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.Control> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateControlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Control.
     * If the [Control][google.cloud.discoveryengine.v1.Control] to delete does
     * not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    default void deleteControl(
        com.google.cloud.discoveryengine.v1.DeleteControlRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteControlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Control.
     * [Control][google.cloud.discoveryengine.v1.Control] action type cannot be
     * changed. If the [Control][google.cloud.discoveryengine.v1.Control] to
     * update does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    default void updateControl(
        com.google.cloud.discoveryengine.v1.UpdateControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.Control> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateControlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Control.
     * </pre>
     */
    default void getControl(
        com.google.cloud.discoveryengine.v1.GetControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.Control> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetControlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Controls by their parent
     * [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * </pre>
     */
    default void listControls(
        com.google.cloud.discoveryengine.v1.ListControlsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.ListControlsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListControlsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ControlService.
   *
   * <pre>
   * Service for performing CRUD operations on Controls.
   * Controls allow for custom logic to be implemented in the serving path.
   * Controls need to be attached to a Serving Config to be considered during a
   * request.
   * </pre>
   */
  public abstract static class ControlServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ControlServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ControlService.
   *
   * <pre>
   * Service for performing CRUD operations on Controls.
   * Controls allow for custom logic to be implemented in the serving path.
   * Controls need to be attached to a Serving Config to be considered during a
   * request.
   * </pre>
   */
  public static final class ControlServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ControlServiceStub> {
    private ControlServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Control.
     * By default 1000 controls are allowed for a data store.
     * A request can be submitted to adjust this limit.
     * If the [Control][google.cloud.discoveryengine.v1.Control] to create already
     * exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public void createControl(
        com.google.cloud.discoveryengine.v1.CreateControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.Control> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateControlMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Control.
     * If the [Control][google.cloud.discoveryengine.v1.Control] to delete does
     * not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public void deleteControl(
        com.google.cloud.discoveryengine.v1.DeleteControlRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteControlMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Control.
     * [Control][google.cloud.discoveryengine.v1.Control] action type cannot be
     * changed. If the [Control][google.cloud.discoveryengine.v1.Control] to
     * update does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public void updateControl(
        com.google.cloud.discoveryengine.v1.UpdateControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.Control> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateControlMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Control.
     * </pre>
     */
    public void getControl(
        com.google.cloud.discoveryengine.v1.GetControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.Control> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetControlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Controls by their parent
     * [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * </pre>
     */
    public void listControls(
        com.google.cloud.discoveryengine.v1.ListControlsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.ListControlsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListControlsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ControlService.
   *
   * <pre>
   * Service for performing CRUD operations on Controls.
   * Controls allow for custom logic to be implemented in the serving path.
   * Controls need to be attached to a Serving Config to be considered during a
   * request.
   * </pre>
   */
  public static final class ControlServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ControlServiceBlockingStub> {
    private ControlServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Control.
     * By default 1000 controls are allowed for a data store.
     * A request can be submitted to adjust this limit.
     * If the [Control][google.cloud.discoveryengine.v1.Control] to create already
     * exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.Control createControl(
        com.google.cloud.discoveryengine.v1.CreateControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateControlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Control.
     * If the [Control][google.cloud.discoveryengine.v1.Control] to delete does
     * not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.protobuf.Empty deleteControl(
        com.google.cloud.discoveryengine.v1.DeleteControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteControlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Control.
     * [Control][google.cloud.discoveryengine.v1.Control] action type cannot be
     * changed. If the [Control][google.cloud.discoveryengine.v1.Control] to
     * update does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.Control updateControl(
        com.google.cloud.discoveryengine.v1.UpdateControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateControlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Control.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.Control getControl(
        com.google.cloud.discoveryengine.v1.GetControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetControlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Controls by their parent
     * [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.ListControlsResponse listControls(
        com.google.cloud.discoveryengine.v1.ListControlsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListControlsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ControlService.
   *
   * <pre>
   * Service for performing CRUD operations on Controls.
   * Controls allow for custom logic to be implemented in the serving path.
   * Controls need to be attached to a Serving Config to be considered during a
   * request.
   * </pre>
   */
  public static final class ControlServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ControlServiceFutureStub> {
    private ControlServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Control.
     * By default 1000 controls are allowed for a data store.
     * A request can be submitted to adjust this limit.
     * If the [Control][google.cloud.discoveryengine.v1.Control] to create already
     * exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.Control>
        createControl(com.google.cloud.discoveryengine.v1.CreateControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateControlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Control.
     * If the [Control][google.cloud.discoveryengine.v1.Control] to delete does
     * not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteControl(com.google.cloud.discoveryengine.v1.DeleteControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteControlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Control.
     * [Control][google.cloud.discoveryengine.v1.Control] action type cannot be
     * changed. If the [Control][google.cloud.discoveryengine.v1.Control] to
     * update does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.Control>
        updateControl(com.google.cloud.discoveryengine.v1.UpdateControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateControlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Control.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.Control>
        getControl(com.google.cloud.discoveryengine.v1.GetControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetControlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Controls by their parent
     * [DataStore][google.cloud.discoveryengine.v1.DataStore].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.ListControlsResponse>
        listControls(com.google.cloud.discoveryengine.v1.ListControlsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListControlsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CONTROL = 0;
  private static final int METHODID_DELETE_CONTROL = 1;
  private static final int METHODID_UPDATE_CONTROL = 2;
  private static final int METHODID_GET_CONTROL = 3;
  private static final int METHODID_LIST_CONTROLS = 4;

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
        case METHODID_CREATE_CONTROL:
          serviceImpl.createControl(
              (com.google.cloud.discoveryengine.v1.CreateControlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.Control>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONTROL:
          serviceImpl.deleteControl(
              (com.google.cloud.discoveryengine.v1.DeleteControlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_CONTROL:
          serviceImpl.updateControl(
              (com.google.cloud.discoveryengine.v1.UpdateControlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.Control>)
                  responseObserver);
          break;
        case METHODID_GET_CONTROL:
          serviceImpl.getControl(
              (com.google.cloud.discoveryengine.v1.GetControlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.Control>)
                  responseObserver);
          break;
        case METHODID_LIST_CONTROLS:
          serviceImpl.listControls(
              (com.google.cloud.discoveryengine.v1.ListControlsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1.ListControlsResponse>)
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
            getCreateControlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.CreateControlRequest,
                    com.google.cloud.discoveryengine.v1.Control>(service, METHODID_CREATE_CONTROL)))
        .addMethod(
            getDeleteControlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.DeleteControlRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CONTROL)))
        .addMethod(
            getUpdateControlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.UpdateControlRequest,
                    com.google.cloud.discoveryengine.v1.Control>(service, METHODID_UPDATE_CONTROL)))
        .addMethod(
            getGetControlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.GetControlRequest,
                    com.google.cloud.discoveryengine.v1.Control>(service, METHODID_GET_CONTROL)))
        .addMethod(
            getListControlsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.ListControlsRequest,
                    com.google.cloud.discoveryengine.v1.ListControlsResponse>(
                    service, METHODID_LIST_CONTROLS)))
        .build();
  }

  private abstract static class ControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1.ControlServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ControlService");
    }
  }

  private static final class ControlServiceFileDescriptorSupplier
      extends ControlServiceBaseDescriptorSupplier {
    ControlServiceFileDescriptorSupplier() {}
  }

  private static final class ControlServiceMethodDescriptorSupplier
      extends ControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ControlServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ControlServiceFileDescriptorSupplier())
                      .addMethod(getCreateControlMethod())
                      .addMethod(getDeleteControlMethod())
                      .addMethod(getUpdateControlMethod())
                      .addMethod(getGetControlMethod())
                      .addMethod(getListControlsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
