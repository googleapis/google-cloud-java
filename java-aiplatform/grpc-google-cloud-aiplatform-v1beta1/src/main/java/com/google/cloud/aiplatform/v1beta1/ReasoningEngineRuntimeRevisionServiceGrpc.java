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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages Vertex AI's Reasoning Engine Revisions.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ReasoningEngineRuntimeRevisionServiceGrpc {

  private ReasoningEngineRuntimeRevisionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevisionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRuntimeRevisionRequest,
          com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision>
      getGetReasoningEngineRuntimeRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReasoningEngineRuntimeRevision",
      requestType =
          com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRuntimeRevisionRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRuntimeRevisionRequest,
          com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision>
      getGetReasoningEngineRuntimeRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRuntimeRevisionRequest,
            com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision>
        getGetReasoningEngineRuntimeRevisionMethod;
    if ((getGetReasoningEngineRuntimeRevisionMethod =
            ReasoningEngineRuntimeRevisionServiceGrpc.getGetReasoningEngineRuntimeRevisionMethod)
        == null) {
      synchronized (ReasoningEngineRuntimeRevisionServiceGrpc.class) {
        if ((getGetReasoningEngineRuntimeRevisionMethod =
                ReasoningEngineRuntimeRevisionServiceGrpc
                    .getGetReasoningEngineRuntimeRevisionMethod)
            == null) {
          ReasoningEngineRuntimeRevisionServiceGrpc.getGetReasoningEngineRuntimeRevisionMethod =
              getGetReasoningEngineRuntimeRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1
                              .GetReasoningEngineRuntimeRevisionRequest,
                          com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetReasoningEngineRuntimeRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .GetReasoningEngineRuntimeRevisionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReasoningEngineRuntimeRevisionServiceMethodDescriptorSupplier(
                              "GetReasoningEngineRuntimeRevision"))
                      .build();
        }
      }
    }
    return getGetReasoningEngineRuntimeRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsRequest,
          com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsResponse>
      getListReasoningEngineRuntimeRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReasoningEngineRuntimeRevisions",
      requestType =
          com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsRequest.class,
      responseType =
          com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsRequest,
          com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsResponse>
      getListReasoningEngineRuntimeRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsRequest,
            com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsResponse>
        getListReasoningEngineRuntimeRevisionsMethod;
    if ((getListReasoningEngineRuntimeRevisionsMethod =
            ReasoningEngineRuntimeRevisionServiceGrpc.getListReasoningEngineRuntimeRevisionsMethod)
        == null) {
      synchronized (ReasoningEngineRuntimeRevisionServiceGrpc.class) {
        if ((getListReasoningEngineRuntimeRevisionsMethod =
                ReasoningEngineRuntimeRevisionServiceGrpc
                    .getListReasoningEngineRuntimeRevisionsMethod)
            == null) {
          ReasoningEngineRuntimeRevisionServiceGrpc.getListReasoningEngineRuntimeRevisionsMethod =
              getListReasoningEngineRuntimeRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1
                              .ListReasoningEngineRuntimeRevisionsRequest,
                          com.google.cloud.aiplatform.v1beta1
                              .ListReasoningEngineRuntimeRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListReasoningEngineRuntimeRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .ListReasoningEngineRuntimeRevisionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .ListReasoningEngineRuntimeRevisionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReasoningEngineRuntimeRevisionServiceMethodDescriptorSupplier(
                              "ListReasoningEngineRuntimeRevisions"))
                      .build();
        }
      }
    }
    return getListReasoningEngineRuntimeRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRuntimeRevisionRequest,
          com.google.longrunning.Operation>
      getDeleteReasoningEngineRuntimeRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReasoningEngineRuntimeRevision",
      requestType =
          com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRuntimeRevisionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRuntimeRevisionRequest,
          com.google.longrunning.Operation>
      getDeleteReasoningEngineRuntimeRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRuntimeRevisionRequest,
            com.google.longrunning.Operation>
        getDeleteReasoningEngineRuntimeRevisionMethod;
    if ((getDeleteReasoningEngineRuntimeRevisionMethod =
            ReasoningEngineRuntimeRevisionServiceGrpc.getDeleteReasoningEngineRuntimeRevisionMethod)
        == null) {
      synchronized (ReasoningEngineRuntimeRevisionServiceGrpc.class) {
        if ((getDeleteReasoningEngineRuntimeRevisionMethod =
                ReasoningEngineRuntimeRevisionServiceGrpc
                    .getDeleteReasoningEngineRuntimeRevisionMethod)
            == null) {
          ReasoningEngineRuntimeRevisionServiceGrpc.getDeleteReasoningEngineRuntimeRevisionMethod =
              getDeleteReasoningEngineRuntimeRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1
                              .DeleteReasoningEngineRuntimeRevisionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DeleteReasoningEngineRuntimeRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .DeleteReasoningEngineRuntimeRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReasoningEngineRuntimeRevisionServiceMethodDescriptorSupplier(
                              "DeleteReasoningEngineRuntimeRevision"))
                      .build();
        }
      }
    }
    return getDeleteReasoningEngineRuntimeRevisionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ReasoningEngineRuntimeRevisionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineRuntimeRevisionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineRuntimeRevisionServiceStub>() {
          @java.lang.Override
          public ReasoningEngineRuntimeRevisionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReasoningEngineRuntimeRevisionServiceStub(channel, callOptions);
          }
        };
    return ReasoningEngineRuntimeRevisionServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ReasoningEngineRuntimeRevisionServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineRuntimeRevisionServiceBlockingV2Stub>
        factory =
            new io.grpc.stub.AbstractStub.StubFactory<
                ReasoningEngineRuntimeRevisionServiceBlockingV2Stub>() {
              @java.lang.Override
              public ReasoningEngineRuntimeRevisionServiceBlockingV2Stub newStub(
                  io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new ReasoningEngineRuntimeRevisionServiceBlockingV2Stub(
                    channel, callOptions);
              }
            };
    return ReasoningEngineRuntimeRevisionServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReasoningEngineRuntimeRevisionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineRuntimeRevisionServiceBlockingStub>
        factory =
            new io.grpc.stub.AbstractStub.StubFactory<
                ReasoningEngineRuntimeRevisionServiceBlockingStub>() {
              @java.lang.Override
              public ReasoningEngineRuntimeRevisionServiceBlockingStub newStub(
                  io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new ReasoningEngineRuntimeRevisionServiceBlockingStub(channel, callOptions);
              }
            };
    return ReasoningEngineRuntimeRevisionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ReasoningEngineRuntimeRevisionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReasoningEngineRuntimeRevisionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<
            ReasoningEngineRuntimeRevisionServiceFutureStub>() {
          @java.lang.Override
          public ReasoningEngineRuntimeRevisionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReasoningEngineRuntimeRevisionServiceFutureStub(channel, callOptions);
          }
        };
    return ReasoningEngineRuntimeRevisionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages Vertex AI's Reasoning Engine Revisions.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a reasoning engine runtime revision.
     * </pre>
     */
    default void getReasoningEngineRuntimeRevision(
        com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRuntimeRevisionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetReasoningEngineRuntimeRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists runtime revisions in a reasoning engine.
     * </pre>
     */
    default void listReasoningEngineRuntimeRevisions(
        com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReasoningEngineRuntimeRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reasoning engine revision.
     * </pre>
     */
    default void deleteReasoningEngineRuntimeRevision(
        com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRuntimeRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteReasoningEngineRuntimeRevisionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ReasoningEngineRuntimeRevisionService.
   *
   * <pre>
   * Manages Vertex AI's Reasoning Engine Revisions.
   * </pre>
   */
  public abstract static class ReasoningEngineRuntimeRevisionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ReasoningEngineRuntimeRevisionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service
   * ReasoningEngineRuntimeRevisionService.
   *
   * <pre>
   * Manages Vertex AI's Reasoning Engine Revisions.
   * </pre>
   */
  public static final class ReasoningEngineRuntimeRevisionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReasoningEngineRuntimeRevisionServiceStub> {
    private ReasoningEngineRuntimeRevisionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReasoningEngineRuntimeRevisionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReasoningEngineRuntimeRevisionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a reasoning engine runtime revision.
     * </pre>
     */
    public void getReasoningEngineRuntimeRevision(
        com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRuntimeRevisionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReasoningEngineRuntimeRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists runtime revisions in a reasoning engine.
     * </pre>
     */
    public void listReasoningEngineRuntimeRevisions(
        com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReasoningEngineRuntimeRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reasoning engine revision.
     * </pre>
     */
    public void deleteReasoningEngineRuntimeRevision(
        com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRuntimeRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteReasoningEngineRuntimeRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service
   * ReasoningEngineRuntimeRevisionService.
   *
   * <pre>
   * Manages Vertex AI's Reasoning Engine Revisions.
   * </pre>
   */
  public static final class ReasoningEngineRuntimeRevisionServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<
          ReasoningEngineRuntimeRevisionServiceBlockingV2Stub> {
    private ReasoningEngineRuntimeRevisionServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReasoningEngineRuntimeRevisionServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReasoningEngineRuntimeRevisionServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a reasoning engine runtime revision.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision
        getReasoningEngineRuntimeRevision(
            com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRuntimeRevisionRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetReasoningEngineRuntimeRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists runtime revisions in a reasoning engine.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsResponse
        listReasoningEngineRuntimeRevisions(
            com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListReasoningEngineRuntimeRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reasoning engine revision.
     * </pre>
     */
    public com.google.longrunning.Operation deleteReasoningEngineRuntimeRevision(
        com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRuntimeRevisionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteReasoningEngineRuntimeRevisionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * ReasoningEngineRuntimeRevisionService.
   *
   * <pre>
   * Manages Vertex AI's Reasoning Engine Revisions.
   * </pre>
   */
  public static final class ReasoningEngineRuntimeRevisionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReasoningEngineRuntimeRevisionServiceBlockingStub> {
    private ReasoningEngineRuntimeRevisionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReasoningEngineRuntimeRevisionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReasoningEngineRuntimeRevisionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a reasoning engine runtime revision.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision
        getReasoningEngineRuntimeRevision(
            com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRuntimeRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReasoningEngineRuntimeRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists runtime revisions in a reasoning engine.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsResponse
        listReasoningEngineRuntimeRevisions(
            com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReasoningEngineRuntimeRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reasoning engine revision.
     * </pre>
     */
    public com.google.longrunning.Operation deleteReasoningEngineRuntimeRevision(
        com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRuntimeRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReasoningEngineRuntimeRevisionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ReasoningEngineRuntimeRevisionService.
   *
   * <pre>
   * Manages Vertex AI's Reasoning Engine Revisions.
   * </pre>
   */
  public static final class ReasoningEngineRuntimeRevisionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReasoningEngineRuntimeRevisionServiceFutureStub> {
    private ReasoningEngineRuntimeRevisionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReasoningEngineRuntimeRevisionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReasoningEngineRuntimeRevisionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a reasoning engine runtime revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision>
        getReasoningEngineRuntimeRevision(
            com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRuntimeRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReasoningEngineRuntimeRevisionMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists runtime revisions in a reasoning engine.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsResponse>
        listReasoningEngineRuntimeRevisions(
            com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReasoningEngineRuntimeRevisionsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reasoning engine revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteReasoningEngineRuntimeRevision(
            com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRuntimeRevisionRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteReasoningEngineRuntimeRevisionMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_GET_REASONING_ENGINE_RUNTIME_REVISION = 0;
  private static final int METHODID_LIST_REASONING_ENGINE_RUNTIME_REVISIONS = 1;
  private static final int METHODID_DELETE_REASONING_ENGINE_RUNTIME_REVISION = 2;

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
        case METHODID_GET_REASONING_ENGINE_RUNTIME_REVISION:
          serviceImpl.getReasoningEngineRuntimeRevision(
              (com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRuntimeRevisionRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision>)
                  responseObserver);
          break;
        case METHODID_LIST_REASONING_ENGINE_RUNTIME_REVISIONS:
          serviceImpl.listReasoningEngineRuntimeRevisions(
              (com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1
                          .ListReasoningEngineRuntimeRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_REASONING_ENGINE_RUNTIME_REVISION:
          serviceImpl.deleteReasoningEngineRuntimeRevision(
              (com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRuntimeRevisionRequest)
                  request,
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
            getGetReasoningEngineRuntimeRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRuntimeRevisionRequest,
                    com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision>(
                    service, METHODID_GET_REASONING_ENGINE_RUNTIME_REVISION)))
        .addMethod(
            getListReasoningEngineRuntimeRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsRequest,
                    com.google.cloud.aiplatform.v1beta1
                        .ListReasoningEngineRuntimeRevisionsResponse>(
                    service, METHODID_LIST_REASONING_ENGINE_RUNTIME_REVISIONS)))
        .addMethod(
            getDeleteReasoningEngineRuntimeRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRuntimeRevisionRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_REASONING_ENGINE_RUNTIME_REVISION)))
        .build();
  }

  private abstract static class ReasoningEngineRuntimeRevisionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReasoningEngineRuntimeRevisionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevisionServiceProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReasoningEngineRuntimeRevisionService");
    }
  }

  private static final class ReasoningEngineRuntimeRevisionServiceFileDescriptorSupplier
      extends ReasoningEngineRuntimeRevisionServiceBaseDescriptorSupplier {
    ReasoningEngineRuntimeRevisionServiceFileDescriptorSupplier() {}
  }

  private static final class ReasoningEngineRuntimeRevisionServiceMethodDescriptorSupplier
      extends ReasoningEngineRuntimeRevisionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ReasoningEngineRuntimeRevisionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ReasoningEngineRuntimeRevisionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new ReasoningEngineRuntimeRevisionServiceFileDescriptorSupplier())
                      .addMethod(getGetReasoningEngineRuntimeRevisionMethod())
                      .addMethod(getListReasoningEngineRuntimeRevisionsMethod())
                      .addMethod(getDeleteReasoningEngineRuntimeRevisionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
