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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.ConversationsClient.ListConversationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationsClient.ListMessagesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
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
import com.google.cloud.dialogflow.v2.CompleteConversationRequest;
import com.google.cloud.dialogflow.v2.Conversation;
import com.google.cloud.dialogflow.v2.CreateConversationRequest;
import com.google.cloud.dialogflow.v2.GenerateStatelessSuggestionRequest;
import com.google.cloud.dialogflow.v2.GenerateStatelessSuggestionResponse;
import com.google.cloud.dialogflow.v2.GenerateStatelessSummaryRequest;
import com.google.cloud.dialogflow.v2.GenerateStatelessSummaryResponse;
import com.google.cloud.dialogflow.v2.GenerateSuggestionsRequest;
import com.google.cloud.dialogflow.v2.GenerateSuggestionsResponse;
import com.google.cloud.dialogflow.v2.GetConversationRequest;
import com.google.cloud.dialogflow.v2.IngestContextReferencesRequest;
import com.google.cloud.dialogflow.v2.IngestContextReferencesResponse;
import com.google.cloud.dialogflow.v2.ListConversationsRequest;
import com.google.cloud.dialogflow.v2.ListConversationsResponse;
import com.google.cloud.dialogflow.v2.ListMessagesRequest;
import com.google.cloud.dialogflow.v2.ListMessagesResponse;
import com.google.cloud.dialogflow.v2.Message;
import com.google.cloud.dialogflow.v2.SearchKnowledgeRequest;
import com.google.cloud.dialogflow.v2.SearchKnowledgeResponse;
import com.google.cloud.dialogflow.v2.SuggestConversationSummaryRequest;
import com.google.cloud.dialogflow.v2.SuggestConversationSummaryResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ConversationsStub}.
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
 * ConversationsStubSettings.Builder conversationsSettingsBuilder =
 *     ConversationsStubSettings.newBuilder();
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
 * ConversationsStubSettings conversationsSettings = conversationsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class ConversationsStubSettings extends StubSettings<ConversationsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final UnaryCallSettings<CreateConversationRequest, Conversation>
      createConversationSettings;
  private final PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings;
  private final UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings;
  private final UnaryCallSettings<CompleteConversationRequest, Conversation>
      completeConversationSettings;
  private final UnaryCallSettings<IngestContextReferencesRequest, IngestContextReferencesResponse>
      ingestContextReferencesSettings;
  private final PagedCallSettings<
          ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
      listMessagesSettings;
  private final UnaryCallSettings<
          SuggestConversationSummaryRequest, SuggestConversationSummaryResponse>
      suggestConversationSummarySettings;
  private final UnaryCallSettings<GenerateStatelessSummaryRequest, GenerateStatelessSummaryResponse>
      generateStatelessSummarySettings;
  private final UnaryCallSettings<
          GenerateStatelessSuggestionRequest, GenerateStatelessSuggestionResponse>
      generateStatelessSuggestionSettings;
  private final UnaryCallSettings<SearchKnowledgeRequest, SearchKnowledgeResponse>
      searchKnowledgeSettings;
  private final UnaryCallSettings<GenerateSuggestionsRequest, GenerateSuggestionsResponse>
      generateSuggestionsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListConversationsRequest, ListConversationsResponse, Conversation>
      LIST_CONVERSATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConversationsRequest, ListConversationsResponse, Conversation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConversationsRequest injectToken(
                ListConversationsRequest payload, String token) {
              return ListConversationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConversationsRequest injectPageSize(
                ListConversationsRequest payload, int pageSize) {
              return ListConversationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConversationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConversationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Conversation> extractResources(ListConversationsResponse payload) {
              return payload.getConversationsList();
            }
          };

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
              return payload.getMessagesList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      LIST_CONVERSATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConversationsRequest,
              ListConversationsResponse,
              ListConversationsPagedResponse>() {
            @Override
            public ApiFuture<ListConversationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConversationsRequest, ListConversationsResponse> callable,
                ListConversationsRequest request,
                ApiCallContext context,
                ApiFuture<ListConversationsResponse> futureResponse) {
              PageContext<ListConversationsRequest, ListConversationsResponse, Conversation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONVERSATIONS_PAGE_STR_DESC, request, context);
              return ListConversationsPagedResponse.createAsync(pageContext, futureResponse);
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
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createConversation. */
  public UnaryCallSettings<CreateConversationRequest, Conversation> createConversationSettings() {
    return createConversationSettings;
  }

  /** Returns the object with the settings used for calls to listConversations. */
  public PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings() {
    return listConversationsSettings;
  }

  /** Returns the object with the settings used for calls to getConversation. */
  public UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings() {
    return getConversationSettings;
  }

  /** Returns the object with the settings used for calls to completeConversation. */
  public UnaryCallSettings<CompleteConversationRequest, Conversation>
      completeConversationSettings() {
    return completeConversationSettings;
  }

  /** Returns the object with the settings used for calls to ingestContextReferences. */
  public UnaryCallSettings<IngestContextReferencesRequest, IngestContextReferencesResponse>
      ingestContextReferencesSettings() {
    return ingestContextReferencesSettings;
  }

  /** Returns the object with the settings used for calls to listMessages. */
  public PagedCallSettings<ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
      listMessagesSettings() {
    return listMessagesSettings;
  }

  /** Returns the object with the settings used for calls to suggestConversationSummary. */
  public UnaryCallSettings<SuggestConversationSummaryRequest, SuggestConversationSummaryResponse>
      suggestConversationSummarySettings() {
    return suggestConversationSummarySettings;
  }

  /** Returns the object with the settings used for calls to generateStatelessSummary. */
  public UnaryCallSettings<GenerateStatelessSummaryRequest, GenerateStatelessSummaryResponse>
      generateStatelessSummarySettings() {
    return generateStatelessSummarySettings;
  }

  /** Returns the object with the settings used for calls to generateStatelessSuggestion. */
  public UnaryCallSettings<GenerateStatelessSuggestionRequest, GenerateStatelessSuggestionResponse>
      generateStatelessSuggestionSettings() {
    return generateStatelessSuggestionSettings;
  }

  /** Returns the object with the settings used for calls to searchKnowledge. */
  public UnaryCallSettings<SearchKnowledgeRequest, SearchKnowledgeResponse>
      searchKnowledgeSettings() {
    return searchKnowledgeSettings;
  }

  /** Returns the object with the settings used for calls to generateSuggestions. */
  public UnaryCallSettings<GenerateSuggestionsRequest, GenerateSuggestionsResponse>
      generateSuggestionsSettings() {
    return generateSuggestionsSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public ConversationsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcConversationsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonConversationsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "dialogflow";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "dialogflow.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dialogflow.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ConversationsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ConversationsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConversationsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ConversationsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createConversationSettings = settingsBuilder.createConversationSettings().build();
    listConversationsSettings = settingsBuilder.listConversationsSettings().build();
    getConversationSettings = settingsBuilder.getConversationSettings().build();
    completeConversationSettings = settingsBuilder.completeConversationSettings().build();
    ingestContextReferencesSettings = settingsBuilder.ingestContextReferencesSettings().build();
    listMessagesSettings = settingsBuilder.listMessagesSettings().build();
    suggestConversationSummarySettings =
        settingsBuilder.suggestConversationSummarySettings().build();
    generateStatelessSummarySettings = settingsBuilder.generateStatelessSummarySettings().build();
    generateStatelessSuggestionSettings =
        settingsBuilder.generateStatelessSuggestionSettings().build();
    searchKnowledgeSettings = settingsBuilder.searchKnowledgeSettings().build();
    generateSuggestionsSettings = settingsBuilder.generateSuggestionsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ConversationsStubSettings. */
  public static class Builder extends StubSettings.Builder<ConversationsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateConversationRequest, Conversation>
        createConversationSettings;
    private final PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings;
    private final UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings;
    private final UnaryCallSettings.Builder<CompleteConversationRequest, Conversation>
        completeConversationSettings;
    private final UnaryCallSettings.Builder<
            IngestContextReferencesRequest, IngestContextReferencesResponse>
        ingestContextReferencesSettings;
    private final PagedCallSettings.Builder<
            ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
        listMessagesSettings;
    private final UnaryCallSettings.Builder<
            SuggestConversationSummaryRequest, SuggestConversationSummaryResponse>
        suggestConversationSummarySettings;
    private final UnaryCallSettings.Builder<
            GenerateStatelessSummaryRequest, GenerateStatelessSummaryResponse>
        generateStatelessSummarySettings;
    private final UnaryCallSettings.Builder<
            GenerateStatelessSuggestionRequest, GenerateStatelessSuggestionResponse>
        generateStatelessSuggestionSettings;
    private final UnaryCallSettings.Builder<SearchKnowledgeRequest, SearchKnowledgeResponse>
        searchKnowledgeSettings;
    private final UnaryCallSettings.Builder<GenerateSuggestionsRequest, GenerateSuggestionsResponse>
        generateSuggestionsSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
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
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConversationsSettings = PagedCallSettings.newBuilder(LIST_CONVERSATIONS_PAGE_STR_FACT);
      getConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      completeConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      ingestContextReferencesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMessagesSettings = PagedCallSettings.newBuilder(LIST_MESSAGES_PAGE_STR_FACT);
      suggestConversationSummarySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateStatelessSummarySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateStatelessSuggestionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchKnowledgeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateSuggestionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConversationSettings,
              listConversationsSettings,
              getConversationSettings,
              completeConversationSettings,
              ingestContextReferencesSettings,
              listMessagesSettings,
              suggestConversationSummarySettings,
              generateStatelessSummarySettings,
              generateStatelessSuggestionSettings,
              searchKnowledgeSettings,
              generateSuggestionsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ConversationsStubSettings settings) {
      super(settings);

      createConversationSettings = settings.createConversationSettings.toBuilder();
      listConversationsSettings = settings.listConversationsSettings.toBuilder();
      getConversationSettings = settings.getConversationSettings.toBuilder();
      completeConversationSettings = settings.completeConversationSettings.toBuilder();
      ingestContextReferencesSettings = settings.ingestContextReferencesSettings.toBuilder();
      listMessagesSettings = settings.listMessagesSettings.toBuilder();
      suggestConversationSummarySettings = settings.suggestConversationSummarySettings.toBuilder();
      generateStatelessSummarySettings = settings.generateStatelessSummarySettings.toBuilder();
      generateStatelessSuggestionSettings =
          settings.generateStatelessSuggestionSettings.toBuilder();
      searchKnowledgeSettings = settings.searchKnowledgeSettings.toBuilder();
      generateSuggestionsSettings = settings.generateSuggestionsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConversationSettings,
              listConversationsSettings,
              getConversationSettings,
              completeConversationSettings,
              ingestContextReferencesSettings,
              listMessagesSettings,
              suggestConversationSummarySettings,
              generateStatelessSummarySettings,
              generateStatelessSuggestionSettings,
              searchKnowledgeSettings,
              generateSuggestionsSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .createConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listConversationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .completeConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .ingestContextReferencesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMessagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .suggestConversationSummarySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateStatelessSummarySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateStatelessSuggestionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchKnowledgeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateSuggestionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLocationSettings()
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

    /** Returns the builder for the settings used for calls to createConversation. */
    public UnaryCallSettings.Builder<CreateConversationRequest, Conversation>
        createConversationSettings() {
      return createConversationSettings;
    }

    /** Returns the builder for the settings used for calls to listConversations. */
    public PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings() {
      return listConversationsSettings;
    }

    /** Returns the builder for the settings used for calls to getConversation. */
    public UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings() {
      return getConversationSettings;
    }

    /** Returns the builder for the settings used for calls to completeConversation. */
    public UnaryCallSettings.Builder<CompleteConversationRequest, Conversation>
        completeConversationSettings() {
      return completeConversationSettings;
    }

    /** Returns the builder for the settings used for calls to ingestContextReferences. */
    public UnaryCallSettings.Builder<
            IngestContextReferencesRequest, IngestContextReferencesResponse>
        ingestContextReferencesSettings() {
      return ingestContextReferencesSettings;
    }

    /** Returns the builder for the settings used for calls to listMessages. */
    public PagedCallSettings.Builder<
            ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
        listMessagesSettings() {
      return listMessagesSettings;
    }

    /** Returns the builder for the settings used for calls to suggestConversationSummary. */
    public UnaryCallSettings.Builder<
            SuggestConversationSummaryRequest, SuggestConversationSummaryResponse>
        suggestConversationSummarySettings() {
      return suggestConversationSummarySettings;
    }

    /** Returns the builder for the settings used for calls to generateStatelessSummary. */
    public UnaryCallSettings.Builder<
            GenerateStatelessSummaryRequest, GenerateStatelessSummaryResponse>
        generateStatelessSummarySettings() {
      return generateStatelessSummarySettings;
    }

    /** Returns the builder for the settings used for calls to generateStatelessSuggestion. */
    public UnaryCallSettings.Builder<
            GenerateStatelessSuggestionRequest, GenerateStatelessSuggestionResponse>
        generateStatelessSuggestionSettings() {
      return generateStatelessSuggestionSettings;
    }

    /** Returns the builder for the settings used for calls to searchKnowledge. */
    public UnaryCallSettings.Builder<SearchKnowledgeRequest, SearchKnowledgeResponse>
        searchKnowledgeSettings() {
      return searchKnowledgeSettings;
    }

    /** Returns the builder for the settings used for calls to generateSuggestions. */
    public UnaryCallSettings.Builder<GenerateSuggestionsRequest, GenerateSuggestionsResponse>
        generateSuggestionsSettings() {
      return generateSuggestionsSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public ConversationsStubSettings build() throws IOException {
      return new ConversationsStubSettings(this);
    }
  }
}
