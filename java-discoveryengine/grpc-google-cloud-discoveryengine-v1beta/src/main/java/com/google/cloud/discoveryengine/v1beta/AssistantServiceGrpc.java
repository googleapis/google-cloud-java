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
package com.google.cloud.discoveryengine.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing Assistant configuration and assisting users.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AssistantServiceGrpc {

  private AssistantServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1beta.AssistantService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.StreamAssistRequest,
          com.google.cloud.discoveryengine.v1beta.StreamAssistResponse>
      getStreamAssistMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamAssist",
      requestType = com.google.cloud.discoveryengine.v1beta.StreamAssistRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.StreamAssistResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.StreamAssistRequest,
          com.google.cloud.discoveryengine.v1beta.StreamAssistResponse>
      getStreamAssistMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.StreamAssistRequest,
            com.google.cloud.discoveryengine.v1beta.StreamAssistResponse>
        getStreamAssistMethod;
    if ((getStreamAssistMethod = AssistantServiceGrpc.getStreamAssistMethod) == null) {
      synchronized (AssistantServiceGrpc.class) {
        if ((getStreamAssistMethod = AssistantServiceGrpc.getStreamAssistMethod) == null) {
          AssistantServiceGrpc.getStreamAssistMethod =
              getStreamAssistMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.StreamAssistRequest,
                          com.google.cloud.discoveryengine.v1beta.StreamAssistResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamAssist"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.StreamAssistRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.StreamAssistResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssistantServiceMethodDescriptorSupplier("StreamAssist"))
                      .build();
        }
      }
    }
    return getStreamAssistMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest,
          com.google.cloud.discoveryengine.v1beta.Assistant>
      getCreateAssistantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAssistant",
      requestType = com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Assistant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest,
          com.google.cloud.discoveryengine.v1beta.Assistant>
      getCreateAssistantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest,
            com.google.cloud.discoveryengine.v1beta.Assistant>
        getCreateAssistantMethod;
    if ((getCreateAssistantMethod = AssistantServiceGrpc.getCreateAssistantMethod) == null) {
      synchronized (AssistantServiceGrpc.class) {
        if ((getCreateAssistantMethod = AssistantServiceGrpc.getCreateAssistantMethod) == null) {
          AssistantServiceGrpc.getCreateAssistantMethod =
              getCreateAssistantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest,
                          com.google.cloud.discoveryengine.v1beta.Assistant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAssistant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Assistant
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssistantServiceMethodDescriptorSupplier("CreateAssistant"))
                      .build();
        }
      }
    }
    return getCreateAssistantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest, com.google.protobuf.Empty>
      getDeleteAssistantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAssistant",
      requestType = com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest, com.google.protobuf.Empty>
      getDeleteAssistantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest,
            com.google.protobuf.Empty>
        getDeleteAssistantMethod;
    if ((getDeleteAssistantMethod = AssistantServiceGrpc.getDeleteAssistantMethod) == null) {
      synchronized (AssistantServiceGrpc.class) {
        if ((getDeleteAssistantMethod = AssistantServiceGrpc.getDeleteAssistantMethod) == null) {
          AssistantServiceGrpc.getDeleteAssistantMethod =
              getDeleteAssistantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAssistant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssistantServiceMethodDescriptorSupplier("DeleteAssistant"))
                      .build();
        }
      }
    }
    return getDeleteAssistantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest,
          com.google.cloud.discoveryengine.v1beta.Assistant>
      getUpdateAssistantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAssistant",
      requestType = com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Assistant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest,
          com.google.cloud.discoveryengine.v1beta.Assistant>
      getUpdateAssistantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest,
            com.google.cloud.discoveryengine.v1beta.Assistant>
        getUpdateAssistantMethod;
    if ((getUpdateAssistantMethod = AssistantServiceGrpc.getUpdateAssistantMethod) == null) {
      synchronized (AssistantServiceGrpc.class) {
        if ((getUpdateAssistantMethod = AssistantServiceGrpc.getUpdateAssistantMethod) == null) {
          AssistantServiceGrpc.getUpdateAssistantMethod =
              getUpdateAssistantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest,
                          com.google.cloud.discoveryengine.v1beta.Assistant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAssistant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Assistant
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssistantServiceMethodDescriptorSupplier("UpdateAssistant"))
                      .build();
        }
      }
    }
    return getUpdateAssistantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetAssistantRequest,
          com.google.cloud.discoveryengine.v1beta.Assistant>
      getGetAssistantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAssistant",
      requestType = com.google.cloud.discoveryengine.v1beta.GetAssistantRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Assistant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetAssistantRequest,
          com.google.cloud.discoveryengine.v1beta.Assistant>
      getGetAssistantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.GetAssistantRequest,
            com.google.cloud.discoveryengine.v1beta.Assistant>
        getGetAssistantMethod;
    if ((getGetAssistantMethod = AssistantServiceGrpc.getGetAssistantMethod) == null) {
      synchronized (AssistantServiceGrpc.class) {
        if ((getGetAssistantMethod = AssistantServiceGrpc.getGetAssistantMethod) == null) {
          AssistantServiceGrpc.getGetAssistantMethod =
              getGetAssistantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.GetAssistantRequest,
                          com.google.cloud.discoveryengine.v1beta.Assistant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAssistant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.GetAssistantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Assistant
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssistantServiceMethodDescriptorSupplier("GetAssistant"))
                      .build();
        }
      }
    }
    return getGetAssistantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest,
          com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse>
      getListAssistantsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAssistants",
      requestType = com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest,
          com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse>
      getListAssistantsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest,
            com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse>
        getListAssistantsMethod;
    if ((getListAssistantsMethod = AssistantServiceGrpc.getListAssistantsMethod) == null) {
      synchronized (AssistantServiceGrpc.class) {
        if ((getListAssistantsMethod = AssistantServiceGrpc.getListAssistantsMethod) == null) {
          AssistantServiceGrpc.getListAssistantsMethod =
              getListAssistantsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest,
                          com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAssistants"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssistantServiceMethodDescriptorSupplier("ListAssistants"))
                      .build();
        }
      }
    }
    return getListAssistantsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AssistantServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssistantServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssistantServiceStub>() {
          @java.lang.Override
          public AssistantServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssistantServiceStub(channel, callOptions);
          }
        };
    return AssistantServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AssistantServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssistantServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssistantServiceBlockingV2Stub>() {
          @java.lang.Override
          public AssistantServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssistantServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return AssistantServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AssistantServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssistantServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssistantServiceBlockingStub>() {
          @java.lang.Override
          public AssistantServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssistantServiceBlockingStub(channel, callOptions);
          }
        };
    return AssistantServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AssistantServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssistantServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssistantServiceFutureStub>() {
          @java.lang.Override
          public AssistantServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssistantServiceFutureStub(channel, callOptions);
          }
        };
    return AssistantServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing Assistant configuration and assisting users.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Assists the user with a query in a streaming fashion.
     * </pre>
     */
    default void streamAssist(
        com.google.cloud.discoveryengine.v1beta.StreamAssistRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.StreamAssistResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStreamAssistMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    default void createAssistant(
        com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Assistant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAssistantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    default void deleteAssistant(
        com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAssistantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant]
     * </pre>
     */
    default void updateAssistant(
        com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Assistant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAssistantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    default void getAssistant(
        com.google.cloud.discoveryengine.v1beta.GetAssistantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Assistant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAssistantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all [Assistant][google.cloud.discoveryengine.v1beta.Assistant]s under
     * an [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    default void listAssistants(
        com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAssistantsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AssistantService.
   *
   * <pre>
   * Service for managing Assistant configuration and assisting users.
   * </pre>
   */
  public abstract static class AssistantServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AssistantServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AssistantService.
   *
   * <pre>
   * Service for managing Assistant configuration and assisting users.
   * </pre>
   */
  public static final class AssistantServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AssistantServiceStub> {
    private AssistantServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssistantServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssistantServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Assists the user with a query in a streaming fashion.
     * </pre>
     */
    public void streamAssist(
        com.google.cloud.discoveryengine.v1beta.StreamAssistRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.StreamAssistResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamAssistMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    public void createAssistant(
        com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Assistant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAssistantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    public void deleteAssistant(
        com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAssistantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant]
     * </pre>
     */
    public void updateAssistant(
        com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Assistant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAssistantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    public void getAssistant(
        com.google.cloud.discoveryengine.v1beta.GetAssistantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Assistant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAssistantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all [Assistant][google.cloud.discoveryengine.v1beta.Assistant]s under
     * an [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    public void listAssistants(
        com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAssistantsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AssistantService.
   *
   * <pre>
   * Service for managing Assistant configuration and assisting users.
   * </pre>
   */
  public static final class AssistantServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AssistantServiceBlockingV2Stub> {
    private AssistantServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssistantServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssistantServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Assists the user with a query in a streaming fashion.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            ?, com.google.cloud.discoveryengine.v1beta.StreamAssistResponse>
        streamAssist(com.google.cloud.discoveryengine.v1beta.StreamAssistRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getStreamAssistMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Assistant createAssistant(
        com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAssistantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    public com.google.protobuf.Empty deleteAssistant(
        com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteAssistantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant]
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Assistant updateAssistant(
        com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateAssistantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Assistant getAssistant(
        com.google.cloud.discoveryengine.v1beta.GetAssistantRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAssistantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all [Assistant][google.cloud.discoveryengine.v1beta.Assistant]s under
     * an [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse listAssistants(
        com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAssistantsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AssistantService.
   *
   * <pre>
   * Service for managing Assistant configuration and assisting users.
   * </pre>
   */
  public static final class AssistantServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AssistantServiceBlockingStub> {
    private AssistantServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssistantServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssistantServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Assists the user with a query in a streaming fashion.
     * </pre>
     */
    public java.util.Iterator<com.google.cloud.discoveryengine.v1beta.StreamAssistResponse>
        streamAssist(com.google.cloud.discoveryengine.v1beta.StreamAssistRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamAssistMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Assistant createAssistant(
        com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAssistantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    public com.google.protobuf.Empty deleteAssistant(
        com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAssistantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant]
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Assistant updateAssistant(
        com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAssistantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Assistant getAssistant(
        com.google.cloud.discoveryengine.v1beta.GetAssistantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAssistantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all [Assistant][google.cloud.discoveryengine.v1beta.Assistant]s under
     * an [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse listAssistants(
        com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAssistantsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AssistantService.
   *
   * <pre>
   * Service for managing Assistant configuration and assisting users.
   * </pre>
   */
  public static final class AssistantServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AssistantServiceFutureStub> {
    private AssistantServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssistantServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssistantServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Assistant>
        createAssistant(com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAssistantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAssistant(com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAssistantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an [Assistant][google.cloud.discoveryengine.v1beta.Assistant]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Assistant>
        updateAssistant(com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAssistantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an [Assistant][google.cloud.discoveryengine.v1beta.Assistant].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Assistant>
        getAssistant(com.google.cloud.discoveryengine.v1beta.GetAssistantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAssistantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all [Assistant][google.cloud.discoveryengine.v1beta.Assistant]s under
     * an [Engine][google.cloud.discoveryengine.v1beta.Engine].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse>
        listAssistants(com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAssistantsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STREAM_ASSIST = 0;
  private static final int METHODID_CREATE_ASSISTANT = 1;
  private static final int METHODID_DELETE_ASSISTANT = 2;
  private static final int METHODID_UPDATE_ASSISTANT = 3;
  private static final int METHODID_GET_ASSISTANT = 4;
  private static final int METHODID_LIST_ASSISTANTS = 5;

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
        case METHODID_STREAM_ASSIST:
          serviceImpl.streamAssist(
              (com.google.cloud.discoveryengine.v1beta.StreamAssistRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.StreamAssistResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_ASSISTANT:
          serviceImpl.createAssistant(
              (com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Assistant>)
                  responseObserver);
          break;
        case METHODID_DELETE_ASSISTANT:
          serviceImpl.deleteAssistant(
              (com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_ASSISTANT:
          serviceImpl.updateAssistant(
              (com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Assistant>)
                  responseObserver);
          break;
        case METHODID_GET_ASSISTANT:
          serviceImpl.getAssistant(
              (com.google.cloud.discoveryengine.v1beta.GetAssistantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Assistant>)
                  responseObserver);
          break;
        case METHODID_LIST_ASSISTANTS:
          serviceImpl.listAssistants(
              (com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse>)
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
            getStreamAssistMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.StreamAssistRequest,
                    com.google.cloud.discoveryengine.v1beta.StreamAssistResponse>(
                    service, METHODID_STREAM_ASSIST)))
        .addMethod(
            getCreateAssistantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest,
                    com.google.cloud.discoveryengine.v1beta.Assistant>(
                    service, METHODID_CREATE_ASSISTANT)))
        .addMethod(
            getDeleteAssistantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ASSISTANT)))
        .addMethod(
            getUpdateAssistantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest,
                    com.google.cloud.discoveryengine.v1beta.Assistant>(
                    service, METHODID_UPDATE_ASSISTANT)))
        .addMethod(
            getGetAssistantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.GetAssistantRequest,
                    com.google.cloud.discoveryengine.v1beta.Assistant>(
                    service, METHODID_GET_ASSISTANT)))
        .addMethod(
            getListAssistantsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest,
                    com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse>(
                    service, METHODID_LIST_ASSISTANTS)))
        .build();
  }

  private abstract static class AssistantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AssistantServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1beta.AssistantServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AssistantService");
    }
  }

  private static final class AssistantServiceFileDescriptorSupplier
      extends AssistantServiceBaseDescriptorSupplier {
    AssistantServiceFileDescriptorSupplier() {}
  }

  private static final class AssistantServiceMethodDescriptorSupplier
      extends AssistantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AssistantServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AssistantServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AssistantServiceFileDescriptorSupplier())
                      .addMethod(getStreamAssistMethod())
                      .addMethod(getCreateAssistantMethod())
                      .addMethod(getDeleteAssistantMethod())
                      .addMethod(getUpdateAssistantMethod())
                      .addMethod(getGetAssistantMethod())
                      .addMethod(getListAssistantsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
