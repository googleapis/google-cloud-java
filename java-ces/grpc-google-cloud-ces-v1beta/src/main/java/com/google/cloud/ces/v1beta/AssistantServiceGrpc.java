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
package com.google.cloud.ces.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The service that manages assistant-related resources in Customer Engagement
 * Suite (CES). The assistant, Arc, is a conversational agent embedded in CES
 * applications to help users with building their agents.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AssistantServiceGrpc {

  private AssistantServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.ces.v1beta.AssistantService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListAssistantSessionsRequest,
          com.google.cloud.ces.v1beta.ListAssistantSessionsResponse>
      getListAssistantSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAssistantSessions",
      requestType = com.google.cloud.ces.v1beta.ListAssistantSessionsRequest.class,
      responseType = com.google.cloud.ces.v1beta.ListAssistantSessionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ListAssistantSessionsRequest,
          com.google.cloud.ces.v1beta.ListAssistantSessionsResponse>
      getListAssistantSessionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.ListAssistantSessionsRequest,
            com.google.cloud.ces.v1beta.ListAssistantSessionsResponse>
        getListAssistantSessionsMethod;
    if ((getListAssistantSessionsMethod = AssistantServiceGrpc.getListAssistantSessionsMethod)
        == null) {
      synchronized (AssistantServiceGrpc.class) {
        if ((getListAssistantSessionsMethod = AssistantServiceGrpc.getListAssistantSessionsMethod)
            == null) {
          AssistantServiceGrpc.getListAssistantSessionsMethod =
              getListAssistantSessionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.ListAssistantSessionsRequest,
                          com.google.cloud.ces.v1beta.ListAssistantSessionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAssistantSessions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListAssistantSessionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ListAssistantSessionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssistantServiceMethodDescriptorSupplier("ListAssistantSessions"))
                      .build();
        }
      }
    }
    return getListAssistantSessionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetAssistantSessionRequest,
          com.google.cloud.ces.v1beta.AssistantSession>
      getGetAssistantSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAssistantSession",
      requestType = com.google.cloud.ces.v1beta.GetAssistantSessionRequest.class,
      responseType = com.google.cloud.ces.v1beta.AssistantSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.GetAssistantSessionRequest,
          com.google.cloud.ces.v1beta.AssistantSession>
      getGetAssistantSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.GetAssistantSessionRequest,
            com.google.cloud.ces.v1beta.AssistantSession>
        getGetAssistantSessionMethod;
    if ((getGetAssistantSessionMethod = AssistantServiceGrpc.getGetAssistantSessionMethod)
        == null) {
      synchronized (AssistantServiceGrpc.class) {
        if ((getGetAssistantSessionMethod = AssistantServiceGrpc.getGetAssistantSessionMethod)
            == null) {
          AssistantServiceGrpc.getGetAssistantSessionMethod =
              getGetAssistantSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.GetAssistantSessionRequest,
                          com.google.cloud.ces.v1beta.AssistantSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAssistantSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.GetAssistantSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.AssistantSession.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssistantServiceMethodDescriptorSupplier("GetAssistantSession"))
                      .build();
        }
      }
    }
    return getGetAssistantSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.CreateAssistantSessionRequest,
          com.google.cloud.ces.v1beta.AssistantSession>
      getCreateAssistantSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAssistantSession",
      requestType = com.google.cloud.ces.v1beta.CreateAssistantSessionRequest.class,
      responseType = com.google.cloud.ces.v1beta.AssistantSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.CreateAssistantSessionRequest,
          com.google.cloud.ces.v1beta.AssistantSession>
      getCreateAssistantSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.CreateAssistantSessionRequest,
            com.google.cloud.ces.v1beta.AssistantSession>
        getCreateAssistantSessionMethod;
    if ((getCreateAssistantSessionMethod = AssistantServiceGrpc.getCreateAssistantSessionMethod)
        == null) {
      synchronized (AssistantServiceGrpc.class) {
        if ((getCreateAssistantSessionMethod = AssistantServiceGrpc.getCreateAssistantSessionMethod)
            == null) {
          AssistantServiceGrpc.getCreateAssistantSessionMethod =
              getCreateAssistantSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.CreateAssistantSessionRequest,
                          com.google.cloud.ces.v1beta.AssistantSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAssistantSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.CreateAssistantSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.AssistantSession.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssistantServiceMethodDescriptorSupplier("CreateAssistantSession"))
                      .build();
        }
      }
    }
    return getCreateAssistantSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest, com.google.protobuf.Empty>
      getDeleteAssistantSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAssistantSession",
      requestType = com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest, com.google.protobuf.Empty>
      getDeleteAssistantSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest, com.google.protobuf.Empty>
        getDeleteAssistantSessionMethod;
    if ((getDeleteAssistantSessionMethod = AssistantServiceGrpc.getDeleteAssistantSessionMethod)
        == null) {
      synchronized (AssistantServiceGrpc.class) {
        if ((getDeleteAssistantSessionMethod = AssistantServiceGrpc.getDeleteAssistantSessionMethod)
            == null) {
          AssistantServiceGrpc.getDeleteAssistantSessionMethod =
              getDeleteAssistantSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAssistantSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssistantServiceMethodDescriptorSupplier("DeleteAssistantSession"))
                      .build();
        }
      }
    }
    return getDeleteAssistantSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.RunAssistantRequest,
          com.google.cloud.ces.v1beta.RunAssistantResponse>
      getRunAssistantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunAssistant",
      requestType = com.google.cloud.ces.v1beta.RunAssistantRequest.class,
      responseType = com.google.cloud.ces.v1beta.RunAssistantResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.RunAssistantRequest,
          com.google.cloud.ces.v1beta.RunAssistantResponse>
      getRunAssistantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.RunAssistantRequest,
            com.google.cloud.ces.v1beta.RunAssistantResponse>
        getRunAssistantMethod;
    if ((getRunAssistantMethod = AssistantServiceGrpc.getRunAssistantMethod) == null) {
      synchronized (AssistantServiceGrpc.class) {
        if ((getRunAssistantMethod = AssistantServiceGrpc.getRunAssistantMethod) == null) {
          AssistantServiceGrpc.getRunAssistantMethod =
              getRunAssistantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.RunAssistantRequest,
                          com.google.cloud.ces.v1beta.RunAssistantResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunAssistant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.RunAssistantRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.RunAssistantResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssistantServiceMethodDescriptorSupplier("RunAssistant"))
                      .build();
        }
      }
    }
    return getRunAssistantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ChatAiAssistantRequest,
          com.google.cloud.ces.v1beta.ChatAiAssistantResponse>
      getChatAiAssistantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChatAiAssistant",
      requestType = com.google.cloud.ces.v1beta.ChatAiAssistantRequest.class,
      responseType = com.google.cloud.ces.v1beta.ChatAiAssistantResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1beta.ChatAiAssistantRequest,
          com.google.cloud.ces.v1beta.ChatAiAssistantResponse>
      getChatAiAssistantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1beta.ChatAiAssistantRequest,
            com.google.cloud.ces.v1beta.ChatAiAssistantResponse>
        getChatAiAssistantMethod;
    if ((getChatAiAssistantMethod = AssistantServiceGrpc.getChatAiAssistantMethod) == null) {
      synchronized (AssistantServiceGrpc.class) {
        if ((getChatAiAssistantMethod = AssistantServiceGrpc.getChatAiAssistantMethod) == null) {
          AssistantServiceGrpc.getChatAiAssistantMethod =
              getChatAiAssistantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1beta.ChatAiAssistantRequest,
                          com.google.cloud.ces.v1beta.ChatAiAssistantResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ChatAiAssistant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ChatAiAssistantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1beta.ChatAiAssistantResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssistantServiceMethodDescriptorSupplier("ChatAiAssistant"))
                      .build();
        }
      }
    }
    return getChatAiAssistantMethod;
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
   * The service that manages assistant-related resources in Customer Engagement
   * Suite (CES). The assistant, Arc, is a conversational agent embedded in CES
   * applications to help users with building their agents.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists all assistant sessions in the given app.
     * </pre>
     */
    default void listAssistantSessions(
        com.google.cloud.ces.v1beta.ListAssistantSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListAssistantSessionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAssistantSessionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified assistant session.
     * </pre>
     */
    default void getAssistantSession(
        com.google.cloud.ces.v1beta.GetAssistantSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.AssistantSession>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAssistantSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new assistant session in the given app.
     * </pre>
     */
    default void createAssistantSession(
        com.google.cloud.ces.v1beta.CreateAssistantSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.AssistantSession>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAssistantSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified assistant session.
     * </pre>
     */
    default void deleteAssistantSession(
        com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAssistantSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs the assistant agent for the specified assistant session.
     * </pre>
     */
    default void runAssistant(
        com.google.cloud.ces.v1beta.RunAssistantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.RunAssistantResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunAssistantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs Arc, the AI assistant, for the specified assistant session.
     * </pre>
     */
    default void chatAiAssistant(
        com.google.cloud.ces.v1beta.ChatAiAssistantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ChatAiAssistantResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getChatAiAssistantMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AssistantService.
   *
   * <pre>
   * The service that manages assistant-related resources in Customer Engagement
   * Suite (CES). The assistant, Arc, is a conversational agent embedded in CES
   * applications to help users with building their agents.
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
   * The service that manages assistant-related resources in Customer Engagement
   * Suite (CES). The assistant, Arc, is a conversational agent embedded in CES
   * applications to help users with building their agents.
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
     * Lists all assistant sessions in the given app.
     * </pre>
     */
    public void listAssistantSessions(
        com.google.cloud.ces.v1beta.ListAssistantSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ListAssistantSessionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAssistantSessionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified assistant session.
     * </pre>
     */
    public void getAssistantSession(
        com.google.cloud.ces.v1beta.GetAssistantSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.AssistantSession>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAssistantSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new assistant session in the given app.
     * </pre>
     */
    public void createAssistantSession(
        com.google.cloud.ces.v1beta.CreateAssistantSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.AssistantSession>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAssistantSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified assistant session.
     * </pre>
     */
    public void deleteAssistantSession(
        com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAssistantSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs the assistant agent for the specified assistant session.
     * </pre>
     */
    public void runAssistant(
        com.google.cloud.ces.v1beta.RunAssistantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.RunAssistantResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunAssistantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs Arc, the AI assistant, for the specified assistant session.
     * </pre>
     */
    public void chatAiAssistant(
        com.google.cloud.ces.v1beta.ChatAiAssistantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ChatAiAssistantResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getChatAiAssistantMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AssistantService.
   *
   * <pre>
   * The service that manages assistant-related resources in Customer Engagement
   * Suite (CES). The assistant, Arc, is a conversational agent embedded in CES
   * applications to help users with building their agents.
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
     * Lists all assistant sessions in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListAssistantSessionsResponse listAssistantSessions(
        com.google.cloud.ces.v1beta.ListAssistantSessionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAssistantSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified assistant session.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.AssistantSession getAssistantSession(
        com.google.cloud.ces.v1beta.GetAssistantSessionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAssistantSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new assistant session in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.AssistantSession createAssistantSession(
        com.google.cloud.ces.v1beta.CreateAssistantSessionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAssistantSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified assistant session.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAssistantSession(
        com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteAssistantSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs the assistant agent for the specified assistant session.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.RunAssistantResponse runAssistant(
        com.google.cloud.ces.v1beta.RunAssistantRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRunAssistantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs Arc, the AI assistant, for the specified assistant session.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ChatAiAssistantResponse chatAiAssistant(
        com.google.cloud.ces.v1beta.ChatAiAssistantRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getChatAiAssistantMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AssistantService.
   *
   * <pre>
   * The service that manages assistant-related resources in Customer Engagement
   * Suite (CES). The assistant, Arc, is a conversational agent embedded in CES
   * applications to help users with building their agents.
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
     * Lists all assistant sessions in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ListAssistantSessionsResponse listAssistantSessions(
        com.google.cloud.ces.v1beta.ListAssistantSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAssistantSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified assistant session.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.AssistantSession getAssistantSession(
        com.google.cloud.ces.v1beta.GetAssistantSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAssistantSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new assistant session in the given app.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.AssistantSession createAssistantSession(
        com.google.cloud.ces.v1beta.CreateAssistantSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAssistantSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified assistant session.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAssistantSession(
        com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAssistantSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs the assistant agent for the specified assistant session.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.RunAssistantResponse runAssistant(
        com.google.cloud.ces.v1beta.RunAssistantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunAssistantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs Arc, the AI assistant, for the specified assistant session.
     * </pre>
     */
    public com.google.cloud.ces.v1beta.ChatAiAssistantResponse chatAiAssistant(
        com.google.cloud.ces.v1beta.ChatAiAssistantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChatAiAssistantMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AssistantService.
   *
   * <pre>
   * The service that manages assistant-related resources in Customer Engagement
   * Suite (CES). The assistant, Arc, is a conversational agent embedded in CES
   * applications to help users with building their agents.
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
     * Lists all assistant sessions in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.ListAssistantSessionsResponse>
        listAssistantSessions(com.google.cloud.ces.v1beta.ListAssistantSessionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAssistantSessionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of the specified assistant session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.AssistantSession>
        getAssistantSession(com.google.cloud.ces.v1beta.GetAssistantSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAssistantSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new assistant session in the given app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.AssistantSession>
        createAssistantSession(com.google.cloud.ces.v1beta.CreateAssistantSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAssistantSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified assistant session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAssistantSession(com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAssistantSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Runs the assistant agent for the specified assistant session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.RunAssistantResponse>
        runAssistant(com.google.cloud.ces.v1beta.RunAssistantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunAssistantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Runs Arc, the AI assistant, for the specified assistant session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1beta.ChatAiAssistantResponse>
        chatAiAssistant(com.google.cloud.ces.v1beta.ChatAiAssistantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getChatAiAssistantMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ASSISTANT_SESSIONS = 0;
  private static final int METHODID_GET_ASSISTANT_SESSION = 1;
  private static final int METHODID_CREATE_ASSISTANT_SESSION = 2;
  private static final int METHODID_DELETE_ASSISTANT_SESSION = 3;
  private static final int METHODID_RUN_ASSISTANT = 4;
  private static final int METHODID_CHAT_AI_ASSISTANT = 5;

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
        case METHODID_LIST_ASSISTANT_SESSIONS:
          serviceImpl.listAssistantSessions(
              (com.google.cloud.ces.v1beta.ListAssistantSessionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.ces.v1beta.ListAssistantSessionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ASSISTANT_SESSION:
          serviceImpl.getAssistantSession(
              (com.google.cloud.ces.v1beta.GetAssistantSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.AssistantSession>)
                  responseObserver);
          break;
        case METHODID_CREATE_ASSISTANT_SESSION:
          serviceImpl.createAssistantSession(
              (com.google.cloud.ces.v1beta.CreateAssistantSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.AssistantSession>)
                  responseObserver);
          break;
        case METHODID_DELETE_ASSISTANT_SESSION:
          serviceImpl.deleteAssistantSession(
              (com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RUN_ASSISTANT:
          serviceImpl.runAssistant(
              (com.google.cloud.ces.v1beta.RunAssistantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.RunAssistantResponse>)
                  responseObserver);
          break;
        case METHODID_CHAT_AI_ASSISTANT:
          serviceImpl.chatAiAssistant(
              (com.google.cloud.ces.v1beta.ChatAiAssistantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1beta.ChatAiAssistantResponse>)
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
            getListAssistantSessionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.ListAssistantSessionsRequest,
                    com.google.cloud.ces.v1beta.ListAssistantSessionsResponse>(
                    service, METHODID_LIST_ASSISTANT_SESSIONS)))
        .addMethod(
            getGetAssistantSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.GetAssistantSessionRequest,
                    com.google.cloud.ces.v1beta.AssistantSession>(
                    service, METHODID_GET_ASSISTANT_SESSION)))
        .addMethod(
            getCreateAssistantSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.CreateAssistantSessionRequest,
                    com.google.cloud.ces.v1beta.AssistantSession>(
                    service, METHODID_CREATE_ASSISTANT_SESSION)))
        .addMethod(
            getDeleteAssistantSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ASSISTANT_SESSION)))
        .addMethod(
            getRunAssistantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.RunAssistantRequest,
                    com.google.cloud.ces.v1beta.RunAssistantResponse>(
                    service, METHODID_RUN_ASSISTANT)))
        .addMethod(
            getChatAiAssistantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1beta.ChatAiAssistantRequest,
                    com.google.cloud.ces.v1beta.ChatAiAssistantResponse>(
                    service, METHODID_CHAT_AI_ASSISTANT)))
        .build();
  }

  private abstract static class AssistantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AssistantServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.ces.v1beta.AssistantServiceProto.getDescriptor();
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
                      .addMethod(getListAssistantSessionsMethod())
                      .addMethod(getGetAssistantSessionMethod())
                      .addMethod(getCreateAssistantSessionMethod())
                      .addMethod(getDeleteAssistantSessionMethod())
                      .addMethod(getRunAssistantMethod())
                      .addMethod(getChatAiAssistantMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
