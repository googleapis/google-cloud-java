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
package com.google.cloud.dialogflow.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing
 * [Conversations][google.cloud.dialogflow.v2.Conversation].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/conversation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConversationsGrpc {

  private ConversationsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dialogflow.v2.Conversations";

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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.SuggestConversationSummaryRequest,
          com.google.cloud.dialogflow.v2.SuggestConversationSummaryResponse>
      getSuggestConversationSummaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SuggestConversationSummary",
      requestType = com.google.cloud.dialogflow.v2.SuggestConversationSummaryRequest.class,
      responseType = com.google.cloud.dialogflow.v2.SuggestConversationSummaryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.SuggestConversationSummaryRequest,
          com.google.cloud.dialogflow.v2.SuggestConversationSummaryResponse>
      getSuggestConversationSummaryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.SuggestConversationSummaryRequest,
            com.google.cloud.dialogflow.v2.SuggestConversationSummaryResponse>
        getSuggestConversationSummaryMethod;
    if ((getSuggestConversationSummaryMethod =
            ConversationsGrpc.getSuggestConversationSummaryMethod)
        == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getSuggestConversationSummaryMethod =
                ConversationsGrpc.getSuggestConversationSummaryMethod)
            == null) {
          ConversationsGrpc.getSuggestConversationSummaryMethod =
              getSuggestConversationSummaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.SuggestConversationSummaryRequest,
                          com.google.cloud.dialogflow.v2.SuggestConversationSummaryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SuggestConversationSummary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.SuggestConversationSummaryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.SuggestConversationSummaryResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationsMethodDescriptorSupplier("SuggestConversationSummary"))
                      .build();
        }
      }
    }
    return getSuggestConversationSummaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GenerateStatelessSummaryRequest,
          com.google.cloud.dialogflow.v2.GenerateStatelessSummaryResponse>
      getGenerateStatelessSummaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateStatelessSummary",
      requestType = com.google.cloud.dialogflow.v2.GenerateStatelessSummaryRequest.class,
      responseType = com.google.cloud.dialogflow.v2.GenerateStatelessSummaryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GenerateStatelessSummaryRequest,
          com.google.cloud.dialogflow.v2.GenerateStatelessSummaryResponse>
      getGenerateStatelessSummaryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.GenerateStatelessSummaryRequest,
            com.google.cloud.dialogflow.v2.GenerateStatelessSummaryResponse>
        getGenerateStatelessSummaryMethod;
    if ((getGenerateStatelessSummaryMethod = ConversationsGrpc.getGenerateStatelessSummaryMethod)
        == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getGenerateStatelessSummaryMethod =
                ConversationsGrpc.getGenerateStatelessSummaryMethod)
            == null) {
          ConversationsGrpc.getGenerateStatelessSummaryMethod =
              getGenerateStatelessSummaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.GenerateStatelessSummaryRequest,
                          com.google.cloud.dialogflow.v2.GenerateStatelessSummaryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateStatelessSummary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GenerateStatelessSummaryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GenerateStatelessSummaryResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationsMethodDescriptorSupplier("GenerateStatelessSummary"))
                      .build();
        }
      }
    }
    return getGenerateStatelessSummaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.SearchKnowledgeRequest,
          com.google.cloud.dialogflow.v2.SearchKnowledgeResponse>
      getSearchKnowledgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchKnowledge",
      requestType = com.google.cloud.dialogflow.v2.SearchKnowledgeRequest.class,
      responseType = com.google.cloud.dialogflow.v2.SearchKnowledgeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.SearchKnowledgeRequest,
          com.google.cloud.dialogflow.v2.SearchKnowledgeResponse>
      getSearchKnowledgeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.SearchKnowledgeRequest,
            com.google.cloud.dialogflow.v2.SearchKnowledgeResponse>
        getSearchKnowledgeMethod;
    if ((getSearchKnowledgeMethod = ConversationsGrpc.getSearchKnowledgeMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getSearchKnowledgeMethod = ConversationsGrpc.getSearchKnowledgeMethod) == null) {
          ConversationsGrpc.getSearchKnowledgeMethod =
              getSearchKnowledgeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.SearchKnowledgeRequest,
                          com.google.cloud.dialogflow.v2.SearchKnowledgeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchKnowledge"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.SearchKnowledgeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.SearchKnowledgeResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationsMethodDescriptorSupplier("SearchKnowledge"))
                      .build();
        }
      }
    }
    return getSearchKnowledgeMethod;
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
   * Service for managing
   * [Conversations][google.cloud.dialogflow.v2.Conversation].
   * </pre>
   */
  public interface AsyncService {

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
     * If
     * [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile]
     * is configured for a dialogflow agent, conversation will start from
     * `Automated Agent Stage`, otherwise, it will start from `Assist Stage`. And
     * during `Automated Agent Stage`, once an
     * [Intent][google.cloud.dialogflow.v2.Intent] with
     * [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff]
     * is triggered, conversation will transfer to Assist Stage.
     * </pre>
     */
    default void createConversation(
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
    default void listConversations(
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
    default void getConversation(
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
    default void completeConversation(
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
    default void listMessages(
        com.google.cloud.dialogflow.v2.ListMessagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListMessagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMessagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Suggests summary for a conversation based on specific historical messages.
     * The range of the messages to be used for summary can be specified in the
     * request.
     * </pre>
     */
    default void suggestConversationSummary(
        com.google.cloud.dialogflow.v2.SuggestConversationSummaryRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.v2.SuggestConversationSummaryResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSuggestConversationSummaryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates and returns a summary for a conversation that does not have a
     * resource created for it.
     * </pre>
     */
    default void generateStatelessSummary(
        com.google.cloud.dialogflow.v2.GenerateStatelessSummaryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.GenerateStatelessSummaryResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateStatelessSummaryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get answers for the given query based on knowledge documents.
     * </pre>
     */
    default void searchKnowledge(
        com.google.cloud.dialogflow.v2.SearchKnowledgeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.SearchKnowledgeResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchKnowledgeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Conversations.
   *
   * <pre>
   * Service for managing
   * [Conversations][google.cloud.dialogflow.v2.Conversation].
   * </pre>
   */
  public abstract static class ConversationsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ConversationsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Conversations.
   *
   * <pre>
   * Service for managing
   * [Conversations][google.cloud.dialogflow.v2.Conversation].
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
     * If
     * [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile]
     * is configured for a dialogflow agent, conversation will start from
     * `Automated Agent Stage`, otherwise, it will start from `Assist Stage`. And
     * during `Automated Agent Stage`, once an
     * [Intent][google.cloud.dialogflow.v2.Intent] with
     * [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff]
     * is triggered, conversation will transfer to Assist Stage.
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

    /**
     *
     *
     * <pre>
     * Suggests summary for a conversation based on specific historical messages.
     * The range of the messages to be used for summary can be specified in the
     * request.
     * </pre>
     */
    public void suggestConversationSummary(
        com.google.cloud.dialogflow.v2.SuggestConversationSummaryRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.v2.SuggestConversationSummaryResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSuggestConversationSummaryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates and returns a summary for a conversation that does not have a
     * resource created for it.
     * </pre>
     */
    public void generateStatelessSummary(
        com.google.cloud.dialogflow.v2.GenerateStatelessSummaryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.GenerateStatelessSummaryResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateStatelessSummaryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get answers for the given query based on knowledge documents.
     * </pre>
     */
    public void searchKnowledge(
        com.google.cloud.dialogflow.v2.SearchKnowledgeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.SearchKnowledgeResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchKnowledgeMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Conversations.
   *
   * <pre>
   * Service for managing
   * [Conversations][google.cloud.dialogflow.v2.Conversation].
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
     * If
     * [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile]
     * is configured for a dialogflow agent, conversation will start from
     * `Automated Agent Stage`, otherwise, it will start from `Assist Stage`. And
     * during `Automated Agent Stage`, once an
     * [Intent][google.cloud.dialogflow.v2.Intent] with
     * [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff]
     * is triggered, conversation will transfer to Assist Stage.
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

    /**
     *
     *
     * <pre>
     * Suggests summary for a conversation based on specific historical messages.
     * The range of the messages to be used for summary can be specified in the
     * request.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.SuggestConversationSummaryResponse
        suggestConversationSummary(
            com.google.cloud.dialogflow.v2.SuggestConversationSummaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSuggestConversationSummaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates and returns a summary for a conversation that does not have a
     * resource created for it.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.GenerateStatelessSummaryResponse generateStatelessSummary(
        com.google.cloud.dialogflow.v2.GenerateStatelessSummaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateStatelessSummaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get answers for the given query based on knowledge documents.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.SearchKnowledgeResponse searchKnowledge(
        com.google.cloud.dialogflow.v2.SearchKnowledgeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchKnowledgeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Conversations.
   *
   * <pre>
   * Service for managing
   * [Conversations][google.cloud.dialogflow.v2.Conversation].
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
     * If
     * [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile]
     * is configured for a dialogflow agent, conversation will start from
     * `Automated Agent Stage`, otherwise, it will start from `Assist Stage`. And
     * during `Automated Agent Stage`, once an
     * [Intent][google.cloud.dialogflow.v2.Intent] with
     * [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff]
     * is triggered, conversation will transfer to Assist Stage.
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

    /**
     *
     *
     * <pre>
     * Suggests summary for a conversation based on specific historical messages.
     * The range of the messages to be used for summary can be specified in the
     * request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.SuggestConversationSummaryResponse>
        suggestConversationSummary(
            com.google.cloud.dialogflow.v2.SuggestConversationSummaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSuggestConversationSummaryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates and returns a summary for a conversation that does not have a
     * resource created for it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.GenerateStatelessSummaryResponse>
        generateStatelessSummary(
            com.google.cloud.dialogflow.v2.GenerateStatelessSummaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateStatelessSummaryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get answers for the given query based on knowledge documents.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.SearchKnowledgeResponse>
        searchKnowledge(com.google.cloud.dialogflow.v2.SearchKnowledgeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchKnowledgeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CONVERSATION = 0;
  private static final int METHODID_LIST_CONVERSATIONS = 1;
  private static final int METHODID_GET_CONVERSATION = 2;
  private static final int METHODID_COMPLETE_CONVERSATION = 3;
  private static final int METHODID_LIST_MESSAGES = 4;
  private static final int METHODID_SUGGEST_CONVERSATION_SUMMARY = 5;
  private static final int METHODID_GENERATE_STATELESS_SUMMARY = 6;
  private static final int METHODID_SEARCH_KNOWLEDGE = 7;

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
        case METHODID_SUGGEST_CONVERSATION_SUMMARY:
          serviceImpl.suggestConversationSummary(
              (com.google.cloud.dialogflow.v2.SuggestConversationSummaryRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2.SuggestConversationSummaryResponse>)
                  responseObserver);
          break;
        case METHODID_GENERATE_STATELESS_SUMMARY:
          serviceImpl.generateStatelessSummary(
              (com.google.cloud.dialogflow.v2.GenerateStatelessSummaryRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2.GenerateStatelessSummaryResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_KNOWLEDGE:
          serviceImpl.searchKnowledge(
              (com.google.cloud.dialogflow.v2.SearchKnowledgeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.SearchKnowledgeResponse>)
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
            getCreateConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.CreateConversationRequest,
                    com.google.cloud.dialogflow.v2.Conversation>(
                    service, METHODID_CREATE_CONVERSATION)))
        .addMethod(
            getListConversationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.ListConversationsRequest,
                    com.google.cloud.dialogflow.v2.ListConversationsResponse>(
                    service, METHODID_LIST_CONVERSATIONS)))
        .addMethod(
            getGetConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.GetConversationRequest,
                    com.google.cloud.dialogflow.v2.Conversation>(
                    service, METHODID_GET_CONVERSATION)))
        .addMethod(
            getCompleteConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.CompleteConversationRequest,
                    com.google.cloud.dialogflow.v2.Conversation>(
                    service, METHODID_COMPLETE_CONVERSATION)))
        .addMethod(
            getListMessagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.ListMessagesRequest,
                    com.google.cloud.dialogflow.v2.ListMessagesResponse>(
                    service, METHODID_LIST_MESSAGES)))
        .addMethod(
            getSuggestConversationSummaryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.SuggestConversationSummaryRequest,
                    com.google.cloud.dialogflow.v2.SuggestConversationSummaryResponse>(
                    service, METHODID_SUGGEST_CONVERSATION_SUMMARY)))
        .addMethod(
            getGenerateStatelessSummaryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.GenerateStatelessSummaryRequest,
                    com.google.cloud.dialogflow.v2.GenerateStatelessSummaryResponse>(
                    service, METHODID_GENERATE_STATELESS_SUMMARY)))
        .addMethod(
            getSearchKnowledgeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.SearchKnowledgeRequest,
                    com.google.cloud.dialogflow.v2.SearchKnowledgeResponse>(
                    service, METHODID_SEARCH_KNOWLEDGE)))
        .build();
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
    private final java.lang.String methodName;

    ConversationsMethodDescriptorSupplier(java.lang.String methodName) {
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
                      .addMethod(getSuggestConversationSummaryMethod())
                      .addMethod(getGenerateStatelessSummaryMethod())
                      .addMethod(getSearchKnowledgeMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
