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
 * Service for managing generator evaluations.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class GeneratorEvaluationsGrpc {

  private GeneratorEvaluationsGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.dialogflow.v2.GeneratorEvaluations";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateGeneratorEvaluationRequest,
          com.google.longrunning.Operation>
      getCreateGeneratorEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGeneratorEvaluation",
      requestType = com.google.cloud.dialogflow.v2.CreateGeneratorEvaluationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateGeneratorEvaluationRequest,
          com.google.longrunning.Operation>
      getCreateGeneratorEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.CreateGeneratorEvaluationRequest,
            com.google.longrunning.Operation>
        getCreateGeneratorEvaluationMethod;
    if ((getCreateGeneratorEvaluationMethod =
            GeneratorEvaluationsGrpc.getCreateGeneratorEvaluationMethod)
        == null) {
      synchronized (GeneratorEvaluationsGrpc.class) {
        if ((getCreateGeneratorEvaluationMethod =
                GeneratorEvaluationsGrpc.getCreateGeneratorEvaluationMethod)
            == null) {
          GeneratorEvaluationsGrpc.getCreateGeneratorEvaluationMethod =
              getCreateGeneratorEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.CreateGeneratorEvaluationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateGeneratorEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.CreateGeneratorEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GeneratorEvaluationsMethodDescriptorSupplier(
                              "CreateGeneratorEvaluation"))
                      .build();
        }
      }
    }
    return getCreateGeneratorEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetGeneratorEvaluationRequest,
          com.google.cloud.dialogflow.v2.GeneratorEvaluation>
      getGetGeneratorEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGeneratorEvaluation",
      requestType = com.google.cloud.dialogflow.v2.GetGeneratorEvaluationRequest.class,
      responseType = com.google.cloud.dialogflow.v2.GeneratorEvaluation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetGeneratorEvaluationRequest,
          com.google.cloud.dialogflow.v2.GeneratorEvaluation>
      getGetGeneratorEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.GetGeneratorEvaluationRequest,
            com.google.cloud.dialogflow.v2.GeneratorEvaluation>
        getGetGeneratorEvaluationMethod;
    if ((getGetGeneratorEvaluationMethod = GeneratorEvaluationsGrpc.getGetGeneratorEvaluationMethod)
        == null) {
      synchronized (GeneratorEvaluationsGrpc.class) {
        if ((getGetGeneratorEvaluationMethod =
                GeneratorEvaluationsGrpc.getGetGeneratorEvaluationMethod)
            == null) {
          GeneratorEvaluationsGrpc.getGetGeneratorEvaluationMethod =
              getGetGeneratorEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.GetGeneratorEvaluationRequest,
                          com.google.cloud.dialogflow.v2.GeneratorEvaluation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetGeneratorEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GetGeneratorEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GeneratorEvaluation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GeneratorEvaluationsMethodDescriptorSupplier(
                              "GetGeneratorEvaluation"))
                      .build();
        }
      }
    }
    return getGetGeneratorEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsRequest,
          com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsResponse>
      getListGeneratorEvaluationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGeneratorEvaluations",
      requestType = com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsRequest,
          com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsResponse>
      getListGeneratorEvaluationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsRequest,
            com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsResponse>
        getListGeneratorEvaluationsMethod;
    if ((getListGeneratorEvaluationsMethod =
            GeneratorEvaluationsGrpc.getListGeneratorEvaluationsMethod)
        == null) {
      synchronized (GeneratorEvaluationsGrpc.class) {
        if ((getListGeneratorEvaluationsMethod =
                GeneratorEvaluationsGrpc.getListGeneratorEvaluationsMethod)
            == null) {
          GeneratorEvaluationsGrpc.getListGeneratorEvaluationsMethod =
              getListGeneratorEvaluationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsRequest,
                          com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListGeneratorEvaluations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GeneratorEvaluationsMethodDescriptorSupplier(
                              "ListGeneratorEvaluations"))
                      .build();
        }
      }
    }
    return getListGeneratorEvaluationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteGeneratorEvaluationRequest,
          com.google.protobuf.Empty>
      getDeleteGeneratorEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGeneratorEvaluation",
      requestType = com.google.cloud.dialogflow.v2.DeleteGeneratorEvaluationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteGeneratorEvaluationRequest,
          com.google.protobuf.Empty>
      getDeleteGeneratorEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.DeleteGeneratorEvaluationRequest,
            com.google.protobuf.Empty>
        getDeleteGeneratorEvaluationMethod;
    if ((getDeleteGeneratorEvaluationMethod =
            GeneratorEvaluationsGrpc.getDeleteGeneratorEvaluationMethod)
        == null) {
      synchronized (GeneratorEvaluationsGrpc.class) {
        if ((getDeleteGeneratorEvaluationMethod =
                GeneratorEvaluationsGrpc.getDeleteGeneratorEvaluationMethod)
            == null) {
          GeneratorEvaluationsGrpc.getDeleteGeneratorEvaluationMethod =
              getDeleteGeneratorEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.DeleteGeneratorEvaluationRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteGeneratorEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.DeleteGeneratorEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GeneratorEvaluationsMethodDescriptorSupplier(
                              "DeleteGeneratorEvaluation"))
                      .build();
        }
      }
    }
    return getDeleteGeneratorEvaluationMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GeneratorEvaluationsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeneratorEvaluationsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GeneratorEvaluationsStub>() {
          @java.lang.Override
          public GeneratorEvaluationsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GeneratorEvaluationsStub(channel, callOptions);
          }
        };
    return GeneratorEvaluationsStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static GeneratorEvaluationsBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeneratorEvaluationsBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GeneratorEvaluationsBlockingV2Stub>() {
          @java.lang.Override
          public GeneratorEvaluationsBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GeneratorEvaluationsBlockingV2Stub(channel, callOptions);
          }
        };
    return GeneratorEvaluationsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GeneratorEvaluationsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeneratorEvaluationsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GeneratorEvaluationsBlockingStub>() {
          @java.lang.Override
          public GeneratorEvaluationsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GeneratorEvaluationsBlockingStub(channel, callOptions);
          }
        };
    return GeneratorEvaluationsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GeneratorEvaluationsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeneratorEvaluationsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GeneratorEvaluationsFutureStub>() {
          @java.lang.Override
          public GeneratorEvaluationsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GeneratorEvaluationsFutureStub(channel, callOptions);
          }
        };
    return GeneratorEvaluationsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing generator evaluations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates evaluation of a generator.
     * </pre>
     */
    default void createGeneratorEvaluation(
        com.google.cloud.dialogflow.v2.CreateGeneratorEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGeneratorEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an evaluation of generator.
     * </pre>
     */
    default void getGeneratorEvaluation(
        com.google.cloud.dialogflow.v2.GetGeneratorEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.GeneratorEvaluation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGeneratorEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists evaluations of generator.
     * </pre>
     */
    default void listGeneratorEvaluations(
        com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGeneratorEvaluationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation of generator.
     * </pre>
     */
    default void deleteGeneratorEvaluation(
        com.google.cloud.dialogflow.v2.DeleteGeneratorEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGeneratorEvaluationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GeneratorEvaluations.
   *
   * <pre>
   * Service for managing generator evaluations.
   * </pre>
   */
  public abstract static class GeneratorEvaluationsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return GeneratorEvaluationsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GeneratorEvaluations.
   *
   * <pre>
   * Service for managing generator evaluations.
   * </pre>
   */
  public static final class GeneratorEvaluationsStub
      extends io.grpc.stub.AbstractAsyncStub<GeneratorEvaluationsStub> {
    private GeneratorEvaluationsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeneratorEvaluationsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeneratorEvaluationsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates evaluation of a generator.
     * </pre>
     */
    public void createGeneratorEvaluation(
        com.google.cloud.dialogflow.v2.CreateGeneratorEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGeneratorEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an evaluation of generator.
     * </pre>
     */
    public void getGeneratorEvaluation(
        com.google.cloud.dialogflow.v2.GetGeneratorEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.GeneratorEvaluation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGeneratorEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists evaluations of generator.
     * </pre>
     */
    public void listGeneratorEvaluations(
        com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGeneratorEvaluationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation of generator.
     * </pre>
     */
    public void deleteGeneratorEvaluation(
        com.google.cloud.dialogflow.v2.DeleteGeneratorEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGeneratorEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GeneratorEvaluations.
   *
   * <pre>
   * Service for managing generator evaluations.
   * </pre>
   */
  public static final class GeneratorEvaluationsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<GeneratorEvaluationsBlockingV2Stub> {
    private GeneratorEvaluationsBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeneratorEvaluationsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeneratorEvaluationsBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates evaluation of a generator.
     * </pre>
     */
    public com.google.longrunning.Operation createGeneratorEvaluation(
        com.google.cloud.dialogflow.v2.CreateGeneratorEvaluationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateGeneratorEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an evaluation of generator.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.GeneratorEvaluation getGeneratorEvaluation(
        com.google.cloud.dialogflow.v2.GetGeneratorEvaluationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetGeneratorEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists evaluations of generator.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsResponse listGeneratorEvaluations(
        com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListGeneratorEvaluationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation of generator.
     * </pre>
     */
    public com.google.protobuf.Empty deleteGeneratorEvaluation(
        com.google.cloud.dialogflow.v2.DeleteGeneratorEvaluationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteGeneratorEvaluationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service GeneratorEvaluations.
   *
   * <pre>
   * Service for managing generator evaluations.
   * </pre>
   */
  public static final class GeneratorEvaluationsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GeneratorEvaluationsBlockingStub> {
    private GeneratorEvaluationsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeneratorEvaluationsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeneratorEvaluationsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates evaluation of a generator.
     * </pre>
     */
    public com.google.longrunning.Operation createGeneratorEvaluation(
        com.google.cloud.dialogflow.v2.CreateGeneratorEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGeneratorEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an evaluation of generator.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.GeneratorEvaluation getGeneratorEvaluation(
        com.google.cloud.dialogflow.v2.GetGeneratorEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGeneratorEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists evaluations of generator.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsResponse listGeneratorEvaluations(
        com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGeneratorEvaluationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation of generator.
     * </pre>
     */
    public com.google.protobuf.Empty deleteGeneratorEvaluation(
        com.google.cloud.dialogflow.v2.DeleteGeneratorEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGeneratorEvaluationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GeneratorEvaluations.
   *
   * <pre>
   * Service for managing generator evaluations.
   * </pre>
   */
  public static final class GeneratorEvaluationsFutureStub
      extends io.grpc.stub.AbstractFutureStub<GeneratorEvaluationsFutureStub> {
    private GeneratorEvaluationsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeneratorEvaluationsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeneratorEvaluationsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates evaluation of a generator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGeneratorEvaluation(
            com.google.cloud.dialogflow.v2.CreateGeneratorEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGeneratorEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an evaluation of generator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.GeneratorEvaluation>
        getGeneratorEvaluation(
            com.google.cloud.dialogflow.v2.GetGeneratorEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGeneratorEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists evaluations of generator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsResponse>
        listGeneratorEvaluations(
            com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGeneratorEvaluationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an evaluation of generator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteGeneratorEvaluation(
            com.google.cloud.dialogflow.v2.DeleteGeneratorEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGeneratorEvaluationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_GENERATOR_EVALUATION = 0;
  private static final int METHODID_GET_GENERATOR_EVALUATION = 1;
  private static final int METHODID_LIST_GENERATOR_EVALUATIONS = 2;
  private static final int METHODID_DELETE_GENERATOR_EVALUATION = 3;

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
        case METHODID_CREATE_GENERATOR_EVALUATION:
          serviceImpl.createGeneratorEvaluation(
              (com.google.cloud.dialogflow.v2.CreateGeneratorEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_GENERATOR_EVALUATION:
          serviceImpl.getGeneratorEvaluation(
              (com.google.cloud.dialogflow.v2.GetGeneratorEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.GeneratorEvaluation>)
                  responseObserver);
          break;
        case METHODID_LIST_GENERATOR_EVALUATIONS:
          serviceImpl.listGeneratorEvaluations(
              (com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_GENERATOR_EVALUATION:
          serviceImpl.deleteGeneratorEvaluation(
              (com.google.cloud.dialogflow.v2.DeleteGeneratorEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getCreateGeneratorEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.CreateGeneratorEvaluationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_GENERATOR_EVALUATION)))
        .addMethod(
            getGetGeneratorEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.GetGeneratorEvaluationRequest,
                    com.google.cloud.dialogflow.v2.GeneratorEvaluation>(
                    service, METHODID_GET_GENERATOR_EVALUATION)))
        .addMethod(
            getListGeneratorEvaluationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsRequest,
                    com.google.cloud.dialogflow.v2.ListGeneratorEvaluationsResponse>(
                    service, METHODID_LIST_GENERATOR_EVALUATIONS)))
        .addMethod(
            getDeleteGeneratorEvaluationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.DeleteGeneratorEvaluationRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_GENERATOR_EVALUATION)))
        .build();
  }

  private abstract static class GeneratorEvaluationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GeneratorEvaluationsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.GeneratorEvaluationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GeneratorEvaluations");
    }
  }

  private static final class GeneratorEvaluationsFileDescriptorSupplier
      extends GeneratorEvaluationsBaseDescriptorSupplier {
    GeneratorEvaluationsFileDescriptorSupplier() {}
  }

  private static final class GeneratorEvaluationsMethodDescriptorSupplier
      extends GeneratorEvaluationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GeneratorEvaluationsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GeneratorEvaluationsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GeneratorEvaluationsFileDescriptorSupplier())
                      .addMethod(getCreateGeneratorEvaluationMethod())
                      .addMethod(getGetGeneratorEvaluationMethod())
                      .addMethod(getListGeneratorEvaluationsMethod())
                      .addMethod(getDeleteGeneratorEvaluationMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
