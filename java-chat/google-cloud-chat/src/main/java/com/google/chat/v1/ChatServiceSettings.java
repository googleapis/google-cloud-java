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

package com.google.chat.v1;

import static com.google.chat.v1.ChatServiceClient.ListMembershipsPagedResponse;
import static com.google.chat.v1.ChatServiceClient.ListMessagesPagedResponse;
import static com.google.chat.v1.ChatServiceClient.ListReactionsPagedResponse;
import static com.google.chat.v1.ChatServiceClient.ListSpacesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.chat.v1.stub.ChatServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ChatServiceClient}.
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
 * ChatServiceSettings.Builder chatServiceSettingsBuilder = ChatServiceSettings.newBuilder();
 * chatServiceSettingsBuilder
 *     .createMessageSettings()
 *     .setRetrySettings(
 *         chatServiceSettingsBuilder
 *             .createMessageSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ChatServiceSettings chatServiceSettings = chatServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ChatServiceSettings extends ClientSettings<ChatServiceSettings> {

  /** Returns the object with the settings used for calls to createMessage. */
  public UnaryCallSettings<CreateMessageRequest, Message> createMessageSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).createMessageSettings();
  }

  /** Returns the object with the settings used for calls to listMessages. */
  public PagedCallSettings<ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
      listMessagesSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).listMessagesSettings();
  }

  /** Returns the object with the settings used for calls to listMemberships. */
  public PagedCallSettings<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      listMembershipsSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).listMembershipsSettings();
  }

  /** Returns the object with the settings used for calls to getMembership. */
  public UnaryCallSettings<GetMembershipRequest, Membership> getMembershipSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).getMembershipSettings();
  }

  /** Returns the object with the settings used for calls to getMessage. */
  public UnaryCallSettings<GetMessageRequest, Message> getMessageSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).getMessageSettings();
  }

  /** Returns the object with the settings used for calls to updateMessage. */
  public UnaryCallSettings<UpdateMessageRequest, Message> updateMessageSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).updateMessageSettings();
  }

  /** Returns the object with the settings used for calls to deleteMessage. */
  public UnaryCallSettings<DeleteMessageRequest, Empty> deleteMessageSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).deleteMessageSettings();
  }

  /** Returns the object with the settings used for calls to getAttachment. */
  public UnaryCallSettings<GetAttachmentRequest, Attachment> getAttachmentSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).getAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to uploadAttachment. */
  public UnaryCallSettings<UploadAttachmentRequest, UploadAttachmentResponse>
      uploadAttachmentSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).uploadAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to listSpaces. */
  public PagedCallSettings<ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
      listSpacesSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).listSpacesSettings();
  }

  /** Returns the object with the settings used for calls to getSpace. */
  public UnaryCallSettings<GetSpaceRequest, Space> getSpaceSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).getSpaceSettings();
  }

  /** Returns the object with the settings used for calls to createSpace. */
  public UnaryCallSettings<CreateSpaceRequest, Space> createSpaceSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).createSpaceSettings();
  }

  /** Returns the object with the settings used for calls to setUpSpace. */
  public UnaryCallSettings<SetUpSpaceRequest, Space> setUpSpaceSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).setUpSpaceSettings();
  }

  /** Returns the object with the settings used for calls to updateSpace. */
  public UnaryCallSettings<UpdateSpaceRequest, Space> updateSpaceSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).updateSpaceSettings();
  }

  /** Returns the object with the settings used for calls to deleteSpace. */
  public UnaryCallSettings<DeleteSpaceRequest, Empty> deleteSpaceSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).deleteSpaceSettings();
  }

  /** Returns the object with the settings used for calls to completeImportSpace. */
  public UnaryCallSettings<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
      completeImportSpaceSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).completeImportSpaceSettings();
  }

  /** Returns the object with the settings used for calls to findDirectMessage. */
  public UnaryCallSettings<FindDirectMessageRequest, Space> findDirectMessageSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).findDirectMessageSettings();
  }

  /** Returns the object with the settings used for calls to createMembership. */
  public UnaryCallSettings<CreateMembershipRequest, Membership> createMembershipSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).createMembershipSettings();
  }

  /** Returns the object with the settings used for calls to updateMembership. */
  public UnaryCallSettings<UpdateMembershipRequest, Membership> updateMembershipSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).updateMembershipSettings();
  }

  /** Returns the object with the settings used for calls to deleteMembership. */
  public UnaryCallSettings<DeleteMembershipRequest, Membership> deleteMembershipSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).deleteMembershipSettings();
  }

  /** Returns the object with the settings used for calls to createReaction. */
  public UnaryCallSettings<CreateReactionRequest, Reaction> createReactionSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).createReactionSettings();
  }

  /** Returns the object with the settings used for calls to listReactions. */
  public PagedCallSettings<ListReactionsRequest, ListReactionsResponse, ListReactionsPagedResponse>
      listReactionsSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).listReactionsSettings();
  }

  /** Returns the object with the settings used for calls to deleteReaction. */
  public UnaryCallSettings<DeleteReactionRequest, Empty> deleteReactionSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).deleteReactionSettings();
  }

  /** Returns the object with the settings used for calls to getSpaceReadState. */
  public UnaryCallSettings<GetSpaceReadStateRequest, SpaceReadState> getSpaceReadStateSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).getSpaceReadStateSettings();
  }

  /** Returns the object with the settings used for calls to updateSpaceReadState. */
  public UnaryCallSettings<UpdateSpaceReadStateRequest, SpaceReadState>
      updateSpaceReadStateSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).updateSpaceReadStateSettings();
  }

  /** Returns the object with the settings used for calls to getThreadReadState. */
  public UnaryCallSettings<GetThreadReadStateRequest, ThreadReadState>
      getThreadReadStateSettings() {
    return ((ChatServiceStubSettings) getStubSettings()).getThreadReadStateSettings();
  }

  public static final ChatServiceSettings create(ChatServiceStubSettings stub) throws IOException {
    return new ChatServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ChatServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ChatServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ChatServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ChatServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ChatServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ChatServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ChatServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ChatServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ChatServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ChatServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ChatServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ChatServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ChatServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ChatServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ChatServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ChatServiceStubSettings.newHttpJsonBuilder());
    }

    public ChatServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ChatServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createMessage. */
    public UnaryCallSettings.Builder<CreateMessageRequest, Message> createMessageSettings() {
      return getStubSettingsBuilder().createMessageSettings();
    }

    /** Returns the builder for the settings used for calls to listMessages. */
    public PagedCallSettings.Builder<
            ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
        listMessagesSettings() {
      return getStubSettingsBuilder().listMessagesSettings();
    }

    /** Returns the builder for the settings used for calls to listMemberships. */
    public PagedCallSettings.Builder<
            ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
        listMembershipsSettings() {
      return getStubSettingsBuilder().listMembershipsSettings();
    }

    /** Returns the builder for the settings used for calls to getMembership. */
    public UnaryCallSettings.Builder<GetMembershipRequest, Membership> getMembershipSettings() {
      return getStubSettingsBuilder().getMembershipSettings();
    }

    /** Returns the builder for the settings used for calls to getMessage. */
    public UnaryCallSettings.Builder<GetMessageRequest, Message> getMessageSettings() {
      return getStubSettingsBuilder().getMessageSettings();
    }

    /** Returns the builder for the settings used for calls to updateMessage. */
    public UnaryCallSettings.Builder<UpdateMessageRequest, Message> updateMessageSettings() {
      return getStubSettingsBuilder().updateMessageSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMessage. */
    public UnaryCallSettings.Builder<DeleteMessageRequest, Empty> deleteMessageSettings() {
      return getStubSettingsBuilder().deleteMessageSettings();
    }

    /** Returns the builder for the settings used for calls to getAttachment. */
    public UnaryCallSettings.Builder<GetAttachmentRequest, Attachment> getAttachmentSettings() {
      return getStubSettingsBuilder().getAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to uploadAttachment. */
    public UnaryCallSettings.Builder<UploadAttachmentRequest, UploadAttachmentResponse>
        uploadAttachmentSettings() {
      return getStubSettingsBuilder().uploadAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to listSpaces. */
    public PagedCallSettings.Builder<ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
        listSpacesSettings() {
      return getStubSettingsBuilder().listSpacesSettings();
    }

    /** Returns the builder for the settings used for calls to getSpace. */
    public UnaryCallSettings.Builder<GetSpaceRequest, Space> getSpaceSettings() {
      return getStubSettingsBuilder().getSpaceSettings();
    }

    /** Returns the builder for the settings used for calls to createSpace. */
    public UnaryCallSettings.Builder<CreateSpaceRequest, Space> createSpaceSettings() {
      return getStubSettingsBuilder().createSpaceSettings();
    }

    /** Returns the builder for the settings used for calls to setUpSpace. */
    public UnaryCallSettings.Builder<SetUpSpaceRequest, Space> setUpSpaceSettings() {
      return getStubSettingsBuilder().setUpSpaceSettings();
    }

    /** Returns the builder for the settings used for calls to updateSpace. */
    public UnaryCallSettings.Builder<UpdateSpaceRequest, Space> updateSpaceSettings() {
      return getStubSettingsBuilder().updateSpaceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSpace. */
    public UnaryCallSettings.Builder<DeleteSpaceRequest, Empty> deleteSpaceSettings() {
      return getStubSettingsBuilder().deleteSpaceSettings();
    }

    /** Returns the builder for the settings used for calls to completeImportSpace. */
    public UnaryCallSettings.Builder<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
        completeImportSpaceSettings() {
      return getStubSettingsBuilder().completeImportSpaceSettings();
    }

    /** Returns the builder for the settings used for calls to findDirectMessage. */
    public UnaryCallSettings.Builder<FindDirectMessageRequest, Space> findDirectMessageSettings() {
      return getStubSettingsBuilder().findDirectMessageSettings();
    }

    /** Returns the builder for the settings used for calls to createMembership. */
    public UnaryCallSettings.Builder<CreateMembershipRequest, Membership>
        createMembershipSettings() {
      return getStubSettingsBuilder().createMembershipSettings();
    }

    /** Returns the builder for the settings used for calls to updateMembership. */
    public UnaryCallSettings.Builder<UpdateMembershipRequest, Membership>
        updateMembershipSettings() {
      return getStubSettingsBuilder().updateMembershipSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMembership. */
    public UnaryCallSettings.Builder<DeleteMembershipRequest, Membership>
        deleteMembershipSettings() {
      return getStubSettingsBuilder().deleteMembershipSettings();
    }

    /** Returns the builder for the settings used for calls to createReaction. */
    public UnaryCallSettings.Builder<CreateReactionRequest, Reaction> createReactionSettings() {
      return getStubSettingsBuilder().createReactionSettings();
    }

    /** Returns the builder for the settings used for calls to listReactions. */
    public PagedCallSettings.Builder<
            ListReactionsRequest, ListReactionsResponse, ListReactionsPagedResponse>
        listReactionsSettings() {
      return getStubSettingsBuilder().listReactionsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReaction. */
    public UnaryCallSettings.Builder<DeleteReactionRequest, Empty> deleteReactionSettings() {
      return getStubSettingsBuilder().deleteReactionSettings();
    }

    /** Returns the builder for the settings used for calls to getSpaceReadState. */
    public UnaryCallSettings.Builder<GetSpaceReadStateRequest, SpaceReadState>
        getSpaceReadStateSettings() {
      return getStubSettingsBuilder().getSpaceReadStateSettings();
    }

    /** Returns the builder for the settings used for calls to updateSpaceReadState. */
    public UnaryCallSettings.Builder<UpdateSpaceReadStateRequest, SpaceReadState>
        updateSpaceReadStateSettings() {
      return getStubSettingsBuilder().updateSpaceReadStateSettings();
    }

    /** Returns the builder for the settings used for calls to getThreadReadState. */
    public UnaryCallSettings.Builder<GetThreadReadStateRequest, ThreadReadState>
        getThreadReadStateSettings() {
      return getStubSettingsBuilder().getThreadReadStateSettings();
    }

    @Override
    public ChatServiceSettings build() throws IOException {
      return new ChatServiceSettings(this);
    }
  }
}
