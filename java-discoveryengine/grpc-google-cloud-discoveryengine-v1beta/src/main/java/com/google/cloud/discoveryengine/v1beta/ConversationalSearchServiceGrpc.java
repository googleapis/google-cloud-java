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
package com.google.cloud.discoveryengine.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for conversational search.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1beta/conversational_search_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConversationalSearchServiceGrpc {

  private ConversationalSearchServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1beta.ConversationalSearchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest,
          com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse>
      getConverseConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConverseConversation",
      requestType = com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest,
          com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse>
      getConverseConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest,
            com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse>
        getConverseConversationMethod;
    if ((getConverseConversationMethod =
            ConversationalSearchServiceGrpc.getConverseConversationMethod)
        == null) {
      synchronized (ConversationalSearchServiceGrpc.class) {
        if ((getConverseConversationMethod =
                ConversationalSearchServiceGrpc.getConverseConversationMethod)
            == null) {
          ConversationalSearchServiceGrpc.getConverseConversationMethod =
              getConverseConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest,
                          com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ConverseConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationalSearchServiceMethodDescriptorSupplier(
                              "ConverseConversation"))
                      .build();
        }
      }
    }
    return getConverseConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateConversationRequest,
          com.google.cloud.discoveryengine.v1beta.Conversation>
      getCreateConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConversation",
      requestType = com.google.cloud.discoveryengine.v1beta.CreateConversationRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateConversationRequest,
          com.google.cloud.discoveryengine.v1beta.Conversation>
      getCreateConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.CreateConversationRequest,
            com.google.cloud.discoveryengine.v1beta.Conversation>
        getCreateConversationMethod;
    if ((getCreateConversationMethod = ConversationalSearchServiceGrpc.getCreateConversationMethod)
        == null) {
      synchronized (ConversationalSearchServiceGrpc.class) {
        if ((getCreateConversationMethod =
                ConversationalSearchServiceGrpc.getCreateConversationMethod)
            == null) {
          ConversationalSearchServiceGrpc.getCreateConversationMethod =
              getCreateConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.CreateConversationRequest,
                          com.google.cloud.discoveryengine.v1beta.Conversation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.CreateConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Conversation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationalSearchServiceMethodDescriptorSupplier(
                              "CreateConversation"))
                      .build();
        }
      }
    }
    return getCreateConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest,
          com.google.protobuf.Empty>
      getDeleteConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConversation",
      requestType = com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest,
          com.google.protobuf.Empty>
      getDeleteConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest,
            com.google.protobuf.Empty>
        getDeleteConversationMethod;
    if ((getDeleteConversationMethod = ConversationalSearchServiceGrpc.getDeleteConversationMethod)
        == null) {
      synchronized (ConversationalSearchServiceGrpc.class) {
        if ((getDeleteConversationMethod =
                ConversationalSearchServiceGrpc.getDeleteConversationMethod)
            == null) {
          ConversationalSearchServiceGrpc.getDeleteConversationMethod =
              getDeleteConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationalSearchServiceMethodDescriptorSupplier(
                              "DeleteConversation"))
                      .build();
        }
      }
    }
    return getDeleteConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest,
          com.google.cloud.discoveryengine.v1beta.Conversation>
      getUpdateConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConversation",
      requestType = com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest,
          com.google.cloud.discoveryengine.v1beta.Conversation>
      getUpdateConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest,
            com.google.cloud.discoveryengine.v1beta.Conversation>
        getUpdateConversationMethod;
    if ((getUpdateConversationMethod = ConversationalSearchServiceGrpc.getUpdateConversationMethod)
        == null) {
      synchronized (ConversationalSearchServiceGrpc.class) {
        if ((getUpdateConversationMethod =
                ConversationalSearchServiceGrpc.getUpdateConversationMethod)
            == null) {
          ConversationalSearchServiceGrpc.getUpdateConversationMethod =
              getUpdateConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest,
                          com.google.cloud.discoveryengine.v1beta.Conversation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Conversation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationalSearchServiceMethodDescriptorSupplier(
                              "UpdateConversation"))
                      .build();
        }
      }
    }
    return getUpdateConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetConversationRequest,
          com.google.cloud.discoveryengine.v1beta.Conversation>
      getGetConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConversation",
      requestType = com.google.cloud.discoveryengine.v1beta.GetConversationRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetConversationRequest,
          com.google.cloud.discoveryengine.v1beta.Conversation>
      getGetConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.GetConversationRequest,
            com.google.cloud.discoveryengine.v1beta.Conversation>
        getGetConversationMethod;
    if ((getGetConversationMethod = ConversationalSearchServiceGrpc.getGetConversationMethod)
        == null) {
      synchronized (ConversationalSearchServiceGrpc.class) {
        if ((getGetConversationMethod = ConversationalSearchServiceGrpc.getGetConversationMethod)
            == null) {
          ConversationalSearchServiceGrpc.getGetConversationMethod =
              getGetConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.GetConversationRequest,
                          com.google.cloud.discoveryengine.v1beta.Conversation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.GetConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.Conversation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationalSearchServiceMethodDescriptorSupplier(
                              "GetConversation"))
                      .build();
        }
      }
    }
    return getGetConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListConversationsRequest,
          com.google.cloud.discoveryengine.v1beta.ListConversationsResponse>
      getListConversationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConversations",
      requestType = com.google.cloud.discoveryengine.v1beta.ListConversationsRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.ListConversationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListConversationsRequest,
          com.google.cloud.discoveryengine.v1beta.ListConversationsResponse>
      getListConversationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ListConversationsRequest,
            com.google.cloud.discoveryengine.v1beta.ListConversationsResponse>
        getListConversationsMethod;
    if ((getListConversationsMethod = ConversationalSearchServiceGrpc.getListConversationsMethod)
        == null) {
      synchronized (ConversationalSearchServiceGrpc.class) {
        if ((getListConversationsMethod =
                ConversationalSearchServiceGrpc.getListConversationsMethod)
            == null) {
          ConversationalSearchServiceGrpc.getListConversationsMethod =
              getListConversationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ListConversationsRequest,
                          com.google.cloud.discoveryengine.v1beta.ListConversationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConversations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListConversationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListConversationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationalSearchServiceMethodDescriptorSupplier(
                              "ListConversations"))
                      .build();
        }
      }
    }
    return getListConversationsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConversationalSearchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceStub>() {
          @java.lang.Override
          public ConversationalSearchServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversationalSearchServiceStub(channel, callOptions);
          }
        };
    return ConversationalSearchServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConversationalSearchServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceBlockingStub>() {
          @java.lang.Override
          public ConversationalSearchServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversationalSearchServiceBlockingStub(channel, callOptions);
          }
        };
    return ConversationalSearchServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConversationalSearchServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceFutureStub>() {
          @java.lang.Override
          public ConversationalSearchServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversationalSearchServiceFutureStub(channel, callOptions);
          }
        };
    return ConversationalSearchServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for conversational search.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Converses a conversation.
     * </pre>
     */
    default void converseConversation(
        com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getConverseConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Conversation.
     * If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to
     * create already exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    default void createConversation(
        com.google.cloud.discoveryengine.v1beta.CreateConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Conversation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Conversation.
     * If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to
     * delete does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    default void deleteConversation(
        com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Conversation.
     * [Conversation][google.cloud.discoveryengine.v1beta.Conversation] action
     * type cannot be changed. If the
     * [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to update
     * does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    default void updateConversation(
        com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Conversation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Conversation.
     * </pre>
     */
    default void getConversation(
        com.google.cloud.discoveryengine.v1beta.GetConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Conversation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Conversations by their parent
     * [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
     * </pre>
     */
    default void listConversations(
        com.google.cloud.discoveryengine.v1beta.ListConversationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.ListConversationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConversationsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ConversationalSearchService.
   *
   * <pre>
   * Service for conversational search.
   * </pre>
   */
  public abstract static class ConversationalSearchServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ConversationalSearchServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ConversationalSearchService.
   *
   * <pre>
   * Service for conversational search.
   * </pre>
   */
  public static final class ConversationalSearchServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ConversationalSearchServiceStub> {
    private ConversationalSearchServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationalSearchServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationalSearchServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Converses a conversation.
     * </pre>
     */
    public void converseConversation(
        com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getConverseConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Conversation.
     * If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to
     * create already exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public void createConversation(
        com.google.cloud.discoveryengine.v1beta.CreateConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Conversation>
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
     * Deletes a Conversation.
     * If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to
     * delete does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public void deleteConversation(
        com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Conversation.
     * [Conversation][google.cloud.discoveryengine.v1beta.Conversation] action
     * type cannot be changed. If the
     * [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to update
     * does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public void updateConversation(
        com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Conversation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Conversation.
     * </pre>
     */
    public void getConversation(
        com.google.cloud.discoveryengine.v1beta.GetConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Conversation>
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
     * Lists all Conversations by their parent
     * [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
     * </pre>
     */
    public void listConversations(
        com.google.cloud.discoveryengine.v1beta.ListConversationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.ListConversationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConversationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ConversationalSearchService.
   *
   * <pre>
   * Service for conversational search.
   * </pre>
   */
  public static final class ConversationalSearchServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConversationalSearchServiceBlockingStub> {
    private ConversationalSearchServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationalSearchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationalSearchServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Converses a conversation.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse
        converseConversation(
            com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getConverseConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Conversation.
     * If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to
     * create already exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Conversation createConversation(
        com.google.cloud.discoveryengine.v1beta.CreateConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Conversation.
     * If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to
     * delete does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConversation(
        com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Conversation.
     * [Conversation][google.cloud.discoveryengine.v1beta.Conversation] action
     * type cannot be changed. If the
     * [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to update
     * does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Conversation updateConversation(
        com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Conversation.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.Conversation getConversation(
        com.google.cloud.discoveryengine.v1beta.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Conversations by their parent
     * [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ListConversationsResponse listConversations(
        com.google.cloud.discoveryengine.v1beta.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ConversationalSearchService.
   *
   * <pre>
   * Service for conversational search.
   * </pre>
   */
  public static final class ConversationalSearchServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConversationalSearchServiceFutureStub> {
    private ConversationalSearchServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationalSearchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationalSearchServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Converses a conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse>
        converseConversation(
            com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getConverseConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Conversation.
     * If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to
     * create already exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Conversation>
        createConversation(
            com.google.cloud.discoveryengine.v1beta.CreateConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Conversation.
     * If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to
     * delete does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteConversation(
            com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Conversation.
     * [Conversation][google.cloud.discoveryengine.v1beta.Conversation] action
     * type cannot be changed. If the
     * [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to update
     * does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Conversation>
        updateConversation(
            com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.Conversation>
        getConversation(com.google.cloud.discoveryengine.v1beta.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Conversations by their parent
     * [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.ListConversationsResponse>
        listConversations(
            com.google.cloud.discoveryengine.v1beta.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConversationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONVERSE_CONVERSATION = 0;
  private static final int METHODID_CREATE_CONVERSATION = 1;
  private static final int METHODID_DELETE_CONVERSATION = 2;
  private static final int METHODID_UPDATE_CONVERSATION = 3;
  private static final int METHODID_GET_CONVERSATION = 4;
  private static final int METHODID_LIST_CONVERSATIONS = 5;

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
        case METHODID_CONVERSE_CONVERSATION:
          serviceImpl.converseConversation(
              (com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONVERSATION:
          serviceImpl.createConversation(
              (com.google.cloud.discoveryengine.v1beta.CreateConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Conversation>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONVERSATION:
          serviceImpl.deleteConversation(
              (com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_CONVERSATION:
          serviceImpl.updateConversation(
              (com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Conversation>)
                  responseObserver);
          break;
        case METHODID_GET_CONVERSATION:
          serviceImpl.getConversation(
              (com.google.cloud.discoveryengine.v1beta.GetConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.Conversation>)
                  responseObserver);
          break;
        case METHODID_LIST_CONVERSATIONS:
          serviceImpl.listConversations(
              (com.google.cloud.discoveryengine.v1beta.ListConversationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.ListConversationsResponse>)
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
            getConverseConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest,
                    com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse>(
                    service, METHODID_CONVERSE_CONVERSATION)))
        .addMethod(
            getCreateConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.CreateConversationRequest,
                    com.google.cloud.discoveryengine.v1beta.Conversation>(
                    service, METHODID_CREATE_CONVERSATION)))
        .addMethod(
            getDeleteConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CONVERSATION)))
        .addMethod(
            getUpdateConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest,
                    com.google.cloud.discoveryengine.v1beta.Conversation>(
                    service, METHODID_UPDATE_CONVERSATION)))
        .addMethod(
            getGetConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.GetConversationRequest,
                    com.google.cloud.discoveryengine.v1beta.Conversation>(
                    service, METHODID_GET_CONVERSATION)))
        .addMethod(
            getListConversationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.ListConversationsRequest,
                    com.google.cloud.discoveryengine.v1beta.ListConversationsResponse>(
                    service, METHODID_LIST_CONVERSATIONS)))
        .build();
  }

  private abstract static class ConversationalSearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConversationalSearchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1beta.ConversationalSearchServiceProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConversationalSearchService");
    }
  }

  private static final class ConversationalSearchServiceFileDescriptorSupplier
      extends ConversationalSearchServiceBaseDescriptorSupplier {
    ConversationalSearchServiceFileDescriptorSupplier() {}
  }

  private static final class ConversationalSearchServiceMethodDescriptorSupplier
      extends ConversationalSearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConversationalSearchServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ConversationalSearchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConversationalSearchServiceFileDescriptorSupplier())
                      .addMethod(getConverseConversationMethod())
                      .addMethod(getCreateConversationMethod())
                      .addMethod(getDeleteConversationMethod())
                      .addMethod(getUpdateConversationMethod())
                      .addMethod(getGetConversationMethod())
                      .addMethod(getListConversationsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
