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
package com.google.cloud.discoveryengine.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing
 * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation]s,
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1beta/evaluation_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EvaluationServiceGrpc {

  private EvaluationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1beta.EvaluationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetEvaluationRequest,
          com.google.cloud.discoveryengine.v1beta.Evaluation>
      getGetEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEvaluation",
      requestType = com.google.cloud.discoveryengine.v1beta.GetEvaluationRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Evaluation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetEvaluationRequest,
          com.google.cloud.discoveryengine.v1beta.Evaluation>
      getGetEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.GetEvaluationRequest,
            com.google.cloud.discoveryengine.v1beta.Evaluation>
        getGetEvaluationMethod;
    if ((getGetEvaluationMethod = EvaluationServiceGrpc.getGetEvaluationMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getGetEvaluationMethod = EvaluationServiceGrpc.getGetEvaluationMethod) == null) {
          EvaluationServiceGrpc.getGetEvaluationMethod =
              getGetEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.GetEvaluationRequest,
                          com.google.cloud.discoveryengine.v1beta.Evaluation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.GetEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Evaluation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("GetEvaluation"))
                      .build();
        }
      }
    }
    return getGetEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListEvaluationsRequest,
          com.google.cloud.discoveryengine.v1beta.ListEvaluationsResponse>
      getListEvaluationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvaluations",
      requestType = com.google.cloud.discoveryengine.v1beta.ListEvaluationsRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.ListEvaluationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListEvaluationsRequest,
          com.google.cloud.discoveryengine.v1beta.ListEvaluationsResponse>
      getListEvaluationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ListEvaluationsRequest,
            com.google.cloud.discoveryengine.v1beta.ListEvaluationsResponse>
        getListEvaluationsMethod;
    if ((getListEvaluationsMethod = EvaluationServiceGrpc.getListEvaluationsMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getListEvaluationsMethod = EvaluationServiceGrpc.getListEvaluationsMethod) == null) {
          EvaluationServiceGrpc.getListEvaluationsMethod =
              getListEvaluationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ListEvaluationsRequest,
                          com.google.cloud.discoveryengine.v1beta.ListEvaluationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEvaluations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListEvaluationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListEvaluationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("ListEvaluations"))
                      .build();
        }
      }
    }
    return getListEvaluationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateEvaluationRequest,
          com.google.longrunning.Operation>
      getCreateEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEvaluation",
      requestType = com.google.cloud.discoveryengine.v1beta.CreateEvaluationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateEvaluationRequest,
          com.google.longrunning.Operation>
      getCreateEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.CreateEvaluationRequest,
            com.google.longrunning.Operation>
        getCreateEvaluationMethod;
    if ((getCreateEvaluationMethod = EvaluationServiceGrpc.getCreateEvaluationMethod) == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getCreateEvaluationMethod = EvaluationServiceGrpc.getCreateEvaluationMethod) == null) {
          EvaluationServiceGrpc.getCreateEvaluationMethod =
              getCreateEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.CreateEvaluationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.CreateEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("CreateEvaluation"))
                      .build();
        }
      }
    }
    return getCreateEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsRequest,
          com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsResponse>
      getListEvaluationResultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvaluationResults",
      requestType = com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsRequest,
          com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsResponse>
      getListEvaluationResultsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsRequest,
            com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsResponse>
        getListEvaluationResultsMethod;
    if ((getListEvaluationResultsMethod = EvaluationServiceGrpc.getListEvaluationResultsMethod)
        == null) {
      synchronized (EvaluationServiceGrpc.class) {
        if ((getListEvaluationResultsMethod = EvaluationServiceGrpc.getListEvaluationResultsMethod)
            == null) {
          EvaluationServiceGrpc.getListEvaluationResultsMethod =
              getListEvaluationResultsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsRequest,
                          com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListEvaluationResults"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EvaluationServiceMethodDescriptorSupplier("ListEvaluationResults"))
                      .build();
        }
      }
    }
    return getListEvaluationResultsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EvaluationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceStub>() {
          @java.lang.Override
          public EvaluationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EvaluationServiceStub(channel, callOptions);
          }
        };
    return EvaluationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EvaluationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceBlockingStub>() {
          @java.lang.Override
          public EvaluationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EvaluationServiceBlockingStub(channel, callOptions);
          }
        };
    return EvaluationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EvaluationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EvaluationServiceFutureStub>() {
          @java.lang.Override
          public EvaluationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EvaluationServiceFutureStub(channel, callOptions);
          }
        };
    return EvaluationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing
   * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation]s,
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation].
     * </pre>
     */
    default void getEvaluation(
        com.google.cloud.discoveryengine.v1beta.GetEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Evaluation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation]s.
     * </pre>
     */
    default void listEvaluations(
        com.google.cloud.discoveryengine.v1beta.ListEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ListEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEvaluationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation].
     * Upon creation, the evaluation will be automatically triggered and begin
     * execution.
     * </pre>
     */
    default void createEvaluation(
        com.google.cloud.discoveryengine.v1beta.CreateEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of results for a given a
     * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation].
     * </pre>
     */
    default void listEvaluationResults(
        com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEvaluationResultsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EvaluationService.
   *
   * <pre>
   * Service for managing
   * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation]s,
   * </pre>
   */
  public abstract static class EvaluationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return EvaluationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EvaluationService.
   *
   * <pre>
   * Service for managing
   * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation]s,
   * </pre>
   */
  public static final class EvaluationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EvaluationServiceStub> {
    private EvaluationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EvaluationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EvaluationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation].
     * </pre>
     */
    public void getEvaluation(
        com.google.cloud.discoveryengine.v1beta.GetEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Evaluation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation]s.
     * </pre>
     */
    public void listEvaluations(
        com.google.cloud.discoveryengine.v1beta.ListEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ListEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEvaluationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation].
     * Upon creation, the evaluation will be automatically triggered and begin
     * execution.
     * </pre>
     */
    public void createEvaluation(
        com.google.cloud.discoveryengine.v1beta.CreateEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of results for a given a
     * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation].
     * </pre>
     */
    public void listEvaluationResults(
        com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEvaluationResultsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EvaluationService.
   *
   * <pre>
   * Service for managing
   * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation]s,
   * </pre>
   */
  public static final class EvaluationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EvaluationServiceBlockingStub> {
    private EvaluationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EvaluationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EvaluationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Evaluation getEvaluation(
        com.google.cloud.discoveryengine.v1beta.GetEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation]s.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ListEvaluationsResponse listEvaluations(
        com.google.cloud.discoveryengine.v1beta.ListEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEvaluationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation].
     * Upon creation, the evaluation will be automatically triggered and begin
     * execution.
     * </pre>
     */
    public com.google.longrunning.Operation createEvaluation(
        com.google.cloud.discoveryengine.v1beta.CreateEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of results for a given a
     * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsResponse
        listEvaluationResults(
            com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEvaluationResultsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EvaluationService.
   *
   * <pre>
   * Service for managing
   * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation]s,
   * </pre>
   */
  public static final class EvaluationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EvaluationServiceFutureStub> {
    private EvaluationServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EvaluationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EvaluationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Evaluation>
        getEvaluation(com.google.cloud.discoveryengine.v1beta.GetEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation]s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.ListEvaluationsResponse>
        listEvaluations(com.google.cloud.discoveryengine.v1beta.ListEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEvaluationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation].
     * Upon creation, the evaluation will be automatically triggered and begin
     * execution.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEvaluation(com.google.cloud.discoveryengine.v1beta.CreateEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of results for a given a
     * [Evaluation][google.cloud.discoveryengine.v1beta.Evaluation].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsResponse>
        listEvaluationResults(
            com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEvaluationResultsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_EVALUATION = 0;
  private static final int METHODID_LIST_EVALUATIONS = 1;
  private static final int METHODID_CREATE_EVALUATION = 2;
  private static final int METHODID_LIST_EVALUATION_RESULTS = 3;

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
        case METHODID_GET_EVALUATION:
          serviceImpl.getEvaluation(
              (com.google.cloud.discoveryengine.v1beta.GetEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Evaluation>)
                  responseObserver);
          break;
        case METHODID_LIST_EVALUATIONS:
          serviceImpl.listEvaluations(
              (com.google.cloud.discoveryengine.v1beta.ListEvaluationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.ListEvaluationsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_EVALUATION:
          serviceImpl.createEvaluation(
              (com.google.cloud.discoveryengine.v1beta.CreateEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_EVALUATION_RESULTS:
          serviceImpl.listEvaluationResults(
              (com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsResponse>)
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
            getGetEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.GetEvaluationRequest,
                    com.google.cloud.discoveryengine.v1beta.Evaluation>(
                    service, METHODID_GET_EVALUATION)))
        .addMethod(
            getListEvaluationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.ListEvaluationsRequest,
                    com.google.cloud.discoveryengine.v1beta.ListEvaluationsResponse>(
                    service, METHODID_LIST_EVALUATIONS)))
        .addMethod(
            getCreateEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.CreateEvaluationRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_EVALUATION)))
        .addMethod(
            getListEvaluationResultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsRequest,
                    com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsResponse>(
                    service, METHODID_LIST_EVALUATION_RESULTS)))
        .build();
  }

  private abstract static class EvaluationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EvaluationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1beta.EvaluationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EvaluationService");
    }
  }

  private static final class EvaluationServiceFileDescriptorSupplier
      extends EvaluationServiceBaseDescriptorSupplier {
    EvaluationServiceFileDescriptorSupplier() {}
  }

  private static final class EvaluationServiceMethodDescriptorSupplier
      extends EvaluationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EvaluationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EvaluationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EvaluationServiceFileDescriptorSupplier())
                      .addMethod(getGetEvaluationMethod())
                      .addMethod(getListEvaluationsMethod())
                      .addMethod(getCreateEvaluationMethod())
                      .addMethod(getListEvaluationResultsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
