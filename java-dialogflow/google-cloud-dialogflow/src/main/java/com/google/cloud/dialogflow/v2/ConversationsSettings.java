/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.ConversationsClient.ListCallMatchersPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationsClient.ListConversationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationsClient.ListMessagesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dialogflow.v2.stub.ConversationsStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ConversationsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createConversation to 30 seconds:
 *
 * <pre>{@code
 * ConversationsSettings.Builder conversationsSettingsBuilder = ConversationsSettings.newBuilder();
 * conversationsSettingsBuilder
 *     .createConversationSettings()
 *     .setRetrySettings(
 *         conversationsSettingsBuilder
 *             .createConversationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConversationsSettings conversationsSettings = conversationsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ConversationsSettings extends ClientSettings<ConversationsSettings> {

  /** Returns the object with the settings used for calls to createConversation. */
  public UnaryCallSettings<CreateConversationRequest, Conversation> createConversationSettings() {
    return ((ConversationsStubSettings) getStubSettings()).createConversationSettings();
  }

  /** Returns the object with the settings used for calls to listConversations. */
  public PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings() {
    return ((ConversationsStubSettings) getStubSettings()).listConversationsSettings();
  }

  /** Returns the object with the settings used for calls to getConversation. */
  public UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings() {
    return ((ConversationsStubSettings) getStubSettings()).getConversationSettings();
  }

  /** Returns the object with the settings used for calls to completeConversation. */
  public UnaryCallSettings<CompleteConversationRequest, Conversation>
      completeConversationSettings() {
    return ((ConversationsStubSettings) getStubSettings()).completeConversationSettings();
  }

  /** Returns the object with the settings used for calls to createCallMatcher. */
  public UnaryCallSettings<CreateCallMatcherRequest, CallMatcher> createCallMatcherSettings() {
    return ((ConversationsStubSettings) getStubSettings()).createCallMatcherSettings();
  }

  /** Returns the object with the settings used for calls to listCallMatchers. */
  public PagedCallSettings<
          ListCallMatchersRequest, ListCallMatchersResponse, ListCallMatchersPagedResponse>
      listCallMatchersSettings() {
    return ((ConversationsStubSettings) getStubSettings()).listCallMatchersSettings();
  }

  /** Returns the object with the settings used for calls to deleteCallMatcher. */
  public UnaryCallSettings<DeleteCallMatcherRequest, Empty> deleteCallMatcherSettings() {
    return ((ConversationsStubSettings) getStubSettings()).deleteCallMatcherSettings();
  }

  /** Returns the object with the settings used for calls to listMessages. */
  public PagedCallSettings<ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
      listMessagesSettings() {
    return ((ConversationsStubSettings) getStubSettings()).listMessagesSettings();
  }

  public static final ConversationsSettings create(ConversationsStubSettings stub)
      throws IOException {
    return new ConversationsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ConversationsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ConversationsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ConversationsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ConversationsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ConversationsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ConversationsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConversationsStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ConversationsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ConversationsSettings. */
  public static class Builder extends ClientSettings.Builder<ConversationsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ConversationsStubSettings.newBuilder(clientContext));
    }

    protected Builder(ConversationsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ConversationsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ConversationsStubSettings.newBuilder());
    }

    public ConversationsStubSettings.Builder getStubSettingsBuilder() {
      return ((ConversationsStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createConversation. */
    public UnaryCallSettings.Builder<CreateConversationRequest, Conversation>
        createConversationSettings() {
      return getStubSettingsBuilder().createConversationSettings();
    }

    /** Returns the builder for the settings used for calls to listConversations. */
    public PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings() {
      return getStubSettingsBuilder().listConversationsSettings();
    }

    /** Returns the builder for the settings used for calls to getConversation. */
    public UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings() {
      return getStubSettingsBuilder().getConversationSettings();
    }

    /** Returns the builder for the settings used for calls to completeConversation. */
    public UnaryCallSettings.Builder<CompleteConversationRequest, Conversation>
        completeConversationSettings() {
      return getStubSettingsBuilder().completeConversationSettings();
    }

    /** Returns the builder for the settings used for calls to createCallMatcher. */
    public UnaryCallSettings.Builder<CreateCallMatcherRequest, CallMatcher>
        createCallMatcherSettings() {
      return getStubSettingsBuilder().createCallMatcherSettings();
    }

    /** Returns the builder for the settings used for calls to listCallMatchers. */
    public PagedCallSettings.Builder<
            ListCallMatchersRequest, ListCallMatchersResponse, ListCallMatchersPagedResponse>
        listCallMatchersSettings() {
      return getStubSettingsBuilder().listCallMatchersSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCallMatcher. */
    public UnaryCallSettings.Builder<DeleteCallMatcherRequest, Empty> deleteCallMatcherSettings() {
      return getStubSettingsBuilder().deleteCallMatcherSettings();
    }

    /** Returns the builder for the settings used for calls to listMessages. */
    public PagedCallSettings.Builder<
            ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
        listMessagesSettings() {
      return getStubSettingsBuilder().listMessagesSettings();
    }

    @Override
    public ConversationsSettings build() throws IOException {
      return new ConversationsSettings(this);
    }
  }
}
