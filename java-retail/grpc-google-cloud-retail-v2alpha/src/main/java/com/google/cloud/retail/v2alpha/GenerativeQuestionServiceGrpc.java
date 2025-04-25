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
package com.google.cloud.retail.v2alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing LLM generated questions in search serving.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/retail/v2alpha/generative_question_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GenerativeQuestionServiceGrpc {

  private GenerativeQuestionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.retail.v2alpha.GenerativeQuestionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionsFeatureConfigRequest,
          com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
      getUpdateGenerativeQuestionsFeatureConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGenerativeQuestionsFeatureConfig",
      requestType =
          com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionsFeatureConfigRequest.class,
      responseType = com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionsFeatureConfigRequest,
          com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
      getUpdateGenerativeQuestionsFeatureConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionsFeatureConfigRequest,
            com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
        getUpdateGenerativeQuestionsFeatureConfigMethod;
    if ((getUpdateGenerativeQuestionsFeatureConfigMethod =
            GenerativeQuestionServiceGrpc.getUpdateGenerativeQuestionsFeatureConfigMethod)
        == null) {
      synchronized (GenerativeQuestionServiceGrpc.class) {
        if ((getUpdateGenerativeQuestionsFeatureConfigMethod =
                GenerativeQuestionServiceGrpc.getUpdateGenerativeQuestionsFeatureConfigMethod)
            == null) {
          GenerativeQuestionServiceGrpc.getUpdateGenerativeQuestionsFeatureConfigMethod =
              getUpdateGenerativeQuestionsFeatureConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha
                              .UpdateGenerativeQuestionsFeatureConfigRequest,
                          com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "UpdateGenerativeQuestionsFeatureConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha
                                  .UpdateGenerativeQuestionsFeatureConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenerativeQuestionServiceMethodDescriptorSupplier(
                              "UpdateGenerativeQuestionsFeatureConfig"))
                      .build();
        }
      }
    }
    return getUpdateGenerativeQuestionsFeatureConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.GetGenerativeQuestionsFeatureConfigRequest,
          com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
      getGetGenerativeQuestionsFeatureConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGenerativeQuestionsFeatureConfig",
      requestType =
          com.google.cloud.retail.v2alpha.GetGenerativeQuestionsFeatureConfigRequest.class,
      responseType = com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.GetGenerativeQuestionsFeatureConfigRequest,
          com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
      getGetGenerativeQuestionsFeatureConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.GetGenerativeQuestionsFeatureConfigRequest,
            com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
        getGetGenerativeQuestionsFeatureConfigMethod;
    if ((getGetGenerativeQuestionsFeatureConfigMethod =
            GenerativeQuestionServiceGrpc.getGetGenerativeQuestionsFeatureConfigMethod)
        == null) {
      synchronized (GenerativeQuestionServiceGrpc.class) {
        if ((getGetGenerativeQuestionsFeatureConfigMethod =
                GenerativeQuestionServiceGrpc.getGetGenerativeQuestionsFeatureConfigMethod)
            == null) {
          GenerativeQuestionServiceGrpc.getGetGenerativeQuestionsFeatureConfigMethod =
              getGetGenerativeQuestionsFeatureConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.GetGenerativeQuestionsFeatureConfigRequest,
                          com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetGenerativeQuestionsFeatureConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha
                                  .GetGenerativeQuestionsFeatureConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenerativeQuestionServiceMethodDescriptorSupplier(
                              "GetGenerativeQuestionsFeatureConfig"))
                      .build();
        }
      }
    }
    return getGetGenerativeQuestionsFeatureConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsRequest,
          com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsResponse>
      getListGenerativeQuestionConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGenerativeQuestionConfigs",
      requestType = com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsRequest.class,
      responseType = com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsRequest,
          com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsResponse>
      getListGenerativeQuestionConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsRequest,
            com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsResponse>
        getListGenerativeQuestionConfigsMethod;
    if ((getListGenerativeQuestionConfigsMethod =
            GenerativeQuestionServiceGrpc.getListGenerativeQuestionConfigsMethod)
        == null) {
      synchronized (GenerativeQuestionServiceGrpc.class) {
        if ((getListGenerativeQuestionConfigsMethod =
                GenerativeQuestionServiceGrpc.getListGenerativeQuestionConfigsMethod)
            == null) {
          GenerativeQuestionServiceGrpc.getListGenerativeQuestionConfigsMethod =
              getListGenerativeQuestionConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsRequest,
                          com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListGenerativeQuestionConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenerativeQuestionServiceMethodDescriptorSupplier(
                              "ListGenerativeQuestionConfigs"))
                      .build();
        }
      }
    }
    return getListGenerativeQuestionConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionConfigRequest,
          com.google.cloud.retail.v2alpha.GenerativeQuestionConfig>
      getUpdateGenerativeQuestionConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGenerativeQuestionConfig",
      requestType = com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionConfigRequest.class,
      responseType = com.google.cloud.retail.v2alpha.GenerativeQuestionConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionConfigRequest,
          com.google.cloud.retail.v2alpha.GenerativeQuestionConfig>
      getUpdateGenerativeQuestionConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionConfigRequest,
            com.google.cloud.retail.v2alpha.GenerativeQuestionConfig>
        getUpdateGenerativeQuestionConfigMethod;
    if ((getUpdateGenerativeQuestionConfigMethod =
            GenerativeQuestionServiceGrpc.getUpdateGenerativeQuestionConfigMethod)
        == null) {
      synchronized (GenerativeQuestionServiceGrpc.class) {
        if ((getUpdateGenerativeQuestionConfigMethod =
                GenerativeQuestionServiceGrpc.getUpdateGenerativeQuestionConfigMethod)
            == null) {
          GenerativeQuestionServiceGrpc.getUpdateGenerativeQuestionConfigMethod =
              getUpdateGenerativeQuestionConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionConfigRequest,
                          com.google.cloud.retail.v2alpha.GenerativeQuestionConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateGenerativeQuestionConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.GenerativeQuestionConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenerativeQuestionServiceMethodDescriptorSupplier(
                              "UpdateGenerativeQuestionConfig"))
                      .build();
        }
      }
    }
    return getUpdateGenerativeQuestionConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsRequest,
          com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsResponse>
      getBatchUpdateGenerativeQuestionConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateGenerativeQuestionConfigs",
      requestType =
          com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsRequest.class,
      responseType =
          com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsRequest,
          com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsResponse>
      getBatchUpdateGenerativeQuestionConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsRequest,
            com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsResponse>
        getBatchUpdateGenerativeQuestionConfigsMethod;
    if ((getBatchUpdateGenerativeQuestionConfigsMethod =
            GenerativeQuestionServiceGrpc.getBatchUpdateGenerativeQuestionConfigsMethod)
        == null) {
      synchronized (GenerativeQuestionServiceGrpc.class) {
        if ((getBatchUpdateGenerativeQuestionConfigsMethod =
                GenerativeQuestionServiceGrpc.getBatchUpdateGenerativeQuestionConfigsMethod)
            == null) {
          GenerativeQuestionServiceGrpc.getBatchUpdateGenerativeQuestionConfigsMethod =
              getBatchUpdateGenerativeQuestionConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsRequest,
                          com.google.cloud.retail.v2alpha
                              .BatchUpdateGenerativeQuestionConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "BatchUpdateGenerativeQuestionConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha
                                  .BatchUpdateGenerativeQuestionConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha
                                  .BatchUpdateGenerativeQuestionConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenerativeQuestionServiceMethodDescriptorSupplier(
                              "BatchUpdateGenerativeQuestionConfigs"))
                      .build();
        }
      }
    }
    return getBatchUpdateGenerativeQuestionConfigsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GenerativeQuestionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GenerativeQuestionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GenerativeQuestionServiceStub>() {
          @java.lang.Override
          public GenerativeQuestionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GenerativeQuestionServiceStub(channel, callOptions);
          }
        };
    return GenerativeQuestionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GenerativeQuestionServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GenerativeQuestionServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GenerativeQuestionServiceBlockingStub>() {
          @java.lang.Override
          public GenerativeQuestionServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GenerativeQuestionServiceBlockingStub(channel, callOptions);
          }
        };
    return GenerativeQuestionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GenerativeQuestionServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GenerativeQuestionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GenerativeQuestionServiceFutureStub>() {
          @java.lang.Override
          public GenerativeQuestionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GenerativeQuestionServiceFutureStub(channel, callOptions);
          }
        };
    return GenerativeQuestionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing LLM generated questions in search serving.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Manages overal generative question feature state -- enables toggling
     * feature on and off.
     * </pre>
     */
    default void updateGenerativeQuestionsFeatureConfig(
        com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionsFeatureConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGenerativeQuestionsFeatureConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Manages overal generative question feature state -- enables toggling
     * feature on and off.
     * </pre>
     */
    default void getGenerativeQuestionsFeatureConfig(
        com.google.cloud.retail.v2alpha.GetGenerativeQuestionsFeatureConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGenerativeQuestionsFeatureConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all questions for a given catalog.
     * </pre>
     */
    default void listGenerativeQuestionConfigs(
        com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGenerativeQuestionConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Allows management of individual questions.
     * </pre>
     */
    default void updateGenerativeQuestionConfig(
        com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.GenerativeQuestionConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGenerativeQuestionConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Allows management of multiple questions.
     * </pre>
     */
    default void batchUpdateGenerativeQuestionConfigs(
        com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchUpdateGenerativeQuestionConfigsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GenerativeQuestionService.
   *
   * <pre>
   * Service for managing LLM generated questions in search serving.
   * </pre>
   */
  public abstract static class GenerativeQuestionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return GenerativeQuestionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GenerativeQuestionService.
   *
   * <pre>
   * Service for managing LLM generated questions in search serving.
   * </pre>
   */
  public static final class GenerativeQuestionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GenerativeQuestionServiceStub> {
    private GenerativeQuestionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GenerativeQuestionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GenerativeQuestionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Manages overal generative question feature state -- enables toggling
     * feature on and off.
     * </pre>
     */
    public void updateGenerativeQuestionsFeatureConfig(
        com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionsFeatureConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGenerativeQuestionsFeatureConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Manages overal generative question feature state -- enables toggling
     * feature on and off.
     * </pre>
     */
    public void getGenerativeQuestionsFeatureConfig(
        com.google.cloud.retail.v2alpha.GetGenerativeQuestionsFeatureConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGenerativeQuestionsFeatureConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all questions for a given catalog.
     * </pre>
     */
    public void listGenerativeQuestionConfigs(
        com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGenerativeQuestionConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Allows management of individual questions.
     * </pre>
     */
    public void updateGenerativeQuestionConfig(
        com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.GenerativeQuestionConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGenerativeQuestionConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Allows management of multiple questions.
     * </pre>
     */
    public void batchUpdateGenerativeQuestionConfigs(
        com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateGenerativeQuestionConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GenerativeQuestionService.
   *
   * <pre>
   * Service for managing LLM generated questions in search serving.
   * </pre>
   */
  public static final class GenerativeQuestionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GenerativeQuestionServiceBlockingStub> {
    private GenerativeQuestionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GenerativeQuestionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GenerativeQuestionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Manages overal generative question feature state -- enables toggling
     * feature on and off.
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig
        updateGenerativeQuestionsFeatureConfig(
            com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionsFeatureConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getUpdateGenerativeQuestionsFeatureConfigMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Manages overal generative question feature state -- enables toggling
     * feature on and off.
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig
        getGenerativeQuestionsFeatureConfig(
            com.google.cloud.retail.v2alpha.GetGenerativeQuestionsFeatureConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGenerativeQuestionsFeatureConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all questions for a given catalog.
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsResponse
        listGenerativeQuestionConfigs(
            com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGenerativeQuestionConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Allows management of individual questions.
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.GenerativeQuestionConfig updateGenerativeQuestionConfig(
        com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGenerativeQuestionConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Allows management of multiple questions.
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsResponse
        batchUpdateGenerativeQuestionConfigs(
            com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateGenerativeQuestionConfigsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * GenerativeQuestionService.
   *
   * <pre>
   * Service for managing LLM generated questions in search serving.
   * </pre>
   */
  public static final class GenerativeQuestionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GenerativeQuestionServiceFutureStub> {
    private GenerativeQuestionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GenerativeQuestionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GenerativeQuestionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Manages overal generative question feature state -- enables toggling
     * feature on and off.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
        updateGenerativeQuestionsFeatureConfig(
            com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionsFeatureConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGenerativeQuestionsFeatureConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Manages overal generative question feature state -- enables toggling
     * feature on and off.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>
        getGenerativeQuestionsFeatureConfig(
            com.google.cloud.retail.v2alpha.GetGenerativeQuestionsFeatureConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGenerativeQuestionsFeatureConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns all questions for a given catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsResponse>
        listGenerativeQuestionConfigs(
            com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGenerativeQuestionConfigsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Allows management of individual questions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.GenerativeQuestionConfig>
        updateGenerativeQuestionConfig(
            com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGenerativeQuestionConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Allows management of multiple questions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsResponse>
        batchUpdateGenerativeQuestionConfigs(
            com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateGenerativeQuestionConfigsMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_UPDATE_GENERATIVE_QUESTIONS_FEATURE_CONFIG = 0;
  private static final int METHODID_GET_GENERATIVE_QUESTIONS_FEATURE_CONFIG = 1;
  private static final int METHODID_LIST_GENERATIVE_QUESTION_CONFIGS = 2;
  private static final int METHODID_UPDATE_GENERATIVE_QUESTION_CONFIG = 3;
  private static final int METHODID_BATCH_UPDATE_GENERATIVE_QUESTION_CONFIGS = 4;

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
        case METHODID_UPDATE_GENERATIVE_QUESTIONS_FEATURE_CONFIG:
          serviceImpl.updateGenerativeQuestionsFeatureConfig(
              (com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionsFeatureConfigRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>)
                  responseObserver);
          break;
        case METHODID_GET_GENERATIVE_QUESTIONS_FEATURE_CONFIG:
          serviceImpl.getGenerativeQuestionsFeatureConfig(
              (com.google.cloud.retail.v2alpha.GetGenerativeQuestionsFeatureConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_GENERATIVE_QUESTION_CONFIGS:
          serviceImpl.listGenerativeQuestionConfigs(
              (com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_GENERATIVE_QUESTION_CONFIG:
          serviceImpl.updateGenerativeQuestionConfig(
              (com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.retail.v2alpha.GenerativeQuestionConfig>)
                  responseObserver);
          break;
        case METHODID_BATCH_UPDATE_GENERATIVE_QUESTION_CONFIGS:
          serviceImpl.batchUpdateGenerativeQuestionConfigs(
              (com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsResponse>)
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
            getUpdateGenerativeQuestionsFeatureConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionsFeatureConfigRequest,
                    com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>(
                    service, METHODID_UPDATE_GENERATIVE_QUESTIONS_FEATURE_CONFIG)))
        .addMethod(
            getGetGenerativeQuestionsFeatureConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.GetGenerativeQuestionsFeatureConfigRequest,
                    com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig>(
                    service, METHODID_GET_GENERATIVE_QUESTIONS_FEATURE_CONFIG)))
        .addMethod(
            getListGenerativeQuestionConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsRequest,
                    com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsResponse>(
                    service, METHODID_LIST_GENERATIVE_QUESTION_CONFIGS)))
        .addMethod(
            getUpdateGenerativeQuestionConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionConfigRequest,
                    com.google.cloud.retail.v2alpha.GenerativeQuestionConfig>(
                    service, METHODID_UPDATE_GENERATIVE_QUESTION_CONFIG)))
        .addMethod(
            getBatchUpdateGenerativeQuestionConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsRequest,
                    com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsResponse>(
                    service, METHODID_BATCH_UPDATE_GENERATIVE_QUESTION_CONFIGS)))
        .build();
  }

  private abstract static class GenerativeQuestionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GenerativeQuestionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.retail.v2alpha.GenerativeQuestionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GenerativeQuestionService");
    }
  }

  private static final class GenerativeQuestionServiceFileDescriptorSupplier
      extends GenerativeQuestionServiceBaseDescriptorSupplier {
    GenerativeQuestionServiceFileDescriptorSupplier() {}
  }

  private static final class GenerativeQuestionServiceMethodDescriptorSupplier
      extends GenerativeQuestionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GenerativeQuestionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GenerativeQuestionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GenerativeQuestionServiceFileDescriptorSupplier())
                      .addMethod(getUpdateGenerativeQuestionsFeatureConfigMethod())
                      .addMethod(getGetGenerativeQuestionsFeatureConfigMethod())
                      .addMethod(getListGenerativeQuestionConfigsMethod())
                      .addMethod(getUpdateGenerativeQuestionConfigMethod())
                      .addMethod(getBatchUpdateGenerativeQuestionConfigsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
