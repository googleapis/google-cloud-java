/*
 * Copyright 2020 Google LLC
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
 * Service for managing [Conversations][google.cloud.dialogflow.v2.Conversation].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/conversation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConversationsGrpc {

  private ConversationsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2.Conversations";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateConversationRequest,
          com.google.cloud.dialogflow.v2.Conversation>
      getCreateConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConversation",
      requestType = com.google.cloud.dialogflow.v2.CreateConversationRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateConversationRequest,
          com.google.cloud.dialogflow.v2.Conversation>
      getCreateConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.CreateConversationRequest,
            com.google.cloud.dialogflow.v2.Conversation>
        getCreateConversationMethod;
    if ((getCreateConversationMethod = ConversationsGrpc.getCreateConversationMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getCreateConversationMethod = ConversationsGrpc.getCreateConversationMethod) == null) {
          ConversationsGrpc.getCreateConversationMethod =
              getCreateConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.CreateConversationRequest,
                          com.google.cloud.dialogflow.v2.Conversation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.CreateConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Conversation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationsMethodDescriptorSupplier("CreateConversation"))
                      .build();
        }
      }
    }
    return getCreateConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListConversationsRequest,
          com.google.cloud.dialogflow.v2.ListConversationsResponse>
      getListConversationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConversations",
      requestType = com.google.cloud.dialogflow.v2.ListConversationsRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListConversationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListConversationsRequest,
          com.google.cloud.dialogflow.v2.ListConversationsResponse>
      getListConversationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.ListConversationsRequest,
            com.google.cloud.dialogflow.v2.ListConversationsResponse>
        getListConversationsMethod;
    if ((getListConversationsMethod = ConversationsGrpc.getListConversationsMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getListConversationsMethod = ConversationsGrpc.getListConversationsMethod) == null) {
          ConversationsGrpc.getListConversationsMethod =
              getListConversationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.ListConversationsRequest,
                          com.google.cloud.dialogflow.v2.ListConversationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConversations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListConversationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListConversationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationsMethodDescriptorSupplier("ListConversations"))
                      .build();
        }
      }
    }
    return getListConversationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetConversationRequest,
          com.google.cloud.dialogflow.v2.Conversation>
      getGetConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConversation",
      requestType = com.google.cloud.dialogflow.v2.GetConversationRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetConversationRequest,
          com.google.cloud.dialogflow.v2.Conversation>
      getGetConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.GetConversationRequest,
            com.google.cloud.dialogflow.v2.Conversation>
        getGetConversationMethod;
    if ((getGetConversationMethod = ConversationsGrpc.getGetConversationMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getGetConversationMethod = ConversationsGrpc.getGetConversationMethod) == null) {
          ConversationsGrpc.getGetConversationMethod =
              getGetConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.GetConversationRequest,
                          com.google.cloud.dialogflow.v2.Conversation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GetConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Conversation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationsMethodDescriptorSupplier("GetConversation"))
                      .build();
        }
      }
    }
    return getGetConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CompleteConversationRequest,
          com.google.cloud.dialogflow.v2.Conversation>
      getCompleteConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompleteConversation",
      requestType = com.google.cloud.dialogflow.v2.CompleteConversationRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CompleteConversationRequest,
          com.google.cloud.dialogflow.v2.Conversation>
      getCompleteConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.CompleteConversationRequest,
            com.google.cloud.dialogflow.v2.Conversation>
        getCompleteConversationMethod;
    if ((getCompleteConversationMethod = ConversationsGrpc.getCompleteConversationMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getCompleteConversationMethod = ConversationsGrpc.getCompleteConversationMethod)
            == null) {
          ConversationsGrpc.getCompleteConversationMethod =
              getCompleteConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.CompleteConversationRequest,
                          com.google.cloud.dialogflow.v2.Conversation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CompleteConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.CompleteConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Conversation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationsMethodDescriptorSupplier("CompleteConversation"))
                      .build();
        }
      }
    }
    return getCompleteConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListMessagesRequest,
          com.google.cloud.dialogflow.v2.ListMessagesResponse>
      getListMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMessages",
      requestType = com.google.cloud.dialogflow.v2.ListMessagesRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListMessagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListMessagesRequest,
          com.google.cloud.dialogflow.v2.ListMessagesResponse>
      getListMessagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.ListMessagesRequest,
            com.google.cloud.dialogflow.v2.ListMessagesResponse>
        getListMessagesMethod;
    if ((getListMessagesMethod = ConversationsGrpc.getListMessagesMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getListMessagesMethod = ConversationsGrpc.getListMessagesMethod) == null) {
          ConversationsGrpc.getListMessagesMethod =
              getListMessagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.ListMessagesRequest,
                          com.google.cloud.dialogflow.v2.ListMessagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMessages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListMessagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListMessagesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationsMethodDescriptorSupplier("ListMessages"))
                      .build();
        }
      }
    }
    return getListMessagesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConversationsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversationsStub>() {
          @java.lang.Override
          public ConversationsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversationsStub(channel, callOptions);
          }
        };
    return ConversationsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConversationsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversationsBlockingStub>() {
          @java.lang.Override
          public ConversationsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversationsBlockingStub(channel, callOptions);
          }
        };
    return ConversationsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConversationsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversationsFutureStub>() {
          @java.lang.Override
          public ConversationsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversationsFutureStub(channel, callOptions);
          }
        };
    return ConversationsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Conversations][google.cloud.dialogflow.v2.Conversation].
   * </pre>
   */
  public abstract static class ConversationsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new conversation. Conversations are auto-completed after 24
     * hours.
     * Conversation Lifecycle:
     * There are two stages during a conversation: Automated Agent Stage and
     * Assist Stage.
     * For Automated Agent Stage, there will be a dialogflow agent responding to
     * user queries.
     * For Assist Stage, there's no dialogflow agent responding to user queries.
     * But we will provide suggestions which are generated from conversation.
     * If [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile] is configured for a dialogflow
     * agent, conversation will start from `Automated Agent Stage`, otherwise, it
     * will start from `Assist Stage`. And during `Automated Agent Stage`, once an
     * [Intent][google.cloud.dialogflow.v2.Intent] with [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff] is triggered, conversation
     * will transfer to Assist Stage.
     * </pre>
     */
    public void createConversation(
        com.google.cloud.dialogflow.v2.CreateConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Conversation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all conversations in the specified project.
     * </pre>
     */
    public void listConversations(
        com.google.cloud.dialogflow.v2.ListConversationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListConversationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConversationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specific conversation.
     * </pre>
     */
    public void getConversation(
        com.google.cloud.dialogflow.v2.GetConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Conversation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified conversation. Finished conversations are purged
     * from the database after 30 days.
     * </pre>
     */
    public void completeConversation(
        com.google.cloud.dialogflow.v2.CompleteConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Conversation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCompleteConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists messages that belong to a given conversation.
     * `messages` are ordered by `create_time` in descending order. To fetch
     * updates without duplication, send request with filter
     * `create_time_epoch_microseconds &gt;
     * [first item's create_time of previous request]` and empty page_token.
     * </pre>
     */
    public void listMessages(
        com.google.cloud.dialogflow.v2.ListMessagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListMessagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMessagesMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateConversationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.CreateConversationRequest,
                      com.google.cloud.dialogflow.v2.Conversation>(
                      this, METHODID_CREATE_CONVERSATION)))
          .addMethod(
              getListConversationsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.ListConversationsRequest,
                      com.google.cloud.dialogflow.v2.ListConversationsResponse>(
                      this, METHODID_LIST_CONVERSATIONS)))
          .addMethod(
              getGetConversationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.GetConversationRequest,
                      com.google.cloud.dialogflow.v2.Conversation>(
                      this, METHODID_GET_CONVERSATION)))
          .addMethod(
              getCompleteConversationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.CompleteConversationRequest,
                      com.google.cloud.dialogflow.v2.Conversation>(
                      this, METHODID_COMPLETE_CONVERSATION)))
          .addMethod(
              getListMessagesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2.ListMessagesRequest,
                      com.google.cloud.dialogflow.v2.ListMessagesResponse>(
                      this, METHODID_LIST_MESSAGES)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Conversations][google.cloud.dialogflow.v2.Conversation].
   * </pre>
   */
  public static final class ConversationsStub
      extends io.grpc.stub.AbstractAsyncStub<ConversationsStub> {
    private ConversationsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversation. Conversations are auto-completed after 24
     * hours.
     * Conversation Lifecycle:
     * There are two stages during a conversation: Automated Agent Stage and
     * Assist Stage.
     * For Automated Agent Stage, there will be a dialogflow agent responding to
     * user queries.
     * For Assist Stage, there's no dialogflow agent responding to user queries.
     * But we will provide suggestions which are generated from conversation.
     * If [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile] is configured for a dialogflow
     * agent, conversation will start from `Automated Agent Stage`, otherwise, it
     * will start from `Assist Stage`. And during `Automated Agent Stage`, once an
     * [Intent][google.cloud.dialogflow.v2.Intent] with [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff] is triggered, conversation
     * will transfer to Assist Stage.
     * </pre>
     */
    public void createConversation(
        com.google.cloud.dialogflow.v2.CreateConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Conversation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all conversations in the specified project.
     * </pre>
     */
    public void listConversations(
        com.google.cloud.dialogflow.v2.ListConversationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListConversationsResponse>
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
     * Retrieves the specific conversation.
     * </pre>
     */
    public void getConversation(
        com.google.cloud.dialogflow.v2.GetConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Conversation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified conversation. Finished conversations are purged
     * from the database after 30 days.
     * </pre>
     */
    public void completeConversation(
        com.google.cloud.dialogflow.v2.CompleteConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Conversation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompleteConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists messages that belong to a given conversation.
     * `messages` are ordered by `create_time` in descending order. To fetch
     * updates without duplication, send request with filter
     * `create_time_epoch_microseconds &gt;
     * [first item's create_time of previous request]` and empty page_token.
     * </pre>
     */
    public void listMessages(
        com.google.cloud.dialogflow.v2.ListMessagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListMessagesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMessagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Conversations][google.cloud.dialogflow.v2.Conversation].
   * </pre>
   */
  public static final class ConversationsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConversationsBlockingStub> {
    private ConversationsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversation. Conversations are auto-completed after 24
     * hours.
     * Conversation Lifecycle:
     * There are two stages during a conversation: Automated Agent Stage and
     * Assist Stage.
     * For Automated Agent Stage, there will be a dialogflow agent responding to
     * user queries.
     * For Assist Stage, there's no dialogflow agent responding to user queries.
     * But we will provide suggestions which are generated from conversation.
     * If [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile] is configured for a dialogflow
     * agent, conversation will start from `Automated Agent Stage`, otherwise, it
     * will start from `Assist Stage`. And during `Automated Agent Stage`, once an
     * [Intent][google.cloud.dialogflow.v2.Intent] with [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff] is triggered, conversation
     * will transfer to Assist Stage.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Conversation createConversation(
        com.google.cloud.dialogflow.v2.CreateConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all conversations in the specified project.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListConversationsResponse listConversations(
        com.google.cloud.dialogflow.v2.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specific conversation.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Conversation getConversation(
        com.google.cloud.dialogflow.v2.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified conversation. Finished conversations are purged
     * from the database after 30 days.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Conversation completeConversation(
        com.google.cloud.dialogflow.v2.CompleteConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompleteConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists messages that belong to a given conversation.
     * `messages` are ordered by `create_time` in descending order. To fetch
     * updates without duplication, send request with filter
     * `create_time_epoch_microseconds &gt;
     * [first item's create_time of previous request]` and empty page_token.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListMessagesResponse listMessages(
        com.google.cloud.dialogflow.v2.ListMessagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMessagesMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Conversations][google.cloud.dialogflow.v2.Conversation].
   * </pre>
   */
  public static final class ConversationsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConversationsFutureStub> {
    private ConversationsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversation. Conversations are auto-completed after 24
     * hours.
     * Conversation Lifecycle:
     * There are two stages during a conversation: Automated Agent Stage and
     * Assist Stage.
     * For Automated Agent Stage, there will be a dialogflow agent responding to
     * user queries.
     * For Assist Stage, there's no dialogflow agent responding to user queries.
     * But we will provide suggestions which are generated from conversation.
     * If [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile] is configured for a dialogflow
     * agent, conversation will start from `Automated Agent Stage`, otherwise, it
     * will start from `Assist Stage`. And during `Automated Agent Stage`, once an
     * [Intent][google.cloud.dialogflow.v2.Intent] with [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff] is triggered, conversation
     * will transfer to Assist Stage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Conversation>
        createConversation(com.google.cloud.dialogflow.v2.CreateConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all conversations in the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.ListConversationsResponse>
        listConversations(com.google.cloud.dialogflow.v2.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConversationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specific conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Conversation>
        getConversation(com.google.cloud.dialogflow.v2.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified conversation. Finished conversations are purged
     * from the database after 30 days.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Conversation>
        completeConversation(com.google.cloud.dialogflow.v2.CompleteConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompleteConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists messages that belong to a given conversation.
     * `messages` are ordered by `create_time` in descending order. To fetch
     * updates without duplication, send request with filter
     * `create_time_epoch_microseconds &gt;
     * [first item's create_time of previous request]` and empty page_token.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.ListMessagesResponse>
        listMessages(com.google.cloud.dialogflow.v2.ListMessagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMessagesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CONVERSATION = 0;
  private static final int METHODID_LIST_CONVERSATIONS = 1;
  private static final int METHODID_GET_CONVERSATION = 2;
  private static final int METHODID_COMPLETE_CONVERSATION = 3;
  private static final int METHODID_LIST_MESSAGES = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConversationsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConversationsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CONVERSATION:
          serviceImpl.createConversation(
              (com.google.cloud.dialogflow.v2.CreateConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Conversation>)
                  responseObserver);
          break;
        case METHODID_LIST_CONVERSATIONS:
          serviceImpl.listConversations(
              (com.google.cloud.dialogflow.v2.ListConversationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2.ListConversationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CONVERSATION:
          serviceImpl.getConversation(
              (com.google.cloud.dialogflow.v2.GetConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Conversation>)
                  responseObserver);
          break;
        case METHODID_COMPLETE_CONVERSATION:
          serviceImpl.completeConversation(
              (com.google.cloud.dialogflow.v2.CompleteConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Conversation>)
                  responseObserver);
          break;
        case METHODID_LIST_MESSAGES:
          serviceImpl.listMessages(
              (com.google.cloud.dialogflow.v2.ListMessagesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListMessagesResponse>)
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

  private abstract static class ConversationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConversationsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.ConversationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Conversations");
    }
  }

  private static final class ConversationsFileDescriptorSupplier
      extends ConversationsBaseDescriptorSupplier {
    ConversationsFileDescriptorSupplier() {}
  }

  private static final class ConversationsMethodDescriptorSupplier
      extends ConversationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConversationsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ConversationsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConversationsFileDescriptorSupplier())
                      .addMethod(getCreateConversationMethod())
                      .addMethod(getListConversationsMethod())
                      .addMethod(getGetConversationMethod())
                      .addMethod(getCompleteConversationMethod())
                      .addMethod(getListMessagesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
