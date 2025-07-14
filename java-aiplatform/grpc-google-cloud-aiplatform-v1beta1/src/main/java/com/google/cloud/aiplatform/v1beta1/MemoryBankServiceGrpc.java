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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for managing memories for LLM applications.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/memory_bank_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MemoryBankServiceGrpc {

  private MemoryBankServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.MemoryBankService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest, com.google.longrunning.Operation>
      getCreateMemoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMemory",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest, com.google.longrunning.Operation>
      getCreateMemoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest,
            com.google.longrunning.Operation>
        getCreateMemoryMethod;
    if ((getCreateMemoryMethod = MemoryBankServiceGrpc.getCreateMemoryMethod) == null) {
      synchronized (MemoryBankServiceGrpc.class) {
        if ((getCreateMemoryMethod = MemoryBankServiceGrpc.getCreateMemoryMethod) == null) {
          MemoryBankServiceGrpc.getCreateMemoryMethod =
              getCreateMemoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMemory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemoryBankServiceMethodDescriptorSupplier("CreateMemory"))
                      .build();
        }
      }
    }
    return getCreateMemoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetMemoryRequest,
          com.google.cloud.aiplatform.v1beta1.Memory>
      getGetMemoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMemory",
      requestType = com.google.cloud.aiplatform.v1beta1.GetMemoryRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Memory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetMemoryRequest,
          com.google.cloud.aiplatform.v1beta1.Memory>
      getGetMemoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetMemoryRequest,
            com.google.cloud.aiplatform.v1beta1.Memory>
        getGetMemoryMethod;
    if ((getGetMemoryMethod = MemoryBankServiceGrpc.getGetMemoryMethod) == null) {
      synchronized (MemoryBankServiceGrpc.class) {
        if ((getGetMemoryMethod = MemoryBankServiceGrpc.getGetMemoryMethod) == null) {
          MemoryBankServiceGrpc.getGetMemoryMethod =
              getGetMemoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetMemoryRequest,
                          com.google.cloud.aiplatform.v1beta1.Memory>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMemory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetMemoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Memory.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemoryBankServiceMethodDescriptorSupplier("GetMemory"))
                      .build();
        }
      }
    }
    return getGetMemoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest, com.google.longrunning.Operation>
      getUpdateMemoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMemory",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest, com.google.longrunning.Operation>
      getUpdateMemoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest,
            com.google.longrunning.Operation>
        getUpdateMemoryMethod;
    if ((getUpdateMemoryMethod = MemoryBankServiceGrpc.getUpdateMemoryMethod) == null) {
      synchronized (MemoryBankServiceGrpc.class) {
        if ((getUpdateMemoryMethod = MemoryBankServiceGrpc.getUpdateMemoryMethod) == null) {
          MemoryBankServiceGrpc.getUpdateMemoryMethod =
              getUpdateMemoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMemory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemoryBankServiceMethodDescriptorSupplier("UpdateMemory"))
                      .build();
        }
      }
    }
    return getUpdateMemoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest,
          com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse>
      getListMemoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMemories",
      requestType = com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest,
          com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse>
      getListMemoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest,
            com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse>
        getListMemoriesMethod;
    if ((getListMemoriesMethod = MemoryBankServiceGrpc.getListMemoriesMethod) == null) {
      synchronized (MemoryBankServiceGrpc.class) {
        if ((getListMemoriesMethod = MemoryBankServiceGrpc.getListMemoriesMethod) == null) {
          MemoryBankServiceGrpc.getListMemoriesMethod =
              getListMemoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest,
                          com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMemories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemoryBankServiceMethodDescriptorSupplier("ListMemories"))
                      .build();
        }
      }
    }
    return getListMemoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest, com.google.longrunning.Operation>
      getDeleteMemoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMemory",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest, com.google.longrunning.Operation>
      getDeleteMemoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest,
            com.google.longrunning.Operation>
        getDeleteMemoryMethod;
    if ((getDeleteMemoryMethod = MemoryBankServiceGrpc.getDeleteMemoryMethod) == null) {
      synchronized (MemoryBankServiceGrpc.class) {
        if ((getDeleteMemoryMethod = MemoryBankServiceGrpc.getDeleteMemoryMethod) == null) {
          MemoryBankServiceGrpc.getDeleteMemoryMethod =
              getDeleteMemoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMemory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemoryBankServiceMethodDescriptorSupplier("DeleteMemory"))
                      .build();
        }
      }
    }
    return getDeleteMemoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest,
          com.google.longrunning.Operation>
      getGenerateMemoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateMemories",
      requestType = com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest,
          com.google.longrunning.Operation>
      getGenerateMemoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest,
            com.google.longrunning.Operation>
        getGenerateMemoriesMethod;
    if ((getGenerateMemoriesMethod = MemoryBankServiceGrpc.getGenerateMemoriesMethod) == null) {
      synchronized (MemoryBankServiceGrpc.class) {
        if ((getGenerateMemoriesMethod = MemoryBankServiceGrpc.getGenerateMemoriesMethod) == null) {
          MemoryBankServiceGrpc.getGenerateMemoriesMethod =
              getGenerateMemoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateMemories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemoryBankServiceMethodDescriptorSupplier("GenerateMemories"))
                      .build();
        }
      }
    }
    return getGenerateMemoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest,
          com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse>
      getRetrieveMemoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveMemories",
      requestType = com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest,
          com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse>
      getRetrieveMemoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest,
            com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse>
        getRetrieveMemoriesMethod;
    if ((getRetrieveMemoriesMethod = MemoryBankServiceGrpc.getRetrieveMemoriesMethod) == null) {
      synchronized (MemoryBankServiceGrpc.class) {
        if ((getRetrieveMemoriesMethod = MemoryBankServiceGrpc.getRetrieveMemoriesMethod) == null) {
          MemoryBankServiceGrpc.getRetrieveMemoriesMethod =
              getRetrieveMemoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest,
                          com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RetrieveMemories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemoryBankServiceMethodDescriptorSupplier("RetrieveMemories"))
                      .build();
        }
      }
    }
    return getRetrieveMemoriesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MemoryBankServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemoryBankServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MemoryBankServiceStub>() {
          @java.lang.Override
          public MemoryBankServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MemoryBankServiceStub(channel, callOptions);
          }
        };
    return MemoryBankServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static MemoryBankServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemoryBankServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MemoryBankServiceBlockingV2Stub>() {
          @java.lang.Override
          public MemoryBankServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MemoryBankServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return MemoryBankServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MemoryBankServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemoryBankServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MemoryBankServiceBlockingStub>() {
          @java.lang.Override
          public MemoryBankServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MemoryBankServiceBlockingStub(channel, callOptions);
          }
        };
    return MemoryBankServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MemoryBankServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemoryBankServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MemoryBankServiceFutureStub>() {
          @java.lang.Override
          public MemoryBankServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MemoryBankServiceFutureStub(channel, callOptions);
          }
        };
    return MemoryBankServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for managing memories for LLM applications.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create a Memory.
     * </pre>
     */
    default void createMemory(
        com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMemoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a Memory.
     * </pre>
     */
    default void getMemory(
        com.google.cloud.aiplatform.v1beta1.GetMemoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Memory> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMemoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a Memory.
     * </pre>
     */
    default void updateMemory(
        com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMemoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Memories.
     * </pre>
     */
    default void listMemories(
        com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMemoriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a Memory.
     * </pre>
     */
    default void deleteMemory(
        com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMemoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate memories.
     * </pre>
     */
    default void generateMemories(
        com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateMemoriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve memories.
     * </pre>
     */
    default void retrieveMemories(
        com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveMemoriesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MemoryBankService.
   *
   * <pre>
   * A service for managing memories for LLM applications.
   * </pre>
   */
  public abstract static class MemoryBankServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MemoryBankServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MemoryBankService.
   *
   * <pre>
   * A service for managing memories for LLM applications.
   * </pre>
   */
  public static final class MemoryBankServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MemoryBankServiceStub> {
    private MemoryBankServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemoryBankServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemoryBankServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a Memory.
     * </pre>
     */
    public void createMemory(
        com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMemoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a Memory.
     * </pre>
     */
    public void getMemory(
        com.google.cloud.aiplatform.v1beta1.GetMemoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Memory> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMemoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a Memory.
     * </pre>
     */
    public void updateMemory(
        com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMemoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Memories.
     * </pre>
     */
    public void listMemories(
        com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMemoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a Memory.
     * </pre>
     */
    public void deleteMemory(
        com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMemoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate memories.
     * </pre>
     */
    public void generateMemories(
        com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateMemoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve memories.
     * </pre>
     */
    public void retrieveMemories(
        com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveMemoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MemoryBankService.
   *
   * <pre>
   * A service for managing memories for LLM applications.
   * </pre>
   */
  public static final class MemoryBankServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<MemoryBankServiceBlockingV2Stub> {
    private MemoryBankServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemoryBankServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemoryBankServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a Memory.
     * </pre>
     */
    public com.google.longrunning.Operation createMemory(
        com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMemoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a Memory.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Memory getMemory(
        com.google.cloud.aiplatform.v1beta1.GetMemoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMemoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a Memory.
     * </pre>
     */
    public com.google.longrunning.Operation updateMemory(
        com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMemoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List Memories.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse listMemories(
        com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMemoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a Memory.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMemory(
        com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMemoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generate memories.
     * </pre>
     */
    public com.google.longrunning.Operation generateMemories(
        com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateMemoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve memories.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse retrieveMemories(
        com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveMemoriesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service MemoryBankService.
   *
   * <pre>
   * A service for managing memories for LLM applications.
   * </pre>
   */
  public static final class MemoryBankServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MemoryBankServiceBlockingStub> {
    private MemoryBankServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemoryBankServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemoryBankServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a Memory.
     * </pre>
     */
    public com.google.longrunning.Operation createMemory(
        com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMemoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a Memory.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Memory getMemory(
        com.google.cloud.aiplatform.v1beta1.GetMemoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMemoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a Memory.
     * </pre>
     */
    public com.google.longrunning.Operation updateMemory(
        com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMemoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List Memories.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse listMemories(
        com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMemoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a Memory.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMemory(
        com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMemoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generate memories.
     * </pre>
     */
    public com.google.longrunning.Operation generateMemories(
        com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateMemoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve memories.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse retrieveMemories(
        com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveMemoriesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MemoryBankService.
   *
   * <pre>
   * A service for managing memories for LLM applications.
   * </pre>
   */
  public static final class MemoryBankServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MemoryBankServiceFutureStub> {
    private MemoryBankServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemoryBankServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemoryBankServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a Memory.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMemory(com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMemoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a Memory.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Memory>
        getMemory(com.google.cloud.aiplatform.v1beta1.GetMemoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMemoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a Memory.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMemory(com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMemoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List Memories.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse>
        listMemories(com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMemoriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a Memory.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMemory(com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMemoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generate memories.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        generateMemories(com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateMemoriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve memories.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse>
        retrieveMemories(com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveMemoriesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_MEMORY = 0;
  private static final int METHODID_GET_MEMORY = 1;
  private static final int METHODID_UPDATE_MEMORY = 2;
  private static final int METHODID_LIST_MEMORIES = 3;
  private static final int METHODID_DELETE_MEMORY = 4;
  private static final int METHODID_GENERATE_MEMORIES = 5;
  private static final int METHODID_RETRIEVE_MEMORIES = 6;

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
        case METHODID_CREATE_MEMORY:
          serviceImpl.createMemory(
              (com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_MEMORY:
          serviceImpl.getMemory(
              (com.google.cloud.aiplatform.v1beta1.GetMemoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Memory>)
                  responseObserver);
          break;
        case METHODID_UPDATE_MEMORY:
          serviceImpl.updateMemory(
              (com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_MEMORIES:
          serviceImpl.listMemories(
              (com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_MEMORY:
          serviceImpl.deleteMemory(
              (com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_MEMORIES:
          serviceImpl.generateMemories(
              (com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RETRIEVE_MEMORIES:
          serviceImpl.retrieveMemories(
              (com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse>)
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
            getCreateMemoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_MEMORY)))
        .addMethod(
            getGetMemoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetMemoryRequest,
                    com.google.cloud.aiplatform.v1beta1.Memory>(service, METHODID_GET_MEMORY)))
        .addMethod(
            getUpdateMemoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_MEMORY)))
        .addMethod(
            getListMemoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest,
                    com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse>(
                    service, METHODID_LIST_MEMORIES)))
        .addMethod(
            getDeleteMemoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_MEMORY)))
        .addMethod(
            getGenerateMemoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest,
                    com.google.longrunning.Operation>(service, METHODID_GENERATE_MEMORIES)))
        .addMethod(
            getRetrieveMemoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest,
                    com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse>(
                    service, METHODID_RETRIEVE_MEMORIES)))
        .build();
  }

  private abstract static class MemoryBankServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MemoryBankServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.MemoryBankServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MemoryBankService");
    }
  }

  private static final class MemoryBankServiceFileDescriptorSupplier
      extends MemoryBankServiceBaseDescriptorSupplier {
    MemoryBankServiceFileDescriptorSupplier() {}
  }

  private static final class MemoryBankServiceMethodDescriptorSupplier
      extends MemoryBankServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MemoryBankServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MemoryBankServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MemoryBankServiceFileDescriptorSupplier())
                      .addMethod(getCreateMemoryMethod())
                      .addMethod(getGetMemoryMethod())
                      .addMethod(getUpdateMemoryMethod())
                      .addMethod(getListMemoriesMethod())
                      .addMethod(getDeleteMemoryMethod())
                      .addMethod(getGenerateMemoriesMethod())
                      .addMethod(getRetrieveMemoriesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
