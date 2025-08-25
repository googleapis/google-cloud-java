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
package com.google.cloud.geminidataanalytics.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to ask a natural language question on top of BigQuery
 * and Looker Studio datasources to get back streamed responses of various kinds
 * to help provide a rich conversational answer.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/geminidataanalytics/v1beta/data_chat_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataChatServiceGrpc {

  private DataChatServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.geminidataanalytics.v1beta.DataChatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.ChatRequest,
          com.google.cloud.geminidataanalytics.v1beta.Message>
      getChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Chat",
      requestType = com.google.cloud.geminidataanalytics.v1beta.ChatRequest.class,
      responseType = com.google.cloud.geminidataanalytics.v1beta.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.ChatRequest,
          com.google.cloud.geminidataanalytics.v1beta.Message>
      getChatMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.ChatRequest,
            com.google.cloud.geminidataanalytics.v1beta.Message>
        getChatMethod;
    if ((getChatMethod = DataChatServiceGrpc.getChatMethod) == null) {
      synchronized (DataChatServiceGrpc.class) {
        if ((getChatMethod = DataChatServiceGrpc.getChatMethod) == null) {
          DataChatServiceGrpc.getChatMethod =
              getChatMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.ChatRequest,
                          com.google.cloud.geminidataanalytics.v1beta.Message>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Chat"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.ChatRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.Message
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DataChatServiceMethodDescriptorSupplier("Chat"))
                      .build();
        }
      }
    }
    return getChatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest,
          com.google.cloud.geminidataanalytics.v1beta.Conversation>
      getCreateConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConversation",
      requestType = com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest.class,
      responseType = com.google.cloud.geminidataanalytics.v1beta.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest,
          com.google.cloud.geminidataanalytics.v1beta.Conversation>
      getCreateConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest,
            com.google.cloud.geminidataanalytics.v1beta.Conversation>
        getCreateConversationMethod;
    if ((getCreateConversationMethod = DataChatServiceGrpc.getCreateConversationMethod) == null) {
      synchronized (DataChatServiceGrpc.class) {
        if ((getCreateConversationMethod = DataChatServiceGrpc.getCreateConversationMethod)
            == null) {
          DataChatServiceGrpc.getCreateConversationMethod =
              getCreateConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest,
                          com.google.cloud.geminidataanalytics.v1beta.Conversation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.Conversation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataChatServiceMethodDescriptorSupplier("CreateConversation"))
                      .build();
        }
      }
    }
    return getCreateConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest,
          com.google.cloud.geminidataanalytics.v1beta.Conversation>
      getGetConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConversation",
      requestType = com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest.class,
      responseType = com.google.cloud.geminidataanalytics.v1beta.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest,
          com.google.cloud.geminidataanalytics.v1beta.Conversation>
      getGetConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest,
            com.google.cloud.geminidataanalytics.v1beta.Conversation>
        getGetConversationMethod;
    if ((getGetConversationMethod = DataChatServiceGrpc.getGetConversationMethod) == null) {
      synchronized (DataChatServiceGrpc.class) {
        if ((getGetConversationMethod = DataChatServiceGrpc.getGetConversationMethod) == null) {
          DataChatServiceGrpc.getGetConversationMethod =
              getGetConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest,
                          com.google.cloud.geminidataanalytics.v1beta.Conversation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.Conversation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataChatServiceMethodDescriptorSupplier("GetConversation"))
                      .build();
        }
      }
    }
    return getGetConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest,
          com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse>
      getListConversationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConversations",
      requestType = com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest.class,
      responseType = com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest,
          com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse>
      getListConversationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest,
            com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse>
        getListConversationsMethod;
    if ((getListConversationsMethod = DataChatServiceGrpc.getListConversationsMethod) == null) {
      synchronized (DataChatServiceGrpc.class) {
        if ((getListConversationsMethod = DataChatServiceGrpc.getListConversationsMethod) == null) {
          DataChatServiceGrpc.getListConversationsMethod =
              getListConversationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest,
                          com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConversations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataChatServiceMethodDescriptorSupplier("ListConversations"))
                      .build();
        }
      }
    }
    return getListConversationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest,
          com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse>
      getListMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMessages",
      requestType = com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest.class,
      responseType = com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest,
          com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse>
      getListMessagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest,
            com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse>
        getListMessagesMethod;
    if ((getListMessagesMethod = DataChatServiceGrpc.getListMessagesMethod) == null) {
      synchronized (DataChatServiceGrpc.class) {
        if ((getListMessagesMethod = DataChatServiceGrpc.getListMessagesMethod) == null) {
          DataChatServiceGrpc.getListMessagesMethod =
              getListMessagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest,
                          com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMessages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataChatServiceMethodDescriptorSupplier("ListMessages"))
                      .build();
        }
      }
    }
    return getListMessagesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataChatServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataChatServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataChatServiceStub>() {
          @java.lang.Override
          public DataChatServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataChatServiceStub(channel, callOptions);
          }
        };
    return DataChatServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DataChatServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataChatServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataChatServiceBlockingV2Stub>() {
          @java.lang.Override
          public DataChatServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataChatServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DataChatServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataChatServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataChatServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataChatServiceBlockingStub>() {
          @java.lang.Override
          public DataChatServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataChatServiceBlockingStub(channel, callOptions);
          }
        };
    return DataChatServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataChatServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataChatServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataChatServiceFutureStub>() {
          @java.lang.Override
          public DataChatServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataChatServiceFutureStub(channel, callOptions);
          }
        };
    return DataChatServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to ask a natural language question on top of BigQuery
   * and Looker Studio datasources to get back streamed responses of various kinds
   * to help provide a rich conversational answer.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Answers a data question by generating a stream of
     * [Message][google.cloud.geminidataanalytics.v1alpha.Message] objects.
     * </pre>
     */
    default void chat(
        com.google.cloud.geminidataanalytics.v1beta.ChatRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.Message>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getChatMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversation to persist the conversation history. Each
     * conversation will have multiple messages associated with it.
     * </pre>
     */
    default void createConversation(
        com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.Conversation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single conversation by using conversation id and parent.
     * </pre>
     */
    default void getConversation(
        com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.Conversation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all conversations for a given parent.
     * </pre>
     */
    default void listConversations(
        com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConversationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all messages for a given conversation.
     * </pre>
     */
    default void listMessages(
        com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMessagesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataChatService.
   *
   * <pre>
   * Service to ask a natural language question on top of BigQuery
   * and Looker Studio datasources to get back streamed responses of various kinds
   * to help provide a rich conversational answer.
   * </pre>
   */
  public abstract static class DataChatServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataChatServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataChatService.
   *
   * <pre>
   * Service to ask a natural language question on top of BigQuery
   * and Looker Studio datasources to get back streamed responses of various kinds
   * to help provide a rich conversational answer.
   * </pre>
   */
  public static final class DataChatServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataChatServiceStub> {
    private DataChatServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataChatServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataChatServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Answers a data question by generating a stream of
     * [Message][google.cloud.geminidataanalytics.v1alpha.Message] objects.
     * </pre>
     */
    public void chat(
        com.google.cloud.geminidataanalytics.v1beta.ChatRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.Message>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getChatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversation to persist the conversation history. Each
     * conversation will have multiple messages associated with it.
     * </pre>
     */
    public void createConversation(
        com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.Conversation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single conversation by using conversation id and parent.
     * </pre>
     */
    public void getConversation(
        com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.Conversation>
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
     * Lists all conversations for a given parent.
     * </pre>
     */
    public void listConversations(
        com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse>
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
     * Lists all messages for a given conversation.
     * </pre>
     */
    public void listMessages(
        com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMessagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataChatService.
   *
   * <pre>
   * Service to ask a natural language question on top of BigQuery
   * and Looker Studio datasources to get back streamed responses of various kinds
   * to help provide a rich conversational answer.
   * </pre>
   */
  public static final class DataChatServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DataChatServiceBlockingV2Stub> {
    private DataChatServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataChatServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataChatServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Answers a data question by generating a stream of
     * [Message][google.cloud.geminidataanalytics.v1alpha.Message] objects.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.google.cloud.geminidataanalytics.v1beta.Message>
        chat(com.google.cloud.geminidataanalytics.v1beta.ChatRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getChatMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversation to persist the conversation history. Each
     * conversation will have multiple messages associated with it.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.Conversation createConversation(
        com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single conversation by using conversation id and parent.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.Conversation getConversation(
        com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all conversations for a given parent.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse listConversations(
        com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all messages for a given conversation.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse listMessages(
        com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMessagesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DataChatService.
   *
   * <pre>
   * Service to ask a natural language question on top of BigQuery
   * and Looker Studio datasources to get back streamed responses of various kinds
   * to help provide a rich conversational answer.
   * </pre>
   */
  public static final class DataChatServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataChatServiceBlockingStub> {
    private DataChatServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataChatServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataChatServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Answers a data question by generating a stream of
     * [Message][google.cloud.geminidataanalytics.v1alpha.Message] objects.
     * </pre>
     */
    public java.util.Iterator<com.google.cloud.geminidataanalytics.v1beta.Message> chat(
        com.google.cloud.geminidataanalytics.v1beta.ChatRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getChatMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversation to persist the conversation history. Each
     * conversation will have multiple messages associated with it.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.Conversation createConversation(
        com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single conversation by using conversation id and parent.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.Conversation getConversation(
        com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all conversations for a given parent.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse listConversations(
        com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all messages for a given conversation.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse listMessages(
        com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMessagesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataChatService.
   *
   * <pre>
   * Service to ask a natural language question on top of BigQuery
   * and Looker Studio datasources to get back streamed responses of various kinds
   * to help provide a rich conversational answer.
   * </pre>
   */
  public static final class DataChatServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataChatServiceFutureStub> {
    private DataChatServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataChatServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataChatServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversation to persist the conversation history. Each
     * conversation will have multiple messages associated with it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta.Conversation>
        createConversation(
            com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single conversation by using conversation id and parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta.Conversation>
        getConversation(
            com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all conversations for a given parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse>
        listConversations(
            com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConversationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all messages for a given conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse>
        listMessages(com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMessagesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHAT = 0;
  private static final int METHODID_CREATE_CONVERSATION = 1;
  private static final int METHODID_GET_CONVERSATION = 2;
  private static final int METHODID_LIST_CONVERSATIONS = 3;
  private static final int METHODID_LIST_MESSAGES = 4;

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
        case METHODID_CHAT:
          serviceImpl.chat(
              (com.google.cloud.geminidataanalytics.v1beta.ChatRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.geminidataanalytics.v1beta.Message>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONVERSATION:
          serviceImpl.createConversation(
              (com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta.Conversation>)
                  responseObserver);
          break;
        case METHODID_GET_CONVERSATION:
          serviceImpl.getConversation(
              (com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta.Conversation>)
                  responseObserver);
          break;
        case METHODID_LIST_CONVERSATIONS:
          serviceImpl.listConversations(
              (com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_MESSAGES:
          serviceImpl.listMessages(
              (com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse>)
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
            getChatMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.ChatRequest,
                    com.google.cloud.geminidataanalytics.v1beta.Message>(service, METHODID_CHAT)))
        .addMethod(
            getCreateConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.CreateConversationRequest,
                    com.google.cloud.geminidataanalytics.v1beta.Conversation>(
                    service, METHODID_CREATE_CONVERSATION)))
        .addMethod(
            getGetConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.GetConversationRequest,
                    com.google.cloud.geminidataanalytics.v1beta.Conversation>(
                    service, METHODID_GET_CONVERSATION)))
        .addMethod(
            getListConversationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.ListConversationsRequest,
                    com.google.cloud.geminidataanalytics.v1beta.ListConversationsResponse>(
                    service, METHODID_LIST_CONVERSATIONS)))
        .addMethod(
            getListMessagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.ListMessagesRequest,
                    com.google.cloud.geminidataanalytics.v1beta.ListMessagesResponse>(
                    service, METHODID_LIST_MESSAGES)))
        .build();
  }

  private abstract static class DataChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataChatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.geminidataanalytics.v1beta.DataChatServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataChatService");
    }
  }

  private static final class DataChatServiceFileDescriptorSupplier
      extends DataChatServiceBaseDescriptorSupplier {
    DataChatServiceFileDescriptorSupplier() {}
  }

  private static final class DataChatServiceMethodDescriptorSupplier
      extends DataChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataChatServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataChatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataChatServiceFileDescriptorSupplier())
                      .addMethod(getChatMethod())
                      .addMethod(getCreateConversationMethod())
                      .addMethod(getGetConversationMethod())
                      .addMethod(getListConversationsMethod())
                      .addMethod(getListMessagesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
