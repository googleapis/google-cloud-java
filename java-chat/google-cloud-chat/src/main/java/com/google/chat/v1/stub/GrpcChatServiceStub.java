/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.chat.v1.stub;

import static com.google.chat.v1.ChatServiceClient.ListMembershipsPagedResponse;
import static com.google.chat.v1.ChatServiceClient.ListMessagesPagedResponse;
import static com.google.chat.v1.ChatServiceClient.ListReactionsPagedResponse;
import static com.google.chat.v1.ChatServiceClient.ListSpacesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.chat.v1.Attachment;
import com.google.chat.v1.CompleteImportSpaceRequest;
import com.google.chat.v1.CompleteImportSpaceResponse;
import com.google.chat.v1.CreateMembershipRequest;
import com.google.chat.v1.CreateMessageRequest;
import com.google.chat.v1.CreateReactionRequest;
import com.google.chat.v1.CreateSpaceRequest;
import com.google.chat.v1.DeleteMembershipRequest;
import com.google.chat.v1.DeleteMessageRequest;
import com.google.chat.v1.DeleteReactionRequest;
import com.google.chat.v1.DeleteSpaceRequest;
import com.google.chat.v1.FindDirectMessageRequest;
import com.google.chat.v1.GetAttachmentRequest;
import com.google.chat.v1.GetMembershipRequest;
import com.google.chat.v1.GetMessageRequest;
import com.google.chat.v1.GetSpaceReadStateRequest;
import com.google.chat.v1.GetSpaceRequest;
import com.google.chat.v1.GetThreadReadStateRequest;
import com.google.chat.v1.ListMembershipsRequest;
import com.google.chat.v1.ListMembershipsResponse;
import com.google.chat.v1.ListMessagesRequest;
import com.google.chat.v1.ListMessagesResponse;
import com.google.chat.v1.ListReactionsRequest;
import com.google.chat.v1.ListReactionsResponse;
import com.google.chat.v1.ListSpacesRequest;
import com.google.chat.v1.ListSpacesResponse;
import com.google.chat.v1.Membership;
import com.google.chat.v1.Message;
import com.google.chat.v1.Reaction;
import com.google.chat.v1.SetUpSpaceRequest;
import com.google.chat.v1.Space;
import com.google.chat.v1.SpaceReadState;
import com.google.chat.v1.ThreadReadState;
import com.google.chat.v1.UpdateMembershipRequest;
import com.google.chat.v1.UpdateMessageRequest;
import com.google.chat.v1.UpdateSpaceReadStateRequest;
import com.google.chat.v1.UpdateSpaceRequest;
import com.google.chat.v1.UploadAttachmentRequest;
import com.google.chat.v1.UploadAttachmentResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ChatService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcChatServiceStub extends ChatServiceStub {
  private static final MethodDescriptor<CreateMessageRequest, Message>
      createMessageMethodDescriptor =
          MethodDescriptor.<CreateMessageRequest, Message>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/CreateMessage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Message.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMessagesRequest, ListMessagesResponse>
      listMessagesMethodDescriptor =
          MethodDescriptor.<ListMessagesRequest, ListMessagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/ListMessages")
              .setRequestMarshaller(ProtoUtils.marshaller(ListMessagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMessagesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsMethodDescriptor =
          MethodDescriptor.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/ListMemberships")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMembershipsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMembershipsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMembershipRequest, Membership>
      getMembershipMethodDescriptor =
          MethodDescriptor.<GetMembershipRequest, Membership>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/GetMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Membership.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMessageRequest, Message> getMessageMethodDescriptor =
      MethodDescriptor.<GetMessageRequest, Message>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.chat.v1.ChatService/GetMessage")
          .setRequestMarshaller(ProtoUtils.marshaller(GetMessageRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Message.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateMessageRequest, Message>
      updateMessageMethodDescriptor =
          MethodDescriptor.<UpdateMessageRequest, Message>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/UpdateMessage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Message.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMessageRequest, Empty> deleteMessageMethodDescriptor =
      MethodDescriptor.<DeleteMessageRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.chat.v1.ChatService/DeleteMessage")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteMessageRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetAttachmentRequest, Attachment>
      getAttachmentMethodDescriptor =
          MethodDescriptor.<GetAttachmentRequest, Attachment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/GetAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Attachment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UploadAttachmentRequest, UploadAttachmentResponse>
      uploadAttachmentMethodDescriptor =
          MethodDescriptor.<UploadAttachmentRequest, UploadAttachmentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/UploadAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UploadAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UploadAttachmentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSpacesRequest, ListSpacesResponse>
      listSpacesMethodDescriptor =
          MethodDescriptor.<ListSpacesRequest, ListSpacesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/ListSpaces")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSpacesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSpacesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSpaceRequest, Space> getSpaceMethodDescriptor =
      MethodDescriptor.<GetSpaceRequest, Space>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.chat.v1.ChatService/GetSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateSpaceRequest, Space> createSpaceMethodDescriptor =
      MethodDescriptor.<CreateSpaceRequest, Space>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.chat.v1.ChatService/CreateSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetUpSpaceRequest, Space> setUpSpaceMethodDescriptor =
      MethodDescriptor.<SetUpSpaceRequest, Space>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.chat.v1.ChatService/SetUpSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(SetUpSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSpaceRequest, Space> updateSpaceMethodDescriptor =
      MethodDescriptor.<UpdateSpaceRequest, Space>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.chat.v1.ChatService/UpdateSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteSpaceRequest, Empty> deleteSpaceMethodDescriptor =
      MethodDescriptor.<DeleteSpaceRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.chat.v1.ChatService/DeleteSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
      completeImportSpaceMethodDescriptor =
          MethodDescriptor.<CompleteImportSpaceRequest, CompleteImportSpaceResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/CompleteImportSpace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CompleteImportSpaceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CompleteImportSpaceResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FindDirectMessageRequest, Space>
      findDirectMessageMethodDescriptor =
          MethodDescriptor.<FindDirectMessageRequest, Space>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/FindDirectMessage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FindDirectMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMembershipRequest, Membership>
      createMembershipMethodDescriptor =
          MethodDescriptor.<CreateMembershipRequest, Membership>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/CreateMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Membership.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateMembershipRequest, Membership>
      updateMembershipMethodDescriptor =
          MethodDescriptor.<UpdateMembershipRequest, Membership>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/UpdateMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Membership.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMembershipRequest, Membership>
      deleteMembershipMethodDescriptor =
          MethodDescriptor.<DeleteMembershipRequest, Membership>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/DeleteMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Membership.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateReactionRequest, Reaction>
      createReactionMethodDescriptor =
          MethodDescriptor.<CreateReactionRequest, Reaction>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/CreateReaction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReactionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Reaction.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListReactionsRequest, ListReactionsResponse>
      listReactionsMethodDescriptor =
          MethodDescriptor.<ListReactionsRequest, ListReactionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/ListReactions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReactionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReactionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteReactionRequest, Empty>
      deleteReactionMethodDescriptor =
          MethodDescriptor.<DeleteReactionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/DeleteReaction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteReactionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSpaceReadStateRequest, SpaceReadState>
      getSpaceReadStateMethodDescriptor =
          MethodDescriptor.<GetSpaceReadStateRequest, SpaceReadState>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/GetSpaceReadState")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSpaceReadStateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SpaceReadState.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSpaceReadStateRequest, SpaceReadState>
      updateSpaceReadStateMethodDescriptor =
          MethodDescriptor.<UpdateSpaceReadStateRequest, SpaceReadState>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/UpdateSpaceReadState")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSpaceReadStateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SpaceReadState.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetThreadReadStateRequest, ThreadReadState>
      getThreadReadStateMethodDescriptor =
          MethodDescriptor.<GetThreadReadStateRequest, ThreadReadState>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.chat.v1.ChatService/GetThreadReadState")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetThreadReadStateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ThreadReadState.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateMessageRequest, Message> createMessageCallable;
  private final UnaryCallable<ListMessagesRequest, ListMessagesResponse> listMessagesCallable;
  private final UnaryCallable<ListMessagesRequest, ListMessagesPagedResponse>
      listMessagesPagedCallable;
  private final UnaryCallable<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsCallable;
  private final UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable;
  private final UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable;
  private final UnaryCallable<GetMessageRequest, Message> getMessageCallable;
  private final UnaryCallable<UpdateMessageRequest, Message> updateMessageCallable;
  private final UnaryCallable<DeleteMessageRequest, Empty> deleteMessageCallable;
  private final UnaryCallable<GetAttachmentRequest, Attachment> getAttachmentCallable;
  private final UnaryCallable<UploadAttachmentRequest, UploadAttachmentResponse>
      uploadAttachmentCallable;
  private final UnaryCallable<ListSpacesRequest, ListSpacesResponse> listSpacesCallable;
  private final UnaryCallable<ListSpacesRequest, ListSpacesPagedResponse> listSpacesPagedCallable;
  private final UnaryCallable<GetSpaceRequest, Space> getSpaceCallable;
  private final UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable;
  private final UnaryCallable<SetUpSpaceRequest, Space> setUpSpaceCallable;
  private final UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable;
  private final UnaryCallable<DeleteSpaceRequest, Empty> deleteSpaceCallable;
  private final UnaryCallable<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
      completeImportSpaceCallable;
  private final UnaryCallable<FindDirectMessageRequest, Space> findDirectMessageCallable;
  private final UnaryCallable<CreateMembershipRequest, Membership> createMembershipCallable;
  private final UnaryCallable<UpdateMembershipRequest, Membership> updateMembershipCallable;
  private final UnaryCallable<DeleteMembershipRequest, Membership> deleteMembershipCallable;
  private final UnaryCallable<CreateReactionRequest, Reaction> createReactionCallable;
  private final UnaryCallable<ListReactionsRequest, ListReactionsResponse> listReactionsCallable;
  private final UnaryCallable<ListReactionsRequest, ListReactionsPagedResponse>
      listReactionsPagedCallable;
  private final UnaryCallable<DeleteReactionRequest, Empty> deleteReactionCallable;
  private final UnaryCallable<GetSpaceReadStateRequest, SpaceReadState> getSpaceReadStateCallable;
  private final UnaryCallable<UpdateSpaceReadStateRequest, SpaceReadState>
      updateSpaceReadStateCallable;
  private final UnaryCallable<GetThreadReadStateRequest, ThreadReadState>
      getThreadReadStateCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcChatServiceStub create(ChatServiceStubSettings settings)
      throws IOException {
    return new GrpcChatServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcChatServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcChatServiceStub(ChatServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcChatServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcChatServiceStub(
        ChatServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcChatServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcChatServiceStub(ChatServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcChatServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcChatServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcChatServiceStub(
      ChatServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateMessageRequest, Message> createMessageTransportSettings =
        GrpcCallSettings.<CreateMessageRequest, Message>newBuilder()
            .setMethodDescriptor(createMessageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListMessagesRequest, ListMessagesResponse> listMessagesTransportSettings =
        GrpcCallSettings.<ListMessagesRequest, ListMessagesResponse>newBuilder()
            .setMethodDescriptor(listMessagesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListMembershipsRequest, ListMembershipsResponse>
        listMembershipsTransportSettings =
            GrpcCallSettings.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
                .setMethodDescriptor(listMembershipsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetMembershipRequest, Membership> getMembershipTransportSettings =
        GrpcCallSettings.<GetMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(getMembershipMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetMessageRequest, Message> getMessageTransportSettings =
        GrpcCallSettings.<GetMessageRequest, Message>newBuilder()
            .setMethodDescriptor(getMessageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateMessageRequest, Message> updateMessageTransportSettings =
        GrpcCallSettings.<UpdateMessageRequest, Message>newBuilder()
            .setMethodDescriptor(updateMessageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("message.name", String.valueOf(request.getMessage().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteMessageRequest, Empty> deleteMessageTransportSettings =
        GrpcCallSettings.<DeleteMessageRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMessageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAttachmentRequest, Attachment> getAttachmentTransportSettings =
        GrpcCallSettings.<GetAttachmentRequest, Attachment>newBuilder()
            .setMethodDescriptor(getAttachmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UploadAttachmentRequest, UploadAttachmentResponse>
        uploadAttachmentTransportSettings =
            GrpcCallSettings.<UploadAttachmentRequest, UploadAttachmentResponse>newBuilder()
                .setMethodDescriptor(uploadAttachmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListSpacesRequest, ListSpacesResponse> listSpacesTransportSettings =
        GrpcCallSettings.<ListSpacesRequest, ListSpacesResponse>newBuilder()
            .setMethodDescriptor(listSpacesMethodDescriptor)
            .build();
    GrpcCallSettings<GetSpaceRequest, Space> getSpaceTransportSettings =
        GrpcCallSettings.<GetSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(getSpaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSpaceRequest, Space> createSpaceTransportSettings =
        GrpcCallSettings.<CreateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(createSpaceMethodDescriptor)
            .build();
    GrpcCallSettings<SetUpSpaceRequest, Space> setUpSpaceTransportSettings =
        GrpcCallSettings.<SetUpSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(setUpSpaceMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateSpaceRequest, Space> updateSpaceTransportSettings =
        GrpcCallSettings.<UpdateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(updateSpaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("space.name", String.valueOf(request.getSpace().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSpaceRequest, Empty> deleteSpaceTransportSettings =
        GrpcCallSettings.<DeleteSpaceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSpaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
        completeImportSpaceTransportSettings =
            GrpcCallSettings.<CompleteImportSpaceRequest, CompleteImportSpaceResponse>newBuilder()
                .setMethodDescriptor(completeImportSpaceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FindDirectMessageRequest, Space> findDirectMessageTransportSettings =
        GrpcCallSettings.<FindDirectMessageRequest, Space>newBuilder()
            .setMethodDescriptor(findDirectMessageMethodDescriptor)
            .build();
    GrpcCallSettings<CreateMembershipRequest, Membership> createMembershipTransportSettings =
        GrpcCallSettings.<CreateMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(createMembershipMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateMembershipRequest, Membership> updateMembershipTransportSettings =
        GrpcCallSettings.<UpdateMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(updateMembershipMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("membership.name", String.valueOf(request.getMembership().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteMembershipRequest, Membership> deleteMembershipTransportSettings =
        GrpcCallSettings.<DeleteMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(deleteMembershipMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateReactionRequest, Reaction> createReactionTransportSettings =
        GrpcCallSettings.<CreateReactionRequest, Reaction>newBuilder()
            .setMethodDescriptor(createReactionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListReactionsRequest, ListReactionsResponse> listReactionsTransportSettings =
        GrpcCallSettings.<ListReactionsRequest, ListReactionsResponse>newBuilder()
            .setMethodDescriptor(listReactionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteReactionRequest, Empty> deleteReactionTransportSettings =
        GrpcCallSettings.<DeleteReactionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReactionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSpaceReadStateRequest, SpaceReadState> getSpaceReadStateTransportSettings =
        GrpcCallSettings.<GetSpaceReadStateRequest, SpaceReadState>newBuilder()
            .setMethodDescriptor(getSpaceReadStateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSpaceReadStateRequest, SpaceReadState>
        updateSpaceReadStateTransportSettings =
            GrpcCallSettings.<UpdateSpaceReadStateRequest, SpaceReadState>newBuilder()
                .setMethodDescriptor(updateSpaceReadStateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "space_read_state.name",
                          String.valueOf(request.getSpaceReadState().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetThreadReadStateRequest, ThreadReadState>
        getThreadReadStateTransportSettings =
            GrpcCallSettings.<GetThreadReadStateRequest, ThreadReadState>newBuilder()
                .setMethodDescriptor(getThreadReadStateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.createMessageCallable =
        callableFactory.createUnaryCallable(
            createMessageTransportSettings, settings.createMessageSettings(), clientContext);
    this.listMessagesCallable =
        callableFactory.createUnaryCallable(
            listMessagesTransportSettings, settings.listMessagesSettings(), clientContext);
    this.listMessagesPagedCallable =
        callableFactory.createPagedCallable(
            listMessagesTransportSettings, settings.listMessagesSettings(), clientContext);
    this.listMembershipsCallable =
        callableFactory.createUnaryCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.listMembershipsPagedCallable =
        callableFactory.createPagedCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.getMembershipCallable =
        callableFactory.createUnaryCallable(
            getMembershipTransportSettings, settings.getMembershipSettings(), clientContext);
    this.getMessageCallable =
        callableFactory.createUnaryCallable(
            getMessageTransportSettings, settings.getMessageSettings(), clientContext);
    this.updateMessageCallable =
        callableFactory.createUnaryCallable(
            updateMessageTransportSettings, settings.updateMessageSettings(), clientContext);
    this.deleteMessageCallable =
        callableFactory.createUnaryCallable(
            deleteMessageTransportSettings, settings.deleteMessageSettings(), clientContext);
    this.getAttachmentCallable =
        callableFactory.createUnaryCallable(
            getAttachmentTransportSettings, settings.getAttachmentSettings(), clientContext);
    this.uploadAttachmentCallable =
        callableFactory.createUnaryCallable(
            uploadAttachmentTransportSettings, settings.uploadAttachmentSettings(), clientContext);
    this.listSpacesCallable =
        callableFactory.createUnaryCallable(
            listSpacesTransportSettings, settings.listSpacesSettings(), clientContext);
    this.listSpacesPagedCallable =
        callableFactory.createPagedCallable(
            listSpacesTransportSettings, settings.listSpacesSettings(), clientContext);
    this.getSpaceCallable =
        callableFactory.createUnaryCallable(
            getSpaceTransportSettings, settings.getSpaceSettings(), clientContext);
    this.createSpaceCallable =
        callableFactory.createUnaryCallable(
            createSpaceTransportSettings, settings.createSpaceSettings(), clientContext);
    this.setUpSpaceCallable =
        callableFactory.createUnaryCallable(
            setUpSpaceTransportSettings, settings.setUpSpaceSettings(), clientContext);
    this.updateSpaceCallable =
        callableFactory.createUnaryCallable(
            updateSpaceTransportSettings, settings.updateSpaceSettings(), clientContext);
    this.deleteSpaceCallable =
        callableFactory.createUnaryCallable(
            deleteSpaceTransportSettings, settings.deleteSpaceSettings(), clientContext);
    this.completeImportSpaceCallable =
        callableFactory.createUnaryCallable(
            completeImportSpaceTransportSettings,
            settings.completeImportSpaceSettings(),
            clientContext);
    this.findDirectMessageCallable =
        callableFactory.createUnaryCallable(
            findDirectMessageTransportSettings,
            settings.findDirectMessageSettings(),
            clientContext);
    this.createMembershipCallable =
        callableFactory.createUnaryCallable(
            createMembershipTransportSettings, settings.createMembershipSettings(), clientContext);
    this.updateMembershipCallable =
        callableFactory.createUnaryCallable(
            updateMembershipTransportSettings, settings.updateMembershipSettings(), clientContext);
    this.deleteMembershipCallable =
        callableFactory.createUnaryCallable(
            deleteMembershipTransportSettings, settings.deleteMembershipSettings(), clientContext);
    this.createReactionCallable =
        callableFactory.createUnaryCallable(
            createReactionTransportSettings, settings.createReactionSettings(), clientContext);
    this.listReactionsCallable =
        callableFactory.createUnaryCallable(
            listReactionsTransportSettings, settings.listReactionsSettings(), clientContext);
    this.listReactionsPagedCallable =
        callableFactory.createPagedCallable(
            listReactionsTransportSettings, settings.listReactionsSettings(), clientContext);
    this.deleteReactionCallable =
        callableFactory.createUnaryCallable(
            deleteReactionTransportSettings, settings.deleteReactionSettings(), clientContext);
    this.getSpaceReadStateCallable =
        callableFactory.createUnaryCallable(
            getSpaceReadStateTransportSettings,
            settings.getSpaceReadStateSettings(),
            clientContext);
    this.updateSpaceReadStateCallable =
        callableFactory.createUnaryCallable(
            updateSpaceReadStateTransportSettings,
            settings.updateSpaceReadStateSettings(),
            clientContext);
    this.getThreadReadStateCallable =
        callableFactory.createUnaryCallable(
            getThreadReadStateTransportSettings,
            settings.getThreadReadStateSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateMessageRequest, Message> createMessageCallable() {
    return createMessageCallable;
  }

  @Override
  public UnaryCallable<ListMessagesRequest, ListMessagesResponse> listMessagesCallable() {
    return listMessagesCallable;
  }

  @Override
  public UnaryCallable<ListMessagesRequest, ListMessagesPagedResponse> listMessagesPagedCallable() {
    return listMessagesPagedCallable;
  }

  @Override
  public UnaryCallable<ListMembershipsRequest, ListMembershipsResponse> listMembershipsCallable() {
    return listMembershipsCallable;
  }

  @Override
  public UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable() {
    return listMembershipsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    return getMembershipCallable;
  }

  @Override
  public UnaryCallable<GetMessageRequest, Message> getMessageCallable() {
    return getMessageCallable;
  }

  @Override
  public UnaryCallable<UpdateMessageRequest, Message> updateMessageCallable() {
    return updateMessageCallable;
  }

  @Override
  public UnaryCallable<DeleteMessageRequest, Empty> deleteMessageCallable() {
    return deleteMessageCallable;
  }

  @Override
  public UnaryCallable<GetAttachmentRequest, Attachment> getAttachmentCallable() {
    return getAttachmentCallable;
  }

  @Override
  public UnaryCallable<UploadAttachmentRequest, UploadAttachmentResponse>
      uploadAttachmentCallable() {
    return uploadAttachmentCallable;
  }

  @Override
  public UnaryCallable<ListSpacesRequest, ListSpacesResponse> listSpacesCallable() {
    return listSpacesCallable;
  }

  @Override
  public UnaryCallable<ListSpacesRequest, ListSpacesPagedResponse> listSpacesPagedCallable() {
    return listSpacesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    return getSpaceCallable;
  }

  @Override
  public UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    return createSpaceCallable;
  }

  @Override
  public UnaryCallable<SetUpSpaceRequest, Space> setUpSpaceCallable() {
    return setUpSpaceCallable;
  }

  @Override
  public UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    return updateSpaceCallable;
  }

  @Override
  public UnaryCallable<DeleteSpaceRequest, Empty> deleteSpaceCallable() {
    return deleteSpaceCallable;
  }

  @Override
  public UnaryCallable<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
      completeImportSpaceCallable() {
    return completeImportSpaceCallable;
  }

  @Override
  public UnaryCallable<FindDirectMessageRequest, Space> findDirectMessageCallable() {
    return findDirectMessageCallable;
  }

  @Override
  public UnaryCallable<CreateMembershipRequest, Membership> createMembershipCallable() {
    return createMembershipCallable;
  }

  @Override
  public UnaryCallable<UpdateMembershipRequest, Membership> updateMembershipCallable() {
    return updateMembershipCallable;
  }

  @Override
  public UnaryCallable<DeleteMembershipRequest, Membership> deleteMembershipCallable() {
    return deleteMembershipCallable;
  }

  @Override
  public UnaryCallable<CreateReactionRequest, Reaction> createReactionCallable() {
    return createReactionCallable;
  }

  @Override
  public UnaryCallable<ListReactionsRequest, ListReactionsResponse> listReactionsCallable() {
    return listReactionsCallable;
  }

  @Override
  public UnaryCallable<ListReactionsRequest, ListReactionsPagedResponse>
      listReactionsPagedCallable() {
    return listReactionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteReactionRequest, Empty> deleteReactionCallable() {
    return deleteReactionCallable;
  }

  @Override
  public UnaryCallable<GetSpaceReadStateRequest, SpaceReadState> getSpaceReadStateCallable() {
    return getSpaceReadStateCallable;
  }

  @Override
  public UnaryCallable<UpdateSpaceReadStateRequest, SpaceReadState> updateSpaceReadStateCallable() {
    return updateSpaceReadStateCallable;
  }

  @Override
  public UnaryCallable<GetThreadReadStateRequest, ThreadReadState> getThreadReadStateCallable() {
    return getThreadReadStateCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
