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
package com.google.cloud.dialogflow.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Generator Service for LLM powered Agent Assist. This service manages the
 * configurations of user owned Generators, such as description, context and
 * instruction, input/output format, etc. The generator resources will be used
 * inside a conversation and will be triggered by TriggerEvent to query LLM for
 * answers.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/generator.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GeneratorsGrpc {

  private GeneratorsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dialogflow.v2.Generators";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateGeneratorRequest,
          com.google.cloud.dialogflow.v2.Generator>
      getCreateGeneratorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGenerator",
      requestType = com.google.cloud.dialogflow.v2.CreateGeneratorRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Generator.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateGeneratorRequest,
          com.google.cloud.dialogflow.v2.Generator>
      getCreateGeneratorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.CreateGeneratorRequest,
            com.google.cloud.dialogflow.v2.Generator>
        getCreateGeneratorMethod;
    if ((getCreateGeneratorMethod = GeneratorsGrpc.getCreateGeneratorMethod) == null) {
      synchronized (GeneratorsGrpc.class) {
        if ((getCreateGeneratorMethod = GeneratorsGrpc.getCreateGeneratorMethod) == null) {
          GeneratorsGrpc.getCreateGeneratorMethod =
              getCreateGeneratorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.CreateGeneratorRequest,
                          com.google.cloud.dialogflow.v2.Generator>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGenerator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.CreateGeneratorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Generator.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GeneratorsMethodDescriptorSupplier("CreateGenerator"))
                      .build();
        }
      }
    }
    return getCreateGeneratorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetGeneratorRequest,
          com.google.cloud.dialogflow.v2.Generator>
      getGetGeneratorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGenerator",
      requestType = com.google.cloud.dialogflow.v2.GetGeneratorRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Generator.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetGeneratorRequest,
          com.google.cloud.dialogflow.v2.Generator>
      getGetGeneratorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.GetGeneratorRequest,
            com.google.cloud.dialogflow.v2.Generator>
        getGetGeneratorMethod;
    if ((getGetGeneratorMethod = GeneratorsGrpc.getGetGeneratorMethod) == null) {
      synchronized (GeneratorsGrpc.class) {
        if ((getGetGeneratorMethod = GeneratorsGrpc.getGetGeneratorMethod) == null) {
          GeneratorsGrpc.getGetGeneratorMethod =
              getGetGeneratorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.GetGeneratorRequest,
                          com.google.cloud.dialogflow.v2.Generator>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGenerator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GetGeneratorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Generator.getDefaultInstance()))
                      .setSchemaDescriptor(new GeneratorsMethodDescriptorSupplier("GetGenerator"))
                      .build();
        }
      }
    }
    return getGetGeneratorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListGeneratorsRequest,
          com.google.cloud.dialogflow.v2.ListGeneratorsResponse>
      getListGeneratorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGenerators",
      requestType = com.google.cloud.dialogflow.v2.ListGeneratorsRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListGeneratorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListGeneratorsRequest,
          com.google.cloud.dialogflow.v2.ListGeneratorsResponse>
      getListGeneratorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.ListGeneratorsRequest,
            com.google.cloud.dialogflow.v2.ListGeneratorsResponse>
        getListGeneratorsMethod;
    if ((getListGeneratorsMethod = GeneratorsGrpc.getListGeneratorsMethod) == null) {
      synchronized (GeneratorsGrpc.class) {
        if ((getListGeneratorsMethod = GeneratorsGrpc.getListGeneratorsMethod) == null) {
          GeneratorsGrpc.getListGeneratorsMethod =
              getListGeneratorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.ListGeneratorsRequest,
                          com.google.cloud.dialogflow.v2.ListGeneratorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGenerators"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListGeneratorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListGeneratorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new GeneratorsMethodDescriptorSupplier("ListGenerators"))
                      .build();
        }
      }
    }
    return getListGeneratorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteGeneratorRequest, com.google.protobuf.Empty>
      getDeleteGeneratorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGenerator",
      requestType = com.google.cloud.dialogflow.v2.DeleteGeneratorRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteGeneratorRequest, com.google.protobuf.Empty>
      getDeleteGeneratorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.DeleteGeneratorRequest, com.google.protobuf.Empty>
        getDeleteGeneratorMethod;
    if ((getDeleteGeneratorMethod = GeneratorsGrpc.getDeleteGeneratorMethod) == null) {
      synchronized (GeneratorsGrpc.class) {
        if ((getDeleteGeneratorMethod = GeneratorsGrpc.getDeleteGeneratorMethod) == null) {
          GeneratorsGrpc.getDeleteGeneratorMethod =
              getDeleteGeneratorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.DeleteGeneratorRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGenerator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.DeleteGeneratorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GeneratorsMethodDescriptorSupplier("DeleteGenerator"))
                      .build();
        }
      }
    }
    return getDeleteGeneratorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateGeneratorRequest,
          com.google.cloud.dialogflow.v2.Generator>
      getUpdateGeneratorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGenerator",
      requestType = com.google.cloud.dialogflow.v2.UpdateGeneratorRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Generator.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateGeneratorRequest,
          com.google.cloud.dialogflow.v2.Generator>
      getUpdateGeneratorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.UpdateGeneratorRequest,
            com.google.cloud.dialogflow.v2.Generator>
        getUpdateGeneratorMethod;
    if ((getUpdateGeneratorMethod = GeneratorsGrpc.getUpdateGeneratorMethod) == null) {
      synchronized (GeneratorsGrpc.class) {
        if ((getUpdateGeneratorMethod = GeneratorsGrpc.getUpdateGeneratorMethod) == null) {
          GeneratorsGrpc.getUpdateGeneratorMethod =
              getUpdateGeneratorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.UpdateGeneratorRequest,
                          com.google.cloud.dialogflow.v2.Generator>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGenerator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.UpdateGeneratorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Generator.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GeneratorsMethodDescriptorSupplier("UpdateGenerator"))
                      .build();
        }
      }
    }
    return getUpdateGeneratorMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GeneratorsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeneratorsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GeneratorsStub>() {
          @java.lang.Override
          public GeneratorsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GeneratorsStub(channel, callOptions);
          }
        };
    return GeneratorsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GeneratorsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeneratorsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GeneratorsBlockingStub>() {
          @java.lang.Override
          public GeneratorsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GeneratorsBlockingStub(channel, callOptions);
          }
        };
    return GeneratorsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GeneratorsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeneratorsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GeneratorsFutureStub>() {
          @java.lang.Override
          public GeneratorsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GeneratorsFutureStub(channel, callOptions);
          }
        };
    return GeneratorsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Generator Service for LLM powered Agent Assist. This service manages the
   * configurations of user owned Generators, such as description, context and
   * instruction, input/output format, etc. The generator resources will be used
   * inside a conversation and will be triggered by TriggerEvent to query LLM for
   * answers.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a generator.
     * </pre>
     */
    default void createGenerator(
        com.google.cloud.dialogflow.v2.CreateGeneratorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Generator> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGeneratorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a generator.
     * </pre>
     */
    default void getGenerator(
        com.google.cloud.dialogflow.v2.GetGeneratorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Generator> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGeneratorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists generators.
     * </pre>
     */
    default void listGenerators(
        com.google.cloud.dialogflow.v2.ListGeneratorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListGeneratorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGeneratorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a generator.
     * </pre>
     */
    default void deleteGenerator(
        com.google.cloud.dialogflow.v2.DeleteGeneratorRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGeneratorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a generator.
     * </pre>
     */
    default void updateGenerator(
        com.google.cloud.dialogflow.v2.UpdateGeneratorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Generator> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGeneratorMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Generators.
   *
   * <pre>
   * Generator Service for LLM powered Agent Assist. This service manages the
   * configurations of user owned Generators, such as description, context and
   * instruction, input/output format, etc. The generator resources will be used
   * inside a conversation and will be triggered by TriggerEvent to query LLM for
   * answers.
   * </pre>
   */
  public abstract static class GeneratorsImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return GeneratorsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Generators.
   *
   * <pre>
   * Generator Service for LLM powered Agent Assist. This service manages the
   * configurations of user owned Generators, such as description, context and
   * instruction, input/output format, etc. The generator resources will be used
   * inside a conversation and will be triggered by TriggerEvent to query LLM for
   * answers.
   * </pre>
   */
  public static final class GeneratorsStub extends io.grpc.stub.AbstractAsyncStub<GeneratorsStub> {
    private GeneratorsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeneratorsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeneratorsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a generator.
     * </pre>
     */
    public void createGenerator(
        com.google.cloud.dialogflow.v2.CreateGeneratorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Generator> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGeneratorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a generator.
     * </pre>
     */
    public void getGenerator(
        com.google.cloud.dialogflow.v2.GetGeneratorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Generator> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGeneratorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists generators.
     * </pre>
     */
    public void listGenerators(
        com.google.cloud.dialogflow.v2.ListGeneratorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListGeneratorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGeneratorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a generator.
     * </pre>
     */
    public void deleteGenerator(
        com.google.cloud.dialogflow.v2.DeleteGeneratorRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGeneratorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a generator.
     * </pre>
     */
    public void updateGenerator(
        com.google.cloud.dialogflow.v2.UpdateGeneratorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Generator> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGeneratorMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Generators.
   *
   * <pre>
   * Generator Service for LLM powered Agent Assist. This service manages the
   * configurations of user owned Generators, such as description, context and
   * instruction, input/output format, etc. The generator resources will be used
   * inside a conversation and will be triggered by TriggerEvent to query LLM for
   * answers.
   * </pre>
   */
  public static final class GeneratorsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GeneratorsBlockingStub> {
    private GeneratorsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeneratorsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeneratorsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a generator.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Generator createGenerator(
        com.google.cloud.dialogflow.v2.CreateGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGeneratorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a generator.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Generator getGenerator(
        com.google.cloud.dialogflow.v2.GetGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGeneratorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists generators.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListGeneratorsResponse listGenerators(
        com.google.cloud.dialogflow.v2.ListGeneratorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGeneratorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a generator.
     * </pre>
     */
    public com.google.protobuf.Empty deleteGenerator(
        com.google.cloud.dialogflow.v2.DeleteGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGeneratorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a generator.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Generator updateGenerator(
        com.google.cloud.dialogflow.v2.UpdateGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGeneratorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Generators.
   *
   * <pre>
   * Generator Service for LLM powered Agent Assist. This service manages the
   * configurations of user owned Generators, such as description, context and
   * instruction, input/output format, etc. The generator resources will be used
   * inside a conversation and will be triggered by TriggerEvent to query LLM for
   * answers.
   * </pre>
   */
  public static final class GeneratorsFutureStub
      extends io.grpc.stub.AbstractFutureStub<GeneratorsFutureStub> {
    private GeneratorsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeneratorsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeneratorsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a generator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Generator>
        createGenerator(com.google.cloud.dialogflow.v2.CreateGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGeneratorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a generator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Generator>
        getGenerator(com.google.cloud.dialogflow.v2.GetGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGeneratorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists generators.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.ListGeneratorsResponse>
        listGenerators(com.google.cloud.dialogflow.v2.ListGeneratorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGeneratorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a generator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteGenerator(com.google.cloud.dialogflow.v2.DeleteGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGeneratorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a generator.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Generator>
        updateGenerator(com.google.cloud.dialogflow.v2.UpdateGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGeneratorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_GENERATOR = 0;
  private static final int METHODID_GET_GENERATOR = 1;
  private static final int METHODID_LIST_GENERATORS = 2;
  private static final int METHODID_DELETE_GENERATOR = 3;
  private static final int METHODID_UPDATE_GENERATOR = 4;

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
        case METHODID_CREATE_GENERATOR:
          serviceImpl.createGenerator(
              (com.google.cloud.dialogflow.v2.CreateGeneratorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Generator>)
                  responseObserver);
          break;
        case METHODID_GET_GENERATOR:
          serviceImpl.getGenerator(
              (com.google.cloud.dialogflow.v2.GetGeneratorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Generator>)
                  responseObserver);
          break;
        case METHODID_LIST_GENERATORS:
          serviceImpl.listGenerators(
              (com.google.cloud.dialogflow.v2.ListGeneratorsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListGeneratorsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_GENERATOR:
          serviceImpl.deleteGenerator(
              (com.google.cloud.dialogflow.v2.DeleteGeneratorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_GENERATOR:
          serviceImpl.updateGenerator(
              (com.google.cloud.dialogflow.v2.UpdateGeneratorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Generator>)
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
            getCreateGeneratorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.CreateGeneratorRequest,
                    com.google.cloud.dialogflow.v2.Generator>(service, METHODID_CREATE_GENERATOR)))
        .addMethod(
            getGetGeneratorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.GetGeneratorRequest,
                    com.google.cloud.dialogflow.v2.Generator>(service, METHODID_GET_GENERATOR)))
        .addMethod(
            getListGeneratorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.ListGeneratorsRequest,
                    com.google.cloud.dialogflow.v2.ListGeneratorsResponse>(
                    service, METHODID_LIST_GENERATORS)))
        .addMethod(
            getDeleteGeneratorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.DeleteGeneratorRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_GENERATOR)))
        .addMethod(
            getUpdateGeneratorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.UpdateGeneratorRequest,
                    com.google.cloud.dialogflow.v2.Generator>(service, METHODID_UPDATE_GENERATOR)))
        .build();
  }

  private abstract static class GeneratorsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GeneratorsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.GeneratorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Generators");
    }
  }

  private static final class GeneratorsFileDescriptorSupplier
      extends GeneratorsBaseDescriptorSupplier {
    GeneratorsFileDescriptorSupplier() {}
  }

  private static final class GeneratorsMethodDescriptorSupplier
      extends GeneratorsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GeneratorsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GeneratorsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GeneratorsFileDescriptorSupplier())
                      .addMethod(getCreateGeneratorMethod())
                      .addMethod(getGetGeneratorMethod())
                      .addMethod(getListGeneratorsMethod())
                      .addMethod(getDeleteGeneratorMethod())
                      .addMethod(getUpdateGeneratorMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
