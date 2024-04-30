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
package com.google.cloud.dialogflow.cx.v3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing conversation history.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3beta1/conversation_history.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConversationHistoryGrpc {

  private ConversationHistoryGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.dialogflow.cx.v3beta1.ConversationHistory";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListConversationsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListConversationsResponse>
      getListConversationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConversations",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ListConversationsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.ListConversationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListConversationsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListConversationsResponse>
      getListConversationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ListConversationsRequest,
            com.google.cloud.dialogflow.cx.v3beta1.ListConversationsResponse>
        getListConversationsMethod;
    if ((getListConversationsMethod = ConversationHistoryGrpc.getListConversationsMethod) == null) {
      synchronized (ConversationHistoryGrpc.class) {
        if ((getListConversationsMethod = ConversationHistoryGrpc.getListConversationsMethod)
            == null) {
          ConversationHistoryGrpc.getListConversationsMethod =
              getListConversationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ListConversationsRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.ListConversationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConversations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListConversationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListConversationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationHistoryMethodDescriptorSupplier("ListConversations"))
                      .build();
        }
      }
    }
    return getListConversationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetConversationRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Conversation>
      getGetConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConversation",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetConversationRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetConversationRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Conversation>
      getGetConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.GetConversationRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Conversation>
        getGetConversationMethod;
    if ((getGetConversationMethod = ConversationHistoryGrpc.getGetConversationMethod) == null) {
      synchronized (ConversationHistoryGrpc.class) {
        if ((getGetConversationMethod = ConversationHistoryGrpc.getGetConversationMethod) == null) {
          ConversationHistoryGrpc.getGetConversationMethod =
              getGetConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.GetConversationRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Conversation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.GetConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Conversation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationHistoryMethodDescriptorSupplier("GetConversation"))
                      .build();
        }
      }
    }
    return getGetConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeleteConversationRequest,
          com.google.protobuf.Empty>
      getDeleteConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConversation",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.DeleteConversationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeleteConversationRequest,
          com.google.protobuf.Empty>
      getDeleteConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.DeleteConversationRequest,
            com.google.protobuf.Empty>
        getDeleteConversationMethod;
    if ((getDeleteConversationMethod = ConversationHistoryGrpc.getDeleteConversationMethod)
        == null) {
      synchronized (ConversationHistoryGrpc.class) {
        if ((getDeleteConversationMethod = ConversationHistoryGrpc.getDeleteConversationMethod)
            == null) {
          ConversationHistoryGrpc.getDeleteConversationMethod =
              getDeleteConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.DeleteConversationRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.DeleteConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationHistoryMethodDescriptorSupplier("DeleteConversation"))
                      .build();
        }
      }
    }
    return getDeleteConversationMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConversationHistoryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationHistoryStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversationHistoryStub>() {
          @java.lang.Override
          public ConversationHistoryStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversationHistoryStub(channel, callOptions);
          }
        };
    return ConversationHistoryStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConversationHistoryBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationHistoryBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversationHistoryBlockingStub>() {
          @java.lang.Override
          public ConversationHistoryBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversationHistoryBlockingStub(channel, callOptions);
          }
        };
    return ConversationHistoryBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConversationHistoryFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationHistoryFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversationHistoryFutureStub>() {
          @java.lang.Override
          public ConversationHistoryFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversationHistoryFutureStub(channel, callOptions);
          }
        };
    return ConversationHistoryFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing conversation history.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns the list of all conversations.
     * </pre>
     */
    default void listConversations(
        com.google.cloud.dialogflow.cx.v3beta1.ListConversationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3beta1.ListConversationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConversationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified conversation.
     * </pre>
     */
    default void getConversation(
        com.google.cloud.dialogflow.cx.v3beta1.GetConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Conversation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified conversation.
     * </pre>
     */
    default void deleteConversation(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConversationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ConversationHistory.
   *
   * <pre>
   * Service for managing conversation history.
   * </pre>
   */
  public abstract static class ConversationHistoryImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ConversationHistoryGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ConversationHistory.
   *
   * <pre>
   * Service for managing conversation history.
   * </pre>
   */
  public static final class ConversationHistoryStub
      extends io.grpc.stub.AbstractAsyncStub<ConversationHistoryStub> {
    private ConversationHistoryStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationHistoryStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationHistoryStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all conversations.
     * </pre>
     */
    public void listConversations(
        com.google.cloud.dialogflow.cx.v3beta1.ListConversationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3beta1.ListConversationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConversationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified conversation.
     * </pre>
     */
    public void getConversation(
        com.google.cloud.dialogflow.cx.v3beta1.GetConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Conversation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified conversation.
     * </pre>
     */
    public void deleteConversation(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ConversationHistory.
   *
   * <pre>
   * Service for managing conversation history.
   * </pre>
   */
  public static final class ConversationHistoryBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConversationHistoryBlockingStub> {
    private ConversationHistoryBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationHistoryBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationHistoryBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all conversations.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListConversationsResponse listConversations(
        com.google.cloud.dialogflow.cx.v3beta1.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified conversation.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Conversation getConversation(
        com.google.cloud.dialogflow.cx.v3beta1.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified conversation.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConversation(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConversationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ConversationHistory.
   *
   * <pre>
   * Service for managing conversation history.
   * </pre>
   */
  public static final class ConversationHistoryFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConversationHistoryFutureStub> {
    private ConversationHistoryFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationHistoryFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationHistoryFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all conversations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.ListConversationsResponse>
        listConversations(com.google.cloud.dialogflow.cx.v3beta1.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConversationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Conversation>
        getConversation(com.google.cloud.dialogflow.cx.v3beta1.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteConversation(
            com.google.cloud.dialogflow.cx.v3beta1.DeleteConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConversationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CONVERSATIONS = 0;
  private static final int METHODID_GET_CONVERSATION = 1;
  private static final int METHODID_DELETE_CONVERSATION = 2;

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
        case METHODID_LIST_CONVERSATIONS:
          serviceImpl.listConversations(
              (com.google.cloud.dialogflow.cx.v3beta1.ListConversationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.ListConversationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CONVERSATION:
          serviceImpl.getConversation(
              (com.google.cloud.dialogflow.cx.v3beta1.GetConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Conversation>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONVERSATION:
          serviceImpl.deleteConversation(
              (com.google.cloud.dialogflow.cx.v3beta1.DeleteConversationRequest) request,
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
            getListConversationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.ListConversationsRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.ListConversationsResponse>(
                    service, METHODID_LIST_CONVERSATIONS)))
        .addMethod(
            getGetConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.GetConversationRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.Conversation>(
                    service, METHODID_GET_CONVERSATION)))
        .addMethod(
            getDeleteConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.DeleteConversationRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CONVERSATION)))
        .build();
  }

  private abstract static class ConversationHistoryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConversationHistoryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3beta1.ConversationHistoryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConversationHistory");
    }
  }

  private static final class ConversationHistoryFileDescriptorSupplier
      extends ConversationHistoryBaseDescriptorSupplier {
    ConversationHistoryFileDescriptorSupplier() {}
  }

  private static final class ConversationHistoryMethodDescriptorSupplier
      extends ConversationHistoryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConversationHistoryMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ConversationHistoryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConversationHistoryFileDescriptorSupplier())
                      .addMethod(getListConversationsMethod())
                      .addMethod(getGetConversationMethod())
                      .addMethod(getDeleteConversationMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
