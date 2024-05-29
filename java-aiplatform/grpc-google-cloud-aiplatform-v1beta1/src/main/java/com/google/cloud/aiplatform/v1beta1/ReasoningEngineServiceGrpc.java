/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for managing Vertex AI's Reasoning Engines.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/reasoning_engine_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReasoningEngineServiceGrpc {

  private ReasoningEngineServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.ReasoningEngineService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest,
          com.google.longrunning.Operation>
      getCreateReasoningEngineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReasoningEngine",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest,
          com.google.longrunning.Operation>
      getCreateReasoningEngineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest,
            com.google.longrunning.Operation>
        getCreateReasoningEngineMethod;
    if ((getCreateReasoningEngineMethod = ReasoningEngineServiceGrpc.getCreateReasoningEngineMethod)
        == null) {
      synchronized (ReasoningEngineServiceGrpc.class) {
        if ((getCreateReasoningEngineMethod =
                ReasoningEngineServiceGrpc.getCreateReasoningEngineMethod)
            == null) {
          ReasoningEngineServiceGrpc.getCreateReasoningEngineMethod =
              getCreateReasoningEngineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateReasoningEngine"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReasoningEngineServiceMethodDescriptorSupplier(
                              "CreateReasoningEngine"))
                      .build();
        }
      }
    }
    return getCreateReasoningEngineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest,
          com.google.cloud.aiplatform.v1beta1.ReasoningEngine>
      getGetReasoningEngineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReasoningEngine",
      requestType = com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ReasoningEngine.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest,
          com.google.cloud.aiplatform.v1beta1.ReasoningEngine>
      getGetReasoningEngineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest,
            com.google.cloud.aiplatform.v1beta1.ReasoningEngine>
        getGetReasoningEngineMethod;
    if ((getGetReasoningEngineMethod = ReasoningEngineServiceGrpc.getGetReasoningEngineMethod)
        == null) {
      synchronized (ReasoningEngineServiceGrpc.class) {
        if ((getGetReasoningEngineMethod = ReasoningEngineServiceGrpc.getGetReasoningEngineMethod)
            == null) {
          ReasoningEngineServiceGrpc.getGetReasoningEngineMethod =
              getGetReasoningEngineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest,
                          com.google.cloud.aiplatform.v1beta1.ReasoningEngine>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReasoningEngine"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ReasoningEngine
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReasoningEngineServiceMethodDescriptorSupplier("GetReasoningEngine"))
                      .build();
        }
      }
    }
    return getGetReasoningEngineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest,
          com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse>
      getListReasoningEnginesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReasoningEngines",
      requestType = com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest,
          com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse>
      getListReasoningEnginesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest,
            com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse>
        getListReasoningEnginesMethod;
    if ((getListReasoningEnginesMethod = ReasoningEngineServiceGrpc.getListReasoningEnginesMethod)
        == null) {
      synchronized (ReasoningEngineServiceGrpc.class) {
        if ((getListReasoningEnginesMethod =
                ReasoningEngineServiceGrpc.getListReasoningEnginesMethod)
            == null) {
          ReasoningEngineServiceGrpc.getListReasoningEnginesMethod =
              getListReasoningEnginesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest,
                          com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListReasoningEngines"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReasoningEngineServiceMethodDescriptorSupplier(
                              "ListReasoningEngines"))
                      .build();
        }
      }
    }
    return getListReasoningEnginesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateReasoningEngineRequest,
          com.google.longrunning.Operation>
      getUpdateReasoningEngineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateReasoningEngine",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateReasoningEngineRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateReasoningEngineRequest,
          com.google.longrunning.Operation>
      getUpdateReasoningEngineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateReasoningEngineRequest,
            com.google.longrunning.Operation>
        getUpdateReasoningEngineMethod;
    if ((getUpdateReasoningEngineMethod = ReasoningEngineServiceGrpc.getUpdateReasoningEngineMethod)
        == null) {
      synchronized (ReasoningEngineServiceGrpc.class) {
        if ((getUpdateReasoningEngineMethod =
                ReasoningEngineServiceGrpc.getUpdateReasoningEngineMethod)
            == null) {
          ReasoningEngineServiceGrpc.getUpdateReasoningEngineMethod =
              getUpdateReasoningEngineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateReasoningEngineRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateReasoningEngine"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateReasoningEngineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReasoningEngineServiceMethodDescriptorSupplier(
                              "UpdateReasoningEngine"))
                      .build();
        }
      }
    }
    return getUpdateReasoningEngineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest,
          com.google.longrunning.Operation>
      getDeleteReasoningEngineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReasoningEngine",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest,
          com.google.longrunning.Operation>
      getDeleteReasoningEngineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest,
            com.google.longrunning.Operation>
        getDeleteReasoningEngineMethod;
    if ((getDeleteReasoningEngineMethod = ReasoningEngineServiceGrpc.getDeleteReasoningEngineMethod)
        == null) {
      synchronized (ReasoningEngineServiceGrpc.class) {
        if ((getDeleteReasoningEngineMethod =
                ReasoningEngineServiceGrpc.getDeleteReasoningEngineMethod)
            == null) {
          ReasoningEngineServiceGrpc.getDeleteReasoningEngineMethod =
              getDeleteReasoningEngineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteReasoningEngine"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReasoningEngineServiceMethodDescriptorSupplier(
                              "DeleteReasoningEngine"))
                      .build();
        }
      }
    }
    return getDeleteReasoningEngineMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ReasoningEngineServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineServiceStub>() {
          @java.lang.Override
          public ReasoningEngineServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReasoningEngineServiceStub(channel, callOptions);
          }
        };
    return ReasoningEngineServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReasoningEngineServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineServiceBlockingStub>() {
          @java.lang.Override
          public ReasoningEngineServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReasoningEngineServiceBlockingStub(channel, callOptions);
          }
        };
    return ReasoningEngineServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ReasoningEngineServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineServiceFutureStub>() {
          @java.lang.Override
          public ReasoningEngineServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReasoningEngineServiceFutureStub(channel, callOptions);
          }
        };
    return ReasoningEngineServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for managing Vertex AI's Reasoning Engines.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a reasoning engine.
     * </pre>
     */
    default void createReasoningEngine(
        com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReasoningEngineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a reasoning engine.
     * </pre>
     */
    default void getReasoningEngine(
        com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ReasoningEngine>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetReasoningEngineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists reasoning engines in a location.
     * </pre>
     */
    default void listReasoningEngines(
        com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReasoningEnginesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a reasoning engine.
     * </pre>
     */
    default void updateReasoningEngine(
        com.google.cloud.aiplatform.v1beta1.UpdateReasoningEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateReasoningEngineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reasoning engine.
     * </pre>
     */
    default void deleteReasoningEngine(
        com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteReasoningEngineMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ReasoningEngineService.
   *
   * <pre>
   * A service for managing Vertex AI's Reasoning Engines.
   * </pre>
   */
  public abstract static class ReasoningEngineServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ReasoningEngineServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ReasoningEngineService.
   *
   * <pre>
   * A service for managing Vertex AI's Reasoning Engines.
   * </pre>
   */
  public static final class ReasoningEngineServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReasoningEngineServiceStub> {
    private ReasoningEngineServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReasoningEngineServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReasoningEngineServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a reasoning engine.
     * </pre>
     */
    public void createReasoningEngine(
        com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReasoningEngineMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a reasoning engine.
     * </pre>
     */
    public void getReasoningEngine(
        com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ReasoningEngine>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReasoningEngineMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists reasoning engines in a location.
     * </pre>
     */
    public void listReasoningEngines(
        com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReasoningEnginesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a reasoning engine.
     * </pre>
     */
    public void updateReasoningEngine(
        com.google.cloud.aiplatform.v1beta1.UpdateReasoningEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateReasoningEngineMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reasoning engine.
     * </pre>
     */
    public void deleteReasoningEngine(
        com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteReasoningEngineMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ReasoningEngineService.
   *
   * <pre>
   * A service for managing Vertex AI's Reasoning Engines.
   * </pre>
   */
  public static final class ReasoningEngineServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReasoningEngineServiceBlockingStub> {
    private ReasoningEngineServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReasoningEngineServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReasoningEngineServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a reasoning engine.
     * </pre>
     */
    public com.google.longrunning.Operation createReasoningEngine(
        com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReasoningEngineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a reasoning engine.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ReasoningEngine getReasoningEngine(
        com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReasoningEngineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists reasoning engines in a location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse listReasoningEngines(
        com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReasoningEnginesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a reasoning engine.
     * </pre>
     */
    public com.google.longrunning.Operation updateReasoningEngine(
        com.google.cloud.aiplatform.v1beta1.UpdateReasoningEngineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateReasoningEngineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reasoning engine.
     * </pre>
     */
    public com.google.longrunning.Operation deleteReasoningEngine(
        com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReasoningEngineMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ReasoningEngineService.
   *
   * <pre>
   * A service for managing Vertex AI's Reasoning Engines.
   * </pre>
   */
  public static final class ReasoningEngineServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReasoningEngineServiceFutureStub> {
    private ReasoningEngineServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReasoningEngineServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReasoningEngineServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a reasoning engine.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createReasoningEngine(
            com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReasoningEngineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a reasoning engine.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ReasoningEngine>
        getReasoningEngine(com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReasoningEngineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists reasoning engines in a location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse>
        listReasoningEngines(
            com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReasoningEnginesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a reasoning engine.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateReasoningEngine(
            com.google.cloud.aiplatform.v1beta1.UpdateReasoningEngineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateReasoningEngineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reasoning engine.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteReasoningEngine(
            com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteReasoningEngineMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_REASONING_ENGINE = 0;
  private static final int METHODID_GET_REASONING_ENGINE = 1;
  private static final int METHODID_LIST_REASONING_ENGINES = 2;
  private static final int METHODID_UPDATE_REASONING_ENGINE = 3;
  private static final int METHODID_DELETE_REASONING_ENGINE = 4;

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
        case METHODID_CREATE_REASONING_ENGINE:
          serviceImpl.createReasoningEngine(
              (com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_REASONING_ENGINE:
          serviceImpl.getReasoningEngine(
              (com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ReasoningEngine>)
                  responseObserver);
          break;
        case METHODID_LIST_REASONING_ENGINES:
          serviceImpl.listReasoningEngines(
              (com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_REASONING_ENGINE:
          serviceImpl.updateReasoningEngine(
              (com.google.cloud.aiplatform.v1beta1.UpdateReasoningEngineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_REASONING_ENGINE:
          serviceImpl.deleteReasoningEngine(
              (com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest) request,
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
            getCreateReasoningEngineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_REASONING_ENGINE)))
        .addMethod(
            getGetReasoningEngineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest,
                    com.google.cloud.aiplatform.v1beta1.ReasoningEngine>(
                    service, METHODID_GET_REASONING_ENGINE)))
        .addMethod(
            getListReasoningEnginesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest,
                    com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse>(
                    service, METHODID_LIST_REASONING_ENGINES)))
        .addMethod(
            getUpdateReasoningEngineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdateReasoningEngineRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_REASONING_ENGINE)))
        .addMethod(
            getDeleteReasoningEngineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_REASONING_ENGINE)))
        .build();
  }

  private abstract static class ReasoningEngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReasoningEngineServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.ReasoningEngineServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReasoningEngineService");
    }
  }

  private static final class ReasoningEngineServiceFileDescriptorSupplier
      extends ReasoningEngineServiceBaseDescriptorSupplier {
    ReasoningEngineServiceFileDescriptorSupplier() {}
  }

  private static final class ReasoningEngineServiceMethodDescriptorSupplier
      extends ReasoningEngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ReasoningEngineServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ReasoningEngineServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ReasoningEngineServiceFileDescriptorSupplier())
                      .addMethod(getCreateReasoningEngineMethod())
                      .addMethod(getGetReasoningEngineMethod())
                      .addMethod(getListReasoningEnginesMethod())
                      .addMethod(getUpdateReasoningEngineMethod())
                      .addMethod(getDeleteReasoningEngineMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
