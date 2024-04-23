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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ChatServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (chat.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createMessage to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ChatServiceStubSettings.Builder chatServiceSettingsBuilder =
 *     ChatServiceStubSettings.newBuilder();
 * chatServiceSettingsBuilder
 *     .createMessageSettings()
 *     .setRetrySettings(
 *         chatServiceSettingsBuilder
 *             .createMessageSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ChatServiceStubSettings chatServiceSettings = chatServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ChatServiceStubSettings extends StubSettings<ChatServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/chat.bot")
          .add("https://www.googleapis.com/auth/chat.delete")
          .add("https://www.googleapis.com/auth/chat.import")
          .add("https://www.googleapis.com/auth/chat.memberships")
          .add("https://www.googleapis.com/auth/chat.memberships.app")
          .add("https://www.googleapis.com/auth/chat.memberships.readonly")
          .add("https://www.googleapis.com/auth/chat.messages")
          .add("https://www.googleapis.com/auth/chat.messages.create")
          .add("https://www.googleapis.com/auth/chat.messages.reactions")
          .add("https://www.googleapis.com/auth/chat.messages.reactions.create")
          .add("https://www.googleapis.com/auth/chat.messages.reactions.readonly")
          .add("https://www.googleapis.com/auth/chat.messages.readonly")
          .add("https://www.googleapis.com/auth/chat.spaces")
          .add("https://www.googleapis.com/auth/chat.spaces.create")
          .add("https://www.googleapis.com/auth/chat.spaces.readonly")
          .add("https://www.googleapis.com/auth/chat.users.readstate")
          .add("https://www.googleapis.com/auth/chat.users.readstate.readonly")
          .build();

  private final UnaryCallSettings<CreateMessageRequest, Message> createMessageSettings;
  private final PagedCallSettings<
          ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
      listMessagesSettings;
  private final PagedCallSettings<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      listMembershipsSettings;
  private final UnaryCallSettings<GetMembershipRequest, Membership> getMembershipSettings;
  private final UnaryCallSettings<GetMessageRequest, Message> getMessageSettings;
  private final UnaryCallSettings<UpdateMessageRequest, Message> updateMessageSettings;
  private final UnaryCallSettings<DeleteMessageRequest, Empty> deleteMessageSettings;
  private final UnaryCallSettings<GetAttachmentRequest, Attachment> getAttachmentSettings;
  private final UnaryCallSettings<UploadAttachmentRequest, UploadAttachmentResponse>
      uploadAttachmentSettings;
  private final PagedCallSettings<ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
      listSpacesSettings;
  private final UnaryCallSettings<GetSpaceRequest, Space> getSpaceSettings;
  private final UnaryCallSettings<CreateSpaceRequest, Space> createSpaceSettings;
  private final UnaryCallSettings<SetUpSpaceRequest, Space> setUpSpaceSettings;
  private final UnaryCallSettings<UpdateSpaceRequest, Space> updateSpaceSettings;
  private final UnaryCallSettings<DeleteSpaceRequest, Empty> deleteSpaceSettings;
  private final UnaryCallSettings<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
      completeImportSpaceSettings;
  private final UnaryCallSettings<FindDirectMessageRequest, Space> findDirectMessageSettings;
  private final UnaryCallSettings<CreateMembershipRequest, Membership> createMembershipSettings;
  private final UnaryCallSettings<UpdateMembershipRequest, Membership> updateMembershipSettings;
  private final UnaryCallSettings<DeleteMembershipRequest, Membership> deleteMembershipSettings;
  private final UnaryCallSettings<CreateReactionRequest, Reaction> createReactionSettings;
  private final PagedCallSettings<
          ListReactionsRequest, ListReactionsResponse, ListReactionsPagedResponse>
      listReactionsSettings;
  private final UnaryCallSettings<DeleteReactionRequest, Empty> deleteReactionSettings;
  private final UnaryCallSettings<GetSpaceReadStateRequest, SpaceReadState>
      getSpaceReadStateSettings;
  private final UnaryCallSettings<UpdateSpaceReadStateRequest, SpaceReadState>
      updateSpaceReadStateSettings;
  private final UnaryCallSettings<GetThreadReadStateRequest, ThreadReadState>
      getThreadReadStateSettings;

  private static final PagedListDescriptor<ListMessagesRequest, ListMessagesResponse, Message>
      LIST_MESSAGES_PAGE_STR_DESC =
          new PagedListDescriptor<ListMessagesRequest, ListMessagesResponse, Message>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMessagesRequest injectToken(ListMessagesRequest payload, String token) {
              return ListMessagesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMessagesRequest injectPageSize(ListMessagesRequest payload, int pageSize) {
              return ListMessagesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMessagesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMessagesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Message> extractResources(ListMessagesResponse payload) {
              return payload.getMessagesList() == null
                  ? ImmutableList.<Message>of()
                  : payload.getMessagesList();
            }
          };

  private static final PagedListDescriptor<
          ListMembershipsRequest, ListMembershipsResponse, Membership>
      LIST_MEMBERSHIPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListMembershipsRequest, ListMembershipsResponse, Membership>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMembershipsRequest injectToken(
                ListMembershipsRequest payload, String token) {
              return ListMembershipsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMembershipsRequest injectPageSize(
                ListMembershipsRequest payload, int pageSize) {
              return ListMembershipsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMembershipsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMembershipsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Membership> extractResources(ListMembershipsResponse payload) {
              return payload.getMembershipsList() == null
                  ? ImmutableList.<Membership>of()
                  : payload.getMembershipsList();
            }
          };

  private static final PagedListDescriptor<ListSpacesRequest, ListSpacesResponse, Space>
      LIST_SPACES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSpacesRequest, ListSpacesResponse, Space>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSpacesRequest injectToken(ListSpacesRequest payload, String token) {
              return ListSpacesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSpacesRequest injectPageSize(ListSpacesRequest payload, int pageSize) {
              return ListSpacesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSpacesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSpacesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Space> extractResources(ListSpacesResponse payload) {
              return payload.getSpacesList() == null
                  ? ImmutableList.<Space>of()
                  : payload.getSpacesList();
            }
          };

  private static final PagedListDescriptor<ListReactionsRequest, ListReactionsResponse, Reaction>
      LIST_REACTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListReactionsRequest, ListReactionsResponse, Reaction>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReactionsRequest injectToken(ListReactionsRequest payload, String token) {
              return ListReactionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReactionsRequest injectPageSize(ListReactionsRequest payload, int pageSize) {
              return ListReactionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReactionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReactionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Reaction> extractResources(ListReactionsResponse payload) {
              return payload.getReactionsList() == null
                  ? ImmutableList.<Reaction>of()
                  : payload.getReactionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
      LIST_MESSAGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>() {
            @Override
            public ApiFuture<ListMessagesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMessagesRequest, ListMessagesResponse> callable,
                ListMessagesRequest request,
                ApiCallContext context,
                ApiFuture<ListMessagesResponse> futureResponse) {
              PageContext<ListMessagesRequest, ListMessagesResponse, Message> pageContext =
                  PageContext.create(callable, LIST_MESSAGES_PAGE_STR_DESC, request, context);
              return ListMessagesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      LIST_MEMBERSHIPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>() {
            @Override
            public ApiFuture<ListMembershipsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMembershipsRequest, ListMembershipsResponse> callable,
                ListMembershipsRequest request,
                ApiCallContext context,
                ApiFuture<ListMembershipsResponse> futureResponse) {
              PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> pageContext =
                  PageContext.create(callable, LIST_MEMBERSHIPS_PAGE_STR_DESC, request, context);
              return ListMembershipsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
      LIST_SPACES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>() {
            @Override
            public ApiFuture<ListSpacesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSpacesRequest, ListSpacesResponse> callable,
                ListSpacesRequest request,
                ApiCallContext context,
                ApiFuture<ListSpacesResponse> futureResponse) {
              PageContext<ListSpacesRequest, ListSpacesResponse, Space> pageContext =
                  PageContext.create(callable, LIST_SPACES_PAGE_STR_DESC, request, context);
              return ListSpacesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReactionsRequest, ListReactionsResponse, ListReactionsPagedResponse>
      LIST_REACTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReactionsRequest, ListReactionsResponse, ListReactionsPagedResponse>() {
            @Override
            public ApiFuture<ListReactionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReactionsRequest, ListReactionsResponse> callable,
                ListReactionsRequest request,
                ApiCallContext context,
                ApiFuture<ListReactionsResponse> futureResponse) {
              PageContext<ListReactionsRequest, ListReactionsResponse, Reaction> pageContext =
                  PageContext.create(callable, LIST_REACTIONS_PAGE_STR_DESC, request, context);
              return ListReactionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createMessage. */
  public UnaryCallSettings<CreateMessageRequest, Message> createMessageSettings() {
    return createMessageSettings;
  }

  /** Returns the object with the settings used for calls to listMessages. */
  public PagedCallSettings<ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
      listMessagesSettings() {
    return listMessagesSettings;
  }

  /** Returns the object with the settings used for calls to listMemberships. */
  public PagedCallSettings<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      listMembershipsSettings() {
    return listMembershipsSettings;
  }

  /** Returns the object with the settings used for calls to getMembership. */
  public UnaryCallSettings<GetMembershipRequest, Membership> getMembershipSettings() {
    return getMembershipSettings;
  }

  /** Returns the object with the settings used for calls to getMessage. */
  public UnaryCallSettings<GetMessageRequest, Message> getMessageSettings() {
    return getMessageSettings;
  }

  /** Returns the object with the settings used for calls to updateMessage. */
  public UnaryCallSettings<UpdateMessageRequest, Message> updateMessageSettings() {
    return updateMessageSettings;
  }

  /** Returns the object with the settings used for calls to deleteMessage. */
  public UnaryCallSettings<DeleteMessageRequest, Empty> deleteMessageSettings() {
    return deleteMessageSettings;
  }

  /** Returns the object with the settings used for calls to getAttachment. */
  public UnaryCallSettings<GetAttachmentRequest, Attachment> getAttachmentSettings() {
    return getAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to uploadAttachment. */
  public UnaryCallSettings<UploadAttachmentRequest, UploadAttachmentResponse>
      uploadAttachmentSettings() {
    return uploadAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to listSpaces. */
  public PagedCallSettings<ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
      listSpacesSettings() {
    return listSpacesSettings;
  }

  /** Returns the object with the settings used for calls to getSpace. */
  public UnaryCallSettings<GetSpaceRequest, Space> getSpaceSettings() {
    return getSpaceSettings;
  }

  /** Returns the object with the settings used for calls to createSpace. */
  public UnaryCallSettings<CreateSpaceRequest, Space> createSpaceSettings() {
    return createSpaceSettings;
  }

  /** Returns the object with the settings used for calls to setUpSpace. */
  public UnaryCallSettings<SetUpSpaceRequest, Space> setUpSpaceSettings() {
    return setUpSpaceSettings;
  }

  /** Returns the object with the settings used for calls to updateSpace. */
  public UnaryCallSettings<UpdateSpaceRequest, Space> updateSpaceSettings() {
    return updateSpaceSettings;
  }

  /** Returns the object with the settings used for calls to deleteSpace. */
  public UnaryCallSettings<DeleteSpaceRequest, Empty> deleteSpaceSettings() {
    return deleteSpaceSettings;
  }

  /** Returns the object with the settings used for calls to completeImportSpace. */
  public UnaryCallSettings<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
      completeImportSpaceSettings() {
    return completeImportSpaceSettings;
  }

  /** Returns the object with the settings used for calls to findDirectMessage. */
  public UnaryCallSettings<FindDirectMessageRequest, Space> findDirectMessageSettings() {
    return findDirectMessageSettings;
  }

  /** Returns the object with the settings used for calls to createMembership. */
  public UnaryCallSettings<CreateMembershipRequest, Membership> createMembershipSettings() {
    return createMembershipSettings;
  }

  /** Returns the object with the settings used for calls to updateMembership. */
  public UnaryCallSettings<UpdateMembershipRequest, Membership> updateMembershipSettings() {
    return updateMembershipSettings;
  }

  /** Returns the object with the settings used for calls to deleteMembership. */
  public UnaryCallSettings<DeleteMembershipRequest, Membership> deleteMembershipSettings() {
    return deleteMembershipSettings;
  }

  /** Returns the object with the settings used for calls to createReaction. */
  public UnaryCallSettings<CreateReactionRequest, Reaction> createReactionSettings() {
    return createReactionSettings;
  }

  /** Returns the object with the settings used for calls to listReactions. */
  public PagedCallSettings<ListReactionsRequest, ListReactionsResponse, ListReactionsPagedResponse>
      listReactionsSettings() {
    return listReactionsSettings;
  }

  /** Returns the object with the settings used for calls to deleteReaction. */
  public UnaryCallSettings<DeleteReactionRequest, Empty> deleteReactionSettings() {
    return deleteReactionSettings;
  }

  /** Returns the object with the settings used for calls to getSpaceReadState. */
  public UnaryCallSettings<GetSpaceReadStateRequest, SpaceReadState> getSpaceReadStateSettings() {
    return getSpaceReadStateSettings;
  }

  /** Returns the object with the settings used for calls to updateSpaceReadState. */
  public UnaryCallSettings<UpdateSpaceReadStateRequest, SpaceReadState>
      updateSpaceReadStateSettings() {
    return updateSpaceReadStateSettings;
  }

  /** Returns the object with the settings used for calls to getThreadReadState. */
  public UnaryCallSettings<GetThreadReadStateRequest, ThreadReadState>
      getThreadReadStateSettings() {
    return getThreadReadStateSettings;
  }

  public ChatServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcChatServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonChatServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "chat";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "chat.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "chat.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ChatServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ChatServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ChatServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ChatServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createMessageSettings = settingsBuilder.createMessageSettings().build();
    listMessagesSettings = settingsBuilder.listMessagesSettings().build();
    listMembershipsSettings = settingsBuilder.listMembershipsSettings().build();
    getMembershipSettings = settingsBuilder.getMembershipSettings().build();
    getMessageSettings = settingsBuilder.getMessageSettings().build();
    updateMessageSettings = settingsBuilder.updateMessageSettings().build();
    deleteMessageSettings = settingsBuilder.deleteMessageSettings().build();
    getAttachmentSettings = settingsBuilder.getAttachmentSettings().build();
    uploadAttachmentSettings = settingsBuilder.uploadAttachmentSettings().build();
    listSpacesSettings = settingsBuilder.listSpacesSettings().build();
    getSpaceSettings = settingsBuilder.getSpaceSettings().build();
    createSpaceSettings = settingsBuilder.createSpaceSettings().build();
    setUpSpaceSettings = settingsBuilder.setUpSpaceSettings().build();
    updateSpaceSettings = settingsBuilder.updateSpaceSettings().build();
    deleteSpaceSettings = settingsBuilder.deleteSpaceSettings().build();
    completeImportSpaceSettings = settingsBuilder.completeImportSpaceSettings().build();
    findDirectMessageSettings = settingsBuilder.findDirectMessageSettings().build();
    createMembershipSettings = settingsBuilder.createMembershipSettings().build();
    updateMembershipSettings = settingsBuilder.updateMembershipSettings().build();
    deleteMembershipSettings = settingsBuilder.deleteMembershipSettings().build();
    createReactionSettings = settingsBuilder.createReactionSettings().build();
    listReactionsSettings = settingsBuilder.listReactionsSettings().build();
    deleteReactionSettings = settingsBuilder.deleteReactionSettings().build();
    getSpaceReadStateSettings = settingsBuilder.getSpaceReadStateSettings().build();
    updateSpaceReadStateSettings = settingsBuilder.updateSpaceReadStateSettings().build();
    getThreadReadStateSettings = settingsBuilder.getThreadReadStateSettings().build();
  }

  /** Builder for ChatServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ChatServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateMessageRequest, Message> createMessageSettings;
    private final PagedCallSettings.Builder<
            ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
        listMessagesSettings;
    private final PagedCallSettings.Builder<
            ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
        listMembershipsSettings;
    private final UnaryCallSettings.Builder<GetMembershipRequest, Membership> getMembershipSettings;
    private final UnaryCallSettings.Builder<GetMessageRequest, Message> getMessageSettings;
    private final UnaryCallSettings.Builder<UpdateMessageRequest, Message> updateMessageSettings;
    private final UnaryCallSettings.Builder<DeleteMessageRequest, Empty> deleteMessageSettings;
    private final UnaryCallSettings.Builder<GetAttachmentRequest, Attachment> getAttachmentSettings;
    private final UnaryCallSettings.Builder<UploadAttachmentRequest, UploadAttachmentResponse>
        uploadAttachmentSettings;
    private final PagedCallSettings.Builder<
            ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
        listSpacesSettings;
    private final UnaryCallSettings.Builder<GetSpaceRequest, Space> getSpaceSettings;
    private final UnaryCallSettings.Builder<CreateSpaceRequest, Space> createSpaceSettings;
    private final UnaryCallSettings.Builder<SetUpSpaceRequest, Space> setUpSpaceSettings;
    private final UnaryCallSettings.Builder<UpdateSpaceRequest, Space> updateSpaceSettings;
    private final UnaryCallSettings.Builder<DeleteSpaceRequest, Empty> deleteSpaceSettings;
    private final UnaryCallSettings.Builder<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
        completeImportSpaceSettings;
    private final UnaryCallSettings.Builder<FindDirectMessageRequest, Space>
        findDirectMessageSettings;
    private final UnaryCallSettings.Builder<CreateMembershipRequest, Membership>
        createMembershipSettings;
    private final UnaryCallSettings.Builder<UpdateMembershipRequest, Membership>
        updateMembershipSettings;
    private final UnaryCallSettings.Builder<DeleteMembershipRequest, Membership>
        deleteMembershipSettings;
    private final UnaryCallSettings.Builder<CreateReactionRequest, Reaction> createReactionSettings;
    private final PagedCallSettings.Builder<
            ListReactionsRequest, ListReactionsResponse, ListReactionsPagedResponse>
        listReactionsSettings;
    private final UnaryCallSettings.Builder<DeleteReactionRequest, Empty> deleteReactionSettings;
    private final UnaryCallSettings.Builder<GetSpaceReadStateRequest, SpaceReadState>
        getSpaceReadStateSettings;
    private final UnaryCallSettings.Builder<UpdateSpaceReadStateRequest, SpaceReadState>
        updateSpaceReadStateSettings;
    private final UnaryCallSettings.Builder<GetThreadReadStateRequest, ThreadReadState>
        getThreadReadStateSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createMessageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMessagesSettings = PagedCallSettings.newBuilder(LIST_MESSAGES_PAGE_STR_FACT);
      listMembershipsSettings = PagedCallSettings.newBuilder(LIST_MEMBERSHIPS_PAGE_STR_FACT);
      getMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getMessageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMessageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMessageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      uploadAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSpacesSettings = PagedCallSettings.newBuilder(LIST_SPACES_PAGE_STR_FACT);
      getSpaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSpaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setUpSpaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSpaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSpaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      completeImportSpaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      findDirectMessageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReactionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listReactionsSettings = PagedCallSettings.newBuilder(LIST_REACTIONS_PAGE_STR_FACT);
      deleteReactionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSpaceReadStateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSpaceReadStateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getThreadReadStateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createMessageSettings,
              listMessagesSettings,
              listMembershipsSettings,
              getMembershipSettings,
              getMessageSettings,
              updateMessageSettings,
              deleteMessageSettings,
              getAttachmentSettings,
              uploadAttachmentSettings,
              listSpacesSettings,
              getSpaceSettings,
              createSpaceSettings,
              setUpSpaceSettings,
              updateSpaceSettings,
              deleteSpaceSettings,
              completeImportSpaceSettings,
              findDirectMessageSettings,
              createMembershipSettings,
              updateMembershipSettings,
              deleteMembershipSettings,
              createReactionSettings,
              listReactionsSettings,
              deleteReactionSettings,
              getSpaceReadStateSettings,
              updateSpaceReadStateSettings,
              getThreadReadStateSettings);
      initDefaults(this);
    }

    protected Builder(ChatServiceStubSettings settings) {
      super(settings);

      createMessageSettings = settings.createMessageSettings.toBuilder();
      listMessagesSettings = settings.listMessagesSettings.toBuilder();
      listMembershipsSettings = settings.listMembershipsSettings.toBuilder();
      getMembershipSettings = settings.getMembershipSettings.toBuilder();
      getMessageSettings = settings.getMessageSettings.toBuilder();
      updateMessageSettings = settings.updateMessageSettings.toBuilder();
      deleteMessageSettings = settings.deleteMessageSettings.toBuilder();
      getAttachmentSettings = settings.getAttachmentSettings.toBuilder();
      uploadAttachmentSettings = settings.uploadAttachmentSettings.toBuilder();
      listSpacesSettings = settings.listSpacesSettings.toBuilder();
      getSpaceSettings = settings.getSpaceSettings.toBuilder();
      createSpaceSettings = settings.createSpaceSettings.toBuilder();
      setUpSpaceSettings = settings.setUpSpaceSettings.toBuilder();
      updateSpaceSettings = settings.updateSpaceSettings.toBuilder();
      deleteSpaceSettings = settings.deleteSpaceSettings.toBuilder();
      completeImportSpaceSettings = settings.completeImportSpaceSettings.toBuilder();
      findDirectMessageSettings = settings.findDirectMessageSettings.toBuilder();
      createMembershipSettings = settings.createMembershipSettings.toBuilder();
      updateMembershipSettings = settings.updateMembershipSettings.toBuilder();
      deleteMembershipSettings = settings.deleteMembershipSettings.toBuilder();
      createReactionSettings = settings.createReactionSettings.toBuilder();
      listReactionsSettings = settings.listReactionsSettings.toBuilder();
      deleteReactionSettings = settings.deleteReactionSettings.toBuilder();
      getSpaceReadStateSettings = settings.getSpaceReadStateSettings.toBuilder();
      updateSpaceReadStateSettings = settings.updateSpaceReadStateSettings.toBuilder();
      getThreadReadStateSettings = settings.getThreadReadStateSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createMessageSettings,
              listMessagesSettings,
              listMembershipsSettings,
              getMembershipSettings,
              getMessageSettings,
              updateMessageSettings,
              deleteMessageSettings,
              getAttachmentSettings,
              uploadAttachmentSettings,
              listSpacesSettings,
              getSpaceSettings,
              createSpaceSettings,
              setUpSpaceSettings,
              updateSpaceSettings,
              deleteSpaceSettings,
              completeImportSpaceSettings,
              findDirectMessageSettings,
              createMembershipSettings,
              updateMembershipSettings,
              deleteMembershipSettings,
              createReactionSettings,
              listReactionsSettings,
              deleteReactionSettings,
              getSpaceReadStateSettings,
              updateSpaceReadStateSettings,
              getThreadReadStateSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createMessageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMessagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMembershipsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMessageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateMessageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteMessageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .uploadAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSpacesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSpaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSpaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setUpSpaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSpaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSpaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .completeImportSpaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .findDirectMessageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createReactionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listReactionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteReactionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSpaceReadStateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSpaceReadStateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getThreadReadStateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createMessage. */
    public UnaryCallSettings.Builder<CreateMessageRequest, Message> createMessageSettings() {
      return createMessageSettings;
    }

    /** Returns the builder for the settings used for calls to listMessages. */
    public PagedCallSettings.Builder<
            ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
        listMessagesSettings() {
      return listMessagesSettings;
    }

    /** Returns the builder for the settings used for calls to listMemberships. */
    public PagedCallSettings.Builder<
            ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
        listMembershipsSettings() {
      return listMembershipsSettings;
    }

    /** Returns the builder for the settings used for calls to getMembership. */
    public UnaryCallSettings.Builder<GetMembershipRequest, Membership> getMembershipSettings() {
      return getMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to getMessage. */
    public UnaryCallSettings.Builder<GetMessageRequest, Message> getMessageSettings() {
      return getMessageSettings;
    }

    /** Returns the builder for the settings used for calls to updateMessage. */
    public UnaryCallSettings.Builder<UpdateMessageRequest, Message> updateMessageSettings() {
      return updateMessageSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMessage. */
    public UnaryCallSettings.Builder<DeleteMessageRequest, Empty> deleteMessageSettings() {
      return deleteMessageSettings;
    }

    /** Returns the builder for the settings used for calls to getAttachment. */
    public UnaryCallSettings.Builder<GetAttachmentRequest, Attachment> getAttachmentSettings() {
      return getAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to uploadAttachment. */
    public UnaryCallSettings.Builder<UploadAttachmentRequest, UploadAttachmentResponse>
        uploadAttachmentSettings() {
      return uploadAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to listSpaces. */
    public PagedCallSettings.Builder<ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
        listSpacesSettings() {
      return listSpacesSettings;
    }

    /** Returns the builder for the settings used for calls to getSpace. */
    public UnaryCallSettings.Builder<GetSpaceRequest, Space> getSpaceSettings() {
      return getSpaceSettings;
    }

    /** Returns the builder for the settings used for calls to createSpace. */
    public UnaryCallSettings.Builder<CreateSpaceRequest, Space> createSpaceSettings() {
      return createSpaceSettings;
    }

    /** Returns the builder for the settings used for calls to setUpSpace. */
    public UnaryCallSettings.Builder<SetUpSpaceRequest, Space> setUpSpaceSettings() {
      return setUpSpaceSettings;
    }

    /** Returns the builder for the settings used for calls to updateSpace. */
    public UnaryCallSettings.Builder<UpdateSpaceRequest, Space> updateSpaceSettings() {
      return updateSpaceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSpace. */
    public UnaryCallSettings.Builder<DeleteSpaceRequest, Empty> deleteSpaceSettings() {
      return deleteSpaceSettings;
    }

    /** Returns the builder for the settings used for calls to completeImportSpace. */
    public UnaryCallSettings.Builder<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
        completeImportSpaceSettings() {
      return completeImportSpaceSettings;
    }

    /** Returns the builder for the settings used for calls to findDirectMessage. */
    public UnaryCallSettings.Builder<FindDirectMessageRequest, Space> findDirectMessageSettings() {
      return findDirectMessageSettings;
    }

    /** Returns the builder for the settings used for calls to createMembership. */
    public UnaryCallSettings.Builder<CreateMembershipRequest, Membership>
        createMembershipSettings() {
      return createMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to updateMembership. */
    public UnaryCallSettings.Builder<UpdateMembershipRequest, Membership>
        updateMembershipSettings() {
      return updateMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMembership. */
    public UnaryCallSettings.Builder<DeleteMembershipRequest, Membership>
        deleteMembershipSettings() {
      return deleteMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to createReaction. */
    public UnaryCallSettings.Builder<CreateReactionRequest, Reaction> createReactionSettings() {
      return createReactionSettings;
    }

    /** Returns the builder for the settings used for calls to listReactions. */
    public PagedCallSettings.Builder<
            ListReactionsRequest, ListReactionsResponse, ListReactionsPagedResponse>
        listReactionsSettings() {
      return listReactionsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReaction. */
    public UnaryCallSettings.Builder<DeleteReactionRequest, Empty> deleteReactionSettings() {
      return deleteReactionSettings;
    }

    /** Returns the builder for the settings used for calls to getSpaceReadState. */
    public UnaryCallSettings.Builder<GetSpaceReadStateRequest, SpaceReadState>
        getSpaceReadStateSettings() {
      return getSpaceReadStateSettings;
    }

    /** Returns the builder for the settings used for calls to updateSpaceReadState. */
    public UnaryCallSettings.Builder<UpdateSpaceReadStateRequest, SpaceReadState>
        updateSpaceReadStateSettings() {
      return updateSpaceReadStateSettings;
    }

    /** Returns the builder for the settings used for calls to getThreadReadState. */
    public UnaryCallSettings.Builder<GetThreadReadStateRequest, ThreadReadState>
        getThreadReadStateSettings() {
      return getThreadReadStateSettings;
    }

    @Override
    public ChatServiceStubSettings build() throws IOException {
      return new ChatServiceStubSettings(this);
    }
  }
}
