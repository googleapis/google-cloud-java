/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListConversationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListMessagesPagedResponse;

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
import com.google.cloud.dialogflow.v2beta1.stub.ConversationsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createConversation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConversationsSettings.Builder conversationsSettingsBuilder = ConversationsSettings.newBuilder();
 * conversationsSettingsBuilder
 *     .createConversationSettings()
 *     .setRetrySettings(
 *         conversationsSettingsBuilder
 *             .createConversationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * ConversationsSettings conversationsSettings = conversationsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
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

  /** Returns the object with the settings used for calls to ingestContextReferences. */
  public UnaryCallSettings<IngestContextReferencesRequest, IngestContextReferencesResponse>
      ingestContextReferencesSettings() {
    return ((ConversationsStubSettings) getStubSettings()).ingestContextReferencesSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateMessages. */
  public UnaryCallSettings<BatchCreateMessagesRequest, BatchCreateMessagesResponse>
      batchCreateMessagesSettings() {
    return ((ConversationsStubSettings) getStubSettings()).batchCreateMessagesSettings();
  }

  /** Returns the object with the settings used for calls to listMessages. */
  public PagedCallSettings<ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
      listMessagesSettings() {
    return ((ConversationsStubSettings) getStubSettings()).listMessagesSettings();
  }

  /** Returns the object with the settings used for calls to suggestConversationSummary. */
  public UnaryCallSettings<SuggestConversationSummaryRequest, SuggestConversationSummaryResponse>
      suggestConversationSummarySettings() {
    return ((ConversationsStubSettings) getStubSettings()).suggestConversationSummarySettings();
  }

  /** Returns the object with the settings used for calls to generateStatelessSummary. */
  public UnaryCallSettings<GenerateStatelessSummaryRequest, GenerateStatelessSummaryResponse>
      generateStatelessSummarySettings() {
    return ((ConversationsStubSettings) getStubSettings()).generateStatelessSummarySettings();
  }

  /** Returns the object with the settings used for calls to generateStatelessSuggestion. */
  public UnaryCallSettings<GenerateStatelessSuggestionRequest, GenerateStatelessSuggestionResponse>
      generateStatelessSuggestionSettings() {
    return ((ConversationsStubSettings) getStubSettings()).generateStatelessSuggestionSettings();
  }

  /** Returns the object with the settings used for calls to searchKnowledge. */
  public UnaryCallSettings<SearchKnowledgeRequest, SearchKnowledgeResponse>
      searchKnowledgeSettings() {
    return ((ConversationsStubSettings) getStubSettings()).searchKnowledgeSettings();
  }

  /** Returns the object with the settings used for calls to generateSuggestions. */
  public UnaryCallSettings<GenerateSuggestionsRequest, GenerateSuggestionsResponse>
      generateSuggestionsSettings() {
    return ((ConversationsStubSettings) getStubSettings()).generateSuggestionsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ConversationsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ConversationsStubSettings) getStubSettings()).getLocationSettings();
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

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ConversationsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ConversationsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ConversationsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConversationsStubSettings.defaultApiClientHeaderProviderBuilder();
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

    private static Builder createHttpJsonDefault() {
      return new Builder(ConversationsStubSettings.newHttpJsonBuilder());
    }

    public ConversationsStubSettings.Builder getStubSettingsBuilder() {
      return ((ConversationsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to ingestContextReferences. */
    public UnaryCallSettings.Builder<
            IngestContextReferencesRequest, IngestContextReferencesResponse>
        ingestContextReferencesSettings() {
      return getStubSettingsBuilder().ingestContextReferencesSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateMessages. */
    public UnaryCallSettings.Builder<BatchCreateMessagesRequest, BatchCreateMessagesResponse>
        batchCreateMessagesSettings() {
      return getStubSettingsBuilder().batchCreateMessagesSettings();
    }

    /** Returns the builder for the settings used for calls to listMessages. */
    public PagedCallSettings.Builder<
            ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
        listMessagesSettings() {
      return getStubSettingsBuilder().listMessagesSettings();
    }

    /** Returns the builder for the settings used for calls to suggestConversationSummary. */
    public UnaryCallSettings.Builder<
            SuggestConversationSummaryRequest, SuggestConversationSummaryResponse>
        suggestConversationSummarySettings() {
      return getStubSettingsBuilder().suggestConversationSummarySettings();
    }

    /** Returns the builder for the settings used for calls to generateStatelessSummary. */
    public UnaryCallSettings.Builder<
            GenerateStatelessSummaryRequest, GenerateStatelessSummaryResponse>
        generateStatelessSummarySettings() {
      return getStubSettingsBuilder().generateStatelessSummarySettings();
    }

    /** Returns the builder for the settings used for calls to generateStatelessSuggestion. */
    public UnaryCallSettings.Builder<
            GenerateStatelessSuggestionRequest, GenerateStatelessSuggestionResponse>
        generateStatelessSuggestionSettings() {
      return getStubSettingsBuilder().generateStatelessSuggestionSettings();
    }

    /** Returns the builder for the settings used for calls to searchKnowledge. */
    public UnaryCallSettings.Builder<SearchKnowledgeRequest, SearchKnowledgeResponse>
        searchKnowledgeSettings() {
      return getStubSettingsBuilder().searchKnowledgeSettings();
    }

    /** Returns the builder for the settings used for calls to generateSuggestions. */
    public UnaryCallSettings.Builder<GenerateSuggestionsRequest, GenerateSuggestionsResponse>
        generateSuggestionsSettings() {
      return getStubSettingsBuilder().generateSuggestionsSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public ConversationsSettings build() throws IOException {
      return new ConversationsSettings(this);
    }
  }
}
